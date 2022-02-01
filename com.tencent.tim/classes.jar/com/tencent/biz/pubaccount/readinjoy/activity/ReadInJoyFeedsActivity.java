package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anpc;
import aqgz;
import aqiw;
import auuw;
import auuw.a;
import awit;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import kbp;
import kfn;
import kfr;
import kgu;
import khz;
import kia;
import kxm;
import lbz;
import lcc;
import lcd;
import lce;
import mqq.os.MqqHandler;
import msg;
import mzj;
import oan;
import obt;
import odd;
import odv;
import org.json.JSONObject;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  protected AccountDetailTopGestureLayout a;
  private a a;
  private int aIV;
  private int aIW;
  private int aIX;
  int aIY;
  private ViewGroup aO;
  private ViewGroup aP;
  private boolean afq;
  private boolean afr;
  public boolean afs;
  public Map<Integer, kfr> dI = new HashMap();
  private MqqHandler h = new MqqHandler();
  private GestureDetector mGestureDetector;
  protected lce mObserver = new kia(this);
  private long rV;
  private long rW;
  private long se;
  private long sf;
  private long startTimeMillis;
  
  private void aDf()
  {
    kfn localkfn = new kfn(this);
    localkfn.i(this.aP);
    localkfn.onCreate();
    this.dI.put(Integer.valueOf(this.aIX), localkfn);
  }
  
  private void initUI()
  {
    this.aO = ((ViewGroup)this.titleRoot.findViewById(2131377363));
    this.aP = ((ViewGroup)findViewById(2131376777));
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.nR.setVisibility(8);
      this.d.setVisibility(0);
      this.aIX = j;
      oQ(j);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setOnClickListener(this);
      this.rightViewImg.setImageResource(2130840663);
      this.rightViewImg.setOnClickListener(this);
      if ((this.leftView != null) && (this.aIV != 5)) {
        this.leftView.setText(getString(2131691039));
      }
      return;
      this.nR.setVisibility(0);
      this.d.setVisibility(8);
      aDf();
    }
  }
  
  private void mb(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(162);
    Object localObject1;
    if (((KandianMergeManager)localObject2).By()) {
      localObject1 = getString(2131721466);
    }
    for (int i = 2130843329;; i = 2130843330)
    {
      String str = getString(2131696840);
      ArrayList localArrayList = new ArrayList();
      auuw.a locala = new auuw.a();
      locala.id = 0;
      locala.title = ((String)localObject1);
      locala.contentDescription = locala.title;
      locala.iconId = i;
      localArrayList.add(locala);
      localObject1 = new auuw.a();
      ((auuw.a)localObject1).id = 1;
      ((auuw.a)localObject1).title = str;
      ((auuw.a)localObject1).contentDescription = ((auuw.a)localObject1).title;
      ((auuw.a)localObject1).iconId = 2130843327;
      localArrayList.add(localObject1);
      if (paramBoolean)
      {
        localObject1 = new auuw.a();
        ((auuw.a)localObject1).id = 2;
        ((auuw.a)localObject1).iconId = 2130850180;
        ((auuw.a)localObject1).contentDescription = ((auuw.a)localObject1).title;
        localArrayList.add(localObject1);
      }
      localObject1 = new auuw.a();
      ((auuw.a)localObject1).id = 7;
      ((auuw.a)localObject1).iconId = 2130843331;
      localArrayList.add(localObject1);
      localObject1 = new auuw.a();
      ((auuw.a)localObject1).id = 8;
      ((auuw.a)localObject1).iconId = 2130843328;
      localArrayList.add(localObject1);
      if (paramBoolean) {}
      localObject1 = auuw.a(this, localArrayList, new khz(this, (KandianMergeManager)localObject2));
      localObject2 = this.aO;
      ((auuw)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131299279) - getResources().getDimensionPixelSize(2131299275), getResources().getDimensionPixelSize(2131298584));
      return;
      localObject1 = getString(2131701906);
    }
  }
  
  private void oQ(int paramInt)
  {
    this.aP.removeAllViews();
    kfr localkfr;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setChecked(false);
      oR(0);
      lbz.a().aJm();
      localObject = (kfr)this.dI.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new kfn(this);
        ((kfr)localObject).i(this.aP);
        ((kfr)localObject).onCreate();
        localkfr = (kfr)this.dI.get(Integer.valueOf(1));
        if (localkfr != null) {
          localkfr.aBZ();
        }
        this.dI.put(Integer.valueOf(paramInt), localObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        ((kfr)localObject).aBY();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
    oS(0);
    lbz.a().aJl();
    Object localObject = (kfr)this.dI.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new kgu(this);
      ((kfr)localObject).i(this.aP);
      ((kfr)localObject).onCreate();
    }
    for (;;)
    {
      localkfr = (kfr)this.dI.get(Integer.valueOf(0));
      if (localkfr != null) {
        localkfr.aBZ();
      }
      this.dI.put(Integer.valueOf(paramInt), localObject);
      return;
      ((kfr)localObject).aBY();
    }
  }
  
  private void oR(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.showRedDot(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.showRedDot(false);
  }
  
  private void oS(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.showRedDot(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.showRedDot(false);
  }
  
  void aQ()
  {
    if (this.leftView != null) {
      ThreadManager.post(new ReadInJoyFeedsActivity.3(this), 5, null, true);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 80;
    int i;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else if (paramInt1 == 9991)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "back from article detail");
      }
      if (kxm.AO())
      {
        i = j;
        if (TextUtils.isEmpty(obt.Yj)) {}
      }
    }
    try
    {
      i = new JSONObject(obt.Yj).optInt("releaseServiceMinMem", 80);
      long l = aqgz.getSystemAvaialbeMemory();
      if (l >>> 20 <= i)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "back from article detail, release web core service");
        }
        WebProcessManager.egr();
      }
      try
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject).put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
        ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
        ((HashMap)localObject).put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
        ((HashMap)localObject).put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
        ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
        }
        anpc.a(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
      }
      catch (Exception localException1)
      {
        Object localObject;
        label287:
        break label287;
      }
      localObject = this.dI.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        ((kfr)this.dI.get(localInteger)).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    mzj.a().aO(this);
    super.doOnCreate(paramBundle);
    awit.x(this.app);
    awit.y(this.app);
    this.rV = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(162)).aIH();
    }
    this.afq = paramBundle.getBooleanExtra("from_search", false);
    this.afr = paramBundle.getBooleanExtra("from_javascript", false);
    this.aIV = paramBundle.getIntExtra("launch_from", 5);
    lcc.a().aJB();
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    int i = aqiw.getSystemNetwork(getApplication());
    if ((i == 4) || (i == 1)) {
      ThreadManager.post(new ReadInJoyFeedsActivity.1(this), 5, null, true);
    }
    ThreadManager.executeOnSubThread(new MyRunnable(this));
    setContentView(2131560381);
    getWindow().setBackgroundDrawable(null);
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new AccountDetailTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
    }
    paramBundle = (lcd)this.app.getManager(163);
    lbz.a().aJn();
    lbz.a().aJj();
    setTitle(obt.b(this.app, this.app.getApp()));
    initUI();
    this.aO.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity$a = new a((kfr)this.dI.get(Integer.valueOf(this.aIX)));
    this.mGestureDetector = new GestureDetector(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyFeedsActivity$a);
    if (this.app.b() != null) {
      this.app.b().addObserver(this);
    }
    if (awit.cA(this.app)) {
      oan.a().ap(this.app);
    }
    lcc.a().b(this.mObserver);
    awit.v(this.app);
    this.aIY = kxm.aMw;
    odv.a(1, true, 0L, this.aIY, 0);
    kxm.Q(this.app);
    return true;
  }
  
  public void doOnDestroy()
  {
    lcc.a().c(this.mObserver);
    super.doOnDestroy();
    this.rW = System.currentTimeMillis();
    long l = this.rW - this.rV;
    if (l > 0L) {
      kbp.a(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", kxm.iR(), false);
    }
    Object localObject = this.dI.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      ((kfr)this.dI.get(localInteger)).onDestroy();
    }
    if (this.app.b() != null) {
      this.app.b().deleteObserver(this);
    }
    localObject = (lcd)this.app.getManager(163);
    lbz.a().aJo();
    mzj.a().aP(this);
    PreloadManager.a().bdj();
    PreloadManager.a().bdm();
    odv.a(1, false, this.rV, this.aIY, this.aIW);
    PublicAccountImageCollectionPreloadManager.a().bdj();
    PublicAccountImageCollectionPreloadManager.a().bdm();
    WebProcessManager.egr();
    WebProcessManager.egw();
    msg.aRK();
    msg.a().destroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.afq = paramIntent.getBooleanExtra("from_search", false);
    this.afr = paramIntent.getBooleanExtra("from_javascript", false);
    this.aIV = paramIntent.getIntExtra("launch_from", 5);
    int i = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int j = getIntent().getIntExtra("tab_tab_index", 0);
    if (i >= 0)
    {
      this.aIX = j;
      oQ(j);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.dI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((kfr)this.dI.get(localInteger)).onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.afs)
    {
      this.afs = true;
      odd.bU("KANDIAN_FEEDS_STAGE_1_COST", null);
    }
    Iterator localIterator = this.dI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((kfr)this.dI.get(localInteger)).onResume();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.startTimeMillis = System.currentTimeMillis();
    lbz.a().aJp();
    Iterator localIterator = this.dI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((kfr)this.dI.get(localInteger)).onStart();
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.se = System.currentTimeMillis();
    this.sf += this.se - this.startTimeMillis;
    lbz.a().aJq();
    Iterator localIterator = this.dI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((kfr)this.dI.get(localInteger)).onStop();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.dI.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((kfr)this.dI.get(localInteger)).finish();
    }
  }
  
  public int nk()
  {
    return this.aIX;
  }
  
  public void oP(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.aIV != 5) || (6 == this.aIV) || (this.afq)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyFeedsActivity.4(this, paramInt));
    }
  }
  
  public void oT(int paramInt)
  {
    this.aIW |= paramInt;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (awit.cA(this.app))
      {
        mb(false);
        continue;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.ds()) {
          kbp.a(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", kxm.iQ(), false);
        }
        for (;;)
        {
          if (this.aIX != 0) {
            break label180;
          }
          ((kfr)this.dI.get(Integer.valueOf(this.aIX))).lP(true);
          break;
          kbp.a(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", kxm.iQ(), false);
        }
        label180:
        this.aIX = 0;
        oQ(this.aIX);
        ((KandianMergeManager)this.app.getManager(162)).qj(0);
        continue;
        odd.bU(null, "KANDIAN_TO_SUBSCRIPT_COST");
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.ds()) {
          kbp.a(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", kxm.iQ(), false);
        }
        for (;;)
        {
          if (this.aIX != 1) {
            break label335;
          }
          ((kfr)this.dI.get(Integer.valueOf(this.aIX))).lP(true);
          break;
          kbp.a(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", kxm.iQ(), false);
        }
        label335:
        this.aIX = 1;
        oQ(this.aIX);
        ((KandianMergeManager)this.app.getManager(162)).qj(1);
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.afq) && (!this.afr) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      aQ();
    }
  }
  
  class MyRunnable
    implements Runnable
  {
    private WeakReference<ReadInJoyFeedsActivity> mWeakReference;
    
    public MyRunnable(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity)
    {
      this.mWeakReference = new WeakReference(paramReadInJoyFeedsActivity);
    }
    
    public void run()
    {
      if (WebProcessManager.aFS()) {}
      for (;;)
      {
        return;
        WebProcessManager localWebProcessManager;
        int i;
        if ((this.mWeakReference != null) && (this.mWeakReference.get() != null))
        {
          localWebProcessManager = (WebProcessManager)((ReadInJoyFeedsActivity)this.mWeakReference.get()).app.getManager(13);
          if (localWebProcessManager != null)
          {
            i = kxm.nS();
            if (!kxm.AO()) {}
          }
        }
        try
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
          localHashMap.put("param_totalMem", String.valueOf(aqgz.getSystemTotalMemory()));
          localHashMap.put("param_availableMem", String.valueOf(aqgz.getSystemAvaialbeMemory()));
          localHashMap.put("param_cpuNum", String.valueOf(aqgz.getCpuNumber()));
          localHashMap.put("param_cpuFreq", String.valueOf(aqgz.getCpuFrequency()));
          localHashMap.put("param_preloadLevel", String.valueOf(i));
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseActivity", 2, "preloadToolProcessReport:" + localHashMap.toString());
          }
          anpc.a(ReadInJoyFeedsActivity.this).collectPerformance(ReadInJoyFeedsActivity.this.app.getCurrentAccountUin(), "actReadInJoyToolPreload", true, 0L, 0L, localHashMap, "");
        }
        catch (Exception localException)
        {
          label206:
          break label206;
        }
        if (i == 1) {
          localWebProcessManager.Yc(200);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("ReadInJoyBaseActivity", 2, "enter folder preload web process");
          return;
          if (i == 2) {
            localWebProcessManager.Yc(201);
          }
        }
      }
    }
  }
  
  static class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private WeakReference<kfr> bs;
    
    public a(kfr paramkfr)
    {
      this.bs = new WeakReference(paramkfr);
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      if ((this.bs != null) && (this.bs.get() != null)) {
        ((kfr)this.bs.get()).lP(true);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity
 * JD-Core Version:    0.7.0.1
 */