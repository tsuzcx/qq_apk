package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class QzonePhotoView$1
  implements Runnable
{
  QzonePhotoView$1(QzonePhotoView paramQzonePhotoView) {}
  
  public void run()
  {
    Object localObject1 = (QZonePhotoWall)this.this$0.app.a().createEntityManager().find(QZonePhotoWall.class, QzonePhotoView.a(this.this$0));
    if (localObject1 != null)
    {
      localObject1 = ((QZonePhotoWall)localObject1).unpackPhotoWallData();
      Object localObject2 = new ArrayList();
      int i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        ((ArrayList)localObject2).add(((PhotoWall)((ArrayList)localObject1).get(i)).photoUrls);
        i += 1;
      }
      new LinkedList();
      localObject1 = QzonePhotoView.a(this.this$0, "", (List)localObject2);
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 200;
      ((Message)localObject2).obj = localObject1;
      QzonePhotoView.a(this.this$0).sendMessage((Message)localObject2);
      return;
    }
    QzonePhotoView.a(this.this$0).sendEmptyMessage(201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.1
 * JD-Core Version:    0.7.0.1
 */