import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.mobileqq.shortvideo.ptvfilter.DoodleMagicAlgoHandler.RenderPoint;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class rif
  extends rhx
{
  volatile boolean UL;
  volatile boolean aHV;
  volatile boolean aHW;
  boolean aHX;
  boolean aHY = false;
  int brB;
  int brP;
  Frame mCacheFrame;
  public String mId;
  ArrayList<DoodleMagicAlgoHandler.RenderPoint> ny = new ArrayList();
  CopyOnWriteArrayList<PointF> w = new CopyOnWriteArrayList();
  
  public rif(int paramInt, String paramString)
  {
    super(paramInt);
    this.mId = paramString;
    this.w.clear();
    this.aHV = false;
    this.aHW = false;
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
    this.w.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rif
 * JD-Core Version:    0.7.0.1
 */