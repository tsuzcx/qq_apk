import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListView;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class uno
{
  public TextView a;
  public StoryPickerHorizontalListView a;
  
  public uno(unn paramunn, View paramView, unm paramunm)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364924));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView = ((StoryPickerHorizontalListView)paramView.findViewById(2131367610));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setSelection(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setOnHorizontalScrollListener(paramunm);
    paramView = (ung)this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.a();
    paramView.a(paramunn.jdField_a_of_type_Unl);
    paramView.a(paramunn.jdField_a_of_type_Unk);
  }
  
  public void a(int paramInt, VideoCollectionItem paramVideoCollectionItem)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setData(paramVideoCollectionItem.collectionVideoUIItemList, paramVideoCollectionItem.collectionId);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView.setTag(Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(vxy.b(paramVideoCollectionItem.collectionTime));
    this.jdField_a_of_type_Unn.jdField_a_of_type_JavaUtilHashMap.put(paramVideoCollectionItem.collectionId, new WeakReference(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uno
 * JD-Core Version:    0.7.0.1
 */