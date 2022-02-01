package com.tencent.mobileqq.app;

import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class HotChatManager$3
  implements Runnable
{
  public void run()
  {
    String str2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "isUinInVList,init");
    }
    Object localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir() + File.separator + this.this$0.app.getAccount() + "_nearby_hotchat_v_list");
    try
    {
      localObject1 = aqhq.readFileToString((File)localObject1);
      this.this$0.xx = new ArrayList();
      if (localObject1 == null) {}
    }
    catch (IOException localIOException)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONArray("vusers");
        if (localObject1 != null)
        {
          int i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            str2 = ((JSONArray)localObject1).optString(i);
            if (!TextUtils.isEmpty(str2)) {
              this.this$0.xx.add(str2);
            }
            i += 1;
            continue;
            localIOException = localIOException;
            if (QLog.isColorLevel()) {
              QLog.i("HotChatManager", 2, "isUinInVList, readFile exception:" + localIOException.getMessage());
            }
            localIOException.printStackTrace();
            Object localObject2 = null;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          String str1 = str2;
        }
      }
      this.this$0.bHO = false;
      if (this.this$0.a != null) {
        this.this$0.a.cJo();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager.3
 * JD-Core Version:    0.7.0.1
 */