package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import apkk;
import apkv;
import apkv.b;
import aplc;
import aple.a;
import aplq;
import aplq.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class VideoInfo$GenerateVideoPosterSegment$1
  implements Runnable
{
  public VideoInfo$GenerateVideoPosterSegment$1(apkv.b paramb, apkv paramapkv, String paramString) {}
  
  public void run()
  {
    this.b.SY(this.cpT);
    this.b.mProgress = 5;
    this.b.mUploadStatus = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)apkv.b.a(this.this$0).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.b.mPosition);
      if ((localObject instanceof aplq.a))
      {
        localObject = (aplq.a)localObject;
        if (this.b.cpR.equals(((aplq.a)localObject).d.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((aplq)((apkk)localXMediaEditor.getAdapter()).a.a(2)).a((aple.a)localObject, this.b, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1
 * JD-Core Version:    0.7.0.1
 */