import android.support.annotation.NonNull;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayyv
  extends GPUBaseFilter
{
  private List<RenderBuffer> FB;
  private boolean cBR;
  private int dBw = -1;
  private List<GPUBaseFilter> mFilterList = new ArrayList();
  
  private void dLZ()
  {
    if (this.FB != null)
    {
      Iterator localIterator = this.FB.iterator();
      while (localIterator.hasNext()) {
        ((RenderBuffer)localIterator.next()).destroy();
      }
      this.FB = null;
    }
  }
  
  public RenderBuffer a()
  {
    if ((this.FB != null) && (this.FB.size() > 0)) {
      return (RenderBuffer)this.FB.get(this.FB.size() - 1);
    }
    throw new RuntimeException("please check your state");
  }
  
  public void a(@NonNull GPUBaseFilter paramGPUBaseFilter)
  {
    this.mFilterList.add(paramGPUBaseFilter);
  }
  
  public void destroy()
  {
    Iterator localIterator = this.mFilterList.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).destroy();
    }
    dLZ();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.dBw = paramInt;
    paramInt = 0;
    if (paramInt < this.mFilterList.size())
    {
      if (paramInt != this.mFilterList.size() - 1)
      {
        ((RenderBuffer)this.FB.get(paramInt)).bind();
        ((GPUBaseFilter)this.mFilterList.get(paramInt)).drawTexture(this.dBw, null, null);
        ((RenderBuffer)this.FB.get(paramInt)).unbind();
        this.dBw = ((RenderBuffer)this.FB.get(paramInt)).getTexId();
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (this.cBR)
        {
          ((GPUBaseFilter)this.mFilterList.get(paramInt)).drawTexture(this.dBw, paramArrayOfFloat1, paramArrayOfFloat2);
        }
        else
        {
          ((RenderBuffer)this.FB.get(paramInt)).bind();
          ((GPUBaseFilter)this.mFilterList.get(paramInt)).drawTexture(this.dBw, paramArrayOfFloat1, paramArrayOfFloat2);
          ((RenderBuffer)this.FB.get(paramInt)).unbind();
          this.dBw = ((RenderBuffer)this.FB.get(paramInt)).getTexId();
        }
      }
    }
  }
  
  public void init()
  {
    Iterator localIterator = this.mFilterList.iterator();
    while (localIterator.hasNext()) {
      ((GPUBaseFilter)localIterator.next()).init();
    }
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    Object localObject = this.mFilterList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GPUBaseFilter)((Iterator)localObject).next()).onOutputSizeChanged(paramInt1, paramInt2);
    }
    dLZ();
    this.FB = new ArrayList();
    int j = this.mFilterList.size();
    int i = j;
    if (this.cBR) {
      i = j - 1;
    }
    j = 0;
    while (j < i)
    {
      localObject = new RenderBuffer(paramInt1, paramInt2, 33984);
      this.FB.add(localObject);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyv
 * JD-Core Version:    0.7.0.1
 */