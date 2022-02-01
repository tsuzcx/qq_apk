import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class akca
  extends ajrw
{
  public akca(NearbyAuthVideoPlayerFragment paramNearbyAuthVideoPlayerFragment) {}
  
  protected void uR(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyAuthVideoPlayerFragment", 2, "onDeleteNearbyPeopleAuthVideo isSuccess:" + paramBoolean);
    }
    ((ajpj)this.this$0.getActivity().app.getManager(106)).go.put(this.this$0.getActivity().app.getCurrentAccountUin(), Integer.valueOf(1));
    if (paramBoolean) {
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akca
 * JD-Core Version:    0.7.0.1
 */