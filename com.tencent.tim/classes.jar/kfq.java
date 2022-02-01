import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class kfq
{
  private static ExecutorService n;
  
  public static void ma(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (n == null) {
      n = Executors.newFixedThreadPool(1);
    }
    n.execute(new KandianUGStatisticUtils.1(paramString));
  }
  
  public static String o(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1.replace("ARTICLE_ID", paramString2).replace("USER_QQ", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin()).replace("ACTION_TYPE", paramString3);
    Log.d("DE_KUAIB", paramString2 + "|" + paramString3);
    return paramString1;
  }
  
  public static String p(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.contains("?")) {
      return paramString1 + "&acttype=" + paramString2 + "&subpos=" + paramString3;
    }
    return paramString1 + "?acttype=" + paramString2 + "&subpos=" + paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfq
 * JD-Core Version:    0.7.0.1
 */