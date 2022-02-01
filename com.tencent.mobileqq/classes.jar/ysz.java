import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class ysz
  extends yop
{
  ysz(ysw paramysw, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if (paramView == paramyqw.a()) {
      ysw.a(this.jdField_a_of_type_Ysw, paramInt, (StoryVideoItem)ysw.a(this.jdField_a_of_type_Ysw).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramyqw.a(2131374659))
      {
        paramView = (StoryCoverView)paramyqw.a(2131374658);
        if (this.jdField_a_of_type_Boolean)
        {
          ysw.a(this.jdField_a_of_type_Ysw, paramInt, (StoryVideoItem)ysw.a(this.jdField_a_of_type_Ysw).a().get(paramInt), paramView);
          return;
        }
        ysw.b(this.jdField_a_of_type_Ysw, paramInt, (StoryVideoItem)ysw.a(this.jdField_a_of_type_Ysw).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramyqw.a(2131374714)) || (paramView == paramyqw.a(2131374661)))
      {
        ysw.a(this.jdField_a_of_type_Ysw, paramInt, (StoryVideoItem)ysw.a(this.jdField_a_of_type_Ysw).a().get(paramInt));
        return;
      }
    } while (paramView != paramyqw.a(2131374710));
    this.jdField_a_of_type_Ysw.a(paramyqw, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */