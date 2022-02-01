import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;

public class ysv
  extends ysa
  implements View.OnClickListener
{
  public ysv(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysv.a)))
    {
      paramView = new ysv.a();
      localView = LayoutInflater.from(this.mContext).inflate(2131561509, null);
      localObject = new Rect();
      ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      Y(localView, ((Rect)localObject).height() - this.mContext.getResources().getDimensionPixelSize(2131299627) - aqnm.dip2px(80.0F));
      paramView.em = ((Button)localView.findViewById(2131368227));
      if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        paramView.em.setBackgroundResource(2130839546);
      }
      localObject = (ThemeImageView)localView.findViewById(2131368223);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(auvj.euL);
      localView.setTag(paramView);
      anot.a(this.mApp, "dc00898", "", "", "0X800A5D3", "0X800A5D3", 0, 0, "1", "", "", "");
      localObject = paramView;
    }
    for (;;)
    {
      ((ysv.a)localObject).em.setOnClickListener(this);
      return localView;
      localObject = (ysv.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A5D4", "0X800A5D4", 0, 0, "1", "", "", "");
    if (aqiw.isNetSupport(this.mContext))
    {
      zbq localzbq = (zbq)this.mApp.getManager(295);
      if (localzbq != null) {
        localzbq.Bo(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show();
    }
  }
  
  public static class a
  {
    public Button em;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysv
 * JD-Core Version:    0.7.0.1
 */