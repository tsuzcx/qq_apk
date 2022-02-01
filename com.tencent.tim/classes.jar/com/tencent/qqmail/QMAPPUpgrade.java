package com.tencent.qqmail;

import com.tencent.qqmail.utilities.log.QMLog;

public abstract class QMAPPUpgrade
{
  private String TAG = "QMAPPUpgrade";
  private QMAPPUpgradeManager upgradeManager;
  
  public QMAPPUpgrade(QMAPPUpgradeManager paramQMAPPUpgradeManager)
  {
    this.upgradeManager = paramQMAPPUpgradeManager;
  }
  
  public abstract void doUpgrade(int paramInt);
  
  public abstract int getVersion();
  
  public final void onUpgrade(int paramInt)
  {
    if (paramInt <= this.upgradeManager.getVersion())
    {
      QMLog.log(4, this.TAG, "doUpgrade from " + paramInt + " to " + getVersion());
      doUpgrade(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMAPPUpgrade
 * JD-Core Version:    0.7.0.1
 */