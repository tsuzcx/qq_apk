package com.tencent.tim.filemanager.fileviewer.FileView;

import android.app.Activity;
import atxy;
import atxy.a;
import aueh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;

public class LocalTbsViewManager$3
  implements Runnable
{
  public LocalTbsViewManager$3(atxy paramatxy, String paramString, boolean paramBoolean, TbsReaderView paramTbsReaderView, Activity paramActivity, atxy.a parama) {}
  
  public void run()
  {
    String str2 = aueh.getExtension(this.aJN);
    String str1 = str2;
    if (str2.startsWith(".")) {
      str1 = str2.replaceFirst(".", "");
    }
    if (!this.diJ) {}
    for (boolean bool = true;; bool = false)
    {
      try
      {
        if (!this.d.preOpen(str1, bool))
        {
          this.val$activity.runOnUiThread(new LocalTbsViewManager.3.1(this));
          if (QLog.isColorLevel()) {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file false!");
          }
        }
        else
        {
          if ((this.diJ) && (this.a != null)) {
            this.val$activity.runOnUiThread(new LocalTbsViewManager.3.2(this));
          }
          if (QLog.isColorLevel())
          {
            QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open file true! wait callback!");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("LocalTbsViewManager<FileAssistant>", 1, " preOpen , e = ", localException);
        this.val$activity.runOnUiThread(new LocalTbsViewManager.3.3(this));
        if (QLog.isColorLevel()) {
          QLog.i("LocalTbsViewManager<FileAssistant>", 1, "pre open error !");
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.FileView.LocalTbsViewManager.3
 * JD-Core Version:    0.7.0.1
 */