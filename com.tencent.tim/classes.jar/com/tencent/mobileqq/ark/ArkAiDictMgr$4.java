package com.tencent.mobileqq.ark;

import adpo;
import adpq;
import aqnl;
import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

public final class ArkAiDictMgr$4
  implements Runnable
{
  public ArkAiDictMgr$4(AppInterface paramAppInterface) {}
  
  public void run()
  {
    try
    {
      if (!adpo.h(this.b)) {
        break label263;
      }
      String str1 = adpq.sK();
      if (str1 == null)
      {
        ArkAppCenter.r("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData, local dict config not available", new Object[0]));
        return;
      }
      if ((adpo.access$200() != null) && (adpo.access$200().equals(str1)))
      {
        ArkAppCenter.r("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData, dict already loaded, dict-id=%s", new Object[] { adpo.access$200() }));
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ArkAppCenter.r("ArkApp.Dict", "reloadWordData, UnsatisfiedLinkError, err:" + localUnsatisfiedLinkError.getMessage());
      return;
    }
    String str2 = adpo.jU(localUnsatisfiedLinkError);
    if (!new File(str2).exists())
    {
      ArkAppCenter.r("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData, local dict file not available, dict-id=%s", new Object[] { localUnsatisfiedLinkError }));
      return;
    }
    WordSegment.uninit();
    int i = WordSegment.init(str2 + '/');
    if (i != 0)
    {
      ArkAppCenter.r("ArkApp.Dict", String.format(Locale.CHINA, String.format(Locale.CHINA, "reloadWordData failed, dict-id=%s, ret=%d", new Object[] { localUnsatisfiedLinkError, Integer.valueOf(i) }), new Object[0]));
      return;
    }
    ArkAppCenter.r("ArkApp.Dict", String.format(Locale.CHINA, String.format("reloadWordData success, dict-id=%s", new Object[] { localUnsatisfiedLinkError }), new Object[0]));
    adpo.access$202(localUnsatisfiedLinkError);
    if (this.b != null)
    {
      aqnl.H(this.b);
      return;
      label263:
      ArkAppCenter.r("ArkApp.Dict", String.format("reloadWordData, dict flag is off", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.4
 * JD-Core Version:    0.7.0.1
 */