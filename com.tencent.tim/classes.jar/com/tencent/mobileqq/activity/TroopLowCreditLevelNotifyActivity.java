package com.tencent.mobileqq.activity;

import acfp;
import acms;
import acnd;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqha;
import aqhu;
import aqju;
import arhz;
import avpw;
import avpw.d;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop.TroopFileProxyActivity;
import java.util.List;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.AppInfo;
import tencent.im.oidb.cmd0xea4.oidb_0xea4.RspBody;
import wab;
import wac;

public class TroopLowCreditLevelNotifyActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected TextView Gd;
  protected TextView Ge;
  protected TextView Gf;
  protected arhz a;
  protected acnd b = new wac(this);
  protected Button dI;
  protected LinearLayout gC;
  protected TextView jh;
  public Context mContext;
  protected String mTroopName = "";
  public String mTroopUin = "";
  public View[] p;
  public boolean[] p;
  protected ImageView rt;
  
  public TroopLowCreditLevelNotifyActivity()
  {
    this.jdField_p_of_type_ArrayOfAndroidViewView = new View[4];
    this.jdField_p_of_type_ArrayOfBoolean = new boolean[4];
  }
  
  private void initViews()
  {
    this.mContext = this;
    this.rt = ((ImageView)findViewById(2131380263));
    this.Gd = ((TextView)findViewById(2131380362));
    this.Ge = ((TextView)findViewById(2131380409));
    this.jh = ((TextView)findViewById(2131370930));
    this.Gf = ((TextView)findViewById(2131371879));
    this.gC = ((LinearLayout)findViewById(2131369423));
    this.dI = ((Button)findViewById(2131378952));
    this.dI.setOnClickListener(this);
    setTitle(2131699771);
    this.jh.setText(2131699779);
    this.Gf.setText(2131699778);
    this.Gd.setText(this.mTroopName);
    this.Ge.setText(this.mTroopUin);
    a(2131699819, 2131699727, this.jdField_p_of_type_ArrayOfBoolean[0], 0);
    a(2131699815, 2131699727, this.jdField_p_of_type_ArrayOfBoolean[1], 1);
    a(2131699816, 2131699725, this.jdField_p_of_type_ArrayOfBoolean[2], 2);
    a(2131699818, 2131699726, this.jdField_p_of_type_ArrayOfBoolean[3], 3);
    Bitmap localBitmap = this.app.a(this.mTroopUin, (byte)3, false, false);
    if (localBitmap != null) {
      this.rt.setImageBitmap(localBitmap);
    }
    while (isAllCompleted())
    {
      this.dI.setEnabled(true);
      return;
      localBitmap = aqhu.G();
      this.rt.setImageBitmap(localBitmap);
    }
    this.dI.setEnabled(false);
  }
  
  private String s(String paramString, long paramLong)
  {
    String str = this.app.getCurrentAccountUin();
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.mTroopUin);
      if (localObject != null) {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L) {
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      paramString = paramString.replace("$GCODE$", this.mTroopUin).replace("$CLIENTVER$", "android3.4.4").replace("$UIN$", str).replace("$LANG$", "zh_CN").replace("$GROUPAPPID$", Long.toString(paramLong)).replace("$ROLE$", (CharSequence)localObject).replace("$ENTERSOURCE$", "1");
      return paramString + "&credit=1";
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) == 1L) {
        localObject = "1";
      } else {
        localObject = "2";
      }
    }
  }
  
  public boolean QP()
  {
    this.mTroopUin = getIntent().getStringExtra("troopUin");
    if (TextUtils.isEmpty(this.mTroopUin)) {
      return false;
    }
    Object localObject = (TroopManager)this.app.getManager(52);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.mTroopUin);
      if (localObject != null)
      {
        this.mTroopName = ((TroopInfo)localObject).getTroopName();
        if (TextUtils.isEmpty(this.mTroopName)) {
          this.mTroopName = this.mTroopUin;
        }
      }
      localObject = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).getString(this.mTroopUin, "");
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams, modifyStatusJson:" + (String)localObject);
      }
      localObject = new JSONObject((String)localObject);
      this.jdField_p_of_type_ArrayOfBoolean[0] = ((JSONObject)localObject).optBoolean("TROOP_INFO_ITEM");
      this.jdField_p_of_type_ArrayOfBoolean[1] = ((JSONObject)localObject).optBoolean("TROOP_ANNOUNCE_ITEM");
      this.jdField_p_of_type_ArrayOfBoolean[2] = ((JSONObject)localObject).optBoolean("TROOP_FILE_ITEM");
      this.jdField_p_of_type_ArrayOfBoolean[3] = ((JSONObject)localObject).optBoolean("TROOP_ALBUM_ITEM");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "initParams:" + localException.toString());
        }
      }
    }
    return true;
    return false;
  }
  
  public oidb_0xea4.AppInfo a(long paramLong)
  {
    Object localObject1 = ((TroopManager)this.app.getManager(52)).r(this.mTroopUin);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject2 = new oidb_0xea4.RspBody();
        ((oidb_0xea4.RspBody)localObject2).mergeFrom((byte[])localObject1);
        localObject2 = ((oidb_0xea4.RspBody)localObject2).infos.get();
        if (localObject2 == null) {
          break label170;
        }
        if (((List)localObject2).size() != 0) {
          break label176;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l;
        if (!QLog.isColorLevel()) {
          break label168;
        }
        QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "getAppInfo: " + paramLong + ", " + localException.toString());
      }
      label168:
      label170:
      oidb_0xea4.AppInfo localAppInfo;
      if (i < ((List)localObject2).size())
      {
        localObject1 = (oidb_0xea4.AppInfo)((List)localObject2).get(i);
        l = ((oidb_0xea4.AppInfo)localObject1).appid.get();
        if (l != paramLong) {
          i += 1;
        }
      }
      else
      {
        return null;
        localAppInfo = null;
      }
      return localAppInfo;
      label176:
      int i = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131563255, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131369532);
    TextView localTextView2 = (TextView)localView.findViewById(2131369466);
    TextView localTextView3 = (TextView)localView.findViewById(2131369527);
    localTextView1.setText(paramInt1);
    localTextView2.setText(paramInt2);
    if (paramBoolean) {
      localTextView3.setVisibility(0);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      this.jdField_p_of_type_ArrayOfAndroidViewView[paramInt3] = localView;
      this.gC.addView(localView);
      return;
      localTextView3.setVisibility(8);
    }
  }
  
  public void a(oidb_0xea4.AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    paramAppInfo = s(paramAppInfo.url.get(), paramAppInfo.appid.get());
    localIntent.putExtra("url", paramAppInfo);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    startActivityForResult(localIntent, 1001);
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "openTroopAnnounce:" + paramAppInfo);
    }
  }
  
  public void bWP()
  {
    Object localObject = (TroopManager)this.app.getManager(52);
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).b(this.mTroopUin);
      if (localObject != null) {
        if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
        {
          i = 1;
          if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
            break label133;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      label56:
      if ((i == 0) && (j == 0))
      {
        localObject = aqha.a(this.mContext, 230).setTitle(getString(2131721103)).setMessage(acfp.m(2131715837));
        ((aqju)localObject).setPositiveButton(2131699773, new wab(this));
        ((aqju)localObject).setNegativeButton("", null);
        ((aqju)localObject).setCancelable(false);
        ((aqju)localObject).show();
      }
      label133:
      do
      {
        return;
        i = 0;
        break;
        j = 0;
        break label56;
        localObject = (acms)this.app.getBusinessHandler(20);
      } while (localObject == null);
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "getTroopCreditInfo:" + this.mTroopUin);
      }
      ((acms)localObject).bL(this.mTroopUin, true);
      showProgressDialog();
      return;
      j = 0;
      i = 0;
    }
  }
  
  public void bWQ()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences("sp_tp_credit_md_stat_" + this.app.getCurrentAccountUin(), 0).edit();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("TROOP_INFO_ITEM", this.jdField_p_of_type_ArrayOfBoolean[0]);
      localJSONObject.put("TROOP_ANNOUNCE_ITEM", this.jdField_p_of_type_ArrayOfBoolean[1]);
      localJSONObject.put("TROOP_FILE_ITEM", this.jdField_p_of_type_ArrayOfBoolean[2]);
      localJSONObject.put("TROOP_ALBUM_ITEM", this.jdField_p_of_type_ArrayOfBoolean[3]);
      localEditor.putString(this.mTroopUin, localJSONObject.toString());
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + localJSONObject.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "saveStatus:" + localException.toString());
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = -1;
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (paramInt1 >= 0)
      {
        this.jdField_p_of_type_ArrayOfAndroidViewView[paramInt1].findViewById(2131369527).setVisibility(0);
        this.jdField_p_of_type_ArrayOfBoolean[paramInt1] = true;
      }
      if (!isAllCompleted()) {
        break;
      }
      this.dI.setEnabled(true);
      return;
      paramInt1 = 0;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 2;
      continue;
      paramInt1 = 3;
    }
    this.dI.setEnabled(false);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "doOnCreate:" + this.mTroopUin + "," + this.mTroopName);
    }
    if (!QP())
    {
      finish();
      return false;
    }
    super.setContentView(2131563256);
    initViews();
    addObserver(this.b);
    bWP();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.b);
    bWQ();
  }
  
  public void hideProgressDialog()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public boolean isAllCompleted()
  {
    int i = 0;
    while (i < this.jdField_p_of_type_ArrayOfBoolean.length)
    {
      if (this.jdField_p_of_type_ArrayOfBoolean[i] == 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (paramView.getId() == 2131378952)
    {
      localObject1 = "https://qqweb.qq.com/m/business/qunlevel/index.html?gc=" + this.mTroopUin + "&from=0&_wv=1027";
      localObject2 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      startActivity((Intent)localObject2);
    }
    label366:
    label369:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_p_of_type_ArrayOfAndroidViewView[0])
      {
        localObject1 = (TroopManager)this.app.getManager(52);
        if (localObject1 == null) {
          break label366;
        }
      }
      for (localObject1 = ((TroopManager)localObject1).b(this.mTroopUin);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label369;
        }
        localObject2 = TroopInfoActivity.a(this.mTroopUin, 28, ((TroopInfo)localObject1).troopLat, ((TroopInfo)localObject1).troopLon, 0, "");
        ((Bundle)localObject2).putInt("troop_type_ex", ((TroopInfo)localObject1).troopTypeExt);
        TroopInfoActivity.b(this, (Bundle)localObject2, 1000);
        break;
        if (paramView == this.jdField_p_of_type_ArrayOfAndroidViewView[1])
        {
          localObject1 = a(1101236949L);
          if (localObject1 != null)
          {
            a((oidb_0xea4.AppInfo)localObject1);
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.TroopLowCreditLevelNotifyActivity", 2, "onClick, appInfo for announce is null, req from server");
          }
          showProgressDialog();
          localObject1 = (acms)this.app.getBusinessHandler(20);
          if (localObject1 == null) {
            break;
          }
          ((acms)localObject1).a(this.mTroopUin, false, 0, 1);
          break;
        }
        if (paramView == this.jdField_p_of_type_ArrayOfAndroidViewView[2])
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra(TroopFileProxyActivity.cjr, this.mTroopUin);
          ((Intent)localObject1).putExtra("param_from", 1000);
          TroopFileProxyActivity.b(this, (Intent)localObject1, 1002, this.app.getCurrentAccountUin());
          break;
        }
        if (paramView != this.jdField_p_of_type_ArrayOfAndroidViewView[3]) {
          break;
        }
        localObject1 = avpw.d.a();
        ((avpw.d)localObject1).cMP = this.app.getCurrentAccountUin();
        ((avpw.d)localObject1).nickname = this.app.getCurrentNickname();
        avpw.a(this, (avpw.d)localObject1, this.mTroopUin, this.mTroopName, 3, 1003, "qunnotice");
        break;
      }
    }
  }
  
  protected void showProgressDialog()
  {
    if (this.a == null) {
      this.a = new arhz(this);
    }
    this.a.setMessage(2131699777);
    this.a.setOffsetY(getTitleBarHeight());
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity
 * JD-Core Version:    0.7.0.1
 */