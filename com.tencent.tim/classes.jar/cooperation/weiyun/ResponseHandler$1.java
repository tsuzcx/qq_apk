package cooperation.weiyun;

import ahwa;
import ahwb;
import anaz;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public final class ResponseHandler$1
  implements Runnable
{
  public ResponseHandler$1(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    ahwa localahwa = new ahwa(this.SO, this.aem, this.val$message, this.bUS, -5023, 2424833, anaz.gQ());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", this.cRU);
    localahwa.addHightlightItem(this.val$index, this.val$index + this.cjX.length(), (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.val$app, localahwa);
    ahwb.a(this.val$app, (MessageForUniteGrayTip)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.weiyun.ResponseHandler.1
 * JD-Core Version:    0.7.0.1
 */