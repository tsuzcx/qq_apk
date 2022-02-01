import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xpn
  extends wjd
  implements View.OnClickListener, View.OnLayoutChangeListener
{
  int Dk = 0;
  int bTB = 0;
  int bVU = 0;
  int bVV = 0;
  int bVW = 0;
  int radius = 0;
  
  public xpn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.Dk = wja.dp2px(16.0F, paramContext.getResources());
    this.radius = wja.dp2px(108.0F, paramContext.getResources());
    this.bTB = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296424) * 2);
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 9);
    }
  }
  
  private View a(View paramView, xpn.a parama)
  {
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558926, null);
      parama.kE = paramView.findViewById(2131365360);
      parama.h = ((CornerImageView)paramView.findViewById(2131371159));
      parama.title = ((TextView)paramView.findViewById(2131379769));
      parama.p = new TextView[3];
      parama.p[0] = ((TextView)paramView.findViewById(2131370461));
      parama.p[1] = ((TextView)paramView.findViewById(2131370462));
      parama.p[2] = ((TextView)paramView.findViewById(2131370463));
      parama.divider = paramView.findViewById(2131365990);
      localObject1 = parama.title.getCompoundDrawables();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setColorFilter(-7894119, PorterDuff.Mode.SRC_IN);
        }
        i += 1;
      }
      parama.a = ((DrawCircleCornerImageView)paramView.findViewById(2131363394));
      parama.a.setRadius(this.Dk);
      parama.a.setImageDrawable(new ColorDrawable(-657670));
      parama.kE.setOnTouchListener(jll.a);
      parama.kE.addOnLayoutChangeListener(this);
      parama.h.setRadius(this.Dk);
      localObject1 = paramView;
      if (aTl)
      {
        parama.E = new StringBuilder();
        localObject1 = paramView;
      }
    }
    if (aTl)
    {
      ((View)localObject1).setContentDescription(null);
      parama.E.replace(0, parama.E.length(), "");
    }
    return localObject1;
  }
  
  private void a(xpn.a parama, int paramInt1, int paramInt2)
  {
    paramInt1 -= wja.dp2px(30.5F, this.mContext.getResources());
    paramInt2 = wja.dp2px(54.0F, this.mContext.getResources());
    if (paramInt1 > 0)
    {
      parama.a.setCircle(paramInt1, paramInt2, this.radius, -920839);
      parama.a.invalidate();
    }
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    int j = 8;
    paramMessageRecord = (MessageForTofuBaseProfile)paramMessageRecord;
    parama = (xpn.a)parama;
    paramView = a(paramView, parama);
    parama.uniseq = paramMessageRecord.uniseq;
    parama.friendUin = this.sessionInfo.aTl;
    paramLinearLayout = xkj.U(this.sessionInfo.aTn, 6);
    paramLinearLayout = paramView.getResources().getString(2131690249, new Object[] { paramLinearLayout });
    parama.title.setText(paramLinearLayout);
    int i = 0;
    if (i < 3)
    {
      if (parama.p[i] != null)
      {
        if (i >= paramMessageRecord.linesCnt) {
          break label152;
        }
        paramLinearLayout = paramMessageRecord.lines[i];
        parama.p[i].setText(paramLinearLayout);
        parama.p[i].setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        label152:
        parama.p[i].setText("");
        parama.p[i].setVisibility(8);
      }
    }
    paramLinearLayout = parama.divider;
    if (paramMessageRecord.linesCnt > 3) {}
    for (i = 0;; i = 8)
    {
      paramLinearLayout.setVisibility(i);
      boolean bool = ThemeUtil.isInNightMode(this.app);
      paramMessageRecord = parama.h;
      i = j;
      if (bool) {
        i = 0;
      }
      paramMessageRecord.setVisibility(i);
      parama.kE.setTag(parama);
      if (aTl)
      {
        parama.E.append(parama.title).append(parama.p[0].getText()).append(parama.p[1].getText()).append(parama.p[2].getText());
        paramView.setContentDescription(parama.E.toString());
      }
      parama.kE.setOnClickListener(this);
      aohm.I(this.app, "0X800AE5D", 0);
      return paramView;
    }
  }
  
  protected wjd.a a()
  {
    return new xpn.a();
  }
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  public void onClick(View paramView)
  {
    xpn.a locala = (xpn.a)paramView.getTag();
    if (locala == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2 = String.format("https://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { locala.friendUin, String.valueOf(this.app.getAppid()), "android-3.4.4" });
      Object localObject1 = localObject2;
      if (aqep.aBZ()) {
        localObject1 = (String)localObject2 + "&intl=1";
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (QQBrowserActivity.bs(500L)))
      {
        localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
        ((Intent)localObject2).putExtra("reqType", 1);
        ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_gxl");
        this.mContext.startActivity((Intent)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TofuBaseProfileItemBuilder", 2, "jump profile detail:" + locala.friendUin);
      }
      aohm.I(this.app, "0X800AE5E", 0);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getMeasuredWidth();
    paramInt2 = paramView.getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != this.bVV) && (paramInt2 != this.bVW))
    {
      paramView = (xpn.a)paramView.getTag();
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    this.bVV = paramInt1;
    this.bVW = paramInt2;
    a(paramView, paramInt1, paramInt2);
  }
  
  class a
    extends wjd.a
  {
    DrawCircleCornerImageView jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView;
    View divider;
    public String friendUin;
    CornerImageView h;
    View kE;
    TextView[] p;
    TextView title;
    public long uniseq;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpn
 * JD-Core Version:    0.7.0.1
 */