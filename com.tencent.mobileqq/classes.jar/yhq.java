import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

public class yhq
  extends yfg
{
  protected WeakReference<Context> a;
  
  public yhq(Context paramContext, int paramInt)
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
 * Qualified Name:     yhq
 * JD-Core Version:    0.7.0.1
 */