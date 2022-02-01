import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput.3;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput.4;
import com.tencent.mobileqq.widget.ClearableEditText;
import java.lang.ref.SoftReference;
import java.util.Timer;

public class aqky
  extends aqju
{
  private SoftReference<Context> C;
  private long asZ;
  private ClearableEditText l;
  private TextWatcher mTextWatcher;
  
  public aqky(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.C = new SoftReference(paramContext);
  }
  
  private boolean aER()
  {
    if ("VIVO".equalsIgnoreCase(Build.MANUFACTURER))
    {
      if ((!Build.MODEL.toUpperCase().contains("Y8")) && (!Build.MODEL.toUpperCase().contains("V18"))) {}
    }
    else {
      while (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.MODEL.toUpperCase().contains("VOG-AL10"))) {
        return true;
      }
    }
    return false;
  }
  
  public void UO(String paramString)
  {
    if (paramString != null) {
      this.l.setText(paramString);
    }
  }
  
  public void UQ(String paramString)
  {
    if (paramString != null) {
      this.l.setHint(paramString);
    }
  }
  
  public void a(TextWatcher paramTextWatcher)
  {
    if (paramTextWatcher != null)
    {
      this.mTextWatcher = paramTextWatcher;
      this.l.addTextChangedListener(paramTextWatcher);
    }
  }
  
  public EditText b()
  {
    return this.l;
  }
  
  public void eef()
  {
    if (this.mTextWatcher != null) {
      this.l.removeTextChangedListener(this.mTextWatcher);
    }
  }
  
  public void gR()
  {
    Object localObject = (Context)this.C.get();
    if (localObject != null)
    {
      localObject = (InputMethodManager)((Context)localObject).getSystemService("input_method");
      if ((((InputMethodManager)localObject).isActive()) && (getCurrentFocus() != null)) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
      }
    }
  }
  
  public String getInputValue()
  {
    return this.l.getText().toString();
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.l = ((ClearableEditText)findViewById(2131369276));
  }
  
  public aqju setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new aqkz(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void show()
  {
    super.show();
    Editable localEditable = this.l.getText();
    if ((localEditable instanceof Spannable)) {
      Selection.setSelection((Spannable)localEditable, localEditable.length());
    }
    this.asZ = System.currentTimeMillis();
    if ((this.l.isFocusable()) || (this.l.isFocusableInTouchMode())) {
      new Timer().schedule(new QQCustomDialogWtihInput.3(this), 200L);
    }
  }
  
  public void show(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.show();
      Editable localEditable = this.l.getText();
      if ((localEditable instanceof Spannable)) {
        Selection.selectAll((Spannable)localEditable);
      }
      new Timer().schedule(new QQCustomDialogWtihInput.4(this), 200L);
      return;
    }
    show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqky
 * JD-Core Version:    0.7.0.1
 */