import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class uni
  extends QQUIEventReceiver<StoryPickerFragment, tlo>
{
  public uni(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull tlo paramtlo)
  {
    veg.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramtlo.toString());
    if ((paramtlo.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtlo.jdField_a_of_type_JavaUtilList != null) && (!paramtlo.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramtlo.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        uuf localuuf = (uuf)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localuuf.jdField_a_of_type_JavaLangString)) {
          localuuf.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Unq.a(paramtlo.jdField_a_of_type_JavaLangString, paramtlo.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return tlo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uni
 * JD-Core Version:    0.7.0.1
 */