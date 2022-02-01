import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class xub
{
  public TextView a;
  public StoryPickerHorizontalListView a;
  
  public xub(xua paramxua, View paramView, xtz paramxtz)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365419));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView = ((StoryPickerHorizontalListView)paramView.findViewById(2131368305));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setSelection(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setOnHorizontalScrollListener(paramxtz);
    paramView = (xtt)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.a();
    paramView.a(paramxua.jdField_a_of_type_Xty);
    paramView.a(paramxua.jdField_a_of_type_Xtx);
  }
  
  public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(zdu.b(paramVideoCollectionItem.collectionTime));
    this.jdField_a_of_type_Xua.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xub
 * JD-Core Version:    0.7.0.1
 */