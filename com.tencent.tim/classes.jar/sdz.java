import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class sdz
  extends sbz
{
  protected WeakReference<Context> mContext;
  
  public sdz(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = new WeakReference(paramContext);
  }
  
  public boolean ME()
  {
    Context localContext = (Context)this.mContext.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public void show()
  {
    if (ME()) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdz
 * JD-Core Version:    0.7.0.1
 */