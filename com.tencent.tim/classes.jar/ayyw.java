import android.support.annotation.NonNull;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2;
import java.util.LinkedList;

public class ayyw
  extends GPUBaseFilter
{
  private ayyn a;
  private ayyn b;
  private final LinkedList<Runnable> mRunOnDraw = new LinkedList();
  private float zp;
  
  private void c(@NonNull LinkedList<Runnable> paramLinkedList)
  {
    try
    {
      while (!paramLinkedList.isEmpty())
      {
        Runnable localRunnable = (Runnable)paramLinkedList.poll();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    finally {}
  }
  
  private void runOnDraw(@NonNull Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.add(paramRunnable);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5)
  {
    runOnDraw(new GpuImagePartsFilterGroup.2(this, paramInt1, paramInt4, paramInt5, paramInt2, paramInt3, paramFloat));
  }
  
  public void aY(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ayyl.lb(paramInt1)) {
      throw new IllegalArgumentException("filterType " + paramInt1 + " is invalid color filter type");
    }
    runOnDraw(new GpuImagePartsFilterGroup.1(this, paramInt1, paramInt2, paramInt3));
  }
  
  public boolean ave()
  {
    return (this.a != null) || (this.b != null);
  }
  
  public void dMa()
  {
    c(this.mRunOnDraw);
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (!ave())
    {
      ram.e("Q.qqstory.publish.edit GpuImagePartsFilterGroup", "must set filters before draw texture");
      return;
    }
    if (this.a != null) {
      this.a.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
    }
    this.b.drawTexture(paramInt, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void init()
  {
    if ((this.a != null) && (!this.a.isInitialized())) {
      this.a.init();
    }
    if ((this.b != null) && (!this.b.isInitialized())) {
      this.b.init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.onOutputSizeChanged(paramInt1, paramInt2);
    }
    if (this.b != null) {
      this.b.onOutputSizeChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyw
 * JD-Core Version:    0.7.0.1
 */