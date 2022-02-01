import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ajlw
  implements agzj.a
{
  ajlw(ajlu paramajlu, agzj paramagzj) {}
  
  public void onError(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    ajlq localajlq = this.e.a(this.b.vW());
    if (localajlq != null)
    {
      localajlq.result = -1;
      localajlq.errorCode = paramInt;
      localajlq.errorMessage = paramString;
      ajlu.a(this.e, localajlq);
    }
  }
  
  public void onSuccess()
  {
    Message localMessage = ajlu.a(this.e).obtainMessage(1);
    ajlq localajlq = this.e.a(this.b.vW());
    if (localajlq != null)
    {
      localajlq.result = 0;
      localMessage.obj = localajlq;
      ajlu.a(this.e).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlw
 * JD-Core Version:    0.7.0.1
 */