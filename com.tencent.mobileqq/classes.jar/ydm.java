import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class ydm
  extends QQUIEventReceiver<StoryPickerFragment, xbt>
{
  public ydm(@NonNull StoryPickerFragment paramStoryPickerFragment)
  {
    super(paramStoryPickerFragment);
  }
  
  public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull xbt paramxbt)
  {
    yuk.b(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", paramxbt.toString());
    if ((paramxbt.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramxbt.jdField_a_of_type_JavaUtilList != null) && (!paramxbt.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramxbt.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ykj localykj = (ykj)localIterator.next();
        if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localykj.jdField_a_of_type_JavaLangString)) {
          localykj.jdField_a_of_type_Boolean = true;
        }
      }
      paramStoryPickerFragment.jdField_a_of_type_Ydu.a(paramxbt.jdField_a_of_type_JavaLangString, paramxbt.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Class acceptEventClass()
  {
    return xbt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydm
 * JD-Core Version:    0.7.0.1
 */