import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class vxz
  extends accd
{
  public vxz(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.this$0.isFinishing())
      {
        paramString1 = paramString2;
        if (this.this$0.isResume())
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.this$0.getResources().getString(2131696690);
          }
          QQToast.a(this.this$0, 1, paramString1, 0).show();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssistantActivity", 2, "onSetCommonUsedTroop error, retCode = " + paramInt2 + " , wording = " + paramString1);
      }
      return;
    }
    this.this$0.bOm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxz
 * JD-Core Version:    0.7.0.1
 */