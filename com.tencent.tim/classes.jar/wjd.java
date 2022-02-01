import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.miniaio.MiniChatLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public abstract class wjd
  extends wko
{
  protected BaseAdapter adapter;
  public QQAppInterface app;
  public Context mContext;
  public SessionInfo sessionInfo;
  
  public wjd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.app = paramQQAppInterface;
    this.adapter = paramBaseAdapter;
    this.sessionInfo = paramSessionInfo;
    this.mContext = paramContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    Object localObject1 = paramViewGroup.getContext();
    wjd.a locala;
    Object localObject2;
    if (paramView == null)
    {
      paramView = new MiniChatLinearLayout((Context)localObject1);
      ((LinearLayout)paramView).setOrientation(1);
      locala = a();
      paramView.setTag(locala);
      locala.mPosition = paramInt1;
      locala.mMessage = paramChatMessage;
      if (!paramChatMessage.mNeedTimeStamp) {
        break label509;
      }
      if (locala.nf == null)
      {
        localObject2 = new TextView((Context)localObject1);
        ((TextView)localObject2).setId(2131364534);
        paramInt2 = wja.dp2px(14.0F, ((Context)localObject1).getResources());
        ((TextView)localObject2).setTextSize(2, 11.0F);
        if (this.sessionInfo.a.k != null) {
          ((TextView)localObject2).setTextColor(this.sessionInfo.a.k);
        }
        ((TextView)localObject2).setPadding(paramInt2, 0, paramInt2, 0);
        ((TextView)localObject2).setGravity(17);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin = BaseChatItemLayout.bOo;
        localLayoutParams.bottomMargin = BaseChatItemLayout.bOo;
        ((ViewGroup)paramView).addView((View)localObject2, 0, localLayoutParams);
        locala.nf = ((TextView)localObject2);
        ((TextView)localObject2).setTag(Long.valueOf(0L));
      }
      localObject2 = (LinearLayout.LayoutParams)locala.nf.getLayoutParams();
      if (!paramChatMessage.isFirstMsg) {
        break label498;
      }
      ((LinearLayout.LayoutParams)localObject2).topMargin = (BaseChatItemLayout.bOo * 2);
      label247:
      locala.nf.setVisibility(0);
      if (((Long)locala.nf.getTag()).longValue() != paramChatMessage.time)
      {
        localObject1 = aqmu.a((Context)localObject1, 3, paramChatMessage.time * 1000L);
        locala.nf.setText((CharSequence)localObject1);
      }
      wmy.c(this.app, paramChatMessage);
      label312:
      paramwlz = a(paramChatMessage, locala, locala.E, (LinearLayout)paramView, paramwlz);
      if (paramwlz != null) {
        break label530;
      }
      paramwlz = "getItemView return null, builder: " + getClass() + ", position: " + paramInt1 + ", msgtype: " + paramChatMessage.msgtype;
      new IllegalArgumentException(paramwlz);
      QLog.e("ChatItemBuilder", 1, paramwlz);
    }
    label498:
    label509:
    while (locala.E == paramwlz)
    {
      a(paramInt1, paramChatMessage, (MiniChatLinearLayout)paramView, paramViewGroup);
      paramChatMessage = paramView;
      do
      {
        for (;;)
        {
          return paramChatMessage;
          try
          {
            locala = (wjd.a)paramView.getTag();
          }
          catch (ClassCastException paramViewGroup)
          {
            paramChatMessage = paramView;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatItemBuilder", 2, "AbstractChatItemBuilder getview  e" + paramViewGroup + "position=" + paramInt1 + "size=" + this.adapter.getCount());
      return paramView;
      ((LinearLayout.LayoutParams)localObject2).topMargin = BaseChatItemLayout.bOo;
      break label247;
      if (locala.nf == null) {
        break label312;
      }
      locala.nf.setVisibility(8);
      break label312;
    }
    label530:
    if (locala.E != null) {
      ((ViewGroup)paramView).removeView(locala.E);
    }
    if (paramwlz.getLayoutParams() == null) {
      ((ViewGroup)paramView).addView(paramwlz, -1, -2);
    }
    for (;;)
    {
      locala.E = paramwlz;
      break;
      ((ViewGroup)paramView).addView(paramwlz);
    }
  }
  
  protected abstract View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz);
  
  protected abstract wjd.a a();
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    i(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, MiniChatLinearLayout paramMiniChatLinearLayout, ViewGroup paramViewGroup)
  {
    int j = 0;
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    int i = j;
    if (localAIOLongShotHelper != null)
    {
      i = j;
      if (localAIOLongShotHelper.RS()) {
        i = 1;
      }
    }
    if (i != 0) {
      paramMiniChatLinearLayout.setCheckBox(paramInt, paramChatMessage, paramMiniChatLinearLayout, this.app, this.sessionInfo, paramViewGroup);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  protected void a(aqoa paramaqoa)
  {
    paramaqoa.Z(2131362505, this.mContext.getString(2131690234), 2130839094);
  }
  
  public void destroy() {}
  
  protected void i(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.mContext;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickScreenShot Error:");
      if (localFragmentActivity != null) {}
      for (paramChatMessage = localFragmentActivity.toString();; paramChatMessage = "ca is null ")
      {
        QLog.e("AbstractChatItemBuilder", 1, paramChatMessage);
        return;
      }
    }
    Object localObject = localFragmentActivity.getChatFragment().a();
    ((AIOLongShotHelper)((BaseChatPie)localObject).a(15)).t(paramChatMessage);
    ((BaseChatPie)localObject).wc(true);
    abrb.b(((BaseChatPie)localObject).app, "select_more_msg", true);
  }
  
  public static abstract class a
    extends wko.a
  {
    public View E;
    public int mPosition;
    public TextView nf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wjd
 * JD-Core Version:    0.7.0.1
 */