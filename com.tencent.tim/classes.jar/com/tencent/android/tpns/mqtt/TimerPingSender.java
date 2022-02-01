package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPingSender
  implements MqttPingSender
{
  private static final String CLASS_NAME = "TimerPingSender";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "TimerPingSender");
  private ClientComms comms;
  private Timer timer;
  
  public void init(ClientComms paramClientComms)
  {
    if (paramClientComms == null) {
      throw new IllegalArgumentException("ClientComms cannot be null.");
    }
    this.comms = paramClientComms;
  }
  
  public void schedule(long paramLong)
  {
    this.timer.schedule(new PingTask(null), paramLong);
  }
  
  public void start()
  {
    String str = this.comms.getClient().getClientId();
    log.fine("TimerPingSender", "start", "659", new Object[] { str });
    this.timer = new Timer("MQTT Ping: " + str);
    this.timer.schedule(new PingTask(null), this.comms.getKeepAlive());
  }
  
  public void stop()
  {
    log.fine("TimerPingSender", "stop", "661", null);
    if (this.timer != null) {
      this.timer.cancel();
    }
  }
  
  class PingTask
    extends TimerTask
  {
    private static final String methodName = "PingTask.run";
    
    private PingTask() {}
    
    public void run()
    {
      TimerPingSender.log.fine("TimerPingSender", "PingTask.run", "660", new Object[] { new Long(System.currentTimeMillis()) });
      TimerPingSender.this.comms.checkForActivity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.TimerPingSender
 * JD-Core Version:    0.7.0.1
 */