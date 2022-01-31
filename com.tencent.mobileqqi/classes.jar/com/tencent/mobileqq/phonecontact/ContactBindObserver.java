package com.tencent.mobileqq.phonecontact;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.observer.BusinessObserver;

public class ContactBindObserver
  implements BusinessObserver
{
  public static final String a = "k_result";
  public static final String b = "k_uin";
  
  public String a(int paramInt)
  {
    if (paramInt == 217) {
      return BaseApplicationImpl.getContext().getString(2131559259);
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return BaseApplicationImpl.getContext().getString(2131559260);
    }
    if (paramInt == 224) {
      return BaseApplicationImpl.getContext().getString(2131559261);
    }
    if (paramInt == 223) {
      return BaseApplicationImpl.getContext().getString(2131559262);
    }
    return BaseApplicationImpl.getContext().getString(2131559263);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void d(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void g(boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    case 21: 
    case 24: 
    case 25: 
    default: 
      return;
    case 12: 
      if (paramBoolean)
      {
        if (paramBundle.getBoolean("bind_state"))
        {
          a(true, true);
          return;
        }
        a(true, false);
        return;
      }
      a(false, false);
      return;
    case 13: 
      a(paramBoolean, paramBundle);
      return;
    case 14: 
      b(paramBoolean);
      return;
    case 15: 
      e(paramBoolean);
      return;
    case 18: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("hasUpdate");
      }
      c(paramBoolean, bool1);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        a(paramBoolean, paramInt);
        return;
      }
    case 17: 
      f(paramBoolean);
      return;
    case 19: 
      c(paramBoolean);
      return;
    case 20: 
      a(paramBoolean);
      return;
    case 22: 
      bool1 = bool2;
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("hasUpdate");
      }
      d(paramBoolean, bool1);
      return;
    case 23: 
      g(paramBoolean);
      return;
    case 26: 
      a(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    }
    b(paramBoolean, paramBundle.getBoolean("bind_state", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindObserver
 * JD-Core Version:    0.7.0.1
 */