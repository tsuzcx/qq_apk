import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class mnq
  extends kpi
{
  @Nullable
  private mns jdField_a_of_type_Mns;
  @NotNull
  private mnt jdField_a_of_type_Mnt;
  @NotNull
  private mnw jdField_a_of_type_Mnw;
  @Nullable
  private ncf jdField_a_of_type_Ncf;
  private volatile boolean isPause;
  private volatile boolean isRunning;
  
  public mnq(@NotNull QQAppInterface paramQQAppInterface, @NotNull mnt parammnt, @Nullable mns parammns)
  {
    super(parammnt, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_Mnw = ((mnw)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Mnt = parammnt;
    this.jdField_a_of_type_Mns = parammns;
  }
  
  public boolean Ai()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    int j;
    label72:
    String str;
    label113:
    long l;
    if ((localUgcVideo.compressPath != null) && (!localUgcVideo.compressPath.isEmpty()) && (new File(localUgcVideo.compressPath).exists()))
    {
      i = 1;
      if (i != 0) {
        localUgcVideo.compressProgress = 100;
      }
      if (localUgcVideo.retryTime < UgcVideo.RETRY_TIME_LIMIT) {
        break label196;
      }
      j = 1;
      if (j != 0)
      {
        str = localUgcVideo.filePath;
        File localFile = new File(str);
        localUgcVideo.compressPath = str;
        str = obc.getFileMd5(localFile);
        if (str == null) {
          break label201;
        }
        localUgcVideo.fileMd5 = str;
        if (!localFile.exists()) {
          break label208;
        }
        l = localFile.length();
        label134:
        localUgcVideo.fileSize = l;
      }
      if ((i != 0) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE) || (j != 0)) {
        break label213;
      }
    }
    label196:
    label201:
    label208:
    label213:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.isPause = false;
        localUgcVideo.startCompressTime = System.currentTimeMillis();
      }
      if ((!super.Ai()) || (i == 0)) {
        break label218;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label72;
      str = "";
      break label113;
      l = 0L;
      break label134;
    }
    label218:
    return false;
  }
  
  public boolean Aj()
  {
    if (!this.isRunning)
    {
      this.isRunning = true;
      UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
      this.jdField_a_of_type_Ncf = new ncf(BaseApplicationImpl.getContext(), new mnr(this, localUgcVideo));
      this.jdField_a_of_type_Ncf.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
  
  public void onStop()
  {
    super.onStop();
    this.isPause = true;
    if (this.jdField_a_of_type_Ncf != null) {
      this.jdField_a_of_type_Ncf.stopTask();
    }
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    localUgcVideo.status = UgcVideo.STATUS_PAUSE;
    this.jdField_a_of_type_Mnw.f(localUgcVideo);
    if (this.jdField_a_of_type_Mns != null) {
      this.jdField_a_of_type_Mns.a(1, true, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnq
 * JD-Core Version:    0.7.0.1
 */