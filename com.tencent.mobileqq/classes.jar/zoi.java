import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.AnimationPoint;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class zoi
  extends ReportDialog
{
  protected TextView a;
  protected AnimationPoint a;
  
  public zoi(Context paramContext)
  {
    super(paramContext, 2131755016);
    View localView = LayoutInflater.from(paramContext).inflate(2131561751, null);
    localView.setOnTouchListener(new zoj(this));
    super.setContentView(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint = ((AnimationPoint)super.findViewById(2131362676));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131367731));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setRadius(zlx.a(paramContext, 25.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setLoopTime(2000L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setDuration(4000L);
    this.jdField_a_of_type_ComTencentBizQqstoryViewAnimationPoint.setOnAnimationListener(new zok(this, paramContext));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoi
 * JD-Core Version:    0.7.0.1
 */