import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class xzr
  extends QQUIEventReceiver<StoryPickerFragment, wxy>
{
  public xzr(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull wxy paramwxy)
  {
    yqp.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramwxy.toString());
    if ((paramwxy.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwxy.jdField_a_of_type_JavaUtilList != null) && (!paramwxy.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramwxy.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ygo localygo = (ygo)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localygo.jdField_a_of_type_JavaLangString)) {
          localygo.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Xzz.a(paramwxy.jdField_a_of_type_JavaLangString, paramwxy.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return wxy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzr
 * JD-Core Version:    0.7.0.1
 */