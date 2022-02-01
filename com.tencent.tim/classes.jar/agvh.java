import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class agvh
  extends accd
{
  agvh(aguu paramaguu) {}
  
  protected void ar(Object paramObject)
  {
    Object localObject = this.this$0.c.b();
    paramObject = (apcy)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.TroopUin) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel<FileAssistant>", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(aguu.a(this.this$0)))
      {
        localObject = apsv.a(this.this$0.mAppInterface, (FileManagerEntity)localObject);
        if (((apcy)localObject).Id != null) {
          aguu.a(this.this$0, ((apcy)localObject).Id.toString());
        }
      }
    } while ((paramObject.Id == null) || (aguu.a(this.this$0) == null) || (!aguu.a(this.this$0).equals(paramObject.Id.toString())));
    aguu.a(this.this$0, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvh
 * JD-Core Version:    0.7.0.1
 */