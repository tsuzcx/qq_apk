import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class wbx
  extends QQUIEventReceiver<StoryPickerFragment, vad>
{
  public wbx(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull vad paramvad)
  {
    wsv.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramvad.toString());
    if ((paramvad.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvad.jdField_a_of_type_JavaUtilList != null) && (!paramvad.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramvad.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        wiu localwiu = (wiu)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localwiu.jdField_a_of_type_JavaLangString)) {
          localwiu.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Wcf.a(paramvad.jdField_a_of_type_JavaLangString, paramvad.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return vad.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wbx
 * JD-Core Version:    0.7.0.1
 */