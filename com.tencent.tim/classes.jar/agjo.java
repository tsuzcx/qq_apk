import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class agjo
  implements ausj.a
{
  agjo(agjn paramagjn, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.mApp.a().a(agjn.a(this.this$0).uniseq, this.this$0.h.aTl, this.this$0.h.cZ, -1L) != -1) {
      ChatActivityUtils.h(this.this$0.mContext, 2131719484, 1);
    }
    for (;;)
    {
      this.val$sheet.cancel();
      return;
      paramView = ahav.a(this.this$0.mApp, agjn.a(this.this$0));
      if (paramView.status == 16)
      {
        ahao.OS(2131694128);
        this.val$sheet.cancel();
        return;
      }
      agjn.a(this.this$0).status = 1002;
      ahav.a(this.this$0.mContext, paramView, this.this$0.mApp, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjo
 * JD-Core Version:    0.7.0.1
 */