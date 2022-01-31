import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class tzx
  extends tzk
{
  public ImageView a;
  private tzz jdField_a_of_type_Tzz;
  private vxu jdField_a_of_type_Vxu;
  
  public tzx(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    veg.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379041));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new uaa(this, null));
    this.jdField_a_of_type_Tzz = new tzz(this, null);
    this.jdField_a_of_type_Vxu = new vxu(a(), this.jdField_a_of_type_Tzz);
    this.jdField_a_of_type_Vxu.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tzx
 * JD-Core Version:    0.7.0.1
 */