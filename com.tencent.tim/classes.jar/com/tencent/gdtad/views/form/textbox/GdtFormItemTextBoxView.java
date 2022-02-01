package com.tencent.gdtad.views.form.textbox;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormErrorListener;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemData;
import com.tencent.ad.tangram.canvas.views.form.framework.AdFormItemView;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import java.lang.ref.WeakReference;
import tkw;
import tmf;
import tmg;
import tmh;

public class GdtFormItemTextBoxView
  extends AdFormItemView
{
  private EditText editText;
  
  public GdtFormItemTextBoxView(Context paramContext, GdtFormItemTextBoxData paramGdtFormItemTextBoxData, WeakReference<AdFormErrorListener> paramWeakReference)
  {
    super(paramContext, paramGdtFormItemTextBoxData, paramWeakReference);
  }
  
  private TextWatcher a()
  {
    return new tmf(this);
  }
  
  private View.OnFocusChangeListener a()
  {
    return new tmg(this);
  }
  
  private TextView.OnEditorActionListener a()
  {
    return new tmh(this);
  }
  
  private static void q(TextView paramTextView)
  {
    if ((paramTextView == null) || (paramTextView.getContext() == null) || (paramTextView.getContext().getSystemService("input_method") == null) || (!(paramTextView.getContext().getSystemService("input_method") instanceof InputMethodManager)))
    {
      tkw.e("GdtFormItemTextBoxView", "hideSoftInput error");
      return;
    }
    try
    {
      ((InputMethodManager)InputMethodManager.class.cast(paramTextView.getContext().getSystemService("input_method"))).hideSoftInputFromWindow(paramTextView.getWindowToken(), 0);
      return;
    }
    catch (Throwable paramTextView)
    {
      tkw.e("GdtFormItemTextBoxView", "hideSoftInput", paramTextView);
    }
  }
  
  public GdtFormItemTextBoxData a()
  {
    AdFormItemData localAdFormItemData = super.getData();
    if ((localAdFormItemData instanceof GdtFormItemTextBoxData)) {
      return (GdtFormItemTextBoxData)GdtFormItemTextBoxData.class.cast(localAdFormItemData);
    }
    return null;
  }
  
  public View createContentView(Context paramContext)
  {
    if ((a() == null) || (!a().isValid()))
    {
      tkw.e("GdtFormItemTextBoxView", "createContentView error");
      return null;
    }
    this.editText = new EditText(paramContext);
    this.editText.setBackgroundColor(0);
    this.editText.setGravity(16);
    this.editText.setTextColor(a().content.color);
    this.editText.setTextSize(0, a().content.size);
    if (a().placeholder != null)
    {
      this.editText.setHint(a().placeholder.text);
      this.editText.setHintTextColor(a().placeholder.color);
    }
    InputFilter.LengthFilter localLengthFilter;
    if (a().content.lengthMax >= 0)
    {
      localLengthFilter = new InputFilter.LengthFilter(a().content.lengthMax);
      if ((this.editText.getFilters() == null) || (this.editText.getFilters().length <= 0))
      {
        paramContext = new InputFilter[1];
        paramContext[0] = localLengthFilter;
        this.editText.setFilters(paramContext);
      }
    }
    else
    {
      paramContext = this.editText;
      if (a().lines != 1) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setSingleLine(bool);
      this.editText.setMinLines(a().lines);
      this.editText.setMaxLines(a().lines);
      this.editText.addTextChangedListener(a());
      this.editText.setOnFocusChangeListener(a());
      this.editText.setOnEditorActionListener(a());
      return this.editText;
      paramContext = new InputFilter[this.editText.getFilters().length + 1];
      System.arraycopy(this.editText.getFilters(), 0, paramContext, 0, this.editText.getFilters().length);
      paramContext[(paramContext.length - 1)] = localLengthFilter;
      break;
    }
  }
  
  public void reset()
  {
    if (this.editText == null)
    {
      tkw.e("GdtFormItemTextBoxView", "reset error");
      return;
    }
    this.editText.setText(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView
 * JD-Core Version:    0.7.0.1
 */