import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class rkh
{
  protected rkh.a a;
  protected final String aAS;
  protected boolean aHE;
  protected final int bsO;
  protected Context context;
  protected boolean isOpen;
  
  public rkh(Context paramContext, String paramString, int paramInt)
  {
    this.context = paramContext;
    this.aAS = paramString;
    this.bsO = paramInt;
  }
  
  public abstract int J(int paramInt);
  
  public void a(rkh.a parama)
  {
    this.a = parama;
  }
  
  public abstract View d(int paramInt, ViewGroup paramViewGroup);
  
  public abstract void m(int paramInt, View paramView);
  
  public abstract void onClick(int paramInt);
  
  public void setOpen(boolean paramBoolean)
  {
    this.isOpen = paramBoolean;
  }
  
  public void setSelect(boolean paramBoolean)
  {
    this.aHE = paramBoolean;
  }
  
  public int tC()
  {
    return this.bsO;
  }
  
  public abstract int tz();
  
  public static abstract interface a
  {
    public abstract void a(rkh paramrkh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkh
 * JD-Core Version:    0.7.0.1
 */