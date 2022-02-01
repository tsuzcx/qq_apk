package com.tencent.qqmail.widget.notelist;

import com.tencent.qqmail.model.NoteManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.timer.WidgetDataChangeTimer;
import com.tencent.qqmail.widget.QMWidgetDataManager;
import java.util.Observer;

public class NoteWidgetManager
  extends QMWidgetDataManager
{
  private static final String TAG = "NoteWidgetManager";
  private static volatile NoteWidgetManager instance;
  private Observer noteListUpdateIObserver = new IObserver(new NoteWidgetManager.1(this));
  private NoteManager noteManager;
  private WidgetDataChangeTimer widgetDataChangeTimer = new WidgetDataChangeTimer();
  
  public static NoteWidgetManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null)
      {
        instance = new NoteWidgetManager();
        instance.init();
      }
      return instance;
    }
    finally {}
  }
  
  public void accountChange()
  {
    QMLog.log(4, "NoteWidgetManager", "accountChange");
    this.noteManager = NoteManager.sharedInstance();
    loadNoteList();
  }
  
  public void init()
  {
    super.init();
    QMLog.log(4, "NoteWidgetManager", "init");
    QMNotification.registNotification("NOTE_LIST_UPDATE", this.noteListUpdateIObserver);
    QMNotification.registNotification("NOTE_LIST_DELETE_DONE", this.noteListUpdateIObserver);
    QMNotification.registNotification("NOTE_DATACHANGE", this.noteListUpdateIObserver);
    QMNotification.registNotification("receivePushNote", this.noteListUpdateIObserver);
    this.noteManager = NoteManager.sharedInstance();
  }
  
  public void loadNoteList()
  {
    if (this.noteManager != null)
    {
      this.noteManager.loadNoteList();
      return;
    }
    notifyDataChange();
    QMLog.log(6, "NoteWidgetManager", "noteManager is null");
  }
  
  public void notifyDataChange()
  {
    this.widgetDataChangeTimer.startWidgetDataChangeTimer(new NoteWidgetManager.2(this), 500L);
  }
  
  public void release()
  {
    super.release();
    QMLog.log(4, "NoteWidgetManager", "release");
    QMNotification.unregistNotification("NOTE_LIST_UPDATE", this.noteListUpdateIObserver);
    QMNotification.unregistNotification("NOTE_LIST_DELETE_DONE", this.noteListUpdateIObserver);
    QMNotification.unregistNotification("NOTE_DATACHANGE", this.noteListUpdateIObserver);
    QMNotification.unregistNotification("receivePushNote", this.noteListUpdateIObserver);
    instance = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.notelist.NoteWidgetManager
 * JD-Core Version:    0.7.0.1
 */