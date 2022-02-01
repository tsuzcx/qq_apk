package com.tencent.mobileqq.filemanager.util;

import ahap.a;
import ahav;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class FileCategoryUtil$7
  implements Runnable
{
  public FileCategoryUtil$7(String paramString, ahap.a parama) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageArchiveInfo(this.bGY, 1);
    if (localPackageInfo != null)
    {
      localObject = localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject).toString();
      localObject = (String)localObject + ".apk";
      this.a.fD((String)localObject, localPackageInfo.applicationInfo.packageName);
      return;
    }
    this.a.fD(ahav.getFileName(this.bGY), ahav.getFileName(this.bGY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.7
 * JD-Core Version:    0.7.0.1
 */