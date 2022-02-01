package com.tencent.mobileqq.portal;

import alaa;
import alab;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class PortalManager$5$1
  implements Runnable
{
  public PortalManager$5$1(alaa paramalaa, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    PortalManager.a locala = (PortalManager.a)this.a.this$0.gw.get(this.bUX);
    this.a.this$0.gw.remove(this.bUX);
    Object localObject1;
    JSONObject localJSONObject;
    if (this.val$isSuccess)
    {
      i = 1;
      localObject1 = PortalManager.a(this.a.this$0).getFaceBitmap(this.bUX, false);
      if (localObject1 != null)
      {
        localObject1 = alab.h((Bitmap)localObject1);
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("errorCode", 0);
      localJSONObject.put("key", locala.key);
      localJSONObject.put("result", localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + locala.key);
      }
      PortalManager.a(this.a.this$0, locala.reqType, localJSONObject.toString(), locala.seq);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    finally
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManagerhead", 2, "error heppened info = " + localJSONObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + locala.key);
        }
        PortalManager.a(this.a.this$0, locala.reqType, locala.seq, null, -1, "get bitmap failed!");
        return;
      }
      finally
      {
        i = 0;
      }
      localObject2 = finally;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManagerhead", 2, "onUpdateCustomHead details.key = " + locala.key);
    }
    if (i != 0)
    {
      PortalManager.a(this.a.this$0, locala.reqType, localJSONObject.toString(), locala.seq);
      return;
    }
    throw localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.5.1
 * JD-Core Version:    0.7.0.1
 */