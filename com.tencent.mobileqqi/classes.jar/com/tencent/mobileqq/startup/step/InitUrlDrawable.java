package com.tencent.mobileqq.startup.step;

import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.DiskCache;
import gkb;
import java.io.File;

public class InitUrlDrawable
  extends Step
{
  public static DiskCache a;
  
  protected boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    URLDrawable.DEBUG = false;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localFile = new File(AppConstants.an);
      URLDrawable.init(localBaseApplicationImpl, new gkb(localBaseApplicationImpl));
      localFile = new File(localFile, "diskcache");
      if (localFile != null) {
        break label87;
      }
      localFile = Utils.getExternalCacheDir(localBaseApplicationImpl);
    }
    label87:
    for (;;)
    {
      a = new DiskCache(localFile);
      com.tencent.mobileqq.transfile.URLDrawableHelper.a = localFile;
      return true;
      localFile = localBaseApplicationImpl.getCacheDir();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */