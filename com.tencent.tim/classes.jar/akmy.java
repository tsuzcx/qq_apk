import android.view.View;
import com.tencent.mobileqq.ocr.OCRResultFragmentNew;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class akmy
  implements ausj.a
{
  public akmy(OCRResultFragmentNew paramOCRResultFragmentNew, List paramList, aklz.b paramb) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.Ef.size())
    {
      paramView = (String)this.Ef.get(paramInt);
      if (!paramView.equalsIgnoreCase(this.b.bTK)) {
        break label108;
      }
      QLog.i("OCRResultFragmentNew", 2, "lanCode equals, return, selectedLan:" + paramView);
    }
    for (;;)
    {
      if ((this.a.ak != null) && (this.a.ak.isShowing())) {
        this.a.ak.dismiss();
      }
      this.a.ak = null;
      return;
      label108:
      QQToast.a(OCRResultFragmentNew.a(this.a), 0, 2131701457, 0).show();
      aklz.d.Ku(paramView);
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("OCRResultFragmentNew", 2, "requestOcr lan:" + paramView + ", ctx:" + aklz.d.tc());
        }
        OCRResultFragmentNew.a(this.a, aklz.d);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akmy
 * JD-Core Version:    0.7.0.1
 */