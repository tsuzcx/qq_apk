package com.huawei.updatesdk.service.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.huawei.updatesdk.support.pm.PackageInstallerActivity;
import java.io.File;

public class a
{
  private static void a()
  {
    g.a(4, -10002);
  }
  
  protected static void a(Context paramContext, b paramb)
  {
    b(paramContext, paramb);
  }
  
  private static void b(Context paramContext, b paramb)
  {
    if (paramb == null)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("InstallProcess", "system install failed,task is null");
      return;
    }
    com.huawei.updatesdk.a.a.b.a.a.a.a("InstallProcess", "systemInstall begin!!!task:" + paramb.toString());
    paramb.a(c.a.a);
    g.a(3, 1);
    Object localObject = new File(paramb.d());
    if ((!((File)localObject).exists()) || (!((File)localObject).isFile()) || (((File)localObject).length() <= 0L))
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("InstallProcess", "system install failed,file not existed filePath:" + paramb.d());
      g.a(4, -10003);
      return;
    }
    localObject = new Intent(paramContext, PackageInstallerActivity.class);
    ((Intent)localObject).putExtra("install_path", paramb.d());
    ((Intent)localObject).putExtra("install_packagename", paramb.c());
    ((Intent)localObject).putExtra("install_change_path_times", paramb.f());
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).setFlags(402653184);
    }
    try
    {
      paramContext.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      a();
      com.huawei.updatesdk.a.a.b.a.a.a.a("InstallProcess", " can not start install !", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.a
 * JD-Core Version:    0.7.0.1
 */