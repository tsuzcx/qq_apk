import android.support.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aerh
  extends aeqp<aerg>
{
  static aerg a = new aerg();
  
  public static aerg c()
  {
    aerg localaerg2 = (aerg)aeif.a().o(444);
    aerg localaerg1 = localaerg2;
    if (localaerg2 == null) {
      localaerg1 = a;
    }
    return localaerg1;
  }
  
  @NonNull
  public aerg a()
  {
    return a;
  }
  
  @NonNull
  public aerg a(@NonNull aeic[] paramArrayOfaeic)
  {
    aerg localaerg = new aerg();
    int m = paramArrayOfaeic.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject = paramArrayOfaeic[i];
      if (j > ((aeic)localObject).taskId)
      {
        i += 1;
      }
      else
      {
        int k = ((aeic)localObject).taskId;
        j = k;
        for (;;)
        {
          try
          {
            if (paramArrayOfaeic[0].content == null) {
              break;
            }
            localObject = new JSONObject(paramArrayOfaeic[0].content);
            localaerg.enable = ((JSONObject)localObject).optBoolean("enable", false);
            if (((JSONObject)localObject).optInt("dltc", 0) != 1) {
              break label166;
            }
            bool = true;
            localaerg.bVW = bool;
            j = k;
          }
          catch (JSONException localJSONException)
          {
            ram.e("QVipDiyTemplateProcessor", "parsed : " + paramArrayOfaeic[0].content + " error:" + localJSONException);
            j = k;
          }
          break;
          label166:
          boolean bool = false;
        }
      }
    }
    return localaerg;
  }
  
  @NonNull
  public aerg b()
  {
    return a;
  }
  
  public Class<aerg> clazz()
  {
    return aerg.class;
  }
  
  public int type()
  {
    return 444;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aerh
 * JD-Core Version:    0.7.0.1
 */