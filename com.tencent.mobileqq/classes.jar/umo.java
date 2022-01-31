import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class umo
  extends umd
{
  public TextView a;
  public umm a;
  public TextView b;
  public umm b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public umo(View paramView, umj paramumj)
  {
    View localView = paramView.findViewById(2131373300);
    paramView = paramView.findViewById(2131373351);
    this.jdField_a_of_type_Umm = new umm(localView, paramumj.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Umm = new umm(paramView, paramumj.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363948));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363948));
    this.c = ((TextView)localView.findViewById(2131363928));
    this.d = ((TextView)paramView.findViewById(2131363928));
    this.e = ((TextView)localView.findViewById(2131363944));
    this.f = ((TextView)paramView.findViewById(2131363944));
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
    if (paramumj.jdField_a_of_type_Umg != null)
    {
      this.jdField_a_of_type_Umm.a(paramumj.jdField_a_of_type_Umg);
      this.jdField_b_of_type_Umm.a(paramumj.jdField_a_of_type_Umg);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      ved.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Umm.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Umm.a();
      return;
    }
    this.jdField_b_of_type_Umm.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umo
 * JD-Core Version:    0.7.0.1
 */