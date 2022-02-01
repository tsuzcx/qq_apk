import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adyu
  implements View.OnClickListener
{
  public adyu(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.H != null) && (this.this$0.H.isShowing()))
    {
      this.this$0.H.dismiss();
      this.this$0.H = null;
    }
    if (this.this$0.cLC == 0)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X80064E3", "0X80064E3", 0, 0, "", "", "", "");
      if ((!this.this$0.isEditMode) || (!this.this$0.bSn) || (this.this$0.isFinishing())) {
        break label176;
      }
      this.this$0.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.getIntent().getIntExtra("source_activity", 0) != 1) {
        break;
      }
      anot.a(this.this$0.app, "CliOper", "", "", "0X80064EE", "0X80064EE", 0, 0, "", "", "", "");
      break;
      label176:
      if (this.this$0.bSo)
      {
        adzx.em(this.this$0.app.getCurrentAccountUin(), -1);
        this.this$0.bSo = false;
      }
      if ((this.this$0.b == null) || (TextUtils.isEmpty(this.this$0.b.cardId))) {
        this.this$0.finish();
      } else {
        BusinessCardEditActivity.a(this.this$0, false, true, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adyu
 * JD-Core Version:    0.7.0.1
 */