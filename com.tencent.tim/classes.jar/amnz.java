import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class amnz
  extends acfm
{
  amnz(amnv paramamnv) {}
  
  public void b(boolean paramBoolean, ArrayList<ArrayList<String>> paramArrayList, ArrayList<String> paramArrayList1)
  {
    super.b(paramBoolean, paramArrayList, paramArrayList1);
    paramArrayList1 = (String)paramArrayList1.get(0);
    StringBuilder localStringBuilder = new StringBuilder(64);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = ((ArrayList)paramArrayList.get(0)).iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (String)paramArrayList.next();
        if (((String)localObject).charAt(0) < '')
        {
          localObject = aqoe.A((String)localObject);
          if ((localObject != null) && (localObject.length > 0))
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              localStringBuilder.append(localObject[i]).append(" ");
              i += 1;
            }
          }
        }
        else
        {
          localStringBuilder.append((String)localObject).append(" ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FTSMessageSearchEngine", 2, "svcSeg result = [" + localStringBuilder.toString().trim() + "]");
      }
    }
    amnv.a(this.this$0).put(paramArrayList1, localStringBuilder);
    paramArrayList = amnv.b(this.this$0).get(paramArrayList1);
    if (paramArrayList != null) {
      try
      {
        paramArrayList.notify();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amnz
 * JD-Core Version:    0.7.0.1
 */