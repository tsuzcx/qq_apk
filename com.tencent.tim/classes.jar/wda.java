import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class wda
  extends acmc
{
  public wda(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      QQToast.a(this.this$0.getApplicationContext(), 2, this.this$0.getApplicationContext().getResources().getString(2131720353), 0).show();
      this.this$0.gL.setVisibility(8);
      return;
    }
    QQToast.a(this.this$0.getApplicationContext(), 1, this.this$0.getApplicationContext().getResources().getString(2131720350), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wda
 * JD-Core Version:    0.7.0.1
 */