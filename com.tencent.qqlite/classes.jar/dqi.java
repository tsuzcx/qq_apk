import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class dqi
  implements Runnable
{
  public dqi(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (UniformDownloadMgr.a(this.a))
    {
      Iterator localIterator = UniformDownloadMgr.a(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        dqj localdqj2 = (dqj)localIterator.next();
        if ((localdqj2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) && (localdqj2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b()) && (2 == localdqj2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.g())) {
          localArrayList.add(localdqj2);
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      dqj localdqj1 = (dqj)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> pauseSlienceRuningGenDownloadOfOldApp, url:[" + localdqj1.jdField_a_of_type_JavaLangString + "]");
      localdqj1.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.e();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dqi
 * JD-Core Version:    0.7.0.1
 */