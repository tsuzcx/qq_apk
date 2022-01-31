import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;

class ciz
  implements Runnable
{
  ciz(ciy paramciy) {}
  
  public void run()
  {
    if ((PhotoListActivity.a(this.a.a)) && (this.a.a.a == null))
    {
      PhotoListActivity.a(this.a.a, false);
      this.a.a.a = new cjc(this.a.a, null);
      this.a.a.a.execute(new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ciz
 * JD-Core Version:    0.7.0.1
 */