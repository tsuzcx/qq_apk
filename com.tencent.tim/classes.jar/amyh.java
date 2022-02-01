import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class amyh
  implements amxz
{
  public static final String TAG = amyh.class.getSimpleName();
  public Context context;
  public final int type;
  public View view;
  
  public amyh(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(TAG + "type is illegal, type = " + paramInt);
    }
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 2) {}
    }
    else
    {
      i = 0;
      QLog.e(TAG, 1, "type is illegal, type = " + 0);
    }
    this.context = paramContext;
    this.type = i;
  }
  
  public View getView()
  {
    if (this.view != null) {
      return this.view;
    }
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
    switch (this.type)
    {
    default: 
      if (bool) {
        localRelativeLayout.setBackgroundColor(this.context.getResources().getColor(2131167222));
      }
      break;
    }
    for (;;)
    {
      this.view = localRelativeLayout;
      return localRelativeLayout;
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, aqcx.dip2px(this.context, 12.0F)));
      View localView = new View(this.context);
      if (bool) {
        localView.setBackgroundColor(this.context.getResources().getColor(2131167233));
      }
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
        localLayoutParams.addRule(15);
        localLayoutParams.leftMargin = aqcx.dip2px(this.context, 15.0F);
        localLayoutParams.rightMargin = aqcx.dip2px(this.context, 15.0F);
        localRelativeLayout.addView(localView, localLayoutParams);
        break;
        localView.setBackgroundColor(this.context.getResources().getColor(2131167232));
      }
      localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, aqcx.dip2px(this.context, 18.0F)));
      break;
      localRelativeLayout.setBackgroundColor(this.context.getResources().getColor(2131167654));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyh
 * JD-Core Version:    0.7.0.1
 */