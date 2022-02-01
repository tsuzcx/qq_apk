import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class vfq
  implements bjig
{
  vfq(vfi paramvfi) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((vfi.a(this.a) == null) || (!vfi.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a.a(), 1, anzj.a(2131713449), 0).a();
      return;
    }
    QQToast.a(this.a.a(), 2, anzj.a(2131713451), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfq
 * JD-Core Version:    0.7.0.1
 */