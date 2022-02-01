import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aerb
  extends aeqp<aera>
{
  public static aera c()
  {
    aera localaera2 = (aera)aeif.a().o(498);
    aera localaera1 = localaera2;
    if (localaera2 == null) {
      localaera1 = new aera();
    }
    return localaera1;
  }
  
  @NonNull
  public aera a()
  {
    return new aera();
  }
  
  @NonNull
  public aera a(@NonNull aeic[] paramArrayOfaeic)
  {
    aera localaera = new aera();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (TextUtils.isEmpty(paramArrayOfaeic)) {}
    for (;;)
    {
      return localaera;
      try
      {
        paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
        localaera.stage = paramArrayOfaeic.optInt("stage");
        localaera.payUrl = paramArrayOfaeic.optString("pay_url");
        if (QLog.isColorLevel())
        {
          QLog.d("vip_ptt.ConfigProcessor", 1, "json parse config.stage:" + localaera.stage + " url=" + localaera.payUrl);
          return localaera;
        }
      }
      catch (JSONException paramArrayOfaeic)
      {
        QLog.e("vip_ptt.ConfigProcessor", 1, "json parse error:" + paramArrayOfaeic);
        localaera.errorMsg = paramArrayOfaeic.toString();
      }
    }
    return localaera;
  }
  
  @NonNull
  public aera b()
  {
    return new aera();
  }
  
  public Class<aera> clazz()
  {
    return aera.class;
  }
  
  public int type()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerb
 * JD-Core Version:    0.7.0.1
 */