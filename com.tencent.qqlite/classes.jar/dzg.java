import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class dzg
  implements Runnable
{
  public dzg(MultiMsgManager paramMultiMsgManager, ArrayList paramArrayList, Intent paramIntent, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
      if (((ChatMessage)localObject2).msgtype == -2000)
      {
        localObject2 = (MessageForPic)localObject2;
        this.jdField_a_of_type_AndroidContentIntent.putExtra("FORWARD_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("SENDER_TROOP_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("FORWARD_PEER_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("FORWARD_SELF_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_image_width", ((MessageForPic)localObject2).width);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_image_height", ((MessageForPic)localObject2).height);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_file_size", ((MessageForPic)localObject2).size);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_image_type", ((MessageForPic)localObject2).imageType);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_filepath", ((MessageForPic)localObject2).path);
        Object localObject3 = ((MessageForPic)localObject2).frienduin + ((MessageForPic)localObject2).uniseq + ((MessageForPic)localObject2).istroop;
        this.jdField_a_of_type_AndroidContentIntent.putExtra("BUSI_TYPE", 1009);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_download_image_task_key", (String)localObject3);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_download_image_org_uin", ((MessageForPic)localObject2).frienduin);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_download_image_org_uin_type", ((MessageForPic)localObject2).istroop);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_download_image_server_path", ((MessageForPic)localObject2).uuid);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_download_image_item_id", ((MessageForPic)localObject2).uniseq);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_photo_isSend", ((MessageForPic)localObject2).issend);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_photo_md5", ((MessageForPic)localObject2).md5);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_photo_group_fileid", ((MessageForPic)localObject2).groupFileID);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", ((MessageForPic)localObject2).fileSizeFlag);
        localObject2 = PicBusiManager.a(1009, this.jdField_a_of_type_AndroidContentIntent);
        localObject3 = PicBusiManager.a(2, 1009);
        ((PicReq)localObject3).a((PicFowardInfo)localObject2);
        PicBusiManager.a((PicReq)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        i += 1;
      }
      for (;;)
      {
        break;
        if (((ChatMessage)localObject2).msgtype == -2011)
        {
          ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForStructing)localObject2).structingMsg, null);
        }
        else
        {
          localObject2 = ((ChatMessage)localObject2).msg;
          ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject2);
        }
      }
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localObject1 = (ChatMessage)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if (localObject1 != null) {}
    for (int j = ((ChatMessage)localObject1).istroop;; j = 0)
    {
      if (j == 0) {
        j = 1;
      }
      for (;;)
      {
        if (k == 0) {
          k = 1;
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004876", "0X8004876", 0, 0, j + "", k + "", "" + this.jdField_a_of_type_JavaUtilArrayList.size(), "" + i + "");
          return;
          if (j == 3000)
          {
            j = 2;
            break;
          }
          if (j != 1) {
            break label691;
          }
          j = 3;
          break;
          if (k == 3000) {
            k = 2;
          } else if (k == 1) {
            k = 3;
          } else {
            k = 4;
          }
        }
        label691:
        j = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dzg
 * JD-Core Version:    0.7.0.1
 */