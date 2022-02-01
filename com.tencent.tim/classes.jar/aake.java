import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentLiveTipItemBuilder.1;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aake
  extends aakb
{
  public static int chn;
  private int chr;
  private Map<String, Boolean> iF = new HashMap();
  private int mScreenWidth;
  private List<String> vo;
  
  private void a(FragmentActivity paramFragmentActivity, MessageForNearbyLiveTip paramMessageForNearbyLiveTip)
  {
    Boolean localBoolean = (Boolean)this.iF.get(paramMessageForNearbyLiveTip.senderuin);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      this.iF.put(paramMessageForNearbyLiveTip.senderuin, Boolean.valueOf(true));
      paramFragmentActivity = paramFragmentActivity.app;
      ThreadManagerV2.excute(new RecentLiveTipItemBuilder.1(this, paramFragmentActivity, paramMessageForNearbyLiveTip, (ajpj)paramFragmentActivity.getManager(106)), 32, null, false);
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, aake.a parama)
  {
    MessageForNearbyLiveTip localMessageForNearbyLiveTip;
    Object localObject;
    if ((paramRecentBaseData instanceof RecentItemNearbyLiveTipData))
    {
      localMessageForNearbyLiveTip = ((RecentItemNearbyLiveTipData)paramRecentBaseData).nearbyLiveTipMsg;
      if (localMessageForNearbyLiveTip != null) {
        if (top.gV(localMessageForNearbyLiveTip.senderuin))
        {
          if (paramRecentBaseData.wU() >= 1) {
            break label355;
          }
          localObject = "0";
        }
      }
    }
    for (;;)
    {
      anot.a(null, "dc00899", "grp_lbs", "", "msg_box", "assist_exp", 0, 0, "", "", "", (String)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = parama.a.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = parama.a.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aqhu.at();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aqhu.at();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      try
      {
        localObject = URLDrawable.getDrawable(localMessageForNearbyLiveTip.headUrl, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
        parama.a.setImageDrawable((Drawable)localObject);
        parama.title.setText(localMessageForNearbyLiveTip.nickName);
        if ((MessageForNearbyLiveTip.isHuayangTip(localMessageForNearbyLiveTip.jumpingUrl)) && (!localMessageForNearbyLiveTip.isLiving))
        {
          if (!TextUtils.isEmpty(localMessageForNearbyLiveTip.c2cMsgWording)) {
            localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.c2cMsgWording;
          }
        }
        else
        {
          parama.description.setText(localMessageForNearbyLiveTip.msg);
          if (localMessageForNearbyLiveTip.senderuin.equals(String.valueOf(1822701914L + acbn.Pd))) {
            localMessageForNearbyLiveTip.isLiving = false;
          }
          if ((!localMessageForNearbyLiveTip.isLiving) || (MessageForNearbyLiveTip.isGroupVideoTip(localMessageForNearbyLiveTip.jumpingUrl))) {
            break label457;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          try
          {
            localObject = aomc.l("https://8.url.cn/huayang/resource/now/gift/ilive_animation.gif");
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mPlayGifImage = true;
            localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            parama.b.setImageDrawable((Drawable)localObject);
            parama.Oa.setVisibility(0);
            parama.b.setVisibility(0);
            parama.NX.setVisibility(8);
            a(parama, paramContext);
            b(paramView, paramRecentBaseData, paramContext, parama);
            a((FragmentActivity)paramContext, localMessageForNearbyLiveTip);
            return;
            label355:
            localObject = "1";
            break;
            localException = localException;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.nearby.tag_nearby_live_tip", 2, "url=" + localMessageForNearbyLiveTip.headUrl);
            continue;
            localMessageForNearbyLiveTip.msg = localMessageForNearbyLiveTip.liveEndWording;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.nearby.freshNews", 2, "RecentLiveTipItemBuilder getview get nowBoardcastGif error, " + localMalformedURLException);
            continue;
          }
          label457:
          parama.Oa.setVisibility(8);
          parama.b.setVisibility(8);
          parama.NX.setVisibility(0);
          parama.NX.setText(paramRecentBaseData.mShowTime);
        }
      }
    }
  }
  
  private void b(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, aake.a parama)
  {
    int j = 1;
    int k = 0;
    int i = paramRecentBaseData.mUnreadNum;
    int m = paramRecentBaseData.mUnreadFlag;
    if (i > 0) {
      if (m == 0)
      {
        parama.h.setDragViewType(-1, paramView);
        j = 0;
        i = 0;
      }
    }
    for (;;)
    {
      aute.updateCustomNoteTxt(parama.h, i, k, j, 99, null);
      return;
      if (m == 2)
      {
        parama.h.setDragViewType(-1, paramView);
        m = 0;
        i = j;
        j = m;
      }
      else if (m == 3)
      {
        parama.h.setDragViewType(1, paramView);
        parama.h.setTextColor(paramContext.getResources().getColor(2131167428));
        j = 2130851408;
        m = 3;
        k = i;
        i = m;
      }
      else
      {
        j = 2130851404;
        parama.h.setDragViewType(0, paramView);
        parama.h.setTextColor(paramContext.getResources().getColor(2131167429));
        k = i;
        i = 3;
        continue;
        j = 0;
        i = 0;
      }
    }
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramc = null;
    paramViewGroup = paramc;
    if (paramView != null)
    {
      paramViewGroup = paramc;
      if ((paramView.getTag() instanceof aake.a)) {
        paramViewGroup = (aake.a)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new aake.a();
      paramView = a(paramContext, 2131562964, paramViewGroup);
      paramViewGroup.a = ((URLThemeImageView)paramView.findViewById(2131368698));
      paramViewGroup.h = ((DragTextView)paramView.findViewById(2131381288));
      paramViewGroup.title = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.Oa = ((TextView)paramView.findViewById(2131370616));
      paramViewGroup.b = ((URLThemeImageView)paramView.findViewById(2131370614));
      paramViewGroup.NX = ((TextView)paramView.findViewById(2131370129));
      paramViewGroup.description = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.zB = paramView.findViewById(2131379403);
      paramView.setTag(paramViewGroup);
      if (this.c != null) {
        paramViewGroup.h.setOnModeChangeListener(this.c.a());
      }
      this.mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      this.chr = ((int)paramViewGroup.Oa.getPaint().measureText(paramViewGroup.Oa.getText().toString()));
    }
    for (;;)
    {
      paramViewGroup.h.setTag(Integer.valueOf(paramInt));
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(null);
      }
      if ((paramObject instanceof RecentBaseData))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramc = null;
        if (paramaajx != null) {
          paramc = paramaajx.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramc);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        paramViewGroup.title.setText("");
        paramViewGroup.Oa.setVisibility(8);
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.description.setText("");
        paramViewGroup.NX.setText("");
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    for (;;)
    {
      this.vo.add(paramRecentBaseData.getString(fy[0]));
      return this.vo;
      this.vo.clear();
    }
  }
  
  protected void a(aake.a parama, Context paramContext)
  {
    try
    {
      localObject = parama.NX;
      localView = parama.zB;
      parama = parama.title;
      if (((TextView)localObject).getVisibility() != 0)
      {
        i = ankt.dip2px(12.0F);
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        parama.setMaxWidth(this.mScreenWidth - this.chr - ankt.dip2px(113.0F));
        return;
      }
      parama = aale.a().t("000000", 1225168973512L);
      if (!TextUtils.isEmpty(parama)) {
        break label318;
      }
      parama = aale.a().qy();
    }
    catch (Exception parama)
    {
      Object localObject;
      View localView;
      int i;
      float f;
      int j;
      label292:
      label318:
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentLiveTipItemBuilder", 4, parama.toString());
        return;
        chn = i;
        continue;
        chn = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
    }
    if ((!TextUtils.isEmpty(parama)) && (parama.length() != "yyyy-MM-dd".length()))
    {
      i = 1;
      if ((chn <= 0) || (i != 0))
      {
        f = paramContext.getResources().getDisplayMetrics().density;
        localObject = ((TextView)localObject).getPaint();
        paramContext = (Context)localObject;
        if (localObject == null)
        {
          paramContext = new TextPaint();
          paramContext.setTextSize(f * 12.0F);
        }
        if (i == 0) {
          break label292;
        }
        i = (int)(paramContext.measureText("yyyy-MM-dd") + f * 6.0F);
        j = (int)(paramContext.measureText(parama) + f * 6.0F);
        if (j > i) {
          chn = j;
        }
      }
      else
      {
        i = localView.getPaddingRight();
        if (i >= chn) {
          return;
        }
        localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), i, localView.getPaddingBottom());
        return;
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
      paramDrawable = null;
      if ((localObject instanceof aake.a)) {
        paramDrawable = (aake.a)localObject;
      }
      if (paramDrawable != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
    return;
    a(paramView, paramRecentBaseData, paramContext, paramDrawable);
  }
  
  public int xV()
  {
    return 2;
  }
  
  public static class a
    extends aakb.a
  {
    public TextView NX;
    public TextView Oa;
    public URLThemeImageView a;
    public URLThemeImageView b;
    public TextView description;
    public DragTextView h;
    public TextView title;
    public View zB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aake
 * JD-Core Version:    0.7.0.1
 */