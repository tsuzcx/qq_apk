import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agrb
  implements View.OnClickListener
{
  agrb(agsa paramagsa, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ahau.a locala = new ahau.a();
      locala.bJE = "file_forward";
      locala.cYX = 9;
      ahau.a(this.c.getApp().getCurrentAccountUin(), locala);
      ahbr.a(this.c.getApp(), this.c.getActivity(), this.k);
      label61:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrb
 * JD-Core Version:    0.7.0.1
 */