import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.manager.MonitorManager;

public class xal
  extends wjd
  implements View.OnClickListener
{
  private static final String aUF = acfp.m(2131703233);
  private ForegroundColorSpan a = new ForegroundColorSpan(Color.parseColor("#883353"));
  private long iu;
  
  public xal(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void L(MessageRecord paramMessageRecord)
  {
    long l1;
    if ((paramMessageRecord != null) && (!aqfv.a().b(paramMessageRecord, "aio_msg|birthday_notice")))
    {
      aqfv.a().g(paramMessageRecord, "aio_msg|birthday_notice");
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramMessageRecord.frienduin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeItemBuilder", 1, "error parse friend uin " + paramMessageRecord);
        MonitorManager.a().d(19, 10, " error parse friend uin " + paramMessageRecord, false);
      }
    }
    paramMessageRecord = new LpReportInfo_pf00064();
    paramMessageRecord.actionType = 91;
    paramMessageRecord.subactionType = 22;
    paramMessageRecord.reserves = 1;
    paramMessageRecord.toUin = l1;
    LpReportManager.getInstance().reportToPF00064(paramMessageRecord, false, false);
  }
  
  private View a(View paramView, xal.a parama)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131558898, null);
      parama.mRoot = paramView;
      parama.mContainer = paramView.findViewById(2131362380);
      parama.T = paramView.findViewById(2131362379);
      parama.aa = ((URLImageView)paramView.findViewById(2131362382));
      parama.IV = ((TextView)paramView.findViewById(2131362383));
      parama.IW = ((TextView)paramView.findViewById(2131362381));
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
    paramMessageRecord = (MessageForBirthdayNotice)paramMessageRecord;
    parama = (xal.a)parama;
    paramView = a(paramView, parama);
    try
    {
      parama.aa.setBackgroundURL(paramMessageRecord.icon);
      parama.T.setBackgroundColor(Color.parseColor(paramMessageRecord.background));
      parama.IV.setText(paramMessageRecord.birthday);
      int i = paramMessageRecord.blessing.indexOf(aUF);
      if (i >= 0)
      {
        paramLinearLayout = new SpannableString(paramMessageRecord.blessing);
        paramLinearLayout.setSpan(this.a, i, aUF.length() + i, 33);
        parama.IW.setText(paramLinearLayout);
        parama.mContainer.setTag(paramMessageRecord);
        parama.mContainer.setOnClickListener(this);
        L(paramMessageRecord);
        if (aTl)
        {
          parama.E.append("生日");
          parama.E.append(paramMessageRecord.birthday);
          parama.E.append(paramMessageRecord.blessing);
          parama.mRoot.setContentDescription(parama.E.toString());
        }
        return paramView;
      }
    }
    catch (Exception paramLinearLayout)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeItemBuilder", 1, "set resource error " + paramLinearLayout);
        MonitorManager.a().d(19, 2, "set data error " + paramLinearLayout, false);
        continue;
        parama.IW.setText(paramMessageRecord.blessing);
      }
    }
  }
  
  protected wjd.a a()
  {
    return new xal.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public aqob[] a(View paramView)
  {
    return null;
  }
  
  public boolean isClickEnable()
  {
    long l = System.currentTimeMillis();
    if (l - this.iu > 500L) {}
    for (boolean bool = true;; bool = false)
    {
      this.iu = l;
      return bool;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (isClickEnable())
    {
      localObject = paramView.getTag();
      if ((localObject instanceof MessageForBirthdayNotice))
      {
        localObject = (MessageForBirthdayNotice)localObject;
        if (!TextUtils.isEmpty(((MessageForBirthdayNotice)localObject).doufu_link)) {
          break label93;
        }
        if (QLog.isColorLevel()) {
          QLog.e("BirthDayNoticeItemBuilder", 2, "jumpToH5Page with url empty");
        }
        MonitorManager.a().d(19, 2, " parse data with empty url " + localObject, false);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label93:
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", ((MessageForBirthdayNotice)localObject).doufu_link);
      this.mContext.startActivity(localIntent);
      try
      {
        long l = Long.parseLong(((MessageForBirthdayNotice)localObject).frienduin);
        localObject = new LpReportInfo_pf00064();
        ((LpReportInfo_pf00064)localObject).actionType = 91;
        ((LpReportInfo_pf00064)localObject).subactionType = 22;
        ((LpReportInfo_pf00064)localObject).reserves = 2;
        ((LpReportInfo_pf00064)localObject).toUin = l;
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      catch (Exception localException)
      {
        QLog.e("BirthDayNoticeItemBuilder", 1, "error parse friend uin " + localObject);
        MonitorManager.a().d(19, 10, " error parse friend uin " + localObject, false);
      }
    }
  }
  
  class a
    extends wjd.a
  {
    TextView IV;
    TextView IW;
    View T;
    URLImageView aa;
    View mContainer;
    View mRoot;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xal
 * JD-Core Version:    0.7.0.1
 */