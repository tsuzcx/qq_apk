import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class uvr
  implements ukd
{
  uvr(uvq paramuvq, long paramLong, uoq paramuoq, usf paramusf) {}
  
  public void a(uko paramuko)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    uqf.a("weishi-beacon", "小程序播放页请求耗时：" + l + "毫秒");
    uoc.a().a(true, l, this.jdField_a_of_type_Uoq.d(), 1, "fullscreen_videoplay", true);
    if (!paramuko.a())
    {
      uqf.d("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramuko.jdField_a_of_type_Int + ", msg:" + paramuko.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Usf != null) {
        this.jdField_a_of_type_Usf.a(paramuko.jdField_a_of_type_Int, paramuko.jdField_a_of_type_JavaLangString);
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (!(paramuko.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedDetailRsp)) {
            break;
          }
          paramuko = ((stSimpleGetFeedDetailRsp)paramuko.jdField_a_of_type_JavaLangObject).feed;
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramuko);
          paramuko = WSVerticalDataManager.a().a((List)localObject);
          localObject = this.jdField_a_of_type_Uvq.a();
        } while ((localObject == null) || (((urv)localObject).a() == null) || (((urv)localObject).a().a() == null));
        localObject = ((urv)localObject).a().a().a;
      } while (!(localObject instanceof utq));
      ((utq)localObject).b((usv)paramuko.get(0));
      return;
    } while (this.jdField_a_of_type_Usf == null);
    this.jdField_a_of_type_Usf.a(paramuko.b, paramuko.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvr
 * JD-Core Version:    0.7.0.1
 */