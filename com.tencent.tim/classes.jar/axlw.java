import dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class axlw
  implements WtTicketPromise
{
  public axlw(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void Done(Ticket paramTicket)
  {
    axiy.i(AEEditorImageEditFragment.access$100(), "psKey success.");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    axiy.e(AEEditorImageEditFragment.access$100(), paramErrMsg.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    axiy.e(AEEditorImageEditFragment.access$100(), paramErrMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axlw
 * JD-Core Version:    0.7.0.1
 */