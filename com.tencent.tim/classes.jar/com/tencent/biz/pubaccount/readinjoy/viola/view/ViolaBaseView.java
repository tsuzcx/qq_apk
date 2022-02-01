package com.tencent.biz.pubaccount.readinjoy.viola.view;

import affn;
import affo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import aqda.a;
import aqhq;
import aqnm;
import aqux;
import arxh;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderContainer;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Random;
import jqc;
import kbp;
import kxm;
import kxm.b;
import lci;
import lcl;
import nbs;
import nbs.a;
import ntp;
import nub;
import nue;
import nug;
import nwl;
import nxb;
import nxc;
import nxe;
import nxf;
import nxg;
import nxi;
import nxj;
import nxk;
import nxl;
import nxm;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class ViolaBaseView
  extends RelativeLayout
  implements CommonSuspensionGestureLayout.a, IActivityState
{
  private static String TAG = "ViolaBaseView";
  private static int bcU;
  private static int bcV = 1;
  private aqda.a jdField_a_of_type_Aqda$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$b;
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c;
  private d jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$d;
  private e jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e;
  private kxm.b jdField_a_of_type_Kxm$b;
  private nue jdField_a_of_type_Nue;
  public String anN;
  private String aoC;
  private String aoD;
  private String aoE;
  private boolean avh;
  private boolean avi;
  private boolean avj;
  private boolean avk = true;
  private boolean avl;
  private boolean avm;
  private boolean avn = true;
  private boolean avo;
  private boolean avp;
  private boolean avq;
  private Fragment jdField_b_of_type_AndroidSupportV4AppFragment;
  private ViolaInstance jdField_b_of_type_ComTencentViolaCoreViolaInstance;
  private int bcT = 0;
  private double be;
  private int mSatus = 0;
  private int mUniqueId;
  private long yk;
  private long yl;
  private long ym;
  
  public ViolaBaseView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void aLD()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.12(this));
    }
    for (;;)
    {
      QLog.d(TAG, 2, "openViolaPage success!");
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e.aLD();
    }
  }
  
  private void aj(int paramInt, boolean paramBoolean)
  {
    if ((this.avo) || (!paramBoolean) || (this.avm)) {
      return;
    }
    this.avo = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e != null)
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.14(this, paramInt));
      }
    }
    else
    {
      if (paramInt != 100) {
        break label162;
      }
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
      this.jdField_a_of_type_Nue.reportData(this.anN);
      this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.anN);
    }
    for (;;)
    {
      QLog.e(TAG, 2, "openViolaPage error,code=" + paramInt + ",biz url=" + this.anN);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e.onError(paramInt);
      break;
      label162:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_Nue.bP(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.anN);
      }
      else if (paramInt == 5)
      {
        this.jdField_a_of_type_Nue.bP(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.anN);
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.anN);
      }
      else if (paramInt == 8)
      {
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.anN);
      }
      else if (paramInt == 6)
      {
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.anN);
      }
      else if (paramInt == 9)
      {
        this.jdField_a_of_type_Nue.bP(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.anN);
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_Nue.bP(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.anN);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_Nue.bP(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.anN);
      }
      else if (paramInt == 10)
      {
        this.jdField_a_of_type_Nue.bP(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_Nue.reportData(this.anN);
        this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.anN);
      }
    }
  }
  
  private void am(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.aoC = paramString;
      if (paramBoolean)
      {
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.ym));
        bbV();
      }
      ThreadManager.post(new ViolaBaseView.18(this), 8, null, true);
      return;
    }
    aj(3, paramBoolean);
  }
  
  private void b(String paramString, a parama)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http"))) {}
    String str;
    do
    {
      return;
      str = Uri.parse(paramString).getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(str));
    ntp.a(str, new nxk(this, str, paramString, parama));
  }
  
  private void bbQ()
  {
    this.avn = true;
    this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.aoC = ntp.fc(this.anN);
    if (!TextUtils.isEmpty(this.aoC))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadJSSource process from v_bid url: " + this.anN);
      }
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
      bbV();
      return;
    }
    this.avn = false;
    if (this.anN.contains("v_debug_test=1"))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadJSSource process from cgi debugVersion url: " + this.anN);
      }
      qm(true);
      return;
    }
    Object localObject = aqhq.o("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.anN) + "_" + kxm.getAccount());
    if ((localObject instanceof String))
    {
      this.aoC = ((String)localObject);
      if (!TextUtils.isEmpty(this.aoC))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "loadJSSource process from cgi cache url: " + this.anN);
        }
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
        bbV();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadJSSource process from cgi no cache url: " + this.anN);
      }
      qm(true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "loadJSSource process from cgi no cache1 url: " + this.anN);
    }
    qm(true);
  }
  
  private void bbR()
  {
    this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.aoE = ntp.fc("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.aoE))
    {
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$b.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = aqhq.o("viola_cache_file_viola_qq_page_data_new_main_js_" + kxm.getAccount());
    if ((localObject instanceof String))
    {
      this.aoE = ((String)localObject);
      if (!TextUtils.isEmpty(this.aoE))
      {
        this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$b.sendEmptyMessageDelayed(3, 0L);
        return;
      }
      qn(true);
      return;
    }
    qn(true);
  }
  
  private void bbS()
  {
    ThreadManager.post(new ViolaBaseView.6(this), 8, null, true);
  }
  
  private void bbT()
  {
    String str1 = Uri.parse("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559").getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = nwl.aB("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      oG(str2);
    }
    for (;;)
    {
      ntp.a(str1, new nxl(this));
      return;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "downLoadSOFromOffline so.zip not exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559],try load from cdn");
      }
      bbS();
    }
  }
  
  private void bbU()
  {
    WeakReference localWeakReference2 = null;
    if (this.mSatus >= 2) {
      return;
    }
    if ((this.avq) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c.oH(this.aoC);
      return;
    }
    ViolaRenderContainer localViolaRenderContainer = new ViolaRenderContainer(getContext());
    addView(localViolaRenderContainer);
    addOnLayoutChangeListener(new nxm(this));
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new nub());
        if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.jdField_b_of_type_AndroidSupportV4AppFragment == null) {
            break label329;
          }
          WeakReference localWeakReference1 = new WeakReference(this.jdField_b_of_type_AndroidSupportV4AppFragment.getActivity());
          if (this.jdField_b_of_type_AndroidSupportV4AppFragment != null) {
            localWeakReference2 = new WeakReference(this.jdField_b_of_type_AndroidSupportV4AppFragment);
          }
          this.jdField_b_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(localBaseApplicationImpl, localWeakReference1, localWeakReference2, null, -1L, this.anN);
        }
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.setRenderContainer(localViolaRenderContainer);
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.setViolaPageListener(new nxc(this));
        if ((TextUtils.isEmpty(this.anN)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$d == null)) {
          break;
        }
        this.mSatus = 2;
        bbX();
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.renderJSSource(this.aoC, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$d.toJSONString(), nwl.fg(this.anN));
        aLD();
        qg(true);
        if (this.avi) {
          this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityResume();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(TAG, 2, "renderJS: " + this.aoC);
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(TAG, 1, "initViola Exception " + localException.getMessage());
      return;
      label329:
      Object localObject = null;
    }
  }
  
  private void bbV()
  {
    if ((!TextUtils.isEmpty(this.aoC)) && (this.avh)) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.11(this));
      }
    }
    do
    {
      return;
      bbU();
      return;
      if (TextUtils.isEmpty(this.aoC))
      {
        onProcess(2);
        return;
      }
    } while (this.avh);
    onProcess(3);
    initSDK();
  }
  
  private void bbW()
  {
    ntp.bcI += 1;
    this.avo = false;
    this.jdField_a_of_type_Nue.aB(this.mUniqueId, this.anN);
  }
  
  private void bbX()
  {
    this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.mPageStartTime = this.yl;
  }
  
  private void checkOfflineUpNotCallback(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (kxm.getAppRuntime() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "checkOfflineUpNotCallback.");
    }
    ThreadManager.post(new ViolaBaseView.8(this, paramString), 8, null, true);
  }
  
  private void init(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$b = new b(Looper.getMainLooper());
    this.mUniqueId = Math.abs(new Random().nextInt());
  }
  
  private void initSDK()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.avh = true;
      onProcess(1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c.bcc();
      }
      this.avh = true;
      bbV();
      return;
    }
    if (TextUtils.isEmpty(this.aoE))
    {
      onProcess(0);
      bbR();
      return;
    }
    ThreadManager.post(new ViolaBaseView.2(this, (QQAppInterface)kxm.getAppRuntime()), 8, null, true);
  }
  
  private void oG(String paramString)
  {
    if (!lcl.dJ(paramString))
    {
      onError(7);
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    do
    {
      return;
      if ((affo.ajd()) && (affn.ajd()))
      {
        up(bcV);
        return;
      }
      onError(8);
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "downLoadSOFromOffline so.zip succ but not Exist");
  }
  
  private void onError(int paramInt)
  {
    aj(paramInt, true);
  }
  
  private void onProcess(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e != null)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        break label67;
      }
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.13(this, paramInt));
    }
    for (;;)
    {
      QLog.d(TAG, 2, "openViolaPage process,code=" + paramInt);
      return;
      label67:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e.onProcess(paramInt);
    }
  }
  
  private void qm(boolean paramBoolean)
  {
    this.ym = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
    }
    if ((this.anN.contains("v_tid")) && (this.anN.contains("v_bundleName")))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "loadJSSource process from judgeIfNeedCgi v_tid url: " + this.anN);
      }
      qo(paramBoolean);
      return;
    }
    this.aoD = this.anN;
    qp(paramBoolean);
    qq(paramBoolean);
  }
  
  private void qn(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    ntp.a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547" + nwl.kP(), new nxi(this, paramBoolean, l));
    b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new nxj(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void qo(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    new arxh("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=" + URLEncoder.encode(new StringBuilder().append(this.anN).append("&v_sdk=").append("3.4.4").append("&v_appid=1&v_uid=").append(kxm.getAccount()).append("&v_platform=1").toString()), "GET", new nxe(this, paramBoolean)).dL(localBundle);
  }
  
  private void qp(boolean paramBoolean)
  {
    ntp.a(this.aoD, new nxf(this, paramBoolean));
  }
  
  private void qq(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    b(this.anN, new nxg(this, paramBoolean, l));
  }
  
  private void qr(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c.bce();
    }
    aj(9, paramBoolean);
  }
  
  private void up(int paramInt)
  {
    if (paramInt == bcU)
    {
      this.jdField_a_of_type_Nue.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.yk = System.currentTimeMillis();
    }
    lci.a(TAG + "_" + Integer.toString(paramInt), new nxb(this, paramInt));
  }
  
  public boolean FJ()
  {
    return Gm();
  }
  
  public boolean Gi()
  {
    return (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) && (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.consumeBackKeyEvent());
  }
  
  public boolean Gm()
  {
    return this.mSatus >= 3;
  }
  
  public void a(String paramString, Fragment paramFragment, d paramd)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("VideoFeeds.js"))) {
      kbp.a(null, null, "0X800AF0D", "0X800AF0D", 0, 0, null, null, null, "" + System.currentTimeMillis(), false);
    }
    this.jdField_b_of_type_AndroidSupportV4AppFragment = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof nue)) {
      this.jdField_a_of_type_Nue = ((nue)ViolaSDKManager.getInstance().getReportDelegate());
    }
    for (;;)
    {
      this.anN = paramString;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$d = paramd;
      this.jdField_a_of_type_Kxm$b = new kxm.b().b("url", this.anN);
      this.avk = Build.CPU_ABI.contains("arm");
      bbW();
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      onError(4);
      return;
      this.jdField_a_of_type_Nue = new nue();
      ViolaSDKManager.getInstance().setReportDelegate(this.jdField_a_of_type_Nue);
    }
    if (!this.avk)
    {
      onError(11);
      return;
    }
    up(bcU);
  }
  
  public void b(e parame)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e = parame;
    this.yl = System.currentTimeMillis();
    bbW();
    if (!this.avk)
    {
      onError(11);
      return;
    }
    up(bcU);
  }
  
  public void bbY()
  {
    if (!this.avp)
    {
      this.avp = true;
      this.jdField_a_of_type_Nue.bbw();
    }
  }
  
  public void bbZ()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.updateCurrentPageInstance();
    }
  }
  
  public void bca()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.clearCurrentPageInstance();
    }
  }
  
  public void bcb()
  {
    ThreadManager.post(new ViolaBaseView.19(this), 8, null, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityBack();
    }
  }
  
  public boolean isCreated()
  {
    return this.mSatus >= 2;
  }
  
  public boolean onActivityBack()
  {
    return false;
  }
  
  public void onActivityCreate()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityCreate();
    }
  }
  
  public void onActivityDestroy()
  {
    this.avm = true;
    if ((!this.avo) && (this.mSatus == 2) && (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) && (!this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.isReceiveOrder()) && (System.currentTimeMillis() - this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime >= 3000L)) {
      this.jdField_a_of_type_Nue.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.anN);
    }
    this.jdField_a_of_type_Nue.bbw();
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityDestroy();
    }
    if (!TextUtils.isEmpty(this.anN))
    {
      checkOfflineUpNotCallback(this.anN.replace("v_bid", "_bid"));
      bcb();
    }
  }
  
  public void onActivityPause()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityPause();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18)
    {
      Object localObject = this.jdField_b_of_type_AndroidSupportV4AppFragment.getActivity();
      if ((paramInt2 == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = wja.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((kxm.getAppRuntime() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)kxm.getAppRuntime(), this.jdField_b_of_type_AndroidSupportV4AppFragment.getActivity(), this.jdField_b_of_type_AndroidSupportV4AppFragment.getActivity(), (Intent)localObject, null);
        }
      }
    }
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityResume();
    }
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance == null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(BaseApplicationImpl.getApplication(), new WeakReference(this.jdField_b_of_type_AndroidSupportV4AppFragment.getActivity()), new WeakReference(this.jdField_b_of_type_AndroidSupportV4AppFragment), null, -1L, this.anN);
    }
    this.avi = true;
  }
  
  public void onActivityStart()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    if (this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.onActivityStop();
    }
  }
  
  public int qI()
  {
    if ((Gm()) && (this.avl)) {
      return this.bcT;
    }
    return 1;
  }
  
  public void qg(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.isDestroy()))
    {
      if (!paramBoolean) {
        break label65;
      }
      if (!this.avj)
      {
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.updateInstance(nwl.N().toString());
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(true);
        this.avj = true;
        bbZ();
      }
    }
    label65:
    do
    {
      return;
      if (this.avj)
      {
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.updateInstance(nwl.O().toString());
        this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(false);
        this.avj = false;
        bca();
      }
    } while (!(ViolaSDKManager.getInstance().getComponentAdapter() instanceof nug));
    ((nug)ViolaSDKManager.getInstance().getComponentAdapter()).onActivityDestroy();
  }
  
  public void setBaseViewListener(c paramc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$c = paramc;
    this.avq = true;
  }
  
  public void setListener(e parame)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView$e = parame;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.yl = paramLong;
  }
  
  public void updateInstance(String paramString)
  {
    if ((this.jdField_b_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.isDestroy())) {
      this.jdField_b_of_type_ComTencentViolaCoreViolaInstance.updateInstance(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bbs();
    
    public abstract void oD(String paramString);
  }
  
  public class b
    extends Handler
  {
    public b(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      case 1: 
      default: 
        return;
      case 0: 
        ViolaBaseView.d(ViolaBaseView.this);
        return;
      case 3: 
        ViolaBaseView.a(ViolaBaseView.this);
        return;
      }
      ViolaBaseView.a(ViolaBaseView.this, true);
      ViolaBaseView.d(ViolaBaseView.this);
    }
  }
  
  public static abstract interface c
  {
    public abstract void bcc();
    
    public abstract void bcd();
    
    public abstract void bce();
    
    public abstract void oH(String paramString);
  }
  
  public static class d
  {
    private JSONObject aJ;
    private String aoF;
    private String aoG = "120";
    private int bcW;
    private int bcX;
    private int bcY = 1;
    private int bcZ;
    private String mChannelId = "0";
    private String mUin;
    private String mUrl;
    
    public d(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2)
    {
      this.mUrl = paramString1;
      this.aJ = paramJSONObject;
      this.aoF = paramString2;
      if ((!TextUtils.isEmpty(this.mUrl)) && ((this.mUrl.contains("v_present=1")) || (this.mUrl.contains("v_present=2")))) {
        this.bcW = 1;
      }
      if ((!TextUtils.isEmpty(this.mUrl)) && (this.mUrl.contains("v_present_auto_top=0"))) {
        this.bcY = 0;
      }
      if ((!TextUtils.isEmpty(this.mUrl)) && (this.mUrl.contains("v_present_top"))) {
        this.aoG = Uri.parse(this.mUrl).getQueryParameter("v_present_top");
      }
      if ((!TextUtils.isEmpty(this.mUrl)) && (this.mUrl.contains("channelId"))) {
        this.mChannelId = Uri.parse(this.mUrl).getQueryParameter("channelId");
      }
      paramString1 = (QQAppInterface)kxm.getAppRuntime();
      if (paramString1 != null) {
        this.mUin = paramString1.getAccount();
      }
      this.bcZ = aqnm.PxToDp(CommonSuspensionGestureLayout.getNavigationBarHeight(BaseActivity.sTopActivity));
    }
    
    public d(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, int paramInt)
    {
      this(paramString1, paramJSONObject, paramString2);
      this.bcX = paramInt;
    }
    
    private int getOrientation()
    {
      Object localObject = BaseApplicationImpl.getApplication().getResources();
      if (localObject == null) {}
      do
      {
        return 1;
        localObject = ((Resources)localObject).getConfiguration();
      } while (localObject == null);
      return ((Configuration)localObject).orientation;
    }
    
    public JSONObject toJSON()
    {
      int j = 0;
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("url", this.mUrl);
        localJSONObject.put("param", this.aJ);
        localJSONObject.put("cache", this.aoF);
        localJSONObject.put("uin", this.mUin);
        localJSONObject.put("isPresent", this.bcW);
        localJSONObject.put("isChannel", this.bcX);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
        {
          i = 1;
          localJSONObject.put("isNightMode", i);
          localJSONObject.put("isAutoTop", this.bcY);
          localJSONObject.put("presentMarginTop", this.aoG);
          localJSONObject.put("nowNavBarHeight", this.bcZ);
          localJSONObject.put("orientation", getOrientation());
          localJSONObject.put("screenWidth", FlexConvertUtils.getScreenWidth(BaseApplicationImpl.getApplication()));
          localJSONObject.put("screenHeight", FlexConvertUtils.getScreenHeight(BaseApplicationImpl.getApplication()));
          if (aqux.Mv() != 1) {
            break label236;
          }
        }
        label236:
        for (int i = 1;; i = 0)
        {
          localJSONObject.put("isKindCard", i);
          localJSONObject.put("channel_id", this.mChannelId);
          i = j;
          if (nbs.a.Fg()) {
            i = 1;
          }
          localJSONObject.put("supportRate", i);
          localJSONObject.put("netType", jqc.getNetWorkType());
          return localJSONObject;
          i = 0;
          break;
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        QLog.e(ViolaBaseView.access$700(), 1, "ViolaCreactPageObject toJSON error = " + localJSONException.getMessage());
      }
    }
    
    public String toJSONString()
    {
      return toJSON().toString();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViolaCreactPageObject : url:");
      if (TextUtils.isEmpty(this.mUrl))
      {
        str = "null";
        localStringBuilder.append(str);
        localStringBuilder.append("; ");
        if (this.aJ != null) {
          break label107;
        }
        str = "null";
        label55:
        localStringBuilder.append(str);
        localStringBuilder.append("; ");
        if (this.aoF != null) {
          break label118;
        }
      }
      label107:
      label118:
      for (String str = "null";; str = this.aoF.toString())
      {
        localStringBuilder.append(str);
        localStringBuilder.append("; ");
        return localStringBuilder.toString();
        str = this.mUrl;
        break;
        str = this.aJ.toString();
        break label55;
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
    
    public abstract void aF(String paramString, int paramInt);
    
    public abstract void aLD();
    
    public abstract void onError(int paramInt);
    
    public abstract void onProcess(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */