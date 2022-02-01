import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class xex
  extends QQUIEventReceiver<StoryPickerFragment, wdj>
{
  public xex(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull wdj paramwdj)
  {
    xvv.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramwdj.toString());
    if ((paramwdj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramwdj.jdField_a_of_type_JavaUtilList != null) && (!paramwdj.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramwdj.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        xlu localxlu = (xlu)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localxlu.jdField_a_of_type_JavaLangString)) {
          localxlu.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Xff.a(paramwdj.jdField_a_of_type_JavaLangString, paramwdj.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return wdj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xex
 * JD-Core Version:    0.7.0.1
 */