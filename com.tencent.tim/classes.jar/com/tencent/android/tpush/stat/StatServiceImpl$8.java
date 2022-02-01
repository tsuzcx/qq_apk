package com.tencent.android.tpush.stat;

import android.app.Activity;
import android.os.Bundle;

final class StatServiceImpl$8
  implements com.tencent.android.tpush.stat.lifecycle.a
{
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, Bundle paramBundle) {}
  
  public void b(Activity paramActivity)
  {
    com.tencent.android.tpush.stat.a.a.b(paramActivity, "onActivityStarted");
  }
  
  public void b(Activity paramActivity, Bundle paramBundle)
  {
    com.tencent.android.tpush.stat.a.a.b(paramActivity, "onActivityCreated");
  }
  
  public void c(Activity paramActivity) {}
  
  public void d(Activity paramActivity)
  {
    com.tencent.android.tpush.stat.a.a.a(paramActivity, "onActivityPaused");
  }
  
  public void e(Activity paramActivity)
  {
    com.tencent.android.tpush.stat.a.a.a(paramActivity, "onActivityDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.StatServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */