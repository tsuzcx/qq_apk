import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class aymx
  extends aymj
{
  ArrayList<aymw> Gp;
  public int color;
  public int lineWidth;
  public Path path;
  
  public aymx(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.path = paramPath;
    this.color = paramInt2;
    this.lineWidth = paramInt3;
    this.Gp = new ArrayList();
  }
  
  public aymx(aymj paramaymj, float paramFloat)
  {
    super(paramaymj.mode);
    if ((paramaymj instanceof aymx))
    {
      paramaymj = (aymx)paramaymj;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.path = new Path();
      this.path.addPath(paramaymj.path, localMatrix);
      this.mode = paramaymj.mode;
      this.color = paramaymj.color;
      this.lineWidth = ((int)(paramaymj.lineWidth * paramFloat));
    }
  }
  
  public JSONObject am()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mode", this.mode);
      localJSONObject.put("color", this.color);
      localJSONObject.put("lineWidth", this.lineWidth);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.Gp.iterator();
      while (localIterator.hasNext())
      {
        aymw localaymw = (aymw)localIterator.next();
        localJSONArray.put(localaymw.mode);
        localJSONArray.put(localaymw.x);
        localJSONArray.put(localaymw.y);
        if (localaymw.mode == aymw.eKE)
        {
          localJSONArray.put(localaymw.x2);
          localJSONArray.put(localaymw.y2);
        }
      }
      localJSONObject.put("points", localJSONArray);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymx
 * JD-Core Version:    0.7.0.1
 */