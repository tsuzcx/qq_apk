import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class wqt
  extends SimpleJob<Object>
{
  wqt(wqs paramwqs, String paramString, StoryVideoItem paramStoryVideoItem, List paramList)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    synchronized (wqs.a(this.jdField_a_of_type_Wqs))
    {
      this.jdField_a_of_type_Wqs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      this.jdField_a_of_type_Wqs.jdField_a_of_type_Wqu = new wqu(this.jdField_a_of_type_Wqs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      this.jdField_a_of_type_Wqs.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_Wqs.b();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqt
 * JD-Core Version:    0.7.0.1
 */