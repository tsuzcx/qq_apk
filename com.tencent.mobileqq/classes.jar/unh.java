import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class unh
  extends QQUIEventReceiver<StoryPickerFragment, tjm>
{
  public unh(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull tjm paramtjm)
  {
    boolean bool1 = false;
    if (!TextUtils.equals(paramStoryPickerFragment.jdField_a_of_type_JavaLangString, paramtjm.jdField_a_of_type_JavaLangString)) {
      return;
    }
    boolean bool2 = paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    Object localObject = new ArrayList(paramtjm.jdField_a_of_type_JavaUtilList.size());
    List localList = paramtjm.jdField_a_of_type_JavaUtilList;
    int i = 0;
    while (i < localList.size())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localList.get(i);
      if (localVideoCollectionItem.collectionType == 1)
      {
        int j = 0;
        if (j < localVideoCollectionItem.collectionVideoUIItemList.size())
        {
          uuf localuuf = (uuf)localVideoCollectionItem.collectionVideoUIItemList.get(j);
          if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localuuf.jdField_a_of_type_JavaLangString))
          {
            localuuf.jdField_a_of_type_Boolean = true;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localuuf.b = true;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            localuuf.jdField_a_of_type_Boolean = false;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localuuf.b = false;
            } else {
              localuuf.b = true;
            }
          }
        }
        ((List)localObject).add(localVideoCollectionItem);
      }
      i += 1;
    }
    if ((bool2) && (paramtjm.e))
    {
      if (!((List)localObject).isEmpty()) {
        break label327;
      }
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
      if (!paramtjm.c) {
        break label347;
      }
      paramStoryPickerFragment.jdField_a_of_type_Unq.a((List)localObject);
    }
    for (;;)
    {
      if (paramtjm.c) {
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(bool2);
      }
      localObject = paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a;
      if (!paramtjm.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      ((wde)localObject).a(bool2, bool1);
      paramStoryPickerFragment.stopTitleProgress();
      return;
      label327:
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
      break;
      label347:
      paramStoryPickerFragment.jdField_a_of_type_Unq.b((List)localObject);
    }
  }
  
  public Class acceptEventClass()
  {
    return tjm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unh
 * JD-Core Version:    0.7.0.1
 */