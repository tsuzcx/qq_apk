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
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageRecord;

public class xkb
  extends wjd
{
  public xkb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout = (xkb.a)parama;
    parama = paramView;
    if (paramView == null)
    {
      parama = LayoutInflater.from(this.mContext).inflate(2131558954, null);
      paramLinearLayout.mTextView = ((TextView)parama.findViewById(2131368123));
    }
    paramLinearLayout.mTextView.setMovementMethod(null);
    paramLinearLayout.mTextView.setGravity(17);
    if ((paramMessageRecord instanceof MessageForMyEnterTroop))
    {
      paramMessageRecord = (MessageForMyEnterTroop)paramMessageRecord;
      paramMessageRecord = this.mContext.getString(2131699436);
      paramLinearLayout.mTextView.setText(paramMessageRecord);
      paramView = this.mContext.getResources().getColorStateList(2131165571);
      if (paramView != null) {
        paramLinearLayout.mTextView.setTextColor(paramView);
      }
      parama.setContentDescription(paramMessageRecord);
    }
    return parama;
  }
  
  protected wjd.a a()
  {
    return new xkb.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  class a
    extends wjd.a
  {
    TextView mTextView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkb
 * JD-Core Version:    0.7.0.1
 */