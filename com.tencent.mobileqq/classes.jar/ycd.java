import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.selectmember.TroopListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;

public class ycd
  extends ProtoUtils.TroopProtocolObserver
{
  public ycd(TroopListAdapter paramTroopListAdapter) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramInt != 0) || (paramArrayOfByte == null) || (localQQAppInterface == null)) {
      return;
    }
    ThreadManager.post(new yce(this, localQQAppInterface, paramArrayOfByte, paramBundle, new Handler(Looper.getMainLooper())), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycd
 * JD-Core Version:    0.7.0.1
 */