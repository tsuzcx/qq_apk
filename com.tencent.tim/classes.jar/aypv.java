import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class aypv
{
  protected aypv.a a;
  protected final String aAS;
  protected boolean aHE;
  protected final int bsO;
  protected final String cXO;
  protected Context context;
  protected boolean enable = true;
  protected boolean isOpen;
  
  public aypv(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.context = paramContext;
    this.aAS = paramString1;
    this.cXO = paramString2;
    this.bsO = paramInt;
  }
  
  public abstract int J(int paramInt);
  
  public void a(aypv.a parama)
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
    public abstract void a(aypv paramaypv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypv
 * JD-Core Version:    0.7.0.1
 */