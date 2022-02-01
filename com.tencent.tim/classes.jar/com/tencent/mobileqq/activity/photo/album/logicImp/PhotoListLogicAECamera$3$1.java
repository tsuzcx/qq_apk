package com.tencent.mobileqq.activity.photo.album.logicImp;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.io.Serializable;
import java.util.List;
import zut;
import zux;

public class PhotoListLogicAECamera$3$1
  implements Runnable
{
  public PhotoListLogicAECamera$3$1(zux paramzux, List paramList, long paramLong, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    if (!((NewPhotoListActivity)this.a.a.mActivity).isFinishing())
    {
      ((NewPhotoListActivity)this.a.a.mActivity).cancleProgressDailog();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.a.val$info.path);
      localBundle.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.val$list);
      localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.val$size);
      zut.a(this.a.a, this.b, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicAECamera.3.1
 * JD-Core Version:    0.7.0.1
 */