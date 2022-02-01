import android.text.TextUtils;
import com.tencent.mobileqq.ocr.TranslateFragment;

public class aknl
  implements akoz.a
{
  public aknl(TranslateFragment paramTranslateFragment, aklz.b paramb) {}
  
  public void a(int paramInt, akoz.b paramb)
  {
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.languageCode)))
    {
      if (!this.b.bTM.equalsIgnoreCase(paramb.languageCode)) {
        TranslateFragment.a(this.a, this.b.bTL, paramb.languageCode);
      }
      aklz.cN("0X800AD31", aklz.dD(paramb.languageCode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknl
 * JD-Core Version:    0.7.0.1
 */