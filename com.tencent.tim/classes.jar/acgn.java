import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.a;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.b;
import com.tencent.mobileqq.app.IndividualRedPacketManager.1;
import com.tencent.mobileqq.app.IndividualRedPacketManager.2;
import com.tencent.mobileqq.app.IndividualRedPacketManager.4;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class acgn
  implements Manager
{
  private static String TAG = "IndividualRedPacketManager";
  public static String bot = acbn.SDCARD_PATH + "RedPacket/";
  public static String bou = "0";
  public static int cvS = 10029;
  public static int cwa;
  public static int cwb = -1;
  public static int cwc;
  public static int cwd = -1;
  HandlerThread D;
  SharedPreferences L;
  public LinkedList<String> L;
  SharedPreferences M;
  acgn.b a;
  public aqqf a;
  Boolean an = Boolean.valueOf(false);
  QQAppInterface app;
  public AtomicBoolean cB;
  public AtomicBoolean cC = new AtomicBoolean(false);
  AtomicBoolean cD = new AtomicBoolean(false);
  public AtomicBoolean cf;
  public Handler ct;
  public int cvT = 0;
  int cvU = 0;
  int cvV = 0;
  int cvW = 0;
  int cvX = 0;
  int cvY = 0;
  public int cvZ = -1;
  ETEngine d;
  public ConcurrentHashMap<String, CustomizeStrategyFactory.RedPacketInfo> ea;
  public Comparator<File> fileComparator = new acgo(this);
  public int iCanUseRed = 0;
  public int iRedDisable = 0;
  ETFont mFont;
  AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  float mScale;
  float sQ = 0.0F;
  public String sRedPackRemard;
  
  public acgn(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    SharedPreferences localSharedPreferences = s();
    x(localSharedPreferences.getInt("sp_vip_info_can_use_packet", 0), localSharedPreferences.getInt("sp_vip_info_red_packet_disable", 0), false);
    ca(localSharedPreferences.getInt("sp_vip_info_red_packet_id", -1), localSharedPreferences.getString("sp_vip_info_red_packet_text", null));
    this.d = ETEngine.getInstanceForRedPacket();
    this.cf = new AtomicBoolean();
    this.cf.set(false);
    this.cB = new AtomicBoolean();
    this.cB.set(false);
    this.jdField_L_of_type_JavaUtilLinkedList = new LinkedList();
    this.mScale = paramQQAppInterface.getApp().getApplicationContext().getResources().getDisplayMetrics().density;
    this.cvT = ((int)(138.0F * this.mScale + 0.5D));
    this.cvU = ((int)(115.0F * this.mScale + 0.5D));
    this.cvW = ((int)(this.mScale * 280.0F + 0.5D));
    this.cvV = ((int)(this.mScale * 280.0F + 0.5D));
    this.cvY = ((int)(this.mScale * 104.0F + 0.5D));
    this.cvX = ((int)(320.0F * this.mScale + 0.5D));
    this.sQ = ((int)(this.mScale * 104.0F + 0.5D));
    this.ea = new ConcurrentHashMap();
    ThreadManager.post(new IndividualRedPacketManager.1(this), 8, null, true);
  }
  
  private Bitmap a(acgn.a parama, String paramString1, String paramString2, int paramInt)
  {
    Object localObject3 = a().a(paramString1, true);
    if ((localObject3 == null) || (((aqqf.e)localObject3).a == null) || (((aqqf.e)localObject3).b == null) || (((aqqf.e)localObject3).c == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "combineFinalImage init json fail, templateId:" + paramString1);
      }
      return null;
    }
    Object localObject2 = null;
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject1 = "#ffe589";
    Point localPoint = null;
    if (paramInt == 6)
    {
      localObject2 = b(paramString1, "", 2, ((aqqf.e)localObject3).version, ((aqqf.e)localObject3).type);
      i = aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).a.fontSize / 2);
      k = this.cvT;
      j = this.cvU;
      localPoint = new Point(aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).a.cJ.left / 2), aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).a.cJ.top / 2));
      localObject1 = "#ffe589";
    }
    for (;;)
    {
      localObject2 = c((String)localObject2, null);
      localObject3 = parama.eK;
      if (localObject2 != null) {
        break;
      }
      return null;
      if (paramInt == 7)
      {
        localObject2 = b(paramString1, "", 3, ((aqqf.e)localObject3).version, ((aqqf.e)localObject3).type);
        i = aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).b.fontSize / 2);
        k = this.cvV;
        j = this.cvW;
        localPoint = new Point(aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).b.cJ.left / 2), aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).b.cJ.top / 2));
        localObject1 = "#d13d4b";
      }
      else if (paramInt == 15)
      {
        localObject2 = b(paramString1, "", 14, ((aqqf.e)localObject3).version, ((aqqf.e)localObject3).type);
        i = aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).c.fontSize / 2);
        k = this.cvX;
        j = this.cvY;
        localPoint = new Point(aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).c.cJ.left / 2), aqcx.dip2px(this.app.getApp().getApplicationContext(), ((aqqf.e)localObject3).c.cJ.top / 2));
        localObject1 = "#edd4d8";
      }
    }
    try
    {
      paramString1 = Bitmap.createBitmap(k, j, Bitmap.Config.ARGB_8888);
      if (paramString1 == null) {
        return paramString1;
      }
    }
    catch (OutOfMemoryError parama)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "combineFinalImage Bitmap.createBitmap OutOfMemoryError: " + parama.getMessage());
      }
    }
    catch (Exception paramString1)
    {
      try
      {
        for (;;)
        {
          parama = new HashMap();
          parama.put("param_FailCode", "combineFinalImage");
          anpc.a(BaseApplicationImpl.sApplication.getApplicationContext()).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, parama, "", false);
          label630:
          return null;
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "combineFinalImage Bitmap.createBitmap Error: " + paramString1.getMessage());
          }
          paramString1 = null;
        }
        RectF localRectF = new RectF();
        Rect localRect = new Rect();
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        localPaint.setDither(true);
        localPaint.setFilterBitmap(true);
        Canvas localCanvas = new Canvas(paramString1);
        localRect.set(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        localRectF.set(0.0F, 0.0F, k, j);
        localCanvas.drawBitmap((Bitmap)localObject2, localRect, localRectF, localPaint);
        if (localObject3 != null) {
          if ((paramInt == 7) && (!parama.bHS))
          {
            localPaint.setColorFilter(new LightingColorFilter(0, 13712715));
            localRect.set(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight());
            localRectF.set(localPoint.x, localPoint.y, localPoint.x + i, localPoint.y + i);
            localCanvas.drawBitmap((Bitmap)localObject3, localRect, localRectF, localPaint);
          }
        }
        for (;;)
        {
          return paramString1;
          if ((paramInt != 15) || (parama.bHS)) {
            break;
          }
          localPaint.setColorFilter(new LightingColorFilter(0, 15586520));
          break;
          localPaint.setColor(Color.parseColor((String)localObject1));
          localPaint.setTextSize(i * 0.7F);
          parama = new float[1];
          localObject1 = localPaint.getFontMetricsInt();
          localPaint.getTextWidths(paramString2, parama);
          float f = localPoint.x;
          paramInt = (int)((i - parama[0]) / 2.0F + f);
          j = localPoint.y;
          k = ((Paint.FontMetricsInt)localObject1).ascent;
          i = (i - (((Paint.FontMetricsInt)localObject1).descent - ((Paint.FontMetricsInt)localObject1).ascent)) / 2;
          localCanvas.drawText(paramString2, paramInt, j - k + i, localPaint);
        }
      }
      catch (Exception parama)
      {
        break label630;
      }
    }
  }
  
  @Nullable
  private static aqqf.e a(acgn arg0, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString1, String paramString2, aqqf paramaqqf)
  {
    aqqf.e locale2 = paramaqqf.a(paramString1, true);
    aqqf.e locale1;
    if ((locale2 != null) && (locale2.a != null) && (locale2.b != null))
    {
      locale1 = locale2;
      if (locale2.c != null) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "VIPHBStrategy.get not in local map. Id = " + paramString1 + "content = " + paramString2 + "mTemplateInfoMap.size=" + paramaqqf.p.size());
      }
      ???.ea.putIfAbsent(paramRedPacketInfo.Qi, paramRedPacketInfo);
      ???.ea.putIfAbsent(paramRedPacketInfo.Qi + "_tp", paramRedPacketInfo);
    }
    synchronized (paramaqqf.oi)
    {
      if (!paramaqqf.oi.containsKey(paramString1))
      {
        paramString2 = new ArrayList();
        paramString2.add(paramRedPacketInfo.Qi);
        paramaqqf.oi.put(paramString1, paramString2);
        paramaqqf.v(16L, paramString1, paramRedPacketInfo.Qi);
        locale1 = null;
        return locale1;
      }
      ((List)paramaqqf.oi.get(paramString1)).add(paramRedPacketInfo.Qi);
    }
  }
  
  public static String a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) && ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {}
    for (Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();; localObject = paramQQAppInterface)
    {
      if (localObject == null)
      {
        localObject = "";
        return localObject;
      }
      acgn localacgn;
      if (localObject == null)
      {
        localacgn = null;
        label43:
        if (localacgn == null) {
          break label343;
        }
        if (!localacgn.aas()) {
          break label205;
        }
        paramQQAppInterface = "1";
      }
      label60:
      label205:
      label337:
      label340:
      label343:
      for (QQAppInterface localQQAppInterface = paramQQAppInterface;; localQQAppInterface = null)
      {
        paramQQAppInterface = aqqj.o(((QQAppInterface)localObject).getApp().getApplicationContext(), "hongbao", "");
        if (1 == paramInt)
        {
          if (TextUtils.isEmpty(paramQQAppInterface)) {
            break label340;
          }
          paramQQAppInterface = paramQQAppInterface.replace("[from]", "1");
        }
        for (;;)
        {
          anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, localQQAppInterface, "1", "", "");
          localObject = paramQQAppInterface;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(TAG, 2, "IndividualRedPacketManager.getMallURL=" + null + ", type:" + paramInt + ", url:" + paramQQAppInterface);
          return paramQQAppInterface;
          localacgn = (acgn)((QQAppInterface)localObject).getManager(131);
          break label43;
          paramQQAppInterface = "0";
          break label60;
          if (3 == paramInt) {
            if ((localacgn != null) && (localacgn.aat()) && (localacgn.a().cVD))
            {
              if (TextUtils.isEmpty(paramQQAppInterface)) {
                break label337;
              }
              paramQQAppInterface = paramQQAppInterface.replace("[from]", "3");
            }
          }
          for (;;)
          {
            anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, localQQAppInterface, "1", "", "");
            break;
            paramQQAppInterface = null;
            break;
            localObject = aqqj.o(((QQAppInterface)localObject).getApp().getApplicationContext(), "hongbao", "");
            paramQQAppInterface = (QQAppInterface)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            paramQQAppInterface = ((String)localObject).replace("[from]", "2");
            break;
          }
        }
      }
    }
  }
  
  private static String a(acgn paramacgn, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramString3 = paramacgn.k(paramString1, paramString2, 18);
    }
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString3;
        if (!TextUtils.isEmpty(paramacgn.k("", paramString2, 16))) {}
      }
      else
      {
        str = paramacgn.k(paramString1, paramString2, 15);
      }
    }
    return str;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if (paramInt1 == aqqf.e.ebF) {
      paramString5 = dy(1) + paramString1 + File.separator + paramString5;
    }
    do
    {
      do
      {
        do
        {
          return paramString5;
          paramString5 = paramString3;
        } while (TextUtils.isEmpty(paramString2));
        paramString5 = paramString3;
      } while (paramInt1 != aqqf.e.ebE);
      paramString1 = dy(paramInt2) + paramString1 + paramString6 + Integer.toHexString(paramString2.charAt(0));
      paramString5 = paramString1;
    } while (paramString4 == null);
    return paramString1 + paramString4;
  }
  
  private void a(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    int i;
    if (paramInt == 2) {
      i = 6;
    }
    Bitmap localBitmap;
    for (;;)
    {
      acgn.a locala = a(paramRedPacketInfo.content, i);
      localBitmap = a(locala, paramRedPacketInfo, i);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onDoneDownloadBG type = " + i);
      }
      if ((locala.eK != null) && (!locala.bHS)) {
        a(locala.eK, "", paramRedPacketInfo.content, 5);
      }
      if ((6 == i) && (locala.eK != null) && (localBitmap != null))
      {
        if (locala.bHT) {
          break;
        }
        a(localBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.content, 6);
      }
      return;
      if (paramInt == 3)
      {
        i = 7;
      }
      else
      {
        i = paramInt;
        if (paramInt == 14) {
          i = 15;
        }
      }
    }
    a(localBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.content, 12);
  }
  
  private void a(acgn.a parama, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, int paramInt, Bitmap paramBitmap)
  {
    if (paramInt == 6) {
      paramRedPacketInfo.dv = paramBitmap;
    }
    do
    {
      return;
      if (paramInt == 7)
      {
        if (parama.bHT)
        {
          a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.content, 13);
          return;
        }
        a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.content, 7);
        return;
      }
    } while (paramInt != 15);
    if (parama.bHT)
    {
      a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.content, 18);
      return;
    }
    a(paramBitmap, paramRedPacketInfo.templateId, paramRedPacketInfo.content, 15);
  }
  
  private static void a(acgn paramacgn, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString1, aqqf.e parame, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (parame.fontId == 1) {
        break label34;
      }
      paramString1 = paramacgn.a(paramString1, paramInt);
    }
    for (;;)
    {
      paramacgn.a(paramString1, paramRedPacketInfo, paramInt);
      return;
      label34:
      paramString1 = new acgn.a();
      paramString1.isDefault = true;
    }
  }
  
  private static void a(acgn paramacgn, String paramString1, String paramString2, acgn.a parama, Bitmap paramBitmap)
  {
    if ((parama != null) && (parama.eK != null) && (!parama.bHS) && (!parama.isDefault)) {
      paramacgn.a(parama.eK, "", paramString2, 5);
    }
    if ((paramBitmap != null) && ((parama.eK != null) || (parama.isDefault)))
    {
      if (parama.bHT) {
        paramacgn.a(paramBitmap, paramString1, paramString2, 12);
      }
    }
    else {
      return;
    }
    paramacgn.a(paramBitmap, paramString1, paramString2, 6);
  }
  
  public static void a(AppInterface paramAppInterface, acgn paramacgn, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((paramacgn == null) || (paramRedPacketInfo == null)) {
      return;
    }
    for (;;)
    {
      String str1;
      aqqf.e locale;
      try
      {
        str1 = paramRedPacketInfo.templateId;
        String str2 = paramRedPacketInfo.content;
        paramAppInterface = paramacgn.a();
        locale = a(paramacgn, paramRedPacketInfo, str1, str2, paramAppInterface);
        if (locale == null) {
          break;
        }
        if ((!TextUtils.isEmpty(str2)) && (paramAppInterface.c.Cu().contains(str2)))
        {
          bool = true;
          if (locale.type != aqqf.e.ebE) {
            break label338;
          }
          if (!bool) {
            break label406;
          }
          paramAppInterface = paramacgn.k(str1, str2, 12);
          localObject1 = paramAppInterface;
          if (TextUtils.isEmpty(paramAppInterface)) {
            if (!TextUtils.isEmpty(str2))
            {
              localObject1 = paramAppInterface;
              if (!TextUtils.isEmpty(paramacgn.k("", str2, 9))) {}
            }
            else
            {
              localObject1 = paramacgn.k(str1, str2, 6);
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label370;
          }
          if (locale.fontId == 1) {
            break label354;
          }
          paramAppInterface = paramacgn.a(str2, 6);
          localObject1 = paramacgn.a(paramAppInterface, paramRedPacketInfo, 6);
          localAppInterface = paramAppInterface;
          if ((locale.type != aqqf.e.ebE) || (!bool)) {
            break label401;
          }
          paramAppInterface = paramacgn.k(str1, str2, 13);
          Object localObject2 = paramAppInterface;
          if (TextUtils.isEmpty(paramAppInterface)) {
            if (!TextUtils.isEmpty(str2))
            {
              localObject2 = paramAppInterface;
              if (!TextUtils.isEmpty(paramacgn.k("", str2, 10))) {}
            }
            else
            {
              localObject2 = paramacgn.k(str1, str2, 7);
            }
          }
          a(paramacgn, paramRedPacketInfo, str2, locale, (String)localObject2, 7);
          if (locale.type != aqqf.e.ebE) {
            break label396;
          }
          paramAppInterface = a(paramacgn, str1, str2, null, bool);
          a(paramacgn, paramRedPacketInfo, str2, locale, paramAppInterface, 15);
          a(paramacgn, str1, str2, localAppInterface, (Bitmap)localObject1);
          break;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label338:
      if (a(paramacgn, paramRedPacketInfo, str1, paramAppInterface, locale)) {
        break;
      }
      break label406;
      label354:
      paramAppInterface = new acgn.a();
      paramAppInterface.isDefault = true;
      continue;
      label370:
      paramRedPacketInfo.dv = c((String)localObject1, null);
      CustomizeStrategyFactory.a().b(paramRedPacketInfo);
      Object localObject1 = null;
      AppInterface localAppInterface = null;
      continue;
      label396:
      paramAppInterface = null;
      continue;
      label401:
      paramAppInterface = null;
      continue;
      label406:
      paramAppInterface = null;
    }
  }
  
  private boolean a(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aqqf.e parame, boolean paramBoolean)
  {
    if (paramInt == 19)
    {
      Object localObject = parame.a;
      boolean bool = paramBoolean;
      if (localObject != null)
      {
        bool = paramBoolean;
        if (((aqqf.b)localObject).a != null)
        {
          localObject = b(((aqqf.b)localObject).id, null, ((aqqf.b)localObject).resType, ((aqqf.b)localObject).version, 0);
          File localFile = new File((String)localObject);
          if ((localFile != null) && (localFile.exists()) && (localFile.isFile())) {
            a(parame, paramRedPacketInfo, (String)localObject, false);
          }
          bool = paramBoolean;
          if (paramRedPacketInfo.a != null) {
            bool = true;
          }
        }
      }
      return bool;
    }
    if (paramInt == 2) {
      paramRedPacketInfo.dv = c(k(parame.id, "", 6), null);
    }
    return true;
  }
  
  private static boolean a(acgn paramacgn, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString, aqqf paramaqqf, aqqf.e parame)
  {
    File localFile = null;
    boolean bool2 = false;
    aqqf.b localb = parame.a;
    if ((localb != null) && (localb.a != null))
    {
      if ((paramRedPacketInfo.a != null) && (!TextUtils.isEmpty(paramRedPacketInfo.a.aSI))) {
        CustomizeStrategyFactory.a().b(paramRedPacketInfo);
      }
      do
      {
        return true;
        String str = b(localb.id, null, localb.resType, localb.version, 0);
        if (!TextUtils.isEmpty(str)) {
          localFile = new File(str);
        }
        if (localFile == null)
        {
          QLog.d(TAG, 2, "VIPHBStrategy.get animFolderPath file == null, zipPath=" + str);
          return true;
        }
        bool1 = bool2;
        if (!localFile.exists()) {
          break;
        }
        bool1 = bool2;
        if (!localFile.isFile()) {
          break;
        }
        bool1 = a(parame, paramRedPacketInfo, str, false);
        if ((QLog.isColorLevel()) || (!bool1)) {
          QLog.d(TAG, 2, "VIPHBStrategy.get animFolderPath getPathOk=" + bool1 + ", zipPath=" + str);
        }
      } while (bool1);
      boolean bool1 = true;
      paramacgn.ea.putIfAbsent(paramRedPacketInfo.Qi, paramRedPacketInfo);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "wait animConfig id = " + paramString + ", exist = " + bool1 + ", name=" + localb.name);
      }
      paramaqqf.v(16L, paramString, paramRedPacketInfo.Qi);
      return true;
    }
    return false;
  }
  
  static boolean a(aqqf.e parame, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, String paramString, boolean paramBoolean)
  {
    if ((parame == null) || (parame.a == null) || (paramRedPacketInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e(TAG, 2, "getAnimatePath Exception 0.zipPath=" + paramString);
      paramBoolean = false;
      return paramBoolean;
    }
    aqqf.b localb = parame.a;
    for (;;)
    {
      Object localObject1;
      String[] arrayOfString;
      boolean bool1;
      int i;
      String str;
      try
      {
        localObject1 = paramString + "_dir2";
        File localFile = new File((String)localObject1);
        if ((!localFile.exists()) || (!localFile.isDirectory())) {
          break label744;
        }
        arrayOfString = localFile.list();
        if (arrayOfString.length <= 0) {
          break label735;
        }
        bool1 = true;
        i = 0;
        if (i >= arrayOfString.length) {
          break label729;
        }
        str = localFile.getAbsolutePath() + File.separator + arrayOfString[i];
        Object localObject2 = new File(str);
        if (!((File)localObject2).exists()) {
          break label756;
        }
        if (!((File)localObject2).isDirectory()) {
          break label590;
        }
        localObject2 = ((File)localObject2).list();
        if (localObject2.length <= 0) {
          break label526;
        }
        i = localObject2.length;
        localObject1 = str;
        if ((QLog.isColorLevel()) || (i == 0)) {
          QLog.d(TAG, 2, "getAnimatePath picNum Err id:" + paramRedPacketInfo.templateId + ", fileNames=" + arrayOfString + ", unZipDir=" + (String)localObject1 + ", picNum=" + i + ", size=" + localb.a.size);
        }
        if ((!paramBoolean) || ((i == localb.a.size) && (i != 0))) {
          break label753;
        }
        aqri.a(null, "individual_v2_redpacket_json_err", "animConfig_size_err", "animConfig_size_err, id=" + paramRedPacketInfo.templateId, null, 0.0F);
      }
      catch (Exception parame)
      {
        QLog.e(TAG, 2, "getAnimatePath Exception id:" + paramRedPacketInfo.templateId + ", name=" + localb.name);
        return false;
      }
      boolean bool2 = bool1;
      if (!paramBoolean)
      {
        bool2 = bool1;
        if (!bool1)
        {
          bool1 = aqqf.bU(paramString, (String)localObject1);
          bool2 = bool1;
          if (bool1)
          {
            bool1 = a(parame, paramRedPacketInfo, paramString, true);
            paramBoolean = bool1;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(TAG, 2, "set animConfig id:" + paramRedPacketInfo.templateId + ", name=" + localb.name + " isRegetOk=" + bool1);
            return bool1;
            label526:
            if (!QLog.isColorLevel()) {
              break label756;
            }
            QLog.d(TAG, 2, "getAnimatePath Err_path id:" + paramRedPacketInfo.templateId + ", path=" + str + ", name=" + localb.name);
            break label756;
            label590:
            i = arrayOfString.length;
            continue;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "set animConfig end name=" + localb.name + ", id=" + paramRedPacketInfo.templateId + ", picNum=" + i + ", fileExist=" + bool2 + ", isUnZipBack=" + paramBoolean + ", unZipDir = " + (String)localObject1);
      }
      if (bool2)
      {
        localb.a.aSI = ((String)localObject1);
        paramRedPacketInfo.a = localb.a;
        paramRedPacketInfo.aHx = true;
        CustomizeStrategyFactory.a().b(paramRedPacketInfo);
        return true;
        label729:
        i = 0;
        continue;
        label735:
        i = 0;
        bool1 = false;
        continue;
        label744:
        bool1 = false;
        i = 0;
        continue;
        label753:
        continue;
        label756:
        i += 1;
      }
    }
  }
  
  private boolean a(String paramString, int paramInt, acgn.a parama)
  {
    boolean bool = false;
    Object localObject = this.app.getApplication().getApplicationContext().getResources().getAssets();
    if (6 == paramInt) {}
    for (;;)
    {
      try
      {
        localObject = ((AssetManager)localObject).open("specialFont/aio/" + Integer.toHexString(paramString.charAt(0)));
        parama.eK = BitmapFactory.decodeStream((InputStream)localObject);
        parama.bHT = true;
        ((InputStream)localObject).close();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(TAG, 2, "getPersonalFontImg success! Special char = " + paramString);
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.d(TAG, 2, "getPersonalFontImg assets oom:" + paramString.getMessage());
        return false;
      }
      catch (IOException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label272;
        }
        QLog.d(TAG, 2, paramString.getMessage());
        return false;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          break label272;
        }
        QLog.d(TAG, 2, paramString.getMessage());
        return false;
        bool = true;
      }
      if (7 == paramInt) {
        localObject = ((AssetManager)localObject).open("specialFont/tp/" + Integer.toHexString(paramString.charAt(0)));
      } else {
        localObject = ((AssetManager)localObject).open("specialFont/send/" + Integer.toHexString(paramString.charAt(0)));
      }
    }
    label272:
    return bool;
  }
  
  public static String b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    String str5 = "";
    String str3 = null;
    String str4 = null;
    String str2 = null;
    String str1 = str5;
    switch (paramInt1)
    {
    default: 
      str1 = str5;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
        QLog.d(TAG, 2, "getLocalImgAddress Error templateId: " + paramString1 + ", name:" + paramString2 + ", type:" + paramInt1 + ", filename:" + str1);
      }
      return str1;
      str1 = dy(3) + "font.ttf";
      continue;
      str1 = dy(3) + "config.json";
      continue;
      str1 = j(paramString2, "", 5);
      continue;
      str1 = j(paramString2, "", 4);
      continue;
      str1 = dy(0) + "specialzip";
      continue;
      str1 = dy(2) + "specialCharItem.zip";
      continue;
      str1 = dy(2) + "config.json";
      continue;
      str1 = y(paramString2, "", "aio");
      continue;
      str1 = y(paramString2, "", "tp");
      continue;
      str1 = y(paramString2, "", "send");
      continue;
      str2 = "_s";
      str1 = a(paramString1, paramString2, paramInt3, "", str2, "aioimg", 6, "_aio_");
      continue;
      str3 = "_s";
      str1 = a(paramString1, paramString2, paramInt3, "", str3, "redenvelopeimg", 7, "_tp_");
      continue;
      str4 = "_s";
      str1 = a(paramString1, paramString2, paramInt3, "", str4, "sendimg", 8, "_send_");
      continue;
      str1 = dy(1) + paramString1;
      continue;
      str1 = dy(1) + paramString1 + File.separator + "aioimg";
      continue;
      str1 = dy(1) + paramString1 + File.separator + "redenvelopeimg";
      continue;
      str1 = dy(1) + paramString1 + File.separator + "sendimg";
      continue;
      str1 = dy(1) + paramString1 + File.separator + "aiopng.zip";
      continue;
      str1 = dy(1) + paramString1 + File.separator + "config.json";
    }
  }
  
  /* Error */
  public static Bitmap c(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload 6
    //   11: astore 4
    //   13: getstatic 920	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   16: aload_0
    //   17: invokevirtual 923	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: ifnull +375 -> 395
    //   23: aload 5
    //   25: astore_3
    //   26: aload 6
    //   28: astore 4
    //   30: getstatic 920	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   33: aload_0
    //   34: invokevirtual 923	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 355	android/graphics/Bitmap
    //   40: astore 5
    //   42: aload 5
    //   44: astore_3
    //   45: aload_3
    //   46: astore 4
    //   48: aload_3
    //   49: ifnonnull +343 -> 392
    //   52: aload_1
    //   53: astore 6
    //   55: aload_1
    //   56: ifnonnull +32 -> 88
    //   59: aload_3
    //   60: astore 4
    //   62: aload_3
    //   63: astore 5
    //   65: new 925	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 926	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 6
    //   74: aload_3
    //   75: astore 4
    //   77: aload_3
    //   78: astore 5
    //   80: aload 6
    //   82: getstatic 929	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   85: putfield 932	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   88: aload_3
    //   89: astore 4
    //   91: aload_3
    //   92: astore 5
    //   94: aload_0
    //   95: aload 6
    //   97: invokestatic 937	aqcu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Laqcu$a;
    //   100: astore 7
    //   102: aload_3
    //   103: astore 4
    //   105: aload_3
    //   106: astore 5
    //   108: aload 7
    //   110: getfield 942	aqcu$a:bmp	Landroid/graphics/Bitmap;
    //   113: astore_1
    //   114: aload_1
    //   115: astore 4
    //   117: aload_1
    //   118: astore 5
    //   120: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +50 -> 173
    //   126: aload_1
    //   127: astore 4
    //   129: aload_1
    //   130: astore 5
    //   132: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   135: iconst_2
    //   136: new 77	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 944
    //   146: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 946
    //   156: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: getfield 949	aqcu$a:iResult	I
    //   164: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_1
    //   174: astore 4
    //   176: aload_1
    //   177: astore 5
    //   179: aload 7
    //   181: getfield 949	aqcu$a:iResult	I
    //   184: istore_2
    //   185: aload_1
    //   186: astore 4
    //   188: iload_2
    //   189: iconst_1
    //   190: if_icmpne +202 -> 392
    //   193: iconst_2
    //   194: istore_2
    //   195: aload_1
    //   196: astore 4
    //   198: iload_2
    //   199: iconst_4
    //   200: if_icmpgt +130 -> 330
    //   203: aload_1
    //   204: astore_3
    //   205: aload_1
    //   206: astore 4
    //   208: aload 6
    //   210: iload_2
    //   211: putfield 952	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   214: aload_1
    //   215: astore_3
    //   216: aload_1
    //   217: astore 4
    //   219: aload_0
    //   220: aload 6
    //   222: invokestatic 937	aqcu:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Laqcu$a;
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload_1
    //   230: astore 4
    //   232: aload 5
    //   234: getfield 942	aqcu$a:bmp	Landroid/graphics/Bitmap;
    //   237: astore_1
    //   238: aload_1
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload 5
    //   245: getfield 949	aqcu$a:iResult	I
    //   248: iconst_1
    //   249: if_icmpeq +151 -> 400
    //   252: aload_1
    //   253: astore_3
    //   254: aload_1
    //   255: astore 4
    //   257: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +18 -> 278
    //   263: aload_1
    //   264: astore_3
    //   265: aload_1
    //   266: astore 4
    //   268: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   271: iconst_2
    //   272: ldc_w 954
    //   275: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_1
    //   279: astore_3
    //   280: new 368	java/util/HashMap
    //   283: dup
    //   284: invokespecial 369	java/util/HashMap:<init>	()V
    //   287: astore 4
    //   289: aload_1
    //   290: astore_3
    //   291: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   294: invokevirtual 384	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   297: invokestatic 389	anpc:a	(Landroid/content/Context;)Lanpc;
    //   300: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   303: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   306: checkcast 211	com/tencent/mobileqq/app/QQAppInterface
    //   309: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   312: ldc_w 956
    //   315: iconst_0
    //   316: lconst_1
    //   317: lconst_0
    //   318: aload 4
    //   320: ldc_w 299
    //   323: iconst_0
    //   324: invokevirtual 402	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   327: aload_1
    //   328: astore 4
    //   330: aload 4
    //   332: astore_3
    //   333: new 368	java/util/HashMap
    //   336: dup
    //   337: invokespecial 369	java/util/HashMap:<init>	()V
    //   340: astore_1
    //   341: aload 4
    //   343: astore_3
    //   344: aload_1
    //   345: ldc_w 371
    //   348: ldc 101
    //   350: invokevirtual 377	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   353: pop
    //   354: aload 4
    //   356: astore_3
    //   357: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   360: invokevirtual 384	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   363: invokestatic 389	anpc:a	(Landroid/content/Context;)Lanpc;
    //   366: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   369: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   372: checkcast 211	com/tencent/mobileqq/app/QQAppInterface
    //   375: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   378: ldc_w 958
    //   381: iconst_0
    //   382: lconst_1
    //   383: lconst_0
    //   384: aload_1
    //   385: ldc_w 299
    //   388: iconst_0
    //   389: invokevirtual 402	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   392: aload 4
    //   394: areturn
    //   395: aconst_null
    //   396: astore_3
    //   397: goto -352 -> 45
    //   400: iload_2
    //   401: iconst_2
    //   402: imul
    //   403: istore_2
    //   404: goto -209 -> 195
    //   407: astore_0
    //   408: aload 4
    //   410: areturn
    //   411: astore_1
    //   412: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +43 -> 458
    //   418: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   421: iconst_2
    //   422: new 77	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 944
    //   432: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_0
    //   436: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: ldc_w 960
    //   442: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_1
    //   446: invokevirtual 364	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: new 368	java/util/HashMap
    //   461: dup
    //   462: invokespecial 369	java/util/HashMap:<init>	()V
    //   465: astore_0
    //   466: aload_0
    //   467: ldc_w 371
    //   470: ldc_w 566
    //   473: invokevirtual 377	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   476: pop
    //   477: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   480: invokevirtual 384	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   483: invokestatic 389	anpc:a	(Landroid/content/Context;)Lanpc;
    //   486: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   489: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   492: checkcast 211	com/tencent/mobileqq/app/QQAppInterface
    //   495: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   498: ldc_w 958
    //   501: iconst_0
    //   502: lconst_1
    //   503: lconst_0
    //   504: aload_0
    //   505: ldc_w 299
    //   508: iconst_0
    //   509: invokevirtual 402	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   512: aload_3
    //   513: areturn
    //   514: astore_1
    //   515: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +43 -> 561
    //   521: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   524: iconst_2
    //   525: new 77	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 944
    //   535: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_0
    //   539: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 962
    //   545: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload_1
    //   549: invokevirtual 405	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   552: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: new 368	java/util/HashMap
    //   564: dup
    //   565: invokespecial 369	java/util/HashMap:<init>	()V
    //   568: astore_0
    //   569: aload_0
    //   570: ldc_w 371
    //   573: ldc_w 566
    //   576: invokevirtual 377	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   583: invokevirtual 384	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   586: invokestatic 389	anpc:a	(Landroid/content/Context;)Lanpc;
    //   589: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   592: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   595: checkcast 211	com/tencent/mobileqq/app/QQAppInterface
    //   598: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   601: ldc_w 964
    //   604: iconst_0
    //   605: lconst_1
    //   606: lconst_0
    //   607: aload_0
    //   608: ldc_w 299
    //   611: iconst_0
    //   612: invokevirtual 402	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   615: aload 4
    //   617: areturn
    //   618: astore_0
    //   619: aload 4
    //   621: areturn
    //   622: astore_1
    //   623: goto -108 -> 515
    //   626: astore_0
    //   627: goto -115 -> 512
    //   630: astore_1
    //   631: aload 5
    //   633: astore_3
    //   634: goto -222 -> 412
    //   637: astore_3
    //   638: aload_1
    //   639: astore 4
    //   641: goto -311 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	paramString	String
    //   0	644	1	paramOptions	android.graphics.BitmapFactory.Options
    //   184	220	2	i	int
    //   8	626	3	localObject1	Object
    //   637	1	3	localException	Exception
    //   11	629	4	localObject2	Object
    //   4	628	5	localObject3	Object
    //   1	220	6	localOptions	android.graphics.BitmapFactory.Options
    //   100	80	7	locala	aqcu.a
    // Exception table:
    //   from	to	target	type
    //   333	341	407	java/lang/Exception
    //   344	354	407	java/lang/Exception
    //   357	392	407	java/lang/Exception
    //   13	23	411	java/lang/OutOfMemoryError
    //   30	42	411	java/lang/OutOfMemoryError
    //   208	214	411	java/lang/OutOfMemoryError
    //   219	227	411	java/lang/OutOfMemoryError
    //   232	238	411	java/lang/OutOfMemoryError
    //   243	252	411	java/lang/OutOfMemoryError
    //   257	263	411	java/lang/OutOfMemoryError
    //   268	278	411	java/lang/OutOfMemoryError
    //   280	289	411	java/lang/OutOfMemoryError
    //   291	327	411	java/lang/OutOfMemoryError
    //   333	341	411	java/lang/OutOfMemoryError
    //   344	354	411	java/lang/OutOfMemoryError
    //   357	392	411	java/lang/OutOfMemoryError
    //   13	23	514	java/lang/Exception
    //   30	42	514	java/lang/Exception
    //   208	214	514	java/lang/Exception
    //   219	227	514	java/lang/Exception
    //   232	238	514	java/lang/Exception
    //   243	252	514	java/lang/Exception
    //   257	263	514	java/lang/Exception
    //   268	278	514	java/lang/Exception
    //   561	615	618	java/lang/Exception
    //   65	74	622	java/lang/Exception
    //   80	88	622	java/lang/Exception
    //   94	102	622	java/lang/Exception
    //   108	114	622	java/lang/Exception
    //   120	126	622	java/lang/Exception
    //   132	173	622	java/lang/Exception
    //   179	185	622	java/lang/Exception
    //   458	512	626	java/lang/Exception
    //   65	74	630	java/lang/OutOfMemoryError
    //   80	88	630	java/lang/OutOfMemoryError
    //   94	102	630	java/lang/OutOfMemoryError
    //   108	114	630	java/lang/OutOfMemoryError
    //   120	126	630	java/lang/OutOfMemoryError
    //   132	173	630	java/lang/OutOfMemoryError
    //   179	185	630	java/lang/OutOfMemoryError
    //   280	289	637	java/lang/Exception
    //   291	327	637	java/lang/Exception
  }
  
  public static String dy(int paramInt)
  {
    String str = bot;
    switch (paramInt)
    {
    case 0: 
    default: 
      return str;
    case 1: 
      return aqul.getSDKPrivatePath(new StringBuilder().append(acbn.SDCARD_PATH).append("pddata/vas/").toString()) + "RedPacket/packets/";
    case 2: 
      return aqul.getSDKPrivatePath(new StringBuilder().append(acbn.SDCARD_PATH).append("pddata/vas/").toString()) + "RedPacket/specialFont/";
    case 3: 
      return aqul.getSDKPrivatePath(new StringBuilder().append(acbn.SDCARD_PATH).append("pddata/vas/").toString()) + "RedPacket/font/";
    case 4: 
      return str + "fontimgprecreate/";
    case 5: 
      return str + "personalfontimg/";
    case 6: 
      return str + "AIOfinalimg/";
    case 7: 
      return str + "TENPAYfinalimg/";
    }
    return str + "SENDfinalimg/";
  }
  
  public static String getIDFromSCID(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(TAG, 1, "getIDFromSCID error null: zipName=" + paramString);
      localObject2 = localObject1;
    }
    do
    {
      return localObject2;
      localObject1 = localObject2;
      if (paramString.length() > "luckyMoney.item.".length())
      {
        localObject1 = localObject2;
        if (paramString.indexOf("luckyMoney.item.") >= 0) {
          localObject1 = paramString.substring("luckyMoney.item.".length());
        }
      }
      if (QLog.isColorLevel()) {
        break;
      }
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    QLog.d(TAG, 2, "getIDFromSCID ok, scid = " + paramString + ", redPacketid=" + (String)localObject1);
    return localObject1;
  }
  
  private static String j(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2 = dy(paramInt) + Integer.toHexString(paramString1.charAt(0));
    }
    return paramString2;
  }
  
  private static String y(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2 = dy(2) + "images" + File.separator + paramString3 + File.separator + Integer.toHexString(paramString1.charAt(0));
    }
    return paramString2;
  }
  
  public void EY(boolean paramBoolean)
  {
    Object localObject = new String[9];
    localObject[0] = dy(1);
    localObject[1] = dy(3);
    localObject[2] = dy(1);
    localObject[3] = dy(5);
    localObject[4] = dy(4);
    localObject[5] = dy(6);
    localObject[6] = dy(7);
    localObject[7] = dy(8);
    localObject[8] = dy(2);
    int k = 0;
    int m;
    int j;
    for (int i = 0; k < localObject.length; i = m)
    {
      File localFile = new File(localObject[k]);
      if (localFile.exists())
      {
        m = i;
        if (localFile.isDirectory()) {}
      }
      else
      {
        bool1 = localFile.mkdirs();
        j = i;
        if (!bool1) {
          j = i + 1;
        }
        m = j;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "initDir path:" + localObject[k] + ", mkdirs:" + bool1 + ", errCode:" + j);
          m = j;
        }
      }
      k += 1;
    }
    boolean bool2;
    if (i <= 0)
    {
      j = 1;
      if (j == 0)
      {
        bool2 = aqwu.f(this.app.getApplication(), TAG, false);
        localObject = this.cC;
        if (bool2) {
          break label389;
        }
      }
    }
    label389:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((AtomicBoolean)localObject).set(bool1);
      QLog.e(TAG, 2, "initDir Err haveSDCard:" + bool2 + ", mIsSDCardError:" + this.cC.get() + ", errCode:" + i);
      if ((this.cC.get()) && (paramBoolean))
      {
        bot = this.app.getApplication().getFilesDir() + File.separator + "dRedPacket/";
        EY(false);
      }
      return;
      j = 0;
      break;
    }
  }
  
  public void Ea(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = t().getString("cach_font_id", "");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(a().a.id)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "Clear SDCard Cache Start!");
      }
      localObject = new String[5];
      localObject[0] = dy(4);
      localObject[1] = dy(5);
      localObject[2] = dy(6);
      localObject[3] = dy(7);
      localObject[4] = dy(8);
      int i = 0;
      while (i < localObject.length)
      {
        File localFile1 = new File(localObject[i]);
        if ((localFile1.exists()) && (localFile1.isDirectory()))
        {
          File[] arrayOfFile = localFile1.listFiles();
          int j = 0;
          while (j < arrayOfFile.length)
          {
            File localFile2 = new File(arrayOfFile[j].getParent() + File.separator + System.currentTimeMillis());
            arrayOfFile[j].renameTo(localFile2);
            localFile2.delete();
            j += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Clear " + localFile1.getAbsolutePath() + " done!");
          }
        }
        i += 1;
      }
    }
    t().edit().putString("cach_font_id", paramString).commit();
  }
  
  public acgn.a a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    acgn.a locala = new acgn.a();
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (a().c.Cu().contains(paramString)))
    {
      locala.bHS = true;
      if ((TextUtils.isEmpty(a().c.cvb)) || (!a().c.cvb.contains(paramString))) {
        break label499;
      }
      int i = 16;
      if (6 == paramInt) {
        i = 9;
      }
      for (;;)
      {
        localObject1 = b(null, paramString, i, 0, 0);
        k("", paramString, i);
        if (!new File((String)localObject1).exists()) {
          break;
        }
        locala.eK = c((String)localObject1, null);
        locala.bHT = true;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getPersonalFontImg success! Special char = " + paramString);
        }
        return locala;
        if (7 == paramInt) {
          i = 10;
        }
      }
      if (!TextUtils.isEmpty(t().getString("special_unzip_version_key", ""))) {
        t().edit().putString("special_unzip_version_key", "").commit();
      }
    }
    Object localObject3 = b("", paramString, 4, 0, 0);
    for (Object localObject2 = new File((String)localObject3);; localObject2 = localObject3)
    {
      for (;;)
      {
        synchronized (this.jdField_L_of_type_JavaUtilLinkedList)
        {
          if (((File)localObject2).exists())
          {
            localObject1 = localObject3;
            if (!this.jdField_L_of_type_JavaUtilLinkedList.contains(localObject3)) {}
          }
          else
          {
            String str = b("", paramString, 5, 0, 0);
            localObject3 = new File(str);
            if (!((File)localObject3).exists()) {
              break label600;
            }
            localObject2 = localObject3;
            localObject1 = str;
            if (this.jdField_L_of_type_JavaUtilLinkedList.contains(str)) {
              break label600;
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            ((File)localObject2).setLastModified(System.currentTimeMillis());
            locala.eK = c((String)localObject1, null);
            l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "getPersonalFontImg from file success time-consuming = " + (l2 - l1) + "ms");
            }
            locala.bHT = false;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "getPersonalFontImg fontImage = " + locala.eK + "Special Char = " + locala.bHS + "Special image = " + locala.bHT);
            }
            return locala;
            label499:
            if ((!TextUtils.isEmpty("")) || (!"".contains(paramString)) || (!a(paramString, paramInt, locala))) {
              break;
            }
            return locala;
          }
        }
        locala.eK = g(paramString, false);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getPersonalFontImg create success time-consuming = " + (l2 - l1) + "ms");
        }
      }
      label600:
      localObject1 = null;
    }
  }
  
  public Bitmap a(acgn.a parama, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = "0X800612F";
      str2 = paramRedPacketInfo.content;
    }
    String str3;
    long l1;
    aqqf.e locale;
    for (;;)
    {
      str3 = "0";
      if (aas()) {
        str3 = "1";
      }
      l1 = System.currentTimeMillis();
      locale = a().a(paramRedPacketInfo.templateId, true);
      if (locale != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "createRedPacketImg init json fail");
      }
      anot.a(this.app, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      parama = null;
      return parama;
      if (paramInt == 7)
      {
        str1 = "0X800613F";
        str2 = "";
      }
      else
      {
        str1 = "0X800613F";
        str2 = "";
      }
    }
    Object localObject;
    if (6 == paramInt) {
      localObject = locale.a;
    }
    while (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "createRedPacketImg decorateInfo = null");
      }
      anot.a(this.app, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      return null;
      if (7 == paramInt) {
        localObject = locale.b;
      } else {
        localObject = locale.c;
      }
    }
    if (!aqqf.a((aqqf.d)localObject))
    {
      if (((aqqf.b)localObject).resType == 2) {
        parama = paramRedPacketInfo.Qi;
      }
      for (;;)
      {
        this.ea.putIfAbsent(parama, paramRedPacketInfo);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "createRedPacketImg id = " + paramRedPacketInfo.templateId + " content = " + paramRedPacketInfo.content + " not exists!");
        }
        a().v(16L, ((aqqf.b)localObject).id, paramRedPacketInfo.Qi);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "createRedPacketImg BG not found,start download url : " + ((aqqf.b)localObject).resType + ", id=" + ((aqqf.b)localObject).id);
        }
        anot.a(this.app, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
        return null;
        if (((aqqf.b)localObject).resType == 3) {
          parama = paramRedPacketInfo.Qi + "_tp";
        } else {
          parama = paramRedPacketInfo.Qi + "_send";
        }
      }
    }
    label513:
    long l2;
    if (locale.type == aqqf.e.ebE)
    {
      localObject = a(parama, paramRedPacketInfo.templateId, paramRedPacketInfo.content, paramInt);
      l2 = System.currentTimeMillis();
      if (localObject == null) {
        break label619;
      }
      a(parama, paramRedPacketInfo, paramInt, (Bitmap)localObject);
      anot.a(this.app, "CliOper", "", "", str1, str1, 0, 0, str3, "1", String.valueOf(l2 - l1), str2);
    }
    for (;;)
    {
      parama = (acgn.a)localObject;
      if (paramInt != 6) {
        break;
      }
      CustomizeStrategyFactory.a().b(paramRedPacketInfo);
      return localObject;
      localObject = c(b(paramRedPacketInfo.templateId, paramRedPacketInfo.content, paramInt, locale.version, locale.type), null);
      break label513;
      label619:
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "createRedPacketImg BG combine == null, templateinfo.type = " + locale.type);
      }
      anot.a(this.app, "CliOper", "", "", str1, str1, 0, 0, str3, "0", String.valueOf(l2 - l1), str2);
    }
  }
  
  public aqqf a()
  {
    if (this.jdField_a_of_type_Aqqf == null) {
      this.jdField_a_of_type_Aqqf = new aqqf(this.app, this);
    }
    return this.jdField_a_of_type_Aqqf;
  }
  
  /* Error */
  public void a(Bitmap arg1, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: ifnonnull +20 -> 24
    //   7: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   16: iconst_2
    //   17: ldc_w 1161
    //   20: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: aload_2
    //   25: invokestatic 580	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +445 -> 473
    //   31: aload_0
    //   32: invokevirtual 269	acgn:a	()Laqqf;
    //   35: aload_2
    //   36: iconst_1
    //   37: invokevirtual 274	aqqf:a	(Ljava/lang/String;Z)Laqqf$e;
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +429 -> 473
    //   47: aload 7
    //   49: getfield 302	aqqf$e:version	I
    //   52: istore 6
    //   54: aload 7
    //   56: getfield 305	aqqf$e:type	I
    //   59: istore 5
    //   61: iload 4
    //   63: iconst_5
    //   64: if_icmpne +27 -> 91
    //   67: aload_3
    //   68: invokestatic 580	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +20 -> 91
    //   74: aload_0
    //   75: invokevirtual 269	acgn:a	()Laqqf;
    //   78: getfield 689	aqqf:c	Laqqf$a;
    //   81: invokevirtual 694	aqqf$a:Cu	()Ljava/lang/String;
    //   84: aload_3
    //   85: invokevirtual 697	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifne -65 -> 23
    //   91: aload_2
    //   92: aload_3
    //   93: iload 4
    //   95: iload 6
    //   97: iload 5
    //   99: invokestatic 308	acgn:b	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   102: astore 8
    //   104: aload 8
    //   106: invokestatic 580	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: ifeq +19 -> 128
    //   112: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +13 -> 128
    //   118: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   121: iconst_2
    //   122: ldc_w 1163
    //   125: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: new 634	java/io/File
    //   131: dup
    //   132: aload 8
    //   134: invokespecial 728	java/io/File:<init>	(Ljava/lang/String;)V
    //   137: astore_2
    //   138: aload_2
    //   139: invokevirtual 731	java/io/File:exists	()Z
    //   142: ifeq +38 -> 180
    //   145: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -125 -> 23
    //   151: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   154: iconst_2
    //   155: new 77	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 1165
    //   165: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 8
    //   170: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: return
    //   180: aload_0
    //   181: getfield 209	acgn:jdField_L_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   184: astore_3
    //   185: aload_3
    //   186: monitorenter
    //   187: aload_0
    //   188: getfield 209	acgn:jdField_L_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   191: aload 8
    //   193: invokevirtual 1166	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: aload_3
    //   198: monitorexit
    //   199: aconst_null
    //   200: astore_3
    //   201: aconst_null
    //   202: astore 7
    //   204: new 1168	java/io/BufferedOutputStream
    //   207: dup
    //   208: new 1170	java/io/FileOutputStream
    //   211: dup
    //   212: aload_2
    //   213: invokespecial 1173	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   216: invokespecial 1176	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   219: astore_2
    //   220: aload_2
    //   221: astore_3
    //   222: aload_1
    //   223: getstatic 1182	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   226: bipush 90
    //   228: aload_2
    //   229: invokevirtual 1186	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   232: pop
    //   233: aload_2
    //   234: astore_3
    //   235: aload_2
    //   236: invokevirtual 1189	java/io/BufferedOutputStream:flush	()V
    //   239: aload_2
    //   240: ifnull +7 -> 247
    //   243: aload_2
    //   244: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   247: aload_0
    //   248: getfield 209	acgn:jdField_L_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   251: astore_1
    //   252: aload_1
    //   253: monitorenter
    //   254: aload_0
    //   255: getfield 209	acgn:jdField_L_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   258: aload 8
    //   260: invokevirtual 1193	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_1
    //   265: monitorexit
    //   266: return
    //   267: astore_2
    //   268: aload_1
    //   269: monitorexit
    //   270: aload_2
    //   271: athrow
    //   272: astore_1
    //   273: aload_3
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    //   277: astore_1
    //   278: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   281: iconst_1
    //   282: ldc_w 1195
    //   285: aload_1
    //   286: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -42 -> 247
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_2
    //   296: astore_3
    //   297: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +35 -> 335
    //   303: aload_2
    //   304: astore_3
    //   305: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   308: iconst_2
    //   309: new 77	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 1200
    //   319: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_1
    //   323: invokevirtual 1201	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: ifnull -89 -> 247
    //   339: aload_2
    //   340: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   343: goto -96 -> 247
    //   346: astore_1
    //   347: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   350: iconst_1
    //   351: ldc_w 1195
    //   354: aload_1
    //   355: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: goto -111 -> 247
    //   361: astore_2
    //   362: aload 7
    //   364: astore_1
    //   365: aload_1
    //   366: astore_3
    //   367: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +35 -> 405
    //   373: aload_1
    //   374: astore_3
    //   375: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   378: iconst_2
    //   379: new 77	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 1200
    //   389: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_2
    //   393: invokevirtual 871	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: aload_1
    //   406: ifnull -159 -> 247
    //   409: aload_1
    //   410: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   413: goto -166 -> 247
    //   416: astore_1
    //   417: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   420: iconst_1
    //   421: ldc_w 1195
    //   424: aload_1
    //   425: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   428: goto -181 -> 247
    //   431: astore_1
    //   432: aload_3
    //   433: ifnull +7 -> 440
    //   436: aload_3
    //   437: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   440: aload_1
    //   441: athrow
    //   442: astore_2
    //   443: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   446: iconst_1
    //   447: ldc_w 1195
    //   450: aload_2
    //   451: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   454: goto -14 -> 440
    //   457: astore_1
    //   458: goto -26 -> 432
    //   461: astore_3
    //   462: aload_2
    //   463: astore_1
    //   464: aload_3
    //   465: astore_2
    //   466: goto -101 -> 365
    //   469: astore_1
    //   470: goto -175 -> 295
    //   473: iconst_0
    //   474: istore 6
    //   476: goto -415 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	acgn
    //   0	479	2	paramString1	String
    //   0	479	3	paramString2	String
    //   0	479	4	paramInt	int
    //   1	97	5	i	int
    //   52	423	6	j	int
    //   40	323	7	locale	aqqf.e
    //   102	157	8	str	String
    // Exception table:
    //   from	to	target	type
    //   254	266	267	finally
    //   268	270	267	finally
    //   187	199	272	finally
    //   273	275	272	finally
    //   243	247	277	java/lang/Exception
    //   204	220	292	java/io/FileNotFoundException
    //   339	343	346	java/lang/Exception
    //   204	220	361	java/io/IOException
    //   409	413	416	java/lang/Exception
    //   204	220	431	finally
    //   367	373	431	finally
    //   375	405	431	finally
    //   436	440	442	java/lang/Exception
    //   222	233	457	finally
    //   235	239	457	finally
    //   297	303	457	finally
    //   305	335	457	finally
    //   222	233	461	java/io/IOException
    //   235	239	461	java/io/IOException
    //   222	233	469	java/io/FileNotFoundException
    //   235	239	469	java/io/FileNotFoundException
  }
  
  public void a(aqqf.a parama)
  {
    if (this.cC.get()) {
      QLog.e(TAG, 1, "preCreatePersonalFontImg mIsSDCardError:" + this.cC.get());
    }
    do
    {
      do
      {
        return;
      } while ((this.cD.get()) || (!this.an.booleanValue()) || (parama.ebC == 0) || (TextUtils.isEmpty(parama.Cu())) || (!aqqf.a(a().a)));
      if (t().getInt("font_precreate_count", 0) >= parama.ebD)
      {
        QLog.d(TAG, 1, "preCreatePersonalFontImg count >= " + parama.ebD);
        return;
      }
    } while ((!aat()) || (!this.cD.compareAndSet(false, true)));
    this.D = ThreadManager.newFreeHandlerThread("RedPacketPrecreate", 19);
    this.D.start();
    this.jdField_a_of_type_Acgn$b = new acgn.b(this, this.app, parama);
    this.ct = new Handler(this.D.getLooper(), this.jdField_a_of_type_Acgn$b);
    this.jdField_a_of_type_Acgn$b.run();
  }
  
  public void a(String paramString, Bundle paramBundle, MessengerService paramMessengerService)
  {
    aqqf.e locale = a().a(paramString, true);
    int j = cwd;
    int i = j;
    if (locale != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramString))
      {
        if (locale.a != null) {
          i = locale.a.resType;
        }
        if (!new File(b(paramString, "", 2, locale.version, locale.type)).exists()) {
          break label141;
        }
      }
    }
    label141:
    for (i = cwc;; i = cwd)
    {
      if (i != cwc) {
        a().v(16L, paramString, null);
      }
      paramString = new Bundle();
      paramString.putInt("result", i);
      paramBundle.putBundle("response", paramString);
      paramMessengerService.cp(paramBundle);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService)
  {
    ThreadManager.post(new IndividualRedPacketManager.4(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
  }
  
  public String aK(String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (!aau())
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "getTenpayCombineImg: isAllowShowRedpacket = false templateId = " + paramString1 + ";name = " + paramString2);
        localObject1 = localObject2;
      }
    }
    do
    {
      return localObject1;
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject3;
        if (a().c.Cu().contains(paramString2)) {
          localObject1 = k(paramString1, paramString2, 13);
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = k(paramString1, paramString2, 7);
      }
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "getTenpayCombineImg: templateId = " + paramString1 + ";name = " + paramString2 + ", path = " + (String)localObject2);
    return localObject2;
  }
  
  public boolean aas()
  {
    return (this.iCanUseRed == 1) && (this.iRedDisable == 0);
  }
  
  public boolean aat()
  {
    return this.iRedDisable == 0;
  }
  
  public boolean aau()
  {
    return (aat()) && (a().cVC);
  }
  
  public void cJq()
  {
    ThreadManager.post(new IndividualRedPacketManager.2(this), 2, null, true);
  }
  
  public void ca(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setRedpacketInfo redpacketId = " + paramInt + "; redpacketText = " + paramString);
    }
    this.cvZ = paramInt;
    this.sRedPackRemard = paramString;
    SharedPreferences localSharedPreferences = s();
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramInt);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void dz(String paramString, int paramInt)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {}
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo;
    aqqf.e locale;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onDoneDownloadBG id = " + paramString + ", resType:" + paramInt);
        }
        localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)this.ea.get(paramString);
      } while (localRedPacketInfo == null);
      locale = a().a(localRedPacketInfo.templateId, true);
    } while (locale == null);
    if (locale.type == aqqf.e.ebE) {
      a(paramInt, localRedPacketInfo);
    }
    for (;;)
    {
      this.ea.remove(paramString);
      if (!bool) {
        break;
      }
      CustomizeStrategyFactory.a().b(localRedPacketInfo);
      return;
      bool = a(paramInt, localRedPacketInfo, locale, false);
    }
  }
  
  /* Error */
  public Bitmap g(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 196	acgn:d	Lcom/etrump/mixlayout/ETEngine;
    //   12: astore 11
    //   14: aload 11
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 204	acgn:cB	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   21: invokevirtual 1030	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   24: ifne +118 -> 142
    //   27: aload_0
    //   28: getfield 204	acgn:cB	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   31: iconst_1
    //   32: invokevirtual 202	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   35: invokestatic 1068	java/lang/System:currentTimeMillis	()J
    //   38: lstore_3
    //   39: aload_0
    //   40: getfield 196	acgn:d	Lcom/etrump/mixlayout/ETEngine;
    //   43: iconst_1
    //   44: ldc_w 1326
    //   47: invokevirtual 1330	com/etrump/mixlayout/ETEngine:initEngine	(II)Z
    //   50: ifeq +161 -> 211
    //   53: aload_0
    //   54: invokevirtual 269	acgn:a	()Laqqf;
    //   57: getfield 1047	aqqf:a	Laqqf$d;
    //   60: invokestatic 1135	aqqf:a	(Laqqf$d;)Z
    //   63: ifeq +24 -> 87
    //   66: aload_0
    //   67: getfield 196	acgn:d	Lcom/etrump/mixlayout/ETEngine;
    //   70: aconst_null
    //   71: aconst_null
    //   72: bipush 8
    //   74: iconst_0
    //   75: iconst_0
    //   76: invokestatic 308	acgn:b	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   79: getstatic 99	acgn:cvS	I
    //   82: iconst_1
    //   83: invokevirtual 1334	com/etrump/mixlayout/ETEngine:native_loadFont	(Ljava/lang/String;IZ)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 199	acgn:cf	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   91: iconst_1
    //   92: invokevirtual 202	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   95: invokestatic 1068	java/lang/System:currentTimeMillis	()J
    //   98: lstore 5
    //   100: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +39 -> 142
    //   106: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   109: iconst_2
    //   110: new 77	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 1336
    //   120: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: lload 5
    //   125: lload_3
    //   126: lsub
    //   127: invokevirtual 1071	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: ldc_w 1110
    //   133: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: getfield 199	acgn:cf	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   146: invokevirtual 1030	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   149: ifeq +10 -> 159
    //   152: aload_1
    //   153: invokestatic 580	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +150 -> 306
    //   159: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   162: iconst_1
    //   163: new 77	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 1338
    //   173: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_0
    //   177: getfield 199	acgn:cf	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   180: invokevirtual 1030	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   183: invokevirtual 751	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: ldc_w 1340
    //   189: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_1
    //   193: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload 11
    //   204: monitorexit
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_0
    //   208: monitorexit
    //   209: aload_1
    //   210: areturn
    //   211: aload_0
    //   212: getfield 196	acgn:d	Lcom/etrump/mixlayout/ETEngine;
    //   215: getfield 1343	com/etrump/mixlayout/ETEngine:isEngineInited	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   218: iconst_0
    //   219: iconst_1
    //   220: invokevirtual 1221	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   223: ifeq +7 -> 230
    //   226: invokestatic 1348	lb:aF	()Z
    //   229: pop
    //   230: aload_0
    //   231: getfield 199	acgn:cf	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   234: iconst_0
    //   235: invokevirtual 202	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   238: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   241: iconst_1
    //   242: ldc_w 1350
    //   245: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto -106 -> 142
    //   251: astore 7
    //   253: aload_0
    //   254: getfield 199	acgn:cf	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   257: iconst_0
    //   258: invokevirtual 202	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   261: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   264: iconst_1
    //   265: new 77	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 1352
    //   275: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 7
    //   280: invokevirtual 1353	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   283: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: goto -150 -> 142
    //   295: astore_1
    //   296: aload 11
    //   298: monitorexit
    //   299: aload_1
    //   300: athrow
    //   301: astore_1
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_1
    //   305: athrow
    //   306: aload_0
    //   307: invokevirtual 269	acgn:a	()Laqqf;
    //   310: getfield 1047	aqqf:a	Laqqf$d;
    //   313: invokestatic 1135	aqqf:a	(Laqqf$d;)Z
    //   316: ifne +21 -> 337
    //   319: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   322: iconst_1
    //   323: ldc_w 1355
    //   326: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 11
    //   331: monitorexit
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -127 -> 207
    //   337: aload_0
    //   338: getfield 1357	acgn:mFont	Lcom/etrump/mixlayout/ETFont;
    //   341: ifnonnull +32 -> 373
    //   344: aload_0
    //   345: new 1359	com/etrump/mixlayout/ETFont
    //   348: dup
    //   349: getstatic 99	acgn:cvS	I
    //   352: aconst_null
    //   353: ldc_w 299
    //   356: bipush 8
    //   358: iconst_0
    //   359: iconst_0
    //   360: invokestatic 308	acgn:b	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   363: aload_0
    //   364: getfield 112	acgn:sQ	F
    //   367: invokespecial 1362	com/etrump/mixlayout/ETFont:<init>	(ILjava/lang/String;F)V
    //   370: putfield 1357	acgn:mFont	Lcom/etrump/mixlayout/ETFont;
    //   373: aload_0
    //   374: getfield 1357	acgn:mFont	Lcom/etrump/mixlayout/ETFont;
    //   377: ldc_w 1364
    //   380: invokestatic 467	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   383: invokevirtual 1365	com/etrump/mixlayout/ETFont:setColor	(I)V
    //   386: iload_2
    //   387: ifeq +41 -> 428
    //   390: ldc_w 299
    //   393: aload_1
    //   394: iconst_4
    //   395: iconst_0
    //   396: iconst_0
    //   397: invokestatic 308	acgn:b	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   400: astore 7
    //   402: aload 7
    //   404: invokestatic 580	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifeq +36 -> 443
    //   410: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   413: iconst_1
    //   414: ldc_w 1367
    //   417: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: aload 11
    //   422: monitorexit
    //   423: aconst_null
    //   424: astore_1
    //   425: goto -218 -> 207
    //   428: ldc_w 299
    //   431: aload_1
    //   432: iconst_5
    //   433: iconst_0
    //   434: iconst_0
    //   435: invokestatic 308	acgn:b	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   438: astore 7
    //   440: goto -38 -> 402
    //   443: new 634	java/io/File
    //   446: dup
    //   447: aload 7
    //   449: invokespecial 728	java/io/File:<init>	(Ljava/lang/String;)V
    //   452: astore 7
    //   454: aload_0
    //   455: getfield 112	acgn:sQ	F
    //   458: f2i
    //   459: aload_0
    //   460: getfield 112	acgn:sQ	F
    //   463: f2i
    //   464: getstatic 353	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   467: invokestatic 359	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   470: astore 8
    //   472: aload_0
    //   473: getfield 196	acgn:d	Lcom/etrump/mixlayout/ETEngine;
    //   476: aload_1
    //   477: iconst_0
    //   478: invokevirtual 644	java/lang/String:charAt	(I)C
    //   481: aload_0
    //   482: getfield 1357	acgn:mFont	Lcom/etrump/mixlayout/ETFont;
    //   485: invokevirtual 1371	com/etrump/mixlayout/ETEngine:native_isPaintableChar	(CLcom/etrump/mixlayout/ETFont;)Z
    //   488: ifeq +22 -> 510
    //   491: aload_0
    //   492: getfield 196	acgn:d	Lcom/etrump/mixlayout/ETEngine;
    //   495: aload_1
    //   496: aload 8
    //   498: iconst_0
    //   499: iconst_0
    //   500: aload_0
    //   501: getfield 1357	acgn:mFont	Lcom/etrump/mixlayout/ETFont;
    //   504: invokevirtual 1375	com/etrump/mixlayout/ETEngine:native_drawText	(Ljava/lang/String;Landroid/graphics/Bitmap;IILcom/etrump/mixlayout/ETFont;)Z
    //   507: ifne +135 -> 642
    //   510: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   513: iconst_1
    //   514: new 77	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 1377
    //   524: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: iconst_0
    //   529: invokevirtual 644	java/lang/String:charAt	(I)C
    //   532: invokevirtual 1380	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   535: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload 11
    //   543: monitorexit
    //   544: aconst_null
    //   545: astore_1
    //   546: goto -339 -> 207
    //   549: astore_1
    //   550: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   553: iconst_1
    //   554: new 77	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1382
    //   564: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: invokevirtual 364	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   571: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 366	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: new 368	java/util/HashMap
    //   583: dup
    //   584: invokespecial 369	java/util/HashMap:<init>	()V
    //   587: astore_1
    //   588: aload_1
    //   589: ldc_w 371
    //   592: ldc_w 1384
    //   595: invokevirtual 377	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 384	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   605: invokestatic 389	anpc:a	(Landroid/content/Context;)Lanpc;
    //   608: getstatic 383	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   611: invokevirtual 393	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   614: checkcast 211	com/tencent/mobileqq/app/QQAppInterface
    //   617: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   620: ldc_w 398
    //   623: iconst_0
    //   624: lconst_1
    //   625: lconst_0
    //   626: aload_1
    //   627: ldc_w 299
    //   630: iconst_0
    //   631: invokevirtual 402	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   634: aload 11
    //   636: monitorexit
    //   637: aconst_null
    //   638: astore_1
    //   639: goto -432 -> 207
    //   642: iload_2
    //   643: ifeq +57 -> 700
    //   646: aload 8
    //   648: ifnull +52 -> 700
    //   651: aload 10
    //   653: astore_1
    //   654: new 1168	java/io/BufferedOutputStream
    //   657: dup
    //   658: new 1170	java/io/FileOutputStream
    //   661: dup
    //   662: aload 7
    //   664: invokespecial 1173	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   667: invokespecial 1176	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   670: astore 7
    //   672: aload 8
    //   674: getstatic 1182	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   677: bipush 90
    //   679: aload 7
    //   681: invokevirtual 1186	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   684: pop
    //   685: aload 7
    //   687: invokevirtual 1189	java/io/BufferedOutputStream:flush	()V
    //   690: aload 7
    //   692: ifnull +8 -> 700
    //   695: aload 7
    //   697: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   700: aload 11
    //   702: monitorexit
    //   703: aload 8
    //   705: astore_1
    //   706: goto -499 -> 207
    //   709: astore_1
    //   710: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   713: iconst_1
    //   714: ldc_w 1386
    //   717: aload_1
    //   718: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: goto -21 -> 700
    //   724: astore_1
    //   725: aload 9
    //   727: astore 7
    //   729: aload_1
    //   730: astore 9
    //   732: aload 7
    //   734: astore_1
    //   735: invokestatic 289	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +37 -> 775
    //   741: aload 7
    //   743: astore_1
    //   744: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   747: iconst_2
    //   748: new 77	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 1388
    //   758: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 9
    //   763: invokevirtual 405	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   772: invokestatic 295	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   775: aload 7
    //   777: ifnull -77 -> 700
    //   780: aload 7
    //   782: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   785: goto -85 -> 700
    //   788: astore_1
    //   789: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   792: iconst_1
    //   793: ldc_w 1386
    //   796: aload_1
    //   797: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   800: goto -100 -> 700
    //   803: astore 8
    //   805: aload_1
    //   806: astore 7
    //   808: aload 8
    //   810: astore_1
    //   811: aload 7
    //   813: ifnull +8 -> 821
    //   816: aload 7
    //   818: invokevirtual 1190	java/io/BufferedOutputStream:close	()V
    //   821: aload_1
    //   822: athrow
    //   823: astore 7
    //   825: getstatic 75	acgn:TAG	Ljava/lang/String;
    //   828: iconst_1
    //   829: ldc_w 1386
    //   832: aload 7
    //   834: invokestatic 1198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   837: goto -16 -> 821
    //   840: astore_1
    //   841: goto -30 -> 811
    //   844: astore 9
    //   846: goto -114 -> 732
    //   849: astore_1
    //   850: goto -216 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	853	0	this	acgn
    //   0	853	1	paramString	String
    //   0	853	2	paramBoolean	boolean
    //   38	88	3	l1	long
    //   98	26	5	l2	long
    //   251	28	7	localThrowable	java.lang.Throwable
    //   400	417	7	localObject1	Object
    //   823	10	7	localException1	Exception
    //   470	234	8	localBitmap	Bitmap
    //   803	6	8	localObject2	Object
    //   4	758	9	str	String
    //   844	1	9	localException2	Exception
    //   1	651	10	localObject3	Object
    //   12	689	11	localETEngine	ETEngine
    // Exception table:
    //   from	to	target	type
    //   39	87	251	java/lang/Throwable
    //   87	142	251	java/lang/Throwable
    //   211	230	251	java/lang/Throwable
    //   230	248	251	java/lang/Throwable
    //   17	39	295	finally
    //   39	87	295	finally
    //   87	142	295	finally
    //   142	159	295	finally
    //   159	205	295	finally
    //   211	230	295	finally
    //   230	248	295	finally
    //   253	292	295	finally
    //   296	299	295	finally
    //   306	332	295	finally
    //   337	373	295	finally
    //   373	386	295	finally
    //   390	402	295	finally
    //   402	423	295	finally
    //   428	440	295	finally
    //   443	454	295	finally
    //   454	472	295	finally
    //   472	510	295	finally
    //   510	544	295	finally
    //   550	580	295	finally
    //   580	634	295	finally
    //   634	637	295	finally
    //   695	700	295	finally
    //   700	703	295	finally
    //   710	721	295	finally
    //   780	785	295	finally
    //   789	800	295	finally
    //   816	821	295	finally
    //   821	823	295	finally
    //   825	837	295	finally
    //   8	17	301	finally
    //   299	301	301	finally
    //   454	472	549	java/lang/OutOfMemoryError
    //   695	700	709	java/lang/Exception
    //   654	672	724	java/lang/Exception
    //   780	785	788	java/lang/Exception
    //   654	672	803	finally
    //   735	741	803	finally
    //   744	775	803	finally
    //   816	821	823	java/lang/Exception
    //   672	690	840	finally
    //   672	690	844	java/lang/Exception
    //   580	634	849	java/lang/Exception
  }
  
  public String k(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = a().a(paramString1, true);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getLocalImg fail! can't find template templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      return localObject2;
      localObject1 = b(paramString1, paramString2, paramInt, ((aqqf.e)localObject1).version, ((aqqf.e)localObject1).type);
      label100:
      localObject2 = this.jdField_L_of_type_JavaUtilLinkedList;
      if (localObject1 != null) {}
      try
      {
        if (this.jdField_L_of_type_JavaUtilLinkedList.contains(localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getLocalImg fail! file Saving! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          }
          return null;
          localObject1 = b("", paramString2, paramInt, 0, 0);
          break label100;
        }
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject2).setLastModified(NetConnInfoCenter.getServerTimeMillis());
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(TAG, 2, "getLocalImg success! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          return localObject1;
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getLocalImg fail! file not exists! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
    }
    return null;
  }
  
  public void onDestroy()
  {
    if (this.D != null)
    {
      this.D.interrupt();
      this.D.quit();
      this.D = null;
    }
    if (this.jdField_a_of_type_Acgn$b != null) {
      this.ct.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_Aqqf != null)
    {
      this.jdField_a_of_type_Aqqf.onDestroy();
      this.jdField_a_of_type_Aqqf = null;
    }
    this.mIsDestroy.set(true);
  }
  
  public String rD()
  {
    String str2 = String.valueOf(this.cvZ);
    String str3 = this.sRedPackRemard;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getSendCombineImg: templateId = " + str2 + ";name = " + str3);
    }
    if (aau())
    {
      String str1 = k(str2, str3, 15);
      if (!TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getSendCombineImg templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
        }
        localObject2 = str1;
        return localObject2;
      }
      Object localObject1 = a().a(str2, true);
      if ((localObject1 == null) || (((aqqf.e)localObject1).c == null))
      {
        QLog.e(TAG, 1, "getSendCombineImg info = null ; templateId = " + str2 + "; name = " + str3);
        a().v(16L, str2, null);
        return null;
      }
      Object localObject2 = b(str2, "", 14, ((aqqf.e)localObject1).version, ((aqqf.e)localObject1).type);
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).exists())
      {
        Object localObject4 = ((aqqf.e)localObject1).c;
        if (localObject4 == null)
        {
          QLog.e(TAG, 1, "getSendCombineImg filenot exists senddecorate = null; templateId = " + str2 + ";name = " + str3);
          return null;
        }
        localObject4 = ((aqqf.b)localObject4).url;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          QLog.e(TAG, 1, "getSendCombineImg filenot exists url is empty; templateId = " + str2 + ";name = " + str3);
          return null;
        }
        int i = aqva.a(new aquz((String)localObject4, (File)localObject3), null);
        if (i != 0)
        {
          QLog.e(TAG, 1, "getSendCombineImg filenot exists download bg faile; templateId = " + str2 + ";name = " + str3 + "; downloadresult = " + i);
          return null;
        }
      }
      if (!((File)localObject3).exists())
      {
        QLog.e(TAG, 1, "getSendCombineImg filenot exists file not exists 2222; templateId = " + str2 + ";name = " + str3);
        return null;
      }
      if ((((aqqf.e)localObject1).type == aqqf.e.ebF) || (TextUtils.isEmpty(str3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getSendCombineImg1 templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
        }
        return localObject2;
      }
      localObject2 = a(str3, 15);
      if (localObject2 == null)
      {
        QLog.e(TAG, 1, "getSendCombineImg fontImg = null ; templateId = " + str2 + "; name = " + str3);
        return null;
      }
      if (((acgn.a)localObject2).eK != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getSendCombineImg savefontimg");
        }
        a(((acgn.a)localObject2).eK, str2, str3, 4);
      }
      localObject3 = a((acgn.a)localObject2, str2, str3, 15);
      if (localObject3 != null)
      {
        if (((acgn.a)localObject2).bHT) {
          a((Bitmap)localObject3, str2, str3, 18);
        }
        for (localObject1 = b(str2, str3, 18, ((aqqf.e)localObject1).version, aqqf.e.ebE);; localObject1 = b(str2, str3, 15, ((aqqf.e)localObject1).version, aqqf.e.ebE))
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(TAG, 2, "getSendCombineImg2 templateId = " + str2 + "; name = " + str3 + "; combinefilename = " + str1);
          return localObject1;
          a((Bitmap)localObject3, str2, str3, 15);
        }
      }
      QLog.e(TAG, 1, "getSendCombineImg3 null allowshowredpacket templateId =" + str2 + ";name = " + str3);
      return null;
    }
    QLog.e(TAG, 1, "getSendCombineImg not allowshowredpacket templateId =" + str2 + ";name = " + str3);
    return null;
  }
  
  public SharedPreferences s()
  {
    if (this.jdField_L_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_L_of_type_AndroidContentSharedPreferences = this.app.getApplication().getApplicationContext().getSharedPreferences("individRedPacket_" + this.app.getAccount(), 0);
    }
    return this.jdField_L_of_type_AndroidContentSharedPreferences;
  }
  
  public SharedPreferences t()
  {
    if (this.M == null)
    {
      QQAppInterface localQQAppInterface = this.app;
      Object localObject = localQQAppInterface;
      if (localQQAppInterface == null) {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
      }
      this.M = ((AppRuntime)localObject).getApplication().getApplicationContext().getSharedPreferences("individRedPacket_common", 0);
    }
    return this.M;
  }
  
  public void x(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "IndividualRedPacketManager.setRedPacketFlags iCanUseRed:" + paramInt1 + ", iRedDisable:" + paramInt2 + ", isUpdate:" + paramBoolean + ", this.iCanUseRed:" + this.iCanUseRed + ", this.iRedDisable:" + this.iRedDisable);
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = this.iCanUseRed;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = this.iRedDisable;
    }
    if ((this.iCanUseRed != i) || (this.iRedDisable != paramInt1))
    {
      this.iCanUseRed = i;
      this.iRedDisable = paramInt1;
      if (paramBoolean)
      {
        SharedPreferences localSharedPreferences = s();
        localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", i);
        localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramInt1);
        localSharedPreferences.edit().commit();
      }
      if ((i == 1) && (paramInt1 == 0)) {
        bou = "1";
      }
    }
    else
    {
      return;
    }
    bou = "0";
  }
  
  public static class a
  {
    public boolean bHS;
    public boolean bHT;
    public Bitmap eK;
    public boolean isDefault;
  }
  
  public static class b
    implements Handler.Callback
  {
    aqqf.a a;
    int cwe = 0;
    WeakReference<acgn> gh;
    WeakReference<QQAppInterface> weakApp;
    
    public b(acgn paramacgn, QQAppInterface paramQQAppInterface, aqqf.a parama)
    {
      this.weakApp = new WeakReference(paramQQAppInterface);
      this.gh = new WeakReference(paramacgn);
      this.a = parama;
    }
    
    void Jh(int paramInt)
    {
      Object localObject2 = (QQAppInterface)this.weakApp.get();
      acgn localacgn = (acgn)this.gh.get();
      if ((localObject2 == null) || (localacgn == null)) {}
      Object localObject1;
      do
      {
        return;
        str = this.a.Cu();
        if (paramInt >= str.length())
        {
          localObject1 = new File(acgn.dy(4)).listFiles();
          localObject2 = localacgn.t().edit();
          if ((localObject1 != null) && (localObject1.length >= str.length())) {
            ((SharedPreferences.Editor)localObject2).putBoolean("font_precreate_finish", true);
          }
          for (;;)
          {
            paramInt = localacgn.t().getInt("font_precreate_count", 0);
            ((SharedPreferences.Editor)localObject2).putInt("font_precreate_count", paramInt + 1);
            ((SharedPreferences.Editor)localObject2).commit();
            QLog.d(acgn.access$000(), 1, "preCreatePersonalFontImg create count = " + paramInt);
            return;
            ((SharedPreferences.Editor)localObject2).putInt("font_precreate_index", 0);
          }
        }
        localObject1 = "0";
        if (localacgn.aas()) {
          localObject1 = "1";
        }
      } while ((localacgn.mIsDestroy.get()) || (Thread.currentThread().isInterrupted()));
      String str = str.substring(paramInt, paramInt + 1);
      if (new File(acgn.b("", str, 4, 0, 0)).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.e(acgn.access$000(), 2, "preCreatePersonalFontImg exists : " + str + " address = " + acgn.b("", str, 4, 0, 0));
        }
        localacgn.t().edit().putInt("font_precreate_index", paramInt + 1).commit();
        localObject1 = localacgn.ct.obtainMessage();
        ((Message)localObject1).what = (paramInt + 1);
        localacgn.ct.sendMessageDelayed((Message)localObject1, 500L);
        return;
      }
      long l1 = System.currentTimeMillis();
      Bitmap localBitmap = localacgn.g(str, true);
      long l2;
      if (localBitmap != null)
      {
        this.cwe = 0;
        l2 = System.currentTimeMillis();
        localacgn.t().edit().putInt("font_precreate_index", paramInt + 1).commit();
        if (paramInt % 100 == 0) {
          anot.a((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "1", String.valueOf(l2 - l1), str);
        }
        if (!localBitmap.isRecycled()) {
          localBitmap.recycle();
        }
      }
      do
      {
        localObject1 = localacgn.ct.obtainMessage();
        ((Message)localObject1).what = (paramInt + 1);
        localacgn.ct.sendMessageDelayed((Message)localObject1, 5000L);
        return;
        l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d(acgn.access$000(), 2, "preCreatePersonalFontImg " + str + "fail");
        }
        if (paramInt % 100 == 0) {
          anot.a((QQAppInterface)localObject2, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject1, "0", String.valueOf(l2 - l1), str);
        }
        this.cwe += 1;
      } while (this.cwe < this.a.cwe);
      QLog.e(acgn.access$000(), 1, "preCreatePersonalFontImg fail count = " + this.cwe + " max failcount = " + this.a.cwe);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      Jh(paramMessage.what);
      return true;
    }
    
    public void run()
    {
      Object localObject = (QQAppInterface)this.weakApp.get();
      acgn localacgn = (acgn)this.gh.get();
      if ((localObject == null) || (localacgn == null) || (localacgn.cC.get())) {
        QLog.d(acgn.access$000(), 1, "preCreatePersonalFontImg return!");
      }
      while (localacgn.t().getBoolean("font_precreate_finish", false)) {
        return;
      }
      QLog.d(acgn.access$000(), 1, "preCreatePersonalFontImg start!");
      int i = localacgn.t().getInt("font_precreate_index", 0);
      localObject = localacgn.ct.obtainMessage();
      ((Message)localObject).what = i;
      localacgn.ct.sendMessage((Message)localObject);
    }
  }
  
  public static class c
    implements CustomizeStrategyFactory.b
  {
    private QQAppInterface app;
    
    public c(QQAppInterface paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
    }
    
    public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc)
    {
      if ((paramRedPacketInfo != null) && ((paramxwc instanceof xwi)))
      {
        paramxwc = (xwi)paramxwc;
        paramRedPacketInfo.dv = paramxwc.dv;
        paramRedPacketInfo.e = paramxwc.e;
        paramRedPacketInfo.a = paramxwc.a;
        paramRedPacketInfo.aHx = paramxwc.aHx;
      }
    }
    
    public void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      if ((paramRedPacketInfo == null) || (TextUtils.isEmpty(paramRedPacketInfo.templateId))) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(acgn.access$000(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.templateId + "content = " + paramRedPacketInfo.content);
      }
      Object localObject = (acgn)this.app.getManager(131);
      if ((localObject == null) || (!((acgn)localObject).aau()) || (((acgn)localObject).cC.get()))
      {
        String str;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          str = acgn.access$000();
          localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
          if (localObject != null) {
            break label150;
          }
        }
        label150:
        for (localObject = "redPacketManager == null";; localObject = "isShowRedpacket:" + ((acgn)localObject).a().cVC + ", PacketEnable:" + ((acgn)localObject).aat() + ", mIsSDCardError:" + ((acgn)localObject).cC.get())
        {
          QLog.d(str, 2, (String)localObject);
          CustomizeStrategyFactory.a().b(paramRedPacketInfo);
          return;
        }
      }
      ThreadManager.post(new IndividualRedPacketManager.VIPHBStrategy.1(this, (acgn)localObject, paramRedPacketInfo), 8, null, true);
    }
    
    public void onDestory() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acgn
 * JD-Core Version:    0.7.0.1
 */