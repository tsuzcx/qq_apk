import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class vmk
  implements bbrr
{
  vmk(vmj paramvmj, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, bbrl parambbrl)
  {
    vmp localvmp;
    if (parambbrl.jdField_a_of_type_Int == 0)
    {
      parambbrl = (aycy)parambbrl.jdField_a_of_type_JavaLangObject;
      localvmp = (vmp)this.jdField_a_of_type_Vmj.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localvmp != null)
      {
        if (!new File(parambbrl.b).exists()) {
          break label99;
        }
        localvmp.b = (System.currentTimeMillis() - localvmp.jdField_a_of_type_Long);
        if (localvmp.jdField_a_of_type_Vmi != null) {
          localvmp.jdField_a_of_type_Vmi.a(localvmp, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        xvv.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        xvv.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(parambbrl.jdField_a_of_type_Int) });
        localvmp = (vmp)this.jdField_a_of_type_Vmj.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localvmp == null);
      localvmp.b = (System.currentTimeMillis() - localvmp.jdField_a_of_type_Long);
    } while (localvmp.jdField_a_of_type_Vmi == null);
    localvmp.jdField_a_of_type_Vmi.a(localvmp, new ErrorMessage(parambbrl.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<bbrl> paramArrayList) {}
  
  public void b(int paramInt, bbrl parambbrl) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmk
 * JD-Core Version:    0.7.0.1
 */