import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agrc
  implements View.OnClickListener
{
  agrc(agsa paramagsa, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localapcy = apsv.a(this.d.getApp(), this.k);
        String str = localapcy.FilePath;
        if (str != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        apcy localapcy;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqiw.getSystemNetwork(this.d.getActivity()) == 0)
      {
        apsd.ck(this.d.getActivity(), this.d.getActivity().getString(2131699827));
      }
      else
      {
        apsd.y(this.d.getActivity(), this.d.getActivity().getString(2131694101), 0);
        TroopFileTransferManager.a(this.d.getApp(), this.k.TroopUin).j(localapcy.FilePath, localapcy.FileName, localapcy.ProgressTotal, localapcy.BusId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrc
 * JD-Core Version:    0.7.0.1
 */