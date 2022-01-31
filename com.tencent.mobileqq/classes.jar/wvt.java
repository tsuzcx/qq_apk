import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import java.util.ArrayList;

class wvt
  extends wrj
{
  wvt(wvq paramwvq, boolean paramBoolean) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if (paramView == paramwtq.a()) {
      wvq.a(this.jdField_a_of_type_Wvq, paramInt, (StoryVideoItem)wvq.a(this.jdField_a_of_type_Wvq).a().get(paramInt), paramView);
    }
    do
    {
      return;
      if (paramView == paramwtq.a(2131373820))
      {
        paramView = (StoryCoverView)paramwtq.a(2131373819);
        if (this.jdField_a_of_type_Boolean)
        {
          wvq.a(this.jdField_a_of_type_Wvq, paramInt, (StoryVideoItem)wvq.a(this.jdField_a_of_type_Wvq).a().get(paramInt), paramView);
          return;
        }
        wvq.b(this.jdField_a_of_type_Wvq, paramInt, (StoryVideoItem)wvq.a(this.jdField_a_of_type_Wvq).a().get(paramInt), paramView);
        return;
      }
      if ((paramView == paramwtq.a(2131373875)) || (paramView == paramwtq.a(2131373822)))
      {
        wvq.a(this.jdField_a_of_type_Wvq, paramInt, (StoryVideoItem)wvq.a(this.jdField_a_of_type_Wvq).a().get(paramInt));
        return;
      }
    } while (paramView != paramwtq.a(2131373871));
    this.jdField_a_of_type_Wvq.a(paramwtq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvt
 * JD-Core Version:    0.7.0.1
 */