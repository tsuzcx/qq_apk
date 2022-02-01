package com.tencent.mobileqq.apollo.store;

import abtv;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import aqhu;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import mqq.os.MqqHandler;
import rox;

class ApolloStoreActivity$3
  implements Runnable
{
  ApolloStoreActivity$3(ApolloStoreActivity paramApolloStoreActivity, Bitmap paramBitmap, long paramLong, String paramString) {}
  
  public void run()
  {
    int i = 0;
    if (this.val$bitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "[saveImage] failed bitmap null");
      }
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloStoreActivity", 2, "[saveImage] consume time " + (System.currentTimeMillis() - this.Or) + " ms");
        }
        Message localMessage = Message.obtain();
        localMessage.what = 256;
        try
        {
          str = Environment.getExternalStorageDirectory().toString();
          Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
          if (ApolloStoreActivity.a(this.this$0) != null) {
            i = ApolloStoreActivity.a(this.this$0).zS();
          }
          str = str + "/cmshow/" + i + "_" + (String)localObject + ".png";
          localObject = new File(str);
          if (!TextUtils.isEmpty(str))
          {
            try
            {
              aqhu.saveBitmapToFile(this.val$bitmap, (File)localObject);
              if ((!TextUtils.isEmpty(str)) && (rox.fileExistsAndNotEmpty(str))) {
                break label275;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("ApolloStoreActivity", 2, "[saveImage] failed invalid path");
              return;
            }
            catch (Throwable localThrowable1) {}
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloStoreActivity", 2, "[saveImage] failed save to disk");
              return;
            }
          }
        }
        catch (Throwable localThrowable2) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[saveImage] failed create path" + localThrowable2.getMessage());
    return;
    try
    {
      label275:
      MediaScannerConnection.scanFile(this.this$0.getApplicationContext(), new String[] { str }, new String[] { "image/png" }, null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "[saveImage] to media db " + str);
      }
      localThrowable2.obj = this.val$callBackId;
      localThrowable2.arg1 = 0;
      this.this$0.b.sendMessage(localThrowable2);
      return;
    }
    catch (Throwable localThrowable3)
    {
      QLog.e("ApolloStoreActivity", 2, "[saveImage] failed exception " + localThrowable3.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.3
 * JD-Core Version:    0.7.0.1
 */