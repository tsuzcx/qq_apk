package com.tencent.mobileqq.activity.contact.addcontact;

import abeg;
import acfp;
import achg;
import amxg;
import amxk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aozz.a;
import apuh;
import aqdf;
import aqft;
import aqhu;
import aqiw;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView;
import com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.ResultItem;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import joa;
import kbp;
import obg;
import obt;
import wja;
import yob;
import yor;
import yos;
import yot;
import you;
import yov;
import yow;
import yqm;
import yvg;
import yvj;

public class SearchContactsFragment
  extends SearchBaseFragment
{
  private static int fromType = -1;
  a jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$a;
  private c jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c;
  private ViewFactory.GuideView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView;
  GroupSearchRecommendView.a jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$a = new yos(this);
  private GroupSearchRecommendView jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView;
  private yvg jdField_a_of_type_Yvg;
  private ArrayList<yow> aQ;
  private String aZj = "";
  private String aZk = "";
  private String aZl;
  private String avs;
  protected SosoInterface.a b = new yor(this, 0, true, false, 60000L, false, false, "SearchContacts");
  private double bG;
  public boolean bnS;
  public boolean bnT = true;
  private double bo;
  private int caq = 2;
  private Map<Integer, Integer> ie = new ConcurrentHashMap();
  ArrayList<b> rd;
  public int searchType;
  
  public SearchContactsFragment()
  {
    SosoInterface.a(this.b);
  }
  
  private boolean B(ArrayList<yow> paramArrayList)
  {
    int i = 2;
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramArrayList != null)
    {
      bool1 = bool2;
      if (paramArrayList.size() == 1)
      {
        localObject = (yow)paramArrayList.get(0);
        if (!((yow)localObject).bnW) {
          break label204;
        }
        paramArrayList = "https://sqimg.qq.com/qq_product_operations/tiqq/suicide/?keyword=" + URLEncoder.encode(this.aZi);
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "is SuicideWord word = " + this.aZi + " jump url is : " + paramArrayList);
        }
        localObject = d();
        Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
        localIntent.putExtra("url", paramArrayList);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("isShowAd", false);
        ((BaseActivity)localObject).startActivity(localIntent);
        bool1 = true;
      }
    }
    label204:
    do
    {
      do
      {
        do
        {
          do
          {
            int j;
            long l;
            do
            {
              do
              {
                return bool1;
                localObject = ((yow)localObject).sS;
                if ((localObject == null) || (((List)localObject).size() != 1)) {
                  break;
                }
                localObject = (AccountSearchPb.record)((List)localObject).get(0);
                j = ((yow)paramArrayList.get(0)).resultType;
                bool1 = bool2;
              } while (j == 80000003);
              l = ((AccountSearchPb.record)localObject).code.get();
              if ((j != 80000001) || (TextUtils.isEmpty(this.avs))) {
                break;
              }
              bool1 = bool2;
            } while (!String.valueOf(l).equals(this.avs));
            i = 30002;
            if (this.mFrom == 1) {
              i = 30010;
            }
            a(j, (AccountSearchPb.record)localObject, i);
            bool1 = bool2;
          } while (this.h == null);
          if (((SearchBaseActivity)this.h).xj() == 0) {
            d().finish();
          }
          return true;
          bool1 = bool2;
        } while (localObject == null);
        bool1 = bool2;
      } while (((List)localObject).size() != 2);
      localObject = SearchBaseActivity.S.matcher(this.aZi);
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "needJump lastKeywords = " + this.aZi);
      }
      bool1 = bool2;
    } while (!((Matcher)localObject).matches());
    cki();
    dc(this.aQ);
    if (this.mFrom == 1) {
      i = 3;
    }
    for (;;)
    {
      d(((yow)paramArrayList.get(0)).resultType, false, i);
      return true;
      if (this.mFrom != 0) {
        i = 0;
      }
    }
  }
  
  private boolean Ud()
  {
    if (this.rd != null)
    {
      Iterator localIterator = this.rd.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if ((localb != null) && (localb.dataType == 80000002)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static SearchContactsFragment a(int paramInt)
  {
    fromType = paramInt;
    return new SearchContactsFragment();
  }
  
  private yow a(int paramInt)
  {
    if (this.aQ == null) {
      return null;
    }
    Iterator localIterator = this.aQ.iterator();
    while (localIterator.hasNext())
    {
      yow localyow = (yow)localIterator.next();
      if (localyow.resultType == paramInt) {
        return localyow;
      }
    }
    return null;
  }
  
  private void a(aozz.a parama)
  {
    int i = 30008;
    if (parama.bnU) {
      i = 30004;
    }
    Object localObject = TroopInfoActivity.a(parama.uin, parama.cnD, i);
    ((Bundle)localObject).putInt("exposureSource", 3);
    ((Bundle)localObject).putInt("t_s_f", 1000);
    apuh.a(d(), (Bundle)localObject, 2);
    anot.a(this.app, "CliOper", "", "", "0X8004BF2", "0X8004BF2", en(80000001), 0, "", "", "", "");
    anot.a(this.app, "P_CliOper", "Grp_find", "", "result", "Clk_grpdate", 0, 0, parama.uin, "", "", "");
    localObject = (Integer)this.ie.get(Integer.valueOf(80000001));
    if (localObject != null) {}
    for (i = ((Integer)localObject).intValue();; i = 0)
    {
      amxk.a(80000001, i, parama.cWL, true, parama.uin, this.aZi, fromType);
      amxk.d("add_page", "all_result", "clk_grp", 0, this.caq, new String[] { parama.uin, "", this.aZi, "" });
      return;
    }
  }
  
  private void a(SearchBaseFragment.a parama)
  {
    Object localObject = getActivity();
    Intent localIntent;
    if (localObject != null)
    {
      localIntent = new Intent((Context)localObject, PublicAccountBrowser.class);
      localIntent.putExtra("url", parama.url);
      if (fromType != 13) {
        break label186;
      }
      localIntent.putExtra("articalChannelId", 12);
      ((Activity)localObject).startActivity(localIntent);
      if (fromType != 12) {
        break label274;
      }
      anot.a(this.app, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "" + parama.num, "", this.aZi, "" + parama.rX);
      label139:
      localObject = (Integer)this.ie.get(Integer.valueOf(80000003));
      if (localObject == null) {
        break label352;
      }
    }
    label186:
    label352:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      amxk.a(80000003, i, parama.num, true, null, this.aZi, fromType);
      return;
      if (fromType == 1)
      {
        localIntent.putExtra("articalChannelId", 10);
        if ((parama == null) || (parama.aZj == null)) {
          break;
        }
        kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.aZi, parama.aZj, parama.aZk, "1");
        break;
      }
      if (fromType != 2) {
        break;
      }
      localIntent.putExtra("articalChannelId", 11);
      break;
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "" + parama.num, "", this.aZi, "" + parama.rX, false);
      break label139;
    }
  }
  
  private void a(SearchBaseFragment.b paramb)
  {
    a(paramb.dataType, paramb.b, 2);
    anot.a(this.app, "CliOper", "", "", "0X8004BF2", "0X8004BF2", en(paramb.dataType), 0, "", "", "", "");
    Object localObject2 = (Integer)this.ie.get(Integer.valueOf(paramb.dataType));
    AccountSearchPb.record localrecord = null;
    Object localObject1 = localrecord;
    if (paramb != null)
    {
      localObject1 = localrecord;
      if (paramb.b != null)
      {
        localObject1 = localrecord;
        if (paramb.b.uin != null) {
          localObject1 = String.valueOf(paramb.b.uin.get());
        }
      }
    }
    int j = paramb.dataType;
    int i;
    label247:
    String str;
    if (localObject2 != null)
    {
      i = ((Integer)localObject2).intValue();
      amxk.a(j, i, paramb.cao, true, (String)localObject1, this.aZi, fromType);
      if (paramb.dataType == 80000002)
      {
        localrecord = paramb.b;
        localObject1 = getActivity();
        if ((localrecord != null) && (localObject1 != null) && ((localObject1 instanceof SearchBaseActivity)))
        {
          i = ((SearchBaseActivity)localObject1).xj();
          localObject2 = obg.a();
          if (localrecord.uin == null) {
            break label377;
          }
          localObject1 = localrecord.uin.get() + "";
          ((obg)localObject2).a(2, (String)localObject1, paramb.cao, fromType);
          if (fromType != 12) {
            break label390;
          }
          localObject1 = this.app;
          localObject2 = paramb.cao + "";
          str = SearchBaseActivity.a.cQ(i);
          if (localrecord.uin == null) {
            break label384;
          }
        }
      }
    }
    label384:
    for (paramb = localrecord.uin.get() + "";; paramb = "")
    {
      anot.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, (String)localObject2, str, paramb, this.aZi);
      return;
      i = 0;
      break;
      label377:
      localObject1 = "";
      break label247;
    }
    label390:
    localObject2 = this.app;
    if (localrecord.uin != null) {}
    for (localObject1 = localrecord.uin.get() + "";; localObject1 = "")
    {
      kbp.a((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", (String)localObject1, "0X8005D20", "0X8005D20", 0, 0, paramb.cao + "", SearchBaseActivity.a.cQ(i), this.aZi, "", false);
      return;
    }
  }
  
  private String cR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 80000000: 
      return "0X8004BEE";
    case 80000001: 
      return "0X8004BEF";
    }
    return "0X8004BF0";
  }
  
  private int en(int paramInt)
  {
    switch (paramInt)
    {
    case 80000000: 
    default: 
      return 1;
    case 80000001: 
      return 2;
    }
    return 3;
  }
  
  protected boolean A(ArrayList<yow> paramArrayList)
  {
    boolean bool = false;
    if (!this.bnS)
    {
      this.aQ = paramArrayList;
      this.caq = amxg.c(paramArrayList, this.avs);
      if (!B(this.aQ))
      {
        this.rd = Z(Y(paramArrayList));
        cki();
        dc(this.aQ);
        bool = true;
      }
    }
    do
    {
      return bool;
      this.bnS = false;
      this.aQ = paramArrayList;
      cki();
      dc(this.aQ);
    } while (B(this.aQ));
    int i;
    if (this.mFrom == 1) {
      i = 3;
    }
    for (;;)
    {
      d(((yow)paramArrayList.get(0)).resultType, false, i);
      return false;
      if (this.mFrom == 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  ArrayList<yow> Y(ArrayList<yow> paramArrayList)
  {
    int[] arrayOfInt = ViewFactory.i(getSearchType());
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        yow localyow = (yow)localIterator.next();
        if (localyow.resultType == k) {
          localArrayList.add(localyow);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  ArrayList<b> Z(ArrayList<yow> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(12);
    int n = paramArrayList.size();
    int j = 0;
    yow localyow;
    for (;;)
    {
      if (j < n)
      {
        localyow = (yow)paramArrayList.get(j);
        if ((localyow == null) || ((localyow.sS.size() <= 0) && (localyow.sT.size() <= 0)))
        {
          j += 1;
        }
        else
        {
          localObject = new b();
          ((b)localObject).itemType = 0;
          ((b)localObject).dataType = localyow.resultType;
          ((b)localObject).bnU = localyow.bnU;
          if (ViewFactory.fv(localyow.resultType) == 2131689920)
          {
            ((b)localObject).aZm = obt.a(this.app, BaseApplicationImpl.getContext());
            label137:
            localArrayList.add(localObject);
            if (TextUtils.isEmpty(localyow.aZp)) {
              break label838;
            }
          }
        }
      }
    }
    label324:
    label838:
    for (Object localObject = localyow.aZp;; localObject = null)
    {
      b localb;
      int i;
      if ((localyow.b != null) && (localyow.b.hotword.has()))
      {
        localb = new b();
        localb.itemType = 2;
        localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = localyow.b;
        localb.dataType = localyow.resultType;
        localb.mExtraFlag = localyow.mExtraFlag;
        localb.aZl = ((String)localObject);
        localArrayList.add(localb);
        i = 2;
        kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F75", "0X8006F75", 0, 0, this.aZi, localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (;;)
      {
        int m;
        int k;
        if (localyow.resultType == 80000004)
        {
          m = localyow.sT.size();
          k = 0;
          if (k < i)
          {
            localObject = new b();
            ((b)localObject).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem = ((AccountSearchPb.ResultItem)localyow.sT.get(k));
            ((b)localObject).itemType = 2;
            ((b)localObject).dataType = localyow.resultType;
            localArrayList.add(localObject);
            if (k < m - 1) {}
          }
          else
          {
            i = m;
          }
        }
        for (;;)
        {
          if (i > 3)
          {
            localObject = new b();
            ((b)localObject).itemType = 1;
            ((b)localObject).dataType = localyow.resultType;
            ((b)localObject).mExtraFlag = localyow.mExtraFlag;
            if (localyow.resultType == 80000004) {
              ((b)localObject).aZn = localyow.aZp;
            }
            localArrayList.add(localObject);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SearchContactsFragment", 2, "search reuslt : type = " + localyow.resultType + "count = " + localyow.sS.size());
          }
          localObject = "";
          switch (localyow.resultType)
          {
          }
          for (;;)
          {
            anot.a(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, String.valueOf(Math.min(i, 3)), "", "", "");
            break;
            ((b)localObject).aZm = d().getString(ViewFactory.fv(localyow.resultType));
            break label137;
            k += 1;
            break label324;
            k = localyow.sS.size();
            m = 0;
            for (;;)
            {
              if (m >= i) {
                break label827;
              }
              localb = new b();
              localb.itemType = 2;
              localb.c = ((AccountSearchPb.record)localyow.sS.get(m));
              localb.dataType = localyow.resultType;
              localb.mExtraFlag = localyow.mExtraFlag;
              localb.aZl = ((String)localObject);
              localb.bnU = localyow.bnU;
              localArrayList.add(localb);
              if (m >= k - 1)
              {
                i = k;
                break;
              }
              if (localyow.resultType == 80000001) {
                anot.a(this.app, "P_CliOper", "Grp_find", "", "result", "exp", 0, 0, "", "", "", "");
              }
              m += 1;
            }
            localObject = "0X80061B8";
            continue;
            localObject = "0X80061BB";
            continue;
            localObject = "0X80061BE";
            continue;
            localObject = "0X80061C1";
          }
          return localArrayList;
          i = k;
        }
        i = 3;
      }
    }
  }
  
  String a(SearchBaseFragment.b paramb, b paramb1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramb1.dataType;
    paramb.uin = (paramb1.c.uin.get() + "");
    boolean bool;
    SpannableStringBuilder localSpannableStringBuilder;
    label132:
    Object localObject;
    if (paramb1.c.uin.get() != 0L)
    {
      bool = true;
      paramb.bnQ = bool;
      paramb.aPj = paramb1.c.mobile.get();
      paramb.FB.setCompoundDrawables(null, null, null, null);
      localSpannableStringBuilder = new SpannableStringBuilder();
      switch (i)
      {
      default: 
        paramb.KU.setText(localSpannableStringBuilder);
        if ((i == 80000000) && (!TextUtils.isEmpty(paramb.uin)) && (aqft.rj(paramb.uin)))
        {
          localObject = this.app.getApp().getResources().getDrawable(2130842599);
          this.app.getApp();
          int j = wja.dp2px(15.0F, BaseApplication.getContext().getResources());
          this.app.getApp();
          ((Drawable)localObject).setBounds(0, 0, j, wja.dp2px(15.0F, BaseApplication.getContext().getResources()));
          paramb.KU.setCompoundDrawables(null, null, (Drawable)localObject, null);
          label249:
          localStringBuilder.append(paramb.FB.getText().toString());
          localStringBuilder.append(paramb.KU.getText().toString());
          switch (i)
          {
          default: 
            i = 1;
          }
        }
        break;
      }
    }
    for (;;)
    {
      localObject = this.d.b(i, paramb.uin);
      paramb1 = (b)localObject;
      if (localObject == null)
      {
        localObject = aqhu.G();
        paramb1 = (b)localObject;
        if (!this.d.isPausing())
        {
          this.d.a(paramb.uin, i, true, (byte)1);
          paramb1 = (b)localObject;
        }
      }
      paramb.pV.setImageBitmap(paramb1);
      return localStringBuilder.toString();
      bool = false;
      break;
      paramb.FB.setText(a(80000000, paramb1.c.name.get()));
      localSpannableStringBuilder.append("(");
      if (paramb.bnQ) {}
      for (localObject = paramb.uin;; localObject = paramb.aPj)
      {
        localSpannableStringBuilder.append(a(80000000, (String)localObject));
        localSpannableStringBuilder.append(")");
        break;
      }
      paramb.FB.setText(a(80000002, String.valueOf(paramb1.c.name.get())));
      break label132;
      paramb.FB.setText(a(80000001, String.valueOf(paramb1.c.name.get())));
      localSpannableStringBuilder.append("(");
      localSpannableStringBuilder.append(a(80000001, String.valueOf(paramb1.c.code.get())));
      localSpannableStringBuilder.append(")");
      break label132;
      paramb.KU.setCompoundDrawables(null, null, null, null);
      break label249;
      localStringBuilder.append(b(paramb, paramb1.c));
      i = 1;
      continue;
      i = 4;
      paramb.KV.setVisibility(0);
      paramb.KV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      paramb.KV.setText(paramb1.c.number.get() + acfp.m(2131714098));
      paramb.KV.setTextColor(d().getResources().getColor(2131167379));
      paramb.KW.setText(paramb1.c.brief.get());
      paramb.uin = String.valueOf(paramb1.c.code.get());
      localStringBuilder.append(paramb.KV.getText()).append(paramb.KW.getText());
      continue;
      localStringBuilder.append(c(paramb, paramb1.c));
      i = 1;
    }
  }
  
  void aj(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent(d(), PublicAccountBrowser.class);
      localIntent.putExtra("url", paramString1);
      d().startActivity(localIntent);
      kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F2A", "0X8006F2A", 0, 0, this.aZi, paramString2, paramString3, "2");
    }
  }
  
  public void bc(String paramString, boolean paramBoolean)
  {
    this.bnO = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("SearchContactsFragment", 2, "doSearch");
    }
    if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      Sa();
      this.aZi = paramString;
      if (this.jdField_a_of_type_Yob == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchContactsFragment", 2, "doSearch:should not be here | searchFacade = null");
        }
        bpm();
        return;
      }
      this.jdField_a_of_type_Yob.ckh();
      if (this.mFrom == 1)
      {
        this.bnS = true;
        this.searchType = 80000001;
        if (this.bnT) {
          yqm.a().dL(this.app.getCurrentUin(), paramString);
        }
      }
      else
      {
        if (fromType != 12) {
          break label223;
        }
        localyob = this.jdField_a_of_type_Yob;
        if (!this.bnS) {
          break label216;
        }
      }
      label216:
      for (int i = this.searchType;; i = 80000006)
      {
        localyob.a(paramString, i, this.bG, this.bo, 1);
        this.bnP = true;
        if (!this.bnS) {
          break label268;
        }
        paramString = cR(this.searchType);
        anot.a(this.app, "CliOper", "", "", paramString, paramString, this.mFrom + 1, 0, "", "", "", "");
        return;
        this.bnT = true;
        break;
      }
      label223:
      yob localyob = this.jdField_a_of_type_Yob;
      if (this.bnS) {}
      for (i = this.searchType;; i = 80000005)
      {
        localyob.a(paramString, i, this.bG, this.bo, 0);
        break;
      }
      label268:
      anot.a(this.app, "CliOper", "", "", "0X8004BED", "0X8004BED", this.mFrom + 1, 0, "", "", "", "");
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131696272, 0).show(getTitleBarHeight());
  }
  
  void ckl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SearchContactsFragment", 2, "show group search recommend view");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView = new GroupSearchRecommendView(d(), this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView$a, new yot(this), new you(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView.onCreate();
    dI(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView);
  }
  
  void ckm()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView = ((ViewFactory.GuideView)ViewFactory.a().a(80000005, d(), true));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {}
    }
    while (this.hu.getChildAt(0) == this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.setListener(new yov(this));
      dI(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
      return;
    }
    dI(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView);
  }
  
  void d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("last_key_words", this.aZi);
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt2 = i;
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004BF1", "0X8004BF1", paramInt1, 0, "", "", "", "");
      return;
      Object localObject2 = d();
      paramInt2 = i;
      if (localObject2 == null) {
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 0);
      ((Intent)localObject1).setClass((Context)localObject2, ClassificationSearchActivity.class);
      ClassificationSearchActivity.a((Activity)localObject2, (Intent)localObject1, a(paramInt1));
      paramInt1 = 1;
      continue;
      long l1 = Double.valueOf(this.bo * 1000000.0D).longValue();
      long l2 = Double.valueOf(this.bG * 1000000.0D).longValue();
      localObject2 = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_rec&keyword=" + URLEncoder.encode(this.aZi) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(l2) + "&lat=" + Long.valueOf(l1) + "&sourceext=" + paramInt2;
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = (String)localObject2 + "&show_tab=hot";
      }
      localObject1 = (String)localObject1 + "&_wv=17039363&_wwv=1293&_cwv=8";
      if (QLog.isColorLevel()) {
        QLog.d("SearchContactsFragment", 2, "call jump ,lastKeywords = " + this.aZi + " jump url is : " + (String)localObject1);
      }
      localObject2 = new Intent(d(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      d().startActivity((Intent)localObject2);
      anot.a(this.app, "P_CliOper", "Grp_find", "", "result", "Clk_more", 0, 0, "", "", "", "");
      localObject2 = this.app;
      if (this.aZi.matches("^\\d{5,11}$")) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        anot.a((QQAppInterface)localObject2, "dc00899", "Grp_find", "", "inte_add", "inte_find_grp", 0, 0, (String)localObject1, this.aZi, "", "");
        paramInt1 = 2;
        break;
      }
      ((Intent)localObject1).putExtra("from_key", 2);
      localObject2 = getActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchContactsActivity))) {
        ((Intent)localObject1).putExtra("jump_src_key", ((SearchContactsActivity)localObject2).xj());
      }
      ((Intent)localObject1).setClass(d(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(d(), (Intent)localObject1, a(paramInt1));
      paramInt1 = 3;
      paramInt2 = paramInt1;
      if (localObject2 == null) {
        break;
      }
      paramInt2 = paramInt1;
      if (!(localObject2 instanceof SearchBaseActivity)) {
        break;
      }
      paramInt1 = ((SearchBaseActivity)localObject2).xj();
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D21", "0X8005D21", 0, 0, "0", SearchBaseActivity.a.cQ(paramInt1), this.aZi, "", false);
      paramInt1 = 3;
      continue;
      ((Intent)localObject1).putExtra("from_key", 5);
      ((Intent)localObject1).putExtra("fromType", fromType);
      ((Intent)localObject1).setClass(d(), ClassificationSearchActivity.class);
      ClassificationSearchActivity.a(d(), (Intent)localObject1, a(paramInt1));
      kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, "0", "", this.aZi, "", false);
      paramInt1 = 1;
    }
  }
  
  public void doDestroy()
  {
    super.doDestroy();
    cki();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (localObject != null) {
      if ((localObject instanceof SearchBaseFragment.b)) {
        a((SearchBaseFragment.b)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof aozz.a))
      {
        a((aozz.a)localObject);
      }
      else if ((localObject instanceof SearchBaseFragment.a))
      {
        a((SearchBaseFragment.a)localObject);
        continue;
        if ((paramView instanceof QzoneSearchResultView)) {
          ((QzoneSearchResultView)paramView).g(getActivity());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c.destroy();
    }
    if (this.b != null) {
      SosoInterface.c(this.b);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Yvg != null) {
      this.jdField_a_of_type_Yvg.onDetach();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.mFrom == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactGroupsearchGroupSearchRecommendView.onResume();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.mFrom == 1) {
      ckl();
    }
  }
  
  protected void refreshList()
  {
    if (this.rd == null) {
      showEmptyView();
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c = new c(BaseApplicationImpl.getContext(), this.app, this.mListView, 4, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c.setData(this.rd);
          this.mListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c);
          this.mAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c;
        }
        if (this.hu.getChildAt(0) != this.mListView)
        {
          this.hu.removeAllViews();
          this.hu.addView(this.mListView);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c.setData(this.rd);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment$c.notifyDataSetChanged();
        if (this.bnP)
        {
          this.bnP = false;
          this.mListView.setSelection(0);
        }
      } while (!Ud());
      localObject1 = getActivity();
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsActivity)))
      {
        localObject1 = SearchBaseActivity.a.cQ(((SearchContactsActivity)localObject1).xj());
        kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1F", "0X8005D1F", 0, 0, "", (String)localObject1, this.aZi, "", false);
      }
    } while (this.rd == null);
    Object localObject1 = new StringBuilder();
    Object localObject2 = this.rd.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if ((localb != null) && (localb.c != null) && (localb.dataType == 80000002))
      {
        ((StringBuilder)localObject1).append(String.valueOf(localb.c.uin.get())).append("#");
        i += 1;
      }
    }
    localObject2 = obg.a().aa(this.app.getCurrentAccountUin(), this.aZi);
    obg.a().a((String)localObject2, this.aZi, 2, false, i, ((StringBuilder)localObject1).toString());
  }
  
  public void setKeyword(String paramString)
  {
    this.avs = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      ckm();
      yW(paramString);
      return;
    }
    this.hu.removeAllViews();
  }
  
  protected void showEmptyView()
  {
    Object localObject = (achg)this.app.getManager(159);
    if ((80000001 == this.searchType) && (((achg)localObject).bIf)) {
      if (this.jdField_a_of_type_Yvg == null)
      {
        this.jdField_a_of_type_Yvg = new yvj(this.app, this.h, null, null);
        localObject = this.jdField_a_of_type_Yvg.a();
        TextView localTextView = new TextView(this.h);
        localTextView.setGravity(17);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(105.0F, getResources())));
        localTextView.setTextColor(getResources().getColor(2131167383));
        localTextView.setTextSize(1, 17.0F);
        localTextView.setText(acfp.m(2131714105));
        localTextView.setBackgroundResource(2130838901);
        ((ListView)localObject).addHeaderView(localTextView);
        localTextView = new TextView(this.h);
        localTextView.setTextColor(getResources().getColor(2131167383));
        localTextView.setTextSize(1, 14.0F);
        localTextView.setGravity(16);
        localTextView.setPadding(wja.dp2px(15.0F, getResources()), 0, 0, 0);
        localTextView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(40.0F, getResources())));
        localTextView.setText(acfp.m(2131714096));
        localTextView.setBackgroundResource(2130838901);
        ((ListView)localObject).addHeaderView(localTextView);
        dI(this.jdField_a_of_type_Yvg.a());
      }
    }
    for (;;)
    {
      this.bnS = false;
      return;
      this.jdField_a_of_type_Yvg.refresh();
      break;
      super.showEmptyView();
    }
  }
  
  void yW(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory$GuideView.bu(getSearchType(), paramString);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      Object localObject1 = paramView.getTag();
      SearchContactsFragment.b localb;
      int j;
      int i;
      if ((localObject1 != null) && ((localObject1 instanceof SearchContactsFragment.b)))
      {
        localb = (SearchContactsFragment.b)localObject1;
        if ((localb.dataType != 80000003) || (SearchContactsFragment.c(SearchContactsFragment.this) == null)) {
          break label304;
        }
        SearchContactsFragment.this.aj(SearchContactsFragment.c(SearchContactsFragment.this), SearchContactsFragment.a(SearchContactsFragment.this), SearchContactsFragment.b(SearchContactsFragment.this));
        Integer localInteger = (Integer)SearchContactsFragment.a(SearchContactsFragment.this).get(Integer.valueOf(localb.dataType));
        Object localObject2 = null;
        localObject1 = localObject2;
        if (localb.c != null)
        {
          localObject1 = localObject2;
          if (localb.c.uin != null) {
            localObject1 = String.valueOf(localb.c.uin.get());
          }
        }
        j = localb.dataType;
        if (localInteger == null) {
          break label404;
        }
        i = localInteger.intValue();
        label162:
        amxk.a(j, i, 0, true, (String)localObject1, SearchContactsFragment.this.aZi, SearchContactsFragment.fromType);
        if (localb.dataType != 80000002) {
          break label455;
        }
        localObject2 = SearchContactsFragment.this.getActivity();
        if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
        {
          i = ((SearchBaseActivity)localObject2).xj();
          if (SearchContactsFragment.fromType != 12) {
            break label409;
          }
          anot.b(SearchContactsFragment.this.app, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", SearchBaseActivity.a.cQ(i), (String)localObject1, SearchContactsFragment.this.aZi);
          label268:
          localObject2 = obg.a();
          if (localInteger == null) {
            break label450;
          }
          i = localInteger.intValue();
          label284:
          ((obg)localObject2).a(2, (String)localObject1, i, SearchContactsFragment.fromType);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label304:
        if (localb.dataType == 80000004)
        {
          QzoneSearchResultView.c(SearchContactsFragment.this.getActivity(), localb.aZn);
          break;
        }
        i = 0;
        if (SearchContactsFragment.this.mFrom == 1)
        {
          i = 3;
          label347:
          localObject1 = SearchContactsFragment.this;
          j = localb.dataType;
          if (localb.mExtraFlag != 2) {
            break label398;
          }
        }
        label398:
        for (boolean bool = true;; bool = false)
        {
          ((SearchContactsFragment)localObject1).d(j, bool, i);
          break;
          if (SearchContactsFragment.this.mFrom != 0) {
            break label347;
          }
          i = 2;
          break label347;
        }
        label404:
        i = 0;
        break label162;
        label409:
        kbp.a(SearchContactsFragment.this.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 0, "0", SearchBaseActivity.a.cQ(i), SearchContactsFragment.this.aZi, "", false);
        break label268;
        label450:
        i = 0;
        break label284;
        label455:
        if (localb.dataType == 80000003)
        {
          if (SearchContactsFragment.fromType == 12) {
            anot.a(SearchContactsFragment.this.app, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", SearchContactsFragment.this.aZi, "0");
          } else {
            kbp.a(SearchContactsFragment.this.app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", SearchContactsFragment.this.aZi, "0", false);
          }
        }
        else if (localb.dataType == 80000001) {
          amxk.d("add_page", "all_result", "clk_more_grp", 0, SearchContactsFragment.a(SearchContactsFragment.this), new String[] { "", "", SearchContactsFragment.this.aZi, "" });
        }
      }
    }
  }
  
  static class b
  {
    public AccountSearchPb.ResultItem a;
    public AccountSearchPb.hotwordrecord a;
    public String aZl;
    public String aZm;
    public String aZn;
    boolean bnU;
    public AccountSearchPb.record c;
    public int dataType;
    public int itemType;
    public int mExtraFlag;
  }
  
  class c
    extends abeg
  {
    private String aZo = "";
    private ArrayList<SearchContactsFragment.b> itemList;
    
    public c(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
    {
      super(paramQQAppInterface, paramListView, paramInt, paramBoolean);
    }
    
    private int fu(int paramInt)
    {
      if (paramInt >= 1)
      {
        if (getItemViewType(paramInt - 1) == 0) {
          return 1;
        }
        if ((paramInt >= 2) && (getItemViewType(paramInt - 2) == 0)) {
          return 2;
        }
      }
      return 3;
    }
    
    private View h(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = SearchContactsFragment.this.d().getLayoutInflater().inflate(2131559418, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131379769);
      if (UniteSearchActivity.dCK == 12) {
        if (((SearchContactsFragment.b)this.itemList.get(paramInt)).aZm.equals(acfp.m(2131714097)))
        {
          paramView.setText(obt.a(SearchContactsFragment.this.app, BaseApplicationImpl.getApplication().getApplicationContext()));
          this.aZo = ((SearchContactsFragment.b)this.itemList.get(paramInt)).aZm;
          if (AppSetting.enableTalkBack)
          {
            localView.setFocusable(true);
            localView.setContentDescription(paramView.getText() + acfp.m(2131714103));
          }
          paramView = localView.findViewById(2131366004);
          if (paramInt <= 0) {
            break label212;
          }
          paramView.setVisibility(0);
        }
      }
      label212:
      while (paramInt != 0)
      {
        return localView;
        paramView.setText(((SearchContactsFragment.b)this.itemList.get(paramInt)).aZm);
        break;
        paramView.setText(((SearchContactsFragment.b)this.itemList.get(paramInt)).aZm);
        break;
      }
      paramView.setVisibility(8);
      return localView;
    }
    
    private View i(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SearchContactsFragment.b localb = (SearchContactsFragment.b)getItem(paramInt);
      View localView = paramView;
      if (paramView == null) {
        localView = joa.b(SearchContactsFragment.this.d(), paramViewGroup, 5, false, 1);
      }
      paramView = ((SearchContactsFragment.b)getItem(paramInt)).c;
      joa.a(localView, SearchContactsFragment.this.d(), localb.c);
      paramViewGroup = (aozz.a)localView.getTag();
      paramViewGroup.ON.setTextColor(SearchContactsFragment.this.d().getResources().getColor(2131167309));
      paramViewGroup.ON.setText(SearchContactsFragment.this.a(80000001, String.valueOf(paramView.name.get())));
      paramViewGroup.uin = Long.toString(localb.c.code.get());
      paramViewGroup.type = 4;
      paramViewGroup.pQ.setImageBitmap(a(4, paramViewGroup.uin));
      paramViewGroup.cWL = fu(paramInt);
      paramViewGroup.cnD = localb.c.bytes_join_group_auth.get().toStringUtf8();
      paramViewGroup.bnU = localb.bnU;
      localView.setOnClickListener(SearchContactsFragment.this);
      return localView;
    }
    
    private View j(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = SearchContactsFragment.this.d().getLayoutInflater().inflate(2131562737, paramViewGroup, false);
      }
      for (;;)
      {
        if ((paramView instanceof QzoneSearchResultView))
        {
          paramViewGroup = (QzoneSearchResultView)paramView;
          SearchContactsFragment.b localb = (SearchContactsFragment.b)getItem(paramInt);
          paramViewGroup.a(SearchContactsFragment.this.app, SearchContactsFragment.this, localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem);
          paramViewGroup.setAvartaView(a(1, paramViewGroup.getUin()));
          paramView.setOnClickListener(SearchContactsFragment.this);
        }
        return paramView;
      }
    }
    
    private View k(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = SearchContactsFragment.this.d().getLayoutInflater().inflate(2131561647, null);
        paramView = new SearchBaseFragment.a();
        paramView.pV = ((ImageView)paramViewGroup.findViewById(2131368406));
        paramView.FB = ((TextView)paramViewGroup.findViewById(2131372383));
        paramView.KS = ((TextView)paramViewGroup.findViewById(2131379699));
        paramView.KT = ((TextView)paramViewGroup.findViewById(2131363121));
        paramView.KR = ((TextView)paramViewGroup.findViewById(2131363720));
        paramViewGroup.setTag(paramView);
      }
      SearchBaseFragment.a locala = (SearchBaseFragment.a)paramViewGroup.getTag();
      paramViewGroup.setOnClickListener(SearchContactsFragment.this);
      SearchContactsFragment.b localb = (SearchContactsFragment.b)getItem(paramInt);
      if (localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
        kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, SearchContactsFragment.this.aZi, localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
      }
      for (paramInt = 1;; paramInt = 0)
      {
        String str3 = "";
        String str1;
        String str2;
        Object localObject1;
        Object localObject2;
        if (paramInt != 0)
        {
          str1 = localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
          str2 = localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
          localObject1 = localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
          localObject2 = localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
          paramView = localb.aZl;
          SearchContactsFragment.a(SearchContactsFragment.this, str1);
          SearchContactsFragment.b(SearchContactsFragment.this, String.valueOf(localb.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
          locala.aZj = SearchContactsFragment.a(SearchContactsFragment.this);
          locala.aZk = SearchContactsFragment.b(SearchContactsFragment.this);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(localb.aZl)) {
            SearchContactsFragment.c(SearchContactsFragment.this, localb.aZl);
          }
          locala.KS.setText(str3);
          int i = SearchContactsFragment.this.getResources().getDimensionPixelSize(2131297863);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
          try
          {
            localObject2 = URLDrawable.getDrawable((String)localObject2, i, i);
            locala.pV.setImageDrawable((Drawable)localObject2);
            label398:
            locala.url = paramView;
            if (!"".equals(str2)) {
              locala.KT.setText(str2);
            }
            paramViewGroup.setTag(locala);
            if (!"".equals(str1)) {
              locala.FB.setText(SearchContactsFragment.this.a(80000003, str1));
            }
            if (paramInt == 0) {
              if (!"".equals(localObject1)) {
                if (SearchContactsFragment.this.a(locala.FB, SearchContactsFragment.this.d()) > 1)
                {
                  locala.KR.setMaxLines(1);
                  label506:
                  locala.KR.setText(SearchContactsFragment.this.a(80000003, (String)localObject1));
                }
              }
            }
            for (;;)
            {
              paramView = (ImageView)paramViewGroup.findViewById(2131382126);
              paramView.setVisibility(4);
              localObject1 = (ImageView)paramViewGroup.findViewById(2131365477);
              ((ImageView)localObject1).setVisibility(4);
              if ((localb.c != null) && (localb.c.video_article.has()) && (localb.c.video_article.get() == amxk.dDV))
              {
                paramView.setVisibility(0);
                ((ImageView)localObject1).getBackground().setAlpha(25);
                ((ImageView)localObject1).setVisibility(0);
              }
              paramView = (TextView)paramViewGroup.findViewById(2131368668);
              paramView.setVisibility(4);
              if (paramInt != 0) {
                paramView.setVisibility(0);
              }
              return paramViewGroup;
              str1 = localb.c.name.get();
              str2 = localb.c.article_author.get();
              localObject1 = localb.c.brief.get();
              localObject2 = localb.c.title_image.get();
              str3 = localb.c.article_create_time.get();
              paramView = localb.c.article_short_url.get();
              locala.rX = localb.c.account_id.get();
              locala.num = localb.c.number.get();
              break;
              locala.KR.setMaxLines(2);
              break label506;
              locala.KR.setVisibility(8);
              continue;
              if (!"".equals(localObject1))
              {
                locala.KR.setMaxLines(1);
                locala.KR.setText(SearchContactsFragment.this.a(80000003, (String)localObject1));
              }
              locala.FB.setMaxWidth(wja.dp2px(190.0F, paramViewGroup.getResources()));
              locala.FB.setMaxLines(1);
              locala.KT.setMaxLines(1);
            }
          }
          catch (Exception localException)
          {
            break label398;
          }
        }
      }
    }
    
    private View l(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = SearchContactsFragment.this.d().getLayoutInflater().inflate(2131561150, paramViewGroup, false);
      }
      localView.setOnClickListener(SearchContactsFragment.this);
      paramView = new SearchBaseFragment.b();
      paramView.pV = ((ImageView)localView.findViewById(2131368406));
      paramView.FB = ((TextView)localView.findViewById(2131372383));
      paramView.KU = ((TextView)localView.findViewById(2131381223));
      paramView.KV = ((TextView)localView.findViewById(2131365744));
      paramView.KW = ((TextView)localView.findViewById(2131370826));
      paramView.b = ((SearchContactsFragment.b)getItem(paramInt)).c;
      paramView.dataType = ((SearchContactsFragment.b)getItem(paramInt)).dataType;
      localView.setTag(paramView);
      paramView = (SearchBaseFragment.b)localView.getTag();
      paramView.b = ((SearchContactsFragment.b)getItem(paramInt)).c;
      paramView.dataType = ((SearchContactsFragment.b)getItem(paramInt)).dataType;
      paramView.cao = fu(paramInt);
      paramView = SearchContactsFragment.this.a(paramView, (SearchContactsFragment.b)this.itemList.get(paramInt));
      if (AppSetting.enableTalkBack) {
        localView.setContentDescription(paramView);
      }
      return localView;
    }
    
    private View m(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = SearchContactsFragment.this.d().getLayoutInflater().inflate(2131561152, paramViewGroup, false);
      }
      if (SearchContactsFragment.this.a == null) {
        SearchContactsFragment.this.a = new SearchContactsFragment.a(SearchContactsFragment.this);
      }
      localView.setTag(this.itemList.get(paramInt));
      localView.setOnClickListener(SearchContactsFragment.this.a);
      if (AppSetting.enableTalkBack) {
        localView.setContentDescription(acfp.m(2131714093) + this.aZo + acfp.m(2131714099));
      }
      return localView;
    }
    
    public int getCount()
    {
      return this.itemList.size();
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
      if (((SearchContactsFragment.b)this.itemList.get(paramInt)).itemType == 2) {}
      switch (((SearchContactsFragment.b)this.itemList.get(paramInt)).dataType)
      {
      case 80000002: 
      default: 
        return ((SearchContactsFragment.b)this.itemList.get(paramInt)).itemType;
      case 80000001: 
        return 3;
      case 80000003: 
        return 4;
      }
      return 5;
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
        paramView = h(paramInt, paramView, paramViewGroup);
        continue;
        paramView = i(paramInt, paramView, paramViewGroup);
        continue;
        paramView = j(paramInt, paramView, paramViewGroup);
        continue;
        paramView = k(paramInt, paramView, paramViewGroup);
        continue;
        paramView = l(paramInt, paramView, paramViewGroup);
        continue;
        paramView = m(paramInt, paramView, paramViewGroup);
      }
    }
    
    public int getViewTypeCount()
    {
      return 6;
    }
    
    public void setData(ArrayList<SearchContactsFragment.b> paramArrayList)
    {
      this.itemList = paramArrayList;
      SearchContactsFragment.a(SearchContactsFragment.this).clear();
      int i = 0;
      int k;
      for (int j = 0; i < this.itemList.size(); j = k)
      {
        k = j;
        if (((SearchContactsFragment.b)this.itemList.get(i)).itemType == 0)
        {
          paramArrayList = SearchContactsFragment.a(SearchContactsFragment.this);
          int m = ((SearchContactsFragment.b)this.itemList.get(i)).dataType;
          k = j + 1;
          paramArrayList.put(Integer.valueOf(m), Integer.valueOf(k));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment
 * JD-Core Version:    0.7.0.1
 */