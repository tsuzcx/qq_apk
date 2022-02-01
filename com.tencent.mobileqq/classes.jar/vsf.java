import UserGrowth.stSimpleGetFeedDetailRsp;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager;
import java.util.ArrayList;
import java.util.List;

class vsf
  implements vfg
{
  vsf(vse paramvse, long paramLong, vos paramvos) {}
  
  public void a(vfr paramvfr)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    vmp.a("weishi-beacon", "小程序播放页请求耗时：" + l + "毫秒");
    vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, "fullscreen_videoplay", true);
    if (!paramvfr.a())
    {
      vmp.d("WSVerticalForMiniAppPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Vos != null) {
        this.jdField_a_of_type_Vos.a(paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
      }
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        if (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stSimpleGetFeedDetailRsp)) {
          break;
        }
        paramvfr = ((stSimpleGetFeedDetailRsp)paramvfr.jdField_a_of_type_JavaLangObject).feed;
        paramvfr.isLoop = true;
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramvfr);
        paramvfr = WSVerticalDataManager.a().a((List)localObject);
        localObject = this.jdField_a_of_type_Vse.a();
      } while ((localObject == null) || (((voi)localObject).a() == null) || (((voi)localObject).a().a() == null));
      localObject = ((voi)localObject).a().a().a;
    } while (!(localObject instanceof vqe));
    ((vqe)localObject).b((vpj)paramvfr.get(0));
    return;
    if (this.jdField_a_of_type_Vos != null) {
      this.jdField_a_of_type_Vos.a(paramvfr.b, paramvfr.jdField_a_of_type_JavaLangString);
    }
    vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, -1, "数据无法解析或为空");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsf
 * JD-Core Version:    0.7.0.1
 */