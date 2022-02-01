import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class xuk
  extends xqa
{
  xuk(xuh paramxuh, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if (paramView == paramxsh.a()) {
      xuh.a(this.jdField_a_of_type_Xuh, paramInt, (StoryVideoItem)xuh.a(this.jdField_a_of_type_Xuh).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramxsh.a(2131374427))
      {
        paramView = (StoryCoverView)paramxsh.a(2131374426);
        if (this.jdField_a_of_type_Boolean)
        {
          xuh.a(this.jdField_a_of_type_Xuh, paramInt, (StoryVideoItem)xuh.a(this.jdField_a_of_type_Xuh).a().get(paramInt), paramView);
          return;
        }
        xuh.b(this.jdField_a_of_type_Xuh, paramInt, (StoryVideoItem)xuh.a(this.jdField_a_of_type_Xuh).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramxsh.a(2131374482)) || (paramView == paramxsh.a(2131374429)))
      {
        xuh.a(this.jdField_a_of_type_Xuh, paramInt, (StoryVideoItem)xuh.a(this.jdField_a_of_type_Xuh).a().get(paramInt));
        return;
      }
    } while (paramView != paramxsh.a(2131374478));
    this.jdField_a_of_type_Xuh.a(paramxsh, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuk
 * JD-Core Version:    0.7.0.1
 */