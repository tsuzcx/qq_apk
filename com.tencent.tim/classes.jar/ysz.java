import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

public class ysz
  extends ysa
  implements View.OnClickListener
{
  public ysz(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.jdField_a_of_type_Auvd = a(paramContext);
    this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(2131297808);
  }
  
  public View a(int paramInt, View paramView)
  {
    ysz.a locala;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysz.a)))
    {
      locala = new ysz.a();
      paramView = a(this.mContext, 2131561720, locala);
      Y(paramView, this.mItemHeight);
      locala.uw = ((ImageView)paramView.findViewById(2131361802));
      locala.Lx = ((TextView)paramView.findViewById(2131372384));
      locala.Ly = ((TextView)paramView.findViewById(2131377214));
      locala.LB = ((TextView)paramView.findViewById(2131362339));
      locala.jdField_Lz_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378586));
      locala.LA = ((TextView)paramView.findViewById(2131377211));
      locala.ej = ((Button)paramView.findViewById(2131377201));
      fI(locala.uw);
      paramView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setOnClickListener(this);
      a(this.mContext, paramView, paramInt, this.jdField_a_of_type_Ytv, locala, this);
      locala.jdField_Lz_of_type_AndroidViewView.setBackgroundResource(2130839639);
      localQIMFollwerAdd = ((yuf)this.jdField_a_of_type_Ytv).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      locala.Lx.setVisibility(0);
      locala.Lx.setText(localQIMFollwerAdd.smartRemark);
      localObject = locala.jdField_Lz_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Ytv.isReaded()) {
        break label483;
      }
      bool = true;
      label268:
      C((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(locala.LB, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      locala.Ly.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), acfp.m(2131711220), new Object[] { localQIMFollwerAdd.source });
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      locala.LA.setVisibility(8);
      locala.ej.setText(acfp.m(2131711219));
      locala.ej.setVisibility(0);
      locala.ej.setOnClickListener(this);
      locala.aZH = String.valueOf(localQIMFollwerAdd.uin);
      locala.uw.setImageBitmap(this.jdField_a_of_type_Ytd.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      locala = (ysz.a)paramView.getTag();
      break;
      label470:
      locala.Lx.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      locala.Ly.setVisibility(0);
      locala.Ly.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.enableTalkBack) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  protected void clg()
  {
    ThreadManager.postImmediately(new QIMFollowerAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      fJ(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((FlashChatManager)this.mApp.getManager(217)).a(this.mContext, null);
    }
  }
  
  protected int xl()
  {
    return 1;
  }
  
  public static class a
    extends ysa.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */