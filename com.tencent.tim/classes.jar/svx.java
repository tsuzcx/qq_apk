import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class svx
  extends aqju
{
  protected EditText mEditText;
  
  protected svx(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static svx a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    svx localsvx = new svx(paramContext, 2131756467);
    localsvx.setContentView(2131559151);
    localsvx.setTitle(paramString1);
    localsvx.setMessage(paramString2);
    localsvx.a(paramInt1, paramOnClickListener2);
    localsvx.b(paramInt2, paramOnClickListener1);
    localsvx.setCanceledOnTouchOutside(false);
    paramString1 = new EditText(paramContext);
    paramString1.setSingleLine();
    paramString1.setFilters(new InputFilter[] { new InputFilter.LengthFilter(120) });
    paramString1.setBackgroundResource(2130844532);
    paramString1.setPadding(20, 0, 20, 0);
    paramString1.setHeight(wja.dp2px(37.0F, paramContext.getResources()));
    paramString1.setTextSize(1, 14.0F);
    paramString2 = new LinearLayout.LayoutParams(-1, wja.dp2px(37.0F, paramContext.getResources()));
    paramString2.topMargin = wja.dp2px(11.0F, paramContext.getResources());
    paramString1.setLayoutParams(paramString2);
    localsvx.a(paramString1);
    return localsvx;
  }
  
  public svx a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new svy(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  protected void a(EditText paramEditText)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(16.0F, getContext().getResources());
    localLayoutParams.topMargin = wja.dp2px(8.0F, getContext().getResources());
    ((RelativeLayout.LayoutParams)this.title.getLayoutParams()).bottomMargin = wja.dp2px(5.0F, getContext().getResources());
    addView(paramEditText);
    this.mEditText = paramEditText;
  }
  
  public svx b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new svz(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void bH(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.text.setText(paramString);
      this.text.setTextSize(1, 16.0F);
      this.text.setGravity(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = wja.dp2px(9.0F, getContext().getResources());
      this.text.setLayoutParams(localLayoutParams);
      this.text.setContentDescription(paramString);
      this.text.setVisibility(0);
      this.text.setTextColor(paramInt);
      ((RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams()).topMargin = 0;
      return;
    }
    this.text.setVisibility(8);
  }
  
  public EditText getEditText()
  {
    return this.mEditText;
  }
  
  public String getInputValue()
  {
    return this.mEditText.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svx
 * JD-Core Version:    0.7.0.1
 */