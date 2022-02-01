package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class QMCursorCollector
{
  private static final String TAG = "QMCursorCollector";
  public static Thread cleanupThread;
  private static final ConcurrentHashMap<Cursor, AtomicInteger> counter = new ConcurrentHashMap(16, 0.9F, 1);
  
  public static int cleanup()
  {
    Iterator localIterator = counter.entrySet().iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Cursor localCursor = (Cursor)localEntry.getKey();
      j = i;
      if (((AtomicInteger)localEntry.getValue()).get() <= 0)
      {
        j = i;
        if (!localCursor.isClosed())
        {
          j = i + 1;
          Threads.runInBackground(new QMCursorCollector.1(localCursor), 10000L);
        }
        counter.remove(localCursor);
      }
    }
    return i;
  }
  
  public static void release(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      paramCursor = (AtomicInteger)counter.get(paramCursor);
      if (paramCursor != null) {
        paramCursor.decrementAndGet();
      }
    }
    cleanup();
  }
  
  public static void retain(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {}
    AtomicInteger localAtomicInteger;
    do
    {
      return;
      localAtomicInteger = (AtomicInteger)counter.get(paramCursor);
      if (localAtomicInteger == null)
      {
        localAtomicInteger = new AtomicInteger();
        localAtomicInteger.set(1);
        counter.put(paramCursor, localAtomicInteger);
        return;
      }
    } while (localAtomicInteger.get() < 0);
    localAtomicInteger.incrementAndGet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMCursorCollector
 * JD-Core Version:    0.7.0.1
 */