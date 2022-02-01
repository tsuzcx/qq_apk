import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class vmo
  extends accn
{
  public vmo(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.this$0.az.isChecked()))
    {
      this.this$0.az.setOnCheckedChangeListener(null);
      this.this$0.az.setChecked(paramBoolean2);
      this.this$0.az.setOnCheckedChangeListener(this.this$0);
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.this$0.e.uin.equals(paramString)) {
      return;
    }
    this.this$0.bJs();
    if (paramBoolean)
    {
      this.this$0.cf(2131691296, 2);
      return;
    }
    this.this$0.cf(2131691294, 1);
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.this$0.az.isChecked()))
    {
      this.this$0.az.setOnCheckedChangeListener(null);
      this.this$0.az.setChecked(paramBoolean2);
      this.this$0.az.setOnCheckedChangeListener(this.this$0);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34))) {}
    for (;;)
    {
      if (this.this$0.aa == null) {
        this.this$0.aa = new Bundle();
      }
      if (paramCard != null) {
        this.this$0.aa.putShort("key_personality_label_switch", paramCard.switch_disable_personality_label);
      }
      return;
      this.this$0.cf(2131697281, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmo
 * JD-Core Version:    0.7.0.1
 */