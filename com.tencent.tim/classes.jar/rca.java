import android.os.Bundle;
import android.os.Message;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter.b;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicInteger;

public class rca
  implements EIPCResultCallback
{
  public rca(EditVideoArtFilter paramEditVideoArtFilter, rfh paramrfh) {}
  
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
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "QIPCResult: resultFilterTaskId:" + i + " currentFilterTaskId:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.an.get() + " currentStyleId:" + EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter) + " resultFilterStyleId:" + j + " resultFilterOriginImgPath:" + (String)localObject);
      }
    } while ((EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter) != j) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.azz == null) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.azz)) || (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.aGJ));
    if (paramEIPCResult.data.getInt("param_art_filter_task_result") == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("param_art_filter_output_path");
      localObject = EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(34);
      ((Message)localObject).obj = paramEIPCResult;
      ((Message)localObject).arg1 = this.jdField_a_of_type_Rfh.id;
      EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage((Message)localObject);
      return;
    }
    paramEIPCResult = EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(37);
    EditVideoArtFilter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rca
 * JD-Core Version:    0.7.0.1
 */