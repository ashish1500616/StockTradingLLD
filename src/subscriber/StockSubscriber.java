package subscriber;

import model.StockName;
import model.StockValue;

public interface StockSubscriber {
    void updateStock(StockName stockName, StockValue stockValue);
}
