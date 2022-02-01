import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

class atry
  implements ausj.a
{
  atry(atrx paramatrx, FileManagerEntity paramFileManagerEntity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QfileBaseRecentFileTabView.n(this.a.a.this$0).a().ca(this.e.nSessionId)) {}
    this.a.a.this$0.d(this.e);
    if ((!TextUtils.isEmpty(this.e.Uuid)) && (3000 != this.e.peerType)) {
      QfileBaseRecentFileTabView.o(this.a.a.this$0).a().n(String.valueOf(this.e.peerUin), this.e.fileName, this.e.Uuid, this.e.bSend);
    }
    this.e.bDelInFM = true;
    QfileBaseRecentFileTabView.p(this.a.a.this$0).a().u(this.e);
    this.a.a.this$0.refreshList();
    if (this.c.isShowing()) {
      this.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atry
 * JD-Core Version:    0.7.0.1
 */