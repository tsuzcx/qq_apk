import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;

public class ajaa
  extends aakb
{
  int mHeaderViewHeight;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramOnClickListener = paramContext.getResources();
    if (paramView == null)
    {
      paramaajx = null;
      if ((paramView == null) || (!(paramView.getTag() instanceof ajaa.a))) {
        break label179;
      }
      paramaajx = (ajaa.a)paramaajx;
      label35:
      paramInt = paramViewGroup.getMeasuredHeight() - this.mHeaderViewHeight;
      if (paramInt >= 0) {
        break label382;
      }
      paramInt = (int)(this.mHeaderViewHeight * 1.5F);
    }
    label81:
    label382:
    for (;;)
    {
      if ((paramView.getLayoutParams() instanceof AbsListView.LayoutParams))
      {
        paramViewGroup = (AbsListView.LayoutParams)paramView.getLayoutParams();
        paramViewGroup.width = -1;
        paramViewGroup.height = paramInt;
        paramView.setLayoutParams(paramViewGroup);
        if ((paramObject instanceof Integer))
        {
          paramInt = ((Integer)paramObject).intValue();
          if (paramInt != 20) {
            break label292;
          }
          paramaajx.j.setImageResource(2130839657);
          if ((paramaajx.j.getDrawable() instanceof Animatable)) {
            ((Animatable)paramaajx.j.getDrawable()).start();
          }
          paramaajx.textView.setText(2131701322);
        }
      }
      while (paramInt != 21)
      {
        return paramView;
        paramaajx = paramView.getTag();
        break;
        paramView = LayoutInflater.from(paramContext).inflate(2131561334, null);
        paramaajx = new ajaa.a();
        paramaajx.dZ = ((ViewGroup)paramView.findViewById(2131370144));
        paramaajx.j = ((ThemeImageView)paramView.findViewById(2131368698));
        paramaajx.textView = ((TextView)paramView.findViewById(2131381048));
        paramView.setTag(paramaajx);
        this.mHeaderViewHeight = (paramOnClickListener.getDimensionPixelSize(2131298717) + paramOnClickListener.getDimensionPixelSize(2131298719) + paramOnClickListener.getDimensionPixelSize(2131298718));
        break label35;
        paramViewGroup = new AbsListView.LayoutParams(-1, paramInt);
        break label81;
      }
      if ((paramaajx.j.getDrawable() instanceof Animatable)) {
        ((Animatable)paramaajx.j.getDrawable()).stop();
      }
      paramObject = aqcu.decodeResource(paramContext.getResources(), 2130846007);
      if (paramObject != null)
      {
        paramaajx.j.setImageBitmap(paramObject);
        paramaajx.j.setMaskShape(auvj.euL);
      }
      for (;;)
      {
        paramaajx.textView.setText(2131701321);
        return paramView;
        QLog.e("MatchEmptyItemBuilder", 1, "image qq_extend_friend_empty_normal decode failed.");
      }
    }
  }
  
  static class a
  {
    ViewGroup dZ;
    ThemeImageView j;
    TextView textView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajaa
 * JD-Core Version:    0.7.0.1
 */