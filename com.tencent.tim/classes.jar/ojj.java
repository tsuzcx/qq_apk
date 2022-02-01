import UserGrowth.stSimpleMetaFeed;
import android.view.ViewGroup;

public class ojj
{
  public static auwn<stSimpleMetaFeed> a(int paramInt, ViewGroup paramViewGroup, ofv paramofv)
  {
    return oji.a(paramViewGroup, paramofv, paramInt);
  }
  
  public static ojj.a a(int paramInt)
  {
    ojj.a locala = new ojj.a();
    locala.cardType = paramInt;
    locala.axt = en(paramInt);
    locala.axu = eo(paramInt);
    locala.axv = ep(paramInt);
    locala.axw = eq(paramInt);
    locala.axx = er(paramInt);
    locala.axy = es(paramInt);
    return locala;
  }
  
  public static boolean em(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3) || (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10);
  }
  
  private static boolean en(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7);
  }
  
  private static boolean eo(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  private static boolean ep(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static boolean eq(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3);
  }
  
  private static boolean er(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7);
  }
  
  private static boolean es(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 7) || (paramInt == 8);
  }
  
  public static class a
  {
    public boolean axt;
    public boolean axu;
    public boolean axv;
    public boolean axw;
    public boolean axx;
    public boolean axy;
    public int cardType;
    
    public String toString()
    {
      return "Type{cardType=" + this.cardType + ", isOuterDescStyle=" + this.axt + ", isInnerInfoStyle=" + this.axu + ", isPlayAndLikeStyle=" + this.axv + ", isOnlyInnerStyle=" + this.axw + ", isOnlyOuterStyle=" + this.axx + ", isPlayCountStyle=" + this.axy + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojj
 * JD-Core Version:    0.7.0.1
 */