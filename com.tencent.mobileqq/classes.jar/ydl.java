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

public class ydl
  extends QQUIEventReceiver<StoryPickerFragment, wzr>
{
  public ydl(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull wzr paramwzr)
  {
    boolean bool1 = false;
    if (!TextUtils.equals(paramStoryPickerFragment.jdField_a_of_type_JavaLangString, paramwzr.jdField_a_of_type_JavaLangString)) {
      return;
    }
    boolean bool2 = paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    Object localObject = new ArrayList(paramwzr.jdField_a_of_type_JavaUtilList.size());
    List localList = paramwzr.jdField_a_of_type_JavaUtilList;
    int i = 0;
    while (i < localList.size())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localList.get(i);
      if (localVideoCollectionItem.collectionType == 1)
      {
        int j = 0;
        if (j < localVideoCollectionItem.collectionVideoUIItemList.size())
        {
          ykj localykj = (ykj)localVideoCollectionItem.collectionVideoUIItemList.get(j);
          if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localykj.jdField_a_of_type_JavaLangString))
          {
            localykj.jdField_a_of_type_Boolean = true;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localykj.b = true;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            localykj.jdField_a_of_type_Boolean = false;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localykj.b = false;
            } else {
              localykj.b = true;
            }
          }
        }
        ((List)localObject).add(localVideoCollectionItem);
      }
      i += 1;
    }
    if ((bool2) && (paramwzr.e))
    {
      if (!((List)localObject).isEmpty()) {
        break label327;
      }
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
      if (!paramwzr.c) {
        break label347;
      }
      paramStoryPickerFragment.jdField_a_of_type_Ydu.a((List)localObject);
    }
    for (;;)
    {
      if (paramwzr.c) {
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(bool2);
      }
      localObject = paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a;
      if (!paramwzr.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      ((zti)localObject).a(bool2, bool1);
      paramStoryPickerFragment.stopTitleProgress();
      return;
      label327:
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
      break;
      label347:
      paramStoryPickerFragment.jdField_a_of_type_Ydu.b((List)localObject);
    }
  }
  
  public Class acceptEventClass()
  {
    return wzr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydl
 * JD-Core Version:    0.7.0.1
 */