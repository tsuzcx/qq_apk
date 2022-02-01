import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.NumRedMsgManager.1;
import com.tencent.mobileqq.redtouch.NumRedMsgManager.2;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class altl
  implements Manager
{
  public acii a;
  protected NumRedMsg.NumMsgRspBody a;
  protected QQAppInterface app;
  public ConcurrentHashMap<Integer, altk> gG = new ConcurrentHashMap();
  
  public altl(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Acii = ((acii)paramQQAppInterface.getBusinessHandler(56));
  }
  
  private void a(NumRedMsg.NumMsgRspBody paramNumMsgRspBody)
  {
    this.jdField_a_of_type_ComTencentPbGetnumredmsgNumRedMsg$NumMsgRspBody = paramNumMsgRspBody;
  }
  
  private void a(long[] paramArrayOfLong, altk paramaltk, String paramString, boolean paramBoolean)
  {
    ThreadManager.post(new NumRedMsgManager.2(this, paramArrayOfLong, paramaltk, paramBoolean, paramString), 5, null, false);
  }
  
  private boolean a(NumRedMsg.NumMsgRspBody paramNumMsgRspBody)
  {
    boolean bool = aqhq.a(new File(this.app.getApplication().getFilesDir(), "NumRedMsgFileName_" + this.app.getCurrentAccountUin()).getAbsolutePath(), paramNumMsgRspBody.toByteArray(), false);
    if (bool) {
      a(paramNumMsgRspBody);
    }
    return bool;
  }
  
  private boolean auv()
  {
    return new File(this.app.getApplication().getFilesDir(), "NumRedMsgFileName_" + this.app.getCurrentAccountUin()).exists();
  }
  
  private void b(NumRedMsg.NumMsgRspBody paramNumMsgRspBody)
  {
    if (paramNumMsgRspBody == null) {}
    NumRedMsg.NumMsgRspBody localNumMsgRspBody;
    List localList;
    do
    {
      return;
      localNumMsgRspBody = a();
      if (localNumMsgRspBody == null)
      {
        a(paramNumMsgRspBody);
        return;
      }
      localList = localNumMsgRspBody.rpt_num_red.get();
      if (localList == null)
      {
        a(paramNumMsgRspBody);
        return;
      }
      paramNumMsgRspBody = paramNumMsgRspBody.rpt_num_red.get();
    } while (paramNumMsgRspBody == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramNumMsgRspBody.size())
    {
      int j = 0;
      int k = 0;
      while (j < localList.size())
      {
        if (((NumRedMsg.NumMsgBusi)localList.get(j)).ui64_msgid.get() == ((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).ui64_msgid.get())
        {
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_content.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_content.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_ext.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_ext.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_missionid.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_missionid.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_path.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_path.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_url.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_url.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).ui_appid.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).ui_appid.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).ui_expire_time.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).ui_expire_time.get());
          ((NumRedMsg.NumMsgBusi)localList.get(j)).str_ret.set(((NumRedMsg.NumMsgBusi)paramNumMsgRspBody.get(i)).str_ret.get());
          k = 1;
        }
        j += 1;
      }
      if (k == 0) {
        localArrayList.add(paramNumMsgRspBody.get(i));
      }
      i += 1;
    }
    localList.addAll(localArrayList);
    a(localNumMsgRspBody);
  }
  
  private void onPrintLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NumRedMsgManager", 2, paramString);
    }
  }
  
  public NumRedMsg.NumMsgRspBody a()
  {
    if (this.jdField_a_of_type_ComTencentPbGetnumredmsgNumRedMsg$NumMsgRspBody != null) {
      return this.jdField_a_of_type_ComTencentPbGetnumredmsgNumRedMsg$NumMsgRspBody;
    }
    NumRedMsg.NumMsgRspBody localNumMsgRspBody1 = new NumRedMsg.NumMsgRspBody();
    Object localObject = new File(this.app.getApplication().getFilesDir(), "NumRedMsgFileName_" + this.app.getCurrentAccountUin());
    if (!((File)localObject).exists()) {
      onPrintLog("numredmsg pb file does not exist");
    }
    try
    {
      ((File)localObject).createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          localObject = aqhq.fileToBytes((File)localObject);
          if (localObject != null) {
            break;
          }
          onPrintLog("Can not translate numredmsg pb file to byte");
          return null;
        }
        finally {}
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    try
    {
      localNumMsgRspBody2.mergeFrom((byte[])localObject);
      a(localNumMsgRspBody2);
      return localNumMsgRspBody2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      onPrintLog("merge numredmsg file to rspbody fail");
    }
    return null;
  }
  
  public void a(NumRedMsg.NumMsgRspBody paramNumMsgRspBody, ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int i = paramToServiceMsg.extraData.getInt("NumMsgListenerKey");
    long[] arrayOfLong = paramToServiceMsg.extraData.getLongArray("NumMsgIDList");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("NumMsgListenerCmd");
    if (paramBoolean)
    {
      if (paramNumMsgRspBody == null) {
        return;
      }
      if (auv()) {
        break label85;
      }
      a(paramNumMsgRspBody);
    }
    for (;;)
    {
      paramNumMsgRspBody = (altk)this.gG.get(Integer.valueOf(i));
      if (paramNumMsgRspBody == null) {
        break;
      }
      a(arrayOfLong, paramNumMsgRspBody, paramToServiceMsg, true);
      return;
      label85:
      b(paramNumMsgRspBody);
    }
  }
  
  public void a(List<Submsgtype0x89.NumRedBusiInfo> paramList, String paramString, altk paramaltk)
  {
    ThreadManager.post(new NumRedMsgManager.1(this, paramList, paramaltk, paramString), 5, null, false);
  }
  
  public void a(long[] paramArrayOfLong, String paramString, altk paramaltk)
  {
    a(paramArrayOfLong, paramaltk, paramString, false);
  }
  
  public void onDestroy()
  {
    this.gG = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     altl
 * JD-Core Version:    0.7.0.1
 */