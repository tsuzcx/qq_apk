import android.content.Context;
import android.view.Window;

public class jln
  extends ausj
{
  public static boolean aaj;
  boolean aak = false;
  
  protected jln(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  public static jln a(Context paramContext)
  {
    paramContext = new jln(paramContext, false, false);
    paramContext.getWindow().setWindowAnimations(2131755426);
    return paramContext;
  }
  
  public static boolean xR()
  {
    return aaj;
  }
  
  public void dismiss()
  {
    aaj = false;
    this.aak = false;
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    if (this.aak)
    {
      aaj = false;
      this.aak = false;
    }
    super.onDetachedFromWindow();
  }
  
  public void onStop()
  {
    if (this.aak)
    {
      aaj = false;
      this.aak = false;
    }
    super.onStop();
  }
  
  public void show()
  {
    if (aaj == true) {
      return;
    }
    aaj = true;
    this.aak = true;
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jln
 * JD-Core Version:    0.7.0.1
 */