import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class mnu
  extends kpi
{
  @Nullable
  private mns jdField_a_of_type_Mns;
  @NotNull
  private mnt jdField_a_of_type_Mnt;
  
  public mnu(@NotNull mnt parammnt, @Nullable mns parammns)
  {
    super(parammnt, true, "PublishTaskStep");
    this.jdField_a_of_type_Mnt = parammnt;
    this.jdField_a_of_type_Mns = parammns;
  }
  
  private void b(UgcVideo paramUgcVideo)
  {
    mns localmns;
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty()))
    {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
      if (this.jdField_a_of_type_Mns != null)
      {
        localmns = this.jdField_a_of_type_Mns;
        if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
          break label74;
        }
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localmns.a(4, bool, true, "");
      aFM();
      return;
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
      break;
    }
  }
  
  public boolean Ai()
  {
    return this.jdField_a_of_type_Mnt.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean Aj()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Mnt.a();
    Object localObject = localUgcVideo.title;
    String str = localUgcVideo.url;
    QLog.i("RIJUGC.PublishTaskStep", 1, "onStep: title=" + (String)localObject);
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      ((List)localObject).add(localUgcVideo);
      mmr.a((List)localObject, new mnv(this, localUgcVideo));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mnu
 * JD-Core Version:    0.7.0.1
 */