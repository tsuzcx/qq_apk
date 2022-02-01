import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

public class ahhf
  extends ahgq
{
  public ahhf(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean anl()
  {
    Intent localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
    localIntent.putExtras(this.bf);
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhf
 * JD-Core Version:    0.7.0.1
 */