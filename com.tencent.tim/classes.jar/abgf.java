import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2.1.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

public class abgf
  extends acnd
{
  abgf(abge paramabge, TroopActivity paramTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131698424), 0).show(this.a.getTitleBarHeight());
      if ((this.this$0.ih != null) && (this.this$0.ih.containsKey(paramString)))
      {
        Switch localSwitch = (Switch)this.this$0.ih.get(paramString);
        if (this.this$0.b != null) {
          localSwitch.setChecked(this.this$0.b.kx(paramString));
        }
      }
    }
  }
  
  protected void wK(String paramString)
  {
    if ((this.this$0.context instanceof BaseActivity)) {
      ((BaseActivity)this.this$0.context).runOnUiThread(new TroopListAdapter2.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgf
 * JD-Core Version:    0.7.0.1
 */