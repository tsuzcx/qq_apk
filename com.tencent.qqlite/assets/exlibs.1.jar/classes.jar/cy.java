import com.dataline.mpfile.MpfileFileListDownloader;
import com.dataline.mpfile.MpfileFileListDownloader.MpFileHttpDownloadListener;

public final class cy
  implements Runnable
{
  public cy(String paramString, MpfileFileListDownloader.MpFileHttpDownloadListener paramMpFileHttpDownloadListener, int paramInt) {}
  
  public void run()
  {
    String str = MpfileFileListDownloader.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComDatalineMpfileMpfileFileListDownloader$MpFileHttpDownloadListener != null)
    {
      if ((str != null) && (str.length() > 0)) {
        this.jdField_a_of_type_ComDatalineMpfileMpfileFileListDownloader$MpFileHttpDownloadListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, str);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComDatalineMpfileMpfileFileListDownloader$MpFileHttpDownloadListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cy
 * JD-Core Version:    0.7.0.1
 */