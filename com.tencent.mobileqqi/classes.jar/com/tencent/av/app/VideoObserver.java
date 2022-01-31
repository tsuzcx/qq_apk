package com.tencent.av.app;

import android.os.Handler;
import android.os.Looper;
import bhd;
import com.tencent.av.service.RecvMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.international.LocaleString;
import java.util.Observable;
import java.util.Observer;

public class VideoObserver
  implements Observer
{
  static final String jdField_a_of_type_JavaLangString = "VideoObserver";
  Handler jdField_a_of_type_AndroidOsHandler;
  
  public VideoObserver()
  {
    this.a = null;
  }
  
  protected void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(RecvMsg paramRecvMsg) {}
  
  public void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    switch (((Integer)paramObject[0]).intValue())
    {
    default: 
      return;
    case 32: 
      a();
      return;
    case 10: 
      b();
      return;
    case 11: 
      c();
      return;
    case 12: 
      a((RecvMsg)paramObject[1]);
      return;
    case 13: 
      d();
      return;
    case 14: 
      a(((Integer)paramObject[1]).intValue());
      return;
    case 15: 
      e();
      return;
    case 16: 
      f();
      return;
    case 17: 
      g();
      return;
    case 18: 
      h();
      return;
    case 19: 
      a((String)paramObject[1]);
      return;
    case 20: 
      i();
      return;
    case 21: 
      b(((Integer)paramObject[1]).intValue());
      return;
    case 22: 
      a(true, ((Boolean)paramObject[1]).booleanValue());
      return;
    case 23: 
      a(false, ((Boolean)paramObject[1]).booleanValue());
      return;
    case 24: 
      a(((Boolean)paramObject[1]).booleanValue());
      return;
    case 25: 
      b(((Boolean)paramObject[1]).booleanValue());
      return;
    case 26: 
      b((String)paramObject[1]);
      return;
    case 27: 
      c((String)paramObject[1]);
      return;
    case 28: 
      a((String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
      return;
    case 29: 
      j();
      return;
    case 30: 
      d((String)paramObject[1]);
      return;
    }
    int i = ((Integer)paramObject[1]).intValue();
    paramObject = (String)paramObject[2];
    a(i, LocaleString.c(BaseApplicationImpl.getContext(), paramObject));
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(String paramString) {}
  
  public void d() {}
  
  public void d(String paramString) {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public void j() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      if (this.a == null) {
        this.a = new Handler(paramObservable);
      }
      this.a.post(new bhd(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoObserver
 * JD-Core Version:    0.7.0.1
 */