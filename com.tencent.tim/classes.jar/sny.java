import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.c;
import com.tencent.common.app.AppInterface;
import java.lang.ref.WeakReference;

public class sny
  implements TextView.OnEditorActionListener
{
  public sny(TroopGiftPanel.c paramc, TroopGiftPanel paramTroopGiftPanel) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.a.gR();
      paramTextView = this.a.aj.getEditableText().toString();
      if (!TextUtils.isEmpty(paramTextView))
      {
        this.a.this$0.ts(paramTextView);
        this.a.dismiss();
        if (!jof.a().dd(this.a.this$0.nD())) {
          break label194;
        }
      }
      label194:
      for (paramInt = 2;; paramInt = 1)
      {
        anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", paramInt, 0, this.a.this$0.nD(), "", this.a.this$0.aFe, "" + jlk.a((AppInterface)this.a.this$0.n.get(), ((AppInterface)this.a.this$0.n.get()).getCurrentAccountUin(), this.a.this$0.nD()));
        return true;
        this.a.this$0.ts("1");
        break;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sny
 * JD-Core Version:    0.7.0.1
 */