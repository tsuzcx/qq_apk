package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopCreateActivity
  extends TroopCreateMapViewSupportActivity
{
  public static final int a = 41;
  public static final int b = 42;
  public static final int c = 43;
  public static final int d = 44;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = true;
  boolean c = false;
  int e = 0;
  int f = -1;
  
  public void a(String paramString)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131362916, 0).b(getTitleBarHeight());
      return;
    }
    d(getString(2131363794));
    Intent localIntent = new Intent(this, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("cfg", paramString);
    startActivityForResult(localIntent, 41);
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      return;
    }
    super.d();
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
      v();
      if ((paramIntent == null) || (paramInt2 != -1))
      {
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      int i = paramIntent.getIntExtra("retCode", -1);
      Object localObject2 = paramIntent.getStringExtra("troopUin");
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      int j = TroopCreateLogic.TroopCreateResult.a(i);
      if (j != 0) {
        QQToast.a(this, j, 0).b(getTitleBarHeight());
      }
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("result", i);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          localObject2 = localObject1;
          localJSONObject.put("troopUin", localObject2);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
        a("onCreateGroupResult", localJSONObject.toString());
        if (i != 0) {
          break;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangString = ((String)localObject1);
        break;
        localObject2 = "";
      }
      if ((paramIntent == null) || (paramInt2 != -1))
      {
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      localObject1 = paramIntent.getStringExtra("modifiedInfo");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      a("onGroupInfoModified", (String)localObject1);
      continue;
      if ((paramIntent == null) || (paramInt2 != -1))
      {
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      this.f = paramIntent.getIntExtra("isBack", -1);
      continue;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      localObject1 = new Intent(this, TroopCreateLogicActivity.class);
      ((Intent)localObject1).putExtra("type", 4);
      ((Intent)localObject1).putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
      startActivityForResult((Intent)localObject1, 42);
      continue;
      this.c = paramIntent.getBooleanExtra("has_head", false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.e = getIntent().getIntExtra("troop_create_from", 0);
    this.jdField_b_of_type_Boolean = true;
    super.doOnCreate(paramBundle);
    if (this.e != 0) {
      setResult(-1);
    }
    if (paramBundle != null)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("TroopCreateWebData");
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "";
      }
      if (Boolean.valueOf(paramBundle.getBoolean("isSavedInstanceState", false)).booleanValue())
      {
        paramBundle = new Intent(this, TroopCreateLogicActivity.class);
        paramBundle.putExtra("type", 6);
        startActivityForResult(paramBundle, 44);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_Boolean) {
      u();
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    JSONObject localJSONObject;
    if (this.f != -1) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("isBack", this.f);
      a("onGetGroupHeadEditViewBack", localJSONObject.toString());
      this.f = -1;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    this.jdField_b_of_type_Boolean = false;
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBoolean("isSavedInstanceState", true);
    paramBundle.putString("TroopCreateWebData", this.jdField_b_of_type_JavaLangString);
  }
  
  public String f()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("head", this.c);
      ((JSONObject)localObject).put("webCacheData", this.jdField_b_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  protected void q()
  {
    finish();
  }
  
  public void u()
  {
    if ((this.e != 0) && (this.e != 4))
    {
      finish();
      return;
    }
    Intent localIntent = new Intent(this, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateActivity
 * JD-Core Version:    0.7.0.1
 */