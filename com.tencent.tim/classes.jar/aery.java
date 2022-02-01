import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aery
  extends aeqp<aerx>
{
  public static aerx a()
  {
    return (aerx)aeif.a().o(563);
  }
  
  @NonNull
  public aerx a(@NonNull aeic[] paramArrayOfaeic)
  {
    aerx localaerx = new aerx();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (paramArrayOfaeic != null) {}
    try
    {
      if (!"".equals(paramArrayOfaeic))
      {
        paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
        localaerx.bAK = paramArrayOfaeic.getString("musicBoxUrl");
        localaerx.bAL = paramArrayOfaeic.getString("playerUrl");
      }
      return localaerx;
    }
    catch (JSONException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
    return localaerx;
  }
  
  @NonNull
  public aerx b()
  {
    return new aerx();
  }
  
  @NonNull
  public aerx c()
  {
    return new aerx();
  }
  
  public Class<aerx> clazz()
  {
    return aerx.class;
  }
  
  public int type()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aery
 * JD-Core Version:    0.7.0.1
 */