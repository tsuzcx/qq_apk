import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class armz
{
  public int jumpType = 4;
  public String jumpUrl = "";
  
  public static armz a(QQAppInterface paramQQAppInterface)
  {
    armz localarmz = new armz();
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    int i = arna.bJ(localBaseApplication, paramQQAppInterface);
    if (i == 1)
    {
      localarmz.jumpType = 1;
      localarmz.jumpUrl = an(localBaseApplication, paramQQAppInterface);
      return localarmz;
    }
    if (i == 2)
    {
      localarmz.jumpType = 2;
      return localarmz;
    }
    if ((!arnb.isWifiEnabled(localBaseApplication)) || (!arnb.cm(localBaseApplication)) || (!arnb.cn(localBaseApplication)))
    {
      if (i == 3)
      {
        localarmz.jumpType = 3;
        localarmz.jumpUrl = an(localBaseApplication, paramQQAppInterface);
        return localarmz;
      }
      localarmz.jumpType = 5;
      return localarmz;
    }
    localarmz.jumpType = 4;
    return localarmz;
  }
  
  public static String an(Context paramContext, String paramString)
  {
    paramString = arna.ap(paramContext, paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://sdi.3g.qq.com/v/2018082711463211194";
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armz
 * JD-Core Version:    0.7.0.1
 */