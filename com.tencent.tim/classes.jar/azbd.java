import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azbd
{
  public String uin;
  public int uinType;
  public long uniseq;
  
  public static List<azbd> bt(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split(";");
    if ((paramString == null) || (paramString.length == 0)) {
      return localArrayList;
    }
    int j = paramString.length;
    int i = 0;
    label31:
    CharSequence localCharSequence;
    if (i < j)
    {
      localCharSequence = paramString[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label31;
      break;
      label56:
      azbd localazbd = new azbd();
      localazbd.adN(localCharSequence);
      localArrayList.add(localazbd);
    }
  }
  
  public static String listToString(List<azbd> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((azbd)paramList.next()).IE()).append(";");
    }
    return localStringBuilder.toString();
  }
  
  public String IE()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.uin).append("_").append(this.uinType).append("_").append(this.uniseq);
    return localStringBuilder.toString();
  }
  
  public void adN(String paramString)
  {
    String[] arrayOfString = paramString.split("_");
    if (arrayOfString.length != 3) {
      throw new IllegalArgumentException(paramString + " illegal MessageBaseData!");
    }
    this.uin = arrayOfString[0];
    this.uinType = Integer.valueOf(arrayOfString[1]).intValue();
    this.uniseq = Long.valueOf(arrayOfString[2]).longValue();
  }
  
  public boolean g(String paramString, int paramInt, long paramLong)
  {
    return (this.uin.equals(paramString)) && (this.uinType == paramInt) && (this.uniseq == paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azbd
 * JD-Core Version:    0.7.0.1
 */