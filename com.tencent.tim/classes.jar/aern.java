import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aern
  extends aeqp<aerm>
{
  @NonNull
  public aerm a()
  {
    return new aerm();
  }
  
  @NonNull
  public aerm a(aeic[] paramArrayOfaeic)
  {
    boolean bool = true;
    localaerm = new aerm();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
      if (paramArrayOfaeic.optInt("is_show_recover_entry", 1) == 1) {}
      for (;;)
      {
        localaerm.bVY = bool;
        localaerm.bAB = paramArrayOfaeic.optString("recover_text", localaerm.bAB);
        localaerm.bAC = paramArrayOfaeic.optString("recover_url", localaerm.bAC);
        return localaerm;
        bool = false;
      }
      return localaerm;
    }
    catch (JSONException paramArrayOfaeic)
    {
      ram.e("QVipFriendTagProcessor", "QVipFriendTagConfig onParsed exception :" + paramArrayOfaeic.getMessage());
    }
  }
  
  @NonNull
  public aerm b()
  {
    return new aerm();
  }
  
  public Class<aerm> clazz()
  {
    return aerm.class;
  }
  
  public int type()
  {
    return 409;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aern
 * JD-Core Version:    0.7.0.1
 */