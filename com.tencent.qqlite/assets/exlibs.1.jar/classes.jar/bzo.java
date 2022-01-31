import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bzo
  implements DownCallBack
{
  WeakReference a;
  
  public bzo(MultiForwardChatPie paramMultiForwardChatPie)
  {
    this.a = new WeakReference(paramMultiForwardChatPie);
  }
  
  public void a(int paramInt) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (this.a == null) {}
    MultiForwardChatPie localMultiForwardChatPie;
    do
    {
      do
      {
        do
        {
          return;
          localMultiForwardChatPie = (MultiForwardChatPie)this.a.get();
          if ((paramDownResult.jdField_a_of_type_Int != 0) || (paramDownResult.jdField_a_of_type_ArrayOfByte == null)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload success");
          }
        } while (localMultiForwardChatPie == null);
        localObject = new HashMap();
        MessageRecord localMessageRecord = MultiForwardChatPie.a(localMultiForwardChatPie).a().a(MultiForwardChatPie.a(localMultiForwardChatPie).jdField_a_of_type_JavaLangString, MultiForwardChatPie.b(localMultiForwardChatPie).jdField_a_of_type_Int, localMultiForwardChatPie.e);
        paramDownResult = MultiForwardChatPie.b(localMultiForwardChatPie).a().a().a(paramDownResult.jdField_a_of_type_ArrayOfByte, (HashMap)localObject, localMessageRecord);
      } while ((paramDownResult == null) || (paramDownResult.size() <= 0));
      MultiMsgManager.a().a((HashMap)localObject, localMultiForwardChatPie.e, MultiForwardChatPie.c(localMultiForwardChatPie));
      Object localObject = new ArrayList();
      paramDownResult = paramDownResult.iterator();
      while (paramDownResult.hasNext()) {
        ((List)localObject).add((ChatMessage)paramDownResult.next());
      }
      localMultiForwardChatPie.b = ((List)localObject);
      paramDownResult = ChatActivityUtils.a(localMultiForwardChatPie.b, MultiForwardChatPie.c(localMultiForwardChatPie), MultiForwardChatPie.d(localMultiForwardChatPie));
      paramDownResult = ChatActivityUtils.a(MultiForwardChatPie.e(localMultiForwardChatPie), BaseApplicationImpl.getContext(), MultiForwardChatPie.d(localMultiForwardChatPie), paramDownResult);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - MultiForwardChatPie.a(localMultiForwardChatPie)));
      }
      MultiMsgManager.a().a(MultiForwardChatPie.f(localMultiForwardChatPie), localMultiForwardChatPie.b, true);
      MultiForwardChatPie.a(localMultiForwardChatPie).runOnUiThread(new bzp(this, localMultiForwardChatPie, paramDownResult));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload failed");
      }
    } while (localMultiForwardChatPie == null);
    MultiMsgManager.a().a(MultiForwardChatPie.g(localMultiForwardChatPie), null, false);
    MultiForwardChatPie.b(localMultiForwardChatPie).runOnUiThread(new bzq(this, localMultiForwardChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzo
 * JD-Core Version:    0.7.0.1
 */