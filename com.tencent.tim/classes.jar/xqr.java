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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;

public class xqr
  extends wjd
{
  public xqr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    parama = (xqr.a)parama;
    parama = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558957, null);
      parama = (TextView)paramView.findViewById(2131368123);
      parama.setMovementMethod(null);
      parama.setGravity(17);
      parama = paramView;
      if (ThemeUtil.isInNightMode(this.app))
      {
        parama = (TextView)paramView.findViewById(2131368502);
        paramLinearLayout = (TextView)paramView.findViewById(2131368503);
        parama.setBackgroundColor(2130843383);
        paramLinearLayout.setBackgroundColor(2130843383);
        parama = paramView;
      }
    }
    paramView = (TextView)parama.findViewById(2131368123);
    if ((paramMessageRecord.istroop == 1) && (jof.a().dd(paramMessageRecord.senderuin)))
    {
      paramView.setTextColor(jof.aCt);
      return parama;
    }
    paramView.setTextColor(parama.getResources().getColorStateList(2131165677));
    return parama;
  }
  
  protected wjd.a a()
  {
    return new xqr.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  class a
    extends wjd.a
  {
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqr
 * JD-Core Version:    0.7.0.1
 */