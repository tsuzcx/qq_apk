import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class ambr
  implements Manager
{
  QQAppInterface mApp;
  private HashMap<Long, ambw> mL = new HashMap();
  
  public ambr(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static ambr a(QQAppInterface paramQQAppInterface)
  {
    return (ambr)paramQQAppInterface.getManager(294);
  }
  
  public ambw a(long paramLong, int paramInt)
  {
    try
    {
      ambw localambw2 = (ambw)this.mL.get(Long.valueOf(paramLong));
      ambw localambw1 = localambw2;
      if (localambw2 == null)
      {
        localambw1 = new ambw(paramLong);
        localambw1.mApp = this.mApp;
        localambw1.dBF = paramInt;
        this.mL.put(Long.valueOf(paramLong), localambw1);
      }
      return localambw1;
    }
    finally {}
  }
  
  public void a(ambw paramambw)
  {
    try
    {
      this.mL.remove(Long.valueOf(paramambw.mSeed));
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    try
    {
      Iterator localIterator = this.mL.values().iterator();
      while (localIterator.hasNext()) {
        ((ambw)localIterator.next()).bme();
      }
      this.mL.clear();
    }
    finally {}
    this.mApp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambr
 * JD-Core Version:    0.7.0.1
 */