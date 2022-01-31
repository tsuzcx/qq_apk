package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class LocalBroadcastManager
{
  private static final boolean DEBUG = false;
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  private static final String TAG = "LocalBroadcastManager";
  private static LocalBroadcastManager mInstance;
  private static final Object mLock = new Object();
  private final HashMap mActions = new HashMap();
  private final Context mAppContext;
  private final Handler mHandler;
  private final ArrayList mPendingBroadcasts = new ArrayList();
  private final HashMap mReceivers = new HashMap();
  
  private LocalBroadcastManager(Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mHandler = new LocalBroadcastManager.1(this, paramContext.getMainLooper());
  }
  
  private void executePendingBroadcasts()
  {
    for (;;)
    {
      int i;
      synchronized (this.mReceivers)
      {
        i = this.mPendingBroadcasts.size();
        if (i <= 0) {
          return;
        }
        LocalBroadcastManager.BroadcastRecord[] arrayOfBroadcastRecord = new LocalBroadcastManager.BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        i = 0;
        if (i >= arrayOfBroadcastRecord.length) {
          continue;
        }
        ??? = arrayOfBroadcastRecord[i];
        int k = ???.receivers.size();
        int j = 0;
        if (j < k)
        {
          LocalBroadcastManager.ReceiverRecord localReceiverRecord = (LocalBroadcastManager.ReceiverRecord)???.receivers.get(j);
          if (!localReceiverRecord.dead) {
            localReceiverRecord.receiver.onReceive(this.mAppContext, ???.intent);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  @NonNull
  public static LocalBroadcastManager getInstance(@NonNull Context paramContext)
  {
    synchronized (mLock)
    {
      if (mInstance == null) {
        mInstance = new LocalBroadcastManager(paramContext.getApplicationContext());
      }
      paramContext = mInstance;
      return paramContext;
    }
  }
  
  public void registerReceiver(@NonNull BroadcastReceiver paramBroadcastReceiver, @NonNull IntentFilter paramIntentFilter)
  {
    synchronized (this.mReceivers)
    {
      LocalBroadcastManager.ReceiverRecord localReceiverRecord = new LocalBroadcastManager.ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.mReceivers.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList(1);
        this.mReceivers.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(localReceiverRecord);
      int i = 0;
      while (i < paramIntentFilter.countActions())
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.mActions.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new ArrayList(1);
          this.mActions.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localReceiverRecord);
        i += 1;
      }
      return;
    }
  }
  
  public boolean sendBroadcast(@NonNull Intent paramIntent)
  {
    int i;
    label161:
    int j;
    Object localObject;
    int k;
    ArrayList localArrayList1;
    synchronized (this.mReceivers)
    {
      String str1 = paramIntent.getAction();
      String str2 = paramIntent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
      Uri localUri = paramIntent.getData();
      String str3 = paramIntent.getScheme();
      Set localSet = paramIntent.getCategories();
      if ((paramIntent.getFlags() & 0x8) == 0) {
        break label500;
      }
      i = 1;
      if (i != 0) {
        Log.v("LocalBroadcastManager", "Resolving type " + str2 + " scheme " + str3 + " of intent " + paramIntent);
      }
      ArrayList localArrayList2 = (ArrayList)this.mActions.get(paramIntent.getAction());
      if (localArrayList2 == null) {
        break label477;
      }
      if (i == 0) {
        break label485;
      }
      Log.v("LocalBroadcastManager", "Action list: " + localArrayList2);
      break label485;
      if (j >= localArrayList2.size()) {
        break label536;
      }
      localObject = (LocalBroadcastManager.ReceiverRecord)localArrayList2.get(j);
      if (i != 0) {
        Log.v("LocalBroadcastManager", "Matching against filter " + ((LocalBroadcastManager.ReceiverRecord)localObject).filter);
      }
      if (((LocalBroadcastManager.ReceiverRecord)localObject).broadcasting)
      {
        if (i == 0) {
          break label505;
        }
        Log.v("LocalBroadcastManager", "  Filter's target already added");
      }
      else
      {
        k = ((LocalBroadcastManager.ReceiverRecord)localObject).filter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
        if (k >= 0)
        {
          if (i != 0) {
            Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(k));
          }
          if (localArrayList1 != null) {
            break label482;
          }
          localArrayList1 = new ArrayList();
          label311:
          localArrayList1.add(localObject);
          ((LocalBroadcastManager.ReceiverRecord)localObject).broadcasting = true;
        }
      }
    }
    if (i != 0) {
      switch (k)
      {
      default: 
        localObject = "unknown reason";
        label376:
        Log.v("LocalBroadcastManager", "  Filter did not match: " + (String)localObject);
        break;
      }
    }
    for (;;)
    {
      if (i < localArrayList1.size())
      {
        ((LocalBroadcastManager.ReceiverRecord)localArrayList1.get(i)).broadcasting = false;
        i += 1;
      }
      else
      {
        this.mPendingBroadcasts.add(new LocalBroadcastManager.BroadcastRecord(paramIntent, localArrayList1));
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
        return true;
        label477:
        label482:
        label485:
        label500:
        label505:
        do
        {
          return false;
          break label311;
          localArrayList1 = null;
          j = 0;
          break label161;
          for (;;)
          {
            j += 1;
            break label161;
            i = 0;
            break;
          }
          localObject = "action";
          break label376;
          localObject = "category";
          break label376;
          localObject = "data";
          break label376;
          localObject = "type";
          break label376;
        } while (localArrayList1 == null);
        label536:
        i = 0;
      }
    }
  }
  
  public void sendBroadcastSync(@NonNull Intent paramIntent)
  {
    if (sendBroadcast(paramIntent)) {
      executePendingBroadcasts();
    }
  }
  
  public void unregisterReceiver(@NonNull BroadcastReceiver paramBroadcastReceiver)
  {
    for (;;)
    {
      int i;
      int j;
      int k;
      synchronized (this.mReceivers)
      {
        ArrayList localArrayList1 = (ArrayList)this.mReceivers.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          return;
        }
        i = localArrayList1.size() - 1;
        if (i >= 0)
        {
          LocalBroadcastManager.ReceiverRecord localReceiverRecord1 = (LocalBroadcastManager.ReceiverRecord)localArrayList1.get(i);
          localReceiverRecord1.dead = true;
          j = 0;
          if (j >= localReceiverRecord1.filter.countActions()) {
            break label203;
          }
          String str = localReceiverRecord1.filter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.mActions.get(str);
          if (localArrayList2 == null) {
            break label196;
          }
          k = localArrayList2.size() - 1;
          if (k >= 0)
          {
            LocalBroadcastManager.ReceiverRecord localReceiverRecord2 = (LocalBroadcastManager.ReceiverRecord)localArrayList2.get(k);
            if (localReceiverRecord2.receiver == paramBroadcastReceiver)
            {
              localReceiverRecord2.dead = true;
              localArrayList2.remove(k);
            }
          }
          else
          {
            if (localArrayList2.size() > 0) {
              break label196;
            }
            this.mActions.remove(str);
            break label196;
          }
        }
        else
        {
          return;
        }
      }
      k -= 1;
      continue;
      label196:
      j += 1;
      continue;
      label203:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.LocalBroadcastManager
 * JD-Core Version:    0.7.0.1
 */