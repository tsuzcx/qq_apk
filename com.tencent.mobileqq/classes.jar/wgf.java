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

public class wgf
  extends QQUIEventReceiver<StoryPickerFragment, vck>
{
  public wgf(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull vck paramvck)
  {
    boolean bool1 = false;
    if (!TextUtils.equals(paramStoryPickerFragment.jdField_a_of_type_JavaLangString, paramvck.jdField_a_of_type_JavaLangString)) {
      return;
    }
    boolean bool2 = paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess();
    Object localObject = new ArrayList(paramvck.jdField_a_of_type_JavaUtilList.size());
    List localList = paramvck.jdField_a_of_type_JavaUtilList;
    int i = 0;
    while (i < localList.size())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localList.get(i);
      if (localVideoCollectionItem.collectionType == 1)
      {
        int j = 0;
        if (j < localVideoCollectionItem.collectionVideoUIItemList.size())
        {
          wnd localwnd = (wnd)localVideoCollectionItem.collectionVideoUIItemList.get(j);
          if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localwnd.jdField_a_of_type_JavaLangString))
          {
            localwnd.jdField_a_of_type_Boolean = true;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localwnd.b = true;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            localwnd.jdField_a_of_type_Boolean = false;
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
              localwnd.b = false;
            } else {
              localwnd.b = true;
            }
          }
        }
        ((List)localObject).add(localVideoCollectionItem);
      }
      i += 1;
    }
    if ((bool2) && (paramvck.e))
    {
      if (!((List)localObject).isEmpty()) {
        break label327;
      }
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
      if (!paramvck.c) {
        break label347;
      }
      paramStoryPickerFragment.jdField_a_of_type_Wgo.a((List)localObject);
    }
    for (;;)
    {
      if (paramvck.c) {
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a(bool2);
      }
      localObject = paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a;
      if (!paramvck.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      ((xwc)localObject).a(bool2, bool1);
      paramStoryPickerFragment.stopTitleProgress();
      return;
      label327:
      paramStoryPickerFragment.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
      break;
      label347:
      paramStoryPickerFragment.jdField_a_of_type_Wgo.b((List)localObject);
    }
  }
  
  public Class acceptEventClass()
  {
    return vck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgf
 * JD-Core Version:    0.7.0.1
 */