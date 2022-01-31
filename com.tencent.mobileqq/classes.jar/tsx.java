import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class tsx
  extends BizTroopObserver
{
  public tsx(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.a.isFinishing())
      {
        paramString1 = paramString2;
        if (this.a.isResume())
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.getResources().getString(2131435563);
          }
          QQToast.a(this.a, 1, paramString1, 0).a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssistantActivity", 2, "onSetCommonUsedTroop error, retCode = " + paramInt2 + " , wording = " + paramString1);
      }
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsx
 * JD-Core Version:    0.7.0.1
 */