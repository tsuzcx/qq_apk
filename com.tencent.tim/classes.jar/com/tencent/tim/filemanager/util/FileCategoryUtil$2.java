package com.tencent.tim.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import audt;
import aueh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public final class FileCategoryUtil$2
  implements Runnable
{
  public FileCategoryUtil$2(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (aueh.isFileExists(this.k.getFilePath())) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.k.strApkPackageName == null) || (this.k.strApkPackageName.length() == 0)) {}
        localIterator = audt.o(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!this.k.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    this.k.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
    this.k.fileName = audt.getAppName(this.k.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FileCategoryUtil.2
 * JD-Core Version:    0.7.0.1
 */