import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class tsl<T>
{
  private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
  private final trx a;
  @Nullable
  public Float endFrame;
  private float endProgress = 1.4E-45F;
  @Nullable
  public final T endValue;
  @Nullable
  public final Interpolator interpolator;
  public final float startFrame;
  private float startProgress = 1.4E-45F;
  @Nullable
  public final T startValue;
  
  public tsl(trx paramtrx, @Nullable T paramT1, @Nullable T paramT2, @Nullable Interpolator paramInterpolator, float paramFloat, @Nullable Float paramFloat1)
  {
    this.a = paramtrx;
    this.startValue = paramT1;
    this.endValue = paramT2;
    this.interpolator = paramInterpolator;
    this.startFrame = paramFloat;
    this.endFrame = paramFloat1;
  }
  
  public static void setEndFrames(List<? extends tsl<?>> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j - 1)
    {
      ((tsl)paramList.get(i)).endFrame = Float.valueOf(((tsl)paramList.get(i + 1)).startFrame);
      i += 1;
    }
    tsl localtsl = (tsl)paramList.get(j - 1);
    if (localtsl.startValue == null) {
      paramList.remove(localtsl);
    }
  }
  
  public boolean containsProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return (paramFloat >= getStartProgress()) && (paramFloat <= getEndProgress());
  }
  
  public float getEndProgress()
  {
    if (this.endProgress == 1.4E-45F) {
      if (this.endFrame != null) {
        break label27;
      }
    }
    label27:
    for (this.endProgress = 1.0F;; this.endProgress = (getStartProgress() + (this.endFrame.floatValue() - this.startFrame) / this.a.getDurationFrames())) {
      return this.endProgress;
    }
  }
  
  public float getStartProgress()
  {
    if (this.startProgress == 1.4E-45F) {
      this.startProgress = ((this.startFrame - (float)this.a.ei()) / this.a.getDurationFrames());
    }
    return this.startProgress;
  }
  
  public boolean isStatic()
  {
    return this.interpolator == null;
  }
  
  public String toString()
  {
    return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
  }
  
  public static class a
  {
    private static final Map<Integer, WeakReference<Interpolator>> gX = new HashMap();
    
    public static <T> List<tsl<T>> a(JSONArray paramJSONArray, trx paramtrx, float paramFloat, tve.a<T> parama)
    {
      int j = paramJSONArray.length();
      if (j == 0) {
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(paramJSONArray.optJSONObject(i), paramtrx, paramFloat, parama));
        i += 1;
      }
      tsl.setEndFrames(localArrayList);
      return localArrayList;
    }
    
    public static <T> tsl<T> a(JSONObject paramJSONObject, trx paramtrx, float paramFloat, tve.a<T> parama)
    {
      float f = 0.0F;
      if (paramJSONObject.has("t"))
      {
        f = (float)paramJSONObject.optDouble("t", 0.0D);
        localObject1 = paramJSONObject.opt("s");
        if (localObject1 == null) {
          break label409;
        }
      }
      label140:
      label409:
      for (Object localObject1 = parama.a(localObject1, paramFloat);; localObject1 = null)
      {
        Object localObject2 = paramJSONObject.opt("e");
        if (localObject2 != null) {}
        for (parama = parama.a(localObject2, paramFloat);; parama = null)
        {
          Object localObject4 = paramJSONObject.optJSONObject("o");
          localObject2 = paramJSONObject.optJSONObject("i");
          if ((localObject4 != null) && (localObject2 != null))
          {
            localObject4 = tws.a((JSONObject)localObject4, paramFloat);
            localObject2 = tws.a((JSONObject)localObject2, paramFloat);
          }
          for (;;)
          {
            if (paramJSONObject.optInt("h", 0) == 1) {}
            for (int i = 1; i != 0; i = 0)
            {
              paramJSONObject = tsl.d();
              parama = (tve.a<T>)localObject1;
              paramFloat = f;
              return new tsl(paramtrx, localObject1, parama, paramJSONObject, paramFloat, null);
            }
            WeakReference localWeakReference;
            if (localObject4 != null)
            {
              ((PointF)localObject4).x = twx.clamp(((PointF)localObject4).x, -paramFloat, paramFloat);
              ((PointF)localObject4).y = twx.clamp(((PointF)localObject4).y, -100.0F, 100.0F);
              ((PointF)localObject2).x = twx.clamp(((PointF)localObject2).x, -paramFloat, paramFloat);
              ((PointF)localObject2).y = twx.clamp(((PointF)localObject2).y, -100.0F, 100.0F);
              i = twy.hashFor(((PointF)localObject4).x, ((PointF)localObject4).y, ((PointF)localObject2).x, ((PointF)localObject2).y);
              localWeakReference = (WeakReference)gX.get(Integer.valueOf(i));
              if (localWeakReference == null) {
                break label390;
              }
            }
            for (paramJSONObject = (Interpolator)localWeakReference.get();; paramJSONObject = null)
            {
              for (;;)
              {
                if ((localWeakReference != null) && (paramJSONObject != null)) {
                  break label387;
                }
                paramJSONObject = PathInterpolatorCompat.create(((PointF)localObject4).x / paramFloat, ((PointF)localObject4).y / paramFloat, ((PointF)localObject2).x / paramFloat, ((PointF)localObject2).y / paramFloat);
                try
                {
                  gX.put(Integer.valueOf(i), new WeakReference(paramJSONObject));
                }
                catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {}
              }
              break;
              paramJSONObject = tsl.d();
              break;
              parama = parama.a(paramJSONObject, paramFloat);
              paramJSONObject = null;
              localObject1 = parama;
              paramFloat = f;
              break label140;
              break;
            }
            Object localObject3 = null;
            localObject4 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tsl
 * JD-Core Version:    0.7.0.1
 */