package com.tencent.mobileqq.activity;

import abdw;
import abeg;
import abeg.a;
import acfd;
import acfp;
import acja;
import acje;
import aklk;
import altq;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiy;
import aurf;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import jqs;
import kbp;
import mqq.os.MqqHandler;
import vmv;
import vmw;
import vmx;
import vmy;
import vmz;
import vna;
import vnb;
import vnc;
import vnd;
import vne;
import vnf;
import vng;
import vnh;
import vni;

public class PublicAccountListActivity
  extends BaseActivity
  implements ThreadExcutor.IThreadListener, IndexView.a
{
  TextView EE;
  TextView EF;
  public EditText I;
  public Dialog W;
  private acfd jdField_a_of_type_Acfd = new vmx(this);
  acja jdField_a_of_type_Acja;
  b jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b = null;
  d jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d;
  e jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$e = new e();
  public boolean aaC = false;
  ImageButton ag;
  IndexView b;
  PinnedDividerListView c;
  private acje d = new vmy(this);
  Drawable dC;
  Runnable dZ = new PublicAccountListActivity.2(this);
  private aklk e = new vmz(this);
  private AdapterView.c g = new vna(this);
  RelativeLayout gW;
  RelativeLayout gX;
  private boolean isResume;
  Handler.Callback mCallback = new vmv(this);
  View mContentView;
  View mEmptyView;
  LayoutInflater mLayoutInflater;
  View mLoadingView;
  View.OnClickListener mOnClickListener = new vnb(this);
  public LinearLayout mRootView;
  List<a> mSearchResultList = new ArrayList();
  TextView mTitle;
  public View mTitleBar;
  private MqqHandler mUIHandler;
  List<a> pr = new ArrayList();
  XListView r;
  public View rS;
  View root;
  View tL;
  TextView tS;
  private RedTouch u;
  private Comparator<a> z = new vnc(this);
  
  private a a(PublicAccountInfo paramPublicAccountInfo)
  {
    a locala = new a(paramPublicAccountInfo);
    locala.vV(ChnToSpell.aJ(paramPublicAccountInfo.name, 2));
    locala.vW(ChnToSpell.aJ(paramPublicAccountInfo.name, 1));
    return locala;
  }
  
  private boolean a(a parama)
  {
    if ((parama != null) && (parama.a == null)) {}
    return false;
  }
  
  private void aC()
  {
    this.mTitle.setText(2131697387);
    this.tS.setText(2131697396);
    this.EE.setText(2131721053);
    this.u = new RedTouch(this, this.EE);
    this.u.a(53).d(5).c(5).a();
    this.tS.setOnClickListener(this.mOnClickListener);
    this.EE.setOnClickListener(this.mOnClickListener);
    if (AppSetting.enableTalkBack)
    {
      this.mTitle.setContentDescription(this.mTitle.getText());
      this.tS.setContentDescription(this.tS.getText() + acfp.m(2131710216));
    }
  }
  
  private void bSH()
  {
    this.W = new ReportDialog(this);
    this.W.setCanceledOnTouchOutside(true);
    this.W.requestWindowFeature(1);
    this.W.getWindow().setSoftInputMode(36);
    this.W.setContentView(2131559831);
    Object localObject = this.W.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.W.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.r = ((XListView)this.W.findViewById(2131377779));
    this.r.setBackgroundDrawable(getResources().getDrawable(2130838900));
    this.r.setDividerHeight(0);
    this.rS = this.mLayoutInflater.inflate(2131559830, this.r, false);
    this.rS.setOnClickListener(this.mOnClickListener);
    this.r.addFooterView(this.rS);
    this.rS.setTag("");
    this.mSearchResultList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d = new d(this.mSearchResultList);
    this.r.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d);
    this.r.setOnItemClickListener(this.g);
    this.r.setOnTouchListener(new vnh(this, (InputMethodManager)localObject));
    this.root = this.W.findViewById(2131377546);
    this.I = ((EditText)this.W.findViewById(2131366542));
    this.I.addTextChangedListener(new f());
    this.ag = ((ImageButton)this.W.findViewById(2131368696));
    this.ag.setOnClickListener(new vni(this));
    this.gX = ((RelativeLayout)this.W.findViewById(2131377207));
    this.gX.setOnClickListener(new vmw(this));
    this.tL = this.W.findViewById(2131368527);
    this.EF = ((TextView)this.W.findViewById(2131365748));
    ((Button)this.tL.findViewById(2131377845)).setOnClickListener(this.mOnClickListener);
  }
  
  private void bSI()
  {
    if (this.u != null)
    {
      altq localaltq = (altq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("101000.101001");
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() == 1)) {
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X80060E2", "0X80060E2", 0, 0, "", "", "", "", false);
      }
      this.u.e(localAppInfo);
      localaltq.i(localAppInfo);
    }
  }
  
  private void hideEmptyView()
  {
    if (this.mEmptyView != null) {
      this.mEmptyView.setVisibility(8);
    }
    this.mContentView.setVisibility(0);
  }
  
  private void initListView()
  {
    View localView = super.getLayoutInflater().inflate(2131559824, this.c, false);
    this.gW = ((RelativeLayout)localView.findViewById(2131377783));
    ((EditText)this.gW.findViewById(2131366542)).setOnTouchListener(new vnd(this));
    ((Button)this.gW.findViewById(2131363801)).setVisibility(8);
    this.c.addHeaderView(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b = new b();
    this.c.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b);
    this.b.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.b.setOnIndexChangedListener(this);
    bSH();
  }
  
  @TargetApi(14)
  private void initViews()
  {
    this.mRootView = ((LinearLayout)super.findViewById(2131373776));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.mRootView.setFitsSystemWindows(true);
    }
    this.mTitleBar = super.findViewById(2131379791);
    this.mTitle = ((TextView)super.findViewById(2131369627));
    this.tS = ((TextView)super.findViewById(2131369579));
    this.EE = ((TextView)super.findViewById(2131369612));
    this.EE.setVisibility(0);
    this.mContentView = super.findViewById(2131365396);
    this.c = ((PinnedDividerListView)super.findViewById(2131373773));
    this.b = ((IndexView)super.findViewById(2131369142));
    this.mLoadingView = super.findViewById(2131373699);
    this.c.setOnItemClickListener(this.g);
  }
  
  private void showEmptyView()
  {
    if (this.mEmptyView == null)
    {
      ViewStub localViewStub = (ViewStub)super.findViewById(2131366438);
      if (localViewStub == null) {
        return;
      }
      this.mEmptyView = localViewStub.inflate();
      this.mEmptyView.findViewById(2131377845).setOnClickListener(this.mOnClickListener);
    }
    this.mEmptyView.setVisibility(0);
    this.mContentView.setVisibility(8);
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.c.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b.m(paramString);
    } while (i == -1);
    this.c.setSelection(i + this.c.getHeaderViewsCount());
  }
  
  public void ayl()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int i = this.mTitleBar.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.mRootView.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new vne(this, localTranslateAnimation1, localTranslateAnimation2, i));
    this.W.setOnDismissListener(new vnf(this, i, localTranslateAnimation2, (InputMethodManager)localObject));
    this.I.setText("");
    this.I.setSelection(0);
    this.I.requestFocus();
    localObject = (Button)this.W.findViewById(2131363801);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new vng(this));
    this.mSearchResultList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d.notifyDataSetChanged();
    this.aaC = true;
  }
  
  protected void bcu()
  {
    Object localObject = (ViewGroup)super.findViewById(2131377361);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = super.findViewById(2131379791);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)super.findViewById(2131369579);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Acja = ((acja)this.app.getManager(56));
    super.setContentView(2131559823);
    this.mLayoutInflater = super.getLayoutInflater();
    initViews();
    aC();
    initListView();
    if (this.jdField_a_of_type_Acja.bIJ) {
      refresh();
    }
    for (;;)
    {
      bcu();
      super.addObserver(this.d);
      super.addObserver(this.jdField_a_of_type_Acfd);
      this.app.registObserver(this.e);
      this.mUIHandler = new aurf(Looper.getMainLooper(), this.mCallback);
      this.app.setHandler(getClass(), this.mUIHandler);
      return true;
      ThreadManager.post(this.dZ, 5, this, true);
    }
  }
  
  public void doOnDestroy()
  {
    super.removeObserver(this.d);
    super.removeObserver(this.jdField_a_of_type_Acfd);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b.destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d.destroy();
    }
    super.doOnDestroy();
    this.app.unRegistObserver(this.e);
    this.app.removeHandler(getClass());
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.isResume = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.isResume = true;
    try
    {
      getWindow().setSoftInputMode(48);
      label18:
      if (this.mTitleBar != null)
      {
        this.mTitleBar.destroyDrawingCache();
        this.mTitleBar.requestLayout();
        this.mTitleBar.invalidate();
      }
      bSI();
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    getWindow().setSoftInputMode(16);
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    runOnUiThread(new PublicAccountListActivity.3(this));
  }
  
  public void onPreRun() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      aqiy.bk("pubAcc_follow_list_display", null, "");
    }
  }
  
  public void refresh()
  {
    this.pr.clear();
    ArrayList localArrayList = this.jdField_a_of_type_Acja.cy();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      hideEmptyView();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext()) {
        this.pr.add(a((PublicAccountInfo)localIterator.next()));
      }
      if (localArrayList.size() < 15) {
        this.b.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$b.bSJ();
      if (this.aaC) {
        this.W.dismiss();
      }
      return;
      this.b.setVisibility(0);
      continue;
      showEmptyView();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
  
  protected void vv(String paramString)
  {
    long l1 = System.currentTimeMillis();
    this.mSearchResultList.clear();
    this.root.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.ag.setVisibility(8);
      this.r.setVisibility(8);
      this.tL.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d.notifyDataSetChanged();
      return;
    }
    this.ag.setVisibility(0);
    this.r.setVisibility(0);
    paramString = paramString.toLowerCase();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = this.pr.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      String str = locala.a.displayNumber;
      if ((str != null) && (str.equalsIgnoreCase(paramString)))
      {
        localArrayList4.add(locala);
      }
      else
      {
        str = locala.a.name.toLowerCase();
        if ((str.equals(paramString)) || (locala.pinyinAll.equals(paramString)) || (locala.pinyinFirst.equals(paramString))) {
          localArrayList1.add(locala);
        } else if ((str.indexOf(paramString) == 0) || (locala.pinyinAll.indexOf(paramString) == 0) || (locala.pinyinFirst.indexOf(paramString) == 0)) {
          localArrayList2.add(locala);
        } else if ((str.indexOf(paramString) > 0) || (locala.pinyinAll.indexOf(paramString) > 0) || (locala.pinyinFirst.indexOf(paramString) > 0)) {
          localArrayList3.add(locala);
        }
      }
    }
    Collections.sort(localArrayList4, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$e);
    Collections.sort(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$e);
    Collections.sort(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$e);
    Collections.sort(localArrayList3, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$e);
    this.mSearchResultList.addAll(localArrayList4);
    this.mSearchResultList.addAll(localArrayList1);
    this.mSearchResultList.addAll(localArrayList2);
    this.mSearchResultList.addAll(localArrayList3);
    if (this.mSearchResultList.isEmpty())
    {
      this.EF.setText(getString(2131697405, new Object[] { paramString }));
      this.tL.setVisibility(0);
      this.r.setVisibility(8);
    }
    for (;;)
    {
      this.rS.setTag(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity$d.notifyDataSetChanged();
      long l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PublicAccountListActivity", 2, "refreshSearchResultList:" + paramString + "," + (l2 - l1) + "," + this.mSearchResultList.size() + "," + this.pr.size());
      return;
      this.tL.setVisibility(8);
      this.r.setVisibility(0);
    }
  }
  
  public static class a
  {
    public PublicAccountInfo a;
    public String pinyinAll = "";
    public String pinyinFirst = "";
    
    public a(PublicAccountInfo paramPublicAccountInfo)
    {
      this.a = paramPublicAccountInfo;
    }
    
    public void vV(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.pinyinFirst = str;
    }
    
    public void vW(String paramString)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      this.pinyinAll = str;
    }
  }
  
  public class b
    extends abdw
  {
    public LinkedHashMap<String, List<PublicAccountListActivity.a>> D = new LinkedHashMap();
    public int[] ad = new int[0];
    public String[] k = new String[0];
    
    public b()
    {
      super(PublicAccountListActivity.this.app, PublicAccountListActivity.this.c, true);
    }
    
    private void bNq()
    {
      this.D.clear();
      if (PublicAccountListActivity.this.pr == null) {}
      for (;;)
      {
        return;
        Object localObject2 = PublicAccountListActivity.this.pr.iterator();
        label89:
        int i;
        while (((Iterator)localObject2).hasNext())
        {
          PublicAccountListActivity.a locala = (PublicAccountListActivity.a)((Iterator)localObject2).next();
          if (!PublicAccountListActivity.a(PublicAccountListActivity.this, locala))
          {
            if ((locala.pinyinFirst == null) || (locala.pinyinFirst.length() == 0))
            {
              localObject1 = "#";
              i = ((String)localObject1).charAt(0);
              if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
                break label194;
              }
            }
            label194:
            for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
            {
              if (this.D.get(localObject1) == null) {
                this.D.put(localObject1, new ArrayList());
              }
              ((List)this.D.get(localObject1)).add(locala);
              break;
              localObject1 = locala.pinyinFirst.substring(0, 1);
              break label89;
            }
          }
        }
        Object localObject1 = this.D;
        this.D = new LinkedHashMap();
        for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
          if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
          {
            localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
            Collections.sort((List)localObject2, PublicAccountListActivity.a(PublicAccountListActivity.this));
            this.D.put(String.valueOf(c), localObject2);
          }
        }
        if (((LinkedHashMap)localObject1).get("#") != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get("#");
          Collections.sort((List)localObject2, PublicAccountListActivity.a(PublicAccountListActivity.this));
          this.D.put("#", localObject2);
        }
        ((LinkedHashMap)localObject1).clear();
        this.ad = new int[this.D.keySet().size()];
        this.k = new String[this.ad.length];
        localObject1 = this.D.keySet().iterator();
        if (this.ad.length != 0)
        {
          this.ad[0] = 0;
          i = 1;
          while (i < this.ad.length)
          {
            localObject2 = this.ad;
            int j = localObject2[i];
            int m = this.ad[(i - 1)];
            localObject2[i] = (((List)this.D.get(((Iterator)localObject1).next())).size() + m + 1 + j);
            i += 1;
          }
          localObject1 = this.D.keySet().iterator();
          i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            this.k[i] = ((String)((Iterator)localObject1).next());
            i += 1;
          }
        }
      }
    }
    
    public int ag()
    {
      return 2131559496;
    }
    
    public void b(View paramView, int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      paramInt = i;
      if (i < 0) {
        paramInt = -(i + 1) - 1;
      }
      if (paramInt >= this.k.length) {
        return;
      }
      ((TextView)paramView).setText(this.k[paramInt]);
    }
    
    public void bSJ()
    {
      bNq();
      super.notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.ad.length == 0) {
        return 0;
      }
      int i = this.ad[(this.ad.length - 1)];
      return ((List)this.D.get(this.k[(this.k.length - 1)])).size() + i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      if (i >= 0) {
        return null;
      }
      i = -(i + 1) - 1;
      return (PublicAccountListActivity.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      PublicAccountListActivity.c localc;
      Object localObject;
      if (paramView == null)
      {
        paramView = PublicAccountListActivity.this.mLayoutInflater.inflate(2131559827, paramViewGroup, false);
        localc = new PublicAccountListActivity.c();
        localc.pQ = ((ImageView)paramView.findViewById(2131368698));
        localc.qG = ((ImageView)paramView.findViewById(2131364179));
        localc.rc = ((TextView)paramView.findViewById(2131379402));
        localc.fe = ((TextView)paramView.findViewById(2131373774));
        localc.rb = ((TextView)paramView.findViewById(2131373757));
        localc.ra = ((TextView)paramView.findViewById(2131373784));
        localc.rd = ((TextView)paramView.findViewById(2131379404));
        localc.EG = ((TextView)paramView.findViewById(2131380761));
        localc.tM = paramView.findViewById(2131373771);
        localc.qH = ((ImageView)paramView.findViewById(2131364146));
        paramView.setTag(localc);
        if (i >= 0) {
          break label764;
        }
        i = -(i + 1) - 1;
        localObject = (PublicAccountListActivity.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
        localc.a = ((PublicAccountListActivity.a)localObject);
        localc.uin = String.valueOf(((PublicAccountListActivity.a)localObject).a.uin);
        localc.tM.setVisibility(0);
        localc.EG.setVisibility(8);
        localc.rc.setVisibility(0);
        localc.rc.setText(((PublicAccountListActivity.a)localObject).a.name);
        if (((PublicAccountListActivity.a)localObject).a.certifiedGrade <= 0L) {
          break label703;
        }
        if (PublicAccountListActivity.this.dC == null)
        {
          PublicAccountListActivity.this.dC = PublicAccountListActivity.this.getResources().getDrawable(2130842599);
          PublicAccountListActivity.this.dC.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
        }
        ThemeUtil.setThemeFilter(PublicAccountListActivity.this.dC, ThemeUtil.curThemeId);
        localc.rc.setCompoundDrawables(null, null, PublicAccountListActivity.this.dC, null);
        label398:
        localc.rd.setText(((PublicAccountListActivity.a)localObject).a.summary);
        localc.pQ.setImageBitmap(super.getFaceBitmap(localc.uin));
        boolean bool = false;
        if (((PublicAccountListActivity.a)localObject).a.extendType == 2) {
          bool = jqs.c(PublicAccountListActivity.this.app, ((PublicAccountListActivity.a)localObject).a.getUin(), 1024);
        }
        if (!bool) {
          break label718;
        }
        localc.qG.setTag(-1, ((PublicAccountListActivity.a)localObject).a.getUin());
        localc.qG.setTag(-2, ((PublicAccountListActivity.a)localObject).a.name);
        localc.qG.setOnClickListener(PublicAccountListActivity.this.mOnClickListener);
        localc.qG.setVisibility(0);
        label533:
        if (!bool)
        {
          localc.qH.setTag(-1, "");
          localc.qH.setTag(-2, "");
          localc.qH.setOnClickListener(null);
          localc.qH.setVisibility(4);
        }
        localc.rb.setVisibility(8);
        localc.fe.setVisibility(8);
        localc.ra.setVisibility(8);
        if (AppSetting.enableTalkBack)
        {
          localObject = new StringBuilder(24);
          ((StringBuilder)localObject).append(localc.rc.getText()).append(" 简介 ").append(localc.rd.getText());
          paramView.setContentDescription((CharSequence)localObject);
          paramView.setFocusable(true);
          paramView.setFocusableInTouchMode(true);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localc = (PublicAccountListActivity.c)paramView.getTag();
        break;
        label703:
        localc.rc.setCompoundDrawables(null, null, null, null);
        break label398;
        label718:
        localc.qG.setTag(-1, "");
        localc.qG.setTag(-2, "");
        localc.qG.setOnClickListener(null);
        localc.qG.setVisibility(4);
        break label533;
        label764:
        localc.a = null;
        localc.uin = "";
        localc.tM.setVisibility(8);
        localc.EG.setVisibility(0);
        localObject = String.valueOf(this.k[i]);
        localc.EG.setText((CharSequence)localObject);
        if (AppSetting.enableTalkBack) {
          localc.EG.setContentDescription(String.format(PublicAccountListActivity.this.getString(2131692906), new Object[] { ((String)localObject).toLowerCase() }));
        }
      }
    }
    
    public int m(String paramString)
    {
      int i;
      if (this.k != null)
      {
        i = 0;
        if (i >= this.k.length) {
          break label53;
        }
        if (!this.k[i].equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0)
        {
          return this.ad[i];
          i += 1;
          break;
        }
        return -1;
        return -1;
        label53:
        i = -1;
      }
    }
    
    public boolean t(int paramInt)
    {
      return Arrays.binarySearch(this.ad, paramInt) >= 0;
    }
  }
  
  public static class c
    extends abeg.a
  {
    public TextView EG;
    public PublicAccountListActivity.a a;
    public TextView fe;
    public ImageView qG;
    public ImageView qH;
    public TextView ra;
    public TextView rb;
    public TextView rc;
    public TextView rd;
    public View tM;
  }
  
  public class d
    extends abeg
  {
    private List<PublicAccountListActivity.a> mList;
    
    public d()
    {
      super(PublicAccountListActivity.this.app, PublicAccountListActivity.this.r, 1, true);
      Object localObject;
      this.mList = localObject;
    }
    
    public int getCount()
    {
      if (this.mList == null) {
        return 0;
      }
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = PublicAccountListActivity.this.mLayoutInflater.inflate(2131559829, paramViewGroup, false);
        paramView = new PublicAccountListActivity.g();
        paramView.pQ = ((ImageView)localView.findViewById(2131368698));
        paramView.fe = ((TextView)localView.findViewById(2131372190));
        localView.setTag(paramView);
        localObject = getItem(paramInt);
        if (localObject != null)
        {
          localObject = (PublicAccountListActivity.a)localObject;
          if (localObject != null)
          {
            paramView.uin = ((PublicAccountListActivity.a)localObject).a.getUin();
            paramView.a = ((PublicAccountListActivity.a)localObject);
            paramView.pQ.setImageBitmap(super.a(paramView.uin, 1, (byte)0));
            paramView.fe.setText(((PublicAccountListActivity.a)localObject).a.name);
            if (((PublicAccountListActivity.a)localObject).a.certifiedGrade <= 0L) {
              break label284;
            }
            if (PublicAccountListActivity.this.dC == null)
            {
              PublicAccountListActivity.this.dC = PublicAccountListActivity.this.getResources().getDrawable(2130842599);
              PublicAccountListActivity.this.dC.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
              ThemeUtil.setThemeFilter(PublicAccountListActivity.this.dC, ThemeUtil.curThemeId);
            }
            paramView.fe.setCompoundDrawables(null, null, PublicAccountListActivity.this.dC, null);
          }
        }
      }
      for (;;)
      {
        if (AppSetting.enableTalkBack) {
          localView.setContentDescription(paramView.fe.getText());
        }
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (PublicAccountListActivity.g)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label284:
        paramView.fe.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public class e
    implements Comparator<PublicAccountListActivity.a>
  {
    public e() {}
    
    public int a(PublicAccountListActivity.a parama1, PublicAccountListActivity.a parama2)
    {
      long l = parama1.a.certifiedGrade;
      return (int)(parama2.a.certifiedGrade - l);
    }
  }
  
  public class f
    implements TextWatcher
  {
    protected f() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = PublicAccountListActivity.this.I.getText().toString().trim();
      PublicAccountListActivity.this.vv(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static class g
    extends abeg.a
  {
    public PublicAccountListActivity.a a;
    public TextView fe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity
 * JD-Core Version:    0.7.0.1
 */