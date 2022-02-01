import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class wrm
  extends wqz
{
  public ImageView a;
  private wro jdField_a_of_type_Wro;
  private you jdField_a_of_type_You;
  
  public wrm(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    xvv.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380640));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new wrp(this, null));
    this.jdField_a_of_type_Wro = new wro(this, null);
    this.jdField_a_of_type_You = new you(a(), this.jdField_a_of_type_Wro);
    this.jdField_a_of_type_You.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrm
 * JD-Core Version:    0.7.0.1
 */