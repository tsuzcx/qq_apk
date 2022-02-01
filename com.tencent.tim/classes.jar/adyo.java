import android.os.Bundle;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class adyo
  implements aprb.a
{
  public adyo(WordMatchManager paramWordMatchManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    if (paramJSONObject != null) {}
    try
    {
      int j = paramJSONObject.getInt("retcode");
      if (j != 0) {
        i = 0;
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi end(failed)| type:" + paramInt + ",time:" + System.currentTimeMillis());
        }
        this.this$0.GU(false);
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      paramBundle = paramBundle;
      paramBundle.printStackTrace();
      paramBundle = new WordMatchManager.a();
      try
      {
        if (paramJSONObject.has("result"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("result");
          if (paramJSONObject.has("id")) {
            paramBundle.id = paramJSONObject.getString("id");
          }
          if (paramJSONObject.has("md5")) {
            paramBundle.md5 = paramJSONObject.getString("md5");
          }
          if (paramJSONObject.has("type")) {
            paramBundle.type = paramJSONObject.getInt("type");
          }
          if (paramJSONObject.has("need_flag")) {
            paramBundle.flag = paramJSONObject.getInt("need_flag");
          }
          if (paramJSONObject.has("delay")) {
            paramBundle.delay = paramJSONObject.getLong("delay");
          }
          if (paramJSONObject.has("base_md5")) {
            paramBundle.bwo = paramJSONObject.getString("base_md5");
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot parse json error | type:" + paramInt + ",time:" + System.currentTimeMillis());
          }
        }
        this.this$0.a(paramBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi end(success) | type:" + paramInt + ",time:" + System.currentTimeMillis());
      }
      if (paramBundle.type != paramInt)
      {
        this.this$0.GU(false);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyo
 * JD-Core Version:    0.7.0.1
 */