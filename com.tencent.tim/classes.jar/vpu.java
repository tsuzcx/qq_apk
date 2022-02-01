import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.31.1;
import com.tencent.mobileqq.activity.QQSettingMe.31.2;
import com.tencent.mobileqq.activity.QQSettingMe.31.3;
import com.tencent.mobileqq.activity.QQSettingMe.31.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vpu
  extends accn
{
  public vpu(QQSettingMe paramQQSettingMe) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.this$0.isResume) && (this.this$0.app != null) && ((paramObject instanceof Card)) && (this.this$0.app.getCurrentAccountUin().equals(((Card)paramObject).uin)))
      {
        this.this$0.c.runOnUiThread(new QQSettingMe.31.1(this));
        ThreadManager.post(new QQSettingMe.31.2(this), 5, null, true);
        return;
      }
    } while ((!paramBoolean) || (this.this$0.app == null) || (!(paramObject instanceof Card)) || (this.this$0.isResume) || (!this.this$0.app.getCurrentAccountUin().equals(((Card)paramObject).uin)));
    ThreadManager.post(new QQSettingMe.31.3(this, (Card)paramObject), 5, null, true);
  }
  
  protected void onGetMedal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.this$0.isResume)) {
      QQSettingMe.a(this.this$0, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onGetMedal [%b, %b] medalSwitchDisable= ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.this$0.isResume), Boolean.valueOf(paramBoolean2) }));
    }
  }
  
  protected void onGetSignInInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new QQSettingMe.31.4(this));
    }
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.this$0.isResume)) {
      QQSettingMe.a(this.this$0, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onSetMedal [%b %b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.this$0.isResume) }));
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.this$0.isResume) && (this.this$0.app != null) && (aqft.equalsWithNullCheck(paramString, this.this$0.app.getCurrentAccountUin()))) {
      this.this$0.wd(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vpu
 * JD-Core Version:    0.7.0.1
 */