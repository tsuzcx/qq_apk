import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

final class oeh
  implements WXShareHelper.a
{
  public void a(BaseResp paramBaseResp)
  {
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131720152, 1).show();
    case -2: 
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, 2131720175, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oeh
 * JD-Core Version:    0.7.0.1
 */