package com.tencent.mobileqq.troop.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public abstract class UploadingTask
  extends Observable
{
  protected TroopUploadingThread a;
  
  public ArrayList a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public void a()
  {
    super.notifyObservers(null);
  }
  
  public abstract void a(Class paramClass, ArrayList paramArrayList, HashMap paramHashMap, String paramString);
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.a(paramString);
    }
  }
  
  public void a(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public void b(Observer paramObserver)
  {
    super.deleteObserver(paramObserver);
  }
  
  public void notifyObservers(Object paramObject)
  {
    super.setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.UploadingTask
 * JD-Core Version:    0.7.0.1
 */