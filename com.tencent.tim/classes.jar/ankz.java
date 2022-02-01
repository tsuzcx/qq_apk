import android.opengl.GLES20;
import com.tencent.maxvideo.common.AVIOStruct;
import java.util.concurrent.atomic.AtomicInteger;

public class ankz
{
  private anky[] a = new anky[3];
  private AtomicInteger bT = new AtomicInteger(0);
  private int[] mPreviewTextureId = new int[3];
  
  private boolean ayj()
  {
    return this.bT.get() == 1;
  }
  
  public void a(anky.b paramb)
  {
    if (ayj())
    {
      int i = 0;
      while (i < this.a.length)
      {
        this.a[i].a(paramb);
        i += 1;
      }
    }
  }
  
  public boolean ayi()
  {
    if (!ayj()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.a.length)
      {
        if (this.a[i].getTexureCurrentStatus() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boolean ayk()
  {
    int i = 0;
    if (!ayj()) {
      return false;
    }
    while (i < this.a.length)
    {
      this.a[i].makeFree();
      i += 1;
    }
    return true;
  }
  
  public anky b()
  {
    if (!ayj()) {
      return null;
    }
    int i = 0;
    anky localanky;
    if (i < this.a.length) {
      if (this.a[i].JU() == 0)
      {
        localanky = this.a[i];
        localanky.makeBusy();
      }
    }
    for (;;)
    {
      return localanky;
      i += 1;
      break;
      localanky = null;
    }
  }
  
  public anky c()
  {
    if (!ayj()) {
      return null;
    }
    int i = 0;
    anky localanky;
    if (i < this.a.length)
    {
      if (this.a[i].JV() == 0) {}
      while (this.a[i].getTexureCurrentStatus() != 0)
      {
        i += 1;
        break;
      }
      localanky = this.a[i];
      localanky.makeBusy();
    }
    for (;;)
    {
      return localanky;
      localanky = null;
    }
  }
  
  public anky d()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!ayj()) {}
    int i;
    label18:
    do
    {
      return localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.a.length);
    anky localanky;
    if (this.a[i].getTexureCurrentStatus() == 2)
    {
      localanky = this.a[i];
      if (localObject1 == null) {
        localObject1 = localanky;
      }
    }
    for (;;)
    {
      i += 1;
      break label18;
      AVIOStruct localAVIOStruct = (AVIOStruct)localObject1.a.eW;
      localObject2 = (AVIOStruct)localanky.a.eW;
      long l = localAVIOStruct.vFrameTime;
      if (((AVIOStruct)localObject2).vFrameTime > l)
      {
        localObject2 = localObject1;
        if (localAVIOStruct.pFrameIndex == 0) {
          break;
        }
        localObject1.makeFree();
        localObject1 = localanky;
        continue;
      }
      localanky.makeFree();
    }
  }
  
  public void dRr()
  {
    int i = 0;
    GLES20.glGenTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
    while (i < this.a.length)
    {
      this.a[i] = new anky(this.mPreviewTextureId[i]);
      i += 1;
    }
    this.bT.getAndSet(1);
  }
  
  public void dRs()
  {
    if (this.bT.getAndSet(0) == 1)
    {
      GLES20.glDeleteTextures(this.mPreviewTextureId.length, this.mPreviewTextureId, 0);
      int i = 0;
      while (i < this.a.length)
      {
        if (this.a[i] != null)
        {
          this.a[i].release();
          this.a[i] = null;
        }
        this.mPreviewTextureId[i] = 0;
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankz
 * JD-Core Version:    0.7.0.1
 */