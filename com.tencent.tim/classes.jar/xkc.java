import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;

public class xkc
  extends wjd
{
  View.OnClickListener onClickListener = new xkd(this);
  
  public xkc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(MessageForPubAccount paramMessageForPubAccount, xkc.a parama, long paramLong, String paramString)
  {
    if ((parama == null) || (paramMessageForPubAccount == null)) {}
    do
    {
      return;
      if (paramLong > 0L) {
        anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", paramMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramLong), "", "", "");
      }
      kdm localkdm = (kdm)this.app.getManager(88);
      kec localkec = (kec)this.app.getBusinessHandler(88);
      if ((localkdm != null) && (localkec != null) && (localkdm.dr(paramMessageForPubAccount.senderuin))) {
        localkec.a(false, paramMessageForPubAccount, parama.itemIndex + 1, paramString);
      }
    } while ((this.app.getManager(56) == null) || (!((acja)this.app.getManager(56)).e(this.sessionInfo)) || (paramMessageForPubAccount.mPAMessage.items == null) || (paramMessageForPubAccount.mPAMessage.items.size() <= 0));
    sqn.b(paramMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.sessionInfo.aTn, ((PAMessage.Item)paramMessageForPubAccount.mPAMessage.items.get(0)).title });
  }
  
  private void a(PAMessage.Item paramItem, xkc.a parama, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      aqhv localaqhv = aqik.c(this.app, this.mContext, paramString);
      int i;
      if (localaqhv == null) {
        if (paramItem.appId != 0L)
        {
          i = 1;
          if (i == 0) {
            break label155;
          }
          if (xke.a(this.app, this.mContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            break label132;
          }
          xke.a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
        }
      }
      for (;;)
      {
        PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
        return;
        i = 0;
        break;
        label132:
        PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        continue;
        label155:
        xke.a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
        continue;
        if (TextUtils.isEmpty(localaqhv.getServerName()))
        {
          if (!xke.a(this.app, this.mContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            xke.a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
          } else {
            PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
          }
        }
        else if (!localaqhv.ace()) {
          xke.a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
        } else {
          PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
        }
      }
    }
    xke.a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364503);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.bNX, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramView = new LinearLayout(this.mContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    int k = (int)(0.5D * BaseChatItemLayout.mDensity);
    ArrayList localArrayList = localPAMessage.items;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    Object localObject1;
    if (localPAMessage.grayTips != null)
    {
      parama = new TextView(this.mContext);
      parama.setText(localPAMessage.grayTips);
      parama.setGravity(17);
      parama.setSingleLine();
      parama.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = aqcx.dip2px(this.mContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = aqcx.dip2px(this.mContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = aqcx.dip2px(this.mContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = aqcx.dip2px(this.mContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      parama.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      parama.setBackgroundResource(2130845675);
      parama.setPadding(aqcx.dip2px(this.mContext, 9.0F), aqcx.dip2px(this.mContext, 4.0F), aqcx.dip2px(this.mContext, 9.0F), aqcx.dip2px(this.mContext, 4.0F));
      parama.setTextColor(-1);
      parama.setTextSize(12.0F);
      localViewGroup.addView(parama);
    }
    int i = 0;
    label376:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new xkc.a();
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((xkc.a)localObject1).itemType = 5;
      ((xkc.a)localObject1).aVc = localItem.url;
      ((xkc.a)localObject1).bTA = localPAMessage.type;
      ((xkc.a)localObject1).aVb = localItem.actionUrl;
      ((xkc.a)localObject1).aVa = localItem.nativeJumpString;
      ((xkc.a)localObject1).uniseq = paramLinearLayout.uniseq;
      ((xkc.a)localObject1).itemIndex = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        parama = LayoutInflater.from(this.mContext).inflate(2131558910, null);
        localObject3 = (TextView)parama.findViewById(2131372789);
        localObject2 = (ImageView)parama.findViewById(2131372788);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.mContext.getResources().getDimensionPixelSize(2131296467));
        }
        String str = jqo.aD(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.mContext.getResources();
          if (i != 0) {
            break label953;
          }
          j = 2130843499;
          label481:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = aqcx.dip2px(this.mContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, aqcx.dip2px(this.mContext, 17.0F) + j, aqcx.dip2px(this.mContext, 20.0F));
          SpannableString localSpannableString = new SpannableString(str + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject4, 0), str.length(), str.length() + 1, 17);
          ((TextView)localObject3).setText(localSpannableString);
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
          if (i != 0) {
            continue;
          }
          j = this.mContext.getResources().getDisplayMetrics().widthPixels;
          int m = wja.dp2px(50.0F, this.mContext.getResources());
          int n = wja.dp2px(150.0F, this.mContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(obs.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label953:
          ((ImageView)localObject2).setImageResource(2130838158);
          continue;
        }
        localViewGroup.addView(parama);
        parama.setTag(localObject1);
        parama.setOnClickListener(this.onClickListener);
        parama.setOnTouchListener(paramwlz);
        parama.setOnLongClickListener(paramwlz);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          parama = new ImageView(this.mContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = aqcx.dip2px(this.mContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          parama.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          parama.setBackgroundResource(2131166185);
          localViewGroup.addView(parama);
          parama = LayoutInflater.from(this.mContext).inflate(2131558908, null);
          break label376;
        }
        if (i != 1)
        {
          parama = new ImageView(this.mContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = aqcx.dip2px(this.mContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          parama.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          parama.setBackgroundResource(2131166185);
          localViewGroup.addView(parama);
        }
        parama = LayoutInflater.from(this.mContext).inflate(2131558909, null);
        break label376;
        j = 2130843500;
        break label481;
        j = wja.dp2px(50.0F, this.mContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838401);
    if ((this.app.getManager(56) != null) && (((acja)this.app.getManager(56)).e(this.sessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      sqn.b(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.sessionInfo.aTn, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
    }
    return paramView;
  }
  
  protected wjd.a a()
  {
    return new xkc.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = ujt.a(this.app, this.sessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      ujt.a(this.app, this.sessionInfo);
    }
    paramContext = this.app;
    Context localContext = this.mContext;
    String str = this.sessionInfo.aTl;
    paramInt = this.sessionInfo.cZ;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      ocp.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    paramView.Z(2131365686, this.mContext.getString(2131691404), 2130839081);
    a(paramView);
    return paramView.a();
  }
  
  class a
    extends wjd.a
  {
    public String aVa;
    public String aVb;
    public String aVc;
    public int bTA;
    int itemIndex;
    public int itemType;
    public long uniseq;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkc
 * JD-Core Version:    0.7.0.1
 */