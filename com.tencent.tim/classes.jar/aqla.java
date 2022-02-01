import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.widget.MyLinearLayout;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.5;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class aqla
  extends aqku
  implements View.OnClickListener
{
  public static final Integer as = Integer.valueOf(1);
  public static final Integer at = Integer.valueOf(2);
  final float AI = 267.0F;
  final float AJ = 45.5F;
  final float AK = 39.0F;
  public SoftReference<Context> C;
  ArrayList<String> CL = new ArrayList();
  ImageView EX;
  public View Ja;
  public EditText U;
  public MyLinearLayout a;
  public boolean brS;
  public boolean cjy = true;
  public WindowManager.LayoutParams f;
  protected View.OnClickListener gc = new aqlc(this);
  Handler mHandler = new Handler();
  public RelativeLayout mRoot;
  boolean mSingleLine = false;
  public WindowManager mWindowManager;
  
  public aqla(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.C = new SoftReference(paramContext);
    getWindow().setSoftInputMode(19);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public void UR(String paramString)
  {
    if (paramString != null)
    {
      this.U.setText(paramString);
      this.U.setSelection(this.U.getText().length());
    }
  }
  
  public void eeg()
  {
    if (this.brS)
    {
      this.mWindowManager.removeView(this.a);
      this.brS = false;
      WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
      localLayoutParams.y = 0;
      getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public void ff(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    this.CL = paramArrayList;
    float f1 = getContext().getResources().getDisplayMetrics().density;
    LinearLayout localLinearLayout = (LinearLayout)this.a.findViewById(2131370530);
    localLinearLayout.removeAllViews();
    int i = 0;
    while (i < paramArrayList.size())
    {
      View localView = View.inflate(getContext(), 2131559168, null);
      localView.setTag(Integer.valueOf(i));
      localView.setClickable(true);
      localView.setOnClickListener(this.gc);
      ((TextView)localView.findViewById(2131370529)).setText((CharSequence)paramArrayList.get(i));
      localLinearLayout.addView(localView, new LinearLayout.LayoutParams(-1, (int)(45.5F * f1)));
      i += 1;
    }
    if (paramArrayList.size() >= 5) {}
    for (this.f = new WindowManager.LayoutParams(-1, (int)(267.0F * f1), 2, 32, -1);; this.f = new WindowManager.LayoutParams(-1, (int)((39.0F + paramArrayList.size() * 45.5F + 2.0F) * f1), 2, 32, -1))
    {
      this.f.gravity = 81;
      return;
    }
  }
  
  void fz(Context paramContext)
  {
    this.a = ((MyLinearLayout)View.inflate(paramContext, 2131559167, null));
    this.a.findViewById(2131370535).setOnClickListener(this);
    this.a.setDispatchKeyEventListener(new aqle(this));
  }
  
  public EditText getEditText()
  {
    return this.U;
  }
  
  public String getInputValue()
  {
    return this.U.getText().toString();
  }
  
  public void hideSoftInputFromWindow()
  {
    if (this.U != null) {
      ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.U.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369287) {
      if (this.a != null)
      {
        if (!this.brS) {
          break label78;
        }
        eeg();
        this.EX.setImageResource(2130848171);
        this.EX.setTag(Integer.valueOf(2130848171));
        this.mHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.5(this), 200L);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label78:
      Object localObject = this.EX.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2130848766))
      {
        aurd.aO(this.U);
        this.EX.setImageResource(2130848171);
        this.EX.setTag(Integer.valueOf(2130848171));
        this.brS = false;
      }
      else
      {
        aurd.hide(this.U);
        this.EX.setImageResource(2130848766);
        this.EX.setTag(Integer.valueOf(2130848766));
        this.mHandler.postDelayed(new QQCustomDialogWtihInputAndChoose.6(this), 200L);
        continue;
        if (paramView.getId() == 2131370535)
        {
          eeg();
        }
        else
        {
          eeg();
          aurd.hide(this.U);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    eeg();
    aurd.hide(this.U);
    super.onTouchEvent(paramMotionEvent);
    return true;
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
    this.EX = ((ImageView)findViewById(2131369287));
    this.EX.setOnClickListener(this);
    findViewById(2131377763).setOnClickListener(this);
    this.U.setSingleLine(this.mSingleLine);
    this.U.setOnTouchListener(new aqlb(this));
    Context localContext = (Context)this.C.get();
    if (localContext == null) {
      return;
    }
    tat.b(localContext, this.U);
    fz(localContext);
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
      this.U.addTextChangedListener(new aqld(this, paramInt));
    }
  }
  
  public aqju setMessage(CharSequence paramCharSequence)
  {
    TextView localTextView = (TextView)findViewById(2131365840);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localTextView.setText(paramCharSequence);
      localTextView.setContentDescription(paramCharSequence);
      localTextView.setVisibility(0);
      return this;
    }
    localTextView.setVisibility(8);
    return this;
  }
  
  public aqju setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131692117));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new aqlf(this, paramOnClickListener));
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
    this.rBtn.setOnClickListener(new aqlg(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.mSingleLine = paramBoolean;
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqla
 * JD-Core Version:    0.7.0.1
 */