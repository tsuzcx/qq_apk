import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.qphone.base.util.QLog;

public class mml
  implements mix.a
{
  public mml(EditVideoFragment paramEditVideoFragment) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      mnw.a(EditVideoFragment.a(this.a)).a(EditVideoFragment.a(this.a), true);
    }
    QLog.i("RIJUGC.EditVideoFragment", 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mml
 * JD-Core Version:    0.7.0.1
 */