import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.widget.QQToast;

final class uwj
  implements biyn
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131718766, 1).a();
    case -2: 
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, 2131718784, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwj
 * JD-Core Version:    0.7.0.1
 */