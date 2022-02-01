import android.content.Context;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.qphone.base.util.QLog;

public class airf
{
  private QQAppInterface app;
  private BaseChatPie c;
  private Context context;
  private SessionInfo sessionInfo;
  
  public airf(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.app = paramQQAppInterface;
    this.c = paramBaseChatPie;
    init();
  }
  
  private void dtZ()
  {
    LocationShareFragment.c(this.c.a(), this.c.sessionInfo.cZ, this.c.sessionInfo.aTl, 1);
    anot.a(null, "CliOper", "", "", "0X800A763", "0X800A763", 0, 0, "", "0", "0", "");
  }
  
  private void dua()
  {
    wmj.a(this.app, this.c.a());
    if (this.c != null) {
      this.c.a().setCanLock(false);
    }
    xro.i(this.app, "0X800407F", this.sessionInfo.cZ);
  }
  
  private void init()
  {
    if (this.c != null)
    {
      this.context = this.c.a();
      this.sessionInfo = this.c.a();
    }
  }
  
  public void show()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationSheet", 2, new Object[] { "show: invoked. ", " sessionInfo: ", this.sessionInfo });
    }
    if ((this.context == null) || (this.c == null) || (this.sessionInfo == null)) {
      return;
    }
    Object localObject = (acff)this.app.getManager(51);
    if (((this.c instanceof xyi)) || (this.sessionInfo.aTl.equals(this.app.getCurrentUin())) || ((this.sessionInfo.cZ == 0) && (!((acff)localObject).isFriend(this.sessionInfo.aTl))))
    {
      dua();
      return;
    }
    localObject = ausj.b(this.context);
    ((ausj)localObject).addButton(2131719489, 0);
    ((ausj)localObject).addButton(2131720167, 0);
    ((ausj)localObject).addCancelButton(2131721058);
    ((ausj)localObject).a(new airg(this, (ausj)localObject));
    ((ausj)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airf
 * JD-Core Version:    0.7.0.1
 */