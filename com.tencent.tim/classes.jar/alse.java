import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class alse
{
  private static final Pattern q = Pattern.compile("@?\\{uin:\\d+,nick(name)?:.*?\\}");
  
  public static newest_feeds_req a(int paramInt, long paramLong1, ArrayList<Long> paramArrayList, long paramLong2, String paramString)
  {
    return new newest_feeds_req(paramInt, paramLong1, paramArrayList, paramLong2, paramString, avpq.getQUA3(), null);
  }
  
  public static newest_feeds_req a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return new newest_feeds_req();
    }
    paramIntent = paramIntent.getSerializableExtra("req");
    if ((paramIntent != null) && ((paramIntent instanceof newest_feeds_req))) {
      return (newest_feeds_req)paramIntent;
    }
    return new newest_feeds_req();
  }
  
  public static Intent a(Intent paramIntent, newest_feeds_req paramnewest_feeds_req)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("req", paramnewest_feeds_req);
    return localIntent;
  }
  
  public static String e(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      localObject = null;
    }
    Matcher localMatcher;
    do
    {
      return localObject;
      localMatcher = q.matcher(paramString);
      localObject = paramString;
    } while (!localMatcher.find());
    String str2 = localMatcher.group();
    String str3 = mU(str2);
    String str1 = "";
    Object localObject = str1;
    if (!TextUtils.isEmpty(str3))
    {
      acff localacff = (acff)paramQQAppInterface.getManager(51);
      localObject = str1;
      if (localacff != null)
      {
        localObject = localacff.e(str3);
        if (localObject == null) {
          break label153;
        }
      }
    }
    label151:
    label153:
    for (localObject = ((Friends)localObject).getFriendNickWithAlias();; localObject = "")
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = mV(str2);
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label151;
        }
        paramString = paramString.replace(str2, "@" + (String)localObject + " ");
        break;
      }
      break;
    }
  }
  
  public static ArrayList<Long> h(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface == null) {
      return null;
    }
    Object localObject = paramQQAppInterface.cq();
    if (localObject != null)
    {
      paramQQAppInterface = new ArrayList(((ArrayList)localObject).size());
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        if ((localFriends != null) && (Friends.isValidUin(localFriends.uin))) {
          paramQQAppInterface.add(Long.valueOf(Long.parseLong(localFriends.uin)));
        }
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      paramQQAppInterface = null;
    }
  }
  
  public static String mU(String paramString)
  {
    if ("".equals(paramString)) {}
    int j;
    int i;
    do
    {
      return null;
      int k = paramString.indexOf("uin:");
      j = paramString.indexOf(",");
      i = 0;
      if (k != -1) {
        i = k + 4;
      }
    } while ((i == 0) || (j == -1));
    return paramString.substring(i, j);
  }
  
  public static String mV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    int i;
    do
    {
      return null;
      int k = paramString.indexOf(",nick:");
      j = paramString.indexOf("}");
      i = 0;
      if (k != -1) {
        i = k + 6;
      }
    } while ((j == -1) || (i == 0));
    return paramString.substring(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alse
 * JD-Core Version:    0.7.0.1
 */