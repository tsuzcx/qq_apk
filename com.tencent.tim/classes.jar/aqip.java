import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class aqip
{
  private static ThreadLocal<LinkedList<Long>> sBeginTimeList = new ThreadLocal();
  
  public static void beginPile()
  {
    if (QLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)sBeginTimeList.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        sBeginTimeList.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void bj(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("PreUploadVideo");
      localStringBuilder.append("[").append(paramString1).append("] ");
      if (paramString2 != null) {
        localStringBuilder.append("status:").append(paramString2).append(" ");
      }
      localStringBuilder.append("content:").append(paramString3);
      QLog.i("PreUploadVideo", 2, localStringBuilder.toString());
    }
  }
  
  public static void endPile(String paramString1, String paramString2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = (LinkedList)sBeginTimeList.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        sBeginTimeList.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int i = 1;
      while (i < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        i += 1;
      }
      if (((LinkedList)sBeginTimeList.get()).size() != 0) {}
    }
    else
    {
      return;
    }
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(":cost ");
    ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)sBeginTimeList.get()).removeFirst()).longValue());
    ((StringBuilder)localObject2).append("ms");
    QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqip
 * JD-Core Version:    0.7.0.1
 */