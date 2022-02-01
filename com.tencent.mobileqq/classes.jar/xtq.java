import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class xtq
  extends QQUIEventReceiver<StoryPickerFragment, xgq>
{
  public xtq(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull xgq paramxgq)
  {
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.clear();
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramxgq.jdField_a_of_type_JavaUtilArrayList);
    List localList = paramStoryPickerFragment.jdField_a_of_type_Xua.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        yap localyap = (yap)localIterator.next();
        if (paramxgq.jdField_a_of_type_JavaUtilArrayList.contains(localyap.jdField_a_of_type_JavaLangString)) {
          localyap.jdField_a_of_type_Boolean = true;
        } else {
          localyap.jdField_a_of_type_Boolean = false;
        }
      }
      i += 1;
    }
    paramStoryPickerFragment.c();
    if (paramxgq.jdField_a_of_type_Boolean) {
      paramStoryPickerFragment.rightViewText.performClick();
    }
  }
  
  public Class acceptEventClass()
  {
    return xgq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtq
 * JD-Core Version:    0.7.0.1
 */