import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aiqt
  extends acnd
{
  aiqt(aiqs paramaiqs) {}
  
  protected void cG(String paramString, int paramInt)
  {
    super.cG(paramString, paramInt);
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity != null) && (this.this$0.a.apC())) {
        QQToast.a(localBaseActivity, 2131694569, 1).show();
      }
      aitg.e(this.this$0.app, 1, paramString);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    super.q(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onTroopManagerSuccess: invoked. 主动退群 or 解散群", " reqtype: ", Integer.valueOf(paramInt1), " troopUin: ", paramString });
      }
      aitg.e(this.this$0.app, 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqt
 * JD-Core Version:    0.7.0.1
 */