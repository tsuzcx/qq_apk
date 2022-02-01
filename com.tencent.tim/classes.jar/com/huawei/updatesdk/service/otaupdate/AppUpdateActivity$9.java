package com.huawei.updatesdk.service.otaupdate;

import android.widget.Toast;
import com.huawei.updatesdk.service.f.a;

class AppUpdateActivity$9
  implements com.huawei.updatesdk.service.f.b
{
  AppUpdateActivity$9(AppUpdateActivity paramAppUpdateActivity) {}
  
  public void a()
  {
    AppUpdateActivity.c(this.a, 101);
    if (!com.huawei.updatesdk.a.a.c.b.b.a(this.a))
    {
      Toast.makeText(this.a, g.b(this.a, "upsdk_no_available_network_prompt_toast"), 0).show();
      AppUpdateActivity.b(this.a, 2);
      this.a.finish();
      return;
    }
    AppUpdateActivity.h(this.a);
  }
  
  public void b()
  {
    AppUpdateActivity.i(this.a).c();
    AppUpdateActivity.b(this.a, 4);
    AppUpdateActivity.c(this.a, 100);
    if (!AppUpdateActivity.f(this.a))
    {
      new c().a(this.a, new AppUpdateActivity.a(this.a));
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.9
 * JD-Core Version:    0.7.0.1
 */