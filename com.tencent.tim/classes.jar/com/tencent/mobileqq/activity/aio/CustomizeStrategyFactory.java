package com.tencent.mobileqq.activity.aio;

import aaai;
import aaai.b;
import acgn.c;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import wkq;
import wks;
import wkt;
import wku;
import xwc;
import xwd;
import xwe;
import xwf;
import xwg;
import xwh;
import xwi;
import xwj;

public class CustomizeStrategyFactory
  implements aaai.b, Handler.Callback
{
  private static volatile CustomizeStrategyFactory a;
  public static byte[] cm = new byte[0];
  public static float density = 1.0F;
  public aaai a;
  public boolean bdM = true;
  public boolean bdN;
  private boolean bdO;
  private boolean bdP;
  private SparseArray<b> bs = new SparseArray(5);
  private QQLruCache<String, xwc> c = new wkq(this, 1020, 30, 10000);
  private byte[] cn = new byte[0];
  private HashMap<Object, c> gI;
  private Handler mUIHandler;
  
  private CustomizeStrategyFactory()
  {
    bZb();
    this.gI = new HashMap(8);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this);
    density = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
  }
  
  private b a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomizeStrategyFactory", 2, "getCustomizeStrategy type =" + paramInt);
    }
    b localb = (b)this.bs.get(paramInt);
    if (localb != null) {
      return localb;
    }
    if (2 == paramInt) {
      paramQQAppInterface = new acgn.c(paramQQAppInterface);
    }
    for (;;)
    {
      this.bs.append(paramInt, paramQQAppInterface);
      return paramQQAppInterface;
      if (1 == paramInt) {
        paramQQAppInterface = new g(paramQQAppInterface);
      } else if (4 == paramInt) {
        paramQQAppInterface = new f(paramQQAppInterface);
      } else if (5 == paramInt) {
        paramQQAppInterface = new e(paramQQAppInterface);
      } else if (6 == paramInt) {
        paramQQAppInterface = new h(paramQQAppInterface);
      } else if (7 == paramInt) {
        paramQQAppInterface = new d(paramQQAppInterface);
      } else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static CustomizeStrategyFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory = new CustomizeStrategyFactory();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory;
    }
    finally {}
  }
  
  private void a(RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo == null) || (!paramRedPacketInfo.aHx) || (paramRedPacketInfo.a == null) || (TextUtils.isEmpty(paramRedPacketInfo.a.aSI))) {
      return;
    }
    paramRedPacketInfo = new CustomizeStrategyFactory.3(this, paramRedPacketInfo);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(paramRedPacketInfo, 5, null, true);
      return;
    }
    paramRedPacketInfo.run();
  }
  
  private void bZb()
  {
    ThreadManager.post(new CustomizeStrategyFactory.2(this), 5, null, true);
  }
  
  public boolean Rr()
  {
    return this.bdN;
  }
  
  public RedPacketInfo a(QQAppInterface paramQQAppInterface, RedPacketInfo paramRedPacketInfo, c paramc)
  {
    if ((paramRedPacketInfo == null) || (paramc == null))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramRedPacketInfo.type);
    if (paramRedPacketInfo.type == 5) {
      ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.skinType).append("_").append(paramRedPacketInfo.skinId).append("_").append(paramRedPacketInfo.bigAnimId);
    }
    for (;;)
    {
      paramRedPacketInfo.Qi = ((StringBuilder)localObject).toString();
      localObject = a(paramRedPacketInfo.type, paramQQAppInterface);
      paramQQAppInterface = paramRedPacketInfo;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = (xwc)this.c.get(paramRedPacketInfo.Qi);
      if (paramQQAppInterface != null) {
        break label195;
      }
      this.gI.put(paramRedPacketInfo, paramc);
      ((b)localObject).c(paramRedPacketInfo);
      return paramRedPacketInfo;
      ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.templateId);
      if ((paramRedPacketInfo.type == 2) && (!TextUtils.isEmpty(paramRedPacketInfo.content))) {
        ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.content);
      }
    }
    label195:
    ((b)localObject).a(paramRedPacketInfo, paramQQAppInterface);
    return paramRedPacketInfo;
  }
  
  public void a(String paramString1, String paramString2, QWalletConfig.a parama)
  {
    if (this.c == null) {
      return;
    }
    paramString1 = this.c.snapshot().entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (xwc)((Map.Entry)paramString1.next()).getValue();
      if (((paramString2 instanceof xwg)) || ((paramString2 instanceof xwd))) {
        paramString1.remove();
      }
    }
    RedPacketManager.getInstance().onUpdate(1);
  }
  
  public void b(RedPacketInfo paramRedPacketInfo)
  {
    if ((this.mUIHandler != null) && (paramRedPacketInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "notifyCustomizeFinish-type:" + paramRedPacketInfo.type + " isAnimation:" + paramRedPacketInfo.aHx);
      }
      if ((paramRedPacketInfo.type == 2) && (paramRedPacketInfo.aHx) && (!paramRedPacketInfo.bdQ)) {
        a(paramRedPacketInfo);
      }
    }
    else
    {
      return;
    }
    Message localMessage = this.mUIHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramRedPacketInfo;
    this.mUIHandler.sendMessage(localMessage);
  }
  
  public void bZc()
  {
    if (this.gI != null) {
      this.gI.clear();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    RedPacketInfo localRedPacketInfo;
    c localc;
    if (paramMessage.what == 1)
    {
      localRedPacketInfo = (RedPacketInfo)paramMessage.obj;
      localc = (c)this.gI.remove(localRedPacketInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "handleMessage info type=" + localRedPacketInfo.type + "| listener=" + localc + "| templateId=" + localRedPacketInfo.templateId + "| content=" + localRedPacketInfo.content + "| info=" + localRedPacketInfo + "|" + System.currentTimeMillis());
      }
      if (!this.c.containsKey(localRedPacketInfo.Qi))
      {
        paramMessage = null;
        if (localRedPacketInfo.type != 2) {
          break label203;
        }
        paramMessage = new xwi(localRedPacketInfo.Qi);
        paramMessage.d(localRedPacketInfo);
      }
    }
    for (;;)
    {
      if ((paramMessage != null) && (paramMessage.isValid())) {
        this.c.put(localRedPacketInfo.Qi, paramMessage);
      }
      if (localc != null) {
        localc.onSucc(localRedPacketInfo.type, localRedPacketInfo);
      }
      return false;
      label203:
      if ((localRedPacketInfo.type == 1) || (localRedPacketInfo.type == 4))
      {
        paramMessage = new xwh(localRedPacketInfo.Qi);
        paramMessage.d(localRedPacketInfo);
      }
      else if (localRedPacketInfo.type == 5)
      {
        if (localRedPacketInfo.skinType == 1)
        {
          paramMessage = new xwg(localRedPacketInfo.Qi);
          paramMessage.d(localRedPacketInfo);
          localRedPacketInfo.icon = paramMessage.a(localRedPacketInfo);
        }
        else if ((localRedPacketInfo.skinType == 2) || (localRedPacketInfo.skinType == 4))
        {
          paramMessage = new xwf(localRedPacketInfo.Qi);
          paramMessage.d(localRedPacketInfo);
        }
        else if (localRedPacketInfo.skinType == 3)
        {
          paramMessage = new xwd(localRedPacketInfo.Qi);
          paramMessage.d(localRedPacketInfo);
        }
      }
      else if (localRedPacketInfo.type == 6)
      {
        paramMessage = new xwj(localRedPacketInfo.Qi);
        paramMessage.d(localRedPacketInfo);
      }
      else if (localRedPacketInfo.type == 7)
      {
        paramMessage = new xwe(localRedPacketInfo.Qi);
        paramMessage.d(localRedPacketInfo);
      }
    }
  }
  
  public void onDestory()
  {
    bZc();
    if (this.c != null) {
      this.c.evictAll();
    }
    if (this.bs != null)
    {
      int j = this.bs.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.bs.valueAt(i)).onDestory();
        i += 1;
      }
      this.bs.clear();
    }
    synchronized (this.cn)
    {
      if (this.jdField_a_of_type_Aaai != null) {
        this.jdField_a_of_type_Aaai.b("redPack", this);
      }
      this.bdP = true;
      this.bdM = true;
      this.mUIHandler = null;
      jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory = null;
      this.bdN = false;
      this.bdO = false;
      return;
    }
  }
  
  public void yv(boolean paramBoolean)
  {
    this.bdN = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "setInAIO isInAIO=" + paramBoolean + ",refreshListView=" + this.bdO);
    }
    if (paramBoolean) {
      this.bdM = false;
    }
    synchronized (cm)
    {
      cm.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "setLockFlag lockFlag" + this.bdM);
      }
      if (this.bdO)
      {
        this.bdO = false;
        ??? = BaseApplicationImpl.sApplication.getRuntime();
        if ((??? instanceof QQAppInterface))
        {
          ??? = ((QQAppInterface)???).getHandler(ChatActivity.class);
          if (??? != null) {
            ((MqqHandler)???).sendEmptyMessage(12);
          }
        }
      }
      return;
    }
  }
  
  public void yw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "setRefreshListView refreshListView=" + paramBoolean);
    }
    this.bdO = paramBoolean;
  }
  
  public static class RedPacketInfo
    extends RedPacketInfoBase
  {
    public String Qi;
    public CustomizeStrategyFactory.a a;
    public boolean aHx;
    public boolean bdQ;
    public long beginTime;
    public String content;
    public Bitmap dv;
    public Drawable[] e;
    public MessageRecord h;
    
    public boolean Rs()
    {
      Object localObject2 = null;
      if ((this.aHx) && (this.e != null) && (this.e.length > 0) && (this.a != null) && (this.a.delay > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CustomizeStrategyFactory", 2, "anim valid");
        }
        return true;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("anim invalid|").append(this.aHx).append("|");
        if (this.e == null) {
          break label151;
        }
      }
      label151:
      for (Object localObject1 = Integer.valueOf(this.e.length);; localObject1 = null)
      {
        localStringBuilder = localStringBuilder.append(localObject1).append("|");
        localObject1 = localObject2;
        if (this.a != null) {
          localObject1 = Integer.valueOf(this.a.delay);
        }
        QLog.d("CustomizeStrategyFactory", 2, localObject1);
        return false;
      }
    }
    
    public int getIsHideTitleDefault()
    {
      if ((this.h instanceof MessageForQQWalletMsg)) {
        return ((MessageForQQWalletMsg)this.h).getIsHideTitleDefault();
      }
      return 0;
    }
  }
  
  public static class a
  {
    public String aSI;
    public int delay;
    public int size;
  }
  
  public static abstract interface b
  {
    public abstract void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc);
    
    public abstract void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo);
    
    public abstract void onDestory();
  }
  
  public static abstract interface c
  {
    public abstract void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo);
  }
  
  public static class d
    implements CustomizeStrategyFactory.b
  {
    PreloadManager a = null;
    private QQAppInterface app;
    aaai b = null;
    
    d(QQAppInterface paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
      if (this.app != null)
      {
        this.a = ((PreloadManager)this.app.getManager(151));
        this.b = ((aaai)this.app.getManager(245));
      }
    }
    
    public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc)
    {
      if ((paramRedPacketInfo != null) && ((paramxwc instanceof xwe)))
      {
        paramxwc = (xwe)paramxwc;
        paramRedPacketInfo.icon = paramxwc.icon;
        paramRedPacketInfo.resPath = paramxwc.resPath;
      }
    }
    
    public void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      ThreadManager.post(new CustomizeStrategyFactory.PanelStrategy.1(this, paramRedPacketInfo), 5, null, true);
    }
    
    public void onDestory() {}
  }
  
  public static class e
    implements CustomizeStrategyFactory.b
  {
    PreloadManager a = null;
    private QQAppInterface app;
    aaai b = null;
    
    e(QQAppInterface paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
      if (this.app != null)
      {
        this.a = ((PreloadManager)this.app.getManager(151));
        this.b = ((aaai)this.app.getManager(245));
      }
    }
    
    private void a(@NonNull PreloadManager paramPreloadManager, @NonNull aaai paramaaai, @NonNull CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      String str1 = null;
      String str2 = paramaaai.a("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
      switch (paramRedPacketInfo.skinType)
      {
      default: 
        return;
      case 1: 
      case 2: 
        JSONObject localJSONObject = paramaaai.a("redPack", new String[] { "skinMap" });
        paramaaai = str1;
        if (localJSONObject != null)
        {
          localJSONObject = localJSONObject.optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
          paramaaai = str1;
          if (localJSONObject != null)
          {
            paramaaai = localJSONObject.optString("aioZipMd5", "");
            str1 = localJSONObject.optString("popZipMd5", "");
            if (paramRedPacketInfo.skinType != 1) {
              break label220;
            }
            paramRedPacketInfo.title = localJSONObject.optString("title", "");
            paramRedPacketInfo.isHideTitle = localJSONObject.optInt("isHideTitle", paramRedPacketInfo.getIsHideTitleDefault());
          }
        }
        if (paramRedPacketInfo.skinType == 1) {}
        for (str1 = "aio_";; str1 = "pop_")
        {
          paramPreloadManager.a(str2 + str1 + paramRedPacketInfo.skinId + ".zip", paramaaai, new wks(this, paramRedPacketInfo));
          return;
          paramaaai = str1;
          break;
        }
      case 3: 
        label220:
        paramaaai = paramaaai.a("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
        paramPreloadManager.a(str2 + "aio_special_" + paramRedPacketInfo.bigAnimId + ".zip", paramaaai, new wkt(this, paramRedPacketInfo));
        return;
      }
      paramaaai = paramaaai.a("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      paramPreloadManager.a(str2 + "pop_anim_" + paramRedPacketInfo.bigAnimId + ".png", paramaaai, new wku(this, paramRedPacketInfo));
    }
    
    public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc)
    {
      if (paramRedPacketInfo != null)
      {
        if (!(paramxwc instanceof xwg)) {
          break label74;
        }
        paramxwc = (xwg)paramxwc;
        paramRedPacketInfo.background = paramxwc.background;
        paramRedPacketInfo.corner = paramxwc.corner;
        paramRedPacketInfo.animInfo = paramxwc.animInfo;
        paramRedPacketInfo.title = paramxwc.title;
        paramRedPacketInfo.icon = paramxwc.a(paramRedPacketInfo);
        paramRedPacketInfo.isHideTitle = paramxwc.isHideTitle;
        paramRedPacketInfo.resPath = paramxwc.resPath;
      }
      label74:
      do
      {
        return;
        if ((paramxwc instanceof xwd))
        {
          paramxwc = (xwd)paramxwc;
          paramRedPacketInfo.specailBackgroundAnimInfo = paramxwc.specailBackgroundAnimInfo;
          paramRedPacketInfo.specialBackground = paramxwc.specialBackground;
          return;
        }
      } while (!(paramxwc instanceof xwf));
      paramRedPacketInfo.resPath = ((xwf)paramxwc).resPath;
    }
    
    public void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
    }
    
    public void onDestory() {}
  }
  
  public static class f
    implements CustomizeStrategyFactory.b
  {
    private PreloadManager a;
    private QQAppInterface app;
    
    public f(QQAppInterface paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
      if (this.app != null) {
        this.a = ((PreloadManager)this.app.getManager(151));
      }
    }
    
    public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc)
    {
      if ((paramRedPacketInfo != null) && ((paramxwc instanceof xwh))) {
        paramRedPacketInfo.animInfo = ((xwh)paramxwc).animInfo;
      }
    }
    
    public void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      if (paramRedPacketInfo == null) {
        return;
      }
      ThreadManager.post(new CustomizeStrategyFactory.ThemeAnimStrategy.1(this, paramRedPacketInfo), 5, null, true);
    }
    
    public void onDestory() {}
  }
  
  public static class g
    implements CustomizeStrategyFactory.b
  {
    private PreloadManager a;
    private QQAppInterface app;
    
    public g(QQAppInterface paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
      if (this.app != null) {
        this.a = ((PreloadManager)this.app.getManager(151));
      }
    }
    
    public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc)
    {
      if ((paramRedPacketInfo != null) && ((paramxwc instanceof xwh))) {
        paramRedPacketInfo.background = ((xwh)paramxwc).background;
      }
    }
    
    public void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      if (paramRedPacketInfo == null) {
        return;
      }
      ThreadManager.post(new CustomizeStrategyFactory.ThemeCustomizeStrategy.1(this, paramRedPacketInfo), 5, null, true);
    }
    
    public void onDestory() {}
  }
  
  public static class h
    implements CustomizeStrategyFactory.b
  {
    PreloadManager a = null;
    private QQAppInterface app;
    aaai b = null;
    
    h(QQAppInterface paramQQAppInterface)
    {
      this.app = paramQQAppInterface;
      if (this.app != null)
      {
        this.a = ((PreloadManager)this.app.getManager(151));
        this.b = ((aaai)this.app.getManager(245));
      }
    }
    
    public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, xwc paramxwc)
    {
      if ((paramRedPacketInfo != null) && ((paramxwc instanceof xwj)))
      {
        paramxwc = (xwj)paramxwc;
        paramRedPacketInfo.icon = paramxwc.el;
        paramRedPacketInfo.resPath = paramxwc.resPath;
      }
    }
    
    public void c(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
    {
      ThreadManager.post(new CustomizeStrategyFactory.VoiceResStrategy.1(this, paramRedPacketInfo), 5, null, true);
    }
    
    public void onDestory() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory
 * JD-Core Version:    0.7.0.1
 */