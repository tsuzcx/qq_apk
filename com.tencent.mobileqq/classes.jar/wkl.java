import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class wkl
  implements bcyi
{
  wkl(wkk paramwkk, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, bcyb parambcyb)
  {
    wkq localwkq;
    if (parambcyb.jdField_a_of_type_Int == 0)
    {
      parambcyb = (azpq)parambcyb.jdField_a_of_type_JavaLangObject;
      localwkq = (wkq)this.jdField_a_of_type_Wkk.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localwkq != null)
      {
        if (!new File(parambcyb.b).exists()) {
          break label99;
        }
        localwkq.b = (System.currentTimeMillis() - localwkq.jdField_a_of_type_Long);
        if (localwkq.jdField_a_of_type_Wkj != null) {
          localwkq.jdField_a_of_type_Wkj.a(localwkq, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        yuk.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        yuk.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(parambcyb.jdField_a_of_type_Int) });
        localwkq = (wkq)this.jdField_a_of_type_Wkk.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localwkq == null);
      localwkq.b = (System.currentTimeMillis() - localwkq.jdField_a_of_type_Long);
    } while (localwkq.jdField_a_of_type_Wkj == null);
    localwkq.jdField_a_of_type_Wkj.a(localwkq, new ErrorMessage(parambcyb.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<bcyb> paramArrayList) {}
  
  public void b(int paramInt, bcyb parambcyb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkl
 * JD-Core Version:    0.7.0.1
 */