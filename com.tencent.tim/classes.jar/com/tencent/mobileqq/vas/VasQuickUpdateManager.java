package com.tencent.mobileqq.vas;

import abgl;
import acbn;
import acdz;
import acgn;
import afem;
import affc;
import afli;
import afqv;
import ahes;
import ahxo;
import ahxp;
import ahxs;
import ajdg;
import alco;
import aldx;
import aldy;
import aldz;
import alem;
import android.content.Context;
import android.text.TextUtils;
import apdj;
import apdr;
import aptj;
import aqgm;
import aqhq;
import aqnl;
import aqpi;
import aqpm;
import aqqj;
import aqqm;
import aqqt;
import aqqv;
import aqrb;
import aqrc;
import aqrd;
import aqri;
import aqrt;
import aqsi;
import aqsm;
import aqsw;
import aqul;
import aquv;
import aqvn;
import aqvn.b;
import aqxp;
import aqyz;
import avcz;
import avde;
import ayzc;
import com.google.gson.stream.JsonReader;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.scupdate.SCUpdatePB.ItemVersion;
import com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB.VCR;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import jml;
import ku;
import lf;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import xks;

public class VasQuickUpdateManager
  implements Manager
{
  public static final long BID_BUBBLE = 2L;
  public static final long BID_CHATBG = 8L;
  public static final long BID_COLOR_NICK = 27L;
  public static final long BID_COLOR_SCREEN = 22L;
  public static final long BID_COMIC = 100L;
  public static final long BID_DEFAULT_CARD = 33L;
  public static final long BID_EMOTICON = 1L;
  public static final long BID_FACE = 23L;
  public static final long BID_FLASH_CHAT = 1002L;
  public static final long BID_FONT = 5L;
  public static final long BID_JSON = 1000L;
  public static final long BID_PENDANT = 4L;
  public static final long BID_POKE = 21L;
  public static final long BID_PRAISE = 20L;
  public static final long BID_PROFILE_CARD = 15L;
  public static final long BID_QUICKUPDATE_TEST = 1999L;
  public static final long BID_REDPACKET = 16L;
  public static final long BID_SIGNATURE_STICKER = 9L;
  public static final long BID_SINGLE_PIC = 1003L;
  public static final long BID_SONIC_TEMPLATE_UPDATE = 1001L;
  public static final long BID_STICKER_GUIDE_MATERIAL = 1004L;
  public static final long BID_TROOP_ENTER_EFFECT = 25L;
  public static final String QUICKUPDATE_TEST_DIR = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".vas_quickupdate_test/");
  public static final String SCID_APNG_SO = "libAPNG_813";
  public static final String SCID_AVATARIN_PENDANT_JSON = "avatarInPendant_json";
  public static final String SCID_BLESS_VOICECHANGE = "blessVoiceList.json";
  public static final String SCID_BUBBLE_PASTER_PREFIX = "bubble.paster.";
  public static final String SCID_BUBBLE_PREFIX = "bubble.android.";
  public static final String SCID_CARD_PREFIX = "card.";
  public static final String SCID_CHANGEVOICE = "changeVoice_json";
  public static final String SCID_CHATBG_PREFIX = "chatbg.";
  public static final String SCID_COLORFONT_SO = "libColorFont_818";
  public static final String SCID_COLOR_NICK_PREFIX = "groupnickitem.";
  public static final String SCID_COLOR_SCREEN_PREFIX = "colorScreen.android.";
  public static final String SCID_COMIC_CONFIG = "vipComic_config_v2.json";
  public static final String SCID_COMIC_NAV_CONFIG = "vipComic_nav_config.json";
  public static final String SCID_COMIC_NAV_ICON = "vipComic_nav_tabIcon.zip";
  public static final String SCID_COMIC_PLAYER_SO = "libqgplayer_765";
  public static final String SCID_DEFAULT_CARD_CFG_PREFIX = "profileitem.";
  public static final String SCID_DEFAULT_FONT = "defaultFont_775";
  public static final String SCID_DIY_CARD_CONFIG = "card.diyFontConfig.json";
  public static final String SCID_DIY_CARD_FONT_PREFIX = "font.diycard.android.";
  public static final String SCID_EMOJI_KEYWORD = "keywordList_2.json";
  public static final String SCID_EMOTICON_RECOMMEND_EFFECT = "emotionRecommendEffect";
  public static final String SCID_ENTER_EFFECT_CONFIG = "groupeffect_config.json";
  public static final String SCID_ENTER_EFFECT_VIP_ICONS = "enterEffectVipIcons";
  public static final String SCID_FACE_PREFIX = "face.";
  public static final String SCID_FLASH_CHAT_PREFIX = "flashchat.";
  public static final String SCID_FLATBUFFERS = "libFlatBuffersParser";
  public static final String SCID_FONT_EFFECT = "magicFontConfig.json";
  public static final String SCID_FONT_FZ_PREFIX = "font.fzfont.android.";
  public static final String SCID_FONT_PREFIX = "font.main.android.";
  public static final String SCID_FUNCDEV_WEBVIEW = "VASBiz_FuncDev_webview.json";
  public static final String SCID_H5_MAGIC_ZIP = "bqmall.android.h5magic.";
  public static final String SCID_HIBOOM_CONFIG_PREFIX = "font.hiFontQQ.json.";
  public static final String SCID_HIBOOM_FONT_PREFIX = "font.hifont.android.";
  public static final String SCID_HIBOOM_TAG = "font.hiFontQQ.tags";
  public static final String SCID_HYFONT_SO = "libVipFont_808";
  public static final String SCID_KANDIAN_RECOMMENT_EMOTICON = "watch_focus.json";
  public static final String SCID_MAGIC_FACE_ENTRY_CONFIG = "emoji_app_vip_emoji_aio_android_config.json";
  public static final String SCID_PENDANT_FONT_PREFIX = "faceAddon.stickerFont.android.";
  public static final String SCID_PENDANT_MARKET_CONFIG = "pendant_market_json.android.v2";
  public static final String SCID_PENDANT_PASTER_PREFIX = "faceAddon.sticker.";
  public static final String SCID_PENDANT_PREFIX = "pendant.";
  public static final String SCID_PERSONAL_CONFIG = "vip_personal_card.json";
  public static final String SCID_POKE_EFFECT_LIST = "poke.effectList";
  public static final String SCID_POKE_EFFECT_PREFIX = "poke.item.res.";
  public static final String SCID_POKE_PANEL_PREFIX = "poke.item.effect.";
  public static final String SCID_PRAISE_CONFIG = "praise.config.json";
  public static final String SCID_PRAISE_PREFIX = "praise.android.";
  public static final String SCID_QUICKUPDATE_TEST_JSON = "scupdate.test.signgle.json";
  public static final String SCID_QUICKUPDATE_TEST_MULTI = "scupdate.test.multi.zip";
  public static final String SCID_QUICKUPDATE_TEST_PRECONFIG = "scupdate.test.2087.cfg";
  public static final String SCID_QUICKUPDATE_TEST_PREFIX = "scupdate.test.";
  public static final String SCID_QUICKUPDATE_TEST_SINGLE = "scupdate.test.single.zip";
  public static final String SCID_REDPACKET_300CHAR = "iRedPacket_v3.char300.json";
  public static final String SCID_REDPACKET_CONFIG = "iRedPacket_v3.json";
  public static final String SCID_REDPACKET_FONT_ZIP = "iRedPacket_v3.font.zip";
  public static final String SCID_REDPACKET_PACKETS_ZIP = "luckyMoney.item.";
  public static final String SCID_REDPACKET_SPECIAL_ZIP = "iRedPacket_v3.specialChar.zip";
  public static final String SCID_SIGNATURE_STICKER_PREFIX = "signature.sticker.";
  public static final String SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX = "signature.item.";
  public static final String SCID_SONIC_FILE_DISCARD = "sonicTemplateUpdate.json";
  public static final String SCID_STICKER_MATERIAL = "emojiStickerGuideZip_v2";
  public static final String SCID_SYSTEM_EMOJI_WHITE_LIST = "emoji.systemEmojiWhiteList.json";
  public static final String SCID_THEME_DIY_BG = "diytheme.json";
  public static final String SCID_THEME_DIY_STYLE = "diytheme.style.json";
  public static final String SCID_TROOP_ENTER_EFFECT_PREFIX = "groupeffect_item_";
  public static final String SCID_URL_CONFIGURABLE = "vipData_individuation_url.android.json";
  public static final String SCID_VAS_MONITOR_BLACKLIST = "monitorAppid";
  public static final String SCID_WEBVIEW_TITLE_CONFIG = "vipData_app_webviewNavStyle.json";
  public static final String SCID_WZRY_TEMPLATE = "cardWZ.zip";
  public static final String SP_QUICK_UPDATE_PREFIX = "quick_update_";
  private static final String TAG = "VasQuickUpdateManager";
  public QQAppInterface app;
  ConcurrentHashMap<Integer, CallBacker> callBackers = new ConcurrentHashMap();
  private aqsm defaultCallback = new DefaultUpdateCallback();
  VasQuickUpdateEngine mEngine;
  AtomicInteger mKey = new AtomicInteger(0);
  aqrd mQuickUpdateObserver = new DefaultVasExtensionObserver();
  
  public VasQuickUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    initEngine();
    paramQQAppInterface.addObserver(this.mQuickUpdateObserver);
  }
  
  /* Error */
  public static void cleanCache()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 411	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: ldc 204
    //   13: invokestatic 415	com/tencent/mobileqq/vas/VasQuickUpdateManager:deleteJSON	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokestatic 421	com/tencent/mobileqq/theme/ThemeCleaner:fl	(Landroid/content/Context;)V
    //   20: aload_0
    //   21: invokestatic 425	aqsw:cleanCache	(Landroid/content/Context;)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: ldc_w 327
    //   31: iconst_1
    //   32: ldc_w 427
    //   35: invokestatic 433	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: goto -14 -> 24
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	15	0	localBaseApplication	BaseApplication
    //   41	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	41	finally
    //   11	24	41	finally
    //   28	38	41	finally
  }
  
  public static void deleteJSON(String paramString)
  {
    try
    {
      paramString = new File(BaseApplicationImpl.getApplication().getFilesDir() + File.separator + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void downloadItem(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, CallBacker paramCallBacker)
  {
    if (paramAppRuntime != null) {}
    for (Manager localManager = paramAppRuntime.getManager(184); (localManager == null) || (!(localManager instanceof VasQuickUpdateManager)); localManager = null)
    {
      QLog.e("VasQuickUpdateManager", 1, "getFileFromLocal, Err0, bid=" + paramLong + ",scid:" + paramString1 + ", mgr:" + localManager + ", app=" + paramAppRuntime + ", filePaht=" + paramString2);
      return;
    }
    paramString2 = (VasQuickUpdateManager)localManager;
    paramString2.addCallBacker(paramCallBacker);
    if (16L == paramLong)
    {
      paramAppRuntime = "getFileFromLocal_redPacket";
      if (("iRedPacket_v3.json".equals(paramString1)) || ("iRedPacket_v3.char300.json".equals(paramString1)) || ("iRedPacket_v3.font.zip".equals(paramString1)) || ("iRedPacket_v3.specialChar.zip".equals(paramString1))) {
        paramAppRuntime = "silent_download.redbag" + paramString1;
      }
      paramString2.downloadItem(paramLong, paramString1, paramAppRuntime);
      return;
    }
    paramString2.downloadItem(paramLong, paramString1, "getFileFromLocal_" + paramLong);
  }
  
  public static File getFileFromLocal(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramAppRuntime != null)) {
      paramString2 = paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString1;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        QLog.e("VasQuickUpdateManager", 1, "getFileFromLocal err filePath, bid=" + paramLong + ",scid:" + paramString1 + ", app=" + paramAppRuntime + ", filePaht=" + paramString2);
      }
      File localFile;
      do
      {
        return null;
        localFile = new File(paramString2);
        if (localFile.exists()) {
          break;
        }
      } while (!paramBoolean);
      downloadItem(paramAppRuntime, paramLong, paramString1, paramString2, paramCallBacker);
      return null;
      return localFile;
    }
  }
  
  public static JSONObject getJSONFromLocal(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocal, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    Object localObject = new File(paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString);
    if (((File)localObject).exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(aqhq.readFileContent((File)localObject));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "getJsonOOM,json_name:" + paramString, localThrowable);
        }
        ((File)localObject).delete();
      }
    }
    if (paramBoolean)
    {
      localObject = paramAppRuntime.getManager(184);
      if ((localObject == null) || (!(localObject instanceof VasQuickUpdateManager)))
      {
        QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocal, manager == null; scid:" + paramString + ", mgr:" + localObject + ", app=" + paramAppRuntime);
        return null;
      }
      paramAppRuntime = (VasQuickUpdateManager)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getJSONFromLocal addCallBacker:" + paramString);
      }
      paramAppRuntime.addCallBacker(paramCallBacker);
      paramAppRuntime.downloadItem(1000L, paramString, "getJSONFromLocal");
    }
    return null;
  }
  
  public static JsonReader getJSONFromLocalByStreamRead(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocalByStreamRead, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    Object localObject = new File(paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString);
    if (((File)localObject).exists()) {
      try
      {
        JsonReader localJsonReader = new JsonReader(new FileReader((File)localObject));
        return localJsonReader;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "getJSONFromLocalByStreamRead error,json_name:" + paramString, localThrowable);
        }
        ((File)localObject).delete();
      }
    }
    if (paramBoolean)
    {
      localObject = paramAppRuntime.getManager(184);
      if ((localObject == null) || (!(localObject instanceof VasQuickUpdateManager)))
      {
        QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocalByStreamRead, manager == null; scid:" + paramString + ", mgr:" + localObject + ", app=" + paramAppRuntime);
        return null;
      }
      paramAppRuntime = (VasQuickUpdateManager)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getJSONFromLocalByStreamRead addCallBacker:" + paramString);
      }
      paramAppRuntime.addCallBacker(paramCallBacker);
      paramAppRuntime.downloadItem(1000L, paramString, "getJSONFromLocal");
    }
    return null;
  }
  
  private void initEngine()
  {
    if (FlatBuffersParser.yl()) {}
    do
    {
      return;
      QLog.e("VasQuickUpdateManager", 1, "initEngine: " + this);
      this.mEngine = VasQuickUpdateEngine.getInstance();
      aqsw.a(this.defaultCallback);
      this.mEngine.mWeakHandler = new WeakReference((aqrb)this.app.getBusinessHandler(71));
    } while ((this.mEngine.mUpdateManagerInstance == 0L) || (!this.mEngine.engineReady.get()));
    this.mEngine.nativeupdateAllItem(this.mEngine.mUpdateManagerInstance);
  }
  
  public void addCallBacker(CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {}
    while (this.callBackers.containsValue(paramCallBacker)) {
      return;
    }
    int i = this.mKey.addAndGet(1);
    this.callBackers.put(Integer.valueOf(i), paramCallBacker);
    paramCallBacker.key = i;
  }
  
  public void addWeakCallback(CallBacker paramCallBacker)
  {
    Object localObject = this.callBackers.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      CallBacker localCallBacker = (CallBacker)((Iterator)localObject).next();
      if (((localCallBacker instanceof WeakCallbacker)) && (((WeakCallbacker)localCallBacker).isWrapOf(paramCallBacker))) {
        return;
      }
    }
    localObject = new WeakCallbacker(paramCallBacker);
    addCallBacker((CallBacker)localObject);
    paramCallBacker.key = ((WeakCallbacker)localObject).key;
  }
  
  public void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasQuickUpdateManager", 2, "callBackToAll Error bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + ", from = " + paramString3 + ", errorCode = " + paramInt1);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callBackers.values().iterator();
      while (localIterator.hasNext()) {
        ((CallBacker)localIterator.next()).callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, this);
      }
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "cancelDwonloadItem bid = " + paramLong + " scid = " + paramString);
    }
    if (this.mEngine != null) {
      this.mEngine.cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadGatherItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + TextUtils.join(",", paramArrayOfString) + " from = " + paramString2);
    }
    if (this.mEngine != null) {
      this.mEngine.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    if (this.mEngine != null) {
      this.mEngine.downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  public void onDestroy()
  {
    QLog.e("VasQuickUpdateManager", 1, "onDestroy: " + this);
    this.app.removeObserver(this.mQuickUpdateObserver);
    if (this.mEngine != null) {
      aqsw.b(this.defaultCallback);
    }
    this.callBackers.clear();
  }
  
  public void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasQuickUpdateManager", 2, "callBackToAll Error bid = " + paramLong1 + ", cfgScid=" + paramString2 + ",scid = " + paramString1);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callBackers.values().iterator();
      while (localIterator.hasNext()) {
        ((CallBacker)localIterator.next()).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, aqqm paramaqqm)
  {
    if (this.mEngine != null)
    {
      paramaqqm = new TimeoutWrapper(paramaqqm, paramBoolean2, null);
      if (paramLong > 0L) {
        ThreadManager.getSubThreadHandler().postDelayed(paramaqqm, paramLong);
      }
      this.mEngine.queryItemVersion(paramInt, paramString, paramBoolean1, paramaqqm);
      return;
    }
    paramaqqm.I(2, "", "");
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {
      return;
    }
    this.callBackers.remove(Integer.valueOf(paramCallBacker.key));
  }
  
  public static abstract class CallBacker
  {
    public int key;
    
    public abstract void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager);
    
    public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  }
  
  class DefaultUpdateCallback
    extends aqsm
  {
    DefaultUpdateCallback() {}
    
    @Nullable
    private Boolean deleteFont(String paramString)
    {
      boolean bool;
      if (paramString.startsWith("font.diycard.android."))
      {
        paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
        paramString = aldy.bVX + paramString;
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font diy card path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.startsWith("font.hifont.android."))
      {
        paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
        paramString = ahxo.bLY + paramString;
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.startsWith("font.hiFontQQ.json."))
      {
        paramString = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
        paramString = ahxo.bLZ + paramString;
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom config path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.startsWith("font.hiFontQQ.tags"))
      {
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(ahxo.bMa));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font hiboom tag result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.startsWith("font.main.android."))
      {
        paramString = paramString.substring("font.main.android.".length(), paramString.length());
        paramString = ku.dV + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.startsWith("font.fzfont.android."))
      {
        paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
        paramString = ku.dW + paramString + File.separatorChar + paramString + ".ttf";
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: font font fz path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.equals("magicFontConfig.json"))
      {
        bool = VasQuickUpdateEngine.safeDeleteFile(new File(ku.eb));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: fontEffect json path = " + ku.eb + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      return null;
    }
    
    @Nullable
    private Boolean deleteJsonFile(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
    {
      paramQQAppInterface = getItemInfo(paramQQAppInterface, paramLong, paramString);
      if (paramQQAppInterface != null)
      {
        boolean bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface.strSavePath));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: bid=" + paramLong + " scid=" + paramString + ", result=" + bool);
        }
        return Boolean.valueOf(bool);
      }
      return null;
    }
    
    @Nullable
    private Boolean deleteMatriel(String paramString)
    {
      if (paramString.equals("libColorFont_818")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(aqnl.getSoDir() + "libFounderColorFont_818.so")));
      }
      if (paramString.equals("kcsdk_4_4_7_3661")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(aqvn.a().bB(VasQuickUpdateManager.this.app.getApp()))));
      }
      if (paramString.equals("GLDrawableV836")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(aqsi.g(VasQuickUpdateManager.this.app.getApp())));
      }
      if (paramString.equals("libFlatBuffersParser"))
      {
        FlatBuffersParser.azd();
        return Boolean.valueOf(true);
      }
      if (paramString.equals("libVipFont_808")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(aqnl.getSoDir() + "libvipfont808.so")));
      }
      if (paramString.startsWith("bqmall.android.h5magic."))
      {
        afli.delete(paramString);
        return Boolean.valueOf(true);
      }
      if (paramString.equals("libqgplayer_765")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(avde.FM() + "libqgplayer_765.so")));
      }
      if (paramString.equals("libAPNG_813")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(aqnl.getSoDir() + "libAPNG_release_813.so")));
      }
      if (paramString.equals("defaultFont_775")) {
        return Boolean.valueOf(VasQuickUpdateEngine.safeDeleteFile(new File(lf.V())));
      }
      if (paramString.equals("enterEffectVipIcons"))
      {
        paramString = apdj.AY();
        if (!TextUtils.isEmpty(paramString)) {
          VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        }
        return Boolean.valueOf(true);
      }
      return null;
    }
    
    @Nullable
    private Boolean deleteProfileCard(String paramString)
    {
      if ("cardWZ.zip".equals(paramString))
      {
        paramString = aldx.aE(VasQuickUpdateManager.this.app.getApp());
        boolean bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: profile card path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      if (paramString.startsWith("card."))
      {
        alco localalco = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).b;
        int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
        return Boolean.valueOf(localalco.i(VasQuickUpdateManager.this.app.getApp(), i));
      }
      return null;
    }
    
    @Nullable
    private Boolean deleteSignature(String paramString)
    {
      if (paramString.startsWith("signature.sticker."))
      {
        paramString = paramString.substring("signature.sticker.".length(), paramString.length());
        boolean bool = VasQuickUpdateEngine.safeDeleteFile(new File(acbn.bmR + paramString));
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: signature sticker path = " + paramString + " result = " + bool);
        }
        return Boolean.valueOf(bool);
      }
      return null;
    }
    
    private void fontProgress(long paramLong1, String paramString, long paramLong2, long paramLong3)
    {
      if (paramLong1 == 5L)
      {
        if (!paramString.startsWith("font.main.android.")) {
          break label63;
        }
        i = Integer.parseInt(paramString.substring("font.main.android.".length(), paramString.length()));
        ((ku)VasQuickUpdateManager.this.app.getManager(42)).d(i, (float)paramLong2 / (float)paramLong3);
      }
      label63:
      do
      {
        do
        {
          return;
        } while (!paramString.startsWith("font.hifont.android."));
        paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
      } while ((TextUtils.isEmpty(paramString)) || (!TextUtils.isDigitsOnly(paramString)));
      int i = Integer.parseInt(paramString);
      ((ahxs)VasQuickUpdateManager.this.app.getManager(219)).in(i, (int)(100L * paramLong2 / paramLong3));
    }
    
    @NotNull
    private VasQuickUpdateEngine.TagItemInfo getBIdJsonInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      String str3 = VasQuickUpdateManager.this.app.getApplication().getFilesDir() + File.separator;
      String str1;
      String str2;
      if (paramString.equals("pendant_market_json.android.v2"))
      {
        str1 = "pendant_market.json";
        str2 = str3;
      }
      for (;;)
      {
        paramTagItemInfo.strSavePath = (str2 + str1);
        return paramTagItemInfo;
        str2 = str3;
        str1 = paramString;
        if (paramString.startsWith("signature.item."))
        {
          str2 = str3;
          str1 = paramString;
          if (paramString.endsWith(".json"))
          {
            paramString = paramString.substring("signature.item.".length(), paramString.length() - 5);
            if (QLog.isColorLevel()) {
              QLog.d("VasQuickUpdateManager", 2, "getItemInfo signature id = " + paramString);
            }
            str1 = "config.json";
            str2 = acbn.bmQ + File.separator + paramString + File.separator;
          }
        }
      }
    }
    
    private boolean getBidBubbleInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      BubbleManager localBubbleManager = (BubbleManager)VasQuickUpdateManager.this.app.getManager(44);
      if (paramString.startsWith("bubble.android."))
      {
        int i = localBubbleManager.cI(paramString);
        if (i > 0)
        {
          paramTagItemInfo.bPreConfig = false;
          if (paramString.endsWith("static.zip"))
          {
            paramTagItemInfo.bSaveInDir = true;
            paramTagItemInfo.strSavePath = (localBubbleManager.d(i).getAbsolutePath() + File.separator + "static");
          }
          for (;;)
          {
            return true;
            if (paramString.endsWith("other.zip"))
            {
              paramTagItemInfo.bSaveInDir = true;
              paramTagItemInfo.strSavePath = localBubbleManager.d(i).getAbsolutePath();
            }
            else if (paramString.endsWith("config.json"))
            {
              paramTagItemInfo.bSaveInDir = false;
              paramTagItemInfo.strSavePath = (localBubbleManager.d(i).getAbsolutePath() + File.separator + "config.json");
            }
          }
        }
      }
      else if (paramString.startsWith("bubble.paster."))
      {
        paramTagItemInfo.bSaveInDir = false;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("bubble.paster.")))
        {
          paramString = paramString.replace("bubble.paster.", "");
          paramTagItemInfo.strSavePath = (localBubbleManager.B().getAbsolutePath() + File.separator + paramString);
          if (QLog.isColorLevel()) {
            QLog.i("VasQuickUpdateManager", 2, "download paster fileName: " + paramTagItemInfo.strSavePath);
          }
        }
        paramTagItemInfo.bPreConfig = false;
        return true;
      }
      return false;
    }
    
    private boolean getBidColorScreenInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      ahes localahes = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_Ahes;
      if (paramString.startsWith("colorScreen.android."))
      {
        int i = localahes.ct(paramString);
        if (i > 0)
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = false;
          paramTagItemInfo.strSavePath = (localahes.e(i).getAbsolutePath() + File.separator + "config.zip");
          return true;
        }
      }
      return false;
    }
    
    @NotNull
    private VasQuickUpdateEngine.TagItemInfo getBidComicInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      paramTagItemInfo.bPreConfig = false;
      if (paramString.equals("vipComic_nav_config.json"))
      {
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = avcz.O().getAbsolutePath();
      }
      while (!paramString.equals("vipComic_nav_tabIcon.zip")) {
        return paramTagItemInfo;
      }
      paramTagItemInfo.bSaveInDir = true;
      paramTagItemInfo.strSavePath = avcz.P().getAbsolutePath();
      return paramTagItemInfo;
    }
    
    private boolean getBidFaceInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      if (paramString.startsWith("face."))
      {
        paramString = VasFaceManager.pS(paramString);
        if (paramString != null)
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = false;
          paramTagItemInfo.strSavePath = paramString;
          return true;
        }
      }
      else if (paramString.equals("avatarInPendant_json"))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = (VasQuickUpdateManager.this.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json");
        return true;
      }
      return false;
    }
    
    @NotNull
    private VasQuickUpdateEngine.TagItemInfo getBidFlashChatInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      FlashChatManager localFlashChatManager = (FlashChatManager)VasQuickUpdateManager.this.app.getManager(217);
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = localFlashChatManager.li(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getItemInfo:  result.strSavePath = " + paramTagItemInfo.strSavePath);
      }
      return paramTagItemInfo;
    }
    
    private VasQuickUpdateEngine.TagItemInfo getBidFontInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      if (paramString.startsWith("font.diycard.android."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = (aldy.bVX + paramString.substring("font.diycard.android.".length(), paramString.length()));
      }
      do
      {
        return paramTagItemInfo;
        if (paramString.startsWith("font.hifont.android."))
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = (ahxo.bLY + paramString.substring("font.hifont.android.".length(), paramString.length()));
          return paramTagItemInfo;
        }
        if (paramString.startsWith("font.hiFontQQ.json."))
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = (ahxo.bLZ + paramString.substring("font.hiFontQQ.json.".length(), paramString.length()));
          return paramTagItemInfo;
        }
        if (paramString.startsWith("font.hiFontQQ.tags"))
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = ahxo.bMa;
          return paramTagItemInfo;
        }
        if (paramString.startsWith("font.main.android."))
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = (ku.dV + File.separator + paramString.substring("font.main.android.".length(), paramString.length()));
          return paramTagItemInfo;
        }
        if (paramString.startsWith("font.fzfont.android."))
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = (ku.dW + paramString.substring("font.fzfont.android.".length(), paramString.length()));
          return paramTagItemInfo;
        }
      } while (!paramString.equals("magicFontConfig.json"));
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = ku.eb;
      return paramTagItemInfo;
    }
    
    @Nullable
    private VasQuickUpdateEngine.TagItemInfo getBidMaterialInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      if (paramString.equals("emojiStickerGuideZip_v2")) {
        paramTagItemInfo.strSavePath = (EmojiStickerManager.uv() + "emojiStickerGuideZip_v2.zip");
      }
      do
      {
        return paramTagItemInfo;
        if (paramString.equals("libFlatBuffersParser"))
        {
          paramTagItemInfo.strSavePath = (FlatBuffersParser.getRootPath() + "libFlatBuffersParser.zip");
          return paramTagItemInfo;
        }
        if (paramString.equals("kcsdk_4_4_7_3661"))
        {
          paramTagItemInfo.strSavePath = aqvn.a().bA(VasQuickUpdateManager.this.app.getApp());
          return paramTagItemInfo;
        }
        if (paramString.equals("GLDrawableV836"))
        {
          paramTagItemInfo.strSavePath = aqsi.bA(VasQuickUpdateManager.this.app.getApp());
          return paramTagItemInfo;
        }
        if (paramString.equals("libColorFont_818"))
        {
          paramTagItemInfo.strSavePath = (ku.dV + File.separator + "libColorFont.zip");
          return paramTagItemInfo;
        }
        if (paramString.equals("libVipFont_808"))
        {
          paramTagItemInfo.strSavePath = (ku.dV + File.separator + "libVipFont.zip");
          return paramTagItemInfo;
        }
        if (paramString.startsWith("bqmall.android.h5magic."))
        {
          paramTagItemInfo.strSavePath = afli.kA(paramString);
          return paramTagItemInfo;
        }
        if (paramString.equals("libqgplayer_765"))
        {
          paramTagItemInfo.strSavePath = (avde.FM() + "libQGamePlayer.zip");
          return paramTagItemInfo;
        }
        if (paramString.equals("libAPNG_813"))
        {
          paramTagItemInfo.strSavePath = (VasQuickUpdateManager.this.app.getApp().getApplicationContext().getFilesDir() + File.separator + "apng.zip");
          return paramTagItemInfo;
        }
        if (paramString.equals("defaultFont_775"))
        {
          paramTagItemInfo.strSavePath = (ku.dV + File.separator + "default.zip");
          return paramTagItemInfo;
        }
      } while (!paramString.equals("enterEffectVipIcons"));
      paramString = apdj.AY();
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS getItemInfo null zipPath");
        return null;
      }
      paramTagItemInfo.strSavePath = paramString;
      return paramTagItemInfo;
    }
    
    private boolean getBidPendantInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      if (paramString.startsWith("faceAddon.stickerFont.android."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = aqgm.pq(paramString.replace("faceAddon.stickerFont.android.", ""));
        return true;
      }
      if (paramString.startsWith("faceAddon.sticker."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = (acbn.bmK + "sticker_info/" + paramString.replace("faceAddon.sticker.", ""));
        return true;
      }
      if ((paramString.startsWith("pendant.")) && (paramString.length() > "pendant.".length()))
      {
        paramString = paramString.substring("pendant.".length(), paramString.length());
        int i = paramString.indexOf(".");
        if (i > 0)
        {
          String str = paramString.substring(0, i);
          paramString.substring(i, paramString.length());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(acbn.bmK).append(str).append(File.separator);
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          if (paramString.endsWith(".xydata.js"))
          {
            paramTagItemInfo.bSaveInDir = false;
            localStringBuilder.append("config.json");
          }
          if (paramString.endsWith(".aio_50.png"))
          {
            paramTagItemInfo.bSaveInDir = false;
            localStringBuilder.append("aio_50.png");
          }
          paramTagItemInfo.strSavePath = localStringBuilder.toString();
          return true;
        }
      }
      return false;
    }
    
    @NotNull
    private VasQuickUpdateEngine.TagItemInfo getBidPokeInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = true;
      if (paramString.startsWith("poke.item.effect.")) {
        paramTagItemInfo.strSavePath = (xks.aVl + paramString.substring("poke.item.effect.".length(), paramString.length()));
      }
      do
      {
        return paramTagItemInfo;
        if (paramString.startsWith("poke.item.res."))
        {
          paramTagItemInfo.strSavePath = (xks.aVl + paramString.substring("poke.item.res.".length(), paramString.length()));
          return paramTagItemInfo;
        }
      } while (!"poke.effectList".equals(paramString));
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = xks.aVm;
      return paramTagItemInfo;
    }
    
    private boolean getBidPraiseInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      PraiseManager localPraiseManager = (PraiseManager)VasQuickUpdateManager.this.app.getManager(209);
      if ((localPraiseManager != null) && (paramString.startsWith("praise.android.")))
      {
        int i = localPraiseManager.dI(paramString);
        if (i > 0)
        {
          paramTagItemInfo.bPreConfig = false;
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = localPraiseManager.f(i).getAbsolutePath();
          return true;
        }
      }
      return false;
    }
    
    private boolean getBidProfileCard(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      boolean bool = false;
      if ("cardWZ.zip".equals(paramString))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = aldx.aE(VasQuickUpdateManager.this.app.getApp());
        bool = true;
      }
      while (!paramString.startsWith("card.")) {
        return bool;
      }
      paramTagItemInfo.bPreConfig = false;
      paramTagItemInfo.bSaveInDir = false;
      int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
      paramString = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).b;
      paramTagItemInfo.strSavePath = alco.f(VasQuickUpdateManager.this.app.getApp(), i);
      return true;
    }
    
    @NotNull
    private VasQuickUpdateEngine.TagItemInfo getBidQuickUpdate(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      paramTagItemInfo.bPreConfig = false;
      if (paramString.endsWith("cfg")) {
        paramTagItemInfo.bPreConfig = true;
      }
      paramTagItemInfo.bSaveInDir = false;
      paramTagItemInfo.strSavePath = (VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString);
      return paramTagItemInfo;
    }
    
    @NotNull
    private VasQuickUpdateEngine.TagItemInfo getBidRedPacket(long paramLong, String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      paramTagItemInfo.bPreConfig = false;
      if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString)))
      {
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = (VasQuickUpdateManager.this.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString);
      }
      if ("iRedPacket_v3.font.zip".equals(paramString))
      {
        paramTagItemInfo.bSaveInDir = true;
        paramTagItemInfo.strSavePath = acgn.dy(3);
      }
      do
      {
        return paramTagItemInfo;
        if ("iRedPacket_v3.specialChar.zip".equals(paramString))
        {
          paramTagItemInfo.bSaveInDir = true;
          paramTagItemInfo.strSavePath = acgn.dy(2);
          return paramTagItemInfo;
        }
      } while ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item.")));
      paramTagItemInfo.bSaveInDir = true;
      String str = acgn.getIDFromSCID(paramString);
      if (TextUtils.isEmpty(str)) {
        QLog.d("VasQuickUpdateManager", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString + " pid = " + str);
      }
      paramTagItemInfo.strSavePath = (acgn.dy(1) + str);
      return paramTagItemInfo;
    }
    
    private boolean getBidSignatureInfo(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      boolean bool = false;
      if (paramString.startsWith("signature.sticker."))
      {
        paramTagItemInfo.bPreConfig = false;
        paramTagItemInfo.bSaveInDir = false;
        paramTagItemInfo.strSavePath = (acbn.bmR + paramString.substring("signature.sticker.".length(), paramString.length()));
        bool = true;
      }
      return bool;
    }
    
    private boolean getBidTroopEnterEffect(String paramString, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo)
    {
      boolean bool = false;
      paramTagItemInfo.bPreConfig = false;
      if (paramString.startsWith("groupeffect_item_"))
      {
        paramTagItemInfo.bSaveInDir = false;
        int i = apdj.eL(paramString);
        paramTagItemInfo.strSavePath = (apdj.cou + i + File.separator + i + ".zip");
        bool = true;
      }
      return bool;
    }
    
    @Nullable
    private Boolean isBubbleExist(String paramString)
    {
      BubbleManager localBubbleManager = (BubbleManager)VasQuickUpdateManager.this.app.getManager(44);
      if (localBubbleManager != null)
      {
        if (paramString.startsWith("bubble.android.")) {
          return Boolean.valueOf(localBubbleManager.isFileExists(paramString));
        }
        if (paramString.startsWith("bubble.paster.")) {
          return Boolean.valueOf(localBubbleManager.ln(paramString));
        }
      }
      return null;
    }
    
    @Nullable
    private Boolean isColorScreenExist(String paramString)
    {
      ahes localahes = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_Ahes;
      if (paramString.startsWith("colorScreen.android.")) {
        return Boolean.valueOf(localahes.isFileExists(paramString));
      }
      return null;
    }
    
    @Nullable
    private Boolean isComicExist(String paramString)
    {
      if (paramString.equals("vipComic_nav_config.json")) {
        return Boolean.valueOf(avcz.aKt());
      }
      if (paramString.equals("vipComic_nav_tabIcon.zip")) {
        return Boolean.valueOf(avcz.aKu());
      }
      return null;
    }
    
    @Nullable
    private Boolean isFaceExist(String paramString)
    {
      VasFaceManager localVasFaceManager = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
      if (paramString.startsWith("face.")) {
        return Boolean.valueOf(localVasFaceManager.isFileExists(paramString));
      }
      if (paramString.equals("avatarInPendant_json")) {
        return Boolean.valueOf(new File(VasQuickUpdateManager.this.app.getApplication().getFilesDir() + File.separator + "avatarInPendant.json").exists());
      }
      return null;
    }
    
    @Nullable
    private Boolean isFontExists(String paramString)
    {
      boolean bool3 = true;
      boolean bool4 = true;
      boolean bool1 = true;
      Object localObject4 = null;
      Object localObject2 = null;
      String str = null;
      Object localObject3 = null;
      Object localObject1 = null;
      boolean bool2 = false;
      int i;
      if (paramString.startsWith("font.diycard.android."))
      {
        paramString = paramString.substring("font.diycard.android.".length(), paramString.length());
        str = aldy.bVX + paramString;
        localObject2 = new File(str);
        paramString = (String)localObject1;
        if (((File)localObject2).exists()) {
          paramString = ((File)localObject2).list();
        }
        localObject1 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject2).exists()).append(" file count = ");
        if (paramString != null)
        {
          i = paramString.length;
          QLog.d("VasQuickUpdateManager", 2, i);
          bool1 = bool2;
          if (((File)localObject2).exists())
          {
            bool1 = bool2;
            if (paramString != null)
            {
              bool1 = bool2;
              if (paramString.length > 0) {
                bool1 = true;
              }
            }
          }
          localObject1 = Boolean.valueOf(bool1);
        }
      }
      label365:
      do
      {
        return localObject1;
        i = 0;
        break;
        if (paramString.startsWith("font.hifont.android."))
        {
          paramString = paramString.substring("font.hifont.android.".length(), paramString.length());
          str = ahxo.bLY + paramString;
          localObject1 = new File(str);
          paramString = (String)localObject2;
          if (((File)localObject1).exists()) {
            paramString = ((File)localObject1).list();
          }
          localObject2 = new StringBuilder().append("isFileExists hiboomfont path = ").append(str).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
          if (paramString != null)
          {
            i = paramString.length;
            QLog.d("VasQuickUpdateManager", 2, i);
            if ((!((File)localObject1).exists()) || (paramString == null) || (paramString.length <= 0)) {
              break label365;
            }
          }
          for (;;)
          {
            return Boolean.valueOf(bool1);
            i = 0;
            break;
            bool1 = false;
          }
        }
        if (paramString.startsWith("font.hiFontQQ.json."))
        {
          paramString = paramString.substring("font.hiFontQQ.json.".length(), paramString.length());
          localObject2 = ahxo.bLZ + paramString;
          localObject1 = new File((String)localObject2);
          paramString = str;
          if (((File)localObject1).exists()) {
            paramString = ((File)localObject1).list();
          }
          localObject2 = new StringBuilder().append("isFileExists hiboomconfig path = ").append((String)localObject2).append(" exist = ").append(((File)localObject1).exists()).append(" file count = ");
          if (paramString != null)
          {
            i = paramString.length;
            QLog.d("VasQuickUpdateManager", 2, i);
            if ((!((File)localObject1).exists()) || (paramString == null) || (paramString.length <= 0)) {
              break label535;
            }
          }
          for (bool1 = bool3;; bool1 = false)
          {
            return Boolean.valueOf(bool1);
            i = 0;
            break;
          }
        }
        if (paramString.startsWith("font.hiFontQQ.tags"))
        {
          localObject1 = new File(ahxo.bMa);
          paramString = localObject3;
          if (((File)localObject1).exists()) {
            paramString = ((File)localObject1).list();
          }
          if ((paramString != null) && (paramString.length > 0)) {}
          for (bool1 = bool4;; bool1 = false) {
            return Boolean.valueOf(bool1);
          }
        }
        if (paramString.startsWith("font.main.android."))
        {
          paramString = paramString.substring("font.main.android.".length(), paramString.length());
          paramString = ku.dV + File.separatorChar + paramString + File.separatorChar + paramString + ".ttf";
          localObject1 = new File(paramString);
          QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
          return Boolean.valueOf(((File)localObject1).exists());
        }
        if (paramString.startsWith("font.fzfont.android."))
        {
          paramString = paramString.substring("font.fzfont.android.".length(), paramString.length());
          paramString = ku.dW + paramString + File.separatorChar + paramString + ".ttf";
          localObject1 = new File(paramString);
          QLog.d("VasQuickUpdateManager", 2, "isFileExists font path = " + paramString + " result = " + ((File)localObject1).exists());
          return Boolean.valueOf(((File)localObject1).exists());
        }
        localObject1 = localObject4;
      } while (!paramString.equals("magicFontConfig.json"));
      label535:
      paramString = new File(ku.eb);
      QLog.d("VasQuickUpdateManager", 2, "isFileExists fontEffectJson path = " + ku.eb + " result = " + paramString.exists());
      return Boolean.valueOf(paramString.exists());
    }
    
    @Nullable
    private Boolean isMaterialExist(String paramString)
    {
      boolean bool = true;
      if (paramString.startsWith("libColorFont_818")) {
        return Boolean.valueOf(new File(aqnl.getSoDir() + "libFounderColorFont_818.so").exists());
      }
      if (paramString.startsWith("libFlatBuffersParser")) {
        return Boolean.valueOf(new File(FlatBuffersParser.getRootPath() + "libFlatBuffersParser.zip").exists());
      }
      if (paramString.equals("kcsdk_4_4_7_3661")) {
        return Boolean.valueOf(new File(aqvn.a().bB(VasQuickUpdateManager.this.app.getApp())).exists());
      }
      if (paramString.equals("GLDrawableV836")) {
        return Boolean.valueOf(aqsi.cg(VasQuickUpdateManager.this.app.getApp()));
      }
      if (paramString.equals("emojiStickerGuideZip_v2")) {
        return Boolean.valueOf(new File(EmojiStickerManager.uv() + "emojiStickerGuideZip_v2.zip").exists());
      }
      if (paramString.equals("libVipFont_808")) {
        return Boolean.valueOf(new File(aqnl.getSoDir() + "libvipfont808.so").exists());
      }
      if (paramString.startsWith("bqmall.android.h5magic.")) {
        return Boolean.valueOf(new File(afli.kA(paramString)).exists());
      }
      if (paramString.equals("libqgplayer_765")) {
        return Boolean.valueOf(new File(avde.FM() + "libqgplayer_765.so").exists());
      }
      if (paramString.equals("libAPNG_813")) {
        return Boolean.valueOf(aqqv.a().Qu());
      }
      if (paramString.equals("defaultFont_775"))
      {
        paramString = new File(aqnl.getSoDir() + lf.eF);
        if ((paramString.exists()) && (paramString.isDirectory())) {}
        for (;;)
        {
          return Boolean.valueOf(bool);
          bool = false;
        }
      }
      if (paramString.equals("enterEffectVipIcons"))
      {
        paramString = apdj.AY();
        if (TextUtils.isEmpty(paramString))
        {
          QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS: get null zipPath");
          return Boolean.valueOf(false);
        }
        return Boolean.valueOf(new File(paramString).exists());
      }
      return null;
    }
    
    @Nullable
    private Boolean isPendantExist(String paramString)
    {
      boolean bool = true;
      if (paramString.startsWith("faceAddon.stickerFont.android.")) {
        return Boolean.valueOf(aqgm.rm(paramString.replace("faceAddon.stickerFont.android.", "")));
      }
      if (paramString.startsWith("faceAddon.sticker.")) {
        return Boolean.valueOf(aqgm.rn(paramString));
      }
      if ((paramString.startsWith("pendant.")) && (paramString.length() > "pendant.".length()))
      {
        paramString = paramString.substring("pendant.".length());
        int i = paramString.indexOf(".");
        if (i <= 0) {
          return null;
        }
        Object localObject = paramString.substring(0, i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(acbn.bmK).append((String)localObject).append(File.separator);
        if (paramString.endsWith(".xydata.js")) {
          localStringBuilder.append("config.json");
        }
        for (;;)
        {
          localObject = new File(localStringBuilder.toString());
          if (!((File)localObject).exists()) {
            break label366;
          }
          if (!((File)localObject).isDirectory()) {
            break label315;
          }
          if (((File)localObject).listFiles() != null) {
            break;
          }
          return Boolean.valueOf(false);
          if (paramString.endsWith(".aio_50.png")) {
            localStringBuilder.append("aio_50.png");
          } else if (paramString.endsWith(".other.zip")) {
            localStringBuilder.append("aio_file");
          }
        }
        i = ((File)localObject).listFiles().length;
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " listFile length = " + i + " filepath = " + localStringBuilder.toString());
        }
        if (i > 0) {}
        for (;;)
        {
          return Boolean.valueOf(bool);
          bool = false;
        }
        label315:
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " exists filepath = " + localStringBuilder.toString());
        }
        return Boolean.valueOf(true);
        label366:
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "isFileExists scid = " + paramString + " not exists filepath = " + localStringBuilder.toString());
        }
        return Boolean.valueOf(false);
      }
      return null;
    }
    
    @Nullable
    private Boolean isPokeExist(String paramString)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      int i;
      if (paramString.startsWith("poke.item.effect."))
      {
        paramString = paramString.substring("poke.item.effect.".length(), paramString.length());
        try
        {
          i = Integer.valueOf(paramString).intValue();
          if (i == -1) {
            return Boolean.valueOf(bool1);
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasQuickUpdateManager", 2, "id error");
            }
            i = -1;
            continue;
            bool1 = xks.G("effect.gif", i);
          }
        }
      }
      if (paramString.startsWith("poke.item.res."))
      {
        paramString = paramString.substring("poke.item.res.".length(), paramString.length());
        try
        {
          i = Integer.valueOf(paramString).intValue();
          if (i == -1)
          {
            bool1 = bool2;
            return Boolean.valueOf(bool1);
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasQuickUpdateManager", 2, "id error");
            }
            i = -1;
            continue;
            bool1 = xks.G("bubble", i);
          }
        }
      }
      if ("poke.effectList".equals(paramString)) {
        return Boolean.valueOf(new File(xks.aVm).exists());
      }
      return null;
    }
    
    @Nullable
    private Boolean isProfileCardExist(String paramString)
    {
      if ("cardWZ.zip".equals(paramString)) {
        return Boolean.valueOf(aldx.W(VasQuickUpdateManager.this.app.getApp(), paramString));
      }
      if (paramString.startsWith("card."))
      {
        int i = Integer.parseInt(paramString.substring("card.".length(), paramString.length()));
        paramString = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).b;
        return Boolean.valueOf(alco.h(VasQuickUpdateManager.this.app.getApp(), i));
      }
      return null;
    }
    
    private boolean isRedPacketExist(String paramString)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      Object localObject2 = null;
      Object localObject1 = null;
      if (("iRedPacket_v3.json".equals(paramString)) || ("iRedPacket_v3.char300.json".equals(paramString))) {
        paramString = VasQuickUpdateManager.this.app.getApp().getApplicationContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + paramString;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString)) {}
        for (paramString = localObject1;; paramString = new File(paramString))
        {
          if ((paramString == null) || (!paramString.exists())) {
            break label293;
          }
          return bool2;
          if ("iRedPacket_v3.font.zip".equals(paramString))
          {
            paramString = acgn.b(null, null, 8, 0, 0);
            break;
          }
          if ("iRedPacket_v3.specialChar.zip".equals(paramString))
          {
            paramString = acgn.b(null, null, 25, 0, 0);
            break;
          }
          if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("luckyMoney.item."))) {
            break label295;
          }
          paramString = acgn.getIDFromSCID(paramString);
          if (TextUtils.isEmpty(paramString)) {
            break label295;
          }
          paramString = acgn.b(paramString, null, 24, 0, 0);
          if (TextUtils.isEmpty(paramString))
          {
            paramString = localObject2;
            label194:
            if ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()) || (paramString.list() == null) || (paramString.list().length <= 1)) {
              break label276;
            }
          }
          for (;;)
          {
            bool2 = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VasQuickUpdateManager", 2, "isFileExists SCID_REDPACKET_PACKETS_ZIP result = " + bool1);
            return bool1;
            paramString = new File(paramString);
            break label194;
            label276:
            bool1 = false;
          }
        }
        label293:
        return false;
        label295:
        paramString = null;
      }
    }
    
    @Nullable
    private Boolean isSignatureExist(String paramString)
    {
      if (paramString.startsWith("signature.sticker."))
      {
        paramString = paramString.substring("signature.sticker.".length(), paramString.length());
        return Boolean.valueOf(new File(acbn.bmR + paramString).exists());
      }
      return null;
    }
    
    @Nullable
    private Boolean isTroopEnterEffectExist(String paramString)
    {
      int i = apdj.eL(paramString);
      if (i > 0) {
        return Boolean.valueOf(aptj.E(new File(apdj.cou + i)));
      }
      return null;
    }
    
    private void onBubbleCompleted(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      BubbleManager localBubbleManager = (BubbleManager)VasQuickUpdateManager.this.app.getManager(44);
      if (paramString1.startsWith("bubble.android.")) {
        localBubbleManager.e(paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
      while (!paramString1.startsWith("bubble.paster.")) {
        return;
      }
      localBubbleManager.d(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    
    private void onColorScreenCompleted(String paramString, int paramInt)
    {
      ahes localahes = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_Ahes;
      if (paramString.startsWith("colorScreen.android.")) {
        localahes.eL(paramString, paramInt);
      }
    }
    
    private void onComicCompleted(String paramString, int paramInt)
    {
      if (paramInt == 0)
      {
        if (!paramString.equals("vipComic_nav_config.json")) {
          break label18;
        }
        avcz.ezw();
      }
      label18:
      while (!paramString.equals("vipComic_nav_tabIcon.zip")) {
        return;
      }
      avcz.aKu();
    }
    
    private void onDefaultCardCompleted(String paramString, int paramInt)
    {
      if (paramString.startsWith("profileitem."))
      {
        alco localalco = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).b;
        int i = Integer.parseInt(paramString.substring("profileitem.".length()));
        localalco.M.remove(Integer.valueOf(i));
        if (paramInt == 0) {
          localalco.a(i, false);
        }
      }
      else
      {
        return;
      }
      QLog.e("VasQuickUpdateManager", 2, "onCompleted: default card download error: " + paramInt + " scid=" + paramString);
    }
    
    private void onFaceCompleted(String paramString, int paramInt)
    {
      VasFaceManager localVasFaceManager = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager;
      if (paramString.startsWith("face.")) {
        localVasFaceManager.onComplete(paramString, paramInt);
      }
    }
    
    private void onFlashChatCompleted(String paramString, int paramInt)
    {
      FlashChatManager localFlashChatManager = (FlashChatManager)VasQuickUpdateManager.this.app.getManager(217);
      if (localFlashChatManager != null) {
        localFlashChatManager.eK(paramString, paramInt);
      }
    }
    
    private void onFontCompleted(String paramString1, String paramString2, int paramInt)
    {
      if (paramString1.startsWith("font.diycard.android.")) {
        if (paramInt == 0)
        {
          paramString1 = paramString1.substring("font.diycard.android.".length(), paramString1.length());
          if (TextUtils.isDigitsOnly(paramString1))
          {
            paramInt = Integer.parseInt(paramString1);
            ahxo.a().b(paramInt, 1, ahxs.c).KE(false);
          }
        }
      }
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return;
              if (!paramString1.startsWith("font.hifont.android.")) {
                break;
              }
              paramString1 = paramString1.substring("font.hifont.android.".length(), paramString1.length());
            } while (!TextUtils.isDigitsOnly(paramString1));
            i = Integer.parseInt(paramString1);
            if (paramInt == 0) {
              ahxo.a().b(i, 0, ahxs.b).KE(false);
            }
            for (;;)
            {
              ((ahxs)VasQuickUpdateManager.this.app.getManager(219)).io(i, paramInt);
              return;
              ahxo.a().b(i, 0, ahxs.b).dqJ();
            }
            if (!paramString1.startsWith("font.hiFontQQ.json.")) {
              break;
            }
            paramString1 = paramString1.substring("font.hiFontQQ.json.".length(), paramString1.length());
          } while (!TextUtils.isDigitsOnly(paramString1));
          i = Integer.parseInt(paramString1);
          if (paramInt == 0)
          {
            ((ahxs)VasQuickUpdateManager.this.app.getManager(219)).c(i, false, true, true);
            return;
          }
          VasWebviewUtil.reportCommercialDrainage(VasQuickUpdateManager.this.app.getCurrentUin(), "HighFont", "DownCoverFail", "", 1, 0, 0, "", paramString1, "");
          return;
          if (!paramString1.startsWith("font.hiFontQQ.tags")) {
            break;
          }
        } while (paramInt != 0);
        ((ahxs)VasQuickUpdateManager.this.app.getManager(219)).dqL();
        return;
        if (paramString1.startsWith("font.main.android."))
        {
          i = Integer.parseInt(paramString1.substring("font.main.android.".length(), paramString1.length()));
          ((ku)VasQuickUpdateManager.this.app.getManager(42)).c(i, paramInt, paramString2);
          return;
        }
        if (paramString1.startsWith("font.fzfont.android."))
        {
          i = Integer.parseInt(paramString1.substring("font.fzfont.android.".length(), paramString1.length()));
          ((ku)VasQuickUpdateManager.this.app.getManager(42)).c(i, paramInt, paramString2);
          return;
        }
      } while (!paramString1.equals("magicFontConfig.json"));
      ((ku)VasQuickUpdateManager.this.app.getManager(42)).g(new File(ku.eb));
    }
    
    private void onJsonCompleted(String paramString, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "onCompleted emoji keyword errorCode = " + paramInt);
      }
      if (paramInt != 0) {}
      label170:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramString.equals("keywordList_2.json")) {
                break;
              }
              paramString = (ajdg)VasQuickUpdateManager.this.app.getManager(14);
            } while (paramString == null);
            paramString.dwh();
            return;
            if (paramString.startsWith("signature.item."))
            {
              aqnl.H(VasQuickUpdateManager.this.app);
              return;
            }
            if ("vipData_individuation_url.android.json".equals(paramString))
            {
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder().append("onCompleted url_configurable ,errorCode = ").append(paramInt).append(", app=");
                if (VasQuickUpdateManager.this.app == null) {
                  break label170;
                }
              }
              for (boolean bool = true;; bool = false)
              {
                QLog.d("VasQuickUpdateManager", 2, bool);
                aqqj.k(VasQuickUpdateManager.this.app);
                return;
              }
            }
            if ("changeVoice_json".equals(paramString))
            {
              ((aqxp)VasQuickUpdateManager.this.app.getManager(176)).a(null, null);
              return;
            }
            if (!"blessVoiceList.json".equals(paramString)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VasQuickUpdateManager", 2, "onCompleted blessVoiceChange ,errorCode = " + paramInt);
          return;
          if ("vip_personal_card.json".equals(paramString))
          {
            aqrt.a().d(VasQuickUpdateManager.this.app, true);
            aqpi.eE(VasQuickUpdateManager.this.app);
            aquv.a().p(VasQuickUpdateManager.this.app);
            return;
          }
          if ("monitorAppid".equals(paramString))
          {
            ((aqri)VasQuickUpdateManager.this.app.getBusinessHandler(103)).c(VasQuickUpdateManager.this.app, true);
            return;
          }
          if ("praise.config.json".equals(paramString))
          {
            alem.k(VasQuickUpdateManager.this.app);
            return;
          }
          if ("card.diyFontConfig.json".equals(paramString))
          {
            aldz.k(VasQuickUpdateManager.this.app);
            return;
          }
          if ("vipData_app_webviewNavStyle.json".equals(paramString))
          {
            aqyz.a().k(VasQuickUpdateManager.this.app);
            return;
          }
          if ("VASBiz_FuncDev_webview.json".equals(paramString))
          {
            jml.a().ayi();
            jml.a().ayd();
            jml.a().ayb();
            return;
          }
          if (!"watch_focus.json".equals(paramString)) {
            break;
          }
          paramString = (acdz)VasQuickUpdateManager.this.app.getBusinessHandler(12);
        } while (paramString == null);
        paramString.cIs();
        return;
        if ("groupeffect_config.json".equals(paramString))
        {
          ((apdr)VasQuickUpdateManager.this.app.getManager(231)).Rz(false);
          return;
        }
      } while (!"emoji.systemEmojiWhiteList.json".equals(paramString));
      afqv.a(VasQuickUpdateManager.this.app, true);
    }
    
    private boolean onMaterialCompleted(String paramString, int paramInt)
    {
      Object localObject;
      boolean bool;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onCompleted sticker material ,errorCode = ").append(paramInt).append(", app=");
        if (VasQuickUpdateManager.this.app != null)
        {
          bool = true;
          QLog.d("VasQuickUpdateManager", 2, bool);
        }
      }
      else
      {
        if (paramInt == 0)
        {
          if (!paramString.equals("emojiStickerGuideZip_v2")) {
            break label111;
          }
          EmojiStickerManager.cZU();
        }
        label75:
        if (!paramString.equals("libColorFont_818")) {
          break label126;
        }
        ((ku)VasQuickUpdateManager.this.app.getManager(42)).z(4, paramInt);
      }
      for (;;)
      {
        return false;
        bool = false;
        break;
        label111:
        if (!paramString.equals("libFlatBuffersParser")) {
          break label75;
        }
        FlatBuffersParser.azc();
        break label75;
        label126:
        if (paramString.equals("libVipFont_808"))
        {
          ((ku)VasQuickUpdateManager.this.app.getManager(42)).z(1, paramInt);
        }
        else if (paramString.startsWith("bqmall.android.h5magic."))
        {
          ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_Afli.ey(paramString, paramInt);
        }
        else if (paramString.equals("libqgplayer_765"))
        {
          avde.V(VasQuickUpdateManager.this.app, paramInt);
        }
        else if (paramString.equals("kcsdk_4_4_7_3661"))
        {
          aqvn.a().aS(VasQuickUpdateManager.this.app.getApp(), paramInt);
        }
        else if (paramString.equals("GLDrawableV836"))
        {
          aqsi.aS(VasQuickUpdateManager.this.app.getApp(), paramInt);
        }
        else if (paramString.equals("libAPNG_813"))
        {
          aqqv.a().XL(paramInt);
        }
        else if (paramString.equals("defaultFont_775"))
        {
          lf.a(VasQuickUpdateManager.this.app, paramInt);
        }
        else if ((paramString.equals("enterEffectVipIcons")) && (paramInt == 0))
        {
          paramString = apdj.AY();
          localObject = apdj.AZ();
          if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject)))
          {
            QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS onComplete null path: " + paramString + "," + (String)localObject);
            return true;
          }
          try
          {
            aqhq.W(paramString, (String)localObject, false);
          }
          catch (IOException paramString)
          {
            QLog.e("VasQuickUpdateManager", 1, "SCID_ENTER_EFFECT_VIP_ICONS onCompleted error", paramString);
          }
        }
      }
    }
    
    private void onPokeCompleted(String paramString)
    {
      if ("poke.effectList".equals(paramString))
      {
        paramString = (afem)VasQuickUpdateManager.this.app.getManager(77);
        if (paramString != null)
        {
          paramString = (affc)paramString.a("qq.android.poke.res_0625");
          if (paramString != null) {
            paramString.cYO();
          }
        }
      }
    }
    
    private void onProfileCardCompleted(String paramString1, String paramString2, int paramInt)
    {
      if ("cardWZ.zip".equals(paramString1)) {
        aldx.l(VasQuickUpdateManager.this.app, paramString1, paramString2, paramInt);
      }
      while (!paramString1.startsWith("card.")) {
        return;
      }
      ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).b.l(VasQuickUpdateManager.this.app, paramString1, paramString2, paramInt);
    }
    
    private void onTroopEnterEffectCompleted(String paramString, int paramInt)
    {
      if (paramInt == 0)
      {
        paramInt = apdj.eL(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect", 2, "download Res onCompleted success id = " + paramInt);
        }
        if (paramInt > 0) {
          paramString = apdj.fL(paramInt);
        }
      }
      try
      {
        if (new File(paramString).exists()) {
          aqhq.W(paramString, apdj.cou, false);
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("TroopEnterEffect", 1, "Res Download unCompress error: " + paramString.getLocalizedMessage());
      }
    }
    
    private void pendantCompleted(String paramString, int paramInt)
    {
      if (paramString.startsWith("faceAddon.stickerFont.android.")) {
        if (paramInt == 0) {
          abgl.a().Bx(paramString);
        }
      }
      long l;
      AvatarPendantManager localAvatarPendantManager;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramString.startsWith("faceAddon.sticker.")) {
                break;
              }
            } while (paramInt != 0);
            abgl.a().Bw(paramString);
            return;
          } while ((!paramString.startsWith("pendant.")) || (paramString.length() <= "pendant.".length()));
          paramString = paramString.substring("pendant.".length(), paramString.length());
          paramInt = paramString.indexOf(".");
        } while (paramInt <= 0);
        l = Long.parseLong(paramString.substring(0, paramInt));
        localAvatarPendantManager = (AvatarPendantManager)VasQuickUpdateManager.this.app.getManager(46);
        if (paramString.endsWith(".xydata.js"))
        {
          localAvatarPendantManager.a(l).mb(PendantInfo.ebQ);
          return;
        }
        if (paramString.endsWith(".aio_50.png"))
        {
          localAvatarPendantManager.a(l).ba(l, 1);
          return;
        }
      } while (!paramString.endsWith(".other.zip"));
      localAvatarPendantManager.a(l).ba(l, 2);
    }
    
    private void sonicTemplateCompleted(String paramString, int paramInt)
    {
      if ((paramInt == 0) && ("sonicTemplateUpdate.json".equals(paramString)))
      {
        paramString = (aqqt)VasQuickUpdateManager.this.app.getManager(192);
        if (paramString != null) {
          paramString.efb();
        }
      }
    }
    
    public void _onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      if ((QLog.isColorLevel()) || (paramInt1 != 0)) {
        QLog.d("VasQuickUpdateManager", 2, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " errorCode = " + paramInt1 + " httpCode = " + paramInt2);
      }
      if (paramLong == 1000L) {
        onJsonCompleted(paramString1, paramInt1);
      }
      for (;;)
      {
        VasQuickUpdateManager.this.callBackToAll(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
        return;
        if (paramLong == 5L)
        {
          onFontCompleted(paramString1, paramString3, paramInt1);
        }
        else if (paramLong == 2L)
        {
          onBubbleCompleted(paramString1, paramString2, paramString3, paramInt1, paramInt2);
        }
        else if (paramLong == 22L)
        {
          onColorScreenCompleted(paramString1, paramInt1);
        }
        else if (paramLong == 23L)
        {
          onFaceCompleted(paramString1, paramInt1);
        }
        else
        {
          if (paramLong == 4L)
          {
            pendantCompleted(paramString1, paramInt1);
            return;
          }
          if (paramLong == 1001L) {
            sonicTemplateCompleted(paramString1, paramInt1);
          } else if (paramLong == 20L) {
            ((PraiseManager)VasQuickUpdateManager.this.app.getManager(209)).e(paramString1, paramString2, paramString3, paramInt1, paramInt2);
          } else if (paramLong == 1004L)
          {
            if (!onMaterialCompleted(paramString1, paramInt1)) {}
          }
          else if (paramLong == 1002L) {
            onFlashChatCompleted(paramString1, paramInt1);
          } else if (paramLong == 15L) {
            onProfileCardCompleted(paramString1, paramString3, paramInt1);
          } else if (paramLong == 21L) {
            onPokeCompleted(paramString1);
          } else if (paramLong == 100L) {
            onComicCompleted(paramString1, paramInt1);
          } else if ((paramLong == 25L) && (paramString1.startsWith("groupeffect_item_"))) {
            onTroopEnterEffectCompleted(paramString1, paramInt1);
          } else if (paramLong == 8L) {
            ((ChatBackgroundManager)VasQuickUpdateManager.this.app.getManager(63)).a(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, VasQuickUpdateManager.this);
          } else if (paramLong == 33L) {
            onDefaultCardCompleted(paramString1, paramInt1);
          }
        }
      }
    }
    
    public void _onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
    {
      if (paramLong1 == 2L) {
        ((BubbleManager)VasQuickUpdateManager.this.app.getManager(44)).b(paramString1, paramString2, paramLong2, paramLong3);
      }
      fontProgress(paramLong1, paramString1, paramLong2, paramLong3);
      if ((paramLong1 == 1004L) && (paramString1.startsWith("bqmall.android.h5magic."))) {
        ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_Afli.onProgress(paramString1, paramLong2, paramLong3);
      }
      if (paramLong1 == 15L) {
        if (paramString1.startsWith("card.")) {
          ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).b.aO(Integer.parseInt(paramString1.substring("card.".length(), paramString1.length())), (int)(100L * paramLong2 / paramLong3));
        }
      }
      for (;;)
      {
        VasQuickUpdateManager.this.onProgressToAll(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
        return;
        if (paramLong1 == 8L) {
          ((ChatBackgroundManager)VasQuickUpdateManager.this.app.getManager(63)).a(VasQuickUpdateManager.this.app, paramLong1, paramString1, (int)(100L * paramLong2 / paramLong3));
        }
      }
    }
    
    public boolean canUpdate(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2)
    {
      if ((paramLong == 5L) && (paramString1.startsWith("font.main.android.")))
      {
        paramQQAppInterface = paramString1.substring("font.main.android.".length(), paramString1.length());
        if (TextUtils.isEmpty(paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.e("VasQuickUpdateManager", 2, "canUpdate error: font id is empty");
          }
          return false;
        }
        int i = Integer.parseInt(paramQQAppInterface);
        if (!((ku)VasQuickUpdateManager.this.app.getManager(42)).v(i)) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      return true;
    }
    
    public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
    {
      boolean bool;
      if ((paramLong == 1000L) || (paramLong == 1003L) || (paramLong == 21L) || (paramLong == 2L) || (paramLong == 16L) || (paramLong == 20L) || (paramLong == 4L) || (paramLong == 23L)) {
        bool = deleteJsonFile(paramQQAppInterface, paramLong, paramString).booleanValue();
      }
      for (;;)
      {
        QLog.e("VasQuickUpdateManager", 1, "deleteFiles : bid = " + paramLong + " scid = " + paramString + " result:" + bool);
        return bool;
        if (paramLong == 1004L)
        {
          bool = deleteMatriel(paramString).booleanValue();
        }
        else if (paramLong == 5L)
        {
          bool = deleteFont(paramString).booleanValue();
        }
        else if (paramLong == 9L)
        {
          bool = deleteSignature(paramString).booleanValue();
        }
        else if (paramLong == 15L)
        {
          bool = deleteProfileCard(paramString).booleanValue();
        }
        else if (paramLong == 22L)
        {
          paramQQAppInterface = ((aqrc)VasQuickUpdateManager.this.app.getManager(235)).jdField_a_of_type_Ahes;
          if (paramString.startsWith("colorScreen.android.")) {
            paramQQAppInterface.deleteFiles(paramString);
          }
          bool = false;
        }
        else if (paramLong == 1999L)
        {
          paramQQAppInterface = VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString;
          bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: quickupdate test path = " + paramQQAppInterface + " result = " + bool);
        }
        else if (paramLong == 25L)
        {
          int i = apdj.eL(paramString);
          paramQQAppInterface = apdj.cou + i;
          bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: ENTER_EFFECT path = " + paramQQAppInterface + " result = " + bool);
        }
        else if (paramLong == 8L)
        {
          paramQQAppInterface = paramString.substring("chatbg.".length(), paramString.length());
          ChatBackgroundManager localChatBackgroundManager = (ChatBackgroundManager)VasQuickUpdateManager.this.app.getManager(63);
          bool = VasQuickUpdateEngine.safeDeleteFile(new File(ChatBackgroundManager.lV(paramQQAppInterface)));
        }
        else if (paramLong == 27L)
        {
          paramQQAppInterface = paramString.substring("groupnickitem.".length(), paramString.length());
          paramQQAppInterface = aqpm.cuR + paramQQAppInterface;
          bool = VasQuickUpdateEngine.safeDeleteFile(new File(paramQQAppInterface));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: COLOR_NICK path = " + paramQQAppInterface + " result = " + bool);
        }
        else if (paramLong == 33L)
        {
          paramQQAppInterface = paramString.substring("profileitem.".length());
          bool = VasQuickUpdateEngine.safeDeleteFile(new File(alco.mK(paramQQAppInterface)));
          QLog.d("VasQuickUpdateManager", 2, "deleteFiles: Default Card Config id=" + paramQQAppInterface + " ret=" + bool);
        }
        else
        {
          bool = false;
        }
      }
    }
    
    public long getBID()
    {
      return 0L;
    }
    
    public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
    {
      paramQQAppInterface = new VasQuickUpdateEngine.TagItemInfo();
      if ((paramLong == 1000L) || (paramLong == 1001L)) {
        return getBIdJsonInfo(paramString, paramQQAppInterface);
      }
      if (paramLong == 1002L) {
        return getBidFlashChatInfo(paramString, paramQQAppInterface);
      }
      if (paramLong == 5L) {
        return getBidFontInfo(paramString, paramQQAppInterface);
      }
      boolean bool;
      if (paramLong == 22L) {
        bool = getBidColorScreenInfo(paramString, paramQQAppInterface);
      }
      for (;;)
      {
        if (bool)
        {
          return paramQQAppInterface;
          if (paramLong == 23L)
          {
            bool = getBidFaceInfo(paramString, paramQQAppInterface);
            continue;
          }
          if (paramLong == 2L)
          {
            bool = getBidBubbleInfo(paramString, paramQQAppInterface);
            continue;
          }
          if (paramLong == 4L)
          {
            bool = getBidPendantInfo(paramString, paramQQAppInterface);
            continue;
          }
          if (paramLong == 20L)
          {
            bool = getBidPraiseInfo(paramString, paramQQAppInterface);
            continue;
          }
          Object localObject;
          if (paramLong == 1003L)
          {
            paramQQAppInterface.bPreConfig = false;
            paramQQAppInterface.bSaveInDir = false;
            localObject = VasQuickUpdateManager.this.app.getApplication().getFilesDir() + File.separator;
            paramQQAppInterface.strSavePath = ((String)localObject + paramString);
            return paramQQAppInterface;
          }
          if (paramLong == 16L) {
            return getBidRedPacket(paramLong, paramString, paramQQAppInterface);
          }
          if (paramLong == 1004L) {
            return getBidMaterialInfo(paramString, paramQQAppInterface);
          }
          if (paramLong == 15L)
          {
            if (getBidProfileCard(paramString, paramQQAppInterface)) {
              return paramQQAppInterface;
            }
          }
          else
          {
            if (paramLong == 21L) {
              return getBidPokeInfo(paramString, paramQQAppInterface);
            }
            if (paramLong == 9L)
            {
              bool = getBidSignatureInfo(paramString, paramQQAppInterface);
              continue;
            }
            if (paramLong == 1999L) {
              return getBidQuickUpdate(paramString, paramQQAppInterface);
            }
            if (paramLong == 100L) {
              return getBidComicInfo(paramString, paramQQAppInterface);
            }
            if (paramLong == 25L)
            {
              bool = getBidTroopEnterEffect(paramString, paramQQAppInterface);
              continue;
            }
            if (paramLong == 8L)
            {
              localObject = (ChatBackgroundManager)VasQuickUpdateManager.this.app.getManager(63);
              paramString = paramString.substring("chatbg.".length(), paramString.length());
              paramQQAppInterface.bSaveInDir = false;
              paramQQAppInterface.bPreConfig = false;
              paramQQAppInterface.strSavePath = ((ChatBackgroundManager)localObject).lU(paramString);
              return paramQQAppInterface;
            }
            if (paramLong == 27L)
            {
              paramString = paramString.substring("groupnickitem.".length(), paramString.length());
              paramQQAppInterface.bSaveInDir = true;
              paramQQAppInterface.bPreConfig = false;
              paramQQAppInterface.strSavePath = (aqpm.cuR + paramString);
              return paramQQAppInterface;
            }
            if (paramLong == 33L)
            {
              paramString = paramString.substring("profileitem.".length());
              paramQQAppInterface.bSaveInDir = false;
              paramQQAppInterface.bPreConfig = false;
              paramQQAppInterface.strSavePath = alco.mK(paramString);
              return paramQQAppInterface;
            }
          }
        }
        else
        {
          return null;
        }
        bool = false;
      }
    }
    
    public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
    {
      paramQQAppInterface = null;
      if (paramLong == 1000L) {
        return new File(VasQuickUpdateManager.this.app.getApplication().getFilesDir(), paramString).exists();
      }
      if (paramLong == 5L) {
        paramQQAppInterface = isFontExists(paramString);
      }
      while (paramQQAppInterface != null)
      {
        return paramQQAppInterface.booleanValue();
        if (paramLong == 2L)
        {
          paramQQAppInterface = isBubbleExist(paramString);
        }
        else if (paramLong == 22L)
        {
          paramQQAppInterface = isColorScreenExist(paramString);
        }
        else if (paramLong == 23L)
        {
          paramQQAppInterface = isFaceExist(paramString);
        }
        else if (paramLong == 4L)
        {
          paramQQAppInterface = isPendantExist(paramString);
        }
        else
        {
          if (paramLong == 20L) {
            return ((PraiseManager)VasQuickUpdateManager.this.app.getManager(209)).isFileExists(paramString);
          }
          if (paramLong == 1003L) {
            return new File(VasQuickUpdateManager.this.app.getApplication().getFilesDir(), paramString).exists();
          }
          if (paramLong == 16L) {
            return isRedPacketExist(paramString);
          }
          if (paramLong == 15L)
          {
            paramQQAppInterface = isProfileCardExist(paramString);
          }
          else if (paramLong == 21L)
          {
            paramQQAppInterface = isPokeExist(paramString);
          }
          else if (paramLong == 1004L)
          {
            paramQQAppInterface = isMaterialExist(paramString);
          }
          else if (paramLong == 9L)
          {
            paramQQAppInterface = isSignatureExist(paramString);
          }
          else
          {
            if (paramLong == 1999L) {
              return new File(VasQuickUpdateManager.QUICKUPDATE_TEST_DIR + paramString).exists();
            }
            if (paramLong == 100L)
            {
              paramQQAppInterface = isComicExist(paramString);
            }
            else if (paramLong == 25L)
            {
              paramQQAppInterface = isTroopEnterEffectExist(paramString);
            }
            else
            {
              if (paramLong == 8L)
              {
                paramQQAppInterface = paramString.substring("chatbg.".length(), paramString.length());
                return ((ChatBackgroundManager)VasQuickUpdateManager.this.app.getManager(63)).nn(paramQQAppInterface);
              }
              if (paramLong == 27L) {
                return new File(aqpm.pP(paramString.substring("groupnickitem.".length(), paramString.length()))).exists();
              }
              if (paramLong == 33L) {
                return new File(alco.mK(paramString.substring("profileitem.".length()))).exists();
              }
            }
          }
        }
      }
      return false;
    }
  }
  
  class DefaultVasExtensionObserver
    extends aqrd
  {
    DefaultVasExtensionObserver() {}
    
    public void onQuickUpdateGetUrl(boolean paramBoolean, Object paramObject)
    {
      if (paramBoolean) {
        paramObject = (VasQuickUpdateManager.GetUrlRsp)paramObject;
      }
      do
      {
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("cookie", paramObject.cookie);
          JSONArray localJSONArray = new JSONArray();
          int i = 0;
          while (i < paramObject.update_list.size())
          {
            VasQuickUpdateManager.UpdateInfo localUpdateInfo = (VasQuickUpdateManager.UpdateInfo)paramObject.update_list.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("bid", localUpdateInfo.bid);
            localJSONObject2.put("scid", localUpdateInfo.scid);
            localJSONObject2.put("dst_version", localUpdateInfo.dst_version);
            localJSONObject2.put("src_version", localUpdateInfo.src_version);
            localJSONObject2.put("delta_mode", localUpdateInfo.delta_mode);
            localJSONObject2.put("storage_mode", localUpdateInfo.storage_mode);
            localJSONObject2.put("compress_mode", localUpdateInfo.compress_mode);
            localJSONObject2.put("url", localUpdateInfo.url);
            localJSONObject2.put("filesize", localUpdateInfo.filesize);
            localJSONObject2.put("filecontent", localUpdateInfo.filecontent);
            localJSONObject2.put("code", localUpdateInfo.code);
            localJSONArray.put(localJSONObject2);
            i += 1;
          }
          localJSONObject1.put("update_list", localJSONArray);
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateGetUrl data = " + localJSONObject1.toString());
          }
          if (VasQuickUpdateManager.this.mEngine != null) {
            VasQuickUpdateManager.this.mEngine.onPbMsgRecv(0, aqrb.cwq, localJSONObject1.toString());
          }
          return;
        }
        catch (Exception localException)
        {
          do
          {
            QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl error: ", localException);
          } while (VasQuickUpdateManager.this.mEngine == null);
          str = "{\"cookie\":" + paramObject.cookie + "}";
          VasQuickUpdateManager.this.mEngine.onPbMsgRecv((int)paramObject.ret, aqrb.cwq, str);
          return;
        }
        paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
        QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl result = " + paramObject.ret + " cookie = " + paramObject.cookie);
      } while (VasQuickUpdateManager.this.mEngine == null);
      String str = "{\"cookie\":" + paramObject.cookie + "}";
      VasQuickUpdateManager.this.mEngine.onPbMsgRecv((int)paramObject.ret, aqrb.cwq, str);
    }
    
    public void onQuickUpdateSync(boolean paramBoolean, Object paramObject)
    {
      int j = 0;
      JSONObject localJSONObject1;
      if (paramBoolean)
      {
        paramObject = (VasQuickUpdateManager.SyncVCRRsp)paramObject;
        localJSONObject1 = new JSONObject();
      }
      do
      {
        try
        {
          localJSONObject1.put("cookie", paramObject.cookie);
          localJSONObject1.put("seq", paramObject.seq);
          localJSONObject1.put("polltime", paramObject.polltime);
          localJSONObject1.put("syncSwitch", paramObject.sync_switch);
          Object localObject1 = new JSONArray();
          int i = 0;
          Object localObject3;
          while (i < paramObject.vcr_list.size())
          {
            localObject2 = (VasQuickUpdateManager.VCR)paramObject.vcr_list.get(i);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("bid", ((VasQuickUpdateManager.VCR)localObject2).bid);
            ((JSONObject)localObject3).put("scid", ((VasQuickUpdateManager.VCR)localObject2).scid);
            ((JSONObject)localObject3).put("optype", ((VasQuickUpdateManager.VCR)localObject2).optype);
            ((JSONObject)localObject3).put("version", ((VasQuickUpdateManager.VCR)localObject2).version);
            ((JSONArray)localObject1).put(localObject3);
            i += 1;
          }
          localJSONObject1.put("vcr_list", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("plver", paramObject.preload.ver);
          Object localObject2 = new JSONArray();
          i = 0;
          JSONObject localJSONObject2;
          while (i < paramObject.preload.itemList.size())
          {
            localObject3 = (VasQuickUpdateManager.ItemVersion)paramObject.preload.itemList.get(i);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).bid);
            localJSONObject2.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).scid);
            localJSONObject2.put("flag", ((VasQuickUpdateManager.ItemVersion)localObject3).flag);
            ((JSONArray)localObject2).put(localJSONObject2);
            i += 1;
          }
          ((JSONObject)localObject1).put("item_list", localObject2);
          localJSONObject1.put("preload", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("rpver", paramObject.report.ver);
          localObject2 = new JSONArray();
          i = j;
          while (i < paramObject.report.itemList.size())
          {
            localObject3 = (VasQuickUpdateManager.ItemVersion)paramObject.report.itemList.get(i);
            localJSONObject2 = new JSONObject();
            localJSONObject2.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).bid);
            localJSONObject2.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).scid);
            ((JSONArray)localObject2).put(localJSONObject2);
            i += 1;
          }
          ((JSONObject)localObject1).put("item_list", localObject2);
          localJSONObject1.put("report", localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateSync data = " + localJSONObject1.toString());
          }
          if (VasQuickUpdateManager.this.mEngine != null) {
            VasQuickUpdateManager.this.mEngine.onPbMsgRecv(0, aqrb.cwo, localJSONObject1.toString());
          }
          return;
        }
        catch (Exception localException)
        {
          do
          {
            QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync error: ", localException);
          } while (VasQuickUpdateManager.this.mEngine == null);
          paramObject = "{\"cookie\":" + paramObject.cookie + "}";
          VasQuickUpdateManager.this.mEngine.onPbMsgRecv(-1, aqrb.cwo, paramObject);
          return;
        }
        paramObject = (VasQuickUpdateManager.QuickUpdateRsp)paramObject;
        QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync result = " + paramObject.ret + " cookie = " + paramObject.cookie);
      } while (VasQuickUpdateManager.this.mEngine == null);
      String str = "{\"cookie\":" + paramObject.cookie + "}";
      VasQuickUpdateManager.this.mEngine.onPbMsgRecv((int)paramObject.ret, aqrb.cwo, str);
    }
  }
  
  public static class GetUrlRsp
    extends VasQuickUpdateManager.QuickUpdateRsp
  {
    public List<VasQuickUpdateManager.UpdateInfo> update_list = new ArrayList();
  }
  
  public static class ItemVersion
  {
    public long bid;
    public long flag;
    public String scid;
    public String version;
  }
  
  public static abstract interface QueryItemVersionCallback
  {
    public abstract void onQueryItemVer(boolean paramBoolean, String paramString1, String paramString2);
  }
  
  public static class QuickUpdateRsp
  {
    public long cookie;
    public long ret;
  }
  
  public static class SCPreloadOrReport
  {
    public List<VasQuickUpdateManager.ItemVersion> itemList = new ArrayList();
    public long ver;
    
    public void setList(PBRepeatMessageField<SCUpdatePB.ItemVersion> paramPBRepeatMessageField)
    {
      int i = 0;
      while (i < paramPBRepeatMessageField.size())
      {
        VasQuickUpdateManager.ItemVersion localItemVersion = new VasQuickUpdateManager.ItemVersion();
        SCUpdatePB.ItemVersion localItemVersion1 = (SCUpdatePB.ItemVersion)paramPBRepeatMessageField.get(i);
        localItemVersion.bid = localItemVersion1.bid.get();
        localItemVersion.scid = localItemVersion1.scid.get();
        localItemVersion.version = localItemVersion1.version.get();
        localItemVersion.flag = localItemVersion1.flag.get();
        this.itemList.add(localItemVersion);
        i += 1;
      }
    }
  }
  
  public static class SyncVCRRsp
    extends VasQuickUpdateManager.QuickUpdateRsp
  {
    public int continue_flag;
    public int polltime;
    public VasQuickUpdateManager.SCPreloadOrReport preload = new VasQuickUpdateManager.SCPreloadOrReport();
    public VasQuickUpdateManager.SCPreloadOrReport report = new VasQuickUpdateManager.SCPreloadOrReport();
    public long seq;
    public int sync_switch;
    public List<VasQuickUpdateManager.VCR> vcr_list = new ArrayList();
  }
  
  static class TimeoutWrapper
    implements VasQuickUpdateManager.QueryItemVersionCallback, Runnable
  {
    private aqqm callback;
    private AtomicBoolean isDone = new AtomicBoolean(false);
    private WeakReference<aqqm> weakReference;
    
    private TimeoutWrapper(aqqm paramaqqm, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.weakReference = new WeakReference(paramaqqm);
        return;
      }
      this.callback = paramaqqm;
    }
    
    private void onResult(int paramInt, String paramString1, String paramString2)
    {
      if (this.isDone.compareAndSet(false, true))
      {
        if (this.callback == null) {
          break label32;
        }
        this.callback.I(paramInt, paramString1, paramString2);
      }
      label32:
      aqqm localaqqm;
      do
      {
        return;
        localaqqm = (aqqm)this.weakReference.get();
      } while (localaqqm == null);
      localaqqm.I(paramInt, paramString1, paramString2);
    }
    
    public void onQueryItemVer(boolean paramBoolean, String paramString1, String paramString2)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
      int i = 0;
      if (!paramBoolean) {
        i = 1;
      }
      onResult(i, paramString1, paramString2);
    }
    
    public void run()
    {
      VasQuickUpdateEngine.getInstance().cancelQuery(this);
      onResult(2, "", "");
    }
  }
  
  public static class UpdateInfo
  {
    public long bid;
    public int code;
    public int compress_mode;
    public int delta_mode;
    public String dst_version;
    public String filecontent;
    public long filesize;
    public String scid;
    public String src_version;
    public int storage_mode;
    public String url;
    
    private String checkTempPath(int paramInt, VasQuickUpdateEngine.TagItemInfo paramTagItemInfo, String paramString)
    {
      String str = paramString;
      if (paramTagItemInfo != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramTagItemInfo.strSavePath)) {
          if (!paramTagItemInfo.bSaveInDir) {
            break label106;
          }
        }
      }
      label106:
      int i;
      for (paramTagItemInfo = paramTagItemInfo.strSavePath;; paramTagItemInfo = paramTagItemInfo.strSavePath.substring(0, i))
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramTagItemInfo))
        {
          paramString = new File(paramTagItemInfo);
          if (!paramString.exists()) {
            paramString.mkdirs();
          }
          ayzc.adK(paramTagItemInfo);
          str = paramTagItemInfo + "/tempFile_" + System.currentTimeMillis() + "_" + paramInt;
        }
        return str;
        i = paramTagItemInfo.strSavePath.lastIndexOf("/");
      }
    }
    
    /* Error */
    private void initTempPath(int paramInt, byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aconst_null
      //   4: astore 5
      //   6: aload 4
      //   8: astore_3
      //   9: aload_0
      //   10: iload_1
      //   11: invokestatic 109	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getInstance	()Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine;
      //   14: aload_0
      //   15: getfield 111	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:bid	J
      //   18: aload_0
      //   19: getfield 113	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:scid	Ljava/lang/String;
      //   22: invokevirtual 117	com/tencent/mobileqq/vas/VasQuickUpdateEngine:getItemInfo	(JLjava/lang/String;)Lcom/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo;
      //   25: new 62	java/lang/StringBuilder
      //   28: dup
      //   29: invokespecial 63	java/lang/StringBuilder:<init>	()V
      //   32: invokestatic 123	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
      //   35: invokevirtual 127	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
      //   38: invokevirtual 130	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   41: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: ldc 69
      //   46: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: invokestatic 75	java/lang/System:currentTimeMillis	()J
      //   52: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   55: ldc 80
      //   57: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   60: iload_1
      //   61: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   64: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   67: invokespecial 132	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:checkTempPath	(ILcom/tencent/mobileqq/vas/VasQuickUpdateEngine$TagItemInfo;Ljava/lang/String;)Ljava/lang/String;
      //   70: astore 6
      //   72: aload 4
      //   74: astore_3
      //   75: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   78: ifeq +32 -> 110
      //   81: aload 4
      //   83: astore_3
      //   84: ldc 139
      //   86: iconst_2
      //   87: new 62	java/lang/StringBuilder
      //   90: dup
      //   91: invokespecial 63	java/lang/StringBuilder:<init>	()V
      //   94: ldc 141
      //   96: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: aload 6
      //   101: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   107: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   110: aload 4
      //   112: astore_3
      //   113: aload 6
      //   115: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   118: ifne +69 -> 187
      //   121: aload 4
      //   123: astore_3
      //   124: new 147	java/io/DataOutputStream
      //   127: dup
      //   128: new 149	java/io/BufferedOutputStream
      //   131: dup
      //   132: new 151	java/io/FileOutputStream
      //   135: dup
      //   136: new 45	java/io/File
      //   139: dup
      //   140: aload 6
      //   142: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
      //   145: invokespecial 154	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   148: invokespecial 157	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   151: invokespecial 158	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   154: astore 4
      //   156: aload 4
      //   158: aload_2
      //   159: iconst_0
      //   160: aload_2
      //   161: arraylength
      //   162: invokevirtual 162	java/io/DataOutputStream:write	([BII)V
      //   165: aload 4
      //   167: invokevirtual 165	java/io/DataOutputStream:flush	()V
      //   170: aload_0
      //   171: aload 6
      //   173: putfield 167	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
      //   176: aload 4
      //   178: ifnull +8 -> 186
      //   181: aload 4
      //   183: invokevirtual 170	java/io/DataOutputStream:close	()V
      //   186: return
      //   187: aload 4
      //   189: astore_3
      //   190: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   193: ifeq +14 -> 207
      //   196: aload 4
      //   198: astore_3
      //   199: ldc 139
      //   201: iconst_2
      //   202: ldc 172
      //   204: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   207: aload 4
      //   209: astore_3
      //   210: aload_0
      //   211: ldc 174
      //   213: putfield 167	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
      //   216: aconst_null
      //   217: astore 4
      //   219: goto -43 -> 176
      //   222: astore_2
      //   223: ldc 139
      //   225: iconst_1
      //   226: ldc 176
      //   228: aload_2
      //   229: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   232: return
      //   233: astore 4
      //   235: aload 5
      //   237: astore_2
      //   238: aload_2
      //   239: astore_3
      //   240: ldc 139
      //   242: iconst_1
      //   243: ldc 182
      //   245: aload 4
      //   247: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   250: aload_2
      //   251: astore_3
      //   252: aload_0
      //   253: ldc 174
      //   255: putfield 167	com/tencent/mobileqq/vas/VasQuickUpdateManager$UpdateInfo:filecontent	Ljava/lang/String;
      //   258: aload_2
      //   259: ifnull -73 -> 186
      //   262: aload_2
      //   263: invokevirtual 170	java/io/DataOutputStream:close	()V
      //   266: return
      //   267: astore_2
      //   268: ldc 139
      //   270: iconst_1
      //   271: ldc 176
      //   273: aload_2
      //   274: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   277: return
      //   278: astore_2
      //   279: aload_3
      //   280: ifnull +7 -> 287
      //   283: aload_3
      //   284: invokevirtual 170	java/io/DataOutputStream:close	()V
      //   287: aload_2
      //   288: athrow
      //   289: astore_3
      //   290: ldc 139
      //   292: iconst_1
      //   293: ldc 176
      //   295: aload_3
      //   296: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   299: goto -12 -> 287
      //   302: astore_2
      //   303: aload 4
      //   305: astore_3
      //   306: goto -27 -> 279
      //   309: astore_3
      //   310: aload 4
      //   312: astore_2
      //   313: aload_3
      //   314: astore 4
      //   316: goto -78 -> 238
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	319	0	this	UpdateInfo
      //   0	319	1	paramInt	int
      //   0	319	2	paramArrayOfByte	byte[]
      //   8	276	3	localObject1	Object
      //   289	7	3	localException1	Exception
      //   305	1	3	localException2	Exception
      //   309	5	3	localException3	Exception
      //   1	217	4	localDataOutputStream	java.io.DataOutputStream
      //   233	78	4	localException4	Exception
      //   314	1	4	localObject2	Object
      //   4	232	5	localObject3	Object
      //   70	102	6	str	String
      // Exception table:
      //   from	to	target	type
      //   181	186	222	java/lang/Exception
      //   9	72	233	java/lang/Exception
      //   75	81	233	java/lang/Exception
      //   84	110	233	java/lang/Exception
      //   113	121	233	java/lang/Exception
      //   124	156	233	java/lang/Exception
      //   190	196	233	java/lang/Exception
      //   199	207	233	java/lang/Exception
      //   210	216	233	java/lang/Exception
      //   262	266	267	java/lang/Exception
      //   9	72	278	finally
      //   75	81	278	finally
      //   84	110	278	finally
      //   113	121	278	finally
      //   124	156	278	finally
      //   190	196	278	finally
      //   199	207	278	finally
      //   210	216	278	finally
      //   240	250	278	finally
      //   252	258	278	finally
      //   283	287	289	java/lang/Exception
      //   156	176	302	finally
      //   156	176	309	java/lang/Exception
    }
    
    public void set(SCUpdatePB.UpdateInfo paramUpdateInfo, int paramInt)
    {
      this.bid = paramUpdateInfo.bid.get();
      this.scid = paramUpdateInfo.scid.get();
      this.dst_version = paramUpdateInfo.dst_version.get();
      this.src_version = paramUpdateInfo.src_version.get();
      this.delta_mode = paramUpdateInfo.delta_mode.get();
      this.storage_mode = paramUpdateInfo.storage_mode.get();
      this.compress_mode = paramUpdateInfo.compress_mode.get();
      this.url = paramUpdateInfo.url.get();
      this.filesize = paramUpdateInfo.filesize.get();
      byte[] arrayOfByte = paramUpdateInfo.filecontent.get().toByteArray();
      if (arrayOfByte.length > 0) {
        initTempPath(paramInt, arrayOfByte);
      }
      this.code = paramUpdateInfo.code.get();
    }
  }
  
  public static class VCR
  {
    public long bid;
    public int optype;
    public String scid;
    public long seq;
    public String version;
    
    public void set(SCUpdatePB.VCR paramVCR)
    {
      this.seq = paramVCR.seq.get();
      this.bid = paramVCR.bid.get();
      this.scid = paramVCR.scid.get();
      this.optype = paramVCR.optype.get();
      this.version = paramVCR.version.get();
    }
  }
  
  public static class WeakCallbacker
    extends VasQuickUpdateManager.CallBacker
  {
    private WeakReference<VasQuickUpdateManager.CallBacker> weakReference;
    
    public WeakCallbacker(VasQuickUpdateManager.CallBacker paramCallBacker)
    {
      this.weakReference = new WeakReference(paramCallBacker);
    }
    
    public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
    {
      VasQuickUpdateManager.CallBacker localCallBacker = (VasQuickUpdateManager.CallBacker)this.weakReference.get();
      if (localCallBacker != null)
      {
        localCallBacker.callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramVasQuickUpdateManager);
        return;
      }
      paramVasQuickUpdateManager.removeCallBacker(this);
    }
    
    public boolean isWrapOf(VasQuickUpdateManager.CallBacker paramCallBacker)
    {
      return this.weakReference.get() == paramCallBacker;
    }
    
    public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
    {
      VasQuickUpdateManager.CallBacker localCallBacker = (VasQuickUpdateManager.CallBacker)this.weakReference.get();
      if (localCallBacker != null) {
        localCallBacker.onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager
 * JD-Core Version:    0.7.0.1
 */