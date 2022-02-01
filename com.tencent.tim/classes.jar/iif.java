import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.app.VideoAppInterface;

class iif
  extends BroadcastReceiver
{
  iif(iie paramiie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", 0);
    if ((iie.a(this.a) != null) && (iie.a(this.a).a != null))
    {
      ((ikr)iie.a(this.a).a(4)).kS(i);
      ikp.r(18, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iif
 * JD-Core Version:    0.7.0.1
 */