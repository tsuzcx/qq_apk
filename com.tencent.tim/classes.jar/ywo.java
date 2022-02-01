import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ywo
  implements View.OnClickListener
{
  ywo(ywk paramywk) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    if ((localRecommendTroopItem == null) || (TextUtils.isEmpty(localRecommendTroopItem.uin))) {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ackn.a(this.a.mApp, 2, localRecommendTroopItem.uin, new ywp(this));
      this.a.kO.remove(localRecommendTroopItem);
      this.a.notifyDataSetChanged();
      if ((this.a.kO != null) && (this.a.kO.size() == 0)) {
        this.a.b.c().sendEmptyMessage(100);
      }
      if (ywk.a(this.a) != null)
      {
        ackn localackn = (ackn)ywk.a(this.a).getManager(22);
        if ((this.a.kO != null) && (this.a.kO.size() == 0)) {
          localackn.JE(1);
        }
        localackn.EK(localRecommendTroopItem.uin);
      }
      anot.a(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, localRecommendTroopItem.uin, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywo
 * JD-Core Version:    0.7.0.1
 */