import android.text.TextUtils;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;

public class vxl
  implements akoz.a
{
  public vxl(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void a(int paramInt, akoz.b paramb)
  {
    if ((!TextUtils.isEmpty(TextPreviewTranslateActivity.a(this.a))) && (!TextPreviewTranslateActivity.a(this.a).equals(paramb.languageCode)))
    {
      TextPreviewTranslateActivity.a(this.a, paramb.languageCode);
      TextPreviewTranslateActivity.a(this.a, TextPreviewTranslateActivity.b(this.a, TextPreviewTranslateActivity.c(this.a)), TextPreviewTranslateActivity.a(this.a), TextPreviewTranslateActivity.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */