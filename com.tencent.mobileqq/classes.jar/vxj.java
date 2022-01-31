import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;

public class vxj
  extends BroadcastReceiver
{
  public vxj(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst")) {
        break label72;
      }
      paramContext = paramIntent.getExtras();
      if (paramContext != null) {
        break label26;
      }
    }
    label26:
    label72:
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          float f;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    long l;
                    do
                    {
                      return;
                      l = paramContext.getLong("deviceopdin", 0L);
                    } while ((paramContext.getInt("deviceoprstcode", 0) != 0) || (Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) != l));
                    this.a.A();
                    return;
                    if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ProductFetchRst")) {
                      break;
                    }
                    paramContext = paramIntent.getExtras();
                  } while ((paramContext == null) || (paramContext.getInt("deviceoprstcode", 0) != 0));
                  this.a.aX();
                  return;
                  if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveVasFlagResult")) {
                    break;
                  }
                  paramContext = paramIntent.getExtras();
                } while (paramContext == null);
                i = paramContext.getInt("Flag", 0);
                paramContext = (DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
                if (i == 1)
                {
                  DeviceMsgChatPie.S = true;
                  paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131434028) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437866);
                  paramContext.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent, MessageCache.a(), true, false, 0);
                  return;
                }
                DeviceMsgChatPie.S = false;
                paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131434028) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437867) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437868);
                paramContext.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent, MessageCache.a(), true, false, 2);
                return;
                if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress")) {
                  break;
                }
                paramContext = paramIntent.getExtras();
              } while (paramContext == null);
              i = paramContext.getInt("cookie", 0);
              f = paramContext.getFloat("percent", 0.0F);
            } while ((i == 0) || (!DeviceMsgChatPie.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))));
            paramContext = (MessageRecord)DeviceMsgChatPie.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramContext instanceof MessageForDeviceFile))
            {
              paramContext = (MessageForDeviceFile)paramContext;
              paramContext.nFileStatus = 3;
              paramContext.progress = f;
              paramContext.serial();
              this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
              return;
            }
          } while (!(paramContext instanceof MessageForDevLittleVideo));
          paramContext = (MessageForDevLittleVideo)paramContext;
          paramContext.videoFileStatus = 1002;
          paramContext.videoFileProgress = ((int)(100.0F * f));
          paramContext.serial();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
          ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, f);
          return;
        } while (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet"));
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      i = paramContext.getInt("cookie", 0);
      j = paramContext.getInt("err_code", 1);
    } while ((i == 0) || (!DeviceMsgChatPie.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))));
    paramContext = (MessageRecord)DeviceMsgChatPie.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (j == 0) {
      if ((paramContext instanceof MessageForDevPtt))
      {
        paramContext = (MessageForDevPtt)paramContext;
        paramContext.extraflag = 32770;
        paramContext.fileSize = FileManagerUtil.a(paramContext.url);
        paramContext.extStr = "device_groupchat";
        paramContext.serial();
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
        ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, Boolean.valueOf(true));
      }
    }
    for (;;)
    {
      DeviceMsgChatPie.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(i));
      return;
      if ((paramContext instanceof MessageForDeviceFile))
      {
        ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, Boolean.valueOf(true));
      }
      else if ((paramContext instanceof MessageForDevLittleVideo))
      {
        paramIntent = (MessageForDevLittleVideo)paramContext;
        paramIntent.videoFileStatus = 1003;
        paramIntent.videoFileProgress = 100;
        paramIntent.serial();
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
        ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, Boolean.valueOf(true));
        continue;
        if ((paramContext instanceof MessageForDevPtt))
        {
          paramContext = (MessageForDevPtt)paramContext;
          paramContext.extraflag = 32768;
          paramContext.extStr = "device_groupchat";
          paramContext.serial();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.frienduin, paramContext.istroop, paramContext.uniseq, paramContext.msgData);
          ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, Boolean.valueOf(false));
        }
        else if ((paramContext instanceof MessageForDeviceFile))
        {
          paramContext = (MessageForDeviceFile)paramContext;
          ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, Boolean.valueOf(false));
        }
        else if ((paramContext instanceof MessageForDevLittleVideo))
        {
          paramIntent = (MessageForDevLittleVideo)paramContext;
          paramIntent.videoFileStatus = 1005;
          paramIntent.videoFileProgress = 0;
          paramIntent.serial();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramIntent.frienduin, paramIntent.istroop, paramIntent.uniseq, paramIntent.msgData);
          ((DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramContext, Boolean.valueOf(false));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxj
 * JD-Core Version:    0.7.0.1
 */