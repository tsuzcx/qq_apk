import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class aaed
  extends aafa
{
  private StringBuilder K;
  
  public aaed(String paramString1, String paramString2)
    throws Throwable
  {
    super(paramString1, paramString2);
  }
  
  public boolean a(wrb paramwrb, String paramString, float paramFloat, int paramInt)
  {
    if ((paramwrb == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return false;
        paramwrb = aaeq.a(paramwrb, 28, 28);
        localObject1 = a(paramwrb);
        aaeq.f(paramwrb);
      } while (localObject1 == null);
      Object localObject1 = a((float[][][][])localObject1);
      paramwrb = new HashSet();
      Object localObject2 = new LinkedList();
      if (localObject1 != null)
      {
        paramInt = 0;
        while (paramInt < this.vh.size())
        {
          if ((localObject1.length > paramInt) && (localObject1[paramInt] > 0.01F))
          {
            ((List)localObject2).add(new aaed.a((String)this.vh.get(paramInt), localObject1[paramInt]));
            if ((localObject1[paramInt] > paramFloat) && (this.vh.size() > paramInt)) {
              paramwrb.add(this.vh.get(paramInt));
            }
          }
          paramInt += 1;
        }
      }
      Collections.sort((List)localObject2, new aaee(this));
      localObject1 = new StringBuilder();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aaed.a locala = (aaed.a)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(locala.name + ":" + locala.prob + "\n");
      }
      this.K = ((StringBuilder)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("DrawClassifier.DefaultClassifier", 2, "recog result:" + ((StringBuilder)localObject1).toString());
      }
      if (paramwrb.contains(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DrawClassifier.DefaultClassifier", 2, "recognition succ:" + paramString);
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DrawClassifier.DefaultClassifier", 2, "recognition failed:" + paramString);
    return false;
  }
  
  public float[][][][] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return (float[][][][])null;
    }
    float[][][][] arrayOfFloat = (float[][][][])Array.newInstance(Float.TYPE, new int[] { 1, 28, 28, 1 });
    int[] arrayOfInt1 = new int[784];
    float[] arrayOfFloat1 = new float[arrayOfInt1.length];
    int[] arrayOfInt2 = new int[784];
    paramBitmap.getPixels(arrayOfInt2, 0, paramBitmap.getWidth(), 0, 0, 28, 28);
    int i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfInt1[i] = 255;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt2.length)
    {
      arrayOfInt2[i] &= 0xFF;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt1.length)
    {
      arrayOfFloat1[i] = (1.0F - arrayOfInt1[i] / 255.0F);
      i += 1;
    }
    int m = arrayOfFloat1.length;
    i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfFloat1[i] != 0.0F) {
        k = j + 1;
      }
      i += 1;
    }
    if (j < 40) {
      return (float[][][][])null;
    }
    i = 0;
    while (i < arrayOfFloat[0].length)
    {
      j = 0;
      while (j < arrayOfFloat[0][i].length)
      {
        arrayOfFloat[0][i][j][0] = arrayOfFloat1[(i * 28 + j)];
        j += 1;
      }
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public String qm()
  {
    if (this.K == null) {
      return "";
    }
    return this.K.toString();
  }
  
  public static class a
  {
    String name;
    float prob;
    
    public a(String paramString, float paramFloat)
    {
      this.name = paramString;
      this.prob = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaed
 * JD-Core Version:    0.7.0.1
 */