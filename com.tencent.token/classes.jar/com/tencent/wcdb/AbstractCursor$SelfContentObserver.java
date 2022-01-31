package com.tencent.wcdb;

import android.database.ContentObserver;
import java.lang.ref.WeakReference;

public class AbstractCursor$SelfContentObserver
  extends ContentObserver
{
  WeakReference mCursor;
  
  public AbstractCursor$SelfContentObserver(AbstractCursor paramAbstractCursor)
  {
    super(null);
    this.mCursor = new WeakReference(paramAbstractCursor);
  }
  
  public boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public void onChange(boolean paramBoolean)
  {
    AbstractCursor localAbstractCursor = (AbstractCursor)this.mCursor.get();
    if (localAbstractCursor != null) {
      localAbstractCursor.onChange(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.AbstractCursor.SelfContentObserver
 * JD-Core Version:    0.7.0.1
 */