import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zbg
  implements View.OnClickListener
{
  public zbg(PublicAccountFragment.b paramb) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str1 = (String)paramView.getTag(-1);
      String str2 = (String)paramView.getTag(-2);
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Contacts.PublicAccountFragment", 2, "onClick - uin = " + str1 + ", name = " + str2);
        }
      }
      else {
        jqs.a(PublicAccountFragment.a(this.b.this$0), PublicAccountFragment.b(this.b.this$0), str2, str1, "IvrEnterpriseDetailEngineFalse");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbg
 * JD-Core Version:    0.7.0.1
 */