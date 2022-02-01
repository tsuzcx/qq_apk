import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.shortvideo.ptvfilter.DoodleMagicAlgoHandler.RenderPoint;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class aymt
  extends aymj
{
  volatile boolean UL;
  volatile boolean aHV;
  volatile boolean aHW;
  boolean aHX;
  boolean aHY = false;
  public int bGG;
  int brB;
  int brP;
  Frame mCacheFrame;
  public String mId;
  ArrayList<DoodleMagicAlgoHandler.RenderPoint> ny = new ArrayList();
  CopyOnWriteArrayList<PointF> w = new CopyOnWriteArrayList();
  
  public aymt(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.mId = paramString;
    this.bGG = paramInt2;
    this.w.clear();
    this.aHV = false;
    this.aHW = false;
  }
  
  public JSONObject am()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mode", this.mode);
      localJSONObject.put("id", this.mId);
      localJSONObject.put("subType", this.bGG);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.w.iterator();
      while (localIterator.hasNext())
      {
        PointF localPointF = (PointF)localIterator.next();
        localJSONArray.put(localPointF.x);
        localJSONArray.put(localPointF.y);
      }
      localJSONObject.put("points", localJSONArray);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public Frame b(int paramInt1, int paramInt2)
  {
    this.brP = RendererUtils.createTexture();
    this.mCacheFrame = new Frame();
    GLES20.glBindTexture(3553, this.brP);
    this.mCacheFrame.bindFrame(this.brP, paramInt1, paramInt2, 1.0D);
    GLES20.glBindFramebuffer(36160, this.mCacheFrame.getFBO());
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glFlush();
    return this.mCacheFrame;
  }
  
  public void buI()
  {
    this.aHV = true;
    this.UL = true;
  }
  
  public void onDestroy()
  {
    if ((this.aHW) && (this.mCacheFrame != null) && (!this.aHY))
    {
      this.aHY = true;
      this.mCacheFrame.clear();
      RendererUtils.clearTexture(this.brP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymt
 * JD-Core Version:    0.7.0.1
 */