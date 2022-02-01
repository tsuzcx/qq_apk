import UserGrowth.stQQGroupDetailRsp;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class uos
  implements uqy
{
  uos(uor paramuor, uot paramuot, String paramString) {}
  
  public void a(urj paramurj)
  {
    Object localObject = new WeakReference(this.jdField_a_of_type_Uot);
    if ((paramurj == null) || (paramurj.jdField_a_of_type_Urg == null) || (!TextUtils.equals(paramurj.jdField_a_of_type_Urg.b, uor.a(this.jdField_a_of_type_Uor)))) {}
    do
    {
      return;
      localObject = (uot)((WeakReference)localObject).get();
    } while ((localObject == null) || (!((uot)localObject).a()));
    ((uot)localObject).c();
    if (paramurj.a())
    {
      if ((paramurj.jdField_a_of_type_JavaLangObject instanceof stQQGroupDetailRsp))
      {
        paramurj = (stQQGroupDetailRsp)paramurj.jdField_a_of_type_JavaLangObject;
        if (paramurj.status == 0)
        {
          uya.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response :  msg = " + paramurj.msg + ", code = " + paramurj.status + "; signature = " + paramurj.signature);
          ((uot)localObject).a(this.jdField_a_of_type_JavaLangString, paramurj.signature);
          return;
        }
      }
      uya.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : response is not instanceof stQQGroupDetailRsp");
      ((uot)localObject).a();
      return;
    }
    uya.e("WSJoinGroupDataProcessor", "doTask: stQQGroupDetailRsp response : !task.succeeded()");
    ((uot)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uos
 * JD-Core Version:    0.7.0.1
 */