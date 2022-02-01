package com.tencent.tim.filemanager.util;

import ahav;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import audt.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class FileCategoryUtil$3
  implements Runnable
{
  public FileCategoryUtil$3(String paramString, audt.a parama) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageArchiveInfo(this.bGY, 1);
    if (localPackageInfo != null)
    {
      this.a.Zb(localPackageInfo.applicationInfo.packageName);
      localObject = localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject).toString();
      localObject = (String)localObject + ".apk";
      this.a.Za((String)localObject);
      return;
    }
    this.a.Zb(ahav.getFileName(this.bGY));
    this.a.Za(ahav.getFileName(this.bGY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FileCategoryUtil.3
 * JD-Core Version:    0.7.0.1
 */