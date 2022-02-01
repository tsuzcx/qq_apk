import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aesq
{
  private String bAU = "";
  private int cOK = 1;
  
  public static aesq a()
  {
    return (aesq)aeif.a().o(460);
  }
  
  public static aesq a(aeic paramaeic)
  {
    aesq localaesq = new aesq();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    try
    {
      paramaeic = new JSONObject(paramaeic.content);
      int i = paramaeic.optInt("robotswitch", 0);
      paramaeic = paramaeic.optString("c2cwarning", "");
      localaesq.LY(i);
      localaesq.Hu(paramaeic);
      return localaesq;
    }
    catch (JSONException paramaeic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaeic.toString());
    }
    return localaesq;
  }
  
  public void Hu(String paramString)
  {
    this.bAU = paramString;
  }
  
  void LY(int paramInt)
  {
    this.cOK = paramInt;
  }
  
  public boolean ahz()
  {
    return this.cOK == 1;
  }
  
  public String tK()
  {
    return this.bAU;
  }
  
  public String toString()
  {
    return String.format("mTroopRobotSwitch:%d", new Object[] { Integer.valueOf(this.cOK) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesq
 * JD-Core Version:    0.7.0.1
 */