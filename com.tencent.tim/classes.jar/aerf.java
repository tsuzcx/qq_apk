import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aerf
  extends aeqp<aere>
{
  public static aere c()
  {
    return (aere)aeif.a().o(412);
  }
  
  @NonNull
  public aere a()
  {
    return new aere();
  }
  
  @NonNull
  public aere a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    localaere = new aere();
    try
    {
      if (new JSONObject(paramArrayOfaeic[0].content).optInt("allow_edit_color_nick", 1) == 1) {}
      for (;;)
      {
        localaere.bVV = bool;
        return localaere;
        bool = false;
      }
      return localaere;
    }
    catch (JSONException paramArrayOfaeic)
    {
      ram.e("QVipColorNickProcessor", "QVipColorNickProcessor onParsed exception :" + paramArrayOfaeic.getMessage());
    }
  }
  
  @NonNull
  public aere b()
  {
    return new aere();
  }
  
  public Class<aere> clazz()
  {
    return aere.class;
  }
  
  public int type()
  {
    return 412;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerf
 * JD-Core Version:    0.7.0.1
 */