import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ayph
  extends ReportDialog
  implements TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, TextView.OnEditorActionListener
{
  public static final String cXL = acfp.m(2131707747);
  ayph.a jdField_a_of_type_Ayph$a;
  XEditText jdField_a_of_type_ComTencentWidgetXEditText;
  int brh;
  String cXJ;
  boolean dAj = false;
  private Context mContext;
  ViewGroup mRootView;
  View xQ;
  
  public ayph(@NonNull Context paramContext)
  {
    super(paramContext, 2131755374);
    this.mContext = paramContext;
  }
  
  public void a(aygu paramaygu)
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = riw.getWindowScreenHeight(getContext());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
    this.mRootView = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131559267, null));
    this.mRootView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText = ((XEditText)this.mRootView.findViewById(2131366233));
    this.jdField_a_of_type_ComTencentWidgetXEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditText.addTextChangedListener(this);
    this.xQ = this.mRootView.findViewById(2131366232);
    this.xQ.setOnClickListener(this);
    setOnDismissListener(paramaygu);
    this.brh = wja.dp2px(100.0F, getContext().getResources());
    this.jdField_a_of_type_Ayph$a = paramaygu;
    setContentView(this.mRootView);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = Color.parseColor("#FF212226");
    this.jdField_a_of_type_ComTencentWidgetXEditText.setTextColor(i);
    if (paramEditable != null)
    {
      if (paramEditable.length() == 0) {
        this.xQ.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.xQ.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void dismiss()
  {
    super.dismiss();
    this.dAj = false;
    this.cXJ = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
    this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentWidgetXEditText.setText("");
      aygu.r("clk_kbdelete", this.mContext);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) && (this.jdField_a_of_type_Ayph$a != null))
    {
      aygu.r("clk_kbfinish", this.mContext);
      paramTextView = this.jdField_a_of_type_ComTencentWidgetXEditText.getText().toString();
      if ((TextUtils.isEmpty(paramTextView)) || (!aqjb.WEB_URL.matcher(paramTextView).matches())) {
        break label138;
      }
    }
    label138:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        this.jdField_a_of_type_Ayph$a.adz(paramTextView);
        this.cXJ = null;
        super.dismiss();
        this.dAj = false;
        this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        return true;
      }
      aygu.r("exp_wronglink", this.mContext);
      QQToast.a(getContext(), cXL, 0).show();
      paramInt = Color.parseColor("#ff4222");
      this.jdField_a_of_type_ComTencentWidgetXEditText.setTextColor(paramInt);
      return true;
    }
  }
  
  public void onGlobalLayout()
  {
    int i = this.mRootView.getBottom();
    int j = this.mRootView.getRootView().getBottom();
    ram.d(getClass().getName(), "bottom = " + i + " , rootBottom = " + j + " , mMinKeyboardHeight = " + this.brh);
    if (j - i > this.brh)
    {
      this.dAj = true;
      localObject = new Rect();
      this.xQ.getHitRect((Rect)localObject);
      ((Rect)localObject).top -= rpq.dip2px(getContext(), 5.0F);
      ((Rect)localObject).bottom += rpq.dip2px(getContext(), 5.0F);
      localObject = new TouchDelegate((Rect)localObject, this.xQ);
      ((View)this.xQ.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
    while (!this.dAj)
    {
      Object localObject;
      return;
    }
    dismiss();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void show(String paramString)
  {
    int j = 0;
    int i = 0;
    super.show();
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditText.setText(paramString);
      XEditText localXEditText = this.jdField_a_of_type_ComTencentWidgetXEditText;
      if (paramString == null) {}
      for (;;)
      {
        localXEditText.setSelection(i);
        i = Color.parseColor("#FF212226");
        this.jdField_a_of_type_ComTencentWidgetXEditText.setTextColor(i);
        this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        i = paramString.length();
      }
    }
    this.jdField_a_of_type_ComTencentWidgetXEditText.setText(this.cXJ);
    paramString = this.jdField_a_of_type_ComTencentWidgetXEditText;
    if (this.cXJ == null) {}
    for (i = j;; i = this.cXJ.length())
    {
      paramString.setSelection(i);
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void adz(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayph
 * JD-Core Version:    0.7.0.1
 */