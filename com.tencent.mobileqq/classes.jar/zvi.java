import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zvi
  implements View.OnClickListener
{
  zvi(zvh paramzvh, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)zux.c(this.jdField_a_of_type_Zvh.a).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      localClipboardManager.setPrimaryClip(ClipData.newPlainText("", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.content.get()));
      zux.a(this.jdField_a_of_type_Zvh.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvi
 * JD-Core Version:    0.7.0.1
 */