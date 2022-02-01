import android.graphics.Color;
import android.support.annotation.IntRange;
import android.util.Log;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tuo
  extends tvg<tvk, tvk>
{
  private tuo(List<tsl<tvk>> paramList, tvk paramtvk)
  {
    super(paramList, paramtvk);
  }
  
  public ttg<tvk, tvk> g()
  {
    if (!Os()) {
      return new ttu(this.bH);
    }
    return new ttj(this.keyframes);
  }
  
  public static final class a
  {
    public static tuo a(JSONObject paramJSONObject, trx paramtrx)
    {
      paramJSONObject = tvf.a(paramJSONObject, 1.0F, paramtrx, new tuo.b(paramJSONObject.optInt("p", paramJSONObject.optJSONArray("k").length() / 4), null)).a();
      paramtrx = (tvk)paramJSONObject.bH;
      return new tuo(paramJSONObject.keyframes, paramtrx, null);
    }
  }
  
  static class b
    implements tve.a<tvk>
  {
    private final int colorPoints;
    
    private b(int paramInt)
    {
      this.colorPoints = paramInt;
    }
    
    private void a(tvk paramtvk, JSONArray paramJSONArray)
    {
      int m = 0;
      int i = this.colorPoints * 4;
      if (paramJSONArray.length() <= i) {}
      for (;;)
      {
        return;
        int j = (paramJSONArray.length() - i) / 2;
        double[] arrayOfDouble1 = new double[j];
        double[] arrayOfDouble2 = new double[j];
        int k = 0;
        j = m;
        if (i < paramJSONArray.length())
        {
          if (i % 2 == 0) {
            arrayOfDouble1[k] = paramJSONArray.optDouble(i);
          }
          for (;;)
          {
            i += 1;
            break;
            arrayOfDouble2[k] = paramJSONArray.optDouble(i);
            k += 1;
          }
        }
        while (j < paramtvk.getSize())
        {
          i = paramtvk.getColors()[j];
          i = Color.argb(getOpacityAtPosition(paramtvk.getPositions()[j], arrayOfDouble1, arrayOfDouble2), Color.red(i), Color.green(i), Color.blue(i));
          paramtvk.getColors()[j] = i;
          j += 1;
        }
      }
    }
    
    @IntRange(from=0L, to=255L)
    private int getOpacityAtPosition(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
    {
      int i = 1;
      while (i < paramArrayOfDouble1.length)
      {
        double d1 = paramArrayOfDouble1[(i - 1)];
        double d2 = paramArrayOfDouble1[i];
        if (paramArrayOfDouble1[i] >= paramDouble)
        {
          paramDouble = (paramDouble - d1) / (d2 - d1);
          return (int)(twx.lerp(paramArrayOfDouble2[(i - 1)], paramArrayOfDouble2[i], paramDouble) * 255.0D);
        }
        i += 1;
      }
      return (int)(paramArrayOfDouble2[(paramArrayOfDouble2.length - 1)] * 255.0D);
    }
    
    public tvk a(Object paramObject, float paramFloat)
    {
      int i = 0;
      paramObject = (JSONArray)paramObject;
      float[] arrayOfFloat = new float[this.colorPoints];
      int[] arrayOfInt = new int[this.colorPoints];
      tvk localtvk = new tvk(arrayOfFloat, arrayOfInt);
      if (paramObject.length() != this.colorPoints * 4) {
        Log.w("LOTTIE", "Unexpected gradient length: " + paramObject.length() + ". Expected " + this.colorPoints * 4 + ". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
      }
      int k = 0;
      int j = 0;
      if (i < this.colorPoints * 4)
      {
        int m = i / 4;
        double d = paramObject.optDouble(i);
        switch (i % 4)
        {
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFloat[m] = ((float)d);
          continue;
          j = (int)(d * 255.0D);
          continue;
          k = (int)(d * 255.0D);
          continue;
          arrayOfInt[m] = Color.argb(255, j, k, (int)(d * 255.0D));
        }
      }
      a(localtvk, paramObject);
      return localtvk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tuo
 * JD-Core Version:    0.7.0.1
 */