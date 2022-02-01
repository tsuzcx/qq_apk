import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqy
  implements View.OnClickListener
{
  agqy(FileManagerEntity paramFileManagerEntity, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (avlx.a().F(this.b)) {
        avlx.a().L(this.c.getActivity(), this.b.getFilePath(), false);
      }
      for (;;)
      {
        label36:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        QLog.e("FileOperaterUtils-PUPU", 2, "Should not open the file with pupu: " + this.b.getFilePath());
      }
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqy
 * JD-Core Version:    0.7.0.1
 */