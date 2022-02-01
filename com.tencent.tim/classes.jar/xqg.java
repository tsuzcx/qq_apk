import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;

public class xqg
  extends wjd
{
  public xqg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    if (paramView == null)
    {
      parama = (xqg.a)parama;
      paramView = LayoutInflater.from(this.mContext).inflate(2131558957, null);
      paramLinearLayout = (TextView)paramView.findViewById(2131368123);
      paramwlz = (TextView)paramView.findViewById(2131368502);
      TextView localTextView = (TextView)paramView.findViewById(2131368503);
      paramLinearLayout.setMovementMethod(null);
      paramLinearLayout.setGravity(17);
      parama.contentView = paramLinearLayout;
      parama.Kb = paramwlz;
      parama.Kc = localTextView;
      paramView.setTag(parama);
      label92:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label208;
      }
      parama.Kb.setBackgroundResource(2130843383);
      parama.Kc.setBackgroundResource(2130843383);
      label120:
      if ((paramMessageRecord.istroop != 1) || (!jof.a().dd(paramMessageRecord.senderuin))) {
        break label229;
      }
      parama.contentView.setTextColor(jof.aCt);
    }
    for (;;)
    {
      if ((paramMessageRecord instanceof MessageForSplitLineTips)) {
        paramMessageRecord = (MessageForSplitLineTips)paramMessageRecord;
      }
      switch (paramMessageRecord.subType)
      {
      default: 
        parama.contentView.setText(paramMessageRecord.msgContent);
        return paramView;
        parama = (xqg.a)paramView.getTag();
        break label92;
        label208:
        parama.Kb.setBackgroundResource(2130843382);
        parama.Kc.setBackgroundResource(2130843382);
        break label120;
        label229:
        parama.contentView.setTextColor(paramView.getResources().getColorStateList(2131165677));
      }
    }
    parama.contentView.setText(acfp.m(2131715832));
    return paramView;
  }
  
  protected wjd.a a()
  {
    return new xqg.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  class a
    extends wjd.a
  {
    public TextView Kb;
    public TextView Kc;
    public TextView contentView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqg
 * JD-Core Version:    0.7.0.1
 */