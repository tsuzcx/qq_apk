import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskListAdapter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;

public class ca
  implements SlideDetectListView.OnSlideListener
{
  public ca(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (MpfileTaskInfo)LiteMpFileDownloadActivity.a(this.a).getItem(paramInt);
    if (paramSlideDetectListView == null) {
      return;
    }
    paramView = paramView.findViewById(2131296441);
    if (paramView != null)
    {
      Button localButton = (Button)paramView.findViewById(2131297127);
      LiteMpFileDownloadActivity.a(this.a).a(paramSlideDetectListView);
      LiteMpFileDownloadActivity.a(this.a, paramSlideDetectListView.c);
      localButton.setOnClickListener(this.a.a);
      ((ShaderAnimLayout)paramView).a();
      LiteMpFileDownloadActivity.a(this.a).setDeleteAreaDim(paramView.getLayoutParams().width, paramView.getLayoutParams().height);
    }
    this.a.a();
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    LiteMpFileDownloadActivity.a(this.a, "");
    LiteMpFileDownloadActivity.a(this.a).a(null);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ca
 * JD-Core Version:    0.7.0.1
 */