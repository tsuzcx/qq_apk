import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.a;
import com.tencent.widget.BubblePopupWindow;

public class agcd
  implements SlideDetectListView.a
{
  public agcd(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.this$0.k != null) {
      this.this$0.k.dismiss();
    }
    if (!this.this$0.akH())
    {
      this.this$0.a.bk(null);
      this.this$0.c.eiZ();
      paramView.setPressed(false);
    }
    do
    {
      return;
      paramSlideDetectListView = paramView.findViewById(2131378161);
      paramView = (FileInfo)this.this$0.a.getItem(paramInt);
      this.this$0.a.bk(paramView);
    } while (paramSlideDetectListView == null);
    paramView = (Button)paramSlideDetectListView.findViewById(2131365674);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(this.this$0.eQ);
    ((ShaderAnimLayout)paramSlideDetectListView).show();
    this.this$0.c.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131378161);
    this.this$0.a.bk(null);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131365674);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    LocalFileBrowserActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcd
 * JD-Core Version:    0.7.0.1
 */