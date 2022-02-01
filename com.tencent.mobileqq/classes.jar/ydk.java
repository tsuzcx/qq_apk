import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class ydk
  extends QQUIEventReceiver<StoryPickerFragment, xqk>
{
  public ydk(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull xqk paramxqk)
  {
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.clear();
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramxqk.jdField_a_of_type_JavaUtilArrayList);
    List localList = paramStoryPickerFragment.jdField_a_of_type_Ydu.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        ykj localykj = (ykj)localIterator.next();
        if (paramxqk.jdField_a_of_type_JavaUtilArrayList.contains(localykj.jdField_a_of_type_JavaLangString)) {
          localykj.jdField_a_of_type_Boolean = true;
        } else {
          localykj.jdField_a_of_type_Boolean = false;
        }
      }
      i += 1;
    }
    paramStoryPickerFragment.c();
    if (paramxqk.jdField_a_of_type_Boolean) {
      paramStoryPickerFragment.rightViewText.performClick();
    }
  }
  
  public Class acceptEventClass()
  {
    return xqk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydk
 * JD-Core Version:    0.7.0.1
 */