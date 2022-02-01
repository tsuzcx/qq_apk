import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class kfl
  implements ViewBase.OnClickListener
{
  kfl(kfk paramkfk) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (paramViewBase.getEventAttachedData() == null)
    {
      QLog.e("DailyHeaderViewController", 1, "[onClick] attach event data is null");
      return;
    }
    kfa.i(this.a.YT, this.a.val$data);
    kxm.aJ(paramViewBase.getNativeView().getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kfl
 * JD-Core Version:    0.7.0.1
 */