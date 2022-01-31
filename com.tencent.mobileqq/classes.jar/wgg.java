import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class wgg
  extends QQUIEventReceiver<StoryPickerFragment, vem>
{
  public wgg(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull vem paramvem)
  {
    wxe.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramvem.toString());
    if ((paramvem.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramvem.jdField_a_of_type_JavaUtilList != null) && (!paramvem.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramvem.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        wnd localwnd = (wnd)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localwnd.jdField_a_of_type_JavaLangString)) {
          localwnd.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Wgo.a(paramvem.jdField_a_of_type_JavaLangString, paramvem.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return vem.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgg
 * JD-Core Version:    0.7.0.1
 */