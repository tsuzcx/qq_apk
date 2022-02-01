import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class ned
  extends acln
{
  ned(ndi paramndi) {}
  
  protected void FZ()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ljp.n(this.this$0.getActivity(), str) < mhz.aSF)
    {
      this.this$0.a.tx(6);
      return;
    }
    QQToast.a(this.this$0.getActivity(), 0, this.this$0.getActivity().getString(2131718541), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ned
 * JD-Core Version:    0.7.0.1
 */