package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class QMPrivateProtocolManager$5
  implements QMGeneralCallback
{
  QMPrivateProtocolManager$5(QMPrivateProtocolManager paramQMPrivateProtocolManager) {}
  
  public void onError() {}
  
  public void onSuccess()
  {
    QMLog.log(4, "QMPrivateProtocolManager", "handleVidSpread success set wtlogin");
    SharedPreferenceUtil.setWtlogin(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.5
 * JD-Core Version:    0.7.0.1
 */