import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicInteger;

public class utb
  implements EIPCResultCallback
{
  public utb(EditVideoArtFilter paramEditVideoArtFilter, uxf paramuxf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data == null) {}
    int j;
    Object localObject;
    do
    {
      return;
      int i = paramEIPCResult.data.getInt("param_art_filter_task_id");
      j = paramEIPCResult.data.getInt("param_art_filter_style_id");
      localObject = paramEIPCResult.data.getString("param_art_filter_resource_path");
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "QIPCResult: resultFilterTaskId:" + i + " currentFilterTaskId:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " currentStyleId:" + EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter) + " resultFilterStyleId:" + j + " resultFilterOriginImgPath:" + (String)localObject);
      }
    } while ((EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter) != j) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.d == null) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.d)) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_Boolean));
    if (paramEIPCResult.data.getInt("param_art_filter_task_result") == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("param_art_filter_output_path");
      localObject = EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(34);
      ((Message)localObject).obj = paramEIPCResult;
      ((Message)localObject).arg1 = this.jdField_a_of_type_Uxf.a;
      EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage((Message)localObject);
      return;
    }
    paramEIPCResult = EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(37);
    EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utb
 * JD-Core Version:    0.7.0.1
 */