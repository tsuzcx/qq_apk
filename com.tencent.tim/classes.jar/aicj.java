import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

class aicj
{
  private List<aihf> Cr = new ArrayList();
  private List<aihf> Cs = new ArrayList();
  private aihg a = new aick(this);
  private BroadcastReceiver bk = new aicl(this);
  private QQAppInterface mApp;
  
  private void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, int paramInt)
  {
    Intent localIntent = z();
    localIntent.putExtra("command_type", paramInt);
    localIntent.putExtra("togetherRoomMessageData", paramNewTogetherRoomMessageData);
    dx(localIntent);
  }
  
  private void b(Intent paramIntent, List<aihf> paramList)
  {
    int i;
    String str;
    StringBuilder localStringBuilder;
    if (!paramList.isEmpty())
    {
      i = paramIntent.getIntExtra("callback_return_code", 0);
      str = paramIntent.getStringExtra("callback_return_message");
      paramIntent = this.Cr.iterator();
      while (paramIntent.hasNext()) {
        ((aihf)paramIntent.next()).callback(i, str);
      }
      localStringBuilder = new StringBuilder().append("receive ");
      if (paramList != this.Cr) {
        break label130;
      }
    }
    label130:
    for (paramIntent = "close";; paramIntent = "open")
    {
      QLog.i("GroupVideoManager|Communicate", 2, paramIntent + " room message " + i + " " + str);
      paramList.clear();
      return;
    }
  }
  
  private void drX()
  {
    Object localObject = (TicketManager)this.mApp.getManager(2);
    if ((localObject != null) && (!TextUtils.isEmpty(this.mApp.getAccount())))
    {
      localObject = ((TicketManager)localObject).getSkey(this.mApp.getAccount());
      Intent localIntent = z();
      localIntent.putExtra("command_type", 6);
      localIntent.putExtra("sKeyKey", (String)localObject);
      dx(localIntent);
      return;
    }
    QLog.e("GroupVideoManager|Communicate", 1, "get skey error");
  }
  
  private void dw(Intent paramIntent)
  {
    aihv localaihv = (aihv)this.mApp.getManager(338);
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.bNH = paramIntent.getStringExtra("closeRoomGroupOwnerUin");
    localNewTogetherRoomMessageData.QD = paramIntent.getStringExtra("closeRoomGroupUin");
    localaihv.a(paramIntent.getStringExtra("closeRoomFrom"), localNewTogetherRoomMessageData);
  }
  
  private void dx(Intent paramIntent)
  {
    this.mApp.getApp().sendBroadcast(paramIntent);
  }
  
  private Intent z()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.gvideo.message.communicate.qq2gvideo");
    return localIntent;
  }
  
  public aihg a()
  {
    return this.a;
  }
  
  void a(aihf paramaihf)
  {
    this.Cs.add(paramaihf);
  }
  
  void a(Bundle paramBundle, aihf paramaihf)
  {
    Intent localIntent = z();
    localIntent.putExtra("command_type", 4);
    localIntent.putExtra("closeRoomBundle", paramBundle);
    dx(localIntent);
    this.Cr.add(paramaihf);
  }
  
  void unInit()
  {
    this.mApp.getApp().unregisterReceiver(this.bk);
    this.Cs.clear();
    this.Cr.clear();
    this.mApp = null;
  }
  
  void z(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("com.tencent.gvideo.message.communicate.gvideo2qq");
    this.mApp.getApp().registerReceiver(this.bk, paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicj
 * JD-Core Version:    0.7.0.1
 */