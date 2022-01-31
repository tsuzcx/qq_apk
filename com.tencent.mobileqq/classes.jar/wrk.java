import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class wrk
  extends wna
{
  wrk(wrh paramwrh, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if (paramView == paramwph.a()) {
      wrh.a(this.jdField_a_of_type_Wrh, paramInt, (StoryVideoItem)wrh.a(this.jdField_a_of_type_Wrh).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramwph.a(2131373769))
      {
        paramView = (StoryCoverView)paramwph.a(2131373768);
        if (this.jdField_a_of_type_Boolean)
        {
          wrh.a(this.jdField_a_of_type_Wrh, paramInt, (StoryVideoItem)wrh.a(this.jdField_a_of_type_Wrh).a().get(paramInt), paramView);
          return;
        }
        wrh.b(this.jdField_a_of_type_Wrh, paramInt, (StoryVideoItem)wrh.a(this.jdField_a_of_type_Wrh).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramwph.a(2131373824)) || (paramView == paramwph.a(2131373771)))
      {
        wrh.a(this.jdField_a_of_type_Wrh, paramInt, (StoryVideoItem)wrh.a(this.jdField_a_of_type_Wrh).a().get(paramInt));
        return;
      }
    } while (paramView != paramwph.a(2131373820));
    this.jdField_a_of_type_Wrh.a(paramwph, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrk
 * JD-Core Version:    0.7.0.1
 */