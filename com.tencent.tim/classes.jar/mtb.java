import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mtb
{
  public static HashMap<Integer, Long> eg = new HashMap();
  public static HashMap<Integer, ArrayList<mtb.a>> eh = new HashMap();
  
  public static void aRR()
  {
    Iterator localIterator = eg.keySet().iterator();
    long l = System.currentTimeMillis();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((Long)eg.get(localInteger)).longValue() < l - 60000L)
      {
        eh.remove(localInteger);
        localIterator.remove();
      }
    }
  }
  
  public static JSONArray j()
  {
    try
    {
      aRR();
      JSONArray localJSONArray1 = new JSONArray();
      Iterator localIterator = eh.keySet().iterator();
      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
      localNumberFormat.setMaximumFractionDigits(2);
      localNumberFormat.setMinimumFractionDigits(2);
      localNumberFormat.setRoundingMode(RoundingMode.HALF_UP);
      localNumberFormat.setGroupingUsed(false);
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        localObject = ((ArrayList)eh.get(localObject)).iterator();
        while (((Iterator)localObject).hasNext())
        {
          mtb.a locala = (mtb.a)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("downloadTime", new Float(localNumberFormat.format(Math.round(locala.jK * 100.0F) / 100.0F)));
            localJSONObject.put("speedList", locala.speed);
            localJSONArray1.put(localJSONObject);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    finally {}
    return localJSONArray2;
  }
  
  static class a
  {
    float jK;
    long speed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtb
 * JD-Core Version:    0.7.0.1
 */