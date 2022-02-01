import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

class apkf
  implements jox
{
  apkf(apke paramapke) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "checkUp loaded json = " + paramString + " code = " + paramInt);
    }
    if (paramInt == 0) {}
    while (apke.ah(apke.a(this.this$0), apke.b(this.this$0)))
    {
      do
      {
        String str;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("data").optJSONObject(0);
          str = paramString.optString("url");
          paramInt = paramString.optInt("filesize");
          if ((str != null) && (str.endsWith("patch")))
          {
            aqhq.cn(jpe.dO(apke.a(this.this$0)) + apke.a(this.this$0));
            apke.a(this.this$0);
            return;
          }
        }
        catch (Exception paramString)
        {
          do
          {
            paramString.printStackTrace();
          } while (apke.ah(apke.a(this.this$0), apke.b(this.this$0)));
          apke.b(this.this$0);
          return;
        }
        if ((!TextUtils.isEmpty(str)) && (paramInt != 0))
        {
          apke.a(this.this$0, paramString);
          return;
        }
      } while (apke.ah(apke.a(this.this$0), apke.b(this.this$0)));
      apke.b(this.this$0);
      return;
    }
    apke.b(this.this$0);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkf
 * JD-Core Version:    0.7.0.1
 */