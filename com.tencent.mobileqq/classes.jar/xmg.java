import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class xmg
  extends xlt
{
  public ImageView a;
  private xmi jdField_a_of_type_Xmi;
  private zkd jdField_a_of_type_Zkd;
  
  public xmg(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    yqp.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380737));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new xmj(this, null));
    this.jdField_a_of_type_Xmi = new xmi(this, null);
    this.jdField_a_of_type_Zkd = new zkd(a(), this.jdField_a_of_type_Xmi);
    this.jdField_a_of_type_Zkd.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmg
 * JD-Core Version:    0.7.0.1
 */