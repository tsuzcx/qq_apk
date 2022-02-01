package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import auvi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class TCWNumberPicker
  extends LinearLayout
  implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener
{
  private static final char[] DIGIT_CHARACTERS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  public static final a a;
  private final InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private d jdField_a_of_type_ComTencentWidgetTCWNumberPicker$d;
  private TCWNumberPickerButton jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton;
  private a jdField_b_of_type_ComTencentWidgetTCWNumberPicker$a;
  private TCWNumberPickerButton jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton;
  private final EditText bI;
  private boolean dla;
  private int euJ;
  private int mCurrent;
  private String[] mDisplayedValues;
  private int mEnd;
  private final Handler mHandler;
  private boolean mIncrement;
  private final Runnable mRunnable = new AutoIncDecRunnable(this);
  private long mSpeed = 300L;
  private int mStart;
  
  static
  {
    jdField_a_of_type_ComTencentWidgetTCWNumberPicker$a = new auvi();
  }
  
  public TCWNumberPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TCWNumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TCWNumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559723, this, true);
    this.mHandler = new Handler();
    paramContext = new b(null);
    this.jdField_a_of_type_AndroidTextInputFilter = new c(null);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton = ((TCWNumberPickerButton)findViewById(2131369135));
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setNumberPicker(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton = ((TCWNumberPickerButton)findViewById(2131365660));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setOnLongClickListener(this);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setNumberPicker(this);
    this.bI = ((EditText)findViewById(2131379708));
    this.bI.setOnFocusChangeListener(this);
    this.bI.setFilters(new InputFilter[] { paramContext });
    this.bI.setRawInputType(2);
    if (!isEnabled()) {
      setEnabled(false);
    }
  }
  
  private void abm(int paramInt)
  {
    int i;
    if (paramInt > this.mEnd) {
      i = this.mStart;
    }
    for (;;)
    {
      this.euJ = this.mCurrent;
      this.mCurrent = i;
      notifyChange();
      updateView();
      return;
      i = paramInt;
      if (paramInt < this.mStart) {
        i = this.mEnd;
      }
    }
  }
  
  private void ay(Runnable paramRunnable)
  {
    if (this.mIncrement)
    {
      abm(this.mCurrent + 1);
      this.mHandler.postDelayed(paramRunnable, this.mSpeed);
    }
    while (!this.dla) {
      return;
    }
    abm(this.mCurrent - 1);
    this.mHandler.postDelayed(paramRunnable, this.mSpeed);
  }
  
  private String formatNumber(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$a != null) {
      return this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$a.toString(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  private int getSelectedPos(String paramString)
  {
    if (this.mDisplayedValues == null) {}
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString)
      {
        break label68;
      }
      paramString = paramString;
    }
    i = 0;
    while (i < this.mDisplayedValues.length)
    {
      paramString = paramString.toLowerCase();
      if (this.mDisplayedValues[i].toLowerCase().startsWith(paramString)) {
        return i + this.mStart;
      }
      i += 1;
    }
    label68:
    return this.mStart;
  }
  
  private void iZ(View paramView)
  {
    paramView = String.valueOf(((TextView)paramView).getText());
    if ("".equals(paramView))
    {
      updateView();
      return;
    }
    r(paramView);
  }
  
  private void notifyChange()
  {
    if (this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$d != null) {
      this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$d.a(this, this.euJ, this.mCurrent);
    }
  }
  
  private void r(CharSequence paramCharSequence)
  {
    int i = getSelectedPos(paramCharSequence.toString());
    if ((i >= this.mStart) && (i <= this.mEnd))
    {
      this.euJ = this.mCurrent;
      this.mCurrent = i;
      notifyChange();
    }
    updateView();
  }
  
  private void updateView()
  {
    if (this.mDisplayedValues == null) {
      this.bI.setText(formatNumber(this.mCurrent));
    }
    for (;;)
    {
      this.bI.setSelection(this.bI.getText().length());
      return;
      this.bI.setText(this.mDisplayedValues[(this.mCurrent - this.mStart)]);
    }
  }
  
  public void exs()
  {
    this.mIncrement = false;
  }
  
  public void ext()
  {
    this.dla = false;
  }
  
  public void onClick(View paramView)
  {
    iZ(this.bI);
    if (!this.bI.hasFocus()) {
      this.bI.requestFocus();
    }
    if (2131369135 == paramView.getId()) {
      abm(this.mCurrent + 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (2131365660 == paramView.getId()) {
        abm(this.mCurrent - 1);
      }
    }
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      iZ(paramView);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.bI.clearFocus();
    if (2131369135 == paramView.getId())
    {
      this.mIncrement = true;
      this.mHandler.post(this.mRunnable);
    }
    while (2131365660 != paramView.getId()) {
      return true;
    }
    this.dla = true;
    this.mHandler.post(this.mRunnable);
    return true;
  }
  
  public void setCurrent(int paramInt)
  {
    this.mCurrent = paramInt;
    updateView();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPickerButton.setEnabled(paramBoolean);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPickerButton.setEnabled(paramBoolean);
    this.bI.setEnabled(paramBoolean);
  }
  
  public void setFormatter(a parama)
  {
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker$a = parama;
  }
  
  public void setOnChangeListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker$d = paramd;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
    this.mCurrent = paramInt1;
    updateView();
  }
  
  public void setRange(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.mDisplayedValues = paramArrayOfString;
    this.mStart = paramInt1;
    this.mEnd = paramInt2;
    this.mCurrent = paramInt1;
    updateView();
  }
  
  public void setSpeed(long paramLong)
  {
    this.mSpeed = paramLong;
  }
  
  static final class AutoIncDecRunnable
    implements Runnable
  {
    final WeakReference<TCWNumberPicker> mRef;
    
    public AutoIncDecRunnable(TCWNumberPicker paramTCWNumberPicker)
    {
      this.mRef = new WeakReference(paramTCWNumberPicker);
    }
    
    public void run()
    {
      TCWNumberPicker localTCWNumberPicker = (TCWNumberPicker)this.mRef.get();
      if (localTCWNumberPicker != null) {
        TCWNumberPicker.a(localTCWNumberPicker, this);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract String toString(int paramInt);
  }
  
  class b
    implements InputFilter
  {
    private b() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      int i = 0;
      if (TCWNumberPicker.a(TCWNumberPicker.this) == null)
      {
        paramCharSequence = TCWNumberPicker.a(TCWNumberPicker.this).filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
        return paramCharSequence;
      }
      String str = String.valueOf(paramCharSequence.subSequence(paramInt1, paramInt2));
      paramSpanned = String.valueOf(String.valueOf(paramSpanned.subSequence(0, paramInt3)) + str + paramSpanned.subSequence(paramInt4, paramSpanned.length())).toLowerCase();
      String[] arrayOfString = TCWNumberPicker.a(TCWNumberPicker.this);
      paramInt2 = arrayOfString.length;
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label154;
        }
        paramCharSequence = str;
        if (arrayOfString[paramInt1].toLowerCase().startsWith(paramSpanned)) {
          break;
        }
        paramInt1 += 1;
      }
      label154:
      return "";
    }
  }
  
  class c
    extends NumberKeyListener
  {
    private c() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      CharSequence localCharSequence2 = super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
      CharSequence localCharSequence1 = localCharSequence2;
      if (localCharSequence2 == null) {
        localCharSequence1 = paramCharSequence.subSequence(paramInt1, paramInt2);
      }
      paramCharSequence = String.valueOf(paramSpanned.subSequence(0, paramInt3)) + localCharSequence1 + paramSpanned.subSequence(paramInt4, paramSpanned.length());
      if ("".equals(paramCharSequence)) {
        localCharSequence1 = paramCharSequence;
      }
      while (TCWNumberPicker.a(TCWNumberPicker.this, paramCharSequence) <= TCWNumberPicker.a(TCWNumberPicker.this)) {
        return localCharSequence1;
      }
      return "";
    }
    
    protected char[] getAcceptedChars()
    {
      return TCWNumberPicker.d();
    }
    
    public int getInputType()
    {
      return 2;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(TCWNumberPicker paramTCWNumberPicker, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker
 * JD-Core Version:    0.7.0.1
 */