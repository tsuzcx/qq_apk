package com.tencent.mobileqq.activity.contacts.publicaccount;

import abdi;
import abdw;
import abeg.a;
import acbn;
import aceb;
import acfd;
import acja;
import acje;
import ahty;
import ahua;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqhu;
import asgx;
import aurf;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.contentbox.QZoneMsgActivity;
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
import ocp;
import ogj;
import rzd;
import tog;
import xki;
import zba;
import zbb;
import zbc;
import zbd;
import zbe;
import zbf;
import zbg;

public class PublicAccountFragment
  extends ContactsBaseFragment
  implements IndexView.a, AdapterView.c
{
  private acfd a;
  protected acja a;
  protected b a;
  private boolean aUE;
  protected IndexView b;
  protected PinnedDividerListView c;
  private acje d = new zbf(this);
  protected Drawable dC;
  protected Handler.Callback mCallback = new zba(this);
  protected View mEmptyView;
  protected View mRootView;
  protected MqqHandler mUIHandler;
  protected List<a> pr;
  private Comparator<a> z = new zbd(this);
  
  public PublicAccountFragment()
  {
    this.jdField_a_of_type_Acfd = new zbe(this);
  }
  
  private a a(PublicAccountInfo paramPublicAccountInfo)
  {
    a locala = new a(paramPublicAccountInfo);
    locala.vV(ChnToSpell.aJ(paramPublicAccountInfo.name, 2));
    locala.vW(ChnToSpell.aJ(paramPublicAccountInfo.name, 1));
    return locala;
  }
  
  private void showEmptyView()
  {
    if (this.mEmptyView == null)
    {
      if (this.mRootView == null) {}
      ViewStub localViewStub;
      do
      {
        return;
        localViewStub = (ViewStub)this.mRootView.findViewById(2131366438);
      } while (localViewStub == null);
      this.mEmptyView = localViewStub.inflate();
      this.mEmptyView.findViewById(2131377845).setOnClickListener(new zbb(this));
    }
    this.mEmptyView.setVisibility(0);
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.mRootView == null) {}
    do
    {
      return;
      if (paramBoolean) {
        bpM();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b = new b();
        this.c.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b);
      }
      if (this.jdField_a_of_type_Acja == null) {
        this.jdField_a_of_type_Acja = ((acja)this.mApp.getManager(56));
      }
    } while (this.jdField_a_of_type_Acja == null);
    if (this.jdField_a_of_type_Acja.bIJ)
    {
      this.mRootView.postDelayed(new PublicAccountFragment.2(this), 200L);
      return;
    }
    qh();
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bpN();
      this.c.setVisibility(4);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
    }
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
      i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.m(paramString);
    } while (i == -1);
    this.c.setSelection(i + this.c.getHeaderViewsCount());
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "getView");
    }
    if (this.mRootView == null)
    {
      this.mRootView = paramLayoutInflater.inflate(2131559060, null, false);
      this.c = ((PinnedDividerListView)this.mRootView.findViewById(2131373773));
      this.c.mForContacts = true;
      this.c.setOnItemClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)this.mRootView.findViewById(2131369142));
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
    for (;;)
    {
      return this.mRootView;
      paramLayoutInflater = this.mRootView.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.mRootView);
      }
    }
  }
  
  public void bpM()
  {
    if ((this.mApp != null) && (this.mk))
    {
      this.mApp.addObserver(this.jdField_a_of_type_Acfd);
      this.mApp.addObserver(this.d);
      if (this.mUIHandler == null)
      {
        this.mUIHandler = new aurf(Looper.getMainLooper(), this.mCallback);
        this.mApp.setHandler(getClass(), this.mUIHandler);
      }
    }
  }
  
  public void bpN()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Acfd);
      this.mApp.removeObserver(this.d);
      this.mApp.removeHandler(getClass());
      if (this.mUIHandler != null) {
        this.mUIHandler.removeCallbacksAndMessages(null);
      }
      if (this.pr != null) {
        this.pr.clear();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.destroy();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b = null;
      }
      this.jdField_a_of_type_Acja = null;
    }
  }
  
  public void doOnDestroy()
  {
    bpN();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.destroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b = null;
  }
  
  public View e()
  {
    return this.c;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    paramView = paramView.getTag();
    if ((paramView instanceof c)) {
      paramAdapterView = ((c)paramView).a;
    }
    if (paramAdapterView == null) {
      if (QLog.isColorLevel()) {
        QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - info = null[position = " + paramInt + "]");
      }
    }
    Intent localIntent;
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramAdapterView.a.getUin();
          localIntent = new Intent(this.mActivity, ChatActivity.class);
          paramInt = 1008;
          if (!TextUtils.isEmpty(paramView)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("Contacts.PublicAccountFragment", 2, "onItemClick - uin = null");
        return;
      } while ((xki.hN(paramView)) && (abdi.b(this.mActivity, this.mApp)));
      if (ocp.F(paramAdapterView.a.accountFlag2) == -10L)
      {
        rzd.bf(this.mActivity, paramView);
        return;
      }
      if (paramAdapterView.a.extendType == 2)
      {
        localIntent.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      if (TextUtils.equals(paramView, acbn.blN))
      {
        ogj.c(getActivity(), "from_user_contacts", 3, false);
        return;
      }
      if (TextUtils.equals(paramView, acbn.blS))
      {
        ocp.b(getActivity(), this.mApp);
        return;
      }
    } while ((TextUtils.equals(paramView, "2290230341")) && (QZoneMsgActivity.e(getActivity(), this.mApp)));
    if ((TextUtils.equals(paramView, "2747277822")) && (ahty.anY()))
    {
      ahua.es(getActivity());
      this.mApp.a().h("2747277822", 1008, false);
      return;
    }
    if (MiniGamePublicAccountHelper.shouldOpenWebFragment(paramView))
    {
      MiniGamePublicAccountHelper.launchMiniGamePublicAccount(getActivity());
      this.mApp.a().h(acbn.blT, 1008, false);
      return;
    }
    localIntent.putExtra("uin", paramView);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramAdapterView.a.name);
    localIntent.putExtra("selfSet_leftViewText", getString(2131697387));
    localIntent.putExtra("jump_from", 3);
    startActivity(localIntent);
    kbp.a(this.mApp, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_4", "contacts_aio", 0, 0, paramView, "", "", "", false);
    anot.b(this.mApp, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 1, 0, paramView, "", "", "");
  }
  
  protected void qh()
  {
    ThreadManager.post(new PublicAccountFragment.4(this), 5, new zbc(this), true);
  }
  
  public void refresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Contacts.PublicAccountFragment", 2, "refresh");
    }
    Object localObject = (PublicAccountHandler)this.mApp.getBusinessHandler(11);
    if (localObject != null)
    {
      ((PublicAccountHandler)localObject).cLi();
      ((PublicAccountHandler)localObject).AF();
    }
    localObject = (aceb)this.mApp.getBusinessHandler(21);
    if (localObject != null) {
      ((aceb)localObject).hq(SystemClock.uptimeMillis());
    }
    this.aUE = true;
  }
  
  public void refreshData()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b == null) {
      return;
    }
    if (this.pr == null) {
      this.pr = new ArrayList();
    }
    if (this.jdField_a_of_type_Acja == null) {
      this.jdField_a_of_type_Acja = ((acja)this.mApp.getManager(56));
    }
    this.pr.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.notifyDataSetChanged();
    Object localObject = this.jdField_a_of_type_Acja.cy();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.mEmptyView != null) {
        this.mEmptyView.setVisibility(8);
      }
      this.c.setVisibility(0);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        asgx localasgx = (asgx)this.mApp.getManager(165);
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if ((ocp.ew(localPublicAccountInfo.getUin())) && (!acbn.blO.equals(localPublicAccountInfo.getUin())) && (!acbn.blP.equals(localPublicAccountInfo.getUin())) && ((localasgx == null) || (!localasgx.sM(localPublicAccountInfo.getUin())))) {
          this.pr.add(a(localPublicAccountInfo));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.bNq();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.notifyDataSetChanged();
      return;
    }
    showEmptyView();
    this.c.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  public void resetData()
  {
    if (this.mk)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b.destroy();
      }
      if (this.mRootView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b = new b();
        this.c.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPublicaccountPublicAccountFragment$b);
        refreshData();
      }
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
    public LinkedHashMap<String, List<PublicAccountFragment.a>> D = new LinkedHashMap();
    public int[] ad = new int[0];
    private boolean bqq;
    public String[] k = new String[0];
    View.OnClickListener mOnClickListener = new zbg(this);
    
    public b()
    {
      this(PublicAccountFragment.c(PublicAccountFragment.this), PublicAccountFragment.b(PublicAccountFragment.this), PublicAccountFragment.this.c, true);
    }
    
    public b(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
    {
      super(paramQQAppInterface, paramXListView, paramBoolean);
      this.du = aqhu.f(true);
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
      if ((paramInt >= this.k.length) || (paramInt < 0)) {}
      while (!(paramView instanceof TextView)) {
        return;
      }
      paramView = (TextView)paramView;
      i = paramView.getPaddingLeft();
      if ((ThemeUtil.isNowThemeDefaultCache) || (ThemeUtil.isNowThemeIsNight(PublicAccountFragment.e(PublicAccountFragment.this), false, null))) {
        paramView.setBackgroundResource(2130851241);
      }
      for (;;)
      {
        paramView.setPadding(i, 0, 0, 0);
        paramView.setText(this.k[paramInt]);
        paramView.setTextColor(PublicAccountFragment.f(PublicAccountFragment.this).getResources().getColorStateList(2131167383));
        return;
        paramView.setBackgroundColor(553648127);
      }
    }
    
    protected void bNq()
    {
      this.D.clear();
      if ((PublicAccountFragment.this.pr == null) || (PublicAccountFragment.this.pr.isEmpty())) {}
      Object localObject2;
      label92:
      do
      {
        return;
        localObject2 = PublicAccountFragment.this.pr.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          PublicAccountFragment.a locala = (PublicAccountFragment.a)((Iterator)localObject2).next();
          if ((locala.pinyinFirst == null) || (locala.pinyinFirst.length() == 0))
          {
            localObject1 = "#";
            i = ((String)localObject1).charAt(0);
            if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
              break label197;
            }
          }
          for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
          {
            if (this.D.get(localObject1) == null) {
              this.D.put(localObject1, new ArrayList());
            }
            ((List)this.D.get(localObject1)).add(locala);
            break;
            localObject1 = locala.pinyinFirst.substring(0, 1);
            break label92;
          }
        }
        localObject1 = this.D;
        this.D = new LinkedHashMap();
        for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
          if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
          {
            localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
            Collections.sort((List)localObject2, PublicAccountFragment.a(PublicAccountFragment.this));
            this.D.put(String.valueOf(c), localObject2);
          }
        }
        if (((LinkedHashMap)localObject1).get("#") != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get("#");
          Collections.sort((List)localObject2, PublicAccountFragment.a(PublicAccountFragment.this));
          this.D.put("#", localObject2);
        }
        ((LinkedHashMap)localObject1).clear();
        this.ad = new int[this.D.keySet().size()];
        this.k = new String[this.ad.length];
        localObject1 = this.D.keySet().iterator();
      } while (this.ad.length == 0);
      label197:
      this.ad[0] = 0;
      int i = 1;
      while (i < this.ad.length)
      {
        localObject2 = this.ad;
        int j = localObject2[i];
        int m = this.ad[(i - 1)];
        localObject2[i] = (((List)this.D.get(((Iterator)localObject1).next())).size() + m + 1 + j);
        i += 1;
      }
      Object localObject1 = this.D.keySet().iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        this.k[i] = ((String)((Iterator)localObject1).next());
        i += 1;
      }
      this.bqq = true;
    }
    
    public void clear()
    {
      this.D.clear();
      this.ad = new int[0];
      this.k = new String[0];
      this.bqq = false;
    }
    
    public Bitmap e(String paramString, int paramInt)
    {
      return a(paramString, 115, (byte)0, paramInt);
    }
    
    public boolean f(View paramView, int paramInt)
    {
      return (!ThemeUtil.isNowThemeDefaultCache) && (!ThemeUtil.isNowThemeIsNight(PublicAccountFragment.d(PublicAccountFragment.this), false, null));
    }
    
    public int getCount()
    {
      if ((this.ad.length == 0) || (!this.bqq)) {
        return 0;
      }
      List localList = (List)this.D.get(this.k[(this.k.length - 1)]);
      if (localList != null)
      {
        int i = this.ad[(this.ad.length - 1)];
        return localList.size() + i + 1;
      }
      return 0;
    }
    
    public Bitmap getFaceBitmap(String paramString)
    {
      return e(paramString, 0);
    }
    
    public Object getItem(int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      if (i >= 0) {
        return null;
      }
      i = -(i + 1) - 1;
      return (PublicAccountFragment.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      View localView;
      if (paramView == null)
      {
        localView = PublicAccountFragment.d(PublicAccountFragment.this).getLayoutInflater().inflate(2131559827, paramViewGroup, false);
        paramView = new PublicAccountFragment.c();
        paramView.type = 115;
        paramView.pQ = ((ImageView)localView.findViewById(2131368698));
        paramView.qG = ((ImageView)localView.findViewById(2131364179));
        paramView.rc = ((TextView)localView.findViewById(2131379402));
        paramView.fe = ((TextView)localView.findViewById(2131373774));
        paramView.rb = ((TextView)localView.findViewById(2131373757));
        paramView.ra = ((TextView)localView.findViewById(2131373784));
        paramView.rd = ((TextView)localView.findViewById(2131379404));
        paramView.EG = ((TextView)localView.findViewById(2131380761));
        paramView.tM = localView.findViewById(2131373771);
        paramView.qH = ((ImageView)localView.findViewById(2131364146));
        localView.setTag(paramView);
        if (!(paramView.pQ instanceof ThemeImageView)) {
          break label903;
        }
        ((ThemeImageView)paramView.pQ).setSupportMaskView(false);
      }
      label903:
      for (;;)
      {
        Object localObject;
        if (i < 0)
        {
          i = -(i + 1) - 1;
          localObject = (PublicAccountFragment.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
          paramView.a = ((PublicAccountFragment.a)localObject);
          paramView.uin = String.valueOf(((PublicAccountFragment.a)localObject).a.uin);
          paramView.tM.setVisibility(0);
          paramView.EG.setVisibility(8);
          paramView.rc.setVisibility(0);
          paramView.rc.setText(((PublicAccountFragment.a)localObject).a.name);
          if (((PublicAccountFragment.a)localObject).a.certifiedGrade > 0L)
          {
            if (PublicAccountFragment.this.dC == null)
            {
              PublicAccountFragment.this.dC = PublicAccountFragment.this.getResources().getDrawable(2130842599);
              PublicAccountFragment.this.dC.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0F), ImmersiveUtils.dpToPx(15.0F));
              ThemeUtil.setThemeFilter(PublicAccountFragment.this.dC, ThemeUtil.curThemeId);
            }
            paramView.rc.setCompoundDrawables(null, null, PublicAccountFragment.this.dC, null);
            label431:
            paramView.rd.setText(((PublicAccountFragment.a)localObject).a.summary);
            Bitmap localBitmap = getFaceBitmap(paramView.uin);
            paramView.pQ.setImageBitmap(localBitmap);
            boolean bool = false;
            if (((PublicAccountFragment.a)localObject).a.extendType == 2) {
              bool = jqs.c(PublicAccountFragment.c(PublicAccountFragment.this), ((PublicAccountFragment.a)localObject).a.getUin(), 1024);
            }
            if (!bool) {
              break label746;
            }
            paramView.qG.setTag(-1, ((PublicAccountFragment.a)localObject).a.getUin());
            paramView.qG.setTag(-2, ((PublicAccountFragment.a)localObject).a.name);
            paramView.qG.setOnClickListener(this.mOnClickListener);
            paramView.qG.setVisibility(0);
            label560:
            if (!bool)
            {
              paramView.qH.setTag(-1, "");
              paramView.qH.setTag(-2, "");
              paramView.qH.setOnClickListener(null);
              paramView.qH.setVisibility(4);
            }
            paramView.rb.setVisibility(8);
            paramView.fe.setVisibility(8);
            paramView.ra.setVisibility(8);
            if (AppSetting.enableTalkBack)
            {
              localObject = new StringBuilder(24);
              ((StringBuilder)localObject).append(paramView.rc.getText()).append(" 简介 ").append(paramView.rd.getText());
              localView.setContentDescription((CharSequence)localObject);
              localView.setFocusable(true);
              localView.setFocusableInTouchMode(true);
            }
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
          localObject = (PublicAccountFragment.c)paramView.getTag();
          localView = paramView;
          paramView = (View)localObject;
          break;
          paramView.rc.setCompoundDrawables(null, null, null, null);
          break label431;
          label746:
          paramView.qG.setTag(-1, "");
          paramView.qG.setTag(-2, "");
          paramView.qG.setOnClickListener(null);
          paramView.qG.setVisibility(4);
          break label560;
          paramView.a = null;
          paramView.uin = "";
          paramView.tM.setVisibility(8);
          paramView.EG.setVisibility(0);
          localObject = String.valueOf(this.k[i]);
          paramView.EG.setText((CharSequence)localObject);
          i = paramView.EG.getPaddingLeft();
          paramView.EG.setPadding(i, 0, 0, 0);
          if (AppSetting.enableTalkBack) {
            paramView.EG.setContentDescription(String.format(PublicAccountFragment.e(PublicAccountFragment.this).getString(2131692906), new Object[] { ((String)localObject).toLowerCase() }));
          }
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
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      super.onScrollStateChanged(paramAbsListView, paramInt);
      if (paramInt != 0) {
        ApngImage.pauseByTag(3);
      }
      if (paramInt == 0) {
        ApngImage.playByTag(3);
      }
    }
    
    public boolean t(int paramInt)
    {
      return Arrays.binarySearch(this.ad, paramInt) >= 0;
    }
  }
  
  static class c
    extends abeg.a
  {
    public TextView EG;
    public PublicAccountFragment.a a;
    public TextView fe;
    public ImageView qG;
    public ImageView qH;
    public TextView ra;
    public TextView rb;
    public TextView rc;
    public TextView rd;
    public View tM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment
 * JD-Core Version:    0.7.0.1
 */