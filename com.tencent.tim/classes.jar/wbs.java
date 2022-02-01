import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.PinnedDividerSwipListView;

public class wbs
  implements auuw.b
{
  public wbs(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(auuw.a parama)
  {
    if (parama.id == this.this$0.BL) {
      return;
    }
    this.this$0.BL = parama.id;
    TroopMemberListActivity.a(this.this$0, parama.id);
    if ((this.this$0.BL >= 0) && (this.this$0.BL < TroopMemberListActivity.a(this.this$0).length)) {
      this.this$0.kn.setText(TroopMemberListActivity.a(this.this$0)[this.this$0.BL]);
    }
    if (this.this$0.BL == 0)
    {
      this.this$0.af("Clk_def", this.this$0.aQS, "");
      this.this$0.bXi();
      if (!this.this$0.bby) {
        this.this$0.bby = true;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$c.bSJ();
      }
      if (this.this$0.BL != 0) {
        break label472;
      }
      this.this$0.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, 0);
    }
    for (;;)
    {
      this.this$0.mTitleLayout.setContentDescription(this.this$0.mTitle.getText().toString() + this.this$0.kn.getText().toString());
      return;
      if (this.this$0.BL == 1)
      {
        ((acms)this.this$0.app.getBusinessHandler(20)).Fl(this.this$0.mTroopUin);
        new anov(this.this$0.app).a("dc00899").b("Grp_online").c("mber_list").d("exp_onlineList").a(0).a(new String[] { this.this$0.mTroopUin }).report();
        new anov(this.this$0.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_onlinefirst").a(new String[] { this.this$0.mTroopUin }).report();
        break;
      }
      if (this.this$0.BL == 5)
      {
        ((acms)this.this$0.app.getBusinessHandler(20)).Fm(this.this$0.mTroopUin);
        break;
      }
      if (this.this$0.BL == 2) {}
      for (parama = "Clk_lastactivetime";; parama = "Clk_jointime")
      {
        this.this$0.af(parama, "1", this.this$0.aQS);
        break;
      }
      label472:
      this.this$0.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.this$0.getResources().getDimensionPixelSize(2131299266));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbs
 * JD-Core Version:    0.7.0.1
 */