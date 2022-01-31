package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EmoticonWording$DownloadWordingJsonTask
  extends AsyncTask
{
  protected Object doInBackground(Object... paramVarArgs)
  {
    File localFile = new File(((Context)paramVarArgs[0]).getFilesDir(), "EmoticonWording.json");
    if (localFile == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonWording", 2, "File Creation Failure: EmoticonWording.json");
      }
    }
    do
    {
      return null;
      if (HttpDownloadUtil.a(null, "http://imgcache.qq.com/club/item/parcel/client_wording.json", localFile))
      {
        EmoticonWording.a((Context)paramVarArgs[0], ((Integer)paramVarArgs[1]).intValue());
        return null;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonWording", 2, "Download failure: http://imgcache.qq.com/club/item/parcel/client_wording.json");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonWording.DownloadWordingJsonTask
 * JD-Core Version:    0.7.0.1
 */