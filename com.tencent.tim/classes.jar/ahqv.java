import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager.2.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.im_msg_body.RichText;

public class ahqv
  implements akyf
{
  ahqv(ahqt paramahqt, ahqw paramahqw, ahqt.a parama) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(akyf.a parama) {}
  
  public void b(akyf.a parama)
  {
    HashMap localHashMap;
    if (parama != null)
    {
      int i = parama.result;
      if (QLog.isColorLevel()) {
        QLog.d("PicOcrManager", 2, "upCallBack res:" + i);
      }
      if ((-1 == i) && (this.a != null)) {
        this.a.onUpdate(100, false, new ahqy());
      }
      if ((-1 == i) || (i == 0))
      {
        if (!this.b.bLq.equals(this.b.bLr)) {
          ThreadManager.excute(new PicOcrManager.2.1(this), 64, null, true);
        }
        localHashMap = new HashMap();
        if (i != 0) {
          break label170;
        }
      }
    }
    label170:
    for (parama = "0";; parama = "1")
    {
      localHashMap.put("param_upload", parama);
      localHashMap.put("param_md5", this.b.bLq);
      anpc.a(BaseApplication.getContext()).collectPerformance("", "actUploadProcessState", true, 0L, 0L, localHashMap, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqv
 * JD-Core Version:    0.7.0.1
 */