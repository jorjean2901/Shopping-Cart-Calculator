import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // จ่าย 2 ชิ้น 50 บาท
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));  // จ่าย 1 ชิ้น 15 บาท
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4 : คำนวณตามกฎ BOGO (ซื้อสินค้า 1 แถม 1)
        ArrayList<CartItem> FreeCart = new ArrayList<>();
        FreeCart.add(new CartItem("BOGO", "Donut", 30.0, 2)); // จ่าย 1 ชิ้น 30 บาท แถม 1 ชิ้น
        FreeCart.add(new CartItem("BOGO", "Green Tea", 20.0, 3)); // จ่าย 2 ชื้น 40 บาท แถม 1 ชิ้น
        double total4 = ShoppingCartCalculator.calculateTotalPrice(FreeCart);
        if (total4 == 70.0) {
            System.out.println("PASSED: Free cart total is correct (70.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Free cart total expected 70.0 but got" + total4);
            failedCount++;
        }

        // Test 5 : คำนวณตามกฎ BULK (ซื้อสินค้า 6 ชิ้นขึ้นไป รับส่วนลด 10% จากราคารวมสินค้าชนิดนั้น)
        ArrayList<CartItem> DiscountCart = new ArrayList<>();
        DiscountCart.add(new CartItem("BULK", "Sope", 40.0, 10)); //(40*10)-10% = 360 บาท
        DiscountCart.add(new CartItem("BULK", "Shampoo", 65.0,6 )); //(65*6)-10% = 351 บาท
        double total5 = ShoppingCartCalculator.calculateTotalPrice(DiscountCart);
        if (total5 == 711.0) {
            System.out.println("PASSED: Discount cart total is correct (711.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Discount cart total expected 711.0 but got " + total5);
            failedCount++;
        }

        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}