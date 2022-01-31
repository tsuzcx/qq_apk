import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFileViewerActivity;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.DatalineFilesAdapter;
import com.dataline.util.DatalineFilesAdapter.ItemHolder;
import com.dataline.util.file.DLFileInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class el
  implements View.OnClickListener
{
  public el(DatalineFilesAdapter paramDatalineFilesAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (DatalineFilesAdapter.ItemHolder)paramView.getTag();
    if (paramView.a == null) {}
    do
    {
      return;
      paramView = DatalineFilesAdapter.a(this.a).a().b(paramView.a.a);
    } while (paramView == null);
    Intent localIntent = new Intent(DatalineFilesAdapter.a(this.a).getApplicationContext(), DLFileViewerActivity.class);
    localIntent.putExtra("dl_file_info_session_id", paramView.sessionid);
    DatalineFilesAdapter.a(this.a).startActivityForResult(localIntent, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     el
 * JD-Core Version:    0.7.0.1
 */