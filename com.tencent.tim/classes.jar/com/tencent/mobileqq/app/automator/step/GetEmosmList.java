package com.tencent.mobileqq.app.automator.step;

import acdz;
import afhj;
import ajdg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqgz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class GetEmosmList
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "getEmosmList start int QQInitHandler...");
    }
    ((afhj)this.a.app.getManager(259)).cZy();
    Object localObject1 = this.a.app.getApp().getSharedPreferences("sticker_pref", 0);
    Object localObject2 = this.a.app.getCurrentAccountUin();
    EmojiStickerManager.cRA = ((SharedPreferences)localObject1).getInt("sticker_max_send_num_" + (String)localObject2, EmojiStickerManager.cRy);
    EmojiStickerManager.cRB = ((SharedPreferences)localObject1).getInt("sticker_max_show_num_" + (String)localObject2, EmojiStickerManager.cRy);
    EmojiStickerManager.bYF = aqgz.aCG();
    EmojiStickerManager.Xz = ((SharedPreferences)localObject1).getLong("sticker_update_version_time_" + (String)localObject2, 0L);
    QLog.i("QQInitHandler", 1, String.format("Sticker config, switch %b, maxSendNum: %d, isRubbishMachine: %b, updateVersionTime: %d", new Object[] { Boolean.valueOf(EmojiStickerManager.bYE), Integer.valueOf(EmojiStickerManager.cRA), Boolean.valueOf(EmojiStickerManager.bYF), Long.valueOf(EmojiStickerManager.Xz) }));
    if (EmojiStickerManager.Xz == 0L)
    {
      long l = NetConnInfoCenter.getServerTime();
      ((SharedPreferences)localObject1).edit().putLong("sticker_update_version_time_" + (String)localObject2, l).apply();
      EmojiStickerManager.Xz = l;
    }
    localObject2 = (ajdg)this.a.app.getManager(14);
    localObject1 = this.a.app.getApplication().getSharedPreferences("mobileQQ", 0);
    if (!Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_set_emosmpackage_valid_" + this.a.app.getCurrentAccountUin(), false)).booleanValue())
    {
      localObject3 = ((ajdg)localObject2).fz();
      if (localObject3 != null)
      {
        Iterator localIterator = ((List)localObject3).iterator();
        while (localIterator.hasNext()) {
          ((EmoticonPackage)localIterator.next()).valid = true;
        }
        ((ajdg)localObject2).lo((List)localObject3);
      }
      ((SharedPreferences)localObject1).edit().putBoolean("emosm_has_set_emosmpackage_valid_" + this.a.app.getCurrentAccountUin(), true).commit();
    }
    localObject2 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_download_emosmpackage_tag_" + this.a.app.getCurrentAccountUin(), false));
    localObject1 = Boolean.valueOf(((SharedPreferences)localObject1).getBoolean("emosm_has_download_emosmpackage_kandian_tag_" + this.a.app.getCurrentAccountUin(), false));
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "kandianOidbFlag kandianOidbFlag int oidbFlag..." + localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "kandianOidbFlag kandianOidbFlag int kandianOidbFlag..." + localObject1);
    }
    Object localObject3 = (acdz)this.a.app.getBusinessHandler(12);
    if (((Boolean)localObject2).booleanValue())
    {
      ((acdz)localObject3).gT(0, 0);
      if (!((Boolean)localObject1).booleanValue()) {
        break label647;
      }
      ((acdz)localObject3).I(0, 0, 1, 0);
    }
    for (;;)
    {
      return 7;
      ((acdz)localObject3).IV(0);
      break;
      label647:
      ((acdz)localObject3).IV(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmosmList
 * JD-Core Version:    0.7.0.1
 */