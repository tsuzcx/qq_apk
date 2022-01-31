import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskListAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

public class de
  implements View.OnClickListener
{
  public de(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (LiteMpFileDownloadActivity.a(this.a) != null) {
      LiteMpFileDownloadActivity.a(this.a).b();
    }
    if ((LiteMpFileDownloadActivity.a(this.a) != null) && (LiteMpFileDownloadActivity.a(this.a).length() > 0))
    {
      DataLineHandler localDataLineHandler = (DataLineHandler)this.a.b.a(8);
      MpfileTaskInfo localMpfileTaskInfo = localDataLineHandler.a().a(LiteMpFileDownloadActivity.a(this.a));
      LiteMpFileDownloadActivity.a(this.a).remove(localMpfileTaskInfo);
      localDataLineHandler.a().b(LiteMpFileDownloadActivity.a(this.a));
      LiteMpFileDownloadActivity.a(this.a, "");
    }
    if ((((Button)paramView.findViewById(2131231701)).getTag() != null) && (LiteMpFileDownloadActivity.a(this.a) != null)) {
      LiteMpFileDownloadActivity.a(this.a).a(null);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     de
 * JD-Core Version:    0.7.0.1
 */