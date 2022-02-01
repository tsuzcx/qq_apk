package com.tencent.device.msg.activities;

import aczy;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import arhz;
import arwt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import szn;
import szo;
import szp;
import tar;
import tas;

public class DeviceMsgSettingActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  public CompoundButton a;
  LinearLayout fC;
  public String fH;
  AppInterface mApp;
  public Handler mHandler = new Handler();
  public String mPid;
  public arhz mProgress;
  String mUin;
  public ArrayList<a> ox = new ArrayList();
  
  private void bCe()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.mUin);
    localBundle.putString("din", this.fH);
    localBundle.putString("pid", this.mPid);
    localBundle.putString("appid", "1300000607");
    int j = 0;
    String str2 = "get_lightapp_property";
    String str1 = str2;
    int i = j;
    if ("9971".equals(this.fH))
    {
      str1 = str2;
      i = j;
      if ("9971".equals(this.mPid))
      {
        i = 2;
        str1 = "get_device_property";
      }
    }
    tas.a(str1, localBundle, i, null, this.mApp, new szo(this));
  }
  
  private void bCf()
  {
    Object localObject = (TextView)super.findViewById(2131378144);
    if (localObject != null)
    {
      if (this.ox.size() == 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      localObject = super.findViewById(2131378137);
      if (localObject != null)
      {
        if (this.ox.size() != 0) {
          break label99;
        }
        ((View)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = super.findViewById(2131378138);
      if (localObject != null)
      {
        if (this.ox.size() != 0) {
          break label107;
        }
        ((View)localObject).setVisibility(0);
        arwt.d("DeviceMsgSettingActivity", "show none background");
      }
      return;
      ((TextView)localObject).setVisibility(0);
      break;
      label99:
      ((View)localObject).setVisibility(0);
    }
    label107:
    arwt.d("DeviceMsgSettingActivity", "hide none background");
    ((View)localObject).setVisibility(8);
  }
  
  private void init()
  {
    Intent localIntent = super.getIntent();
    this.mPid = String.valueOf(localIntent.getIntExtra("pid", 0));
    this.fH = localIntent.getStringExtra("din");
    this.mApp = ((AppInterface)super.getAppRuntime());
    this.mUin = this.mApp.getCurrentAccountUin();
    this.mProgress = new arhz(this, super.getTitleBarHeight());
    this.fC = ((LinearLayout)super.findViewById(2131378135));
    this.mProgress.setMessage(2131694323);
    if ((!super.isFinishing()) && (!this.mProgress.isShowing())) {
      this.mProgress.show();
    }
    bCe();
    tar.a(this.app, Long.parseLong(this.fH), "Usr_MsgMgr_Open", 0, 0, Integer.parseInt(this.mPid));
  }
  
  private void uc(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.mUin);
    localBundle.putString("din", this.fH);
    localBundle.putString("pid", this.mPid);
    localBundle.putString("appid", "1300000607");
    localBundle.putString("data", paramString);
    int j = 0;
    String str = "set_lightapp_property";
    paramString = str;
    int i = j;
    if ("9971".equals(this.fH))
    {
      paramString = str;
      i = j;
      if ("9971".equals(this.mPid))
      {
        i = 2;
        paramString = "set_device_property";
      }
    }
    tas.a(paramString, localBundle, i, null, this.app, new szp(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559216);
    super.setTitle(2131692600);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!aczy.bd(this)) {
        aczy.a(this, 3, new szn(this));
      }
    }
    for (;;)
    {
      return true;
      init();
      continue;
      init();
    }
  }
  
  public void initUI()
  {
    bCf();
    int j = this.ox.size();
    int i = 0;
    if (i < j)
    {
      a locala = (a)this.ox.get(i);
      FormSwitchItem localFormSwitchItem = new FormSwitchItem(this, null);
      localFormSwitchItem.setBgType(0);
      localFormSwitchItem.setText(locala.name);
      localFormSwitchItem.setFocusable(true);
      label76:
      Switch localSwitch;
      if (j == 1)
      {
        localFormSwitchItem.setBgType(0);
        localSwitch = localFormSwitchItem.a();
        localSwitch.setTag(Integer.valueOf(locala.id));
        if (locala.enable != 1) {
          break label173;
        }
      }
      label173:
      for (boolean bool = true;; bool = false)
      {
        localSwitch.setChecked(bool);
        localSwitch.setOnCheckedChangeListener(this);
        this.fC.addView(localFormSwitchItem);
        i += 1;
        break;
        if (i == 0)
        {
          localFormSwitchItem.setBgType(1);
          break label76;
        }
        if (i == j - 1)
        {
          localFormSwitchItem.setBgType(3);
          break label76;
        }
        localFormSwitchItem.setBgType(2);
        break label76;
      }
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = ((Integer)paramCompoundButton.getTag()).intValue();
    this.mProgress.setMessage(2131719605);
    if ((!super.isFinishing()) && (!this.mProgress.isShowing())) {
      this.mProgress.show();
    }
    Object localObject1 = new JSONArray();
    Iterator localIterator = this.ox.iterator();
    Object localObject2;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = (a)localIterator.next();
        if (((a)localObject2).id == j)
        {
          int k = ((a)localObject2).enable;
          if (paramBoolean)
          {
            i = 1;
            label109:
            if (k != i) {
              break label174;
            }
            localObject1 = this.app;
            long l = Long.parseLong(this.fH);
            if (!paramBoolean) {
              break label169;
            }
            i = 1;
            label136:
            tar.a((AppRuntime)localObject1, l, "Usr_MsgMgr_Setting", i, 1, Integer.parseInt(this.mPid));
          }
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break label109;
      label169:
      i = 2;
      break label136;
      for (;;)
      {
        try
        {
          label174:
          localObject2 = new JSONObject().put("id", ((a)localObject2).id);
          if (!paramBoolean) {
            break label228;
          }
          i = 1;
          ((JSONArray)localObject1).put(((JSONObject)localObject2).put("enable", i));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        break;
        label228:
        i = 0;
      }
      this.a = paramCompoundButton;
      uc(((JSONArray)localObject1).toString());
    }
  }
  
  public class a
  {
    public int enable;
    public int id;
    public String name;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceMsgSettingActivity
 * JD-Core Version:    0.7.0.1
 */