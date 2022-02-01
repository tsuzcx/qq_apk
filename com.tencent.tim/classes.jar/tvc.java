import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Collections;
import org.json.JSONObject;

public class tvc
  implements tvj
{
  private final tuq jdField_a_of_type_Tuq;
  private final tus jdField_a_of_type_Tus;
  private final tuv jdField_a_of_type_Tuv;
  private final tve<PointF, PointF> jdField_a_of_type_Tve;
  private final tum e;
  @Nullable
  private final tum f;
  @Nullable
  private final tum g;
  
  private tvc(tus paramtus, tve<PointF, PointF> paramtve, tuv paramtuv, tum paramtum1, tuq paramtuq, @Nullable tum paramtum2, @Nullable tum paramtum3)
  {
    this.jdField_a_of_type_Tus = paramtus;
    this.jdField_a_of_type_Tve = paramtve;
    this.jdField_a_of_type_Tuv = paramtuv;
    this.e = paramtum1;
    this.jdField_a_of_type_Tuq = paramtuq;
    this.f = paramtum2;
    this.g = paramtum3;
  }
  
  @Nullable
  public tso a(trz paramtrz, twe paramtwe)
  {
    return null;
  }
  
  public ttw a()
  {
    return new ttw(this);
  }
  
  public tus a()
  {
    return this.jdField_a_of_type_Tus;
  }
  
  public tve<PointF, PointF> a()
  {
    return this.jdField_a_of_type_Tve;
  }
  
  public tum b()
  {
    return this.e;
  }
  
  public tuq b()
  {
    return this.jdField_a_of_type_Tuq;
  }
  
  public tuv b()
  {
    return this.jdField_a_of_type_Tuv;
  }
  
  @Nullable
  public tum c()
  {
    return this.f;
  }
  
  @Nullable
  public tum d()
  {
    return this.g;
  }
  
  public static class a
  {
    public static tvc a()
    {
      return new tvc(new tus(), new tus(), tuv.a.a(), tum.a.a(), tuq.a.a(), tum.a.a(), tum.a.a(), null);
    }
    
    public static tvc a(JSONObject paramJSONObject, trx paramtrx)
    {
      Object localObject1 = paramJSONObject.optJSONObject("a");
      Object localObject2;
      label43:
      Object localObject3;
      label64:
      Object localObject5;
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = new tus(((JSONObject)localObject1).opt("k"), paramtrx);
        localObject2 = paramJSONObject.optJSONObject("p");
        if (localObject2 == null) {
          break label203;
        }
        localObject2 = tus.a((JSONObject)localObject2, paramtrx);
        localObject3 = paramJSONObject.optJSONObject("s");
        if (localObject3 == null) {
          break label213;
        }
        localObject3 = tuv.a.a((JSONObject)localObject3, paramtrx);
        localObject5 = paramJSONObject.optJSONObject("r");
        localObject4 = localObject5;
        if (localObject5 == null) {
          localObject4 = paramJSONObject.optJSONObject("rz");
        }
        if (localObject4 == null) {
          break label235;
        }
        localObject4 = tum.a.a((JSONObject)localObject4, paramtrx, false);
        label103:
        localObject5 = paramJSONObject.optJSONObject("o");
        if (localObject5 == null) {
          break label246;
        }
        localObject5 = tuq.a.a((JSONObject)localObject5, paramtrx);
        label124:
        localObject6 = paramJSONObject.optJSONObject("so");
        if (localObject6 == null) {
          break label271;
        }
      }
      label271:
      for (Object localObject6 = tum.a.a((JSONObject)localObject6, paramtrx, false);; localObject6 = null)
      {
        paramJSONObject = paramJSONObject.optJSONObject("eo");
        if (paramJSONObject != null) {}
        for (paramJSONObject = tum.a.a(paramJSONObject, paramtrx, false);; paramJSONObject = null)
        {
          return new tvc((tus)localObject1, (tve)localObject2, (tuv)localObject3, (tum)localObject4, (tuq)localObject5, (tum)localObject6, paramJSONObject, null);
          Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
          localObject1 = new tus();
          break;
          label203:
          uD("position");
          localObject2 = null;
          break label43;
          label213:
          localObject3 = new tuv(Collections.emptyList(), new tuj());
          break label64;
          label235:
          uD("rotation");
          localObject4 = null;
          break label103;
          label246:
          localObject5 = new tuq(Collections.emptyList(), Integer.valueOf(100));
          break label124;
        }
      }
    }
    
    private static void uD(String paramString)
    {
      throw new IllegalArgumentException("Missing transform for " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvc
 * JD-Core Version:    0.7.0.1
 */