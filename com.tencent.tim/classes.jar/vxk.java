import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.widget.QQToast;

public class vxk
  extends aklt
{
  public vxk(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    TextPreviewTranslateActivity.b(this.a);
    if ((paramBoolean) && (paramTranslateResult != null) && (paramTranslateResult.isSuccess()) && (!paramTranslateResult.isEmpty()))
    {
      TextPreviewTranslateActivity.a(this.a, paramTranslateResult);
      return;
    }
    String str2 = this.a.getResources().getString(2131701476);
    String str1 = str2;
    if (paramTranslateResult != null)
    {
      if (TextUtils.isEmpty(paramTranslateResult.errMsg)) {
        break label92;
      }
      str1 = paramTranslateResult.errMsg;
    }
    for (;;)
    {
      QQToast.a(this.a, 1, str1, 0).show();
      return;
      label92:
      str1 = str2;
      if (paramTranslateResult.isEmpty()) {
        str1 = this.a.getResources().getString(2131701455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxk
 * JD-Core Version:    0.7.0.1
 */