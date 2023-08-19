import model.Currency;
import model.StockName;
import model.StockValue;
import publisher.StockPublisher;
import publisher.StockUpdatePublisher;
import subscriber.StockSubscriber;
import subscriber.StockUpdateSubscriber;

public class Main {
    public static void main(String[] args) {
        StockPublisher BSEpublisher = new StockUpdatePublisher("BSE");
        StockPublisher NSEpublisher = new StockUpdatePublisher("NSE");
        StockSubscriber subscriber1 = new StockUpdateSubscriber("subscriber1");
        StockSubscriber subscriber2 = new StockUpdateSubscriber("subscriber2");
        StockSubscriber subscriber3 = new StockUpdateSubscriber("subscriber3");
        NSEpublisher.subscribe(subscriber1);
        NSEpublisher.subscribe(subscriber2);
        BSEpublisher.subscribe(subscriber2);
        BSEpublisher.subscribe(subscriber3);
        NSEpublisher.notifySubscriber(StockName.AMAZON, new StockValue(1, 100, Currency.USD));
        NSEpublisher.notifySubscriber(StockName.AMAZON, new StockValue(1, 100, Currency.USD));
        BSEpublisher.notifySubscriber(StockName.AMAZON, new StockValue(1, 101, Currency.USD));
        NSEpublisher.notifySubscriber(StockName.AMAZON, new StockValue(1, 100, Currency.USD));
        NSEpublisher.notifySubscriber(StockName.NASDAQ, new StockValue(1, 400, Currency.USD));
    }
}