package com.tencent.mobileqq.jsp;

import aeuj;
import aeuk;
import aiiy;
import aobh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class DocxApiPlugin$3
  implements Runnable
{
  public DocxApiPlugin$3(aiiy paramaiiy, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = aeuk.a();
    if ((((aeuj)localObject).ahY()) && (((aeuj)localObject).ahZ()) && (aobh.pM(this.bJt)))
    {
      localObject = aobh.nQ(this.bJt);
      this.this$0.callJs(this.val$callback, new String[] { localObject });
    }
    for (;;)
    {
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(this.bOb);
      aiiy.a(this.this$0, (ArrayList)localObject);
      return;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", 1);
        this.this$0.callJs(this.val$callback, new String[] { ((JSONObject)localObject).toString() });
      }
      catch (JSONException localJSONException)
      {
        QLog.e("DocxApiPlugin", 1, "JSONException ", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */