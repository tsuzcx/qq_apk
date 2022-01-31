import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.LiteMpFileFileDetailActivity;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskListAdapter.ItemHolder;

public class df
  implements View.OnClickListener
{
  public df(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (MpfileTaskListAdapter.ItemHolder)paramView.getTag();
    if (paramView != null)
    {
      Object localObject = paramView.a;
      if (localObject != null)
      {
        paramView = new Bundle();
        paramView.putString("fileId", ((MpfileTaskInfo)localObject).c);
        paramView.putString("name", ((MpfileTaskInfo)localObject).d);
        paramView.putLong("size", ((MpfileTaskInfo)localObject).b);
        localObject = new Intent(this.a, LiteMpFileFileDetailActivity.class);
        ((Intent)localObject).putExtras(paramView);
        this.a.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     df
 * JD-Core Version:    0.7.0.1
 */