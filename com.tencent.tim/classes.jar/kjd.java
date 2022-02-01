import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class kjd
  extends acje
{
  public kjd(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (paramLong != 2171946401L) {
      return;
    }
    Object localObject = this.this$0;
    ((ReadInJoySettingActivity)localObject).aDG -= 1;
    if ((this.this$0.aDG == 0) && (this.this$0.mProgress != null) && (this.this$0.mProgress.isShowing())) {
      this.this$0.mProgress.dismiss();
    }
    boolean bool;
    if (paramInt == this.this$0.aJl)
    {
      bool = ReadInJoySettingActivity.a(this.this$0);
      if (!paramBoolean) {
        break label202;
      }
      localObject = ReadInJoySettingActivity.a(this.this$0);
      if (bool) {
        break label168;
      }
      paramBoolean = true;
      ((Switch)localObject).setChecked(paramBoolean);
      if (!bool) {
        break label173;
      }
      kbp.a(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", kxm.iQ(), false);
      label147:
      ReadInJoySettingActivity.a(this.this$0).mR(bool);
    }
    for (;;)
    {
      this.this$0.afG = false;
      return;
      label168:
      paramBoolean = false;
      break;
      label173:
      kbp.a(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", kxm.iQ(), false);
      break label147;
      label202:
      QQToast.a(this.this$0.getApplicationContext(), 2131701904, 0).show();
      this.this$0.afI = true;
      ReadInJoySettingActivity.a(this.this$0).setChecked(bool);
      QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjd
 * JD-Core Version:    0.7.0.1
 */