import android.os.Bundle;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter.b;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicInteger;

public class ayfd
  implements EIPCResultCallback
{
  public ayfd(EditVideoArtFilter paramEditVideoArtFilter, rfh paramrfh) {}
  
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
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "QIPCResult: resultFilterTaskId:" + i + " currentFilterTaskId:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.an.get() + " currentStyleId:" + EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter) + " resultFilterStyleId:" + j + " resultFilterOriginImgPath:" + (String)localObject);
      }
    } while ((EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter) != j) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.azz == null) || (!((String)localObject).equals(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.azz)) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter.aGJ));
    if (paramEIPCResult.data.getInt("param_art_filter_task_result") == 0)
    {
      paramEIPCResult = paramEIPCResult.data.getString("param_art_filter_output_path");
      localObject = EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(34);
      ((Message)localObject).obj = paramEIPCResult;
      ((Message)localObject).arg1 = this.jdField_a_of_type_Rfh.id;
      EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage((Message)localObject);
      return;
    }
    paramEIPCResult = EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).obtainMessage(37);
    EditVideoArtFilter.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter).sendMessage(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayfd
 * JD-Core Version:    0.7.0.1
 */