import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class akry
  extends acfd
{
  akry(akrv paramakrv) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (akrv.a(this.this$0) == null) || (akrv.a(this.this$0).isFinishing()) || (akrv.a(this.this$0) == null)) {
      QLog.d("AccountPanel", 1, String.format("onUpdateCustomHead return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    do
    {
      return;
      akrv.a locala = akrv.a(this.this$0, paramString);
      if (locala != null) {
        locala.setIcon(aqdj.a(akrv.a(this.this$0), 1, paramString));
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountPanel", 2, String.format("onUpdateCustomHead, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (akrv.a(this.this$0) == null) || (akrv.a(this.this$0).isFinishing()) || (akrv.a(this.this$0) == null))
    {
      QLog.d("AccountPanel", 1, String.format("onUpdateFriendInfo return, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
    }
    akrv.a locala = akrv.a(this.this$0, paramString);
    Object localObject;
    if (locala != null)
    {
      if (locala.type != 2) {
        break label147;
      }
      localObject = aqgv.b(akrv.a(this.this$0), paramString, false);
    }
    for (;;)
    {
      locala.setText((CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AccountPanel", 2, String.format("onUpdateFriendInfo, isSuccess: %s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
      return;
      label147:
      localObject = (SimpleAccount)locala.itemView.getTag(2131361913);
      if (localObject != null) {
        localObject = anxk.a(akrv.a(this.this$0), (SimpleAccount)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akry
 * JD-Core Version:    0.7.0.1
 */