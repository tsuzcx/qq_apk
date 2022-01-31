import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class tnb
  extends tmo
{
  public ImageView a;
  private tnd jdField_a_of_type_Tnd;
  private vky jdField_a_of_type_Vky;
  
  public tnb(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    urk.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313205));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new tne(this, null));
    this.jdField_a_of_type_Tnd = new tnd(this, null);
    this.jdField_a_of_type_Vky = new vky(a(), this.jdField_a_of_type_Tnd);
    this.jdField_a_of_type_Vky.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tnb
 * JD-Core Version:    0.7.0.1
 */