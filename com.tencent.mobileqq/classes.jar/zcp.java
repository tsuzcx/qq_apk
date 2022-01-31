import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class zcp
  extends Dialog
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  private TextView c;
  
  public zcp(Context paramContext)
  {
    super(paramContext, 2131755801);
    super.setContentView(2131560257);
    super.getWindow().setWindowAnimations(2131755128);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365220));
    this.b = ((TextView)super.findViewById(2131365226));
    this.c = ((TextView)super.findViewById(2131377893));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131377894));
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (acew.S)
    {
      Resources localResources = getContext().getResources();
      this.b.setContentDescription(localResources.getString(2131690622, new Object[] { localResources.getString(2131719910) }));
    }
    this.b.setOnClickListener(new zcr(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (acew.S)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131690622, new Object[] { str }));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new zcq(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zcp
 * JD-Core Version:    0.7.0.1
 */