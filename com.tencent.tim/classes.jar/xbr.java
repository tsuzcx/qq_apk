import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;

public class xbr
  extends xci
{
  public xbr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @TargetApi(16)
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    parama = (xbr.a)parama;
    paramView = LayoutInflater.from(this.mContext).inflate(2131558953, null);
    parama.mTextView = ((TextView)paramView.findViewById(2131368123));
    parama.sX = ((ImageView)paramView.findViewById(2131377016));
    parama.sY = ((ImageView)paramView.findViewById(2131372677));
    parama.layout = ((LinearLayout)paramView.findViewById(2131372762));
    parama.mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    int i;
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      parama.mTextView.setText(paramMessageRecord.getShowMsgContent(this.app, this.mContext));
      parama.mTextView.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = parama.sY;
      if (!paramMessageRecord.isOpen) {
        break label301;
      }
      i = 8;
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = parama.mTextView.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != wja.dp2px(10.0F, this.mContext.getResources())) {
            paramMessageRecord.rightMargin = wja.dp2px(10.0F, this.mContext.getResources());
          }
        }
      }
      paramMessageRecord = ((zxj)this.app.getManager(125)).f("StatusIcon_HongBaoIcon", 2130848170);
      if (Build.VERSION.SDK_INT >= 16) {
        break label307;
      }
      parama.sX.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramMessageRecord));
    }
    for (;;)
    {
      parama.layout.setOnClickListener(new xbs(this));
      anot.a(this.app, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
      return paramView;
      label301:
      i = 0;
      break;
      label307:
      parama.sX.setBackground(new BitmapDrawable(this.mContext.getResources(), paramMessageRecord));
    }
  }
  
  protected wjd.a a()
  {
    return new xbr.a();
  }
  
  class a
    extends wjd.a
  {
    LinearLayout layout;
    TextView mTextView;
    ImageView sX;
    ImageView sY;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbr
 * JD-Core Version:    0.7.0.1
 */