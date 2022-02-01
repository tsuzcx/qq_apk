import android.app.Activity;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.play.EditTextViewer;
import dov.com.qq.im.ae.play.EditTextViewer.4.1;

public class axib
  extends axbo
{
  public axib(EditTextViewer paramEditTextViewer, AppInterface paramAppInterface, String paramString) {}
  
  protected void a(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp)
  {
    this.b.removeObserver(this);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      bool1 = bool2;
      if (paramGetFontDataRsp != null)
      {
        if (paramGetFontDataRsp.Code != 0) {
          break label74;
        }
        EditTextViewer.a(this.this$0, this.cUD);
        bool1 = true;
        EditTextViewer.a(this.this$0, paramGetFontDataRsp);
      }
    }
    for (;;)
    {
      EditTextViewer.a(this.this$0).runOnUiThread(new EditTextViewer.4.1(this, bool1));
      return;
      label74:
      if (paramGetFontDataRsp.Code == -10002)
      {
        EditTextViewer.a(this.this$0, 2131690009);
        bool1 = bool2;
      }
      else
      {
        EditTextViewer.a(this.this$0, 2131690011);
        bool1 = bool2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axib
 * JD-Core Version:    0.7.0.1
 */