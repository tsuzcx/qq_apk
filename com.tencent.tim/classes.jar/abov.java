import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class abov
  implements abyv.a
{
  abov(abos paramabos) {}
  
  public void hO(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    abyv.b(abos.a(this.this$0));
    Activity localActivity = this.this$0.q();
    if (paramInt == 0) {
      if ((localActivity != null) && (!abos.c(this.this$0)))
      {
        abos.a(this.this$0, true);
        abos.c(this.this$0);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abov
 * JD-Core Version:    0.7.0.1
 */