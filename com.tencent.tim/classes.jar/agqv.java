import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqv
  implements View.OnClickListener
{
  agqv(FileManagerEntity paramFileManagerEntity, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localQQAppInterface.a().a(this.b, this.b.peerUin);
      ahao.JG(BaseActivity.sTopActivity.getString(2131694101));
      if ((this.c != null) && (this.c.bY())) {
        ahav.l(localQQAppInterface, this.b.nSessionId);
      }
      label70:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqv
 * JD-Core Version:    0.7.0.1
 */