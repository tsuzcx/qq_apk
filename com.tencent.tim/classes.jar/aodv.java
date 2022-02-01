import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aodv
  implements View.OnClickListener
{
  public aodv(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    aodi.a locala = (aodi.a)paramView.getTag();
    if (locala.dOb == aodi.dOa)
    {
      aobw.h(this.this$0.app, "0X8009938");
      aobw.a(this.this$0.app, this.this$0, 2, "group_online_doc_more_temp", this.this$0.aoW, GroupTeamWorkListActivity.a(this.this$0), this.this$0.app.getLongAccountUin());
      anot.a(this.this$0.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.this$0), "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ahbr.a(this.this$0.app, this.this$0.aoW, this.this$0.app.getLongAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(this.this$0, str, 0).show();
      }
      else
      {
        aobw.h(this.this$0.app, "0X8009937");
        aobw.a(this.this$0.app, this.this$0, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.this$0), locala.a);
        anot.a(this.this$0.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.this$0), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aodv
 * JD-Core Version:    0.7.0.1
 */