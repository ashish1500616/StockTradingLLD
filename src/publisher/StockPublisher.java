package publisher;

import model.StockName;
import model.StockValue;
import subscriber.StockSubscriber;

public interface StockPublisher {
    void subscribe(StockSubscriber subscriber);

    void unsubscribe(StockSubscriber subscriber);

    void notifySubscriber(StockName stockName, StockValue stockValue);
}
