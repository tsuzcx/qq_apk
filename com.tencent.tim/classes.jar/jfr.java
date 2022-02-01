import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeToolbar;

public class jfr
  implements jcc.a
{
  public jfr(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong, QavListItemBase.c paramc)
  {
    igd.aK(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + paramc.id);
    iiv localiiv = this.a.mApp.b().b();
    int i = Integer.parseInt(paramc.id);
    if (i == 0) {
      irk.a().resume(64);
    }
    while (i == 0)
    {
      localiiv.Na = null;
      localiiv.YN = i;
      localiiv.anp = 0;
      paramc = this.a.getAVActivity();
      if ((paramc != null) && (paramc.mControlUI != null)) {
        paramc.mControlUI.O(paramLong, 8);
      }
      this.a.mApp.b().alV();
      jfq.a(localiiv, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (localiiv.amI == 4) {
        anon.QY(String.valueOf(i));
      }
      return;
      irk.a().pause(64);
    }
    if ((paramc.ax instanceof jfp.a)) {}
    for (localiiv.Na = ((jfp.a)paramc.ax).RO;; localiiv.Na = paramc.iconurl)
    {
      jjk.kG(paramc.id);
      break;
    }
  }
  
  public void dk(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfr
 * JD-Core Version:    0.7.0.1
 */