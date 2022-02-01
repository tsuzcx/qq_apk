import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeuv
{
  private String bBS = "";
  private String bBT = "";
  
  public static aeuv a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      paramArrayOfaeic = null;
    }
    aeuv localaeuv;
    for (;;)
    {
      return paramArrayOfaeic;
      localaeuv = new aeuv();
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfaeic[0].content);
        if (localJSONObject.has("AndroidDrawerJumpURL"))
        {
          localaeuv.bBS = localJSONObject.getString("AndroidDrawerJumpURL");
          if (QLog.isColorLevel()) {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + localaeuv.bBS);
          }
        }
        paramArrayOfaeic = localaeuv;
        if (localJSONObject.has("AndroidAioJumpURL"))
        {
          localaeuv.bBT = localJSONObject.getString("AndroidAioJumpURL");
          paramArrayOfaeic = localaeuv;
          if (QLog.isColorLevel())
          {
            QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + localaeuv.bBT);
            return localaeuv;
          }
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        paramArrayOfaeic.printStackTrace();
      }
    }
    return localaeuv;
  }
  
  public String uh()
  {
    if (TextUtils.isEmpty(this.bBS)) {
      return null;
    }
    return this.bBS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeuv
 * JD-Core Version:    0.7.0.1
 */