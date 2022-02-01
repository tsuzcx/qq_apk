import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

class auct
  implements View.OnClickListener
{
  auct(aucs paramaucs, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.val$app, "CliOper", "", "", "0X8008D2D", "0X8008D2D", 0, 0, "", "", "", "");
    aucs.a(this.this$0, aukp.a(this.val$app, this.b, this.this$0.mContext, "FileBrowserViewBase", this.this$0.mContext.getString(2131720932), true));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auct
 * JD-Core Version:    0.7.0.1
 */