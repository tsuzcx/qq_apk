import android.content.Intent;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aso
  extends CardObserver
{
  public aso(Leba paramLeba) {}
  
  protected void onNearByProfileSymbolGet(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "Leba.onNearbyProfileSymbolGet(), isSuccess: " + paramBoolean + " symbol is: " + paramInt + " is leba resume :" + Leba.c(this.a));
    }
    if ((Leba.a(this.a) != null) && (Leba.a(this.a).isShowing()))
    {
      Leba.a(this.a).dismiss();
      if (Leba.d(this.a))
      {
        if (!paramBoolean) {
          break label128;
        }
        Intent localIntent = new Intent(this.a.a(), NearbyActivity.class);
        this.a.a(localIntent);
      }
    }
    return;
    label128:
    QQToast.a(this.a.a(), "检查资料失败，请稍后重试。", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aso
 * JD-Core Version:    0.7.0.1
 */