import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class ymn
  implements Handler.Callback
{
  acnd a;
  public arhz a;
  private String aLX;
  public WeakReference<BaseActivity> ai;
  public int bZX;
  private acfd c = new ymo(this);
  private final auru e = new auru(Looper.getMainLooper(), this);
  public QQAppInterface mApp;
  private String mUin;
  private int mUinType;
  
  public ymn(BaseActivity paramBaseActivity, int paramInt)
  {
    this.jdField_a_of_type_Acnd = new ymp(this);
    this.ai = new WeakReference(paramBaseActivity);
    this.bZX = paramInt;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)localAppRuntime);
    }
    paramBaseActivity = paramBaseActivity.getIntent();
    this.mUinType = paramBaseActivity.getIntExtra("uintype", -1);
    this.mUin = paramBaseActivity.getStringExtra("uin");
  }
  
  public void b(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.ai.get();
    if (localBaseActivity == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    String str = " ";
    if (this.mUinType == 0) {}
    for (str = aqgv.t(this.mApp, this.mUin);; str = this.aLX) {
      do
      {
        paramMap = ujt.a(localBaseActivity, str, paramArrayList, paramMap, true);
        if (paramMap == null) {
          break;
        }
        paramMap.mMsg_A_ActionData = null;
        paramArrayList = new Intent();
        paramArrayList.putExtra("forward_type", -3);
        paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
        paramArrayList.putExtra("is_need_show_sources", false);
        paramArrayList.putExtra("forward_msg_from_together", 1);
        paramArrayList.putExtra("forwardDirect", true);
        ahgq.f(localBaseActivity, paramArrayList, this.bZX);
        return;
      } while ((this.mUinType != 1) && (this.mUinType != 3000));
    }
  }
  
  public void cy(Intent paramIntent)
  {
    if (anre.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.aTl = paramIntent.getStringExtra("uin");
    localSessionInfo.troopUin = paramIntent.getStringExtra("troop_uin");
    paramIntent = ajlc.a();
    paramIntent.a(this.mApp, localSessionInfo, paramIntent.xL);
  }
  
  public void gG(List<ChatMessage> paramList)
  {
    Object localObject = (BaseActivity)this.ai.get();
    if (localObject == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = ajlg.a(this.mApp, (ArrayList)paramList);
    ajlc.a().lx(paramList);
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    }
    this.jdField_a_of_type_Arhz.setMessage(2131700604);
    this.jdField_a_of_type_Arhz.show();
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if (!localArrayList.contains(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage.senderuin);
      }
    }
    ajlc.a().xL.clear();
    ajlc.a().xL.addAll(paramList);
    if (this.mUinType == 1) {
      ((acms)this.mApp.getBusinessHandler(20)).a(this.mUin, localArrayList, false, null);
    }
    for (;;)
    {
      paramList = this.e.obtainMessage(1);
      paramList.arg1 = localArrayList.size();
      this.e.sendMessageDelayed(paramList, 30000L);
      return;
      if ((this.mUinType == 0) || (this.mUinType == 3000)) {
        ((FriendListHandler)this.mApp.getBusinessHandler(1)).E(localArrayList);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      paramMessage = (BaseActivity)this.ai.get();
    } while ((this.jdField_a_of_type_Arhz == null) || (paramMessage == null));
    this.jdField_a_of_type_Arhz.dismiss();
    QQToast.a(paramMessage, 2131700606, 0).show(paramMessage.getResources().getDimensionPixelSize(2131299627));
    return false;
  }
  
  public void onCreate()
  {
    this.mApp.addObserver(this.c);
    this.mApp.addObserver(this.jdField_a_of_type_Acnd);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.c);
    this.mApp.removeObserver(this.jdField_a_of_type_Acnd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ymn
 * JD-Core Version:    0.7.0.1
 */