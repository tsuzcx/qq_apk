import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class xnm
  extends bbgg
{
  protected EditText a;
  
  protected xnm(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static xnm a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    xnm localxnm = new xnm(paramContext, 2131755791);
    localxnm.setContentView(2131558906);
    localxnm.setTitle(paramString1);
    localxnm.setMessage(paramString2);
    localxnm.a(paramInt1, paramOnClickListener2);
    localxnm.b(paramInt2, paramOnClickListener1);
    localxnm.setCanceledOnTouchOutside(false);
    paramString1 = new EditText(paramContext);
    paramString1.setSingleLine();
    paramString1.setFilters(new InputFilter[] { new InputFilter.LengthFilter(120) });
    paramString1.setBackgroundResource(2130843116);
    paramString1.setPadding(20, 0, 20, 0);
    paramString1.setHeight(actn.a(37.0F, paramContext.getResources()));
    paramString1.setTextSize(1, 14.0F);
    paramString2 = new LinearLayout.LayoutParams(-1, actn.a(37.0F, paramContext.getResources()));
    paramString2.topMargin = actn.a(11.0F, paramContext.getResources());
    paramString1.setLayoutParams(paramString2);
    localxnm.a(paramString1);
    return localxnm;
  }
  
  public xnm a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new xnn(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  protected void a(EditText paramEditText)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.bottomMargin = actn.a(16.0F, getContext().getResources());
    localLayoutParams.topMargin = actn.a(8.0F, getContext().getResources());
    ((RelativeLayout.LayoutParams)this.title.getLayoutParams()).bottomMargin = actn.a(5.0F, getContext().getResources());
    addView(paramEditText);
    this.a = paramEditText;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.text.setText(paramString);
      this.text.setTextSize(1, 16.0F);
      this.text.setGravity(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = actn.a(9.0F, getContext().getResources());
      this.text.setLayoutParams(localLayoutParams);
      this.text.setContentDescription(paramString);
      this.text.setVisibility(0);
      this.text.setTextColor(paramInt);
      ((RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams()).topMargin = 0;
      return;
    }
    this.text.setVisibility(8);
  }
  
  public xnm b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new xno(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public EditText getEditText()
  {
    return this.a;
  }
  
  public String getInputValue()
  {
    return this.a.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     xnm
 * JD-Core Version:    0.7.0.1
 */