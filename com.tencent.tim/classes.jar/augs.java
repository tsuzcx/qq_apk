import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.mail.MailPluginPreload;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xac4.oidb_0xac4.MailInfo;

public class augs
  extends augr
{
  public augs(MailPluginPreload paramMailPluginPreload) {}
  
  public void Y(boolean paramBoolean, List<oidb_0xac4.MailInfo> paramList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onPluginGetBindMail, isSuccess: ").append(paramBoolean).append(", size: ");
      if (paramList == null) {
        break label178;
      }
    }
    label178:
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("MailPluginPreload", 2, i);
      if ((!paramBoolean) || (paramList == null)) {
        break label264;
      }
      localObject = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        oidb_0xac4.MailInfo localMailInfo = (oidb_0xac4.MailInfo)localIterator.next();
        if (localMailInfo != null)
        {
          paramList = null;
          long l = 0L;
          if (localMailInfo.bytes_mail.has()) {
            paramList = localMailInfo.bytes_mail.get().toStringUtf8();
          }
          if (localMailInfo.uint64_type.has()) {
            l = localMailInfo.uint64_type.get();
          }
          if (!TextUtils.isEmpty(paramList)) {
            ((HashMap)localObject).put(paramList, Long.valueOf(l));
          }
        }
      }
    }
    paramList = new Bundle();
    paramList.putSerializable("bindMailList", (Serializable)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginPreload", 2, "bindMailList, size: " + ((HashMap)localObject).size());
    }
    augt.a().a(this.a.a.app, "cmd_bind_list", paramList);
    this.a.setResult(7);
    return;
    label264:
    this.a.setResult(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augs
 * JD-Core Version:    0.7.0.1
 */