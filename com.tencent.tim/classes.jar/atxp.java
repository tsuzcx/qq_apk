import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

final class atxp
  implements View.OnClickListener
{
  atxp(String paramString, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.bIW);
    Intent localIntent = new Intent();
    localIntent.putExtra("cmd", "send_mail_chatrecord");
    localIntent.putStringArrayListExtra("mail_attachment_path", localArrayList);
    ((augo)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getManager(374)).g(this.val$activity, localIntent, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxp
 * JD-Core Version:    0.7.0.1
 */