import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.28.1;
import com.tencent.mobileqq.activity.TroopMemberListActivity.28.2;
import com.tencent.mobileqq.activity.TroopMemberListActivity.c;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;

public class wbp
  implements ausj.a
{
  public wbp(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!TroopMemberListActivity.c(this.this$0)) && (paramInt >= 5)) {}
    for (int i = paramInt + 1;; i = paramInt)
    {
      if (this.this$0.aUo) {
        if (paramInt == 0) {
          this.this$0.mHandler.postDelayed(new TroopMemberListActivity.28.1(this), 320L);
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
          QLog.d("TroopMemberListActivityget_troop_member", 2, "mOnActionSheetClickListener.OnClick, error : which = " + paramInt + ", troopUin = " + this.this$0.mTroopUin);
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
              anot.a(this.this$0.app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.this$0.mTroopUin, this.this$0.aQS, "", "");
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
                paramView = new Intent(this.this$0, SelectMemberActivity.class);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("group_uin", this.this$0.mTroopUin);
                paramView.putExtra("param_groupcode", this.this$0.aKI);
                paramView.putExtra("param_from", 30);
                paramView.putExtra("param_subtype", 4);
                paramView.putExtra("param_entrance", 30);
                paramView.putExtra("param_max", 30);
                paramView.putExtra("param_exit_animation", 3);
                this.this$0.startActivity(paramView);
                this.this$0.overridePendingTransition(2130772009, 0);
                anot.a(this.this$0.app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.this$0.mTroopUin, "", "", "");
              }
              break;
            case 2: 
              this.this$0.mHandler.postDelayed(new TroopMemberListActivity.28.2(this), 320L);
              break;
            case 3: 
              this.this$0.bbo = true;
              this.this$0.Gk.setVisibility(0);
              TroopMemberListActivity.a(this.this$0);
              this.this$0.ru.setVisibility(8);
              this.this$0.rv.setVisibility(8);
              this.this$0.Bi.setVisibility(8);
              this.this$0.Bi = ((TextView)this.this$0.findViewById(2131369581));
              this.this$0.Bi.setVisibility(0);
              this.this$0.Bi.setText(acfp.m(2131715971));
              this.this$0.Bi.setOnClickListener(new wbq(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wbp
 * JD-Core Version:    0.7.0.1
 */