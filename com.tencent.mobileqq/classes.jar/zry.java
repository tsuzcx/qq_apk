import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class zry
  extends ReportDialog
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561685);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374578));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374621));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374620));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131374625));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131374626));
    ((RelativeLayout)findViewById(2131374577)).setOnClickListener(new zrz(this));
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label207;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(this.c)) {
        break label277;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label160:
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label335;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new zsc(this));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label207:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_a_of_type_JavaLangString) > zps.a(getContext(), 280.0F)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(3);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      label277:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.c);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        break label160;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new zsa(this));
      break label160;
      label335:
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      } else {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new zsb(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zry
 * JD-Core Version:    0.7.0.1
 */