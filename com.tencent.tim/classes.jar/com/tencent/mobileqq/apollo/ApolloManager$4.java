package com.tencent.mobileqq.apollo;

import abhh;
import abxi;
import android.text.TextUtils;
import aqhq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ApolloManager$4
  implements Runnable
{
  public ApolloManager$4(abhh paramabhh) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      if (this.this$0.mApp == null) {
        break label152;
      }
      localObject = this.this$0.mApp.getApp();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, localOutOfMemoryError.getMessage());
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, localException.getMessage());
          }
        }
      } while (localException != null);
    }
    localObject = new File(abxi.bim);
    ((File)localObject).mkdirs();
    localObject = new File((File)localObject, "apollo_res_version_info.json");
    if (((File)localObject).exists())
    {
      localObject = aqhq.readFileToString((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.be = new JSONObject((String)localObject);
      }
    }
    if (this.this$0.be == null)
    {
      this.this$0.be = new JSONObject();
      return;
    }
    label152:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.4
 * JD-Core Version:    0.7.0.1
 */