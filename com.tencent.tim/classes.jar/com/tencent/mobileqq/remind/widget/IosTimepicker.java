package com.tencent.mobileqq.remind.widget;

import alve;
import alvf;
import alvg;
import alvh;
import alvi;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ausj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.VerticalGallery.a;
import com.tencent.widget.VerticalGallery.c;

public class IosTimepicker
  extends LinearLayout
{
  private static String TAG = "remind";
  private View Gm;
  private b jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$b;
  private AdapterView.e jdField_a_of_type_ComTencentWidgetAdapterView$e = new alvg(this);
  private VerticalGallery.a jdField_a_of_type_ComTencentWidgetVerticalGallery$a = new alvi(this);
  private VerticalGallery.c jdField_a_of_type_ComTencentWidgetVerticalGallery$c = new alvh(this);
  private BaseAdapter[] jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private long ahK;
  private long ahL;
  private a b;
  private int ccv;
  private int dyf;
  private String[] gp;
  private String[] gq;
  private Button hb;
  private LinearLayout ke;
  private ausj mActionSheet;
  private Context mContext;
  private int[] mO;
  private TextView my;
  
  public IosTimepicker(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  @TargetApi(11)
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void ae(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(this.ccv);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(this.dyf);
  }
  
  private void dJT()
  {
    if (this.b != null)
    {
      int j = this.mO.length;
      int i = 0;
      while (i < j)
      {
        this.mO[i] = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i].getSelectedItemPosition();
        i += 1;
      }
      this.ahL = this.b.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView, this.mO);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$b.kQ(this.ahL);
    }
  }
  
  public void a(Context paramContext, ausj paramausj, b paramb, View.OnClickListener paramOnClickListener, BaseAdapter[] paramArrayOfBaseAdapter, int[] paramArrayOfInt, a parama)
  {
    if ((paramArrayOfBaseAdapter == null) || (paramArrayOfBaseAdapter.length == 0) || (paramArrayOfBaseAdapter.length > 3)) {
      throw new IllegalArgumentException("adapters is null or empty, or its length is larger than 3");
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("selectionPos is null or empty, or its length is larger than 3");
    }
    if (paramArrayOfInt.length != paramArrayOfBaseAdapter.length) {
      throw new IllegalArgumentException("selectionPos.length is not equal to adapters.length");
    }
    this.mContext = paramContext;
    this.mActionSheet = paramausj;
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$b = paramb;
    this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter = paramArrayOfBaseAdapter;
    this.mO = paramArrayOfInt;
    int k = paramArrayOfBaseAdapter.length;
    int j = paramArrayOfInt.length;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[k];
    this.b = parama;
    int i = 0;
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i] = new WheelView(this.mContext);
      i += 1;
    }
    paramausj = this.mContext.getResources();
    this.ccv = paramausj.getColor(2131167389);
    this.dyf = paramausj.getColor(2131167349);
    this.gp = alve.gp;
    this.gq = alve.gq;
    this.Gm = findViewById(2131369368);
    this.ke = ((LinearLayout)findViewById(2131369367));
    this.my = ((TextView)findViewById(2131377953));
    this.hb = ((Button)findViewById(2131379693));
    i = paramausj.getColor(2131167402);
    findViewById(2131369366).setBackgroundColor(i);
    findViewById(2131369365).setBackgroundColor(i);
    this.Gm.setBackgroundColor(paramausj.getColor(2131167354));
    i = paramausj.getColor(2131167401);
    findViewById(2131370492).setBackgroundColor(i);
    findViewById(2131370470).setBackgroundColor(i);
    if (paramOnClickListener != null)
    {
      this.hb.setOnClickListener(paramOnClickListener);
      if (k != 1) {
        break label514;
      }
      paramContext = new LinearLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[0].setLayoutParams(paramContext);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[0].setAdapter(this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter[0]);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "createTimePicker Time :" + alve.bD(this.ahK));
      }
    }
    for (;;)
    {
      i = 0;
      while (i < j)
      {
        paramContext = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        this.ke.addView(paramContext);
        paramContext.setAdapter(this.jdField_a_of_type_ArrayOfAndroidWidgetBaseAdapter[i]);
        paramContext.setSelection(this.mO[i], true);
        paramContext.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$e);
        paramContext.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$c);
        paramContext.setOnEndFlingListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$a);
        i += 1;
      }
      this.hb.setOnClickListener(new alvf(this));
      break;
      label514:
      i = 0;
      if (i < k)
      {
        paramb = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[i];
        if (i == 0) {}
        for (paramContext = new LinearLayout.LayoutParams(paramausj.getDimensionPixelSize(2131299618), -1);; paramContext = new LinearLayout.LayoutParams(paramausj.getDimensionPixelSize(2131299620), -1))
        {
          paramContext.setMargins(0, paramausj.getDimensionPixelSize(2131299623), 0, paramausj.getDimensionPixelSize(2131299621));
          paramb.setLayoutParams(paramContext);
          if (i != 0)
          {
            paramb.setScrollCycle(true);
            paramb.setmMaxRotationAngle(80);
            paramb.setmMaxSkew(0.1F);
            paramb.setNeedTranslate(true);
          }
          i += 1;
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "createTimePicker Time :" + alve.bD(this.ahK));
      }
    }
    dJT();
  }
  
  public long gG()
  {
    return this.ahL;
  }
  
  public void setFormatDataListener(a parama)
  {
    this.b = parama;
  }
  
  public void setMaxDays(int paramInt)
  {
    alve.dye = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setMaxDays days = " + alve.dye);
    }
  }
  
  public void setOnTimePickerSelectListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$b = paramb;
  }
  
  public void setTips(String paramString)
  {
    if (this.my != null) {
      this.my.setText(paramString);
    }
  }
  
  public static abstract interface a
  {
    public abstract long a(WheelView[] paramArrayOfWheelView, int[] paramArrayOfInt);
  }
  
  public static abstract interface b
  {
    public abstract void kQ(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */