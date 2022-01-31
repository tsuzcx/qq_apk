import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class uix
  implements bapx
{
  uix(uiw paramuiw) {}
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw.jdField_a_of_type_Int == 3) {}
    uja localuja;
    do
    {
      do
      {
        return;
        localObject = ((baps)parambaqw.jdField_a_of_type_Baqv).a();
      } while ((localObject == null) || (!(localObject instanceof uja)));
      localuja = (uja)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((uja)localObject).jdField_a_of_type_JavaLangString);
      localuja.jdField_b_of_type_Long = (System.currentTimeMillis() - localuja.jdField_a_of_type_Long);
    } while (localuja.jdField_a_of_type_Uit == null);
    Object localObject = localuja.jdField_a_of_type_Uit;
    if (parambaqw.jdField_a_of_type_Int == 0) {}
    for (parambaqw = new ErrorMessage(0, "");; parambaqw = new ErrorMessage(parambaqw.b, parambaqw.jdField_a_of_type_JavaLangString))
    {
      ((uit)localObject).a(localuja, parambaqw);
      return;
    }
  }
  
  public void onUpdateProgeress(baqv arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof uja)))
    {
      uja localuja = (uja)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            uje localuje = (uje)((WeakReference)localIterator.next()).get();
            if (localuje != null) {
              localuje.a(localuja.jdField_b_of_type_JavaLangString, localuja.jdField_a_of_type_Int, i, localuja);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uix
 * JD-Core Version:    0.7.0.1
 */