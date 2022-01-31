import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class wcg
{
  public TextView a;
  public StoryPickerHorizontalListView a;
  
  public wcg(wcf paramwcf, View paramView, wce paramwce)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365011));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView = ((StoryPickerHorizontalListView)paramView.findViewById(2131367739));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setSelection(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setOnHorizontalScrollListener(paramwce);
    paramView = (wby)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.a();
    paramView.a(paramwcf.jdField_a_of_type_Wcd);
    paramView.a(paramwcf.jdField_a_of_type_Wcc);
  }
  
  public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(xmq.b(paramVideoCollectionItem.collectionTime));
    this.jdField_a_of_type_Wcf.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcg
 * JD-Core Version:    0.7.0.1
 */