import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ocr.TranslateFragment;
import com.tencent.mobileqq.ocr.TranslateFragment.1.1;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akni
  extends aklt
{
  public akni(TranslateFragment paramTranslateFragment) {}
  
  public void a(boolean paramBoolean, int paramInt, TranslateResult paramTranslateResult)
  {
    if (!TranslateFragment.a(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TranslateFragment", 2, String.format("onGetTranslateResult isSuccess:%s, type:%s, result:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramTranslateResult }));
    }
    TranslateFragment.a(this.a).runOnUiThread(new TranslateFragment.1.1(this, paramBoolean, paramTranslateResult));
    HashMap localHashMap = new HashMap();
    if (paramTranslateResult != null) {}
    for (int i = paramTranslateResult.errCode;; i = 2000)
    {
      localHashMap.put("errCode", String.valueOf(i));
      localHashMap.put("type", String.valueOf(paramInt));
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "SCAN_TRANSLATE_RESULT", paramBoolean, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akni
 * JD-Core Version:    0.7.0.1
 */