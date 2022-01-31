import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class uam
  extends QQUIEventReceiver<StoryPickerFragment, sys>
{
  public uam(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull sys paramsys)
  {
    urk.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramsys.toString());
    if ((paramsys.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsys.jdField_a_of_type_JavaUtilList != null) && (!paramsys.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramsys.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        uhj localuhj = (uhj)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localuhj.jdField_a_of_type_JavaLangString)) {
          localuhj.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Uau.a(paramsys.jdField_a_of_type_JavaLangString, paramsys.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return sys.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uam
 * JD-Core Version:    0.7.0.1
 */