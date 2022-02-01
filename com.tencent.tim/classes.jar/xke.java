import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.open.adapter.OpenAppClient;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class xke
  extends wjd
{
  View.OnClickListener onClickListener = new xkf(this);
  
  public xke(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void G(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPubAccount))
    {
      paramChatMessage = (MessageForPubAccount)paramChatMessage;
      if ((paramChatMessage.mPAMessage != null) && (paramChatMessage.mPAMessage.mMsgId > 0L))
      {
        anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", paramChatMessage.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramChatMessage.mPAMessage.mMsgId), "", "", "");
        if ((this.app.getManager(56) != null) && (((acja)this.app.getManager(56)).e(this.sessionInfo)) && (paramChatMessage.mPAMessage.items != null) && (paramChatMessage.mPAMessage.items.size() > 0))
        {
          String str = ((PAMessage.Item)paramChatMessage.mPAMessage.items.get(0)).title;
          sqn.b(paramChatMessage.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.sessionInfo.aTn, str });
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    if (obj.d(paramString1, paramContext)) {
      return;
    }
    if ((paramString2 != null) && (paramString2.equals("open_local")))
    {
      paramString1 = new Bundle();
      paramString1.putString("schemaurl", paramString3);
      paramString1.putString("uin", paramQQAppInterface.getCurrentAccountUin());
      OpenAppClient.r((Activity)paramContext, paramString1);
      return;
    }
    paramString1 = new Intent(paramContext, PublicAccountBrowser.class);
    paramString1.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString1.putExtra("url", paramString3);
    paramString1.putExtra("assignBackText", paramContext.getResources().getString(2131691039));
    paramString1.putExtra("puin", paramString4);
    if (paramLong >= 0L) {
      paramString1.putExtra("msg_id", String.valueOf(paramLong));
    }
    paramString1.putExtra("source_name", paramString5);
    paramString1.putExtra("fromAio", true);
    paramString1.putExtra("uin_type", 1008);
    paramString1.putExtra("big_brother_source_key", ocp.fq(paramString4));
    ocp.f(paramString1, paramString3);
    paramContext.startActivity(paramString1);
    anot.b(null, "P_CliOper", "Pb_account_lifeservice", paramString4, "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString3, "", "", "");
  }
  
  private void a(xke.a parama, ChatMessage paramChatMessage, long paramLong)
  {
    if ((parama == null) || (paramChatMessage == null)) {}
    label25:
    kdm localkdm;
    kec localkec;
    label93:
    label228:
    label234:
    do
    {
      return;
      String str;
      aqhv localaqhv;
      int i;
      if (TextUtils.isEmpty(parama.a_actionData))
      {
        str = parama.actionData;
        localkdm = (kdm)this.app.getManager(88);
        localkec = (kec)this.app.getBusinessHandler(88);
        if (TextUtils.isEmpty(str)) {
          break label475;
        }
        localaqhv = aqik.c(this.app, this.mContext, str);
        if (localaqhv != null) {
          break label300;
        }
        if (parama.appId != 0L) {
          break label228;
        }
        i = 0;
        if (i == 0) {
          break label259;
        }
        if (a(this.app, this.mContext, parama.aVa, parama.appId, str)) {
          break label234;
        }
        a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
      }
      for (;;)
      {
        PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
        if ((paramChatMessage == null) || (localkdm == null) || (localkec == null) || (!localkdm.dr(paramChatMessage.senderuin))) {
          break;
        }
        localkec.a(false, paramChatMessage, 1, str);
        return;
        str = parama.a_actionData;
        break label25;
        i = 1;
        break label93;
        PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        continue;
        a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
        continue;
        if (TextUtils.isEmpty(localaqhv.getServerName()))
        {
          if (!a(this.app, this.mContext, parama.aVa, parama.appId, str)) {
            a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
          } else {
            PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
          }
        }
        else if (!localaqhv.ace()) {
          a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
        } else {
          PublicAccountHandler.a(this.app, this.sessionInfo.aTl, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
        }
      }
      a(this.app, this.mContext, parama.aVa, parama.aVb, parama.aVc, this.sessionInfo.aTl, this.sessionInfo.aTn, paramLong);
    } while ((paramChatMessage == null) || (localkdm == null) || (localkec == null) || (!localkdm.dr(paramChatMessage.senderuin)));
    label259:
    label300:
    label475:
    localkec.a(false, paramChatMessage, 1, parama.aVc);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    int i = 0;
    paramString2 = Uri.parse(paramString2);
    paramString1 = paramString2.getScheme();
    paramString2 = paramString2.getHost();
    if ((!TextUtils.isEmpty(paramString1)) && (arxn.appIsExists(paramString1)))
    {
      anan localanan = new anan();
      if (anan.ea(paramString2) == 0) {}
      Bundle localBundle;
      int j;
      for (;;)
      {
        localBundle = anan.f(paramString2);
        j = localBundle.getInt("a_launch_mode", 268435456);
        if (i == 0) {
          break;
        }
        localanan.a(paramQQAppInterface, paramContext, String.valueOf(paramLong), paramString2, paramString1, j);
        return true;
        i = 1;
      }
      return arxn.a(paramContext, paramString1, localBundle, j);
    }
    return false;
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout.setPadding(0, wja.dp2px(11.0F, this.mContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.mContext).inflate(2131558911, null);
    }
    paramView = (MessageForPubAccount)paramMessageRecord;
    parama = (xke.a)parama;
    View localView = paramLinearLayout.findViewById(2131372799);
    Object localObject5 = (TextView)paramLinearLayout.findViewById(2131372785);
    Object localObject2 = (TextView)paramLinearLayout.findViewById(2131372801);
    Object localObject3 = (TextView)paramLinearLayout.findViewById(2131372800);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131372798);
    Object localObject6 = (TextView)paramLinearLayout.findViewById(2131372790);
    Object localObject7 = (TextView)paramLinearLayout.findViewById(2131372791);
    Object localObject8 = (TextView)paramLinearLayout.findViewById(2131372792);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131372793);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131372794);
    Object localObject4 = (TextView)paramLinearLayout.findViewById(2131372796);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject6);
    localArrayList.add(localObject7);
    localArrayList.add(localObject8);
    localArrayList.add(localTextView1);
    localArrayList.add(localTextView2);
    localObject6 = paramView.mPAMessage;
    label405:
    int i;
    long l;
    if (((PAMessage)localObject6).grayTips != null)
    {
      ((TextView)localObject5).setText(((PAMessage)localObject6).grayTips);
      ((TextView)localObject5).setVisibility(0);
      localObject5 = (PAMessage.Item)((PAMessage)localObject6).items.get(0);
      parama.aVc = ((PAMessage.Item)localObject5).url;
      parama.aVb = ((PAMessage.Item)localObject5).actionUrl;
      parama.aVa = ((PAMessage.Item)localObject5).nativeJumpString;
      parama.bTA = ((PAMessage)localObject6).type;
      parama.itemType = 5;
      parama.bP = Long.valueOf(paramView.uniseq);
      parama.aVd = ((PAMessage)localObject6).moreText;
      parama.appId = ((PAMessage.Item)localObject5).appId;
      parama.actionData = ((PAMessage.Item)localObject5).actionData;
      parama.a_actionData = ((PAMessage.Item)localObject5).a_actionData;
      parama.i_actionData = ((PAMessage.Item)localObject5).i_actionData;
      if (TextUtils.isEmpty(((PAMessage)localObject6).moreText)) {
        break label830;
      }
      ((TextView)localObject4).setText(((PAMessage)localObject6).moreText);
      localObject4 = jqo.aD(((PAMessage.Item)localObject5).title);
      ((TextView)localObject2).setText((CharSequence)localObject4);
      if (((PAMessage.Item)localObject5).mVideoFlag == 1)
      {
        localObject7 = this.mContext.getResources().getDrawable(2130843500);
        i = aqcx.dip2px(this.mContext, 5.0F);
        ((Drawable)localObject7).setBounds(i, 0, aqcx.dip2px(this.mContext, 17.0F) + i, aqcx.dip2px(this.mContext, 20.0F));
        localObject8 = new SpannableString((String)localObject4 + "1");
        ((SpannableString)localObject8).setSpan(new ImageSpan((Drawable)localObject7, 0), ((String)localObject4).length(), ((String)localObject4).length() + 1, 17);
        ((TextView)localObject2).setText((CharSequence)localObject8);
      }
      if (((PAMessage.Item)localObject5).time == 0L) {
        break label841;
      }
      l = ((PAMessage.Item)localObject5).time;
      label572:
      if (l == 0L) {
        break label851;
      }
      ((TextView)localObject3).setText(aqmu.b(this.mContext, l * 1000L));
      ((TextView)localObject3).setVisibility(0);
    }
    for (;;)
    {
      try
      {
        localObject2 = obs.a(((PAMessage.Item)localObject5).cover, 0);
        i = this.mContext.getResources().getDisplayMetrics().widthPixels;
        int j = wja.dp2px(50.0F, this.mContext.getResources());
        int k = wja.dp2px(150.0F, this.mContext.getResources());
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (i - j);
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = k;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
        ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
        ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
        paramMessageRecord = URLDrawable.getDrawable((URL)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        paramMessageRecord.addHeader("my_uin", this.app.getCurrentAccountUin());
        ((ImageView)localObject1).setImageDrawable(paramMessageRecord);
        paramMessageRecord = ((PAMessage.Item)localObject5).digestList;
        if (paramMessageRecord != null)
        {
          i = paramMessageRecord.size();
          j = 0;
          if (j < localArrayList.size())
          {
            localObject1 = (TextView)localArrayList.get(j);
            if (i > j)
            {
              ((TextView)localObject1).setText((CharSequence)paramMessageRecord.get(j));
              ((TextView)localObject1).setVisibility(0);
              j += 1;
              continue;
              ((TextView)localObject5).setVisibility(8);
              break;
              label830:
              ((TextView)localObject4).setText(2131696709);
              break label405;
              label841:
              l = ((PAMessage)localObject6).sendTime;
              break label572;
              label851:
              ((TextView)localObject3).setVisibility(8);
              continue;
            }
          }
        }
      }
      catch (Exception paramMessageRecord)
      {
        ((ImageView)localObject1).setImageResource(2130838158);
        continue;
        ((TextView)localObject1).setVisibility(8);
        continue;
        localView.setTag(parama);
        localView.setOnClickListener(this.onClickListener);
        localView.setOnTouchListener(paramwlz);
        localView.setOnLongClickListener(paramwlz);
        if ((this.app.getManager(56) != null) && (((acja)this.app.getManager(56)).e(this.sessionInfo)) && (paramView.mPAMessage.items != null) && (paramView.mPAMessage.items.size() > 0)) {
          sqn.b(paramView.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.sessionInfo.aTn, localObject4 });
        }
        return paramLinearLayout;
      }
      i = 0;
    }
  }
  
  protected wjd.a a()
  {
    return new xke.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
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
    return paramView.a();
  }
  
  class a
    extends wjd.a
  {
    public String aVa;
    public String aVb;
    public String aVc;
    public String aVd;
    public String a_actionData;
    public String actionData;
    public long appId;
    public Object bP;
    public int bTA;
    public String i_actionData;
    public int itemType;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xke
 * JD-Core Version:    0.7.0.1
 */