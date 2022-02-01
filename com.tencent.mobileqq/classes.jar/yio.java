import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class yio
  extends SimpleJob<Object>
{
  yio(yin paramyin, String paramString, StoryVideoItem paramStoryVideoItem, List paramList)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    synchronized (yin.a(this.jdField_a_of_type_Yin))
    {
      this.jdField_a_of_type_Yin.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      this.jdField_a_of_type_Yin.jdField_a_of_type_Yip = new yip(this.jdField_a_of_type_Yin.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      this.jdField_a_of_type_Yin.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_Yin.b();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yio
 * JD-Core Version:    0.7.0.1
 */