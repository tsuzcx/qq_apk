import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class ycv
  extends yck
{
  public TextView a;
  public yct a;
  public TextView b;
  public yct b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public ycv(View paramView, ycq paramycq)
  {
    View localView = paramView.findViewById(2131374639);
    paramView = paramView.findViewById(2131374690);
    this.jdField_a_of_type_Yct = new yct(localView, paramycq.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Yct = new yct(paramView, paramycq.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364254));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364254));
    this.c = ((TextView)localView.findViewById(2131364233));
    this.d = ((TextView)paramView.findViewById(2131364233));
    this.e = ((TextView)localView.findViewById(2131364249));
    this.f = ((TextView)paramView.findViewById(2131364249));
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
    if (paramycq.jdField_a_of_type_Ycn != null)
    {
      this.jdField_a_of_type_Yct.a(paramycq.jdField_a_of_type_Ycn);
      this.jdField_b_of_type_Yct.a(paramycq.jdField_a_of_type_Ycn);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      yuk.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Yct.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Yct.a();
      return;
    }
    this.jdField_b_of_type_Yct.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycv
 * JD-Core Version:    0.7.0.1
 */