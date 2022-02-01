package com.tencent.mobileqq.troop.activity;

import acfp;
import acms;
import acnd;
import ahgg.a;
import ahgq;
import ahix;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import anqv;
import anrd;
import anre;
import aofk;
import aowj;
import aowk;
import aowl;
import aowm;
import aown;
import aowo;
import apbc;
import apbc.c;
import apbc.d;
import apue;
import apzg;
import aqiw;
import aqmf;
import arwr;
import avqq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogicActivity
  extends BaseActivity
  implements apbc.c
{
  public String Qt;
  apbc jdField_a_of_type_Apbc = null;
  apzg jdField_a_of_type_Apzg;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  public WXShareHelper.a b = new aowj(this);
  public boolean cPg;
  public acnd q = new aowk(this);
  
  private void a(String paramString, a parama)
  {
    if ((parama == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    paramString.setURLDrawableListener(new aown(this, paramString, parama));
    paramString.setDownloadListener(new aowo(this, paramString, parama));
    if (paramString.getStatus() == 1)
    {
      parama.ah(arwr.e(paramString, 100, 100));
      return;
    }
    paramString.startDownload();
  }
  
  private void bE(JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("shareLink");
    String str1 = paramJSONObject.optString("shareTitle");
    String str2 = paramJSONObject.optString("shareDesc");
    paramJSONObject = paramJSONObject.optString("shareIcon");
    localObject = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(149).a(acfp.m(2131715638) + str1).e((String)localObject).a();
    anqv localanqv = anrd.a(2);
    localanqv.aU(paramJSONObject, str1, str2);
    ((AbsShareMsg)localObject).addItem(localanqv);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("forward_type", -3);
    paramJSONObject.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
    ahgq.f(this, paramJSONObject, 1002);
  }
  
  private void bF(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    Object localObject = paramJSONObject.optString("shareIcon");
    paramJSONObject = new ArrayList();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramJSONObject.add(localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("title", str2);
    ((Bundle)localObject).putString("desc", str3);
    ((Bundle)localObject).putLong("req_share_id", 0L);
    ((Bundle)localObject).putString("detail_url", str1);
    ((Bundle)localObject).putString("url", str1);
    ((Bundle)localObject).putStringArrayList("image_url", paramJSONObject);
    ((Bundle)localObject).putString("bizname", "SharePlato");
    avqq.a(this.app, this, (Bundle)localObject, null, 1001);
  }
  
  private void bG(JSONObject paramJSONObject)
  {
    if (!aqiw.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131696272, 1).show();
      return;
    }
    this.Qt = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new aowl(this, str2, str3, str1));
    finish();
  }
  
  private void bH(JSONObject paramJSONObject)
  {
    if (!aqiw.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131696272, 1).show();
      return;
    }
    this.Qt = String.valueOf(System.currentTimeMillis());
    String str1 = paramJSONObject.optString("shareLink");
    String str2 = paramJSONObject.optString("shareTitle");
    String str3 = paramJSONObject.optString("shareDesc");
    a(paramJSONObject.optString("shareIcon"), new aowm(this, str2, str3, str1));
    finish();
  }
  
  private void dXw()
  {
    if (getIntent() != null) {
      ahix.a(getIntent(), this.app, this).H(ahgg.a.R.intValue(), getIntent().getExtras());
    }
  }
  
  private void dXx()
  {
    if (getIntent() != null) {
      ahix.a(getIntent(), this.app, this).dnM();
    }
  }
  
  private void dXy()
  {
    Object localObject = getIntent();
    int i = ((Intent)localObject).getIntExtra("chanelId", -1);
    localObject = ((Intent)localObject).getStringExtra("params");
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        switch (i)
        {
        case 0: 
          QLog.e("qqBaseActivity", 1, "unrecognized channel! shareChanel = " + i);
          finish();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "commonShare failed! exception = ", localException);
        return;
      }
      bE((JSONObject)localObject);
      return;
      bF(localException);
      return;
      bG(localException);
      return;
      bH(localException);
      return;
    }
  }
  
  public void Bb(String paramString) {}
  
  public void Sl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject == null)
    {
      finish();
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString);
    if (localTroopInfo == null)
    {
      finish();
      return;
    }
    localObject = new JSONObject();
    paramString = "";
    try
    {
      if (!TextUtils.isEmpty(localTroopInfo.mRichFingerMemo)) {
        paramString = new aofk(localTroopInfo.mRichFingerMemo, 11).AE();
      }
      ((JSONObject)localObject).put("classify", localTroopInfo.dwGroupClassExt);
      ((JSONObject)localObject).put("name", localTroopInfo.troopname);
      ((JSONObject)localObject).put("introduction", paramString);
      ((JSONObject)localObject).put("location", localTroopInfo.strLocation);
      ((JSONObject)localObject).put("percentage", "1.0");
      paramString = new Intent();
      paramString.putExtra("modifiedInfo", ((JSONObject)localObject).toString());
      setResult(-1, paramString);
      finish();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      finish();
    }
  }
  
  public void Sm(String paramString)
  {
    if ((this.app == null) || (this.jdField_a_of_type_Apzg == null) || (TextUtils.isEmpty(paramString))) {
      finish();
    }
    label76:
    do
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        try
        {
          if (Long.parseLong(paramString) > 0L) {
            break label76;
          }
          finish();
          return;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          TroopManager localTroopManager;
          paramString = "";
        }
      }
      finish();
      localJSONException1.printStackTrace();
      while (TextUtils.isEmpty(paramString))
      {
        finish();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin = paramString;
      localTroopManager = (TroopManager)this.app.getManager(52);
    } while (localTroopManager == null);
    paramString = localTroopManager.b(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(paramString, getResources(), this.app.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember = true;
    }
    this.jdField_a_of_type_Apzg.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
  }
  
  public void Sn(String paramString)
  {
    j = 0;
    String str4 = "";
    String str2 = "";
    i = j;
    localObject1 = str2;
    localObject2 = str4;
    if (this.app != null)
    {
      i = j;
      localObject1 = str2;
      localObject2 = str4;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = str2;
        localObject2 = str4;
        str3 = str2;
        str1 = str4;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = str2;
      localObject2 = str4;
      str3 = str2;
      str1 = str4;
      paramString = localJSONObject.getString("troopUin");
      localObject1 = str2;
      localObject2 = paramString;
      str3 = str2;
      str1 = paramString;
      str2 = localJSONObject.getString("groupName");
      localObject1 = str2;
      localObject2 = paramString;
      str3 = str2;
      str1 = paramString;
      long l = Long.parseLong(paramString);
      i = j;
      localObject1 = str2;
      localObject2 = paramString;
      if (l > 0L)
      {
        i = 1;
        localObject2 = paramString;
        localObject1 = str2;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        i = j;
        localObject1 = str3;
        localObject2 = str1;
      }
    }
    if (i != 0)
    {
      paramString = new TroopInfo();
      paramString.troopuin = ((String)localObject2);
      paramString.troopname = ((String)localObject1);
      paramString.Administrator = this.app.getCurrentAccountUin();
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 != null) {
        ((TroopManager)localObject1).i(paramString);
      }
    }
    finish();
  }
  
  public void So(String paramString)
  {
    if (this.jdField_a_of_type_Apbc != null)
    {
      this.jdField_a_of_type_Apbc.gi(paramString, 0);
      this.jdField_a_of_type_Apbc.b(this);
    }
  }
  
  public void Sp(String paramString)
  {
    if (this.jdField_a_of_type_Apbc != null) {
      this.jdField_a_of_type_Apbc.dYx();
    }
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    finish();
  }
  
  public void bE(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("retCode", paramInt);
    localIntent.putExtra("troopUin", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  public void bF(int paramInt, String paramString) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      int i;
      Object localObject;
      do
      {
        return;
        if (paramInt2 != -1) {
          break;
        }
        i = getResources().getDimensionPixelSize(2131299627);
        QQToast.a(this, 2, getString(2131698725), 0).show(i);
        localObject = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      } while (localObject == null);
      if ((localObject instanceof StructMsgForImageShare)) {}
      String str;
      for (;;)
      {
        if (TextUtils.isEmpty(paramIntent.getExtras().getString("share_comment_message"))) {
          localObject = ((AbsStructMsg)localObject).mCommentText;
        }
        this.cPg = false;
        finish();
        break;
        str = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("uintype", -1);
        aqmf.a(this.app, str, i, (AbsStructMsg)localObject, null);
      }
      if (paramInt2 == -1)
      {
        localObject = anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        str = paramIntent.getStringExtra("uin");
        i = paramIntent.getIntExtra("uintype", -1);
        if ((localObject == null) || (TextUtils.isEmpty(str))) {
          break label244;
        }
        aqmf.a(this.app, str, i, (AbsStructMsg)localObject, null);
      }
      for (;;)
      {
        finish();
        break;
        label244:
        if (QLog.isColorLevel()) {
          QLog.e("qqBaseActivity", 2, "friendUin = " + str + " structMsg = " + localObject);
        }
      }
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Apbc = ((apbc)this.app.getManager(32));
    this.jdField_a_of_type_Apzg = new apzg(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", -1);
    if (i == 1) {
      So(paramBundle.getStringExtra("cfg"));
    }
    for (;;)
    {
      apue.m("TroopCreateLogicActivity", new String[] { "" + i });
      return true;
      if (i == 2)
      {
        Sp(paramBundle.getStringExtra("troop_uin"));
      }
      else if (i == 3)
      {
        Sm(paramBundle.getStringExtra("cfg"));
      }
      else if (i == 4)
      {
        Sl(paramBundle.getStringExtra("troop_uin"));
      }
      else if (i == 5)
      {
        String str = paramBundle.getStringExtra("troop_location");
        long l = paramBundle.getLongExtra("troop_uin", 0L);
        this.app.addObserver(this.q);
        ((acms)this.app.getBusinessHandler(20)).b(l, TextUtils.isEmpty(str), str);
      }
      else if (i == 6)
      {
        if (this.jdField_a_of_type_Apbc == null)
        {
          finish();
        }
        else
        {
          paramBundle = new Intent();
          paramBundle.putExtra("has_head", this.jdField_a_of_type_Apbc.a().cPF);
          setResult(-1, paramBundle);
          finish();
        }
      }
      else if (i == 7)
      {
        Sn(paramBundle.getStringExtra("cfg"));
      }
      else if (i == 8)
      {
        dXy();
      }
      else if (i == 9)
      {
        dXw();
      }
      else if (i == 10)
      {
        dXx();
      }
      else
      {
        finish();
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Apbc = null;
    if (this.jdField_a_of_type_Apzg != null)
    {
      this.jdField_a_of_type_Apzg.onDestroy();
      this.jdField_a_of_type_Apzg = null;
    }
    if (this.q != null)
    {
      this.app.removeObserver(this.q);
      this.q = null;
    }
  }
  
  public void finish()
  {
    if (this.cPg) {
      return;
    }
    super.finish();
  }
  
  public static abstract interface a
  {
    public abstract void ah(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity
 * JD-Core Version:    0.7.0.1
 */