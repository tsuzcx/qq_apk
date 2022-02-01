import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;

public class xpp
  extends wjd
  implements View.OnClickListener
{
  int bVX = 0;
  int bVY = 0;
  
  public xpp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.bVX = wja.dp2px(251.0F, paramContext.getResources());
    this.bVY = wja.dp2px(131.0F, paramContext.getResources());
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 10);
    }
  }
  
  @NotNull
  private Drawable a(boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = aoop.TRANSLUCENT;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSLUCENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSLUCENT;
    localURLDrawableOptions.mRequestHeight = this.bVY;
    if (paramBoolean) {}
    for (int i = this.bVX;; i = (int)(0.5F * this.bVX))
    {
      localURLDrawableOptions.mRequestWidth = i;
      try
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.d("TofuNicePicsItemBuilder", 1, "getDrawable ex=" + paramString.getMessage(), paramString);
      }
    }
    return localDrawable;
  }
  
  private View a(View paramView, xpp.a parama)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558928, null);
      parama.kE = paramView.findViewById(2131365360);
      parama.mask = paramView.findViewById(2131371159);
      parama.tE = ((ImageView)paramView.findViewById(2131363431));
      parama.tF = ((ImageView)paramView.findViewById(2131370382));
      parama.tG = ((ImageView)paramView.findViewById(2131377320));
      parama.JW = ((TextView)paramView.findViewById(2131370461));
      parama.JX = ((TextView)paramView.findViewById(2131370462));
      parama.tips = ((TextView)paramView.findViewById(2131379724));
      parama.kE.setOnTouchListener(jll.a);
      localView = paramView;
      if (aTl)
      {
        parama.E = new StringBuilder();
        localView = paramView;
      }
    }
    if (aTl)
    {
      localView.setContentDescription(null);
      parama.E.replace(0, parama.E.length(), "");
    }
    return localView;
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (int i = 0;; i = 8)
    {
      paramImageView.setVisibility(i);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    int i = 8;
    paramLinearLayout = (MessageForTofuNicePics)paramMessageRecord;
    paramMessageRecord = (xpp.a)parama;
    parama = a(paramView, paramMessageRecord);
    paramMessageRecord.uniseq = paramLinearLayout.uniseq;
    paramMessageRecord.friendUin = Long.toString(paramLinearLayout.frdUin);
    paramMessageRecord.a = paramLinearLayout;
    if ((!TextUtils.isEmpty(paramLinearLayout.url1)) && (!TextUtils.isEmpty(paramLinearLayout.url2)))
    {
      paramView = a(false, paramLinearLayout.url1);
      paramwlz = a(false, paramLinearLayout.url2);
      a(paramMessageRecord.tF, paramView);
      a(paramMessageRecord.tG, paramwlz);
      a(paramMessageRecord.tE, null);
      paramView = xkj.U(this.sessionInfo.aTn, 6);
      paramView = this.mContext.getResources().getString(2131690253, new Object[] { paramView, Integer.valueOf(paramLinearLayout.countInc) });
      paramMessageRecord.JW.setText(paramView);
      if (paramLinearLayout.countInc <= 1) {
        break label397;
      }
      paramMessageRecord.tips.setText("共" + paramLinearLayout.countInc + "张");
      paramMessageRecord.tips.setVisibility(0);
    }
    for (;;)
    {
      paramView = aqmu.a(this.mContext, 7, paramLinearLayout.upTime * 1000L);
      paramMessageRecord.JX.setText(paramView);
      boolean bool = ThemeUtil.isInNightMode(this.app);
      paramView = paramMessageRecord.mask;
      if (bool) {
        i = 0;
      }
      paramView.setVisibility(i);
      paramMessageRecord.kE.setTag(paramMessageRecord);
      if (aTl)
      {
        paramMessageRecord.E.append(paramMessageRecord.JW.getText()).append(paramMessageRecord.JX.getText());
        parama.setContentDescription(paramMessageRecord.E.toString());
      }
      paramMessageRecord.kE.setOnClickListener(this);
      aohm.I(this.app, "0X800AE5F", 0);
      return parama;
      paramView = a(true, paramLinearLayout.url1);
      a(paramMessageRecord.tF, null);
      a(paramMessageRecord.tG, null);
      a(paramMessageRecord.tE, paramView);
      break;
      label397:
      paramMessageRecord.tips.setVisibility(8);
    }
  }
  
  protected wjd.a a()
  {
    return new xpp.a();
  }
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public void onClick(View paramView)
  {
    xpp.a locala = (xpp.a)paramView.getTag();
    if (locala == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PhotoWallView.e((Activity)paramView.getContext(), locala.friendUin, false);
      if (QLog.isColorLevel()) {
        QLog.d("TofuNicePicsItemBuilder", 2, "jump photowall:" + locala.friendUin);
      }
      aohm.I(this.app, "0X800AE60", 0);
    }
  }
  
  class a
    extends wjd.a
  {
    TextView JW;
    TextView JX;
    MessageForTofuNicePics jdField_a_of_type_ComTencentMobileqqDataMessageForTofuNicePics;
    public String friendUin;
    View kE;
    View mask;
    ImageView tE;
    ImageView tF;
    ImageView tG;
    TextView tips;
    public long uniseq;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpp
 * JD-Core Version:    0.7.0.1
 */