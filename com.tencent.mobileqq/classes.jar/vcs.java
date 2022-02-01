import UserGrowth.stQQGroupDetailRsp;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class vcs
  implements vfg
{
  vcs(vcr paramvcr, vct paramvct, String paramString) {}
  
  public void a(vfr paramvfr)
  {
    Object localObject = new WeakReference(this.jdField_a_of_type_Vct);
    if ((paramvfr == null) || (paramvfr.jdField_a_of_type_Vfo == null) || (!TextUtils.equals(paramvfr.jdField_a_of_type_Vfo.b, vcr.a(this.jdField_a_of_type_Vcr)))) {}
    do
    {
      return;
      localObject = (vct)((WeakReference)localObject).get();
    } while ((localObject == null) || (!((vct)localObject).a()));
    ((vct)localObject).c();
    if (paramvfr.a())
    {
      if ((paramvfr.jdField_a_of_type_JavaLangObject instanceof stQQGroupDetailRsp))
      {
        paramvfr = (stQQGroupDetailRsp)paramvfr.jdField_a_of_type_JavaLangObject;
        if (paramvfr.status == 0)
        {
          vmp.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response :  msg = " + paramvfr.msg + ", code = " + paramvfr.status + "; signature = " + paramvfr.signature);
          ((vct)localObject).a(this.jdField_a_of_type_JavaLangString, paramvfr.signature);
          return;
        }
      }
      vmp.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : response is not instanceof stQQGroupDetailRsp");
      ((vct)localObject).a();
      return;
    }
    vmp.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : !task.succeeded()");
    ((vct)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */