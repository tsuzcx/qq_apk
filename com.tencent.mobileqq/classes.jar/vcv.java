import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class vcv
  extends uyl
{
  vcv(vcs paramvcs, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if (paramView == paramvas.a()) {
      vcs.a(this.jdField_a_of_type_Vcs, paramInt, (StoryVideoItem)vcs.a(this.jdField_a_of_type_Vcs).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramvas.a(2131373318))
      {
        paramView = (StoryCoverView)paramvas.a(2131373317);
        if (this.jdField_a_of_type_Boolean)
        {
          vcs.a(this.jdField_a_of_type_Vcs, paramInt, (StoryVideoItem)vcs.a(this.jdField_a_of_type_Vcs).a().get(paramInt), paramView);
          return;
        }
        vcs.b(this.jdField_a_of_type_Vcs, paramInt, (StoryVideoItem)vcs.a(this.jdField_a_of_type_Vcs).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramvas.a(2131373373)) || (paramView == paramvas.a(2131373320)))
      {
        vcs.a(this.jdField_a_of_type_Vcs, paramInt, (StoryVideoItem)vcs.a(this.jdField_a_of_type_Vcs).a().get(paramInt));
        return;
      }
    } while (paramView != paramvas.a(2131373369));
    this.jdField_a_of_type_Vcs.a(paramvas, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcv
 * JD-Core Version:    0.7.0.1
 */