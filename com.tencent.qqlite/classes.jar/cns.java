import android.app.Dialog;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

class cns
  implements Runnable
{
  cns(cnr paramcnr) {}
  
  public void run()
  {
    try
    {
      if (!this.a.a.isFinishing())
      {
        this.a.a.a.dismiss();
        this.a.a.finish();
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cns
 * JD-Core Version:    0.7.0.1
 */