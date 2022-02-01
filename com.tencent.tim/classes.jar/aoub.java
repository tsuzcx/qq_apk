import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.2.1;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.e;
import java.util.ArrayList;

public class aoub
  implements AdapterView.e
{
  public aoub(TroopAvatarWallPreviewActivity.2.1 param1) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    if (TroopAvatarWallPreviewActivity.a(this.a.a.this$0).isReport)
    {
      TroopAvatarWallPreviewActivity.a(this.a.a.this$0).addPicIndex(paramInt);
      paramAdapterView = TroopAvatarWallPreviewActivity.a(this.a.a.this$0);
      paramAdapterView.slide_number += 1;
    }
    this.a.a.this$0.mIndex = paramInt;
    paramAdapterView = this.a.a.this$0.mIndex + 1 + "/" + this.a.a.this$0.dRK;
    this.a.a.this$0.mTextView.setText(paramAdapterView);
    boolean bool1;
    if (this.a.a.this$0.cOH)
    {
      anot.a(this.a.a.this$0.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.this$0.mTroopUin, "0", "", "");
      if (this.a.a.this$0.cOG) {
        TroopAvatarWallPreviewActivity.a(this.a.a.this$0, this.a.a.this$0.mIndex);
      }
      boolean bool2 = this.a.a.this$0.cOJ;
      if ((TroopAvatarWallPreviewActivity.a(this.a.a.this$0) != null) && (TroopAvatarWallPreviewActivity.a(this.a.a.this$0).getBoolean("from_personality_label", false)))
      {
        paramAdapterView = this.a.a.this$0;
        if (Long.valueOf((String)this.a.a.this$0.BA.get(this.a.a.this$0.mIndex)).longValue() == -1L) {
          break label530;
        }
        bool1 = true;
        label363:
        paramAdapterView.cOJ = bool1;
      }
      if (bool2 != this.a.a.this$0.cOJ)
      {
        paramAdapterView = this.a.a.this$0.sf;
        if (!this.a.a.this$0.cOJ) {
          break label536;
        }
      }
    }
    label530:
    label536:
    for (paramInt = 0;; paramInt = 8)
    {
      paramAdapterView.setVisibility(paramInt);
      if (this.a.a.this$0.cOM) {
        TroopAvatarWallPreviewActivity.b(this.a.a.this$0);
      }
      TroopAvatarWallPreviewActivity.b(this.a.a.this$0, this.a.a.this$0.mIndex);
      return;
      anot.a(this.a.a.this$0.app, "P_CliOper", "Grp_set", "", "Grp_Visdata", "nonmber_Clk_head", 0, 0, this.a.a.this$0.mTroopUin, "1", "", "");
      break;
      bool1 = false;
      break label363;
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoub
 * JD-Core Version:    0.7.0.1
 */