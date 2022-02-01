import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class ysi
  extends SimpleJob<Object>
{
  ysi(ysh paramysh, String paramString, StoryVideoItem paramStoryVideoItem, List paramList)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    synchronized (ysh.a(this.jdField_a_of_type_Ysh))
    {
      this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      this.jdField_a_of_type_Ysh.jdField_a_of_type_Ysj = new ysj(this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      this.jdField_a_of_type_Ysh.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_Ysh.b();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysi
 * JD-Core Version:    0.7.0.1
 */