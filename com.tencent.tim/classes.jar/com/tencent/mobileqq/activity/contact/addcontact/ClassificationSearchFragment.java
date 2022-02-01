package com.tencent.mobileqq.activity.contact.addcontact;

import aajx;
import acfp;
import amxk;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import aqft;
import aqhu;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kbp;
import kbq;
import kbq.a;
import kbq.c;
import obg;
import obt;
import wja;
import yoa;
import yob;
import yow;

public class ClassificationSearchFragment
  extends SearchBaseFragment
{
  private static yow jdField_a_of_type_Yow;
  private static int mIsFrom;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a;
  private c jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c;
  private boolean bnL;
  boolean bnM;
  int cai = 0;
  int caj = 0;
  private int fromType;
  private int mSearchType;
  private List<AccountSearchPb.record> pr = new ArrayList(20);
  private View rM;
  private View xW;
  
  private boolean B(ArrayList<yow> paramArrayList)
  {
    if ((!this.bnO) && (paramArrayList != null) && (paramArrayList.size() == 1))
    {
      Object localObject = ((yow)paramArrayList.get(0)).sS;
      if ((localObject != null) && (((List)localObject).size() == 1))
      {
        localObject = (AccountSearchPb.record)((List)localObject).get(0);
        a(((yow)paramArrayList.get(0)).resultType, (AccountSearchPb.record)localObject, 2);
        return true;
      }
    }
    return false;
  }
  
  private void Ek(int paramInt)
  {
    this.cai = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c.notifyDataSetChanged();
    }
  }
  
  public static ClassificationSearchFragment a(int paramInt)
  {
    mIsFrom = paramInt;
    return new ClassificationSearchFragment();
  }
  
  public static ClassificationSearchFragment a(yow paramyow)
  {
    jdField_a_of_type_Yow = paramyow;
    return new ClassificationSearchFragment();
  }
  
  private String a(SearchBaseFragment.b paramb, AccountSearchPb.record paramrecord)
  {
    int j = 11;
    StringBuilder localStringBuilder = new StringBuilder();
    paramb.uin = (paramrecord.uin.get() + "");
    paramb.aPj = paramrecord.mobile.get();
    boolean bool;
    Object localObject2;
    Object localObject1;
    label148:
    label304:
    int i;
    if (paramrecord.uin.get() != 0L)
    {
      bool = true;
      paramb.bnQ = bool;
      paramb.FB.setText(a(paramb.dataType, paramrecord.name.get()));
      localStringBuilder.append(paramb.FB.getText());
      if (paramb.dataType == 80000000)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append("(");
        if (!paramb.bnQ) {
          break label426;
        }
        localObject1 = paramb.uin;
        ((SpannableStringBuilder)localObject2).append(a(80000000, (String)localObject1));
        ((SpannableStringBuilder)localObject2).append(")");
        paramb.KU.setText((CharSequence)localObject2);
        if ((TextUtils.isEmpty(paramb.uin)) || (!aqft.rj(paramb.uin))) {
          break label435;
        }
        localObject1 = this.app.getApp().getResources();
        localObject2 = ((Resources)localObject1).getDrawable(2130842599);
        ((Drawable)localObject2).setBounds(0, 0, wja.dp2px(15.0F, (Resources)localObject1), wja.dp2px(15.0F, (Resources)localObject1));
        ThemeUtil.setThemeFilter((Drawable)localObject2, ThemeUtil.curThemeId);
        paramb.KU.setCompoundDrawables(null, null, (Drawable)localObject2, null);
        label261:
        localStringBuilder.append(paramb.KU.getText());
      }
      switch (this.mFrom)
      {
      case 1: 
      default: 
        localObject1 = this.d;
        if (paramb.bnQ)
        {
          i = 1;
          label319:
          if (!paramb.bnQ) {
            break label485;
          }
          paramrecord = paramb.uin;
          label331:
          localObject1 = ((aqdf)localObject1).b(i, paramrecord);
          paramrecord = (AccountSearchPb.record)localObject1;
          if (localObject1 == null)
          {
            localObject1 = aqhu.G();
            if (!this.d.isPausing())
            {
              localObject2 = this.d;
              if (!paramb.bnQ) {
                break label493;
              }
            }
          }
        }
        break;
      }
    }
    label426:
    label435:
    label485:
    label493:
    for (paramrecord = paramb.uin;; paramrecord = paramb.aPj)
    {
      i = j;
      if (paramb.bnQ) {
        i = 1;
      }
      ((aqdf)localObject2).a(paramrecord, i, true, (byte)1);
      paramrecord = (AccountSearchPb.record)localObject1;
      paramb.pV.setImageBitmap(paramrecord);
      return localStringBuilder.toString();
      bool = false;
      break;
      localObject1 = paramb.aPj;
      break label148;
      paramb.KU.setCompoundDrawables(null, null, null, null);
      break label261;
      localStringBuilder.append(b(paramb, paramrecord));
      break label304;
      localStringBuilder.append(c(paramb, paramrecord));
      break label304;
      i = 11;
      break label319;
      paramrecord = paramb.aPj;
      break label331;
    }
  }
  
  protected boolean A(ArrayList<yow> paramArrayList)
  {
    yow localyow = (yow)paramArrayList.get(0);
    if (B(paramArrayList))
    {
      this.bnL = true;
      return false;
    }
    if (this.uiHandler != null) {
      this.uiHandler.post(new ClassificationSearchFragment.1(this, localyow));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClassificationSearchFragment", 2, "is no more page  = " + localyow.bnV);
    }
    this.pr = localyow.sS;
    if (!this.bnO) {
      cki();
    }
    dc(paramArrayList);
    return true;
  }
  
  public void Aq(boolean paramBoolean)
  {
    this.bnL = paramBoolean;
  }
  
  public boolean Uc()
  {
    return this.bnL;
  }
  
  public void bc(String paramString, boolean paramBoolean)
  {
    this.bnO = paramBoolean;
    if (this.bnO) {
      if (UniteSearchActivity.dCK == 12) {
        this.jdField_a_of_type_Yob.a(this.aZi, this.mSearchType, 0.0D, 0.0D, 1);
      }
    }
    for (;;)
    {
      if (this.mFrom == 2)
      {
        paramString = getActivity();
        if ((paramString != null) && ((paramString instanceof SearchBaseActivity)))
        {
          int i = ((SearchBaseActivity)paramString).xj();
          int j = this.jdField_a_of_type_Yob.xh();
          kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "" + (j + 1), SearchBaseActivity.a.cQ(i), this.aZi, "", false);
        }
      }
      return;
      if (mIsFrom == ClassificationSearchActivity.cad)
      {
        this.jdField_a_of_type_Yob.a(this.aZi, this.mSearchType, 0.0D, 0.0D, 2);
      }
      else
      {
        this.jdField_a_of_type_Yob.a(this.aZi, this.mSearchType, 0.0D, 0.0D, 0);
        continue;
        if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
        {
          Sa();
          this.aZi = paramString;
          this.jdField_a_of_type_Yob.ckh();
          if (UniteSearchActivity.dCK == 12) {
            this.jdField_a_of_type_Yob.a(this.aZi, this.mSearchType, 0.0D, 0.0D, 1);
          }
          for (;;)
          {
            this.bnP = true;
            break;
            if (mIsFrom == ClassificationSearchActivity.cad) {
              this.jdField_a_of_type_Yob.a(this.aZi, this.mSearchType, 0.0D, 0.0D, 2);
            } else {
              this.jdField_a_of_type_Yob.a(this.aZi, this.mSearchType, 0.0D, 0.0D, 0);
            }
          }
        }
        QQToast.a(BaseApplicationImpl.getContext(), 2131696272, 0).show(getTitleBarHeight());
        Ek(4);
      }
    }
  }
  
  void cke()
  {
    if (this.cai == 1)
    {
      Ek(2);
      bc(this.aZi, true);
    }
  }
  
  protected void ckf()
  {
    if (this.cai == 2) {
      Ek(0);
    }
  }
  
  @TargetApi(9)
  public void clear()
  {
    super.clear();
    Object localObject;
    if ((this.hu != null) && (this.mFrom == 2))
    {
      if (this.xW == null)
      {
        this.xW = LayoutInflater.from(getActivity()).inflate(2131559836, null);
        localObject = (GridView)this.xW.findViewById(2131377826);
        if (Build.VERSION.SDK_INT > 8) {
          ((GridView)localObject).setOverScrollMode(2);
        }
        ((GridView)localObject).setNumColumns(4);
        ((GridView)localObject).setStretchMode(2);
        ((GridView)localObject).setVerticalSpacing(wja.dp2px(20.0F, getResources()));
        ((GridView)localObject).setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a);
      }
      this.hu.addView(this.xW);
      this.hu.setClickable(false);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a.getCount() <= 0)) {
        break label241;
      }
      this.xW.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a.pO();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label221;
      }
      ((TextView)this.xW.findViewById(2131377830)).setText(getString(2131697464));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a.getList() != null) && (!a.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a.refreshData(false);
      }
      return;
      label221:
      ((TextView)this.xW.findViewById(2131377830)).setText((CharSequence)localObject);
      continue;
      label241:
      this.xW.setVisibility(8);
    }
  }
  
  public void nA(int paramInt)
  {
    this.fromType = paramInt;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    AccountSearchPb.record localrecord;
    String str;
    Object localObject3;
    if (localObject1 != null)
    {
      if (!(localObject1 instanceof SearchBaseFragment.b)) {
        break label498;
      }
      localObject2 = (SearchBaseFragment.b)localObject1;
      a(((SearchBaseFragment.b)localObject2).dataType, ((SearchBaseFragment.b)localObject2).b, 2);
      int i = ((SearchBaseFragment.b)localObject2).cao;
      int j = ((SearchBaseFragment.b)localObject2).dataType;
      int k = ((SearchBaseFragment.b)localObject2).cao;
      if (((SearchBaseFragment.b)localObject2).b.uin == null) {
        break label373;
      }
      localObject1 = ((SearchBaseFragment.b)localObject2).b.uin.get() + "";
      amxk.a(j, 0, k, false, (String)localObject1, this.aZi, UniteSearchActivity.dCK);
      if (((SearchBaseFragment.b)localObject2).dataType == 80000002)
      {
        localrecord = ((SearchBaseFragment.b)localObject2).b;
        localObject1 = getActivity();
        if ((localObject1 != null) && ((localObject1 instanceof ClassificationSearchActivity)))
        {
          str = SearchBaseActivity.a.cQ(((SearchBaseActivity)localObject1).xj());
          localObject1 = paramView.getTag(2131371124);
          if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
            ((SearchBaseFragment.b)localObject2).cao = (((Integer)localObject1).intValue() + 1);
          }
          localObject3 = obg.a();
          if (localrecord.uin == null) {
            break label379;
          }
          localObject1 = localrecord.uin.get() + "";
          label247:
          ((obg)localObject3).a(3, (String)localObject1, i, UniteSearchActivity.dCK);
          if (UniteSearchActivity.dCK != 12) {
            break label393;
          }
          localObject3 = this.app;
          localObject2 = ((SearchBaseFragment.b)localObject2).cao + "";
          if (localrecord.uin == null) {
            break label386;
          }
          localObject1 = localrecord.uin.get() + "";
          label334:
          anot.b((QQAppInterface)localObject3, "CliOper", "", "", "0X800658B", "0X800658B", 0, 1, 0, (String)localObject2, str, (String)localObject1, this.aZi);
        }
      }
    }
    label386:
    label393:
    label812:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label373:
      localObject1 = null;
      break;
      label379:
      localObject1 = "";
      break label247;
      localObject1 = "";
      break label334;
      localObject3 = this.app;
      if (localrecord.uin != null) {}
      for (localObject1 = localrecord.uin.get() + "";; localObject1 = "")
      {
        kbp.a((QQAppInterface)localObject3, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D22", "0X8005D22", 0, 0, ((SearchBaseFragment.b)localObject2).cao + "", str, this.aZi, "", false);
        break;
      }
      label498:
      if ((localObject1 instanceof b))
      {
        if ((this.cai == 3) || (this.cai == 4)) {
          if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
          {
            Ek(1);
          }
          else
          {
            QQToast.a(BaseApplicationImpl.getContext(), 2131696272, 0).show(getTitleBarHeight());
            Ek(4);
          }
        }
      }
      else if ((localObject1 instanceof SearchBaseFragment.a))
      {
        localObject1 = (SearchBaseFragment.a)localObject1;
        localObject2 = new Intent(this.h, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", ((SearchBaseFragment.a)localObject1).url);
        if (UniteSearchActivity.dCK == 1) {
          ((Intent)localObject2).putExtra("articalChannelId", 10);
        }
        for (;;)
        {
          this.h.startActivity((Intent)localObject2);
          if (UniteSearchActivity.dCK != 12) {
            break label812;
          }
          anot.a(this.app, "CliOper", "", "", "0X800658C", "0X800658C", 0, 0, "" + ((SearchBaseFragment.a)localObject1).num, "", this.aZi, "" + ((SearchBaseFragment.a)localObject1).rX);
          break;
          if (UniteSearchActivity.dCK == 2) {
            ((Intent)localObject2).putExtra("articalChannelId", 11);
          } else if (this.fromType == 14) {
            ((Intent)localObject2).putExtra("articalChannelId", 14);
          } else if (this.fromType == 13) {
            ((Intent)localObject2).putExtra("articalChannelId", 12);
          } else if (this.fromType == 15) {
            ((Intent)localObject2).putExtra("articalChannelId", 13);
          }
        }
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D97", "0X8005D97", 0, 0, "" + ((SearchBaseFragment.a)localObject1).num, "", this.aZi, "" + ((SearchBaseFragment.a)localObject1).rX, false);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.rM == null)
    {
      this.rM = d().getLayoutInflater().inflate(2131559418, this.mListView, false);
      this.rM.setClickable(false);
      this.rM.setFocusable(true);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a.onDestroy();
    }
    obg.a().bdd();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (jdField_a_of_type_Yow != null)
    {
      int i;
      if (!jdField_a_of_type_Yow.bnV)
      {
        i = 1;
        Ek(i);
        this.pr.addAll(jdField_a_of_type_Yow.sS);
        this.jdField_a_of_type_Yob.El(jdField_a_of_type_Yow.cak);
        if (ViewFactory.fv(jdField_a_of_type_Yow.resultType) != 2131689920) {
          break label192;
        }
        ((TextView)this.rM.findViewById(2131379769)).setText(obt.a(this.app, BaseApplicationImpl.getContext()));
      }
      for (;;)
      {
        if ((this.id.size() == 0) && (this.pr.size() > 0))
        {
          paramView = new ArrayList();
          paramView.add(jdField_a_of_type_Yow);
          dc(paramView);
        }
        jdField_a_of_type_Yow = null;
        refreshList();
        this.mSearchType = getSearchType();
        if ((this.mFrom == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a == null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$a = new a();
        }
        return;
        i = 0;
        break;
        label192:
        ((TextView)this.rM.findViewById(2131379769)).setText(ViewFactory.fv(jdField_a_of_type_Yow.resultType));
      }
    }
    if ((mIsFrom == ClassificationSearchActivity.cad) || (mIsFrom == ClassificationSearchActivity.cae)) {
      ((TextView)this.rM.findViewById(2131379769)).setText(ViewFactory.fv(80000003));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchFragment", 2, "searchResult is null");
      }
      showEmptyView();
      break;
      if ((mIsFrom == ClassificationSearchActivity.caf) || (mIsFrom == ClassificationSearchActivity.cah)) {
        ((TextView)this.rM.findViewById(2131379769)).setText(ViewFactory.fv(80000002));
      }
    }
  }
  
  protected void refreshList()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("isGetMore = ").append(this.bnO).append(" mListData is null = ");
      if (this.pr != null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ClassificationSearchFragment", 2, bool);
      if ((this.bnO) || (this.pr != null)) {
        break;
      }
      showEmptyView();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c = new c(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c.setData(this.pr);
      localObject2 = this.rM;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.mFrom == 0)
      {
        localObject1 = acfp.m(2131703953);
        label141:
        ((View)localObject2).setContentDescription((String)localObject1 + acfp.m(2131703955));
        this.mListView.addHeaderView(this.rM);
        this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c);
        this.mAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c;
      }
    }
    else
    {
      if (this.hu.getChildAt(0) != this.mListView)
      {
        this.hu.removeAllViews();
        this.hu.addView(this.mListView);
      }
      if (!this.bnO) {
        break label371;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c.getData().addAll(this.pr);
    }
    int i;
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c.notifyDataSetChanged();
      if (this.bnP)
      {
        this.bnP = false;
        this.mListView.setSelection(0);
      }
      if ((this.mFrom != 2) || (this.pr == null)) {
        break;
      }
      localObject1 = new StringBuilder();
      localObject2 = this.pr.iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(String.valueOf(((AccountSearchPb.record)((Iterator)localObject2).next()).uin.get())).append("#");
        i += 1;
      }
      localObject1 = acfp.m(2131703959);
      break label141;
      label371:
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment$c.setData(this.pr);
    }
    Object localObject2 = obg.a().aa(this.app.getCurrentAccountUin(), this.aZi);
    obg.a().a((String)localObject2, this.aZi, 3, true, i, ((StringBuilder)localObject1).toString());
  }
  
  protected void uQ(String paramString)
  {
    super.uQ(paramString);
    Ek(3);
  }
  
  public class a
    extends BaseAdapter
    implements aqdf.a, kbq.a
  {
    private String VY;
    private boolean bnN;
    private ArrayList<kbq.c> jJ;
    private aajx mFaceDecoder = new aajx(ClassificationSearchFragment.this.app, this, false);
    private View.OnClickListener x = new yoa(this);
    
    public a()
    {
      refreshData(true);
    }
    
    public void b(ArrayList<kbq.c> paramArrayList, String paramString, boolean paramBoolean)
    {
      this.jJ = paramArrayList;
      this.VY = paramString;
      this.bnN = paramBoolean;
      if (ClassificationSearchFragment.a(ClassificationSearchFragment.this) != null)
      {
        if (getCount() == 0)
        {
          ((TextView)ClassificationSearchFragment.a(ClassificationSearchFragment.this).findViewById(2131377830)).setText(acfp.m(2131703938));
          ClassificationSearchFragment.a(ClassificationSearchFragment.this).setVisibility(8);
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        paramString = new StringBuilder("onGetRecommendSuccess->isFromRecommend:" + paramBoolean + ", title:" + paramString + ", list:");
        if (paramArrayList != null) {
          break label271;
        }
        paramString.append("null");
      }
      for (;;)
      {
        QLog.d("ClassificationSearchFragment", 2, paramString.toString());
        if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
          return;
        }
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramString = (kbq.c)paramArrayList.next();
          QLog.d("ClassificationSearchFragment", 2, "onGetRecommendSuccess->" + paramString.toString());
        }
        if (TextUtils.isEmpty(paramString)) {
          ((TextView)ClassificationSearchFragment.a(ClassificationSearchFragment.this).findViewById(2131377830)).setText(acfp.m(2131703943));
        }
        for (;;)
        {
          ClassificationSearchFragment.a(ClassificationSearchFragment.this).setVisibility(0);
          notifyDataSetChanged();
          break;
          ((TextView)ClassificationSearchFragment.a(ClassificationSearchFragment.this).findViewById(2131377830)).setText(paramString);
        }
        label271:
        paramString.append("size:").append(paramArrayList.size());
      }
    }
    
    public int getCount()
    {
      if (this.jJ == null) {
        return 0;
      }
      return this.jJ.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((this.jJ == null) || (paramInt >= this.jJ.size())) {
        return null;
      }
      return this.jJ.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public ArrayList<kbq.c> getList()
    {
      return this.jJ;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = LayoutInflater.from(ClassificationSearchFragment.this.getActivity()).inflate(2131559837, null);
      }
      for (;;)
      {
        kbq.c localc = (kbq.c)getItem(paramInt);
        if (localc != null)
        {
          if (this.mFaceDecoder != null)
          {
            Drawable localDrawable = this.mFaceDecoder.a(1008, localc.mUin);
            ((URLImageView)paramView.findViewById(2131368375)).setImageDrawable(localDrawable);
          }
          ((TextView)paramView.findViewById(2131372190)).setText(localc.mName);
          paramView.findViewById(2131365322).setOnClickListener(this.x);
          paramView.findViewById(2131365322).setTag(localc);
          paramView.setTag(localc);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
    
    public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
    {
      if ((ClassificationSearchFragment.a(ClassificationSearchFragment.this) == null) || (TextUtils.isEmpty(paramString))) {}
      for (;;)
      {
        return;
        if (((paramBitmap != null) || (paramInt1 <= 0)) && (paramBitmap != null))
        {
          GridView localGridView = (GridView)ClassificationSearchFragment.a(ClassificationSearchFragment.this).findViewById(2131377826);
          paramInt2 = localGridView.getChildCount();
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            View localView = localGridView.getChildAt(paramInt1);
            if (paramString.equals(((kbq.c)localView.getTag()).mUin)) {
              ((URLImageView)localView.findViewById(2131368375)).setImageBitmap(paramBitmap);
            }
            paramInt1 += 1;
          }
        }
      }
    }
    
    public void onDestroy()
    {
      if (this.mFaceDecoder != null) {
        this.mFaceDecoder.onDestory();
      }
    }
    
    public String pO()
    {
      return this.VY;
    }
    
    public void refreshData(boolean paramBoolean)
    {
      kbq.a().a(ClassificationSearchFragment.this.app, paramBoolean, this);
    }
  }
  
  static class b
  {
    public ProgressBar R;
    public TextView loadingTv;
  }
  
  class c
    extends BaseAdapter
  {
    private List<AccountSearchPb.record> itemList;
    
    private c() {}
    
    public int getCount()
    {
      int j = this.itemList.size();
      if (ClassificationSearchFragment.this.cai != 0) {}
      for (int i = 1;; i = 0) {
        return i + j;
      }
    }
    
    public List<AccountSearchPb.record> getData()
    {
      return this.itemList;
    }
    
    public Object getItem(int paramInt)
    {
      return this.itemList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt < this.itemList.size())
      {
        if (((AccountSearchPb.record)this.itemList.get(paramInt)).account_id.has()) {
          return 2;
        }
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      switch (getItemViewType(paramInt))
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        View localView = paramView;
        if (paramView == null)
        {
          paramView = ClassificationSearchFragment.this.d().getLayoutInflater().inflate(2131561150, paramViewGroup, false);
          paramView.setOnClickListener(ClassificationSearchFragment.this);
          localObject1 = new SearchBaseFragment.b();
          ((SearchBaseFragment.b)localObject1).pV = ((ImageView)paramView.findViewById(2131368406));
          ((SearchBaseFragment.b)localObject1).FB = ((TextView)paramView.findViewById(2131372383));
          ((SearchBaseFragment.b)localObject1).KU = ((TextView)paramView.findViewById(2131381223));
          ((SearchBaseFragment.b)localObject1).KV = ((TextView)paramView.findViewById(2131365744));
          ((SearchBaseFragment.b)localObject1).KW = ((TextView)paramView.findViewById(2131370826));
          ((SearchBaseFragment.b)localObject1).b = ((AccountSearchPb.record)getItem(paramInt));
          ((SearchBaseFragment.b)localObject1).dataType = ClassificationSearchFragment.a(ClassificationSearchFragment.this);
          paramView.setTag(2131371124, Integer.valueOf(paramInt));
          paramView.setTag(localObject1);
          localView = paramView;
          if ((((SearchBaseFragment.b)localObject1).pV instanceof ThemeImageView))
          {
            ((ThemeImageView)((SearchBaseFragment.b)localObject1).pV).setSupportMaskView(false);
            localView = paramView;
          }
        }
        paramView = (SearchBaseFragment.b)localView.getTag();
        paramView.b = ((AccountSearchPb.record)getItem(paramInt));
        paramView.cao = (paramInt + 1);
        Object localObject1 = ClassificationSearchFragment.a(ClassificationSearchFragment.this, paramView, (AccountSearchPb.record)this.itemList.get(paramInt));
        paramView = localView;
        if (AppSetting.enableTalkBack)
        {
          localView.setContentDescription((CharSequence)localObject1);
          paramView = localView;
          continue;
          localObject1 = (AccountSearchPb.record)this.itemList.get(paramInt);
          localView = paramView;
          if (paramView == null)
          {
            localView = ClassificationSearchFragment.this.d().getLayoutInflater().inflate(2131561648, null);
            paramView = new SearchBaseFragment.a();
            paramView.pV = ((ImageView)localView.findViewById(2131368406));
            paramView.FB = ((TextView)localView.findViewById(2131372383));
            paramView.KS = ((TextView)localView.findViewById(2131379699));
            paramView.KT = ((TextView)localView.findViewById(2131363121));
            paramView.KR = ((TextView)localView.findViewById(2131363720));
            paramView.rX = ((AccountSearchPb.record)localObject1).account_id.get();
            localView.setOnClickListener(ClassificationSearchFragment.this);
            localView.setTag(paramView);
          }
          paramView = (SearchBaseFragment.a)localView.getTag();
          paramView.KS.setText(((AccountSearchPb.record)localObject1).article_create_time.get());
          if ((((AccountSearchPb.record)localObject1).article_author.has()) && (!"".equals(((AccountSearchPb.record)localObject1).article_author.get()))) {
            paramView.KT.setText(((AccountSearchPb.record)localObject1).article_author.get());
          }
          int i = ClassificationSearchFragment.this.getResources().getDimensionPixelSize(2131297863);
          if (!TextUtils.isEmpty(((AccountSearchPb.record)localObject1).title_image.get())) {}
          try
          {
            Object localObject2 = URLDrawable.getDrawable(((AccountSearchPb.record)localObject1).title_image.get(), i, i);
            paramView.pV.setImageDrawable((Drawable)localObject2);
            paramView.url = ((AccountSearchPb.record)localObject1).article_short_url.get();
            if (((AccountSearchPb.record)localObject1).name.has()) {
              paramView.FB.setText(ClassificationSearchFragment.this.a(80000003, ((AccountSearchPb.record)localObject1).name.get()));
            }
            if ((((AccountSearchPb.record)localObject1).brief.has()) && (!"".equals(((AccountSearchPb.record)localObject1).brief.get()))) {
              if (ClassificationSearchFragment.this.a(paramView.FB, ClassificationSearchFragment.this.d()) > 1)
              {
                paramView.KR.setMaxLines(1);
                paramView.KR.setVisibility(0);
                paramView.KR.setEllipsize(TextUtils.TruncateAt.END);
                localObject2 = ClassificationSearchFragment.this.a(80000003, ((AccountSearchPb.record)localObject1).brief.get());
                if (QLog.isColorLevel()) {
                  QLog.d("ClassificationSearchFragment", 2, "brief = " + localObject2);
                }
                paramView.KR.setText((CharSequence)localObject2);
                localView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(110.0F, ClassificationSearchFragment.this.d().getResources()))));
                localObject2 = (ImageView)localView.findViewById(2131382126);
                ((ImageView)localObject2).setVisibility(4);
                ImageView localImageView = (ImageView)localView.findViewById(2131365477);
                localImageView.setVisibility(4);
                if ((((AccountSearchPb.record)localObject1).video_article.has()) && (((AccountSearchPb.record)localObject1).video_article.get() == 11))
                {
                  ((ImageView)localObject2).setVisibility(0);
                  localImageView.getBackground().setAlpha(25);
                  localImageView.setVisibility(0);
                }
                paramView.num = (paramInt + 1);
                paramView = localView;
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ClassificationSearchFragment", 1, "classification urldrawable error:" + localException.toString());
              continue;
              paramView.KR.setMaxLines(2);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("ClassificationSearchFragment", 2, "brief = gone");
              }
              paramView.KR.setVisibility(8);
              localView.setLayoutParams(new AbsListView.LayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(90.0F, ClassificationSearchFragment.this.d().getResources()))));
            }
          }
          localView = paramView;
          if (paramView == null)
          {
            localView = ClassificationSearchFragment.this.d().getLayoutInflater().inflate(2131559672, null);
            localView.setOnClickListener(ClassificationSearchFragment.this);
            paramView = new ClassificationSearchFragment.b();
            localView.setTag(paramView);
            paramView.R = ((ProgressBar)localView.findViewById(2131377037));
            localView.findViewById(2131370781).setVisibility(8);
            paramView.loadingTv = ((TextView)localView.findViewById(2131371975));
          }
          ClassificationSearchFragment.this.cke();
          localObject1 = (ClassificationSearchFragment.b)localView.getTag();
          if (ClassificationSearchFragment.this.cai == 3)
          {
            if (!ClassificationSearchFragment.this.bnM)
            {
              ClassificationSearchFragment.this.bnM = true;
              ((ClassificationSearchFragment.b)localObject1).R.setVisibility(8);
              ((ClassificationSearchFragment.b)localObject1).loadingTv.setText(acfp.m(2131703939));
              paramView = localView;
            }
            else
            {
              paramView = localView;
              if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
              {
                ClassificationSearchFragment.this.bnM = false;
                ((ClassificationSearchFragment.b)localObject1).R.setVisibility(0);
                ((ClassificationSearchFragment.b)localObject1).loadingTv.setText(acfp.m(2131703948));
                ClassificationSearchFragment.this.bc(ClassificationSearchFragment.this.aZi, true);
                paramView = localView;
              }
            }
          }
          else if (ClassificationSearchFragment.this.cai == 2)
          {
            ((ClassificationSearchFragment.b)localObject1).R.setVisibility(0);
            ((ClassificationSearchFragment.b)localObject1).loadingTv.setText(acfp.m(2131703956));
            paramView = localView;
          }
          else
          {
            paramView = localView;
            if (ClassificationSearchFragment.this.cai == 4)
            {
              ((ClassificationSearchFragment.b)localObject1).R.setVisibility(8);
              ((ClassificationSearchFragment.b)localObject1).loadingTv.setText(acfp.m(2131703952));
              paramView = localView;
            }
          }
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
    
    public void setData(List<AccountSearchPb.record> paramList)
    {
      this.itemList = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment
 * JD-Core Version:    0.7.0.1
 */