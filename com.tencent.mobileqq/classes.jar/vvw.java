import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

public class vvw
{
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static List<QQCircleReport.SingleDcData> a(List<byte[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleReport.SingleDcData localSingleDcData = a((byte[])paramList.next());
      if (localSingleDcData != null) {
        localArrayList.add(localSingleDcData);
      }
    }
    return localArrayList;
  }
  
  public static QQCircleReport.SingleDcData a(byte[] paramArrayOfByte)
  {
    try
    {
      QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
      localSingleDcData.mergeFrom(paramArrayOfByte);
      return localSingleDcData;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvw
 * JD-Core Version:    0.7.0.1
 */