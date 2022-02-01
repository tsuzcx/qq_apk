import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class xza
  extends xyp
{
  public TextView a;
  public xyy a;
  public TextView b;
  public xyy b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public xza(View paramView, xyv paramxyv)
  {
    View localView = paramView.findViewById(2131374502);
    paramView = paramView.findViewById(2131374553);
    this.jdField_a_of_type_Xyy = new xyy(localView, paramxyv.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Xyy = new xyy(paramView, paramxyv.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364209));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364209));
    this.c = ((TextView)localView.findViewById(2131364189));
    this.d = ((TextView)paramView.findViewById(2131364189));
    this.e = ((TextView)localView.findViewById(2131364205));
    this.f = ((TextView)paramView.findViewById(2131364205));
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
    if (paramxyv.jdField_a_of_type_Xys != null)
    {
      this.jdField_a_of_type_Xyy.a(paramxyv.jdField_a_of_type_Xys);
      this.jdField_b_of_type_Xyy.a(paramxyv.jdField_a_of_type_Xys);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      yqp.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Xyy.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Xyy.a();
      return;
    }
    this.jdField_b_of_type_Xyy.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xza
 * JD-Core Version:    0.7.0.1
 */