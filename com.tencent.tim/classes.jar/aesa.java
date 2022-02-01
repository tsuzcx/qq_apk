import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aesa
  extends aeqp<aerz>
{
  public static final aerz a = new aerz();
  
  @NonNull
  public aerz a()
  {
    return a;
  }
  
  @NonNull
  public aerz a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    localaerz = new aerz();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    try
    {
      if (new JSONObject(paramArrayOfaeic).optInt("show_red_name_card", 0) == 1) {}
      for (;;)
      {
        localaerz.bWd = bool;
        return localaerz;
        bool = false;
      }
      return localaerz;
    }
    catch (JSONException paramArrayOfaeic)
    {
      ram.e("QVipRedNameCardProcessor", "QVipRedNameCardConfig onParsed exception :" + paramArrayOfaeic.getMessage());
    }
  }
  
  @NonNull
  public aerz b()
  {
    return a;
  }
  
  public Class<aerz> clazz()
  {
    return aerz.class;
  }
  
  public int type()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesa
 * JD-Core Version:    0.7.0.1
 */