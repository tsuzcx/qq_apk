import android.app.Activity;
import com.tencent.tim.timfiletab.dialog.FileApplicationDialog.2.1;
import java.lang.ref.WeakReference;

public class aunn
  extends atsn
{
  protected void bd(int paramInt, String paramString)
  {
    auds.JD(paramString);
  }
  
  protected void wG(boolean paramBoolean)
  {
    if ((aunl.a(this.a) != null) && (aunl.a(this.a).get() != null))
    {
      Activity localActivity = (Activity)aunl.a(this.a).get();
      localActivity.runOnUiThread(new FileApplicationDialog.2.1(this, paramBoolean, localActivity));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunn
 * JD-Core Version:    0.7.0.1
 */