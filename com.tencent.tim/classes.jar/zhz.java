import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29.1;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29.2;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class zhz
  implements ausj.a
{
  public zhz(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!ChatHistoryTroopMemberFragment.c(this.this$0)) && (paramInt >= 5)) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.this$0.aUo) {
        if (paramInt == 0) {
          this.this$0.mHandler.postDelayed(new ChatHistoryTroopMemberFragment.29.1(this), 320L);
        }
      }
      for (;;)
      {
        if ((this.this$0.mActionSheet != null) && (this.this$0.mActionSheet.isShowing())) {
          this.this$0.mActionSheet.dismiss();
        }
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.history.BaseFragment", 2, "mOnActionSheetClickListener.OnClick, error : which = " + paramInt + ", troopUin = " + this.this$0.mTroopUin);
          continue;
          if (this.this$0.mFrom == 9) {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.this$0.bbn = true;
              this.this$0.aQZ = "";
              this.this$0.Gk.setVisibility(0);
              this.this$0.ru.setVisibility(8);
              this.this$0.rv.setVisibility(8);
              if (this.this$0.a != null) {
                this.this$0.a.bSJ();
              }
              anot.a(this.this$0.getActivity().app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.this$0.mTroopUin, this.this$0.aQS, "", "");
              break;
            }
          } else {
            switch (i)
            {
            default: 
              break;
            case 0: 
              this.this$0.bXl();
              break;
            case 1: 
              if (!TextUtils.isEmpty(this.this$0.aKI))
              {
                paramView = new Intent(this.this$0.getActivity(), SelectMemberActivity.class);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("group_uin", this.this$0.mTroopUin);
                paramView.putExtra("param_groupcode", this.this$0.aKI);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("param_subtype", 4);
                paramView.putExtra("param_entrance", 30);
                paramView.putExtra("param_max", 30);
                paramView.putExtra("param_exit_animation", 3);
                this.this$0.startActivity(paramView);
                this.this$0.getActivity().overridePendingTransition(2130772009, 0);
                anot.a(this.this$0.getActivity().app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.this$0.mTroopUin, "", "", "");
              }
              break;
            case 2: 
              this.this$0.mHandler.postDelayed(new ChatHistoryTroopMemberFragment.29.2(this), 320L);
              break;
            case 3: 
              this.this$0.bbo = true;
              this.this$0.Gk.setVisibility(0);
              ChatHistoryTroopMemberFragment.a(this.this$0);
              this.this$0.ru.setVisibility(8);
              this.this$0.rv.setVisibility(8);
              this.this$0.Bi.setVisibility(8);
              this.this$0.Bi = ((TextView)ChatHistoryTroopMemberFragment.a(this.this$0, 2131369581));
              this.this$0.Bi.setVisibility(0);
              this.this$0.Bi.setText(acfp.m(2131703631));
              this.this$0.Bi.setOnClickListener(new zia(this));
              if (this.this$0.a != null) {
                this.this$0.a.bSJ();
              }
              paramView = this.this$0.aQS;
              this.this$0.af("Clk_del", paramView, "");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zhz
 * JD-Core Version:    0.7.0.1
 */