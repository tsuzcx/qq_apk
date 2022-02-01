import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzh
  implements AladdinConfigHandler
{
  private static final Set<String> R = ;
  
  private static Set<String> o()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (String)awit.f("native_feeds_aladdin_keys", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localHashSet;
    }
    localObject = ((String)localObject).split("\\|");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(localObject[i]);
      i += 1;
    }
    return localHashSet;
  }
  
  public static Set<String> p()
  {
    String str = kqc.iD();
    QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 2, "getNativeFeedsAlladinKey | operationBarAladdinKey : " + str);
    if ((R != null) && (!TextUtils.isEmpty(str))) {
      R.add(str);
    }
    return R;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ("native_article_aladdin_keys".equalsIgnoreCase(str1))
      {
        String str2 = (String)paramString.get(str1);
        QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
        awit.H("native_feeds_aladdin_keys", str2);
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzh
 * JD-Core Version:    0.7.0.1
 */