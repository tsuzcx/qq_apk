import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.nearby.profilecard.NearbyCardVoteView;
import java.util.List;

public class akcc
  extends Handler
{
  public akcc(NearbyCardVoteView paramNearbyCardVoteView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int j;
    if (paramMessage.what == NearbyCardVoteView.dml)
    {
      j = paramMessage.arg1;
      if (paramMessage.arg2 > 0)
      {
        i = 2;
        this.a.iU(j, i);
      }
    }
    while (paramMessage.what != NearbyCardVoteView.dmm) {
      for (;;)
      {
        return;
        i = 0;
      }
    }
    int m = paramMessage.arg1;
    int n = paramMessage.arg2;
    Object localObject = (List)paramMessage.obj;
    paramMessage = (Message)localObject;
    if (localObject != null)
    {
      paramMessage = (Message)localObject;
      if (n < ((List)localObject).size()) {
        paramMessage = ((List)localObject).subList(0, n);
      }
    }
    paramMessage = alem.bp(paramMessage);
    int i = 0;
    int k;
    if ((i < n) && (i < 20))
    {
      if ((paramMessage == null) || (i >= paramMessage.size())) {
        break label267;
      }
      k = (int)((TPraiseInfo)paramMessage.get(i)).uCustomId;
      j = ((TPraiseInfo)paramMessage.get(i)).iIsPayed;
    }
    for (;;)
    {
      localObject = this.a.mHandler.obtainMessage(NearbyCardVoteView.dml, k, j);
      this.a.mHandler.sendMessageDelayed((Message)localObject, (i + 2) * 500);
      i += 1;
      break;
      paramMessage = this.a.getContext().getSharedPreferences("nearby_card_reddot_num", 0).edit();
      paramMessage.putInt("voteNum", m);
      paramMessage.putInt("increaseNum", n);
      paramMessage.commit();
      return;
      label267:
      j = 0;
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcc
 * JD-Core Version:    0.7.0.1
 */