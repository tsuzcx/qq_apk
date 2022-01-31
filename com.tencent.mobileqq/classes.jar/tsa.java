import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;

public class tsa
  extends tvg
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private View b;
  private View c;
  private View d;
  private View e;
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372529);
    this.b = paramView.findViewById(2131372527);
    this.c = paramView.findViewById(2131372519);
    this.c.setOnClickListener(this);
    this.d = paramView.findViewById(2131372523);
    this.d.setOnClickListener(this);
    tyj.a("", 4, 1L);
    this.e = paramView.findViewById(2131372518);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131372522));
    this.e.setOnClickListener(this);
    if ((a() != null) && ((a() instanceof BaseActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(bcxb.a(((BaseActivity)a()).app, 1, 4, tqg.a()));
    }
  }
  
  public void onClick(View paramView)
  {
    String str = "1";
    if (tym.a().c(3)) {
      str = "2";
    }
    switch (paramView.getId())
    {
    case 2131372520: 
    case 2131372521: 
    default: 
      return;
    case 2131372519: 
      ((BaseActivity)a()).doOnBackPressed();
      tyj.a("", 21, 1L, 0L, str, "", "", "", "");
      return;
    case 2131372523: 
      tqs.a(a(), tqr.b, null);
      tyj.a("", 4, 2L);
      return;
    }
    tyj.a("", 21, 2L, 0L, str, "", "", "", "");
    tqs.a(tqg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsa
 * JD-Core Version:    0.7.0.1
 */