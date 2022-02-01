import android.os.Handler;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserMiniAIOHelper.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class agql
  implements Observer
{
  private View CP;
  private String bIV;
  private QQAppInterface mApp;
  
  public agql(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.bIV = paramString;
  }
  
  public void djl()
  {
    if (this.CP != null) {
      this.CP.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    if (this.mApp.b() != null) {
      this.mApp.b().deleteObserver(this);
    }
  }
  
  public void onPause()
  {
    if (this.mApp.b() != null) {
      this.mApp.b().deleteObserver(this);
    }
  }
  
  public void onResume()
  {
    if (this.mApp.b() != null) {
      this.mApp.b().addObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((!(paramObject instanceof MessageRecord)) || (!(paramObject instanceof ChatMessage)));
        paramObservable = (MessageRecord)paramObject;
      } while (!QLog.isColorLevel());
      QLog.d("FileBrowserMiniAIOHelper<QFile>", 2, "recv: msgseq[" + paramObservable.msgseq + "] uin[" + paramObservable.frienduin + "]");
    } while (!paramObservable.frienduin.equals(this.bIV));
    ThreadManagerV2.getUIHandlerV2().post(new FileBrowserMiniAIOHelper.1(this));
  }
  
  public void z(View paramView)
  {
    this.CP = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agql
 * JD-Core Version:    0.7.0.1
 */