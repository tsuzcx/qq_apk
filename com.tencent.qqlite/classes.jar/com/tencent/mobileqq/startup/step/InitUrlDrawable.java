package com.tencent.mobileqq.startup.step;

import android.content.res.Resources;
import android.os.Environment;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photopreview.PhotoPreviewConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.DiskCache;
import efo;
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
      localFile = new File(AppConstants.as);
      URLDrawable.init(localBaseApplicationImpl, new efo(localBaseApplicationImpl));
      localFile = new File(localFile, "diskcache");
      if (localFile != null) {
        break label123;
      }
      localFile = Utils.getExternalCacheDir(localBaseApplicationImpl);
    }
    label123:
    for (;;)
    {
      a = new DiskCache(localFile);
      com.tencent.mobileqq.transfile.URLDrawableHelper.a = localFile;
      PhotoPreviewConstant.k = (int)(PhotoPreviewConstant.i * localBaseApplicationImpl.getResources().getDisplayMetrics().density);
      PhotoPreviewConstant.l = (int)(135.0F * localBaseApplicationImpl.getResources().getDisplayMetrics().density);
      return true;
      localFile = localBaseApplicationImpl.getCacheDir();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */