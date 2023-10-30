package mytest.EventModel;

import java.util.ArrayList;
import java.util.List;

// 具体主题类
class TextSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String text) {
        for (Observer observer : observers) {
            observer.update(text);
        }
    }
}

