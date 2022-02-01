package com.tencent.mobileqq.activity.photo.album;

import ztv;

public class PhotoListLogicDefault$6
  implements Runnable
{
  public PhotoListLogicDefault$6(ztv paramztv) {}
  
  public void run()
  {
    if (((NewPhotoListActivity)this.this$0.mActivity).queryPhotoTask == null) {
      ((NewPhotoListActivity)this.this$0.mActivity).excuteQueryPhotoTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.6
 * JD-Core Version:    0.7.0.1
 */