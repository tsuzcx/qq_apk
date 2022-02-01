import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;

class hni
  implements Runnable
{
  hni(hng paramhng, long paramLong1, long paramLong2, String paramString) {}
  
  public void run()
  {
    int i = (int)((float)this.jdField_a_of_type_Long * 100.0F / (float)this.b);
    DownloadInfo localDownloadInfo = this.jdField_a_of_type_Hng.a.c(this.jdField_a_of_type_JavaLangString, i);
    if (localDownloadInfo == null) {
      LogUtility.d(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskProgressChanged info == null");
    }
    for (;;)
    {
      this.jdField_a_of_type_Hng.a.a(2, localDownloadInfo);
      return;
      LogUtility.a(DownloadManager.jdField_a_of_type_JavaLangString, "OnDownloadSDKTaskProgressChanged info state=" + localDownloadInfo.a() + " progress=" + localDownloadInfo.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hni
 * JD-Core Version:    0.7.0.1
 */