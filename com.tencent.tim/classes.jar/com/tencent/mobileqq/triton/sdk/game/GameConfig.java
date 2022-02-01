package com.tencent.mobileqq.triton.sdk.game;

import java.util.List;

public class GameConfig
{
  public String deviceOrientation;
  public List<String> navigateToMiniProgramAppIdList;
  public NetworkTimeout networkTimeout;
  public boolean showStatusBar;
  public String workers;
  
  public class NetworkTimeout
  {
    public String connectSocket;
    public String downloadFile;
    public String request;
    public String uploadFile;
    
    public NetworkTimeout() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.GameConfig
 * JD-Core Version:    0.7.0.1
 */