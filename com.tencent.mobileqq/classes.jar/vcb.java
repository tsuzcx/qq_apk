import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.List;

class vcb
  extends SimpleJob<Object>
{
  vcb(vca paramvca, String paramString, StoryVideoItem paramStoryVideoItem, List paramList)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext arg1, @Nullable Void... paramVarArgs)
  {
    synchronized (vca.a(this.jdField_a_of_type_Vca))
    {
      this.jdField_a_of_type_Vca.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      this.jdField_a_of_type_Vca.jdField_a_of_type_Vcc = new vcc(this.jdField_a_of_type_Vca.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      this.jdField_a_of_type_Vca.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_Vca.b();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcb
 * JD-Core Version:    0.7.0.1
 */