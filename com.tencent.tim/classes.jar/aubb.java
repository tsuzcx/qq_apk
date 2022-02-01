import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aubb
  extends accd
{
  aubb(auau paramauau) {}
  
  protected void ar(Object paramObject)
  {
    Object localObject = this.this$0.c.b();
    paramObject = (apcy)paramObject;
    if (((FileManagerEntity)localObject).TroopUin != paramObject.TroopUin) {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileModel", 4, "difference troop uin file");
      }
    }
    do
    {
      return;
      if (TextUtils.isEmpty(auau.a(this.this$0)))
      {
        localObject = apsv.a(this.this$0.mAppInterface, (FileManagerEntity)localObject);
        if (((apcy)localObject).Id != null) {
          auau.a(this.this$0, ((apcy)localObject).Id.toString());
        }
      }
    } while ((paramObject.Id == null) || (auau.a(this.this$0) == null) || (!auau.a(this.this$0).equals(paramObject.Id.toString())));
    auau.a(this.this$0, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubb
 * JD-Core Version:    0.7.0.1
 */