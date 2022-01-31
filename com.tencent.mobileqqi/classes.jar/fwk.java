import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.ThumbDownLoader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class fwk
  extends FileTransferObserver
{
  public fwk(ThumbDownLoader paramThumbDownLoader) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String arg4, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    QLog.i("ThumbDownLoader<FileAssistant>", 2, "OnDiscDownloadInfo, taskid[" + String.valueOf(paramLong2) + "]");
    synchronized (ThumbDownLoader.a(this.a))
    {
      paramString2 = (fwl)ThumbDownLoader.a(this.a).get(Long.valueOf(paramLong2));
      if (paramString2 == null)
      {
        QLog.e("ThumbDownLoader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
        FileManagerUtil.a(this.a.a, 0L, "actFileDiscThumb", 0L, "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
        FileManagerUtil.a(this.a.a, 0L, "actFileDiscThumbDetail", 0L, "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
        this.a.a(null);
        return;
      }
    }
    if (!paramBoolean)
    {
      QLog.e("ThumbDownLoader<FileAssistant>", 1, "OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(???) + "]");
      if (paramLong1 == -100001L) {
        paramLong2 = 9043L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_Long, "actFileDiscThumb", paramString2.e, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_Long, "actFileDiscThumbDetail", paramString2.e, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
        synchronized (ThumbDownLoader.a(this.a))
        {
          ThumbDownLoader.a(this.a).remove(Long.valueOf(paramString2.jdField_d_of_type_Long));
          this.a.a(null);
          return;
          paramLong2 = 9045L;
        }
      }
    }
    if ((paramString3 == null) || (paramString3.length() == 0))
    {
      QLog.i("ThumbDownLoader<FileAssistant>", 1, "id[" + String.valueOf(paramString2.jdField_a_of_type_Long) + "] get DiscdownLoad info Url is null,retCode[" + String.valueOf(paramLong1) + "]");
      this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      if (paramLong1 == 0L) {
        paramLong2 = 9048L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_Long, "actFileDiscThumb", paramString2.e, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_Long, "actFileDiscThumbDetail", paramString2.e, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        synchronized (ThumbDownLoader.a(this.a))
        {
          ThumbDownLoader.a(this.a).remove(Long.valueOf(paramString2.jdField_d_of_type_Long));
          this.a.a(null);
          return;
          paramLong2 = paramLong1;
        }
      }
    }
    paramString2.jdField_d_of_type_JavaLangString = paramString5;
    ??? = "http://" + paramString3 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString4;
    switch (paramString2.jdField_a_of_type_Int)
    {
    default: 
      QLog.e("ThumbDownLoader<FileAssistant>", 2, "unknow thumbSize!!!info:" + paramString2.toString());
      this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_Long, "actFileDiscThumb", paramString2.e, ???, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, 9005L, "size error", 0L, 0L, 0L, ???, "", 0, "size error", "");
      FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_Long, "actFileDiscThumbDetail", paramString2.e, ???, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, 9005L, "size error", 0L, 0L, 0L, ???, "", 0, "size error", "");
    }
    synchronized (ThumbDownLoader.a(this.a))
    {
      ThumbDownLoader.a(this.a).remove(Long.valueOf(paramString2.jdField_d_of_type_Long));
      this.a.a(null);
      return;
      paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=16*16");
      for (;;)
      {
        QLog.e("ThumbDownLoader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is find taskid[" + String.valueOf(paramLong2) + "]taskid[" + String.valueOf(paramLong2) + "]info.strUrl[" + String.valueOf(???) + "]strCookie[" + String.valueOf(paramString5) + "]");
        ThumbDownLoader.a(this.a, paramString2, paramLong2);
        return;
        paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=32*32");
        continue;
        paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=64*64");
        continue;
        paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=128*128");
        continue;
        paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=320*320");
        continue;
        paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=640*640");
      }
      paramString2.jdField_a_of_type_JavaLangString = (??? + "?pictype=scaled" + "&size=1024*1024");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwk
 * JD-Core Version:    0.7.0.1
 */