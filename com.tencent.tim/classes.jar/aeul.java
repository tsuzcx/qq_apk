import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class aeul
{
  private Map<String, Long> jZ = new HashMap();
  
  public static aeul a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    localaeul = new aeul();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      Iterator localIterator = paramArrayOfaeic.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localaeul.jZ.put(str, Long.valueOf(paramArrayOfaeic.getLong(str)));
      }
      return localaeul;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocPreviewConfigBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
    }
  }
  
  public Map<String, Long> ag()
  {
    return this.jZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeul
 * JD-Core Version:    0.7.0.1
 */