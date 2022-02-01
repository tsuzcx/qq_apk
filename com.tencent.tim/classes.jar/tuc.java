import android.graphics.Color;
import android.support.annotation.ColorInt;
import org.json.JSONArray;
import org.json.JSONObject;

public class tuc
{
  @ColorInt
  public int color;
  public String fontName;
  int justification;
  double lineHeight;
  public int size;
  @ColorInt
  public int strokeColor;
  public boolean strokeOverFill;
  public int strokeWidth;
  public String text;
  public int tracking;
  
  tuc(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, double paramDouble, @ColorInt int paramInt4, @ColorInt int paramInt5, int paramInt6, boolean paramBoolean)
  {
    this.text = paramString1;
    this.fontName = paramString2;
    this.size = paramInt1;
    this.justification = paramInt2;
    this.tracking = paramInt3;
    this.lineHeight = paramDouble;
    this.color = paramInt4;
    this.strokeColor = paramInt5;
    this.strokeWidth = paramInt6;
    this.strokeOverFill = paramBoolean;
  }
  
  public int hashCode()
  {
    int i = this.text.hashCode();
    int j = this.fontName.hashCode();
    int k = this.size;
    int m = this.justification;
    int n = this.tracking;
    long l = Double.doubleToLongBits(this.lineHeight);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + (int)(l ^ l >>> 32)) * 31 + this.color;
  }
  
  public static final class a
  {
    public static tuc a(JSONObject paramJSONObject)
    {
      String str1 = paramJSONObject.optString("t");
      String str2 = paramJSONObject.optString("f");
      int j = paramJSONObject.optInt("s");
      int k = paramJSONObject.optInt("j");
      int m = paramJSONObject.optInt("tr");
      double d = paramJSONObject.optDouble("lh");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("fc");
      int n = Color.argb(255, (int)(localJSONArray.optDouble(0) * 255.0D), (int)(localJSONArray.optDouble(1) * 255.0D), (int)(localJSONArray.optDouble(2) * 255.0D));
      localJSONArray = paramJSONObject.optJSONArray("sc");
      int i = 0;
      if (localJSONArray != null) {
        i = Color.argb(255, (int)(localJSONArray.optDouble(0) * 255.0D), (int)(localJSONArray.optDouble(1) * 255.0D), (int)(localJSONArray.optDouble(2) * 255.0D));
      }
      return new tuc(str1, str2, j, k, m, d, n, i, paramJSONObject.optInt("sw"), paramJSONObject.optBoolean("of"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tuc
 * JD-Core Version:    0.7.0.1
 */