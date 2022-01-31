import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class gbf
  implements Runnable
{
  public gbf(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (UniformDownloadMgr.a(this.a))
    {
      Iterator localIterator = UniformDownloadMgr.a(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        gbh localgbh2 = (gbh)localIterator.next();
        if ((localgbh2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader != null) && (localgbh2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.b()) && (2 == localgbh2.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.g())) {
          localArrayList.add(localgbh2);
        }
      }
    }
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      gbh localgbh1 = (gbh)((Iterator)???).next();
      QLog.w("UniformDownloadMgr<FileAssistant>", 1, "[UniformDL] >>> pauseSlienceRuningGenDownloadOfOldApp, url:[" + localgbh1.jdField_a_of_type_JavaLangString + "]");
      localgbh1.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloader.e();
    }
    UniformDownloadMgr.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gbf
 * JD-Core Version:    0.7.0.1
 */