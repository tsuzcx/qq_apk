package com.tencent.mobileqq.filemanager.util;

import ahap;
import ahbj;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public final class FileCategoryUtil$6
  implements Runnable
{
  public FileCategoryUtil$6(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (ahbj.isFileExists(this.k.getFilePath())) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.k.strApkPackageName == null) || (this.k.strApkPackageName.length() == 0)) {}
        localIterator = ahap.o(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!this.k.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    this.k.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
    this.k.fileName = ahap.getAppName(this.k.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.6
 * JD-Core Version:    0.7.0.1
 */