package com.tencent.mobileqq.ark.image;

import adst;
import adsw;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class PhotoListLogicArk$2
  implements Runnable
{
  public PhotoListLogicArk$2(adsw paramadsw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListLogicArk", 1, "copy file to res: " + adsw.a(this.this$0));
    }
    String str = adst.a(adsw.a(this.this$0).selectedPhotoList, adsw.a(this.this$0), adsw.a(this.this$0), adsw.b(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    adst.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListLogicArk.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.2
 * JD-Core Version:    0.7.0.1
 */