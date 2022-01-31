import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;

public class wio
  extends BizTroopObserver
{
  public wio(TroopView paramTroopView) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0) {
      this.a.j();
    }
    while (this.a.b()) {
      return;
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = this.a.getResources().getString(2131435563);
    }
    QQToast.a(this.a.a(), 1, paramString1, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wio
 * JD-Core Version:    0.7.0.1
 */