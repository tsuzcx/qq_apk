import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter.1;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter.2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.c2s.imax.IMaxService.ExposureMsg;
import tencent.im.c2s.imax.IMaxService.IgnoreADMsg;
import tencent.im.c2s.imax.IMaxService.ReqBody;
import tencent.im.c2s.imax.IMaxService.RspBody;

public class aibd
  implements Handler.Callback
{
  private static final aibd a = new aibd();
  private Handler mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public static aibd a()
  {
    return a;
  }
  
  private void cE(int paramInt, String paramString)
  {
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString;
    if (paramInt == 1)
    {
      str = paramString;
      if (paramString.contains("__OS__")) {
        str = paramString.replace("__OS__", "0");
      }
      paramString = str;
      if (str.contains("__IMEI__"))
      {
        localObject1 = aqgz.getIMEI();
        paramString = "";
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = arwv.encodeHexStr((String)localObject1);
        }
        paramString = str.replace("__IMEI__", paramString);
      }
      str = paramString;
      if (paramString.contains("__APP__")) {
        str = paramString.replace("__APP__", arwv.encodeHexStr("android_qq"));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "exporsure type :" + paramInt + "exporsure url :" + str.toString());
    }
    int i = -1;
    paramString = "";
    int j = i;
    boolean bool2 = bool4;
    int k = i;
    boolean bool3 = bool5;
    Object localObject1 = paramString;
    label672:
    HashMap localHashMap;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(str).openConnection();
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setRequestMethod("GET");
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setConnectTimeout(30000);
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setReadTimeout(30000);
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.setUseCaches(false);
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      localHttpURLConnection.connect();
      j = i;
      bool2 = bool4;
      k = i;
      bool3 = bool5;
      localObject1 = paramString;
      int m = localHttpURLConnection.getResponseCode();
      i = m;
      if (m == 200)
      {
        i = 0;
        bool1 = true;
      }
      j = i;
      bool2 = bool1;
      k = i;
      bool3 = bool1;
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        j = i;
        bool2 = bool1;
        k = i;
        bool3 = bool1;
        localObject1 = paramString;
        QLog.i("AdvertisementRecentUserManager", 1, "exporsure rspCode " + i + "， request thirdparty" + bool1);
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("mResult", i + "");
      ((HashMap)localObject1).put("mErrDesc", "");
      ((HashMap)localObject1).put("Url", str);
      if (paramInt == 1) {}
      for (paramString = "imaxExporsureSucessRate";; paramString = "imaxClickExporsureSucessRate")
      {
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, paramString, bool1, 0L, 0L, (HashMap)localObject1, "");
        return;
      }
      paramString = "imaxExporsureSucessRate";
    }
    catch (Throwable localThrowable)
    {
      if (localThrowable == null)
      {
        paramString = "e is null";
        k = j;
        bool3 = bool2;
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          k = j;
          bool3 = bool2;
          localObject1 = paramString;
          QLog.w("AdvertisementRecentUserManager", 2, paramString);
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("mResult", j + "");
        ((HashMap)localObject1).put("mErrDesc", paramString);
        ((HashMap)localObject1).put("Url", str);
        if (paramInt != 1) {
          break label672;
        }
      }
      for (paramString = "imaxExporsureSucessRate";; paramString = "imaxClickExporsureSucessRate")
      {
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, paramString, bool2, 0L, 0L, (HashMap)localObject1, "");
        return;
        k = j;
        bool3 = bool2;
        localObject1 = paramString;
        paramString = localThrowable.toString();
        break;
      }
    }
    finally
    {
      localHashMap = new HashMap();
      localHashMap.put("mResult", k + "");
      localHashMap.put("mErrDesc", localObject1);
      localHashMap.put("Url", str);
      if (paramInt != 1) {}
    }
    for (;;)
    {
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, paramString, bool3, 0L, 0L, localHashMap, "");
      throw localObject2;
      paramString = "imaxClickExporsureSucessRate";
    }
  }
  
  public void V(Message paramMessage)
  {
    paramMessage.setTarget(this.mHandler);
    this.mHandler.sendMessageDelayed(paramMessage, 1000L);
  }
  
  void a(QQAppInterface paramQQAppInterface, aajg paramaajg, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramaajg != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label137;
      }
      i -= 1;
    }
    label137:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      while (j < k + 1)
      {
        Object localObject = paramaajg.getItem(j);
        View localView = paramAbsListView.getChildAt(j - i);
        if ((localView != null) && (localObject != null) && ((localObject instanceof RecentItemImaxADData)))
        {
          localObject = (RecentItemImaxADData)localObject;
          localView.setTag(Integer.valueOf(j));
          b(paramQQAppInterface, ((RecentItemImaxADData)localObject).mUser.uin, ((RecentItemImaxADData)localObject).mUser.getType(), localView, paramString);
        }
        j += 1;
      }
      return;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    jxl localjxl = jxl.a();
    jxc localjxc = localjxl.b(paramString1);
    if ((localjxc != null) && (aibg.isVisibleAreaSatisfied(paramView)) && (paramString2.equals(localjxc.Ux)))
    {
      paramString2 = paramQQAppInterface.b();
      if (paramString2 != null)
      {
        paramString1 = paramString2.k(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new ImaxAdPresenter.1(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localjxc != null) && (localjxc.a != null))
            {
              anot.c(paramQQAppInterface, "dc00898", "", localjxc.a.UD, "0X8008F5D", "0X8008F5D", 0, 0, localjxc.a.hT, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), jxp.gP(), localjxc.a.mNickName);
              anot.c(paramQQAppInterface, "dc00898", "", localjxc.a.UD, "0X8008F5C", "0X8008F5C", 0, 0, localjxc.a.hT, "", jxp.gP(), localjxc.a.mNickName);
            }
          }
        }
      }
      if ((localjxc != null) && (!localjxc.hasReport))
      {
        localjxc.hasReport = true;
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementRecentUserManager", 2, "do exposure Report");
        }
        d(localjxc);
        localjxl.a(paramQQAppInterface, 1, localjxc);
        if ((localjxc != null) && (localjxc.a != null)) {
          anot.c(paramQQAppInterface, "dc00898", "", localjxc.a.UD, "0X8008F5F", "0X8008F5F", 0, 0, localjxc.a.hT, "", "", localjxc.a.mNickName);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, jxc paramjxc)
  {
    if (paramjxc != null) {
      anot.c(paramQQAppInterface, "dc00898", "", paramjxc.a.UD, "0X8009102", "0X8009102", 0, 0, paramjxc.a.hT, "", jxp.gP(), paramjxc.a.mNickName);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ImaxAdNetPresenter", 2, "do doDel Report fail");
  }
  
  public void a(jxc paramjxc, Activity paramActivity, AppInterface paramAppInterface)
  {
    boolean bool;
    if ((paramActivity == null) || (paramjxc == null)) {
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder().append("activity is null : ");
        if (paramActivity != null) {
          break label72;
        }
        bool = true;
        paramActivity = paramAppInterface.append(bool).append(", item is null : ");
        if (paramjxc != null) {
          break label78;
        }
        bool = true;
        label55:
        QLog.e("ImaxAdNetPresenter", 2, bool);
      }
    }
    label72:
    label78:
    label355:
    for (;;)
    {
      return;
      bool = false;
      break;
      bool = false;
      break label55;
      int i = 0;
      switch (paramjxc.a.jumpType)
      {
      }
      for (;;)
      {
        if ((i == 0) || (!(paramActivity instanceof PublicAccountAdvertisementActivity))) {
          break label355;
        }
        ((PublicAccountAdvertisementActivity)paramActivity).aAB();
        return;
        if ((paramActivity instanceof BaseActivity))
        {
          anot.a(null, "dc00898", "", paramjxc.a.UD, "0X80090FE", "0X80090FE", 0, 0, paramjxc.a.hT, "", jxp.gP(), paramjxc.a.mNickName);
          r((BaseActivity)paramActivity);
          i = 1;
          continue;
          anot.a(null, "dc00898", "", paramjxc.a.UD, "0X8009101", "0X8009101", 0, 0, paramjxc.a.hT, "", jxp.gP(), paramjxc.a.mNickName);
          anot.a(null, "dc00898", "", paramjxc.a.UD, "0X8009100", "0X8009100", 0, 0, paramjxc.a.hT, "", jxp.gP(), paramjxc.a.mNickName);
          if (paramAppInterface == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramjxc = new StringBuilder().append("app is null : ");
            if (paramAppInterface == null) {}
            for (bool = true;; bool = false)
            {
              QLog.e("ImaxAdNetPresenter", 2, bool);
              return;
            }
          }
          b(paramjxc, paramActivity, paramAppInterface);
          i = 1;
        }
      }
    }
  }
  
  public void a(jxc paramjxc, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramjxc == null) || (paramjxc.a == null)) {
      QLog.e("ImaxAdNetPresenter", 1, "doIMaxServiceRequest error " + paramjxc);
    }
    AppRuntime localAppRuntime;
    IMaxService.ReqBody localReqBody;
    long l;
    do
    {
      do
      {
        return;
        localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      } while (localAppRuntime == null);
      localReqBody = new IMaxService.ReqBody();
      localObject = paramjxc.a.hT;
      l = Long.parseLong(localAppRuntime.getAccount());
      if (paramInt2 == 2)
      {
        paramjxc = new IMaxService.IgnoreADMsg();
        paramjxc.uint64_uin.set(l);
        paramjxc.str_ad_id.set((String)localObject);
        localReqBody.msg_ignoreAD.set(paramjxc);
        localReqBody.int32_type.set(2);
        paramjxc = new NewIntent(BaseApplicationImpl.getApplication(), jnl.class);
        paramQQAppInterface = new aibd.a(paramInt1);
        paramQQAppInterface.mType = 2;
        paramjxc.putExtra("cmd", "iMaxServiceSvc.IgnoreADMsg");
        paramjxc.putExtra("data", localReqBody.toByteArray());
        paramjxc.putExtra("isResend", false);
        paramjxc.setObserver(paramQQAppInterface);
        localAppRuntime.startServlet(paramjxc);
        return;
      }
    } while (paramInt2 != 1);
    IMaxService.ExposureMsg localExposureMsg = new IMaxService.ExposureMsg();
    localExposureMsg.str_ad_id.set((String)localObject);
    localExposureMsg.uint64_uin.set(l);
    localExposureMsg.uint32_action_type.set(1);
    localReqBody.msg_exposure.set(localExposureMsg);
    localReqBody.int32_type.set(1);
    Object localObject = new NewIntent(BaseApplicationImpl.getApplication(), jnl.class);
    paramjxc = new aibd.a(paramjxc, paramQQAppInterface);
    paramjxc.mType = 2;
    ((NewIntent)localObject).putExtra("cmd", "iMaxServiceSvc.ExposureADMsg");
    ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
    ((NewIntent)localObject).putExtra("isResend", false);
    ((NewIntent)localObject).setObserver(paramjxc);
    localAppRuntime.startServlet((NewIntent)localObject);
  }
  
  void b(QQAppInterface paramQQAppInterface, aajg paramaajg, AbsListView paramAbsListView, String paramString)
  {
    int i;
    if ((paramAbsListView != null) && (paramaajg != null) && (paramQQAppInterface != null))
    {
      i = paramAbsListView.getFirstVisiblePosition();
      if (i <= 0) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      int k = paramAbsListView.getLastVisiblePosition();
      int j = i;
      while (j < k + 1)
      {
        Object localObject = paramaajg.getItem(j);
        if ((localObject != null) && ((localObject instanceof RecentItemPublicAccountADFolderData)))
        {
          localObject = (RecentItemPublicAccountADFolderData)localObject;
          View localView = paramAbsListView.getChildAt(j - i);
          if (aibg.isVisibleAreaSatisfied(localView)) {
            a(paramQQAppInterface, ((RecentItemPublicAccountADFolderData)localObject).mUser.uin, ((RecentItemPublicAccountADFolderData)localObject).mUser.getType(), localView, paramString);
          }
        }
        j += 1;
      }
      return;
    }
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, View paramView, String paramString2)
  {
    jxc localjxc2 = aibe.a().b(paramString1);
    jxc localjxc1 = localjxc2;
    if (localjxc2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item recreated " + paramString1);
      }
      localjxc1 = jxc.a(aibg.bf(paramQQAppInterface.getCurrentUin(), paramString1));
      if (localjxc1 == null) {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdNetPresenter", 2, "isShowImaxAdItem item false " + paramString1);
        }
      }
    }
    do
    {
      do
      {
        return;
        aibe.a().b(localjxc1);
      } while ((localjxc1 == null) || (!aibg.isVisibleAreaSatisfied(paramView)) || (!paramString2.equals(localjxc1.Ux)));
      paramString2 = paramQQAppInterface.b();
      if (paramString2 != null)
      {
        paramString1 = paramString2.k(paramString1, paramInt);
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          paramString1 = (MessageRecord)paramString1.get(paramString1.size() - 1);
          if ("false".equals(paramString1.getExtInfoFromExtStr("recent_list_advertisement_message_first_report")))
          {
            paramString1.saveExtInfoToExtStr("recent_list_advertisement_message_first_report", "true");
            ThreadManager.post(new ImaxAdPresenter.2(this, paramQQAppInterface, paramString1), 5, null, false);
            if ((localjxc1 != null) && (localjxc1.a != null)) {
              anot.c(paramQQAppInterface, "dc00898", "", localjxc1.a.UD, "0X8008F5D", "0X8008F5D", 0, 0, localjxc1.a.hT, String.valueOf(((Integer)paramView.getTag()).intValue() + 1), jxp.gP(), localjxc1.a.mNickName);
            }
          }
        }
      }
    } while ((localjxc1 == null) || (localjxc1.hasReport) || (localjxc1.a == null));
    if (localjxc1.yF())
    {
      a(localjxc1, paramQQAppInterface, -1, 1);
      aibg.aI(paramQQAppInterface.getCurrentUin(), localjxc1.mSenderUin, localjxc1.hV());
    }
    anot.c(paramQQAppInterface, "dc00898", "", localjxc1.a.UD, "0X8008F5F", "0X8008F5F", 0, 0, localjxc1.a.hT, "", "", localjxc1.a.mNickName);
  }
  
  public void b(jxc paramjxc, Activity paramActivity, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramjxc.a.UL)) && (paramjxc.a.aDX != -1)) {
      anku.a(paramAppInterface, paramActivity, "1", "1", "1", "1", "1", "1", paramjxc.a.UL, "" + paramjxc.a.aDX, "1", "1", "", "", "1", "1", "", "", "", "", "", "", "", null);
    }
  }
  
  public void d(jxc paramjxc)
  {
    if ((paramjxc == null) || (paramjxc.a == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.obj = paramjxc.a.UF;
    this.mHandler.sendMessage(localMessage);
  }
  
  public void e(jxc paramjxc)
  {
    if ((paramjxc == null) || (paramjxc.a == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = paramjxc.a.UM;
    this.mHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            localObject = paramMessage.getData();
          } while (localObject == null);
          localObject = ((Bundle)localObject).getString("key_ad_id");
          paramMessage = (HashMap)paramMessage.obj;
          b((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (aajg)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
          return true;
          localObject = paramMessage.getData();
        } while (localObject == null);
        Object localObject = ((Bundle)localObject).getString("key_ad_id");
        paramMessage = (HashMap)paramMessage.obj;
        a((QQAppInterface)((WeakReference)paramMessage.get("key_app")).get(), (aajg)((WeakReference)paramMessage.get("key_adapter")).get(), (AbsListView)((WeakReference)paramMessage.get("key_listview")).get(), (String)localObject);
        return true;
        paramMessage = (String)paramMessage.obj;
      } while (TextUtils.isEmpty(paramMessage));
      cE(1, paramMessage);
      return true;
      paramMessage = (String)paramMessage.obj;
    } while (TextUtils.isEmpty(paramMessage));
    cE(2, paramMessage);
    return true;
  }
  
  public void r(BaseActivity paramBaseActivity)
  {
    aakj.a(paramBaseActivity, 0L, 4096L, 1);
  }
  
  public class a
    extends jnm.a
  {
    jxc advertisementItem;
    int tag = 0;
    WeakReference<QQAppInterface> weakReference;
    
    public a(int paramInt)
    {
      this.tag = paramInt;
    }
    
    public a(jxc paramjxc, QQAppInterface paramQQAppInterface)
    {
      this.advertisementItem = paramjxc;
      this.weakReference = new WeakReference(paramQQAppInterface);
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      paramBundle = new IMaxService.RspBody();
      if (QLog.isColorLevel()) {
        QLog.i("ImaxAdNetPresenter", 2, "errorCode == " + paramInt);
      }
      if (paramInt == 0)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("ImaxAdNetPresenter", 2, "request service success");
          }
          paramBundle.mergeFrom(paramArrayOfByte);
          if ((!paramBundle.has()) || (paramBundle.int32_ret.get() != 0)) {
            return;
          }
          paramInt = paramBundle.int32_type.get();
          if ((paramInt == 2) && (this.tag == 3))
          {
            Toast.makeText(BaseApplication.getContext(), acfp.m(2131707391), 0).show();
            return;
          }
          if (paramInt != 1) {
            return;
          }
          if (paramBundle.int32_exposure_flag.get() != 1) {
            break label264;
          }
          paramArrayOfByte = (QQAppInterface)this.weakReference.get();
          if (paramArrayOfByte == null)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d("ImaxAdNetPresenter", 2, "request EXPOSURE succ ,but app == null");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return;
        }
        jxl.a().a(paramArrayOfByte, 1, this.advertisementItem);
        this.advertisementItem.hasReport = true;
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdNetPresenter", 2, "do exposure Report");
        }
        aibd.this.d(this.advertisementItem);
        anot.c(paramArrayOfByte, "dc00898", "", this.advertisementItem.a.UD, "0X8009129", "0X8009129", 0, 0, this.advertisementItem.a.hT, "", jxp.gP(), this.advertisementItem.a.mNickName);
        return;
        label264:
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdNetPresenter", 2, "exposure already limited");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("ImaxAdNetPresenter", 2, "request service fail");
        }
        if (this.tag == 3) {
          Toast.makeText(BaseApplication.getContext(), acfp.m(2131707390), 0).show();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibd
 * JD-Core Version:    0.7.0.1
 */