import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;

class qra
  implements qqz.a
{
  qra(qqz paramqqz, PublishParam paramPublishParam, String paramString, int paramInt) {}
  
  public void onError()
  {
    ram.e("QQStoryTakeVideoHelper", "generate manifest file error. let's exit.");
    qqz.a(this.jdField_a_of_type_Qqz).finish();
    qqz.a(this.jdField_a_of_type_Qqz).overridePendingTransition(0, 0);
  }
  
  public void onSuccess()
  {
    ram.i("QQStoryTakeVideoHelper", "generate manifest file success.start publishing.");
    qqz.a(this.jdField_a_of_type_Qqz, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam, this.ayh, this.bnL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qra
 * JD-Core Version:    0.7.0.1
 */