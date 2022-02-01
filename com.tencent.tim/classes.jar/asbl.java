import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class asbl
  extends asbp.a
{
  asbl(asbh paramasbh, asav paramasav, artd paramartd, String paramString, JSONObject paramJSONObject) {}
  
  protected void k(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    bool2 = false;
    boolean bool3 = true;
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.uploadAvatarImage.result:", asbp.ck(paramString1, this.b.uin) });
    localObject = null;
    bool1 = bool2;
    paramString2 = localObject;
    i = paramInt;
    if (paramBoolean) {}
    try
    {
      paramString1 = new JSONObject(paramString1);
      i = paramString1.optInt("ErrorCode");
      if (i != 0) {}
    }
    catch (JSONException paramString1)
    {
      label96:
      do
      {
        for (;;)
        {
          QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.uploadAvatarImage.e:", paramString1);
          bool1 = bool2;
          paramString2 = localObject;
          i = paramInt;
        }
        asbh.a(this.this$0);
        if (asbh.b(this.this$0) < 2) {
          break;
        }
      } while (this.c == null);
      this.c.f(bool1, this.val$imagePath, paramString2, i);
      return;
      asbh.a(this.this$0, this.b, this.val$imagePath, this.cf, this.c);
      return;
    }
    try
    {
      paramString1 = paramString1.optJSONObject("msg_img_data");
      if (paramString1 == null) {
        break label253;
      }
      paramString1 = paramString1.optString("str_file_name");
      paramBoolean = bool3;
    }
    catch (JSONException paramString1)
    {
      paramInt = i;
      break label155;
      paramBoolean = false;
      paramString1 = null;
      break label96;
    }
    paramInt = i;
    for (;;)
    {
      i = paramInt;
      paramString2 = paramString1;
      bool1 = paramBoolean;
      if (!bool1) {
        break;
      }
      if (this.c != null) {
        this.c.f(bool1, this.val$imagePath, paramString2, i);
      }
      return;
      paramInt = paramString1.optInt("uint32_ret_to_http", i);
      paramString1 = null;
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     asbl
 * JD-Core Version:    0.7.0.1
 */