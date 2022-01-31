package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import fcx;
import fcy;
import fcz;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BindGroupActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, ImageLoader.ImageLoadListener, HttpCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  protected static final int a = 1000;
  protected static final String a = "BindGroupActivity";
  protected static final int b = 50;
  protected static final String b = "http://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list";
  public static boolean b = false;
  protected static final int c = 50;
  protected static final String c = "640";
  protected Resources a;
  protected Bundle a;
  public Handler a;
  protected LayoutInflater a;
  protected View a;
  protected TextView a;
  protected OpenIdObserver a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  public SlideDetectListView a;
  protected BindGroupActivity.GroupListAdapter a;
  protected List a;
  protected boolean a;
  protected View b;
  protected TextView b;
  public QQProgressDialog b;
  protected TextView c;
  public boolean c;
  protected TextView d;
  protected String d;
  public String e;
  public String f;
  protected String g;
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public BindGroupActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new fcy(this);
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("请稍等...");
    }
    OpenID localOpenID = this.app.a().a(this.g);
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID))) {
      this.f = localOpenID.openID;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.app.a());
    this.jdField_a_of_type_AndroidOsBundle.putString("vkey", this.app.d());
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, mOpenid: " + this.e);
    }
    if (!TextUtils.isEmpty(this.e))
    {
      if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363380);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new fcz(this), 3000L);
        this.app.a(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
        this.app.a().e(this.g);
        return;
      }
      if (!this.e.equals(localOpenID.openID))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
        }
        d();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      this.f = localOpenID.openID;
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.f);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (BindGroupActivity.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this, BindGroupConfirmActivity.class);
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("group_code", paramAdapterView.a);
        this.jdField_a_of_type_AndroidOsBundle.putString("group_name", paramAdapterView.b);
        this.jdField_a_of_type_AndroidOsBundle.putString("group_avatar_url", paramAdapterView.c);
      }
      paramView.putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
      super.startActivityForResult(paramView, 1000);
      overridePendingTransition(2130968590, 2130968591);
    }
  }
  
  public void a(Exception paramException)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("BindGroupActivity", 2, "-->onException", paramException);
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = "网络连接超时!";
    }
    for (;;)
    {
      QQToast.a(this, paramException, 0).a(super.getTitleBarHeight()).show();
      return;
      if ((paramException instanceof SocketTimeoutException)) {
        paramException = "网络连接超时!";
      } else if ((paramException instanceof MalformedURLException)) {
        paramException = "访问url有误!";
      } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
        paramException = "Http返回码异常!";
      } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
        paramException = "网络连接异常，请检查后重试!";
      } else if ((paramException instanceof JSONException)) {
        paramException = "服务器返回数据格式有误!";
      } else if ((paramException instanceof IOException)) {
        paramException = "网络连接异常，请检查后重试!";
      } else {
        paramException = "未知错误!";
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onImageLoaded() url = " + paramString);
    }
    runOnUiThread(new fcx(this, paramString, paramBitmap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onResult, result: " + paramJSONObject);
    }
    try
    {
      if (paramJSONObject.getInt("ret") != 0) {
        break label272;
      }
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int j = paramJSONObject.length();
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          BindGroupActivity.GroupInfo localGroupInfo = new BindGroupActivity.GroupInfo();
          try
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            localGroupInfo.a = localJSONObject.getString("group_code");
            localGroupInfo.b = localJSONObject.getString("name");
            localGroupInfo.c = (localJSONObject.getString("face") + "640");
            this.jdField_a_of_type_JavaUtilList.add(localGroupInfo);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BindGroupActivity", 2, "The JSONObject has error!" + localJSONException.getMessage());
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label254;
      }
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
      return;
    }
    this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter.notifyDataSetChanged();
    return;
    label254:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    return;
    label272:
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "The JSONObject has error!");
    }
    QQToast.a(this, paramJSONObject.getString("msg"), 0).a(super.getTitleBarHeight()).show();
  }
  
  public void c()
  {
    if ((this.f != null) && (this.jdField_a_of_type_AndroidOsBundle != null)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.f);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    new HttpCgiAsyncTask("http://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this).a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131362445);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131362488);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131362801, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131362446, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    super.finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == paramDialogInterface)
    {
      if (paramInt != 1) {
        break label60;
      }
      paramDialogInterface = new Intent(this, LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      super.startActivity(paramDialogInterface);
      super.finish();
    }
    label60:
    while (paramInt != 0) {
      return;
    }
    super.setResult(0);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131296898: 
        super.finish();
        return;
      }
      paramView = (TroopCreateLogic)this.app.getManager(29);
    } while (paramView == null);
    paramView.a(this, 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setTheme(2131624276);
    super.setContentView(2130903347);
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return;
    }
    this.e = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    this.g = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
    e();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.jdField_a_of_type_AndroidOsBundle.putString("vkey", super.getIntent().getStringExtra("vkey"));
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", super.getIntent().getStringExtra("uin"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296898));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296902));
    this.c = ((TextView)super.findViewById(2131296892));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297773);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)super.findViewById(2131297776));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this);
    if (this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter == null) {
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter = new BindGroupActivity.GroupListAdapter(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131297777);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297780));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    jdField_b_of_type_Boolean = false;
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131362156));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.c.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131362156));
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_Boolean))
    {
      if (!jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      new HttpCgiAsyncTask("http://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this).a(this.jdField_a_of_type_AndroidOsBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupActivity", 2, "-->onStart, start load group list.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity
 * JD-Core Version:    0.7.0.1
 */