import android.os.Handler;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

class dgn
  implements Runnable
{
  dgn(dgm paramdgm) {}
  
  public void run()
  {
    if (this.a.a.e)
    {
      this.a.a.g();
      return;
    }
    this.a.a.h();
    this.a.a.g();
    new Handler().postDelayed(new dgo(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgn
 * JD-Core Version:    0.7.0.1
 */