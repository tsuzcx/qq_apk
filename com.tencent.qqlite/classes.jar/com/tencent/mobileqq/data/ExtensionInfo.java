package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;

public class ExtensionInfo
  extends Entity
{
  public static final int AUDIO_PANEL_TYPE__NONE = -1;
  public static final int AUDIO_PANEL_TYPE__PRESS_RECORDER = 1;
  public static final int AUDIO_PANEL_TYPE__RECORDER = 2;
  public static final int AUDIO_PANEL_TYPE__VOICE_CHANGER = 0;
  public static final long CHAT_FONT_ID_UNAVAILABLE = 0L;
  public static final int CHAT_INPUT_TYPE_ADUIO = 2;
  public static final int CHAT_INPUT_TYPE_KEYBOARD = 1;
  public static final int CHAT_INPUT_TYPE_NONE = 0;
  public static final int CHAT_SHOW_AUDIO_PANEL = 1;
  public static final int CHAT_SHOW_NONE_PANEL = 0;
  public static final long EXTENSION_INFO_EXPIRATION = 86400000L;
  public static final long PENDANT_ID_UNAVAILABLE = 0L;
  @defaultValue(a=-1)
  public int audioPanelType = -1;
  public int chatInputType = 0;
  public long colorRingId = 0L;
  @notColumn
  public boolean isDataChanged;
  public long pendantId;
  public int pttChangeVoiceType = 0;
  public int showC2CPanel = 1;
  public long timestamp = 0L;
  public long uVipFont;
  @unique
  public String uin;
  
  public boolean isPendantExpired()
  {
    return System.currentTimeMillis() - this.timestamp >= 86400000L;
  }
  
  public boolean isPendantValid()
  {
    return this.pendantId != 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.ExtensionInfo
 * JD-Core Version:    0.7.0.1
 */