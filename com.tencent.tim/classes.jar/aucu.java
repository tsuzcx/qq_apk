import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

class aucu
  implements View.OnClickListener
{
  aucu(aucs paramaucs, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.val$app, "CliOper", "", "", "0X8008A32", "0X8008A32", 0, 0, "", "", "", "");
    aucs.a(this.this$0, aukp.a(this.val$app, this.b, this.this$0.mContext, "FileBrowserViewBase", this.this$0.mContext.getString(2131720933), false));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucu
 * JD-Core Version:    0.7.0.1
 */