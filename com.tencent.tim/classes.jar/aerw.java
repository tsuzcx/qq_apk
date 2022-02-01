import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aerw
  extends aeqp<aerv>
{
  public static aerv a()
  {
    return (aerv)aeif.a().o(413);
  }
  
  @NonNull
  public aerv a(@NonNull aeic[] paramArrayOfaeic)
  {
    aerv localaerv = new aerv();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (paramArrayOfaeic != null) {}
    try
    {
      if (!"".equals(paramArrayOfaeic))
      {
        paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
        localaerv.setUrl(paramArrayOfaeic.getString("url"));
        localaerv.setEnable(paramArrayOfaeic.getBoolean("isEnable"));
        localaerv.Hu(paramArrayOfaeic.getBoolean("hideHotValue"));
      }
      return localaerv;
    }
    catch (JSONException paramArrayOfaeic)
    {
      paramArrayOfaeic.printStackTrace();
    }
    return localaerv;
  }
  
  @NonNull
  public aerv b()
  {
    return new aerv();
  }
  
  @NonNull
  public aerv c()
  {
    return new aerv();
  }
  
  public Class<aerv> clazz()
  {
    return aerv.class;
  }
  
  public int type()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerw
 * JD-Core Version:    0.7.0.1
 */