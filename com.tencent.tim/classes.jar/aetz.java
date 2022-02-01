import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aetz
{
  private int cPj = -1;
  
  public static aetz a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      paramArrayOfaeic = null;
    }
    aetz localaetz;
    do
    {
      return paramArrayOfaeic;
      localaetz = new aetz();
      try
      {
        localaetz.cPj = new JSONObject(paramArrayOfaeic[0].content).getInt("show_limit");
        return localaetz;
      }
      catch (JSONException localJSONException)
      {
        paramArrayOfaeic = localaetz;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TencentDocHistoryTabToastBean", 1, "exception = " + localJSONException.toString());
    return localaetz;
  }
  
  public int Cz()
  {
    return this.cPj;
  }
  
  public boolean ahX()
  {
    return this.cPj == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetz
 * JD-Core Version:    0.7.0.1
 */