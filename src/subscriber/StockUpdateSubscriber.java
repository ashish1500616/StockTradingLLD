package subscriber;

import model.StockName;
import model.StockValue;

import java.util.HashMap;
import java.util.Map;

public class StockUpdateSubscriber implements StockSubscriber {
    private final String name;

    private Map<StockName, StockValue> stockValueMap;

    public StockUpdateSubscriber(String name) {
        this.name = name;
        this.stockValueMap = new HashMap<>();
    }

    @Override
    public void updateStock(StockName stockName, StockValue stockValue) {
        /*
         *   TODO: Handle concurrency for this function.
         *
         * */
        System.out.print(name + " " + "stockName = " + stockName + " " + "stockValue = " + stockValue.getAmount()
                + " stockCurrency = " + stockValue.getCurrency() + " stockVersion = " + stockValue.getVersionNumber() + " ");
        if (!stockValueMap.containsKey(stockName) || stockValueMap.get(stockName).getVersionNumber() < stockValue.getVersionNumber()) {
            stockValueMap.put(stockName, stockValue);
            System.out.print("-Updated");
        }
        System.out.println("");
    }
}
