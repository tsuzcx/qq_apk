package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQToast;
import ekv;
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
  public static final int f = 6;
  public static final String f = "has_head";
  public TroopObserver a;
  TroopCreateLogic jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = null;
  TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
  TroopShareUtility jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  
  public TroopCreateLogicActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ekv(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    if (localQQMessageFacade != null)
    {
      String str = paramQQAppInterface.a();
      long l = paramQQAppInterface.a().a(paramString, 1).shmsgseq;
      paramQQAppInterface = (MessageForGrayTips)MessageRecordFactory.a(-1013);
      paramQQAppInterface.init(str, paramString, paramString, paramContext.getString(2131362326), MessageCache.a(), -1013, 1, 1L + l);
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
    Object localObject = (FriendManager)this.app.getManager(8);
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
    if ((this.app == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility == null) || (TextUtils.isEmpty(paramString))) {
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
      localFriendManager = (FriendManager)this.app.getManager(8);
    } while (localFriendManager == null);
    paramString = localFriendManager.a(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(paramString, getResources(), this.app.a());
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
    a(this.app, this, paramString);
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    int i;
    Object localObject;
    do
    {
      return;
      if (paramInt2 != -1) {
        break;
      }
      i = getResources().getDimensionPixelSize(2131492887);
      QQToast.a(this, 2, getString(2131362626), 0).b(i);
      localObject = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
    } while (localObject == null);
    if ((localObject instanceof StructMsgForImageShare)) {}
    for (;;)
    {
      if (TextUtils.isEmpty(paramIntent.getExtras().getString("share_comment_message"))) {
        localObject = ((AbsStructMsg)localObject).mCommentText;
      }
      this.jdField_a_of_type_Boolean = false;
      finish();
      break;
      String str = paramIntent.getStringExtra("uin");
      i = paramIntent.getIntExtra("uintype", -1);
      ShareMsgHelper.a(this.app, str, i, (AbsStructMsg)localObject, null);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic = ((TroopCreateLogic)this.app.getManager(29));
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
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      ((TroopHandler)this.app.a(17)).a(l, TextUtils.isEmpty(str), str);
      return true;
    }
    if (i == 6)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic == null) {
        finish();
      }
      paramBundle = new Intent();
      paramBundle.putExtra("has_head", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic.a().jdField_a_of_type_Boolean);
      setResult(-1, paramBundle);
      finish();
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
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity
 * JD-Core Version:    0.7.0.1
 */