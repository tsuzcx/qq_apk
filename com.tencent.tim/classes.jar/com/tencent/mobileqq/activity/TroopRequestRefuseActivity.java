package com.tencent.mobileqq.activity;

import acrp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import anot;
import anze;
import aqiw;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import oicq.wlogin_sdk.tools.MD5;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestRefuseActivity
  extends IphoneTitleBarActivity
  implements TextWatcher, View.OnClickListener
{
  protected TextView GN;
  private structmsg.StructMsg a;
  protected EditText aG;
  private String aRJ = "";
  Handler mHandler = new Handler(Looper.getMainLooper());
  protected CheckBox y;
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      this.GN.setText(String.valueOf(25));
      this.GN.setTextColor(Color.rgb(119, 119, 119));
      enableRightHighlight(true);
      return;
    }
    this.mHandler.post(new TroopRequestRefuseActivity.1(this, paramEditable));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563284);
    setTitle(2131700001);
    setLeftButton(2131721058, this);
    setRightHighlightButton(2131719505, this);
    enableRightHighlight(true);
    this.aG = ((EditText)findViewById(2131366539));
    this.aG.setBackgroundColor(-1);
    this.aG.addTextChangedListener(this);
    this.GN = ((TextView)findViewById(2131381033));
    this.GN.setText(String.valueOf(25));
    this.y = ((CheckBox)findViewById(2131364574));
    paramBundle = pc();
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.aG.setText(paramBundle);
      this.aG.setSelection(this.aG.length());
    }
    long l = anze.a().hf();
    this.a = anze.a().a(Long.valueOf(l));
    if (this.a != null) {
      this.aRJ = String.valueOf(this.a.msg.group_code.get());
    }
    anot.a(this.app, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "exp_reject", 0, 0, this.aRJ, "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.aG != null)
    {
      String str = this.aG.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        xa(str);
      }
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightHighLView) {
      if (!aqiw.isNetSupport(this)) {
        QQToast.a(this, getString(2131696270), 0).show(getTitleBarHeight());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str1 = this.aG.getText().toString();
      boolean bool = this.y.isChecked();
      v(str1, bool);
      setResult(-1);
      finish();
      QQAppInterface localQQAppInterface = this.app;
      String str3 = this.aRJ;
      if (TextUtils.isEmpty(str1))
      {
        str1 = "0";
        label100:
        if (!bool) {
          break label144;
        }
      }
      label144:
      for (String str2 = "0";; str2 = "1")
      {
        anot.a(localQQAppInterface, "P_CliOper", "Grp_sysmsg", "", "Grp_ask", "Clk_send_reject", 0, 0, str3, str1, str2, "");
        break;
        str1 = "1";
        break label100;
      }
      if (paramView == this.leftViewNotBack) {
        finish();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected String pc()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("share_troop_request_refuse", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString(MD5.toMD5(this.app.getCurrentAccountUin()), "");
    }
    return "";
  }
  
  protected boolean v(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.a != null)
    {
      int i = this.a.msg_type.get();
      long l1 = this.a.msg_seq.get();
      long l2 = this.a.req_uin.get();
      int j = this.a.msg.sub_type.get();
      int k = this.a.msg.src_id.get();
      int m = this.a.msg.sub_src_id.get();
      int n = this.a.msg.group_msg_type.get();
      Object localObject = this.a.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((List)localObject).size() < 0)
        {
          localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
          if (!TextUtils.isEmpty(paramString)) {
            ((structmsg.SystemMsgActionInfo)localObject).msg.set(paramString);
          }
          ((structmsg.SystemMsgActionInfo)localObject).blacklist.set(paramBoolean);
          this.app.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void xa(String paramString)
  {
    Object localObject = getSharedPreferences("share_troop_request_refuse", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString(MD5.toMD5(this.app.getCurrentAccountUin()), paramString);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestRefuseActivity
 * JD-Core Version:    0.7.0.1
 */