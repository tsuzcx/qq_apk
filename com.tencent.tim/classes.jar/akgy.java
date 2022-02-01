import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

class akgy
  implements View.OnLongClickListener
{
  akgy(akgm paramakgm) {}
  
  @TargetApi(11)
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.jF.getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new akgm.b(this.this$0, paramView), paramView, 0);
    localObject = akgm.a(this.this$0, (PicInfo)paramView.getTag(), null);
    ((RelativeLayout)localObject).setVisibility(4);
    akgm.a(this.this$0, (RelativeLayout)localObject);
    int i = this.this$0.jF.indexOfChild(paramView);
    if (i != -1)
    {
      this.this$0.jF.removeView(paramView);
      this.this$0.jF.addView(akgm.a(this.this$0), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgy
 * JD-Core Version:    0.7.0.1
 */