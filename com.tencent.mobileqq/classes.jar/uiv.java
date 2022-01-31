import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class uiv
  implements azah
{
  uiv(uiu paramuiu, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, azaa paramazaa)
  {
    uja localuja;
    if (paramazaa.jdField_a_of_type_Int == 0)
    {
      paramazaa = (awei)paramazaa.jdField_a_of_type_JavaLangObject;
      localuja = (uja)this.jdField_a_of_type_Uiu.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localuja != null)
      {
        if (!new File(paramazaa.b).exists()) {
          break label99;
        }
        localuja.b = (System.currentTimeMillis() - localuja.jdField_a_of_type_Long);
        if (localuja.jdField_a_of_type_Uit != null) {
          localuja.jdField_a_of_type_Uit.a(localuja, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        wsv.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        wsv.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramazaa.jdField_a_of_type_Int) });
        localuja = (uja)this.jdField_a_of_type_Uiu.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localuja == null);
      localuja.b = (System.currentTimeMillis() - localuja.jdField_a_of_type_Long);
    } while (localuja.jdField_a_of_type_Uit == null);
    localuja.jdField_a_of_type_Uit.a(localuja, new ErrorMessage(paramazaa.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<azaa> paramArrayList) {}
  
  public void b(int paramInt, azaa paramazaa) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uiv
 * JD-Core Version:    0.7.0.1
 */