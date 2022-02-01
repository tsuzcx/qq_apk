package c.t.m.g;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.map.geolocation.TencentPoi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class br
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public bw c;
  
  br() {}
  
  public br(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new bw(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              bv localbv = new bv(paramJSONObject.getJSONObject(i));
              this.b.add(localbv);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = bw.a;
              new StringBuilder("DetailsData: unknown json ").append(paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject) {}
      }
    }
  }
  
  private static bw a(@Nullable JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    bw localbw;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localbw = bw.a(bw.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localbw.b = ((JSONObject)localObject1).optString("n");
        localbw.e = ((JSONObject)localObject1).optString("p");
        localbw.f = ((JSONObject)localObject1).optString("c");
        localbw.g = ((JSONObject)localObject1).optString("d");
        localbw.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localbw.m.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localbw.m.putParcelable("addrdesp.landmark", new bq((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localbw.m.putParcelable("addrdesp.second_landmark", new bq((JSONObject)localObject1));
        }
      }
      localObject1 = localbw;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new bq(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((bq)localObject2).b)) {
        localbw.j = ((bq)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((bq)localObject2).b)) {
          localbw.k = ((bq)localObject2).a;
        }
      }
    }
    localbw.m.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localbw;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.br
 * JD-Core Version:    0.7.0.1
 */