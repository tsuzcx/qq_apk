import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class vcs
  extends uyi
{
  vcs(vcp paramvcp, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if (paramView == paramvap.a()) {
      vcp.a(this.jdField_a_of_type_Vcp, paramInt, (StoryVideoItem)vcp.a(this.jdField_a_of_type_Vcp).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramvap.a(2131373320))
      {
        paramView = (StoryCoverView)paramvap.a(2131373319);
        if (this.jdField_a_of_type_Boolean)
        {
          vcp.a(this.jdField_a_of_type_Vcp, paramInt, (StoryVideoItem)vcp.a(this.jdField_a_of_type_Vcp).a().get(paramInt), paramView);
          return;
        }
        vcp.b(this.jdField_a_of_type_Vcp, paramInt, (StoryVideoItem)vcp.a(this.jdField_a_of_type_Vcp).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramvap.a(2131373375)) || (paramView == paramvap.a(2131373322)))
      {
        vcp.a(this.jdField_a_of_type_Vcp, paramInt, (StoryVideoItem)vcp.a(this.jdField_a_of_type_Vcp).a().get(paramInt));
        return;
      }
    } while (paramView != paramvap.a(2131373371));
    this.jdField_a_of_type_Vcp.a(paramvap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */