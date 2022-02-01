package com.tencent.mobileqq.activity.contacts.topentry;

import aqgt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import zbq;
import zbq.b;

public class CTEntryMng$3
  implements Runnable
{
  public CTEntryMng$3(zbq paramzbq) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(zbq.a(this.this$0));
    for (;;)
    {
      JSONArray localJSONArray;
      int i;
      String str;
      try
      {
        if (localArrayList.size() > 0)
        {
          localJSONArray = new JSONArray();
          i = 0;
          if (i >= localArrayList.size()) {
            break label211;
          }
          Object localObject = (zbq.b)localArrayList.get(i);
          if ((((zbq.b)localObject).ccU > 4) && (!zbq.b(this.this$0).contains(Integer.valueOf(((zbq.b)localObject).ccU))))
          {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "saveUserSetting not save id: " + ((zbq.b)localObject).ccU);
            }
          }
          else
          {
            localObject = ((zbq.b)localObject).toJson();
            if (localObject != null) {
              localJSONArray.put(localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str = "";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveUserSetting value: %s", new Object[] { str }));
        }
        aqgt.q(zbq.a(this.this$0).getApp(), zbq.a(this.this$0).getCurrentUin(), "ct_entry_user_setting", str);
        return;
        label211:
        str = localJSONArray.toString();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3
 * JD-Core Version:    0.7.0.1
 */