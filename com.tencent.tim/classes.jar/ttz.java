import android.graphics.Color;
import org.json.JSONArray;

public class ttz
  implements tve.a<Integer>
{
  public static final ttz a = new ttz();
  
  public Integer a(Object paramObject, float paramFloat)
  {
    paramObject = (JSONArray)paramObject;
    if (paramObject.length() == 4)
    {
      int i = 0;
      int j = 1;
      while (i < paramObject.length())
      {
        if (paramObject.optDouble(i) > 1.0D) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {}
      for (paramFloat = 255.0F;; paramFloat = 1.0F) {
        return Integer.valueOf(Color.argb((int)(paramObject.optDouble(3) * paramFloat), (int)(paramObject.optDouble(0) * paramFloat), (int)(paramObject.optDouble(1) * paramFloat), (int)(paramObject.optDouble(2) * paramFloat)));
      }
    }
    return Integer.valueOf(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ttz
 * JD-Core Version:    0.7.0.1
 */