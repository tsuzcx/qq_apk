import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class xts
  extends QQUIEventReceiver<StoryPickerFragment, wse>
{
  public xts(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull wse paramwse)
  {
    ykq.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramwse.toString());
    if ((paramwse.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwse.jdField_a_of_type_JavaUtilList != null) && (!paramwse.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramwse.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        yap localyap = (yap)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localyap.jdField_a_of_type_JavaLangString)) {
          localyap.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Xua.a(paramwse.jdField_a_of_type_JavaLangString, paramwse.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return wse.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xts
 * JD-Core Version:    0.7.0.1
 */