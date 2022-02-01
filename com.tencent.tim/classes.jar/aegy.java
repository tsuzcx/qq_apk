import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.confess.ConfessPlugin.5;
import com.tencent.mobileqq.confess.ConfessPlugin.5.1;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;

public class aegy
  implements WXShareHelper.a
{
  public aegy(ConfessPlugin.5.1 param1) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfessPlugin", 2, "onWXShareResp resp.errCode=" + paramBaseResp.errCode);
    }
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      ConfessPlugin.a(this.a.a.this$0, false);
      ConfessPlugin.a(this.a.a.this$0, 1, 2131720152);
      return;
    case 0: 
      ConfessPlugin.a(this.a.a.this$0, true);
      ConfessPlugin.a(this.a.a.this$0, 2, 2131720175);
      return;
    }
    ConfessPlugin.a(this.a.a.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegy
 * JD-Core Version:    0.7.0.1
 */