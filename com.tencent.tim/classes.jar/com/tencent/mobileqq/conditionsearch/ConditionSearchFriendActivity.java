package com.tencent.mobileqq.conditionsearch;

import accv;
import accv.b;
import accv.d;
import acfp;
import acgs;
import aefk;
import aefl;
import aefm;
import aefn;
import aefo;
import aefp;
import aefq;
import aefr;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import anot;
import aqiw;
import arhz;
import ausj;
import auvj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
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

public class ConditionSearchFriendActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String bwH = acfp.m(2131704267);
  View Bv;
  View Bw;
  View Bx;
  public View By;
  public TextView GO;
  TextView Ra;
  TextView Rb;
  TextView Rc;
  accv.b jdField_a_of_type_Accv$b = new aefq(this);
  accv.d jdField_a_of_type_Accv$d = new aefp(this);
  acgs jdField_a_of_type_Acgs = new aefr(this);
  IphonePickerView.d jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d = new aefl(this);
  public FormSimpleItem av;
  public FormSimpleItem aw;
  public FormSimpleItem ax;
  FormSimpleItem ay;
  public FormSimpleItem az;
  public accv b;
  IphonePickerView.c b;
  public int bHl = 0;
  public boolean bTA = false;
  public boolean bTB = false;
  public boolean bTC = true;
  public boolean bTD = true;
  EditText bb;
  public int cMt;
  public int cMu;
  public int cMv;
  private final int cMw = 20;
  private int cMx;
  public ausj d;
  public IphonePickerView d;
  DialogInterface.OnDismissListener f = new aefn(this);
  Button fQ;
  public String keyword;
  public int mAgeSelectIndex1;
  public int mAgeSelectIndex2;
  public int mCurAgeIndex1;
  public int mCurAgeIndex2;
  Handler mHandler = new aefo(this);
  public BaseAddress[] mLocationArray;
  public String[] mLocationCodeArray;
  public int mLocationColumCount;
  BaseAddress mLocationCountry;
  public String mLocationCountyCode;
  public int[] mLocationIndexArray;
  public Object[] mLocationListArray;
  View mRoot;
  public int pickerType;
  arhz u;
  
  public ConditionSearchFriendActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$c = new aefm(this);
  }
  
  private void LS(int paramInt)
  {
    int i = 1;
    Object localObject = null;
    String[] arrayOfString;
    if (paramInt == 1)
    {
      localObject = this.jdField_b_of_type_Accv.H();
      this.mLocationCountyCode = localObject[0];
      if (this.mLocationCountyCode.equals("0"))
      {
        arrayOfString = this.jdField_b_of_type_Accv.G();
        this.mLocationCountyCode = arrayOfString[0];
        localObject = arrayOfString;
        if (this.mLocationCountyCode.equals("0"))
        {
          this.mLocationCountyCode = "1";
          localObject = arrayOfString;
        }
      }
    }
    for (;;)
    {
      this.mLocationCodeArray = new String[] { "0", "0", "0" };
      if (localObject == null) {
        break;
      }
      int j = localObject.length;
      while (i < j)
      {
        this.mLocationCodeArray[(i - 1)] = localObject[i];
        i += 1;
      }
      if (paramInt == 2)
      {
        arrayOfString = this.jdField_b_of_type_Accv.I();
        this.mLocationCountyCode = arrayOfString[0];
        localObject = arrayOfString;
        if (this.mLocationCountyCode.equals("0"))
        {
          this.mLocationCountyCode = "1";
          localObject = arrayOfString;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "initLocationCode|type : " + paramInt + ", mLocationCountyCode : " + this.mLocationCountyCode);
    }
  }
  
  private void LT(int paramInt)
  {
    int j = -1;
    this.pickerType = paramInt;
    this.jdField_d_of_type_Ausj = ausj.d(this);
    Object localObject = (DispatchActionMoveScrollView)this.jdField_d_of_type_Ausj.findViewById(2131362014);
    ((DispatchActionMoveScrollView)localObject).getChildAt(0).setOnClickListener(null);
    ((DispatchActionMoveScrollView)localObject).cZW = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561390, null));
    this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d);
    this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setBackgroundColor(-1118221);
    int i;
    if (paramInt == 0)
    {
      paramInt = gZ(this.mAgeSelectIndex1);
      i = gZ(this.mAgeSelectIndex2);
      this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, paramInt);
      this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, i);
      this.av.setRightTextColor(1);
      i = q(this.av);
      paramInt = this.av.getHeight();
    }
    for (;;)
    {
      this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$c);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_d_of_type_Ausj.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_d_of_type_Ausj.setActionContentView(this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_d_of_type_Ausj.setOnDismissListener(this.f);
      try
      {
        this.jdField_d_of_type_Ausj.show();
        this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.post(new ConditionSearchFriendActivity.5(this, i, paramInt));
        return;
        if (paramInt == 3)
        {
          this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.cMu);
          this.az.setRightTextColor(1);
          i = q(this.az);
          paramInt = this.az.getHeight();
        }
        else
        {
          i = 0;
          while (i < this.mLocationColumCount)
          {
            this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(i, this.mLocationIndexArray[i]);
            i += 1;
          }
          this.GO = ((TextView)this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.findViewById(2131377935));
          this.GO.setVisibility(0);
          if (this.mLocationCountry != null) {}
          for (localObject = this.mLocationCountry.name;; localObject = "中国")
          {
            this.GO.setText((CharSequence)localObject);
            this.GO.setOnClickListener(this);
            if (AppSetting.enableTalkBack) {
              this.GO.setContentDescription(acfp.m(2131704269) + (String)localObject + acfp.m(2131704266));
            }
            if (paramInt != 1) {
              break label459;
            }
            this.aw.setRightTextColor(1);
            i = q(this.aw);
            paramInt = this.aw.getHeight();
            break;
          }
          label459:
          if (paramInt == 2)
          {
            this.ax.setRightTextColor(1);
            i = q(this.ax);
            paramInt = this.ax.getHeight();
          }
          else
          {
            paramInt = -1;
            i = j;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("ConditionSearchFriendActivity", 2, localThrowable.getMessage());
      }
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
  
  private void bv(int paramInt, boolean paramBoolean)
  {
    Intent localIntent;
    if ((this.mLocationColumCount <= 0) || (this.mLocationColumCount > 3)) {
      if (!"0".equals(this.mLocationCountyCode))
      {
        localIntent = new Intent(this, CountrySelectActivity.class);
        localIntent.putExtra("key_country_code", this.mLocationCountyCode);
        localIntent.putExtra("key_no_limit_allow", true);
        if (paramInt == 1) {
          startActivityForResult(localIntent, 1003);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt != 2);
        startActivityForResult(localIntent, 1004);
        return;
        if (!paramBoolean)
        {
          LS(paramInt);
          initLocationData();
        }
        if (paramInt == 1)
        {
          this.aw.setRightText(this.jdField_b_of_type_Accv.je(ci()));
          LT(1);
          return;
        }
      } while (paramInt != 2);
      this.ax.setRightText(this.jdField_b_of_type_Accv.je(ci()));
      LT(2);
      return;
      if (paramInt == 1)
      {
        if ("不限".equals(this.aw.a().getText())) {
          this.aw.setRightText(this.jdField_b_of_type_Accv.je(ci()));
        }
        LT(1);
        return;
      }
    } while (paramInt != 2);
    if ("不限".equals(this.ax.a().getText())) {
      this.ax.setRightText(this.jdField_b_of_type_Accv.je(ci()));
    }
    LT(2);
  }
  
  private void cWF()
  {
    boolean bool = auvj.isNightMode();
    if (bool)
    {
      i = 2130839682;
      this.Bv.setBackgroundResource(i);
      this.Bw.setBackgroundResource(i);
      this.Bx.setBackgroundResource(i);
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (int i = 2131167380;; i = 2131167309)
    {
      this.Ra.setTextColor(getResources().getColor(i));
      this.Rb.setTextColor(getResources().getColor(i));
      this.Rc.setTextColor(getResources().getColor(i));
      return;
      i = 2130850608;
      break;
    }
  }
  
  private void cWG()
  {
    this.mLocationIndexArray = null;
    this.mLocationArray = null;
    this.mLocationListArray = null;
    this.mLocationColumCount = 0;
    this.mLocationCodeArray = new String[] { "0", "0", "0" };
  }
  
  private void cWH()
  {
    if (this.cMt == 0)
    {
      this.Bx.setSelected(true);
      this.Bv.setSelected(false);
      this.Bw.setSelected(false);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack)
      {
        this.Bx.setContentDescription(acfp.m(2131704271));
        this.Bw.setContentDescription(acfp.m(2131704263));
        this.Bv.setContentDescription(acfp.m(2131704268));
      }
      return;
      if (this.cMt == 1)
      {
        this.Bx.setSelected(false);
        this.Bv.setSelected(false);
        this.Bw.setSelected(true);
      }
      else if (this.cMt == 2)
      {
        this.Bx.setSelected(false);
        this.Bv.setSelected(true);
        this.Bw.setSelected(false);
      }
    }
  }
  
  private String ci()
  {
    Object localObject = new StringBuilder();
    if ((!"0".equals(this.mLocationCountyCode)) && (this.mLocationCountry != null))
    {
      ((StringBuilder)localObject).append(this.mLocationCountry.name).append("-");
      int i = 0;
      while (i < this.mLocationColumCount)
      {
        if ((this.mLocationArray != null) && (this.mLocationArray[i] != null) && (!"0".equals(this.mLocationArray[i].code))) {
          ((StringBuilder)localObject).append(this.mLocationArray[i].name).append("-");
        }
        i += 1;
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "不限";
    }
    return ((String)localObject).substring(0, ((String)localObject).length() - 1);
  }
  
  private int gY(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    if (paramInt > 0) {
      return paramInt + 17;
    }
    return 0;
  }
  
  private int gZ(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 17)) {}
    while (paramInt <= 17) {
      return 0;
    }
    return paramInt - 17;
  }
  
  private void init()
  {
    this.bTB = getIntent().getBooleanExtra("key_first_req_location", false);
    this.jdField_b_of_type_Accv = ((accv)this.app.getManager(59));
    this.cMt = this.jdField_b_of_type_Accv.Am();
    Object localObject = this.jdField_b_of_type_Accv.N();
    this.mAgeSelectIndex1 = localObject[0];
    this.mAgeSelectIndex2 = localObject[1];
    this.mCurAgeIndex1 = gZ(localObject[0]);
    this.mCurAgeIndex2 = gZ(localObject[1]);
    this.cMu = this.jdField_b_of_type_Accv.Al();
    this.cMv = this.jdField_b_of_type_Accv.Ak();
    if ((this.cMv == accv.kh[0]) || (this.cMv == accv.kh[1]))
    {
      this.cMv = 0;
      this.jdField_b_of_type_Accv.IL(this.cMv);
    }
    this.bb = ((EditText)findViewById(2131366535));
    this.bb.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
    localObject = getResources().getDrawable(2130851338);
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    this.bb.setCompoundDrawables((Drawable)localObject, null, null, null);
    this.bb.addTextChangedListener(new aefk(this));
    this.av = ((FormSimpleItem)findViewById(2131365196));
    this.aw = ((FormSimpleItem)findViewById(2131365199));
    this.ax = ((FormSimpleItem)findViewById(2131365197));
    this.ay = ((FormSimpleItem)findViewById(2131365198));
    this.az = ((FormSimpleItem)findViewById(2131365200));
    this.fQ = ((Button)findViewById(2131365402));
    this.Bv = findViewById(2131367944);
    this.Bw = findViewById(2131367946);
    this.Bx = findViewById(2131367942);
    this.Ra = ((TextView)findViewById(2131367011));
    this.Rb = ((TextView)findViewById(2131371110));
    this.Rc = ((TextView)findViewById(2131363590));
    cWF();
    this.Bv.setOnClickListener(this);
    this.Bw.setOnClickListener(this);
    this.Bx.setOnClickListener(this);
    this.av.setLeftIcon(null);
    this.av.setLeftText(getResources().getString(2131691955));
    localObject = this.jdField_b_of_type_Accv.B(this.mAgeSelectIndex1, this.mAgeSelectIndex2);
    this.av.setRightText((CharSequence)localObject);
    if (AppSetting.enableTalkBack) {
      this.av.setContentDescription(acfp.m(2131704273) + (String)localObject);
    }
    this.av.setOnClickListener(this);
    this.ay.setVisibility(0);
    this.ay.setLeftIcon(null);
    this.ay.setLeftText(getResources().getString(2131691958));
    this.ay.setRightText(accv.dU[this.cMv]);
    if (AppSetting.enableTalkBack) {
      this.ay.setContentDescription(acfp.m(2131704264) + accv.dU[this.cMv]);
    }
    this.ay.setOnClickListener(this);
    this.aw.setLeftIcon(null);
    this.aw.setLeftText(getResources().getString(2131691959));
    localObject = this.jdField_b_of_type_Accv.dw(0);
    this.aw.setRightText(this.jdField_b_of_type_Accv.je((String)localObject));
    if (AppSetting.enableTalkBack) {
      this.aw.setContentDescription(acfp.m(2131704256) + (String)localObject);
    }
    this.aw.setOnClickListener(this);
    this.ax.setLeftIcon(null);
    this.ax.setLeftText(getResources().getString(2131691957));
    String str = this.jdField_b_of_type_Accv.dw(1);
    this.ax.setRightText(this.jdField_b_of_type_Accv.je(str));
    if (AppSetting.enableTalkBack) {
      this.ax.setContentDescription(acfp.m(2131704270) + str);
    }
    this.ax.setOnClickListener(this);
    this.az.setLeftIcon(null);
    this.az.setLeftText(getResources().getString(2131691962));
    this.az.setRightText(accv.dT[this.cMu]);
    if (AppSetting.enableTalkBack) {
      this.az.setContentDescription(acfp.m(2131704259) + accv.dT[this.cMu]);
    }
    this.az.setOnClickListener(this);
    this.fQ.setOnClickListener(this);
    if (AppSetting.enableTalkBack) {
      this.fQ.setContentDescription(getString(2131692131));
    }
    cWH();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "init|mIsFirstReqLocation : " + this.bTB + ", locDesc : " + (String)localObject);
    }
    if ((this.bTB) || ("不限".equals(localObject))) {
      addObserver(this.jdField_a_of_type_Acgs);
    }
  }
  
  private void initLocationData()
  {
    this.mLocationCountry = this.jdField_b_of_type_Accv.a(this.mLocationCountyCode);
    if (this.mLocationCountry != null)
    {
      this.mLocationColumCount = this.mLocationCountry.getColumnNember();
      this.mLocationListArray = new Object[this.mLocationColumCount];
      this.mLocationArray = new BaseAddress[this.mLocationColumCount];
      this.mLocationIndexArray = new int[this.mLocationColumCount];
      if (this.mLocationColumCount != 0) {}
    }
    int j;
    int i;
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = this.mLocationCountry;
      int k = this.mLocationCodeArray.length;
      j = 0;
      i = 0;
      while (j < k) {
        if ("0".equals(this.mLocationCodeArray[j])) {
          j += 1;
        } else {
          if (i < this.mLocationListArray.length) {
            break label234;
          }
        }
      }
      if (i < this.mLocationColumCount)
      {
        this.mLocationListArray[i] = ((BaseAddress)localObject1).getDataList();
        this.mLocationArray[i] = ((BaseAddress)((BaseAddress)localObject1).dataMap.get(Integer.valueOf(0)));
        this.mLocationIndexArray[i] = 0;
      }
    }
    Object localObject2 = new StringBuilder().append("initLocationData|mLocationColumCount : ").append(this.mLocationColumCount).append(", mLocationCountry.name : ");
    if (this.mLocationCountry == null) {}
    for (Object localObject1 = "null";; localObject1 = this.mLocationCountry.name)
    {
      QLog.d("ConditionSearchFriendActivity", 2, (String)localObject1);
      return;
      label234:
      this.mLocationListArray[i] = ((BaseAddress)localObject1).getDataList();
      BaseAddress[] arrayOfBaseAddress = this.mLocationArray;
      localObject2 = (BaseAddress)((BaseAddress)localObject1).dataMap.get(this.mLocationCodeArray[j]);
      arrayOfBaseAddress[i] = localObject2;
      this.mLocationIndexArray[i] = b((ArrayList)this.mLocationListArray[i], this.mLocationCodeArray[j]);
      i += 1;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return;
    }
  }
  
  private int q(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void LU(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i = this.jdField_b_of_type_Accv.Ai();
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|checkUpdate result = " + i);
    }
    if (i != 0)
    {
      i = this.jdField_b_of_type_Accv.q(i, true);
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|update updateResult = " + i);
      }
      if (i == 2)
      {
        QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
        return;
      }
      if (i == 0)
      {
        bg(paramInt, getString(2131691966));
        this.jdField_b_of_type_Accv.addListener(this.jdField_a_of_type_Accv$b);
        return;
      }
      bg(paramInt, getString(2131691966));
      this.mHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "startSelectAddress|type : " + paramInt + ", mNeedInitLocation" + this.bTD + ", mNeedInitHome : " + this.bTC + ", mLocationColumCount : " + this.mLocationColumCount + ", mLocationCountyCode : " + this.mLocationCountyCode);
    }
    if (paramInt == 1)
    {
      if (!this.bTD) {
        break label335;
      }
      LS(1);
      initLocationData();
      this.bTD = false;
      this.bTC = true;
    }
    for (;;)
    {
      bv(paramInt, bool1);
      return;
      if (paramInt != 2) {
        break;
      }
      if (this.bTC)
      {
        LS(2);
        initLocationData();
        this.bTC = false;
        this.bTD = true;
      }
      for (bool1 = bool2;; bool1 = false)
      {
        bv(paramInt, bool1);
        return;
      }
      label335:
      bool1 = false;
    }
  }
  
  public void aqz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog | type = " + this.u);
    }
    if ((this.u != null) && (this.u.isShowing()))
    {
      this.bHl = 0;
      this.u.dismiss();
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearchFriendActivity", 2, "dismissWaittingDialog dismiss");
      }
    }
  }
  
  void bg(int paramInt, String paramString)
  {
    this.bHl = paramInt;
    if (this.u == null) {
      this.u = new arhz(this, getTitleBarHeight());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "showWaitingDialog | type = " + paramInt + ", str = " + paramString + ", dlg=" + this.u);
    }
    this.u.setMessage(paramString);
    this.u.show();
  }
  
  void cWI()
  {
    if (this.bTA)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004241", "0X8004241", 0, 0, "", "", "", "");
      this.bTA = false;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | requestCode = " + paramInt1);
    }
    if (paramIntent == null) {}
    label36:
    label611:
    label624:
    label626:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label36;
              break label36;
              break label36;
              break label36;
              do
              {
                return;
              } while (paramInt2 != -1);
              if (paramInt1 != 1002) {
                break;
              }
              this.cMv = paramIntent.getIntExtra("param_id", 0);
              this.ay.setRightText(accv.dU[this.cMv]);
              this.jdField_b_of_type_Accv.IL(this.cMv);
            } while (!AppSetting.enableTalkBack);
            this.ay.setContentDescription(acfp.m(2131704258) + accv.dU[this.cMv]);
            return;
            paramIntent = paramIntent.getStringExtra("key_country_code");
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, "doOnActivityResult | codes = " + paramIntent);
            }
          } while ((TextUtils.isEmpty(paramIntent)) || (paramIntent.equals(this.mLocationCountyCode)));
          this.mLocationCountyCode = paramIntent;
          this.mLocationCountry = this.jdField_b_of_type_Accv.a(this.mLocationCountyCode);
        } while (this.mLocationCountry == null);
        paramInt2 = this.mLocationCountry.getColumnNember();
        if ((paramInt2 <= 0) || (paramInt2 > 3))
        {
          cWG();
          initLocationData();
          if ((this.jdField_d_of_type_Ausj != null) && (this.jdField_d_of_type_Ausj.isShowing())) {
            this.jdField_d_of_type_Ausj.dismiss();
          }
        }
        for (;;)
        {
          if (paramInt1 != 1003) {
            break label626;
          }
          this.aw.setRightText(this.mLocationCountry.name);
          if (!AppSetting.enableTalkBack) {
            break;
          }
          this.aw.setContentDescription(acfp.m(2131704253) + this.mLocationCountry.name);
          return;
          paramIntent = new String[4];
          paramIntent[0] = this.mLocationCountyCode;
          paramIntent[1] = this.mLocationCodeArray[0];
          paramIntent[2] = this.mLocationCodeArray[1];
          paramIntent[3] = this.mLocationCodeArray[2];
          String str = ci();
          if (paramInt1 == 1003)
          {
            this.jdField_b_of_type_Accv.bZ(0, str);
            this.jdField_b_of_type_Accv.H(paramIntent);
          }
          else if (paramInt1 == 1004)
          {
            this.jdField_b_of_type_Accv.bZ(1, str);
            this.jdField_b_of_type_Accv.I(paramIntent);
            continue;
            cWG();
            initLocationData();
            if ((this.jdField_d_of_type_Ausj != null) && (this.jdField_d_of_type_Ausj.isShowing()))
            {
              if (this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
                this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2131561390, null));
              }
              this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d);
              paramInt2 = 0;
            }
            while (paramInt2 < this.mLocationColumCount)
            {
              this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.LV(paramInt2);
              this.jdField_d_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(paramInt2, 0);
              paramInt2 += 1;
              continue;
              if (paramInt1 != 1003) {
                break label611;
              }
              LT(1);
            }
            for (;;)
            {
              if (this.GO == null) {
                break label624;
              }
              this.GO.setText(this.mLocationCountry.name);
              if (!AppSetting.enableTalkBack) {
                break;
              }
              this.GO.setContentDescription(acfp.m(2131704257) + this.mLocationCountry.name + acfp.m(2131704260));
              break;
              if (paramInt1 == 1004) {
                LT(2);
              }
            }
          }
        }
      } while (paramInt1 != 1004);
      this.ax.setRightText(this.mLocationCountry.name);
    } while (!AppSetting.enableTalkBack);
    this.ax.setContentDescription(acfp.m(2131704272) + this.mLocationCountry.name);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561265);
    this.mRoot = findViewById(2131377546);
    this.By = findViewById(2131369236);
    setContentBackgroundResource(2130838900);
    this.jdField_b_of_type_Accv = ((accv)this.app.getManager(59));
    setTitle(2131691948);
    init();
    return true;
  }
  
  public void doOnDestroy()
  {
    cWI();
    super.doOnDestroy();
    this.mHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_Accv.aW(this);
    this.jdField_b_of_type_Accv.removeListener(this.jdField_a_of_type_Accv$b);
    this.jdField_b_of_type_Accv.removeListener(this.jdField_a_of_type_Accv$d);
    removeObserver(this.jdField_a_of_type_Acgs);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_b_of_type_Accv != null) {
      this.jdField_b_of_type_Accv.aV(this);
    }
  }
  
  public void onClick(View paramView)
  {
    cWI();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.app, "CliOper", "", "", "0X800424B", "0X800424B", 0, 0, "", "", "", "");
      if (!aqiw.isNetSupport(this))
      {
        QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
      }
      else
      {
        this.keyword = this.bb.getText().toString();
        Object localObject = this.jdField_b_of_type_Accv.H();
        String[] arrayOfString = this.jdField_b_of_type_Accv.I();
        this.jdField_b_of_type_Accv.addListener(this.jdField_a_of_type_Accv$d);
        this.jdField_b_of_type_Accv.a(true, this.keyword, this.cMt, this.mAgeSelectIndex1, this.mAgeSelectIndex2, (String[])localObject, arrayOfString, this.cMv, this.cMu, 1);
        bg(3, getString(2131691967));
        continue;
        LT(0);
        continue;
        localObject = new Intent(this, JobSelectionActivity.class);
        ((Intent)localObject).putExtra("param_id", this.cMv);
        ((Intent)localObject).putExtra("param_from_consearch", true);
        ((Intent)localObject).putExtra("param_need_no_limit", true);
        startActivityForResult((Intent)localObject, 1002);
        continue;
        anot.a(this.app, "CliOper", "", "", "0X8004245", "0X8004245", 0, 0, "", "", "", "");
        LU(2);
        continue;
        this.bTB = false;
        this.jdField_b_of_type_Accv.cHY();
        anot.a(this.app, "CliOper", "", "", "0X8004244", "0X8004244", 0, 0, "", "", "", "");
        LU(1);
        continue;
        LT(3);
        continue;
        this.cMt = 2;
        cWH();
        this.jdField_b_of_type_Accv.IN(this.cMt);
        anot.a(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.cMt + "", "", "", "");
        continue;
        this.cMt = 1;
        cWH();
        this.jdField_b_of_type_Accv.IN(this.cMt);
        anot.a(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.cMt + "", "", "", "");
        continue;
        this.cMt = 0;
        cWH();
        this.jdField_b_of_type_Accv.IN(this.cMt);
        anot.a(this.app, "CliOper", "", "", "0X8004242", "0X8004242", 0, 0, this.cMt + "", "", "", "");
        continue;
        localObject = new Intent(this, CountrySelectActivity.class);
        ((Intent)localObject).putExtra("key_country_code", this.mLocationCountyCode);
        ((Intent)localObject).putExtra("key_no_limit_allow", true);
        if (this.pickerType == 1) {
          startActivityForResult((Intent)localObject, 1003);
        } else if (this.pickerType == 2) {
          startActivityForResult((Intent)localObject, 1004);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity
 * JD-Core Version:    0.7.0.1
 */