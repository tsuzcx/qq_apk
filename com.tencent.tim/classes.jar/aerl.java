import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aerl
  extends aeqp<aerk>
{
  public static aerk c()
  {
    aerk localaerk2 = (aerk)aeif.a().o(469);
    aerk localaerk1 = localaerk2;
    if (localaerk2 == null) {
      localaerk1 = new aerk();
    }
    return localaerk1;
  }
  
  @NonNull
  public aerk a()
  {
    return new aerk();
  }
  
  @NonNull
  public aerk a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    localaerk = new aerk();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
      if (paramArrayOfaeic.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaerk.bVY = bool;
        localaerk.bAB = paramArrayOfaeic.optString("recover_text", localaerk.bAB);
        localaerk.bAC = paramArrayOfaeic.optString("recover_url", localaerk.bAC);
        localaerk.bAD = paramArrayOfaeic.optString("recoveryHomePageUrl", localaerk.bAD);
        return localaerk;
        bool = false;
      }
      return localaerk;
    }
    catch (JSONException paramArrayOfaeic)
    {
      ram.e("QVipFriendTag2Processor", "QVipFriendTag2Config onParsed exception :" + paramArrayOfaeic.getMessage());
    }
  }
  
  @NonNull
  public aerk b()
  {
    return new aerk();
  }
  
  public Class<aerk> clazz()
  {
    return aerk.class;
  }
  
  public int type()
  {
    return 469;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerl
 * JD-Core Version:    0.7.0.1
 */