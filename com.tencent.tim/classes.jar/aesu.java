import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aesu
{
  private int cOO;
  private int cOP;
  private int cOQ = 1;
  
  public static aesu a(aeic paramaeic)
  {
    aesu localaesu = new aesu();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SearchHotWordConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    try
    {
      paramaeic = new JSONObject(paramaeic.content);
      localaesu.Mc(paramaeic.optInt("hotword_switch_message", 0));
      localaesu.Md(paramaeic.optInt("hotword_switch_contact", 0));
      localaesu.Me(paramaeic.optInt("hotword_switch_dongtai", 1));
      return localaesu;
    }
    catch (Exception paramaeic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SearchHotWordConfBean", 2, "parse error->" + paramaeic.toString());
    }
    return localaesu;
  }
  
  void Mc(int paramInt)
  {
    this.cOO = paramInt;
  }
  
  void Md(int paramInt)
  {
    this.cOP = paramInt;
  }
  
  void Me(int paramInt)
  {
    this.cOQ = paramInt;
  }
  
  public boolean ahD()
  {
    return this.cOO == 1;
  }
  
  public boolean ahE()
  {
    return this.cOP == 1;
  }
  
  public boolean ahF()
  {
    return this.cOQ == 1;
  }
  
  public String toString()
  {
    return String.format("mHotWordSwitchTabMessage:%d, mHotWordSwitchTabContact:%d, mHotWordSwitchTabDongtai:%d", new Object[] { Integer.valueOf(this.cOO), Integer.valueOf(this.cOP), Integer.valueOf(this.cOQ) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesu
 * JD-Core Version:    0.7.0.1
 */