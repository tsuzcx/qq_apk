import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import java.net.MalformedURLException;
import java.net.URL;

public class xkj
  extends wjd
{
  int Dk = 0;
  anqz a;
  int bTB = 0;
  int bTC = 0;
  
  public xkj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.bTB = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296424) * 2);
    this.Dk = ((int)paramContext.getResources().getDimension(2131298563));
    this.bTC = paramContext.getResources().getDimensionPixelSize(2131298562);
    paramQQAppInterface = (wkh)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.report(3, 1);
    }
  }
  
  public static String U(String paramString, int paramInt)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int k;
      if (j < paramString.length())
      {
        k = paramString.codePointAt(j);
        if ((k < 32) || (k > 126)) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        if (i <= paramInt) {
          localStringBuilder.appendCodePoint(k);
        }
        if (i < paramInt) {
          break;
        }
        if (localStringBuilder.length() < paramString.length()) {
          localStringBuilder.append("...");
        }
        return localStringBuilder.toString();
        label90:
        if (k >= 65535)
        {
          i += 1;
          j += 1;
        }
        else
        {
          i += 2;
        }
      }
      j += 1;
    }
  }
  
  private int a(xkj.a parama)
  {
    int i = parama.text.getBackground().getIntrinsicWidth();
    return parama.text.getBackground().getIntrinsicHeight() * this.bTB / i;
  }
  
  private View a(View paramView, xkj.a parama)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558915, null);
      parama.kE = paramView.findViewById(2131365360);
      parama.text = ((TextView)paramView.findViewById(2131379401));
      parama.title = ((TextView)paramView.findViewById(2131379769));
      parama.b = ((CornerImageView)paramView.findViewById(2131363394));
      parama.b.setRadius(this.Dk);
      parama.b.setPressMask(true);
      int i = a(parama);
      parama.text.getLayoutParams().width = this.bTB;
      parama.text.getLayoutParams().height = i;
      localView = paramView;
      if (aTl)
      {
        parama.E = new StringBuilder();
        localView = paramView;
      }
    }
    if (aTl)
    {
      localView.setContentDescription(null);
      parama.E.replace(0, parama.E.length(), "");
    }
    return localView;
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    paramLinearLayout = (MessageForPLNews)paramMessageRecord;
    parama = (xkj.a)parama;
    paramView = a(paramView, parama);
    parama.uniseq = paramLinearLayout.uniseq;
    parama.friendUin = paramLinearLayout.frienduin;
    paramwlz = U(this.sessionInfo.aTn, 6);
    String str = String.format(albf.bVg, new Object[] { paramwlz });
    if (!parama.title.getText().equals(str)) {
      parama.title.setText(str);
    }
    if (!parama.text.getText().equals(paramLinearLayout.text)) {
      parama.text.setText(paramLinearLayout.text);
    }
    paramMessageRecord = (String)parama.b.getTag(2131373650);
    Object localObject = (Integer)parama.b.getTag(2131373649);
    int j;
    if (localObject == null)
    {
      j = 0;
      if ((TextUtils.isEmpty(paramLinearLayout.cover)) || (!aqft.equalsWithNullCheck(paramLinearLayout.cover, paramMessageRecord))) {
        break label543;
      }
    }
    label538:
    label543:
    for (int i = 0;; i = 1)
    {
      int k = i;
      if (TextUtils.isEmpty(paramLinearLayout.cover))
      {
        k = i;
        if (j == paramLinearLayout.bgColor) {
          k = 0;
        }
      }
      anqz localanqz;
      if (k != 0)
      {
        localObject = new anqz(paramLinearLayout.bgColor, this.Dk * 3, this.Dk * 3, this.Dk);
        localanqz = new anqz(0, this.Dk * 3, this.Dk * 3, this.Dk);
        if (TextUtils.isEmpty(paramLinearLayout.cover)) {
          break label538;
        }
      }
      for (;;)
      {
        try
        {
          paramMessageRecord = new URL(paramLinearLayout.cover);
          if (paramMessageRecord != null)
          {
            paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, a(parama), a(parama), localanqz, (Drawable)localObject);
            paramMessageRecord.setDecodeHandler(aqbn.s);
            parama.b.setImageDrawable(paramMessageRecord);
            parama.b.setTag(2131373650, paramLinearLayout.cover);
            if (paramMessageRecord == null)
            {
              parama.b.setImageDrawable((Drawable)localObject);
              parama.b.setTag(2131373649, Integer.valueOf(paramLinearLayout.bgColor));
            }
            if (!TextUtils.isEmpty(paramLinearLayout.cover))
            {
              if (this.a == null) {
                this.a = new anqz(Color.parseColor("#66000000"), this.Dk * 3, this.Dk * 3, this.Dk);
              }
              parama.kE.setBackgroundDrawable(this.a);
              if (aTl)
              {
                parama.E.append(str).append(paramLinearLayout.text);
                paramView.setContentDescription(parama.E.toString());
              }
              parama.kE.setTag(parama);
              parama.kE.setOnClickListener(new xkk(this, paramLinearLayout, paramwlz));
              return paramView;
              j = ((Integer)localObject).intValue();
            }
          }
        }
        catch (MalformedURLException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = null;
          continue;
          parama.kE.setBackgroundDrawable(null);
          continue;
        }
        paramMessageRecord = null;
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xkj.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return new aqob[0];
  }
  
  class a
    extends wjd.a
  {
    CornerImageView b;
    public String friendUin;
    View kE;
    TextView text;
    TextView title;
    public long uniseq;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xkj
 * JD-Core Version:    0.7.0.1
 */