package com.tencent.mobileqq.activity.photo.album.logicImp;

import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import zvy;

public class PhotoListLogicWeiyun$1
  implements Runnable
{
  public PhotoListLogicWeiyun$1(zvy paramzvy, NewPhotoListActivity paramNewPhotoListActivity) {}
  
  public void run()
  {
    if (this.b.queryPhotoTask == null) {
      this.b.excuteQueryPhotoTask();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicWeiyun.1
 * JD-Core Version:    0.7.0.1
 */