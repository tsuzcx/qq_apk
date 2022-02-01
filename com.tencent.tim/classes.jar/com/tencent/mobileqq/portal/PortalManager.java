package com.tencent.mobileqq.portal;

import acfd;
import acfp;
import akpr;
import akrf;
import akzx;
import akzy;
import akzz;
import alaa;
import alab;
import alan;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import anot;
import anpc;
import aoll;
import aolm;
import aolm.a;
import aolm.b;
import aomg;
import aomh;
import aqgv;
import aqgz;
import aqhq;
import aqnm;
import aure;
import aurr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.Integer;>;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0x78.submsgtype0x78.MsgBody;

public class PortalManager
  implements SoundPool.OnLoadCompleteListener, Handler.Callback, aolm.b, Manager, BusinessObserver
{
  private static Comparator<TimerConfig> P;
  private static TimerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig;
  static long afJ = 2500L;
  static long afK = 180000L;
  static long afL = 180000L;
  public static long afO;
  public static long afP;
  private static long afQ;
  protected static aolm.a b;
  public static final String bUW;
  public static boolean cvz;
  static int dqL = 1;
  static final String[] gg = { "2016-12-13", "2016-12-14", "2017-1-20", "2017-1-27", "2017-1-28" };
  private static final int[] mi;
  private static final boolean[] u;
  static SimpleDateFormat y;
  private acfd jdField_a_of_type_Acfd = new alaa(this);
  private BannerConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalConfig jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  protected volatile RedPacketConfig a;
  b jdField_a_of_type_ComTencentMobileqqPortalPortalManager$b;
  private c jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c;
  public long afM;
  volatile long afN = 0L;
  private long afR;
  private akpr jdField_b_of_type_Akpr;
  private BannerConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
  private PortalConfig jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
  private SoundPool jdField_c_of_type_AndroidMediaSoundPool;
  private aolm jdField_c_of_type_Aolm;
  Set<String> cf = Collections.synchronizedSet(new HashSet());
  private boolean cvA;
  private boolean cvB;
  private int doM;
  private int doN;
  private int dqM;
  int dqN = 4;
  public final ConcurrentHashMap<String, a> gw = new ConcurrentHashMap(1000);
  private boolean isDestroyed;
  SparseArrayCompat<ArrayList<Long>> l = new SparseArrayCompat(1);
  SparseArrayCompat<ArrayList<Long>> m = new SparseArrayCompat(100);
  private QQAppInterface mApp;
  private Context mCtx;
  private long mLastRequestTime;
  private Handler mSubHandler;
  private Handler mUiHandler;
  private final int[] mh = { 0, 0, 0, 0, 0 };
  
  static
  {
    bUW = File.separator + "redPacketRes/";
    jdField_b_of_type_Aolm$a = new akzy();
    P = new akzz();
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig = new TimerConfig(null);
    u = new boolean[] { 0, 0, 0, 0, 0 };
    mi = new int[0];
  }
  
  public PortalManager(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mCtx = BaseApplicationImpl.sApplication;
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    this.mSubHandler.sendEmptyMessageDelayed(1, 5000L);
    this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$b = new b(null);
    try
    {
      this.mApp.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$b, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.tim.msg.permission.pushnotify", null);
      this.mApp.registObserver(this);
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("PortalManager", 1, "", paramQQAppInterface);
      }
    }
  }
  
  private int Hp()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord;
  }
  
  private void T(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PortalManager", 2, "downLoad, " + paramInt + ", " + paramString1 + ", " + paramString2);
    }
    if (this.jdField_c_of_type_Aolm == null) {
      this.jdField_c_of_type_Aolm = this.mApp.getNetEngine(0);
    }
    String str = this.mApp.getApplication().getFilesDir() + bUW;
    aoll localaoll = new aoll();
    localaoll.f = this;
    localaoll.bZ = paramString1;
    localaoll.mHttpMethod = 0;
    localaoll.atY = (str + paramString2);
    localaoll.dPo = 2;
    localaoll.bw(new String[] { String.valueOf(paramInt), paramString2 });
    localaoll.a = jdField_b_of_type_Aolm$a;
    this.jdField_c_of_type_Aolm.a(localaoll);
  }
  
  private void W(int paramInt1, String paramString, int paramInt2)
  {
    if ((!QLog.isColorLevel()) || (paramInt1 == 1009)) {}
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        localObject = "get head returned , key = " + ((JSONObject)localObject).getString("key");
        QLog.d("PortalManager", 2, "sendBroadcastRespData, " + paramInt1 + ", " + paramInt2 + ", " + (String)localObject);
        localObject = new Intent("com.tencent.portal.resp.action");
        ((Intent)localObject).putExtra("portal_type_key", paramInt1);
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("bc_data", alab.D(paramString));
        ((Intent)localObject).putExtras(localBundle);
        if (paramInt2 > 0) {
          ((Intent)localObject).putExtra("bc_seq", paramInt2);
        }
        this.mApp.getApp().sendBroadcast((Intent)localObject, "com.tencent.tim.msg.permission.pushnotify");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str = paramString;
        continue;
      }
      String str = paramString;
    }
  }
  
  private static Pair<Integer, Bitmap> a(String paramString, int paramInt1, akpr paramakpr, int paramInt2)
  {
    localObject3 = null;
    Object localObject1 = null;
    j = 0;
    if ((TextUtils.isEmpty(paramString)) && (paramInt1 < 0)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject4 = new BitmapFactory.Options();
        if (paramakpr == null) {
          continue;
        }
        ((BitmapFactory.Options)localObject4).inPurgeable = true;
        ((BitmapFactory.Options)localObject4).inInputShareable = true;
        if (!paramakpr.ctX) {
          continue;
        }
        ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (!paramakpr.ctV) {
          continue;
        }
        ((BitmapFactory.Options)localObject4).inSampleSize = 2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if ((paramakpr == null) || (paramakpr.ctV)) {
          continue;
        }
        paramakpr.ctV = true;
        if (paramakpr.ctW) {
          continue;
        }
        localObject2 = a(paramString, paramInt1, paramakpr, paramInt2);
        paramakpr = (Bitmap)((Pair)localObject2).second;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PortalManager", 2, "decodeBitmap OOM|path:" + paramString);
        paramInt2 = 0;
        i = 1;
        continue;
        ((BitmapFactory.Options)localObject4).inSampleSize = 1;
        continue;
      }
      catch (Exception paramakpr)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PortalManager", 2, "decodeBitmap Exception:" + paramakpr.toString() + ",filePath:" + paramString);
        localObject3 = null;
        paramInt2 = 1;
        int i = 0;
        paramakpr = (akpr)localObject2;
        localObject2 = localObject3;
        continue;
        ((BitmapFactory.Options)localObject4).inPurgeable = true;
        ((BitmapFactory.Options)localObject4).inInputShareable = true;
        ((BitmapFactory.Options)localObject4).inSampleSize = 1;
        ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.RGB_565;
        ((BitmapFactory.Options)localObject4).inDither = true;
        continue;
        if (paramInt2 != 2) {
          continue;
        }
        Object localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), paramInt1, (BitmapFactory.Options)localObject4);
        paramakpr = (akpr)localObject4;
        continue;
        paramInt1 = ((Integer)((Pair)localObject2).first).intValue();
        continue;
        if (i == 0) {
          continue;
        }
        paramInt1 = 2;
        continue;
        paramInt1 = j;
        if (paramInt2 == 0) {
          continue;
        }
        paramInt1 = 3;
        continue;
        l1 = paramakpr.getRowBytes() * paramakpr.getHeight() / 1024;
        continue;
        continue;
      }
      if (paramInt2 != 1) {
        continue;
      }
      localObject4 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject4);
      paramakpr = (akpr)localObject4;
      localObject1 = null;
      paramInt2 = 0;
      i = 0;
      if (localObject1 == null) {
        continue;
      }
      if (((Integer)localObject1.first).intValue() != 0) {
        continue;
      }
      paramInt1 = 1;
      if ((paramakpr == null) && (i == 0) && (paramInt2 == 0)) {}
      try
      {
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "decodeBitmap| file.delete()");
        }
      }
      catch (Exception paramString)
      {
        long l1;
        continue;
        Object localObject2 = null;
        paramakpr = localObject3;
        continue;
        paramakpr = null;
      }
      paramString = new Pair(Integer.valueOf(paramInt1), paramakpr);
      if (QLog.isColorLevel())
      {
        if (paramakpr != null) {
          continue;
        }
        l1 = 0L;
        QLog.d("PortalManager", 2, "decodeBitmap|size:" + l1 + "KB,errCode:" + paramInt1);
      }
      return paramString;
      ((BitmapFactory.Options)localObject4).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject4).inDither = true;
    }
  }
  
  public static Pair<String, String> a(XmlPullParser paramXmlPullParser, String paramString)
    throws Exception
  {
    if (paramXmlPullParser == null) {
      return new Pair("", "");
    }
    int i = paramXmlPullParser.next();
    Object localObject2 = "";
    Object localObject1 = "";
    String str;
    if (i != 1)
    {
      str = paramXmlPullParser.getName();
      if ((i != 3) || (!str.equalsIgnoreCase(paramString))) {}
    }
    else
    {
      return new Pair(localObject1, localObject2);
    }
    Object localObject3 = localObject2;
    Object localObject4 = localObject1;
    if (i == 2)
    {
      if (!str.equalsIgnoreCase("url")) {
        break label124;
      }
      localObject4 = paramXmlPullParser.nextText();
      localObject3 = localObject2;
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      localObject2 = localObject3;
      localObject1 = localObject4;
      break;
      label124:
      localObject3 = localObject2;
      localObject4 = localObject1;
      if (str.equalsIgnoreCase("md5"))
      {
        localObject3 = paramXmlPullParser.nextText();
        localObject4 = localObject1;
      }
    }
  }
  
  public static RedPacketConfig a(String paramString, int paramInt1, int paramInt2, ArrayList<Integer> paramArrayList)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    RedPacketConfig localRedPacketConfig = new RedPacketConfig();
    localRedPacketConfig.version = paramInt1;
    localRedPacketConfig.taskId = paramInt2;
    Object localObject1 = null;
    Object localObject4;
    label303:
    label319:
    label321:
    Object localObject3;
    label661:
    label823:
    PortalConfig localPortalConfig;
    String str;
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        paramInt1 = localXmlPullParser.getEventType();
        if (paramInt1 == 1) {
          break label3220;
        }
        Object localObject2 = localObject1;
        if (paramInt1 == 2)
        {
          localObject4 = localXmlPullParser.getName();
          if (!((String)localObject4).equalsIgnoreCase("Common")) {
            break label661;
          }
          paramInt1 = localXmlPullParser.next();
          localObject2 = localObject1;
          if (paramInt1 != 1)
          {
            localObject4 = localXmlPullParser.getName();
            if ((paramInt1 != 3) || (!((String)localObject4).equalsIgnoreCase("Common"))) {
              continue;
            }
            localObject2 = localObject1;
          }
        }
        paramInt1 = localXmlPullParser.next();
        localObject1 = localObject2;
        continue;
        localObject2 = localObject1;
        if (paramInt1 == 2)
        {
          if (((String)localObject4).equalsIgnoreCase("GrabReqInterval"))
          {
            localRedPacketConfig.grebInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
            localObject2 = localObject1;
          }
        }
        else
        {
          paramInt1 = localXmlPullParser.next();
          localObject1 = localObject2;
          continue;
        }
        if (!((String)localObject4).equalsIgnoreCase("ReportActiveInterval")) {
          break label321;
        }
        localRedPacketConfig.reportActiveInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
        localObject2 = localObject1;
        continue;
        if (!QLog.isColorLevel()) {
          break label319;
        }
      }
      catch (Exception localException)
      {
        localObject1 = null;
        paramArrayList = (ArrayList<Integer>)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("PortalManager", 2, paramString, localException);
          paramArrayList = (ArrayList<Integer>)localObject1;
        }
      }
      localObject1 = new StringBuilder().append("parseConfig, ");
      if (paramArrayList == null) {
        break label3630;
      }
      paramString = paramArrayList.toString();
      QLog.d("PortalManager", 2, paramString);
      return paramArrayList;
      if (((String)localObject4).equalsIgnoreCase("ReportNormalInterval"))
      {
        localRedPacketConfig.reportNormalInterval = Long.valueOf(localXmlPullParser.nextText()).longValue();
        localObject3 = localObject1;
      }
      else if (((String)localObject4).equalsIgnoreCase("ShareTimes"))
      {
        localRedPacketConfig.shareBaseLine = Integer.valueOf(localXmlPullParser.nextText()).intValue();
        localObject3 = localObject1;
      }
      else if (((String)localObject4).equalsIgnoreCase("ComboNumber"))
      {
        if (localRedPacketConfig.comboNumberConfigs == null) {
          localRedPacketConfig.comboNumberConfigs = new ArrayList();
        }
        localObject3 = new ComboNumber();
        localRedPacketConfig.comboNumberConfigs.add(localObject3);
      }
      else if (((String)localObject4).equalsIgnoreCase("Number"))
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          ((ComboNumber)localObject1).number = Integer.valueOf(localXmlPullParser.nextText()).intValue();
          localObject3 = localObject1;
        }
      }
      else if (((String)localObject4).equalsIgnoreCase("NumberImage"))
      {
        localObject3 = a(localXmlPullParser, (String)localObject4);
        ((ComboNumber)localObject1).numberImageUrl = ((String)((Pair)localObject3).first);
        ((ComboNumber)localObject1).numberImageMD5 = ((String)((Pair)localObject3).second);
        localObject3 = localObject1;
      }
      else
      {
        localObject3 = localObject1;
        if (((String)localObject4).equalsIgnoreCase("FlowerImage"))
        {
          localObject4 = a(localXmlPullParser, (String)localObject4);
          if (TextUtils.isEmpty(((ComboNumber)localObject1).flowerImageUrl))
          {
            ((ComboNumber)localObject1).flowerImageUrl = ((String)((Pair)localObject4).first);
            ((ComboNumber)localObject1).flowerImageMD5 = ((String)((Pair)localObject4).second);
            localObject3 = localObject1;
          }
          else
          {
            localObject3 = localObject1;
            if (TextUtils.isEmpty(((ComboNumber)localObject1).flowerImage2Url))
            {
              ((ComboNumber)localObject1).flowerImage2Url = ((String)((Pair)localObject4).first);
              ((ComboNumber)localObject1).flowerImage2MD5 = ((String)((Pair)localObject4).second);
              localObject3 = localObject1;
              continue;
              if (((String)localObject4).equalsIgnoreCase("ConfigId"))
              {
                localRedPacketConfig.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                localObject3 = localObject1;
              }
              else if (((String)localObject4).equalsIgnoreCase("BBanner"))
              {
                localObject4 = new BannerConfig(null);
                paramInt1 = localXmlPullParser.next();
                localObject3 = localObject1;
                if (paramInt1 != 1)
                {
                  localObject3 = localXmlPullParser.getName();
                  if ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase("BBanner")))
                  {
                    localRedPacketConfig.bannerConfigs.add(localObject4);
                    localObject3 = localObject1;
                  }
                  else
                  {
                    if (paramInt1 == 2)
                    {
                      if (!((String)localObject3).equalsIgnoreCase("Id")) {
                        break label823;
                      }
                      ((BannerConfig)localObject4).id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                    }
                    for (;;)
                    {
                      paramInt1 = localXmlPullParser.next();
                      break;
                      if (((String)localObject3).equalsIgnoreCase("Begin"))
                      {
                        ((BannerConfig)localObject4).uiBegin = ah(localXmlPullParser.nextText());
                      }
                      else if (((String)localObject3).equalsIgnoreCase("End"))
                      {
                        ((BannerConfig)localObject4).uiEnd = ah(localXmlPullParser.nextText());
                      }
                      else if (((String)localObject3).equalsIgnoreCase("Image"))
                      {
                        localObject3 = a(localXmlPullParser, (String)localObject3);
                        ((BannerConfig)localObject4).bannerImg = ((String)((Pair)localObject3).first);
                        ((BannerConfig)localObject4).bannarMd5 = ((String)((Pair)localObject3).second);
                      }
                      else if (((String)localObject3).equalsIgnoreCase("JumpH5"))
                      {
                        ((BannerConfig)localObject4).jumpUrl = localXmlPullParser.nextText();
                      }
                    }
                  }
                }
              }
              else
              {
                localObject3 = localObject1;
                if (((String)localObject4).equalsIgnoreCase("Activity"))
                {
                  localPortalConfig = new PortalConfig();
                  paramInt1 = localXmlPullParser.next();
                  localObject3 = localObject1;
                  if (paramInt1 != 1)
                  {
                    str = localXmlPullParser.getName();
                    if ((paramInt1 != 3) || (!str.equalsIgnoreCase("Activity"))) {
                      break;
                    }
                    if (localPortalConfig.realEnd >= localPortalConfig.realBegin)
                    {
                      localRedPacketConfig.portalConfigs.add(localPortalConfig);
                      localObject3 = localObject1;
                    }
                    else
                    {
                      localObject3 = localObject1;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("PortalManager", 2, "parseConfig" + localPortalConfig.realBegin + ", " + localPortalConfig.realEnd);
                        localObject3 = localObject1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (paramInt1 == 2)
    {
      if (!str.equalsIgnoreCase("Id")) {
        break label1161;
      }
      localPortalConfig.id = Integer.valueOf(localXmlPullParser.nextText()).intValue();
    }
    label1161:
    label1639:
    label2045:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            paramInt1 = localXmlPullParser.next();
            break;
            if (str.equalsIgnoreCase("Type"))
            {
              localPortalConfig.type = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            }
            else if (str.equalsIgnoreCase("Mode"))
            {
              localPortalConfig.mode = Integer.valueOf(localXmlPullParser.nextText()).intValue();
            }
            else
            {
              long l1;
              if (str.equalsIgnoreCase("BeginTime"))
              {
                l1 = ah(localXmlPullParser.nextText());
                localPortalConfig.realBegin = l1;
                localPortalConfig.uiBegin = l1;
              }
              else if (str.equalsIgnoreCase("EndTime"))
              {
                l1 = ah(localXmlPullParser.nextText());
                localPortalConfig.realEnd = l1;
                localPortalConfig.uiEnd = l1;
              }
              else if (str.equalsIgnoreCase("BackGroundImage"))
              {
                localObject3 = a(localXmlPullParser, str);
                localPortalConfig.bgImg = ((String)((Pair)localObject3).first);
                localPortalConfig.bgMd5 = ((String)((Pair)localObject3).second);
              }
              else if (str.equalsIgnoreCase("activityTime"))
              {
                localPortalConfig.rightMsg = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("scrollTime"))
              {
                localPortalConfig.scrollTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
              }
              else if (str.equalsIgnoreCase("Timer"))
              {
                localPortalConfig.countTime = (Integer.parseInt(localXmlPullParser.nextText()) * 1000);
              }
              else if (str.equalsIgnoreCase("GrabWording"))
              {
                localPortalConfig.grabMsg = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("NoRPWording"))
              {
                localPortalConfig.emptyMsg = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("LeftCloudImage"))
              {
                localObject3 = a(localXmlPullParser, str);
                localPortalConfig.leftCloudImageUrl = ((String)((Pair)localObject3).first);
                localPortalConfig.leftCloudImageMD5 = ((String)((Pair)localObject3).second);
              }
              else if (str.equalsIgnoreCase("RightCloudImage"))
              {
                localObject3 = a(localXmlPullParser, str);
                localPortalConfig.rightCloudImageURL = ((String)((Pair)localObject3).first);
                localPortalConfig.rightCloudImageMD5 = ((String)((Pair)localObject3).second);
              }
              else if (str.equalsIgnoreCase("Logo"))
              {
                localObject3 = new LogoConfig();
                localPortalConfig.logoList.add(localObject3);
                paramInt1 = localXmlPullParser.next();
                if (paramInt1 != 1)
                {
                  localObject4 = localXmlPullParser.getName();
                  if ((paramInt1 == 3) && (((String)localObject4).equalsIgnoreCase(str))) {
                    continue;
                  }
                  if (paramInt1 == 2)
                  {
                    if (!((String)localObject4).equalsIgnoreCase("LogoImage")) {
                      break label1730;
                    }
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((LogoConfig)localObject3).logoImageUrl = ((String)((Pair)localObject4).first);
                    ((LogoConfig)localObject3).logoImageMD5 = ((String)((Pair)localObject4).second);
                  }
                }
                for (;;)
                {
                  paramInt1 = localXmlPullParser.next();
                  break label1639;
                  break;
                  if (((String)localObject4).equalsIgnoreCase("logoId"))
                  {
                    ((LogoConfig)localObject3).logoId = Integer.parseInt(localXmlPullParser.nextText());
                  }
                  else if (((String)localObject4).equalsIgnoreCase("NameImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((LogoConfig)localObject3).nameUrl = ((String)((Pair)localObject4).first);
                    ((LogoConfig)localObject3).nameMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("GreetImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((LogoConfig)localObject3).greetImageUrl = ((String)((Pair)localObject4).first);
                    ((LogoConfig)localObject3).greetImageMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("padantImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((LogoConfig)localObject3).padantImageUrl = ((String)((Pair)localObject4).first);
                    ((LogoConfig)localObject3).padantImageMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("relationCompanyLogo"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((LogoConfig)localObject3).relationCompanyLogoUrl = ((String)((Pair)localObject4).first);
                    ((LogoConfig)localObject3).relationCompanyLogoMD5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("relationCompanyNameImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((LogoConfig)localObject3).relationCompanyNameUrl = ((String)((Pair)localObject4).first);
                    ((LogoConfig)localObject3).relationCompanyNameMD5 = ((String)((Pair)localObject4).second);
                  }
                }
              }
              else if (str.equalsIgnoreCase("Award"))
              {
                localObject3 = new AwardConfig();
                localPortalConfig.awardConfigList.add(localObject3);
                paramInt1 = localXmlPullParser.next();
                if (paramInt1 != 1)
                {
                  localObject4 = localXmlPullParser.getName();
                  if ((paramInt1 == 3) && (((String)localObject4).equalsIgnoreCase(str))) {
                    continue;
                  }
                  if (paramInt1 == 2)
                  {
                    if (!((String)localObject4).equalsIgnoreCase("AwardId")) {
                      break label2119;
                    }
                    ((AwardConfig)localObject3).awardId = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  }
                }
                for (;;)
                {
                  paramInt1 = localXmlPullParser.next();
                  break label2045;
                  break;
                  if (((String)localObject4).equalsIgnoreCase("logoId"))
                  {
                    ((AwardConfig)localObject3).logoId = Integer.parseInt(localXmlPullParser.nextText());
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogoType"))
                  {
                    ((AwardConfig)localObject3).awardType = Integer.valueOf(localXmlPullParser.nextText()).intValue();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogo1Image"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((AwardConfig)localObject3).awardImg = ((String)((Pair)localObject4).first);
                    ((AwardConfig)localObject3).awardMd5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogo2Image"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((AwardConfig)localObject3).starImg = ((String)((Pair)localObject4).first);
                    ((AwardConfig)localObject3).starMd5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardLogoBGImage"))
                  {
                    localObject4 = a(localXmlPullParser, (String)localObject4);
                    ((AwardConfig)localObject3).ctfBgImg = ((String)((Pair)localObject4).first);
                    ((AwardConfig)localObject3).ctfBgMd5 = ((String)((Pair)localObject4).second);
                  }
                  else if (((String)localObject4).equalsIgnoreCase("Grettings"))
                  {
                    ((AwardConfig)localObject3).awardMsg = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AwardName"))
                  {
                    ((AwardConfig)localObject3).awardTitle = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("AddWording"))
                  {
                    ((AwardConfig)localObject3).addMsg = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("PublicId"))
                  {
                    ((AwardConfig)localObject3).publicId = localXmlPullParser.nextText();
                  }
                  else if (((String)localObject4).equalsIgnoreCase("showPublic"))
                  {
                    ((AwardConfig)localObject3).showPublic = Integer.parseInt(localXmlPullParser.nextText());
                  }
                  else if (((String)localObject4).equalsIgnoreCase("PublicWording"))
                  {
                    ((AwardConfig)localObject3).publicWording = localXmlPullParser.nextText();
                  }
                }
              }
              else if (str.equalsIgnoreCase("NextActTime"))
              {
                localPortalConfig.nextActTime = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("ActEndWording"))
              {
                localPortalConfig.actEndWording = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("TipWording"))
              {
                localPortalConfig.countDownTips = localXmlPullParser.nextText();
              }
              else if (str.equalsIgnoreCase("StarLuckytype"))
              {
                localPortalConfig.starLucytype = Integer.parseInt(localXmlPullParser.nextText());
              }
              else
              {
                if (!str.equalsIgnoreCase("StarNoLuckytype")) {
                  break label2622;
                }
                localPortalConfig.starNoLucyType = Integer.parseInt(localXmlPullParser.nextText());
              }
            }
          }
          if (!str.equalsIgnoreCase("sharePhoto")) {
            break label2969;
          }
          paramInt1 = localXmlPullParser.next();
          if (paramInt1 == 1) {
            break label2728;
          }
          localObject3 = localXmlPullParser.getName();
        } while ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase(str)));
        if (paramInt1 == 2)
        {
          if (!((String)localObject3).equalsIgnoreCase("summary")) {
            break label2730;
          }
          localObject4 = localXmlPullParser.nextText();
          localObject3 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject3 = "";
          }
          localPortalConfig.summaryForStar = ((String)localObject3);
        }
        for (;;)
        {
          paramInt1 = localXmlPullParser.next();
          break label2641;
          break;
          if (((String)localObject3).equalsIgnoreCase("structMsgTitle"))
          {
            localObject4 = localXmlPullParser.nextText();
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject3 = "";
            }
            localPortalConfig.structMsgTitleForStar = ((String)localObject3);
          }
          else if (((String)localObject3).equalsIgnoreCase("structMsgContent"))
          {
            localObject4 = localXmlPullParser.nextText();
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject3 = "";
            }
            localPortalConfig.structMsgContentForStar = ((String)localObject3);
          }
          else if (((String)localObject3).equalsIgnoreCase("starPhoto"))
          {
            localObject3 = a(localXmlPullParser, (String)localObject3);
            localPortalConfig.shareStarImageUrl = ((String)((Pair)localObject3).first);
            localPortalConfig.shareStarImageMD5 = ((String)((Pair)localObject3).second);
          }
          else if (((String)localObject3).equalsIgnoreCase("ShareWording"))
          {
            localObject4 = localXmlPullParser.nextText();
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject3 = "";
            }
            localPortalConfig.shareWording = ((String)localObject3);
          }
          else if (((String)localObject3).equalsIgnoreCase("starGuiderPhoto"))
          {
            localObject3 = a(localXmlPullParser, (String)localObject3);
            localPortalConfig.starGuiderPhotoURL = ((String)((Pair)localObject3).first);
            localPortalConfig.starGuiderPhotoMD5 = ((String)((Pair)localObject3).second);
          }
        }
      } while (!str.equalsIgnoreCase("shareScore"));
      paramInt1 = localXmlPullParser.next();
      if (paramInt1 == 1) {
        break label3075;
      }
      localObject3 = localXmlPullParser.getName();
    } while ((paramInt1 == 3) && (((String)localObject3).equalsIgnoreCase(str)));
    label1730:
    label2119:
    label2641:
    if (paramInt1 == 2)
    {
      if (!((String)localObject3).equalsIgnoreCase("summary")) {
        break label3077;
      }
      localObject4 = localXmlPullParser.nextText();
      localObject3 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject3 = "";
      }
      localPortalConfig.summaryForScore = ((String)localObject3);
    }
    for (;;)
    {
      label2622:
      paramInt1 = localXmlPullParser.next();
      label2728:
      label2730:
      label2988:
      break label2988;
      label2969:
      break;
      label3075:
      label3077:
      if (((String)localObject3).equalsIgnoreCase("structMsgTitle"))
      {
        localObject4 = localXmlPullParser.nextText();
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        localPortalConfig.structMsgTitleForScore = ((String)localObject3);
      }
      else if (((String)localObject3).equalsIgnoreCase("structMsgContent"))
      {
        localObject4 = localXmlPullParser.nextText();
        localObject3 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject3 = "";
        }
        localPortalConfig.structMsgContentForScore = ((String)localObject3);
      }
      else if (((String)localObject3).equalsIgnoreCase("shareIcon"))
      {
        localObject3 = a(localXmlPullParser, (String)localObject3);
        localPortalConfig.shareImageUrl = ((String)((Pair)localObject3).first);
        localPortalConfig.shareImageMD5 = ((String)((Pair)localObject3).second);
      }
    }
    label3220:
    paramInt1 = 0;
    int j = localRedPacketConfig.portalConfigs.size();
    label3241:
    label3314:
    int i;
    if (paramArrayList != null)
    {
      paramInt2 = paramArrayList.size();
      if ((paramInt2 != 0) && (j > 0))
      {
        Collections.sort(localRedPacketConfig.portalConfigs, P);
        localObject1 = (PortalConfig)localRedPacketConfig.portalConfigs.get(0);
        if (((PortalConfig)localObject1).type != 2) {
          break label3640;
        }
        ((PortalConfig)localObject1).uiBegin = (((PortalConfig)localObject1).realBegin + ((Integer)paramArrayList.get(0 % paramInt2)).intValue());
        paramInt1 = 1;
        break label3640;
        if (i < j)
        {
          localObject3 = (PortalConfig)localRedPacketConfig.portalConfigs.get(i);
          if (((PortalConfig)localObject3).type != 2) {
            break label3637;
          }
          ((PortalConfig)localObject3).uiBegin = (((PortalConfig)localObject3).realBegin + ((Integer)paramArrayList.get(paramInt1 % paramInt2)).intValue() * 1000);
          if ((localObject1 == null) || (((PortalConfig)localObject1).type != 1) || (((PortalConfig)localObject1).realEnd + 2000L < ((PortalConfig)localObject3).realBegin)) {
            break label3646;
          }
          ((PortalConfig)localObject1).uiEnd = (((PortalConfig)localObject1).realEnd + ((Integer)paramArrayList.get(paramInt1 % paramInt2)).intValue() * 1000);
          break label3646;
        }
      }
      Collections.sort(localRedPacketConfig.portalConfigs, P);
      paramInt1 = localRedPacketConfig.bannerConfigs.size() - 1;
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        localObject1 = (BannerConfig)localRedPacketConfig.bannerConfigs.get(paramInt1);
        localObject3 = localRedPacketConfig.portalConfigs.iterator();
        do
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (PortalConfig)((Iterator)localObject3).next();
          if ((((BannerConfig)localObject1).uiBegin >= ((PortalConfig)localObject4).realBegin) && (((BannerConfig)localObject1).uiBegin < ((PortalConfig)localObject4).realEnd))
          {
            if (((BannerConfig)localObject1).uiBegin != ((PortalConfig)localObject4).realBegin) {
              break;
            }
            ((BannerConfig)localObject1).uiBegin = ((PortalConfig)localObject4).uiBegin;
            break;
          }
        } while (((PortalConfig)localObject4).uiBegin <= ((BannerConfig)localObject1).uiBegin);
      }
      else
      {
        Collections.sort(localRedPacketConfig.bannerConfigs, P);
        if (QLog.isColorLevel()) {
          a(localRedPacketConfig, "parseConfig, " + paramArrayList);
        }
        paramArrayList = localRedPacketConfig;
        break;
        label3630:
        paramString = "null";
        break label303;
        label3637:
        break label3650;
        label3640:
        i = 1;
        break label3314;
        label3646:
        paramInt1 += 1;
        label3650:
        i += 1;
        localObject1 = localObject3;
        break label3314;
        paramInt2 = 0;
        break label3241;
      }
      paramInt1 -= 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2)
  {
    localObject = paramString1;
    if (TextUtils.isEmpty(paramString1)) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("errorCode", paramInt3);
      if (!TextUtils.isEmpty(paramString2)) {
        ((JSONObject)localObject).put("errorMsg", paramString2);
      }
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
        localObject = paramString1;
      }
    }
    W(paramInt1, (String)localObject, paramInt2);
  }
  
  private void a(RedPacketConfig paramRedPacketConfig)
  {
    if (aqhq.getAvailableInnernalMemorySize() < 1048576.0F) {}
    do
    {
      return;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      Iterator localIterator1 = paramRedPacketConfig.bannerConfigs.iterator();
      Object localObject1;
      while (localIterator1.hasNext())
      {
        localObject1 = (BannerConfig)localIterator1.next();
        if ((((BannerConfig)localObject1).uiEnd > l1) && (nU(((BannerConfig)localObject1).bannarMd5))) {
          T(((BannerConfig)localObject1).id, ((BannerConfig)localObject1).bannerImg, ((BannerConfig)localObject1).bannarMd5);
        }
      }
      if (paramRedPacketConfig.comboNumberConfigs != null)
      {
        localIterator1 = paramRedPacketConfig.comboNumberConfigs.iterator();
        while (localIterator1.hasNext())
        {
          localObject1 = (ComboNumber)localIterator1.next();
          if (nU(((ComboNumber)localObject1).flowerImageMD5)) {
            T(-101, ((ComboNumber)localObject1).flowerImageUrl, ((ComboNumber)localObject1).flowerImageMD5);
          }
          if (nU(((ComboNumber)localObject1).numberImageMD5)) {
            T(-101, ((ComboNumber)localObject1).numberImageUrl, ((ComboNumber)localObject1).numberImageMD5);
          }
          if (nU(((ComboNumber)localObject1).flowerImage2MD5)) {
            T(-101, ((ComboNumber)localObject1).flowerImage2Url, ((ComboNumber)localObject1).flowerImage2MD5);
          }
        }
      }
      localIterator1 = paramRedPacketConfig.portalConfigs.iterator();
      while (localIterator1.hasNext())
      {
        localObject1 = (PortalConfig)localIterator1.next();
        if ((localObject1 != null) && ((((PortalConfig)localObject1).uiEnd > l1) || (((PortalConfig)localObject1).realEnd > l1)))
        {
          if (nU(((PortalConfig)localObject1).bgMd5)) {
            T(((PortalConfig)localObject1).id, ((PortalConfig)localObject1).bgImg, ((PortalConfig)localObject1).bgMd5);
          }
          if (nU(((PortalConfig)localObject1).leftCloudImageMD5)) {
            T(((PortalConfig)localObject1).id, ((PortalConfig)localObject1).leftCloudImageUrl, ((PortalConfig)localObject1).leftCloudImageMD5);
          }
          if (nU(((PortalConfig)localObject1).rightCloudImageMD5)) {
            T(((PortalConfig)localObject1).id, ((PortalConfig)localObject1).rightCloudImageURL, ((PortalConfig)localObject1).rightCloudImageMD5);
          }
          Iterator localIterator2;
          Object localObject2;
          if (((PortalConfig)localObject1).logoList != null)
          {
            localIterator2 = ((PortalConfig)localObject1).logoList.iterator();
            while (localIterator2.hasNext())
            {
              localObject2 = (LogoConfig)localIterator2.next();
              if (localObject2 != null)
              {
                if (nU(((LogoConfig)localObject2).logoImageMD5)) {
                  T(((PortalConfig)localObject1).id, ((LogoConfig)localObject2).logoImageUrl, ((LogoConfig)localObject2).logoImageMD5);
                }
                if (nU(((LogoConfig)localObject2).nameMD5)) {
                  T(((PortalConfig)localObject1).id, ((LogoConfig)localObject2).nameUrl, ((LogoConfig)localObject2).nameMD5);
                }
                if (nU(((LogoConfig)localObject2).greetImageMD5)) {
                  T(((PortalConfig)localObject1).id, ((LogoConfig)localObject2).greetImageUrl, ((LogoConfig)localObject2).greetImageMD5);
                }
                if (nU(((LogoConfig)localObject2).padantImageMD5)) {
                  T(((PortalConfig)localObject1).id, ((LogoConfig)localObject2).padantImageUrl, ((LogoConfig)localObject2).padantImageMD5);
                }
                if (nU(((LogoConfig)localObject2).relationCompanyLogoMD5)) {
                  T(((PortalConfig)localObject1).id, ((LogoConfig)localObject2).relationCompanyLogoUrl, ((LogoConfig)localObject2).relationCompanyLogoMD5);
                }
                if (nU(((LogoConfig)localObject2).relationCompanyNameMD5)) {
                  T(((PortalConfig)localObject1).id, ((LogoConfig)localObject2).relationCompanyNameUrl, ((LogoConfig)localObject2).relationCompanyNameMD5);
                }
              }
            }
          }
          if (((PortalConfig)localObject1).awardConfigList != null)
          {
            localIterator2 = ((PortalConfig)localObject1).awardConfigList.iterator();
            while (localIterator2.hasNext())
            {
              localObject2 = (AwardConfig)localIterator2.next();
              if (localObject2 != null)
              {
                if (nU(((AwardConfig)localObject2).awardMd5)) {
                  T(((PortalConfig)localObject1).id, ((AwardConfig)localObject2).awardImg, ((AwardConfig)localObject2).awardMd5);
                }
                if (nU(((AwardConfig)localObject2).starMd5)) {
                  T(((PortalConfig)localObject1).id, ((AwardConfig)localObject2).starImg, ((AwardConfig)localObject2).starMd5);
                }
                if (nU(((AwardConfig)localObject2).ctfBgMd5)) {
                  T(((PortalConfig)localObject1).id, ((AwardConfig)localObject2).ctfBgImg, ((AwardConfig)localObject2).ctfBgMd5);
                }
              }
            }
          }
          if (nU(((PortalConfig)localObject1).shareStarImageMD5)) {
            T(((PortalConfig)localObject1).id, ((PortalConfig)localObject1).shareStarImageUrl, ((PortalConfig)localObject1).shareStarImageMD5);
          }
          if (nU(((PortalConfig)localObject1).starGuiderPhotoMD5)) {
            T(((PortalConfig)localObject1).id, ((PortalConfig)localObject1).starGuiderPhotoURL, ((PortalConfig)localObject1).starGuiderPhotoMD5);
          }
        }
      }
    } while (System.currentTimeMillis() - this.afM <= 1800000L);
    this.afM = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "tryDownload needReport");
    }
    this.mSubHandler.postDelayed(new PortalManager.2(this, paramRedPacketConfig), 60000L);
  }
  
  private static void a(RedPacketConfig paramRedPacketConfig, String paramString)
  {
    int j = 0;
    int n = paramRedPacketConfig.bannerConfigs.size();
    int k = paramRedPacketConfig.portalConfigs.size();
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(paramString).append(", ").append(paramRedPacketConfig.id).append(", ").append(paramRedPacketConfig.version);
    localStringBuilder.append('[');
    int i = 0;
    while (i < n)
    {
      localStringBuilder.append(((BannerConfig)paramRedPacketConfig.bannerConfigs.get(i)).id).append(", ");
      i += 1;
    }
    localStringBuilder.append(']').append(", ").append('[');
    i = j;
    while (i < k)
    {
      localStringBuilder.append(((PortalConfig)paramRedPacketConfig.portalConfigs.get(i)).id).append(", ");
      i += 1;
    }
    localStringBuilder.append(']');
    QLog.d("PortalManager", 2, localStringBuilder.toString());
  }
  
  @SuppressLint({"UseSparseArrays"})
  private boolean a(RedPacketConfig paramRedPacketConfig1, RedPacketConfig paramRedPacketConfig2, boolean paramBoolean)
  {
    int j = 0;
    int k = paramRedPacketConfig1.portalConfigs.size();
    if (paramRedPacketConfig2 != null) {}
    HashMap localHashMap;
    PortalConfig localPortalConfig1;
    for (int i = paramRedPacketConfig2.portalConfigs.size();; i = 0)
    {
      if (paramRedPacketConfig2 != null) {
        paramRedPacketConfig1.showGesturesTime = paramRedPacketConfig2.showGesturesTime;
      }
      if ((k <= 0) || (i <= 0)) {
        break label284;
      }
      localHashMap = new HashMap(i);
      localObject = paramRedPacketConfig2.portalConfigs.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localPortalConfig1 = (PortalConfig)((Iterator)localObject).next();
        localHashMap.put(Integer.valueOf(localPortalConfig1.id), localPortalConfig1);
      }
    }
    Object localObject = paramRedPacketConfig1.portalConfigs.iterator();
    boolean bool = false;
    PortalConfig localPortalConfig2;
    do
    {
      paramBoolean = bool;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localPortalConfig1 = (PortalConfig)((Iterator)localObject).next();
      localPortalConfig2 = (PortalConfig)localHashMap.get(Integer.valueOf(localPortalConfig1.id));
    } while (localPortalConfig2 == null);
    if (localPortalConfig2.useFlag != localPortalConfig1.useFlag)
    {
      localPortalConfig1.useFlag = localPortalConfig2.useFlag;
      bool = true;
    }
    if (localPortalConfig2.useTime != localPortalConfig1.useTime)
    {
      localPortalConfig1.useTime = localPortalConfig2.useTime;
      bool = true;
    }
    if (localPortalConfig2.countGrab != localPortalConfig1.countGrab)
    {
      localPortalConfig1.countGrab = localPortalConfig2.countGrab;
      bool = true;
    }
    if (localPortalConfig2.continuousRecord != localPortalConfig1.continuousRecord) {
      localPortalConfig1.continuousRecord = localPortalConfig2.continuousRecord;
    }
    for (paramBoolean = true;; paramBoolean = bool)
    {
      bool = paramBoolean;
      break;
      label284:
      paramBoolean = false;
      k = paramRedPacketConfig1.bannerConfigs.size();
      i = j;
      if (paramRedPacketConfig2 != null) {
        i = paramRedPacketConfig2.bannerConfigs.size();
      }
      bool = paramBoolean;
      if (k > 0)
      {
        bool = paramBoolean;
        if (i > 0)
        {
          localHashMap = new HashMap(i);
          paramRedPacketConfig2 = paramRedPacketConfig2.bannerConfigs.iterator();
          while (paramRedPacketConfig2.hasNext())
          {
            localObject = (BannerConfig)paramRedPacketConfig2.next();
            localHashMap.put(Integer.valueOf(((BannerConfig)localObject).id), localObject);
          }
          paramRedPacketConfig1 = paramRedPacketConfig1.bannerConfigs.iterator();
          for (;;)
          {
            bool = paramBoolean;
            if (!paramRedPacketConfig1.hasNext()) {
              break;
            }
            paramRedPacketConfig2 = (BannerConfig)paramRedPacketConfig1.next();
            localObject = (BannerConfig)localHashMap.get(Integer.valueOf(paramRedPacketConfig2.id));
            if ((localObject != null) && (((BannerConfig)localObject).useFlag != paramRedPacketConfig2.useFlag))
            {
              paramRedPacketConfig2.useFlag = ((BannerConfig)localObject).useFlag;
              paramBoolean = true;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PortalManager", 2, "updateUsedFlag, " + bool);
      }
      return bool;
    }
  }
  
  public static long ah(String paramString)
  {
    if (y == null)
    {
      y = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      y.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l1 = -1L;
    try
    {
      long l2 = y.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PortalManager", 2, "", paramString);
    }
    return l1;
    return -1L;
  }
  
  public static boolean atg()
  {
    boolean bool2 = false;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (cvz) {
      l1 = System.currentTimeMillis();
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l1);
    int j = ((Calendar)localObject1).get(1);
    int k = ((Calendar)localObject1).get(2);
    int n = ((Calendar)localObject1).get(5);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    localObject1 = null;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i < gg.length) {
        try
        {
          localObject2 = localSimpleDateFormat.parse(gg[i]);
          if (localObject2 == null)
          {
            i += 1;
            localObject1 = localObject2;
          }
        }
        catch (ParseException localParseException)
        {
          int i1;
          int i2;
          int i3;
          do
          {
            Object localObject2;
            for (;;)
            {
              localObject2 = localObject1;
              if (QLog.isColorLevel())
              {
                QLog.e("PortalManager", 2, "isForbidAlert", localParseException);
                localObject2 = localObject1;
              }
            }
            localCalendar.clear();
            localCalendar.setTime((Date)localObject2);
            i1 = localCalendar.get(1);
            i2 = localCalendar.get(2);
            i3 = localCalendar.get(5);
          } while ((j != i1) || (k + 1 != i2 + 1) || (n != i3));
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "isForbidAlert, current=" + l1 + ", bingo=" + bool1 + ", DEBUG_GRAB=" + cvz);
    }
    return bool1;
  }
  
  private void b(RedPacketConfig paramRedPacketConfig)
  {
    Object localObject1 = paramRedPacketConfig.bannerConfigs.iterator();
    boolean bool1 = true;
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      if (!nU(((BannerConfig)((Iterator)localObject1).next()).bannarMd5)) {}
      for (i = 1;; i = 0)
      {
        bool1 = i & bool1;
        break;
      }
    }
    boolean bool2 = bool1;
    Object localObject2;
    label118:
    int j;
    label132:
    int k;
    if (paramRedPacketConfig.comboNumberConfigs != null)
    {
      localObject1 = paramRedPacketConfig.comboNumberConfigs.iterator();
      bool2 = bool1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComboNumber)((Iterator)localObject1).next();
        if (!nU(((ComboNumber)localObject2).flowerImageMD5))
        {
          i = 1;
          if (nU(((ComboNumber)localObject2).numberImageMD5)) {
            break label166;
          }
          j = 1;
          if (nU(((ComboNumber)localObject2).flowerImage2MD5)) {
            break label171;
          }
        }
        label166:
        label171:
        for (k = 1;; k = 0)
        {
          bool1 = j & i & bool1 & k;
          break;
          i = 0;
          break label118;
          j = 0;
          break label132;
        }
      }
    }
    localObject1 = paramRedPacketConfig.portalConfigs.iterator();
    label241:
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PortalConfig)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        label256:
        label288:
        Object localObject4;
        label331:
        label346:
        int n;
        label361:
        int i1;
        if (!nU(((PortalConfig)localObject2).bgMd5))
        {
          i = 1;
          if (nU(((PortalConfig)localObject2).leftCloudImageMD5)) {
            break label415;
          }
          j = 1;
          if (nU(((PortalConfig)localObject2).rightCloudImageMD5)) {
            break label420;
          }
          k = 1;
          i = k & bool2 & i & j;
          if (((PortalConfig)localObject2).logoList == null) {
            break label455;
          }
          localObject3 = ((PortalConfig)localObject2).logoList.iterator();
          j = i;
          do
          {
            i = j;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (LogoConfig)((Iterator)localObject3).next();
          } while (localObject4 == null);
          if (nU(((LogoConfig)localObject4).logoImageMD5)) {
            break label426;
          }
          i = 1;
          if (nU(((LogoConfig)localObject4).nameMD5)) {
            break label431;
          }
          k = 1;
          if (nU(((LogoConfig)localObject4).greetImageMD5)) {
            break label437;
          }
          n = 1;
          if (nU(((LogoConfig)localObject4).padantImageMD5)) {
            break label443;
          }
          i1 = 1;
          label376:
          if (nU(((LogoConfig)localObject4).relationCompanyLogoMD5)) {
            break label449;
          }
        }
        label415:
        label420:
        label426:
        label431:
        label437:
        label443:
        label449:
        for (int i2 = 1;; i2 = 0)
        {
          j = i2 & i1 & i & j & k & n;
          break label288;
          i = 0;
          break;
          j = 0;
          break label241;
          k = 0;
          break label256;
          i = 0;
          break label331;
          k = 0;
          break label346;
          n = 0;
          break label361;
          i1 = 0;
          break label376;
        }
        label455:
        j = i;
        if (((PortalConfig)localObject2).awardConfigList != null)
        {
          localObject3 = ((PortalConfig)localObject2).awardConfigList.iterator();
          do
          {
            j = i;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject4 = (AwardConfig)((Iterator)localObject3).next();
          } while (localObject4 == null);
          if (!nU(((AwardConfig)localObject4).awardMd5))
          {
            j = 1;
            label520:
            if (nU(((AwardConfig)localObject4).starMd5)) {
              break label568;
            }
            k = 1;
            label535:
            if (nU(((AwardConfig)localObject4).ctfBgMd5)) {
              break label574;
            }
          }
          label568:
          label574:
          for (n = 1;; n = 0)
          {
            i = k & j & i & n;
            break;
            j = 0;
            break label520;
            k = 0;
            break label535;
          }
        }
        if (!nU(((PortalConfig)localObject2).shareStarImageMD5))
        {
          i = 1;
          label594:
          if (nU(((PortalConfig)localObject2).starGuiderPhotoMD5)) {
            break label625;
          }
        }
        label625:
        for (k = 1;; k = 0)
        {
          bool2 = i & j & k;
          break;
          i = 0;
          break label594;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "reportResCover ,resCover=" + bool2);
    }
    if (bool2) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      localObject2 = String.valueOf(paramRedPacketConfig.taskId);
      paramRedPacketConfig = String.valueOf(paramRedPacketConfig.version);
      anot.a(this.mApp, "dc01440", "", "", "0X80078FA", "0X80078FA", 0, 0, (String)localObject1, (String)localObject2, paramRedPacketConfig, "");
      if (alan.V(this.mCtx, "hongbao_17_res_cover"))
      {
        alan.bL(this.mCtx, "hongbao_17_res_cover");
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("config_version", paramRedPacketConfig);
        ((HashMap)localObject3).put("cover", localObject1);
        ((HashMap)localObject3).put("taskid", localObject2);
        anpc.a(this.mCtx).collectPerformance(this.mApp.getCurrentAccountUin(), "hongbao_res_precover", bool2, 0L, 0L, (HashMap)localObject3, "", false);
      }
      return;
    }
  }
  
  private void cRa()
  {
    boolean bool2 = true;
    int i;
    int j;
    String str;
    if (this.jdField_b_of_type_Akpr == null)
    {
      this.jdField_b_of_type_Akpr = new akpr();
      i = (int)(aqgz.getSystemTotalMemory() / 1024L / 1024L);
      j = aqnm.getScreenWidth();
      str = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.olympic_act_config.name());
      this.jdField_b_of_type_Akpr.RU = str;
    }
    try
    {
      if (str.length() > 0)
      {
        String[] arrayOfString = str.split("\\|");
        if (arrayOfString.length >= 9)
        {
          if (i <= Integer.valueOf(arrayOfString[0]).intValue()) {}
          for (this.jdField_b_of_type_Akpr.ctV = true;; this.jdField_b_of_type_Akpr.ctV = true)
          {
            if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
              this.jdField_b_of_type_Akpr.ctX = true;
            }
            this.jdField_b_of_type_Akpr.cEa = Integer.valueOf(arrayOfString[4]).intValue();
            this.jdField_b_of_type_Akpr.cEb = Integer.valueOf(arrayOfString[5]).intValue();
            this.jdField_b_of_type_Akpr.cEc = Integer.valueOf(arrayOfString[6]).intValue();
            this.jdField_b_of_type_Akpr.cEd = Integer.valueOf(arrayOfString[7]).intValue();
            this.jdField_b_of_type_Akpr.cEe = Integer.valueOf(arrayOfString[8]).intValue();
            bool1 = false;
            this.jdField_b_of_type_Akpr.ctU = bool1;
            if (bool1)
            {
              if (i > 512) {
                break label489;
              }
              this.jdField_b_of_type_Akpr.ctV = true;
              this.jdField_b_of_type_Akpr.ctX = false;
              this.jdField_b_of_type_Akpr.cEa = 0;
              this.jdField_b_of_type_Akpr.cEb = 3;
              this.jdField_b_of_type_Akpr.cEc = 1000;
              this.jdField_b_of_type_Akpr.cEd = 1;
              this.jdField_b_of_type_Akpr.cEe = 1;
            }
            if (this.jdField_b_of_type_Akpr.cEd != 1) {
              break label525;
            }
            akrf.Nd(bool2);
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager", 2, "loadDPCConfig|featureValue:" + str + ",systemTotalMem:" + i + ",screenWidth:" + j + ",isUseDefault:" + bool1 + ",dpc:" + this.jdField_b_of_type_Akpr.toString());
            }
            return;
            if (j > Integer.valueOf(arrayOfString[1]).intValue()) {
              break;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PortalManager", 2, "loadDPCConfig Exception:" + localException.toString());
        }
        boolean bool1 = true;
        continue;
        label525:
        if (j <= Integer.valueOf(localException[2]).intValue())
        {
          this.jdField_b_of_type_Akpr.ctW = true;
          continue;
          label489:
          if (j <= 480)
          {
            this.jdField_b_of_type_Akpr.ctV = true;
          }
          else if (j <= 720)
          {
            this.jdField_b_of_type_Akpr.ctW = true;
            continue;
            bool2 = false;
          }
        }
      }
    }
  }
  
  public static Bitmap d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "getBitmap, path=" + paramString1 + ", defaultPath=" + paramString2);
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getFilesDir() + bUW;
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return i(paramString2, true);
      }
      str = "red_packet_" + paramString1;
      localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str);
      if (localBitmap == null) {
        break label167;
      }
      localObject1 = localBitmap;
      paramString1 = localBitmap;
      try
      {
        if (!QLog.isColorLevel()) {
          return paramString1;
        }
        localObject1 = localBitmap;
        QLog.d("PortalManager", 2, "getBitmap, hit cache");
        return localBitmap;
      }
      catch (Exception paramString2) {}
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        String str;
        Bitmap localBitmap;
        label167:
        Object localObject1 = null;
      }
    }
    paramString1 = (String)localObject1;
    if (QLog.isColorLevel())
    {
      QLog.d("PortalManager", 2, "", paramString2);
      return localObject1;
      localObject1 = localBitmap;
      try
      {
        PortalManager localPortalManager = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(79);
        localObject1 = localBitmap;
        localObject2 = a((String)localObject2 + paramString1, -1, localPortalManager.jdField_b_of_type_Akpr, 1);
        paramString1 = localBitmap;
        if (localObject2 != null)
        {
          localObject1 = localBitmap;
          paramString1 = (Bitmap)((Pair)localObject2).second;
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PortalManager", 2, "getBitmap, exception=" + paramString1.getMessage(), paramString1);
          }
          paramString1 = null;
        }
        localObject1 = paramString1;
        paramString2 = i(paramString2, true);
        localObject1 = paramString2;
        paramString1 = paramString2;
        if (!QLog.isColorLevel()) {
          return paramString1;
        }
      }
      if (paramString1 != null)
      {
        localObject1 = paramString1;
        BaseApplicationImpl.sImageCache.put(str, paramString1);
        return paramString1;
      }
      localObject1 = paramString2;
      QLog.d("PortalManager", 2, "getBitmap, using default bitmap");
      return paramString2;
    }
    return paramString1;
  }
  
  private void dEz()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.l.size())
      {
        if (this.l.keyAt(i) != this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id)
        {
          this.l.remove(this.l.keyAt(i));
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "purifyBrashReporter delete key = " + this.l.keyAt(i));
          }
        }
        i += 1;
      }
    }
  }
  
  private static int dH(String paramString)
  {
    return -1;
  }
  
  public static Bitmap getBitmapFromCache(String paramString)
  {
    try
    {
      paramString = (Bitmap)BaseApplicationImpl.sImageCache.get("red_packet_" + paramString);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("getBitmapFromCache, hit=");
        if (paramString == null) {
          break label73;
        }
      }
      label73:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("PortalManager", 2, bool);
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PortalManager", 2, "preloadDrawableById Exception", paramString);
      }
    }
  }
  
  public static Bitmap i(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("red_packet_" + paramString);
      if (localObject2 != null) {
        return localObject2;
      }
      i = dH(paramString);
      if (i < 0) {
        return null;
      }
      localObject1 = (PortalManager)BaseApplicationImpl.getApplication().getRuntime().getManager(79);
      if (localObject1 == null) {
        break label166;
      }
      localObject1 = ((PortalManager)localObject1).jdField_b_of_type_Akpr;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        int i;
        Pair localPair;
        if (QLog.isColorLevel()) {
          QLog.e("PortalManager", 2, "", paramString);
        }
        return null;
        Object localObject1 = null;
      }
    }
    catch (Exception paramString)
    {
      label166:
      if (!QLog.isColorLevel()) {
        break label189;
      }
      QLog.e("PortalManager", 2, "", paramString);
      label189:
      localObject2 = null;
    }
    localPair = a("", i, (akpr)localObject1, 2);
    localObject1 = localObject2;
    if (localPair != null) {
      localObject1 = (Bitmap)localPair.second;
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (paramBoolean)
      {
        BaseApplicationImpl.sImageCache.put("red_packet_" + paramString, localObject1);
        return localObject1;
      }
    }
    return localObject2;
  }
  
  /* Error */
  public static Bitmap k(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +40 -> 45
    //   8: ldc_w 299
    //   11: iconst_2
    //   12: new 130	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1436
    //   22: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 1438
    //   32: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: getstatic 1390	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   48: new 130	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 1386
    //   58: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 1393	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 539	android/graphics/Bitmap
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +36 -> 112
    //   79: aload_3
    //   80: astore 5
    //   82: aload_3
    //   83: astore 6
    //   85: aload_3
    //   86: astore 4
    //   88: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +206 -> 297
    //   94: aload_3
    //   95: astore 5
    //   97: aload_3
    //   98: astore 6
    //   100: ldc_w 299
    //   103: iconst_2
    //   104: ldc_w 1440
    //   107: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_3
    //   111: areturn
    //   112: aload_3
    //   113: astore 5
    //   115: aload_3
    //   116: astore 6
    //   118: invokestatic 549	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   121: invokevirtual 1399	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   124: bipush 79
    //   126: invokevirtual 1405	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   129: checkcast 2	com/tencent/mobileqq/portal/PortalManager
    //   132: astore 4
    //   134: aload 4
    //   136: ifnull +15 -> 151
    //   139: aload_3
    //   140: astore 5
    //   142: aload_3
    //   143: astore 6
    //   145: aload 4
    //   147: getfield 1294	com/tencent/mobileqq/portal/PortalManager:jdField_b_of_type_Akpr	Lakpr;
    //   150: astore_2
    //   151: aload_3
    //   152: astore 5
    //   154: aload_3
    //   155: astore 6
    //   157: ldc_w 301
    //   160: iload_1
    //   161: aload_2
    //   162: iconst_2
    //   163: invokestatic 534	com/tencent/mobileqq/portal/PortalManager:a	(Ljava/lang/String;ILakpr;I)Landroid/util/Pair;
    //   166: astore 4
    //   168: aload_3
    //   169: astore_2
    //   170: aload 4
    //   172: ifnull +18 -> 190
    //   175: aload_3
    //   176: astore 5
    //   178: aload_3
    //   179: astore 6
    //   181: aload 4
    //   183: getfield 537	android/util/Pair:second	Ljava/lang/Object;
    //   186: checkcast 539	android/graphics/Bitmap
    //   189: astore_2
    //   190: aload_2
    //   191: astore 4
    //   193: aload_2
    //   194: ifnull +103 -> 297
    //   197: aload_2
    //   198: astore 5
    //   200: aload_2
    //   201: astore 6
    //   203: getstatic 1390	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   206: new 130	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 1386
    //   216: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: aload_2
    //   227: invokevirtual 1406	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   230: pop
    //   231: aload_2
    //   232: areturn
    //   233: astore_0
    //   234: aload 5
    //   236: astore 4
    //   238: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +56 -> 297
    //   244: ldc_w 299
    //   247: iconst_2
    //   248: ldc_w 1442
    //   251: aload_0
    //   252: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload 5
    //   257: areturn
    //   258: astore_0
    //   259: aconst_null
    //   260: astore 6
    //   262: aload 6
    //   264: astore 4
    //   266: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +28 -> 297
    //   272: ldc_w 299
    //   275: iconst_2
    //   276: ldc_w 1430
    //   279: aload_0
    //   280: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload 6
    //   285: areturn
    //   286: astore_0
    //   287: goto -25 -> 262
    //   290: astore_0
    //   291: aconst_null
    //   292: astore 5
    //   294: goto -60 -> 234
    //   297: aload 4
    //   299: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramString	String
    //   0	300	1	paramInt	int
    //   1	231	2	localObject1	Object
    //   74	105	3	localBitmap	Bitmap
    //   86	212	4	localObject2	Object
    //   80	213	5	localObject3	Object
    //   83	201	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	94	233	java/lang/OutOfMemoryError
    //   100	110	233	java/lang/OutOfMemoryError
    //   118	134	233	java/lang/OutOfMemoryError
    //   145	151	233	java/lang/OutOfMemoryError
    //   157	168	233	java/lang/OutOfMemoryError
    //   181	190	233	java/lang/OutOfMemoryError
    //   203	231	233	java/lang/OutOfMemoryError
    //   45	75	258	java/lang/Exception
    //   88	94	286	java/lang/Exception
    //   100	110	286	java/lang/Exception
    //   118	134	286	java/lang/Exception
    //   145	151	286	java/lang/Exception
    //   157	168	286	java/lang/Exception
    //   181	190	286	java/lang/Exception
    //   203	231	286	java/lang/Exception
    //   45	75	290	java/lang/OutOfMemoryError
  }
  
  private void kA(long paramLong)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    if (localObject3 == null) {
      return;
    }
    long l2 = paramLong;
    if (afO > 0L) {
      l2 = afO + afQ * (paramLong - afP);
    }
    this.mUiHandler.removeMessages(100);
    ArrayList localArrayList = ((RedPacketConfig)localObject3).bannerConfigs;
    jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig.uiBegin = l2;
    PortalConfig localPortalConfig = null;
    int i = Collections.binarySearch(localArrayList, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, P);
    Object localObject1;
    if (i >= 0)
    {
      i += 1;
      if ((i <= 0) || (i > localArrayList.size())) {
        break label869;
      }
      localObject1 = (BannerConfig)localArrayList.get(i - 1);
      if (((BannerConfig)localObject1).uiEnd >= l2) {
        break label866;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = localPortalConfig;
      if (i < localArrayList.size())
      {
        localObject2 = localPortalConfig;
        if (i >= 0) {
          localObject2 = (BannerConfig)localArrayList.get(i);
        }
      }
      localObject3 = ((RedPacketConfig)localObject3).portalConfigs;
      i = Collections.binarySearch((List)localObject3, jdField_a_of_type_ComTencentMobileqqPortalPortalManager$TimerConfig, P);
      if (i >= 0)
      {
        i += 1;
        label184:
        if ((i <= 0) || (i > ((ArrayList)localObject3).size())) {
          break label860;
        }
        localPortalConfig = (PortalConfig)((ArrayList)localObject3).get(i - 1);
        if (localPortalConfig.uiEnd >= l2) {
          break label857;
        }
        localPortalConfig = null;
      }
      for (;;)
      {
        if ((i < ((ArrayList)localObject3).size()) && (i >= 0)) {}
        label291:
        label558:
        label587:
        for (localObject3 = (PortalConfig)((ArrayList)localObject3).get(i);; localObject3 = null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((BannerConfig)localObject1);
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig = ((BannerConfig)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = localPortalConfig;
          this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig = ((PortalConfig)localObject3);
          paramLong = 9223372036854775807L;
          long l1;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
          {
            paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiEnd;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
              break label778;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd <= l2) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd >= paramLong)) {
              break label735;
            }
            l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
            label332:
            paramLong = l1;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
            {
              long l3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime;
              paramLong = l1;
              if (l3 >= l2)
              {
                paramLong = l1;
                if (l3 < l1)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PortalManager", 2, "updateCurrentTimer last minutes in, countTime = " + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime + ", diffTime = " + l3 + ", timeout = " + l3);
                  }
                  paramLong = l3;
                }
              }
            }
            this.afR = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd;
          }
          label460:
          label848:
          for (;;)
          {
            if (paramLong != 9223372036854775807L)
            {
              if (paramLong <= l2) {
                break label808;
              }
              l1 = paramLong - l2;
              label481:
              l2 = l1;
              if (l1 > 60000L) {
                l2 = 60000L;
              }
              if (afO == 0L) {
                break label841;
              }
            }
            for (l1 = 1000L;; l1 = l2)
            {
              a(true, 100, l1, null);
              if (!QLog.isColorLevel()) {
                break;
              }
              localObject1 = new StringBuilder().append("updateCurrentTimer, ");
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
              {
                i = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label821;
                }
                i = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label826;
                }
                i = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                label616:
                localObject1 = ((StringBuilder)localObject1).append(i).append(", ");
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label831;
                }
                i = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
                localObject1 = ((StringBuilder)localObject1).append(i).append(", ").append(paramLong).append(", ");
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
                  break label836;
                }
              }
              for (i = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag;; i = -1)
              {
                QLog.d("PortalManager", 2, i);
                return;
                i = -i - 1;
                break;
                i = -i - 1;
                break label184;
                if (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
                  break label291;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.uiBegin;
                break label291;
                label735:
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd <= l2) {
                  break label332;
                }
                l1 = paramLong;
                if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd >= paramLong) {
                  break label332;
                }
                l1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd;
                break label332;
                if ((this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin >= paramLong)) {
                  break label848;
                }
                paramLong = this.jdField_b_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiBegin;
                break label460;
                l1 = 60000L;
                break label481;
                i = -1;
                break label558;
                i = -1;
                break label587;
                i = -1;
                break label616;
                i = -1;
                break label645;
              }
            }
          }
        }
        label645:
        label778:
        label808:
        label821:
        label826:
        label831:
        label836:
        label841:
        label857:
        continue;
        label860:
        localPortalConfig = null;
      }
      label866:
      continue;
      label869:
      localObject1 = null;
    }
  }
  
  private boolean nU(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.cf.contains(paramString))) {}
    String str;
    do
    {
      return false;
      str = this.mApp.getApplication().getFilesDir() + bUW;
    } while (new File(str + paramString).exists());
    this.cf.add(paramString);
    return true;
  }
  
  public int Ho()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
    }
    return -1;
  }
  
  public void SA(int paramInt)
  {
    bH(paramInt, false);
  }
  
  public void Sz(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 2)) {}
    do
    {
      do
      {
        return;
      } while (paramInt <= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord);
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.continuousRecord = paramInt;
    } while (this.mSubHandler.hasMessages(6));
    a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
  }
  
  public PortalConfig a(long paramLong)
  {
    long l2 = paramLong;
    long l1;
    int i;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
    {
      l1 = paramLong;
      if (paramLong == -1L)
      {
        paramLong = NetConnInfoCenter.getServerTimeMillis();
        l1 = paramLong;
        if (afO > 0L) {
          l1 = afO + afQ * (paramLong - afP);
        }
      }
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs;
      int j = localArrayList.size();
      i = 0;
      l2 = l1;
      if (i < j)
      {
        localObject2 = (PortalConfig)localArrayList.get(i);
        localObject1 = localObject2;
        l2 = l1;
        if (((PortalConfig)localObject2).id != l1)
        {
          if ((((PortalConfig)localObject2).realBegin > l1) || (((PortalConfig)localObject2).realEnd <= l1)) {
            break label202;
          }
          l2 = l1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      label140:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("findRealPortal, ").append(l2).append(", ");
        if (localObject1 == null) {
          break label239;
        }
      }
      label202:
      label239:
      for (i = localObject1.id;; i = -1)
      {
        QLog.d("PortalManager", 2, i);
        return localObject1;
        if ((l1 > 536870911L) && (((PortalConfig)localObject2).realBegin > l1))
        {
          localObject1 = null;
          l2 = l1;
          break label140;
        }
        i += 1;
        break;
      }
      localObject1 = null;
    }
  }
  
  /* Error */
  protected RedPacketConfig a()
  {
    // Byte code:
    //   0: new 135	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 237	com/tencent/mobileqq/portal/PortalManager:mCtx	Landroid/content/Context;
    //   8: invokevirtual 1510	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: new 130	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1512
    //   21: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 229	com/tencent/mobileqq/portal/PortalManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: invokevirtual 1515	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   31: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 1518	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual 505	java/io/File:exists	()Z
    //   45: ifeq +398 -> 443
    //   48: new 1520	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 1523	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: new 1525	java/io/ObjectInputStream
    //   60: dup
    //   61: new 1527	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 1530	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 1531	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   72: astore 6
    //   74: aload_1
    //   75: astore_3
    //   76: aload 6
    //   78: astore_2
    //   79: aload 6
    //   81: invokevirtual 1534	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   84: checkcast 31	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   87: astore 4
    //   89: aload 6
    //   91: ifnull +8 -> 99
    //   94: aload 6
    //   96: invokevirtual 1537	java/io/ObjectInputStream:close	()V
    //   99: aload_1
    //   100: ifnull +348 -> 448
    //   103: aload_1
    //   104: invokevirtual 1538	java/io/FileInputStream:close	()V
    //   107: aload 4
    //   109: astore_1
    //   110: aload_1
    //   111: astore_2
    //   112: aload_1
    //   113: ifnonnull +11 -> 124
    //   116: new 31	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig
    //   119: dup
    //   120: invokespecial 596	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:<init>	()V
    //   123: astore_2
    //   124: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +41 -> 168
    //   130: new 130	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 1540
    //   140: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: astore_3
    //   144: aload_2
    //   145: ifnull +254 -> 399
    //   148: aload_2
    //   149: invokevirtual 644	com/tencent/mobileqq/portal/PortalManager$RedPacketConfig:toString	()Ljava/lang/String;
    //   152: astore_1
    //   153: ldc_w 299
    //   156: iconst_2
    //   157: aload_3
    //   158: aload_1
    //   159: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_0
    //   169: getfield 1445	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig	Lcom/tencent/mobileqq/portal/PortalManager$RedPacketConfig;
    //   172: ifnonnull +11 -> 183
    //   175: aload_0
    //   176: iconst_1
    //   177: iconst_2
    //   178: lconst_0
    //   179: aload_2
    //   180: invokevirtual 1480	com/tencent/mobileqq/portal/PortalManager:a	(ZIJLjava/lang/Object;)V
    //   183: aload_2
    //   184: areturn
    //   185: astore_2
    //   186: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq -90 -> 99
    //   192: ldc_w 299
    //   195: iconst_2
    //   196: ldc_w 301
    //   199: aload_2
    //   200: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   203: goto -104 -> 99
    //   206: astore_1
    //   207: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +14 -> 224
    //   213: ldc_w 299
    //   216: iconst_2
    //   217: ldc_w 301
    //   220: aload_1
    //   221: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload 4
    //   226: astore_1
    //   227: goto -117 -> 110
    //   230: astore 5
    //   232: aconst_null
    //   233: astore 4
    //   235: aconst_null
    //   236: astore_1
    //   237: aload 4
    //   239: astore_3
    //   240: aload_1
    //   241: astore_2
    //   242: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +20 -> 265
    //   248: aload 4
    //   250: astore_3
    //   251: aload_1
    //   252: astore_2
    //   253: ldc_w 299
    //   256: iconst_2
    //   257: ldc_w 301
    //   260: aload 5
    //   262: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 1537	java/io/ObjectInputStream:close	()V
    //   273: aload 4
    //   275: ifnull +168 -> 443
    //   278: aload 4
    //   280: invokevirtual 1538	java/io/FileInputStream:close	()V
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -175 -> 110
    //   288: astore_1
    //   289: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -19 -> 273
    //   295: ldc_w 299
    //   298: iconst_2
    //   299: ldc_w 301
    //   302: aload_1
    //   303: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   306: goto -33 -> 273
    //   309: astore_1
    //   310: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +14 -> 327
    //   316: ldc_w 299
    //   319: iconst_2
    //   320: ldc_w 301
    //   323: aload_1
    //   324: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -219 -> 110
    //   332: astore 4
    //   334: aconst_null
    //   335: astore_1
    //   336: aconst_null
    //   337: astore_2
    //   338: aload_2
    //   339: ifnull +7 -> 346
    //   342: aload_2
    //   343: invokevirtual 1537	java/io/ObjectInputStream:close	()V
    //   346: aload_1
    //   347: ifnull +7 -> 354
    //   350: aload_1
    //   351: invokevirtual 1538	java/io/FileInputStream:close	()V
    //   354: aload 4
    //   356: athrow
    //   357: astore_2
    //   358: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -15 -> 346
    //   364: ldc_w 299
    //   367: iconst_2
    //   368: ldc_w 301
    //   371: aload_2
    //   372: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   375: goto -29 -> 346
    //   378: astore_1
    //   379: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -28 -> 354
    //   385: ldc_w 299
    //   388: iconst_2
    //   389: ldc_w 301
    //   392: aload_1
    //   393: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   396: goto -42 -> 354
    //   399: ldc_w 1064
    //   402: astore_1
    //   403: goto -250 -> 153
    //   406: astore 4
    //   408: aconst_null
    //   409: astore_2
    //   410: goto -72 -> 338
    //   413: astore 4
    //   415: aload_3
    //   416: astore_1
    //   417: goto -79 -> 338
    //   420: astore 5
    //   422: aconst_null
    //   423: astore_2
    //   424: aload_1
    //   425: astore 4
    //   427: aload_2
    //   428: astore_1
    //   429: goto -192 -> 237
    //   432: astore 5
    //   434: aload_1
    //   435: astore 4
    //   437: aload 6
    //   439: astore_1
    //   440: goto -203 -> 237
    //   443: aconst_null
    //   444: astore_1
    //   445: goto -335 -> 110
    //   448: aload 4
    //   450: astore_1
    //   451: goto -341 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	PortalManager
    //   40	119	1	localObject1	Object
    //   206	15	1	localIOException1	java.io.IOException
    //   226	59	1	localObject2	Object
    //   288	15	1	localIOException2	java.io.IOException
    //   309	15	1	localIOException3	java.io.IOException
    //   328	23	1	localObject3	Object
    //   378	15	1	localIOException4	java.io.IOException
    //   402	49	1	localObject4	Object
    //   78	106	2	localObject5	Object
    //   185	15	2	localIOException5	java.io.IOException
    //   241	102	2	localObject6	Object
    //   357	15	2	localIOException6	java.io.IOException
    //   409	19	2	localObject7	Object
    //   75	341	3	localObject8	Object
    //   87	192	4	localRedPacketConfig	RedPacketConfig
    //   332	23	4	localObject9	Object
    //   406	1	4	localObject10	Object
    //   413	1	4	localObject11	Object
    //   425	24	4	localObject12	Object
    //   230	31	5	localThrowable1	Throwable
    //   420	1	5	localThrowable2	Throwable
    //   432	1	5	localThrowable3	Throwable
    //   72	366	6	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   94	99	185	java/io/IOException
    //   103	107	206	java/io/IOException
    //   48	57	230	java/lang/Throwable
    //   269	273	288	java/io/IOException
    //   278	283	309	java/io/IOException
    //   48	57	332	finally
    //   342	346	357	java/io/IOException
    //   350	354	378	java/io/IOException
    //   57	74	406	finally
    //   79	89	413	finally
    //   242	248	413	finally
    //   253	265	413	finally
    //   57	74	420	java/lang/Throwable
    //   79	89	432	java/lang/Throwable
  }
  
  protected RedPacketConfig a(RedPacketConfig paramRedPacketConfig)
  {
    RedPacketConfig localRedPacketConfig1;
    if (QLog.isColorLevel())
    {
      if (paramRedPacketConfig == null) {
        QLog.d("PortalManager", 2, "handleNewConfig");
      }
    }
    else
    {
      RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      localRedPacketConfig1 = localRedPacketConfig2;
      if (localRedPacketConfig2 == null) {
        localRedPacketConfig1 = a();
      }
      if (paramRedPacketConfig == null) {
        break label126;
      }
      a(paramRedPacketConfig, localRedPacketConfig1, false);
      a(paramRedPacketConfig);
    }
    for (;;)
    {
      a(paramRedPacketConfig);
      return paramRedPacketConfig;
      QLog.d("PortalManager", 2, "handleNewConfig, " + paramRedPacketConfig.version + ", " + paramRedPacketConfig.bannerConfigs.size() + ", " + paramRedPacketConfig.portalConfigs.size());
      break;
      label126:
      paramRedPacketConfig = localRedPacketConfig1;
    }
  }
  
  public d a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (0 == 0) {}
    for (Object localObject2 = a(paramInt2);; localObject2 = null)
    {
      if (localObject2 == null) {
        return null;
      }
      Object localObject3 = ((PortalConfig)localObject2).findRealAwardConfigById(paramInt3);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = ((PortalConfig)localObject2).findRealAwardConfigById(paramInt4);
        localObject1 = localObject2;
        if (localObject2 == null) {
          return null;
        }
      }
      localObject3 = new d();
      switch (paramInt1)
      {
      default: 
        return null;
      }
      ((d)localObject3).fJ = d(localObject1.awardMd5, null);
      ((d)localObject3).tips = localObject1.addMsg;
      ((d)localObject3).awT = localObject1.publicId;
      ((d)localObject3).aNx = localObject1.publicWording;
      StringBuilder localStringBuilder = new StringBuilder().append(BaseApplicationImpl.getApplication().getFilesDir()).append(bUW);
      if (localObject1.awardType == 2) {}
      for (localObject2 = localObject1.starMd5;; localObject2 = localObject1.awardMd5)
      {
        ((d)localObject3).bUY = ((String)localObject2);
        ((d)localObject3).bUZ = (BaseApplicationImpl.getApplication().getFilesDir() + bUW + localObject1.ctfBgMd5);
        ((d)localObject3).wishing = localObject1.awardMsg;
        ((d)localObject3).bVa = localObject1.awardTitle;
        ((d)localObject3).dqA = localObject1.awardType;
        ((d)localObject3).dqP = localObject1.showPublic;
        return localObject3;
      }
    }
  }
  
  public void a(c paramc, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c == null) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Bitmap localBitmap1 = null;
    Object localObject4 = null;
    String str1 = null;
    String str2 = null;
    Object localObject5 = null;
    paramc = null;
    int j = 0;
    int i = j;
    long l4;
    long l1;
    long l2;
    Bitmap localBitmap2;
    Bitmap localBitmap3;
    Bitmap localBitmap4;
    Object localObject3;
    if (1 == (paramInt & 0x1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.cun();
        i = j;
      }
    }
    else
    {
      j = i;
      if (2 == (paramInt & 0x2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
          break label1186;
        }
        l4 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.version << 30 | this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;
        l1 = paramLong;
        if (paramLong == 0L) {
          l1 = NetConnInfoCenter.getServerTimeMillis();
        }
        l2 = l1;
        if (afO > 0L) {
          l2 = afO + afQ * (l1 - afP);
        }
        localBitmap2 = d(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, "hb_bg_name_path");
        localBitmap3 = d(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.leftCloudImageMD5, "hb_leftclound_name_path");
        localBitmap4 = d(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightCloudImageMD5, "hb_rightclound_name_path");
        paramLong = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.scrollTime;
        l1 = paramLong;
        if (paramLong == 0L) {
          l1 = 3000L;
        }
        localObject3 = localObject5;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.size() > 0)
        {
          localObject3 = localObject5;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 3)
          {
            localObject5 = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList);
            localObject3 = localObject5;
            if (localObject5 != null)
            {
              Collections.shuffle((List)localObject5);
              localObject3 = localObject5;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
          break label686;
        }
        paramLong = -1L;
        if (l2 > this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd) {
          paramLong = Math.min(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - l2, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.uiEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 1) {
          break label619;
        }
        paramc = (LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
        localObject1 = d(paramc.logoImageMD5, "hb_yure_star_logo_path");
        localObject2 = d(paramc.nameMD5, "hb_yure_star_name_path");
        localBitmap1 = d(paramc.padantImageMD5, "hb_icon_path");
      }
    }
    for (;;)
    {
      label408:
      if (paramc != null) {
        localObject4 = d(paramc.greetImageMD5, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.a(l4, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode, localBitmap2, (Bitmap)localObject1, localBitmap1, localBitmap3, localBitmap4, (Bitmap)localObject4, (Bitmap)localObject2, (List)localObject3, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.rightMsg, paramLong, paramBoolean, l1);
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag < 2) && (!this.cvB) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.atc()))
      {
        this.cvB = true;
        paramInt = 1;
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
      }
      for (;;)
      {
        j = paramInt;
        for (;;)
        {
          if (j == 0) {
            break label1198;
          }
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return;
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig == null) {
            break;
          }
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag >= 2) {
            break;
          }
          localObject3 = d(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.bannarMd5, "hb_banner_path");
          i = j;
          if (localObject3 == null) {
            break;
          }
          i = j;
          if (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.g((Bitmap)localObject3, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
          i = 1;
          break;
          label619:
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 2) {
            break label1206;
          }
          paramc = (LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
          localObject1 = d(paramc.logoImageMD5, "hb_busi_logo_path");
          localObject2 = d(paramc.nameMD5, "hb_yure_busi_name_path");
          localBitmap1 = d(paramc.padantImageMD5, "hb_busi_logo_path");
          break label408;
          label686:
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2)
          {
            String str3;
            long l3;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode == 1)
            {
              localObject2 = (LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
              paramc = d(((LogoConfig)localObject2).logoImageMD5, "hb_icon_path");
              localBitmap1 = d(((LogoConfig)localObject2).nameMD5, "hb_name_path");
              localObject1 = d(((LogoConfig)localObject2).padantImageMD5, "hb_icon_path");
              localObject4 = d(((LogoConfig)localObject2).relationCompanyLogoMD5, "hb_busi_logo_path");
              localObject2 = d(((LogoConfig)localObject2).relationCompanyNameMD5, "hb_name_path");
              str1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.grabMsg;
              str2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.actEndWording;
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.nextActTime;
              str3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countDownTips;
              l3 = -1L;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime <= 0L) {
                break label1076;
              }
              l3 = l2 - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime;
              if (l3 <= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime)
              {
                paramLong = l3;
                if (l3 > 0L) {}
              }
              else
              {
                paramLong = 0L;
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.a(l4, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode, localBitmap2, paramc, (Bitmap)localObject1, str1, str2, (String)localObject5, str3, paramLong, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab, localBitmap3, localBitmap4, (List)localObject3, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.comboNumberConfigs, localBitmap1, l1, (Bitmap)localObject4, (Bitmap)localObject2);
              j = i;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime > 0L) {
                break;
              }
              j = i;
              if (!this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.ath()) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.showGesturesTime = l2;
              j = 1;
              break;
              paramc = (c)localObject2;
              localObject4 = str1;
              localObject2 = str2;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.mode != 2) {
                break label790;
              }
              localObject1 = (LogoConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.logoList.get(0);
              paramc = d(((LogoConfig)localObject1).logoImageMD5, "hb_busi_logo_path");
              localBitmap1 = d(((LogoConfig)localObject1).nameMD5, "hb_name_path");
              localObject1 = d(((LogoConfig)localObject1).padantImageMD5, "hb_busi_logo_path");
              localObject4 = str1;
              localObject2 = str2;
              break label790;
              label1076:
              paramLong = l3;
              if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime == 0L)
              {
                paramLong = l3;
                if (l2 >= this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.realEnd - this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countTime) {
                  paramLong = 0L;
                }
              }
            }
          }
          label790:
          j = i;
          if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 3)
          {
            paramc = d(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.bgMd5, null);
            j = i;
            if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.g(paramc))
            {
              j = 1;
              this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 2;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.clearTask();
          continue;
          label1186:
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.clearTask();
          j = i;
        }
        label1198:
        break;
        paramInt = i;
      }
      label1206:
      localObject2 = null;
      localObject1 = null;
      localBitmap1 = null;
    }
  }
  
  public void a(submsgtype0x78.MsgBody paramMsgBody)
  {
    boolean bool = paramMsgBody.uint32_version.has();
    int i = paramMsgBody.uint32_version.get();
    int j = getVersion();
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handlePush, " + bool + ", " + j + ", " + i);
    }
  }
  
  void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.isDestroyed) {
      try
      {
        if (!this.isDestroyed) {
          if (!paramBoolean) {
            break label46;
          }
        }
        label46:
        for (Handler localHandler = this.mUiHandler;; localHandler = this.mSubHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  protected boolean a(RedPacketConfig paramRedPacketConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "saveRedPacketConfig");
    }
    if (paramRedPacketConfig == null) {
      return false;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramRedPacketConfig);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return aqhq.a(new File(this.mCtx.getFilesDir(), "red_packet_config2017_" + this.mApp.getAccount()).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (Throwable paramRedPacketConfig)
    {
      paramRedPacketConfig.printStackTrace();
    }
    return false;
  }
  
  public boolean ate()
  {
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    long l1;
    if (afO > 0L)
    {
      l1 = afO;
      long l3 = afQ;
      l2 = (l2 - afP) * l3 + l1;
    }
    for (;;)
    {
      boolean bool = NetworkUtils.isNetworkAvailable(this.mCtx);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder(128);
        ((StringBuilder)localObject2).append("grabHongbao").append(", ").append(bool);
        if (localObject1 != null) {
          ((StringBuilder)localObject2).append(", ").append(((PortalConfig)localObject1).id).append(", ").append(((PortalConfig)localObject1).type).append(", ").append(((PortalConfig)localObject1).useFlag).append(", ").append(((PortalConfig)localObject1).useTime).append(", ").append(l2).append(", ").append(((PortalConfig)localObject1).currentCountGrab);
        }
        QLog.e("PortalManager", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 == null) || (((PortalConfig)localObject1).type == 1)) {}
      label267:
      do
      {
        return false;
        localObject2 = (ArrayList)this.l.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
        if (localObject2 != null) {
          break;
        }
        localObject2 = new ArrayList(60);
        ((ArrayList)localObject2).add(Long.valueOf(l2));
        this.l.put(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id, localObject2);
        if (this.l.size() > 1) {
          dEz();
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        i = localPortalConfig.countGrab + 1;
        localPortalConfig.countGrab = i;
        ((PortalConfig)localObject2).currentCountGrab = i;
        if (!this.mSubHandler.hasMessages(6)) {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        }
        if (((PortalConfig)localObject1).type != 3) {
          break label439;
        }
      } while (((PortalConfig)localObject1).useFlag >= 4);
      int i = 1;
      for (;;)
      {
        if (i != 0)
        {
          localObject1 = new d();
          ((d)localObject1).detailUrl = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hotUrl;
          ((d)localObject1).showType = 2;
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.a(1, (d)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useFlag = 4;
          a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return false;
          ((ArrayList)localObject2).add(Long.valueOf(l2));
          break label267;
          label439:
          if (!((PortalConfig)localObject1).isOver(l2)) {
            break label783;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.hotUrl)) || (((PortalConfig)localObject1).useFlag >= 4)) {
            break;
          }
          i = 1;
          continue;
        }
        if (!bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.a(false, akzx.bUV, null);
          return false;
        }
        if (this.mLastRequestTime >= 0L)
        {
          localObject1 = this.mApp.a(ServerConfigManager.ConfigType.common, "GetNewPackReq_DelayTime");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label776;
          }
        }
        for (;;)
        {
          try
          {
            l1 = Long.valueOf((String)localObject1).longValue();
            l1 *= 1000L;
            if ((l1 <= 30000L) || (l1 >= 300000L)) {
              break label776;
            }
          }
          catch (Exception localException)
          {
            QLog.e("PortalManager", 1, (String)localObject1, localException);
            l1 = 30000L;
            continue;
          }
          if ((Math.abs(l2 - this.mLastRequestTime) < l1) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.currentCountGrab <= dqL))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PortalManager", 2, "grabHongbao, " + l2 + ", " + this.mLastRequestTime + "," + l1);
            }
            return true;
            if ((this.mLastRequestTime < 0L) && ((this.mLastRequestTime + l2 < afJ) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.currentCountGrab <= dqL)))
            {
              if (!this.mUiHandler.hasMessages(13)) {
                a(true, 13, (1200.0D + Math.random() * 2300.0D), null);
              }
              return true;
            }
          }
          this.mLastRequestTime = l2;
          if (cvz) {
            RedPacketServlet.h(this.mApp, 1001);
          }
          for (;;)
          {
            return true;
            RedPacketServlet.h(this.mApp, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
          }
          label776:
          l1 = 30000L;
        }
        label783:
        i = 0;
      }
    }
  }
  
  public boolean atf()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 2);
  }
  
  public void bH(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, playSound, " + paramInt + ", " + this.mh[paramInt] + ", " + u[paramInt] + ", mPlayCountDownStreamId=" + this.dqM + ", mPlayCountDownState=" + this.dqN);
    }
    try
    {
      if (this.jdField_c_of_type_AndroidMediaSoundPool == null)
      {
        this.jdField_c_of_type_AndroidMediaSoundPool = new SoundPool(10, 3, 0);
        this.jdField_c_of_type_AndroidMediaSoundPool.setOnLoadCompleteListener(this);
      }
      if (paramInt == 2)
      {
        if ((this.dqN != 4) || (!paramBoolean))
        {
          if ((this.dqN == 1) && (!paramBoolean)) {
            return;
          }
          this.dqN = 1;
        }
      }
      else
      {
        i = this.mh[paramInt];
        if (i == 0)
        {
          i = this.jdField_c_of_type_AndroidMediaSoundPool.load(this.mApp.getApp().getApplicationContext(), mi[paramInt], 1);
          this.mh[paramInt] = i;
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      if (QLog.isColorLevel())
      {
        QLog.d("PortalManager", 2, "playSound, throwable=" + localThrowable.getMessage());
        localThrowable.printStackTrace();
        return;
        if (u[paramInt] != 0) {
          if (paramInt == 2) {}
        }
        for (i = this.jdField_c_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 1, 0, 1.0F); QLog.isColorLevel(); i = -1)
        {
          QLog.d("PortalManager", 2, "playSound, " + paramInt + ", " + this.mh[paramInt] + ", " + u[paramInt] + ", " + i + ", mPlayCountDownStreamId=" + this.dqM);
          return;
          if (this.dqM == 0) {
            this.dqM = this.jdField_c_of_type_AndroidMediaSoundPool.play(i, 1.0F, 1.0F, 10, -1, 1.0F);
          }
        }
      }
    }
  }
  
  public void clearData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "clearData");
    }
    File localFile = new File(BaseApplicationImpl.sApplication.getFilesDir(), "red_packet_config2017_" + this.mApp.getAccount());
    if ((localFile.delete()) && (!localFile.delete()) && (localFile.delete())) {}
  }
  
  public void dEA()
  {
    a(true, 100, 0L, null);
  }
  
  public void dEB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, stopCountDown, mPlayCountDownStreamId=" + this.dqM + ", mPlayCountDownState=" + this.dqN);
    }
    if (this.dqN == 4) {
      return;
    }
    if (this.dqM != 0) {}
    try
    {
      if (this.jdField_c_of_type_AndroidMediaSoundPool != null) {
        this.jdField_c_of_type_AndroidMediaSoundPool.pause(this.dqM);
      }
      label83:
      this.dqM = 0;
      this.dqN = 4;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  public void dEC()
  {
    ArrayList localArrayList;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
    {
      localArrayList = (ArrayList)this.m.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id);
      if (localArrayList != null) {
        break label138;
      }
      localArrayList = new ArrayList(60);
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      this.m.put(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id, localArrayList);
    }
    for (;;)
    {
      if (!this.mSubHandler.hasMessages(15)) {
        this.mSubHandler.sendEmptyMessageDelayed(15, 600000L);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type == 1) {
        anot.a(this.mApp, "dc01440", "", "", "0X80077E4", "0X80077E4", 0, 0, "", "", "", "");
      }
      return;
      label138:
      localArrayList.add(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
    }
  }
  
  public void dED()
  {
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (!this.cvA))
    {
      localQQAppInterface = this.mApp;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
        break label66;
      }
    }
    label66:
    for (String str = "1";; str = "2")
    {
      anot.a(localQQAppInterface, "dc01440", "", "", "0X80077E2", "0X80077E2", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void dEE()
  {
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)
    {
      localQQAppInterface = this.mApp;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.type != 1) {
        break label59;
      }
    }
    label59:
    for (String str = "1";; str = "2")
    {
      anot.a(localQQAppInterface, "dc01440", "", "", "0X80077E3", "0X80077E3", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void dEy()
  {
    this.cvA = false;
    dEB();
    a(true, 100, 0L, null);
    if (!this.mUiHandler.hasMessages(16)) {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label128;
      }
    }
    label128:
    for (long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.useTime).longValue();; l1 = 10000L)
    {
      a(true, 16, 1000L, Long.valueOf(l1));
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
        QLog.d("PortalManager", 2, "setGrabTimeFinish activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      }
      return;
    }
  }
  
  public void eL(Context paramContext) {}
  
  public int getVersion()
  {
    RedPacketConfig localRedPacketConfig2 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
    RedPacketConfig localRedPacketConfig1 = localRedPacketConfig2;
    if (localRedPacketConfig2 == null) {
      localRedPacketConfig1 = a();
    }
    return localRedPacketConfig1.version;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "handleMessage " + paramMessage.what + ", " + paramMessage.obj);
    }
    long l1 = 0L;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      for (;;)
      {
        return false;
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig == null) && (NetConnInfoCenter.servetTimeSecondInterv != 0L)) {
          a();
        }
        cRa();
      }
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) {
        return true;
      }
    case 3: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig;
      localObject2 = (RedPacketConfig)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig = ((RedPacketConfig)localObject2);
      if (localObject2 != null)
      {
        bool2 = a((RedPacketConfig)localObject2, (RedPacketConfig)localObject1, true);
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null)
        {
          v(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.grebInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportActiveInterval, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.reportNormalInterval);
          bool1 = bool2;
        }
        label283:
        l1 = NetConnInfoCenter.getServerTimeMillis();
        kA(l1);
      }
      break;
    }
    for (;;)
    {
      if (paramMessage.what == 5) {}
      for (bool2 = true;; bool2 = false)
      {
        a(null, 3, bool2, l1);
        if (!bool1) {
          break;
        }
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        break;
      }
      if (this.mSubHandler.hasMessages(6)) {
        break;
      }
      a((RedPacketConfig)paramMessage.obj);
      break;
      a(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
      break;
      localObject1 = (c)paramMessage.obj;
      this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c = ((c)localObject1);
      a((c)localObject1, paramMessage.arg1, false, 0L);
      break;
      dEy();
      if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
        break;
      }
      QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT | activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      break;
      this.mSubHandler.post(new reportRunnable(this.l.clone(), 1, this.doM, this.doN, Hp(), ((Long)paramMessage.obj).longValue(), false));
      this.doN = 0;
      this.doM = 0;
      this.l.clear();
      if ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null)) {
        break;
      }
      QLog.d("PortalManager", 2, "MSG_GRAB_TIMEOUT_REPORT | activity id:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id + ", total count:" + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.countGrab);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c == null) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c;
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) {}
      for (paramMessage = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.emptyMsg;; paramMessage = acfp.m(2131709813))
      {
        ((c)localObject1).a(false, paramMessage, null);
        break;
      }
      if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof ArrayList))) {
        break;
      }
      localObject1 = this.mApp;
      int i = paramMessage.arg1;
      localObject2 = (ArrayList)paramMessage.obj;
      if (paramMessage.arg2 == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        RedPacketServlet.a((AppRuntime)localObject1, i, (ArrayList)localObject2, bool1, paramMessage.getData());
        break;
      }
      this.mSubHandler.post(new reportRunnable(this.m.clone(), 2, 0, 0, 0, 0L, false));
      this.m.clear();
      this.mSubHandler.removeMessages(15);
      this.mSubHandler.sendEmptyMessageDelayed(15, 600000L);
      break;
      bool1 = false;
      break label283;
      bool1 = false;
    }
  }
  
  public void i(Activity paramActivity, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("clickBanner, ");
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
      {
        localObject = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag + this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.id);
        QLog.i("PortalManager", 2, localObject + ", " + paramBoolean);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag < 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.useFlag = 2;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        a(null, 1, false, 0L);
      }
      if (!paramBoolean) {
        break label336;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl)) {
        break label311;
      }
      if (paramActivity == null) {
        break label268;
      }
      localObject = paramActivity;
      label144:
      localObject = new Intent((Context)localObject, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig.jumpUrl);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).addFlags(67108864);
      if (paramActivity == null) {
        break label275;
      }
      paramActivity.startActivity((Intent)localObject);
    }
    for (;;)
    {
      anot.a(this.mApp, "dc01440", "", "", "0X80077E7", "0X80077E7", 0, 0, "", "", "", "");
      return;
      localObject = "";
      break;
      label268:
      localObject = BaseApplicationImpl.sApplication;
      break label144;
      label275:
      paramActivity = BaseActivity.sTopActivity;
      if (paramActivity != null)
      {
        paramActivity.startActivity((Intent)localObject);
      }
      else
      {
        paramActivity = BaseApplicationImpl.sApplication;
        ((Intent)localObject).addFlags(268435456);
        paramActivity.startActivity((Intent)localObject);
        continue;
        label311:
        if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null)) {
          this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c.atc();
        }
      }
    }
    label336:
    anot.a(this.mApp, "dc01440", "", "", "0X80077E6", "0X80077E6", 0, 0, "", "", "", "");
  }
  
  public void je(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setStarShareFlag, ").append(paramInt1);
      if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig == null) {
        break label101;
      }
    }
    label101:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id;; i = 0)
    {
      QLog.d("PortalManager", 2, i + "," + paramInt2);
      if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.id == paramInt1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.starShareTypeReqState = 2;
        this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig.starShareType = paramInt2;
      }
      return;
    }
  }
  
  public long[] k()
  {
    this.cvA = true;
    PortalConfig localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (afO > 0L)
    {
      long l2 = afO;
      long l3 = afQ;
      l1 = (l1 - afP) * l3 + l2;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("setGrabStartTime");
        if (localPortalConfig != null) {
          localStringBuilder.append(", ").append(localPortalConfig.id).append(", ").append(localPortalConfig.type).append(", ").append(localPortalConfig.useTime).append(", ").append(localPortalConfig.countTime).append(", ").append(l1).append(", ").append(localPortalConfig.realEnd);
        }
        QLog.d("PortalManager", 2, localStringBuilder.toString());
      }
      if ((localPortalConfig == null) || (localPortalConfig.type != 2) || ((localPortalConfig.useTime == 0L) && (localPortalConfig.countTime + l1 >= localPortalConfig.realEnd)) || ((localPortalConfig.useTime > 0L) && (localPortalConfig.useTime + localPortalConfig.countTime >= localPortalConfig.realEnd)) || ((localPortalConfig.useTime > 0L) && (localPortalConfig.useTime + localPortalConfig.countTime <= l1)) || (l1 > localPortalConfig.realEnd)) {
        return null;
      }
      if (localPortalConfig.useTime == 0L)
      {
        localPortalConfig.useTime = l1;
        a(false, 6, 1000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
        anot.a(this.mApp, "dc01440", "", "", "0X80077E8", "0X80077E8", 0, 0, "", "", l1 + "", "");
        anot.a(this.mApp, "dc01440", "", "", "0X80077EB", "0X80077EB", 0, 0, Ho() + "", "", "", "");
      }
      l1 = localPortalConfig.countTime - l1 + localPortalConfig.useTime;
      this.mUiHandler.removeMessages(12);
      a(true, 12, l1, Long.valueOf(localPortalConfig.useTime));
      return new long[] { localPortalConfig.countTime, l1 };
    }
  }
  
  public boolean nV(String paramString)
  {
    PortalConfig localPortalConfig = null;
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "isShowYYBao, url=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return true;
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    int i;
    Object localObject;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.size();
      if (i > 0)
      {
        localObject = (PortalConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.get(0);
        localPortalConfig = (PortalConfig)this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.get(this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig.portalConfigs.size() - 1);
        if ((localObject != null) && (localPortalConfig != null) && (((PortalConfig)localObject).realBegin <= l1) && (l1 <= localPortalConfig.realEnd))
        {
          paramString = aurr.getArgumentsFromURL(paramString);
          if ((paramString != null) && ("redpacket2017".equalsIgnoreCase((String)paramString.get("from"))))
          {
            bool = false;
            paramString = (String)localObject;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("isShowYYBao, ").append(bool).append(",").append(l1).append(",").append(i).append(", startpor=");
        if (paramString == null) {
          break label348;
        }
        paramString = paramString.id + "," + paramString.realBegin;
        localObject = ((StringBuilder)localObject).append(paramString).append(", endpor=");
        if (localPortalConfig == null) {
          break label355;
        }
      }
      label348:
      label355:
      for (paramString = localPortalConfig.id + "," + localPortalConfig.realEnd;; paramString = "")
      {
        QLog.d("PortalManager", 2, paramString);
        return bool;
        paramString = "";
        break;
      }
      bool = true;
      paramString = (String)localObject;
      continue;
      paramString = null;
      bool = true;
      continue;
      i = -1;
      bool = true;
      paramString = null;
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 323	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +13 -> 18
    //   8: ldc_w 299
    //   11: iconst_2
    //   12: ldc_w 2027
    //   15: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 1167	com/tencent/mobileqq/portal/PortalManager:isDestroyed	Z
    //   23: aload_0
    //   24: getfield 311	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig	Lcom/tencent/mobileqq/portal/PortalManager$PortalConfig;
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 196	com/tencent/mobileqq/portal/PortalManager:l	Landroid/support/v4/util/SparseArrayCompat;
    //   32: invokevirtual 1415	android/support/v4/util/SparseArrayCompat:size	()I
    //   35: ifle +60 -> 95
    //   38: aload_1
    //   39: getfield 1154	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifle +51 -> 95
    //   47: aload_0
    //   48: getfield 250	com/tencent/mobileqq/portal/PortalManager:mSubHandler	Landroid/os/Handler;
    //   51: new 49	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   54: dup
    //   55: aload_0
    //   56: aload_0
    //   57: getfield 196	com/tencent/mobileqq/portal/PortalManager:l	Landroid/support/v4/util/SparseArrayCompat;
    //   60: invokevirtual 1908	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   63: iconst_1
    //   64: aload_0
    //   65: getfield 1910	com/tencent/mobileqq/portal/PortalManager:doM	I
    //   68: aload_0
    //   69: getfield 1912	com/tencent/mobileqq/portal/PortalManager:doN	I
    //   72: aload_0
    //   73: invokespecial 1914	com/tencent/mobileqq/portal/PortalManager:Hp	()I
    //   76: aload_1
    //   77: getfield 1154	com/tencent/mobileqq/portal/PortalManager$PortalConfig:useTime	J
    //   80: iconst_1
    //   81: invokespecial 1917	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   84: invokevirtual 1921	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: aload_0
    //   89: getfield 196	com/tencent/mobileqq/portal/PortalManager:l	Landroid/support/v4/util/SparseArrayCompat;
    //   92: invokevirtual 1922	android/support/v4/util/SparseArrayCompat:clear	()V
    //   95: aload_0
    //   96: getfield 215	com/tencent/mobileqq/portal/PortalManager:m	Landroid/support/v4/util/SparseArrayCompat;
    //   99: invokevirtual 1415	android/support/v4/util/SparseArrayCompat:size	()I
    //   102: ifle +39 -> 141
    //   105: aload_0
    //   106: getfield 250	com/tencent/mobileqq/portal/PortalManager:mSubHandler	Landroid/os/Handler;
    //   109: new 49	com/tencent/mobileqq/portal/PortalManager$reportRunnable
    //   112: dup
    //   113: aload_0
    //   114: aload_0
    //   115: getfield 215	com/tencent/mobileqq/portal/PortalManager:m	Landroid/support/v4/util/SparseArrayCompat;
    //   118: invokevirtual 1908	android/support/v4/util/SparseArrayCompat:clone	()Landroid/support/v4/util/SparseArrayCompat;
    //   121: iconst_2
    //   122: iconst_0
    //   123: iconst_0
    //   124: iconst_0
    //   125: lconst_0
    //   126: iconst_1
    //   127: invokespecial 1917	com/tencent/mobileqq/portal/PortalManager$reportRunnable:<init>	(Lcom/tencent/mobileqq/portal/PortalManager;Landroid/support/v4/util/SparseArrayCompat;IIIIJZ)V
    //   130: invokevirtual 1921	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   133: pop
    //   134: aload_0
    //   135: getfield 215	com/tencent/mobileqq/portal/PortalManager:m	Landroid/support/v4/util/SparseArrayCompat;
    //   138: invokevirtual 1922	android/support/v4/util/SparseArrayCompat:clear	()V
    //   141: aload_0
    //   142: getfield 250	com/tencent/mobileqq/portal/PortalManager:mSubHandler	Landroid/os/Handler;
    //   145: iconst_1
    //   146: invokevirtual 1454	android/os/Handler:removeMessages	(I)V
    //   149: aload_0
    //   150: getfield 250	com/tencent/mobileqq/portal/PortalManager:mSubHandler	Landroid/os/Handler;
    //   153: bipush 15
    //   155: invokevirtual 1454	android/os/Handler:removeMessages	(I)V
    //   158: aload_0
    //   159: getfield 257	com/tencent/mobileqq/portal/PortalManager:mUiHandler	Landroid/os/Handler;
    //   162: aconst_null
    //   163: invokevirtual 2030	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   166: aload_0
    //   167: getfield 229	com/tencent/mobileqq/portal/PortalManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   170: aload_0
    //   171: invokevirtual 2033	com/tencent/mobileqq/app/QQAppInterface:unRegistObserver	(Lmqq/observer/BusinessObserver;)V
    //   174: aload_0
    //   175: getfield 229	com/tencent/mobileqq/portal/PortalManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   178: aload_0
    //   179: getfield 227	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_Acfd	Lacfd;
    //   182: invokevirtual 2036	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lacci;)V
    //   185: aload_0
    //   186: invokevirtual 1866	com/tencent/mobileqq/portal/PortalManager:dEB	()V
    //   189: aload_0
    //   190: getfield 229	com/tencent/mobileqq/portal/PortalManager:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   193: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   196: aload_0
    //   197: getfield 268	com/tencent/mobileqq/portal/PortalManager:jdField_a_of_type_ComTencentMobileqqPortalPortalManager$b	Lcom/tencent/mobileqq/portal/PortalManager$b;
    //   200: invokevirtual 2040	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   203: aload_0
    //   204: getfield 1814	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   207: ifnull +15 -> 222
    //   210: aload_0
    //   211: getfield 1814	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   214: invokevirtual 2043	android/media/SoundPool:release	()V
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 1814	com/tencent/mobileqq/portal/PortalManager:jdField_c_of_type_AndroidMediaSoundPool	Landroid/media/SoundPool;
    //   222: aload_0
    //   223: monitorexit
    //   224: return
    //   225: astore_1
    //   226: ldc_w 299
    //   229: iconst_1
    //   230: ldc_w 2027
    //   233: aload_1
    //   234: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: goto -34 -> 203
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	PortalManager
    //   27	50	1	localPortalConfig	PortalConfig
    //   225	9	1	localException	Exception
    //   240	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   189	203	225	java/lang/Exception
    //   2	18	240	finally
    //   18	95	240	finally
    //   95	141	240	finally
    //   141	189	240	finally
    //   189	203	240	finally
    //   203	222	240	finally
    //   226	237	240	finally
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "testplaySound, onLoadComplete, " + paramInt1 + ", " + paramInt2 + ", mPlayCountDownStreamId=" + this.dqM + ", mPlayCountDownState=" + this.dqN);
    }
    int i = 0;
    if ((i >= 5) || (this.mh[i] == paramInt1)) {
      if (i != 5) {
        break label105;
      }
    }
    label105:
    while (paramInt2 != 0)
    {
      return;
      i += 1;
      break;
    }
    u[i] = true;
    bH(i, true);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "onReceive, " + paramInt + ", " + paramBoolean + ", " + paramBundle);
    }
    Object localObject3;
    int i;
    int j;
    boolean bool;
    int k;
    int n;
    PortalConfig localPortalConfig;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localObject3 = paramBundle.getString("k_url");
      i = paramBundle.getInt("k_id", -1);
      int i1 = paramBundle.getInt("k_code", -1);
      j = paramBundle.getInt("k_money", -1);
      int i2 = paramBundle.getInt("k_type", -1);
      bool = paramBundle.getBoolean("k_s_follow", true);
      k = paramBundle.getInt("key_award_id", -1);
      n = paramBundle.getInt("key_promotion_id", -1);
      paramInt = -1;
      if (paramBoolean) {
        this.mLastRequestTime = (-this.mLastRequestTime);
      }
      if (i1 > 0) {
        this.doM += 1;
      }
      if ((paramBoolean) && (i1 == 0))
      {
        this.doN += 1;
        switch (i2)
        {
        default: 
          this.doN -= 1;
          this.doM += 1;
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "onReceive cmd = CMD_RESULT, portId = " + i + ", url = " + (String)localObject3 + ", showType = " + paramInt + ", money = " + j + ", awardId = " + k + ", promotionId = " + n);
          }
          localPortalConfig = a(i);
          if (localPortalConfig == null) {
            paramBoolean = false;
          }
          break;
        }
      }
      break;
    }
    for (;;)
    {
      Object localObject1;
      if ((paramBoolean) && (localPortalConfig != null))
      {
        localObject1 = localPortalConfig.findRealAwardConfigById(k);
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          localObject1 = localPortalConfig.findRealAwardConfigById(n);
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null)
          {
            paramBundle = (Bundle)localObject1;
            paramBoolean = false;
          }
        }
      }
      for (;;)
      {
        Object localObject2 = null;
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = localObject2;
          if (paramBundle != null)
          {
            localObject2 = new d(null, paramBundle.awardTitle, paramBundle.awardMsg, i, paramInt, (String)localObject3, j, bool, k, n);
            localObject3 = localPortalConfig.logoList.iterator();
            label478:
            LogoConfig localLogoConfig;
            do
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localLogoConfig = (LogoConfig)((Iterator)localObject3).next();
            } while (localLogoConfig.logoId != paramBundle.logoId);
            String str = localLogoConfig.logoImageMD5;
            if (localPortalConfig.mode == 1) {}
            for (localObject1 = "hb_icon_path";; localObject1 = "hb_busi_logo_path")
            {
              ((d)localObject2).fK = d(str, (String)localObject1);
              ((d)localObject2).fL = d(localLogoConfig.nameMD5, "hb_name_path");
              break label478;
              paramInt = 0;
              break;
              paramInt = 1;
              break;
              paramBoolean = false;
              break;
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c != null)
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$c;
          if (localPortalConfig != null)
          {
            localObject2 = localPortalConfig.emptyMsg;
            label616:
            ((c)localObject3).a(paramBoolean, (String)localObject2, (d)localObject1);
          }
        }
        else
        {
          if ((!paramBoolean) || (paramBundle == null)) {
            break;
          }
          localPortalConfig.isHit = paramBoolean;
          if (paramInt != 0) {
            break label694;
          }
          localPortalConfig.hbCnt += 1;
        }
        while (!this.mSubHandler.hasMessages(6))
        {
          a(false, 6, 2000L, this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$RedPacketConfig);
          return;
          localObject2 = acfp.m(2131709811);
          break label616;
          label694:
          if (paramInt == 1) {
            localPortalConfig.cardCnt += 1;
          }
        }
        paramInt = paramBundle.getInt("k_code", 2);
        if (paramInt == 3)
        {
          handleMessage(this.mUiHandler.obtainMessage(3, new RedPacketConfig()));
          return;
        }
        if (paramInt == 4)
        {
          paramBundle = (RedPacketConfig)paramBundle.getSerializable("k_cache");
          handleMessage(this.mUiHandler.obtainMessage(3, paramBundle));
          return;
        }
        if ((!paramBoolean) || (paramInt == 2)) {
          break;
        }
        return;
        paramInt = paramBundle.getInt("k_code", -1);
        i = paramBundle.getInt("k_r_type");
        j = paramBundle.getInt("key_seq");
        if ((!paramBoolean) || (paramInt != 0))
        {
          a(i, j, null, paramInt, null);
          return;
        }
        W(i, paramBundle.getString("k_result"), j);
        return;
        continue;
        paramBundle = null;
      }
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    int i = 1;
    boolean bool;
    aoll localaoll;
    Object localObject1;
    HashMap localHashMap;
    int j;
    PortalConfig localPortalConfig;
    if (paramaomh.mResult == 0)
    {
      bool = true;
      localaoll = (aoll)paramaomh.b;
      localObject1 = new File(localaoll.atY);
      Object localObject2 = localaoll.U();
      localHashMap = new HashMap();
      if ((localObject2 == null) || (!(localObject2 instanceof String[]))) {
        break label444;
      }
      localObject2 = (String[])localObject2;
      j = Integer.valueOf(localObject2[0]).intValue();
      localObject2 = localObject2[1];
      if (this.cf.contains(localObject2)) {
        this.cf.remove(localObject2);
      }
      if (bool)
      {
        if (!((String)localObject2).equals(alab.getFileMD5String(((File)localObject1).getAbsolutePath()))) {
          break label423;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$BannerConfig;
        localPortalConfig = this.jdField_a_of_type_ComTencentMobileqqPortalPortalManager$PortalConfig;
        if ((localObject1 == null) || (((BannerConfig)localObject1).id != j)) {
          break label398;
        }
        d((String)localObject2, "hb_banner_path");
        a(true, 5, 0L, null);
        label181:
        if (QLog.isColorLevel()) {
          QLog.i("PortalManager", 2, "onRespMSG_UPDATE_UI, md5 = " + (String)localObject2);
        }
      }
      label215:
      if (QLog.isColorLevel()) {
        QLog.i("PortalManager", 2, "onResp" + localaoll.bZ + ", " + paramaomh.mResult + ", " + paramaomh.mErrCode + ", " + (String)localHashMap.get("param_checkMd5Fail"));
      }
      if (bool) {
        break label453;
      }
      localHashMap.put("param_Url", localaoll.bZ);
      localHashMap.put("param_ResultCode", String.valueOf(paramaomh.mResult));
      localHashMap.put("param_FailCode", String.valueOf(paramaomh.mErrCode));
    }
    for (;;)
    {
      if (i != 0)
      {
        paramaomh = this.mApp.getCurrentAccountUin();
        anpc.a(this.mApp.getApp().getApplicationContext()).collectPerformance(paramaomh, "RedPacketPicDownload", bool, 0L, 0L, localHashMap, "", false);
      }
      return;
      bool = false;
      break;
      label398:
      if ((localPortalConfig == null) || (localPortalConfig.id != j)) {
        break label181;
      }
      a(true, 5, 0L, null);
      break label181;
      label423:
      ((File)localObject1).delete();
      localHashMap.put("param_checkMd5Fail", "checkMd5Fail");
      break label215;
      label444:
      ((File)localObject1).delete();
      break label215;
      label453:
      if (new Random().nextInt(10000) == 1000)
      {
        localHashMap.put("param_Url", localaoll.bZ);
        localHashMap.put("param_ResultCode", String.valueOf(paramaomh.mResult));
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  
  public void v(long paramLong1, long paramLong2, long paramLong3)
  {
    this.mUiHandler.post(new PortalManager.1(this, paramLong1, paramLong2, paramLong3));
  }
  
  public static class AwardConfig
    implements Serializable
  {
    public String addMsg;
    public int awardId;
    public String awardImg;
    public String awardMd5;
    public String awardMsg;
    public String awardTitle = "";
    public int awardType;
    public String ctfBgImg;
    public String ctfBgMd5;
    public int logoId;
    public String publicId;
    public String publicWording;
    public int showPublic;
    public String starImg;
    public String starMd5;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("awardId=").append(this.awardId);
      localStringBuilder.append(", logoId=").append(this.logoId);
      localStringBuilder.append(", awardImg=").append(this.awardImg);
      localStringBuilder.append(", awardMd5=").append(this.awardMd5);
      localStringBuilder.append(", starImg=").append(this.starImg);
      localStringBuilder.append(", starMD5=").append(this.starMd5);
      localStringBuilder.append(", ctfBgImg=").append(this.ctfBgImg);
      localStringBuilder.append(", ctfBgMd5=").append(this.ctfBgMd5);
      localStringBuilder.append(", showPublic=").append(this.showPublic);
      return localStringBuilder.toString();
    }
  }
  
  static class BannerConfig
    extends PortalManager.TimerConfig
  {
    public String bannarMd5;
    public String bannerImg;
    public int id;
    public String jumpUrl;
    public int useFlag;
    
    private BannerConfig()
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=").append(this.id);
      localStringBuilder.append(", bannerImg=").append(this.bannerImg);
      localStringBuilder.append(", bannarMd5=").append(this.bannarMd5);
      localStringBuilder.append(", jumpUrl=").append(this.jumpUrl);
      localStringBuilder.append(", useFlag=").append(this.useFlag);
      return localStringBuilder.toString();
    }
  }
  
  public static class ComboNumber
    implements Serializable
  {
    public String flowerImage2MD5;
    public String flowerImage2Url;
    public String flowerImageMD5;
    public String flowerImageUrl;
    public int number;
    public String numberImageMD5;
    public String numberImageUrl;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("number=").append(this.number).append(", numUrl=").append(this.numberImageUrl).append(", numMd5=").append(this.numberImageMD5).append(", floUrl=").append(this.flowerImageUrl).append(", floMd5=").append(this.flowerImageMD5).append(", flo2Url=").append(this.flowerImage2Url).append(", flo2Md5=").append(this.flowerImage2MD5);
      return localStringBuilder.toString();
    }
  }
  
  public static class LogoConfig
    implements Serializable
  {
    public String greetImageMD5;
    public String greetImageUrl;
    public int logoId;
    public String logoImageMD5;
    public String logoImageUrl;
    public String nameMD5;
    public String nameUrl;
    public String padantImageMD5;
    public String padantImageUrl;
    public String relationCompanyLogoMD5;
    public String relationCompanyLogoUrl;
    public String relationCompanyNameMD5;
    public String relationCompanyNameUrl;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("logoImageUrl=").append(this.logoImageUrl);
      localStringBuilder.append(", logoImageMD5=").append(this.logoImageMD5);
      localStringBuilder.append(", nameUrl=").append(this.nameUrl);
      localStringBuilder.append(", nameMD5=").append(this.nameMD5);
      localStringBuilder.append(", greetImageUrl=").append(this.greetImageUrl);
      localStringBuilder.append(", greetImageMD5=").append(this.greetImageMD5);
      localStringBuilder.append(", padantImageUrl=").append(this.padantImageUrl);
      localStringBuilder.append(", padantImageMD5=").append(this.padantImageMD5);
      localStringBuilder.append(", relationCompanyLogoUrl=").append(this.relationCompanyLogoUrl);
      localStringBuilder.append(", relationCompanyLogoMD5=").append(this.relationCompanyLogoMD5);
      localStringBuilder.append(", relationCompanyNameUrl=").append(this.relationCompanyNameUrl);
      localStringBuilder.append(", relationCompanyNameMD5=").append(this.relationCompanyNameMD5);
      localStringBuilder.append(", logoId=").append(this.logoId);
      return localStringBuilder.toString();
    }
  }
  
  public static class PortalConfig
    extends PortalManager.TimerConfig
  {
    public String actEndWording;
    public String activityTime;
    List<PortalManager.AwardConfig> awardConfigList = new ArrayList();
    public String bgImg;
    public String bgMd5;
    public int cardCnt;
    public int continuousRecord;
    public String countDownTips;
    public int countGrab;
    public long countTime;
    public transient int currentCountGrab;
    public String emptyMsg;
    public String grabMsg;
    public int hbCnt;
    public String hotAddMsg;
    public String hotImg;
    public String hotMd5;
    public String hotPublicId;
    public String hotTopic;
    public String hotUrl;
    public int id;
    public boolean isHit;
    public String leftCloudImageMD5;
    public String leftCloudImageUrl;
    List<PortalManager.LogoConfig> logoList = new ArrayList();
    public int mode;
    public String nextActTime;
    public long realBegin;
    public long realEnd;
    public String rightCloudImageMD5;
    public String rightCloudImageURL;
    public String rightMsg;
    public long scrollTime;
    public String shareImageMD5;
    public String shareImageUrl;
    public String shareStarImageMD5;
    public String shareStarImageUrl;
    public String shareWording = "";
    public long showSharePageTime;
    public String starGuiderPhotoMD5;
    public String starGuiderPhotoURL;
    public int starLucytype;
    public int starNoLucyType;
    public transient int starShareType = -1;
    public transient int starShareTypeReqState = 0;
    public String structMsgContentForScore = "";
    public String structMsgContentForStar = "";
    public String structMsgTitleForScore = "";
    public String structMsgTitleForStar = "";
    public String summaryForScore = "";
    public String summaryForStar = "";
    public int type;
    public int useFlag;
    public long useTime;
    public String wishingMsg;
    
    public PortalConfig()
    {
      super();
    }
    
    public PortalManager.AwardConfig findRealAwardConfigById(long paramLong)
    {
      if ((this.awardConfigList != null) && (!this.awardConfigList.isEmpty()))
      {
        Iterator localIterator = this.awardConfigList.iterator();
        while (localIterator.hasNext())
        {
          PortalManager.AwardConfig localAwardConfig = (PortalManager.AwardConfig)localIterator.next();
          if ((localAwardConfig != null) && (localAwardConfig.awardId == paramLong)) {
            return localAwardConfig;
          }
        }
      }
      return null;
    }
    
    public boolean isOver(long paramLong)
    {
      return (this.useTime != 0L) && (paramLong > this.useTime + this.countTime);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=").append(this.id);
      localStringBuilder.append(", type=").append(this.type);
      localStringBuilder.append(", mode=").append(this.mode);
      localStringBuilder.append(", countTime=").append(this.countTime);
      localStringBuilder.append(", realBegin=").append(this.realBegin);
      localStringBuilder.append(", realEnd=").append(this.realEnd);
      localStringBuilder.append(", useFlag=").append(this.useFlag);
      localStringBuilder.append(", logoList=").append(this.logoList);
      localStringBuilder.append(", awardConfigList=").append(this.awardConfigList);
      localStringBuilder.append(", starLucytype=").append(this.starLucytype);
      localStringBuilder.append(", starNoLucyType=").append(this.starNoLucyType);
      localStringBuilder.append(", shareType=").append(this.starShareType);
      return localStringBuilder.toString();
    }
  }
  
  public static class RedPacketConfig
    implements Serializable
  {
    public ArrayList<PortalManager.BannerConfig> bannerConfigs = new ArrayList();
    public ArrayList<PortalManager.ComboNumber> comboNumberConfigs = new ArrayList();
    public long grebInterval = -1L;
    public int id;
    public long lastGrabTime;
    public ArrayList<PortalManager.PortalConfig> portalConfigs = new ArrayList();
    public long reportActiveInterval = -1L;
    public long reportNormalInterval = -1L;
    public int shareBaseLine;
    public long showGesturesTime;
    public int taskId;
    public int version;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareBaseLine=").append(this.shareBaseLine);
      localStringBuilder.append(", portalConfigs=").append(this.portalConfigs);
      localStringBuilder.append(", comboNumberConfigs=").append(this.comboNumberConfigs);
      localStringBuilder.append(", bannerConfigs=").append(this.bannerConfigs);
      return localStringBuilder.toString();
    }
  }
  
  public static class TimerConfig
    implements Serializable
  {
    public long uiBegin;
    public long uiEnd;
  }
  
  public static class a
  {
    public String key;
    public int reqType;
    public int seq;
  }
  
  class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 1;
      int i = 1;
      int k = paramIntent.getIntExtra("portal_type_key", -1);
      int m = paramIntent.getIntExtra("bc_seq", -1);
      paramContext = paramIntent.getStringExtra("portal_agrs");
      if (QLog.isColorLevel()) {
        QLog.i("PortalManager", 2, "PortalSwictherReceiver, " + paramIntent.getExtras());
      }
      Object localObject;
      int n;
      switch (k)
      {
      default: 
      case 1010: 
      case 1011: 
        do
        {
          return;
          try
          {
            paramContext = new JSONObject();
            paramIntent = paramContext.put("errorCode", 0);
            if (PortalManager.this.Ho() != -1)
            {
              paramIntent.put("result", i);
              PortalManager.a(PortalManager.this, k, paramContext.toString(), m);
              return;
            }
          }
          catch (JSONException paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
              try
              {
                paramContext = new JSONObject();
                paramContext.put("errorCode", -1);
                PortalManager.a(PortalManager.this, k, paramContext.toString(), m);
                return;
              }
              catch (JSONException paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
              i = 0;
            }
            if (!TextUtils.isEmpty(paramContext)) {
              break;
            }
            PortalManager.a(PortalManager.this, k, m, null, -1, "params is null");
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("PortalManager", 2, "", paramContext);
        return;
        paramContext = new JSONObject(paramContext);
        paramIntent = paramContext.getString("key");
        localObject = alab.mH(paramIntent);
        localObject = aqgv.C(PortalManager.a(PortalManager.this), (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramContext.put("errorCode", 0).put("result", localObject).put("key", paramIntent);
        }
        for (;;)
        {
          PortalManager.a(PortalManager.this, k, paramContext.toString(), m);
          return;
          paramContext.put("errorCode", -1).put("key", paramIntent);
        }
      case 1008: 
        if (TextUtils.isEmpty(paramContext))
        {
          PortalManager.a(PortalManager.this, k, m, null, -1, "params is null");
          return;
        }
        paramContext = new JSONObject(paramContext);
        int i1 = paramContext.getInt("type");
        n = paramContext.getInt("count");
        i = j;
        switch (i1)
        {
        }
        break;
      }
      for (;;)
      {
        RedPacketServlet.a(PortalManager.a(PortalManager.this), i, n, k, m);
        return;
        if (TextUtils.isEmpty(paramContext))
        {
          PortalManager.a(PortalManager.this, k, m, null, -1, "params is null");
          return;
        }
        paramContext = new JSONObject(paramContext).getString("key");
        if (!TextUtils.isEmpty(paramContext))
        {
          paramIntent = alab.mH(paramContext);
          localObject = PortalManager.a(PortalManager.this).getFaceBitmap(paramIntent, false);
          if (localObject != null)
          {
            paramIntent = alab.h((Bitmap)localObject);
            localObject = new JSONObject();
            ((JSONObject)localObject).put("errorCode", 0);
            ((JSONObject)localObject).put("key", paramContext);
            ((JSONObject)localObject).put("result", paramIntent);
            PortalManager.a(PortalManager.this, k, ((JSONObject)localObject).toString(), m);
            return;
          }
          localObject = new PortalManager.a();
          ((PortalManager.a)localObject).key = paramContext;
          ((PortalManager.a)localObject).reqType = k;
          ((PortalManager.a)localObject).seq = m;
          PortalManager.this.gw.put(paramIntent, localObject);
          if ((PortalManager.a(PortalManager.this).getFaceBitmap(paramIntent, true) != null) || (!QLog.isColorLevel())) {
            break;
          }
          paramIntent = aqgv.A(PortalManager.a(PortalManager.this), String.valueOf(paramIntent));
          QLog.d("PortalManager", 2, "昵称为" + paramIntent + "，本地不存在头像，key = " + paramContext);
          return;
        }
        PortalManager.a(PortalManager.this, k, m, null, -1, "key is null");
        return;
        i = j;
        continue;
        i = 2;
        continue;
        i = 3;
      }
    }
  }
  
  public static class c
  {
    public void a(int paramInt, PortalManager.d paramd) {}
    
    public void a(long paramLong1, int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, List<PortalManager.LogoConfig> paramList, String paramString, long paramLong2, boolean paramBoolean, long paramLong3) {}
    
    public void a(long paramLong1, int paramInt1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean, int paramInt2, Bitmap paramBitmap4, Bitmap paramBitmap5, List<PortalManager.LogoConfig> paramList, List<PortalManager.ComboNumber> paramList1, Bitmap paramBitmap6, long paramLong3, Bitmap paramBitmap7, Bitmap paramBitmap8) {}
    
    public void a(boolean paramBoolean, String paramString, PortalManager.d paramd) {}
    
    public boolean atc()
    {
      return false;
    }
    
    public boolean ath()
    {
      return false;
    }
    
    public void clearTask() {}
    
    public void cun() {}
    
    public boolean g(Bitmap paramBitmap)
    {
      return false;
    }
    
    public boolean g(Bitmap paramBitmap, String paramString)
    {
      return false;
    }
  }
  
  public static class d
  {
    public String aNx;
    public String awT;
    public int awardId;
    public String bUY;
    public String bUZ;
    public String bVa;
    public boolean cvC;
    public String detailUrl;
    public int dqA;
    public int dqO;
    public int dqP;
    public Bitmap fJ;
    public Bitmap fK;
    public Bitmap fL;
    public int money;
    public int showType;
    public int taskId;
    public String tips;
    public String wishing;
    
    public d() {}
    
    public d(Bitmap paramBitmap, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
    {
      this.fJ = paramBitmap;
      this.bVa = paramString1;
      this.wishing = paramString2;
      this.taskId = paramInt1;
      this.showType = paramInt2;
      this.detailUrl = paramString3;
      this.money = paramInt3;
      this.cvC = paramBoolean;
      this.awardId = paramInt4;
      this.dqO = paramInt5;
    }
  }
  
  public class reportRunnable
    implements Runnable
  {
    private long aed;
    private boolean cue;
    private int doP;
    private int doQ;
    private int dqQ;
    private int mType;
    private SparseArrayCompat<ArrayList<Long>> n;
    
    public reportRunnable(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, boolean paramBoolean)
    {
      this.n = paramInt1;
      this.mType = paramInt2;
      this.doP = paramInt3;
      this.doQ = paramInt4;
      this.dqQ = paramLong;
      this.aed = ???;
      boolean bool1;
      this.cue = bool1;
    }
    
    public void run()
    {
      if ((this.n == null) || (this.n.size() <= 0)) {
        return;
      }
      int i = 0;
      label20:
      Object localObject1;
      Object localObject2;
      int j;
      label171:
      int k;
      if (i < this.n.size())
      {
        localObject1 = new ArrayList(100);
        localObject2 = new aure(60);
        int m = this.n.keyAt(i);
        Object localObject3 = ((ArrayList)this.n.get(m)).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject3).next();
          if (this.mType == 1) {}
          for (j = 1000;; j = 60000)
          {
            l = localLong.longValue() / j * j;
            if (((aure)localObject2).get(l) == null) {
              break label171;
            }
            ((aure)localObject2).put(l, Integer.valueOf(((Integer)((aure)localObject2).get(l)).intValue() + 1));
            break;
          }
          ((aure)localObject2).put(l, Integer.valueOf(1));
        }
        k = 0;
        j = 0;
        while (k < ((aure)localObject2).size())
        {
          localObject3 = new RedPacketServlet.BrashReportItem();
          l = ((aure)localObject2).keyAt(k);
          ((RedPacketServlet.BrashReportItem)localObject3).time = l;
          ((RedPacketServlet.BrashReportItem)localObject3).count = ((int)((Integer)((aure)localObject2).get(l)).intValue());
          ((ArrayList)localObject1).add(localObject3);
          j += ((RedPacketServlet.BrashReportItem)localObject3).count;
          k += 1;
        }
        localObject2 = PortalManager.a(PortalManager.this);
        if (this.mType != 1) {
          break label510;
        }
        k = 1;
        label284:
        localObject2 = ((Handler)localObject2).obtainMessage(14, m, k, localObject1);
        if (this.mType == 1)
        {
          localObject3 = new Bundle();
          if (this.doP > 0) {
            ((Bundle)localObject3).putInt("k_e_ctr", this.doP);
          }
          if (this.doQ > 0) {
            ((Bundle)localObject3).putInt("k_h_ctr", this.doQ);
          }
          if (this.dqQ > 0) {
            ((Bundle)localObject3).putInt("k_c_ctr", this.dqQ);
          }
          ((Bundle)localObject3).putLong("k_s_time", this.aed);
          ((Message)localObject2).setData((Bundle)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("PortalManager", 2, "reportRunnable " + this.doP + ", " + this.doQ + ", " + this.dqQ + ", " + j);
          }
        }
        if (!this.cue) {
          break label521;
        }
        localObject3 = PortalManager.a(PortalManager.this);
        j = ((Message)localObject2).arg1;
        if (((Message)localObject2).arg2 != 1) {
          break label515;
        }
        bool = true;
        RedPacketServlet.a((AppRuntime)localObject3, j, (ArrayList)localObject1, bool, ((Message)localObject2).getData());
      }
      label510:
      while (PortalManager.a(PortalManager.this)) {
        for (;;)
        {
          i += 1;
          break label20;
          break;
          k = 0;
          break label284;
          boolean bool = false;
        }
      }
      label515:
      label521:
      if (this.mType == 1)
      {
        l = PortalManager.afK;
        label544:
        j = (int)l;
        localObject1 = PortalManager.a(PortalManager.this);
        if (j > 0) {
          break label585;
        }
      }
      label585:
      for (long l = 0L;; l = new Random().nextInt(j))
      {
        ((Handler)localObject1).sendMessageDelayed((Message)localObject2, l);
        break;
        l = PortalManager.afL;
        break label544;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager
 * JD-Core Version:    0.7.0.1
 */