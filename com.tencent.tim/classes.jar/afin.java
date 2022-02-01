import android.text.TextUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class afin
  extends aquy
{
  afin(afim paramafim, File paramFile, CustomEmotionData paramCustomEmotionData, afhu paramafhu, List paramList1, IPicDownloadListener paramIPicDownloadListener, List paramList2, EntityManager paramEntityManager, VipComicFavorEmoStructMsgInfo paramVipComicFavorEmoStructMsgInfo, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if ((paramaquz.getStatus() == 3) && (paramaquz.errCode == 0) && (this.val$file.exists()))
    {
      this.b.emoPath = this.val$file.getAbsolutePath();
      if ("needDownload".equals(this.b.RomaingType)) {
        this.b.RomaingType = "isUpdate";
      }
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(this.b.emoPath)))
      {
        paramaquz = SecUtil.getFileMd5(this.b.emoPath);
        if (!this.b.md5.equals(paramaquz)) {
          QLog.i("VipComicMqqManager", 2, "init = " + this.b.md5 + " , compute = " + paramaquz);
        }
      }
      this.val$fdb.b(this.b);
      this.xu.add(this.b);
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onFileDone(this.b, true);
      }
    }
    for (;;)
    {
      this.aT.getAndIncrement();
      if ((this.aT.get() == this.aU.get()) && (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null)) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onDone(this.xu, this.xv);
      }
      return;
      this.xv.add(this.b);
      this.val$fdb.a(this.b);
      this.val$entityManager.remove(this.jdField_a_of_type_ComTencentMobileqqDataVipComicFavorEmoStructMsgInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIPicDownloadListener.onFileDone(this.b, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afin
 * JD-Core Version:    0.7.0.1
 */