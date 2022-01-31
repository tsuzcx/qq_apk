import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;

class ubo
  implements ubr
{
  ubo(ubn paramubn, PublishParam paramPublishParam, String paramString, int paramInt) {}
  
  public void a()
  {
    urk.c("QQStoryTakeVideoHelper", "generate manifest file success.start publishing.");
    ubn.a(this.jdField_a_of_type_Ubn, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void b()
  {
    urk.e("QQStoryTakeVideoHelper", "generate manifest file error. let's exit.");
    ubn.a(this.jdField_a_of_type_Ubn).finish();
    ubn.a(this.jdField_a_of_type_Ubn).overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ubo
 * JD-Core Version:    0.7.0.1
 */