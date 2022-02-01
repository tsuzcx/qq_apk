import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.ui.BeautyToolbar.a;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TraeHelper;

public class iyk
  implements jcr.e
{
  public iyk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong, String paramString) {}
  
  public void aoD()
  {
    this.this$0.Yc = true;
    this.this$0.auW();
    EffectOperateManager localEffectOperateManager = (EffectOperateManager)this.this$0.mApp.a(8);
    if (localEffectOperateManager != null) {
      localEffectOperateManager.id(false);
    }
    this.this$0.auY();
  }
  
  public void aoE()
  {
    iiv localiiv = this.this$0.a.b();
    TraeHelper.a().dN(this.kQ);
    localiiv.PU = false;
    if (localiiv.ana != -1) {}
    for (;;)
    {
      localiiv.Qh = true;
      jjk.f(this.this$0.a);
      if (this.this$0.Wg) {
        jjk.t(this.this$0.a);
      }
      if ((localiiv.isConnected()) && (localiiv.amI == 2) && (!localiiv.PY)) {
        jjk.awZ();
      }
      igd.aJ(this.this$0.TAG, "DataReport onClose: ");
      ikl.a.a(this.this$0.TAG, this.this$0.mApp);
      ilg.a.h(this.this$0.mApp);
      iju.a.c(this.this$0.mApp);
      BeautyToolbar.a.jS(this.this$0.mApp.getCurrentAccountUin());
      jfq.f(localiiv);
      String str = localiiv.getRoomId() + "";
      this.this$0.a.O(this.val$uin, 237);
      this.this$0.a.ko(237);
      ijw.a(this.this$0.mApp, str);
      ijw.Z(2, str);
      ijw.stop(2);
      this.this$0.a.P(this.val$uin, localiiv.ana);
      this.this$0.Ox = true;
      localiiv.O("onClick_HangeUP", false);
      localiiv.Z("onClick_HangeUP", 0);
      this.this$0.Yc = false;
      return;
      localiiv.ana = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyk
 * JD-Core Version:    0.7.0.1
 */