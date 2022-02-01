import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;
import java.util.List;

public class xkg
  extends wjd
{
  View.OnClickListener onClickListener = new xkh(this);
  
  public xkg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout.setPadding(0, wja.dp2px(11.0F, this.mContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.mContext).inflate(2131558912, null);
    }
    Object localObject2 = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = ((MessageForPubAccount)localObject2).mPAMessage;
    paramMessageRecord = (xkg.a)parama;
    Object localObject3 = localPAMessage.items;
    parama = (ViewGroup)paramLinearLayout.findViewById(2131372807);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131372810);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131372809);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131372802);
    TextView localTextView3 = (TextView)paramLinearLayout.findViewById(2131372803);
    TextView localTextView4 = (TextView)paramLinearLayout.findViewById(2131372804);
    TextView localTextView5 = (TextView)paramLinearLayout.findViewById(2131372805);
    TextView localTextView6 = (TextView)paramLinearLayout.findViewById(2131372806);
    paramView = new ArrayList();
    paramView.add(localTextView2);
    paramView.add(localTextView3);
    paramView.add(localTextView4);
    paramView.add(localTextView5);
    paramView.add(localTextView6);
    localObject3 = (PAMessage.Item)((ArrayList)localObject3).get(0);
    paramMessageRecord.aVc = ((PAMessage.Item)localObject3).url;
    paramMessageRecord.bTA = localPAMessage.type;
    paramMessageRecord.aVb = ((PAMessage.Item)localObject3).actionUrl;
    paramMessageRecord.aVa = ((PAMessage.Item)localObject3).nativeJumpString;
    paramMessageRecord.itemType = 6;
    paramMessageRecord.bP = Long.valueOf(((MessageForPubAccount)localObject2).uniseq);
    paramMessageRecord.aVe = ((PAMessage.Item)localObject3).iconsString;
    if ((!TextUtils.isEmpty(paramMessageRecord.aVe)) && (paramMessageRecord.aVe.contains("1")))
    {
      i = 1;
      localObject2 = localTextView1.getLayoutParams();
      if (i == 0) {
        break label450;
      }
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 24;
        localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((ImageView)localObject1).setVisibility(0);
      label351:
      localTextView1.setText(((PAMessage.Item)localObject3).title);
      localObject1 = ((PAMessage.Item)localObject3).digestList;
      if (localObject1 == null) {
        break label526;
      }
    }
    label385:
    label526:
    for (int i = ((List)localObject1).size();; i = 0)
    {
      int j = 0;
      if (j < paramView.size())
      {
        localTextView1 = (TextView)paramView.get(j);
        if (i > j)
        {
          localTextView1.setText((CharSequence)((List)localObject1).get(j));
          localTextView1.setVisibility(0);
        }
        for (;;)
        {
          j += 1;
          break label385;
          i = 0;
          break;
          label450:
          if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
          {
            localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
            localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          ((ImageView)localObject1).setVisibility(8);
          break label351;
          localTextView1.setVisibility(8);
        }
      }
      parama.setTag(paramMessageRecord);
      parama.setOnClickListener(this.onClickListener);
      parama.setOnTouchListener(paramwlz);
      parama.setOnLongClickListener(paramwlz);
      return paramLinearLayout;
    }
  }
  
  protected wjd.a a()
  {
    return new xkg.a();
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
    public String aVe;
    public Object bP;
    public int bTA;
    public int itemType;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkg
 * JD-Core Version:    0.7.0.1
 */