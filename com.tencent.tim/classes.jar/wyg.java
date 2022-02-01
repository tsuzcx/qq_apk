import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class wyg
  extends wjd
{
  public int bSq;
  public int bSr;
  public int bSs;
  public int coverHeight;
  public int coverWidth;
  
  public wyg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.bSq = paramContext.getResources().getDimensionPixelSize(2131298575);
    int i = paramContext.getResources().getDimensionPixelSize(2131298576);
    this.coverHeight = i;
    this.coverWidth = i;
    this.bSs = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296424) * 2);
    this.bSr = paramContext.getResources().getDimensionPixelSize(2131298574);
  }
  
  private View a(View paramView, wyg.a parama)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131558894, null);
      parama.wC = localView.findViewById(2131365360);
      parama.sK = ((ImageView)localView.findViewById(2131362517));
      parama.tips = ((TextView)localView.findViewById(2131362518));
      parama.b = ((CornerImageView)localView.findViewById(2131362515));
      parama.bM = ((ImageView)localView.findViewById(2131362516));
      parama.b.setRadius(this.bSq);
      paramView = new aqfi.b(-1, this.coverWidth, this.coverHeight);
      parama.sK.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    parama = (wyg.a)parama;
    paramView = a(paramView, parama);
    paramMessageRecord = (String)parama.b.getTag(2131374810);
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (aqft.equalsWithNullCheck(paramLinearLayout.cover, paramMessageRecord))) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      try
      {
        paramMessageRecord = new URL(paramLinearLayout.cover);
        if (paramMessageRecord != null)
        {
          aqex.a(parama.bM, paramLinearLayout.cover);
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.bSs, this.bSr);
          paramMessageRecord.setDecodeHandler(aqbn.s);
          parama.b.setImageDrawable(paramMessageRecord);
          parama.b.setTag(2131374810, paramLinearLayout.cover);
        }
        if (aTl) {
          paramView.setContentDescription(paramLinearLayout.text);
        }
        parama.wC.setOnClickListener(new wyh(this, paramLinearLayout));
        return paramView;
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatItemBuilder", 2, " AIOStoryVideoBuilder:  url has problem");
          }
          paramMessageRecord = null;
        }
      }
    }
  }
  
  protected wjd.a a()
  {
    return new wyg.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  class a
    extends wjd.a
  {
    CornerImageView b;
    ImageView bM;
    ImageView sK;
    TextView tips;
    View wC;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wyg
 * JD-Core Version:    0.7.0.1
 */