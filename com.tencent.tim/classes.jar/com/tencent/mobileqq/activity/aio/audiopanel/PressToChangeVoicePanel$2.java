package com.tencent.mobileqq.activity.aio.audiopanel;

import afem;
import afeu;
import affj;
import anot;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import imm;

final class PressToChangeVoicePanel$2
  implements Runnable
{
  PressToChangeVoicePanel$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (!this.bfg)
    {
      if (PressToChangeVoicePanel.GW == null) {
        PressToChangeVoicePanel.GW = TraeHelper.S(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo async:" + PressToChangeVoicePanel.GW);
      }
    }
    if ((PressToChangeVoicePanel.GW != null) || (imm.getCpuArchitecture() <= 2)) {}
    for (;;)
    {
      try
      {
        afeu localafeu = ((afem)this.val$app.getManager(77)).a(affj.ur());
        if (localafeu == null) {
          continue;
        }
        localafeu.HL(false);
      }
      catch (Exception localException)
      {
        QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo Exception:" + localException.getMessage());
        continue;
      }
      anot.a(this.val$app, "dc00898", "", "", this.val$actionName, this.val$actionName, 0, 0, "", "", "", "");
      return;
      QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
      continue;
      AVSoUtils.d(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.2
 * JD-Core Version:    0.7.0.1
 */