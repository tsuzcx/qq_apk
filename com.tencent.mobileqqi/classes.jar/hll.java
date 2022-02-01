import com.tencent.open.applist.H5ConfirmDialog.Dialogcallback;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;

public class hll
  implements H5ConfirmDialog.Dialogcallback
{
  public hll(WebAppActivity paramWebAppActivity) {}
  
  public void a(boolean paramBoolean)
  {
    LogUtility.c("WebAppActivity", " createIcon = " + paramBoolean);
    if (paramBoolean) {
      this.a.a(this.a.h, this.a.h, true);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hll
 * JD-Core Version:    0.7.0.1
 */