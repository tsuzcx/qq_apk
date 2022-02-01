import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;

class akgc
  implements View.OnLongClickListener
{
  akgc(akfk paramakfk) {}
  
  @TargetApi(11)
  public boolean onLongClick(View paramView)
  {
    if (this.this$0.jF.getChildCount() <= 1) {
      return true;
    }
    Object localObject = new ClipData.Item("");
    paramView.startDrag(new ClipData("", new String[] { "text/plain" }, (ClipData.Item)localObject), new akfk.b(this.this$0, paramView), paramView, 0);
    localObject = akfk.a(this.this$0, (PicInfo)paramView.getTag(), null);
    ((RelativeLayout)localObject).setVisibility(4);
    akfk.a(this.this$0, (RelativeLayout)localObject);
    int i = this.this$0.jF.indexOfChild(paramView);
    if (i != -1)
    {
      this.this$0.jF.removeView(paramView);
      this.this$0.jF.addView(akfk.a(this.this$0), i);
      return true;
    }
    paramView.setVisibility(4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgc
 * JD-Core Version:    0.7.0.1
 */