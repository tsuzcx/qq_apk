import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class lrm
{
  public static String R(String paramString1, String paramString2)
  {
    QLog.d("PGCShortContentUtils", 1, "getJumpType: " + paramString1 + " recommendType: " + paramString2);
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      QLog.d("PGCShortContentUtils", 1, "getJumpType result is: " + paramString2);
      return paramString2;
      paramString2 = eK(paramString1);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (dM(paramString1)) {
          paramString2 = "6";
        }
      }
      else if ((paramString1.startsWith("http:")) || (paramString1.startsWith("https:"))) {
        paramString2 = paramString1;
      } else {
        paramString2 = "-1";
      }
    }
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo)
  {
    b(paramContext, paramArticleInfo, false);
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    QLog.d("PGCShortContentUtils", 1, "redirectToOtherPage " + paramArticleInfo + " isComment: " + paramBoolean);
    if (paramArticleInfo == null)
    {
      QLog.d("PGCShortContentUtils", 1, "articleInfo is null");
      return;
    }
    if (paramArticleInfo.isCardJumpUrlAvailable == 1)
    {
      paramArticleInfo.click_jump_target = R(paramArticleInfo.getCardJumpUrl(), "-1");
      kxm.C(paramContext, paramArticleInfo.getCardJumpUrl());
      return;
    }
    paramArticleInfo.click_jump_target = R(kwt.acD, "-1");
    kxm.a(paramContext, paramArticleInfo, paramBoolean);
  }
  
  public static boolean dM(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = aqik.c(kxm.a(), BaseApplicationImpl.getContext(), paramString);
      if (localObject != null)
      {
        localObject = ((aqhv)localObject).attrs;
        if ((localObject != null) && ("6".equals((String)((Map)localObject).get("target"))) && (((Map)localObject).containsKey("v_url_base64"))) {
          return true;
        }
      }
      return ntp.ek(ntp.fd(paramString));
    }
    return false;
  }
  
  private static String eK(String paramString)
  {
    paramString = aqik.c(kxm.a(), BaseApplicationImpl.getContext(), paramString);
    if (paramString != null)
    {
      paramString = paramString.attrs;
      if (paramString != null)
      {
        paramString = (String)paramString.get("target");
        if (!TextUtils.isEmpty(paramString)) {
          return paramString;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrm
 * JD-Core Version:    0.7.0.1
 */