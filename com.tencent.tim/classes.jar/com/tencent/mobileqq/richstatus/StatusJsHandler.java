package com.tencent.mobileqq.richstatus;

import acja;
import aiim.b;
import amhh;
import amhi;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import kbp;
import kbs;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class StatusJsHandler
  extends aiim.b
{
  public AccountDetail a;
  private BusinessObserver a;
  private BusinessObserver b = new amhi(this);
  boolean cCD = false;
  boolean cCE = false;
  String cad;
  public String cae;
  public WeakReference<BaseActivity> mActivity;
  public String mFriendUin;
  private Handler mUiHandler;
  WeakReference<WebView> mWebView;
  
  public StatusJsHandler(BaseActivity paramBaseActivity, WebView paramWebView, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = null;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new amhh(this);
    this.mActivity = new WeakReference(paramBaseActivity);
    this.mWebView = new WeakReference(paramWebView);
    this.mFriendUin = paramString;
  }
  
  private void f(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "sendDetailInfoRequest");
    }
    NewIntent localNewIntent = new NewIntent(paramBaseActivity, kbs.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("3.4.4,3,3058");
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
      paramBaseActivity.app.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramBaseActivity)
    {
      hk(this.cae, "false");
    }
  }
  
  private void g(BaseActivity paramBaseActivity, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "follow");
    }
    NewIntent localNewIntent = new NewIntent(paramBaseActivity, kbs.class);
    localNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    try
    {
      localFollowRequest.uin.set((int)Long.parseLong(paramString));
      localFollowRequest.ext.set("0");
      localNewIntent.putExtra("data", localFollowRequest.toByteArray());
      localNewIntent.setObserver(this.b);
      paramBaseActivity.app.startServlet(localNewIntent);
      kbp.g(paramBaseActivity.app, paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, "follow exit");
      }
      return;
    }
    catch (Exception paramBaseActivity)
    {
      hk(this.cae, "false");
    }
  }
  
  public void Bm(int paramInt)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    QQToast.a(localBaseActivity, paramInt, 0).show(localBaseActivity.getTitleBarHeight());
  }
  
  public void a(BaseActivity paramBaseActivity, AccountDetail paramAccountDetail)
  {
    EntityManager localEntityManager = paramBaseActivity.app.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richstatus.", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        localEntityManager.drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.close();
      paramBaseActivity = (acja)paramBaseActivity.app.getManager(56);
      if (paramBaseActivity != null) {
        paramBaseActivity.f(paramAccountDetail);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      localEntityManager.persist(paramAccountDetail);
    }
  }
  
  public void followAccount(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity.get();
    if (localBaseActivity == null) {}
    while (this.cCD) {
      return;
    }
    this.cCD = true;
    this.cae = paramString2;
    paramString2 = localBaseActivity.app.a().createEntityManager();
    AccountDetail localAccountDetail = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
    paramString2.close();
    if (localAccountDetail != null)
    {
      g(localBaseActivity, paramString1);
      return;
    }
    f(localBaseActivity, paramString1);
  }
  
  public void getLocation(String paramString)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity.get();
    if (localBaseActivity == null) {}
    while (this.cCE) {
      return;
    }
    this.cCE = true;
    this.cad = paramString;
    ThreadManager.post(new StatusJsHandler.1(this, (LocationManager)localBaseActivity.getSystemService("location")), 5, null, false);
  }
  
  public boolean hasFollowAccount(String paramString)
  {
    Object localObject = (BaseActivity)this.mActivity.get();
    if (localObject == null) {
      return false;
    }
    localObject = (acja)((BaseActivity)localObject).app.getManager(56);
    return (localObject != null) && (((acja)localObject).b(paramString) != null);
  }
  
  public void hk(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity.get();
    WebView localWebView = (WebView)this.mWebView.get();
    if ((paramString1 == null) || (localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localWebView == null)) {
      return;
    }
    if (this.mUiHandler == null) {
      this.mUiHandler = new Handler(Looper.getMainLooper());
    }
    this.mUiHandler.post(new StatusJsHandler.2(this, paramString1, paramString2, localWebView));
  }
  
  public void setData(String paramString1, String paramString2)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.mActivity.get();
    if (localBaseActivity == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("k_data_text", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("k_data_id", Long.valueOf(paramString2));
    }
    localBaseActivity.setResult(-1, localIntent);
    localBaseActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusJsHandler
 * JD-Core Version:    0.7.0.1
 */