import com.tencent.open.model.CreateVirtualResult;
import com.tencent.open.virtual.OpenSdkVirtualManager.1;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class asbi
  extends asbp.a
{
  public asbi(OpenSdkVirtualManager.1 param1) {}
  
  protected void k(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createVirtual.result:", asbp.ck(paramString1, this.a.b.uin) });
    ahlw.a("KEY_CREATE_VIRTUAL_D17", this.a.b, paramBoolean);
    paramString2 = new CreateVirtualResult();
    int i;
    if (paramBoolean) {
      i = paramInt;
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        i = paramInt;
        paramInt = paramString1.optInt("ErrorCode");
        if (paramInt == 0)
        {
          i = paramInt;
          paramString2.awT = paramString1.optLong("uint64_vuid");
          i = paramInt;
          paramString2.headUrl = paramString1.optString("str_head_url");
        }
      }
      catch (JSONException paramString1)
      {
        int j = 0;
        paramInt = i;
        i = j;
      }
      try
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "OpenVirtual.createResult=", asbp.ck(paramString2.toString(), this.a.b.uin) });
        if (this.a.c != null) {
          this.a.c.a(true, paramString2, paramInt);
        }
        return;
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          i = 1;
        }
      }
      i = 0;
      if ((i == 0) && (this.a.c != null))
      {
        this.a.c.a(false, null, paramInt);
        return;
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "OpenVirtual.createVirtual.e:", paramString1);
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     asbi
 * JD-Core Version:    0.7.0.1
 */