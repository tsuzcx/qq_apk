import android.content.Context;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.widget.FilterRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public class ahqq
  extends BaseBubbleBuilder
{
  @Nullable
  private static ArraySet<WeakReference<CustomFrameAnimationDrawable>> g;
  private static final SparseArrayCompat<String[]> h = new SparseArrayCompat();
  private HandlerThread P;
  private ArraySet<Long> c = new ArraySet();
  private int daE;
  private int daF;
  private int daG;
  private int daH;
  private int daI;
  private int daJ;
  private final ArrayMap<String, Boolean> k = new ArrayMap();
  private int logoHeight;
  private int logoWidth;
  
  public ahqq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    paramQQAppInterface = paramContext.getResources();
    this.daE = paramQQAppInterface.getDimensionPixelSize(2131297384);
    this.daF = paramQQAppInterface.getDimensionPixelSize(2131297383);
    this.logoWidth = paramQQAppInterface.getDimensionPixelSize(2131297388);
    this.logoHeight = paramQQAppInterface.getDimensionPixelSize(2131297387);
    this.daG = paramQQAppInterface.getDimensionPixelSize(2131297390);
    this.daH = paramQQAppInterface.getDimensionPixelSize(2131297389);
    this.daI = paramQQAppInterface.getDimensionPixelSize(2131297386);
    this.daJ = paramQQAppInterface.getDimensionPixelSize(2131297385);
  }
  
  private String a(MessageForFuDai paramMessageForFuDai)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForFuDai.aioTails);
    if (paramMessageForFuDai.isExpired()) {
      localStringBuilder.append("，").append(this.mContext.getResources().getString(2131694085));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (paramMessageForFuDai.isGrabByMe()) {
        localStringBuilder.append("，").append(this.mContext.getResources().getString(2131694084));
      } else if (paramMessageForFuDai.isEmpty()) {
        localStringBuilder.append("，").append(this.mContext.getResources().getString(2131694086));
      }
    }
  }
  
  private void a(ahqq.a parama)
  {
    ahqq.a.a(parama).setFilter(-1711276033);
    ahqq.a.c(parama).setVisibility(0);
    ahqq.a.d(parama).setVisibility(8);
    ahqq.a.a(parama).setImageResource(2130846159);
    ahqq.a.c(parama).setImageResource(2130846160);
  }
  
  private void a(MessageForFuDai paramMessageForFuDai, int paramInt) {}
  
  @Nullable
  private BaseChatPie e()
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
  
  public static void pause()
  {
    if (g == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext())
      {
        CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)localIterator.next()).get();
        if (localCustomFrameAnimationDrawable != null) {
          localCustomFrameAnimationDrawable.cdI();
        }
      }
    }
  }
  
  public static void resume()
  {
    if (g == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = g.iterator();
      while (localIterator.hasNext())
      {
        CustomFrameAnimationDrawable localCustomFrameAnimationDrawable = (CustomFrameAnimationDrawable)((WeakReference)localIterator.next()).get();
        if (localCustomFrameAnimationDrawable != null) {
          localCustomFrameAnimationDrawable.resume();
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    parame = (ahqq.a)parame;
    MessageForFuDai localMessageForFuDai = (MessageForFuDai)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.mContext).inflate(2131561371, paramBaseChatItemLayout, false);
      ahqq.a.a(parame, paramChatMessage);
      paramChatMessage.setOnLongClickListener(paramwlz);
      paramChatMessage.setOnTouchListener(paramwlz);
      ahqq.a.a(parame).setOnClickListener(this);
      ahqq.a.a(parame).setOnTouchListener(paramwlz);
      ahqq.a.a(parame).setOnLongClickListener(paramwlz);
    }
    if (aTl)
    {
      paramView = a(localMessageForFuDai);
      aqcl.changeAccessibilityForView(ahqq.a.a(parame), paramView, View.class.getName());
      paramChatMessage.setContentDescription(paramView);
    }
    ahqq.a.a(parame, localMessageForFuDai);
    if (TextUtils.isEmpty(localMessageForFuDai.aioTails))
    {
      ahqq.a.a(parame).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("FudaiItemBuilder", 2, "no logo res");
      }
      ahqq.a.b(parame).setVisibility(8);
      if (!localMessageForFuDai.isExpired()) {
        break label255;
      }
      a(parame);
      ahqq.a.b(parame).setVisibility(0);
      ahqq.a.b(parame).setText(2131694085);
    }
    for (;;)
    {
      if (!this.c.contains(Long.valueOf(localMessageForFuDai.uniseq)))
      {
        this.c.add(Long.valueOf(localMessageForFuDai.uniseq));
        a(localMessageForFuDai, 110);
      }
      return paramChatMessage;
      ahqq.a.a(parame).setVisibility(0);
      ahqq.a.a(parame).setText(localMessageForFuDai.aioTails);
      break;
      label255:
      if (localMessageForFuDai.isGrabByMe())
      {
        a(parame);
        ahqq.a.b(parame).setVisibility(8);
      }
      else if (localMessageForFuDai.isEmpty())
      {
        a(parame);
        ahqq.a.b(parame).setVisibility(0);
        ahqq.a.b(parame).setText(2131694086);
      }
    }
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new ahqq.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365686: 
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    super.m(paramChatMessage);
  }
  
  public boolean a(BaseBubbleBuilder.e parame)
  {
    return parame instanceof ahqq.a;
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (aqiu.ms(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append(a((MessageForFuDai)paramChatMessage));
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void destroy()
  {
    if (this.P != null)
    {
      this.P.quit();
      this.P = null;
    }
    if (g != null) {
      g.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BaseChatPie localBaseChatPie = e();
      if (localBaseChatPie != null)
      {
        MessageForFuDai localMessageForFuDai = (MessageForFuDai)((ahqq.a)wja.a(paramView)).mMessage;
        a(localMessageForFuDai, 111);
        ((ahqp)localBaseChatPie.a(2)).a(localMessageForFuDai);
      }
    }
  }
  
  public static class a
    extends BaseBubbleBuilder.e
  {
    private ImageView Aa;
    private ImageView Ab;
    private ImageView Ac;
    private TextView Gb;
    private TextView TA;
    private FilterRelativeLayout a;
    private int themeId;
    private ImageView zZ;
    
    private void b(MessageForFuDai paramMessageForFuDai)
    {
      this.themeId = paramMessageForFuDai.themeId;
    }
    
    private void gP(View paramView)
    {
      this.a = ((FilterRelativeLayout)paramView.findViewById(2131367790));
      this.zZ = ((ImageView)paramView.findViewById(2131367784));
      this.Aa = ((ImageView)paramView.findViewById(2131367788));
      this.Ab = ((ImageView)paramView.findViewById(2131367789));
      this.Ac = ((ImageView)paramView.findViewById(2131367785));
      this.Gb = ((TextView)paramView.findViewById(2131367791));
      this.TA = ((TextView)paramView.findViewById(2131367792));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahqq
 * JD-Core Version:    0.7.0.1
 */