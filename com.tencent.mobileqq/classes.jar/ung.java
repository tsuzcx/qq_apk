import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ung
  implements baug
{
  ung(unf paramunf) {}
  
  public void onResp(bavf parambavf)
  {
    if (parambavf.jdField_a_of_type_Int == 3) {}
    unj localunj;
    do
    {
      do
      {
        return;
        localObject = ((baub)parambavf.jdField_a_of_type_Bave).a();
      } while ((localObject == null) || (!(localObject instanceof unj)));
      localunj = (unj)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((unj)localObject).jdField_a_of_type_JavaLangString);
      localunj.jdField_b_of_type_Long = (System.currentTimeMillis() - localunj.jdField_a_of_type_Long);
    } while (localunj.jdField_a_of_type_Unc == null);
    Object localObject = localunj.jdField_a_of_type_Unc;
    if (parambavf.jdField_a_of_type_Int == 0) {}
    for (parambavf = new ErrorMessage(0, "");; parambavf = new ErrorMessage(parambavf.b, parambavf.jdField_a_of_type_JavaLangString))
    {
      ((unc)localObject).a(localunj, parambavf);
      return;
    }
  }
  
  public void onUpdateProgeress(bave arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof unj)))
    {
      unj localunj = (unj)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            unn localunn = (unn)((WeakReference)localIterator.next()).get();
            if (localunn != null) {
              localunn.a(localunj.jdField_b_of_type_JavaLangString, localunj.jdField_a_of_type_Int, i, localunj);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ung
 * JD-Core Version:    0.7.0.1
 */