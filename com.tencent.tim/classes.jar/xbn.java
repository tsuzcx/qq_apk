import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

public class xbn
  extends xci
  implements ahav.d
{
  private String tipsType;
  
  public xbn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    parama = (xbn.a)parama;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.mContext).inflate(2131561074, null);
      parama.mTextView = ((TextView)paramMessageRecord.findViewById(2131368123));
    }
    paramView = parama.mMessage.getExtInfoFromExtStr("tim_aio_show");
    this.tipsType = parama.mMessage.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (!this.tipsType.equalsIgnoreCase("keyword")) {
        break label184;
      }
      anot.a(this.app, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      parama.mMessage.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, parama));
      paramView = ahav.a(parama.mMessage.getExtInfoFromExtStr("tim_aio_file_tips"), parama.mMessage.getExtInfoFromExtStr("tim_aio_file_link"), this);
      parama.mTextView.setText(paramView);
      parama.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
      parama.mTextView.setHighlightColor(17170445);
      return paramMessageRecord;
      label184:
      if (this.tipsType.equalsIgnoreCase("precent")) {
        anot.a(this.app, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.tipsType.equalsIgnoreCase("text_keyword")) {
        anot.a(this.app, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xbn.a();
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    ((aocq)this.app.getManager(272)).a(localChatMessage, paramView.getContext(), this.sessionInfo);
  }
  
  public class a
    extends wjd.a
  {
    TextView mTextView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbn
 * JD-Core Version:    0.7.0.1
 */