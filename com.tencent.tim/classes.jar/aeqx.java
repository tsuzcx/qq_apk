import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.QQFriendRelation2Config;
import org.json.JSONException;
import org.json.JSONObject;

public class aeqx
  extends aeqp<QQFriendRelation2Config>
{
  public static QQFriendRelation2Config c()
  {
    QQFriendRelation2Config localQQFriendRelation2Config2 = (QQFriendRelation2Config)aeif.a().o(491);
    QQFriendRelation2Config localQQFriendRelation2Config1 = localQQFriendRelation2Config2;
    if (localQQFriendRelation2Config2 == null) {
      localQQFriendRelation2Config1 = new QQFriendRelation2Config();
    }
    return localQQFriendRelation2Config1;
  }
  
  @NonNull
  public QQFriendRelation2Config a()
  {
    return new QQFriendRelation2Config();
  }
  
  @NonNull
  public QQFriendRelation2Config a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    localQQFriendRelation2Config = new QQFriendRelation2Config();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfaeic)) {
        if (new JSONObject(paramArrayOfaeic).optInt("enable", 1) != 1) {
          break label49;
        }
      }
      for (;;)
      {
        localQQFriendRelation2Config.mIsEnable = bool;
        return localQQFriendRelation2Config;
        label49:
        bool = false;
      }
      return localQQFriendRelation2Config;
    }
    catch (JSONException paramArrayOfaeic)
    {
      ram.e("QQFriendRelation2Processor", "QQFriendRelation2Config onParsed exception :" + paramArrayOfaeic.getMessage());
    }
  }
  
  @NonNull
  public QQFriendRelation2Config b()
  {
    return new QQFriendRelation2Config();
  }
  
  public Class<QQFriendRelation2Config> clazz()
  {
    return QQFriendRelation2Config.class;
  }
  
  public int type()
  {
    return 491;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeqx
 * JD-Core Version:    0.7.0.1
 */