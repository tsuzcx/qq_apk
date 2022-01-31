import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;

public class wbz
  extends Dialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public wbz(Context paramContext)
  {
    super(paramContext, 2131755013);
    View localView = LayoutInflater.from(paramContext).inflate(2131561309, null);
    localView.setOnTouchListener(new wca(this));
    super.setContentView(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131362547));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367281));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setRadius(vzo.a(paramContext, 25.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setLoopTime(2000L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(4000L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new wcb(this, paramContext));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setIsVertical(paramBoolean);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.b();
    super.dismiss();
  }
  
  public void show()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.a();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wbz
 * JD-Core Version:    0.7.0.1
 */