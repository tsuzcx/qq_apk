package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import bgu;
import com.tencent.av.service.RecvMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GAudioUIObserver
  implements Observer
{
  static final String jdField_a_of_type_JavaLangString = "VideoObserver";
  Handler jdField_a_of_type_AndroidOsHandler;
  
  public GAudioUIObserver()
  {
    this.a = null;
  }
  
  public void a() {}
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt, long paramLong) {}
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, ArrayList paramArrayList) {}
  
  public void a(long paramLong, boolean paramBoolean) {}
  
  public void a(long paramLong, long[] paramArrayOfLong) {}
  
  public void a(long paramLong, long[] paramArrayOfLong, boolean paramBoolean) {}
  
  public void a(RecvMsg paramRecvMsg) {}
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("VideoObserver", 2, "OnUpdate-->Wrong notify type.Type = " + i);
      }
      return;
    case 10: 
      a();
      return;
    case 12: 
      a((RecvMsg)paramObject[1]);
      return;
    case 61: 
      a(((Long)paramObject[1]).longValue(), (long[])paramObject[2], ((Boolean)paramObject[3]).booleanValue());
      return;
    case 62: 
      c(((Long)paramObject[1]).longValue(), (long[])paramObject[2]);
      return;
    case 69: 
      a(((Long)paramObject[1]).longValue(), (long[])paramObject[2]);
      return;
    case 70: 
      b(((Long)paramObject[1]).longValue(), (long[])paramObject[2]);
      return;
    case 77: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), true);
      return;
    case 78: 
      a(((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue(), false);
      return;
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 96: 
    case 97: 
    case 98: 
      a(i, ((Long)paramObject[1]).longValue());
      return;
    case 63: 
      a((long[])paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    case 64: 
      a(((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2]);
      return;
    case 66: 
      c(((Long)paramObject[1]).longValue());
      return;
    case 67: 
      d(((Long)paramObject[1]).longValue());
      return;
    case 68: 
      a(((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 21: 
      a(((Integer)paramObject[1]).intValue());
      return;
    case 79: 
      a(((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 80: 
      b(((Long)paramObject[1]).longValue());
      return;
    case 83: 
      a(((Long)paramObject[1]).longValue());
      return;
    case 81: 
      e(((Long)paramObject[1]).longValue());
      return;
    case 82: 
      a((String)paramObject[1], (String[])paramObject[2]);
      return;
    }
    b();
  }
  
  public void a(String paramString, String[] paramArrayOfString) {}
  
  public void a(long[] paramArrayOfLong, boolean paramBoolean) {}
  
  protected void b() {}
  
  public void b(long paramLong) {}
  
  protected void b(long paramLong, long[] paramArrayOfLong) {}
  
  public void c(long paramLong) {}
  
  public void c(long paramLong, long[] paramArrayOfLong) {}
  
  protected void d(long paramLong) {}
  
  protected void e(long paramLong) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new bgu(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.app.GAudioUIObserver
 * JD-Core Version:    0.7.0.1
 */