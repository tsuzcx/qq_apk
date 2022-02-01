import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

class wgq
  implements bcfq
{
  wgq(wgp paramwgp, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, bcfj parambcfj)
  {
    wgv localwgv;
    if (parambcfj.jdField_a_of_type_Int == 0)
    {
      parambcfj = (ayxd)parambcfj.jdField_a_of_type_JavaLangObject;
      localwgv = (wgv)this.jdField_a_of_type_Wgp.a.a.remove(this.jdField_a_of_type_JavaLangString);
      if (localwgv != null)
      {
        if (!new File(parambcfj.b).exists()) {
          break label99;
        }
        localwgv.b = (System.currentTimeMillis() - localwgv.jdField_a_of_type_Long);
        if (localwgv.jdField_a_of_type_Wgo != null) {
          localwgv.jdField_a_of_type_Wgo.a(localwgv, new ErrorMessage(0, "onDownload"));
        }
      }
    }
    label99:
    do
    {
      do
      {
        return;
        yqp.d("AsyncFileDownloader", "preload success , why file not exist , key : %s", new Object[] { this.jdField_a_of_type_JavaLangString });
        return;
        yqp.d("AsyncFileDownloader", "onPreLoadFailed,key=%s,errorCode=%s", new Object[] { this.jdField_a_of_type_JavaLangString, String.valueOf(parambcfj.jdField_a_of_type_Int) });
        localwgv = (wgv)this.jdField_a_of_type_Wgp.a.a.remove(this.jdField_a_of_type_JavaLangString);
      } while (localwgv == null);
      localwgv.b = (System.currentTimeMillis() - localwgv.jdField_a_of_type_Long);
    } while (localwgv.jdField_a_of_type_Wgo == null);
    localwgv.jdField_a_of_type_Wgo.a(localwgv, new ErrorMessage(parambcfj.jdField_a_of_type_Int, "onFailed"));
  }
  
  public void a(int paramInt, ArrayList<bcfj> paramArrayList) {}
  
  public void b(int paramInt, bcfj parambcfj) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgq
 * JD-Core Version:    0.7.0.1
 */