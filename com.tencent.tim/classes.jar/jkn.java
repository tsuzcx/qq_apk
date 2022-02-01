import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class jkn
{
  private static final String SE = acfp.m(2131710315);
  private static String SF;
  private static jkn.b a;
  private static int aAA;
  private static int aAB;
  private static int aAC = -1;
  private static int aAD = -1;
  private static int aAw = -1;
  private static int aAx;
  private static volatile int aAy;
  private static int aAz;
  private static long pW = 1000L;
  private static volatile Boolean y;
  
  static
  {
    aAx = -1;
    aAy = -1;
    aAz = -1;
    aAA = -1;
    aAB = -1;
  }
  
  public static jkn.a a(int paramInt)
  {
    JSONArray localJSONArray = h();
    if (localJSONArray == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        jkn.a locala = new jkn.a();
        locala.priority = 2147483647;
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((localJSONObject.getInt("type") == paramInt) && (localJSONObject.getInt("priority") < locala.priority))
          {
            locala.id = localJSONObject.getInt("id");
            locala.url = localJSONObject.getString("url");
            locala.priority = localJSONObject.getInt("priority");
            locala.sessionType = localJSONObject.getInt("type");
          }
        }
        else if (locala.priority < 2147483647)
        {
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips. highest. id = " + locala.id + ", url = " + locala.url + ", priority = " + locala.priority + ", type = " + locala.sessionType);
          return locala;
        }
      }
      catch (Exception localException)
      {
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips failed. " + QLog.getStackTraceString(localException));
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. getHighestPriorityMoreBtnTips failed. moreBtnTips = null. sessionType = " + paramInt);
        return null;
      }
      i += 1;
    }
  }
  
  public static jkn.b a(String paramString1, String paramString2, String paramString3)
  {
    if (a == null)
    {
      a = new jkn.b(paramString1, paramString2, paramString3);
      paramString3 = EffectConfigBase.a(287, EffectConfigBase.Nk);
      paramString1 = paramString3.getString("screenShareTips", "");
      if (paramString1.equals(""))
      {
        QLog.i("QAVConfigUtils", 1, "screenShareTips not receive");
        return a;
      }
      paramString2 = paramString3.getString("screenTipsHighlight", "");
      if (paramString2.equals(""))
      {
        QLog.i("QAVConfigUtils", 1, "screenTipsHighlight not receive");
        return a;
      }
      paramString3 = paramString3.getString("screenTipsLink", "");
      if (paramString3.equals(""))
      {
        QLog.i("QAVConfigUtils", 1, "screenTipsLink not receive");
        return a;
      }
      a.content = paramString1;
      a.SG = paramString2;
      a.link = paramString3;
      QLog.i("QAVConfigUtils", 1, "sScreenShareSafeTips, content[" + paramString1 + "], highlight[" + paramString2 + "], link[" + paramString3 + "]");
    }
    return a;
  }
  
  public static boolean aF(long paramLong)
  {
    boolean bool = false;
    int i = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("useAADSDeJitterAlgorithmUin", -1);
    if (i <= -1) {}
    for (;;)
    {
      QLog.i("QAVConfigUtils", 1, "JTest. read useAADSDeJitterAlgorithmUin = " + i + ", useAADSDeJitterAlgorithm = " + bool);
      return bool;
      if (paramLong % 10L <= i) {
        bool = true;
      }
    }
  }
  
  public static boolean aG(long paramLong)
  {
    boolean bool = false;
    int i = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("enableAADSDeJitterMaxJDelayUin", -1);
    if (i <= -1) {}
    for (;;)
    {
      QLog.i("QAVConfigUtils", 1, "JTest. read enableAADSDeJitterMaxJDelayUin = " + i + ", enableAADSDeJitterMaxJDelay = " + bool);
      return bool;
      if (paramLong % 10L <= i) {
        bool = true;
      }
    }
  }
  
  private static void axt()
  {
    if ((y == null) || (TextUtils.isEmpty(SF)))
    {
      SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.Nk);
      y = Boolean.valueOf(localSharedPreferences.getBoolean("switchMultiForceUseGroup", false));
      SF = localSharedPreferences.getString("switchMultiForceUseGroupAlertTip", SE);
      if (TextUtils.isEmpty(SF)) {
        SF = SE;
      }
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "initDouble2GroupConfig [" + y + "," + SF + "]");
      }
    }
  }
  
  public static long bU()
  {
    return pW;
  }
  
  private static String c(JSONObject paramJSONObject, String paramString1, String paramString2)
    throws Exception
  {
    if (paramJSONObject.has(paramString1)) {
      paramString2 = paramJSONObject.getString(paramString1);
    }
    return paramString2;
  }
  
  public static String dB(@NonNull String paramString)
  {
    return EffectConfigBase.a(287, EffectConfigBase.Nk).getString(paramString, "");
  }
  
  private static JSONArray h()
  {
    Object localObject = EffectConfigBase.a(287, EffectConfigBase.Nk).getString("moreBtnTips", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray failed. TextUtils.isEmpty(moreBtnTipsJson) = " + TextUtils.isEmpty((CharSequence)localObject));
      return null;
    }
    try
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray. read moreBtnTipsJson = " + (String)localObject);
      localObject = new JSONArray((String)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.i("QAVConfigUtils", 1, "MoreBtnTips. readMoreBtnTipsJsonArray failed. " + QLog.getStackTraceString(localException));
    }
    return null;
  }
  
  public static String hv()
  {
    axt();
    return SF;
  }
  
  public static void kM(String paramString)
  {
    int j = 1;
    int i5 = 1;
    long l1 = 1000L;
    boolean bool3 = true;
    boolean bool6 = true;
    int i3 = -1;
    int i4 = 0;
    int i7 = 0;
    boolean bool4 = false;
    boolean bool10 = false;
    Object localObject1 = SE;
    boolean bool9 = false;
    boolean bool5 = false;
    int i1 = 7;
    int i2 = -1;
    int i11 = -1;
    int i6 = -1;
    Object localObject3 = "";
    Object localObject4 = "";
    Object localObject5 = "";
    Object localObject7 = "";
    boolean bool7 = false;
    boolean bool8 = false;
    Object localObject8 = "";
    String str3 = "";
    int i10 = -1;
    String str5 = "";
    String str4 = "";
    if (QLog.isColorLevel()) {
      QLog.i("QAVConfigUtils", 2, " parseAndSave parse json = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {}
    label4239:
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("isBlueToothSwitchForAndroid")) {
          i = localJSONObject.getInt("isBlueToothSwitchForAndroid");
        }
      }
      catch (Exception localException7)
      {
        try
        {
          JSONObject localJSONObject;
          if (localJSONObject.has("bluetoothDelayTime"))
          {
            long l2 = localJSONObject.getLong("bluetoothDelayTime");
            l1 = l2;
          }
          String str2;
          Object localObject16;
          int i9;
          Object localObject15;
          Object localObject14;
          Object localObject10;
          int i8;
          Object localObject11;
          Object localObject12;
          i = 1;
        }
        catch (Exception localException7)
        {
          try
          {
            if (localJSONObject.has("LowlightAndDenoiseDevice")) {
              bool1 = localJSONObject.getBoolean("LowlightAndDenoiseDevice");
            }
          }
          catch (Exception localException7)
          {
            try
            {
              if (localJSONObject.has("multiVideoSupportNumbers")) {
                j = localJSONObject.getInt("multiVideoSupportNumbers");
              }
            }
            catch (Exception localException7)
            {
              try
              {
                if (localJSONObject.has("SpeedDialScreenStyle")) {
                  k = localJSONObject.getInt("SpeedDialScreenStyle");
                }
              }
              catch (Exception localException7)
              {
                try
                {
                  if (localJSONObject.has("switchMultiForceUseGroup")) {
                    bool2 = localJSONObject.getBoolean("switchMultiForceUseGroup");
                  }
                }
                catch (Exception localException7)
                {
                  try
                  {
                    if (localJSONObject.has("switchMultiForceUseGroupAlertTip"))
                    {
                      localObject2 = localJSONObject.getString("switchMultiForceUseGroupAlertTip");
                      localObject1 = localObject2;
                    }
                    bool2 = false;
                  }
                  catch (Exception localException7)
                  {
                    try
                    {
                      if (localJSONObject.has("useRGB2I420Shader"))
                      {
                        m = localJSONObject.getInt("useRGB2I420Shader");
                        bool3 = bool5;
                        str2 = str4;
                        localObject16 = str5;
                        i9 = i10;
                        localObject15 = str3;
                        localObject14 = localObject8;
                        bool6 = bool7;
                        localObject13 = localObject7;
                        localObject10 = localObject5;
                        localObject6 = localObject4;
                        localObject9 = localObject3;
                        i8 = i6;
                        i5 = i11;
                        i4 = i2;
                        i7 = i1;
                        bool5 = bool9;
                        try
                        {
                          if (localJSONObject.has("isSharpnessSwitch"))
                          {
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i2;
                            i7 = i1;
                            bool5 = bool9;
                            if (localJSONObject.getInt("isSharpnessSwitch") == 1)
                            {
                              bool3 = true;
                              break label4239;
                            }
                          }
                          else
                          {
                            n = i1;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i2;
                            i7 = i1;
                            bool5 = bool3;
                            if (localJSONObject.has("sharpnessFPSThreshold"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i2;
                              i7 = i1;
                              bool5 = bool3;
                              n = localJSONObject.getInt("sharpnessFPSThreshold");
                            }
                            i1 = i2;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i2;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("useAADSDeJitterAlgorithmUin"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i2;
                              i7 = n;
                              bool5 = bool3;
                              i1 = localJSONObject.getInt("useAADSDeJitterAlgorithmUin");
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save useAADSDeJitterAlgorithmUin = " + i1);
                            }
                            i2 = i11;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i8 = i6;
                            i5 = i11;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("enableAADSDeJitterMaxJDelayUin"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i6;
                              i5 = i11;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              i2 = localJSONObject.getInt("enableAADSDeJitterMaxJDelayUin");
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i6;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "JTest. save enableAADSDeJitterMaxJDelayUin = " + i2);
                            }
                            i3 = i6;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i8 = i6;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("upLoadWhenGetNewData"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i6;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              i3 = localJSONObject.getInt("upLoadWhenGetNewData");
                            }
                            localObject2 = localObject3;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject3;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("ptuNewRenderLimit"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject3;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject2 = localJSONObject.getString("ptuNewRenderLimit");
                            }
                            localObject3 = localObject4;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject4;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("moreBtnTips"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject4;
                              localObject9 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject3 = localJSONObject.getJSONArray("moreBtnTips").toString();
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              QLog.i("QAVConfigUtils", 1, "MoreBtnTips. downloaded moreBtnTipsJson = " + (String)localObject3);
                            }
                            localObject4 = localObject5;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject5;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("ptuAfterTreamentLimit"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject5;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject4 = localJSONObject.getString("ptuAfterTreamentLimit");
                            }
                            localObject5 = localObject7;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject7;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("ptuAfterTreamentCanvas"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject7;
                              localObject10 = localObject4;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              localObject5 = localJSONObject.getString("ptuAfterTreamentCanvas");
                            }
                            bool4 = bool8;
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool7;
                            localObject13 = localObject5;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            if (localJSONObject.has("isAllowedControlMicAfterBeMuted"))
                            {
                              str2 = str4;
                              localObject16 = str5;
                              i9 = i10;
                              localObject15 = str3;
                              localObject14 = localObject8;
                              bool6 = bool7;
                              localObject13 = localObject5;
                              localObject10 = localObject4;
                              localObject6 = localObject3;
                              localObject9 = localObject2;
                              i8 = i3;
                              i5 = i2;
                              i4 = i1;
                              i7 = n;
                              bool5 = bool3;
                              bool4 = localJSONObject.getBoolean("isAllowedControlMicAfterBeMuted");
                            }
                          }
                        }
                        catch (Exception localException10)
                        {
                          localObject2 = localObject16;
                          localObject3 = localObject15;
                          localObject4 = localObject14;
                          localObject5 = localObject13;
                          localObject7 = localObject6;
                          localObject8 = localObject9;
                          n = m;
                          i1 = i7;
                          localObject9 = localObject1;
                          bool4 = bool2;
                          i2 = k;
                          i3 = j;
                          bool3 = bool1;
                          localObject13 = localException10;
                          i6 = i;
                          localObject1 = str2;
                          i = i9;
                          bool1 = bool6;
                          localObject6 = localException8;
                          j = i8;
                          k = i5;
                          m = i4;
                          bool2 = bool5;
                          i4 = i2;
                          i2 = i6;
                          localObject12 = localObject13;
                          continue;
                        }
                        try
                        {
                          QLog.i("QAVConfigUtils", 1, "JTest. save isAllowedControlMicAfterBeMuted = " + bool4);
                          localObject7 = localObject8;
                          str2 = str4;
                          localObject16 = str5;
                          i9 = i10;
                          localObject15 = str3;
                          localObject14 = localObject8;
                          bool6 = bool4;
                          localObject13 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (localJSONObject.has("machineMiddleLine"))
                          {
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject8;
                            bool6 = bool4;
                            localObject13 = localObject5;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            localObject7 = localJSONObject.getString("machineMiddleLine");
                          }
                          localObject8 = str3;
                          str2 = str4;
                          localObject16 = str5;
                          i9 = i10;
                          localObject15 = str3;
                          localObject14 = localObject7;
                          bool6 = bool4;
                          localObject13 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (localJSONObject.has("machineHighLine"))
                          {
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = str3;
                            localObject14 = localObject7;
                            bool6 = bool4;
                            localObject13 = localObject5;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            localObject8 = localJSONObject.getString("machineHighLine");
                          }
                          i6 = i10;
                          str2 = str4;
                          localObject16 = str5;
                          i9 = i10;
                          localObject15 = localObject8;
                          localObject14 = localObject7;
                          bool6 = bool4;
                          localObject13 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          if (localJSONObject.has("allowMicLongPressSpeakInMute"))
                          {
                            str2 = str4;
                            localObject16 = str5;
                            i9 = i10;
                            localObject15 = localObject8;
                            localObject14 = localObject7;
                            bool6 = bool4;
                            localObject13 = localObject5;
                            localObject10 = localObject4;
                            localObject6 = localObject3;
                            localObject9 = localObject2;
                            i8 = i3;
                            i5 = i2;
                            i4 = i1;
                            i7 = n;
                            bool5 = bool3;
                            i6 = localJSONObject.getInt("allowMicLongPressSpeakInMute");
                          }
                          str2 = str4;
                          localObject16 = str5;
                          i9 = i6;
                          localObject15 = localObject8;
                          localObject14 = localObject7;
                          bool6 = bool4;
                          localObject13 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          str3 = c(localJSONObject, "screenShareTips", "");
                          str2 = str4;
                          localObject16 = str3;
                          i9 = i6;
                          localObject15 = localObject8;
                          localObject14 = localObject7;
                          bool6 = bool4;
                          localObject13 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          str4 = c(localJSONObject, "screenTipsHighlight", "");
                          str2 = str4;
                          localObject16 = str3;
                          i9 = i6;
                          localObject15 = localObject8;
                          localObject14 = localObject7;
                          bool6 = bool4;
                          localObject13 = localObject5;
                          localObject10 = localObject4;
                          localObject6 = localObject3;
                          localObject9 = localObject2;
                          i8 = i3;
                          i5 = i2;
                          i4 = i1;
                          i7 = n;
                          bool5 = bool3;
                          str5 = c(localJSONObject, "screenTipsLink", "");
                          localObject13 = str5;
                          localObject10 = str4;
                          localObject14 = str3;
                          localObject15 = localObject8;
                          localObject16 = localObject7;
                          bool5 = bool4;
                          i5 = i3;
                          i7 = i2;
                          i8 = i1;
                          bool6 = bool3;
                          i2 = i;
                          bool3 = bool1;
                          i3 = j;
                          i4 = k;
                          bool4 = bool2;
                          localObject9 = localObject1;
                          bool2 = bool6;
                          i1 = n;
                          n = m;
                          m = i8;
                          k = i7;
                          j = i5;
                          localObject8 = localObject2;
                          localObject7 = localObject3;
                          localObject6 = localObject4;
                          bool1 = bool5;
                          localObject4 = localObject16;
                          localObject3 = localObject15;
                          i = i6;
                          localObject2 = localObject14;
                          localObject1 = localObject13;
                          localObject13 = EffectConfigBase.a(287, EffectConfigBase.Nk).edit();
                          ((SharedPreferences.Editor)localObject13).putInt("isBlueToothSwitch", i2);
                          ((SharedPreferences.Editor)localObject13).putLong("bluetoothDelayTime", l1);
                          ((SharedPreferences.Editor)localObject13).putBoolean("LowlightAndDenoiseDevice", bool3);
                          ((SharedPreferences.Editor)localObject13).putInt("multiVideoSupportNumbers", i3);
                          ((SharedPreferences.Editor)localObject13).putInt("SpeedDialScreenStyle", i4);
                          ((SharedPreferences.Editor)localObject13).putBoolean("switchMultiForceUseGroup", bool4);
                          ((SharedPreferences.Editor)localObject13).putString("switchMultiForceUseGroupAlertTip", localObject9);
                          ((SharedPreferences.Editor)localObject13).putInt("useRGB2I420Shader", n);
                          ((SharedPreferences.Editor)localObject13).putBoolean("isSharpnessSwitch", bool2);
                          ((SharedPreferences.Editor)localObject13).putInt("sharpnessFPSThreshold", i1);
                          ((SharedPreferences.Editor)localObject13).putInt("useAADSDeJitterAlgorithmUin", m);
                          ((SharedPreferences.Editor)localObject13).putInt("enableAADSDeJitterMaxJDelayUin", k);
                          ((SharedPreferences.Editor)localObject13).putInt("upLoadWhenGetNewData", j);
                          ((SharedPreferences.Editor)localObject13).putString("ptuNewRenderLimit", (String)localObject8);
                          ((SharedPreferences.Editor)localObject13).putString("moreBtnTips", (String)localObject7);
                          ((SharedPreferences.Editor)localObject13).putString("ptuAfterTreamentLimit", (String)localObject6);
                          ((SharedPreferences.Editor)localObject13).putString("ptuAfterTreamentCanvas", (String)localObject5);
                          ((SharedPreferences.Editor)localObject13).putBoolean("isAllowedControlMicAfterBeMuted", bool1);
                          ((SharedPreferences.Editor)localObject13).putString("machineMiddleLine", (String)localObject4);
                          ((SharedPreferences.Editor)localObject13).putString("machineHighLine", (String)localObject3);
                          ((SharedPreferences.Editor)localObject13).putInt("allowMicLongPressSpeakInMute", i);
                          if (!((String)localObject2).isEmpty()) {
                            ((SharedPreferences.Editor)localObject13).putString("screenShareTips", (String)localObject2);
                          }
                          if (!((String)localObject10).isEmpty()) {
                            ((SharedPreferences.Editor)localObject13).putString("screenTipsHighlight", (String)localObject10);
                          }
                          if (!((String)localObject1).isEmpty()) {
                            ((SharedPreferences.Editor)localObject13).putString("screenTipsLink", (String)localObject1);
                          }
                          ((SharedPreferences.Editor)localObject13).commit();
                          if (QLog.isColorLevel()) {
                            QLog.i("QAVConfigUtils", 2, "parseAndSave [" + paramString + "]");
                          }
                          return;
                        }
                        catch (Exception localException9)
                        {
                          localObject16 = "";
                          localObject15 = "";
                          i9 = -1;
                          localObject14 = "";
                          localObject13 = "";
                          localObject6 = localObject4;
                          localObject7 = localObject3;
                          localObject8 = localObject2;
                          i4 = m;
                          i5 = n;
                          localObject9 = localObject1;
                          bool5 = bool2;
                          i6 = k;
                          i7 = j;
                          bool6 = bool1;
                          i8 = i;
                          localObject1 = localObject16;
                          localObject2 = localObject15;
                          i = i9;
                          localObject3 = localObject14;
                          localObject4 = localObject13;
                          bool1 = bool4;
                          j = i3;
                          k = i2;
                          m = i1;
                          n = i4;
                          i1 = i5;
                          bool2 = bool3;
                          bool4 = bool5;
                          i4 = i6;
                          i3 = i7;
                          bool3 = bool6;
                          i2 = i8;
                          continue;
                        }
                        bool3 = false;
                        break label4239;
                        localException1 = localException1;
                        localObject2 = "";
                        i = -1;
                        localObject3 = "";
                        localObject4 = "";
                        bool1 = false;
                        localObject5 = "";
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        i5 = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        bool2 = false;
                        i1 = 7;
                        i2 = j;
                        localObject9 = localObject1;
                        j = i5;
                        localObject1 = localObject13;
                        if (QLog.isColorLevel()) {
                          QLog.i("handleGetQAVGeneralConfig", 2, " parse json: " + QLog.getStackTraceString(localException1));
                        }
                        localObject11 = localObject1;
                        localObject1 = "";
                        continue;
                        localException2 = localException2;
                        i2 = i;
                        i = -1;
                        localObject3 = "";
                        localObject4 = "";
                        bool1 = false;
                        localObject5 = "";
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        localObject2 = "";
                        localObject9 = localObject1;
                        i1 = 7;
                        bool2 = false;
                        localObject1 = localObject13;
                        continue;
                        localException3 = localException3;
                        i2 = i;
                        localObject3 = "";
                        localObject4 = "";
                        bool1 = false;
                        localObject5 = "";
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        localObject2 = "";
                        i = -1;
                        i1 = 7;
                        bool2 = false;
                        localObject9 = localObject1;
                        localObject1 = localObject13;
                        continue;
                        localException4 = localException4;
                        bool3 = bool1;
                        i2 = i;
                        localObject4 = "";
                        bool1 = false;
                        localObject5 = "";
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        localObject2 = "";
                        i = -1;
                        localObject3 = "";
                        bool2 = false;
                        localObject9 = localObject1;
                        i1 = 7;
                        localObject1 = localObject13;
                        continue;
                        localException5 = localException5;
                        i3 = j;
                        bool3 = bool1;
                        i2 = i;
                        bool1 = false;
                        localObject5 = "";
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        localObject2 = "";
                        i = -1;
                        localObject3 = "";
                        localObject4 = "";
                        localObject9 = localObject1;
                        i1 = 7;
                        bool2 = false;
                        localObject1 = localObject13;
                        continue;
                        localException6 = localException6;
                        i4 = k;
                        i3 = j;
                        bool3 = bool1;
                        i2 = i;
                        localObject5 = "";
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        localObject2 = "";
                        i = -1;
                        localObject3 = "";
                        localObject4 = "";
                        bool1 = false;
                        bool2 = false;
                        localObject9 = localObject1;
                        i1 = 7;
                        localObject1 = localObject13;
                        continue;
                        localException7 = localException7;
                        bool4 = bool2;
                        i4 = k;
                        i3 = j;
                        bool3 = bool1;
                        i2 = i;
                        localObject6 = "";
                        localObject7 = "";
                        localObject8 = "";
                        j = -1;
                        k = -1;
                        m = -1;
                        n = -1;
                        localObject13 = "";
                        localObject2 = "";
                        i = -1;
                        localObject3 = "";
                        localObject4 = "";
                        bool1 = false;
                        localObject5 = "";
                        localObject9 = localObject1;
                        i1 = 7;
                        bool2 = false;
                        localObject1 = localObject13;
                        continue;
                      }
                    }
                    catch (Exception localException8)
                    {
                      i1 = 7;
                      bool5 = false;
                      localObject9 = localObject1;
                      bool4 = bool2;
                      i4 = k;
                      i3 = j;
                      bool3 = bool1;
                      i2 = i;
                      j = -1;
                      k = -1;
                      m = -1;
                      n = -1;
                      localObject1 = "";
                      localObject2 = "";
                      i = -1;
                      localObject3 = "";
                      localObject4 = "";
                      bool1 = false;
                      localObject5 = "";
                      localObject6 = "";
                      localObject7 = "";
                      localObject8 = "";
                      bool2 = bool5;
                      continue;
                      m = -1;
                      continue;
                    }
                    continue;
                  }
                  continue;
                }
                k = 0;
                continue;
              }
              j = -1;
              continue;
            }
            bool1 = true;
            continue;
          }
          l1 = 1000L;
          continue;
        }
        continue;
      }
      String str1 = "";
      Object localObject2 = "";
      int i = -1;
      localObject3 = "";
      localObject4 = "";
      boolean bool1 = false;
      localObject5 = "";
      Object localObject6 = "";
      localObject7 = "";
      localObject8 = "";
      j = -1;
      int k = -1;
      int m = -1;
      int n = -1;
      Object localObject13 = "";
      boolean bool2 = false;
      Object localObject9 = localObject1;
      i1 = 7;
      localObject1 = localObject13;
      bool4 = bool10;
      i4 = i7;
      bool3 = bool6;
      i2 = i5;
    }
  }
  
  public static int mE()
  {
    if (aAy == -1)
    {
      aAy = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("multiVideoSupportNumbers", -1);
      if (aAy == -1) {
        aAy = 5;
      }
      return aAy;
    }
    return aAy;
  }
  
  public static int mF()
  {
    if (aAB == -1) {
      aAB = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("sharpnessFPSThreshold", 7);
    }
    return aAB * 10;
  }
  
  public static void nJ(int paramInt)
  {
    JSONArray localJSONArray = h();
    if (localJSONArray == null) {
      return;
    }
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        new jkn.a().priority = 2147483647;
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject = localJSONArray.getJSONObject(i);
        if (((JSONObject)localObject).getInt("id") != paramInt) {
          break label196;
        }
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips. id = " + paramInt);
        if (Build.VERSION.SDK_INT >= 19)
        {
          localJSONArray.remove(i);
          localObject = EffectConfigBase.a(287, EffectConfigBase.Nk).edit();
          QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips. saved moreBtnTipsJson = " + localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).putString("moreBtnTips", localJSONArray.toString());
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.i("QAVConfigUtils", 1, "MoreBtnTips. removeMoreBtnTips failed. " + QLog.getStackTraceString(localException));
        return;
      }
      ((JSONObject)localObject).put("priority", 2147483647);
      continue;
      label196:
      i += 1;
    }
  }
  
  public static boolean xE()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (-1 != aAw) {
      return aAw == 1;
    }
    for (;;)
    {
      try
      {
        if (-1 == aAw) {
          break;
        }
        if (aAw == 1) {
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
    SharedPreferences localSharedPreferences = EffectConfigBase.a(287, EffectConfigBase.Nk);
    aAw = localSharedPreferences.getInt("isBlueToothSwitch", 1);
    pW = localSharedPreferences.getLong("bluetoothDelayTime", 1000L);
    if (aAw == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean xF()
  {
    if (aAx == -1) {
      if (!EffectConfigBase.a(287, EffectConfigBase.Nk).getBoolean("LowlightAndDenoiseDevice", true)) {
        break label41;
      }
    }
    label41:
    for (aAx = 1; aAx == 1; aAx = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean xG()
  {
    boolean bool = false;
    if (aAz == -1) {
      aAz = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("SpeedDialScreenStyle", 0);
    }
    if (aAz == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean xH()
  {
    if (aAA == -1) {
      aAA = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("allowMicLongPressSpeakInMute", 0);
    }
    return aAA == 1;
  }
  
  public static boolean xI()
  {
    axt();
    return y.booleanValue();
  }
  
  public static boolean xJ()
  {
    if (aAC == -1) {
      aAC = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("useRGB2I420Shader", 0);
    }
    return aAC == 1;
  }
  
  public static boolean xK()
  {
    if (aAD == -1) {
      aAD = EffectConfigBase.a(287, EffectConfigBase.Nk).getInt("upLoadWhenGetNewData", 0);
    }
    return aAD == 1;
  }
  
  public static boolean xL()
  {
    boolean bool = EffectConfigBase.a(287, EffectConfigBase.Nk).getBoolean("isAllowedControlMicAfterBeMuted", false);
    QLog.i("QAVConfigUtils", 1, "JTest. read isAllowedControlMicAfterBeMuted = " + bool);
    return bool;
  }
  
  public static class a
  {
    public int id = -1;
    public int priority = 0;
    public int sessionType = 0;
    public String url = "";
  }
  
  public static class b
  {
    public String SG;
    public String content;
    public String link;
    
    b(String paramString1, String paramString2, String paramString3)
    {
      this.content = paramString1;
      this.SG = paramString2;
      this.link = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkn
 * JD-Core Version:    0.7.0.1
 */