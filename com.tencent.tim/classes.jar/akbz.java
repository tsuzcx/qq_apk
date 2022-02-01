import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2.1;
import com.tencent.qphone.base.util.QLog;

public class akbz
  implements advm.a
{
  public akbz(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  public void ei(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAuthVideoPlayerFragment", 2, "onDownloadFinish  url:" + paramString + "   progress:" + paramInt);
    }
  }
  
  public void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAuthVideoPlayerFragment", 2, "onDownloadFinish  url:" + paramString + "   isSuccess:" + paramBoolean1 + "  isFileExist:" + paramBoolean2);
    }
    if ((this.this$0.isDetached()) || (this.this$0.getActivity() == null)) {
      return;
    }
    this.this$0.getActivity().runOnUiThread(new NearbyAuthVideoPlayerFragment.2.1(this, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbz
 * JD-Core Version:    0.7.0.1
 */