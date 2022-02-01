package com.tencent.mobileqq.filemanager.multisave;

import agzj;
import agzj.a;
import ahbf;
import android.text.TextUtils;

public class QFileMultiSaveReq$1
  implements Runnable
{
  public QFileMultiSaveReq$1(agzj paramagzj, String paramString, agzj.a parama) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(ahbf.le(this.val$filePath))) {
          break label97;
        }
        i = 1;
        if (this.a != null)
        {
          if (i != 0)
          {
            this.a.onSuccess();
            return;
          }
          this.a.onError(-1, "save file fail. filePath[" + this.val$filePath + "]");
          return;
        }
      }
      catch (Exception localException)
      {
        if (this.a != null) {
          this.a.onError(-1, localException.getMessage());
        }
      }
      return;
      label97:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.1
 * JD-Core Version:    0.7.0.1
 */