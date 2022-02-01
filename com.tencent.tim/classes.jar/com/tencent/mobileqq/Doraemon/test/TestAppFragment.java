package com.tencent.mobileqq.Doraemon.test;

import acbn;
import acfp;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import tzd;
import tzg;
import tzk;
import ubj;
import ubk;
import ubl;
import ubm;
import ubn;
import ubp;

public class TestAppFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  public String CONF_FILE = "openapi";
  public String aKu = acbn.SDCARD_ROOT + "/Tencent/com/tencent/mobileqq/";
  public String aKv = "101469453";
  public EditText al;
  public int bDr = 5;
  public tzg c;
  private RadioGroup g;
  private RadioGroup h;
  
  private void bFh()
  {
    this.c.a("login", null, new ubn(this));
  }
  
  public void bFg()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    LinearLayout localLinearLayout = new LinearLayout(getActivity());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(300, 300));
    EditText localEditText1 = new EditText(getActivity());
    localEditText1.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    localEditText1.setText(this.aKv);
    EditText localEditText2 = new EditText(getActivity());
    localEditText2.setLayoutParams(new ViewGroup.LayoutParams(400, 80));
    localEditText2.setText("" + this.bDr);
    localLinearLayout.addView(localEditText1);
    localLinearLayout.addView(localEditText2);
    localBuilder.setView(localLinearLayout);
    localBuilder.setTitle("输入appid&type");
    localBuilder.setPositiveButton(acfp.m(2131715242), new ubl(this, localEditText1, localEditText2)).setNegativeButton(acfp.m(2131715246), new ubk(this));
    localBuilder.create().show();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (FormSwitchItem)this.mContentView.findViewById(2131365800);
    paramLayoutInflater.setChecked(new File(this.aKu + this.CONF_FILE).exists());
    paramLayoutInflater.setOnCheckedChangeListener(new ubj(this));
    this.mContentView.findViewById(2131368500).setOnClickListener(this);
    this.mContentView.findViewById(2131370875).setOnClickListener(this);
    this.mContentView.findViewById(2131370878).setOnClickListener(this);
    this.mContentView.findViewById(2131370876).setOnClickListener(this);
    this.mContentView.findViewById(2131368006).setOnClickListener(this);
    this.mContentView.findViewById(2131368004).setOnClickListener(this);
    this.mContentView.findViewById(2131364600).setOnClickListener(this);
    this.mContentView.findViewById(2131368007).setOnClickListener(this);
    this.mContentView.findViewById(2131368002).setOnClickListener(this);
    this.mContentView.findViewById(2131368005).setOnClickListener(this);
    this.mContentView.findViewById(2131377160).setOnClickListener(this);
    this.mContentView.findViewById(2131369281).setOnClickListener(this);
    this.al = ((EditText)this.mContentView.findViewById(2131372764));
    this.g = ((RadioGroup)this.mContentView.findViewById(2131377252));
    this.h = ((RadioGroup)this.mContentView.findViewById(2131377251));
    tzk.prepare();
    this.c = tzk.a(getActivity(), 3, "101480522");
  }
  
  public int getContentLayoutId()
  {
    return 2131559252;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(2);
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    Object localObject = new JSONObject();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.c.a("hello", null, new a(this.al));
      continue;
      this.c.a("login", null, new a(this.al));
      continue;
      this.c.a("loginSilent", null, new a(this.al));
      continue;
      localObject = new ubp(getActivity());
      ((ubp)localObject).uK(acfp.m(2131715244));
      ((ubp)localObject).setAppName("appName");
      ((ubp)localObject).uL("desc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\ndesc\n");
      ((ubp)localObject).uN("negativeButton");
      ((ubp)localObject).uM("positiveButton");
      ((ubp)localObject).s(null);
      ((ubp)localObject).t(null);
      ((ubp)localObject).mm("https://seeklogo.com/images/T/twitter-icon-square-logo-108D17D373-seeklogo.com.png");
      ((ubp)localObject).show();
      continue;
      this.c.a("getSkey", (JSONObject)localObject, new a(this.al));
      continue;
      this.c.a("getUserInfo", (JSONObject)localObject, new a(this.al));
      continue;
      this.c.a("getAppFriends", (JSONObject)localObject, new a(this.al));
      continue;
      this.c.a("getLocation", null, new a(this.al));
      continue;
      this.c.a("getCity", null, new a(this.al));
      continue;
      int i;
      switch (this.g.getCheckedRadioButtonId())
      {
      default: 
        i = 0;
        label450:
        switch (this.h.getCheckedRadioButtonId())
        {
        default: 
          j = 0;
        }
        break;
      }
      try
      {
        ((JSONObject)localObject).put("rankingID", 11007);
        ((JSONObject)localObject).put("topCount", 11);
        ((JSONObject)localObject).put("rankKey", "");
        ((JSONObject)localObject).put("rankValueType", i);
        ((JSONObject)localObject).put("rankOrderType", j);
        label532:
        this.c.a("getRankingList", (JSONObject)localObject, new a(this.al));
        this.c.a("loginSilent", null, new ubm(this, this.al, (JSONObject)localObject));
        continue;
        i = 1;
        break label450;
        i = 2;
        break label450;
        bFh();
        continue;
        bFg();
      }
      catch (JSONException localJSONException)
      {
        break label532;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
  }
  
  public static class a
    implements tzd
  {
    EditText ap;
    
    public a() {}
    
    public a(EditText paramEditText)
    {
      this.ap = paramEditText;
    }
    
    private void aL(String paramString, boolean paramBoolean)
    {
      QLog.d("DoraemonOpenAPI.test", 2, paramString);
      if (this.ap != null) {
        this.ap.append(paramString);
      }
      if (paramBoolean) {
        QQToast.a(BaseApplicationImpl.getApplication(), paramString, 0).show();
      }
    }
    
    private void print(String paramString)
    {
      if (this.ap == null) {}
      for (boolean bool = true;; bool = false)
      {
        aL(paramString, bool);
        return;
      }
    }
    
    public void onComplete()
    {
      print("onComplete\n");
    }
    
    public void onFailure(int paramInt, String paramString)
    {
      print("onFailure code=" + paramInt + " msg=" + paramString + "\n");
    }
    
    public void onPermission(int paramInt)
    {
      aL("onPermission " + paramInt + "\n", true);
    }
    
    public void onSuccess(JSONObject paramJSONObject)
    {
      aL("onSuccess " + paramJSONObject + "\n", true);
      if (this.ap != null) {
        new AlertDialog.Builder(this.ap.getContext()).setTitle("onSuccess").setMessage(paramJSONObject.toString()).setNegativeButton(acfp.m(2131715243), null).create().show();
      }
    }
    
    public void onTrigger(JSONObject paramJSONObject)
    {
      print("onTrigger\n");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment
 * JD-Core Version:    0.7.0.1
 */