import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class fws
  implements Runnable
{
  public fws(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (UniformDownloadMgr.a(this.a))
    {
      Iterator localIterator = UniformDownloadMgr.a(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        fwu localfwu2 = (fwu)localIterator.next();
        if ((localfwu2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) && (localfwu2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b()) && (2 == localfwu2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.g())) {
          localArrayList.add(localfwu2);
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      fwu localfwu1 = (fwu)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> pauseSlienceRuningGenDownloadOfOldApp, url:[" + localfwu1.jdField_a_of_type_JavaLangString + "]");
      localfwu1.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.e();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fws
 * JD-Core Version:    0.7.0.1
 */