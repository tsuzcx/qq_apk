import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.Vas.ColorFont.FreeTypeLib;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontManager.1;
import com.etrump.mixlayout.FontManager.10;
import com.etrump.mixlayout.FontManager.2;
import com.etrump.mixlayout.FontManager.3;
import com.etrump.mixlayout.FontManager.4;
import com.etrump.mixlayout.FontManager.5;
import com.etrump.mixlayout.FontManager.9;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class ku
  implements Handler.Callback, Manager
{
  public static float E;
  public static AtomicBoolean E;
  public static AtomicBoolean F;
  public static AtomicBoolean G;
  public static float W;
  public static float X;
  public static float Y;
  public static float Z;
  public static Vector<Integer> a;
  public static float aa;
  public static long ba;
  public static long bb;
  public static volatile boolean cA;
  public static boolean cC;
  public static boolean cD;
  public static final String dV = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".font_info");
  public static final String dW = dV + File.separator + "fz2.0/";
  public static final String dZ = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".font_effect");
  public static final String eb = dZ + File.separator + "magicFontConfig.json";
  public static final String ej = Environment.getExternalStorageDirectory() + "/FontTest" + "/hanyifont/";
  public static final String en = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengfont/";
  public static final String eo = Environment.getExternalStorageDirectory() + "/FontTest" + "/fangzhengcolorfont2/";
  public static final String eq = Environment.getExternalStorageDirectory() + "/FontTest" + "/diyfont/";
  public static int iD;
  private static int iE;
  static int iH;
  public static ConcurrentHashMap<Integer, kt> j;
  private Map<Integer, String> A = new ConcurrentHashMap();
  public AtomicBoolean C = new AtomicBoolean(false);
  private Map<Integer, Long> D;
  public AtomicBoolean D;
  public Handler I;
  List<Integer> V = new LinkedList();
  public aqvd a;
  public ETEngine a;
  public float af = 1.5F;
  public float ag = 1.3F;
  public float ah = 1.5F;
  long bd = 0L;
  long be = 0L;
  boolean cB = false;
  public boolean cE;
  boolean cG = false;
  public boolean cy;
  public volatile boolean cz;
  public String dX;
  public String dY;
  public String ee = acfp.m(2131706394);
  public String eh;
  private CopyOnWriteArrayList<ku.a> f = new CopyOnWriteArrayList();
  public int iC = -1;
  private int iF = -1;
  public int iG = 1;
  ConcurrentHashMap<String, kt> l = new ConcurrentHashMap();
  public QQAppInterface mApp = null;
  String mDeviceInfo;
  public ETEngine mEngine;
  public HandlerThread mHandlerThread;
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, kt>> p = new ConcurrentHashMap();
  final Object v = new Object();
  Map<Integer, Float> y = new ConcurrentHashMap();
  
  static
  {
    jdField_E_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    cC = true;
    cD = true;
    jdField_E_of_type_Float = 0.3F;
    W = 0.3F;
    X = 1.5F;
    Y = 0.7F;
    Z = 1.3F;
    aa = 0.7F;
    iD = 4;
    F = new AtomicBoolean(true);
    G = new AtomicBoolean(true);
    jdField_a_of_type_JavaUtilVector = new Vector();
    iE = -1;
  }
  
  public ku(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aqvd = null;
    this.jdField_D_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.mApp = paramQQAppInterface;
    this.jdField_D_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    j = new ConcurrentHashMap();
    U(aqmj.k(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), "vas_font_switch_config"));
    this.cz = this.mApp.getApp().getSharedPreferences("font_open_switch", 4).getBoolean("isUserOpenFontSwitch_" + this.mApp.getAccount(), false);
    paramQQAppInterface = new StringBuilder();
    if (!this.cB) {
      paramQQAppInterface.append(aqgz.getModel()).append("; CPU number: ").append(aqgz.getCpuNumber()).append("; CPU frequency: ").append(aqgz.getCpuFrequency()).append("; RAM: ").append(aqgz.getSystemTotalMemory());
    }
    this.mDeviceInfo = paramQQAppInterface.toString();
    this.cy = aB();
    this.mHandlerThread = ThreadManager.newFreeHandlerThread("VasFont", 0);
    this.mHandlerThread.start();
    this.I = new Handler(this.mHandlerThread.getLooper(), this);
  }
  
  private boolean F(String paramString)
  {
    if (this.iF == -1)
    {
      if (((aqgz.getCpuNumber() < 2) || (aqgz.getCpuFrequency() <= 1000L)) && ((aqgz.getCpuNumber() < 4) || (aqgz.getSystemTotalMemory() <= 838860800L))) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return true");
      }
      this.iF = 1;
    }
    for (;;)
    {
      aqri.a(this.mApp, "individual_v2_font_dpc_fail", "font_dpc_fail", this.mDeviceInfo, paramString, 0.0F);
      if (this.iF != 1) {
        break;
      }
      return true;
      label92:
      this.iF = 0;
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getChatFontAbilityFromLocal return false. CPU number = " + aqgz.getCpuNumber() + " CPU Frequency = " + aqgz.getCpuFrequency() + " Memory = " + aqgz.getSystemTotalMemory());
      }
    }
    return false;
  }
  
  public static void U(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "updateFontSwitch configContent = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONObject(paramString);
        F.set(paramString.optBoolean("enableHanyiFont", true));
        G.set(paramString.optBoolean("enableFounderFont", true));
        paramString = paramString.optJSONArray("blackList");
        if ((paramString == null) || (paramString.length() <= 0)) {
          continue;
        }
        int i = 0;
        while (i < paramString.length())
        {
          int k = paramString.optInt(i);
          if (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(k))) {
            jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(k));
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("VasFont", 1, "updateFontSwitch error: ", paramString);
      }
    }
  }
  
  public static int a(ExtensionInfo paramExtensionInfo)
  {
    int i = 0;
    if (paramExtensionInfo != null) {
      i = (int)(((paramExtensionInfo.uVipFont & 0xFF) << 8) + (paramExtensionInfo.uVipFont >> 8 & 0xFF)) + (paramExtensionInfo.vipFontType << 16) + (paramExtensionInfo.magicFont << 24);
    }
    return i;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    switch (paramMessageRecord.istroop)
    {
    default: 
    case 0: 
    case 1000: 
    case 1001: 
    case 1002: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1010: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1025: 
    case 10002: 
    case 10004: 
    case 10008: 
    case 1: 
      do
      {
        return null;
        if (paramMessageRecord.isSend()) {
          return paramMessageRecord.selfuin;
        }
        return paramMessageRecord.frienduin;
      } while (jof.a(paramMessageRecord));
      if (paramMessageRecord.isSend()) {
        return paramMessageRecord.selfuin;
      }
      return paramMessageRecord.senderuin;
    }
    if (paramMessageRecord.isSend()) {
      return paramMessageRecord.selfuin;
    }
    return paramMessageRecord.senderuin;
  }
  
  private kt a()
  {
    ??? = (kt)this.l.get(this.dX);
    Object localObject3;
    if (??? != null)
    {
      localObject3 = ???;
      if (((kt)???).mFontType == 4)
      {
        i.a().b(((kt)???).mFontId, ((kt)???).mFontPath);
        localObject3 = ???;
      }
      return localObject3;
    }
    if (this.iC == 1)
    {
      if (!ETEngine.getInstance().isEngineInited.get())
      {
        eS();
        return null;
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
    }
    for (;;)
    {
      synchronized (this.v)
      {
        this.mEngine.native_loadFont(ej + this.dX, this.dX.hashCode(), true);
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(ej + this.dX, this.dX.hashCode(), true);
        ??? = new kt(this.dX.hashCode(), ej + this.dX);
        localObject3 = new ETFont(((kt)???).mFontId, ej + this.dX, 1.0F);
        ((kt)???).iB = this.mEngine.native_getVariantStyleComboCount((ETFont)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getTestFont: fontId=" + ((kt)???).mFontId + " styleCount=" + ((kt)???).iB);
        }
        ((kt)???).mFontType = this.iC;
        localObject3 = ???;
        if (??? == null) {
          break;
        }
        this.l.put(this.dX, ???);
        return ???;
      }
      if (this.iC == 2)
      {
        ??? = new kt(this.dX.hashCode(), en + this.dX);
        ((kt)???).mFontType = this.iC;
        ((kt)???).mTypeface = Typeface.createFromFile(en + this.dX);
        continue;
      }
      if (this.iC == 4)
      {
        if (!i.a().n.get()) {
          eQ();
        }
        if (!i.a().v.get())
        {
          if (i.a().p.get())
          {
            i.a().a().Z();
            i.a().v.set(true);
          }
        }
        else
        {
          ??? = new kt(49152 + (this.dX.hashCode() & 0x3FFF), eo + this.dX);
          ((kt)???).mFontType = this.iC;
          i.a().b(((kt)???).mFontId, ((kt)???).mFontPath);
          ((kt)???).iB = h.l(((kt)???).mFontId);
          continue;
        }
        return null;
      }
      if (this.iC != 99) {
        continue;
      }
      if (!ETEngine.getInstance().isEngineInited.get()) {
        eS();
      }
      if (!ETEngine.getInstance().isEngineReady.get()) {
        return null;
      }
      ??? = new kt(1000, eq + this.dX);
      ((kt)???).mFontType = 1;
      ??? = new File(eq + "config.json");
      if (((File)???).exists()) {
        ((kt)???).dU = kl.d((File)???);
      }
      ((kt)???).b = new ETFont(((kt)???).mFontId, ((kt)???).mFontPath, 16.0F, ((kt)???).mFontType, ((kt)???).mTypeface);
      synchronized (this.v)
      {
        this.mEngine.native_loadFont(ej + this.dX, ((kt)???).mFontId, true);
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(ej + this.dX, ((kt)???).mFontId, true);
        ((kt)???).b.parseDIYJsonString(((kt)???).dU);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    this.I.post(new FontManager.5(this, paramInt1, paramInt2, paramString, paramInt3, paramBoolean));
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.b != null)
    {
      int k = paramBaseChatPie.b.getFirstVisiblePosition();
      int m = paramBaseChatPie.b.getLastVisiblePosition();
      int n = paramBaseChatPie.b.getHeaderViewsCount();
      int i = k - 1;
      if (i <= m)
      {
        Object localObject = paramBaseChatPie.b.getChildAt(n + i - k);
        if (localObject != null)
        {
          if (!(wja.a((View)localObject) instanceof xov.a)) {
            break label113;
          }
          localObject = (xov.a)wja.a((View)localObject);
          if ((((xov.a)localObject).mText instanceof ETTextView)) {
            ((ETTextView)((xov.a)localObject).mText).startAnimation(false, true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label113:
          if ((wja.a((View)localObject) instanceof xmj.a))
          {
            localObject = (xmj.a)wja.a((View)localObject);
            if ((((xmj.a)localObject).a != null) && (((xmj.a)localObject).a.l != null)) {
              ((xmj.a)localObject).a.l.startAnimation(false, true);
            }
          }
          else if ((wja.a((View)localObject) instanceof xea.a))
          {
            ((xea.a)wja.a((View)localObject)).b.restartAnimation();
          }
        }
      }
    }
  }
  
  private void a(String paramString, kt paramkt, int paramInt)
  {
    this.I.post(new FontManager.9(this, paramString, paramkt, paramInt));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, ExtensionInfo paramExtensionInfo, int paramInt1, int paramInt2)
  {
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo = paramExtensionInfo;
    if (paramExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = paramString;
    }
    if (localExtensionInfo.diyFontTimestampMap == null) {
      localExtensionInfo.diyFontTimestampMap = new ConcurrentHashMap();
    }
    if ((localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) == null) || (((Integer)localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1))).intValue() < paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "checkUpdateDIYConfig uin = " + paramString + " fontId = " + paramInt1 + " oldTime = " + localExtensionInfo.diyFontTimestampMap.get(Integer.valueOf(paramInt1)) + " newTime = " + paramInt2);
      }
      paramQQAppInterface = (acle)paramQQAppInterface.getBusinessHandler(13);
      paramExtensionInfo = new HashMap();
      paramExtensionInfo.put(paramString, Integer.valueOf(paramInt1));
      paramQQAppInterface.af(paramExtensionInfo);
      localExtensionInfo.diyFontTimestampMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      localacff.a(localExtensionInfo);
      return true;
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (!cC) {}
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(a(paramChatMessage)));
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    } while ((TextUtils.isEmpty(paramChatMessage)) || (!TextUtils.isDigitsOnly(paramChatMessage)) || ((Long.parseLong(paramChatMessage) >> 24 & 1L) != 1L));
    return true;
  }
  
  private boolean a(String paramString, kt paramkt, int paramInt)
  {
    if (paramkt.b == null) {
      paramkt.b = new ETFont(paramkt.mFontId, paramkt.mFontPath, 16.0F, paramkt.mFontType, paramkt.mTypeface);
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.p.get(paramString);
    if (localConcurrentHashMap == null) {
      localConcurrentHashMap = new ConcurrentHashMap();
    }
    for (;;)
    {
      if (ETEngine.getInstance().native_diyFontIsDIYFont(paramkt.b))
      {
        paramkt.cx = true;
        Object localObject2 = ((acff)this.mApp.getManager(51)).a(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = paramString;
        }
        if (a(this.mApp, paramString, (ExtensionInfo)localObject1, paramkt.mFontId, paramInt))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isDIYFont fontId = " + paramkt.mFontId + " uin = " + paramString + " needUpdateDiyConfig");
          }
          if (!localConcurrentHashMap.containsKey(Integer.valueOf(paramkt.mFontId)))
          {
            localObject1 = new kt(0, "");
            localConcurrentHashMap.put(Integer.valueOf(paramkt.mFontId), localObject1);
            this.p.put(paramString, localConcurrentHashMap);
          }
          return false;
        }
        if (localConcurrentHashMap.containsKey(Integer.valueOf(paramkt.mFontId)))
        {
          if (paramkt.mFontId != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isDIYFont fontid = " + paramkt.mFontId + " is diy font handle = " + paramkt.b.m_diyHandle);
            }
            paramkt.cx = true;
            return true;
          }
        }
        else
        {
          if ((((ExtensionInfo)localObject1).diyFontConfigMap != null) && (((ExtensionInfo)localObject1).diyFontConfigMap.containsKey(Integer.valueOf(paramkt.mFontId))))
          {
            localObject1 = (String)((ExtensionInfo)localObject1).diyFontConfigMap.get(Integer.valueOf(paramkt.mFontId));
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isDIYFont fontId = " + paramkt.mFontId + " uin = " + paramString + " config = " + (String)localObject1);
            }
            paramkt.b.parseDIYJsonString((String)localObject1);
            localObject1 = new kt(paramkt.mFontId, paramkt.mFontPath);
            ((kt)localObject1).mFontType = paramkt.mFontType;
            ((kt)localObject1).cx = true;
            localObject2 = new ETFont(paramkt.mFontId, paramkt.mFontPath, 16.0F, paramkt.mFontType, null);
            ((ETFont)localObject2).copy(paramkt.b);
            ((kt)localObject1).b = ((ETFont)localObject2);
            localConcurrentHashMap.put(Integer.valueOf(paramkt.mFontId), localObject1);
            this.p.put(paramString, localConcurrentHashMap);
            return true;
          }
          localObject1 = new kt(paramkt.mFontId, paramkt.mFontPath);
          ((kt)localObject1).mFontType = paramkt.mFontType;
          ((kt)localObject1).cx = true;
          ((kt)localObject1).b = new ETFont(paramkt.mFontId, paramkt.mFontPath, 16.0F, paramkt.mFontType, null);
          localConcurrentHashMap.put(Integer.valueOf(paramkt.mFontId), localObject1);
          this.p.put(paramString, localConcurrentHashMap);
          return true;
        }
      }
      return false;
    }
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 24) & 0x1;
  }
  
  public static int c(long paramLong)
  {
    return (int)(paramLong >> 16 & 0xF);
  }
  
  public static int d(long paramLong)
  {
    kt localkt = null;
    if (j != null) {
      localkt = (kt)j.get(Integer.valueOf((int)paramLong));
    }
    if (localkt != null) {}
    for (int i = localkt.iB;; i = 0)
    {
      if (i > 0) {}
      for (int k = iH % i;; k = 0)
      {
        iH += 1;
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getVariedStyleIndex: sIndex=" + iH + " fontId=" + paramLong + " styleCount=" + i + " index=" + k);
        }
        return k;
      }
    }
  }
  
  public static boolean d(int paramInt1, int paramInt2)
  {
    return new File(e(paramInt1, paramInt2)).exists();
  }
  
  public static String e(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3) {
      return dW + paramInt1 + File.separator + paramInt1 + ".ttf";
    }
    return dV + File.separator + paramInt1 + File.separator + paramInt1 + ".ttf";
  }
  
  private void eL()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      ku.a locala = (ku.a)localIterator.next();
      if (locala != null) {
        locala.eU();
      }
    }
  }
  
  public static void eM()
  {
    QLog.e("VasFont", 1, "resetFontSwitch");
    F.set(true);
    G.set(true);
    jdField_a_of_type_JavaUtilVector.clear();
  }
  
  public static String f(int paramInt1, int paramInt2)
  {
    return dV + File.separator + paramInt1 + File.separator + paramInt1 + "." + paramInt2 + ".ttf";
  }
  
  public static long h(long paramLong)
  {
    return ((paramLong & 0xFF) << 8) + (paramLong >> 8 & 0xFF);
  }
  
  public void B(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "reDownloadFont start");
    }
    Object localObject = a(paramInt1, paramInt2);
    if (localObject != null)
    {
      j.remove(Integer.valueOf(paramInt1));
      localObject = new File(((kt)localObject).mFontPath);
      if (!((File)localObject).exists()) {
        break label242;
      }
      localObject = new File(((File)localObject).getParent());
      File[] arrayOfFile = ((File)localObject).listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          bool = arrayOfFile[i].delete();
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "reDownloadFont delete " + arrayOfFile[i].getName() + " ret = " + bool);
          }
          i += 1;
        }
      }
      boolean bool = ((File)localObject).delete();
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownloadFont delete " + ((File)localObject).getName() + " ret = " + bool);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownload startDownload");
      }
      b(paramInt1, null, paramInt2);
      return;
      label242:
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "reDownloadFont fontFile not exist");
      }
    }
  }
  
  public void U(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.cy = aB();
        if (!this.cy) {
          break label596;
        }
        localObject = (acff)this.mApp.getManager(51);
        this.mEngine = ETEngine.getInstance();
        this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForAnimation();
        if ((this.mEngine == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null)) {
          break label585;
        }
        int m = ChatTextSizeSettingActivity.ag(this.mApp.getApplication());
        i = m * m * 240 * 18 * 2;
        if (i <= 1048576) {
          break label597;
        }
        boolean bool3 = this.mEngine.isEngineReady.get();
        boolean bool2 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.isEngineReady.get();
        boolean bool1 = bool3;
        if (!bool3) {}
        try
        {
          bool1 = this.mEngine.initEngine(18, i);
          bool3 = bool2;
          if (!bool2) {
            bool3 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(10, 3145728);
          }
          if ((bool1) && (bool3))
          {
            k = 1;
            if (paramBoolean)
            {
              if (k == 0) {
                break label577;
              }
              String str1 = "1";
              localObject = ((acff)localObject).a(this.mApp.getAccount());
              if ((localObject == null) || (0L == ((ExtensionInfo)localObject).uVipFont) || (((ExtensionInfo)localObject).vipFontType != 1)) {
                break label604;
              }
              localObject = "0";
              anot.a(this.mApp, "CliOper", "", "", "Font_Mall", "0X80072CB", 0, 0, str1, (String)localObject, "", "");
              if (QLog.isColorLevel()) {
                QLog.d("VasFont", 2, "VipFontReport: AIO engine status, status=" + str1 + ", hgType=" + (String)localObject);
              }
            }
            if (k == 0) {
              break label596;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "start init font engine fontsize=" + m + ",num=" + 18 + ",cache=" + i);
            }
            ETEngine.getInstance().isEngineReady.set(true);
            if (paramBoolean) {
              break label596;
            }
            anot.a(this.mApp, "CliOper", "", "", "Font_Mall", "0X80072C9", 0, 0, "", "", "", "");
            if (!QLog.isColorLevel()) {
              break label596;
            }
            QLog.d("VasFont", 2, "VipFontReport: AioRefreshed");
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("VasFont", 1, "init font engine fail " + localException.getMessage());
          anot.a(this.mApp, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
          return;
        }
        int k = 0;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VasFont", 1, "init font engine fail " + localThrowable.getMessage());
        anot.a(this.mApp, "CliOper", "", "", "Font_Mall", "load_font_fail", 0, 1, "-1", "", "", "");
        return;
      }
      continue;
      label577:
      String str2 = "0";
      continue;
      label585:
      throw new Exception("create font engine Instance fail");
      label596:
      return;
      label597:
      int i = 1048576;
      continue;
      label604:
      Object localObject = "1";
    }
  }
  
  public void V(boolean paramBoolean)
  {
    if (this.mApp != null) {
      this.mApp.getApp().getSharedPreferences("font_open_switch", 4).edit().putBoolean("isUserOpenFontSwitch_" + this.mApp.getAccount(), paramBoolean).apply();
    }
    this.cz = paramBoolean;
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject1 = new File(dV + File.separatorChar + paramInt + File.separatorChar + "fontname.png");
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return null;
      try
      {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        localObject1 = BitmapFactory.decodeStream(new FileInputStream((File)localObject1));
        if (localObject1 == null) {
          continue;
        }
        return new BitmapDrawable((Bitmap)localObject1);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, localFileNotFoundException.toString());
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public kt a(int paramInt1, int paramInt2)
  {
    kt localkt = (kt)j.get(Integer.valueOf(paramInt1));
    Object localObject = localkt;
    if (localkt == null)
    {
      localObject = new File(e(paramInt1, paramInt2));
      boolean bool = ((File)localObject).exists();
      if (bool) {
        localkt = new kt(paramInt1, ((File)localObject).getAbsolutePath());
      }
      localObject = localkt;
      if (QLog.isColorLevel())
      {
        QLog.d("VasFont", 2, "findFontInfo|find from local|fontExists=" + bool);
        localObject = localkt;
      }
    }
    return localObject;
  }
  
  public kt a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3)
  {
    if (((paramInt2 == 4) || (paramInt2 == 3)) && (!i.a().v.get())) {
      if (!i.a().n.get())
      {
        eQ();
        localObject = null;
      }
    }
    kt localkt;
    do
    {
      return localObject;
      if (i.a().p.get())
      {
        i.a().a().Z();
        i.a().v.set(true);
        localkt = (kt)j.get(Integer.valueOf(paramInt1));
        if (localkt == null)
        {
          a(paramInt1, paramInt2, paramBoolean, paramString, paramInt3);
          return localkt;
        }
      }
      else
      {
        return null;
      }
      if (localkt.mFontType == 4)
      {
        long l1 = System.currentTimeMillis();
        paramInt2 = i.a().b(paramInt1, localkt.mFontPath);
        localkt.iB = h.l(paramInt1);
        long l2 = System.currentTimeMillis();
        if (paramInt2 != 0) {
          la.a("action_load", paramInt1, 4, 0, l2 - l1);
        }
      }
      if (localkt.b == null) {
        localkt.b = new ETFont(paramInt1, localkt.mFontPath, 16.0F, localkt.mFontType, localkt.mTypeface);
      }
      localObject = localkt;
    } while (!localkt.cx);
    Object localObject = (ConcurrentHashMap)this.p.get(paramString);
    if ((localObject != null) && (((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(paramInt1))))
    {
      localObject = (kt)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt1));
      this.I.post(new FontManager.4(this, paramString, paramInt1, paramInt3));
      return localObject;
    }
    a(paramString, localkt, paramInt3);
    return null;
  }
  
  kt a(ChatMessage paramChatMessage)
  {
    boolean bool = false;
    Object localObject = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    String str = paramChatMessage.getExtInfoFromExtStr("diy_timestamp");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {}
    for (int m = Integer.parseInt(str);; m = 0)
    {
      int i;
      int k;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject)) && (!((String)localObject).equals("0")))
      {
        long l1 = Long.parseLong((String)localObject);
        i = (int)h(l1);
        k = c(l1);
      }
      for (;;)
      {
        localObject = a(paramChatMessage);
        if (k == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "doGetUserFont msg do not has font id");
          }
          localObject = ((acff)this.mApp.getManager(51)).a((String)localObject, false);
          if (localObject != null)
          {
            i = (int)((ExtensionInfo)localObject).uVipFont;
            k = ((ExtensionInfo)localObject).vipFontType;
          }
        }
        for (;;)
        {
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "doGetUserFont fontID = " + i + " type = " + k);
            }
            if (jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(i)))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont font is in black list");
              }
              return null;
              QLog.e("VasFont", 1, "doGetUserFont extensionInfo not in cache");
              return null;
            }
            if (((k == 4) || (k == 3)) && (!ay()))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont Founder Color Font not supported");
              }
              return null;
            }
            if ((k == 1) && (!F.get()))
            {
              if (QLog.isColorLevel()) {
                QLog.e("VasFont", 2, "doGetUserFont HanYi Font not supported");
              }
              return null;
            }
            if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
              bool = true;
            }
            paramChatMessage = a(i, k, bool, a(paramChatMessage), m);
            if (paramChatMessage != null)
            {
              cA = true;
              return paramChatMessage;
            }
            if (QLog.isColorLevel()) {
              QLog.e("VasFont", 2, "doGetUserFont no font fontid = " + i + " fontType = " + k);
            }
            return null;
          }
          return new kt(0, null);
        }
        k = 0;
        i = 0;
      }
    }
  }
  
  public JSONObject a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt1, paramInt2) != null)
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", acfp.m(2131706395));
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt1);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "queryInfo fontId=" + paramInt1 + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        if (!this.y.containsKey(Integer.valueOf(paramInt1))) {
          break label344;
        }
        f1 = ((Float)this.y.get(Integer.valueOf(paramInt1))).floatValue();
        if (f1 != 1.0F) {
          break;
        }
        localJSONObject2.put("status", 3);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", acfp.m(2131706396));
        break label392;
        localJSONObject2.put("canceling", paramInt2);
        localJSONObject2.put("progress", 100.0F * f1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f1;
        localException.printStackTrace();
        continue;
        if (f1 == 2.0F)
        {
          localException.put("status", 1);
          localJSONObject1.put("result", -1);
          localJSONObject1.put("message", acfp.m(2131706393));
        }
        else
        {
          localException.put("status", 2);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", acfp.m(2131706391));
          break label392;
          label344:
          localException.put("status", 1);
          localException.put("progress", 0);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", acfp.m(2131706392));
          continue;
        }
        label392:
        if (f1 == 3.0F) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
      }
    }
  }
  
  public void a(aqvd paramaqvd)
  {
    this.jdField_a_of_type_Aqvd = paramaqvd;
  }
  
  public void a(ku.a parama)
  {
    if ((parama == null) || (this.f.contains(parama))) {
      return;
    }
    this.f.add(parama);
  }
  
  public boolean a(BaseBubbleBuilder.e parame, ChatMessage paramChatMessage)
  {
    if ((parame instanceof xov.a))
    {
      parame = (xov.a)parame;
      if ((parame.mText instanceof ETTextView))
      {
        if (((ETTextView)parame.mText).mFont == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has no font yet");
          }
          return true;
        }
        kt localkt = b(paramChatMessage);
        if ((localkt != null) && ((parame.mText instanceof ETTextView)))
        {
          ETTextView localETTextView = (ETTextView)parame.mText;
          if (localETTextView.mFont.mFontId != localkt.mFontId)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has font change");
            }
            return true;
          }
          if ((localkt.b != null) && (localkt.b.m_diyHandle != localETTextView.mFont.m_diyHandle))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "isAioNeedRefresh text has diyFont change");
            }
            return true;
          }
        }
        if (a(paramChatMessage) != ((ETTextView)parame.mText).mMagicFont)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change");
          }
          return true;
        }
        if (this.cG)
        {
          this.cG = false;
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh needRefershAIOForFontEffect.");
          }
          return true;
        }
        parame = (ETTextView)parame.mText;
        if ((parame.getETLayout() != null) && (parame.mMagicFont != parame.getETLayout().mMagicFont))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "isAioNeedRefresh text has magicfont change 2");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(kt paramkt, String paramString, int paramInt)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        boolean bool3 = this.mApp.getCurrentAccountUin().equals(paramString);
        try
        {
          ??? = new File(paramkt.mFontPath);
          if (!((File)???).exists())
          {
            b(paramkt.mFontId, null, 1);
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "load font fail file not exist font id=" + paramkt.mFontId);
            }
            bool1 = false;
            return bool1;
          }
          if (aqhq.fileToBytes((File)???) == null)
          {
            B(paramkt.mFontId, 1);
            VasWebviewUtil.reportVasStatus("Font", "FontMd5Check", "0", 0, 0, paramkt.mFontId, 1, "", "");
            bool1 = false;
            continue;
          }
          QLog.d("VasFont", 1, "ET load font start id = " + paramkt.mFontId + " time = " + System.currentTimeMillis());
        }
        catch (Throwable paramkt)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VasFont", 2, "load font fail", paramkt);
          continue;
        }
        synchronized (this.v)
        {
          bool1 = this.mEngine.native_loadFont(paramkt.mFontPath, paramkt.mFontId, bool3);
          bool3 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(paramkt.mFontPath, paramkt.mFontId, bool3);
          QLog.d("VasFont", 1, "ET load font end id = " + paramkt.mFontId + " time = " + System.currentTimeMillis());
          if ((!bool1) || (!bool3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "load font fail font id=" + paramkt.mFontId + " ret=" + bool1 + " ret2=" + bool3);
            }
            bool1 = false;
          }
        }
        if (!QLog.isColorLevel()) {
          break label397;
        }
      }
      finally {}
      QLog.d("VasFont", 2, "setActiveFonts refreshAIO");
      label397:
      boolean bool1 = bool2;
      if (a(paramString, paramkt, paramInt))
      {
        aqnl.H(this.mApp);
        bool1 = bool2;
      }
    }
  }
  
  public boolean aB()
  {
    if (this.iF != -1) {
      return this.iF == 1;
    }
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.chat_font.name(), "default");
    QLog.d("VasFont", 1, "fontSwitch = " + str);
    if (str.equals("1"))
    {
      this.cy = true;
      this.iF = 1;
      return this.cy;
    }
    if (this.cz)
    {
      this.cy = true;
      this.iF = 1;
      return this.cy;
    }
    if ((str.equals("000")) || (str.equals("default"))) {
      this.cy = F(str);
    }
    if (str.equals("0")) {
      this.iF = 0;
    }
    return this.cy;
  }
  
  public boolean ay()
  {
    return G.get();
  }
  
  public boolean az()
  {
    boolean bool = false;
    if (iE == -1)
    {
      Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.vip_individuation.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 9)
        {
          QLog.d("VasFont", 1, "FounderDynamicFont DPC value = " + localObject[8]);
          if (!"0".equals(localObject[8])) {
            break label109;
          }
        }
      }
    }
    label109:
    for (iE = 0;; iE = 1)
    {
      if ((iE == 1) || (iE == -1)) {
        bool = true;
      }
      return bool;
    }
  }
  
  public kt b(ChatMessage paramChatMessage)
  {
    this.cy = aB();
    if (!this.cy)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VasFont", 2, "getUserFont fontFeatureSupported = false");
      }
      return null;
    }
    if ((this.C.get()) && (!TextUtils.isEmpty(this.dX))) {
      return a();
    }
    String str1 = a(paramChatMessage);
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "getUserFont uin is empty");
      }
      return new kt(0, null);
    }
    acff localacff = (acff)this.mApp.getManager(51);
    ExtensionInfo localExtensionInfo = localacff.a(str1, false);
    String str2 = paramChatMessage.getExtInfoFromExtStr("vip_font_id");
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "getUserFont: message font id = " + str2 + " uin = " + str1);
    }
    long l1 = paramChatMessage.time;
    long l2;
    int i;
    if ((!TextUtils.isEmpty(str2)) && (TextUtils.isDigitsOnly(str2)) && (!str2.equals("0")))
    {
      l2 = Long.parseLong(str2);
      i = c(l2);
      if ((i == 2) || (i == 1) || (i == 4)) {
        if ((localExtensionInfo != null) && (l1 > localExtensionInfo.lastUpdateTime))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getUserFont: message time = " + l1 + " lastUpdateTime = " + localExtensionInfo.lastUpdateTime);
          }
          if (h(l2) == localExtensionInfo.uVipFont) {
            break label370;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "getUserFont: message font not equals local uin = " + str1);
          }
          aqgm.UC(str1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        aqgm.ez(this.mApp);
      }
      return a(paramChatMessage);
      label370:
      if (b(l2) != localExtensionInfo.magicFont)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "getUserFont: message magicfont not equals local uin = " + str1);
        }
        aqgm.UC(str1);
        i = 1;
        continue;
        if (localExtensionInfo != null) {
          return a(paramChatMessage);
        }
        new QueryTask(new kv(this, localacff, str1), new kw(this, paramChatMessage)).bq(null);
        if (QLog.isColorLevel()) {
          QLog.i("VasFont", 2, "getUserFont extensionInfo no cache.");
        }
        return null;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    for (;;)
    {
      synchronized (this.V)
      {
        if (this.V.contains(Integer.valueOf(paramInt1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "startDownload font " + paramInt1 + " is downloading");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "startDownload font " + paramInt1 + " start download");
        }
        this.V.add(Integer.valueOf(paramInt1));
        Map localMap = this.A;
        ??? = paramString;
        if (paramString == null) {
          ??? = "0";
        }
        localMap.put(Integer.valueOf(paramInt1), ???);
        paramString = (VasQuickUpdateManager)this.mApp.getManager(184);
        if (paramInt2 == 3)
        {
          paramString.downloadItem(5L, "font.fzfont.android." + paramInt1, "FontManager");
          this.y.put(Integer.valueOf(paramInt1), Float.valueOf(0.0F));
          return;
        }
      }
      if (paramInt2 == 4) {
        this.jdField_D_of_type_JavaUtilMap.put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
      }
      paramString.downloadItem(5L, "font.main.android." + paramInt1, "FontManager");
    }
  }
  
  public void b(ku.a parama)
  {
    if (parama == null) {
      return;
    }
    this.f.remove(parama);
  }
  
  public File c()
  {
    File localFile = new File(dV);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void c(int paramInt1, int paramInt2, String arg3)
  {
    int i = 0;
    QLog.e("DIYProfileTemplate.VasFont", 1, "字体下载完成回调:" + paramInt1 + " error:" + paramInt2);
    for (;;)
    {
      synchronized (this.V)
      {
        if (this.V.contains(Integer.valueOf(paramInt1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VasFont", 2, "onDownloadComplete font " + paramInt1 + " complete remove from list");
          }
          this.V.remove(Integer.valueOf(paramInt1));
        }
        if (!this.jdField_D_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt1))) {
          break label405;
        }
        l1 = ((Long)this.jdField_D_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).longValue();
        this.jdField_D_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
        if (paramInt2 == 0)
        {
          if (l1 > 0L) {
            la.a("action_download", paramInt1, 4, 0, System.currentTimeMillis() - l1);
          }
          this.y.put(Integer.valueOf(paramInt1), Float.valueOf(1.0F));
          ??? = (String)this.A.get(Integer.valueOf(paramInt1));
          if ((??? != null) && (!???.equals("0")))
          {
            Object localObject1;
            if (TextUtils.isDigitsOnly(???))
            {
              int k = Integer.parseInt(???);
              localObject1 = new EIPCResult();
              ((EIPCResult)localObject1).code = paramInt2;
              new Bundle().putInt("id", paramInt1);
              ld.a().callbackResult(k, (EIPCResult)localObject1);
            }
            if (this.jdField_a_of_type_Aqvd != null)
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("callbackId", ???);
              ((Bundle)localObject1).putInt("srcType", 2);
              ??? = this.jdField_a_of_type_Aqvd;
              l1 = paramInt1;
              if (paramInt2 != 0) {
                break label400;
              }
              paramInt1 = i;
              ???.a(l1, paramInt1, (Bundle)localObject1);
            }
          }
          if (paramInt2 == 0)
          {
            aqnl.H(this.mApp);
            eL();
          }
          return;
        }
      }
      this.y.put(Integer.valueOf(paramInt1), Float.valueOf(2.0F));
      continue;
      label400:
      paramInt1 = -1;
      continue;
      label405:
      long l1 = 0L;
    }
  }
  
  public void d(int paramInt, float paramFloat)
  {
    this.y.put(Integer.valueOf(paramInt), Float.valueOf(paramFloat));
  }
  
  void eQ()
  {
    if (i.a().n.get()) {
      return;
    }
    i.a().n.set(true);
    this.I.post(new FontManager.1(this));
  }
  
  public void eS()
  {
    if ((ETEngine.getInstance().isEngineInited.compareAndSet(false, true)) && (lb.aF())) {
      this.I.postDelayed(new FontManager.2(this), 2000L);
    }
  }
  
  public void eT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont", 2, "resetLastSendReportTime.");
    }
    this.bd = 0L;
    this.be = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = this.mApp.getPreferences().edit();
    localEditor.putLong("magic_font_last_send_report", this.bd);
    localEditor.putLong("magic_font_reset_time", this.be);
    localEditor.apply();
  }
  
  public void g(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists())) {}
    for (;;)
    {
      int i;
      try
      {
        paramFile = new JSONObject(aqhq.readFileContent(paramFile));
        Object localObject = paramFile.optJSONArray("defaultEffect");
        if (1 == ((JSONArray)localObject).length()) {
          this.iG = ((JSONObject)((JSONArray)localObject).get(0)).optInt("effectID", 1);
        }
        paramFile = paramFile.optJSONArray("magicFontConfig");
        i = 0;
        if (i < paramFile.length())
        {
          localObject = (JSONObject)paramFile.get(i);
          if (2 == ((JSONObject)localObject).optInt("platformId", 0))
          {
            this.af = ((float)((JSONObject)localObject).optDouble("fontEnlargeFactor"));
            this.ag = ((float)((JSONObject)localObject).optDouble("maxEnlargeFactor"));
            this.ah = ((float)((JSONObject)localObject).optDouble("emotionEnlargeFactor"));
            if (((JSONObject)localObject).optInt("switch", 1) != 1) {
              break label335;
            }
            bool = true;
            this.cE = bool;
            this.ee = ((JSONObject)localObject).optString("description");
            this.eh = ((JSONObject)localObject).optString("magic");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("VasFont", 2, "fontEffectPrefer = " + this.iG + " enlargeFontText = " + this.af + " enlargeFontTextMax = " + this.ag + " enlargeFontEmo = " + this.ah + " enlargeFontSwitch = " + this.cE + " enlargeFontDesc = " + this.ee + " enlargeFontImgURL = " + this.eh);
          }
          this.cG = true;
          aqnl.H(this.mApp);
          return;
        }
      }
      catch (Exception paramFile)
      {
        QLog.e("VasFont", 1, "parse fontEffect json config fail", paramFile);
        return;
      }
      i += 1;
      continue;
      label335:
      boolean bool = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return true;
  }
  
  public void m(String paramString, int paramInt)
  {
    int k = 1;
    acff localacff = (acff)this.mApp.getManager(51);
    ExtensionInfo localExtensionInfo2 = localacff.a(paramString);
    int i = 0;
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = paramString;
      localExtensionInfo1.fontEffect = -1;
      i = 1;
    }
    if (localExtensionInfo1.fontEffect != paramInt)
    {
      localExtensionInfo1.fontEffect = paramInt;
      localExtensionInfo1.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      eT();
    }
    for (paramInt = k;; paramInt = i)
    {
      if (paramInt != 0) {
        localacff.a(localExtensionInfo1);
      }
      return;
    }
  }
  
  public void n(String paramString, int paramInt)
  {
    this.I.post(new FontManager.10(this, paramString, paramInt));
  }
  
  public void onAIODestroy()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine != null)
    {
      ETDecoration.clearMap(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine);
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_resetEngine();
    }
    if (this.mEngine != null)
    {
      ETDecoration.clearMap(this.mEngine);
      this.mEngine.native_resetEngine();
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: lconst_0
    //   1: putstatic 1537	ku:ba	J
    //   4: lconst_0
    //   5: putstatic 1539	ku:bb	J
    //   8: getstatic 271	ku:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: invokevirtual 1540	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   14: aload_0
    //   15: getfield 375	ku:I	Landroid/os/Handler;
    //   18: ifnull +11 -> 29
    //   21: aload_0
    //   22: getfield 375	ku:I	Landroid/os/Handler;
    //   25: aconst_null
    //   26: invokevirtual 1543	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   29: aload_0
    //   30: getfield 359	ku:mHandlerThread	Landroid/os/HandlerThread;
    //   33: ifnull +45 -> 78
    //   36: getstatic 1546	com/etrump/mixlayout/ETTextView:mCreateDecorationHandler	Landroid/os/Handler;
    //   39: ifnull +14 -> 53
    //   42: getstatic 1546	com/etrump/mixlayout/ETTextView:mCreateDecorationHandler	Landroid/os/Handler;
    //   45: aconst_null
    //   46: invokevirtual 1543	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   49: aconst_null
    //   50: putstatic 1546	com/etrump/mixlayout/ETTextView:mCreateDecorationHandler	Landroid/os/Handler;
    //   53: getstatic 1549	com/tencent/mobileqq/hiboom/HiBoomTextView:cX	Landroid/os/Handler;
    //   56: ifnull +14 -> 70
    //   59: getstatic 1549	com/tencent/mobileqq/hiboom/HiBoomTextView:cX	Landroid/os/Handler;
    //   62: aconst_null
    //   63: invokevirtual 1543	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   66: aconst_null
    //   67: putstatic 1549	com/tencent/mobileqq/hiboom/HiBoomTextView:cX	Landroid/os/Handler;
    //   70: aload_0
    //   71: getfield 359	ku:mHandlerThread	Landroid/os/HandlerThread;
    //   74: invokevirtual 1552	android/os/HandlerThread:quit	()Z
    //   77: pop
    //   78: aload_0
    //   79: getfield 548	ku:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   82: ifnull +53 -> 135
    //   85: aload_0
    //   86: getfield 229	ku:v	Ljava/lang/Object;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 548	ku:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   96: invokestatic 1529	com/etrump/mixlayout/ETDecoration:clearMap	(Lcom/etrump/mixlayout/ETEngine;)V
    //   99: aload_0
    //   100: getfield 548	ku:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   103: invokevirtual 1555	com/etrump/mixlayout/ETEngine:native_doneEngine	()V
    //   106: aload_1
    //   107: monitorexit
    //   108: aload_0
    //   109: getfield 548	ku:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   112: getfield 538	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   115: iconst_0
    //   116: invokevirtual 428	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   119: aload_0
    //   120: getfield 548	ku:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   123: getfield 546	com/etrump/mixlayout/ETEngine:isEngineReady	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   126: iconst_0
    //   127: invokevirtual 428	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 548	ku:mEngine	Lcom/etrump/mixlayout/ETEngine;
    //   135: aload_0
    //   136: getfield 559	ku:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   139: ifnull +53 -> 192
    //   142: aload_0
    //   143: getfield 229	ku:v	Ljava/lang/Object;
    //   146: astore_1
    //   147: aload_1
    //   148: monitorenter
    //   149: aload_0
    //   150: getfield 559	ku:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   153: invokestatic 1529	com/etrump/mixlayout/ETDecoration:clearMap	(Lcom/etrump/mixlayout/ETEngine;)V
    //   156: aload_0
    //   157: getfield 559	ku:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   160: invokevirtual 1555	com/etrump/mixlayout/ETEngine:native_doneEngine	()V
    //   163: aload_1
    //   164: monitorexit
    //   165: aload_0
    //   166: getfield 559	ku:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   169: getfield 538	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   172: iconst_0
    //   173: invokevirtual 428	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   176: aload_0
    //   177: getfield 559	ku:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   180: getfield 546	com/etrump/mixlayout/ETEngine:isEngineReady	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   183: iconst_0
    //   184: invokevirtual 428	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 559	ku:jdField_a_of_type_ComEtrumpMixlayoutETEngine	Lcom/etrump/mixlayout/ETEngine;
    //   192: invokestatic 1560	ahxo:a	()Lahxo;
    //   195: getfield 1562	ahxo:I	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   198: iconst_0
    //   199: invokevirtual 428	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   202: invokestatic 1560	ahxo:a	()Lahxo;
    //   205: getfield 1564	ahxo:H	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   208: iconst_0
    //   209: invokevirtual 428	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   212: aload_0
    //   213: getfield 234	ku:f	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   216: invokevirtual 1565	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   219: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +13 -> 235
    //   225: ldc_w 351
    //   228: iconst_2
    //   229: ldc_w 1567
    //   232: invokestatic 391	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: return
    //   236: astore_2
    //   237: aload_1
    //   238: monitorexit
    //   239: aload_2
    //   240: athrow
    //   241: astore_1
    //   242: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq -137 -> 108
    //   248: ldc_w 351
    //   251: iconst_2
    //   252: aload_1
    //   253: invokevirtual 1568	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   256: invokestatic 1255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: goto -151 -> 108
    //   262: astore_2
    //   263: aload_1
    //   264: monitorexit
    //   265: aload_2
    //   266: athrow
    //   267: astore_1
    //   268: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq -106 -> 165
    //   274: ldc_w 351
    //   277: iconst_2
    //   278: aload_1
    //   279: invokevirtual 1568	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   282: invokestatic 1255	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto -120 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	ku
    //   241	23	1	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   267	12	1	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   236	4	2	localObject2	Object
    //   262	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   92	108	236	finally
    //   237	239	236	finally
    //   85	92	241	java/lang/UnsatisfiedLinkError
    //   239	241	241	java/lang/UnsatisfiedLinkError
    //   149	165	262	finally
    //   263	265	262	finally
    //   142	149	267	java/lang/UnsatisfiedLinkError
    //   265	267	267	java/lang/UnsatisfiedLinkError
  }
  
  public int stopDownload(int paramInt)
  {
    ((VasQuickUpdateManager)this.mApp.getManager(184)).cancelDwonloadItem(5L, "font.main.android." + paramInt);
    this.y.put(Integer.valueOf(paramInt), Float.valueOf(3.0F));
    synchronized (this.V)
    {
      if (this.V.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "stopDownload font " + paramInt + " complete remove from list");
        }
        this.V.remove(Integer.valueOf(paramInt));
      }
      return 0;
    }
  }
  
  public boolean v(int paramInt)
  {
    if ((this.mEngine == null) || (!this.mEngine.isEngineReady.get())) {
      return false;
    }
    return this.mEngine.native_isFontLoaded(paramInt);
  }
  
  public void z(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.I.post(new FontManager.3(this, paramInt1));
    }
    do
    {
      return;
      ld.a().C(paramInt1, -102);
    } while ((TextUtils.isEmpty(this.dY)) || (this.jdField_a_of_type_Aqvd == null));
    Bundle localBundle = new Bundle();
    localBundle.putString("callbackId", this.dY);
    localBundle.putInt("srcType", 9);
    this.jdField_a_of_type_Aqvd.a(0L, -1, localBundle);
    this.dY = null;
  }
  
  public static abstract interface a
  {
    public abstract void eU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ku
 * JD-Core Version:    0.7.0.1
 */