import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public class jss
{
  private static jss jdField_a_of_type_Jss;
  private static Rect au = new Rect();
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  public boolean aby;
  public boolean abz = true;
  private QQAppInterface mApp;
  private Context mContext;
  private SessionInfo mSessionInfo;
  Handler mUiHandler = new jst(this, Looper.getMainLooper());
  
  public static jss a()
  {
    if (jdField_a_of_type_Jss == null) {}
    try
    {
      if (jdField_a_of_type_Jss == null) {
        jdField_a_of_type_Jss = new jss();
      }
      return jdField_a_of_type_Jss;
    }
    finally {}
  }
  
  private void azl() {}
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, SessionInfo paramSessionInfo)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.mContext = this.jdField_a_of_type_ComTencentWidgetAbsListView.getContext();
    this.mSessionInfo = paramSessionInfo;
  }
  
  public void azk()
  {
    this.mUiHandler.removeMessages(1);
    this.mUiHandler.sendEmptyMessageDelayed(1, 200L);
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "#requestPlayCheck():# ");
    }
  }
  
  public void azm() {}
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = null;
    this.abz = true;
    this.mContext = null;
    this.mApp = null;
    this.aby = false;
    this.mSessionInfo = null;
  }
  
  public void e(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.abz = true;
      azl();
      return;
    }
    this.abz = false;
  }
  
  public void eg(long paramLong) {}
  
  public void onNetWifi2Mobile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoController", 2, "onNetWifi2Mobile(): ====>");
    }
    if ((this.mApp == null) || (this.jdField_a_of_type_ComTencentWidgetAbsListView == null) || (this.mContext == null)) {}
    while (!this.mApp.b().Op()) {
      return;
    }
    this.mUiHandler.removeMessages(2);
    this.mUiHandler.sendEmptyMessage(2);
    azm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jss
 * JD-Core Version:    0.7.0.1
 */