import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class mrt<T>
  implements VideoPreDownloadMgr.a
{
  public boolean Ea()
  {
    return false;
  }
  
  public boolean Eb()
  {
    return naa.a().b(a());
  }
  
  protected abstract VideoPreDownloadMgr.b a(T paramT);
  
  public List<VideoPreDownloadMgr.b> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = be();
      int i = paramInt;
      if (Ea()) {
        i = paramInt - 1;
      }
      a(i, paramBoolean, localList, localArrayList);
      b(i, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
  
  protected abstract myi a();
  
  protected void a(int paramInt, boolean paramBoolean, List<T> paramList, List<VideoPreDownloadMgr.b> paramList1)
  {
    int j = paramInt + 1;
    int i = 0;
    int k = 0;
    paramList1.size();
    if (j < paramList.size())
    {
      int m = Math.min(naa.a().t(getScene(), paramInt) + paramInt, paramList.size() - 1);
      paramInt = k;
      for (;;)
      {
        i = paramInt;
        if (j > m) {
          break;
        }
        paramList1.add(a(paramList.get(j)));
        j += 1;
        paramInt += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DefaultVideoPreDownloadController", 2, "scroll to next = " + paramBoolean + " preDownload to forward = " + i);
    }
  }
  
  protected void b(int paramInt, boolean paramBoolean, List<T> paramList, List<VideoPreDownloadMgr.b> paramList1)
  {
    int i = 0;
    int k = 0;
    int j = paramInt - 1;
    paramList1.size();
    if (j >= 0)
    {
      int m = Math.max(paramInt - naa.a().qj(), 0);
      paramInt = k;
      for (;;)
      {
        i = paramInt;
        if (j < m) {
          break;
        }
        paramList1.add(a(paramList.get(j)));
        j -= 1;
        paramInt += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DefaultVideoPreDownloadController", 2, "scroll to next = " + paramBoolean + " preDownload to backward = " + i);
    }
  }
  
  protected abstract List<T> be();
  
  protected abstract String getScene();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrt
 * JD-Core Version:    0.7.0.1
 */