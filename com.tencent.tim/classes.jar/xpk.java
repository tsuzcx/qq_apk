import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageRecord;

public class xpk
  extends wjd
{
  public xpk(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout = (xpk.a)parama;
    parama = paramView;
    if (paramView == null)
    {
      parama = LayoutInflater.from(this.mContext).inflate(2131558956, null);
      paramLinearLayout.mTitleView = ((TextView)parama.findViewById(2131379769));
      paramLinearLayout.np = ((TextView)parama.findViewById(2131365360));
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForTimDouFuGuide)))
    {
      paramMessageRecord = ((MessageForTimDouFuGuide)paramMessageRecord).config;
      if (paramMessageRecord != null)
      {
        paramLinearLayout.mTitleView.setText(paramMessageRecord.tipsHighLight);
        paramView = new SpannableString(paramMessageRecord.tipsMsg + acfp.m(2131715323));
        int i = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(parama.getResources().getColor(2131167316)), i - 4, i, 33);
        paramLinearLayout.np.setText(paramView);
        parama.setOnClickListener(new xpl(this, paramMessageRecord));
      }
    }
    return parama;
  }
  
  protected wjd.a a()
  {
    return new xpk.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return new aqoa().a();
  }
  
  public class a
    extends wjd.a
  {
    public TextView mTitleView;
    public TextView np;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpk
 * JD-Core Version:    0.7.0.1
 */