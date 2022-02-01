package com.tencent.qqmail.utilities;

import java.lang.ref.WeakReference;

public class QMWeakReference<T>
{
  private WeakReference<T> mOuter;
  
  public QMWeakReference(T paramT)
  {
    this.mOuter = new WeakReference(paramT);
  }
  
  public T get()
  {
    return this.mOuter.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMWeakReference
 * JD-Core Version:    0.7.0.1
 */