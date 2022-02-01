package com.tencent.av.business.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import aoll;
import aolm;
import aomi;
import aqec;
import aqhq;
import aqiw;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igd;
import igg;
import igk;
import igl;
import iiv;
import ijo;
import ijr;
import ijs;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jll;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EffectConfigBase<T extends b>
  extends ijo
{
  private static String Nh = "qav_config_";
  private static String Ni = "text";
  public static String Nj = "ver";
  public static String Nk = "0";
  protected final ijr a = new ijr();
  int anL = 0;
  public Handler ar = new c(this.TAG, this);
  protected T b;
  protected List<T> fd;
  protected List<T> fe;
  protected List<WeakReference<a<T>>> ff = new ArrayList();
  protected List<T> mItemList;
  
  public EffectConfigBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static SharedPreferences a(int paramInt, String paramString)
  {
    paramString = h(paramInt, paramString);
    return BaseApplicationImpl.getContext().getSharedPreferences(paramString, 4);
  }
  
  private WeakReference<a<T>> a(a<T> parama)
  {
    int j = this.ff.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.ff.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((a)localWeakReference.get()).equals(parama))) {
        return localWeakReference;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(long paramLong, T paramT, boolean paramBoolean)
  {
    if (AudioHelper.aCz()) {
      QLog.w(this.TAG, 1, "triggleonResourceDownloadFinished, id[" + paramT.getId() + "], isSuccess[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = a(paramT.getId());
      if (localObject != null) {
        ((b)localObject).setUsable(true);
      }
    }
    int j = this.ff.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.ff.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((a)((WeakReference)localObject).get()).onDownloadFinish(paramLong, paramT, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(T paramT, int paramInt)
  {
    int j = this.ff.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.ff.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((a)localWeakReference.get()).onProgressUpdate(paramT, paramInt);
      }
      i += 1;
    }
  }
  
  private boolean a(T paramT1, T paramT2)
  {
    if (paramT1 == null) {
      if (paramT2 != null) {}
    }
    while ((paramT2 != null) && (paramT1.getId().equals(paramT2.getId())))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void b(long paramLong, T paramT)
  {
    int j = this.ff.size();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "triggleonItemSelectedChanged, size[" + j + "], seq[" + paramLong + "]");
    }
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.ff.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((a)localWeakReference.get()).onItemSelectedChanged(paramLong, paramT);
      }
      i += 1;
    }
  }
  
  public static String h(int paramInt, String paramString)
  {
    if ((AudioHelper.isDev()) && (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("getConfigSPName uin不能为空, configId:" + paramInt);
    }
    return Nh + paramInt + "_" + paramString;
  }
  
  public static String i(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getString(Ni, null);
  }
  
  public static int j(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getInt(Nj, 0);
  }
  
  public static void j(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    SharedPreferences.Editor localEditor = a(paramInt1, paramString1).edit();
    if (paramString2 == null)
    {
      localEditor.remove(Ni);
      localEditor.putInt(Nj, paramInt2);
      localEditor.commit();
      if (!QLog.isDevelopLevel()) {
        break label149;
      }
    }
    for (;;)
    {
      QLog.w("EffectConfigBase_" + paramInt1, 1, "saveConfig, configId[" + paramInt1 + "], uin[" + paramString1 + "], version[" + paramInt2 + "],\n" + paramString2 + "");
      return;
      localEditor.putString(Ni, paramString2);
      break;
      label149:
      if (paramString2 == null) {
        paramString2 = "null";
      } else {
        paramString2 = paramString2.length() + "";
      }
    }
  }
  
  public void U(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramString.equals(this.mApp.b().b().peerUin)) || (paramString.equals(String.valueOf(this.mApp.b().b().ll))))) {
      a(AudioHelper.hG(), null);
    }
  }
  
  public T a()
  {
    return this.b;
  }
  
  public T a(String paramString)
  {
    parse();
    Iterator localIterator;
    b localb;
    if ((this.mItemList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.mItemList.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (paramString.equals(localb.getId())) {
          return localb;
        }
      }
    }
    if ((this.fd != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.fd.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (paramString.equals(localb.getId())) {
          return localb;
        }
      }
    }
    if ((this.fe != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.fe.iterator();
      while (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (paramString.equals(localb.getId())) {
          return localb;
        }
      }
    }
    return null;
  }
  
  protected abstract Class<?> a();
  
  public String a(T paramT)
  {
    return igg.gu() + paramT.cid + File.separator + "temp" + File.separator + paramT.getId() + ".zip";
  }
  
  protected List<T> a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    int i;
    int j;
    label68:
    b localb;
    int m;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        localObject = new JSONObject(paramString);
        k = jll.mM();
        if (paramInt != 543) {
          break label432;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        Object localObject;
        boolean bool2;
        String str1;
        String str2;
        File localFile;
        QLog.w(this.TAG, 1, "parse, cid[" + paramInt + "], Exception", paramString);
        j(paramInt, Nk, 0, null);
      }
      if (((JSONObject)localObject).has(paramString))
      {
        paramString = ((JSONObject)localObject).getJSONArray(paramString);
        localObject = a();
        j = 0;
        if (j < paramString.length())
        {
          localb = (b)aqec.convertFrom((JSONObject)paramString.get(j), (Class)localObject);
          if ((localb == null) || (TextUtils.isEmpty(localb.getId()))) {
            break label423;
          }
          localb.cid = paramInt;
          m = localb.getPlatform();
          igd.aJ(this.TAG, "cid = " + localb.cid + ", item: " + localb.toString() + "|" + k + "|" + m);
          bool2 = a(localb);
          bool1 = bool2;
          if (bool2)
          {
            str1 = a(localb);
            str2 = b(localb);
            localFile = new File(str2);
            bool1 = localFile.exists();
            if (bool1) {}
          }
        }
      }
    }
    label423:
    label432:
    label435:
    for (;;)
    {
      try
      {
        aqhq.W(str1, str2, false);
        bool1 = localFile.exists();
        if (i == 0) {
          break label382;
        }
        localb.setUsable(bool1);
        localArrayList.add(localb);
        break label423;
        paramString = gL();
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.TAG, 1, "parse item fail, item[" + localb + "]", localThrowable);
        continue;
      }
      return localArrayList;
      label382:
      if ((m == 0) || (k >= m))
      {
        localb.setUsable(bool1);
        localArrayList.add(localb);
      }
      for (;;)
      {
        if (i == 0) {
          break label435;
        }
        paramString = "content";
        break;
        j += 1;
        break label68;
        i = 0;
      }
    }
  }
  
  public void a(long paramLong, a<T> parama)
  {
    if (parama != null)
    {
      if (a(parama) == null)
      {
        WeakReference localWeakReference = new WeakReference(parama);
        this.ff.add(localWeakReference);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "addCallback, callback[" + parama.getClass().getSimpleName() + "], callback[" + parama + "], seq[" + paramLong + "]");
      }
    }
  }
  
  public void a(long paramLong, T paramT)
  {
    if ((paramT.isUsable()) || (TextUtils.isEmpty(paramT.getResurl())))
    {
      QLog.w(this.TAG, 1, "startDownload, 不下载, item[" + paramT + "], seq[" + paramLong + "]");
      paramT.isDownloading = false;
      this.ar.obtainMessage(1, 1, (int)paramLong, paramT).sendToTarget();
      return;
    }
    aoll localaoll = new aoll();
    localaoll.f = new ijs(this, paramLong, paramT);
    localaoll.bZ = paramT.getResurl();
    localaoll.mHttpMethod = 0;
    localaoll.atY = a(paramT);
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    localaoll.bw(paramT);
    QLog.w(this.TAG, 1, "startDownload, item[" + paramT + "], seq[" + paramLong + "]");
    paramT.isDownloading = true;
    ThreadManager.post(new NetReqRunnable(localaoll), 5, null, true);
  }
  
  public void a(T paramT) {}
  
  public boolean a(long paramLong, T paramT)
  {
    b localb = null;
    Object localObject = null;
    if (!a(this.b, paramT))
    {
      localb = this.b;
      this.b = paramT;
      if (AudioHelper.aCz())
      {
        if (QLog.isDevelopLevel()) {
          localObject = new Throwable("打印调用栈");
        }
        QLog.w(this.TAG, 1, "setCurrentItem, notify MSG_ON_ITEM_SELECT_CHANGED, seq[" + paramLong + "], count_MSG[" + this.anL + "], \nlast[" + localb + "], \nnew[" + this.b + "]", (Throwable)localObject);
      }
      this.ar.removeMessages(0);
      this.anL = 1;
      paramT = this.ar.obtainMessage(0, paramT);
      paramT.arg1 = ((int)paramLong);
      this.ar.sendMessage(paramT);
      return true;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = localb;
      if (QLog.isDevelopLevel()) {
        localObject = new Throwable("打印调用栈");
      }
      QLog.w(this.TAG, 1, "setCurrentItem, 重复, seq[" + paramLong + "], count_MSG_ON_ITEM_SELECT_CHANGED[" + this.anL + "], item[" + paramT + "]", (Throwable)localObject);
    }
    return false;
  }
  
  protected boolean a(T paramT)
  {
    if ((paramT == null) || (paramT.cid <= 0) || (TextUtils.isEmpty(paramT.getId())))
    {
      str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("isTemplateUsable:");
      if (paramT != null) {}
      for (paramT = Integer.valueOf(paramT.cid);; paramT = "item == null")
      {
        igd.aL(str, paramT + "|");
        return false;
      }
    }
    if (TextUtils.isEmpty(paramT.getResurl())) {
      return true;
    }
    String str = a(paramT);
    if (!new File(str).exists()) {
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    str = SecUtil.getFileMd5(str);
    long l2 = SystemClock.elapsedRealtime();
    paramT = paramT.getMd5();
    igd.aJ(this.TAG, "isTemplateUsable :" + str + "|" + paramT + "|" + (l2 - l1));
    return paramT.equalsIgnoreCase(str);
  }
  
  protected void ai(Message paramMessage) {}
  
  public String b(T paramT)
  {
    return igg.gu() + paramT.cid + File.separator + paramT.getId() + File.separator;
  }
  
  public void b(long paramLong, a<T> parama)
  {
    if (parama != null)
    {
      if (a(parama) != null) {
        this.ff.remove(parama);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "removeCallback, callback[" + parama.getClass().getSimpleName() + "], callback[" + parama + "], seq[" + paramLong + "]");
      }
    }
  }
  
  public String c(T paramT)
  {
    return igg.gu() + paramT.cid + File.separator + paramT.getId();
  }
  
  public boolean d(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.TAG, 1, "setCurrentItemById, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if (TextUtils.isEmpty(paramString))
    {
      a(paramLong, null);
      return true;
    }
    a(paramLong, a(paramString));
    return true;
  }
  
  protected String gL()
  {
    return "content";
  }
  
  public abstract int getConfigID();
  
  protected String getConfigString()
  {
    String str = null;
    igk localigk = igl.b(getConfigID());
    if (localigk != null) {
      str = localigk.content;
    }
    return str;
  }
  
  public int h(int paramInt, String paramString)
  {
    return 0;
  }
  
  public int i(int paramInt, String paramString)
  {
    igd.aJ(this.TAG, "onSendMessageToPeer :" + paramInt + "|" + paramString);
    return this.mApp.b().d(paramInt, paramString);
  }
  
  public void onCreate() {}
  
  public void parse()
  {
    if ((this.mItemList == null) || (this.mItemList.size() == 0))
    {
      String str = getConfigString();
      this.mItemList = a(getConfigID(), str);
    }
    if (getConfigID() == 176)
    {
      if ((this.fd == null) || (this.fd.size() == 0)) {
        this.fd = a(370, igl.b(370).content);
      }
      if ((this.fe == null) || (this.fe.size() == 0)) {
        this.fe = a(543, igl.b(543).content);
      }
    }
  }
  
  public List<T> y(String paramString)
  {
    parse();
    if (TextUtils.equals("voicesticker", paramString)) {
      return this.fd;
    }
    if (TextUtils.equals("creativecop", paramString)) {
      return this.fe;
    }
    return this.mItemList;
  }
  
  class NetReqRunnable
    implements Runnable
  {
    final aoll d;
    
    public NetReqRunnable(aoll paramaoll)
    {
      this.d = paramaoll;
    }
    
    public void run()
    {
      try
      {
        if ((EffectConfigBase.this.mApp != null) && (this.d != null)) {
          EffectConfigBase.this.mApp.getNetEngine(0).a(this.d);
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        localException.printStackTrace();
      }
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void onDownloadFinish(long paramLong, T paramT, boolean paramBoolean);
    
    public abstract void onItemSelectedChanged(long paramLong, T paramT);
    
    public abstract void onProgressUpdate(T paramT, int paramInt);
  }
  
  public static abstract class b
  {
    public int cid = -1;
    public boolean isDownloading;
    
    public abstract String getDesc();
    
    public abstract String getIconurl();
    
    public abstract String getId();
    
    public abstract String getMd5();
    
    public abstract int getPlatform();
    
    public abstract String getResurl();
    
    public abstract boolean isUsable();
    
    public abstract void setUsable(boolean paramBoolean);
  }
  
  static class c<T extends EffectConfigBase.b>
    extends Handler
  {
    final String TAG;
    WeakReference<EffectConfigBase<T>> weakReference;
    
    c(String paramString, EffectConfigBase<T> paramEffectConfigBase)
    {
      this.TAG = paramString;
      this.weakReference = new WeakReference(paramEffectConfigBase);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (this.weakReference.get() != null)
      {
        EffectConfigBase localEffectConfigBase = (EffectConfigBase)this.weakReference.get();
        EffectConfigBase.b localb;
        switch (paramMessage.what)
        {
        default: 
          localEffectConfigBase.ai(paramMessage);
        case 0: 
          do
          {
            return;
            localb = (EffectConfigBase.b)paramMessage.obj;
            l = paramMessage.arg1;
            bool = EffectConfigBase.a(localEffectConfigBase, localb, localEffectConfigBase.b);
            QLog.w(this.TAG, 1, "MSG_ON_ITEM_SELECT_CHANGED, seq[" + l + "], isEqual[" + bool + "], count_MSG[" + localEffectConfigBase.anL + "], \nitem[" + localb + "], \ncur[" + localEffectConfigBase.b + "]");
            if (localEffectConfigBase.anL >= 0) {
              localEffectConfigBase.anL -= 1;
            }
          } while (!bool);
          EffectConfigBase.a(localEffectConfigBase, l, localb);
          return;
        case 1: 
          localb = (EffectConfigBase.b)paramMessage.obj;
          l = paramMessage.arg2;
          if (paramMessage.arg1 == 1) {}
          for (;;)
          {
            EffectConfigBase.a(localEffectConfigBase, l, localb, bool);
            return;
            bool = false;
          }
        }
        EffectConfigBase.a(localEffectConfigBase, (EffectConfigBase.b)paramMessage.obj, paramMessage.arg1);
        return;
      }
      long l = 0L;
      if (paramMessage.what == 0) {
        l = paramMessage.arg1;
      }
      QLog.w(this.TAG, 1, "handleMessage, had destroy, msg[" + paramMessage.what + "], seq[" + l + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase
 * JD-Core Version:    0.7.0.1
 */