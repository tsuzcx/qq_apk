import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView.a;

public class aawh
  implements ParticipleBottomMenuView.a
{
  public aawh(TextPreviewMenu paramTextPreviewMenu, TextPreviewActivity paramTextPreviewActivity) {}
  
  public void AX(String paramString)
  {
    aofz.hG(paramString, "OCR_Participle_copy");
  }
  
  public void AY(String paramString)
  {
    aofz.N(this.a, paramString);
  }
  
  public void AZ(String paramString)
  {
    aofz.c(this.a, this.a.app, paramString);
  }
  
  public void Ba(String paramString)
  {
    Intent localIntent = new Intent(this.a, TextPreviewTranslateActivity.class);
    localIntent.putExtra("TranslateText", paramString);
    localIntent.putExtra("WhereAreYouFrom", "AIO_TEXTPREVIEW");
    TextPreviewMenu.a(this.this$0, localIntent);
  }
  
  public void auC()
  {
    TextPreviewMenu.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawh
 * JD-Core Version:    0.7.0.1
 */