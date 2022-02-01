import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aekf
{
  public boolean bUA = true;
  public int cNF = 3;
  
  public static aekf a(aeic paramaeic)
  {
    boolean bool = true;
    aekf localaekf = new aekf();
    if (paramaeic != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaeic.taskId + " content->" + paramaeic.content);
      }
    }
    for (;;)
    {
      try
      {
        paramaeic = new JSONObject(paramaeic.content);
        if (paramaeic.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localaekf.bUA = bool;
        localaekf.cNF = paramaeic.optInt("prepareCount", 3);
      }
      catch (Exception paramaeic)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaeic.toString());
      }
      return localaekf;
      bool = false;
    }
    return localaekf;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.bUA + " prepareCount:" + this.cNF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekf
 * JD-Core Version:    0.7.0.1
 */