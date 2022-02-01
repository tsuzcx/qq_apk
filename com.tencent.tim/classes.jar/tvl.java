import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.GradientType;
import org.json.JSONException;
import org.json.JSONObject;

public class tvl
  implements tvj
{
  private final tuo jdField_a_of_type_Tuo;
  private final tuq jdField_a_of_type_Tuq;
  private final GradientType jdField_b_of_type_ComTencentLottieNewModelContentGradientType;
  private final tut jdField_b_of_type_Tut;
  private final tut c;
  private final Path.FillType fillType;
  @Nullable
  private final tum h;
  @Nullable
  private final tum i;
  private final String name;
  
  private tvl(String paramString, GradientType paramGradientType, Path.FillType paramFillType, tuo paramtuo, tuq paramtuq, tut paramtut1, tut paramtut2, tum paramtum1, tum paramtum2)
  {
    this.jdField_b_of_type_ComTencentLottieNewModelContentGradientType = paramGradientType;
    this.fillType = paramFillType;
    this.jdField_a_of_type_Tuo = paramtuo;
    this.jdField_a_of_type_Tuq = paramtuq;
    this.jdField_b_of_type_Tut = paramtut1;
    this.c = paramtut2;
    this.name = paramString;
    this.h = paramtum1;
    this.i = paramtum2;
  }
  
  public GradientType a()
  {
    return this.jdField_b_of_type_ComTencentLottieNewModelContentGradientType;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new tst(paramtrz, paramtwe, this);
  }
  
  public tuo a()
  {
    return this.jdField_a_of_type_Tuo;
  }
  
  public tuq b()
  {
    return this.jdField_a_of_type_Tuq;
  }
  
  public tut b()
  {
    return this.jdField_b_of_type_Tut;
  }
  
  public tut c()
  {
    return this.c;
  }
  
  public Path.FillType getFillType()
  {
    return this.fillType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  static class a
  {
    static tvl a(JSONObject paramJSONObject, trx paramtrx)
    {
      String str = paramJSONObject.optString("nm");
      Object localObject2 = paramJSONObject.optJSONObject("g");
      Object localObject1 = localObject2;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((JSONObject)localObject2).has("k"))
        {
          i = ((JSONObject)localObject2).optInt("p");
          localObject1 = ((JSONObject)localObject2).optJSONObject("k");
        }
      }
      try
      {
        ((JSONObject)localObject1).put("p", i);
        if (localObject1 != null)
        {
          localObject1 = tuo.a.a((JSONObject)localObject1, paramtrx);
          localObject2 = paramJSONObject.optJSONObject("o");
          if (localObject2 != null)
          {
            localObject2 = tuq.a.a((JSONObject)localObject2, paramtrx);
            Path.FillType localFillType;
            if (paramJSONObject.optInt("r", 1) == 1)
            {
              localFillType = Path.FillType.WINDING;
              if (paramJSONObject.optInt("t", 1) != 1) {
                break label193;
              }
            }
            label193:
            for (GradientType localGradientType = GradientType.Linear;; localGradientType = GradientType.Radial)
            {
              localObject4 = paramJSONObject.optJSONObject("s");
              if (localObject4 == null) {
                break label211;
              }
              localObject4 = tut.a.a((JSONObject)localObject4, paramtrx);
              paramJSONObject = paramJSONObject.optJSONObject("e");
              if (paramJSONObject == null) {
                break label206;
              }
              paramJSONObject = tut.a.a(paramJSONObject, paramtrx);
              return new tvl(str, localGradientType, localFillType, (tuo)localObject1, (tuq)localObject2, (tut)localObject4, paramJSONObject, null, null, null);
              localFillType = Path.FillType.EVEN_ODD;
              break;
            }
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          continue;
          label206:
          paramJSONObject = null;
          continue;
          label211:
          Object localObject4 = null;
          continue;
          Object localObject3 = null;
          continue;
          localObject1 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvl
 * JD-Core Version:    0.7.0.1
 */