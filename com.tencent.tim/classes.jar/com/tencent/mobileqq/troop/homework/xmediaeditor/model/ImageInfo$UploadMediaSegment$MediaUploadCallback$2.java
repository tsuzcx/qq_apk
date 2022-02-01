package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import apks;
import apks.b;
import apks.b.a;
import aple.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$2
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$2(apks.b.a parama, int paramInt) {}
  
  public void run()
  {
    apks.b.a(this.a.a).mProgress = this.dUS;
    Object localObject = (XMediaEditor)apks.b.a(this.a.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(apks.b.a(this.a.a).mPosition);
      if ((localObject instanceof aple.a))
      {
        localObject = (aple.a)localObject;
        if (apks.b.a(this.a.a).cpR.equals(((aple.a)localObject).d.getTag()))
        {
          ((aple.a)localObject).d.setVisibility(0);
          ((aple.a)localObject).d.setDrawStatus(1);
          ((aple.a)localObject).d.setAnimProgress(apks.b.a(this.a.a).mProgress, apks.b.a(this.a.a).cpR);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.2
 * JD-Core Version:    0.7.0.1
 */