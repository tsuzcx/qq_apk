import android.content.Intent;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController.1;
import com.tencent.mobileqq.transfile.TransFileController.1.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class aooj
  implements akyf
{
  public aooj(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (parama != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (parama != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = parama.result)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (parama != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (parama.result == 0)
    {
      bool = true;
      label94:
      localObject = (CardHandler)this.a.val$app.getBusinessHandler(2);
      if (localObject == null) {
        break label226;
      }
      ((CardHandler)localObject).p(bool, this.a.val$app.getCurrentAccountUin(), 0);
      if (bool) {
        break label233;
      }
      aqep.ad("TransferRequest.onSend", parama.errCode, parama.toString());
      if (!"FROM_MINI_APP".equals(this.cmm)) {
        break label394;
      }
      if (!bool) {
        break label396;
      }
      i = j;
      if (!bool) {
        break label403;
      }
    }
    label133:
    label151:
    label170:
    for (parama = "ok";; parama = "upload failed")
    {
      this.a.val$intent.putExtra("param_result_code", i);
      this.a.val$intent.putExtra("param_result_desc", parama);
      accu.a().df(this.a.val$intent);
      return;
      bool = false;
      break label94;
      label226:
      aqep.Us(null);
      break label133;
      label233:
      if (((Integer)ajrb.c(this.a.val$app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        ajrb.c(this.a.val$app.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.cNx) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (aqmj.aO(this.a.val$app.getApp(), this.a.val$app.getCurrentAccountUin()) == 2) {
        break label151;
      }
      parama = (CardHandler)this.a.val$app.getBusinessHandler(2);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      parama.a(this.a.val$app.getCurrentAccountUin(), this.a.val$app.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label151;
      break;
      i = -10002;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aooj
 * JD-Core Version:    0.7.0.1
 */