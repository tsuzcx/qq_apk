import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class aiu
  implements CompoundButton.OnCheckedChangeListener
{
  public aiu(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = (FriendsManagerImp)this.a.app.getManager(8);
    Object localObject = paramCompoundButton.a(DiscussionInfoCardActivity.a(this.a), this.a.app.a());
    int i = ((DiscussionMemberInfo)localObject).flag;
    if (paramBoolean)
    {
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag & 0xFFFFFFFE));
      if (i != ((DiscussionMemberInfo)localObject).flag)
      {
        byte b = (byte)(((DiscussionMemberInfo)localObject).flag & 0x1);
        paramCompoundButton.a((DiscussionMemberInfo)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d(DiscussionInfoCardActivity.c(), 4, "DiscussionMemberInfo.flag changed save now:" + ((DiscussionMemberInfo)localObject).flag + " flag:" + b);
        }
        DiscussionInfoCardActivity.a(this.a).a(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue(), b);
      }
      localObject = this.a.app;
      if (!paramBoolean) {
        break label215;
      }
    }
    label215:
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, paramCompoundButton, "", "", "");
      return;
      ((DiscussionMemberInfo)localObject).flag = ((byte)(((DiscussionMemberInfo)localObject).flag | 0x1));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aiu
 * JD-Core Version:    0.7.0.1
 */