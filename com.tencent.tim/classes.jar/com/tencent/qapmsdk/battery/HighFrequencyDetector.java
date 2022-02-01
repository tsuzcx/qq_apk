package com.tencent.qapmsdk.battery;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HighFrequencyDetector
{
  private LinkedList<Action> actionList = null;
  private long detectInterval;
  private int maxActionCount;
  
  public HighFrequencyDetector(int paramInt, long paramLong)
  {
    this.maxActionCount = paramInt;
    this.detectInterval = paramLong;
  }
  
  public static String getDescription(List<Action> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH点mm分ss");
      int i = paramList.size();
      localStringBuilder.ensureCapacity((((Action)paramList.get(0)).userData.toString().length() + 20) * i);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Action localAction = (Action)paramList.next();
        localStringBuilder.append("[").append(localSimpleDateFormat.format(new Date(localAction.timestamp))).append(":").append(localAction.userData.toString()).append("]");
      }
    }
    return localStringBuilder.toString();
  }
  
  public List<Action> onAction(Object arg1)
  {
    Object localObject1 = new Action();
    ((Action)localObject1).timestamp = System.currentTimeMillis();
    ((Action)localObject1).userData = ???;
    synchronized (this.actionList)
    {
      this.actionList.addLast(localObject1);
      if (this.actionList.size() < this.maxActionCount) {
        return null;
      }
      Action localAction = (Action)this.actionList.getFirst();
      if (((Action)localObject1).timestamp - localAction.timestamp < this.detectInterval)
      {
        localObject1 = new ArrayList(this.actionList);
        return localObject1;
      }
    }
    this.actionList.removeFirst();
    return null;
  }
  
  public void trimCache()
  {
    synchronized (this.actionList)
    {
      this.actionList.clear();
      return;
    }
  }
  
  public static final class Action
  {
    public long timestamp = 0L;
    public Object userData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.HighFrequencyDetector
 * JD-Core Version:    0.7.0.1
 */