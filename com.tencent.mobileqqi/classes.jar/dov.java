import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SpaceGateActivity;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.mobileqq.widget.SlipLimitedListView;

public class dov
  implements SlideDetectListView.OnSlideListener
{
  public dov(SpaceGateActivity paramSpaceGateActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131230987);
    Object localObject = (Cursor)SpaceGateActivity.a(this.a).getItem(paramInt);
    SpaceGateActivity.a(this.a, ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("senderuin")));
    SpaceGateActivity.b(this.a, ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("selfuin")));
    SpaceGateActivity.a(this.a).a(SpaceGateActivity.a(this.a) + "_" + 1009);
    if (paramSlideDetectListView != null)
    {
      localObject = (Button)paramSlideDetectListView.findViewById(2131231699);
      ((Button)localObject).setTag(Integer.valueOf(paramInt));
      ((Button)localObject).setOnClickListener(SpaceGateActivity.a(this.a));
      ((ShaderAnimLayout)paramSlideDetectListView).a();
      SpaceGateActivity.a(this.a).setDeleteAreaWidth(paramSlideDetectListView.getLayoutParams().width);
    }
    paramSlideDetectListView = paramView.findViewById(2131231881);
    if (paramSlideDetectListView != null)
    {
      SpaceGateActivity.a(this.a).removeMessages(0);
      paramSlideDetectListView.setVisibility(8);
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131230987);
    SpaceGateActivity.a(this.a).a("");
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131231699);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    paramSlideDetectListView = (TextView)paramView.findViewById(2131231881);
    if ((paramSlideDetectListView != null) && (!"".equals(paramSlideDetectListView.getText())))
    {
      SpaceGateActivity.a(this.a).removeMessages(0);
      paramView = Message.obtain();
      paramView.obj = paramSlideDetectListView;
      paramView.arg1 = 0;
      SpaceGateActivity.a(this.a).sendMessageDelayed(paramView, 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dov
 * JD-Core Version:    0.7.0.1
 */