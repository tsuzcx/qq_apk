import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.1;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class aibe
{
  private static aibe a;
  private ConcurrentHashMap<String, jxc> fE = new ConcurrentHashMap();
  
  public static aibe a()
  {
    try
    {
      if (a == null) {
        a = new aibe();
      }
      aibe localaibe = a;
      return localaibe;
    }
    finally {}
  }
  
  private void b(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, jxc paramjxc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "jumpToImaxDisplayActivity item :" + paramString);
    }
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramjxc.hV());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", aalb.bwi);
    aalb.bwi = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new ImaxAdRecentUserManager.2(this, paramQQAppInterface, paramString, paramInt, paramjxc), 5, null, false);
    jxl.a().a(paramQQAppInterface, 2, paramjxc);
  }
  
  public void a(QQAppInterface paramQQAppInterface, aajg paramaajg, AbsListView paramAbsListView)
  {
    int i;
    if ((paramAbsListView != null) && (paramaajg != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label364;
      }
      i -= 1;
    }
    label355:
    label364:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      for (;;)
      {
        Object localObject1;
        if (j < k + 1)
        {
          localObject1 = paramaajg.getItem(j);
          if ((localObject1 == null) || (!(localObject1 instanceof RecentItemImaxADData))) {
            break label355;
          }
          localObject1 = (RecentItemImaxADData)localObject1;
          localObject2 = paramQQAppInterface.a().a(((RecentItemImaxADData)localObject1).mUser.uin, ((RecentItemImaxADData)localObject1).mUser.getType());
          if (localObject2 != null) {
            ((ConversationInfo)localObject2).isImax = true;
          }
          if (!aibg.isVisibleAreaSatisfied(paramAbsListView.getChildAt(j - i))) {
            break label355;
          }
          localObject3 = ((RecentItemImaxADData)localObject1).mUser.uin;
          localObject2 = b((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label244;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "isShowImaxAdItem item recreated " + (String)localObject3);
          }
          localObject1 = jxc.a(aibg.bf(paramQQAppInterface.getCurrentUin(), (String)localObject3));
          if (localObject1 != null) {
            break label238;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "isShowImaxAdItem item false " + (String)localObject3);
          }
        }
        return;
        label238:
        b((jxc)localObject1);
        label244:
        Object localObject2 = Message.obtain();
        Object localObject3 = new HashMap();
        ((HashMap)localObject3).put("key_app", new WeakReference(paramQQAppInterface));
        ((HashMap)localObject3).put("key_adapter", new WeakReference(paramaajg));
        ((HashMap)localObject3).put("key_listview", new WeakReference(paramAbsListView));
        ((Message)localObject2).obj = localObject3;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("key_ad_id", ((jxc)localObject1).Ux);
        ((Message)localObject2).setData((Bundle)localObject3);
        ((Message)localObject2).what = 2;
        aibd.a().V((Message)localObject2);
        j += 1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    jxc localjxc;
    if ((paramRecentUser != null) && (paramRecentUser.uin != null))
    {
      localjxc = b(paramRecentUser.uin);
      if ((localjxc != null) && (NetConnInfoCenter.getServerTimeMillis() >= localjxc.qV))
      {
        localObject = (ProxyManager)paramQQAppInterface.getManager(18);
        if (localObject != null) {
          break label136;
        }
      }
    }
    label136:
    for (Object localObject = null;; localObject = ((ProxyManager)localObject).a())
    {
      if (localObject != null)
      {
        aajt.a().Av(paramRecentUser.uin + "-" + paramRecentUser.getType());
        ((acxw)localObject).f(paramRecentUser);
        aalb.l(paramQQAppInterface, localjxc.mSenderUin, 10005);
        paramQQAppInterface.b().ca(localjxc.mSenderUin, 10005);
      }
      a(paramQQAppInterface, paramRecentUser, localjxc, false);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, jxc paramjxc, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImaxAdvertisement", 2, "dodelete ExpireItem uin:" + paramRecentUser.uin);
    }
    ThreadManager.executeOnFileThread(new ImaxAdRecentUserManager.1(this, paramBoolean, paramQQAppInterface, paramjxc, paramRecentUser));
    c(paramRecentUser.uin);
  }
  
  public boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      if (paramQQAppInterface != null) {
        break label55;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement result " + bool1);
      }
      return bool1;
      label55:
      if (TextUtils.isEmpty(paramString))
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ImaxAdvertisement", 2, "openImaxAdvertisement empty uin!");
          bool1 = bool2;
        }
      }
      else
      {
        jxc localjxc = b(paramString);
        if (localjxc == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImaxAdvertisement", 2, "openAdvertisement item recreated :" + paramString);
          }
          localjxc = jxc.a(aibg.bf(paramQQAppInterface.getCurrentUin(), paramString));
          bool1 = bool2;
          if (localjxc != null)
          {
            b(localjxc);
            b(paramContext, paramQQAppInterface, paramString, paramInt, localjxc);
            bool1 = true;
          }
        }
        else
        {
          b(paramContext, paramQQAppInterface, paramString, paramInt, localjxc);
          bool1 = true;
        }
      }
    }
  }
  
  public void aAV()
  {
    if (this.fE.values() != null)
    {
      Iterator localIterator = this.fE.values().iterator();
      while (localIterator.hasNext()) {
        ((jxc)localIterator.next()).hasReport = false;
      }
    }
  }
  
  public jxc b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (jxc)this.fE.get(paramString);
    }
    return null;
  }
  
  public void b(jxc paramjxc)
  {
    this.fE.put(paramjxc.mSenderUin, paramjxc);
  }
  
  public jxc c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (jxc)this.fE.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibe
 * JD-Core Version:    0.7.0.1
 */