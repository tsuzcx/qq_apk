import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class zon
  extends zof
{
  public zon(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  private void cqD()
  {
    if (!this.brV) {}
    while (this.vr == null) {
      return;
    }
    this.vr.setOnClickListener(null);
    if (ixa.a().cD(this.mApp.getCurrentAccountUin()))
    {
      this.vr.setVisibility(0);
      this.vr.setContentDescription(this.mContext.getResources().getString(2131700701));
      return;
    }
    this.vr.setVisibility(8);
  }
  
  protected void Ib()
  {
    this.TAG = "MiniPieForDisc";
  }
  
  protected boolean Vz()
  {
    return true;
  }
  
  protected void aC()
  {
    super.aC();
    cqD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zon
 * JD-Core Version:    0.7.0.1
 */