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
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int d = 0;
  int e = -1;
  
  public void a(String paramString)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131562451, 0).b(d());
      return;
    }
    c(getString(2131561894));
    Intent localIntent = new Intent(this, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("cfg", paramString);
    startActivityForResult(localIntent, 41);
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
      p();
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
        QQToast.a(this, j, 0).b(d());
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
      this.e = paramIntent.getIntExtra("isBack", -1);
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
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.d = getIntent().getIntExtra("troop_create_from", 0);
    super.doOnCreate(paramBundle);
    if (this.d != 0) {
      setResult(-1);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    e();
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    JSONObject localJSONObject;
    if (this.e != -1) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("isBack", this.e);
      a("onGetGroupHeadEditViewBack", localJSONObject.toString());
      this.e = -1;
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
  
  public void e()
  {
    if (this.d != 0)
    {
      finish();
      return;
    }
    Intent localIntent = new Intent(this, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 2);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
    startActivity(localIntent);
  }
  
  protected void n()
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateActivity
 * JD-Core Version:    0.7.0.1
 */