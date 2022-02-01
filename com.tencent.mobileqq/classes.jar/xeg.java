import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class xeg
  extends xdv
{
  public TextView a;
  public xee a;
  public TextView b;
  public xee b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public xeg(View paramView, xeb paramxeb)
  {
    View localView = paramView.findViewById(2131374407);
    paramView = paramView.findViewById(2131374458);
    this.jdField_a_of_type_Xee = new xee(localView, paramxeb.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Xee = new xee(paramView, paramxeb.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364273));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364273));
    this.c = ((TextView)localView.findViewById(2131364252));
    this.d = ((TextView)paramView.findViewById(2131364252));
    this.e = ((TextView)localView.findViewById(2131364268));
    this.f = ((TextView)paramView.findViewById(2131364268));
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
    if (paramxeb.jdField_a_of_type_Xdy != null)
    {
      this.jdField_a_of_type_Xee.a(paramxeb.jdField_a_of_type_Xdy);
      this.jdField_b_of_type_Xee.a(paramxeb.jdField_a_of_type_Xdy);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      xvv.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Xee.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Xee.a();
      return;
    }
    this.jdField_b_of_type_Xee.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xeg
 * JD-Core Version:    0.7.0.1
 */