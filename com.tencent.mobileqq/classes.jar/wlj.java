import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class wlj
  implements Runnable
{
  public wlj(TroopActivity paramTroopActivity) {}
  
  public void run()
  {
    if (this.a.e)
    {
      int i = this.a.app.a().b();
      TextView localTextView = (TextView)this.a.findViewById(2131363995);
      ImageView localImageView = (ImageView)this.a.findViewById(2131363994);
      localTextView.setVisibility(0);
      localImageView.setVisibility(0);
      localTextView.setText("" + i);
      if (i <= 0) {
        localTextView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wlj
 * JD-Core Version:    0.7.0.1
 */