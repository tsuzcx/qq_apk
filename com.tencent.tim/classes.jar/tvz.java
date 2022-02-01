import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.lottieNew.model.content.MergePaths.a;
import com.tencent.lottieNew.model.content.PolystarShape.a;
import com.tencent.lottieNew.model.content.ShapeStroke.a;
import com.tencent.lottieNew.model.content.ShapeTrimPath.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tvz
  implements tvj
{
  private final List<tvj> items;
  private final String name;
  
  public tvz(String paramString, List<tvj> paramList)
  {
    this.name = paramString;
    this.items = paramList;
  }
  
  @Nullable
  public static tvj a(JSONObject paramJSONObject, trx paramtrx)
  {
    String str = paramJSONObject.optString("ty");
    if ("gr".equals(str)) {
      return tvz.a.b(paramJSONObject, paramtrx);
    }
    if ("st".equals(str)) {
      return ShapeStroke.a.a(paramJSONObject, paramtrx);
    }
    if ("gs".equals(str)) {
      return tvn.a.a(paramJSONObject, paramtrx);
    }
    if ("fl".equals(str)) {
      return tvx.a.a(paramJSONObject, paramtrx);
    }
    if ("gf".equals(str)) {
      return tvl.a.a(paramJSONObject, paramtrx);
    }
    if ("tr".equals(str)) {
      return tvc.a.a(paramJSONObject, paramtrx);
    }
    if ("sh".equals(str)) {
      return twa.a.a(paramJSONObject, paramtrx);
    }
    if ("el".equals(str)) {
      return tvh.a.a(paramJSONObject, paramtrx);
    }
    if ("rc".equals(str)) {
      return tvs.a.a(paramJSONObject, paramtrx);
    }
    if ("tm".equals(str)) {
      return ShapeTrimPath.a.a(paramJSONObject, paramtrx);
    }
    if ("sr".equals(str)) {
      return PolystarShape.a.a(paramJSONObject, paramtrx);
    }
    if ("mm".equals(str)) {
      return MergePaths.a.a(paramJSONObject);
    }
    if ("rp".equals(str)) {
      return tvu.a.a(paramJSONObject, paramtrx);
    }
    Log.w("LOTTIE", "Unknown shape type " + str);
    return null;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new tsp(paramtrz, paramtwe, this);
  }
  
  public List<tvj> getItems()
  {
    return this.items;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + '}';
  }
  
  static class a
  {
    private static tvz a(JSONObject paramJSONObject, trx paramtrx)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("it");
      paramJSONObject = paramJSONObject.optString("nm");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        tvj localtvj = tvz.a(localJSONArray.optJSONObject(i), paramtrx);
        if (localtvj != null) {
          localArrayList.add(localtvj);
        }
        i += 1;
      }
      return new tvz(paramJSONObject, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvz
 * JD-Core Version:    0.7.0.1
 */