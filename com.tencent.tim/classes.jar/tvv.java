import android.graphics.PointF;
import android.support.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tvv
{
  private boolean closed;
  private final List<tub> curves = new ArrayList();
  private PointF initialPoint;
  
  public tvv() {}
  
  private tvv(PointF paramPointF, boolean paramBoolean, List<tub> paramList)
  {
    this.initialPoint = paramPointF;
    this.closed = paramBoolean;
    this.curves.addAll(paramList);
  }
  
  private void setInitialPoint(float paramFloat1, float paramFloat2)
  {
    if (this.initialPoint == null) {
      this.initialPoint = new PointF();
    }
    this.initialPoint.set(paramFloat1, paramFloat2);
  }
  
  public void a(tvv paramtvv1, tvv paramtvv2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.initialPoint == null) {
      this.initialPoint = new PointF();
    }
    if ((paramtvv1.isClosed()) || (paramtvv2.isClosed())) {}
    for (boolean bool = true;; bool = false)
    {
      this.closed = bool;
      if ((this.curves.isEmpty()) || (this.curves.size() == paramtvv1.getCurves().size()) || (this.curves.size() == paramtvv2.getCurves().size())) {
        break;
      }
      throw new IllegalStateException("Curves must have the same number of control points. This: " + getCurves().size() + "\tShape 1: " + paramtvv1.getCurves().size() + "\tShape 2: " + paramtvv2.getCurves().size());
    }
    if (this.curves.isEmpty())
    {
      i = paramtvv1.getCurves().size() - 1;
      while (i >= 0)
      {
        this.curves.add(new tub());
        i -= 1;
      }
    }
    PointF localPointF1 = paramtvv1.getInitialPoint();
    PointF localPointF2 = paramtvv2.getInitialPoint();
    setInitialPoint(twx.lerp(localPointF1.x, localPointF2.x, paramFloat), twx.lerp(localPointF1.y, localPointF2.y, paramFloat));
    int i = this.curves.size() - 1;
    while (i >= 0)
    {
      Object localObject2 = (tub)paramtvv1.getCurves().get(i);
      Object localObject1 = (tub)paramtvv2.getCurves().get(i);
      localPointF1 = ((tub)localObject2).getControlPoint1();
      localPointF2 = ((tub)localObject2).getControlPoint2();
      localObject2 = ((tub)localObject2).getVertex();
      PointF localPointF3 = ((tub)localObject1).getControlPoint1();
      PointF localPointF4 = ((tub)localObject1).getControlPoint2();
      localObject1 = ((tub)localObject1).getVertex();
      ((tub)this.curves.get(i)).setControlPoint1(twx.lerp(localPointF1.x, localPointF3.x, paramFloat), twx.lerp(localPointF1.y, localPointF3.y, paramFloat));
      ((tub)this.curves.get(i)).setControlPoint2(twx.lerp(localPointF2.x, localPointF4.x, paramFloat), twx.lerp(localPointF2.y, localPointF4.y, paramFloat));
      ((tub)this.curves.get(i)).setVertex(twx.lerp(((PointF)localObject2).x, ((PointF)localObject1).x, paramFloat), twx.lerp(((PointF)localObject2).y, ((PointF)localObject1).y, paramFloat));
      i -= 1;
    }
  }
  
  public List<tub> getCurves()
  {
    return this.curves;
  }
  
  public PointF getInitialPoint()
  {
    return this.initialPoint;
  }
  
  public boolean isClosed()
  {
    return this.closed;
  }
  
  public String toString()
  {
    return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + '}';
  }
  
  public static class a
    implements tve.a<tvv>
  {
    public static final a a = new a();
    
    private static PointF a(int paramInt, JSONArray paramJSONArray)
    {
      if (paramInt >= paramJSONArray.length()) {
        throw new IllegalArgumentException("Invalid index " + paramInt + ". There are only " + paramJSONArray.length() + " points.");
      }
      Object localObject = paramJSONArray.optJSONArray(paramInt);
      paramJSONArray = ((JSONArray)localObject).opt(0);
      localObject = ((JSONArray)localObject).opt(1);
      float f1;
      if ((paramJSONArray instanceof Double))
      {
        f1 = ((Double)paramJSONArray).floatValue();
        if (!(localObject instanceof Double)) {
          break label128;
        }
      }
      label128:
      for (float f2 = ((Double)localObject).floatValue();; f2 = ((Integer)localObject).intValue())
      {
        return new PointF(f1, f2);
        f1 = ((Integer)paramJSONArray).intValue();
        break;
      }
    }
    
    public tvv a(Object paramObject, float paramFloat)
    {
      Object localObject2 = null;
      if ((paramObject instanceof JSONArray))
      {
        paramObject = ((JSONArray)paramObject).opt(0);
        if ((!(paramObject instanceof JSONObject)) || (!((JSONObject)paramObject).has("v"))) {
          break label604;
        }
      }
      label604:
      for (paramObject = (JSONObject)paramObject;; paramObject = null)
      {
        Object localObject1 = paramObject;
        while (localObject1 == null)
        {
          return null;
          localObject1 = localObject2;
          if ((paramObject instanceof JSONObject))
          {
            localObject1 = localObject2;
            if (((JSONObject)paramObject).has("v")) {
              localObject1 = (JSONObject)paramObject;
            }
          }
        }
        Object localObject4 = ((JSONObject)localObject1).optJSONArray("v");
        localObject2 = ((JSONObject)localObject1).optJSONArray("i");
        Object localObject3 = ((JSONObject)localObject1).optJSONArray("o");
        boolean bool = ((JSONObject)localObject1).optBoolean("c", false);
        if ((localObject4 == null) || (localObject2 == null) || (localObject3 == null) || (((JSONArray)localObject4).length() != ((JSONArray)localObject2).length()) || (((JSONArray)localObject4).length() != ((JSONArray)localObject3).length())) {
          throw new IllegalStateException("Unable to process points array or tangents. " + localObject1);
        }
        if (((JSONArray)localObject4).length() == 0) {
          return new tvv(new PointF(), false, Collections.emptyList(), null);
        }
        int j = ((JSONArray)localObject4).length();
        paramObject = a(0, (JSONArray)localObject4);
        paramObject.x *= paramFloat;
        paramObject.y *= paramFloat;
        localObject1 = new ArrayList(j);
        int i = 1;
        PointF localPointF1;
        while (i < j)
        {
          localPointF1 = a(i, (JSONArray)localObject4);
          PointF localPointF3 = a(i - 1, (JSONArray)localObject4);
          PointF localPointF4 = a(i - 1, (JSONArray)localObject3);
          PointF localPointF2 = a(i, (JSONArray)localObject2);
          localPointF3 = twx.addPoints(localPointF3, localPointF4);
          localPointF2 = twx.addPoints(localPointF1, localPointF2);
          localPointF3.x *= paramFloat;
          localPointF3.y *= paramFloat;
          localPointF2.x *= paramFloat;
          localPointF2.y *= paramFloat;
          localPointF1.x *= paramFloat;
          localPointF1.y *= paramFloat;
          ((List)localObject1).add(new tub(localPointF3, localPointF2, localPointF1));
          i += 1;
        }
        if (bool)
        {
          localPointF1 = a(0, (JSONArray)localObject4);
          localObject4 = a(j - 1, (JSONArray)localObject4);
          localObject3 = a(j - 1, (JSONArray)localObject3);
          localObject2 = a(0, (JSONArray)localObject2);
          localObject3 = twx.addPoints((PointF)localObject4, (PointF)localObject3);
          localObject2 = twx.addPoints(localPointF1, (PointF)localObject2);
          if (paramFloat != 1.0F)
          {
            ((PointF)localObject3).x *= paramFloat;
            ((PointF)localObject3).y *= paramFloat;
            ((PointF)localObject2).x *= paramFloat;
            ((PointF)localObject2).y *= paramFloat;
            localPointF1.x *= paramFloat;
            localPointF1.y *= paramFloat;
          }
          ((List)localObject1).add(new tub((PointF)localObject3, (PointF)localObject2, localPointF1));
        }
        return new tvv(paramObject, bool, (List)localObject1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvv
 * JD-Core Version:    0.7.0.1
 */