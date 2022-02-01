import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class moe
  extends kpi
{
  @Nullable
  private mns jdField_a_of_type_Mns;
  @NotNull
  private mnt jdField_a_of_type_Mnt;
  @NotNull
  private mnw jdField_a_of_type_Mnw;
  private QQAppInterface app;
  private mql b;
  private volatile boolean isRunning;
  private String uploadPath = "";
  
  public moe(@NotNull QQAppInterface paramQQAppInterface, @NotNull mnt parammnt, @Nullable mns parammns)
  {
    super(parammnt, true, "UploadCoverTaskStep");
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Mnw = ((mnw)paramQQAppInterface.getManager(356));
    this.jdField_a_of_type_Mnt = parammnt;
    this.jdField_a_of_type_Mns = parammns;
  }
  
  public boolean Ai()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    if (!TextUtils.isEmpty(localUgcVideo.coverUrl))
    {
      i = 1;
      if (i != 0) {
        localUgcVideo.coverProgress = 100;
      }
      if ((i != 0) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((!super.Ai()) || (i == 0)) {
        break label69;
      }
      return true;
      i = 0;
      break;
    }
    label69:
    return false;
  }
  
  public boolean Aj()
  {
    Object localObject = this.jdField_a_of_type_Mnt.a();
    if (((UgcVideo)localObject).coverPath != null) {}
    for (String str = ((UgcVideo)localObject).coverPath;; str = "")
    {
      if ((!this.isRunning) || (!TextUtils.equals(this.uploadPath, str)))
      {
        this.isRunning = true;
        this.uploadPath = str;
        QLog.i("RIJUGC.UploadCoverTaskStep", 1, "onStep begin upload cover:" + str);
        localObject = new mof(this, (UgcVideo)localObject);
        if (this.b != null) {
          this.b.cancel();
        }
        this.b = new mqo(BaseApplicationImpl.getContext(), this.app, str);
        this.b.a((mqk)localObject);
        this.b.upload();
      }
      return false;
    }
  }
  
  public void onStop()
  {
    super.onStop();
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    if ((this.b != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.b.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moe
 * JD-Core Version:    0.7.0.1
 */