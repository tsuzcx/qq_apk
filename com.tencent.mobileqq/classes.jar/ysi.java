import com.tencent.mobileqq.apollo.tmg_opensdk.TMG_DownloadInfo;
import com.tencent.mobileqq.apollo.tmg_opensdk.TMG_Downloader;
import com.tencent.mobileqq.apollo.tmg_opensdk.TMG_Downloader.TMG_Downloader_DownloadEvent;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ysi
  implements INetEngine.INetEngineListener
{
  ysi(ysh paramysh, String paramString, TMG_DownloadInfo paramTMG_DownloadInfo) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent != null) {
        this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent.a(i);
      }
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
    if (this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.jdField_a_of_type_JavaLangString, Integer.valueOf(paramNetResp.jdField_a_of_type_Int), Integer.valueOf(paramNetResp.c), this.jdField_a_of_type_JavaLangString }));
    }
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      paramNetResp = new File(localHttpNetReq.c);
      if (!paramNetResp.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          paramNetResp = paramNetResp.getParent();
          FileUtils.a(localHttpNetReq.c, paramNetResp, false);
          TMG_Downloader.a(this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_DownloadInfo.b);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent != null)
          {
            this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent.a(100);
            this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent.a(0, "Download Complete!!!");
          }
          this.jdField_a_of_type_Ysh.jdField_a_of_type_Boolean = false;
          return;
        }
        catch (Exception paramNetResp)
        {
          paramNetResp.printStackTrace();
        }
        int i = 0;
      }
    } while (this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent == null);
    this.jdField_a_of_type_Ysh.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkTMG_Downloader$TMG_Downloader_DownloadEvent.a(2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysi
 * JD-Core Version:    0.7.0.1
 */