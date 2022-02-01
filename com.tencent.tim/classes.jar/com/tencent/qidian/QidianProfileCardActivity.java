package com.tencent.qidian;

import acbn;
import accn;
import acfd;
import acff;
import acfp;
import adzx;
import ahgq;
import ahyh;
import albb;
import alcn;
import alkw;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anlm;
import apuh;
import aqdj;
import aqep;
import aqft;
import aqgv;
import aqha;
import aqhu;
import aqju;
import arhz;
import arie;
import asgx;
import asgz;
import asha;
import ashc;
import ashd;
import ashe;
import ashf;
import ashg;
import ashh;
import ashi;
import ashj;
import ashk;
import ashl;
import ashm;
import ashn;
import asho;
import ashp;
import ashq;
import ashr;
import ashs;
import asht;
import ashx;
import ashy;
import asib;
import asic;
import ausc;
import ausj;
import auss;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.a;
import com.tencent.qidian.data.QidianProfileUiInfo.b;
import com.tencent.qidian.data.QidianProfileUiInfo.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jos;
import jou;
import jqc;
import jqs;
import ocp;
import wja;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  private TextView BM;
  Dialog C;
  private ImageView Fo;
  private ImageView Fp;
  public ImageView Gv;
  private TextView Pb;
  private acfd jdField_a_of_type_Acfd = new asgz(this);
  ahyh jdField_a_of_type_Ahyh = new ahyh("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.Gg());
  public alcn a;
  public asgx a;
  public CardHandler a;
  private c jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c;
  private jos jdField_a_of_type_Jos = new ashh(this);
  private RelativeLayout aG;
  public int accountType = 4;
  private TextView ado;
  private ausj as;
  private ausj at;
  private View.OnLongClickListener jdField_b_of_type_AndroidViewView$OnLongClickListener = new asha(this);
  private arie jdField_b_of_type_Arie;
  private ashx jdField_b_of_type_Ashx = new ashg(this);
  public BmqqUserSimpleInfo b;
  private BounceScrollView jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView;
  PhotoWallViewForQiDianProfile.b jdField_b_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$b = new ashr(this);
  private QidianCorpInfo jdField_b_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo b;
  private QidianProfileUiInfo jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo;
  public int bGV;
  public acff c;
  private String cEL = "";
  private String cEM = "";
  private accn cardObserver = new ashf(this);
  private boolean dex;
  private boolean dey;
  int dp10;
  int dp16;
  int dp8;
  public int emb;
  private boolean isNightMode;
  public ConcurrentHashMap<String, b> jC;
  public ConcurrentHashMap<String, Drawable> jD;
  private LinearLayout lK;
  public LinearLayout lL;
  public Bitmap mAvatarBitmap;
  public LinearLayout mContainer;
  aqju mDialog;
  public ImageView mK;
  private View.OnClickListener mOnClickListener = new ashc(this);
  public arhz mProgress;
  
  public QidianProfileCardActivity()
  {
    this.jdField_a_of_type_Alcn = new alcn();
  }
  
  private void XM(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.c == null)) {
      return;
    }
    ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
  }
  
  private void XN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = "https://" + paramString;
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", str);
    paramString.putExtra("isShowAd", false);
    paramString.putExtra("big_brother_source_key", "biz_src_qycp");
    startActivity(paramString);
  }
  
  private void XR(String paramString)
  {
    Object localObject = (ClipboardManager)getSystemService("clipboard");
    alkw.a((ClipboardManager)localObject, paramString);
    ((ClipboardManager)localObject).setText(paramString);
    if (aHT())
    {
      paramString = new Intent();
      localObject = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
      paramString.setAction("android.intent.action.MAIN");
      paramString.addCategory("android.intent.category.LAUNCHER");
      paramString.addFlags(268435456);
      paramString.setComponent((ComponentName)localObject);
      startActivity(paramString);
      return;
    }
    XN("https://weixin.qq.com/d");
  }
  
  private void Zs(int paramInt)
  {
    if (paramInt == 4) {
      showLoading(2131697483);
    }
    if (this.jdField_a_of_type_Asgx.P(this.jdField_a_of_type_Alcn.e.uin, true)) {
      this.jdField_a_of_type_Asgx.dI(this.jdField_a_of_type_Alcn.e.uin, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((ashy)this.app.getBusinessHandler(85)).mw(Long.parseLong(this.jdField_a_of_type_Alcn.e.uin));
      }
      return;
      if (this.jdField_a_of_type_Asgx.Q(this.jdField_a_of_type_Alcn.e.uin, false))
      {
        BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_Alcn.e.uin, 1);
        this.jdField_a_of_type_Asgx.b(this, localBmqqAccountType);
      }
      else
      {
        this.jdField_a_of_type_Asgx.XL(this.jdField_a_of_type_Alcn.e.uin);
      }
    }
  }
  
  private void Zt(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c.postDelayed(new QidianProfileCardActivity.3(this, paramInt), 0L);
  }
  
  private void Zv(int paramInt)
  {
    Object localObject1 = "";
    Object localObject2 = "";
    String str1;
    Object localObject3;
    if ((paramInt == 1) || (paramInt == 6))
    {
      str1 = getDisplayName();
      localObject3 = localObject2;
      localObject1 = str1;
      if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo == null) {
        break label244;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.job))
      {
        localObject2 = this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.job;
        if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.verity != 1) {}
      }
      localObject3 = localObject2;
      localObject1 = str1;
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.sign)) {
        break label244;
      }
      String str2 = this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.sign;
      localObject1 = str1;
      localObject3 = localObject2;
      localObject2 = str2;
    }
    for (;;)
    {
      this.BM.setText((CharSequence)localObject1);
      this.ado.setText((CharSequence)localObject3);
      this.Pb.setText((CharSequence)localObject2);
      if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
      for (;;)
      {
        return;
        if (paramInt != 0)
        {
          localObject3 = localObject2;
          if (paramInt != 2) {
            break label244;
          }
        }
        str1 = getDisplayName();
        localObject3 = localObject2;
        localObject1 = str1;
        if (this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null) {
          break label244;
        }
        localObject3 = localObject2;
        localObject1 = str1;
        if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle)) {
          break label244;
        }
        localObject3 = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle;
        localObject2 = "";
        localObject1 = str1;
        break;
        if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.verity == 2) {}
        for (paramInt = 1; (paramInt != 0) && (this.Gv != null); paramInt = 0)
        {
          this.Gv.setVisibility(4);
          return;
        }
      }
      label244:
      localObject2 = "";
    }
  }
  
  private void Zw(int paramInt)
  {
    this.lL.removeAllViews();
    Iterator localIterator;
    if ((paramInt == 1) || (paramInt == 6))
    {
      if (this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo != null) {
        localIterator = this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo.getConfigGroupInfos().iterator();
      }
    }
    else {
      while (localIterator.hasNext())
      {
        a((QidianProfileUiInfo.b)localIterator.next());
        continue;
        if ((paramInt == 0) || (paramInt == 2)) {
          ens();
        }
      }
    }
  }
  
  private albb a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new albb(52, paramString2);
    case 2: 
      return new albb(4, paramString2);
    case 3: 
      return new albb(47, paramString2);
    case 4: 
      return new albb(48, new String[] { paramString1, paramString2 });
    case 7: 
      return new albb(54, paramString3);
    case 6: 
      return new albb(75, paramString2);
    case 5: 
      return new albb(76, paramString3);
    }
    return new albb(82, paramString3);
  }
  
  public static Bitmap a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    paramQQAppInterface = paramURLDrawable.getCurrDrawable();
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface instanceof BitmapDrawable))
      {
        paramURLDrawable = ((BitmapDrawable)paramQQAppInterface).getBitmap();
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          paramQQAppInterface = QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
      do
      {
        do
        {
          return paramQQAppInterface;
          if (!(paramQQAppInterface instanceof SkinnableBitmapDrawable)) {
            break;
          }
          paramURLDrawable = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
          paramQQAppInterface = paramURLDrawable;
        } while (!paramBoolean);
        return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        paramURLDrawable = aqhu.g(paramQQAppInterface);
        paramQQAppInterface = paramURLDrawable;
      } while (!paramBoolean);
      return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
    }
    return null;
  }
  
  public static Message a(Parcelable paramParcelable)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramParcelable);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message a(ArrayList<Parcelable> paramArrayList)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("data", paramArrayList);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  private View a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    View localView = View.inflate(this, paramInt2, null);
    int i = getResources().getDimensionPixelSize(2131298485);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131381048);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.isNightMode)
    {
      if (paramInt2 != 2131561090) {
        break label127;
      }
      localButton.setBackgroundResource(2130845276);
      localButton.setTextColor(getResources().getColor(2131166520));
    }
    for (;;)
    {
      this.lK.addView(localView, localLayoutParams);
      return localButton;
      label127:
      if (paramInt2 == 2131561089)
      {
        localButton.setBackgroundResource(2130845275);
        localButton.setTextColor(getResources().getColor(2131166519));
      }
    }
  }
  
  private void a(QidianProfileUiInfo.b paramb)
  {
    paramb = paramb.JR;
    if (paramb != null)
    {
      int j = paramb.size();
      int i = 0;
      if (i < j)
      {
        QidianProfileUiInfo.c localc = (QidianProfileUiInfo.c)paramb.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localc, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(QidianProfileUiInfo.c paramc, boolean paramBoolean)
  {
    if (paramc != null) {
      switch (paramc.type)
      {
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        ent();
      }
      return;
      b(paramc, paramBoolean);
      continue;
      if ((this.accountType != 1) && (this.accountType != 4))
      {
        c(paramc, paramBoolean);
        continue;
        if ((this.accountType != 1) && (this.accountType != 4))
        {
          d(paramc, paramBoolean);
          continue;
          b(paramc, paramBoolean);
        }
      }
    }
  }
  
  private boolean aHT()
  {
    return ausc.bb(getApplicationContext(), "com.tencent.mm");
  }
  
  private void b(QidianProfileUiInfo.c paramc, boolean paramBoolean)
  {
    if ((paramc.content == null) || ((TextUtils.isEmpty(paramc.content.trim())) && (!paramc.title.equals(acfp.m(2131711158))))) {
      return;
    }
    QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianSimpleProfileItem();
    localQidianSimpleProfileItem.title = paramc.title;
    localQidianSimpleProfileItem.content = paramc.content;
    localQidianSimpleProfileItem.type = paramc.type;
    localQidianSimpleProfileItem.aqA = paramc.aqA;
    String str;
    if (!TextUtils.isEmpty(paramc.cET))
    {
      str = paramc.cET;
      localQidianSimpleProfileItem.action = str;
      if (localQidianSimpleProfileItem.aqA == 0) {
        break label161;
      }
    }
    label161:
    for (boolean bool = true;; bool = false)
    {
      localQidianSimpleProfileItem.isClickable = bool;
      localQidianSimpleProfileItem.cNv = paramBoolean;
      localQidianSimpleProfileItem.deA = paramc.deA;
      paramc = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c.sendMessage(paramc);
      return;
      str = paramc.action;
      break;
    }
  }
  
  private void c(QidianProfileUiInfo.c paramc, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
    do
    {
      return;
      localObject = this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems();
    } while ((localObject == null) || (((List)localObject).size() <= 0) || (localObject == null) || (((List)localObject).size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      asic localasic = (asic)((Iterator)localObject).next();
      QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianCompoundProfileItem();
      localQidianCompoundProfileItem.type = localasic.type;
      localQidianCompoundProfileItem.uin = localasic.uin;
      localQidianCompoundProfileItem.name = localasic.name.trim();
      if (localasic.verity == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.isVerified = bool;
        localQidianCompoundProfileItem.title = paramc.title;
        localQidianCompoundProfileItem.cNv = paramBoolean;
        localQidianCompoundProfileItem.faceUrl = localasic.faceUrl;
        localQidianCompoundProfileItem.cEP = localasic.cEP;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    paramc = a(localArrayList);
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c.sendMessage(paramc);
  }
  
  private void clearData()
  {
    if (this.jC != null) {
      this.jC.clear();
    }
    if (this.jD != null) {
      this.jD.clear();
    }
    this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo = null;
    this.jdField_b_of_type_ComTencentQidianDataQidianCorpInfo = null;
    this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo = null;
    this.as = null;
    this.at = null;
    this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = null;
  }
  
  private void d(URLDrawable paramURLDrawable, String paramString)
  {
    ThreadManager.executeOnFileThread(new SavePhotoRunnable(this, paramURLDrawable, paramString));
  }
  
  private void d(QidianProfileUiInfo.c paramc, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
    do
    {
      return;
      localObject = this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems();
    } while ((localObject == null) || (((List)localObject).size() <= 0) || (localObject == null) || (((List)localObject).size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      asib localasib = (asib)((Iterator)localObject).next();
      QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianCompoundProfileItem();
      localQidianCompoundProfileItem.type = paramc.type;
      localQidianCompoundProfileItem.uin = String.valueOf(localasib.mN);
      localQidianCompoundProfileItem.name = localasib.name.trim();
      localQidianCompoundProfileItem.title = paramc.title;
      localQidianCompoundProfileItem.cNv = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    paramc = a(localArrayList);
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c.sendMessage(paramc);
  }
  
  private void ens()
  {
    QidianProfileUiInfo.b localb;
    QidianProfileUiInfo.c localc;
    if (this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localb = new QidianProfileUiInfo.b();
      localb.JR = new ArrayList(5);
      new QidianProfileUiInfo.c();
      localc = new QidianProfileUiInfo.c();
      localc.type = 1;
      localc.aqA = 0;
      localc.title = acfp.m(2131711165);
      localc.content = this.jdField_a_of_type_Alcn.e.uin;
      localb.JR.add(localc);
      localc = new QidianProfileUiInfo.c();
      localc.type = 1;
      localc.aqA = 2;
      localc.title = getResources().getString(2131700186);
      localc.content = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localc.action = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localb.JR.add(localc);
      localc = new QidianProfileUiInfo.c();
      localc.type = 1;
      localc.aqA = 1;
      localc.title = getResources().getString(2131720734);
      localc.content = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localc.action = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localb.JR.add(localc);
      localc = new QidianProfileUiInfo.c();
      localc.type = 1;
      localc.aqA = 3;
      localc.title = getResources().getString(2131695599);
      localc.content = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localc.action = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localb.JR.add(localc);
      localc = new QidianProfileUiInfo.c();
      localc.type = 1;
      localc.title = getResources().getString(2131697196);
      localc.content = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!jou.A(getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!jou.de(this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label428;
      }
      localc.aqA = 7;
      localc.cET = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localc.deA = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localc.deA = this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localb.JR.add(localc);
      a(localb);
      return;
      label428:
      localc.aqA = 0;
    }
  }
  
  private void ent()
  {
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c.post(new QidianProfileCardActivity.8(this));
  }
  
  private void env()
  {
    ThreadManager.executeOnSubThread(new QidianProfileCardActivity.11(this));
  }
  
  private void g(URLDrawable paramURLDrawable, String paramString)
  {
    ausj localausj = ausj.d(this);
    localausj.addButton(2131694752);
    localausj.addButton(2131694762);
    localausj.addButton(2131700357);
    localausj.addCancelButton(2131721058);
    localausj.a(new ashk(this, localausj, paramURLDrawable, paramString));
    localausj.show();
  }
  
  private String getDisplayName()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.remark)) {
      return this.jdField_a_of_type_Alcn.e.remark;
    }
    if (this.accountType == 0)
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName))) {
        return this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName;
      }
    }
    else if (((this.accountType == 1) || (this.accountType == 6)) && (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo != null))
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.nickname)) {
        return this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.uin;
      }
      return this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
    }
    return this.jdField_a_of_type_Alcn.e.uin;
  }
  
  private void iN(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, QQMapActivity.class);
    localIntent.putExtra("lat", paramString1);
    localIntent.putExtra("lon", paramString2);
    startActivity(localIntent);
  }
  
  private void initUI()
  {
    Resources localResources = getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.bGV = (localResources.getDimensionPixelSize(2131299627) - (int)(localDisplayMetrics.density * 66.0F));
    this.lK = ((LinearLayout)findViewById(2131364045));
    this.aG = ((RelativeLayout)findViewById(2131368427));
    this.mK = ((ImageView)findViewById(2131368397));
    this.mK.setOnClickListener(new ashn(this));
    if (!anlm.ayn()) {
      this.mK.setImageDrawable(getResources().getDrawable(2130845272));
    }
    this.Gv = ((ImageView)findViewById(2131381492));
    this.mContainer = ((LinearLayout)findViewById(2131365322));
    this.lL = ((LinearLayout)findViewById(2131369550));
    this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131365101));
    this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new asho(this));
    this.BM = ((TextView)findViewById(2131372190));
    this.ado = ((TextView)findViewById(2131369977));
    this.Pb = ((TextView)findViewById(2131378414));
    findViewById(2131378430).setOnClickListener(new ashp(this));
    this.Fo = ((ImageView)findViewById(2131370394));
    this.Fo.setOnClickListener(new ashq(this));
    this.Fp = ((ImageView)findViewById(2131377339));
    this.Fp.setTag(new albb(53, null));
    this.Fp.setOnClickListener(this.mOnClickListener);
    enu();
  }
  
  private void l(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(acbn.oM).mkdirs();
      str = acbn.oM + Utils.Crc64String(this.jdField_a_of_type_Alcn.e.uin) + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            d(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131696986), 0).show();
          return;
        }
      }
    }
    aqha.a(this, 230).setTitle(getString(2131718959)).setMessage(getString(2131696979)).setPositiveButton(getString(2131718798), new ashm(this, paramURLDrawable, str)).setNegativeButton(getString(2131696322), new ashl(this)).show();
  }
  
  private void vx(String paramString)
  {
    this.jdField_a_of_type_Alcn.e.remark = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_Alcn, 4, paramString);
    FriendProfileCardActivity.b(this.jdField_a_of_type_Alcn);
    paramString = getDisplayName();
    this.BM.setText(paramString);
  }
  
  private void y(URLDrawable paramURLDrawable)
  {
    ThreadManager.executeOnFileThread(new ForwardRunnable(this, paramURLDrawable));
  }
  
  public void Fo(int paramInt)
  {
    Zv(paramInt);
    Zw(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "Show finish");
    }
  }
  
  public void XO(String paramString)
  {
    if (this.at == null)
    {
      this.at = ((ausj)auss.a(this, null));
      this.at.addButton(super.getResources().getStringArray(2130968586)[0], 1);
      if ((this.accountType == 1) && (this.jdField_a_of_type_Asgx.sK(this.jdField_a_of_type_Alcn.e.uin))) {
        this.at.addButton(super.getResources().getStringArray(2130968586)[1]);
      }
      this.at.addCancelButton(super.getResources().getStringArray(2130968586)[2]);
      this.at.a(new ashd(this, paramString));
    }
    this.at.show();
  }
  
  public void XP(String paramString)
  {
    if (this.as == null)
    {
      this.as = ((ausj)auss.a(this, null));
      this.as.addButton(super.getResources().getStringArray(2130968585)[0], 1);
      if ((this.accountType == 1) && (this.jdField_a_of_type_Asgx.sK(this.jdField_a_of_type_Alcn.e.uin))) {
        this.as.addButton(super.getResources().getStringArray(2130968585)[1], 1);
      }
      this.as.addButton(super.getResources().getStringArray(2130968585)[2], 1);
      this.as.addCancelButton(super.getResources().getStringArray(2130968585)[3]);
      this.as.a(new ashe(this, paramString));
    }
    this.as.show();
  }
  
  public void XQ(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    ocp.a(localIntent, this.app, this, paramString, -1);
  }
  
  public void XS(String paramString)
  {
    apuh.a(this, TroopInfoActivity.c(paramString, 31), 2);
  }
  
  public void XT(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void XU(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      super.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    }
  }
  
  public void XV(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
    }
  }
  
  public void Zu(int paramInt)
  {
    EntityManager localEntityManager;
    if (paramInt == 1) {
      localEntityManager = this.app.a().createEntityManager();
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.find(QidianExternalInfo.class, this.jdField_a_of_type_Alcn.e.uin));
        this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.find(QidianProfileUiInfo.class, this.jdField_a_of_type_Alcn.e.uin));
        acff localacff = (acff)this.app.getManager(51);
        this.jdField_a_of_type_Alcn.d = localacff.b(this.jdField_a_of_type_Alcn.e.uin);
        if ((this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_b_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localEntityManager.find(QidianCorpInfo.class, this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
      if ((paramInt == 0) || (paramInt == 2))
      {
        localEntityManager = this.app.a().createEntityManager();
        try
        {
          this.jdField_b_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.find(BmqqUserSimpleInfo.class, this.jdField_a_of_type_Alcn.e.uin));
          return;
        }
        finally
        {
          if (localEntityManager != null) {
            localEntityManager.close();
          }
        }
      }
      if (paramInt != 6) {
        continue;
      }
      localEntityManager = this.app.a().createEntityManager();
      try
      {
        this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.find(QidianExternalInfo.class, this.jdField_a_of_type_Alcn.e.uin));
        this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.find(QidianProfileUiInfo.class, this.jdField_a_of_type_Alcn.e.uin));
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
    }
  }
  
  public void Zx(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      Intent localIntent = new Intent(getActivity(), ChatActivity.class);
      localIntent.addFlags(67108864);
      localObject = null;
      String str = this.jdField_a_of_type_Alcn.e.uin;
      if (this.c.isFriend(str))
      {
        paramInt = 0;
        localObject = aqgv.o(this.app, str);
      }
      for (;;)
      {
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", paramInt);
        if (localObject != null) {
          localIntent.putExtra("uinname", (String)localObject);
        }
        startActivity(localIntent);
        return;
        paramInt = 1025;
      }
    }
    if (paramInt == 6)
    {
      localObject = new Intent(getActivity(), ChatActivity.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Alcn.e.uin);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_Alcn);
  }
  
  public Drawable a(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    URLDrawable localURLDrawable2;
    QQAppInterface localQQAppInterface;
    Drawable localDrawable;
    try
    {
      URLDrawable localURLDrawable1 = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable1 == null) || (localURLDrawable1.getStatus() == 2)) {
        return aqhu.at();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAFaceDrawable load net error, " + localException.getMessage());
        }
        localURLDrawable2 = null;
      }
      if (localURLDrawable2.getStatus() == 1)
      {
        paramURLImageView = this.app;
        if (!anlm.ayn()) {}
        for (bool = true;; bool = false) {
          return new BitmapDrawable(a(paramURLImageView, localURLDrawable2, bool));
        }
      }
      localQQAppInterface = this.app;
      localDrawable = aqhu.at();
      if (anlm.ayn()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramURLImageView.setURLDrawableDownListener(new a(this, localQQAppInterface, paramURLImageView, paramString, localDrawable, bool));
      return localURLDrawable2;
    }
  }
  
  public View a(QidianSimpleProfileItem paramQidianSimpleProfileItem)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    ImageView localImageView;
    label154:
    int i;
    if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711154)))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2131561084, this.lL, false);
      Object localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131370365);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131371508);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131363696);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131377304);
      localImageView = (ImageView)((RelativeLayout)localObject1).findViewById(2131371506);
      ((ImageView)localObject5).setImageResource(2130845278);
      if (this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo != null)
      {
        localObject5 = this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          Iterator localIterator = ((QidianProfileUiInfo.b)((Iterator)localObject5).next()).JR.iterator();
          label427:
          label430:
          for (;;)
          {
            Object localObject6;
            if (localIterator.hasNext())
            {
              localObject6 = (QidianProfileUiInfo.c)localIterator.next();
              if ((!((QidianProfileUiInfo.c)localObject6).title.equals(acfp.m(2131711151))) || (((QidianProfileUiInfo.c)localObject6).a == null)) {
                continue;
              }
              ((TextView)localObject2).setText(((QidianProfileUiInfo.c)localObject6).a.corpName);
              ((TextView)localObject3).setText(((QidianProfileUiInfo.c)localObject6).a.cES);
              ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.aqA, paramQidianSimpleProfileItem.title, ((QidianProfileUiInfo.c)localObject6).a.alE, paramQidianSimpleProfileItem.action));
              this.cEM = ((QidianProfileUiInfo.c)localObject6).a.alE;
              if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo == null) {
                continue;
              }
              if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.verity != 2) {
                break label427;
              }
            }
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) || (!jqc.isValidUrl(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.verify_url))) {
                break label430;
              }
              localObject6 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = getResources().getDrawable(2130845273);
              ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = getResources().getDrawable(2130845273);
              ((URLDrawable.URLDrawableOptions)localObject6).mPlayGifImage = false;
              ((URLDrawable.URLDrawableOptions)localObject6).mGifRoundCorner = 0.0F;
              ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = 20;
              ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = 20;
              localObject6 = URLDrawable.getDrawable(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.verify_url, (URLDrawable.URLDrawableOptions)localObject6);
              if (localImageView == null) {
                break label154;
              }
              localImageView.setMaxWidth(20);
              localImageView.setMaxHeight(20);
              localImageView.setVisibility(0);
              localImageView.setImageDrawable((Drawable)localObject6);
              break label154;
              break;
            }
          }
        }
      }
      if (!paramQidianSimpleProfileItem.isClickable)
      {
        ((ImageView)localObject4).setVisibility(4);
        ((RelativeLayout)localObject1).setLongClickable(true);
        ((RelativeLayout)localObject1).setTag(paramQidianSimpleProfileItem.content);
        ((RelativeLayout)localObject1).setOnLongClickListener(this.jdField_b_of_type_AndroidViewView$OnLongClickListener);
        return localObject1;
      }
      ((RelativeLayout)localObject1).setClickable(true);
      ((RelativeLayout)localObject1).setOnClickListener(this.mOnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      return localObject1;
    }
    if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711148)))
    {
      i = 2130845284;
      label509:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2131561088, this.lL, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131370365);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131371508);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131377304);
      localImageView = (ImageView)((RelativeLayout)localObject2).findViewById(2131371506);
      ((TextView)localObject3).setText(paramQidianSimpleProfileItem.content);
      if (paramQidianSimpleProfileItem.isClickable) {
        break label1018;
      }
      ((ImageView)localObject4).setVisibility(4);
      ((RelativeLayout)localObject2).setLongClickable(true);
      ((RelativeLayout)localObject2).setTag(paramQidianSimpleProfileItem.content);
      ((RelativeLayout)localObject2).setOnLongClickListener(this.jdField_b_of_type_AndroidViewView$OnLongClickListener);
      label626:
      if (!paramQidianSimpleProfileItem.deA) {
        break label1067;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      ((ImageView)localObject1).setImageResource(i);
      localObject1 = localObject2;
      if (!paramQidianSimpleProfileItem.title.equals(acfp.m(2131711159))) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo == null) {
        break;
      }
      localObject3 = this.jdField_b_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((QidianProfileUiInfo.b)((Iterator)localObject3).next()).JR.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (QidianProfileUiInfo.c)((Iterator)localObject1).next();
          if (((QidianProfileUiInfo.c)localObject4).title.equals(acfp.m(2131711155))) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.aqA, paramQidianSimpleProfileItem.title, paramQidianSimpleProfileItem.content, ((QidianProfileUiInfo.c)localObject4).lat + "|" + ((QidianProfileUiInfo.c)localObject4).lng));
          }
        }
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711150)))
      {
        i = 2130845282;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711152)))
      {
        i = 2130845280;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711160)))
      {
        i = 2130846671;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711149)))
      {
        i = 2130845277;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711156)))
      {
        i = 2130845281;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711163)))
      {
        i = 2130845278;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711153)))
      {
        i = 2130845283;
        break label509;
      }
      if (paramQidianSimpleProfileItem.title.equals(acfp.m(2131711162))) {
        return null;
      }
      if (paramQidianSimpleProfileItem.title.equals("QQ空间"))
      {
        i = 2130845285;
        break label509;
      }
      i = 2130845279;
      break label509;
      label1018:
      ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.aqA, paramQidianSimpleProfileItem.title, paramQidianSimpleProfileItem.content, paramQidianSimpleProfileItem.action));
      ((RelativeLayout)localObject2).setClickable(true);
      ((RelativeLayout)localObject2).setOnClickListener(this.mOnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      break label626;
      label1067:
      localImageView.setVisibility(8);
    }
  }
  
  public View a(List<QidianCompoundProfileItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      localObject1 = null;
    }
    LinearLayout localLinearLayout;
    int i;
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return localObject1;
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131561083, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131379401);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131369423);
        ((TextView)localObject1).setText(((QidianCompoundProfileItem)paramList.get(0)).title);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2131561082, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131368698);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131372190);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131364412);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131365721);
    localURLImageView.post(new QidianProfileCardActivity.10(this, (QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianCompoundProfileItem)localObject2).name);
    ((LinearLayout)localObject1).setOnClickListener(this.mOnClickListener);
    if (((QidianCompoundProfileItem)localObject2).type == 0)
    {
      localTextView2.setText(2131700363);
      ((LinearLayout)localObject1).setTag(new albb(49, ((QidianCompoundProfileItem)localObject2).uin));
      label243:
      if ((((QidianCompoundProfileItem)localObject2).type != 0) || (!((QidianCompoundProfileItem)localObject2).isVerified)) {
        break label385;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130843486);
    }
    for (;;)
    {
      localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
      if (i == 0) {
        ((LinearLayout)localObject1).setPadding(0, 0, this.dp8, 0);
      }
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      i += 1;
      break;
      if (((QidianCompoundProfileItem)localObject2).type == 1)
      {
        localTextView2.setText(2131700364);
        ((LinearLayout)localObject1).setTag(new albb(50, ((QidianCompoundProfileItem)localObject2).cEP));
        break label243;
      }
      localTextView2.setText(((QidianCompoundProfileItem)localObject2).uin);
      ((LinearLayout)localObject1).setTag(new albb(51, ((QidianCompoundProfileItem)localObject2).uin));
      break label243;
      label385:
      if ((((QidianCompoundProfileItem)localObject2).type == 1) && (((QidianCompoundProfileItem)localObject2).isVerified))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130845302);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt, URLImageView paramURLImageView, String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramURLImageView == null)) {}
    for (;;)
    {
      return;
      if ((!paramBoolean) && (this.jD.containsKey(paramString)) && (this.jD.get(paramString) != null))
      {
        paramURLImageView.setImageDrawable((Drawable)this.jD.get(paramString));
        return;
      }
      Object localObject;
      if (paramInt == 0) {
        localObject = aqdj.a(this.app, 1, paramString);
      }
      while (localObject != null)
      {
        this.jD.put(paramString, localObject);
        paramURLImageView.setImageDrawable((Drawable)localObject);
        return;
        if (paramInt == 1) {
          localObject = a(paramURLImageView, paramString);
        } else {
          localObject = this.app.l(paramString);
        }
      }
    }
  }
  
  public void a(asic paramasic)
  {
    Object localObject = paramasic.cEP;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.mDialog == null)
    {
      this.mDialog = aqha.b(this, 0, 2131561092, null, null, getString(2131721059), getString(2131721059), new ashi(this), null);
      this.mDialog.setMessageCount(super.getString(2131700362));
      this.mDialog.setCanceledOnTouchOutside(true);
    }
    localObject = b((URLImageView)this.mDialog.framePreviewImage, (String)localObject);
    this.mDialog.setPreviewImage((Drawable)localObject, true, 1);
    if (this.mDialog.getWindow() != null) {
      this.mDialog.getWindow().findViewById(2131367585).setOnLongClickListener(new ashj(this, (Drawable)localObject, paramasic));
    }
    this.mDialog.show();
  }
  
  public void aAt()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
  }
  
  public boolean aHS()
  {
    if (asgx.mR(this.emb)) {
      return true;
    }
    this.accountType = this.jdField_a_of_type_Asgx.g(this.jdField_a_of_type_Alcn.e.uin, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.accountType);
    }
    switch (this.accountType)
    {
    }
    for (;;)
    {
      return false;
      showLoading(2131697483);
      return true;
      jqs.a(this, null, this.jdField_a_of_type_Alcn.e.uin, true, -1, true, -1);
    }
  }
  
  public Drawable b(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable == null) || (localURLDrawable.getStatus() == 2)) {
        return aqhu.at();
      }
    }
    catch (Exception localException)
    {
      Drawable localDrawable;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAQrDrawable load net error, " + localException.getMessage());
        }
        localDrawable = null;
      }
      if (localDrawable.getStatus() == 1) {
        return localDrawable;
      }
      paramURLImageView.setURLDrawableDownListener(new a(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130851853), false));
      return localDrawable;
    }
  }
  
  public void bGM()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_Alcn, this.C);
  }
  
  public void bT(byte[] paramArrayOfByte)
  {
    ThreadManager.post(new QidianProfileCardActivity.25(this, paramArrayOfByte), 8, null, true);
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Arie == null) {
      this.jdField_b_of_type_Arie = new arie(this);
    }
    this.jdField_b_of_type_Arie.V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1012: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          super.finish();
          return;
        }
        paramIntent = paramIntent.getStringExtra("remark");
      } while (aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.e.remark, paramIntent));
      vx(paramIntent);
      return;
    }
    super.setResult(-1);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    this.isNightMode = ThemeUtil.isInNightMode(this.app);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card start " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_Asgx = ((asgx)this.app.getManager(165));
    this.c = ((acff)this.app.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(2));
    try
    {
      setContentView(2131561081);
      this.dp16 = wja.dp2px(16.0F, getResources());
      this.dp10 = wja.dp2px(10.0F, getResources());
      this.dp8 = wja.dp2px(8.0F, getResources());
      this.jdField_a_of_type_Alcn.e = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_Alcn.e == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_Alcn.e = new ProfileActivity.AllInOne(paramBundle, 104);
      }
      this.emb = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_Alcn.e == null) || (this.jdField_a_of_type_Alcn.e.uin == null))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
      return false;
    }
    if ((this.c != null) && (this.c.isFriend(this.jdField_a_of_type_Alcn.e.uin)) && (!this.jdField_a_of_type_Alcn.e.uin.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Alcn.e.pa = 1;
    }
    this.jdField_a_of_type_Alcn.gh = new String[7];
    clearData();
    this.app.addObserver(this.jdField_a_of_type_Acfd);
    this.app.addObserver(this.jdField_a_of_type_Jos);
    this.app.addObserver(this.jdField_b_of_type_Ashx);
    this.app.addObserver(this.cardObserver);
    if (!aHS())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c = new c();
    this.jC = new ConcurrentHashMap();
    this.jD = new ConcurrentHashMap();
    ThreadManager.post(new QidianProfileCardActivity.1(this), 8, null, true);
    Zs(this.accountType);
    initUI();
    env();
    Zt(this.accountType);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card end " + System.currentTimeMillis());
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.C != null) && (this.C.isShowing()))
    {
      this.C.dismiss();
      this.C = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
    this.app.removeObserver(this.jdField_b_of_type_Ashx);
    this.app.removeObserver(this.cardObserver);
    this.app.removeObserver(this.jdField_a_of_type_Jos);
    clearData();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.uin.equals(this.jdField_a_of_type_Alcn.e.uin))) {
      Zs(this.accountType);
    }
    if ((localAllInOne != null) && (!localAllInOne.uin.equals(this.jdField_a_of_type_Alcn.e.uin)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    XM(this.jdField_a_of_type_Alcn.e.uin);
  }
  
  public void enu()
  {
    if ((this.accountType != 1) && (this.accountType != 2) && (this.accountType != 0) && (this.accountType != 6)) {}
    label311:
    for (;;)
    {
      return;
      this.lK.removeAllViews();
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Alcn.e);
      boolean bool1;
      boolean bool3;
      if (this.accountType == 6)
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Alcn.e);
        if (bool2) {
          a(2131694811, 2131561090, this.mOnClickListener).setTag(new albb(7, null));
        }
        if ((this.accountType != 1) || (!this.jdField_a_of_type_Asgx.sK(this.jdField_a_of_type_Alcn.e.uin))) {
          break label211;
        }
        a(2131700359, 2131561090, this.mOnClickListener).setTag(new albb(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label311;
        }
        a(2131700862, 2131561089, this.mOnClickListener).setTag(new albb(8, Integer.valueOf(this.accountType)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Alcn.e);
        break;
        label211:
        if ((this.accountType == 6) && (this.jdField_a_of_type_Asgx.sJ(this.jdField_a_of_type_Alcn.e.uin))) {
          a(2131694846, 2131561090, this.mOnClickListener).setTag(new albb(20, null));
        } else if ((bool3) && (this.accountType != 6)) {
          a(2131694846, 2131561090, this.mOnClickListener).setTag(new albb(20, null));
        }
      }
    }
  }
  
  public void enw()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c != null) {
      this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$c.sendMessage(localMessage);
    }
  }
  
  public void enx()
  {
    if (this.jdField_a_of_type_Alcn == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    Object localObject;
    if (TextUtils.isEmpty(this.cEL))
    {
      localObject = ((acff)this.app.getManager(51)).e(this.jdField_a_of_type_Alcn.e.uin);
      if ((localObject == null) || (TextUtils.isEmpty(((Friends)localObject).name))) {
        break label167;
      }
      this.cEL = ((Friends)localObject).name;
    }
    for (;;)
    {
      localIntent.putExtra("key_nick_name", this.cEL);
      if (this.accountType == 6) {
        localIntent.putExtra("key_qidian_detail_url", this.cEM);
      }
      localObject = adzx.a(this.app, this.jdField_a_of_type_Alcn);
      localIntent = aqep.a(localIntent, this.jdField_a_of_type_Alcn.e.uin, this.app, this.jdField_a_of_type_Alcn.e, (BusinessCard)localObject);
      localIntent.addFlags(536870912);
      super.startActivityForResult(localIntent, 1012);
      return;
      label167:
      if (this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo != null) {
        this.cEL = this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
      }
    }
  }
  
  public void eny()
  {
    if ((this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_Alcn.e == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.uin)))
    {
      cf(2131694848, 1);
      return;
    }
    jqs.b(this.app, this, this.jdField_b_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_Alcn.e.uin);
  }
  
  public void iO(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianProfileCardActivity", 2, "enterNewPage content is null");
      }
      return;
    }
    Intent localIntent = new Intent(this, QidianProfileAllTextActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("content", paramString2);
    super.startActivity(localIntent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21))
    {
      Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public void showLoading(int paramInt)
  {
    if (this.mProgress == null) {
      this.mProgress = new arhz(this, getResources().getDimensionPixelSize(2131299627));
    }
    this.mProgress.setCanceledOnTouchOutside(true);
    this.mProgress.setMessage(paramInt);
    this.mProgress.show();
  }
  
  static class ForwardRunnable
    implements Runnable
  {
    private WeakReference<QidianProfileCardActivity> an;
    private URLDrawable e;
    
    ForwardRunnable(QidianProfileCardActivity paramQidianProfileCardActivity, URLDrawable paramURLDrawable)
    {
      this.an = new WeakReference(paramQidianProfileCardActivity);
      this.e = paramURLDrawable;
    }
    
    public void run()
    {
      QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.an.get();
      if (localQidianProfileCardActivity == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 1);
      Object localObject = new File(acbn.bmS);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str = acbn.bmS + Utils.Crc64String(localQidianProfileCardActivity.a.e.uin) + Utils.Crc64String(this.e.getURL().toString());
      localObject = str;
      if (!new File(str).exists()) {}
      try
      {
        localObject = this.e.saveTo(str);
        localBundle.putBoolean("forward_urldrawable", true);
        localBundle.putString("forward_urldrawable_thumb_url", this.e.getURL().toString());
        localBundle.putString("forward_filepath", (String)localObject);
        localBundle.putString("forward_urldrawable_big_url", this.e.getURL().toString());
        localBundle.putString("forward_extra", (String)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtras(localBundle);
        ahgq.f(localQidianProfileCardActivity, (Intent)localObject, 21);
        return;
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianProfileCardActivity", 2, "IOException", localIOException);
        }
        localQidianProfileCardActivity.runOnUiThread(new QidianProfileCardActivity.ForwardRunnable.1(this, localQidianProfileCardActivity));
      }
    }
  }
  
  public static class QidianCompoundProfileItem
    implements Parcelable
  {
    public static final Parcelable.Creator<QidianCompoundProfileItem> CREATOR = new ashs();
    public String cEP;
    public boolean cNv;
    public String faceUrl;
    public boolean isVerified;
    public String name;
    public String title;
    public int type;
    public String uin;
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.uin);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.title);
      if (this.isVerified)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.type);
        if (!this.cNv) {
          break label86;
        }
      }
      label86:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeString(this.faceUrl);
        paramParcel.writeString(this.cEP);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  public static class QidianSimpleProfileItem
    implements Parcelable
  {
    public static final Parcelable.Creator<QidianSimpleProfileItem> CREATOR = new asht();
    public String action;
    public int aqA = 0;
    public boolean cNv;
    public String content;
    public boolean deA;
    public boolean isClickable;
    public String title;
    public int type = 1;
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.content);
      if (this.isClickable)
      {
        paramInt = 1;
        paramParcel.writeByte((byte)paramInt);
        paramParcel.writeInt(this.type);
        paramParcel.writeInt(this.aqA);
        paramParcel.writeString(this.action);
        if (!this.cNv) {
          break label93;
        }
        paramInt = 1;
        label66:
        paramParcel.writeByte((byte)paramInt);
        if (!this.deA) {
          break label98;
        }
      }
      label93:
      label98:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label66;
      }
    }
  }
  
  static class SavePhotoRunnable
    implements Runnable
  {
    private WeakReference<QidianProfileCardActivity> an;
    private String baM;
    private URLDrawable e;
    
    SavePhotoRunnable(QidianProfileCardActivity paramQidianProfileCardActivity, URLDrawable paramURLDrawable, String paramString)
    {
      this.an = new WeakReference(paramQidianProfileCardActivity);
      this.e = paramURLDrawable;
      this.baM = paramString;
    }
    
    public void run()
    {
      localQidianProfileCardActivity = (QidianProfileCardActivity)this.an.get();
      if (localQidianProfileCardActivity == null) {
        return;
      }
      for (;;)
      {
        try
        {
          str1 = this.e.saveTo(this.baM);
          if (str1 == null) {
            continue;
          }
          aqhu.cn(localQidianProfileCardActivity, str1);
          str1 = localQidianProfileCardActivity.getString(2131696988) + " " + str1;
        }
        catch (IOException localIOException)
        {
          String str1;
          String str2 = localQidianProfileCardActivity.getString(2131696986);
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          String str3 = localQidianProfileCardActivity.getString(2131696986);
          continue;
        }
        localQidianProfileCardActivity.runOnUiThread(new QidianProfileCardActivity.SavePhotoRunnable.1(this, localQidianProfileCardActivity, str1));
        return;
        str1 = localQidianProfileCardActivity.getString(2131696986);
      }
    }
  }
  
  static class a
    extends URLDrawableDownListener.Adapter
  {
    boolean dez = true;
    WeakReference<URLImageView> iS = null;
    WeakReference<Drawable> iT = null;
    WeakReference<QidianProfileCardActivity> mActivity = null;
    String mUrl = "";
    WeakReference<QQAppInterface> n = null;
    
    public a(QidianProfileCardActivity paramQidianProfileCardActivity, QQAppInterface paramQQAppInterface, URLImageView paramURLImageView, String paramString, Drawable paramDrawable, boolean paramBoolean)
    {
      this.iS = new WeakReference(paramURLImageView);
      this.mUrl = paramString;
      this.n = new WeakReference(paramQQAppInterface);
      this.iT = new WeakReference(paramDrawable);
      this.dez = paramBoolean;
      this.mActivity = new WeakReference(paramQidianProfileCardActivity);
    }
    
    public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
    {
      super.onLoadSuccessed(paramView, paramURLDrawable);
      paramView = (URLImageView)this.iS.get();
      QQAppInterface localQQAppInterface = (QQAppInterface)this.n.get();
      QidianProfileCardActivity localQidianProfileCardActivity = (QidianProfileCardActivity)this.mActivity.get();
      if ((paramView != null) && (localQQAppInterface != null) && (localQidianProfileCardActivity != null) && (!TextUtils.isEmpty(this.mUrl)))
      {
        paramURLDrawable = new BitmapDrawable(QidianProfileCardActivity.a(localQQAppInterface, paramURLDrawable, this.dez));
        if (this.dez) {
          localQidianProfileCardActivity.jD.put(this.mUrl, paramURLDrawable);
        }
        paramView.setImageDrawable(paramURLDrawable);
      }
    }
  }
  
  public static class b
  {
    public String key = "";
    public int type;
    public WeakReference<URLImageView> view;
    
    public b(URLImageView paramURLImageView, int paramInt, String paramString)
    {
      this.view = new WeakReference(paramURLImageView);
      this.type = paramInt;
      this.key = paramString;
    }
  }
  
  class c
    extends Handler
  {
    c() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        try
        {
          BitmapDrawable localBitmapDrawable = new BitmapDrawable(QidianProfileCardActivity.this.getResources(), QidianProfileCardActivity.this.mAvatarBitmap);
          QidianProfileCardActivity.this.mK.setBackgroundDrawable(localBitmapDrawable);
        }
        catch (Exception localException) {}
        continue;
        Object localObject = (QidianProfileCardActivity.QidianSimpleProfileItem)paramMessage.getData().getParcelable("data");
        localObject = QidianProfileCardActivity.this.a((QidianProfileCardActivity.QidianSimpleProfileItem)localObject);
        if (localObject != null)
        {
          QidianProfileCardActivity.this.lL.addView((View)localObject);
          continue;
          localObject = paramMessage.getData().getParcelableArrayList("data");
          localObject = QidianProfileCardActivity.this.a((List)localObject);
          if (localObject != null)
          {
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
            localLayoutParams.leftMargin = QidianProfileCardActivity.this.dp16;
            ((View)localObject).setPadding(0, QidianProfileCardActivity.this.dp10, QidianProfileCardActivity.this.dp16, QidianProfileCardActivity.this.dp10);
            QidianProfileCardActivity.this.lL.addView((View)localObject, localLayoutParams);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */