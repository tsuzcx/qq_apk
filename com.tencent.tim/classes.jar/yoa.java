import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yoa
  implements View.OnClickListener
{
  public yoa(ClassificationSearchFragment.a parama) {}
  
  public void onClick(View paramView)
  {
    kbq.c localc = (kbq.c)paramView.getTag();
    Object localObject = (acja)this.b.this$0.app.getManager(56);
    if ((localObject != null) && (((acja)localObject).c(localc.mUin) != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = new Intent(this.b.this$0.d(), ChatActivity.class);
        if (localc.ady)
        {
          ((Intent)localObject).putExtra("uintype", 1008);
          ((Intent)localObject).putExtra("uin", localc.mUin);
          ((Intent)localObject).putExtra("uinname", localc.mName);
          ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
          this.b.this$0.d().startActivity((Intent)localObject);
          if (!ClassificationSearchFragment.a.a(this.b)) {
            break label376;
          }
        }
      }
      label376:
      for (localObject = "houtai";; localObject = "duan")
      {
        kbp.a(this.b.this$0.app, localc.mUin, "0X8007404", "0X8007404", 0, 0, "", "", (String)localObject, "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("clickRecommendAccount->");
          localStringBuilder.append("source:").append((String)localObject);
          localStringBuilder.append(", puin:").append(localc.mUin);
          localStringBuilder.append(", isFollow:").append(bool);
          QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ((Intent)localObject).putExtra("uintype", 1024);
        break;
        if (localc.ady)
        {
          localObject = new Intent(this.b.this$0.d(), AccountDetailActivity.class);
          ((Intent)localObject).putExtra("uintype", 1008);
          ((Intent)localObject).putExtra("source", 118);
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("uin", localc.mUin);
          ((Intent)localObject).addFlags(67108864);
          this.b.this$0.d().startActivity((Intent)localObject);
          break;
          localObject = jqs.a(this.b.this$0.d(), null, "", false, -1, false, -1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoa
 * JD-Core Version:    0.7.0.1
 */