import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.FaceToolbar;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class izb
  implements jcc.a
{
  public izb(FaceToolbar paramFaceToolbar) {}
  
  public void a(long paramLong, QavListItemBase.c paramc)
  {
    int j = 1;
    if (AudioHelper.aCz()) {
      QLog.w(FaceToolbar.TAG, 1, "onEffectClick, seq[" + paramLong + "], id[" + paramc.id + "]");
    }
    EffectSettingUi.a(this.this$0.mApp, paramLong);
    Object localObject = this.this$0.mApp.b();
    if (this.this$0.checkDimmStatus(paramc)) {}
    do
    {
      return;
      localObject = ((VideoController)localObject).getChatRoomId(this.this$0.mApp.b().b().peerUin) + "";
      VoiceRecogTips.a(this.this$0.mApp, paramc);
      if (!paramc.id.equals("0")) {
        break;
      }
      this.this$0.notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(true));
      ijw.Z(2, (String)localObject);
      ijw.stop(2);
    } while (!this.this$0.mApp.ch(13));
    ((ikd)this.this$0.mApp.a(13)).o(paramLong, "onEffectClick2");
    return;
    AudioHelper.dj(paramc.id, false);
    new iya.e(paramLong, paramc.id, true, 1).n(this.this$0.mApp);
    FaceItem localFaceItem = (FaceItem)this.this$0.mFaceManager.a(paramc.id);
    int i = j;
    if (localFaceItem != null)
    {
      if (!localFaceItem.getType().equalsIgnoreCase("face")) {
        break label314;
      }
      i = j;
    }
    for (;;)
    {
      ijw.m(paramc.id, i, (String)localObject);
      ijw.G(paramc.id, i);
      return;
      label314:
      if (localFaceItem.getType().equalsIgnoreCase("pendant"))
      {
        i = 2;
      }
      else if (localFaceItem.getType().equalsIgnoreCase("voicesticker"))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (localFaceItem.getType().equalsIgnoreCase("creativecop")) {
          i = 4;
        }
      }
    }
  }
  
  public void dk(long paramLong)
  {
    EffectSettingUi.a(this.this$0.mApp, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izb
 * JD-Core Version:    0.7.0.1
 */