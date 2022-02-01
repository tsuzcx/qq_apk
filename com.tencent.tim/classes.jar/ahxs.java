import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TGetPosterFontRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TPosterFontInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONObject;
import tencent.hiboom.hiboomauth.hiboom_auth.TTipsInfo;

public class ahxs
  implements Manager
{
  private static boolean IS_DEBUG;
  public static ahxo.a b = new ahxv();
  public static final String bMn = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "hiboom_list_cache";
  public static ahxo.a c = new ahxw();
  public static int dbR;
  public static AtomicBoolean dd = new AtomicBoolean(false);
  public static AtomicBoolean de;
  public Vector<Integer> F = new Vector();
  public Vector<Integer> G = new Vector();
  public Vector<Integer> H = new Vector();
  ahxs.c jdField_a_of_type_Ahxs$c = null;
  private aqvd jdField_a_of_type_Aqvd;
  public Handler cV;
  public Handler cW;
  public AtomicBoolean db = new AtomicBoolean(false);
  private AtomicBoolean dc = new AtomicBoolean(false);
  public ConcurrentHashMap<Integer, ahxr> fA = new ConcurrentHashMap();
  public final Object handlerLock = new Object();
  public QQAppInterface mApp;
  ConcurrentHashMap<Integer, String> y = new ConcurrentHashMap();
  
  static
  {
    dbR = 300;
    de = new AtomicBoolean(false);
  }
  
  public ahxs(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    dd.set(false);
  }
  
  private void OZ(int paramInt)
  {
    ((VasQuickUpdateManager)this.mApp.getManager(184)).downloadItem(5L, "font.hiFontQQ.json." + paramInt, "HiBoomManager");
  }
  
  public static ahxs a(QQAppInterface paramQQAppInterface)
  {
    return (ahxs)paramQQAppInterface.getManager(219);
  }
  
  public static arhz a(Context paramContext)
  {
    if ((((FragmentActivity)paramContext).getChatFragment() != null) && (((FragmentActivity)paramContext).getChatFragment().a() != null))
    {
      if (((FragmentActivity)paramContext).getChatFragment().a().x == null) {
        ((FragmentActivity)paramContext).getChatFragment().a().x = new arhz(paramContext);
      }
      return ((FragmentActivity)paramContext).getChatFragment().a().x;
    }
    return null;
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      hiboom_auth.TTipsInfo localTTipsInfo = new hiboom_auth.TTipsInfo();
      label332:
      for (;;)
      {
        try
        {
          localTTipsInfo.mergeFrom(paramArrayOfByte);
          int i = localTTipsInfo.i32_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult tipsType = " + i);
          }
          String str2 = localTTipsInfo.str_title.get();
          if (TextUtils.isEmpty(str2))
          {
            str2 = acfp.m(2131707140);
            paramArrayOfByte = localTTipsInfo.str_msg.get();
            if (TextUtils.isEmpty(paramArrayOfByte))
            {
              String str3;
              if (i == 1)
              {
                paramArrayOfByte = acfp.m(2131707144);
                str3 = localTTipsInfo.str_button.get();
                str1 = str3;
                if (TextUtils.isEmpty(str3))
                {
                  if (i == 1) {
                    str1 = acfp.m(2131707145);
                  }
                }
                else
                {
                  str3 = localTTipsInfo.str_url.get();
                  aqha.a(paramContext, 230, str2, paramArrayOfByte, acfp.m(2131707148), str1, new ahxt(i, str3, paramContext, localTTipsInfo, paramInt), new ahxu()).show();
                  if (!(paramContext instanceof FragmentActivity)) {
                    break;
                  }
                  paramContext = (FragmentActivity)paramContext;
                  if ((paramContext.getChatFragment() == null) || (paramContext.getChatFragment().a() == null)) {
                    break;
                  }
                  ((ahxs)paramContext.getChatFragment().a().app.getManager(219)).db.set(false);
                }
              }
              else
              {
                if (i != 2) {
                  break label332;
                }
                paramArrayOfByte = acfp.m(2131707149);
                continue;
              }
              String str1 = str3;
              if (i != 2) {
                continue;
              }
              str1 = acfp.m(2131707142);
              continue;
            }
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("HiBoomFont.HiBoomManager", 1, "onHiBoomAuthResult merge error: " + paramContext.getLocalizedMessage() + " trace: " + Log.getStackTraceString(paramContext));
          return;
        }
      }
    }
  }
  
  public static boolean aos()
  {
    long l = Runtime.getRuntime().maxMemory();
    if (l > 134217728L) {}
    for (boolean bool = true;; bool = false)
    {
      if ((QLog.isColorLevel()) || (!bool)) {
        QLog.d("HiBoomFont.HiBoomManager", 1, "isMemorySupport: " + bool + " maxHeap=" + l);
      }
      return bool;
    }
  }
  
  private void dqN()
  {
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    ArrayList localArrayList = new ArrayList();
    int i = 2000;
    if (i < 2005)
    {
      VipFontUpdate.TPosterFontInfo localTPosterFontInfo = new VipFontUpdate.TPosterFontInfo();
      localTPosterFontInfo.i32_font_id.set(i);
      if (i % 2 == 0) {}
      for (long l = System.currentTimeMillis() / 1000L + 86400L;; l = System.currentTimeMillis() / 1000L - i)
      {
        localTPosterFontInfo.u64_ts.set(l);
        localArrayList.add(localTPosterFontInfo);
        i += 1;
        break;
      }
    }
    localTGetPosterFontRsp.rpt_using_list.set(localArrayList);
    a(localTGetPosterFontRsp, true);
  }
  
  private void dqO()
  {
    Iterator localIterator = this.fA.values().iterator();
    while (localIterator.hasNext())
    {
      ahxr localahxr = (ahxr)localIterator.next();
      if (!localahxr.da.get()) {
        c(localahxr.id, true, false, false);
      }
    }
  }
  
  public static int hY(int paramInt)
  {
    ahxp localahxp = ahxo.a().b(paramInt, 0, b);
    if ((localahxp.mType != 2) && (localahxp.mType != 1) && (localahxp.mType != 4) && (localahxp.mType != 3)) {
      localahxp.B(false);
    }
    return localahxp.mType;
  }
  
  private static boolean isExpired(long paramLong)
  {
    return NetConnInfoCenter.getServerTime() > paramLong;
  }
  
  public static boolean jZ(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static String ls(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
  }
  
  public void KF(boolean paramBoolean)
  {
    this.dc.set(paramBoolean);
  }
  
  public void KG(boolean paramBoolean)
  {
    de.set(paramBoolean);
    if (paramBoolean) {
      dqL();
    }
    if (this.jdField_a_of_type_Ahxs$c != null) {
      this.jdField_a_of_type_Ahxs$c.KH(paramBoolean);
    }
  }
  
  public void Px(int paramInt)
  {
    ahxr localahxr = a(paramInt);
    localahxr.progress = -3;
    localahxr.isDownloading = false;
    if (this.y.containsKey(Integer.valueOf(paramInt))) {
      this.y.remove(Integer.valueOf(paramInt));
    }
    ((VasQuickUpdateManager)this.mApp.getManager(184)).cancelDwonloadItem(5L, "font.hifont.android." + paramInt);
  }
  
  public ahxr a(int paramInt)
  {
    try
    {
      ahxr localahxr2 = (ahxr)this.fA.get(Integer.valueOf(paramInt));
      ahxr localahxr1 = localahxr2;
      if (localahxr2 == null)
      {
        localahxr1 = new ahxr();
        localahxr1.id = paramInt;
        this.fA.put(Integer.valueOf(paramInt), localahxr1);
      }
      return localahxr1;
    }
    finally {}
  }
  
  public void a(ahxs.c paramc)
  {
    this.jdField_a_of_type_Ahxs$c = paramc;
  }
  
  public void a(aqvd paramaqvd)
  {
    this.jdField_a_of_type_Aqvd = paramaqvd;
  }
  
  public void a(VipFontUpdate.TGetPosterFontRsp paramTGetPosterFontRsp, boolean paramBoolean)
  {
    this.F.clear();
    this.G.clear();
    this.H.clear();
    Object localObject = paramTGetPosterFontRsp.rpt_using_list.get();
    int i;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList size = " + ((List)localObject).size());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VipFontUpdate.TPosterFontInfo localTPosterFontInfo = (VipFontUpdate.TPosterFontInfo)((Iterator)localObject).next();
        i = localTPosterFontInfo.i32_font_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList id = " + i);
        }
        ahxr localahxr = a(i);
        localahxr.id = i;
        localahxr.validTime = localTPosterFontInfo.u64_ts.get();
        if (isExpired(localahxr.validTime)) {
          this.G.add(Integer.valueOf(i));
        } else {
          this.F.add(Integer.valueOf(i));
        }
      }
      Collections.reverse(this.F);
    }
    localObject = paramTGetPosterFontRsp.i32_recommend_font_id.get();
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList recommand size = " + ((List)localObject).size());
    }
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        i = ((Integer)((Iterator)localObject).next()).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomManager", 2, "parseHiBoomList recommand id = " + i);
        }
        a(i);
        this.H.add(Integer.valueOf(i));
      }
    }
    dqO();
    dqL();
    if (paramBoolean) {
      aqhq.writeFile(paramTGetPosterFontRsp.toByteArray(), bMn);
    }
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "sendHiBoomMessage hiBoomId = " + paramInt1);
    }
    int i;
    if ((paramBaseChatPie.getCurType() != 1008) && (paramBaseChatPie.getCurType() != 7200))
    {
      i = 1;
      if (i != 0)
      {
        localObject = ls(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label82;
        }
      }
    }
    label82:
    do
    {
      return false;
      i = 0;
      break;
      if (((String)localObject).length() > 20) {
        break label376;
      }
      if (!aofy.Z((String)localObject)) {
        break label165;
      }
    } while (this.mApp.getPreferences().getBoolean("HiBoom_CHN_Tips", false));
    QQToast.a(paramBaseChatPie.mContext, acfp.m(2131707143), 0).show();
    this.mApp.getPreferences().edit().putBoolean("HiBoom_CHN_Tips", true).apply();
    return false;
    label165:
    HiBoomMessage localHiBoomMessage = new HiBoomMessage();
    localHiBoomMessage.id = paramInt1;
    localHiBoomMessage.text = ((String)localObject);
    localHiBoomMessage.type = paramInt2;
    ujt.a(this.mApp, paramBaseChatPie.sessionInfo, localHiBoomMessage, null);
    Object localObject = "99";
    switch (a(paramInt1).Fr())
    {
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentUin(), "HighFont", "Send", "", 1, 0, 0, "", "" + paramInt1, (String)localObject);
      localObject = new ujt.d();
      paramBaseChatPie.a((ujt.d)localObject);
      ((ujt.d)localObject).aSL = paramBaseChatPie.aSL;
      paramBaseChatPie.aSL = false;
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (wwn)paramBaseChatPie.a(27);
        if (paramBaseChatPie != null) {
          paramBaseChatPie.a(paramString, (ujt.d)localObject, 0);
        }
      }
      return true;
      localObject = "2";
      continue;
      localObject = "3";
      continue;
      localObject = "1";
    }
    label376:
    QQToast.a(paramBaseChatPie.mContext, "嗨爆字体不能超过20字", 0).show();
    return false;
  }
  
  public boolean aor()
  {
    aheq.a(this.mApp).h(this.mApp);
    return (this.dc.get()) && (aos());
  }
  
  public void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ahxr localahxr = a(paramInt);
    Object localObject = new File(ahxo.bLZ + localahxr.id + File.separator + "hifont.json");
    if (((File)localObject).exists())
    {
      localObject = aqhq.b((File)localObject, -1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        for (;;)
        {
          try
          {
            localObject = new JSONObject((String)localObject);
            localahxr.name = ((JSONObject)localObject).optString("name");
            localahxr.engine = ((JSONObject)localObject).optInt("engine");
            localahxr.tag = ((JSONObject)localObject).optString("tag");
            if (!TextUtils.isEmpty(localahxr.tag)) {
              localahxr.tag = localahxr.tag.toLowerCase();
            }
            localahxr.ciP = ahxo.jX(paramInt);
            if (!localahxr.ciP)
            {
              localObject = new File(ahxo.bLZ + localahxr.id + File.separator + "panelImg.png");
              if (((File)localObject).exists()) {
                localahxr.fl = aqhu.d(((File)localObject).getAbsolutePath(), null);
              }
            }
            else
            {
              if (paramBoolean3)
              {
                localObject = new File(ahxo.bLZ + paramInt + File.separator + "aiodbclick.png");
                if (!((File)localObject).exists()) {
                  break label450;
                }
                localahxr.fm = aqhu.d(((File)localObject).getAbsolutePath(), null);
              }
              localahxr.da.set(true);
              if (paramBoolean2) {
                dqL();
              }
              if ((!paramBoolean3) || (this.cW == null)) {
                break;
              }
              localObject = this.cW.obtainMessage(19);
              ((Message)localObject).obj = localahxr.fm;
              this.cW.sendMessage((Message)localObject);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " preview not exists");
            }
            if (!paramBoolean1) {
              continue;
            }
            OZ(localahxr.id);
            continue;
            if (!QLog.isColorLevel()) {
              break label488;
            }
          }
          catch (Exception localException)
          {
            QLog.e("HiBoomFont.HiBoomManager", 1, "loadHiBoomConfig: " + Log.getStackTraceString(localException));
            return;
          }
          label450:
          QLog.d("HiBoomFont.HiBoomManager", 2, "loadHiBoomConfig id = " + paramInt + " aio preview not exists");
          label488:
          if (paramBoolean1) {
            OZ(localException.id);
          }
        }
      }
    }
    else if (paramBoolean1)
    {
      OZ(localException.id);
    }
  }
  
  public void cD(int paramInt, String paramString)
  {
    if (this.y.containsKey(Integer.valueOf(paramInt)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "downloadHiBoomFont id = " + paramInt + " is downloading");
      }
      return;
    }
    this.y.put(Integer.valueOf(paramInt), paramString);
    b.Pw(paramInt);
  }
  
  public void dqL()
  {
    synchronized (this.handlerLock)
    {
      if (this.cV != null) {
        this.cV.sendEmptyMessage(1);
      }
      return;
    }
  }
  
  public void dqM()
  {
    if (this.db.compareAndSet(false, true))
    {
      if (IS_DEBUG) {
        dqN();
      }
    }
    else {
      return;
    }
    ((acle)this.mApp.getBusinessHandler(13)).cMh();
  }
  
  public void dqP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "getHiBoomListFromLocal");
    }
    byte[] arrayOfByte = aqhq.readFile(bMn);
    VipFontUpdate.TGetPosterFontRsp localTGetPosterFontRsp;
    if (arrayOfByte != null) {
      localTGetPosterFontRsp = new VipFontUpdate.TGetPosterFontRsp();
    }
    try
    {
      localTGetPosterFontRsp.mergeFrom(arrayOfByte);
      a(localTGetPosterFontRsp, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("HiBoomFont.HiBoomManager", 1, "getHiBoomListFromLocal error: " + Log.getStackTraceString(localException));
    }
  }
  
  public JSONObject g(int paramInt)
  {
    i = 1;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localahxr = a(paramInt);
        if (!ahxo.jX(paramInt)) {
          continue;
        }
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", acfp.m(2131707151));
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (Exception localException)
      {
        ahxr localahxr;
        localException.printStackTrace();
        continue;
        if (localahxr.progress != -1) {
          continue;
        }
        localException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", acfp.m(2131707141));
        continue;
        localException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", acfp.m(2131707146));
        continue;
        i = 0;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "queryInfo hiboomId=" + paramInt + ",json=" + localJSONObject1.toString());
      }
      return localJSONObject1;
      if (!localahxr.ciP) {
        continue;
      }
      localJSONObject2.put("status", 3);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("message", acfp.m(2131707139));
      if (localahxr.progress != -3) {
        continue;
      }
      localJSONObject2.put("canceling", i);
      localJSONObject2.put("progress", localahxr.progress);
    }
  }
  
  public void in(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "updateHiBoomItemProgress id = " + paramInt1 + " progress = " + paramInt2);
    }
    a(paramInt1).progress = paramInt2;
    synchronized (this.handlerLock)
    {
      if (this.cV != null)
      {
        Message localMessage = this.cV.obtainMessage(2);
        localMessage.arg1 = paramInt1;
        localMessage.arg2 = paramInt2;
        this.cV.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void io(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    int j = 0;
    Object localObject2 = this.mApp.getCurrentUin();
    String str = "" + paramInt1;
    int i;
    if (paramInt2 == 0)
    {
      ??? = "0";
      VasWebviewUtil.reportCommercialDrainage((String)localObject2, "HighFont", "ClickDown", "", 1, 0, 0, "", str, (String)???);
      ??? = a(paramInt1);
      ((ahxr)???).isDownloading = false;
      if (paramInt2 != 0) {
        break label270;
      }
      i = 100;
      label90:
      ((ahxr)???).progress = i;
      if (paramInt2 != 0) {
        break label275;
      }
      ((ahxr)???).ciP = bool;
    }
    for (;;)
    {
      synchronized (this.handlerLock)
      {
        if (this.cV != null)
        {
          localObject2 = this.cV.obtainMessage(3);
          ((Message)localObject2).arg1 = paramInt1;
          this.cV.sendMessage((Message)localObject2);
        }
        localObject2 = (String)this.y.get(Integer.valueOf(paramInt1));
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.y.remove(Integer.valueOf(paramInt1));
          if ((!((String)localObject2).equals("0")) && (this.jdField_a_of_type_Aqvd != null))
          {
            ??? = new Bundle();
            ((Bundle)???).putString("callbackId", (String)localObject2);
            ((Bundle)???).putInt("srcType", 2);
            localObject2 = this.jdField_a_of_type_Aqvd;
            long l = paramInt1;
            if (paramInt2 != 0) {
              break label289;
            }
            paramInt1 = j;
            ((aqvd)localObject2).a(l, paramInt1, (Bundle)???);
          }
        }
        return;
        ??? = "1";
        break;
        label270:
        i = -1;
        break label90;
        label275:
        bool = false;
      }
      label289:
      paramInt1 = -1;
    }
  }
  
  public void onAIODestroy()
  {
    if (this.cV != null) {
      this.cV.removeCallbacksAndMessages(null);
    }
    synchronized (this.handlerLock)
    {
      this.cV = null;
      this.jdField_a_of_type_Ahxs$c = null;
      return;
    }
  }
  
  public void onDestroy() {}
  
  public static class a
    extends achq
  {
    private WeakReference<Context> hc;
    
    public a(Context paramContext)
    {
      this.hc = new WeakReference(paramContext);
    }
    
    protected void k(int paramInt, byte[] paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult errorCode = " + paramInt);
      }
      Context localContext = (Context)this.hc.get();
      if ((paramInt != 0) && (localContext != null)) {
        ahxs.a(localContext, paramArrayOfByte, 0);
      }
    }
  }
  
  public static class b
    extends aclh
  {
    private WeakReference<Context> hc;
    
    public b(Context paramContext)
    {
      this.hc = new WeakReference(paramContext);
    }
    
    public void aF(boolean paramBoolean, Object paramObject)
    {
      int k = -1;
      Context localContext = (Context)this.hc.get();
      if (localContext == null)
      {
        QLog.e("HiBoomFont.HiBoomManager", 1, "onAuthHiBoom: context == null");
        return;
      }
      Object localObject = ahxs.a(localContext);
      if ((localObject != null) && (((arhz)localObject).isShowing())) {
        ((arhz)localObject).dismiss();
      }
      label124:
      int j;
      if ((paramBoolean) && ((paramObject instanceof Object[])))
      {
        Object[] arrayOfObject = (Object[])paramObject;
        if (arrayOfObject.length >= 5)
        {
          int i;
          if ((arrayOfObject[0] instanceof Integer))
          {
            i = ((Integer)arrayOfObject[0]).intValue();
            if (!(arrayOfObject[1] instanceof byte[])) {
              break label217;
            }
            localObject = (byte[])arrayOfObject[1];
            if (!(arrayOfObject[2] instanceof Integer)) {
              break label223;
            }
            j = ((Integer)arrayOfObject[2]).intValue();
            label146:
            if (!(arrayOfObject[3] instanceof String)) {
              break label229;
            }
          }
          label217:
          label223:
          label229:
          for (paramObject = (String)arrayOfObject[3];; paramObject = null)
          {
            if ((arrayOfObject[4] instanceof Integer)) {
              k = ((Integer)arrayOfObject[4]).intValue();
            }
            if (i == 0) {
              break label234;
            }
            if (localObject == null) {
              break label260;
            }
            ahxs.a(localContext, (byte[])localObject, j);
            ahxs.dd.set(false);
            return;
            i = -1;
            break;
            localObject = null;
            break label124;
            j = -1;
            break label146;
          }
        }
      }
      switch (k)
      {
      default: 
        QQToast.a(localContext, 1, acfp.m(2131707150), 0).show();
        ahxs.dd.set(false);
        return;
      case 1: 
        label234:
        localObject = new Bundle();
        label260:
        ((Bundle)localObject).putInt("forward_type", 37);
        ((Bundle)localObject).putInt("emoInputType", 5);
        ((Bundle)localObject).putString("forward_text", paramObject);
        ((Bundle)localObject).putInt("key_hiboom_id", j);
        ((Bundle)localObject).putInt("key_hiboom_type", ahxs.hY(j));
        paramObject = new Intent();
        paramObject.putExtras((Bundle)localObject);
        ahgq.f((Activity)localContext, paramObject, 21);
        return;
      }
      if ((localContext instanceof FragmentActivity))
      {
        localObject = (FragmentActivity)localContext;
        if ((((FragmentActivity)localObject).getChatFragment() != null) && (((FragmentActivity)localObject).getChatFragment().a() != null))
        {
          localObject = ((FragmentActivity)localObject).getChatFragment().a();
          ((ahxs)((BaseChatPie)localObject).app.getManager(219)).a((BaseChatPie)localObject, paramObject, j, ahxs.hY(j));
          ((BaseChatPie)localObject).aey();
          ((BaseChatPie)localObject).a.setText("");
        }
      }
      ahxs.dd.set(false);
    }
    
    public void aG(boolean paramBoolean, Object paramObject)
    {
      int j = -1;
      Context localContext = (Context)this.hc.get();
      if (localContext == null) {
        QLog.e("HiBoomFont.HiBoomManager", 1, "onAuthHiBoom: context == null");
      }
      for (;;)
      {
        return;
        Object localObject = ahxs.a(localContext);
        if ((localObject != null) && (((arhz)localObject).isShowing())) {
          ((arhz)localObject).dismiss();
        }
        if (paramBoolean)
        {
          if (!(paramObject instanceof Object[])) {
            break label454;
          }
          localObject = (Object[])paramObject;
          if (localObject.length >= 5)
          {
            int i;
            if ((localObject[0] instanceof Integer))
            {
              i = ((Integer)localObject[0]).intValue();
              label102:
              if ((localObject[1] instanceof Integer)) {
                j = ((Integer)localObject[1]).intValue();
              }
              if (!(localObject[2] instanceof byte[])) {
                break label249;
              }
              paramObject = (byte[])localObject[2];
              label145:
              if (!(localObject[3] instanceof Boolean)) {
                break label254;
              }
              paramBoolean = ((Boolean)localObject[3]).booleanValue();
              label166:
              if (!(localObject[4] instanceof String)) {
                break label259;
              }
            }
            label259:
            for (localObject = (String)localObject[4];; localObject = null)
            {
              if (i == 0) {
                break label265;
              }
              QLog.d("HiBoomFont.HiBoomManager", 1, "onSetHiBoom fail ret = " + i + " id = " + j);
              if (!paramBoolean) {
                break;
              }
              ahxs.a(localContext, paramObject, j);
              ahxs.dd.set(false);
              return;
              i = -1;
              break label102;
              label249:
              paramObject = null;
              break label145;
              label254:
              paramBoolean = false;
              break label166;
            }
            label265:
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomManager", 2, "onSetHiBoom success");
            }
            if (paramBoolean)
            {
              if ((localContext instanceof FragmentActivity))
              {
                paramObject = (FragmentActivity)localContext;
                if ((paramObject.getChatFragment() != null) && (paramObject.getChatFragment().a() != null))
                {
                  paramObject = paramObject.getChatFragment().a();
                  ((ahxs)paramObject.app.getManager(219)).a(paramObject, (String)localObject, j, ahxs.hY(j));
                  paramObject.aey();
                  paramObject.a.setText("");
                }
              }
              ahxs.dd.set(false);
            }
            paramObject = BaseApplicationImpl.getApplication().getRuntime();
            if (!(paramObject instanceof QQAppInterface)) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomManager", 2, "onSetHiBoom get hiboom list");
            }
            ((acle)((QQAppInterface)paramObject).getBusinessHandler(13)).cMh();
            return;
          }
          paramBoolean = false;
        }
        while (paramBoolean)
        {
          QQToast.a(localContext, 1, acfp.m(2131707147), 0).show();
          ahxs.dd.set(false);
          return;
          paramBoolean = ((Boolean)paramObject).booleanValue();
          continue;
          label454:
          paramBoolean = false;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void KH(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxs
 * JD-Core Version:    0.7.0.1
 */