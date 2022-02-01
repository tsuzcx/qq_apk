import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.PinnedDividerSwipListView;

public class zik
  implements auuw.b
{
  public zik(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void a(auuw.a parama)
  {
    if (parama.id == this.this$0.BL) {
      return;
    }
    this.this$0.BL = parama.id;
    ChatHistoryTroopMemberFragment.a(this.this$0, parama.id);
    if ((this.this$0.BL >= 0) && (this.this$0.BL < ChatHistoryTroopMemberFragment.a(this.this$0).length)) {
      this.this$0.kn.setText(ChatHistoryTroopMemberFragment.a(this.this$0)[this.this$0.BL]);
    }
    if (this.this$0.BL == 0)
    {
      this.this$0.af("Clk_def", this.this$0.aQS, "");
      this.this$0.bXi();
      if (!this.this$0.bby) {
        this.this$0.bby = true;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$c.bSJ();
      }
      if (this.this$0.BL != 0) {
        break label433;
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
      if (this.this$0.BL == 2) {}
      for (parama = "Clk_lastactivetime";; parama = "Clk_jointime")
      {
        this.this$0.af(parama, "1", this.this$0.aQS);
        break;
      }
      label433:
      this.this$0.jdField_a_of_type_ComTencentWidgetPinnedDividerSwipListView.setSelectionFromTop(0, -this.this$0.getResources().getDimensionPixelSize(2131299266));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zik
 * JD-Core Version:    0.7.0.1
 */