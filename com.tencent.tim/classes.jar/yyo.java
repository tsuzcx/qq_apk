import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.widget.QQToast;

public class yyo
  extends accd
{
  public yyo(TroopView paramTroopView) {}
  
  protected void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 0) {
      this.a.bOm();
    }
    while (this.a.isFinishing()) {
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131696690);
    }
    QQToast.a(this.a.getActivity(), 1, paramString1, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyo
 * JD-Core Version:    0.7.0.1
 */