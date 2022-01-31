import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class wbg
  extends wav
{
  public TextView a;
  public wbe a;
  public TextView b;
  public wbe b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public wbg(View paramView, wbb paramwbb)
  {
    View localView = paramView.findViewById(2131373749);
    paramView = paramView.findViewById(2131373800);
    this.jdField_a_of_type_Wbe = new wbe(localView, paramwbb.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Wbe = new wbe(paramView, paramwbb.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364006));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364006));
    this.c = ((TextView)localView.findViewById(2131363986));
    this.d = ((TextView)paramView.findViewById(2131363986));
    this.e = ((TextView)localView.findViewById(2131364002));
    this.f = ((TextView)paramView.findViewById(2131364002));
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
    if (paramwbb.jdField_a_of_type_Way != null)
    {
      this.jdField_a_of_type_Wbe.a(paramwbb.jdField_a_of_type_Way);
      this.jdField_b_of_type_Wbe.a(paramwbb.jdField_a_of_type_Way);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      wsv.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Wbe.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Wbe.a();
      return;
    }
    this.jdField_b_of_type_Wbe.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbg
 * JD-Core Version:    0.7.0.1
 */