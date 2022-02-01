import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class kvz
  implements ViewBase.OnClickListener
{
  kvz(kvy paramkvy) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.b.getCurActivity() != null)
    {
      kvx.a(this.a.a, paramViewBase);
      this.a.b.getCurActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvz
 * JD-Core Version:    0.7.0.1
 */