import android.text.TextUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopView;
import com.tencent.mobileqq.app.BizTroopObserver;

public class egr
  extends BizTroopObserver
{
  public egr(TroopView paramTroopView) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 == 0) {
      this.a.a();
    }
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.a.a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     egr
 * JD-Core Version:    0.7.0.1
 */