package com.tencent.mobileqq.profile;

import accn;
import acff;
import alcl;
import alcs;
import aldk;
import aldl;
import aldm;
import aldn;
import aldo;
import aldp;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anot;
import aqep;
import aqha;
import aqju;
import aqrf;
import aquy;
import aquz;
import aqva;
import arhz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class VipProfileCardBaseActivity
  extends IphoneTitleBarActivity
{
  protected arhz G;
  public DialogInterface.OnClickListener S = new aldo(this);
  public DialogInterface.OnClickListener T = new aldp(this);
  public int WAIT_TIME = 30000;
  protected aqju aA;
  public long agu;
  public String bVS;
  public CardHandler c;
  protected boolean cwi;
  protected boolean cwj;
  public int drV = 2;
  public int dsf = -1;
  protected int dsg = -1;
  protected int dsh;
  public int dsi;
  protected int dsj = 1;
  public int dsk = -1;
  public int dsl = -1;
  protected int dsm;
  protected accn g = new aldl(this);
  protected String lN = "";
  public Context mContext;
  protected float mDensity;
  public Runnable mDismissRunnable = new VipProfileCardBaseActivity.3(this);
  @SuppressLint({"HandlerLeak"})
  public Handler mHandler = new aldk(this);
  protected int mScreenHeight;
  protected int mScreenWidth;
  public DialogInterface.OnClickListener v = new aldn(this);
  public DialogInterface.OnClickListener w = new aldm(this);
  protected ArrayList<alcs> yD;
  protected aqju z;
  
  protected int a(String paramString, aquy paramaquy)
  {
    if (aqep.aj(this.mContext, paramString)) {
      return 19;
    }
    paramString = new aquz(paramString, new File(aqep.I(this.mContext, paramString)));
    if (paramaquy != null) {
      paramString.c(paramaquy);
    }
    paramString.cxX = "profileCardDownload";
    paramString.cxW = "VIP_profilecard";
    return aqva.a(paramString, this.app);
  }
  
  public void a(alcl paramalcl)
  {
    if (paramalcl == null) {}
    long l;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime();
    } while ((paramalcl.drG != 1) || (l >= paramalcl.drI) || (l <= paramalcl.drH));
    paramalcl.drF = 1;
  }
  
  public void a(alcs paramalcs)
  {
    if (paramalcs == null) {}
    long l;
    do
    {
      return;
      l = NetConnInfoCenter.getServerTime();
    } while ((paramalcs.drG != 1) || (l >= paramalcs.drI) || (l <= paramalcs.drH));
    paramalcs.bVr = "1";
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    acff localacff = (acff)this.app.getManager(51);
    Card localCard = localacff.b(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localacff.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(alcs paramalcs, alcl paramalcl, boolean paramBoolean)
  {
    if ((paramalcs != null) && (paramalcl != null))
    {
      if (paramalcs.agr == 0L) {
        return true;
      }
      int k = Integer.valueOf(paramalcs.bVr).intValue();
      int i = paramalcl.drF;
      boolean bool = aqep.a(paramalcl);
      if (bool) {
        i = paramalcs.drU;
      }
      if (k >= i)
      {
        this.dsh = 1;
        if (k == i) {
          this.dsh = 2;
        }
      }
      for (int j = k;; j = i)
      {
        this.dsg = j;
        if ((j != 0) && (j != 1)) {
          break;
        }
        return true;
        this.dsh = 0;
      }
      if (j == 2)
      {
        if ((!this.cwi) && (!this.cwj))
        {
          this.dsf = 1;
          if (bool) {
            this.lN = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.cwi), Boolean.valueOf(this.cwj), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.dsf), this.lN }));
            }
            if (paramBoolean) {
              this.mHandler.sendEmptyMessage(9);
            }
            return false;
            if (this.dsj == 1) {
              this.lN = aqep.a(this.cwi, this.cwj, k, i, this.dsf);
            } else {
              this.lN = aqep.gb(3);
            }
          }
        }
      }
      else if (j == 4)
      {
        if (!this.cwj)
        {
          this.dsf = 2;
          if (bool) {
            this.lN = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.cwi), Boolean.valueOf(this.cwj), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.dsf), this.lN }));
            }
            if (paramBoolean) {
              this.mHandler.sendEmptyMessage(9);
            }
            return false;
            if (this.dsj == 1) {
              this.lN = aqep.a(this.cwi, this.cwj, k, i, this.dsf);
            } else {
              this.lN = aqep.gb(6);
            }
          }
        }
      }
      else if (j == 5) {
        return true;
      }
    }
    return true;
  }
  
  protected void ay(long paramLong1, long paramLong2)
  {
    e(paramLong1, paramLong2, null, 0);
  }
  
  /* Error */
  public void bF()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 311	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:G	Larhz;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 311	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:G	Larhz;
    //   11: invokevirtual 316	arhz:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 311	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:G	Larhz;
    //   21: invokevirtual 319	arhz:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 311	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:G	Larhz;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 311	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:G	Larhz;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 311	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:G	Larhz;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	VipProfileCardBaseActivity
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  public void bFU()
  {
    if (this.z != null)
    {
      this.z.dismiss();
      this.z = null;
    }
  }
  
  public void bOQ()
  {
    bFU();
    String str2;
    String str1;
    if (this.dsf == 2)
    {
      str2 = getString(2131697253);
      if (this.dsh == 2) {
        str1 = getString(2131697257);
      }
    }
    for (;;)
    {
      this.z = aqha.a(this.mContext, 0, str2, str1, 2131697251, 2131697252, this.v, this.w);
      this.z.show();
      return;
      if (this.dsh == 1)
      {
        str1 = getString(2131697259);
      }
      else
      {
        str1 = getString(2131697255);
        continue;
        str2 = getString(2131697261);
        if (this.dsh == 2) {
          str1 = getString(2131697258);
        } else if (this.dsh == 1) {
          str1 = getString(2131697260);
        } else {
          str1 = getString(2131697256);
        }
      }
    }
  }
  
  protected void dFg() {}
  
  protected void dFh()
  {
    this.cwj = VipUtils.ce(this.app);
    this.cwi = VipUtils.cf(this.app);
  }
  
  public void dFi()
  {
    if (this.aA != null)
    {
      this.aA.dismiss();
      this.aA = null;
    }
  }
  
  public void dFj()
  {
    Object localObject2 = null;
    Intent localIntent = getIntent();
    Object localObject1 = localObject2;
    if (localIntent != null)
    {
      localObject1 = localObject2;
      if (localIntent.hasExtra("ExternAid")) {
        localObject1 = localIntent.getStringExtra("ExternAid");
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.lN;
    }
    for (;;)
    {
      if (this.dsf == 2)
      {
        aqrf.a(this.app, (BaseActivity)this.mContext, (String)localObject1, 3, "1450000516", "CJCLUBT", getString(2131720669), "svip");
        anot.a(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.d(this.app, this.app.getCurrentAccountUin()));
        return;
      }
      aqrf.a(this.app, (BaseActivity)this.mContext, (String)localObject1, 3, "1450000515", "LTMCLUB", getString(2131697263), "vip");
      anot.a(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.d(this.app, this.app.getCurrentAccountUin()));
      return;
    }
  }
  
  public void dFk()
  {
    Card localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
    if (localCard != null)
    {
      if (localCard.templateRet != 0)
      {
        this.agu = 0L;
        this.dsk = -1;
        this.dsl = 1;
        this.bVS = null;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", new Object[] { Long.valueOf(this.agu), Integer.valueOf(this.dsk), Integer.valueOf(this.dsl), this.bVS }));
      }
      return;
    }
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      if (localCard.cardType == 2) {}
      for (l = alcs.agq;; l = (int)localCard.lCurrentStyleId)
      {
        this.agu = l;
        this.dsk = ((int)localCard.lCurrentBgId);
        this.bVS = localCard.backgroundUrl;
        this.dsl = ((int)localCard.backgroundColor);
        label168:
        if (this.agu != -1L) {
          break label285;
        }
        this.agu = 0L;
        break;
      }
    }
    if (!localIntent.hasExtra("CurrentTemplateId")) {
      if (localCard.cardType != 2) {
        break label287;
      }
    }
    label285:
    label287:
    for (long l = alcs.agq;; l = (int)localCard.lCurrentStyleId)
    {
      this.agu = l;
      if (!localIntent.hasExtra("CurrentBackgroundId")) {
        this.dsk = ((int)localCard.lCurrentBgId);
      }
      if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
        this.bVS = localCard.backgroundUrl;
      }
      if (localIntent.hasExtra("CurrentBackgroundColor")) {
        break label168;
      }
      this.dsl = ((int)localCard.backgroundColor);
      break label168;
      break;
    }
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources().getDisplayMetrics();
    this.mScreenWidth = paramBundle.widthPixels;
    this.mScreenHeight = paramBundle.heightPixels;
    this.dsm = paramBundle.densityDpi;
    this.mDensity = paramBundle.density;
    dFh();
    this.c = ((CardHandler)this.app.getBusinessHandler(2));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.g);
    bFU();
    bF();
    this.yD = null;
  }
  
  public ArrayList<alcs> dp()
  {
    int i;
    if ((this.yD == null) || (this.yD.size() == 0))
    {
      this.yD = aqep.a(this.app, false, false);
      if ((this.yD != null) && (!this.yD.isEmpty()))
      {
        i = 0;
        if (i >= this.yD.size()) {
          break label131;
        }
        localalcs = (alcs)this.yD.get(i);
        if ((localalcs == null) || (localalcs.agr != alcs.agj)) {
          break label124;
        }
      }
    }
    label131:
    for (alcs localalcs = aqep.a(localalcs);; localalcs = null)
    {
      if (localalcs != null)
      {
        localalcs.agr = alcs.agq;
        this.yD.add(0, localalcs);
      }
      aqep.et(this.app);
      return this.yD;
      label124:
      i += 1;
      break;
    }
  }
  
  protected void e(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    bF();
    this.G = new arhz(this.mContext, ((BaseActivity)this.mContext).getTitleBarHeight());
    this.G.setCancelable(false);
    this.G.setMessage(2131697313);
    try
    {
      this.G.show();
      label54:
      this.app.execute(new VipProfileCardBaseActivity.8(this, paramLong1, paramLong2, paramString, paramInt));
      this.mHandler.postDelayed(this.mDismissRunnable, this.WAIT_TIME);
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public long[] l()
  {
    ArrayList localArrayList = dp();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new long[localArrayList.size()];
        int i = 0;
        while (i < localArrayList.size())
        {
          localObject1[i] = ((alcs)localArrayList.get(i)).agr;
          i += 1;
        }
      }
    }
    return localObject1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      String str = null;
      if (paramIntent.hasExtra("result"))
      {
        Object localObject = paramIntent.getStringExtra("result");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultStr : " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = new JSONObject((String)localObject);
            if (localObject == null) {
              return;
            }
            localObject = ((JSONObject)localObject).get("payState");
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, stateObj : " + localObject);
            }
            if ((localObject == null) || (!"0".equals(String.valueOf(localObject)))) {
              return;
            }
            if (paramIntent.hasExtra("callbackSn")) {
              str = paramIntent.getStringExtra("callbackSn");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, callbackSn : " + str);
            }
            if ("svip".equals(str)) {
              this.cwj = true;
            }
            for (;;)
            {
              dFg();
              return;
              this.cwi = true;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, data contain no result key.");
      }
    }
  }
  
  public boolean p(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity
 * JD-Core Version:    0.7.0.1
 */