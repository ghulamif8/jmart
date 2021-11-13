package GhulamJmartAK;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Jmart here.
 *
 * @author (Ghulam)
 * @version (9/11/2021)
 */

public class Jmart
{
    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        return paginate(list, page, pageSize, product -> product.accountId == accountId);
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category) {
        return Algorithm.<Product>collect(list, prod -> prod.category == category);
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        return paginate(list, page, pageSize, product -> product.name.toLowerCase().contains(search.toLowerCase()));
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice) {
        if (minPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice);
        }
        else if (maxPrice <= 0) {
            return Algorithm.<Product>collect(list, prod -> prod.price >= minPrice);
        }
        return Algorithm.<Product>collect(list, prod -> prod.price <= maxPrice && prod.price >= minPrice);
    }

    public static void main (String[] args)
    {
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);
        System.out.println("account id" + new Account(null, null, null, -1).id);

        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);
        System.out.println("payment id" + new Payment(-1, -1, -1, null).id);

        String filepath = "D:/Praktikum OOP/jmart/src/GhulamJmartAK/randomProductList.json";
        try {
            List<Product> list = read(filepath);
            List<Product> filtered = filterByPrice(list, 13000.0, 14000.0);
            filtered.forEach(product -> System.out.println(product.price));
            List<Product> filteredByName = filterByName(list, "gtx", 1, 5);
            filteredByName.forEach(product -> System.out.println(product.name));
            List<Product> filteredById = filterByAccountId(list, 1, 0, 5);
            filteredById.forEach(product -> System.out.println(product.name));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        int iteration = 0;
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<Product> pageList = new ArrayList<>(pageSize);

        for (; iteration < list.size() && occurences < startingIdx; ++iteration) {
            if (pred.predicate(list.get(iteration))) {
                ++occurences;
            }
        }
        for (int i = iteration; i < list.size() && pageList.size() < pageSize; ++i) {
            if (pred.predicate(list.get(i))) {
                pageList.add(list.get(i));
            }
        }
        return pageList;
    }

    public static List<Product> read(String filepath) throws FileNotFoundException {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Product>>() {
        }.getType();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        List<Product> returnList = gson.fromJson(br, userListType);
        return returnList;
    }
}
