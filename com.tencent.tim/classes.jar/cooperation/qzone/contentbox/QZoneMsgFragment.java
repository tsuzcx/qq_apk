package cooperation.qzone.contentbox;

import acfp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqhv;
import aqik;
import aqmr;
import arxa;
import avpw;
import avsm;
import avsn;
import avtk;
import avtk.a;
import avtl;
import avtm;
import avtn;
import avto;
import avtp;
import avtr;
import avts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

public class QZoneMsgFragment
  extends ReportV4Fragment
  implements Handler.Callback, avtk.a
{
  private avsm jdField_a_of_type_Avsm;
  public avtk a;
  avts jdField_a_of_type_Avts = new avtn(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  a jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$a;
  private LocalPhotoGroupData jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData;
  public volatile QQAppInterface app;
  private FootNavigationLayout b;
  BroadcastReceiver bW = new avtl(this);
  private int dXO = 0;
  private boolean doM;
  private boolean doN;
  private volatile boolean doO;
  private boolean doP;
  protected int footerPreState = 5;
  private final AbsListView.e h = new avtm(this);
  private Handler handler;
  private volatile boolean hasMore = true;
  private boolean isNightMode;
  
  private void WN(boolean paramBoolean) {}
  
  private void WO(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.doP)) {
      arxa.a().showToast(acfp.m(2131713197));
    }
    WQ(paramBoolean);
    this.dXO = 0;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "loadMoreFinish ，requestState=" + this.dXO);
    }
  }
  
  private void WP(boolean paramBoolean) {}
  
  private void WQ(boolean paramBoolean) {}
  
  private void WR(boolean paramBoolean)
  {
    WP(paramBoolean);
    this.dXO = 0;
    if (this.jdField_a_of_type_Avtk.getCount() > 0)
    {
      MQMsg localMQMsg = (MQMsg)this.jdField_a_of_type_Avtk.getItem(0);
      if (localMQMsg == null) {
        break label113;
      }
      aam(localMQMsg.promot);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText ，mqMsg.promot=" + localMQMsg.promot);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "refreshFinish ，requestState=" + this.dXO);
      }
      return;
      label113:
      if (QLog.isColorLevel()) {
        QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "updatePromptText mqMsg ==null");
      }
    }
  }
  
  private MQMsg a()
  {
    if (this.jdField_a_of_type_Avtk == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "getLastMQMsg failed: adapter == null");
      return null;
    }
    return this.jdField_a_of_type_Avtk.a();
  }
  
  private void a(QZoneMsgEntityNew paramQZoneMsgEntityNew)
  {
    if (paramQZoneMsgEntityNew == null)
    {
      paramQZoneMsgEntityNew = new ArrayList();
      paramQZoneMsgEntityNew.add(new avtr(acfp.m(2131720732), "mqqzone://arouse/activefeed"));
      paramQZoneMsgEntityNew.add(new avtr(acfp.m(2131713193), "mqqzone://arouse/albumlist"));
    }
    for (;;)
    {
      if (this.handler != null) {
        this.handler.post(new QZoneMsgFragment.6(this, paramQZoneMsgEntityNew));
      }
      return;
      paramQZoneMsgEntityNew = paramQZoneMsgEntityNew.bottomItems;
    }
  }
  
  private void aIH()
  {
    ThreadManagerV2.excute(new QZoneMsgFragment.3(this), 32, null, true);
  }
  
  private boolean aLF()
  {
    if (this.jdField_a_of_type_Avtk == null)
    {
      QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "removeLastEmptyMQMsg failed: adapter == null");
      return false;
    }
    return this.jdField_a_of_type_Avtk.aLF();
  }
  
  private void aam(String paramString)
  {
    ThreadManager.postImmediately(new QZoneMsgFragment.4(this, paramString), null, false);
  }
  
  private void eBS()
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    int k;
    do
    {
      return;
      k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    } while (k <= 0);
    int j = 0;
    int i = 0;
    label24:
    Object localObject;
    if (j < k)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(j);
      if ((localObject instanceof MsgCardView)) {
        break label54;
      }
    }
    for (;;)
    {
      j += 1;
      break label24;
      break;
      label54:
      localObject = (MsgCardView)localObject;
      if ((i == 0) && ((((MsgCardView)localObject).aLE()) || (this.doN)))
      {
        ((MsgCardView)localObject).startPlay();
        i = 1;
      }
      else
      {
        ((MsgCardView)localObject).stopPlay();
      }
    }
  }
  
  private void eBT()
  {
    if (this.jdField_a_of_type_Avsm != null)
    {
      this.jdField_a_of_type_Avsm.onDestroy();
      this.jdField_a_of_type_Avsm = null;
      if (this.jdField_a_of_type_Avtk != null) {
        this.jdField_a_of_type_Avtk.a(null, this.doM, this.doN);
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    } while (j <= 0);
    int i = 0;
    label66:
    View localView;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
      if ((localView instanceof MsgCardView)) {
        break label94;
      }
    }
    for (;;)
    {
      i += 1;
      break label66;
      break;
      label94:
      ((MsgCardView)localView).recycle();
    }
  }
  
  private void eBU()
  {
    if ((this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData == null) || (this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.pathList == null) || (this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.pathList.isEmpty()))
    {
      boolean bool = aLF();
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: removeLastEmptyMQMsg:" + bool + ", mLocalPhotoGroupData == null || mLocalPhotoGroupData.pathList == null || mLocalPhotoGroupData.pathList.isEmpty()");
    }
    MQMsg localMQMsg;
    do
    {
      do
      {
        return;
        localMQMsg = a();
        if (localMQMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg == null");
      return;
      if (QLog.isColorLevel())
      {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: getLastMQMsg{\nmsgType='" + localMQMsg.msgType + '\'' + '\n' + ", title=" + localMQMsg.title + '\'' + '\n' + ", eventTitle='" + localMQMsg.eventTitle + '\'' + '\n' + ", uniKey='" + localMQMsg.uniKey + '\'' + '\n' + '}');
        if ((localMQMsg.msgBody != null) && (localMQMsg.msgBody.photolist != null)) {
          localObject1 = localMQMsg.msgBody.photolist.iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MQPhotoCell)((Iterator)localObject1).next();
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: cell.coverUrl=" + ((MQPhotoCell)localObject2).coverUrl);
          continue;
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "updateMQMsg: mqMsg.msgBody.photolist==null");
        }
      }
    } while (((localMQMsg.msgBody.photolist != null) && (!localMQMsg.msgBody.photolist.isEmpty()) && (!aqmr.isEmpty(((MQPhotoCell)localMQMsg.msgBody.photolist.get(0)).coverUrl))) || (localMQMsg.msgType != 9));
    localMQMsg.uniKey = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.unikey;
    localMQMsg.eventTitle = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.title;
    localMQMsg.capTime = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.capTime;
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData.pathList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      MQPhotoCell localMQPhotoCell = new MQPhotoCell();
      localMQPhotoCell.coverUrl = str;
      ((ArrayList)localObject1).add(localMQPhotoCell);
    }
    localMQMsg.msgBody.photolist = ((ArrayList)localObject1);
    this.handler.post(new QZoneMsgFragment.8(this, localMQMsg));
    QLog.d("QZoneMsgManager.QZoneMsgFragment", 2, "setLocalPhotoGroupData: update last empty MQMsg.");
  }
  
  private void initEmptyView(View paramView) {}
  
  private void refresh()
  {
    this.dXO = 2;
    ((avto)this.app.getManager(293)).eBW();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "refresh ，requestState=" + this.dXO);
    }
  }
  
  public avsm a()
  {
    return this.jdField_a_of_type_Avsm;
  }
  
  public void a(LocalPhotoGroupData paramLocalPhotoGroupData)
  {
    this.jdField_a_of_type_CooperationQzoneProviderLocalPhotoGroupData = paramLocalPhotoGroupData;
    eBU();
  }
  
  public void aan(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    localIntent.setPackage("com.tencent.mobileqq");
    getActivity().getApplicationContext().startActivity(localIntent);
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt >= this.jdField_a_of_type_Avtk.getCount() - 1) && (this.jdField_a_of_type_Avtk.getCount() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onGetView loadMore");
      }
      WN(false);
    }
  }
  
  public void b(MQMsg paramMQMsg)
  {
    Object localObject;
    if ((paramMQMsg != null) && (!TextUtils.isEmpty(paramMQMsg.jumpUrlToDetail)))
    {
      localObject = aqik.c(this.app, getActivity(), paramMQMsg.jumpUrlToDetail);
      if (localObject != null)
      {
        ((aqhv)localObject).ace();
        return;
      }
      localObject = new Intent(getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMQMsg.jumpUrlToDetail);
      avpw.ay((Intent)localObject);
      startActivity((Intent)localObject);
      return;
    }
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "msg.jumpUrlToDetail is null");
    if ((paramMQMsg != null) && (paramMQMsg.msgType == 9) && (!aqmr.isEmpty(paramMQMsg.uniKey)))
    {
      localObject = "mqqzone://arouse/photogrouprecommenddetail?usecache=true&checkgroup=false&unikey=" + paramMQMsg.uniKey;
      aan((String)localObject);
      LpReportInfo_dc02880.report(2, 2, (String)localObject, "29", false, true);
      LpReportInfo_pf00064.allReport(133, 14, String.valueOf(paramMQMsg.msgType));
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "jumpToPhotoGroupRecommendDetail: uniKey=" + paramMQMsg.uniKey);
      return;
    }
    QLog.e("QZoneMsgManager.QZoneMsgFragment", 1, "msg == null | msg.msgType != ENUM_PUSH_MSG_TYPE._ENUM_TRAVEL_ALBUM | StringUtil.isEmpty(msg.uniKey)");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      aIH();
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "EVENT_LOAD_MORE_MANUAL loadMore");
      }
      WN(true);
      continue;
      this.jdField_a_of_type_Avtk.notifyDataSetChanged();
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    ThreadManagerV2.excute(new QZoneMsgFragment.5(this, (avto)this.app.getManager(293)), 32, null, true);
    refresh();
    this.handler.sendEmptyMessage(1001);
    QZoneLoginReportHelper.reportLoginFromQZoneMsgBox();
    paramBundle = new LpReportInfo_dc02880(7, 1);
    LpReportManager.getInstance().reportToDC02880(paramBundle, false, true);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "fragment onAttach  ");
    }
    this.app = ((BaseActivity)paramActivity).app;
    this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$a = new a();
    this.app.registObserver(this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$a);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.qzone.sync_comment_like");
    getActivity().registerReceiver(this.bW, (IntentFilter)localObject);
    this.handler = new Handler(Looper.getMainLooper(), this);
    this.doN = avsn.e(paramActivity, this.app);
    if (avsn.aLy()) {
      if (QzonePluginProxyActivity.a() == null)
      {
        QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneMsgFragment.1(this, paramActivity));
        this.doM = false;
      }
    }
    for (;;)
    {
      if (this.doM)
      {
        localObject = avsn.g();
        if (this.app != localObject) {
          avsn.g(paramActivity, this.app);
        }
      }
      return;
      this.doM = this.doN;
      continue;
      this.doM = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.isNightMode = ThemeUtil.isNowThemeIsNightForQzone();
    if (this.isNightMode) {
      paramViewGroup.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(2131562594, paramViewGroup, false);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramViewGroup.setBackgroundColor(-1380874);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "fragment onDetach  ");
    }
    eBT();
    if (this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$a != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_CooperationQzoneContentboxQZoneMsgFragment$a);
    }
    getActivity().unregisterReceiver(this.bW);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Avsm != null) {
      this.jdField_a_of_type_Avsm.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Avsm != null) {
      this.jdField_a_of_type_Avsm.onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramView.findViewById(2131372015));
    paramBundle = paramView.findViewById(2131376017);
    this.jdField_a_of_type_ComTencentWidgetListView.setEmptyView(paramBundle);
    paramBundle = getActivity();
    if ((this.doM) && (paramBundle != null))
    {
      this.jdField_a_of_type_Avsm = avsn.a(paramBundle);
      if (this.jdField_a_of_type_Avsm != null) {
        this.jdField_a_of_type_Avsm.setHandler(this.handler);
      }
      this.jdField_a_of_type_Avtk = new avtk(getActivity());
      this.jdField_a_of_type_Avtk.setNightMode(this.isNightMode);
      this.jdField_a_of_type_Avtk.a(this.jdField_a_of_type_Avsm, this.doM, this.doN);
      this.jdField_a_of_type_Avtk.a(this);
      this.jdField_a_of_type_Avtk.setMsgOnClickListener(this.jdField_a_of_type_Avts);
      this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this.h);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Avtk);
      this.b = ((FootNavigationLayout)paramView.findViewById(2131372009));
      paramBundle = this.b;
      if (!this.doN) {
        break label249;
      }
    }
    label249:
    for (int i = 0;; i = 8)
    {
      paramBundle.setArrowVisible(i);
      if (this.isNightMode) {
        this.b.setNightMode(true);
      }
      a(null);
      initEmptyView(paramView);
      return;
      if (this.jdField_a_of_type_Avsm == null) {
        break;
      }
      this.jdField_a_of_type_Avsm.onDestroy();
      this.jdField_a_of_type_Avsm = null;
      break;
    }
  }
  
  class a
    extends avtp
  {
    a() {}
    
    public void ac(boolean paramBoolean, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg");
      }
      super.ac(paramBoolean, paramBundle);
      if (!paramBoolean)
      {
        QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onLoadMoreMsg error");
        QZoneMsgFragment.a(QZoneMsgFragment.this, paramBoolean);
        return;
      }
      paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
      if (paramBundle != null)
      {
        QZoneMsgFragment.this.a.ft(paramBundle.ArkNes_vec);
        QZoneMsgFragment.a(QZoneMsgFragment.this);
        QZoneMsgFragment.a(QZoneMsgFragment.this, paramBundle.hasmore);
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg ，hasMore=" + QZoneMsgFragment.c(QZoneMsgFragment.this));
      }
      for (;;)
      {
        QZoneMsgFragment.a(QZoneMsgFragment.this, paramBoolean);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onLoadMoreMsg ，rsp=null");
        }
      }
    }
    
    public void ad(boolean paramBoolean, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg");
      }
      super.ad(paramBoolean, paramBundle);
      if (!paramBoolean) {
        QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onPreloadMsg error");
      }
      do
      {
        return;
        paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
        if (paramBundle != null)
        {
          QZoneMsgFragment.a(QZoneMsgFragment.this, paramBundle);
          QZoneMsgFragment.a(QZoneMsgFragment.this, paramBundle.hasmore);
          QZoneMsgFragment.this.a.fs(paramBundle.ArkNes_vec);
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg ，hasMore=" + QZoneMsgFragment.c(QZoneMsgFragment.this));
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onPreloadMsg ，rsp=null");
    }
    
    public void ae(boolean paramBoolean, Bundle paramBundle)
    {
      QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "onReFreshMsg start");
      super.ae(paramBoolean, paramBundle);
      if (!paramBoolean)
      {
        QZLog.e("QZoneMsgManager.QZoneMsgFragment", "onReFreshMsg error");
        QZoneMsgFragment.b(QZoneMsgFragment.this, paramBoolean);
        return;
      }
      paramBundle = (QZoneMsgEntityNew)paramBundle.getSerializable("key_response");
      if (paramBundle != null)
      {
        QZoneMsgFragment.a(QZoneMsgFragment.this, paramBundle);
        QZoneMsgFragment.a(QZoneMsgFragment.this).postDelayed(new QZoneMsgFragment.QZoneMsgUIObserver.1(this, paramBundle), 500L);
        QZoneMsgFragment.b(QZoneMsgFragment.this, true);
        QZoneMsgFragment.a(QZoneMsgFragment.this, paramBundle.hasmore);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("onReFreshMsg ，hasMore=").append(QZoneMsgFragment.c(QZoneMsgFragment.this)).append(" ,ArkNes_vec size:");
          if (paramBundle.ArkNes_vec == null) {
            break label175;
          }
          paramBundle = String.valueOf(paramBundle.ArkNes_vec.size());
          QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, paramBundle);
        }
      }
      for (;;)
      {
        QZoneMsgFragment.b(QZoneMsgFragment.this, paramBoolean);
        return;
        label175:
        paramBundle = "null";
        break;
        if (QLog.isColorLevel()) {
          QLog.e("QZoneMsgManager.QZoneMsgFragment", 2, "onReFreshMsg ，rsp=null");
        }
      }
    }
    
    public void af(boolean paramBoolean, Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager.QZoneMsgFragment", 2, "onLikeFeed start");
      }
      super.af(paramBoolean, paramBundle);
      if ((paramBoolean) && (paramBundle != null))
      {
        paramBoolean = paramBundle.getBoolean("like_key");
        long l = paramBundle.getLong("entity_pushtime");
        QZoneMsgFragment.this.a.aE(l, paramBoolean);
      }
    }
    
    public boolean b(boolean paramBoolean, Bundle paramBundle)
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment
 * JD-Core Version:    0.7.0.1
 */