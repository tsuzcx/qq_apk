package com.tencent.mobileqq.phonecontact;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class ContactBindObserver
  implements BusinessObserver
{
  public static final String a = "k_result";
  public static final String b = "k_uin";
  
  protected String a(int paramInt)
  {
    if (paramInt == 217) {
      return "手机号码不正确，请确认！";
    }
    if ((paramInt == 219) || (paramInt == 216)) {
      return "请求频率太高，请稍后重试！";
    }
    if (paramInt == 224) {
      return "所属地区运营商暂未支持开通服务";
    }
    if (paramInt == 223) {
      return "绑定失败，请稍后再试";
    }
    return "请求失败，请稍候重试。";
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt)
    {
    case 18: 
    case 21: 
    case 22: 
    case 24: 
    case 25: 
    default: 
      return;
    case 12: 
      if (paramBoolean)
      {
        paramBoolean = paramBundle.getBoolean("bind_state");
        bool1 = paramBundle.getBoolean("bind_strategy", false);
        if (paramBoolean)
        {
          a(true, true, bool1);
          return;
        }
        a(true, false, bool1);
        return;
      }
      a(false, false, false);
      return;
    case 13: 
      a(paramBoolean, paramBundle);
      return;
    case 14: 
      a(paramBoolean);
      return;
    case 15: 
      d(paramBoolean);
      return;
    case 28: 
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("hasUpdate");
      }
      b(paramBoolean, bool1);
      return;
    case 16: 
      if (paramBundle != null) {}
      for (paramInt = paramBundle.getInt("k_result");; paramInt = -1)
      {
        a(paramBoolean, paramInt);
        return;
      }
    case 17: 
      e(paramBoolean);
      return;
    case 19: 
      b(paramBoolean, paramBundle);
      return;
    case 20: 
      b(paramBoolean);
      return;
    case 29: 
      bool1 = bool2;
      if (paramBundle != null) {
        bool1 = paramBundle.getBoolean("hasUpdate");
      }
      c(paramBoolean, bool1);
      return;
    case 23: 
      f(paramBoolean);
      return;
    case 26: 
      a(paramBoolean, paramBundle.getBoolean("bindOK"), paramBundle.getBoolean("hadBind"), paramBundle.getString("bindUin"));
      return;
    }
    a(paramBoolean, paramBundle.getBoolean("bind_state", false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.ContactBindObserver
 * JD-Core Version:    0.7.0.1
 */