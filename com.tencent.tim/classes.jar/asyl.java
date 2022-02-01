import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asyl
{
  private List<asyu> Ke = new ArrayList();
  private List<String> Kf = new ArrayList();
  private int eob;
  private long mInterval = 3600L;
  private String mType = "";
  
  public asyl(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        this.mType = paramJSONObject.getString("type");
        long l = paramJSONObject.getLong("interval");
        if ((l > 0L) && (l < 604800L)) {
          this.mInterval = l;
        }
        Object localObject = paramJSONObject.getJSONArray("filter");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            if (localJSONObject == null) {
              break label248;
            }
            this.Ke.add(new asyu(localJSONObject));
            break label248;
          }
        }
        if (paramJSONObject.has("rpt"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("rpt");
          if (paramJSONObject != null)
          {
            i = paramJSONObject.getInt("id");
            if (i > 100000)
            {
              this.eob = i;
              paramJSONObject = paramJSONObject.getJSONArray("fields");
              if (paramJSONObject != null)
              {
                i = j;
                if (i < paramJSONObject.length())
                {
                  localObject = paramJSONObject.getString(i);
                  if ((localObject != null) && (!((String)localObject).isEmpty())) {
                    this.Kf.add(localObject);
                  }
                  i += 1;
                  continue;
                }
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      label248:
      i += 1;
    }
  }
  
  public int NZ()
  {
    return this.eob;
  }
  
  public boolean f(Object paramObject)
  {
    if (!this.Ke.isEmpty())
    {
      Iterator localIterator = this.Ke.iterator();
      while (localIterator.hasNext())
      {
        asyu localasyu = (asyu)localIterator.next();
        if (!localasyu.isValid()) {
          return false;
        }
        if (!localasyu.f(paramObject)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public long getInterval()
  {
    return this.mInterval;
  }
  
  public List<String> hb()
  {
    return this.Kf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyl
 * JD-Core Version:    0.7.0.1
 */