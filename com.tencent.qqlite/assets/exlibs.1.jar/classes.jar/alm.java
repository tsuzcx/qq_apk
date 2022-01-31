import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;

public final class alm
  implements Runnable
{
  public alm(Context paramContext) {}
  
  public void run()
  {
    QQToast.a(this.a.getApplicationContext(), this.a.getString(2131363409), 0).b(this.a.getResources().getDimensionPixelSize(2131492887));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alm
 * JD-Core Version:    0.7.0.1
 */