import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

public class iwx
  extends iwy
{
  int avg = 0;
  int avh = 0;
  int avi = -1;
  int avj = -1;
  int avk = -1;
  WeakReference<View.OnClickListener> bC = null;
  
  public iwx(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, View.OnClickListener paramOnClickListener)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
    this.avg = paramInt5;
    this.avh = paramInt6;
    if (paramOnClickListener != null) {
      this.bC = new WeakReference(paramOnClickListener);
    }
  }
  
  public int lM()
  {
    return 3;
  }
  
  public int lO()
  {
    return this.avg;
  }
  
  public int lP()
  {
    return this.avh;
  }
  
  public int lQ()
  {
    return this.avi;
  }
  
  public int lR()
  {
    return this.avj;
  }
  
  public int lS()
  {
    return this.avk;
  }
  
  public View.OnClickListener r()
  {
    if ((this.bC == null) || (this.bC.isEnqueued())) {
      return null;
    }
    return (View.OnClickListener)this.bC.get();
  }
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.bC = new WeakReference(paramOnClickListener);
      return;
    }
    this.bC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwx
 * JD-Core Version:    0.7.0.1
 */