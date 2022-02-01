import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class imw
{
  private final ArrayList<imx> io = new ArrayList(1);
  
  public void a(PathMeasure paramPathMeasure)
  {
    int j = this.io.size();
    int i = 0;
    while (i < j)
    {
      ((imx)this.io.get(i)).a(paramPathMeasure);
      i += 1;
    }
  }
  
  public void d(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getResources();
    this.io.clear();
    if (paramInt1 != 0)
    {
      Object localObject1 = paramContext.openRawResource(paramInt1);
      try
      {
        localObject1 = new BufferedReader(new InputStreamReader((InputStream)localObject1), 512);
        Object localObject2;
        do
        {
          localObject2 = new imx((BufferedReader)localObject1);
          ((BufferedReader)localObject1).readLine();
          ((BufferedReader)localObject1).readLine();
          TypedArray localTypedArray = paramContext.obtainTypedArray(paramInt2);
          int i = localTypedArray.length();
          BitmapDrawable[] arrayOfBitmapDrawable = new BitmapDrawable[i];
          paramInt1 = 0;
          while (paramInt1 < i)
          {
            arrayOfBitmapDrawable[paramInt1] = ((BitmapDrawable)localTypedArray.getDrawable(paramInt1));
            paramInt1 += 1;
          }
          ((imx)localObject2).a(arrayOfBitmapDrawable);
          localTypedArray.recycle();
          this.io.add(localObject2);
          if (((BufferedReader)localObject1).readLine() == null) {
            return;
          }
          localObject2 = ((BufferedReader)localObject1).readLine();
        } while (localObject2 != null);
        return;
      }
      catch (IOException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ParticleEffect", 2, "WL_DEBUG loadEmitters ex = " + paramContext);
        }
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = this.io.size();
    int i = 0;
    while (i < j)
    {
      ((imx)this.io.get(i)).draw(paramCanvas);
      i += 1;
    }
  }
  
  public void update(float paramFloat)
  {
    int j = this.io.size();
    int i = 0;
    while (i < j)
    {
      ((imx)this.io.get(i)).update(paramFloat);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imw
 * JD-Core Version:    0.7.0.1
 */