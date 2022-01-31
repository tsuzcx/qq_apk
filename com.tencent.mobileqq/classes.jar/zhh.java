import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class zhh
  extends Dialog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private zhk jdField_a_of_type_Zhk;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public zhh(Context paramContext)
  {
    super(paramContext, 2131755801);
    super.setContentView(2131559086);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377949);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377944);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365222));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365228));
    this.c = ((TextView)super.findViewById(2131377947));
    ((ImageView)super.findViewById(2131377948)).setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
    this.d = ((TextView)super.findViewById(2131377942));
    ((ImageView)super.findViewById(2131377943)).setColorFilter(-909794, PorterDuff.Mode.MULTIPLY);
    this.e = ((TextView)super.findViewById(2131377182));
  }
  
  private void b(boolean paramBoolean)
  {
    int j = 8;
    QLog.i("ShareToQZone", 2, "width:" + this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width);
    Object localObject;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
      i = 8;
      label65:
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (!this.jdField_a_of_type_Boolean) {
        break label131;
      }
      i = 0;
      label86:
      ((View)localObject).setVisibility(i);
      localObject = this.e;
      if (!this.jdField_a_of_type_Boolean) {
        break label137;
      }
    }
    label131:
    label137:
    for (int i = j;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label126:
      i = 0;
      break label65;
      i = 8;
      break label86;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.d != null) {
      this.d.setText(paramInt);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new zhi(this, paramOnClickListener));
  }
  
  public void a(zhk paramzhk)
  {
    this.jdField_a_of_type_Zhk = paramzhk;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    if (this.e != null)
    {
      if (paramInt != 0) {
        this.e.setText(paramInt);
      }
    }
    else {
      return;
    }
    this.e.setText("");
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      b(false);
      return;
    }
    b(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new zhj(this, paramOnClickListener));
  }
  
  public void c(int paramInt)
  {
    if (this.c != null) {
      this.c.setText(paramInt);
    }
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onBackPressed()
  {
    QLog.i("ShareResultDialog", 2, "onBackPressed");
    super.onBackPressed();
    zhk localzhk;
    if (this.jdField_a_of_type_Zhk != null)
    {
      localzhk = this.jdField_a_of_type_Zhk;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      localzhk.a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhh
 * JD-Core Version:    0.7.0.1
 */