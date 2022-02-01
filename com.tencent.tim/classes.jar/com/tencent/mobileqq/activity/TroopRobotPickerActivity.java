package com.tencent.mobileqq.activity;

import accv;
import acfp;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import ausj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import wdl;
import wdm;

public class TroopRobotPickerActivity
  extends BaseActivity
{
  public static String TAG = "TroopRobotPickerActivity";
  static final String[] cw = { "provn", "city", "area", "" };
  TextView GO;
  ausj Y;
  public ProgressDialog a;
  public RobotPickerData a;
  String aRK;
  JSONObject aT;
  JSONObject aU;
  accv b;
  IphonePickerView f;
  
  private int b(ArrayList<? extends BaseAddress> paramArrayList, String paramString)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((BaseAddress)paramArrayList.get(i)).code.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private void bXt()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType;
    if (i == 3) {
      initLocationData();
    }
    this.Y = ausj.d(this);
    Object localObject = (DispatchActionMoveScrollView)this.Y.findViewById(2131362014);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).cZW = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.f = ((IphonePickerView)LayoutInflater.from(this).inflate(2131561390, null));
    this.f.a(new c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
    this.f.setBackgroundColor(-1118221);
    if (i == 2)
    {
      this.f.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1);
      this.f.setSelection(1, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2);
    }
    for (;;)
    {
      this.f.setPickListener(new a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData, this.f, this.Y));
      if (Build.VERSION.SDK_INT >= 11) {
        this.Y.getWindow().setFlags(16777216, 16777216);
      }
      this.Y.setActionContentView(this.f, null);
      this.Y.setOnDismissListener(new b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
      try
      {
        this.Y.show();
        return;
        if (i == 1)
        {
          this.f.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex);
        }
        else
        {
          i = 0;
          while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
          {
            this.f.setSelection(i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i]);
            i += 1;
          }
          this.GO = ((TextView)this.f.findViewById(2131377935));
          this.GO.setVisibility(0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null) {}
          for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name;; localObject = "中国")
          {
            this.GO.setText((CharSequence)localObject);
            this.GO.setOnClickListener(new wdl(this));
            if (!AppSetting.enableTalkBack) {
              break;
            }
            this.GO.setContentDescription(acfp.m(2131716101) + (String)localObject + acfp.m(2131716103));
            break;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(TAG, 2, localThrowable.getMessage());
      }
    }
  }
  
  private void initLocationData()
  {
    xb("");
  }
  
  private void xb(String paramString)
  {
    localObject1 = "";
    try
    {
      localObject2 = this.aU.optString("countryCode");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
        continue;
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry;
        int k = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray.length;
        int j = 0;
        int i = 0;
        Object localObject3;
        if (j < k)
        {
          if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[j])) {}
          do
          {
            j += 1;
            break;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[i] = paramString.getDataList();
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray;
            localObject1 = (BaseAddress)paramString.dataMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[j]);
            localObject3[i] = localObject1;
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i] = b((ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[i], this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[j]);
            i += 1;
            paramString = (String)localObject1;
          } while (localObject1 != null);
          return;
        }
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray[i] = paramString.getDataList();
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray[i] = ((BaseAddress)paramString.dataMap.get(Integer.valueOf(0)));
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray[i] = 0;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject3 = new StringBuilder().append("initLocationData|mLocationColumCount : ").append(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount).append(", mLocationCountry.name : ");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry == null) {}
          for (paramString = "null";; paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name)
          {
            QLog.d((String)localObject1, 2, paramString);
            return;
          }
          paramString = (String)localObject3;
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "1";
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.b.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry = paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.getColumnNember();
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationListArray = new Object[this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount];
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationArray = new BaseAddress[this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount];
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationIndexArray = new int[this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount];
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount == 0) {
          return;
        }
      }
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      String str = paramIntent.getStringExtra("key_country_code");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "doOnActivityResult | codes = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode = str;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry = this.b.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.getColumnNember();
          if ((i > 0) && (i <= 3)) {
            break label183;
          }
          xb(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
          if ((this.Y != null) && (this.Y.isShowing())) {
            this.Y.dismiss();
          }
        }
      }
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label183:
      xb(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode);
      if ((this.Y != null) && (this.Y.isShowing()))
      {
        if (this.f == null) {
          this.f = ((IphonePickerView)getLayoutInflater().inflate(2131561390, null));
        }
        this.f.a(new c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData));
        i = 0;
        while (i < this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationColumCount)
        {
          this.f.LV(i);
          this.f.setSelection(i, 0);
          i += 1;
        }
      }
      if (this.GO != null)
      {
        this.GO.setText(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name);
        if (AppSetting.enableTalkBack) {
          this.GO.setContentDescription(acfp.m(2131716111) + this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountry.name + acfp.m(2131716114));
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppProgressDialog = new ReportProgressDialog(this);
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(acfp.m(2131716108));
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData = new RobotPickerData();
    try
    {
      this.aT = new JSONObject(getIntent().getStringExtra("json"));
      this.aU = this.aT.getJSONObject("selected");
      this.aRK = this.aT.optString("callback");
      if ((this.aT == null) || (this.aRK == null))
      {
        finish();
        if (QLog.isColorLevel()) {
          QLog.e("" + TAG, 2, "webData is null!");
        }
        return false;
      }
    }
    catch (JSONException paramBundle)
    {
      do
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType = this.aT.optInt("type");
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 0)
          {
            finish();
            QQToast.a(this, acfp.m(2131716107), 1).show();
            return false;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          for (;;)
          {
            this.b = ((accv)this.app.getManager(59));
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType != 3) {
              break;
            }
            this.jdField_a_of_type_AndroidAppProgressDialog.show();
            this.b.addListener(new wdm(this));
            this.b.q(this.b.Ai(), true);
            return false;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mSexIndex = this.aU.optInt("sex");
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1 = this.aU.optInt("ageStart");
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2 = this.aU.optInt("ageEnd");
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex1 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex1;
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mCurAgeIndex2 = this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mAgeSelectIndex2;
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray = new String[3];
              int i = 0;
              while (i < 3)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCodeArray[i] = this.aU.optString(cw[i]);
                i += 1;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.mLocationCountyCode = this.aU.optString("country");
            }
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopRobotPickerActivity$RobotPickerData.pickerType == -1);
      bXt();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.b != null) {
      this.b.aW(this);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.b != null) {
      this.b.aV(this);
    }
  }
  
  public static class RobotPickerData
    implements Serializable
  {
    public static final int REQ_ROBOT_PICKER = 111;
    static final int TYPE_AGE_PICKER = 2;
    static final int TYPE_LOCATION_PICKER = 3;
    static final int TYPE_SEX_PICKER = 1;
    public int mAgeSelectIndex1;
    public int mAgeSelectIndex2;
    public int mCurAgeIndex1;
    public int mCurAgeIndex2;
    public BaseAddress[] mLocationArray;
    public String[] mLocationCodeArray;
    public int mLocationColumCount;
    public BaseAddress mLocationCountry;
    public String mLocationCountyCode;
    public int[] mLocationIndexArray;
    public Object[] mLocationListArray;
    public int mSexIndex;
    public int pickerType = -1;
  }
  
  class a
    implements IphonePickerView.c
  {
    public TroopRobotPickerActivity.RobotPickerData b;
    ausj jdField_d_of_type_Ausj;
    IphonePickerView jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
    
    a(TroopRobotPickerActivity.RobotPickerData paramRobotPickerData, IphonePickerView paramIphonePickerView, ausj paramausj)
    {
      this.b = paramRobotPickerData;
      this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = paramIphonePickerView;
      this.jdField_d_of_type_Ausj = paramausj;
    }
    
    public void dn()
    {
      if ((this.b.pickerType == 2) && (this.b.mCurAgeIndex1 > this.b.mCurAgeIndex2) && (this.b.mCurAgeIndex2 != 0)) {
        QQToast.a(TroopRobotPickerActivity.this, TroopRobotPickerActivity.this.getResources().getString(2131691949), 0).show();
      }
      while ((this.jdField_d_of_type_Ausj == null) || (!this.jdField_d_of_type_Ausj.isShowing())) {
        return;
      }
      this.jdField_d_of_type_Ausj.dismiss();
    }
    
    public void w(int paramInt1, int paramInt2)
    {
      if (this.b == null) {}
      do
      {
        do
        {
          ArrayList localArrayList2;
          do
          {
            do
            {
              for (;;)
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d(TroopRobotPickerActivity.TAG, 2, "onItemSelected|pickerType : " + this.b.pickerType + ", column : " + paramInt1 + ", row : " + paramInt2);
                }
                if (this.b.pickerType == 2)
                {
                  int i;
                  if (paramInt2 >= 0)
                  {
                    i = paramInt2;
                    if (paramInt2 < accv.dS.length) {}
                  }
                  else
                  {
                    i = 0;
                  }
                  switch (paramInt1)
                  {
                  }
                  while ((this.b.mCurAgeIndex1 <= this.b.mCurAgeIndex2) || (this.b.mCurAgeIndex2 == 0))
                  {
                    this.b.mAgeSelectIndex1 = this.b.mCurAgeIndex1;
                    this.b.mAgeSelectIndex2 = this.b.mCurAgeIndex2;
                    return;
                    this.b.mCurAgeIndex1 = i;
                    continue;
                    this.b.mCurAgeIndex2 = i;
                  }
                }
                else
                {
                  if (this.b.pickerType == 1)
                  {
                    if (paramInt2 >= 0)
                    {
                      paramInt1 = paramInt2;
                      if (paramInt2 < accv.dT.length) {}
                    }
                    else
                    {
                      paramInt1 = 0;
                    }
                    this.b.mSexIndex = paramInt1;
                    return;
                  }
                  switch (paramInt1)
                  {
                  default: 
                    return;
                  case 0: 
                    if ((this.b.mLocationListArray[0] != null) && (((List)this.b.mLocationListArray[0]).size() > 0))
                    {
                      if (paramInt2 >= 0)
                      {
                        paramInt1 = paramInt2;
                        if (paramInt2 < ((List)this.b.mLocationListArray[0]).size()) {}
                      }
                      else
                      {
                        paramInt1 = 0;
                      }
                      this.b.mLocationIndexArray[0] = paramInt1;
                      this.b.mLocationArray[0] = ((BaseAddress)((List)this.b.mLocationListArray[0]).get(paramInt1));
                      this.b.mLocationCodeArray[0] = this.b.mLocationArray[0].code;
                      ArrayList localArrayList1 = this.b.mLocationArray[0].getDataList();
                      if (this.b.mLocationColumCount > 1)
                      {
                        this.b.mLocationListArray[1] = localArrayList1;
                        this.b.mLocationIndexArray[1] = 0;
                        this.b.mLocationArray[1] = new AddressData.NO_LIMIT_ADDRESS(2);
                        this.b.mLocationCodeArray[1] = "0";
                        try
                        {
                          this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(1);
                          this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, 0);
                          if (this.b.mLocationColumCount > 2)
                          {
                            this.b.mLocationListArray[2] = null;
                            this.b.mLocationIndexArray[2] = 0;
                            this.b.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
                            this.b.mLocationCodeArray[2] = "0";
                            try
                            {
                              this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(2);
                              this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
                              return;
                            }
                            catch (Exception localException1)
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d(TroopRobotPickerActivity.TAG, 2, localException1, new Object[0]);
                              }
                            }
                            if ((this.jdField_d_of_type_Ausj != null) && (this.jdField_d_of_type_Ausj.isShowing()))
                            {
                              this.jdField_d_of_type_Ausj.dismiss();
                              return;
                            }
                          }
                        }
                        catch (Exception localException2)
                        {
                          for (;;)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.d(TroopRobotPickerActivity.TAG, 2, localException2, new Object[0]);
                            }
                            if ((this.jdField_d_of_type_Ausj != null) && (this.jdField_d_of_type_Ausj.isShowing())) {
                              this.jdField_d_of_type_Ausj.dismiss();
                            }
                          }
                        }
                      }
                    }
                    break;
                  }
                }
              }
            } while ((this.b.mLocationListArray[1] == null) || (((List)this.b.mLocationListArray[1]).size() <= 0));
            if (paramInt2 >= 0)
            {
              paramInt1 = paramInt2;
              if (paramInt2 < ((List)this.b.mLocationListArray[1]).size()) {}
            }
            else
            {
              paramInt1 = 0;
            }
            this.b.mLocationIndexArray[1] = paramInt1;
            this.b.mLocationArray[1] = ((BaseAddress)((List)this.b.mLocationListArray[1]).get(paramInt1));
            this.b.mLocationCodeArray[1] = this.b.mLocationArray[1].code;
            localArrayList2 = this.b.mLocationArray[1].getDataList();
          } while (this.b.mLocationColumCount <= 2);
          this.b.mLocationListArray[2] = localArrayList2;
          this.b.mLocationIndexArray[2] = 0;
          this.b.mLocationArray[2] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.b.mLocationCodeArray[2] = "0";
          try
          {
            this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(2);
            this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, 0);
            return;
          }
          catch (Exception localException3)
          {
            if (QLog.isColorLevel()) {
              QLog.d(TroopRobotPickerActivity.TAG, 2, localException3, new Object[0]);
            }
          }
        } while ((this.jdField_d_of_type_Ausj == null) || (!this.jdField_d_of_type_Ausj.isShowing()));
        this.jdField_d_of_type_Ausj.dismiss();
        return;
      } while ((this.b.mLocationListArray[2] == null) || (((List)this.b.mLocationListArray[2]).size() <= 0));
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ((List)this.b.mLocationListArray[2]).size()) {}
      }
      else
      {
        paramInt1 = 0;
      }
      this.b.mLocationIndexArray[2] = paramInt1;
      this.b.mLocationArray[2] = ((BaseAddress)((List)this.b.mLocationListArray[2]).get(paramInt1));
      this.b.mLocationCodeArray[2] = this.b.mLocationArray[2].code;
    }
  }
  
  class b
    implements DialogInterface.OnDismissListener
  {
    TroopRobotPickerActivity.RobotPickerData b;
    
    b(TroopRobotPickerActivity.RobotPickerData paramRobotPickerData)
    {
      this.b = paramRobotPickerData;
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TroopRobotPickerActivity.TAG, 2, "onDismiss|pickerType : " + this.b.pickerType);
      }
      if (this.b.pickerType == 2)
      {
        paramDialogInterface = new Intent();
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("ageStart", this.b.mAgeSelectIndex1);
          localJSONObject.put("ageEnd", this.b.mAgeSelectIndex2);
          paramDialogInterface.putExtra("result", localJSONObject.toString());
          paramDialogInterface.putExtra("callback", TroopRobotPickerActivity.this.aRK);
          TroopRobotPickerActivity.this.setResult(-1, paramDialogInterface);
          TroopRobotPickerActivity.this.finish();
          if (QLog.isColorLevel()) {
            QLog.d(TroopRobotPickerActivity.TAG, 2, "onDismiss|mCurAgeIndex1 : " + this.b.mCurAgeIndex1 + ", mCurAgeIndex2 : " + this.b.mCurAgeIndex2 + ", mAgeSelectIndex1 : " + this.b.mAgeSelectIndex1 + ", mAgeSelectIndex2 : " + this.b.mAgeSelectIndex2);
          }
          return;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
          }
        }
      }
      int i = this.b.pickerType;
      paramDialogInterface = this.b;
      if (i == 1)
      {
        paramDialogInterface = new Intent();
        localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("sex", this.b.mSexIndex);
          paramDialogInterface.putExtra("callback", TroopRobotPickerActivity.this.aRK);
          paramDialogInterface.putExtra("result", localJSONObject.toString());
          TroopRobotPickerActivity.this.setResult(-1, paramDialogInterface);
          TroopRobotPickerActivity.this.finish();
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
      paramDialogInterface = new Intent();
      JSONObject localJSONObject = new JSONObject();
      i = 0;
      try
      {
        while (i < this.b.mLocationCodeArray.length)
        {
          localJSONObject.put(TroopRobotPickerActivity.cw[i], this.b.mLocationCodeArray[i]);
          localJSONObject.put(TroopRobotPickerActivity.cw[i] + "Str", this.b.mLocationArray[i].name);
          i += 1;
        }
        localJSONObject.put("country", this.b.mLocationCountyCode);
        localJSONObject.put("countryStr", this.b.mLocationCountry.name);
      }
      catch (JSONException localJSONException3)
      {
        for (;;)
        {
          localJSONException3.printStackTrace();
        }
      }
      paramDialogInterface.putExtra("result", localJSONObject.toString());
      paramDialogInterface.putExtra("callback", TroopRobotPickerActivity.this.aRK);
      TroopRobotPickerActivity.this.setResult(-1, paramDialogInterface);
      TroopRobotPickerActivity.this.finish();
    }
  }
  
  class c
    implements IphonePickerView.d
  {
    public TroopRobotPickerActivity.RobotPickerData b;
    
    c(TroopRobotPickerActivity.RobotPickerData paramRobotPickerData)
    {
      this.b = paramRobotPickerData;
    }
    
    public String d(int paramInt1, int paramInt2)
    {
      String str2 = "";
      int i;
      String str1;
      if (this.b.pickerType == 2)
      {
        if (paramInt2 >= 0)
        {
          i = paramInt2;
          if (paramInt2 < accv.dS.length) {}
        }
        else
        {
          i = 0;
        }
        str1 = accv.dS[i];
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopRobotPickerActivity.TAG, 2, "getText|pickerType : " + this.b.pickerType + ", column : " + paramInt1 + ", row : " + i + ", result : " + str1);
        }
        return str1;
        if (this.b.pickerType == 1)
        {
          if (paramInt2 >= 0)
          {
            i = paramInt2;
            if (paramInt2 < accv.dT.length) {}
          }
          else
          {
            i = 0;
          }
          str1 = accv.dR[i];
        }
        else
        {
          str1 = str2;
          i = paramInt2;
          if (this.b.pickerType == 3)
          {
            str1 = str2;
            i = paramInt2;
            if (this.b.mLocationListArray[paramInt1] != null)
            {
              if (paramInt2 >= 0)
              {
                i = paramInt2;
                if (paramInt2 < ((List)this.b.mLocationListArray[paramInt1]).size()) {}
              }
              else
              {
                i = 0;
              }
              if (((BaseAddress)((List)this.b.mLocationListArray[paramInt1]).get(i)).code.equals("0")) {
                str1 = acfp.m(2131716106);
              } else {
                str1 = ((BaseAddress)((List)this.b.mLocationListArray[paramInt1]).get(i)).name;
              }
            }
          }
        }
      }
    }
    
    public int getColumnCount()
    {
      int j = 1;
      int i = this.b.pickerType;
      TroopRobotPickerActivity.RobotPickerData localRobotPickerData = this.b;
      if (i == 2) {
        i = 2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopRobotPickerActivity.TAG, 2, "getColumnCount|pickerType : " + this.b.pickerType + ", count : " + i);
        }
        return i;
        int k = this.b.pickerType;
        localRobotPickerData = this.b;
        i = j;
        if (k != 1)
        {
          k = this.b.pickerType;
          localRobotPickerData = this.b;
          i = j;
          if (k == 3) {
            i = this.b.mLocationColumCount;
          }
        }
      }
    }
    
    public int t(int paramInt)
    {
      int j = 0;
      int i = this.b.pickerType;
      TroopRobotPickerActivity.RobotPickerData localRobotPickerData = this.b;
      if (i == 2) {
        i = accv.dS.length;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TroopRobotPickerActivity.TAG, 2, "getRowCount|pickerType : " + this.b.pickerType + ", column : " + paramInt + ", count : " + i);
        }
        return i;
        i = this.b.pickerType;
        localRobotPickerData = this.b;
        if (i == 1)
        {
          i = accv.dR.length;
        }
        else
        {
          int k = this.b.pickerType;
          localRobotPickerData = this.b;
          i = j;
          if (k == 3)
          {
            i = j;
            if (paramInt < this.b.mLocationColumCount)
            {
              i = j;
              if (paramInt >= 0)
              {
                i = j;
                if (this.b.mLocationListArray[paramInt] != null) {
                  i = ((List)this.b.mLocationListArray[paramInt]).size();
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRobotPickerActivity
 * JD-Core Version:    0.7.0.1
 */