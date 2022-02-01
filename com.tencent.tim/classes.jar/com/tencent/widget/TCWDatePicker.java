package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import atau.a;
import auvg;
import auvh;
import com.tencent.common.config.AppSetting;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TCWDatePicker
  extends FrameLayout
{
  private Calendar G;
  private Calendar H;
  private Calendar I;
  private Calendar J;
  private a jdField_a_of_type_ComTencentWidgetTCWDatePicker$a;
  private final TCWNumberPicker jdField_a_of_type_ComTencentWidgetTCWNumberPicker;
  private final TCWNumberPicker b;
  private final TCWNumberPicker c;
  private final java.text.DateFormat m = new SimpleDateFormat("MM/dd/yyyy");
  private Locale mCurrentLocale;
  
  public TCWDatePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TCWDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TCWDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setCurrentLocale(Locale.getDefault());
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559208, this, true);
    Object localObject1 = new auvg(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131365621));
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setFormatter(TCWNumberPicker.a);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(100L);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.d)localObject1);
    this.b = ((TCWNumberPicker)findViewById(2131371906));
    this.b.setFormatter(TCWNumberPicker.a);
    Object localObject2 = new DateFormatSymbols();
    this.b.setRange(1, 12, ((DateFormatSymbols)localObject2).getShortMonths());
    this.b.setSpeed(200L);
    this.b.setOnChangeListener((TCWNumberPicker.d)localObject1);
    this.c = ((TCWNumberPicker)findViewById(2131382399));
    this.c.setSpeed(100L);
    this.c.setOnChangeListener((TCWNumberPicker.d)localObject1);
    if (AppSetting.enableTalkBack)
    {
      localObject1 = (TCWNumberPickerButton)this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131369135);
      localObject2 = (TCWNumberPickerButton)this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131365660);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131689766));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131695946));
      localObject1 = (TCWNumberPickerButton)this.b.findViewById(2131369135);
      localObject2 = (TCWNumberPickerButton)this.b.findViewById(2131365660);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131689804));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131695947));
      localObject1 = (TCWNumberPickerButton)this.c.findViewById(2131369135);
      localObject2 = (TCWNumberPickerButton)this.c.findViewById(2131365660);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131689855));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131695948));
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sq);
    paramInt = paramContext.getInt(3, 1900);
    int i = paramContext.getInt(0, 2100);
    paramAttributeSet = paramContext.getString(2);
    localObject1 = paramContext.getString(1);
    this.c.setRange(paramInt, i);
    paramContext.recycle();
    this.H.clear();
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!a(paramAttributeSet, this.H)) {
        this.H.set(paramInt, 0, 1);
      }
      setMinDate(this.H.getTimeInMillis());
      this.H.clear();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label591;
      }
      if (!a((String)localObject1, this.H)) {
        this.H.set(i, 11, 31);
      }
    }
    for (;;)
    {
      setMaxDate(this.H.getTimeInMillis());
      this.G.setTimeInMillis(System.currentTimeMillis());
      a(this.G.get(1), this.G.get(2), this.G.get(5), null);
      exo();
      if (!isEnabled()) {
        setEnabled(false);
      }
      return;
      this.H.set(paramInt, 0, 1);
      break;
      label591:
      this.H.set(i, 11, 31);
    }
  }
  
  private Calendar a(Calendar paramCalendar, Locale paramLocale)
  {
    if (paramCalendar == null) {
      return Calendar.getInstance(paramLocale);
    }
    long l = paramCalendar.getTimeInMillis();
    paramCalendar = Calendar.getInstance(paramLocale);
    paramCalendar.setTimeInMillis(l);
    return paramCalendar;
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      paramCalendar.setTime(this.m.parse(paramString));
      return true;
    }
    catch (ParseException paramString) {}
    return false;
  }
  
  private void bp(int paramInt1, int paramInt2, int paramInt3)
  {
    this.G.set(paramInt1, paramInt2, paramInt3);
    if (this.G.before(this.I)) {
      this.G.setTimeInMillis(this.I.getTimeInMillis());
    }
    while (!this.G.after(this.J)) {
      return;
    }
    this.G.setTimeInMillis(this.J.getTimeInMillis());
  }
  
  private void exo()
  {
    int i = 0;
    char[] arrayOfChar = android.text.format.DateFormat.getDateFormatOrder(getContext());
    if ((arrayOfChar[0] == 'M') && (arrayOfChar[1] == 'd')) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131372858);
    localLinearLayout.removeAllViews();
    int j = arrayOfChar.length;
    label51:
    int k;
    if (i < j)
    {
      k = arrayOfChar[i];
      if (k != 100) {
        break label83;
      }
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker);
    }
    for (;;)
    {
      i += 1;
      break label51;
      break;
      label83:
      if (k == 77) {
        localLinearLayout.addView(this.b);
      } else {
        localLinearLayout.addView(this.c);
      }
    }
  }
  
  private void exp()
  {
    exq();
    this.c.setCurrent(this.G.get(1));
    this.b.setCurrent(this.G.get(2) + 1);
  }
  
  private void exq()
  {
    int i = this.G.getActualMaximum(5);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setRange(1, i);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.G.get(5));
  }
  
  private void exr()
  {
    if (this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$a != null) {
      this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$a.b(this, getYear(), getMonth(), getDayOfMonth());
    }
  }
  
  private void setCurrentLocale(Locale paramLocale)
  {
    if (paramLocale.equals(this.mCurrentLocale)) {
      return;
    }
    this.mCurrentLocale = paramLocale;
    this.H = a(this.H, paramLocale);
    this.I = a(this.I, paramLocale);
    this.J = a(this.J, paramLocale);
    this.G = a(this.G, paramLocale);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, a parama)
  {
    bp(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$a = parama;
    exp();
    exr();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  public int getDayOfMonth()
  {
    return this.G.get(5);
  }
  
  public int getMonth()
  {
    return this.G.get(2);
  }
  
  public int getYear()
  {
    return this.G.get(1);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    bp(SavedState.a(paramParcelable), SavedState.b(paramParcelable), SavedState.c(paramParcelable));
    exp();
    exr();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), null);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
    this.b.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
  }
  
  public void setMaxDate(long paramLong)
  {
    this.H.setTimeInMillis(paramLong);
    if ((this.H.get(1) == this.J.get(1)) && (this.H.get(6) != this.J.get(6))) {
      return;
    }
    this.J.setTimeInMillis(paramLong);
    if (this.G.after(this.J))
    {
      this.G.setTimeInMillis(this.J.getTimeInMillis());
      exr();
    }
    exp();
  }
  
  public void setMinDate(long paramLong)
  {
    this.H.setTimeInMillis(paramLong);
    if ((this.H.get(1) == this.I.get(1)) && (this.H.get(6) != this.I.get(6))) {
      return;
    }
    this.I.setTimeInMillis(paramLong);
    if (this.G.before(this.I))
    {
      this.G.setTimeInMillis(this.I.getTimeInMillis());
      exr();
    }
    exp();
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new auvh();
    private final int DR;
    private final int JE;
    private final int esf;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.DR = paramParcel.readInt();
      this.JE = paramParcel.readInt();
      this.esf = paramParcel.readInt();
    }
    
    private SavedState(Parcelable paramParcelable, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      this.DR = paramInt1;
      this.JE = paramInt2;
      this.esf = paramInt3;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.DR);
      paramParcel.writeInt(this.JE);
      paramParcel.writeInt(this.esf);
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(TCWDatePicker paramTCWDatePicker, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TCWDatePicker
 * JD-Core Version:    0.7.0.1
 */