import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForEnterTroop.a;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xbm
  extends wjd
{
  public xbm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    int j = 0;
    paramwlz = (xbm.a)parama;
    parama = paramView;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      parama = new LinearLayout(paramLinearLayout.getContext());
      parama.setOrientation(1);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.topMargin = wja.dp2px(9.0F, paramLinearLayout.getContext().getResources());
      parama.setLayoutParams(paramView);
      localObject1 = new LinearLayout(parama.getContext());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(1);
      paramwlz.hf = ((LinearLayout)localObject1);
      paramView = new LinearLayout(parama.getContext());
      paramView.setOrientation(0);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(52.0F, paramLinearLayout.getContext().getResources());
      ((LinearLayout.LayoutParams)localObject2).topMargin = wja.dp2px(4.0F, paramLinearLayout.getContext().getResources());
      parama.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      parama.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      paramwlz.mTextView = new TextView(paramView.getContext());
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      paramView.addView(paramwlz.mTextView, (ViewGroup.LayoutParams)localObject1);
      paramwlz.mTextView.setTextColor(-8355712);
      paramwlz.mTextView.setGravity(1);
      paramwlz.mTextView.setSingleLine();
      paramwlz.mTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramwlz.sd = new ArrayList();
    }
    int i;
    if ((paramMessageRecord instanceof MessageForEnterTroop))
    {
      localObject1 = (MessageForEnterTroop)paramMessageRecord;
      paramMessageRecord = this.mContext.getString(2131699438);
      localObject2 = ((MessageForEnterTroop)localObject1).mList.iterator();
      for (i = 1; ((Iterator)localObject2).hasNext(); i = 0)
      {
        MessageForEnterTroop.a locala = (MessageForEnterTroop.a)((Iterator)localObject2).next();
        paramView = paramMessageRecord;
        if (i == 0) {
          paramView = paramMessageRecord + ",";
        }
        paramMessageRecord = paramView + locala.nick;
      }
      paramwlz.mTextView.setText(paramMessageRecord);
      i = ((MessageForEnterTroop)localObject1).mList.size();
      if (i <= 5) {
        break label727;
      }
      i = 5;
    }
    label727:
    for (;;)
    {
      int k = paramwlz.sd.size();
      if (k < i) {
        while (j < i - k)
        {
          paramMessageRecord = new ImageView(paramwlz.hf.getContext());
          paramMessageRecord.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = wja.dp2px(26.0F, paramLinearLayout.getContext().getResources());
          paramView = new LinearLayout.LayoutParams(m, m);
          paramView.leftMargin = wja.dp2px(4.0F, paramLinearLayout.getContext().getResources());
          paramView.rightMargin = wja.dp2px(4.0F, paramLinearLayout.getContext().getResources());
          paramwlz.hf.addView(paramMessageRecord, paramView);
          paramwlz.sd.add(paramMessageRecord);
          j += 1;
        }
      }
      if (k > i)
      {
        j = k;
        while (j > i)
        {
          paramwlz.hf.removeView((View)paramwlz.sd.get(j - 1));
          paramwlz.sd.remove(j - 1);
          j -= 1;
        }
      }
      paramMessageRecord = paramwlz.sd.iterator();
      paramView = ((MessageForEnterTroop)localObject1).mList.iterator();
      while ((paramMessageRecord.hasNext()) && (paramView.hasNext()))
      {
        paramLinearLayout = (ImageView)paramMessageRecord.next();
        paramwlz = (MessageForEnterTroop.a)paramView.next();
        paramLinearLayout.setImageDrawable(aqdj.a(this.app, 1, paramwlz.uin));
      }
      return parama;
    }
  }
  
  protected wjd.a a()
  {
    return new xbm.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  class a
    extends wjd.a
  {
    LinearLayout hf;
    TextView mTextView;
    List<ImageView> sd;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xbm
 * JD-Core Version:    0.7.0.1
 */