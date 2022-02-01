import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class wkn
  implements beuq
{
  wkn(wkm paramwkm) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.jdField_a_of_type_Int == 3) {}
    wkq localwkq;
    do
    {
      do
      {
        return;
        localObject = ((beum)parambevm.jdField_a_of_type_Bevl).a();
      } while ((localObject == null) || (!(localObject instanceof wkq)));
      localwkq = (wkq)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((wkq)localObject).jdField_a_of_type_JavaLangString);
      localwkq.jdField_b_of_type_Long = (System.currentTimeMillis() - localwkq.jdField_a_of_type_Long);
    } while (localwkq.jdField_a_of_type_Wkj == null);
    Object localObject = localwkq.jdField_a_of_type_Wkj;
    if (parambevm.jdField_a_of_type_Int == 0) {}
    for (parambevm = new ErrorMessage(0, "");; parambevm = new ErrorMessage(parambevm.b, parambevm.jdField_a_of_type_JavaLangString))
    {
      ((wkj)localObject).a(localwkq, parambevm);
      return;
    }
  }
  
  public void onUpdateProgeress(bevl arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof wkq)))
    {
      wkq localwkq = (wkq)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            wku localwku = (wku)((WeakReference)localIterator.next()).get();
            if (localwku != null) {
              localwku.a(localwkq.jdField_b_of_type_JavaLangString, localwkq.jdField_a_of_type_Int, i, localwkq);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkn
 * JD-Core Version:    0.7.0.1
 */