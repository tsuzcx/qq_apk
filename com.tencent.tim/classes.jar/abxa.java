import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class abxa
{
  public int ctl;
  public boolean isEnd;
  public Map<Integer, Long> je;
  public BlockingQueue<abwx> l;
  public abwz result;
  public long serverTime;
  public long startTime;
  public long timestamp;
  
  public abxa(int paramInt)
  {
    this.ctl = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{").append("spanId:").append(this.ctl).append(",result:").append(this.result);
    Iterator localIterator;
    if (this.je != null)
    {
      localStringBuilder.append(",extra:[");
      localIterator = this.je.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel()) {
          localStringBuilder.append("{").append(localEntry.getKey()).append(",").append(localEntry.getValue()).append("}");
        } else {
          localStringBuilder.append("{").append(localEntry.getKey()).append("}");
        }
      }
      localStringBuilder.append("]");
    }
    if (this.l != null)
    {
      localStringBuilder.append(",anno:[");
      localIterator = this.l.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((abwx)localIterator.next()).toString());
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abxa
 * JD-Core Version:    0.7.0.1
 */