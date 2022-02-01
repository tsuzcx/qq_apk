import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aymo
  extends aymj
{
  ArrayList<aymw> Gp;
  public int color;
  public int lineWidth;
  List<Integer> oP;
  List<Integer> oQ;
  public Path path;
  
  public aymo(int paramInt)
  {
    super(paramInt);
    this.path = new Path();
    this.oP = new LinkedList();
    this.oQ = new LinkedList();
    this.Gp = new ArrayList();
  }
  
  public aymo(aymj paramaymj, float paramFloat)
  {
    super(paramaymj.mode);
    if ((paramaymj instanceof aymo))
    {
      paramaymj = (aymo)paramaymj;
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
      if (!this.oP.isEmpty())
      {
        localJSONObject.put("StorageMode", "separate");
        int i = 0;
        while (i < this.oP.size())
        {
          localJSONArray.put(this.oP.get(i));
          localJSONArray.put(this.oQ.get(i));
          i += 1;
        }
      }
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
 * Qualified Name:     aymo
 * JD-Core Version:    0.7.0.1
 */