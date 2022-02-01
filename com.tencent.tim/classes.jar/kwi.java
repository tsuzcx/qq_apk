import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class kwi
  implements ViewBase.OnClickListener
{
  kwi(kwc paramkwc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.b != null)
    {
      kxm.b(this.a.b.b().getActivity(), this.a.b.a());
      kxm.a(this.a.b.b().getActivity(), this.a.b.a(), this.a.b.b(), this.a.b.nh());
      return;
    }
    QLog.d("ProteusSupportUtil", 1, "clickCommentBiuCardWrapper exception, model is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwi
 * JD-Core Version:    0.7.0.1
 */