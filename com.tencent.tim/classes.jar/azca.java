import java.util.concurrent.atomic.AtomicInteger;

public class azca
{
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public azca.a a;
  private azca.b a;
  private AtomicInteger bS;
  private AtomicInteger mTextureDataFlag;
  public int mTextureId;
  
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
    azca.a locala = this.jdField_a_of_type_Azca$a;
    if (paramInt == 1) {}
    for (;;)
    {
      locala.bEX = bool;
      this.jdField_a_of_type_Azca$a.eW = paramObject;
      this.jdField_a_of_type_Azca$a.mFrontCamera = paramBoolean;
      return;
      bool = false;
    }
  }
  
  public void dRp()
  {
    if (this.jdField_a_of_type_Azca$b != null)
    {
      this.jdField_a_of_type_Azca$b.onFrameAvailable();
      return;
    }
    makeFree();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azca
 * JD-Core Version:    0.7.0.1
 */