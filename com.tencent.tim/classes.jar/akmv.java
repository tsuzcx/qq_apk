import android.app.Dialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class akmv
  extends aogb
{
  public akmv(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  protected void H(boolean paramBoolean, List<String> paramList)
  {
    super.H(paramBoolean, paramList);
    if (OCRResultFragmentNew.a(this.a) != null)
    {
      OCRResultFragmentNew.a(this.a).setOnCancelListener(null);
      OCRResultFragmentNew.a(this.a).dismiss();
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.a.setParticipleItems(paramList);
      this.a.a.eim();
      OCRResultFragmentNew.a(this.a, 2);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709351), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmv
 * JD-Core Version:    0.7.0.1
 */