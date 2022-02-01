import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.1;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class asuj
  implements asuh.a
{
  asuj(asui paramasui) {}
  
  public void onAddColorSign(boolean paramBoolean)
  {
    QLog.d("ColorNotePlugin", 1, "onAddColorSign:" + paramBoolean);
    if (paramBoolean)
    {
      this.a.a.val$req.ok();
      return;
    }
    this.a.a.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asuj
 * JD-Core Version:    0.7.0.1
 */