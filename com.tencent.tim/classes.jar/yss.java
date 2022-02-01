import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendSubTitle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yss
  extends ysa
  implements View.OnClickListener
{
  public yss(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof yss.a)))
    {
      localObject = new yss.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131561512, null);
      ((yss.a)localObject).titleText = ((TextView)paramView.findViewById(2131379769));
      ((yss.a)localObject).yd = paramView.findViewById(2131366484);
      ((yss.a)localObject).yd.setOnClickListener(this);
      paramView.setTag(localObject);
      ((yss.a)localObject).titleText.setText(((yty)this.a).a.title);
      localObject = ((yss.a)localObject).yd;
      if (!((yty)this.a).a.showEntrance) {
        break label133;
      }
    }
    label133:
    for (paramInt = 0;; paramInt = 8)
    {
      ((View)localObject).setVisibility(paramInt);
      return paramView;
      localObject = (yss.a)paramView.getTag();
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yqv.bD((Activity)this.mContext);
      anot.a(null, "dc00898", "", "", "0X800A3A5", "0X800A3A5", 0, 0, "", "", "", "");
    }
  }
  
  public static class a
  {
    public TextView titleText;
    public View yd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yss
 * JD-Core Version:    0.7.0.1
 */