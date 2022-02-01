import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adtq
  implements CompoundButton.OnCheckedChangeListener
{
  public adtq(ArkAuthorityInfoActivity paramArkAuthorityInfoActivity, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str1 = ArkAuthorityInfoActivity.a(this.a);
    String str2 = ArkAuthorityInfoActivity.j()[this.val$index];
    String str3 = this.a.app.getCurrentAccountUin();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      adnq.c.p(str1, str2, str3, i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtq
 * JD-Core Version:    0.7.0.1
 */