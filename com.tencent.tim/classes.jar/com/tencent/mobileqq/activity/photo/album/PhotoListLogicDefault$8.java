package com.tencent.mobileqq.activity.photo.album;

import android.os.Handler;
import android.os.Message;
import aqfy;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.Map;
import ztv;

public class PhotoListLogicDefault$8
  implements Runnable
{
  public PhotoListLogicDefault$8(ztv paramztv, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = ((NewPhotoListActivity)this.this$0.mActivity).hT(this.rw);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    aqfy.a(localLocalMediaInfo, str);
    PhotoListBaseData.newCaptureMediaInfo.put(str, localLocalMediaInfo);
    ((NewPhotoListActivity)this.this$0.mActivity).mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.8
 * JD-Core Version:    0.7.0.1
 */