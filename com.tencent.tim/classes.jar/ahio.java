import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog.7;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog.8;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MaxHeightRelativelayout;
import java.lang.ref.SoftReference;

public class ahio
  extends aqku
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private TextView Tn;
  aqmn.a jdField_a_of_type_Aqmn$a = new ahip(this);
  private aqmn jdField_a_of_type_Aqmn;
  private EmoticonMainPanel jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private MaxHeightRelativelayout jdField_b_of_type_ComTencentWidgetMaxHeightRelativelayout;
  private EditText bh;
  private boolean brS;
  private int cdX = 7;
  private WindowManager.LayoutParams f;
  private LinearLayout iW;
  protected ScrollView k;
  private int keyboardHeight;
  private Handler mHandler = new Handler();
  private Resources mResources;
  private View mRootView;
  private WindowManager mWindowManager;
  private SoftReference<Context> s;
  private ImageView zR;
  
  public ahio(@NonNull Context paramContext)
  {
    super(paramContext, 2131756467);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.s = new SoftReference(paramContext);
    this.mResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.f = new WindowManager.LayoutParams(-1, aqmn.ki(0), 2, 32, -1);
    this.f.gravity = 81;
    this.f.windowAnimations = 2131755378;
    setContentView(2131559146);
  }
  
  private void dom()
  {
    ViewGroup.LayoutParams localLayoutParams = this.mRootView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.mRootView.requestLayout();
    }
  }
  
  private void eq(Context paramContext)
  {
    Object localObject = new ahiv(this);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299627);
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(getContext(), 2131559281, null));
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack((afmf)localObject);
      localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
      if (this.cdX == 7) {}
      for (boolean bool = true;; bool = false)
      {
        ((EmoticonMainPanel)localObject).bYY = bool;
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)paramContext, 100003, getContext(), i, null, null, false);
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.daq();
        this.f.height = this.keyboardHeight;
        return;
      }
    }
    QLog.e("Forward.NewVersion.Dialog", 1, "get QQAppInterface fail");
  }
  
  private int q(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  public void Ke(String paramString)
  {
    if (paramString != null) {
      this.Tn.setText(paramString);
    }
  }
  
  public void Kr(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.iW.setVisibility(8);
      return;
    }
    this.iW.setVisibility(0);
  }
  
  public void Pf(int paramInt)
  {
    this.jdField_b_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(wja.dp2px(paramInt, getContext().getResources()));
  }
  
  public ahio a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setContentDescription(paramString + getContext().getString(2131692117));
    this.lBtn.setOnClickListener(new ahiw(this, paramOnClickListener));
    return this;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    this.title.setText(paramString1);
    this.bh.setHint(paramString2);
    a(paramString3, paramOnClickListener2);
    b(paramString4, paramOnClickListener1);
  }
  
  public void addContentView(View paramView)
  {
    this.jdField_b_of_type_ComTencentWidgetMaxHeightRelativelayout.addView(paramView);
  }
  
  public ahio b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setContentDescription(paramString + getContext().getString(2131692117));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new ahiq(this, paramOnClickListener));
    return this;
  }
  
  public EditText getEditText()
  {
    return this.bh;
  }
  
  public String getInputValue()
  {
    return this.bh.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.bh != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.bh.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131366307) {
      if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        if (!this.brS) {
          break label117;
        }
        dom();
        this.mWindowManager.removeView(this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
        this.brS = false;
        this.zR.setImageResource(2130838215);
        this.zR.setTag(Integer.valueOf(2130838215));
        this.mHandler.postDelayed(new ForwardNewVersionDialog.7(this), 200L);
        localObject = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label117:
      localObject = this.zR.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130840507))
      {
        aurd.aO(this.bh);
        this.zR.setImageResource(2130838215);
        this.zR.setTag(Integer.valueOf(2130838215));
        this.brS = false;
      }
      else
      {
        aurd.hide(this.bh);
        this.zR.setImageResource(2130840507);
        this.zR.setTag(Integer.valueOf(2130840507));
        this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setMinimumHeight(aqmn.ki(0));
        this.mHandler.postDelayed(new ForwardNewVersionDialog.8(this), 200L);
        continue;
        if (this.brS)
        {
          dom();
          this.mWindowManager.removeView(this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
          this.brS = false;
          localObject = getWindow().getAttributes();
          ((WindowManager.LayoutParams)localObject).y = 0;
          getWindow().setAttributes((WindowManager.LayoutParams)localObject);
        }
        aurd.hide(this.bh);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
    if (this.jdField_a_of_type_Aqmn != null) {
      this.jdField_a_of_type_Aqmn.destroy();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.brS)
    {
      this.mWindowManager.removeView(this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
      this.brS = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      dom();
    }
    aurd.hide(this.bh);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.jdField_b_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131377408));
    this.Tn = ((TextView)findViewById(2131381161));
    this.bh = ((EditText)findViewById(2131369276));
    this.zR = ((ImageView)findViewById(2131366307));
    this.iW = ((LinearLayout)findViewById(2131369288));
    this.mRootView = findViewById(2131365859);
    this.zR.setOnClickListener(this);
    this.bh.setEditableFactory(aofr.a(16));
    this.bh.setSingleLine(false);
    this.bh.setMaxLines(2);
    setMaxLength(this.mResources.getInteger(2131427345));
    this.bh.setOnTouchListener(new ahir(this));
    Object localObject = (Context)this.s.get();
    if (localObject == null) {
      return;
    }
    tat.b((Context)localObject, this.bh);
    this.jdField_a_of_type_Aqmn = new aqmn(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.mWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Aqmn$a);
    this.keyboardHeight = this.jdField_a_of_type_Aqmn.Mg();
    this.keyboardHeight = aqmn.ki(this.keyboardHeight);
    setOnDismissListener(this);
    eq((Context)localObject);
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new ahis(this));
    localObject = this.mRootView.findViewById(2131377753);
    if ((localObject instanceof ScrollView)) {
      this.k = ((ScrollView)localObject);
    }
    this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ahit(this));
  }
  
  public void setMaxLength(int paramInt)
  {
    if (this.bh != null)
    {
      this.bh.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.bh.addTextChangedListener(new ahiu(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahio
 * JD-Core Version:    0.7.0.1
 */