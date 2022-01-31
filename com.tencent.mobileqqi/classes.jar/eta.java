import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.BaseActivityView.IPhoneContext;
import com.tencent.mobileqq.activity.voip.VoipAddressBookActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FakeImageView;
import com.tencent.mobileqq.widget.FakeTextView;
import mqq.app.MobileQQ;

public class eta
  implements BaseActivityView.IPhoneContext
{
  public eta(VoipAddressBookActivity paramVoipAddressBookActivity) {}
  
  public View a()
  {
    return new View(this.a.b.getApplication().getApplicationContext());
  }
  
  public ImageView a()
  {
    return new FakeImageView(this.a.b.getApplication().getApplicationContext());
  }
  
  public TextView a()
  {
    return new FakeTextView(this.a.b.getApplication().getApplicationContext());
  }
  
  public QQAppInterface a()
  {
    return this.a.b;
  }
  
  public View b()
  {
    return new View(this.a.b.getApplication().getApplicationContext());
  }
  
  public TextView b()
  {
    return new FakeTextView(this.a.b.getApplication().getApplicationContext());
  }
  
  public TextView c()
  {
    return new FakeTextView(this.a.b.getApplication().getApplicationContext());
  }
  
  public TextView d()
  {
    return new FakeTextView(this.a.b.getApplication().getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eta
 * JD-Core Version:    0.7.0.1
 */