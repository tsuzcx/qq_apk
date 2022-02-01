import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import org.json.JSONException;
import org.json.JSONObject;

public class aerc
  extends aeqp<QVipBigClubSVIP9Config>
{
  public static QVipBigClubSVIP9Config c()
  {
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config2 = (QVipBigClubSVIP9Config)aeif.a().o(427);
    QVipBigClubSVIP9Config localQVipBigClubSVIP9Config1 = localQVipBigClubSVIP9Config2;
    if (localQVipBigClubSVIP9Config2 == null) {
      localQVipBigClubSVIP9Config1 = new QVipBigClubSVIP9Config();
    }
    return localQVipBigClubSVIP9Config1;
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  @NonNull
  public QVipBigClubSVIP9Config a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    localQVipBigClubSVIP9Config = new QVipBigClubSVIP9Config();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaeic))
      {
        paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
        if (paramArrayOfaeic.optInt("enable", 1) != 1) {
          break label93;
        }
      }
      for (;;)
      {
        localQVipBigClubSVIP9Config.mIsEnable = bool;
        localQVipBigClubSVIP9Config.mAPngIconUrl = paramArrayOfaeic.optString("apng_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrl);
        localQVipBigClubSVIP9Config.mAPngIconUrlNew_Gray = paramArrayOfaeic.optString("apng_gray_icon_url_pattern", localQVipBigClubSVIP9Config.mAPngIconUrlNew_Gray);
        localQVipBigClubSVIP9Config.mVipIconSettingsUrl = paramArrayOfaeic.optString("vipicon_setting_url_pattern", localQVipBigClubSVIP9Config.mVipIconSettingsUrl);
        return localQVipBigClubSVIP9Config;
        label93:
        bool = false;
      }
      return localQVipBigClubSVIP9Config;
    }
    catch (JSONException paramArrayOfaeic)
    {
      ram.e("QVipBigTroopExpiredProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfaeic.getMessage());
    }
  }
  
  @NonNull
  public QVipBigClubSVIP9Config b()
  {
    return new QVipBigClubSVIP9Config();
  }
  
  public Class<QVipBigClubSVIP9Config> clazz()
  {
    return QVipBigClubSVIP9Config.class;
  }
  
  public int type()
  {
    return 427;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerc
 * JD-Core Version:    0.7.0.1
 */