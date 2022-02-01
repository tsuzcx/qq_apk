import UserGrowth.stGetAIOFeedDetailRsp;
import UserGrowth.stSimpleMetaFeed;

class vih
  implements vfg
{
  vih(vic paramvic, long paramLong) {}
  
  public void a(vfr paramvfr)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if ((!paramvfr.a()) || (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stGetAIOFeedDetailRsp))) {
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, paramvfr.jdField_a_of_type_Int, paramvfr.jdField_a_of_type_JavaLangString);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    do
    {
      return;
      vkk.a().a(l, paramvfr.jdField_a_of_type_Vfo, "feeds", true);
      paramvfr = (stGetAIOFeedDetailRsp)paramvfr.jdField_a_of_type_JavaLangObject;
      localstSimpleMetaFeed = paramvfr.feed;
    } while ((!paramvfr.enable) || (localstSimpleMetaFeed == null));
    vic.a(this.jdField_a_of_type_Vic, localstSimpleMetaFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vih
 * JD-Core Version:    0.7.0.1
 */