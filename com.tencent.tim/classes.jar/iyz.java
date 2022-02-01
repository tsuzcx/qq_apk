import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.EffectToolbar;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

public class iyz
  implements jcc.a
{
  public iyz(EffectToolbar paramEffectToolbar) {}
  
  public void a(long paramLong, QavListItemBase.c paramc)
  {
    EffectSettingUi.a(this.this$0.mApp, paramLong);
    Object localObject1 = VideoController.a();
    Object localObject2 = ((VideoController)localObject1).a(((AVActivity)this.this$0.mActivity.get()).getApplicationContext());
    if (localObject2 != null)
    {
      if (AudioHelper.aCz()) {
        QLog.w("EffectToolbar", 1, "onEffectClick, clearState, seq[" + paramLong + "], info[" + paramc + "]");
      }
      ((iov)localObject2).cp(paramLong);
    }
    if (paramc.id.equals("0"))
    {
      EffectToolbar.access$000(this.this$0, paramLong, null);
      this.this$0.mEarbackBtn.setVisibility(4);
      this.this$0.mApp.b().b().anp = 0;
      this.this$0.mApp.b().alV();
    }
    while (!paramc.usable) {
      return;
    }
    Object localObject3 = PtvTemplateManager.bYM + paramc.name;
    localObject2 = paramc.id;
    boolean bool = this.this$0.isEffectBtnEnable();
    if (QLog.isColorLevel()) {
      QLog.w("EffectToolbar", 1, "onEffectClick, path[" + (String)localObject3 + "], bSuc[" + bool + "], seq[" + paramLong + "]");
    }
    EffectToolbar.access$000(this.this$0, paramLong, paramc.id);
    anon.QV((String)localObject2);
    localObject3 = ((VideoController)localObject1).b();
    int i = ((iiv)localObject3).ani;
    int j = ((iiv)localObject3).relationType;
    paramLong = ((VideoController)localObject1).by();
    localObject1 = (PendantItem)this.this$0.mPtvTemplateInfoMap.get(localObject2);
    QLog.i("EffectToolbar", 2, "onEffectClick voiceid : " + paramc.voiceid);
    this.this$0.mApp.b().b().anp = paramc.voiceid;
    this.this$0.mApp.b().alV();
    if (paramc.voiceid > 0)
    {
      this.this$0.mEarbackBtn.setVisibility(0);
      EffectToolbar.access$100(this.this$0);
    }
    for (;;)
    {
      ikh.ano();
      ixo.a(j, i, paramLong, (String)localObject2, ((PendantItem)localObject1).getCategory());
      return;
      this.this$0.mEarbackBtn.setVisibility(4);
    }
  }
  
  public void dk(long paramLong)
  {
    EffectSettingUi.a(this.this$0.mApp, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iyz
 * JD-Core Version:    0.7.0.1
 */