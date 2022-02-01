import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class aldv
  extends accn
{
  public aldv(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity) {}
  
  public void reqShoppingInfo(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, "user binding shoppingNo = " + paramString1 + "Threadid=" + Thread.currentThread().getId());
    }
    if ((this.this$0.app == null) || (this.this$0.isFinishing())) {}
    do
    {
      return;
      this.this$0.app.removeObserver(this);
      this.this$0.cardObserver = null;
    } while (!paramBoolean);
    if ("0".equals(paramString1))
    {
      paramString1 = this.this$0.mContext;
      paramString2 = this.this$0.mContext;
      paramString1 = paramString1.getSharedPreferences("is_binding_shop", 0).edit();
      paramString1.putBoolean(this.this$0.aNh, false);
      paramString1.commit();
      return;
    }
    paramString1 = this.this$0.mContext;
    paramString2 = this.this$0.mContext;
    paramString1 = paramString1.getSharedPreferences("is_binding_shop", 0).edit();
    paramString1.putBoolean(this.this$0.aNh, true);
    paramString1.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aldv
 * JD-Core Version:    0.7.0.1
 */