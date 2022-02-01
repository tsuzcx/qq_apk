import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class kzf
  implements AladdinConfigHandler
{
  private static final Set<String> P = ;
  
  private static Set<String> k()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (String)awit.f("default_feeds_aladdin_keys", "");
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
  
  public static Set<String> l()
  {
    return P;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("WhiteListBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = kye.i(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("WhiteListBidConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      awit.H("default_feeds_aladdin_keys", str2);
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("WhiteListBidConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzf
 * JD-Core Version:    0.7.0.1
 */