package com.tencent.biz.qrcode;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import jqc;
import org.json.JSONArray;
import org.json.JSONObject;

class CodeMaskManager$1
  extends Thread
{
  CodeMaskManager$1(CodeMaskManager paramCodeMaskManager, String paramString, SharedPreferences paramSharedPreferences, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString);
  }
  
  public void run()
  {
    localEditor = this.v.edit();
    localEditor.putLong("updateTemplate2", System.currentTimeMillis());
    Object localObject = "https://qm.qq.com/cgi-bin/tpl?v=1&os=a&resx=" + this.val$width + "&resy=" + this.val$height + "&t=" + this.bvp + "&" + "mType" + "=" + "qb_qrcode";
    try
    {
      String str = jqc.a(this.this$0.context, (String)localObject, "GET", null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QRHttpUtil", 2, "open :" + (String)localObject + ", result: " + str);
      }
      localObject = new JSONObject(str);
      if (((JSONObject)localObject).getInt("r") == 0)
      {
        localObject = ((JSONObject)localObject).getJSONArray("tpls");
        if (((JSONArray)localObject).length() > 0)
        {
          this.this$0.mHandler.post(new CodeMaskManager.1.1(this, (JSONArray)localObject));
          localEditor.putString("tpl_json", str);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QRHttpUtil", 2, localException.getMessage());
        }
        localEditor.putLong("updateTemplate2", 0L);
      }
    }
    localEditor.commit();
    this.this$0.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.CodeMaskManager.1
 * JD-Core Version:    0.7.0.1
 */