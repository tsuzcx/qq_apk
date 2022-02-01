package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.graphics.BitmapFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;
import jqc;
import nwg;

public class QShareUtils$2
  implements Runnable
{
  public QShareUtils$2(nwg paramnwg, String paramString, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = jqc.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.akc), "GET", null, null);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localObject != null) {
          this.eI.put("image", localObject);
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label49;
    }
    catch (IOException localIOException)
    {
      label49:
      break label49;
    }
    this.val$appInterface.runOnUiThread(this.cY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.2
 * JD-Core Version:    0.7.0.1
 */