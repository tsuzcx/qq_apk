import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class abgw
{
  private static abgw a;
  private Map<Long, abgw.a> iO = new HashMap();
  private Map<Long, Long> iP = new HashMap();
  
  public static abgw a()
  {
    if (a == null) {
      a = new abgw();
    }
    return a;
  }
  
  public int N(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.iO.containsKey(Long.valueOf(paramLong)))
    {
      abgw.a locala = (abgw.a)this.iO.get(Long.valueOf(paramLong));
      if (l - locala.Nm < 3600000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "Found from local cache, the fraud flag is true");
        }
        return locala.coy;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AntiFraud", 4, "Found from local cache, timestamp is out of data");
      }
      this.iO.remove(Long.valueOf(paramLong));
      return 0;
    }
    if (this.iP.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((Long)this.iP.get(Long.valueOf(paramLong))).longValue() < 43200000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "Found from local cache, the fraud flag is false");
        }
        return 0;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AntiFraud", 4, "Found from local cache, timestamp is out of data");
      }
      this.iP.remove(Long.valueOf(paramLong));
      return 0;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AntiFraud", 4, "use default value, false");
    }
    return 0;
  }
  
  public void ar(long paramLong, int paramInt)
  {
    long l = System.currentTimeMillis();
    abgw.a locala = new abgw.a();
    locala.coy = paramInt;
    locala.Nm = l;
    if (this.iO.size() > 500) {
      this.iO.clear();
    }
    this.iO.put(Long.valueOf(paramLong), locala);
    if (this.iP.containsKey(Long.valueOf(paramLong))) {
      this.iP.remove(Long.valueOf(paramLong));
    }
  }
  
  public boolean bB(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.iO.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((abgw.a)this.iO.get(Long.valueOf(paramLong))).Nm > 3600000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "FraudUin, Found from local cache, timestamp is out of data");
        }
        this.iO.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
    if (this.iP.containsKey(Long.valueOf(paramLong)))
    {
      if (l - ((Long)this.iP.get(Long.valueOf(paramLong))).longValue() > 43200000L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AntiFraud", 4, "NonFraudUin, Found from local cache, timestamp is out of data");
        }
        this.iP.remove(Long.valueOf(paramLong));
        return true;
      }
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AntiFraud", 4, "Out of date, use default value, true!");
    }
    return true;
  }
  
  public void gO(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (this.iP.size() > 500) {
      this.iP.clear();
    }
    this.iP.put(Long.valueOf(paramLong), Long.valueOf(l));
    if (this.iO.containsKey(Long.valueOf(paramLong))) {
      this.iO.remove(Long.valueOf(paramLong));
    }
  }
  
  class a
  {
    public long Nm;
    public int coy;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgw
 * JD-Core Version:    0.7.0.1
 */