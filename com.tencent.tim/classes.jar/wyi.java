import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wyi
  extends wjd
  implements View.OnClickListener
{
  protected String url;
  
  public wyi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout = (wyi.a)parama;
    parama = paramView;
    if (paramView == null)
    {
      parama = LayoutInflater.from(this.mContext).inflate(2131560067, null);
      paramLinearLayout.IH = ((TextView)parama.findViewById(2131364501));
      paramLinearLayout.mP = ((TextView)parama.findViewById(2131364500));
      paramLinearLayout.II = ((TextView)parama.findViewById(2131364499));
      paramLinearLayout.mImageView = ((ImageView)parama.findViewById(2131364497));
      parama.setOnClickListener(this);
      paramLinearLayout.IH.setOnClickListener(this);
      paramLinearLayout.mP.setOnClickListener(this);
      paramLinearLayout.II.setOnClickListener(this);
      paramLinearLayout.mImageView.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.IH.setText(acfp.m(2131702008));
      paramLinearLayout.mP.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.II);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, parama.getResources().getDrawable(2130843339), parama.getResources().getDrawable(2130843338));
      paramLinearLayout.mImageView.setBackgroundDrawable(paramMessageRecord);
      this.url = paramView.url;
      if (aTl)
      {
        if (TextUtils.isEmpty(paramView.title))
        {
          paramMessageRecord = "";
          paramLinearLayout = new StringBuilder().append(paramMessageRecord);
          if (!TextUtils.isEmpty(paramView.summary)) {
            break label298;
          }
          paramMessageRecord = "";
          parama.setContentDescription(paramMessageRecord);
        }
      }
      else {
        return parama;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.mImageView.setBackgroundResource(2130843338);
        continue;
        paramMessageRecord = paramView.title;
        continue;
        label298:
        paramMessageRecord = paramView.summary;
      }
    }
  }
  
  protected wjd.a a()
  {
    return new wyi.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(String paramString, TextView paramTextView)
  {
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new wyj(this, paramTextView, paramString));
  }
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    aoyd.G(this.mContext, this.url, this.app.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  class a
    extends wjd.a
  {
    TextView IH;
    TextView II;
    ImageView mImageView;
    TextView mP;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyi
 * JD-Core Version:    0.7.0.1
 */