import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleFuelAnimationEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import java.util.ArrayList;

public class tsf
  extends tvv
  implements View.OnClickListener, yiy
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private View d;
  private View e;
  
  public String a()
  {
    return "QCircleFolderActivityChipPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372554);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372552);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372541);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.d = paramView.findViewById(2131372545);
    this.d.setOnClickListener(this);
    tzv.a("", 4, 1L);
    this.e = paramView.findViewById(2131372540);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131372544));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373187));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373190));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373189));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373188));
    this.e.setOnClickListener(this);
    if ((a() != null) && ((a() instanceof BaseActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setImageDrawable(bdbk.a(((BaseActivity)a()).app, 1, 4, tqg.a()));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFuelAnimationEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    yiw.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    yiw.a().b(this);
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    String str = "1";
    if (tzy.a().c(3)) {
      str = "2";
    }
    switch (paramView.getId())
    {
    case 2131372542: 
    case 2131372543: 
    default: 
      return;
    case 2131372541: 
      ((BaseActivity)a()).doOnBackPressed();
      tzv.a("", 21, 1L, 0L, str, "", "", "", "");
      return;
    case 2131372545: 
      tqs.a(a(), tqr.a, null);
      tzv.a("", 4, 2L);
      return;
    }
    tzv.a("", 21, 2L, 0L, str, "", "", "", "");
    tqs.a(tqg.a());
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFuelAnimationEvent)) {
      tyz.a().a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsf
 * JD-Core Version:    0.7.0.1
 */