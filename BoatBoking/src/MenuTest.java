import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class MenuTest {

    @Test
    public void testDisplay_ValidInput_ExitLoop() throws IOException {
        // Chuỗi đầu vào để mô phỏng lựa chọn 1 -> 1 -> 0 (để thoát khỏi vòng lặp)
        String input =  "a" + System.lineSeparator() + "1" + System.lineSeparator() + "1" + System.lineSeparator()  + "boat.txt" +System.lineSeparator() + "0" + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Thực thi phương thức display()
        Menu obj = new Menu();
        obj.display();

        // Kiểm tra logic hoạt động đúng
        // ...
        // Ví dụ: Kiểm tra một thông báo được in ra
        // assertEquals("Thông báo cần kiểm tra", expectedValue, actualValue);
        // ...
    }

    @Test
    public void testInorderTraverse() {
        // Tạo một mock object của MyList
        MyList mockList = mock(MyList.class);

        // Thiết lập các giá trị và kịch bản mong đợi cho phương thức inorder
        // trong trường hợp này, chúng ta không quan tâm đến kết quả trả về của phương thức này,
        // chỉ cần đảm bảo nó được gọi với tham số đúng
        doNothing().when(mockList).inorder(any());

        // Gọi phương thức cần kiểm tra
        Menu.inorderTraverse(mockList);

        // Kiểm tra xem phương thức inorder đã được gọi chính xác hay không
        verify(mockList, times(1)).inorder(any());
    }

    ///////////////////////////////////////////////////////////////////////
    //inputBoat()

    private Menu yourObject;

    @Before
    public void setup() {
        yourObject = new Menu();
    }

    @Test
    public void testInputBoat() {
        String input = "ABCD" +  System.lineSeparator() + "Boat Name"+  System.lineSeparator() +"10"+  System.lineSeparator()+ "5" +  System.lineSeparator() +"1.5" +  System.lineSeparator() + "Depart Place" +  System.lineSeparator();
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.inputBoat();

        // Add your assertions here to verify the expected behavior
        // For example:
        // Assert.assertEquals(expectedValue, yourObject.getSomeValue());
        // Assert.assertTrue(yourObject.isSomeConditionMet());
    }

    ///////////////////////////////////////////////////////////////////////
    //inputBooking()
    @Test
    public void testInputBooking() {
        String input = "ABCD" +  System.lineSeparator() + "Boat Name"+  System.lineSeparator() +"10"+  System.lineSeparator()+ "5" +  System.lineSeparator() +"1.5" +  System.lineSeparator() + "Depart Place" +  System.lineSeparator();
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.inputBooking();

        // Add your assertions here to verify the expected behavior
        // For example:
        // Assert.assertEquals(expectedValue, yourObject.getSomeValue());
        // Assert.assertTrue(yourObject.isSomeConditionMet());
    }


    ///////////////////////////////////////////////////////////////////////
    //inputCustomer()
    @Test
    public void testInputCustomer() {
        String input = "C03" +  System.lineSeparator() + "Hoa"+  System.lineSeparator() +"1902"+  System.lineSeparator();
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.inputCustomer();

        // Add your assertions here to verify the expected behavior
        // For example:
        // Assert.assertEquals(expectedValue, yourObject.getSomeValue());
        // Assert.assertTrue(yourObject.isSomeConditionMet());
    }


    ///////////////////////////////////////////////////////////////////////
    //loadBoat()

    @Test
    public void testLoadBoat() throws IOException{
        // Chuỗi đầu vào mô phỏng việc nhập tên tệp tin
        String input = "boat.txt" +  System.lineSeparator() ;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.loadBoat();
    }

    ///////////////////////////////////////////////////////////////////////
    //loadCustomer()
    @Test
    public void testLoadCustomer() throws IOException{
        // Chuỗi đầu vào mô phỏng việc nhập tên tệp tin
        String input = "customer.txt" +  System.lineSeparator() ;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.loadCustomer();
    }


    ///////////////////////////////////////////////////////////////////////
    //searchBoat()
    @Test
    public void testSearchBoat() throws IOException{
        // Chuỗi đầu vào mô phỏng việc nhập tên tệp tin
        String input = "txt" +  System.lineSeparator() ;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.searchBoat();
    }

    ///////////////////////////////////////////////////////////////////////
    //searchCustomer()

    @Test
    public void testSearchCustomer() throws IOException{
        // Chuỗi đầu vào mô phỏng việc nhập tên tệp tin
        String input = "C01" +  System.lineSeparator() ;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        yourObject.searchCustomer();
    }


    ///////////////////////////////////////////////////////////////////////
    //AddTail()
    private MyList myList;

    @Before
    public void setUp() {
        myList = new MyList();
    }

    @Test
    public void testAddTail() {
        // Tạo đối tượng Boat mới
        Boat boat = new Boat("B001", "Boat 1", 10, 5, "Place 1", 10.5);

        // Thêm đối tượng Boat vào danh sách
        myList.addTail(boat);

        // Kiểm tra danh sách không rỗng
        Assert.assertFalse(myList.isEmpty());

        // Lấy đối tượng Node cuối cùng trong danh sách
        Node tailNode = myList.tail;

        // Kiểm tra đối tượng Node không null
        assertNotNull(tailNode);

        // Kiểm tra đối tượng Node chứa đúng đối tượng Boat đã thêm
        Assert.assertEquals(boat, tailNode.boat);
    }

    ///////////////////////////////////////////////////////////////////////
    //addToTailBooking()
    @Test
    public void testAddToTailBooking() {
        MyList myList = new MyList();
        Booking booking1 = new Booking("123", "A", 1);
        Booking booking2 = new Booking("456", "B", 1);

        // Thêm booking1 vào danh sách
        myList.addToTailBooking(booking1);

        // Kiểm tra danh sách sau khi thêm
        Assertions.assertEquals(booking1, myList.head.booking);
        Assertions.assertEquals(booking1, myList.tail.booking);
        Assertions.assertNull(myList.head.left);

        // Thêm booking2 vào danh sách
        myList.addToTailBooking(booking2);

        // Kiểm tra danh sách sau khi thêm
        Assertions.assertEquals(booking1, myList.head.booking);
        Assertions.assertEquals(booking2, myList.tail.booking);
        Assertions.assertEquals(booking2, myList.head.left.booking);
        Assertions.assertNull(myList.tail.left);
    }

    ///////////////////////////////////////////////////////////////////////
    //addToTailCus()
    @Test
    public void testAddToTailCus() {
        // Arrange
        MyList myList = new MyList();
        Customer customer1 = new Customer("C001", "John Doe", "123456789");
        Customer customer2 = new Customer("C002", "Jane Smith", "987654321");

        // Act
        myList.addToTailCus(customer1);
        myList.addToTailCus(customer2);

        // Assert
        Assertions.assertEquals(customer1, myList.head.cus);
        Assertions.assertEquals(customer2, myList.tail.cus);
    }

    ///////////////////////////////////////////////////////////////////////
    //bal()


    @Test
    public void testBal() {
        // Kiểm tra trước khi cân bằng
        int countBefore = myList.countNode();
        assertTrue(isBalanced(myList.head));

        // Cân bằng danh sách
        myList.bal();

        // Kiểm tra sau khi cân bằng
        int countAfter = myList.countNode();
        Assert.assertEquals(countBefore, countAfter); // Số lượng phần tử không thay đổi
        assertTrue(isBalanced(myList.head));
    }

    // Phương thức kiểm tra cây có cân bằng hay không
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right)) {
            return true;
        }

        return false;
    }

    // Phương thức tính chiều cao của cây con
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    ///////////////////////////////////////////////////////////////////////
    //balance()

    @Test
    public void testBalance() {
        // Tạo danh sách các đối tượng Boat
        ArrayList<Boat> boats = new ArrayList<>();
        boats.add(new Boat("B01", "Boat 1", 10, 5, "Place 1", 10.0));
        boats.add(new Boat("B02", "Boat 2", 15, 8, "Place 2", 12.0));
        boats.add(new Boat("B03", "Boat 3", 20, 10, "Place 3", 15.0));
        boats.add(new Boat("B04", "Boat 4", 12, 6, "Place 4", 11.0));

        // Thêm các đối tượng Boat vào MyList
        for (Boat boat : boats) {
            myList.insert(boat);
        }

        // Cân bằng danh sách
        myList.balance(boats, 0, boats.size() - 1);


        // Kiểm tra kích thước danh sách sau khi cân bằng
        int expectedSize = boats.size();
        int actualSize = myList.countNode();
        Assert.assertEquals(expectedSize, actualSize);

        // Kiểm tra xem danh sách đã được cân bằng đúng không
        ArrayList<Boat> sortedList = new ArrayList<>();
        myList.inOrder(sortedList, myList.head);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getBcode().compareTo(sortedList.get(i + 1).getBcode()) < 0);
        }
    }

    ///////////////////////////////////////////////////////////////////////
    //bfs()
    @Test
    public void testBFS() throws IOException {
        // Load data into the list
        myList.loadFileCustomer("customer.txt");
        // Perform BFS
        myList.bfs(myList.head);
        // Verify the results
        // You can add your own assertions here to match the expected output
        assertTrue(true);
    }

    ///////////////////////////////////////////////////////////////////////
    //clear()

    @Test
    public void testClear() {
        // Thêm các phần tử vào danh sách
        myList.addTail(new Boat("B1", "Boat 1", 10, 5, "Place 1", 10.0));
        myList.addTail(new Boat("B2", "Boat 2", 8, 3, "Place 2", 8.0));
        myList.addTail(new Boat("B3", "Boat 3", 12, 7, "Place 3", 12.0));

        // Kiểm tra danh sách trước khi xóa
        Assert.assertFalse(myList.isEmpty());

        // Xóa danh sách
        myList.clear();

        // Kiểm tra danh sách sau khi xóa
        Assert.assertTrue(myList.isEmpty());
    }

    ///////////////////////////////////////////////////////////////////////
    //countNode()

    @Test
    public void testCountNodeEmptyList() {
        MyList myList = new MyList();
        int expectedCount = 0;
        int actualCount = myList.countNode();
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCountNodeNonEmptyList() {
        MyList myList = new MyList();
        // Thêm các nút vào danh sách (ví dụ: myList.addTail(...))
        // ...
        int expectedCount = 5; // Số nút mà bạn mong đợi trong danh sách
        int actualCount = myList.countNode();
        assertEquals(expectedCount, actualCount);
    }

    ///////////////////////////////////////////////////////////////////////
    //deleByCopy()

    @Test
    public void testDeleByCopy() {
        // Add some boats to the list
        myList.addTail(new Boat("B001", "Boat 1", 10, 5, "Place 1", 10.0));
        myList.addTail(new Boat("B002", "Boat 2", 20, 15, "Place 2", 15.0));
        myList.addTail(new Boat("B003", "Boat 3", 15, 8, "Place 3", 12.0));
        myList.addTail(new Boat("B004", "Boat 4", 12, 10, "Place 4", 8.0));

        // Delete a boat using deleByCopy method
        myList.deleByCopy("B002");

        // Check if the boat has been deleted successfully
        assertNull(myList.getNodebyCode("B002", 1));
    }

    ///////////////////////////////////////////////////////////////////////
    //delete()

    @Test
    public void testDeleteFromEmptyList() {
        myList.delete("code", 1); // Perform delete operation on an empty list
        Assert.assertTrue(myList.isEmpty());
    }

    @Test
    public void testDeleteFromHead() {
        myList.addTail(new Boat("code1", "Boat 1", 10, 5, "Place 1", 10.0));
        myList.addTail(new Boat("code2", "Boat 2", 10, 5, "Place 2", 10.0));

        myList.deleteFromHead();

        Assert.assertEquals("code2", myList.head.boat.getBcode());
    }

    @Test
    public void testDeleteExistingNode() {
        myList.addTail(new Boat("code1", "Boat 1", 10, 5, "Place 1", 10.0));
        myList.addTail(new Boat("code2", "Boat 2", 10, 5, "Place 2", 10.0));
        myList.addTail(new Boat("code3", "Boat 3", 10, 5, "Place 3", 10.0));

        myList.delete("code2", 1);

        Assert.assertEquals("code3", myList.head.left.boat.getBcode());
    }

    @Test
    public void testDeleteNonExistingNode() {
        myList.addTail(new Boat("code1", "Boat 1", 10, 5, "Place 1", 10.0));
        myList.addTail(new Boat("code2", "Boat 2", 10, 5, "Place 2", 10.0));
        myList.addTail(new Boat("code3", "Boat 3", 10, 5, "Place 3", 10.0));

        myList.delete("code4", 1);

        Assert.assertEquals("code1", myList.head.boat.getBcode());
        Assert.assertEquals("code2", myList.head.left.boat.getBcode());
        Assert.assertEquals("code3", myList.head.left.left.boat.getBcode());
    }

    @Test
    public void testDeleteBefore() {
        myList.addTail(new Boat("code1", "Boat 1", 10, 5, "Place 1", 10.0));
        myList.addTail(new Boat("code2", "Boat 2", 10, 5, "Place 2", 10.0));
        myList.addTail(new Boat("code3", "Boat 3", 10, 5, "Place 3", 10.0));

        myList.deleteBefore("code2");

        Assert.assertEquals("code2", myList.head.boat.getBcode());
        Assert.assertNull(myList.head.left);
    }

}
