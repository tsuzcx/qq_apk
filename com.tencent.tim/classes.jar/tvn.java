import android.support.annotation.Nullable;
import com.tencent.lottieNew.model.content.GradientType;
import com.tencent.lottieNew.model.content.ShapeStroke.LineCapType;
import com.tencent.lottieNew.model.content.ShapeStroke.LineJoinType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tvn
  implements tvj
{
  private final ShapeStroke.LineCapType jdField_a_of_type_ComTencentLottieNewModelContentShapeStroke$LineCapType;
  private final ShapeStroke.LineJoinType jdField_a_of_type_ComTencentLottieNewModelContentShapeStroke$LineJoinType;
  private final tuo jdField_a_of_type_Tuo;
  private final tuq jdField_a_of_type_Tuq;
  private final GradientType jdField_b_of_type_ComTencentLottieNewModelContentGradientType;
  private final tut jdField_b_of_type_Tut;
  private final tut c;
  private final tum j;
  @Nullable
  private final tum k;
  private final List<tum> lineDashPattern;
  private final String name;
  
  private tvn(String paramString, GradientType paramGradientType, tuo paramtuo, tuq paramtuq, tut paramtut1, tut paramtut2, tum paramtum1, ShapeStroke.LineCapType paramLineCapType, ShapeStroke.LineJoinType paramLineJoinType, List<tum> paramList, @Nullable tum paramtum2)
  {
    this.name = paramString;
    this.jdField_b_of_type_ComTencentLottieNewModelContentGradientType = paramGradientType;
    this.jdField_a_of_type_Tuo = paramtuo;
    this.jdField_a_of_type_Tuq = paramtuq;
    this.jdField_b_of_type_Tut = paramtut1;
    this.c = paramtut2;
    this.j = paramtum1;
    this.jdField_a_of_type_ComTencentLottieNewModelContentShapeStroke$LineCapType = paramLineCapType;
    this.jdField_a_of_type_ComTencentLottieNewModelContentShapeStroke$LineJoinType = paramLineJoinType;
    this.lineDashPattern = paramList;
    this.k = paramtum2;
  }
  
  public GradientType a()
  {
    return this.jdField_b_of_type_ComTencentLottieNewModelContentGradientType;
  }
  
  public ShapeStroke.LineCapType a()
  {
    return this.jdField_a_of_type_ComTencentLottieNewModelContentShapeStroke$LineCapType;
  }
  
  public ShapeStroke.LineJoinType a()
  {
    return this.jdField_a_of_type_ComTencentLottieNewModelContentShapeStroke$LineJoinType;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new tsu(paramtrz, paramtwe, this);
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
  
  public tum e()
  {
    return this.j;
  }
  
  @Nullable
  public tum f()
  {
    return this.k;
  }
  
  public List<tum> getLineDashPattern()
  {
    return this.lineDashPattern;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  static class a
  {
    static tvn a(JSONObject paramJSONObject, trx paramtrx)
    {
      String str1 = paramJSONObject.optString("nm");
      Object localObject1 = paramJSONObject.optJSONObject("g");
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((JSONObject)localObject1).has("k")) {
          localObject2 = ((JSONObject)localObject1).optJSONObject("k");
        }
      }
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = tuo.a.a((JSONObject)localObject2, paramtrx);
      }
      Object localObject3 = paramJSONObject.optJSONObject("o");
      localObject2 = null;
      if (localObject3 != null) {
        localObject2 = tuq.a.a((JSONObject)localObject3, paramtrx);
      }
      Object localObject4;
      tut localtut;
      tum localtum;
      ShapeStroke.LineCapType localLineCapType;
      ShapeStroke.LineJoinType localLineJoinType;
      ArrayList localArrayList;
      int i;
      label217:
      JSONObject localJSONObject;
      String str2;
      if (paramJSONObject.optInt("t", 1) == 1)
      {
        localObject3 = GradientType.Linear;
        localObject4 = paramJSONObject.optJSONObject("s");
        localtut = null;
        if (localObject4 != null) {
          localtut = tut.a.a((JSONObject)localObject4, paramtrx);
        }
        localObject5 = paramJSONObject.optJSONObject("e");
        localObject4 = null;
        if (localObject5 != null) {
          localObject4 = tut.a.a((JSONObject)localObject5, paramtrx);
        }
        localtum = tum.a.a(paramJSONObject.optJSONObject("w"), paramtrx);
        localLineCapType = ShapeStroke.LineCapType.values()[(paramJSONObject.optInt("lc") - 1)];
        localLineJoinType = ShapeStroke.LineJoinType.values()[(paramJSONObject.optInt("lj") - 1)];
        localObject5 = null;
        localArrayList = new ArrayList();
        if (!paramJSONObject.has("d")) {
          break label362;
        }
        JSONArray localJSONArray = paramJSONObject.optJSONArray("d");
        paramJSONObject = null;
        i = 0;
        if (i >= localJSONArray.length()) {
          break label332;
        }
        localJSONObject = localJSONArray.optJSONObject(i);
        str2 = localJSONObject.optString("n");
        if (!str2.equals("o")) {
          break label284;
        }
        localObject5 = tum.a.a(localJSONObject.optJSONObject("v"), paramtrx);
      }
      for (;;)
      {
        i += 1;
        paramJSONObject = (JSONObject)localObject5;
        break label217;
        localObject3 = GradientType.Radial;
        break;
        label284:
        if (!str2.equals("d"))
        {
          localObject5 = paramJSONObject;
          if (!str2.equals("g")) {}
        }
        else
        {
          localArrayList.add(tum.a.a(localJSONObject.optJSONObject("v"), paramtrx));
          localObject5 = paramJSONObject;
        }
      }
      label332:
      if (localArrayList.size() == 1) {
        localArrayList.add(localArrayList.get(0));
      }
      Object localObject5 = paramJSONObject;
      label362:
      return new tvn(str1, (GradientType)localObject3, (tuo)localObject1, (tuq)localObject2, localtut, (tut)localObject4, localtum, localLineCapType, localLineJoinType, localArrayList, (tum)localObject5, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvn
 * JD-Core Version:    0.7.0.1
 */