package com.tencent.av.gaudio;

import android.os.Handler;
import android.os.Looper;
import bhp;
import java.util.Observable;
import java.util.Observer;

public class GAudioObserver
  implements Observer
{
  public static final String a = "GAudioObserver";
  Handler a = null;
  
  public void a(int paramInt, String paramString1, String paramString2) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    switch (((Integer)paramObject[0]).intValue())
    {
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    default: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 21: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 22: 
      b(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 23: 
      c(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
      return;
    case 28: 
      a(((Integer)paramObject[1]).intValue(), (String)paramObject[2], (String)paramObject[3]);
      return;
    }
    a((String)paramObject[2], (String)paramObject[3]);
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(long paramLong1, long paramLong2) {}
  
  public void c(long paramLong1, long paramLong2) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new bhp(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GAudioObserver
 * JD-Core Version:    0.7.0.1
 */