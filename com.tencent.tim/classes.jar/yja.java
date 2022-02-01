import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class yja
  implements yim, yjf
{
  private long Kb = -1L;
  private long Kc = -1L;
  private yjh a;
  private QQAppInterface app;
  private int bZo = -1;
  private WeakReference<XPanelContainer> ey;
  private wki g;
  private WeakReference<Context> mContext;
  protected List<QQOperationViopTipTask> qm;
  private SessionInfo sessionInfo;
  
  public yja(QQAppInterface paramQQAppInterface, yjh paramyjh, Context paramContext, XPanelContainer paramXPanelContainer, List<QQOperationViopTipTask> paramList, SessionInfo paramSessionInfo, wki paramwki)
  {
    this.app = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.ey = new WeakReference(paramXPanelContainer);
    this.qm = paramList;
    this.a = paramyjh;
    this.mContext = new WeakReference(paramContext);
    this.g = paramwki;
  }
  
  private void b(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    List localList = this.g.getList();
    if (localList == null) {
      return;
    }
    int j = localList.size();
    int i = j - 1;
    label27:
    if (i >= 0) {
      if (i < j - 10) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQOperateTips", 2, " findExcludeMsg, just return ");
        return;
        if (((ChatMessage)localList.get(i)).msgtype == -1043)
        {
          i = 1;
          continue;
        }
        i -= 1;
        break label27;
      }
      this.a.a(this, new Object[] { paramQQOperationViopTipTask });
      return;
      i = 0;
    }
  }
  
  private void ciz()
  {
    this.app.execute(new QQOperateTips.2(this));
  }
  
  private void onShow()
  {
    this.app.execute(new QQOperateTips.1(this));
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      if ((this.mContext == null) || (this.mContext.get() == null)) {
        return null;
      }
      View localView = LayoutInflater.from((Context)this.mContext.get()).inflate(2131561202, null);
      TextView localTextView = (TextView)localView.findViewById(2131374823);
      Button localButton = (Button)localView.findViewById(2131374820);
      localTextView.setText(paramVarArgs.adwords);
      localButton.setText(paramVarArgs.clickableWord);
      localButton.setOnClickListener(new yjb(this, paramVarArgs));
      return localView;
    }
    return null;
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    if ((paramVarArgs[0] instanceof QQOperationViopTipTask))
    {
      paramVarArgs = (QQOperationViopTipTask)paramVarArgs[0];
      MessageRecord localMessageRecord = anbi.d(-1041);
      long l = anaz.gQ();
      localMessageRecord.init(this.app.getCurrentAccountUin(), this.sessionInfo.aTl, this.app.getAccount(), paramVarArgs.adwords + "|" + paramVarArgs.clickableWord + "|" + paramVarArgs.linkOffset + "|" + paramVarArgs.url + "|" + paramVarArgs.taskid, l, -1041, this.sessionInfo.cZ, l);
      localMessageRecord.isread = true;
      if (!achp.a(this.app, localMessageRecord, false)) {
        return localMessageRecord;
      }
      return null;
    }
    return null;
  }
  
  public void a(QQOperationViopTipTask paramQQOperationViopTipTask)
  {
    this.a.a(this, new Object[] { paramQQOperationViopTipTask });
  }
  
  public void gC(List<QQOperationViopTipTask> paramList)
  {
    aeve localaeve = aeve.a(this.app);
    paramList = paramList.iterator();
    label195:
    label198:
    for (;;)
    {
      int i;
      QQOperationViopTipTask localQQOperationViopTipTask;
      if (paramList.hasNext())
      {
        i = ((QQOperationViopTipTask)paramList.next()).taskid;
        localQQOperationViopTipTask = localaeve.a(i);
        if ((QLog.isDevelopLevel()) && (localQQOperationViopTipTask == null)) {
          QLog.d("QQOperateVoIP", 4, "on showTips, voipTask is null, taskId=" + i);
        }
        XPanelContainer localXPanelContainer = (XPanelContainer)this.ey.get();
        if (localXPanelContainer == null) {
          break label195;
        }
        if (localXPanelContainer.vm() == 0) {
          i = 1;
        }
      }
      for (;;)
      {
        if (localQQOperationViopTipTask == null) {
          break label198;
        }
        if (localQQOperationViopTipTask.isBlueTipsTask())
        {
          if (i != 0)
          {
            a(localQQOperationViopTipTask);
            break;
            i = 0;
            continue;
          }
          if (this.qm == null) {
            break;
          }
          this.qm.add(localQQOperationViopTipTask);
          break;
        }
        if ((!localQQOperationViopTipTask.isGryTipsTask()) || (localaeve.aQ(this.sessionInfo.cZ, 2))) {
          break;
        }
        b(localQQOperationViopTipTask);
        break;
        return;
        i = 1;
      }
    }
  }
  
  public int getType()
  {
    return 6;
  }
  
  public void h(int paramInt, Object... paramVarArgs)
  {
    if ((this.sessionInfo.cZ != 0) && (this.sessionInfo.cZ != 3000)) {}
    do
    {
      return;
      if (paramInt == 1000)
      {
        onShow();
        return;
      }
    } while (paramInt != 1001);
    ciz();
  }
  
  public int wM()
  {
    return 40;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yja
 * JD-Core Version:    0.7.0.1
 */