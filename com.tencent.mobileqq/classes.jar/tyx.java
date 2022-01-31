import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;

public class tyx
  extends tvv
  implements View.OnClickListener
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private tys jdField_a_of_type_Tys;
  
  public tyx(tys paramtys)
  {
    this.jdField_a_of_type_Tys = paramtys;
  }
  
  public String a()
  {
    return "QCirclePublicTitleBarPart";
  }
  
  protected void a(View paramView)
  {
    TextView localTextView;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366460));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368709));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379043));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if (this.jdField_a_of_type_Tys != null)
      {
        localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Tys.getTitle())) {
          break label109;
        }
      }
    }
    label109:
    for (paramView = this.jdField_a_of_type_Tys.getTitle();; paramView = "")
    {
      localTextView.setText(paramView);
      this.jdField_a_of_type_Tys.initTitleBar(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if ((!a().onBackEvent()) && (a() != null)) {
        a().finish();
      }
    } while ((!yxv.a("QCirclePublicTitleBarPart")) || (this.jdField_a_of_type_Tys == null));
    this.jdField_a_of_type_Tys.onDoubleClickTitle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyx
 * JD-Core Version:    0.7.0.1
 */