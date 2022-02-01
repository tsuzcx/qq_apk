import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class yjf
  extends yev
{
  yjf(yjc paramyjc, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if (paramView == paramyhc.a()) {
      yjc.a(this.jdField_a_of_type_Yjc, paramInt, (StoryVideoItem)yjc.a(this.jdField_a_of_type_Yjc).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramyhc.a(2131374665))
      {
        paramView = (StoryCoverView)paramyhc.a(2131374664);
        if (this.jdField_a_of_type_Boolean)
        {
          yjc.a(this.jdField_a_of_type_Yjc, paramInt, (StoryVideoItem)yjc.a(this.jdField_a_of_type_Yjc).a().get(paramInt), paramView);
          return;
        }
        yjc.b(this.jdField_a_of_type_Yjc, paramInt, (StoryVideoItem)yjc.a(this.jdField_a_of_type_Yjc).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramyhc.a(2131374720)) || (paramView == paramyhc.a(2131374667)))
      {
        yjc.a(this.jdField_a_of_type_Yjc, paramInt, (StoryVideoItem)yjc.a(this.jdField_a_of_type_Yjc).a().get(paramInt));
        return;
      }
    } while (paramView != paramyhc.a(2131374716));
    this.jdField_a_of_type_Yjc.a(paramyhc, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjf
 * JD-Core Version:    0.7.0.1
 */