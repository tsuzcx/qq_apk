import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class ydh
  extends yax
{
  protected WeakReference<Context> a;
  
  public ydh(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.a = new WeakReference(paramContext);
  }
  
  public boolean a()
  {
    Context localContext = (Context)this.a.get();
    return ((localContext instanceof Activity)) && (((Activity)localContext).isFinishing());
  }
  
  public void show()
  {
    if (a()) {
      return;
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydh
 * JD-Core Version:    0.7.0.1
 */