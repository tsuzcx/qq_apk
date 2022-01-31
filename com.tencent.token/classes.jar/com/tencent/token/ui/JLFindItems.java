package com.tencent.token.ui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import java.util.Calendar;
import java.util.Date;

public class JLFindItems
  extends BaseActivity
{
  private Button btn_apply;
  private Button btn_record;
  private Button btn_submit;
  Calendar calendar = Calendar.getInstance();
  private CheckBox chk_licence;
  private int dateFlag = -1;
  private DatePickerDialog.OnDateSetListener dateListener = new nh(this);
  private int detail_max;
  private int detail_min;
  DatePickerDialog dpd;
  private EditText et;
  Date getStealTime;
  private boolean is_xy = false;
  Date lastLoginTime;
  private View lv_findItems_getStealTime;
  private View lv_findItems_lastLoginTime;
  private View lv_findItems_role;
  private Handler mHandler = new ng(this);
  private int roleID = -1;
  private String roleName;
  private int serverID = -1;
  private String serverName;
  private TextView tv_getstealtime;
  private TextView tv_getstealtimeTitle;
  private TextView tv_lastlogintime;
  private TextView tv_lastlogintimeTitle;
  private TextView tv_licence;
  private TextView tv_qqname;
  private TextView tv_rolename;
  private TextView tv_roletitle;
  private int zoneID = -1;
  private String zoneName;
  
  private void getSavedRoleInfo(long paramLong)
  {
    Object localObject = RqdApplication.i().getSharedPreferences("jl_has_save_role", 0).getString(String.valueOf(paramLong), "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = ((String)localObject).split("-");
      this.roleID = Integer.parseInt(localObject[0]);
      this.zoneID = Integer.parseInt(localObject[1]);
      this.serverID = Integer.parseInt(localObject[2]);
      this.roleName = localObject[3];
      this.zoneName = localObject[4];
      this.serverName = localObject[5];
      this.tv_rolename.setText(this.roleName + " " + this.zoneName + "/" + this.serverName);
      this.tv_rolename.setVisibility(0);
      this.tv_rolename.setTextAppearance(this, 2131427335);
      this.tv_roletitle.setTextAppearance(this, 2131427386);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void initUI()
  {
    setContentViewForDetail();
  }
  
  private void saveRoleInfo(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = RqdApplication.i().getSharedPreferences("jl_has_save_role", 0).edit();
    localEditor.putString(String.valueOf(paramLong), new StringBuilder().append(paramInt1).append("-").toString() + new StringBuilder().append(paramInt2).append("-").toString() + new StringBuilder().append(paramInt3).append("-").toString() + new StringBuilder().append(paramString1).append("-").toString() + new StringBuilder().append(paramString2).append("-").toString() + paramString3);
    localEditor.commit();
  }
  
  private void setCanSubmit()
  {
    if ((this.getStealTime != null) && (this.lastLoginTime != null) && (this.roleID != -1) && (this.zoneID != -1) && (this.serverID != -1))
    {
      this.btn_submit.setEnabled(true);
      this.btn_submit.setBackgroundResource(2130837549);
      this.btn_submit.setTextAppearance(this, 2131427381);
    }
  }
  
  private void setContentViewForDetail()
  {
    setContentView(2130903120);
    this.tv_roletitle = ((TextView)findViewById(2131296752));
    this.tv_lastlogintimeTitle = ((TextView)findViewById(2131296755));
    this.tv_getstealtimeTitle = ((TextView)findViewById(2131296759));
    this.et = ((EditText)findViewById(2131296761));
    this.et.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.detail_max) });
    if (this.et != null) {
      this.et.clearFocus();
    }
    this.tv_qqname = ((TextView)findViewById(2131296749));
    QQUser localQQUser = ax.a().e();
    if (this.is_xy)
    {
      Object localObject = getApplicationContext().getResources().getDrawable(2130837702);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new ImageSpan((Drawable)localObject, 1);
      if (localQQUser != null)
      {
        SpannableString localSpannableString = new SpannableString(localQQUser.mUinMask + "（" + localQQUser.mNickName + "） ");
        int i = (localQQUser.mUinMask + "（" + localQQUser.mNickName + "）").length();
        localSpannableString.setSpan(localObject, i, i + 1, 33);
        if (this.tv_qqname != null) {
          this.tv_qqname.setText(localSpannableString);
        }
      }
    }
    for (;;)
    {
      this.lv_findItems_role = findViewById(2131296751);
      this.lv_findItems_role.setOnClickListener(new nb(this));
      this.tv_rolename = ((TextView)findViewById(2131296739));
      getSavedRoleInfo(localQQUser.mUin);
      this.lv_findItems_lastLoginTime = findViewById(2131296754);
      this.lv_findItems_lastLoginTime.setOnClickListener(new nc(this));
      this.tv_lastlogintime = ((TextView)findViewById(2131296756));
      this.lv_findItems_getStealTime = findViewById(2131296758);
      this.lv_findItems_getStealTime.setOnClickListener(new nd(this));
      this.tv_getstealtime = ((TextView)findViewById(2131296760));
      this.btn_submit = ((Button)findViewById(2131296762));
      this.btn_submit.setOnClickListener(new ne(this));
      this.chk_licence = ((CheckBox)findViewById(2131296764));
      this.tv_licence = ((TextView)findViewById(2131296765));
      this.tv_licence.setText(Html.fromHtml(getResources().getString(2131362284)));
      this.tv_licence.setOnClickListener(new nf(this));
      return;
      if (this.tv_qqname != null) {
        this.tv_qqname.setText(localQQUser.mUinMask + "（" + localQQUser.mNickName + "） ");
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 1)
    {
      this.roleName = paramIntent.getStringExtra("roleName");
      this.zoneName = paramIntent.getStringExtra("zoneName");
      this.serverName = paramIntent.getStringExtra("serverName");
      this.tv_rolename.setText(this.roleName + " " + this.zoneName + "/" + this.serverName);
      this.tv_rolename.setVisibility(0);
      this.tv_rolename.setTextAppearance(this, 2131427335);
      this.tv_roletitle.setTextAppearance(this, 2131427386);
      this.roleID = paramIntent.getIntExtra("roleID", -1);
      this.zoneID = paramIntent.getIntExtra("zoneID", -1);
      this.serverID = paramIntent.getIntExtra("serverID", -1);
      setCanSubmit();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(1);
    this.is_xy = getIntent().getBooleanExtra("is_xy", false);
    this.detail_max = getIntent().getIntExtra("detail_max", 0);
    this.detail_min = getIntent().getIntExtra("detail_min", 0);
    setContentViewForDetail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.JLFindItems
 * JD-Core Version:    0.7.0.1
 */