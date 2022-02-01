import android.text.TextUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class awdi
{
  public static List<String> A(String paramString, int paramInt)
  {
    int i = 0;
    paramString = LocalMultiProcConfig.getString(paramString, "").split(";");
    LinkedList localLinkedList = new LinkedList();
    if ((paramString.length == 0) || (paramInt <= 0)) {
      return localLinkedList;
    }
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        k = j;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          localLinkedList.add(localCharSequence);
          k = j + 1;
        }
        if (k != paramInt) {}
      }
      else
      {
        return localLinkedList;
      }
      i += 1;
    }
  }
  
  public static void V(String paramString, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    List localList = A(paramString, 500 - paramList.size());
    localLinkedList.addAll(paramList);
    localLinkedList.addAll(localList);
    LocalMultiProcConfig.putString(paramString, aa(localLinkedList));
  }
  
  private static String aa(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(";");
    }
    return localStringBuilder.toString();
  }
  
  public static List<String> bq(String paramString)
  {
    return A(paramString, 500);
  }
  
  public static void jw(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    List localList;
    do
    {
      return;
      localList = A(paramString1, 500);
    } while (localList.contains(paramString2));
    localList.add(0, paramString2);
    if (localList.size() > 500) {
      localList.remove(500);
    }
    LocalMultiProcConfig.putString(paramString1, aa(localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awdi
 * JD-Core Version:    0.7.0.1
 */