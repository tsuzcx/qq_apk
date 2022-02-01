package com.tencent.mobileqq.conditionsearch;

import accv;
import acfp;
import acgr;
import acgs;
import aeft;
import aefv;
import aefw;
import aefx;
import aefy;
import aefz;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import anot;
import aqiw;
import ausj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.c;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MultiImageTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LocationSelectActivity
  extends LbsBaseActivity
  implements View.OnClickListener
{
  String[] S;
  public long VV = 0L;
  private acgs jdField_a_of_type_Acgs = new aefy(this);
  private BaseAddress jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
  IphonePickerView.d jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d = new aefv(this);
  public BaseAddress[] a;
  private FormSimpleItem aA;
  private FormSimpleItem aB;
  private FormSimpleItem aC;
  public int[] aH;
  accv jdField_b_of_type_Accv;
  IphonePickerView.c jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$c = new aefw(this);
  private boolean bTG;
  private boolean bTH;
  String bwK = "1";
  final int cMz = 1000;
  public int columnCount = 0;
  public ausj d;
  public IphonePickerView d;
  DialogInterface.OnDismissListener f;
  public Object[] f;
  public Handler mHandler = new aefx(this);
  private String oz;
  private int reqType;
  
  public LocationSelectActivity()
  {
    this.jdField_f_of_type_AndroidContentDialogInterface$OnDismissListener = new aefz(this);
  }
  
  private String[] M()
  {
    int i = 0;
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
      int j = arrayOfBaseAddress.length;
      while (i < j)
      {
        BaseAddress localBaseAddress = arrayOfBaseAddress[i];
        if (localBaseAddress == null) {
          break;
        }
        arrayOfString[(localBaseAddress.addressType - 1)] = String.valueOf(accv.cm(localBaseAddress.code));
        i += 1;
      }
    }
    return arrayOfString;
  }
  
  private void R(String[] paramArrayOfString)
  {
    Intent localIntent = new Intent("action_get_lbs_location");
    localIntent.putExtra("code", paramArrayOfString);
    if (this.jdField_b_of_type_Accv != null)
    {
      paramArrayOfString = this.jdField_b_of_type_Accv.d(paramArrayOfString);
      if (paramArrayOfString != null) {
        localIntent.putExtra("location", paramArrayOfString);
      }
    }
    sendBroadcast(localIntent);
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.equals("不限")) {
        str = "";
      }
    }
    paramFormSimpleItem.setRightText(str);
  }
  
  private void a(FormSimpleItem paramFormSimpleItem, boolean paramBoolean)
  {
    if (paramFormSimpleItem != null)
    {
      this.aC.setEnabled(paramBoolean);
      paramFormSimpleItem = this.aC;
      if (paramBoolean) {
        break label51;
      }
    }
    label51:
    for (int i = 2;; i = 0)
    {
      paramFormSimpleItem.setLeftTextColor(i);
      if ((!paramBoolean) && (AppSetting.enableTalkBack)) {
        this.aC.setContentDescription(acfp.m(2131707914));
      }
      return;
    }
  }
  
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
  
  private void cWJ()
  {
    this.S = new String[] { "0", "0", "0" };
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = null;
  }
  
  private void cWK()
  {
    String[] arrayOfString = getIntent().getStringArrayExtra("param_location");
    if (arrayOfString != null)
    {
      cWJ();
      if ((this.reqType != 0) || (!this.jdField_b_of_type_Accv.ZL()) || ((arrayOfString != null) && (!arrayOfString[0].equals("0")))) {
        break label51;
      }
    }
    for (;;)
    {
      return;
      label51:
      this.bwK = arrayOfString[0];
      int i = 1;
      int j = arrayOfString.length;
      while (i < j)
      {
        this.S[(i - 1)] = arrayOfString[i];
        i += 1;
      }
    }
  }
  
  private void cWL()
  {
    if (!aqiw.isNetSupport(this))
    {
      QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
      return;
    }
    this.VV = System.currentTimeMillis();
    addObserver(this.jdField_a_of_type_Acgs);
    ((acgr)this.app.getBusinessHandler(3)).cJs();
    this.aA.setLeftTextColor(2);
    Drawable localDrawable = getResources().getDrawable(2130839657);
    this.aA.setRightIcon(localDrawable);
    ((Animatable)localDrawable).start();
    this.aA.setEnabled(false);
  }
  
  private String ci()
  {
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < this.columnCount)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i] != null) && (!"0".equals(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].code))) {
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].name).append("-");
      }
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private void initData()
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress = this.jdField_b_of_type_Accv.a(this.bwK);
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {}
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress != null)
        {
          this.columnCount = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.getColumnNember();
          if (this.aC != null)
          {
            if (this.columnCount == 0)
            {
              a(this.aC, false);
              return;
            }
            a(this.aC, true);
          }
          this.jdField_f_of_type_ArrayOfJavaLangObject = new Object[this.columnCount];
          this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress = new BaseAddress[this.columnCount];
          this.aH = new int[this.columnCount];
          if (this.columnCount == 0) {
            break;
          }
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress;
          int k = this.S.length;
          int j = 0;
          int i = 0;
          if (j < k)
          {
            if ("0".equals(this.S[j])) {}
            BaseAddress localBaseAddress;
            do
            {
              j += 1;
              break;
              this.jdField_f_of_type_ArrayOfJavaLangObject[i] = ((BaseAddress)localObject).getDataList();
              BaseAddress[] arrayOfBaseAddress = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress;
              localBaseAddress = (BaseAddress)((BaseAddress)localObject).dataMap.get(this.S[j]);
              arrayOfBaseAddress[i] = localBaseAddress;
              this.aH[i] = b((ArrayList)this.jdField_f_of_type_ArrayOfJavaLangObject[i], this.S[j]);
              i += 1;
              localObject = localBaseAddress;
            } while (localBaseAddress != null);
            return;
          }
          if (i == 0)
          {
            this.jdField_f_of_type_ArrayOfJavaLangObject[i] = ((BaseAddress)localObject).getDataList();
            this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i] = ((BaseAddress)((BaseAddress)localObject).dataMap.get(Integer.valueOf(0)));
            return;
          }
          try
          {
            if (i < this.columnCount)
            {
              this.jdField_f_of_type_ArrayOfJavaLangObject[i] = ((BaseAddress)localObject).getDataList();
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationSelectActivity", 2, "", localException);
  }
  
  private void initView()
  {
    this.bTH = getIntent().getBooleanExtra("param_is_popup", true);
    label183:
    Object localObject;
    if (this.bTH)
    {
      setRightHighlightButton(2131721066, new aeft(this));
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
      this.aA = ((FormSimpleItem)findViewById(2131365203));
      this.aB = ((FormSimpleItem)findViewById(2131365202));
      this.aC = ((FormSimpleItem)findViewById(2131365204));
      if ((this.reqType != 0) && (this.reqType != 2)) {
        break label343;
      }
      setTitle(2131691959);
      this.aA.setLeftIcon(null);
      this.aA.setLeftText(getResources().getString(2131691965));
      this.aA.setLeftTextColor(1);
      this.aA.showArrow(false);
      this.aA.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.aA.setContentDescription(acfp.m(2131707910));
      }
      this.aB.setLeftIcon(null);
      this.aB.setLeftText(getResources().getString(2131691956));
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label488;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label362;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;
    }
    for (;;)
    {
      label230:
      a(this.aB, (String)localObject);
      this.aB.setOnClickListener(this);
      if (AppSetting.enableTalkBack) {
        this.aB.setContentDescription(acfp.m(2131707908) + (String)localObject);
      }
      this.aC.setLeftIcon(null);
      this.aC.setLeftText(getResources().getString(2131691960));
      this.aC.setOnClickListener(this);
      if (this.columnCount == 0) {
        a(this.aC, false);
      }
      label343:
      label362:
      do
      {
        return;
        setLeftViewName(2131690700);
        break;
        setTitle(2131691957);
        this.aA.setVisibility(8);
        break label183;
        localObject = acfp.m(2131707912);
        break label230;
        a(this.aC, true);
        this.oz = getIntent().getStringExtra("param_location_param");
        localObject = this.jdField_b_of_type_Accv.k(this.oz);
        if (localObject[0].equals(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name)) {
          this.oz = localObject[1];
        }
        a(this.aC, this.oz);
      } while (!AppSetting.enableTalkBack);
      this.aC.setContentDescription(acfp.m(2131707906) + this.aC.a().getText());
      return;
      label488:
      localObject = null;
    }
  }
  
  private void rt()
  {
    this.jdField_d_of_type_Ausj = ausj.d(this);
    DispatchActionMoveScrollView localDispatchActionMoveScrollView = (DispatchActionMoveScrollView)this.jdField_d_of_type_Ausj.findViewById(2131362014);
    localDispatchActionMoveScrollView.cZW = true;
    localDispatchActionMoveScrollView.setBackgroundResource(17170445);
    this.jdField_d_of_type_Ausj.setOnDismissListener(this.jdField_f_of_type_AndroidContentDialogInterface$OnDismissListener);
    this.jdField_d_of_type_Ausj.setCloseAutoRead(true);
    this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561390, null));
    this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d);
    int i = 0;
    while (i < this.columnCount)
    {
      this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, this.aH[i]);
      i += 1;
    }
    this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$c);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_d_of_type_Ausj.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_d_of_type_Ausj.setActionContentView(this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    try
    {
      this.bTG = false;
      this.jdField_d_of_type_Ausj.show();
      this.aC.setRightTextColor(1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocationSelectActivity", 2, localThrowable.getMessage());
        }
        this.bTG = true;
      }
    }
  }
  
  private String te()
  {
    String str = ci();
    if (!"不限".equals(str)) {
      return str;
    }
    return "";
  }
  
  public void bQr() {}
  
  public void c(boolean paramBoolean, String[] paramArrayOfString)
  {
    BaseAddress localBaseAddress = null;
    this.aA.setLeftTextColor(1);
    this.aA.setRightIcon(null);
    this.aA.setEnabled(true);
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length == 4))
    {
      if (this.bTG)
      {
        if (!TextUtils.isEmpty(paramArrayOfString[0])) {
          localBaseAddress = this.jdField_b_of_type_Accv.a(paramArrayOfString[0]);
        }
        if (localBaseAddress == null) {
          break label253;
        }
        this.bwK = paramArrayOfString[0];
        cWJ();
        m = paramArrayOfString.length;
        j = 0;
        i = 1;
        while (i < m)
        {
          k = j;
          if (!TextUtils.isEmpty(paramArrayOfString[i]))
          {
            this.S[j] = paramArrayOfString[i];
            k = j + 1;
          }
          i += 1;
          j = k;
        }
        initData();
        a(this.aB, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        this.aB.setContentDescription(acfp.m(2131707909) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        if (this.columnCount != 0) {
          break label245;
        }
        paramArrayOfString = "";
        a(this.aC, paramArrayOfString);
        this.aC.setContentDescription(acfp.m(2131707911) + paramArrayOfString);
      }
      label245:
      label253:
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          int m;
          int j;
          int i;
          int k;
          return;
          paramArrayOfString = ci();
        }
      }
      QLog.d("LocationSelectActivity", 2, "invalid country code!! | cournty code is :" + paramArrayOfString[0]);
      return;
    }
    QQToast.a(this, 2131691953, 0).show(getTitleBarHeight());
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_country_code");
      if ((!TextUtils.isEmpty(paramIntent)) && (!paramIntent.equals(this.bwK)))
      {
        if (this.jdField_b_of_type_Accv.a(paramIntent) != null) {
          break label83;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LocationSelectActivity", 2, "doOnActivityResult | should not be here, can not get country by code ! result code = " + paramIntent);
        }
      }
    }
    return;
    label83:
    this.bwK = paramIntent;
    cWJ();
    initData();
    a(this.aB, this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
    if (this.columnCount == 0) {}
    for (paramIntent = "";; paramIntent = "不限")
    {
      a(this.aC, paramIntent);
      if (AppSetting.enableTalkBack)
      {
        this.aB.setContentDescription(acfp.m(2131707913) + this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name);
        this.aC.setContentDescription(acfp.m(2131707907) + this.aC.a().getText());
      }
      if (this.reqType != 0) {
        break;
      }
      anot.a(this.app, "CliOper", "", "", "0X8004247", "0X8004247", 0, 0, accv.cm(this.bwK) + "", "", "", "");
      return;
    }
    anot.a(this.app, "CliOper", "", "", "0X8004249", "0X8004249", 0, 0, accv.cm(this.bwK) + "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.reqType = getIntent().getIntExtra("param_req_type", 0);
    setContentBackgroundResource(2130838900);
    setContentView(2131561414);
    this.jdField_b_of_type_Accv = ((accv)this.app.getManager(59));
    cWK();
    initData();
    initView();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Acgs);
    super.doOnDestroy();
  }
  
  public boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = this.bwK;
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    arrayOfString[3] = "0";
    int i;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress != null)
    {
      int j = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress.length;
      i = 0;
      if ((i < j) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i] != null)) {}
    }
    else
    {
      localIntent.putExtra("param_location", arrayOfString);
      str = te();
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress == null) {
        break label216;
      }
      if (!TextUtils.isEmpty(str)) {
        break label179;
      }
    }
    label179:
    for (String str = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name;; str = this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataBaseAddress.name + "-" + ci())
    {
      localIntent.putExtra("param_location_param", str);
      R(arrayOfString);
      setResult(-1, localIntent);
      finish();
      if (this.bTH) {
        overridePendingTransition(0, 2130771990);
      }
      return false;
      arrayOfString[this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].addressType] = this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[i].code;
      i += 1;
      break;
    }
    label216:
    if ((this.reqType == 2) || (this.reqType == 3)) {}
    for (str = "";; str = "不限")
    {
      localIntent.putExtra("param_location_param", str);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.app, "CliOper", "", "", "0X8004246", "0X8004246", 0, 0, "", "", "", "");
      this.bTG = true;
      S(new LocationSelectActivity.2(this));
      continue;
      Intent localIntent = new Intent(this, CountrySelectActivity.class);
      localIntent.putExtra("key_country_code", this.bwK);
      if ((this.reqType == 1) || (this.reqType == 0)) {
        bool = true;
      }
      localIntent.putExtra("key_no_limit_allow", bool);
      startActivityForResult(localIntent, 1000);
      continue;
      rt();
    }
  }
  
  public int vv()
  {
    return 2131691950;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */