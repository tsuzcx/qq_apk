import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class umr
  extends umg
{
  public TextView a;
  public ump a;
  public TextView b;
  public ump b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public umr(View paramView, umm paramumm)
  {
    View localView = paramView.findViewById(2131373298);
    paramView = paramView.findViewById(2131373349);
    this.jdField_a_of_type_Ump = new ump(localView, paramumm.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Ump = new ump(paramView, paramumm.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363949));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363949));
    this.c = ((TextView)localView.findViewById(2131363929));
    this.d = ((TextView)paramView.findViewById(2131363929));
    this.e = ((TextView)localView.findViewById(2131363945));
    this.f = ((TextView)paramView.findViewById(2131363945));
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991b8"));
      this.c.setTextColor(Color.parseColor("#6991b8"));
      this.d.setTextColor(Color.parseColor("#6991b8"));
      this.e.setTextColor(Color.parseColor("#6991b8"));
      this.f.setTextColor(Color.parseColor("#6991b8"));
    }
    if (paramumm.jdField_a_of_type_Umj != null)
    {
      this.jdField_a_of_type_Ump.a(paramumm.jdField_a_of_type_Umj);
      this.jdField_b_of_type_Ump.a(paramumm.jdField_a_of_type_Umj);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      veg.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Ump.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Ump.a();
      return;
    }
    this.jdField_b_of_type_Ump.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umr
 * JD-Core Version:    0.7.0.1
 */