import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class xpo
  extends wjd
  implements View.OnClickListener
{
  int Dk = 0;
  int bTB = 0;
  int bVU = 0;
  String[] cH;
  int[] hx;
  
  public xpo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.Dk = wja.dp2px(16.0F, paramContext.getResources());
    this.bTB = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296424) * 2);
    this.bVU = ((int)(0.4531835F * this.bTB));
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 8);
    }
    this.cH = paramContext.getResources().getStringArray(2130968581);
    this.hx = paramContext.getResources().getIntArray(2130968580);
  }
  
  private View a(View paramView, xpo.a parama)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558927, null);
      parama.kE = paramView.findViewById(2131365360);
      parama.mask = paramView.findViewById(2131371159);
      parama.JW = ((TextView)paramView.findViewById(2131370461));
      parama.JX = ((TextView)paramView.findViewById(2131370462));
      parama.JY = ((TextView)paramView.findViewById(2131370463));
      parama.tD = ((ImageView)paramView.findViewById(2131368396));
      parama.tC = ((ImageView)paramView.findViewById(2131368413));
      localObject = (ViewGroup.MarginLayoutParams)parama.kE.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.bVU;
      parama.kE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      parama.kE.setOnTouchListener(jll.a);
      localObject = paramView;
      if (aTl)
      {
        parama.E = new StringBuilder();
        localObject = paramView;
      }
    }
    if (aTl)
    {
      ((View)localObject).setContentDescription(null);
      parama.E.replace(0, parama.E.length(), "");
    }
    return localObject;
  }
  
  @Nullable
  private BaseChatPie c()
  {
    if ((this.mContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.mContext).getChatFragment();
      if (localChatFragment == null) {
        return null;
      }
      return localChatFragment.a();
    }
    return null;
  }
  
  private void g(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    }
    for (;;)
    {
      if (paramDrawable != null) {
        paramDrawable.invalidateSelf();
      }
      return;
      if ((paramDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)paramDrawable).setColor(paramInt);
      }
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    int j = 0;
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    parama = (xpo.a)parama;
    paramView = a(paramView, parama);
    parama.uniseq = paramLinearLayout.uniseq;
    parama.friendUin = Long.toString(paramLinearLayout.frdUin);
    parama.a = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = aoop.TRANSLUCENT;
    paramMessageRecord.mFailedDrawable = aoop.TRANSLUCENT;
    paramMessageRecord.mRequestHeight = this.bVU;
    paramMessageRecord.mRequestWidth = this.bTB;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    parama.kE.setBackgroundDrawable(paramMessageRecord);
    parama.JW.setTextColor(paramLinearLayout.txtColor);
    parama.JX.setTextColor(paramLinearLayout.txtColor);
    parama.JY.setTextColor(paramLinearLayout.txtColor);
    g(parama.JY.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    if ((this.cH != null) && (this.cH.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0))
    {
      paramMessageRecord = this.cH[paramLinearLayout.inimateType];
      parama.JX.setText(paramView.getContext().getString(2131690251, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * paramLinearLayout.bindTime);
      parama.JY.setText(paramView.getContext().getString(2131690252, new Object[] { paramMessageRecord }));
      paramMessageRecord = aqdj.a(this.app, 1, String.valueOf(paramLinearLayout.frdUin));
      parama.tD.setImageDrawable(paramMessageRecord);
      paramMessageRecord = aqdj.a(this.app, 1, this.app.getCurrentAccountUin());
      parama.tC.setImageDrawable(paramMessageRecord);
      boolean bool = ThemeUtil.isInNightMode(this.app);
      paramMessageRecord = parama.mask;
      if (!bool) {
        break label510;
      }
    }
    label510:
    for (int i = 0;; i = 8)
    {
      paramMessageRecord.setVisibility(i);
      parama.kE.setTag(parama);
      if (aTl)
      {
        parama.E.append(parama.JW.getText()).append(parama.JX.getText()).append(parama.JY.getText());
        paramView.setContentDescription(parama.E.toString());
      }
      parama.kE.setOnClickListener(this);
      i = j;
      if (this.hx != null)
      {
        i = j;
        if (this.hx.length > paramLinearLayout.inimateType)
        {
          i = j;
          if (paramLinearLayout.inimateType >= 0) {
            i = this.hx[paramLinearLayout.inimateType];
          }
        }
      }
      aohm.I(this.app, "0X800AE61", i);
      return paramView;
      paramMessageRecord = "";
      break;
    }
  }
  
  protected wjd.a a()
  {
    return new xpo.a();
  }
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public void onClick(View paramView)
  {
    xpo.a locala = (xpo.a)paramView.getTag();
    if (locala == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    BaseChatPie localBaseChatPie = c();
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof xys)) && (localBaseChatPie.a != null)) {
      localBaseChatPie.a.yY(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "jumpIntimatePage:" + locala.friendUin);
    }
    if ((this.hx != null) && (this.hx.length > locala.a.inimateType) && (locala.a.inimateType >= 0)) {}
    for (int i = this.hx[locala.a.inimateType];; i = 0)
    {
      aohm.I(this.app, "0X800AE62", i);
      break;
    }
  }
  
  class a
    extends wjd.a
  {
    TextView JW;
    TextView JX;
    TextView JY;
    MessageForTofuIntimateAnniversary jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary;
    public String friendUin;
    View kE;
    View mask;
    ImageView tC;
    ImageView tD;
    public long uniseq;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpo
 * JD-Core Version:    0.7.0.1
 */