package com.tencent.mobileqq.activity;

import acfd;
import acff;
import acfp;
import ahkr;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import anot;
import anpc;
import aqft;
import aqfz;
import aqha;
import aqhv;
import aqiw;
import aqju;
import arhz;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jqk;
import mqq.util.WeakReference;
import udr;
import uds;
import udt;
import udu;
import udv;
import udw;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static String aKF = "";
  public static boolean aRh;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new udu(this);
  private arhz jdField_a_of_type_Arhz;
  private a jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$a;
  protected jqk a;
  private String aKG;
  private String aKH;
  public boolean aRg;
  private int bDw;
  private int bDx;
  private int bDy = -1;
  private int bDz;
  public Handler bJ;
  private int eK = -1;
  private String mSourceName;
  private int mType;
  private String mUin;
  DialogInterface.OnClickListener s = new uds(this);
  DialogInterface.OnClickListener t = new udt(this);
  private aqju w;
  public aqju x;
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_Jqk = new udw(this);
  }
  
  private boolean OA()
  {
    Object localObject1 = getIntent();
    this.bDx = ((Intent)localObject1).getIntExtra("source_id", 3999);
    this.aKH = ((Intent)localObject1).getStringExtra("extra");
    if (!c(this.mType, this.mUin)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "addFriend");
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.bDx == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.aKH)))
    {
      localObject1 = this.app.a().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).find(TroopMemberInfo.class, new String[] { this.aKH, this.mUin });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).close();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$a = new a(this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$a);
    if (this.mType == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "queryUinSafetyFlag");
      }
      abe();
      ((FriendListHandler)this.app.getBusinessHandler(1)).l("OidbSvc.0x476_147", Long.parseLong(this.mUin), 147);
    }
    for (;;)
    {
      return true;
      if (this.bDx == 3024)
      {
        bFD();
        return true;
      }
      if (!TextUtils.isEmpty(aKF)) {
        bFE();
      } else {
        bFD();
      }
    }
  }
  
  private boolean OB()
  {
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this.app.getApplication(), 2131696272, 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    Intent localIntent = new Intent(this, AddFriendVerifyActivity.class);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("contact_bothway", true);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      return true;
      startActivityForResult(localIntent, 1);
    }
  }
  
  private boolean OC()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int i = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((TroopManager)this.app.getManager(52)).b(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131690301, 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    if (i == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131695152);
      }
      QQToast.a(this.app.getApplication(), 2131721390, 0).show(getTitleBarHeight());
      finish();
      return false;
    }
    localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("friend_setting", 9);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    startActivityForResult((Intent)localObject, 1);
    return true;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendLogicActivity.startAddFriend [type:%s, uin: %s, extUin: %s, source:%s, subSource:%s]", new Object[] { Integer.valueOf(paramInt1), aqft.pl(paramString1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    Intent localIntent = new Intent(paramContext, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    localIntent.putExtra("is_from_game", aqhv.ctn);
    aqhv.ctn = null;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = AutoRemarkActivity.hb(paramString3);
    }
    localIntent.putExtra("nick_name", paramString1);
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 30) {
        paramString1 = paramString4.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("param_return_addr", paramString5);
    localIntent.putExtra("last_activity", paramString6);
    localIntent.putExtra("src_name", paramString7);
    if (paramInt2 == 3999)
    {
      paramString2 = new HashMap(4);
      paramString2.put("act", paramContext.getClass().getSimpleName());
      if (BaseActivity.sTopActivity != null) {
        break label441;
      }
    }
    label441:
    for (paramString1 = "null";; paramString1 = BaseActivity.sTopActivity.toString())
    {
      paramString2.put("top", paramString1);
      if ((paramContext instanceof Activity))
      {
        paramString1 = ((Activity)paramContext).getIntent();
        if (paramString1 != null)
        {
          paramString2.put("intent", paramString1.toString());
          paramString1 = paramString1.getExtras();
          if (paramString1 != null) {
            paramString2.put("extra", paramString1.toString());
          }
        }
      }
      anpc.a(paramContext).collectPerformance(null, "addFriendSource", true, 0L, 0L, paramString2, null);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startAddFriend Extras = " + localIntent.getExtras().toString());
      }
      if (QLog.isDebugVersion()) {
        QLog.d("addfriend", 2, "source =  " + paramInt2 + "subSource= " + paramInt3);
      }
      return localIntent;
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, null, paramString7, null);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    paramContext = new Intent(paramContext, AddFriendLogicActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("k_uin_type", 4);
    paramContext.putExtra("group_option", paramShort);
    paramContext.putExtra("troop_question", paramString3);
    paramContext.putExtra("troop_answer", paramString4);
    paramContext.putExtra("nick_name", paramString2);
    paramContext.putExtra("stat_option", paramInt);
    paramContext.putExtra("param_return_addr", paramString5);
    paramContext.putExtra("last_activity", paramString6);
    paramContext.putExtra("authKey", paramString7);
    paramContext.putExtra("authSig", paramString8);
    paramContext.putExtra("key_param_homework_intro_str", paramString9);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, List<PhoneContact> paramList, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, AddFriendLogicActivity.class);
    localIntent.putExtra("k_uin_type", 2);
    localIntent.putExtra("contacts", (Serializable)paramList);
    localIntent.putExtra("source_id", paramInt1);
    paramContext = paramString1;
    if (paramString1 != null)
    {
      paramContext = paramString1;
      if (paramString1.length() > 30) {
        paramContext = paramString1.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramContext);
    localIntent.putExtra("last_activity", paramString2);
    localIntent.putExtra("src_name", paramString3);
    localIntent.putExtra("contact_from_type", paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "startMultiAddFriend Extras = " + localIntent.getExtras().toString());
    }
    return localIntent;
  }
  
  private void abe()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "showProgress");
    }
    if (this.jdField_a_of_type_Arhz == null)
    {
      this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
      this.jdField_a_of_type_Arhz.a(new udr(this));
    }
    this.jdField_a_of_type_Arhz.setMessage(2131694339);
    if (!isFinishing()) {
      this.jdField_a_of_type_Arhz.show();
    }
  }
  
  private void bFD()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "getAddFriendSetting");
    }
    abe();
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
    int i = getIntent().getIntExtra("sub_source_id", 0);
    localFriendListHandler.a(this.mUin, this.bDx, i, this.aKH, this.bDw);
  }
  
  private void bFE()
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, "checkAccountDiff");
    }
    if (!TextUtils.isEmpty(aKF)) {
      if (this.aKH != null) {
        break label115;
      }
    }
    label115:
    for (OpenID localOpenID = null; (localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)); localOpenID = this.app.a().a(this.aKH))
    {
      abe();
      this.bJ = new Handler();
      this.bJ.postDelayed(new AddFriendLogicActivity.2(this), 3000L);
      this.app.addObserver(this.jdField_a_of_type_Jqk);
      if (this.aKH != null) {
        this.app.a().Eo(this.aKH);
      }
      return;
    }
    if (!aKF.equals(localOpenID.openID))
    {
      bFG();
      return;
    }
    bFD();
  }
  
  private void bFF()
  {
    if ((this.w != null) && (this.bDz != 0))
    {
      localObject1 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertTitle", 147, this.bDz);
      if (localObject1 == null) {
        break label506;
      }
    }
    label209:
    label229:
    label506:
    for (Object localObject1 = ((Bundle)localObject1).getString("AlertTitle");; localObject1 = null)
    {
      Object localObject2 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertText", 147, this.bDz);
      if (localObject2 != null) {}
      for (Object localObject4 = ((Bundle)localObject2).getString("AlertText");; localObject4 = null)
      {
        localObject2 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.bDz);
        if (localObject2 != null) {}
        for (localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");; localObject2 = null)
        {
          Object localObject3 = (Bundle)aqfz.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.bDz);
          if (localObject3 != null) {}
          for (localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");; localObject3 = null)
          {
            Object localObject5 = localObject1;
            int i;
            if (localObject1 == null)
            {
              if (this.bDz == 1)
              {
                i = 2131719340;
                localObject5 = getString(i);
              }
            }
            else
            {
              localObject1 = localObject4;
              if (localObject4 == null)
              {
                if (this.bDz != 1) {
                  break label333;
                }
                localObject1 = getString(2131719341);
              }
              if (localObject2 != null) {
                break label432;
              }
              if (this.bDz != 1) {
                break label420;
              }
              this.s = null;
              localObject4 = localObject2;
              if (localObject3 != null) {
                break label467;
              }
              if (this.bDz != 1) {
                break label456;
              }
              localObject2 = getString(2131719335);
            }
            for (;;)
            {
              this.w.setTitle((String)localObject5);
              this.w.setMessage((CharSequence)localObject1);
              this.w.setNegativeButton((String)localObject4, this.s);
              this.w.setPositiveButton((String)localObject2, this.t);
              if ((this.s == null) || (this.t == null)) {
                this.w.findViewById(2131363753).setVisibility(8);
              }
              return;
              i = 2131719344;
              break;
              if (this.bDz == 2)
              {
                localObject1 = getString(2131719339);
                break label209;
              }
              if (this.bDz == 3)
              {
                localObject1 = getString(2131719343);
                break label209;
              }
              if (this.bDz == 4)
              {
                localObject1 = getString(2131719342);
                break label209;
              }
              if (this.bDz == 5)
              {
                localObject1 = getString(2131719337);
                break label209;
              }
              localObject1 = getString(2131719338);
              break label209;
              localObject4 = getString(2131719336);
              break label229;
              localObject4 = localObject2;
              if (!TextUtils.isEmpty(((String)localObject2).trim())) {
                break label229;
              }
              this.s = null;
              localObject4 = localObject2;
              break label229;
              localObject2 = getString(2131719334);
              continue;
              if (TextUtils.isEmpty(((String)localObject3).trim())) {
                this.t = null;
              }
              localObject2 = localObject3;
            }
          }
        }
      }
    }
  }
  
  private void ba(int paramInt, String paramString)
  {
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("source_id", 3999) == 3090) {}
      try
      {
        ahkr.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK error = " + paramString);
        return;
      }
    }
    QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK intent = null");
  }
  
  private boolean c(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      finish();
      return false;
    case 1: 
      try
      {
        Long.parseLong(paramString);
        if (((acff)this.app.getManager(51)).isFriend(paramString))
        {
          QQToast.a(this.app.getApplication(), 2131690304, 0).show(getTitleBarHeight());
          finish();
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
    case 2: 
      if (this.bDx == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.bDx = 3006;
      }
      break;
    }
    while (!aqiw.isNetSupport(this))
    {
      QQToast.a(this.app.getApplication(), 2131696272, 0).show(getTitleBarHeight());
      finish();
      return false;
      if (this.bDx == 3999)
      {
        this.bDx = 3016;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "openId source id is default!");
        }
      }
    }
    return true;
  }
  
  private void vH(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "dismissOrHideProgress hide: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_Arhz == null) || (!this.jdField_a_of_type_Arhz.isShowing())) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Arhz.hide();
      return;
    }
    this.jdField_a_of_type_Arhz.dismiss();
  }
  
  void a(int paramInt1, boolean paramBoolean, ArrayList<String> paramArrayList, Class<?> paramClass, int paramInt2)
  {
    this.bDy = paramInt1;
    if ((this.bDx == 3024) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendLogicActivity", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
      }
      if (aqiw.isNetSupport(this))
      {
        paramArrayList = (FriendListHandler)this.app.getBusinessHandler(1);
        paramInt2 = getIntent().getIntExtra("sub_source_id", 0);
        paramArrayList.a(this.mUin, this.aKH, paramInt1, (byte)0, "", this.bDx, paramInt2, false, null, false, null, this.mSourceName, getIntent().getBundleExtra("flc_extra_param"));
        return;
      }
      QQToast.a(this.app.getApplication(), 2131696272, 0).show(getTitleBarHeight());
      return;
    }
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt1);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    paramClass.putExtra("sort_id", this.bDx);
    paramClass.putExtra("extra", this.aKH);
    paramClass.putExtra("entrance", this.eK);
    if ((!paramClass.hasExtra("param_wzry_data")) && (KplRoleInfo.isKplSession(this.app, this, this.mUin, paramInt2)))
    {
      paramArrayList = KplRoleInfo.WZRYUIinfo.buildNickName(getIntent().getStringExtra("nick_name"), KplRoleInfo.getGameNickByUin(this.app, this.mUin));
      Object localObject = KplRoleInfo.getKplVerifyMsg(this.app);
      localObject = KplRoleInfo.WZRYUIinfo.createInfo(this.mUin, paramArrayList, (String)localObject, 0, 0);
      if (localObject != null)
      {
        paramClass.putExtra("param_wzry_data", (Serializable)localObject);
        paramClass.putExtra("nick_name", paramArrayList);
      }
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 1);
  }
  
  public void bFG()
  {
    if ((this.x != null) && (!this.x.isShowing()) && (!isFinishing())) {
      this.x.show();
    }
    do
    {
      return;
      this.x = aqha.a(this, 230);
      this.x.setMessage(2131697425);
      this.x.setTitle(2131693317);
      udv localudv = new udv(this);
      this.x.setNegativeButton(2131721058, localudv);
      this.x.setPositiveButton(2131697395, localudv);
    } while (isFinishing());
    this.x.show();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.mType = paramBundle.getIntExtra("k_uin_type", 0);
    this.mUin = paramBundle.getStringExtra("uin");
    this.aKG = paramBundle.getStringExtra("last_activity");
    this.mSourceName = paramBundle.getStringExtra("src_name");
    this.eK = paramBundle.getIntExtra("entrance", -1);
    if ((this.mUin == null) || (this.mUin.length() < 5))
    {
      this.bDx = paramBundle.getIntExtra("source_id", 3999);
      if ((this.bDx == 3078) || (this.bDx == 3079)) {
        return OB();
      }
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "uin should not be null, activity finish");
      }
      super.finish();
      return false;
    }
    this.bDw = hashCode();
    if (this.mType == 4) {
      return OC();
    }
    return OA();
  }
  
  public void doOnDestroy()
  {
    vH(false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$a != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$a);
    }
    if (this.jdField_a_of_type_Jqk != null) {
      removeObserver(this.jdField_a_of_type_Jqk);
    }
    super.doOnDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    Intent localIntent = getIntent();
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("need_result_uin", false);
    }
    localIntent = paramIntent;
    if (bool)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("uin", this.mUin);
    }
    setResult(paramInt2, localIntent);
    finish();
  }
  
  public String setLastActivityName()
  {
    if (this.aKG != null) {
      return this.aKG;
    }
    return super.setLastActivityName();
  }
  
  class a
    extends acfd
  {
    final WeakReference<AddFriendLogicActivity> j;
    
    a(AddFriendLogicActivity paramAddFriendLogicActivity)
    {
      this.j = new WeakReference(paramAddFriendLogicActivity);
    }
    
    public void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
    {
      Object localObject = (AddFriendLogicActivity)this.j.get();
      if ((localObject == null) || (!((AddFriendLogicActivity)localObject).isResume())) {}
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [uin:%s, isSuc:%s, type:%s, serviceType:%s, status:%s]", new Object[] { aqft.pl(String.valueOf(paramLong)), Boolean.valueOf(paramBoolean), Integer.valueOf(AddFriendLogicActivity.c(AddFriendLogicActivity.this)), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        }
      } while ((AddFriendLogicActivity.c(AddFriendLogicActivity.this) != 1) || (paramInt1 != 147) || (!String.valueOf(paramLong).equals(AddFriendLogicActivity.a(AddFriendLogicActivity.this))));
      if ((!paramBoolean) || (paramInt2 == 0))
      {
        AddFriendLogicActivity.a(AddFriendLogicActivity.this);
        return;
      }
      AddFriendLogicActivity.a(AddFriendLogicActivity.this, false);
      AddFriendLogicActivity.a(AddFriendLogicActivity.this, paramInt2);
      aqfz.a().bf(AddFriendLogicActivity.this.app, "SecWarningCfg");
      try
      {
        AddFriendLogicActivity.a(AddFriendLogicActivity.this, aqha.a(AddFriendLogicActivity.this, 230, "", "", AddFriendLogicActivity.this.s, AddFriendLogicActivity.this.t));
        AddFriendLogicActivity.b(AddFriendLogicActivity.this);
        localObject = AddFriendLogicActivity.a(AddFriendLogicActivity.this).getWindow();
        if (localObject != null)
        {
          WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
          if ((QLog.isColorLevel()) && (localLayoutParams != null)) {
            QLog.i("addFriendTag", 2, String.format("onQueryUinSafetyFlag [%s, %s, %s]", new Object[] { Float.valueOf(localLayoutParams.dimAmount), Integer.valueOf(localLayoutParams.flags), Integer.valueOf(localLayoutParams.flags & 0x2) }));
          }
          ((Window)localObject).setDimAmount(0.5F);
          ((Window)localObject).addFlags(2);
        }
        AddFriendLogicActivity.a(AddFriendLogicActivity.this).setOnDismissListener(AddFriendLogicActivity.this.a);
        AddFriendLogicActivity.a(AddFriendLogicActivity.this).show();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      anot.a(AddFriendLogicActivity.this.app, "P_CliOper", "Safe_AntiFraud", AddFriendLogicActivity.this.app.getCurrentAccountUin(), "AlertDialog", "Display", 0, AddFriendLogicActivity.d(AddFriendLogicActivity.this), "", "", "", "");
    }
    
    public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
    {
      if ((AddFriendLogicActivity.b(AddFriendLogicActivity.this) == 3024) && (AddFriendLogicActivity.e(AddFriendLogicActivity.this) == 0))
      {
        paramString = AddFriendLogicActivity.this.app.getApplication();
        if (!paramBoolean1) {
          break label70;
        }
      }
      label70:
      for (int i = 2131719506;; i = 2131718832)
      {
        QQToast.a(paramString, i, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
        AddFriendLogicActivity.this.finish();
        return;
      }
    }
    
    public void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
    {
      Object localObject = paramBundle.getString("uin");
      if (!AddFriendLogicActivity.a(AddFriendLogicActivity.this).equals(localObject)) {}
      int i;
      do
      {
        return;
        i = paramBundle.getInt("random_key");
      } while ((i != 0) && (i != AddFriendLogicActivity.a(AddFriendLogicActivity.this)));
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format("onUpdateAddFriendSetting [uin:%s, key:%s, isSuc:%s]", new Object[] { aqft.pl((String)localObject), Integer.valueOf(i), Boolean.valueOf(paramBoolean) }));
      }
      AddFriendLogicActivity.a(AddFriendLogicActivity.this, false);
      if (paramBoolean)
      {
        i = paramBundle.getInt("friend_setting");
        ArrayList localArrayList = paramBundle.getStringArrayList("user_question");
        Boolean localBoolean = Boolean.valueOf(paramBundle.getBoolean("contact_bothway"));
        long l = paramBundle.getLong("query_friend_uin");
        try
        {
          paramBundle = Long.toString(l);
          if ((localBoolean.booleanValue()) && (i != 0))
          {
            if (AddFriendLogicActivity.b(AddFriendLogicActivity.this) == 3006) {
              AddFriendLogicActivity.this.getIntent().putExtra("sub_source_id", 2);
            }
            AddFriendLogicActivity.this.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.b(AddFriendLogicActivity.this));
            return;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            paramBundle = null;
          }
          switch (i)
          {
          default: 
            AddFriendLogicActivity.a(AddFriendLogicActivity.this, -1, acfp.m(2131702066));
            QQToast.a(AddFriendLogicActivity.this.app.getApplication(), 2131718828, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
            AddFriendLogicActivity.this.finish();
            return;
          }
        }
        AddFriendLogicActivity.this.a(i, localBoolean.booleanValue(), localArrayList, AddFriendVerifyActivity.class, AddFriendLogicActivity.b(AddFriendLogicActivity.this));
        return;
        AddFriendLogicActivity.a(AddFriendLogicActivity.this, -1, AddFriendLogicActivity.this.getString(2131718680));
        QQToast.a(AddFriendLogicActivity.this.app.getApplication(), 2131718680, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
        AddFriendLogicActivity.this.finish();
        return;
        if (AddFriendLogicActivity.c(AddFriendLogicActivity.this) == 1) {
          ThreadManager.post(new AddFriendLogicActivity.MyFriendListObserver.1(this, (String)localObject), 8, null, true);
        }
        while ((AddFriendLogicActivity.this.getIntent().getBooleanExtra("webim_qd_ext", false)) && (!TextUtils.isEmpty(paramBundle)))
        {
          paramBundle = new ProfileActivity.AllInOne(paramBundle, 1);
          localObject = new Intent(AddFriendLogicActivity.this, QidianProfileCardActivity.class);
          ((Intent)localObject).putExtra("AllInOne", paramBundle);
          ((Intent)localObject).addFlags(536870912);
          AddFriendLogicActivity.this.startActivity((Intent)localObject);
          AddFriendLogicActivity.this.setResult(-1);
          AddFriendLogicActivity.this.finish();
          return;
          if (AddFriendLogicActivity.c(AddFriendLogicActivity.this) == 2) {
            ((PhoneContactManagerImp)AddFriendLogicActivity.this.app.getManager(11)).clH();
          }
        }
        if ((!TextUtils.isEmpty(paramBundle)) && (!"0".equals(paramBundle)))
        {
          paramBundle = new ProfileActivity.AllInOne(paramBundle, 1);
          paramBundle.bJa = 115;
          localObject = ProfileActivity.a(AddFriendLogicActivity.this, paramBundle);
          ((Intent)localObject).putExtra("AllInOne", paramBundle);
          ((Intent)localObject).putExtra("src_name", AddFriendLogicActivity.b(AddFriendLogicActivity.this));
          ((Intent)localObject).putExtra("source_id", AddFriendLogicActivity.this.getIntent().getIntExtra("source_id", 3999));
          ((Intent)localObject).putExtra("extra", AddFriendLogicActivity.this.getIntent().getStringExtra("extra"));
          ((Intent)localObject).addFlags(536870912);
          ((Intent)localObject).addFlags(268435456);
          AddFriendLogicActivity.aRh = true;
          AddFriendLogicActivity.this.startActivity((Intent)localObject);
          AddFriendLogicActivity.this.setResult(-1);
          AddFriendLogicActivity.this.finish();
          return;
        }
        AddFriendLogicActivity.a(AddFriendLogicActivity.this, -1, acfp.m(2131702065));
        QQToast.a(AddFriendLogicActivity.this.app.getApplication(), acfp.m(2131702062), 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
        AddFriendLogicActivity.this.setResult(-1);
        AddFriendLogicActivity.this.finish();
        return;
      }
      AddFriendLogicActivity.a(AddFriendLogicActivity.this, -1, acfp.m(2131702069));
      QQToast.a(AddFriendLogicActivity.this.app.getApplication(), 2131718828, 0).show(AddFriendLogicActivity.this.getTitleBarHeight());
      AddFriendLogicActivity.this.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */