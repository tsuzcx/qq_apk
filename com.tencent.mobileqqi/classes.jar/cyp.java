import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class cyp
{
  private static final int jdField_a_of_type_Int = 1002;
  private static final int b = 1003;
  Handler jdField_a_of_type_AndroidOsHandler = new cyq(this);
  public Toast a;
  protected SessionInfo a;
  protected BaseActivity a;
  protected BizTroopHandler a;
  protected BizTroopObserver a;
  protected MessageObserver a;
  protected QQAppInterface a;
  protected QQProgressDialog a;
  public String a;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public boolean d = false;
  
  public cyp(SessionInfo paramSessionInfo, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = null;
    this.jdField_a_of_type_AndroidWidgetToast = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new cyr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cys(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if ((paramBaseActivity.getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBaseActivity.getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      d();
      return;
    }
    if (paramBoolean)
    {
      FriendManager localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b.getManager(8);
      OpenTroopInfo localOpenTroopInfo = localFriendManager.a(paramString2);
      paramString3 = localOpenTroopInfo;
      if (localOpenTroopInfo == null) {
        paramString3 = new OpenTroopInfo();
      }
      paramString3.troopCode = paramString2;
      paramString3.troopUin = paramString1;
      localFriendManager.a(paramString3, true);
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (this.jdField_a_of_type_AndroidWidgetToast != null)
      {
        this.jdField_a_of_type_AndroidWidgetToast.cancel();
        this.jdField_a_of_type_AndroidWidgetToast = null;
      }
      paramString1 = new QQToast(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramString1.c(3000);
      paramString1.a(paramString3);
      this.jdField_a_of_type_AndroidWidgetToast = paramString1.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.d());
      d();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在进群，请稍等....");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new cyt(this), 1000L);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    Message localMessage = Message.obtain();
    localMessage.what = 1002;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      MessageForPic localMessageForPic;
      do
      {
        return;
        if ((paramChatMessage instanceof MessageForText))
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.msg, paramChatMessage.uniseq);
          return;
        }
        if (!(paramChatMessage instanceof MessageForPic)) {
          break;
        }
        localMessageForPic = (MessageForPic)paramChatMessage;
      } while (!FileUtils.b(localMessageForPic.path));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.istroop, localMessageForPic.uniseq);
      if (localMessageForPic.isSendFromLocal()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPic.frienduin, localMessageForPic.uniseq));
      }
      Object localObject = new PicUploadInfo.Builder();
      ((PicUploadInfo.Builder)localObject).a(localMessageForPic.path);
      ((PicUploadInfo.Builder)localObject).d(localMessageForPic.busiType);
      ((PicUploadInfo.Builder)localObject).d(localMessageForPic.frienduin);
      ((PicUploadInfo.Builder)localObject).c(TranDbRecord.PicDbRecord.e);
      ((PicUploadInfo.Builder)localObject).e(localMessageForPic.senderuin);
      ((PicUploadInfo.Builder)localObject).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((PicUploadInfo.Builder)localObject).e(localMessageForPic.istroop);
      PicUploadInfo.RetryInfo localRetryInfo = new PicUploadInfo.RetryInfo();
      localRetryInfo.a = paramChatMessage.msgseq;
      localRetryInfo.b = paramChatMessage.shmsgseq;
      localRetryInfo.a = paramChatMessage.msgseq;
      ((PicUploadInfo.Builder)localObject).a(localRetryInfo);
      paramChatMessage = PicBusiManager.a(3, localMessageForPic.busiType);
      paramChatMessage.a(((PicUploadInfo.Builder)localObject).a());
      PicBusiManager.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if ((paramChatMessage instanceof MessageForPtt))
      {
        paramChatMessage = (MessageForPtt)paramChatMessage;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.url, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -3);
        return;
      }
      if ((paramChatMessage instanceof MessageForMarketFace))
      {
        localObject = EmoticonUtils.a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((PicEmoticonInfo)localObject).a, paramChatMessage.uniseq);
        return;
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
        return;
      }
    } while (!(paramChatMessage instanceof MessageForLongMsg));
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageForLongMsg)paramChatMessage);
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      b((ChatMessage)localIterator.next());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cyp
 * JD-Core Version:    0.7.0.1
 */