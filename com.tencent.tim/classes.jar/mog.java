import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class mog
  extends kpi
{
  @Nullable
  private mns jdField_a_of_type_Mns;
  @NotNull
  private mnt jdField_a_of_type_Mnt;
  @NotNull
  private mnw jdField_a_of_type_Mnw;
  @NotNull
  private mqn jdField_a_of_type_Mqn;
  private volatile boolean isRunning;
  
  public mog(QQAppInterface paramQQAppInterface, @NotNull mnt parammnt, @Nullable mns parammns, @NotNull mqn parammqn)
  {
    super(parammnt, true, "UploadVideoTaskStep");
    this.jdField_a_of_type_Mnw = ((mnw)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Mnt = parammnt;
    this.jdField_a_of_type_Mns = parammns;
    this.jdField_a_of_type_Mqn = parammqn;
  }
  
  private void aQL()
  {
    this.isRunning = false;
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "pauseUpload, ugcVideo.status=" + localUgcVideo.status);
    if ((localUgcVideo.status == UgcVideo.STATUS_UPLOADING) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE))
    {
      if (!TextUtils.isEmpty(localUgcVideo.videoUploadKey)) {
        this.jdField_a_of_type_Mqn.pause();
      }
    }
    else {
      return;
    }
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "videoUploadKey is Empty");
  }
  
  public boolean Ai()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    String str2 = localUgcVideo.compressPath;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if ((localUgcVideo.url.length() == 0) && (new File(str1).exists()) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {}
    for (int i = 1; (super.Ai()) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public boolean Aj()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    String str1 = localUgcVideo.compressPath;
    String str2;
    if ((!this.isRunning) && (!TextUtils.isEmpty(str1)))
    {
      this.isRunning = true;
      this.jdField_a_of_type_Mnt.a().status = UgcVideo.STATUS_UPLOADING;
      QLog.i("RIJUGC.UploadVideoTaskStep", 1, "onStep begin upload video, filePath=" + str1);
      localUgcVideo.startUploadingTime = System.currentTimeMillis();
      if (localUgcVideo.startUserWaitingTime > 0L) {
        localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      }
      this.jdField_a_of_type_Mnw.f(localUgcVideo);
      str2 = localUgcVideo.videoUploadKey;
      localUgcVideo.lastUploadSizeUpdateTime = System.currentTimeMillis();
      moh localmoh = new moh(this, localUgcVideo);
      this.jdField_a_of_type_Mqn.a(localmoh);
      if (!TextUtils.isEmpty(str2)) {
        break label161;
      }
      this.jdField_a_of_type_Mqn.nL(str1);
    }
    for (;;)
    {
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_UPLOADING_VIDEO;
      return false;
      label161:
      this.jdField_a_of_type_Mqn.nM(str2);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Mnt.a().lastUploadSizeUpdateTime = 0L;
    aQL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mog
 * JD-Core Version:    0.7.0.1
 */