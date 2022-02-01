import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ydv
{
  public TextView a;
  public StoryPickerHorizontalListView a;
  
  public ydv(ydu paramydu, View paramView, ydt paramydt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365294));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView = ((StoryPickerHorizontalListView)paramView.findViewById(2131368133));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setSelection(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setOnHorizontalScrollListener(paramydt);
    paramView = (ydn)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.a();
    paramView.a(paramydu.jdField_a_of_type_Yds);
    paramView.a(paramydu.jdField_a_of_type_Ydr);
  }
  
  public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(zof.b(paramVideoCollectionItem.collectionTime));
    this.jdField_a_of_type_Ydu.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydv
 * JD-Core Version:    0.7.0.1
 */