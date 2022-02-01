package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class AudioCapabilitiesReceiver
{
  AudioCapabilities audioCapabilities;
  private final Context context;
  private final Listener listener;
  private final BroadcastReceiver receiver;
  
  public AudioCapabilitiesReceiver(Context paramContext, Listener paramListener)
  {
    this.context = ((Context)Assertions.checkNotNull(paramContext));
    this.listener = ((Listener)Assertions.checkNotNull(paramListener));
    if (Util.SDK_INT >= 21) {}
    for (paramContext = new HdmiAudioPlugBroadcastReceiver(null);; paramContext = null)
    {
      this.receiver = paramContext;
      return;
    }
  }
  
  public AudioCapabilities register()
  {
    if (this.receiver == null) {}
    for (Intent localIntent = null;; localIntent = this.context.registerReceiver(this.receiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")))
    {
      this.audioCapabilities = AudioCapabilities.getCapabilities(localIntent);
      return this.audioCapabilities;
    }
  }
  
  public void unregister()
  {
    if (this.receiver != null) {
      this.context.unregisterReceiver(this.receiver);
    }
  }
  
  final class HdmiAudioPlugBroadcastReceiver
    extends BroadcastReceiver
  {
    private HdmiAudioPlugBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (!isInitialStickyBroadcast())
      {
        paramContext = AudioCapabilities.getCapabilities(paramIntent);
        if (!paramContext.equals(AudioCapabilitiesReceiver.this.audioCapabilities))
        {
          AudioCapabilitiesReceiver.this.audioCapabilities = paramContext;
          AudioCapabilitiesReceiver.this.listener.onAudioCapabilitiesChanged(paramContext);
        }
      }
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void onAudioCapabilitiesChanged(AudioCapabilities paramAudioCapabilities);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver
 * JD-Core Version:    0.7.0.1
 */