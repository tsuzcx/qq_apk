import android.app.Activity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;

public abstract interface ahuh
{
  public abstract void a(MessageRecord paramMessageRecord, Activity paramActivity);
  
  public abstract void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt);
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuh
 * JD-Core Version:    0.7.0.1
 */