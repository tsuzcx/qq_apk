import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;

class bbk
  implements Runnable
{
  bbk(bbj parambbj) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem = this.a.a.c;
    if (TextUtils.isEmpty(ProfileCardMoreActivity.b(this.a.a))) {}
    for (String str = "";; str = ProfileCardMoreActivity.b(this.a.a))
    {
      localFormSimpleItem.setRightText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bbk
 * JD-Core Version:    0.7.0.1
 */