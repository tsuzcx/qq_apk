package com.tencent.qqmail.calendar.fragment;

import android.content.Context;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import org.apache.commons.lang3.StringUtils;

public abstract class EventChecker
{
  protected Context mContext;
  protected EventChecker mNextChecker;
  
  public EventChecker(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public EventChecker addNextChecker(EventChecker paramEventChecker)
  {
    if (this.mNextChecker != null)
    {
      this.mNextChecker.addNextChecker(paramEventChecker);
      return paramEventChecker;
    }
    this.mNextChecker = paramEventChecker;
    return paramEventChecker;
  }
  
  protected abstract boolean needShowDialog();
  
  public void setNextChecker(EventChecker paramEventChecker)
  {
    this.mNextChecker = paramEventChecker;
  }
  
  protected void showDialog(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
  {
    paramEventCheckerListener.onCheckError();
  }
  
  protected abstract boolean validate(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution);
  
  public void validateEventData(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
  {
    if (validate(paramQMCalendarEvent1, paramQMCalendarEvent2, paramEventCheckerListener, paramSolution))
    {
      if (this.mNextChecker != null)
      {
        this.mNextChecker.validateEventData(paramQMCalendarEvent1, paramQMCalendarEvent2, paramEventCheckerListener, paramSolution);
        return;
      }
      paramEventCheckerListener.onCheckSuccess(paramSolution);
      return;
    }
    if (needShowDialog())
    {
      showDialog(paramQMCalendarEvent1, paramQMCalendarEvent2, paramEventCheckerListener, paramSolution);
      return;
    }
    paramEventCheckerListener.onCheckError();
  }
  
  public static abstract interface EventCheckerListener
  {
    public abstract void onCheckError();
    
    public abstract void onCheckSuccess(ModifyScheduleFragment.Solution paramSolution);
  }
  
  public static class EventFolderChecker
    extends EventChecker
  {
    public EventFolderChecker(Context paramContext)
    {
      super();
    }
    
    protected boolean needShowDialog()
    {
      return true;
    }
    
    protected void showDialog(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      QMCalendarFolder localQMCalendarFolder = QMCalendarManager.getInstance().getCalendarFolder(paramQMCalendarEvent2.getAccountId(), paramQMCalendarEvent2.getCalderFolderId());
      QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.mContext);
      localBottomListSheetBuilder.setTitle(String.format(this.mContext.getString(2131691065), new Object[] { localQMCalendarFolder.getName() }));
      localBottomListSheetBuilder.addItem(this.mContext.getString(2131691068));
      localBottomListSheetBuilder.addItem(this.mContext.getString(2131691067));
      localBottomListSheetBuilder.setOnSheetItemClickListener(new EventChecker.EventFolderChecker.1(this, localQMCalendarFolder, paramQMCalendarEvent1, paramQMCalendarEvent2, paramEventCheckerListener, paramSolution));
      paramQMCalendarEvent1 = localBottomListSheetBuilder.build();
      paramQMCalendarEvent1.setCanceledOnTouchOutside(true);
      paramQMCalendarEvent1.setOnCancelListener(new EventChecker.EventFolderChecker.2(this, paramEventCheckerListener));
      Threads.runOnMainThread(new EventChecker.EventFolderChecker.3(this, paramQMCalendarEvent1), 300L);
    }
    
    protected boolean validate(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      paramQMCalendarEvent1 = QMCalendarManager.getInstance().getCalendarFolder(paramQMCalendarEvent2.getAccountId(), paramQMCalendarEvent2.getCalderFolderId());
      if (paramQMCalendarEvent1 == null) {
        throw new IllegalStateException("creating calendar event while no default folder exist, accountId:" + paramQMCalendarEvent2.getAccountId() + ",calderFolderId:" + paramQMCalendarEvent2.getCalderFolderId());
      }
      return paramQMCalendarEvent1.isShow();
    }
  }
  
  public static class EventNoActionChecker
    extends EventChecker
  {
    public EventNoActionChecker(Context paramContext)
    {
      super();
    }
    
    protected boolean needShowDialog()
    {
      return false;
    }
    
    protected boolean validate(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      return true;
    }
  }
  
  public static class EventProtocolChecker
    extends EventChecker
  {
    public EventProtocolChecker(Context paramContext)
    {
      super();
    }
    
    protected boolean needShowDialog()
    {
      return true;
    }
    
    protected void showDialog(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.mContext).setTitle(2131691148)).setMessage(2131691126).addAction(2131721871, new EventChecker.EventProtocolChecker.1(this, paramEventCheckerListener))).create().show();
    }
    
    protected boolean validate(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      if ((!paramQMCalendarEvent2.isRecurring()) || (paramSolution.getModifyType() == 0) || (paramQMCalendarEvent1.getCategory() == 1)) {}
      do
      {
        return true;
        paramQMCalendarEvent1 = AccountManager.shareInstance().getAccountList().getAccountById(paramQMCalendarEvent2.getAccountId());
      } while (((paramQMCalendarEvent1 != null) && (QMCalendarManager.getInstance().isCalDavAccount(paramQMCalendarEvent1.getId()))) || (Math.abs(QMCalendarUtil.getTimeDuration(paramQMCalendarEvent2.getStartTime(), paramQMCalendarEvent2.getEndTime(), paramQMCalendarEvent2.isAllDay())) <= QMCalendarUtil.getDaysByRecurringType(paramQMCalendarEvent2.getRecurrenceType())));
      return false;
    }
  }
  
  public static class EventRecurrentChecker
    extends EventChecker
  {
    private QMSchedule mSchedule;
    
    public EventRecurrentChecker(Context paramContext, QMSchedule paramQMSchedule)
    {
      super();
      this.mSchedule = paramQMSchedule;
    }
    
    protected boolean needShowDialog()
    {
      return true;
    }
    
    protected void showDialog(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.mContext);
      localBottomListSheetBuilder.setTitle(2131691132);
      int i;
      if (paramQMCalendarEvent1.getRecurrenceType() != paramQMCalendarEvent2.getRecurrenceType())
      {
        i = 1;
        if (i == 0)
        {
          if (paramQMCalendarEvent1.getCategory() == 1) {
            break label129;
          }
          localBottomListSheetBuilder.addItem(this.mContext.getString(2131691123));
        }
      }
      for (;;)
      {
        localBottomListSheetBuilder.addItem(this.mContext.getString(2131691122));
        localBottomListSheetBuilder.setOnSheetItemClickListener(new EventChecker.EventRecurrentChecker.1(this, paramSolution, paramQMCalendarEvent1, paramQMCalendarEvent2, paramEventCheckerListener));
        paramQMCalendarEvent1 = localBottomListSheetBuilder.build();
        paramQMCalendarEvent1.setCanceledOnTouchOutside(true);
        paramQMCalendarEvent1.setOnCancelListener(new EventChecker.EventRecurrentChecker.2(this, paramEventCheckerListener));
        paramQMCalendarEvent1.show();
        return;
        i = 0;
        break;
        label129:
        localBottomListSheetBuilder.addItem(this.mContext.getString(2131691121));
      }
    }
    
    protected boolean validate(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      return (!paramQMCalendarEvent1.isRecurring()) || (!StringUtils.isBlank(this.mSchedule.getExceptionId()));
    }
  }
  
  public static class EventTimeChecker
    extends EventChecker
  {
    public EventTimeChecker(Context paramContext)
    {
      super();
    }
    
    protected boolean needShowDialog()
    {
      return true;
    }
    
    protected void showDialog(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this.mContext).setTitle(2131691148)).setMessage(2131691147).addAction(2131721871, new EventChecker.EventTimeChecker.1(this, paramEventCheckerListener))).create().show();
    }
    
    protected boolean validate(QMCalendarEvent paramQMCalendarEvent1, QMCalendarEvent paramQMCalendarEvent2, EventChecker.EventCheckerListener paramEventCheckerListener, ModifyScheduleFragment.Solution paramSolution)
    {
      return QMCalendarUtil.compareTime(paramQMCalendarEvent2.getStartTime(), paramQMCalendarEvent2.getEndTime(), paramQMCalendarEvent2.isAllDay()) <= 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.EventChecker
 * JD-Core Version:    0.7.0.1
 */