import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

class emy
  implements Runnable
{
  emy(emx paramemx) {}
  
  public void run()
  {
    if ((PhotoListActivity.a(this.a.a)) && (this.a.a.a == null))
    {
      PhotoListActivity.a(this.a.a, false);
      this.a.a.a = new enb(this.a.a, null);
      this.a.a.a.execute(new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emy
 * JD-Core Version:    0.7.0.1
 */