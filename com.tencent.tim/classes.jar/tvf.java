import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tvf<T>
{
  private final trx a;
  private final tve.a<T> b;
  @Nullable
  private final JSONObject json;
  private final float scale;
  
  private tvf(@Nullable JSONObject paramJSONObject, float paramFloat, trx paramtrx, tve.a<T> parama)
  {
    this.json = paramJSONObject;
    this.scale = paramFloat;
    this.a = paramtrx;
    this.b = parama;
  }
  
  static <T> tvf<T> a(@Nullable JSONObject paramJSONObject, float paramFloat, trx paramtrx, tve.a<T> parama)
  {
    return new tvf(paramJSONObject, paramFloat, paramtrx, parama);
  }
  
  @Nullable
  private T c(List<tsl<T>> paramList)
  {
    if (this.json != null)
    {
      if (!paramList.isEmpty()) {
        return ((tsl)paramList.get(0)).startValue;
      }
      return this.b.a(this.json.opt("k"), this.scale);
    }
    return null;
  }
  
  private List<tsl<T>> cC()
  {
    if (this.json != null)
    {
      Object localObject = this.json.opt("k");
      if (t(localObject)) {
        return tsl.a.a((JSONArray)localObject, this.a, this.scale, this.b);
      }
      return Collections.emptyList();
    }
    return Collections.emptyList();
  }
  
  private static boolean t(Object paramObject)
  {
    if (!(paramObject instanceof JSONArray)) {
      return false;
    }
    paramObject = ((JSONArray)paramObject).opt(0);
    if (((paramObject instanceof JSONObject)) && (((JSONObject)paramObject).has("t"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  tvf.a<T> a()
  {
    List localList = cC();
    return new tvf.a(localList, c(localList));
  }
  
  static class a<T>
  {
    @Nullable
    final T bH;
    final List<tsl<T>> keyframes;
    
    a(List<tsl<T>> paramList, @Nullable T paramT)
    {
      this.keyframes = paramList;
      this.bH = paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvf
 * JD-Core Version:    0.7.0.1
 */