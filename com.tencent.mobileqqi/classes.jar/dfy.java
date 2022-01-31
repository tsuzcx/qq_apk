import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

class dfy
  implements Runnable
{
  dfy(dfx paramdfx) {}
  
  public void run()
  {
    if ((ProfileCardMoreActivity.b(this.a.a) != null) && (ProfileCardMoreActivity.b(this.a.a).equals("我的好友"))) {
      ProfileCardMoreActivity.a(this.a.a, this.a.a.getString(2131559856));
    }
    FormSimpleItem localFormSimpleItem = this.a.a.c;
    if (TextUtils.isEmpty(ProfileCardMoreActivity.b(this.a.a))) {}
    for (String str = "";; str = ProfileCardMoreActivity.b(this.a.a))
    {
      localFormSimpleItem.setRightText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dfy
 * JD-Core Version:    0.7.0.1
 */