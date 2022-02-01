package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images.Media;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import dz;
import java.io.File;
import rbr;
import rbt;
import rel;
import wmj;

public class EditPicSave$2$1
  implements Runnable
{
  public EditPicSave$2$1(rbt paramrbt, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = wmj.getCameraPath();
      File localFile = new File(str);
      if (aqhq.copyFile(new File(this.azt), localFile))
      {
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
        localObject = ((BitmapFactory.Options)localObject).outMimeType;
        int i = dz.l(str);
        ContentValues localContentValues = new ContentValues(7);
        localContentValues.put("title", localFile.getName());
        localContentValues.put("_display_name", localFile.getName());
        localContentValues.put("date_modified", Long.valueOf(localFile.lastModified() / 1000L));
        localContentValues.put("mime_type", (String)localObject);
        localContentValues.put("orientation", Integer.valueOf(i));
        localContentValues.put("_data", str);
        localContentValues.put("_size", Long.valueOf(localFile.length()));
        if (this.a.this$0.a.getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues) == null) {
          MediaStore.Images.Media.insertImage(this.a.this$0.a.getActivity().getContentResolver(), str, localFile.getName(), null);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EditPicSave", 2, "savePic " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */