import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;

public class xqb
  extends xpo
{
  public ImageView a;
  private xqd jdField_a_of_type_Xqd;
  private zny jdField_a_of_type_Zny;
  
  public xqb(@NonNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  protected View a(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    yuk.b(this.jdField_a_of_type_JavaLangString, "setVisibility ignore");
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380914));
    ((StoryPlayerGroupHolder)a()).a.setOnTouchListener(new xqe(this, null));
    this.jdField_a_of_type_Xqd = new xqd(this, null);
    this.jdField_a_of_type_Zny = new zny(a(), this.jdField_a_of_type_Xqd);
    this.jdField_a_of_type_Zny.a(50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqb
 * JD-Core Version:    0.7.0.1
 */