package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import gxw;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateLogicActivity
  extends BaseActivity
  implements TroopCreateLogic.TroopCreateCallback
{
  public static final int a = 1;
  public static final int b = 2;
  public static final String b = "type";
  public static final int c = 3;
  public static final String c = "cfg";
  public static final int d = 4;
  public static final String d = "troop_uin";
  public static final int e = 5;
  public static final String e = "troop_location";
  public TroopObserver a;
  TroopCreateLogic jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = null;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  TroopShareUtility jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public TroopCreateLogicActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new gxw(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null)
    {
      String str = paramQQAppInterface.a();
      long l = paramQQAppInterface.a().a(paramString, 1).shmsgseq;
      paramQQAppInterface = (MessageForGrayTips)MessageRecordFactory.a(-1013);
      paramQQAppInterface.init(str, paramString, paramString, paramContext.getString(2131560418), MessageCache.a(), -1013, 1, 1L + l);
      paramQQAppInterface.isread = true;
      localQQMessageFacade.a(paramQQAppInterface, str);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("retCode", paramInt);
    localIntent.putExtra("troopUin", paramString);
    setResult(-1, localIntent);
    finish();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    Object localObject = (FriendManager)this.b.getManager(8);
    if (localObject == null)
    {
      finish();
      return;
    }
    TroopInfo localTroopInfo = ((FriendManager)localObject).a(paramString);
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
        paramString = new QQText(localTroopInfo.mRichFingerMemo, 11).a();
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
  
  public void b(String paramString)
  {
    if ((this.b == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility == null) || (TextUtils.isEmpty(paramString))) {
      finish();
    }
    label75:
    do
    {
      return;
      try
      {
        paramString = new JSONObject(paramString).getString("troopUin");
        try
        {
          if (Long.parseLong(paramString) > 0L) {
            break label75;
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
          FriendManager localFriendManager;
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
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c = paramString;
      localFriendManager = (FriendManager)this.b.getManager(8);
    } while (localFriendManager == null);
    paramString = localFriendManager.a(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramString, getResources(), this.b.a());
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a(this);
    }
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      finish();
      return;
    }
    a(this.b, this, paramString);
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        Intent localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.setFlags(67108864);
        startActivity(localIntent);
      }
      this.jdField_a_of_type_Boolean = false;
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = ((TroopCreateLogic)this.b.getManager(30));
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("type", -1);
    if (i == 1)
    {
      c(paramBundle.getStringExtra("cfg"));
      return true;
    }
    if (i == 2)
    {
      d(paramBundle.getStringExtra("troop_uin"));
      return true;
    }
    if (i == 3)
    {
      b(paramBundle.getStringExtra("cfg"));
      return true;
    }
    if (i == 4)
    {
      a(paramBundle.getStringExtra("troop_uin"));
      return true;
    }
    if (i == 5)
    {
      String str = paramBundle.getStringExtra("troop_location");
      long l = paramBundle.getLongExtra("troop_uin", 0L);
      this.b.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      ((TroopHandler)this.b.a(19)).a(l, TextUtils.isEmpty(str), str);
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.f();
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null)
    {
      this.b.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = null;
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity
 * JD-Core Version:    0.7.0.1
 */