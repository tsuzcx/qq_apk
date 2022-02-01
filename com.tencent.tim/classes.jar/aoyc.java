import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.Collection;
import java.util.Iterator;

public class aoyc
{
  public static String b(Collection<TroopAIOAppInfo> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (aoyb.isEmpty(paramCollection))
    {
      localStringBuilder.append("empty apps");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("[gray+ red*]");
    paramCollection = paramCollection.iterator();
    label41:
    TroopAIOAppInfo localTroopAIOAppInfo;
    if (paramCollection.hasNext())
    {
      localTroopAIOAppInfo = (TroopAIOAppInfo)paramCollection.next();
      if (localTroopAIOAppInfo.isGray) {
        localStringBuilder.append("+");
      }
      if (localTroopAIOAppInfo.redPoint) {
        localStringBuilder.append("*");
      }
      if (TextUtils.isEmpty(localTroopAIOAppInfo.name)) {
        break label117;
      }
      localStringBuilder.append(localTroopAIOAppInfo.name);
    }
    for (;;)
    {
      localStringBuilder.append(" ");
      break label41;
      break;
      label117:
      localStringBuilder.append("id:");
      localStringBuilder.append(localTroopAIOAppInfo.appid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoyc
 * JD-Core Version:    0.7.0.1
 */