import java.util.concurrent.atomic.AtomicInteger;

public class anky
{
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public anky.a a = new anky.a();
  private anky.b b;
  private AtomicInteger bS = new AtomicInteger(0);
  private Object eV = new Object();
  private AtomicInteger mTextureDataFlag = new AtomicInteger(0);
  public int mTextureId;
  
  public anky(int paramInt)
  {
    this.mTextureId = paramInt;
  }
  
  public int JU()
  {
    return this.bS.getAndSet(1);
  }
  
  public int JV()
  {
    return this.bS.getAndAdd(0);
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    boolean bool = true;
    anky.a locala = this.a;
    if (paramInt == 1) {}
    for (;;)
    {
      locala.bEX = bool;
      this.a.eW = paramObject;
      this.a.mFrontCamera = paramBoolean;
      return;
      bool = false;
    }
  }
  
  public void a(anky.b paramb)
  {
    this.b = paramb;
  }
  
  public void dRp()
  {
    if (this.b != null)
    {
      this.b.onFrameAvailable();
      return;
    }
    makeFree();
  }
  
  public void dRq()
  {
    this.mTextureDataFlag.getAndSet(3);
  }
  
  public int getTexureCurrentStatus()
  {
    return this.mTextureDataFlag.getAndAdd(0);
  }
  
  public void makeBusy()
  {
    this.mTextureDataFlag.getAndSet(1);
  }
  
  public void makeDataReady()
  {
    this.mTextureDataFlag.getAndSet(2);
  }
  
  public void makeFree()
  {
    this.mTextureDataFlag.getAndSet(0);
  }
  
  public void release()
  {
    this.mTextureId = 0;
  }
  
  public static class a
  {
    public boolean bEX;
    public Object eW;
    public boolean mFrontCamera;
  }
  
  public static abstract interface b
  {
    public abstract void onFrameAvailable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anky
 * JD-Core Version:    0.7.0.1
 */