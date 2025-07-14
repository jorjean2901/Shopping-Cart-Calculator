import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     1.ถ้า items เป็น null หรือ empty จะทำการ return ค่า 0.0 กลับไป
     2.คิดราคาสินค้าปกติ จะคำนวณราคาตามปกติ ex.ซื้อ Bread 2 ชิ้น ชิ้นละ 25 บาท เป็น 50 บาท ซื้อ Milk 1 กล่อง 15 บาท 
     ราคาที่ต้องจ่ายทั้งหมด 65 บาท ไม่มีส่วนลดอะไร
     3.คิดราคาตาม Promotion "BOGO" 1 แถม 1 ex. ซื้อ Donut 2 ชิ้น ชิ้นละ 30 บาท เป็นเงิน 60 บาท แต่จ่ายแค่ 1 ชิ้น 30 บาท
     Green Tea 3 ชิ้น ชิ้นละ 20 บาท เป็นเงิน 60 บาท แต่จ่ายแค่ 2 ชิ้น 40 บาท 
     ราคาที่ต้องจ่ายทั้งหมด 30 + 40 = 70  บาท โดยหักส่วนลด 1 แถม 1 แล้วเรียบร้อย
     4.คิดราคาตาม Promotion "BLUK" ซื้อสินค้า 6 ชิ้นขึ้นไป รับส่วนลด 10% จากราคารวมสินค้าชนิดนั้น
     ex.ซื้อ Sope 10 ชิ้น ราคาชิ้นละ 40 บาท ราคารวม 400 บาท หักส่วนลด 10% (40*10)-10% = 360 บาท
     ราคาที่ต้องจ่ายทั้งหมด 360 บาท
     * @param items รายการสินค้าที่อยู่ในตะกร้า ({ArrayList<CartItem>}) โดยแต่ละ {CartItem} มีคุณสมบัติดังนี้
                    - price ราคาของสินค้า (ต้องไม่ติดลบหรือเท่ากับ 0) 
                    - quantity จำนวนสินค้าที่ต้องการ (ต้องไม่ติดลบ) 
                    - sku ประเภทโปรสินค้า ได้แก่ "BULK","BOGO","NORMAL" 
                    - name ชื่อสินค้าต้อง (ห้ามเป็นค่าว่าง)
     * @return ยอดรวมราคาทั้งหมดหลังคิดส่วนลด ถ้า input ไม่ถูกต้อง จะ return 0.0
     
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
         double total = 0 ;
        if (items == null || items.isEmpty()) {
           return 0.0; 
        }    
        for (CartItem item : items) {

            if (item.sku().equalsIgnoreCase("BULK")) {
                if (item.quantity()>=6) {
                    total +=(item.price()*item.quantity())-(item.price()*item.quantity()*10.0/100.0);
                }else total +=item.price()*item.quantity(); 
            } 
            else if (item.sku().equalsIgnoreCase("BOGO")) {
                total += item.price()*(Math.ceil(item.quantity()/2.0));
            } 
            else {total +=item.price()*item.quantity();
            } 
        }
        return total;
    }
}
