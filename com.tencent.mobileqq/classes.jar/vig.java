import UserGrowth.stPublisherRsp;

class vig
  implements vfg
{
  vig(vic paramvic) {}
  
  public void a(vfr paramvfr)
  {
    if (!paramvfr.a()) {
      vmp.d("WSHomeFragmentPresenter", "GetFeedDetailRequest onTaskResponse failed code:" + paramvfr.jdField_a_of_type_Int + ", msg:" + paramvfr.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      if (!(paramvfr.jdField_a_of_type_JavaLangObject instanceof stPublisherRsp)) {
        break;
      }
      paramvfr = (stPublisherRsp)paramvfr.jdField_a_of_type_JavaLangObject;
    } while (this.a.a() == null);
    ((vir)this.a.a()).a(paramvfr);
    return;
    vmp.d("WSHomeFragmentPresenter", "GetPublisherRequest onTaskResponse failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vig
 * JD-Core Version:    0.7.0.1
 */