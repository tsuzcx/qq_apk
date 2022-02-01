import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

class vdm
  implements bihh
{
  vdm(vde paramvde) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((vde.a(this.a) == null) || (!vde.a(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QQToast.a(this.a.a(), 1, anni.a(2131713340), 0).a();
      return;
    }
    QQToast.a(this.a.a(), 2, anni.a(2131713342), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdm
 * JD-Core Version:    0.7.0.1
 */