import android.support.annotation.Nullable;
import org.json.JSONObject;

public class tvb
{
  @Nullable
  public final tuk a;
  @Nullable
  public final tuk b;
  @Nullable
  public final tum c;
  @Nullable
  public final tum d;
  
  tvb(@Nullable tuk paramtuk1, @Nullable tuk paramtuk2, @Nullable tum paramtum1, @Nullable tum paramtum2)
  {
    this.a = paramtuk1;
    this.b = paramtuk2;
    this.c = paramtum1;
    this.d = paramtum2;
  }
  
  public static final class a
  {
    public static tvb a(JSONObject paramJSONObject, trx paramtrx)
    {
      tum localtum = null;
      if ((paramJSONObject == null) || (!paramJSONObject.has("a"))) {
        return new tvb(null, null, null, null);
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("a");
      paramJSONObject = localJSONObject.optJSONObject("fc");
      if (paramJSONObject != null) {}
      for (paramJSONObject = tuk.a.a(paramJSONObject, paramtrx);; paramJSONObject = null)
      {
        Object localObject1 = localJSONObject.optJSONObject("sc");
        if (localObject1 != null) {}
        for (localObject1 = tuk.a.a((JSONObject)localObject1, paramtrx);; localObject1 = null)
        {
          Object localObject2 = localJSONObject.optJSONObject("sw");
          if (localObject2 != null) {}
          for (localObject2 = tum.a.a((JSONObject)localObject2, paramtrx);; localObject2 = null)
          {
            localJSONObject = localJSONObject.optJSONObject("t");
            if (localJSONObject != null) {
              localtum = tum.a.a(localJSONObject, paramtrx);
            }
            return new tvb(paramJSONObject, (tuk)localObject1, (tum)localObject2, localtum);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvb
 * JD-Core Version:    0.7.0.1
 */