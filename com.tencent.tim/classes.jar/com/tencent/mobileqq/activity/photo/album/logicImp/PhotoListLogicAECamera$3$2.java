package com.tencent.mobileqq.activity.photo.album.logicImp;

import android.util.Log;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import zut;
import zux;

public class PhotoListLogicAECamera$3$2
  implements Runnable
{
  public PhotoListLogicAECamera$3$2(zux paramzux) {}
  
  public void run()
  {
    if (!((NewPhotoListActivity)this.a.a.mActivity).isFinishing())
    {
      ((NewPhotoListActivity)this.a.a.mActivity).cancleProgressDailog();
      Log.d("Q.videostory.capture", "failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicAECamera.3.2
 * JD-Core Version:    0.7.0.1
 */