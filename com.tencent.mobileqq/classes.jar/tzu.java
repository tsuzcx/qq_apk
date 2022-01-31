import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class tzu
  extends tzh
{
  public ImageView a;
  private tzw jdField_a_of_type_Tzw;
  private vxr jdField_a_of_type_Vxr;
  
  public tzu(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    ved.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379046));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new tzx(this, null));
    this.jdField_a_of_type_Tzw = new tzw(this, null);
    this.jdField_a_of_type_Vxr = new vxr(a(), this.jdField_a_of_type_Tzw);
    this.jdField_a_of_type_Vxr.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzu
 * JD-Core Version:    0.7.0.1
 */