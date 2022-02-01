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

class wbh
  implements INetEngine.INetEngineListener
{
  wbh(wbg paramwbg) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {}
    wbk localwbk;
    do
    {
      do
      {
        return;
        localObject = ((HttpNetReq)paramNetResp.mReq).getUserData();
      } while ((localObject == null) || (!(localObject instanceof wbk)));
      localwbk = (wbk)localObject;
      this.a.a.jdField_a_of_type_JavaUtilMap.remove(((wbk)localObject).jdField_a_of_type_JavaLangString);
      localwbk.jdField_b_of_type_Long = (System.currentTimeMillis() - localwbk.jdField_a_of_type_Long);
    } while (localwbk.jdField_a_of_type_Wbd == null);
    Object localObject = localwbk.jdField_a_of_type_Wbd;
    if (paramNetResp.mResult == 0) {}
    for (paramNetResp = new ErrorMessage(0, "");; paramNetResp = new ErrorMessage(paramNetResp.mErrCode, paramNetResp.mErrDesc))
    {
      ((wbd)localObject).a(localwbk, paramNetResp);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    ??? = ???.getUserData();
    if ((??? != null) && ((??? instanceof wbk)))
    {
      wbk localwbk = (wbk)???;
      int i = (int)(paramLong1 / paramLong2 * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        if (this.a.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            wbo localwbo = (wbo)((WeakReference)localIterator.next()).get();
            if (localwbo != null) {
              localwbo.a(localwbk.jdField_b_of_type_JavaLangString, localwbk.jdField_a_of_type_Int, i, localwbk);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbh
 * JD-Core Version:    0.7.0.1
 */