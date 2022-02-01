import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class aipb
{
  public int BT = -1;
  public int aOw = -1;
  public String albumUrl;
  public Paint.Align b;
  public String bPp;
  public String bPq;
  public boolean ckY = true;
  public boolean ckZ;
  public boolean cla;
  public boolean clb;
  public boolean clc;
  public boolean cld;
  public boolean cle;
  public int deq = -1;
  public int der = -1;
  public int des;
  public int det;
  public int deu;
  public int dev;
  public boolean isForeground = true;
  
  public boolean G(int paramInt, String paramString)
  {
    return (paramInt == this.des) && (TextUtils.equals(paramString, this.bPp)) && (paramInt != 0) && (paramString != null);
  }
  
  public boolean H(int paramInt, String paramString)
  {
    return (paramInt == this.det) && (TextUtils.equals(paramString, this.bPq)) && (paramInt != 0) && (paramString != null);
  }
  
  public boolean apo()
  {
    return (this.des == this.det) && (TextUtils.equals(this.bPp, this.bPq)) && (this.des != 0) && (this.bPp != null);
  }
  
  public void dc(int paramInt, String paramString)
  {
    this.des = paramInt;
    this.bPp = paramString;
  }
  
  public void dd(int paramInt, String paramString)
  {
    this.det = paramInt;
    this.bPq = paramString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatParams[\niconCenterX:").append(this.deq).append("\niconCenterY:").append(this.der).append("\nalignRight:").append(this.ckY).append("\nuserClosed:").append(this.ckZ).append("\nalbumUrl:").append(this.albumUrl).append("\nshowIcon:").append(this.cla).append("\nisForeground:").append(this.isForeground).append("\ntmpGoneForSomePage:").append(this.cld).append("\ncurrentListenType:").append(this.des).append("\ncurrentListenUin:").append(this.bPp).append("\ncurrentAIOType:").append(this.det).append("\ncurrentAIOUin:").append(this.bPq).append("\ntextNeedCenter:").append(this.clc).append("\nshowIconValueChanged:").append(this.clb).append("\n]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipb
 * JD-Core Version:    0.7.0.1
 */