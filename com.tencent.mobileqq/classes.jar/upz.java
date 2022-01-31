import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class upz
  extends ulp
{
  upz(upw paramupw, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if (paramView == paramunw.a()) {
      upw.a(this.jdField_a_of_type_Upw, paramInt, (StoryVideoItem)upw.a(this.jdField_a_of_type_Upw).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramunw.a(2131307605))
      {
        paramView = (StoryCoverView)paramunw.a(2131307604);
        if (this.jdField_a_of_type_Boolean)
        {
          upw.a(this.jdField_a_of_type_Upw, paramInt, (StoryVideoItem)upw.a(this.jdField_a_of_type_Upw).a().get(paramInt), paramView);
          return;
        }
        upw.b(this.jdField_a_of_type_Upw, paramInt, (StoryVideoItem)upw.a(this.jdField_a_of_type_Upw).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramunw.a(2131307660)) || (paramView == paramunw.a(2131307607)))
      {
        upw.a(this.jdField_a_of_type_Upw, paramInt, (StoryVideoItem)upw.a(this.jdField_a_of_type_Upw).a().get(paramInt));
        return;
      }
    } while (paramView != paramunw.a(2131307656));
    this.jdField_a_of_type_Upw.a(paramunw, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upz
 * JD-Core Version:    0.7.0.1
 */