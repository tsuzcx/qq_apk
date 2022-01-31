import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class und
  extends QQUIEventReceiver<StoryPickerFragment, uad>
{
  public und(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull uad paramuad)
  {
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.clear();
    paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramuad.jdField_a_of_type_JavaUtilArrayList);
    List localList = paramStoryPickerFragment.jdField_a_of_type_Unn.a();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        uuc localuuc = (uuc)localIterator.next();
        if (paramuad.jdField_a_of_type_JavaUtilArrayList.contains(localuuc.jdField_a_of_type_JavaLangString)) {
          localuuc.jdField_a_of_type_Boolean = true;
        } else {
          localuuc.jdField_a_of_type_Boolean = false;
        }
      }
      i += 1;
    }
    paramStoryPickerFragment.c();
    if (paramuad.jdField_a_of_type_Boolean) {
      paramStoryPickerFragment.rightViewText.performClick();
    }
  }
  
  public Class acceptEventClass()
  {
    return uad.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     und
 * JD-Core Version:    0.7.0.1
 */