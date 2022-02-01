package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import apkk;
import apks;
import apks.b;
import apks.b.a;
import apkv;
import aplc;
import aple.a;
import aplq;
import aplq.a;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment$MediaUploadCallback$1
  implements Runnable
{
  public ImageInfo$UploadMediaSegment$MediaUploadCallback$1(apks.b.a parama, apkv paramapkv) {}
  
  public void run()
  {
    apks.b.a(this.jdField_a_of_type_Apks$b$a.a).mProgress = 95;
    apks.b.a(this.jdField_a_of_type_Apks$b$a.a).mUploadStatus = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)apks.b.a(this.jdField_a_of_type_Apks$b$a.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(apks.b.a(this.jdField_a_of_type_Apks$b$a.a).mPosition);
      if ((localObject instanceof aplq.a))
      {
        localObject = (aplq.a)localObject;
        if (this.jdField_a_of_type_Apkv.cpR.equals(((aplq.a)localObject).d.getTag())) {
          ((aplq)((apkk)localXMediaEditor.getAdapter()).a.a(2)).a((aple.a)localObject, apks.b.a(this.jdField_a_of_type_Apks$b$a.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback.1
 * JD-Core Version:    0.7.0.1
 */