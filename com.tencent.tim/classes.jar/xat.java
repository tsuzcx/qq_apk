import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Locale;

public class xat
  extends wjd
{
  public xat(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, wjd.a parama, View paramView, LinearLayout paramLinearLayout, wlz paramwlz)
  {
    MessageForConfessNews localMessageForConfessNews = (MessageForConfessNews)paramMessageRecord;
    xat.a locala = (xat.a)parama;
    paramLinearLayout = paramView;
    if (paramView == null)
    {
      paramLinearLayout = LayoutInflater.from(this.mContext).inflate(2131558900, null);
      locala.titleView = ((TextView)paramLinearLayout.findViewById(2131379769));
      locala.contentView = ((TextView)paramLinearLayout.findViewById(2131365395));
      locala.tD = ((TextView)paramLinearLayout.findViewById(2131378922));
      locala.tM = paramLinearLayout.findViewById(2131365360);
      locala.a = ((ConfessNewsBgView)paramLinearLayout.findViewById(2131363394));
      locala.a.setPressMask(true);
      locala.a.setOnClickListener(new xau(this));
    }
    locala.a.setTag(localMessageForConfessNews);
    locala.a.setBgType(localMessageForConfessNews.nBGType);
    locala.uniseq = paramMessageRecord.uniseq;
    locala.friendUin = paramMessageRecord.frienduin;
    int i;
    boolean bool1;
    Object localObject;
    label251:
    String str2;
    String str1;
    label306:
    StringBuilder localStringBuilder;
    if ((paramMessageRecord.istroop != 0) || (paramMessageRecord.istroop == 1))
    {
      i = 1;
      bool1 = this.app.getCurrentAccountUin().equals(localMessageForConfessNews.strConfessorUin);
      boolean bool2 = this.app.getCurrentAccountUin().equals(localMessageForConfessNews.strRecUin);
      if (!bool2) {
        break label574;
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { acfp.m(2131704305) });
      locala.titleView.setText((CharSequence)localObject);
      str2 = localMessageForConfessNews.strConfessorDesc;
      float f = aehc.d(str2);
      paramView = localMessageForConfessNews.strConfessorNick;
      if (bool1) {
        paramView = acfp.m(2131704304);
      }
      if (localMessageForConfessNews.confessTime > 0L) {
        break label692;
      }
      str1 = "";
      localStringBuilder = new StringBuilder();
      if (localMessageForConfessNews.nBizType != 1) {
        break label741;
      }
      if (!bool2) {
        break label712;
      }
      paramView = acfp.m(2131704309);
      label335:
      localStringBuilder.append(String.format(Locale.getDefault(), acfp.m(2131704308), new Object[] { Integer.valueOf(localMessageForConfessNews.nConfessNum), paramView }));
      label371:
      locala.tD.setText(localStringBuilder.toString());
      if (f <= 8.0F) {
        break label792;
      }
      locala.contentView.setTextSize(1, 21.0F);
      locala.contentView.setLineSpacing(0.0F, 1.2F);
      if ((f > 12.0F) || (!aehc.lC(str2))) {
        break label814;
      }
      i = (int)(f * 0.7D);
    }
    label792:
    label814:
    for (paramView = str2.substring(0, i) + "\n" + str2.substring(i, str2.length());; paramView = str2)
    {
      locala.contentView.setText(paramView);
      if (aTl)
      {
        parama.E.append((String)localObject).append(paramView).append(",").append(localStringBuilder.toString());
        paramLinearLayout.setContentDescription(parama.E.toString());
      }
      locala.a.setTag(paramMessageRecord);
      locala.a.setOnTouchListener(paramwlz);
      locala.a.setOnLongClickListener(paramwlz);
      return paramLinearLayout;
      i = 0;
      break;
      label574:
      localObject = localMessageForConfessNews.strRecNick;
      paramView = (View)localObject;
      if (i != 0) {
        if (localMessageForConfessNews.nRecNickType != 1)
        {
          paramView = (View)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        }
        else
        {
          str1 = aqgv.h(this.app, localMessageForConfessNews.strGroupUin, localMessageForConfessNews.strRecUin);
          paramView = (View)localObject;
          if (!TextUtils.isEmpty(str1)) {
            paramView = str1;
          }
        }
      }
      localObject = paramView;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.length() > 7) {
          localObject = aeha.a(paramView, 7.0F);
        }
      }
      localObject = String.format(Locale.getDefault(), "%s收到的坦白说", new Object[] { localObject });
      break label251;
      label692:
      str1 = aqmu.a(localMessageForConfessNews.confessTime * 1000L, true, "");
      break label306;
      label712:
      if (localMessageForConfessNews.nGetConfessSex == 1)
      {
        paramView = acfp.m(2131704306);
        break label335;
      }
      paramView = acfp.m(2131704307);
      break label335;
      label741:
      localStringBuilder.append("来自");
      if ((i != 0) && (!bool1)) {}
      localStringBuilder.append(paramView);
      if (TextUtils.isEmpty(str1)) {
        break label371;
      }
      localStringBuilder.append(" | ").append(str1);
      break label371;
      locala.contentView.setTextSize(1, 24.0F);
      locala.contentView.setLineSpacing(0.0F, 1.0F);
    }
  }
  
  protected wjd.a a()
  {
    return new xat.a();
  }
  
  public aqob[] a(View paramView)
  {
    paramView = new aqoa();
    a(paramView);
    return paramView.a();
  }
  
  static class a
    extends wjd.a
  {
    ConfessNewsBgView a;
    TextView contentView;
    public String friendUin;
    TextView tD;
    View tM;
    TextView titleView;
    public long uniseq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xat
 * JD-Core Version:    0.7.0.1
 */