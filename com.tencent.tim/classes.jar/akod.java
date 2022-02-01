import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.c;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.ocr.ui.SearchResultFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akod
  extends aklt
{
  public akod(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public void a(int paramInt, String paramString, OCRTextSearchInfo.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, errorCode=" + paramInt + ", sessionID=" + paramString + ", mSessionId=" + this.a.mSessionId);
    }
    if ((paramString == null) || (this.a.mSessionId == null) || (!this.a.mSessionId.equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, session error");
      }
      return;
    }
    this.a.bx(false);
    if (this.a.a == null) {
      this.a.Se(1);
    }
    this.a.a.a(this.a.I.getText().toString(), paramInt, paramc);
    this.a.Sd(1);
    if ((paramInt == 0) && (paramc.qT != null) && (paramc.qT.size() > 0))
    {
      anot.a(null, "dc00898", "", "", "0X80082E8", "0X80082E8", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "dc00898", "", "", "0X80082E7", "0X80082E7", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akod
 * JD-Core Version:    0.7.0.1
 */