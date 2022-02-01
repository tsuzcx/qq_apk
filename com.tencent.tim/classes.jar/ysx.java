import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysx
  extends ysa
  implements View.OnClickListener
{
  public ysx(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public View a(int paramInt, View paramView)
  {
    ysx.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysx.a)))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131561728, null);
      locala = new ysx.a();
      locala.uw = ((ImageView)paramView.findViewById(2131368375));
      paramView.setOnClickListener(this);
      paramView.setTag(locala);
    }
    for (;;)
    {
      String str = ((yud)this.jdField_a_of_type_Ytv).uin;
      locala.aZH = str;
      locala.uw.setImageBitmap(this.jdField_a_of_type_Ytd.a(1, str));
      yqv.caG += 1;
      return paramView;
      locala = (ysx.a)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
    }
    yqv.bD((Activity)this.mContext);
    anot.a(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static class a
    extends ysa.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysx
 * JD-Core Version:    0.7.0.1
 */