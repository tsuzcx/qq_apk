import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;

public class xux
  extends Dialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public xux(Context paramContext)
  {
    super(paramContext, 2131755015);
    View localView = LayoutInflater.from(paramContext).inflate(2131561516, null);
    localView.setOnTouchListener(new xuy(this));
    super.setContentView(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131362574));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367422));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setRadius(xsm.a(paramContext, 25.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setLoopTime(2000L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(4000L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new xuz(this, paramContext));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xux
 * JD-Core Version:    0.7.0.1
 */