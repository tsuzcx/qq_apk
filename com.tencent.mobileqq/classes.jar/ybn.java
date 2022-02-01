import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ybn
  extends blfl
  implements View.OnClickListener, View.OnLongClickListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  StoryCoverView jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView;
  String jdField_a_of_type_JavaLangString;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  
  public ybn(StoryMessageListActivity paramStoryMessageListActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363145));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView = ((StoryCoverView)paramView.findViewById(2131378884));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364890));
    this.c = ((TextView)paramView.findViewById(2131372074));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370092);
    this.d = ((TextView)paramView.findViewById(2131378941));
    this.e = ((TextView)paramView.findViewById(2131380804));
    this.f = ((TextView)paramView.findViewById(2131380805));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370108);
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.onItemClick(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.onItemLongClick(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a, paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybn
 * JD-Core Version:    0.7.0.1
 */