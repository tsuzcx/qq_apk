package dov.com.qq.im.ae.camera.ui.topbar;

import android.support.annotation.Nullable;
import axzu;
import axzy;

public class AEVideoStoryTopBarViewModel
  extends axzy
{
  public final axzu<Ratio> d = new axzu();
  private axzu<a> e = new axzu();
  private axzu<Boolean> f = new axzu();
  
  public axzu<a> b()
  {
    return this.e;
  }
  
  public axzu<Boolean> c()
  {
    return this.f;
  }
  
  public static abstract enum Ratio
  {
    FULL(4),  R_1_1(11);
    
    public final int code;
    
    private Ratio(int paramInt)
    {
      this.code = paramInt;
    }
    
    @Nullable
    public static Ratio fromCode(int paramInt)
    {
      Ratio[] arrayOfRatio = values();
      int j = arrayOfRatio.length;
      int i = 0;
      while (i < j)
      {
        Ratio localRatio = arrayOfRatio[i];
        if (localRatio.code == paramInt) {
          return localRatio;
        }
        i += 1;
      }
      return null;
    }
    
    public abstract Ratio next();
  }
  
  public static class a
  {
    private int count;
    private boolean enable;
    
    public a(boolean paramBoolean, int paramInt)
    {
      this.enable = paramBoolean;
      this.count = paramInt;
    }
    
    public int getCount()
    {
      return this.count;
    }
    
    public boolean getEnable()
    {
      return this.enable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel
 * JD-Core Version:    0.7.0.1
 */