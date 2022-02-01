import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;

public class aowj
  implements WXShareHelper.a
{
  public aowj(TroopCreateLogicActivity paramTroopCreateLogicActivity) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.Qt == null) || (!this.a.Qt.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131720152, 1).show();
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2, 2131720175, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowj
 * JD-Core Version:    0.7.0.1
 */