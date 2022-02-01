import android.text.TextUtils;
import com.tencent.mobileqq.ocr.TranslateFragment;

public class aknj
  implements akoz.a
{
  public aknj(TranslateFragment paramTranslateFragment, aklz.b paramb) {}
  
  public void a(int paramInt, akoz.b paramb)
  {
    if ((paramb != null) && (!TextUtils.isEmpty(paramb.languageCode)))
    {
      if (!this.b.bTL.equalsIgnoreCase(paramb.languageCode)) {
        TranslateFragment.a(this.a, paramb.languageCode, this.b.mz(paramb.languageCode));
      }
      aklz.cN("0X800AD30", aklz.dD(paramb.languageCode));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknj
 * JD-Core Version:    0.7.0.1
 */