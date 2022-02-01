package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import apkk;
import apkv;
import apkv.a;
import aplc;
import aple.a;
import aplq;
import aplq.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class VideoInfo$CompressVideoSegment$1
  implements Runnable
{
  public VideoInfo$CompressVideoSegment$1(apkv.a parama, apkv paramapkv, XMediaEditor paramXMediaEditor) {}
  
  public void run()
  {
    this.b.mProgress = 10;
    this.b.mUploadStatus = -2147483647;
    Object localObject = this.d.findViewHolderForLayoutPosition(this.b.mPosition);
    if ((localObject instanceof aplq.a))
    {
      localObject = (aplq.a)localObject;
      if (this.b.cpR.equals(((aplq.a)localObject).d.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        ((aplq)((apkk)this.d.getAdapter()).a.a(2)).a((aple.a)localObject, this.b, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1
 * JD-Core Version:    0.7.0.1
 */