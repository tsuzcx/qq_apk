import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.10.1;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment.a;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;

public class zyt
  implements PreloadManager.d
{
  public zyt(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      RedPacketKSongFragment.a locala = new RedPacketKSongFragment.a();
      locala.bby = (paramPathResult.folderPath + "/" + "original.mp3");
      locala.bbz = (paramPathResult.folderPath + "/" + "accompany.mp3");
      locala.bbA = (paramPathResult.folderPath + "/" + "lyrics.qrc");
      locala.bbB = (paramPathResult.folderPath + "/" + "config.cfg");
      RedPacketKSongFragment.a(this.this$0, locala);
      if (this.this$0.isFinish()) {
        return;
      }
      this.this$0.getActivity().runOnUiThread(new RedPacketKSongFragment.10.1(this));
      return;
    }
    this.this$0.csK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyt
 * JD-Core Version:    0.7.0.1
 */