import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class wfp
  extends wfe
{
  public TextView a;
  public wfn a;
  public TextView b;
  public wfn b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public wfp(View paramView, wfk paramwfk)
  {
    View localView = paramView.findViewById(2131373800);
    paramView = paramView.findViewById(2131373851);
    this.jdField_a_of_type_Wfn = new wfn(localView, paramwfk.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Wfn = new wfn(paramView, paramwfk.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364008));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364008));
    this.c = ((TextView)localView.findViewById(2131363988));
    this.d = ((TextView)paramView.findViewById(2131363988));
    this.e = ((TextView)localView.findViewById(2131364004));
    this.f = ((TextView)paramView.findViewById(2131364004));
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
    if (paramwfk.jdField_a_of_type_Wfh != null)
    {
      this.jdField_a_of_type_Wfn.a(paramwfk.jdField_a_of_type_Wfh);
      this.jdField_b_of_type_Wfn.a(paramwfk.jdField_a_of_type_Wfh);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      wxe.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Wfn.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Wfn.a();
      return;
    }
    this.jdField_b_of_type_Wfn.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfp
 * JD-Core Version:    0.7.0.1
 */