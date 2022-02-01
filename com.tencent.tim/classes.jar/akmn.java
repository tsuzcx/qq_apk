import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ocr.OCRResultActivity;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class akmn
  extends aogb
{
  public akmn(OCRResultActivity paramOCRResultActivity) {}
  
  protected void H(boolean paramBoolean, List<String> paramList)
  {
    super.H(paramBoolean, paramList);
    OCRResultActivity.c(this.a);
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.a.setParticipleItems(paramList);
      this.a.a.eim();
      OCRResultActivity.d(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131709351), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmn
 * JD-Core Version:    0.7.0.1
 */