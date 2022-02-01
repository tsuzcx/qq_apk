import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aess
{
  private int cOL = 1;
  private int cOM = 1;
  private int cON = 1;
  
  public static aess a(aeic paramaeic)
  {
    aess localaess = new aess();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchBusinessConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    try
    {
      paramaeic = new JSONObject(paramaeic.content);
      localaess.LZ(paramaeic.optInt("business_switch_message", 1));
      localaess.Ma(paramaeic.optInt("business_switch_contact", 1));
      localaess.Mb(paramaeic.optInt("business_switch_dongtai", 1));
      return localaess;
    }
    catch (Exception paramaeic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchBusinessConfBean", 2, "parse error->" + paramaeic.toString());
    }
    return localaess;
  }
  
  void LZ(int paramInt)
  {
    this.cOL = paramInt;
  }
  
  void Ma(int paramInt)
  {
    this.cOM = paramInt;
  }
  
  void Mb(int paramInt)
  {
    this.cON = paramInt;
  }
  
  public boolean ahA()
  {
    return this.cOL == 1;
  }
  
  public boolean ahB()
  {
    return this.cOM == 1;
  }
  
  public boolean ahC()
  {
    return this.cON == 1;
  }
  
  public String toString()
  {
    return String.format("mBusinessSwitchTabMessage:%d, mBusinessSwitchTabContact:%d, mBusinessSwitchTabDongtai:%d", new Object[] { Integer.valueOf(this.cOL), Integer.valueOf(this.cOM), Integer.valueOf(this.cON) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aess
 * JD-Core Version:    0.7.0.1
 */