package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorPingSender
  implements MqttPingSender
{
  private static final String CLASS_NAME = "ScheduledExecutorPingSender";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ScheduledExecutorPingSender");
  private String clientid;
  private ClientComms comms;
  private ScheduledExecutorService executorService;
  private ScheduledFuture scheduledFuture;
  
  public ScheduledExecutorPingSender(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramScheduledExecutorService == null) {
      throw new IllegalArgumentException("ExecutorService cannot be null.");
    }
    this.executorService = paramScheduledExecutorService;
  }
  
  public void init(ClientComms paramClientComms)
  {
    if (paramClientComms == null) {
      throw new IllegalArgumentException("ClientComms cannot be null.");
    }
    this.comms = paramClientComms;
    this.clientid = paramClientComms.getClient().getClientId();
  }
  
  public void schedule(long paramLong)
  {
    this.scheduledFuture = this.executorService.schedule(new PingRunnable(null), paramLong, TimeUnit.MILLISECONDS);
  }
  
  public void start()
  {
    log.fine("ScheduledExecutorPingSender", "start", "659", new Object[] { this.clientid });
    schedule(this.comms.getKeepAlive());
  }
  
  public void stop()
  {
    log.fine("ScheduledExecutorPingSender", "stop", "661", null);
    if (this.scheduledFuture != null) {
      this.scheduledFuture.cancel(true);
    }
  }
  
  class PingRunnable
    implements Runnable
  {
    private static final String methodName = "PingTask.run";
    
    private PingRunnable() {}
    
    public void run()
    {
      String str = Thread.currentThread().getName();
      Thread.currentThread().setName("MQTT Ping: " + ScheduledExecutorPingSender.this.clientid);
      ScheduledExecutorPingSender.log.fine("ScheduledExecutorPingSender", "PingTask.run", "660", new Object[] { new Long(System.currentTimeMillis()) });
      ScheduledExecutorPingSender.this.comms.checkForActivity();
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.ScheduledExecutorPingSender
 * JD-Core Version:    0.7.0.1
 */