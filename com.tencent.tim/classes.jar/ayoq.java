import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class ayoq
{
  public final String aAH;
  public String aAI;
  public final int bsq;
  public final int bsr;
  
  public ayoq(int paramInt1, String paramString, int paramInt2)
  {
    this.bsq = paramInt1;
    this.aAH = paramString;
    this.bsr = paramInt2;
  }
  
  public boolean LD()
  {
    return false;
  }
  
  @NonNull
  public abstract ayoq.a a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  @NonNull
  public abstract Class<? extends ayoq.a> c();
  
  public String toString()
  {
    return "Filter:{" + this.aAH + "}";
  }
  
  public static abstract class a<T extends ayoq>
  {
    public T a;
    public final View mItemView = b(paramContext, paramViewGroup);
    protected int mPosition;
    
    protected a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      if (this.mItemView == null) {
        throw new NullPointerException("onCreateView can not return null");
      }
    }
    
    public boolean LD()
    {
      return (this.a != null) && (this.a.LD());
    }
    
    public void a(T paramT, int paramInt)
    {
      this.a = paramT;
      this.mPosition = paramInt;
    }
    
    protected abstract View b(@NonNull Context paramContext, ViewGroup paramViewGroup);
    
    public void buT()
    {
      this.a = null;
      this.mPosition = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayoq
 * JD-Core Version:    0.7.0.1
 */