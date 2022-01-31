import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class dqc
  implements Runnable
{
  public dqc(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (UniformDownloadMgr.a(this.a))
    {
      Iterator localIterator = UniformDownloadMgr.a(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        dqd localdqd2 = (dqd)localIterator.next();
        if ((localdqd2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) && (localdqd2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b()) && (2 == localdqd2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.g())) {
          localArrayList.add(localdqd2);
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      dqd localdqd1 = (dqd)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> pauseSlienceRuningGenDownloadOfOldApp, url:[" + localdqd1.jdField_a_of_type_JavaLangString + "]");
      localdqd1.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.e();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dqc
 * JD-Core Version:    0.7.0.1
 */