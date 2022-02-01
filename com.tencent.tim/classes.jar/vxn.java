import android.text.TextUtils;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;

public class vxn
  implements akoz.a
{
  public vxn(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(int paramInt, akoz.b paramb)
  {
    if ((paramb != null) && (!TextUtils.isEmpty(TextPreviewTranslateActivity.b(this.a))) && (!TextPreviewTranslateActivity.b(this.a).equals(paramb.languageCode)))
    {
      TextPreviewTranslateActivity.b(this.a, paramb.languageCode);
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.b(this.a, TextPreviewTranslateActivity.c(this.a)), TextPreviewTranslateActivity.a(this.a), TextPreviewTranslateActivity.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxn
 * JD-Core Version:    0.7.0.1
 */