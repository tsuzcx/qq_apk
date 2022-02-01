package com.tencent.mobileqq.businessCard.activity;

import acfd;
import acff;
import acfp;
import adyp;
import adyq;
import adyr;
import adys;
import adyt;
import adyu;
import adyv;
import adyw;
import adyx;
import adyy;
import adyz;
import adza;
import adzb;
import adzc;
import adzd;
import adze;
import adzf;
import adzx;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import anot;
import aqcx;
import aqdj;
import aqgv;
import aqha;
import aqiw;
import arhz;
import arie;
import aurd;
import ausj;
import awcy;
import awcy.a;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardMobileInfo;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.data.CardUinInfo;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import wja;

public class BusinessCardEditActivity
  extends BaseActivity
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  TextView Cr;
  public Dialog H;
  TextView HV;
  TextView QS;
  TextView QT;
  TextView QU;
  TextView QV;
  public adyp a;
  adyq jdField_a_of_type_Adyq = new adyy(this);
  arhz jdField_a_of_type_Arhz;
  b jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$b;
  CardOCRInfo jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
  ClearEllipsisEditText jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText;
  public BusinessCard b;
  ClearEllipsisEditText b;
  public boolean bSn = false;
  public boolean bSo = false;
  boolean bSp = false;
  boolean bSq = false;
  private boolean bSr;
  private boolean bSs;
  String bwp;
  String bwq;
  acfd c = new adyx(this);
  private int cLA = 1;
  private int cLB = 1;
  public int cLC;
  int cLD;
  public int cLE = -1;
  public int cLF = 0;
  private int cLz = 1;
  Button cl;
  private ContentObserver d;
  public boolean isEditMode = false;
  LinearLayout iu;
  LinearLayout iv;
  public LinearLayout iw;
  LinearLayout ix;
  RelativeLayout jK;
  RelativeLayout jL;
  public String mCardId;
  Intent mIntent;
  RelativeLayout mRootView;
  private List<WeakReference<aqdj>> yA;
  ImageView yp;
  
  private void H(String paramString1, String paramString2, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)findViewById(2131364306);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)findViewById(2131364284);
    Object localObject = (TextView)findViewById(2131372208);
    if (this.cLC == 2)
    {
      ((TextView)localObject).setText(super.getResources().getString(2131694938));
      if (paramBoolean) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(paramString1);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setEllipsisText(paramString2);
      if (this.isEditMode)
      {
        localRelativeLayout1.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
        this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
        if (this.cLC == 2) {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131700769);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$b = new b(96, this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText, 1);
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$b);
          localRelativeLayout2.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(true);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(true);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131700752);
          paramString1 = new b(30, this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText);
          this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.addTextChangedListener(paramString1);
          return;
          if (this.bwq != null)
          {
            paramString1 = this.bwq;
            break;
          }
          if ((this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))) {
            break label520;
          }
          paramString1 = (acff)this.app.getManager(51);
          Card localCard;
          if (paramString1 == null)
          {
            localCard = null;
            label261:
            if ((localCard == null) || ((TextUtils.isEmpty(localCard.strReMark)) && (TextUtils.isEmpty(localCard.strNick)))) {
              break label357;
            }
            if (!TextUtils.isEmpty(localCard.strReMark)) {
              break label347;
            }
          }
          label347:
          for (localObject = localCard.strNick;; localObject = localCard.strReMark)
          {
            paramString1 = (String)localObject;
            if (!TextUtils.isEmpty(localCard.strReMark)) {
              break;
            }
            this.bSp = true;
            paramString1 = (String)localObject;
            break;
            localCard = paramString1.b(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
            break label261;
          }
          label357:
          if (paramString1 == null) {}
          for (paramString1 = null;; paramString1 = paramString1.e(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin))
          {
            if (paramString1 == null) {
              break label520;
            }
            if (TextUtils.isEmpty(paramString1.remark)) {
              break label400;
            }
            paramString1 = paramString1.remark;
            break;
          }
          label400:
          paramString1 = paramString1.name;
          this.bSp = true;
          break;
          ((TextView)localObject).setText(super.getResources().getString(2131700765));
          break;
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(2131700766);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(acfp.m(2131703308));
      if (TextUtils.isEmpty(paramString2))
      {
        localRelativeLayout2.setVisibility(8);
        return;
      }
      localRelativeLayout2.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusable(false);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setFocusableInTouchMode(false);
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setHint(acfp.m(2131703303));
      return;
      label520:
      paramString1 = "";
    }
  }
  
  private void Hg(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.bwp = (paramString + "/?01");
      this.yp.setVisibility(0);
      this.yp.setOnClickListener(this);
      int i = getResources().getDisplayMetrics().widthPixels;
      int j = i * 600 / 1000;
      paramString = (LinearLayout.LayoutParams)this.yp.getLayoutParams();
      paramString.width = i;
      paramString.height = j;
      this.yp.setLayoutParams(paramString);
      try
      {
        paramString = URLDrawable.URLDrawableOptions.obtain();
        paramString.mRequestWidth = 1000;
        paramString.mRequestHeight = 600;
        paramString.mLoadingDrawable = super.getResources().getDrawable(2130845843);
        paramString.mFailedDrawable = super.getResources().getDrawable(2130845843);
        paramString = URLDrawable.getDrawable(this.bwp, paramString);
        this.yp.setImageDrawable(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    findViewById(2131373259).setVisibility(8);
    this.yp.setVisibility(8);
  }
  
  private void Hi(String paramString)
  {
    this.H = aqha.a(this, paramString, 2131694366, 2131694830, new adyu(this), new adyv(this));
    if ((this.H != null) && (!isFinishing())) {
      this.H.show();
    }
  }
  
  private void a(BusinessCard paramBusinessCard, CardOCRInfo paramCardOCRInfo)
  {
    int k = 0;
    int j = 0;
    int i;
    if (paramBusinessCard != null)
    {
      this.iv.removeAllViews();
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        i = 0;
        while (i < paramBusinessCard.mobilesNum.size())
        {
          paramCardOCRInfo = (String)paramBusinessCard.mobilesNum.get(i);
          a(this.iv, paramCardOCRInfo, 1, 15);
          i += 1;
        }
        this.cLz = paramBusinessCard.mobilesNum.size();
      }
      if (this.mIntent.getExtras() != null) {}
      for (paramCardOCRInfo = this.mIntent.getExtras().getString("add_phone_num", null);; paramCardOCRInfo = null)
      {
        if ((paramCardOCRInfo != null) && (this.cLz < 3))
        {
          this.cLz += 1;
          a(this.iv, paramCardOCRInfo, 1, 15, true);
        }
        if (this.cLz >= 3) {
          this.QT.setVisibility(8);
        }
        if (this.cLz == 0)
        {
          a(this.iv, null, 1, 15);
          this.cLz = 1;
        }
        this.iw.removeAllViews();
        if (paramBusinessCard.uinInfos.isEmpty()) {
          break label383;
        }
        i = j;
        while (i < paramBusinessCard.uinInfos.size())
        {
          paramCardOCRInfo = ((CardUinInfo)paramBusinessCard.uinInfos.get(i)).uin;
          if (!TextUtils.isEmpty(paramCardOCRInfo)) {
            el(paramCardOCRInfo, i);
          }
          i += 1;
        }
      }
      this.cLA = paramBusinessCard.uinInfos.size();
      if (this.cLA >= 2) {
        this.QU.setVisibility(8);
      }
      for (;;)
      {
        this.ix.removeAllViews();
        if (paramBusinessCard.descs.isEmpty()) {
          break label444;
        }
        paramCardOCRInfo = new StringBuilder();
        localIterator = paramBusinessCard.descs.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (paramCardOCRInfo.length() > 0) {
            paramCardOCRInfo.append("\n");
          }
          paramCardOCRInfo.append(str);
        }
        label383:
        el(null, 0);
        this.cLA = 1;
      }
      a(this.ix, paramCardOCRInfo.toString(), 2, 150);
      this.cLB = paramBusinessCard.descs.size();
      if (this.cLB >= 2) {
        this.QV.setVisibility(8);
      }
    }
    label444:
    while (paramCardOCRInfo == null)
    {
      Iterator localIterator;
      String str;
      return;
      a(this.ix, null, 2, 150);
      this.cLB = 1;
      return;
    }
    this.iv.removeAllViews();
    if (!paramCardOCRInfo.mobilesNum.isEmpty())
    {
      i = 0;
      while (i < paramCardOCRInfo.mobilesNum.size())
      {
        paramBusinessCard = (String)paramCardOCRInfo.mobilesNum.get(i);
        a(this.iv, paramBusinessCard, 1, 15);
        i += 1;
      }
    }
    for (this.cLz = paramCardOCRInfo.mobilesNum.size();; this.cLz = 1)
    {
      this.iw.removeAllViews();
      if (paramCardOCRInfo.qqNum.isEmpty()) {
        break label666;
      }
      i = k;
      while (i < paramCardOCRInfo.qqNum.size())
      {
        el((String)paramCardOCRInfo.qqNum.get(i), i);
        i += 1;
      }
      a(this.iv, null, 1, 15);
    }
    for (this.cLA = paramCardOCRInfo.qqNum.size();; this.cLA = 1)
    {
      this.ix.removeAllViews();
      a(this.ix, null, 2, 150);
      this.cLB = 1;
      return;
      label666:
      el(null, 0);
    }
  }
  
  private void a(BusinessCard paramBusinessCard, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      paramBusinessCard.cardId = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      paramBusinessCard.bindUin = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin;
      if (this.cLC == 2) {
        paramBusinessCard.cardName = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName;
      }
    }
    if (this.cLC != 2) {
      paramBusinessCard.cardName = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.sZ();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
    {
      paramBusinessCard.picUrl = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.picUrl;
      paramBusinessCard.OCRInfo = this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo;
    }
    Object localObject;
    for (;;)
    {
      if (this.bSq)
      {
        paramBusinessCard.picUrl = null;
        paramBusinessCard.OCRInfo = null;
      }
      paramBusinessCard.company = this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.sZ();
      paramBusinessCard.mobilesNum.clear();
      i = 0;
      while (i < this.iv.getChildCount())
      {
        localObject = ((EditText)this.iv.getChildAt(i)).getText().toString().trim();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramBusinessCard.mobilesNum.add(localObject);
        }
        i += 1;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
      {
        paramBusinessCard.picUrl = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl;
        paramBusinessCard.OCRInfo = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo;
      }
    }
    paramBusinessCard.qqNum.clear();
    int i = 0;
    while (i < this.iw.getChildCount())
    {
      localObject = this.iw.getChildAt(i);
      if ((localObject instanceof RelativeLayout))
      {
        localObject = (EditText)((View)localObject).findViewById(2131374910);
        if (localObject != null)
        {
          localObject = ((EditText)localObject).getText().toString().trim();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramBusinessCard.qqNum.add(localObject);
          }
        }
      }
      i += 1;
    }
    paramBusinessCard.descs.clear();
    i = 0;
    while (i < this.ix.getChildCount())
    {
      localObject = ((EditText)this.ix.getChildAt(i)).getText().toString().trim();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramBusinessCard.descs.add(localObject);
      }
      i += 1;
    }
    if (paramBoolean)
    {
      if (this.cLC != 0) {
        break label621;
      }
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.cardName)) {
        localObject = "1";
      }
      anot.a(this.app, "CliOper", "", "", "0X80064E7", "0X80064E7", 0, 0, (String)localObject, "", "", "");
      localObject = "0";
      if (TextUtils.isEmpty(paramBusinessCard.company)) {
        localObject = "1";
      }
      anot.a(this.app, "CliOper", "", "", "0X80064E8", "0X80064E8", 0, 0, (String)localObject, "", "", "");
      localObject = paramBusinessCard.qqNum.size() + "";
      anot.a(this.app, "CliOper", "", "", "0X80064E9", "0X80064E9", 0, 0, (String)localObject, "", "", "");
      paramBusinessCard = paramBusinessCard.descs.size() + "";
      anot.a(this.app, "CliOper", "", "", "0X80064EA", "0X80064EA", 0, 0, paramBusinessCard, "", "", "");
    }
    for (;;)
    {
      return;
      label621:
      if (getIntent().getIntExtra("source_activity", 0) == 1)
      {
        localObject = "0";
        if (!TextUtils.isEmpty(paramBusinessCard.cardName))
        {
          anot.a(this.app, "CliOper", "", "", "0X8007749", "0X8007749", this.cLF, 0, "", "", "", "");
          localObject = "1";
        }
        anot.a(this.app, "CliOper", "", "", "0X80064EF", "0X80064EF", 0, 0, (String)localObject, "", "", "");
        localObject = "0";
        if (!TextUtils.isEmpty(paramBusinessCard.company))
        {
          anot.a(this.app, "CliOper", "", "", "0X800774A", "0X800774A", this.cLF, 0, "", "", "", "");
          localObject = "1";
        }
        anot.a(this.app, "CliOper", "", "", "0X80064F0", "0X80064F0", 0, 0, (String)localObject, "", "", "");
        localObject = paramBusinessCard.qqNum.size() + "";
        anot.a(this.app, "CliOper", "", "", "0X80064F1", "0X80064F1", 0, 0, (String)localObject, "", "", "");
        int j = paramBusinessCard.descs.size();
        i = 0;
        while (i < j)
        {
          if (!TextUtils.isEmpty((CharSequence)paramBusinessCard.descs.get(i))) {
            anot.a(this.app, "CliOper", "", "", "0X800774E", "0X800774E", this.cLF, 0, "", "", "", "");
          }
          i += 1;
        }
        localObject = paramBusinessCard.descs.size() + "";
        anot.a(this.app, "CliOper", "", "", "0X80064F2", "0X80064F2", 0, 0, (String)localObject, "", "", "");
        j = paramBusinessCard.mobilesNum.size();
        i = 0;
        while (i < j)
        {
          if ((i == 0) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            anot.a(this.app, "CliOper", "", "", "0X800774B", "0X800774B", this.cLF, 0, "", "", "", "");
          }
          if ((i == 1) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            anot.a(this.app, "CliOper", "", "", "0X800774C", "0X800774C", this.cLF, 0, "", "", "", "");
          }
          if ((i == 2) && (!TextUtils.isEmpty((CharSequence)paramBusinessCard.mobilesNum.get(i)))) {
            anot.a(this.app, "CliOper", "", "", "0X800774D", "0X800774D", this.cLF, 0, "", "", "", "");
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo != null)
    {
      this.iv.removeAllViews();
      Object localObject1 = this.mIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject2;
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.iv, (String)localObject3, 1);
        }
      }
      if (!paramCardOCRInfo.mobilesNum.isEmpty())
      {
        localObject2 = paramCardOCRInfo.mobilesNum.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.iv, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramCardOCRInfo.mobilesNum.isEmpty())) {
        a(this.iv, null, 1);
      }
      if (!afU())
      {
        this.iw.removeAllViews();
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        localObject3 = new ArrayList();
        paramCardOCRInfo = new ArrayList();
        if (a((ArrayList)localObject2, (ArrayList)localObject1, (ArrayList)localObject3, paramCardOCRInfo))
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          Object localObject4;
          Object localObject5;
          Object localObject6;
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2131561247, null);
            localObject5 = (ImageView)((View)localObject3).findViewById(2131368698);
            localObject6 = aqdj.a(this.app, 1, (String)localObject4);
            this.yA.add(new WeakReference(localObject6));
            ((ImageView)localObject5).setBackgroundDrawable((Drawable)localObject6);
            ((TextView)((View)localObject3).findViewById(2131372369)).setText(aqgv.D(this.app, (String)localObject4));
            ((TextView)((View)localObject3).findViewById(2131381221)).setText((CharSequence)localObject4);
            ((ImageView)((View)localObject3).findViewById(2131362988)).setVisibility(0);
            localObject5 = new a();
            ((a)localObject5).uin = ((String)localObject4);
            ((a)localObject5).nickName = aqgv.D(this.app, (String)localObject4);
            ((a)localObject5).bSt = false;
            ((View)localObject3).setTag(localObject5);
            ((View)localObject3).setOnClickListener(new adza(this));
            localObject4 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this, 70.0F));
            this.iw.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            localObject2 = LayoutInflater.from(this).inflate(2131561247, null);
            localObject4 = (ImageView)((View)localObject2).findViewById(2131368698);
            localObject5 = aqdj.a(this.app, 1, (String)localObject3);
            this.yA.add(new WeakReference(localObject5));
            ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject5);
            localObject4 = (TextView)((View)localObject2).findViewById(2131372369);
            ((TextView)((View)localObject2).findViewById(2131381221)).setText((CharSequence)localObject3);
            localObject5 = (Button)((View)localObject2).findViewById(2131362207);
            ((Button)localObject5).setVisibility(0);
            localObject6 = new a();
            ((a)localObject6).uin = ((String)localObject3);
            ((a)localObject6).nickName = aqgv.c(this.app, (String)localObject3, true);
            ((a)localObject6).bSt = false;
            ((View)localObject2).setTag(localObject6);
            ((TextView)localObject4).setText(((a)localObject6).nickName);
            ((Button)localObject5).setTag(localObject6);
            ((Button)localObject5).setOnClickListener(new adzb(this));
            localObject3 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this, 70.0F));
            this.iw.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          }
          paramCardOCRInfo = paramCardOCRInfo.iterator();
          while (paramCardOCRInfo.hasNext())
          {
            localObject1 = (String)paramCardOCRInfo.next();
            a(this.iw, (String)localObject1, 0);
          }
        }
        a(this.iw, null, 0);
      }
      this.ix.removeAllViews();
      paramCardOCRInfo = (LinearLayout)this.jL.findViewById(2131365754);
      localObject1 = this.jL.findViewById(2131365733);
      paramCardOCRInfo.setVisibility(8);
      ((View)localObject1).setVisibility(8);
    }
  }
  
  private boolean a(BusinessCard paramBusinessCard1, BusinessCard paramBusinessCard2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBusinessCard2 == null)
    {
      bool1 = true;
      return bool1;
    }
    if (!aP(paramBusinessCard2.cardName, paramBusinessCard1.cardName)) {
      return true;
    }
    if (!aP(paramBusinessCard2.picUrl, paramBusinessCard1.picUrl)) {
      return true;
    }
    if (!aP(paramBusinessCard2.company, paramBusinessCard1.company)) {
      return true;
    }
    if (paramBusinessCard1.mobilesNum.size() != paramBusinessCard2.mobilesNum.size()) {
      return true;
    }
    int i = 0;
    while (i < paramBusinessCard2.mobilesNum.size())
    {
      if (!((String)paramBusinessCard1.mobilesNum.get(i)).equals(paramBusinessCard2.mobilesNum.get(i))) {
        return true;
      }
      i += 1;
    }
    if (paramBusinessCard1.descs.size() != paramBusinessCard2.descs.size()) {
      return true;
    }
    i = 0;
    while (i < paramBusinessCard2.descs.size())
    {
      if (!((String)paramBusinessCard1.descs.get(i)).equals(paramBusinessCard2.descs.get(i))) {
        return true;
      }
      i += 1;
    }
    if (paramBusinessCard1.qqNum.size() != paramBusinessCard2.uinInfos.size()) {
      return true;
    }
    i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramBusinessCard2.uinInfos.size()) {
        break;
      }
      if (!((String)paramBusinessCard1.qqNum.get(i)).equals(((CardUinInfo)paramBusinessCard2.uinInfos.get(i)).uin)) {
        return true;
      }
      i += 1;
    }
  }
  
  private boolean a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) && ((((acff)this.app.getManager(51)).isFriend(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin)) || (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardType == 1))) {
        paramArrayList1.add(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin);
      }
      Iterator localIterator = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.uinInfos.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (CardUinInfo)localIterator.next();
        if (((CardUinInfo)localObject).isFriend) {
          paramArrayList1.add(((CardUinInfo)localObject).uin);
        } else if (((CardUinInfo)localObject).bSx) {
          paramArrayList2.add(((CardUinInfo)localObject).uin);
        } else {
          paramArrayList4.add(((CardUinInfo)localObject).uin);
        }
      }
      localIterator = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobileInfos.iterator();
      while (localIterator.hasNext())
      {
        localObject = (CardMobileInfo)localIterator.next();
        if (((CardMobileInfo)localObject).isFriend) {
          paramArrayList1.add(((CardMobileInfo)localObject).bwu);
        } else {
          paramArrayList3.add(((CardMobileInfo)localObject).mobile);
        }
      }
      return (!paramArrayList1.isEmpty()) || (!paramArrayList2.isEmpty()) || (!paramArrayList3.isEmpty()) || (!paramArrayList4.isEmpty());
    }
    return false;
  }
  
  public static boolean aP(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2))) {
      return true;
    }
    return false;
  }
  
  private void b(CardOCRInfo paramCardOCRInfo)
  {
    int k = 1;
    if (paramCardOCRInfo == null) {
      return;
    }
    if (!aP(this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.sZ(), paramCardOCRInfo.name)) {}
    Object localObject;
    int i;
    for (int j = 1;; j = 0)
    {
      localObject = new ArrayList();
      i = 0;
      while (i < this.iv.getChildCount())
      {
        String str = ((EditText)this.iv.getChildAt(i)).getText().toString().trim();
        if (!TextUtils.isEmpty(str)) {
          ((ArrayList)localObject).add(str);
        }
        i += 1;
      }
    }
    if ((!paramCardOCRInfo.mobilesNum.isEmpty()) && (!((ArrayList)localObject).isEmpty()))
    {
      paramCardOCRInfo = (String)paramCardOCRInfo.mobilesNum.get(0);
      if (TextUtils.isEmpty(paramCardOCRInfo)) {
        break label247;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramCardOCRInfo.equals((String)((Iterator)localObject).next())) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      if ((j != 0) && (i != 0)) {
        i = k;
      }
      for (;;)
      {
        adzx.em(this.app.getCurrentAccountUin(), i);
        return;
        if ((!paramCardOCRInfo.mobilesNum.isEmpty()) || (!((ArrayList)localObject).isEmpty())) {
          break label247;
        }
        i = 0;
        break;
        if (j != 0) {
          i = 2;
        } else if (i != 0) {
          i = 3;
        } else {
          i = 0;
        }
      }
      label247:
      i = 1;
    }
  }
  
  private void b(String paramString1, String paramString2, List<String> paramList)
  {
    ContentValues localContentValues = new ContentValues();
    Uri localUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
    if ((localUri == null) || (ContentUris.parseId(localUri) <= 0L))
    {
      runOnUiThread(new BusinessCardEditActivity.15(this));
      return;
    }
    long l = ContentUris.parseId(localUri);
    this.bSs = true;
    if ((paramString1 != null) && (paramList != null) && (paramList.size() > 0))
    {
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/name");
      localContentValues.put("data2", paramString1);
      getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      if (paramString2 != null)
      {
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l));
        localContentValues.put("mimetype", "vnd.android.cursor.item/organization");
        localContentValues.put("data1", paramString2);
        localContentValues.put("data2", Integer.valueOf(1));
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      }
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (String)paramString1.next();
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l));
        localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        localContentValues.put("data1", paramString2);
        localContentValues.put("data2", Integer.valueOf(2));
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      }
    }
    anot.a(this.app, "CliOper", "", "", "0X80064E4", "0X80064E4", 0, 0, "", "", "", "");
  }
  
  private void cVn()
  {
    if (this.isEditMode) {
      if (this.cLC == 2)
      {
        this.HV.setText(2131700760);
        this.QS.setVisibility(0);
        this.QS.setText(2131721066);
        this.Cr.setBackgroundDrawable(super.getResources().getDrawable(2130851758));
        this.iu.setVisibility(8);
      }
    }
    label307:
    do
    {
      do
      {
        return;
        if (this.cLC == 3)
        {
          this.HV.setText(2131700764);
          break;
        }
        this.HV.setText(2131700758);
        break;
        if (this.cLC == 3) {
          this.HV.setText(2131700764);
        }
        for (;;)
        {
          this.QS.setText(2131721064);
          if (this.cLD == 2) {
            this.QS.setVisibility(8);
          }
          this.Cr.setBackgroundDrawable(super.getResources().getDrawable(2130851758));
          this.cl.setText(2131700775);
          if ((this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (((this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.OCRInfo.picUrl))) && (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0))) {
            break label307;
          }
          if ((this.cLC != 3) && (!this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.isEmpty()) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName))) {
            break;
          }
          this.iu.setVisibility(8);
          return;
          this.HV.setText(2131700757);
        }
      } while (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum.size() <= 0);
      this.iu.setVisibility(0);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.mobilesNum == null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.mobilesNum.size() <= 0)) {
        break label409;
      }
      if ((this.cLC == 3) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.mobilesNum.isEmpty()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.name)))
      {
        this.iu.setVisibility(8);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.mobilesNum.size() <= 0);
    this.iu.setVisibility(0);
    return;
    label409:
    this.iu.setVisibility(8);
  }
  
  private void cb(String paramString, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.sZ().trim();
    acff localacff;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localacff = (acff)this.app.getManager(51);
      if (localacff == null)
      {
        localObject1 = null;
        if ((localObject1 == null) || (TextUtils.isEmpty(((Card)localObject1).strNick))) {
          break label147;
        }
        localObject1 = ((Card)localObject1).strNick;
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity$b.mHasChanged) && (((String)localObject2).equals(localObject1)) && (this.bSp)) {}
      for (localObject1 = "";; localObject1 = localObject2)
      {
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(1);
        if (localObject2 != null)
        {
          ((FriendListHandler)localObject2).g(paramString, (String)localObject1, false, paramBoolean);
          localObject1 = new awcy.a();
          ((awcy.a)localObject1).cmd = 5;
          awcy.a(paramString).a((awcy.a)localObject1);
        }
        return;
        localObject1 = localacff.b(paramString);
        break;
        label147:
        if (localacff == null) {}
        for (localObject1 = null;; localObject1 = localacff.e(paramString))
        {
          if (localObject1 == null) {
            break label182;
          }
          localObject1 = ((Friends)localObject1).name;
          break;
        }
      }
      label182:
      localObject1 = null;
    }
  }
  
  private void clF()
  {
    try
    {
      this.d = new adyw(this, new Handler(this.app.getApp().getMainLooper()));
      this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
      }
      this.bSs = false;
    }
  }
  
  private void f(BusinessCard paramBusinessCard)
  {
    Object localObject1;
    if (paramBusinessCard != null)
    {
      this.iv.removeAllViews();
      localObject1 = this.mIntent.getStringArrayListExtra("bind_phone_num");
      Object localObject3;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.iv, (String)localObject3, 1);
        }
      }
      if (!paramBusinessCard.mobilesNum.isEmpty())
      {
        localObject2 = paramBusinessCard.mobilesNum.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          a(this.iv, (String)localObject3, 1);
        }
      }
      if ((localObject1 == null) && (paramBusinessCard.mobilesNum.isEmpty())) {
        a(this.iv, null, 1);
      }
      if (!afU())
      {
        this.iw.removeAllViews();
        Object localObject4 = new ArrayList();
        localObject3 = new ArrayList();
        localObject2 = new ArrayList();
        localObject1 = new ArrayList();
        if (a((ArrayList)localObject4, (ArrayList)localObject3, (ArrayList)localObject2, (ArrayList)localObject1))
        {
          localObject4 = ((ArrayList)localObject4).iterator();
          Object localObject6;
          Object localObject5;
          Object localObject7;
          Object localObject8;
          while (((Iterator)localObject4).hasNext())
          {
            localObject6 = (String)((Iterator)localObject4).next();
            localObject5 = LayoutInflater.from(this).inflate(2131561247, null);
            localObject7 = (ImageView)((View)localObject5).findViewById(2131368698);
            localObject8 = aqdj.a(this.app, 1, (String)localObject6);
            this.yA.add(new WeakReference(localObject8));
            ((ImageView)localObject7).setBackgroundDrawable((Drawable)localObject8);
            ((TextView)((View)localObject5).findViewById(2131372369)).setText(aqgv.D(this.app, (String)localObject6));
            ((TextView)((View)localObject5).findViewById(2131381221)).setText((CharSequence)localObject6);
            ((ImageView)((View)localObject5).findViewById(2131362988)).setVisibility(0);
            localObject7 = new a();
            ((a)localObject7).uin = ((String)localObject6);
            ((a)localObject7).nickName = aqgv.D(this.app, (String)localObject6);
            ((a)localObject7).bSt = false;
            ((View)localObject5).setTag(localObject7);
            ((View)localObject5).setOnClickListener(new adzc(this));
            localObject6 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this, 70.0F));
            this.iw.addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
          }
          localObject3 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (String)((Iterator)localObject3).next();
            localObject4 = LayoutInflater.from(this).inflate(2131561247, null);
            localObject6 = (ImageView)((View)localObject4).findViewById(2131368698);
            localObject7 = aqdj.a(this.app, 1, (String)localObject5);
            this.yA.add(new WeakReference(localObject7));
            ((ImageView)localObject6).setBackgroundDrawable((Drawable)localObject7);
            localObject6 = (TextView)((View)localObject4).findViewById(2131372369);
            ((TextView)((View)localObject4).findViewById(2131381221)).setText((CharSequence)localObject5);
            localObject7 = (Button)((View)localObject4).findViewById(2131362207);
            ((Button)localObject7).setVisibility(0);
            localObject8 = new a();
            ((a)localObject8).uin = ((String)localObject5);
            ((a)localObject8).nickName = aqgv.c(this.app, (String)localObject5, true);
            ((a)localObject8).bSt = false;
            ((View)localObject4).setTag(localObject8);
            ((TextView)localObject6).setText(((a)localObject8).nickName);
            ((Button)localObject7).setTag(localObject8);
            ((Button)localObject7).setOnClickListener(new adzd(this));
            localObject5 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this, 70.0F));
            this.iw.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject7 = (String)((Iterator)localObject2).next();
            localObject3 = LayoutInflater.from(this).inflate(2131561247, null);
            localObject4 = (ImageView)((View)localObject3).findViewById(2131368698);
            localObject5 = (TextView)((View)localObject3).findViewById(2131372369);
            localObject8 = (TextView)((View)localObject3).findViewById(2131381221);
            localObject6 = (Button)((View)localObject3).findViewById(2131362207);
            ((Button)localObject6).setVisibility(0);
            ((TextView)localObject8).setText((CharSequence)localObject7);
            localObject8 = paramBusinessCard.getMobileInfoByMobile((String)localObject7);
            a locala = new a();
            locala.bSt = true;
            if (localObject8 != null)
            {
              localObject7 = aqdj.a(this.app, 11, ((CardMobileInfo)localObject8).bwv);
              this.yA.add(new WeakReference(localObject7));
              ((ImageView)localObject4).setBackgroundDrawable((Drawable)localObject7);
              locala.uin = ((CardMobileInfo)localObject8).bwv;
            }
            for (locala.nickName = ((CardMobileInfo)localObject8).nickName;; locala.nickName = ((String)localObject7))
            {
              ((View)localObject3).setTag(locala);
              ((TextView)localObject5).setText(locala.nickName);
              ((Button)localObject6).setTag(locala);
              ((Button)localObject6).setOnClickListener(new adze(this));
              localObject4 = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this, 70.0F));
              this.iw.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
              break;
              locala.uin = ((String)localObject7);
            }
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            a(this.iw, (String)localObject2, 0);
          }
        }
        a(this.iw, null, 0);
      }
      this.ix.removeAllViews();
      localObject1 = (LinearLayout)this.jL.findViewById(2131365754);
      Object localObject2 = this.jL.findViewById(2131365733);
      if (paramBusinessCard.descs.isEmpty()) {
        break label1162;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      ((View)localObject2).setVisibility(0);
      localObject1 = new StringBuilder();
      paramBusinessCard = paramBusinessCard.descs.iterator();
      while (paramBusinessCard.hasNext())
      {
        localObject2 = (String)paramBusinessCard.next();
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append("\n");
        }
        ((StringBuilder)localObject1).append((String)localObject2);
      }
      if (!TextUtils.isEmpty(((StringBuilder)localObject1).toString())) {
        a(this.ix, ((StringBuilder)localObject1).toString(), 2);
      }
    }
    return;
    label1162:
    ((LinearLayout)localObject1).setVisibility(8);
    ((LinearLayout)localObject1).setVisibility(8);
  }
  
  private void initData()
  {
    this.mIntent = super.getIntent();
    this.cLC = this.mIntent.getIntExtra("mode_type", 0);
    this.isEditMode = this.mIntent.getBooleanExtra("is_edit_mode", false);
    this.mCardId = this.mIntent.getStringExtra("cur_card_id");
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = ((BusinessCard)this.mIntent.getParcelableExtra("cur_card_body"));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo = ((CardOCRInfo)this.mIntent.getParcelableExtra("cur_ocr_info"));
    this.cLD = this.mIntent.getIntExtra("source_activity", 0);
    this.bSn = this.mIntent.getBooleanExtra("finish_immedia", false);
    this.bwq = this.mIntent.getStringExtra("has_local_remark");
    this.yA = new ArrayList();
    this.jdField_a_of_type_Adyp = ((adyp)this.app.getManager(112));
    if (this.mCardId != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = this.jdField_a_of_type_Adyp.a(this.mCardId);
      if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        ThreadManager.post(new BusinessCardEditActivity.1(this), 8, null, true);
      }
      if (this.cLC != 3)
      {
        adyr.a(this.app, this.mCardId, false, 3);
        if ((this.cLC == 2) && (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl))) {
          this.cLE = 0;
        }
        if (this.cLC != 2) {
          break label329;
        }
        this.cLF = 1;
      }
    }
    for (;;)
    {
      this.app.registObserver(this.jdField_a_of_type_Adyq);
      clF();
      addObserver(this.c);
      return;
      adyr.a(this.app, this.mCardId, true, 3);
      break;
      if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) {
        break;
      }
      this.mCardId = this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId;
      break;
      label329:
      if (this.cLC == 3) {
        this.cLF = 2;
      } else {
        this.cLF = 0;
      }
    }
  }
  
  private void initUI()
  {
    super.setContentView(2131561242);
    this.mRootView = ((RelativeLayout)findViewById(2131377565));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.mRootView.setFitsSystemWindows(true);
    }
    cVm();
    cVn();
    this.yp = ((ImageView)findViewById(2131364315));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131364305));
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setTag("name");
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(96, 1);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText = ((ClearEllipsisEditText)findViewById(2131364283));
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setOnEditorActionListener(this);
    this.jdField_b_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.setMaxLength(30, 2);
    this.jK = ((RelativeLayout)findViewById(2131366245));
    this.jL = ((RelativeLayout)findViewById(2131365978));
    if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      Hg(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl);
      H(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    for (;;)
    {
      GW(true);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null)
      {
        Hg(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.picUrl);
        H(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.name, null, true);
      }
      else
      {
        Hg(null);
        H(null, null, true);
      }
    }
  }
  
  private void t(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.isEditMode = paramBoolean1;
    cVn();
    if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
    {
      if (paramBoolean2) {
        Hg(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.picUrl);
      }
      H(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, true);
    }
    GW(paramBoolean3);
  }
  
  public void GW(boolean paramBoolean)
  {
    if (this.isEditMode)
    {
      this.jL.setVisibility(8);
      this.jK.setVisibility(0);
      this.iv = ((LinearLayout)this.jK.findViewById(2131371874));
      this.iw = ((LinearLayout)this.jK.findViewById(2131374912));
      this.ix = ((LinearLayout)this.jK.findViewById(2131365738));
      this.QT = ((TextView)this.jK.findViewById(2131371868));
      this.QT.setVisibility(0);
      this.QT.setOnClickListener(this);
      this.QU = ((TextView)this.jK.findViewById(2131374740));
      this.QU.setVisibility(0);
      this.QU.setOnClickListener(this);
      this.QV = ((TextView)this.jK.findViewById(2131365731));
      this.QV.setVisibility(8);
      this.QV.setOnClickListener(this);
      if (afU())
      {
        this.jK.findViewById(2131374913).setVisibility(8);
        this.QU.setVisibility(8);
      }
      if (paramBoolean) {
        a(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard, this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
      }
    }
    do
    {
      do
      {
        return;
        this.jL.setVisibility(0);
        this.jK.setVisibility(8);
        this.iv = ((LinearLayout)this.jL.findViewById(2131371874));
        this.iw = ((LinearLayout)this.jL.findViewById(2131374912));
        this.ix = ((LinearLayout)this.jL.findViewById(2131365738));
        if (afU())
        {
          this.jL.findViewById(2131374913).setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.w("BusinessCard_EditActivity", 2, "名片备注不应该出现详情态");
          }
        }
      } while (!paramBoolean);
      if (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)
      {
        f(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null);
    a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
  }
  
  public void Hh(String paramString)
  {
    ausj localausj = ausj.b(this);
    localausj.addButton(2131700744);
    localausj.addButton(2131700780);
    localausj.addCancelButton(2131721058);
    localausj.a(new adyt(this, paramString, localausj));
    localausj.show();
  }
  
  public void I(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    if (paramBoolean)
    {
      j = 2;
      i = 2;
    }
    super.startActivity(AddFriendLogicActivity.a(this, i, paramString1, null, 3026, j, paramString2, null, BusinessCardEditActivity.class.getName(), setLastActivityName(), null));
    anot.a(this.app, "CliOper", "", "", "0X80064E6", "0X80064E6", 0, 0, "", "", "", "");
  }
  
  public void LL(int paramInt)
  {
    Intent localIntent = new Intent(this, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 9999);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_max", 1);
    startActivityForResult(localIntent, paramInt);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt)
  {
    TextView localTextView = new TextView(this);
    localTextView.setText(paramString);
    localTextView.setTextSize(16.0F);
    localTextView.setHint(acfp.m(2131703321));
    localTextView.setTextColor(super.getResources().getColor(2131167304));
    localTextView.setGravity(16);
    localTextView.setBackgroundDrawable(super.getResources().getDrawable(2130851371));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, aqcx.dip2px(this, 44.0F));
    localTextView.setPadding(wja.dp2px(28.0F, getResources()), 0, wja.dp2px(50.0F, getResources()), 0);
    if (paramInt == 1)
    {
      localTextView.setTag(paramString);
      localTextView.setOnClickListener(new adzf(this));
      paramString = localLayoutParams;
    }
    for (;;)
    {
      paramLinearLayout.addView(localTextView, paramString);
      return;
      paramString = localLayoutParams;
      if (paramInt == 2)
      {
        paramString = new LinearLayout.LayoutParams(-1, -2);
        localTextView.setMinHeight(aqcx.dip2px(this, 44.0F));
        localTextView.setPadding(wja.dp2px(28.0F, getResources()), wja.dp2px(12.0F, getResources()), wja.dp2px(50.0F, getResources()), wja.dp2px(10.0F, getResources()));
      }
    }
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2)
  {
    a(paramLinearLayout, paramString, paramInt1, paramInt2, false);
  }
  
  public void a(LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, wja.dp2px(44.0F, getResources()));
    Object localObject;
    if (paramInt1 != 2)
    {
      localObject = new ClearableEditText(this);
      ((EditText)localObject).setInputType(2);
      ((EditText)localObject).setSingleLine();
      ((EditText)localObject).setHint(2131700762);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130851371));
      ((EditText)localObject).setCompoundDrawablePadding(wja.dp2px(5.0F, getResources()));
      ((EditText)localObject).setPadding(wja.dp2px(28.0F, getResources()), 0, wja.dp2px(10.0F, getResources()), 0);
    }
    for (;;)
    {
      ((EditText)localObject).setText(paramString);
      ((EditText)localObject).setTextSize(16.0F);
      ((EditText)localObject).setTextColor(super.getResources().getColor(2131167304));
      ((EditText)localObject).setHintTextColor(super.getResources().getColor(2131165573));
      ((EditText)localObject).setGravity(16);
      paramLinearLayout.addView((View)localObject, localLayoutParams);
      ((EditText)localObject).addTextChangedListener(new b(paramInt2, (EditText)localObject));
      if (paramBoolean)
      {
        ((EditText)localObject).setSelection(((EditText)localObject).getText().toString().length());
        ((EditText)localObject).postDelayed(new BusinessCardEditActivity.2(this, (EditText)localObject), 100L);
      }
      return;
      localObject = new EditText(this);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      ((EditText)localObject).setBackgroundDrawable(super.getResources().getDrawable(2130851371));
      ((EditText)localObject).setMinHeight(aqcx.dip2px(this, 44.0F));
      ((EditText)localObject).setOnEditorActionListener(this);
      ((EditText)localObject).setPadding(wja.dp2px(28.0F, getResources()), wja.dp2px(12.0F, getResources()), wja.dp2px(50.0F, getResources()), wja.dp2px(10.0F, getResources()));
      ((EditText)localObject).setHint(2131700755);
    }
  }
  
  public boolean afU()
  {
    return (this.cLC == 3) || (this.cLC == 2) || (this.cLD == 2);
  }
  
  public void aqz()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  protected void cVm()
  {
    this.HV = ((TextView)findViewById(2131369627));
    this.Cr = ((TextView)findViewById(2131369579));
    this.Cr.setOnClickListener(this);
    this.QS = ((TextView)findViewById(2131369612));
    this.QS.setOnClickListener(this);
    this.iu = ((LinearLayout)findViewById(2131363617));
    this.cl = ((Button)findViewById(2131363640));
    this.cl.setOnClickListener(this);
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    new arie(this).V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  void clG()
  {
    if (this.d != null) {}
    try
    {
      this.app.getApp().getContentResolver().unregisterContentObserver(this.d);
      this.d = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BusinessCard_EditActivity", 2, localThrowable.getMessage(), localThrowable);
        }
      }
    }
  }
  
  public void dN(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Arhz == null) {
        this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Arhz.setMessage(paramString);
      this.jdField_a_of_type_Arhz.setCancelable(false);
    } while (isFinishing());
    this.jdField_a_of_type_Arhz.show();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user denied = ");
    this.bSr = false;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      }
    } while ((paramIntent == null) || (!this.isEditMode));
    paramIntent = (ResultRecord)paramIntent.get(0);
    paramInt2 = 0;
    while (paramInt2 < this.iw.getChildCount())
    {
      Object localObject = this.iw.getChildAt(paramInt2);
      if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof Integer)) && (paramInt1 == ((Integer)((View)localObject).getTag()).intValue()))
      {
        localObject = (EditText)((View)localObject).findViewById(2131374910);
        if (localObject != null)
        {
          ((EditText)localObject).setText(paramIntent.uin);
          return;
          if ((!this.isEditMode) || (!paramIntent.getBooleanExtra("delete_pic", false))) {
            break;
          }
          this.bSq = true;
          Hg(null);
          return;
          paramIntent.putExtra("selfSet_leftViewText", getString(2131720735));
          localObject = wja.a(new Intent(this, SplashActivity.class), null);
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          startActivity((Intent)localObject);
          return;
        }
      }
      paramInt2 += 1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    initData();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.c);
    clG();
    this.app.unRegistObserver(this.jdField_a_of_type_Adyq);
    Iterator localIterator = this.yA.iterator();
    while (localIterator.hasNext())
    {
      aqdj localaqdj = (aqdj)((WeakReference)localIterator.next()).get();
      if (localaqdj != null) {
        localaqdj.cancel();
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.bSs = false;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.cLF != 0) {
      anot.a(this.app, "CliOper", "", "", "0X8007751", "0X8007751", this.cLF, 0, "", "", "", "");
    }
  }
  
  public void el(String paramString, int paramInt)
  {
    View localView = LayoutInflater.from(this).inflate(2131561246, null);
    localView.setTag(Integer.valueOf(paramInt));
    EditText localEditText = (EditText)localView.findViewById(2131374910);
    localEditText.addTextChangedListener(new b(15, localEditText));
    localEditText.setText(paramString);
    paramString = (ImageView)localView.findViewById(2131362234);
    paramString.setTag(Integer.valueOf(paramInt));
    paramString.setOnClickListener(new adyz(this));
    this.iw.addView(localView);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    if (this.bSr) {
      ThreadManager.post(new BusinessCardEditActivity.11(this), 8, null, true);
    }
    this.bSr = false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    aurd.cE(this);
    if (this.isEditMode)
    {
      BusinessCard localBusinessCard = new BusinessCard();
      a(localBusinessCard, false);
      if (a(localBusinessCard, this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
      {
        Hi(super.getResources().getString(2131697232));
        return true;
      }
      if ((this.isEditMode) && (this.bSn) && (!isFinishing()))
      {
        finish();
        return true;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardId)))
      {
        super.finish();
        return true;
      }
      t(false, false, false);
      return true;
    }
    super.finish();
    return true;
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
      onBackEvent();
      continue;
      Object localObject2;
      Object localObject1;
      if (this.isEditMode)
      {
        aurd.cE(this);
        localObject2 = new BusinessCard();
        a((BusinessCard)localObject2, true);
        if (this.bSo)
        {
          b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo);
          this.bSo = false;
        }
        if ((this.cLC == 2) && (this.bwq != null))
        {
          ((adyp)this.app.getManager(112)).a(((BusinessCard)localObject2).bindUin, (BusinessCard)localObject2);
          if (!isFinishing())
          {
            localObject1 = getIntent();
            this.bwq = this.jdField_a_of_type_ComTencentMobileqqBusinessCardViewsClearEllipsisEditText.sZ();
            ((Intent)localObject1).putExtra("has_local_remark", this.bwq);
            setResult(-1, (Intent)localObject1);
            finish();
          }
        }
        while (this.cLF != 0)
        {
          anot.a(this.app, "CliOper", "", "", "0X8007754", "0X8007754", this.cLF, 0, "", "", "", "");
          break;
          if ((this.cLC == 2) && (this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null)) {
            cb(this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.bindUin, getIntent().getBooleanExtra("notify_plugin", false));
          }
          if (a((BusinessCard)localObject2, this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard))
          {
            if (!aqiw.isNetSupport(this))
            {
              cf(2131696348, 1);
              break;
            }
            localObject1 = Boolean.valueOf(false);
            if (this.cLC == 3) {
              localObject1 = Boolean.valueOf(true);
            }
            if ((((BusinessCard)localObject2).cardId != null) && (((BusinessCard)localObject2).cardId.length() > 0))
            {
              adyr.b(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
              dN(acfp.m(2131703304));
              continue;
            }
            adyr.a(this.app, (BusinessCard)localObject2, ((Boolean)localObject1).booleanValue());
            dN(acfp.m(2131703299));
            continue;
          }
          if ((this.isEditMode) && (this.bSn) && (!isFinishing())) {
            finish();
          } else {
            t(false, false, false);
          }
        }
      }
      t(true, false, true);
      anot.a(this.app, "CliOper", "", "", "0X80064E2", "0X80064E2", 0, 0, "", "", "", "");
      continue;
      if ((this.jdField_b_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) || (this.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo != null))
      {
        this.bSr = true;
        requestPermissions(new adys(this), 1, new String[] { "android.permission.WRITE_CONTACTS" });
        continue;
        a(this.iv, null, 1, 15);
        this.cLz += 1;
        if (this.cLz >= 3) {
          this.QT.setVisibility(8);
        }
        if (this.cLF != 0)
        {
          anot.a(this.app, "CliOper", "", "", "0X8007752", "0X8007752", this.cLF, 0, "", "", "", "");
          continue;
          el(null, this.cLA);
          this.cLA += 1;
          if (this.cLA >= 2)
          {
            this.QU.setVisibility(8);
            continue;
            a(this.ix, null, 2, 150);
            this.cLB += 1;
            if (this.cLB >= 2)
            {
              this.QV.setVisibility(8);
              continue;
              localObject1 = new Intent(this, CardPicGalleryActivity.class);
              localObject2 = new ArrayList();
              if (!TextUtils.isEmpty(this.bwp)) {
                ((ArrayList)localObject2).add(this.bwp);
              }
              ((Intent)localObject1).putStringArrayListExtra("business_card_pics", (ArrayList)localObject2);
              ((Intent)localObject1).putExtra("is_edit_mode", this.isEditMode);
              if ((this.cLD == 1) || (this.cLD == 3)) {
                ((Intent)localObject1).putExtra("is_from_profile", true);
              }
              startActivityForResult((Intent)localObject1, 11);
              overridePendingTransition(2130772376, 0);
            }
          }
        }
      }
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent == null) {}
    while (paramKeyEvent.getKeyCode() != 66) {
      return false;
    }
    return true;
  }
  
  public class a
  {
    public boolean bSt;
    public String nickName;
    public String uin;
    
    a() {}
  }
  
  class b
    implements TextWatcher
  {
    boolean bInit = true;
    String bws = "";
    EditText mEditText;
    boolean mHasChanged = false;
    int mMaxBytes;
    int mTag;
    
    public b(int paramInt, EditText paramEditText)
    {
      this.mMaxBytes = paramInt;
      this.mEditText = paramEditText;
      this.mTag = 0;
    }
    
    public b(int paramInt1, EditText paramEditText, int paramInt2)
    {
      this.mMaxBytes = paramInt1;
      this.mEditText = paramEditText;
      this.mTag = paramInt2;
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      int j = 1;
      boolean bool;
      label69:
      int i;
      if ((this.mTag == 1) && (!this.bws.equals(paramEditable.toString())))
      {
        if (this.bInit)
        {
          bool = this.mHasChanged;
          this.mHasChanged = bool;
        }
      }
      else
      {
        this.bInit = false;
        if (!(this.mEditText instanceof ClearEllipsisEditText)) {
          break label155;
        }
        paramEditable = ((ClearEllipsisEditText)this.mEditText).sZ();
        i = paramEditable.length();
        if ((this.mEditText.getTag() == null) || (!((String)this.mEditText.getTag()).equals("name"))) {
          break label197;
        }
        i = paramEditable.getBytes().length;
      }
      for (;;)
      {
        if (i > this.mMaxBytes)
        {
          for (;;)
          {
            if (i <= this.mMaxBytes) {
              break label177;
            }
            paramEditable = paramEditable.substring(0, paramEditable.length() - 1);
            if (j != 0)
            {
              i = paramEditable.getBytes().length;
              continue;
              bool = true;
              break;
              label155:
              paramEditable = this.mEditText.getText().toString();
              break label69;
            }
            i = paramEditable.length();
          }
          label177:
          this.mEditText.setText(paramEditable);
          this.mEditText.setSelection(paramEditable.length());
        }
        return;
        label197:
        j = 0;
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.bws = paramCharSequence.toString();
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity
 * JD-Core Version:    0.7.0.1
 */