import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class une
  implements azeq
{
  une(und paramund, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, azej paramazej)
  {
    unj localunj;
    if (paramazej.jdField_a_of_type_Int == 0)
    {
      paramazej = (awir)paramazej.jdField_a_of_type_JavaLangObject;
      localunj = (unj)this.jdField_a_of_type_Und.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localunj != null)
      {
        if (!new File(paramazej.b).exists()) {
          break label99;
        }
        localunj.b = (System.currentTimeMillis() - localunj.jdField_a_of_type_Long);
        if (localunj.jdField_a_of_type_Unc != null) {
          localunj.jdField_a_of_type_Unc.a(localunj, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        wxe.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        wxe.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(paramazej.jdField_a_of_type_Int) });
        localunj = (unj)this.jdField_a_of_type_Und.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localunj == null);
      localunj.b = (System.currentTimeMillis() - localunj.jdField_a_of_type_Long);
    } while (localunj.jdField_a_of_type_Unc == null);
    localunj.jdField_a_of_type_Unc.a(localunj, new ErrorMessage(paramazej.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<azej> paramArrayList) {}
  
  public void b(int paramInt, azej paramazej) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     une
 * JD-Core Version:    0.7.0.1
 */