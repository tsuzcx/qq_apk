import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PreloadDownloader;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class vmm
  implements INetEngine.INetEngineListener
{
  vmm(vml paramvml) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {}
    vmp localvmp;
    do
    {
      do
      {
        return;
        localObject = ((HttpNetReq)paramNetResp.mReq).getUserData();
      } while ((localObject == null) || (!(localObject instanceof vmp)));
      localvmp = (vmp)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((vmp)localObject).jdField_a_of_type_JavaLangString);
      localvmp.jdField_b_of_type_Long = (System.currentTimeMillis() - localvmp.jdField_a_of_type_Long);
    } while (localvmp.jdField_a_of_type_Vmi == null);
    Object localObject = localvmp.jdField_a_of_type_Vmi;
    if (paramNetResp.mResult == 0) {}
    for (paramNetResp = new ErrorMessage(0, "");; paramNetResp = new ErrorMessage(paramNetResp.mErrCode, paramNetResp.mErrDesc))
    {
      ((vmi)localObject).a(localvmp, paramNetResp);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof vmp)))
    {
      vmp localvmp = (vmp)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            vmt localvmt = (vmt)((WeakReference)localIterator.next()).get();
            if (localvmt != null) {
              localvmt.a(localvmp.jdField_b_of_type_JavaLangString, localvmp.jdField_a_of_type_Int, i, localvmp);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */