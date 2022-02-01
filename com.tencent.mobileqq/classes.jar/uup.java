import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class uup
  implements ujj
{
  uup(uuo paramuuo, long paramLong, unp paramunp, ure paramure) {}
  
  public void a(uju paramuju)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    upe.a("weishi-beacon", "小程序播放页请求耗时：" + l + "毫秒");
    unb.a().a(true, l, this.jdField_a_of_type_Unp.d(), 1, "fullscreen_videoplay", true);
    if (!paramuju.a())
    {
      upe.d("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramuju.jdField_a_of_type_Int + ", msg:" + paramuju.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Ure != null) {
        this.jdField_a_of_type_Ure.a(paramuju.jdField_a_of_type_Int, paramuju.jdField_a_of_type_JavaLangString);
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
          if (!(paramuju.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedDetailRsp)) {
            break;
          }
          paramuju = ((stSimpleGetFeedDetailRsp)paramuju.jdField_a_of_type_JavaLangObject).feed;
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramuju);
          paramuju = WSVerticalDataManager.a().a((List)localObject);
          localObject = this.jdField_a_of_type_Uuo.a();
        } while ((localObject == null) || (((uqu)localObject).a() == null) || (((uqu)localObject).a().a() == null));
        localObject = ((uqu)localObject).a().a().a;
      } while (!(localObject instanceof usp));
      ((usp)localObject).b((uru)paramuju.get(0));
      return;
    } while (this.jdField_a_of_type_Ure == null);
    this.jdField_a_of_type_Ure.a(paramuju.b, paramuju.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uup
 * JD-Core Version:    0.7.0.1
 */