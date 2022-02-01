import android.util.SparseArray;

public class swx
{
  public String aHI;
  public boolean aNO = true;
  public SparseArray<swx.a> bk = new SparseArray(3);
  public int bzO = 4;
  public int delay;
  
  public swx(String paramString)
  {
    this.aHI = paramString;
  }
  
  public swx.a a(int paramInt)
  {
    swx.a locala2 = (swx.a)this.bk.get(paramInt);
    swx.a locala1 = locala2;
    if (locala2 == null)
    {
      if (paramInt != 1) {
        break label40;
      }
      locala1 = new swx.a(85, 5, 0.7F, 0.2F);
    }
    label40:
    do
    {
      return locala1;
      if (paramInt == 2) {
        return new swx.a(80, 15, 0.9F, 0.4F);
      }
      locala1 = locala2;
    } while (paramInt != 3);
    return new swx.a(75, 30, 1.0F, 0.7F);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ClearMemoryConfig{");
    localStringBuilder.append("DpcConfigId='").append(this.aHI).append('\'');
    localStringBuilder.append(", isClearEnable=").append(this.aNO);
    localStringBuilder.append(", delay=").append(this.delay);
    localStringBuilder.append(", clearStep=").append(this.bzO);
    localStringBuilder.append(", clearLevels=").append(this.bk);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public int bzP;
    public int delayTime;
    public float ow;
    public float ox;
    
    public a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
    {
      this.bzP = paramInt1;
      this.delayTime = paramInt2;
      this.ow = paramFloat1;
      this.ox = paramFloat2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MemoryLevelInfo{");
      localStringBuilder.append("MemoryPercent=").append(this.bzP);
      localStringBuilder.append(", delayTime=").append(this.delayTime);
      localStringBuilder.append(", maxCacheSize=").append(this.ow);
      localStringBuilder.append(", trimPercent=").append(this.ox);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swx
 * JD-Core Version:    0.7.0.1
 */