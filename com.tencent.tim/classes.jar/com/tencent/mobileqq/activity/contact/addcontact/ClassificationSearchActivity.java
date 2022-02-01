package com.tencent.mobileqq.activity.contact.addcontact;

import acfp;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import aqha;
import aqju;
import auts;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.biz.lebasearch.SearchProtocol.a;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.TipsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.XListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kbp;
import lbz;
import lcc;
import lce;
import obt;
import ynm;
import ynn;
import yno;
import ynp;
import ynq;
import ynr;
import yns;
import ynt;
import ynu;
import ynv;
import ynw;
import ynx;
import yny;
import ynz;
import yof;
import yof.a;
import yow;

public class ClassificationSearchActivity
  extends SearchBaseActivity
  implements yof.a
{
  private static yow jdField_a_of_type_Yow;
  public static String aZc = "is_from";
  static String aZd = "";
  static String aZe = "";
  public static int cad = 1;
  public static int cae = 2;
  public static int caf = 3;
  public static int cag = 4;
  public static int cah = 5;
  XListView B;
  ReadInJoySearchTipsContainer.a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$a = new yno(this);
  SearchProtocol.a jdField_b_of_type_ComTencentBizLebasearchSearchProtocol$a = new yny(this);
  ReadInJoySearchTipsContainer.a jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$a = new ynn(this);
  ReadInJoySearchTipsContainer jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  boolean bnK = false;
  private TextView.OnEditorActionListener jdField_c_of_type_AndroidWidgetTextView$OnEditorActionListener = new ynx(this);
  ReadInJoySearchTipsContainer jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer;
  private View.OnClickListener ej = new ynw(this);
  private View.OnTouchListener f = new ynp(this);
  protected Handler mHandler = new ynr(this);
  public int mSource = 0;
  View mask;
  protected lce n = new ynz(this);
  View ni;
  List<ReadInJoySearchHistoryEntity> sO = new ArrayList();
  public List<SearchProtocol.WordItem> sP = new ArrayList();
  public List<ChannelInfo> sQ = new ArrayList();
  View xS;
  View xT;
  View xU;
  View xV;
  
  private void An(boolean paramBoolean)
  {
    if ((this.sQ == null) || (this.sQ.isEmpty())) {}
    do
    {
      return;
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$a);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.sQ.iterator();
      while (localIterator.hasNext())
      {
        ChannelInfo localChannelInfo = (ChannelInfo)localIterator.next();
        ReadInJoySearchTipsContainer.TipsInfo localTipsInfo = new ReadInJoySearchTipsContainer.TipsInfo();
        localTipsInfo.word = localChannelInfo.mChannelName;
        localTipsInfo.frameColor = localChannelInfo.mFrameColor;
        localTipsInfo.textColor = localChannelInfo.mFontColor;
        localArrayList.add(localTipsInfo);
      }
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.bJ(localArrayList);
    } while (!paramBoolean);
    ckd();
  }
  
  private void Ao(boolean paramBoolean)
  {
    if (this.sP == null) {}
    do
    {
      return;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer$a);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.sP.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((SearchProtocol.WordItem)localIterator.next());
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.cZ(localArrayList);
    } while (!paramBoolean);
    ckd();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, yow paramyow)
  {
    jdField_a_of_type_Yow = paramyow;
    aZe = paramIntent.getStringExtra("last_hint");
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private String cP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000000: 
      return acfp.m(2131703944);
    case 80000001: 
      return acfp.m(2131703950);
    case 80000002: 
      if (UniteSearchActivity.dCK == 12) {
        return acfp.m(2131703947) + obt.a(this.app, getApplicationContext());
      }
      return acfp.m(2131703954);
    }
    return acfp.m(2131703946);
  }
  
  private void ckc()
  {
    this.xU = LayoutInflater.from(this).inflate(2131560172, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.xU.setLayoutParams(localLayoutParams);
    this.B = ((XListView)this.xU.findViewById(2131377828));
    this.B.setOnTouchListener(this.f);
    this.xS = LayoutInflater.from(this).inflate(2131559814, null);
    this.xS.setOnTouchListener(this.f);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.xS.findViewById(2131379724));
    if ((this.mSource == cad) || (this.mSource == cag)) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer.setmMaxLines(-1);
    }
    this.ni = this.xS.findViewById(2131377830);
    this.xT = this.xS.findViewById(2131379746);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySearchTipsContainer = ((ReadInJoySearchTipsContainer)this.xS.findViewById(2131364444));
    this.xV = this.xS.findViewById(2131364443);
    this.B.addHeaderView(this.xS);
  }
  
  private void ckd()
  {
    if (((this.sP == null) || (this.sP.size() == 0)) && ((this.sQ == null) || (this.sQ.isEmpty())) && ((this.sO == null) || (this.sO.size() == 0)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.clear();
        Ap(false);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.dI(this.xU);
    if ((this.sQ == null) || (this.sQ.isEmpty()))
    {
      this.xV.setVisibility(8);
      if ((this.sP != null) && (this.sP.size() != 0)) {
        break label197;
      }
      this.xT.setVisibility(8);
      label144:
      if ((this.sO != null) && (this.sO.size() != 0)) {
        break label208;
      }
      this.ni.setVisibility(8);
    }
    for (;;)
    {
      this.B.setSelection(0);
      Ap(true);
      return;
      this.xV.setVisibility(0);
      break;
      label197:
      this.xT.setVisibility(0);
      break label144;
      label208:
      this.ni.setVisibility(0);
    }
  }
  
  private void oS(String paramString)
  {
    paramString = paramString.trim();
    try
    {
      localObject = URLEncoder.encode(paramString, "utf-8");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        continue;
        paramString = localUnsupportedEncodingException;
      }
    }
    localObject = obt.Yd;
    if (localObject != null)
    {
      if (!((String)localObject).contains("keyword")) {}
    }
    else {
      for (paramString = ((String)localObject).replace("keyword", paramString);; paramString = "https://so.mp.qq.com/search/index?key=" + paramString + "&_wv=3&_bid=2321")
      {
        localObject = new Intent(this, PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("url", paramString);
        startActivity((Intent)localObject);
        return;
      }
    }
  }
  
  public void Ap(boolean paramBoolean)
  {
    if (ThemeUtil.isInNightMode(this.app))
    {
      if (!paramBoolean) {
        break label89;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.hu.setBackgroundColor(-1);
      if (this.mask != null) {
        ((ViewGroup)this.mask.getParent()).removeView(this.mask);
      }
      this.mask = new View(this);
      this.mask.setBackgroundColor(1996488704);
      addContentView(this.mask, new ViewGroup.LayoutParams(-1, -1));
    }
    label89:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.hu != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.hu.setBackgroundColor(0);
      }
    } while (this.mask == null);
    this.mask.setVisibility(8);
  }
  
  protected void Ie()
  {
    super.Ie();
    Intent localIntent = getIntent();
    if (localIntent.hasExtra(aZc)) {
      this.mSource = localIntent.getIntExtra(aZc, 0);
    }
  }
  
  protected SearchBaseFragment a()
  {
    if ((jdField_a_of_type_Yow == null) && ((this.mSource == cad) || (this.mSource == cag) || (this.mSource == cah) || (this.mSource == cae) || (this.mSource == caf))) {
      return ClassificationSearchFragment.a(this.mSource);
    }
    return ClassificationSearchFragment.a(jdField_a_of_type_Yow);
  }
  
  public void a(ReadInJoySearchHistoryEntity paramReadInJoySearchHistoryEntity)
  {
    if (this.mSource == cad)
    {
      this.aN.setText(paramReadInJoySearchHistoryEntity.keyWord);
      if (!TextUtils.isEmpty(paramReadInJoySearchHistoryEntity.keyWord)) {
        this.aN.setSelection(this.aN.getText().length());
      }
      oS(paramReadInJoySearchHistoryEntity.keyWord);
      kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006819", "0X8006819", 0, 0, paramReadInJoySearchHistoryEntity.keyWord, "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.bc(paramReadInJoySearchHistoryEntity.keyWord, false);
  }
  
  public void aa(List<ReadInJoySearchHistoryEntity> paramList, boolean paramBoolean)
  {
    this.sO = paramList;
    if (paramBoolean) {
      ckd();
    }
    if (this.B.getAdapter() == null)
    {
      paramList = new yof(this, paramList, this);
      this.B.setAdapter(paramList);
    }
    yof localyof;
    do
    {
      return;
      if (!(this.B.getAdapter() instanceof auts)) {
        break;
      }
      localyof = (yof)((auts)this.B.getAdapter()).getWrappedAdapter();
    } while (localyof == null);
    localyof.bJ(paramList);
    return;
    ((yof)this.B.getAdapter()).bJ(paramList);
  }
  
  public void bcr()
  {
    ThreadManager.post(new ClassificationSearchActivity.14(this), 10, null, true);
  }
  
  public void bcs()
  {
    aqju localaqju = aqha.a(this, 230);
    Object localObject = new ynq(this);
    localaqju.setPositiveButton(2131698203, (DialogInterface.OnClickListener)localObject);
    localaqju.setNegativeButton(2131698202, (DialogInterface.OnClickListener)localObject);
    localObject = getString(2131698204);
    localaqju.setTitle(2131699480);
    TextView localTextView = new TextView(this);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getResources().getColor(2131165625));
    localTextView.setText((CharSequence)localObject);
    localTextView.setGravity(1);
    localaqju.addView(localTextView);
    localaqju.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.aN.setText(this.aZi);
    if (!TextUtils.isEmpty(this.aZi))
    {
      this.aN.requestFocus();
      this.aN.setSelection(this.aN.getText().length());
    }
    this.bnK = true;
    if (this.mSource == cad)
    {
      bcr();
      SearchProtocol.a(this.app, this, this.jdField_b_of_type_ComTencentBizLebasearchSearchProtocol$a);
      lcc.a().b(this.n);
      if (lbz.a().on() == 0) {
        lbz.a().cE(1, 1);
      }
    }
    while (this.mSource != cag) {
      return bool;
    }
    aa(null, true);
    SearchProtocol.a(this.app, this, this.jdField_b_of_type_ComTencentBizLebasearchSearchProtocol$a);
    return bool;
  }
  
  public void doOnDestroy()
  {
    lcc.a().c(this.n);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.mSource == cad) || (this.mSource == cag) || (this.mSource == cah)) {
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).Aq(true);
    }
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).Uc())
    {
      Looper.myQueue().addIdleHandler(new ynm(this));
      ((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).Aq(false);
    }
    if (this.mSource == cad)
    {
      if (TextUtils.isEmpty(aZe)) {
        break label313;
      }
      this.aN.setEllipsize(TextUtils.TruncateAt.END);
      this.aN.setHint(aZe);
    }
    for (;;)
    {
      ckd();
      if (this.mSource == cag)
      {
        this.aN.setHint(acfp.m(2131703949));
        ckd();
      }
      if (this.mSource == cae)
      {
        this.aN.setHint(acfp.m(2131703940));
        ckd();
        if ((!TextUtils.isEmpty(aZd)) && (this.bnK)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.bc(aZd, false);
        }
      }
      if (this.mSource == caf)
      {
        this.uo.setVisibility(8);
        if (this.aN.getText().toString().equals("")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.clear();
        }
        this.aN.setHint(acfp.m(2131703941));
      }
      if (this.mSource == cah)
      {
        if (this.aN.getText().toString().equals("")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.clear();
        }
        this.aN.setHint(acfp.m(2131703945));
      }
      return;
      label313:
      if (!TextUtils.isEmpty(""))
      {
        this.aN.setEllipsize(TextUtils.TruncateAt.END);
        this.aN.setHint("");
      }
      else
      {
        this.aN.setHint(acfp.m(2131703958));
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (((ClassificationSearchFragment)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).Uc()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.clear();
    }
    this.bnK = false;
  }
  
  protected void initViews()
  {
    super.initViews();
    if (jdField_a_of_type_Yow != null)
    {
      String str = cP(jdField_a_of_type_Yow.resultType);
      this.aN.setHint(str);
    }
    this.aN.addTextChangedListener(new yns(this));
    this.aN.setOnEditorActionListener(this.jdField_c_of_type_AndroidWidgetTextView$OnEditorActionListener);
    this.uo.setOnClickListener(new ynt(this));
    this.eg.setOnClickListener(this.ej);
    if (AppSetting.enableTalkBack) {
      this.aN.setContentDescription(acfp.m(2131703951) + this.aZi);
    }
    this.ap.setOnClickListener(new ynu(this));
    if ((this.mSource == cad) || (this.mSource == cag))
    {
      ckc();
      Looper.myQueue().addIdleHandler(new ynv(this));
    }
  }
  
  public void oR(String paramString)
  {
    ThreadManager.post(new ClassificationSearchActivity.13(this, paramString), 10, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity
 * JD-Core Version:    0.7.0.1
 */