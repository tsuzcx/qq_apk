import android.graphics.drawable.Drawable;

public class iwy
  extends iww
{
  protected Drawable cd;
  protected String mIconUrl;
  protected int xN = 0;
  
  public iwy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
  }
  
  public iwy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString1);
    this.mIconUrl = paramString2;
    this.xN = paramInt5;
  }
  
  public void A(Drawable paramDrawable)
  {
    this.cd = paramDrawable;
  }
  
  public Drawable getDrawable()
  {
    return this.cd;
  }
  
  public String getIconUrl()
  {
    return this.mIconUrl;
  }
  
  public int lM()
  {
    return 1;
  }
  
  public int lT()
  {
    return this.xN;
  }
  
  public void lZ(int paramInt)
  {
    this.xN = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwy
 * JD-Core Version:    0.7.0.1
 */