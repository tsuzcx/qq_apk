package com.tencent.qqmail.utilities.qmnetwork.service;

import java.net.Socket;

public class QMPushSocket
  extends Socket
{
  public String toString()
  {
    return super.toString() + "Connect:" + isConnected() + " ,InputShutDown:" + isInputShutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMPushSocket
 * JD-Core Version:    0.7.0.1
 */