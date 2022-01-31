import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.apollo.ai.ApolloAIPresenter;
import com.tencent.mobileqq.apollo.ai.IApolloAIView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class yut
  extends TransProcessorHandler
{
  public yut(ApolloAIPresenter paramApolloAIPresenter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.jdField_c_of_type_Int != 36)) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        case 1002: 
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApolloAIPresenter", 2, "start upload cmshow record");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIPresenter", 2, "finish upload cmshow record" + localFileMsg.g);
      }
      try
      {
        paramMessage = new cmd0x346.RspBody();
        paramMessage.mergeFrom(localFileMsg.a);
        paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
        if (paramMessage.int32_ret_code.get() != 0) {
          break;
        }
        paramMessage = (cmd0x346.DownloadInfo)paramMessage.msg_download_info.get();
        if ((paramMessage != null) && (paramMessage.str_download_url.has())) {}
        paramMessage = paramMessage.str_download_url.get();
        ((VasExtensionHandler)ApolloAIPresenter.a(this.a).a(71)).a(1, paramMessage, "cmshowAI");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloAIPresenter", 2, "download record url =" + paramMessage);
        }
        FileUtil.c(localFileMsg.jdField_c_of_type_JavaLangString);
        VipUtils.a(null, "cmshow", "Apollo", "voice_sent_rst", 0, 0, new String[0]);
        return;
      }
      catch (Exception paramMessage) {}
    } while (!QLog.isColorLevel());
    QLog.e("ApolloAIPresenter", 2, "upload cmshow record response error e=" + paramMessage.toString());
    return;
    VipUtils.a(null, "cmshow", "Apollo", "voice_sent_rst", 0, 1, new String[0]);
    return;
    VipUtils.a(null, "cmshow", "Apollo", "voice_sent_rst", 0, 1, new String[0]);
    if (ApolloAIPresenter.a(this.a) != null)
    {
      ApolloAIPresenter.a(this.a).h();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIPresenter", 2, "apollo ai record upload fail");
      }
    }
    QLog.i("ApolloAIPresenter", 1, "upload cmshow error:" + localFileMsg.g);
    return;
    QLog.i("ApolloAIPresenter", 1, "upload cmshow cancel:" + localFileMsg.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yut
 * JD-Core Version:    0.7.0.1
 */