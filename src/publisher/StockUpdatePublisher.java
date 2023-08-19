package publisher;

import model.StockName;
import model.StockValue;
import subscriber.StockSubscriber;

import java.util.ArrayList;
import java.util.List;

public class StockUpdatePublisher implements StockPublisher {

    private final String name;
    private List<StockSubscriber> stockSubscriberList;

    public StockUpdatePublisher(String name) {
        this.name = name;
        this.stockSubscriberList = new ArrayList<>();
    }

    @Override
    public void subscribe(StockSubscriber subscriber) {
        this.stockSubscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(StockSubscriber subscriber) {
        this.stockSubscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscriber(StockName stockName, StockValue stockValue) {
        for (StockSubscriber subscriber : stockSubscriberList) {
            subscriber.updateStock(stockName, stockValue);
        }
    }
}
