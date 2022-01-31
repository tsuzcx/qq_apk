import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFileViewerActivity;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.LiteMutiPicViewerActivity;
import com.dataline.util.DatalineSessionAdapter;
import com.dataline.util.DatalineSessionAdapter.ItemHolder;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;

public class ei
  implements View.OnClickListener
{
  public ei(DatalineSessionAdapter paramDatalineSessionAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = ((DatalineSessionAdapter.ItemHolder)paramView.getTag()).a();
    Object localObject = paramView.getFirstItem();
    if (paramView.isSingle())
    {
      if (-1000 == ((DataLineMsgRecord)localObject).msgtype) {
        return;
      }
      paramView = new Intent(DatalineSessionAdapter.a(this.a).getApplicationContext(), DLFileViewerActivity.class);
      paramView.putExtra("dl_file_info_session_id", ((DataLineMsgRecord)localObject).sessionid);
      if (-2000 == ((DataLineMsgRecord)localObject).msgtype) {
        paramView.putExtra("dl_file_type", 0);
      }
      DatalineSessionAdapter.a(this.a).startActivityForResult(paramView, 102);
      return;
    }
    if (paramView.getGroupType() == -2000)
    {
      localObject = new Intent(DatalineSessionAdapter.a(this.a), LiteMutiPicViewerActivity.class);
      ((Intent)localObject).putExtra("dataline_group_id", paramView.getGroupId());
      DatalineSessionAdapter.a(this.a).startActivity((Intent)localObject);
      return;
    }
    localObject = new Intent(DatalineSessionAdapter.a(this.a), DLFilesViewerActivity.class);
    ((Intent)localObject).putExtra("dl_files_groupid", paramView.getGroupId());
    DatalineSessionAdapter.a(this.a).startActivityForResult((Intent)localObject, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ei
 * JD-Core Version:    0.7.0.1
 */