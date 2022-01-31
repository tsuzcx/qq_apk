package com.tencent.av.gaudio;

public class AVGQuality
{
  public int RTT;
  public AVGQuality.AudioQos audioQos = new AVGQuality.AudioQos(this);
  public AVGQuality.AudioQuality audioQua = new AVGQuality.AudioQuality(this);
  public AVGQuality.VideoQuality mainVideoRecvQua = new AVGQuality.VideoQuality(this);
  public AVGQuality.VideoQos mainVideoSendBigViewQos = new AVGQuality.VideoQos(this);
  public AVGQuality.VideoQuality mainVideoSendBigViewQua = new AVGQuality.VideoQuality(this);
  public AVGQuality.VideoQos mainVideoSendSmallViewQos = new AVGQuality.VideoQos(this);
  public AVGQuality.VideoQuality mainVideoSendSmallViewQua = new AVGQuality.VideoQuality(this);
  public int recvBitR;
  public int recvJitterR;
  public float recvLossR;
  public int recvPktR;
  public int sendBitR;
  public int sendJitterR;
  public float sendLossR;
  public int sendPktR;
  public AVGQuality.VideoQuality subVideoRecvQua = new AVGQuality.VideoQuality(this);
  public float sysCpu;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.AVGQuality
 * JD-Core Version:    0.7.0.1
 */