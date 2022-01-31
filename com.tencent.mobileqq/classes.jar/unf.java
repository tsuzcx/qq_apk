import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class unf
  extends QQUIEventReceiver<StoryPickerFragment, tll>
{
  public unf(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull tll paramtll)
  {
    ved.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramtll.toString());
    if ((paramtll.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramtll.jdField_a_of_type_JavaUtilList != null) && (!paramtll.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramtll.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        uuc localuuc = (uuc)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localuuc.jdField_a_of_type_JavaLangString)) {
          localuuc.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Unn.a(paramtll.jdField_a_of_type_JavaLangString, paramtll.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return tll.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     unf
 * JD-Core Version:    0.7.0.1
 */