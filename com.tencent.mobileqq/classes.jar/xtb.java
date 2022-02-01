import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class xtb
  extends xsq
{
  public TextView a;
  public xsz a;
  public TextView b;
  public xsz b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  
  public xtb(View paramView, xsw paramxsw)
  {
    View localView = paramView.findViewById(2131374645);
    paramView = paramView.findViewById(2131374696);
    this.jdField_a_of_type_Xsz = new xsz(localView, paramxsw.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Xsz = new xsz(paramView, paramxsw.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364351));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364351));
    this.c = ((TextView)localView.findViewById(2131364330));
    this.d = ((TextView)paramView.findViewById(2131364330));
    this.e = ((TextView)localView.findViewById(2131364346));
    this.f = ((TextView)paramView.findViewById(2131364346));
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
    if (paramxsw.jdField_a_of_type_Xst != null)
    {
      this.jdField_a_of_type_Xsz.a(paramxsw.jdField_a_of_type_Xst);
      this.jdField_b_of_type_Xsz.a(paramxsw.jdField_a_of_type_Xst);
    }
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem, View paramView, int paramInt)
  {
    if ((paramVideoCollectionItem == null) || (paramView == null))
    {
      ykq.e("Q.qqstory.shareGroup.ShareGroupsListAdapter", "qqstory sharegroup hotsort erro. view  or data is null.");
      return;
    }
    paramView = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(0);
    paramVideoCollectionItem = (HotSortVideoEntry)paramVideoCollectionItem.hotSortVideoLIst.get(1);
    this.jdField_a_of_type_Xsz.a(paramView);
    if (paramVideoCollectionItem == null)
    {
      this.jdField_b_of_type_Xsz.a();
      return;
    }
    this.jdField_b_of_type_Xsz.a(paramVideoCollectionItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtb
 * JD-Core Version:    0.7.0.1
 */