import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class wgs
  implements bdvw
{
  wgs(wgr paramwgr) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.jdField_a_of_type_Int == 3) {}
    wgv localwgv;
    do
    {
      do
      {
        return;
        localObject = ((bdvs)parambdwt.jdField_a_of_type_Bdws).a();
      } while ((localObject == null) || (!(localObject instanceof wgv)));
      localwgv = (wgv)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((wgv)localObject).jdField_a_of_type_JavaLangString);
      localwgv.jdField_b_of_type_Long = (System.currentTimeMillis() - localwgv.jdField_a_of_type_Long);
    } while (localwgv.jdField_a_of_type_Wgo == null);
    Object localObject = localwgv.jdField_a_of_type_Wgo;
    if (parambdwt.jdField_a_of_type_Int == 0) {}
    for (parambdwt = new ErrorMessage(0, "");; parambdwt = new ErrorMessage(parambdwt.b, parambdwt.jdField_a_of_type_JavaLangString))
    {
      ((wgo)localObject).a(localwgv, parambdwt);
      return;
    }
  }
  
  public void onUpdateProgeress(bdws arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.a();
    if ((??? != null) && ((??? instanceof wgv)))
    {
      wgv localwgv = (wgv)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            wgz localwgz = (wgz)((WeakReference)localIterator.next()).get();
            if (localwgz != null) {
              localwgz.a(localwgv.jdField_b_of_type_JavaLangString, localwgv.jdField_a_of_type_Int, i, localwgv);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgs
 * JD-Core Version:    0.7.0.1
 */