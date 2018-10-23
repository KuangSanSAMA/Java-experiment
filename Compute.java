import java.util.*;
import java.util.HashMap;
public class Compute{

    public static void main(String args[]){
        Scanner c = new Scanner(System.in);
        HashMap<String,Book> books = new HashMap<String,Book>();
        for(int i = 0;i<5;i++){
        String name=c.next();
        float price = c.nextFloat();
        int count = c.nextInt();
        books.put(name,new Book(name,count,price));
        }
        float cost = getSum( books);
        System.out.println(cost);
        }
public static float getSum(HashMap<String,Book> books){
        float cost = 0;
        Collection<Book> b = books.values();
        for(Iterator it = b.iterator();it.hasNext();){
        Book book = (Book) it.next();
        cost += book.price * book.count;
        }
        return cost;
        }
        }
class Book{
        String name;
        int count;
        float price;
        Book(String name,int count,float price){
        this.name=name;
        this.count=count;
        this.price=price;
        }
}
