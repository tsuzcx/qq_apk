import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class wbf
  implements bcyl
{
  wbf(wbe paramwbe, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, bcyf parambcyf)
  {
    wbk localwbk;
    if (parambcyf.jdField_a_of_type_Int == 0)
    {
      parambcyf = (azjk)parambcyf.jdField_a_of_type_JavaLangObject;
      localwbk = (wbk)this.jdField_a_of_type_Wbe.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localwbk != null)
      {
        if (!new File(parambcyf.b).exists()) {
          break label99;
        }
        localwbk.b = (System.currentTimeMillis() - localwbk.jdField_a_of_type_Long);
        if (localwbk.jdField_a_of_type_Wbd != null) {
          localwbk.jdField_a_of_type_Wbd.a(localwbk, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        ykq.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        ykq.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(parambcyf.jdField_a_of_type_Int) });
        localwbk = (wbk)this.jdField_a_of_type_Wbe.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localwbk == null);
      localwbk.b = (System.currentTimeMillis() - localwbk.jdField_a_of_type_Long);
    } while (localwbk.jdField_a_of_type_Wbd == null);
    localwbk.jdField_a_of_type_Wbd.a(localwbk, new ErrorMessage(parambcyf.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<bcyf> paramArrayList) {}
  
  public void b(int paramInt, bcyf parambcyf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbf
 * JD-Core Version:    0.7.0.1
 */