import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.view.TextHeaderView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahur
  implements View.OnClickListener
{
  public ahur(TextHeaderView paramTextHeaderView, Activity paramActivity, MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(TextHeaderView.a(this.a)))
    {
      Object localObject = new Intent(this.val$activity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", TextHeaderView.a(this.a));
      this.val$activity.startActivityForResult((Intent)localObject, 0);
      localObject = ahtz.b(this.y, 0);
      tbb.a(abmt.getAppInterface(), "769", "205019", (String)localObject, "76901", "1", "160", new String[] { ahtz.t(this.i), "", "20" });
      ((aqrb)abmt.getAppInterface().getBusinessHandler(71)).X(3, this.y.getExtInfoFromExtStr("pa_msgId"), TextHeaderView.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahur
 * JD-Core Version:    0.7.0.1
 */