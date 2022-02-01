package com.tencent.qqmail.utilities.observer;

import com.tencent.qqmail.model.mail.watcher.ConcurrentWatcherList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class ConcurrentObservable
  extends Observable
{
  private ConcurrentWatcherList<Observer> observers = new ConcurrentWatcherList(Observer.class);
  
  public void addObserver(Observer paramObserver)
  {
    this.observers.add(paramObserver);
  }
  
  public int countObservers()
  {
    return this.observers.size();
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    this.observers.remove(paramObserver);
  }
  
  public void deleteObservers()
  {
    this.observers.clear();
  }
  
  public void notifyObservers(Object paramObject)
  {
    Iterator localIterator = this.observers.iterator();
    while (localIterator.hasNext()) {
      ((Observer)localIterator.next()).update(this, paramObject);
    }
  }
  
  public void trigger(Object paramObject)
  {
    notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.observer.ConcurrentObservable
 * JD-Core Version:    0.7.0.1
 */