package com.tencent.pluginmanager.channel.listener;

import android.os.Bundle;
import com.tencent.pluginmanager.channel.ChannelCallback;

public abstract interface IBizReqListener
{
  public abstract void onReceiveBizTask(int paramInt, Bundle paramBundle, ChannelCallback paramChannelCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.pluginmanager.channel.listener.IBizReqListener
 * JD-Core Version:    0.7.0.1
 */