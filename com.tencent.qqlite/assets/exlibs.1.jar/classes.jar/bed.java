import android.content.Intent;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class bed
  extends CardObserver
{
  public bed(QQSetting paramQQSetting) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (this.a.a.a().equals(((Card)paramObject).uin))) {
      QQSetting.a(this.a, ((Card)paramObject).iQQLevel);
    }
  }
  
  protected void onNearByProfileSymbolGet(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "Leba.onNearbyProfileSymbolGet(), isSuccess: " + paramBoolean + " symbol is: " + paramInt + " is leba resume :" + QQSetting.a(this.a));
    }
    if ((QQSetting.a(this.a) != null) && (QQSetting.a(this.a).isShowing()))
    {
      QQSetting.a(this.a).dismiss();
      if (QQSetting.b(this.a))
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
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a.a().equals(paramString))) {
      this.a.b(new bee(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bed
 * JD-Core Version:    0.7.0.1
 */