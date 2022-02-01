package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;

class PhotoWallView$1
  implements Runnable
{
  PhotoWallView$1(PhotoWallView paramPhotoWallView) {}
  
  public void run()
  {
    Object localObject = (QZonePhotoWall)this.this$0.mApp.a().createEntityManager().find(QZonePhotoWall.class, this.this$0.mUin);
    if (localObject == null)
    {
      this.this$0.mHandler.sendEmptyMessage(3);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    this.this$0.b(((QZonePhotoWall)localObject).totalPic, ((QZonePhotoWall)localObject).hasMore, ((QZonePhotoWall)localObject).attachInfo, ((QZonePhotoWall)localObject).unpackPhotoWallData(), localArrayList);
    localObject = this.this$0.mHandler.obtainMessage(1);
    ((Message)localObject).obj = localArrayList;
    this.this$0.mHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoWallView.1
 * JD-Core Version:    0.7.0.1
 */