import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

class ajse
  extends BroadcastReceiver
{
  ajse(ajrz paramajrz) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("SmallScreenState", 0);
    if (i == 3) {
      this.b.mView.setVisibility(4);
    }
    while ((i != 2) && (i != 0)) {
      return;
    }
    this.b.mView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajse
 * JD-Core Version:    0.7.0.1
 */