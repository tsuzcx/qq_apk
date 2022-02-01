package org.junit.runner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunListener.ThreadSafe;

public class Result
  implements Serializable
{
  private static final ObjectStreamField[] serialPersistentFields = ObjectStreamClass.lookup(SerializedForm.class).getFields();
  private static final long serialVersionUID = 1L;
  private final AtomicInteger count;
  private final CopyOnWriteArrayList<Failure> failures;
  private final AtomicInteger ignoreCount;
  private final AtomicLong runTime;
  private SerializedForm serializedForm;
  private final AtomicLong startTime;
  
  public Result()
  {
    this.count = new AtomicInteger();
    this.ignoreCount = new AtomicInteger();
    this.failures = new CopyOnWriteArrayList();
    this.runTime = new AtomicLong();
    this.startTime = new AtomicLong();
  }
  
  private Result(SerializedForm paramSerializedForm)
  {
    this.count = paramSerializedForm.fCount;
    this.ignoreCount = paramSerializedForm.fIgnoreCount;
    this.failures = new CopyOnWriteArrayList(paramSerializedForm.fFailures);
    this.runTime = new AtomicLong(paramSerializedForm.fRunTime);
    this.startTime = new AtomicLong(paramSerializedForm.fStartTime);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws ClassNotFoundException, IOException
  {
    this.serializedForm = SerializedForm.deserialize(paramObjectInputStream);
  }
  
  private Object readResolve()
  {
    return new Result(this.serializedForm);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    new SerializedForm(this).serialize(paramObjectOutputStream);
  }
  
  public RunListener createListener()
  {
    return new Listener(null);
  }
  
  public int getFailureCount()
  {
    return this.failures.size();
  }
  
  public List<Failure> getFailures()
  {
    return this.failures;
  }
  
  public int getIgnoreCount()
  {
    return this.ignoreCount.get();
  }
  
  public int getRunCount()
  {
    return this.count.get();
  }
  
  public long getRunTime()
  {
    return this.runTime.get();
  }
  
  public boolean wasSuccessful()
  {
    return getFailureCount() == 0;
  }
  
  @RunListener.ThreadSafe
  class Listener
    extends RunListener
  {
    private Listener() {}
    
    public void testAssumptionFailure(Failure paramFailure) {}
    
    public void testFailure(Failure paramFailure)
      throws Exception
    {
      Result.this.failures.add(paramFailure);
    }
    
    public void testFinished(Description paramDescription)
      throws Exception
    {
      Result.this.count.getAndIncrement();
    }
    
    public void testIgnored(Description paramDescription)
      throws Exception
    {
      Result.this.ignoreCount.getAndIncrement();
    }
    
    public void testRunFinished(Result paramResult)
      throws Exception
    {
      long l = System.currentTimeMillis();
      Result.this.runTime.addAndGet(l - Result.this.startTime.get());
    }
    
    public void testRunStarted(Description paramDescription)
      throws Exception
    {
      Result.this.startTime.set(System.currentTimeMillis());
    }
  }
  
  static class SerializedForm
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    private final AtomicInteger fCount;
    private final List<Failure> fFailures;
    private final AtomicInteger fIgnoreCount;
    private final long fRunTime;
    private final long fStartTime;
    
    private SerializedForm(ObjectInputStream.GetField paramGetField)
      throws IOException
    {
      this.fCount = ((AtomicInteger)paramGetField.get("fCount", null));
      this.fIgnoreCount = ((AtomicInteger)paramGetField.get("fIgnoreCount", null));
      this.fFailures = ((List)paramGetField.get("fFailures", null));
      this.fRunTime = paramGetField.get("fRunTime", 0L);
      this.fStartTime = paramGetField.get("fStartTime", 0L);
    }
    
    public SerializedForm(Result paramResult)
    {
      this.fCount = paramResult.count;
      this.fIgnoreCount = paramResult.ignoreCount;
      this.fFailures = Collections.synchronizedList(new ArrayList(paramResult.failures));
      this.fRunTime = paramResult.runTime.longValue();
      this.fStartTime = paramResult.startTime.longValue();
    }
    
    public static SerializedForm deserialize(ObjectInputStream paramObjectInputStream)
      throws ClassNotFoundException, IOException
    {
      return new SerializedForm(paramObjectInputStream.readFields());
    }
    
    public void serialize(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      ObjectOutputStream.PutField localPutField = paramObjectOutputStream.putFields();
      localPutField.put("fCount", this.fCount);
      localPutField.put("fIgnoreCount", this.fIgnoreCount);
      localPutField.put("fFailures", this.fFailures);
      localPutField.put("fRunTime", this.fRunTime);
      localPutField.put("fStartTime", this.fStartTime);
      paramObjectOutputStream.writeFields();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.Result
 * JD-Core Version:    0.7.0.1
 */