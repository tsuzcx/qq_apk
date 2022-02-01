import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.8;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import mqq.app.AppRuntime;

public class aqkk
  extends aqku
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  public SoftReference<Context> C;
  public EditText U;
  aqmn.a jdField_a_of_type_Aqmn$a = new aqkl(this);
  private aqmn jdField_a_of_type_Aqmn;
  EmoticonMainPanel b = null;
  public boolean brS;
  SystemEmoticonPanel c = null;
  public boolean cUt = true;
  int cdX = 1;
  public WindowManager.LayoutParams f;
  protected ScrollView k;
  private int keyboardHeight;
  Handler mHandler = new Handler();
  Resources mResources = null;
  public RelativeLayout mRoot;
  boolean mSingleLine = false;
  public WindowManager mWindowManager;
  ImageView zR = null;
  
  public aqkk(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams != null) {
      localLayoutParams.gravity = 17;
    }
    this.C = new SoftReference(paramContext);
    this.mResources = paramContext.getResources();
    getWindow().setSoftInputMode(19);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      bool = true;
      this.cUt = bool;
      if (!this.cUt) {
        break label194;
      }
    }
    label194:
    for (paramInt = aqmn.ki(0);; paramInt = (int)(150.0F * this.mResources.getDisplayMetrics().density))
    {
      this.f = new WindowManager.LayoutParams(-1, paramInt, 2, 32, -1);
      this.f.gravity = 81;
      this.f.windowAnimations = 2131755378;
      return;
      bool = false;
      break;
    }
  }
  
  private void dom()
  {
    ViewGroup.LayoutParams localLayoutParams = this.mRoot.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = -2;
      this.mRoot.requestLayout();
    }
  }
  
  public void UO(String paramString)
  {
    if (paramString != null) {
      this.U.setText(paramString);
    }
  }
  
  public void Xz(int paramInt)
  {
    this.cdX = paramInt;
  }
  
  public void eed()
  {
    if (this.U != null) {
      this.U.setEditableFactory(aofw.a);
    }
  }
  
  void eq(Context paramContext)
  {
    aqkt localaqkt = new aqkt(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299627);
      this.b = ((EmoticonMainPanel)View.inflate(getContext(), 2131559281, null));
      this.b.setCallBack(localaqkt);
      paramContext = this.b;
      if (this.cdX == 7) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext.bYY = bool;
        this.b.a((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
        this.b.daq();
        this.f.height = this.keyboardHeight;
        return;
      }
    }
    QLog.e("QQCustomDialogWtihEmoticonInput", 1, "get QQAppInterface fail");
    if (this.cdX == 7)
    {
      this.c = new SystemAndEmojiEmoticonPanel(paramContext, localaqkt);
      return;
    }
    this.c = new SystemEmoticonPanel(paramContext, localaqkt);
  }
  
  public String getEditString()
  {
    Object localObject;
    if (this.U == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = this.U.getText().toString();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return this.U.getHint().toString();
  }
  
  public EditText getEditText()
  {
    return this.U;
  }
  
  public String getInputValue()
  {
    return this.U.getText().toString();
  }
  
  public String gi()
  {
    if (this.U == null) {
      return "";
    }
    Object localObject;
    if ((this.U.getText() instanceof aofw))
    {
      localObject = (aofw)this.U.getText();
      if (localObject != null) {
        return ((aofw)localObject).AE();
      }
    }
    else if ((this.U.getText() instanceof aofr))
    {
      localObject = (aofr)this.U.getText();
      if (localObject != null) {
        return ((aofr)localObject).AE();
      }
    }
    return this.U.getEditableText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.U != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.U.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (this.cUt)
    {
      localObject1 = this.b;
      if (paramView.getId() != 2131366307) {
        break label269;
      }
      if (localObject1 != null)
      {
        if (!this.brS) {
          break label131;
        }
        dom();
        this.mWindowManager.removeView((View)localObject1);
        this.brS = false;
        this.zR.setImageResource(2130838215);
        this.zR.setTag(Integer.valueOf(2130838215));
        this.mHandler.postDelayed(new QQCustomDialogWtihEmoticonInput.8(this), 200L);
        localObject1 = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject1).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = this.c;
      break;
      label131:
      Object localObject2 = this.zR.getTag();
      if ((localObject2 != null) && ((localObject2 instanceof Integer)) && (((Integer)localObject2).intValue() == 2130840507))
      {
        aurd.aO(this.U);
        this.zR.setImageResource(2130838215);
        this.zR.setTag(Integer.valueOf(2130838215));
        this.brS = false;
      }
      else
      {
        aurd.hide(this.U);
        this.zR.setImageResource(2130840507);
        this.zR.setTag(Integer.valueOf(2130840507));
        if (this.cUt) {
          ((View)localObject1).setMinimumHeight(aqmn.ki(0));
        }
        this.mHandler.postDelayed(new QQCustomDialogWtihEmoticonInput.9(this, (View)localObject1), 200L);
        continue;
        label269:
        if (this.brS)
        {
          this.mWindowManager.removeView((View)localObject1);
          this.brS = false;
          dom();
        }
        localObject1 = getWindow().getAttributes();
        ((WindowManager.LayoutParams)localObject1).y = 0;
        getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
        aurd.hide(this.U);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.b != null) {
      this.b.onDestory();
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
      if (!this.cUt) {
        break label86;
      }
      this.mWindowManager.removeView(this.b);
    }
    for (;;)
    {
      this.brS = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
      dom();
      aurd.hide(this.U);
      super.onTouchEvent(paramMotionEvent);
      return true;
      label86:
      this.mWindowManager.removeView(this.c);
    }
  }
  
  public int q(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  @TargetApi(11)
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.mRoot = ((RelativeLayout)findViewById(2131365859));
    this.U = ((EditText)findViewById(2131369276));
    this.zR = ((ImageView)findViewById(2131366307));
    this.zR.setOnClickListener(this);
    findViewById(2131377763).setOnClickListener(this);
    this.U.setEditableFactory(aofr.c);
    this.U.setSingleLine(this.mSingleLine);
    this.U.setOnTouchListener(new aqko(this));
    Object localObject = (Context)this.C.get();
    if (localObject == null) {
      return;
    }
    tat.b((Context)localObject, this.U);
    if (this.cUt)
    {
      this.jdField_a_of_type_Aqmn = new aqmn(((ViewGroup)getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.mWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Aqmn$a);
      this.keyboardHeight = this.jdField_a_of_type_Aqmn.Mg();
      this.keyboardHeight = aqmn.ki(this.keyboardHeight);
      setOnDismissListener(this);
      eq((Context)localObject);
      this.b.setDispatchKeyEventListener(new aqkp(this));
    }
    for (;;)
    {
      localObject = this.mRoot.findViewById(2131377753);
      if ((localObject instanceof ScrollView)) {
        this.k = ((ScrollView)localObject);
      }
      this.mRoot.getViewTreeObserver().addOnGlobalLayoutListener(new aqkr(this));
      return;
      eq((Context)localObject);
      this.c.setBackgroundResource(2130838096);
      this.c.setMinimumHeight(wja.dp2px(150.0F, this.mResources));
      this.c.setDispatchKeyEventListener(new aqkq(this));
    }
  }
  
  public void setEditLint(String paramString)
  {
    this.U.setHint(paramString);
  }
  
  public void setMaxLength(int paramInt)
  {
    if (this.U != null)
    {
      this.U.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
      this.U.addTextChangedListener(new aqks(this, paramInt));
    }
  }
  
  public aqju setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    hideSoftInputFromWindow();
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131692117));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new aqkm(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqju setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new aqkn(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public aqju setPreviewImage(Drawable paramDrawable, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    Object localObject;
    if (paramDrawable.getIntrinsicHeight() > i)
    {
      localObject = ((URLDrawable)paramDrawable).getCurrDrawable();
      if ((localObject instanceof RegionDrawable))
      {
        localObject = ((RegionDrawable)localObject).getBitmap();
        if (localObject != null)
        {
          Matrix localMatrix = new Matrix();
          localMatrix.postScale(0.5F, 0.5F);
          localObject = Bitmap.createBitmap((Bitmap)localObject, 0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), localMatrix, true);
          if (localObject != null)
          {
            localObject = new BitmapDrawable(this.mResources, (Bitmap)localObject);
            ((BitmapDrawable)localObject).setBounds(0, 0, ((BitmapDrawable)localObject).getIntrinsicWidth(), ((BitmapDrawable)localObject).getIntrinsicHeight());
          }
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        return super.setPreviewImage(paramDrawable, paramBoolean1, paramInt, paramBoolean2);
      }
      return super.setPreviewImage((Drawable)localObject, paramBoolean1, paramInt, paramBoolean2);
      localObject = null;
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.mSingleLine = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqkk
 * JD-Core Version:    0.7.0.1
 */