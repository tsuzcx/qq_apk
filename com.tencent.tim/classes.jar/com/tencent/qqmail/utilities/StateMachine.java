package com.tencent.qqmail.utilities;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class StateMachine
{
  public static final boolean HANDLED = true;
  public static final boolean NOT_HANDLED = false;
  private static final int SM_INIT_CMD = -2;
  private static final int SM_QUIT_CMD = -1;
  private String mName;
  private SmHandler mSmHandler;
  private HandlerThread mSmThread;
  
  protected StateMachine(String paramString)
  {
    this.mSmThread = new HandlerThread(paramString);
    this.mSmThread.start();
    initStateMachine(paramString, this.mSmThread.getLooper());
  }
  
  protected StateMachine(String paramString, Handler paramHandler)
  {
    initStateMachine(paramString, paramHandler.getLooper());
  }
  
  protected StateMachine(String paramString, Looper paramLooper)
  {
    initStateMachine(paramString, paramLooper);
  }
  
  private void initStateMachine(String paramString, Looper paramLooper)
  {
    this.mName = paramString;
    this.mSmHandler = new SmHandler(paramLooper, this, null);
  }
  
  protected void addLogRec(String paramString)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.mLogRecords.add(this, localSmHandler.getCurrentMessage(), paramString, localSmHandler.getCurrentState(), localSmHandler.mStateStack[localSmHandler.mStateStackTopIndex].state, localSmHandler.mDestState);
  }
  
  protected final void addState(State paramState)
  {
    this.mSmHandler.addState(paramState, null);
  }
  
  protected final void addState(State paramState1, State paramState2)
  {
    this.mSmHandler.addState(paramState1, paramState2);
  }
  
  public final Collection<LogRec> copyLogRecs()
  {
    Vector localVector = new Vector();
    Object localObject = this.mSmHandler;
    if (localObject != null)
    {
      localObject = SmHandler.access$1600((SmHandler)localObject).mLogRecVector.iterator();
      while (((Iterator)localObject).hasNext()) {
        localVector.add((LogRec)((Iterator)localObject).next());
      }
    }
    return localVector;
  }
  
  protected final void deferMessage(Message paramMessage)
  {
    this.mSmHandler.deferMessage(paramMessage);
  }
  
  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.println(getName() + ":");
    paramPrintWriter.println(" total records=" + getLogRecCount());
    int i = 0;
    while (i < getLogRecSize())
    {
      paramPrintWriter.printf(" rec[%d]: %s\n", new Object[] { Integer.valueOf(i), getLogRec(i).toString() });
      paramPrintWriter.flush();
      i += 1;
    }
    paramPrintWriter.println("curState=" + getCurrentState().getName());
  }
  
  protected final Message getCurrentMessage()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return null;
    }
    return localSmHandler.getCurrentMessage();
  }
  
  protected final IState getCurrentState()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return null;
    }
    return localSmHandler.getCurrentState();
  }
  
  public final Handler getHandler()
  {
    return this.mSmHandler;
  }
  
  public final LogRec getLogRec(int paramInt)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return null;
    }
    return localSmHandler.mLogRecords.get(paramInt);
  }
  
  public final int getLogRecCount()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return 0;
    }
    return localSmHandler.mLogRecords.count();
  }
  
  public final int getLogRecSize()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return 0;
    }
    return localSmHandler.mLogRecords.size();
  }
  
  protected String getLogRecString(Message paramMessage)
  {
    return "";
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  protected String getWhatToString(int paramInt)
  {
    return null;
  }
  
  protected void haltedProcessMessage(Message paramMessage) {}
  
  public boolean isDbg()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return false;
    }
    return localSmHandler.isDbg();
  }
  
  protected final boolean isQuit(Message paramMessage)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return paramMessage.what == -1;
    }
    return localSmHandler.isQuit(paramMessage);
  }
  
  protected void log(String paramString)
  {
    Log.d(this.mName, paramString);
  }
  
  protected void logAndAddLogRec(String paramString)
  {
    addLogRec(paramString);
    log(paramString);
  }
  
  protected void logd(String paramString)
  {
    Log.d(this.mName, paramString);
  }
  
  protected void loge(String paramString)
  {
    Log.e(this.mName, paramString);
  }
  
  protected void loge(String paramString, Throwable paramThrowable)
  {
    Log.e(this.mName, paramString, paramThrowable);
  }
  
  protected void logi(String paramString)
  {
    Log.i(this.mName, paramString);
  }
  
  protected void logv(String paramString)
  {
    Log.v(this.mName, paramString);
  }
  
  protected void logw(String paramString)
  {
    Log.w(this.mName, paramString);
  }
  
  public final Message obtainMessage()
  {
    return Message.obtain(this.mSmHandler);
  }
  
  public final Message obtainMessage(int paramInt)
  {
    return Message.obtain(this.mSmHandler, paramInt);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2)
  {
    return Message.obtain(this.mSmHandler, paramInt1, paramInt2, 0);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    return Message.obtain(this.mSmHandler, paramInt1, paramInt2, paramInt3);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return Message.obtain(this.mSmHandler, paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    return Message.obtain(this.mSmHandler, paramInt, paramObject);
  }
  
  protected void onHalting() {}
  
  protected void onQuitting() {}
  
  protected final void quit()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.quit();
  }
  
  protected final void quitNow()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.quitNow();
  }
  
  protected boolean recordLogRec(Message paramMessage)
  {
    return true;
  }
  
  protected final void removeMessages(int paramInt)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.removeMessages(paramInt);
  }
  
  public final void sendMessage(int paramInt)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt));
  }
  
  public final void sendMessage(int paramInt1, int paramInt2)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt1, paramInt2));
  }
  
  public final void sendMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt1, paramInt2, paramInt3));
  }
  
  public final void sendMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt1, paramInt2, paramInt3, paramObject));
  }
  
  public final void sendMessage(int paramInt, Object paramObject)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(obtainMessage(paramInt, paramObject));
  }
  
  public final void sendMessage(Message paramMessage)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessage(paramMessage);
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt));
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt1, int paramInt2)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt1, paramInt2));
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt1, int paramInt2, int paramInt3)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt1, paramInt2, paramInt3));
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt1, paramInt2, paramInt3, paramObject));
  }
  
  protected final void sendMessageAtFrontOfQueue(int paramInt, Object paramObject)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(obtainMessage(paramInt, paramObject));
  }
  
  protected final void sendMessageAtFrontOfQueue(Message paramMessage)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageAtFrontOfQueue(paramMessage);
  }
  
  public final void sendMessageDelayed(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt1, paramInt2, paramInt3), paramLong);
  }
  
  public final void sendMessageDelayed(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt1, paramInt2, paramInt3, paramObject), paramLong);
  }
  
  public final void sendMessageDelayed(int paramInt1, int paramInt2, long paramLong)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt1, paramInt2), paramLong);
  }
  
  public final void sendMessageDelayed(int paramInt, long paramLong)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt), paramLong);
  }
  
  public final void sendMessageDelayed(int paramInt, Object paramObject, long paramLong)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageDelayed(obtainMessage(paramInt, paramObject), paramLong);
  }
  
  public final void sendMessageDelayed(Message paramMessage, long paramLong)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.sendMessageDelayed(paramMessage, paramLong);
  }
  
  public void setDbg(boolean paramBoolean)
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.setDbg(paramBoolean);
  }
  
  protected final void setInitialState(State paramState)
  {
    this.mSmHandler.setInitialState(paramState);
  }
  
  public final void setLogOnlyTransitions(boolean paramBoolean)
  {
    this.mSmHandler.mLogRecords.setLogOnlyTransitions(paramBoolean);
  }
  
  public final void setLogRecSize(int paramInt)
  {
    this.mSmHandler.mLogRecords.setSize(paramInt);
  }
  
  public void start()
  {
    SmHandler localSmHandler = this.mSmHandler;
    if (localSmHandler == null) {
      return;
    }
    localSmHandler.completeConstruction();
  }
  
  protected final void transitionTo(IState paramIState)
  {
    this.mSmHandler.transitionTo(paramIState);
  }
  
  protected final void transitionToHaltingState()
  {
    this.mSmHandler.transitionTo(this.mSmHandler.mHaltingState);
  }
  
  protected void unhandledMessage(Message paramMessage)
  {
    if (this.mSmHandler.mDbg) {
      loge(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
  }
  
  public static class LogRec
  {
    private IState mDstState;
    private String mInfo;
    private IState mOrgState;
    private StateMachine mSm;
    private IState mState;
    private long mTime;
    private int mWhat;
    
    LogRec(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      update(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
    }
    
    public IState getDestState()
    {
      return this.mDstState;
    }
    
    public String getInfo()
    {
      return this.mInfo;
    }
    
    public IState getOriginalState()
    {
      return this.mOrgState;
    }
    
    public IState getState()
    {
      return this.mState;
    }
    
    public long getTime()
    {
      return this.mTime;
    }
    
    public long getWhat()
    {
      return this.mWhat;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(this.mTime);
      localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
      localStringBuilder.append(" processed=");
      if (this.mState == null)
      {
        localObject = "<null>";
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" org=");
        if (this.mOrgState != null) {
          break label247;
        }
        localObject = "<null>";
        label106:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" dest=");
        if (this.mDstState != null) {
          break label260;
        }
        localObject = "<null>";
        label129:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" what=");
        if (this.mSm == null) {
          break label273;
        }
        localObject = this.mSm.getWhatToString(this.mWhat);
        label161:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label279;
        }
        localStringBuilder.append(this.mWhat);
        localStringBuilder.append("(0x");
        localStringBuilder.append(Integer.toHexString(this.mWhat));
        localStringBuilder.append(")");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.mInfo))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(this.mInfo);
        }
        return localStringBuilder.toString();
        localObject = this.mState.getName();
        break;
        label247:
        localObject = this.mOrgState.getName();
        break label106;
        label260:
        localObject = this.mDstState.getName();
        break label129;
        label273:
        localObject = "";
        break label161;
        label279:
        localStringBuilder.append((String)localObject);
      }
    }
    
    public void update(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      this.mSm = paramStateMachine;
      this.mTime = System.currentTimeMillis();
      if (paramMessage != null) {}
      for (int i = paramMessage.what;; i = 0)
      {
        this.mWhat = i;
        this.mInfo = paramString;
        this.mState = paramIState1;
        this.mOrgState = paramIState2;
        this.mDstState = paramIState3;
        return;
      }
    }
  }
  
  static class LogRecords
  {
    private static final int DEFAULT_SIZE = 20;
    private int mCount = 0;
    private boolean mLogOnlyTransitions = false;
    private Vector<StateMachine.LogRec> mLogRecVector = new Vector();
    private int mMaxSize = 20;
    private int mOldestIndex = 0;
    
    /* Error */
    void add(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield 33	com/tencent/qqmail/utilities/StateMachine$LogRecords:mCount	I
      //   7: iconst_1
      //   8: iadd
      //   9: putfield 33	com/tencent/qqmail/utilities/StateMachine$LogRecords:mCount	I
      //   12: aload_0
      //   13: getfield 27	com/tencent/qqmail/utilities/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   16: invokevirtual 46	java/util/Vector:size	()I
      //   19: aload_0
      //   20: getfield 29	com/tencent/qqmail/utilities/StateMachine$LogRecords:mMaxSize	I
      //   23: if_icmpge +30 -> 53
      //   26: aload_0
      //   27: getfield 27	com/tencent/qqmail/utilities/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   30: new 48	com/tencent/qqmail/utilities/StateMachine$LogRec
      //   33: dup
      //   34: aload_1
      //   35: aload_2
      //   36: aload_3
      //   37: aload 4
      //   39: aload 5
      //   41: aload 6
      //   43: invokespecial 50	com/tencent/qqmail/utilities/StateMachine$LogRec:<init>	(Lcom/tencent/qqmail/utilities/StateMachine;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/qqmail/utilities/IState;Lcom/tencent/qqmail/utilities/IState;Lcom/tencent/qqmail/utilities/IState;)V
      //   46: invokevirtual 53	java/util/Vector:add	(Ljava/lang/Object;)Z
      //   49: pop
      //   50: aload_0
      //   51: monitorexit
      //   52: return
      //   53: aload_0
      //   54: getfield 27	com/tencent/qqmail/utilities/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   57: aload_0
      //   58: getfield 31	com/tencent/qqmail/utilities/StateMachine$LogRecords:mOldestIndex	I
      //   61: invokevirtual 57	java/util/Vector:get	(I)Ljava/lang/Object;
      //   64: checkcast 48	com/tencent/qqmail/utilities/StateMachine$LogRec
      //   67: astore 7
      //   69: aload_0
      //   70: aload_0
      //   71: getfield 31	com/tencent/qqmail/utilities/StateMachine$LogRecords:mOldestIndex	I
      //   74: iconst_1
      //   75: iadd
      //   76: putfield 31	com/tencent/qqmail/utilities/StateMachine$LogRecords:mOldestIndex	I
      //   79: aload_0
      //   80: getfield 31	com/tencent/qqmail/utilities/StateMachine$LogRecords:mOldestIndex	I
      //   83: aload_0
      //   84: getfield 29	com/tencent/qqmail/utilities/StateMachine$LogRecords:mMaxSize	I
      //   87: if_icmplt +8 -> 95
      //   90: aload_0
      //   91: iconst_0
      //   92: putfield 31	com/tencent/qqmail/utilities/StateMachine$LogRecords:mOldestIndex	I
      //   95: aload 7
      //   97: aload_1
      //   98: aload_2
      //   99: aload_3
      //   100: aload 4
      //   102: aload 5
      //   104: aload 6
      //   106: invokevirtual 60	com/tencent/qqmail/utilities/StateMachine$LogRec:update	(Lcom/tencent/qqmail/utilities/StateMachine;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/qqmail/utilities/IState;Lcom/tencent/qqmail/utilities/IState;Lcom/tencent/qqmail/utilities/IState;)V
      //   109: goto -59 -> 50
      //   112: astore_1
      //   113: aload_0
      //   114: monitorexit
      //   115: aload_1
      //   116: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	117	0	this	LogRecords
      //   0	117	1	paramStateMachine	StateMachine
      //   0	117	2	paramMessage	Message
      //   0	117	3	paramString	String
      //   0	117	4	paramIState1	IState
      //   0	117	5	paramIState2	IState
      //   0	117	6	paramIState3	IState
      //   67	29	7	localLogRec	StateMachine.LogRec
      // Exception table:
      //   from	to	target	type
      //   2	50	112	finally
      //   53	95	112	finally
      //   95	109	112	finally
    }
    
    void cleanup()
    {
      try
      {
        this.mLogRecVector.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    int count()
    {
      try
      {
        int i = this.mCount;
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    StateMachine.LogRec get(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 31	com/tencent/qqmail/utilities/StateMachine$LogRecords:mOldestIndex	I
      //   6: iload_1
      //   7: iadd
      //   8: istore_2
      //   9: iload_2
      //   10: istore_1
      //   11: iload_2
      //   12: aload_0
      //   13: getfield 29	com/tencent/qqmail/utilities/StateMachine$LogRecords:mMaxSize	I
      //   16: if_icmplt +10 -> 26
      //   19: iload_2
      //   20: aload_0
      //   21: getfield 29	com/tencent/qqmail/utilities/StateMachine$LogRecords:mMaxSize	I
      //   24: isub
      //   25: istore_1
      //   26: aload_0
      //   27: invokevirtual 67	com/tencent/qqmail/utilities/StateMachine$LogRecords:size	()I
      //   30: istore_2
      //   31: iload_1
      //   32: iload_2
      //   33: if_icmplt +9 -> 42
      //   36: aconst_null
      //   37: astore_3
      //   38: aload_0
      //   39: monitorexit
      //   40: aload_3
      //   41: areturn
      //   42: aload_0
      //   43: getfield 27	com/tencent/qqmail/utilities/StateMachine$LogRecords:mLogRecVector	Ljava/util/Vector;
      //   46: iload_1
      //   47: invokevirtual 57	java/util/Vector:get	(I)Ljava/lang/Object;
      //   50: checkcast 48	com/tencent/qqmail/utilities/StateMachine$LogRec
      //   53: astore_3
      //   54: goto -16 -> 38
      //   57: astore_3
      //   58: aload_0
      //   59: monitorexit
      //   60: aload_3
      //   61: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	62	0	this	LogRecords
      //   0	62	1	paramInt	int
      //   8	26	2	i	int
      //   37	17	3	localLogRec	StateMachine.LogRec
      //   57	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	9	57	finally
      //   11	26	57	finally
      //   26	31	57	finally
      //   42	54	57	finally
    }
    
    boolean logOnlyTransitions()
    {
      try
      {
        boolean bool = this.mLogOnlyTransitions;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    void setLogOnlyTransitions(boolean paramBoolean)
    {
      try
      {
        this.mLogOnlyTransitions = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    void setSize(int paramInt)
    {
      try
      {
        this.mMaxSize = paramInt;
        this.mCount = 0;
        this.mLogRecVector.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    int size()
    {
      try
      {
        int i = this.mLogRecVector.size();
        return i;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static class SmHandler
    extends Handler
  {
    private static final Object mSmHandlerObj = new Object();
    private boolean mDbg = false;
    private ArrayList<Message> mDeferredMessages = new ArrayList();
    private State mDestState;
    private HaltingState mHaltingState = new HaltingState(null);
    private boolean mHasQuit = false;
    private State mInitialState;
    private boolean mIsConstructionCompleted;
    private StateMachine.LogRecords mLogRecords = new StateMachine.LogRecords(null);
    private Message mMsg;
    private QuittingState mQuittingState = new QuittingState(null);
    private StateMachine mSm;
    private HashMap<State, StateInfo> mStateInfo = new HashMap();
    private StateInfo[] mStateStack;
    private int mStateStackTopIndex = -1;
    private StateInfo[] mTempStateStack;
    private int mTempStateStackCount;
    
    private SmHandler(Looper paramLooper, StateMachine paramStateMachine)
    {
      super();
      this.mSm = paramStateMachine;
      addState(this.mHaltingState, null);
      addState(this.mQuittingState, null);
    }
    
    private final StateInfo addState(State paramState1, State paramState2)
    {
      Object localObject2;
      Object localObject1;
      if (this.mDbg)
      {
        localObject2 = this.mSm;
        StringBuilder localStringBuilder = new StringBuilder().append("addStateInternal: E state=").append(paramState1.getName()).append(",parent=");
        if (paramState2 == null)
        {
          localObject1 = "";
          ((StateMachine)localObject2).log((String)localObject1);
        }
      }
      else
      {
        if (paramState2 == null) {
          break label216;
        }
        localObject1 = (StateInfo)this.mStateInfo.get(paramState2);
        if (localObject1 != null) {
          break label211;
        }
        paramState2 = addState(paramState2, null);
      }
      for (;;)
      {
        localObject2 = (StateInfo)this.mStateInfo.get(paramState1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new StateInfo(null);
          this.mStateInfo.put(paramState1, localObject1);
        }
        if ((((StateInfo)localObject1).parentStateInfo != null) && (((StateInfo)localObject1).parentStateInfo != paramState2))
        {
          throw new RuntimeException("state already added");
          localObject1 = paramState2.getName();
          break;
        }
        ((StateInfo)localObject1).state = paramState1;
        ((StateInfo)localObject1).parentStateInfo = paramState2;
        ((StateInfo)localObject1).active = false;
        if (this.mDbg) {
          this.mSm.log("addStateInternal: X stateInfo: " + localObject1);
        }
        return localObject1;
        label211:
        paramState2 = (State)localObject1;
        continue;
        label216:
        paramState2 = null;
      }
    }
    
    private final void cleanupAfterQuitting()
    {
      if (this.mSm.mSmThread != null)
      {
        getLooper().quit();
        StateMachine.access$402(this.mSm, null);
      }
      StateMachine.access$502(this.mSm, null);
      this.mSm = null;
      this.mMsg = null;
      this.mLogRecords.cleanup();
      this.mStateStack = null;
      this.mTempStateStack = null;
      this.mStateInfo.clear();
      this.mInitialState = null;
      this.mDestState = null;
      this.mDeferredMessages.clear();
      this.mHasQuit = true;
    }
    
    private final void completeConstruction()
    {
      if (this.mDbg) {
        this.mSm.log("completeConstruction: E");
      }
      Iterator localIterator = this.mStateInfo.values().iterator();
      int i = 0;
      int j;
      if (localIterator.hasNext())
      {
        StateInfo localStateInfo = (StateInfo)localIterator.next();
        j = 0;
        while (localStateInfo != null)
        {
          localStateInfo = localStateInfo.parentStateInfo;
          j += 1;
        }
        if (i >= j) {
          break label168;
        }
      }
      for (;;)
      {
        i = j;
        break;
        if (this.mDbg) {
          this.mSm.log("completeConstruction: maxDepth=" + i);
        }
        this.mStateStack = new StateInfo[i];
        this.mTempStateStack = new StateInfo[i];
        setupInitialStateStack();
        sendMessageAtFrontOfQueue(obtainMessage(-2, mSmHandlerObj));
        if (this.mDbg) {
          this.mSm.log("completeConstruction: X");
        }
        return;
        label168:
        j = i;
      }
    }
    
    private final void deferMessage(Message paramMessage)
    {
      if (this.mDbg) {
        this.mSm.log("deferMessage: msg=" + paramMessage.what);
      }
      Message localMessage = obtainMessage();
      localMessage.copyFrom(paramMessage);
      this.mDeferredMessages.add(localMessage);
    }
    
    private final Message getCurrentMessage()
    {
      return this.mMsg;
    }
    
    private final IState getCurrentState()
    {
      return this.mStateStack[this.mStateStackTopIndex].state;
    }
    
    private final void invokeEnterMethods(int paramInt)
    {
      while (paramInt <= this.mStateStackTopIndex)
      {
        if (this.mDbg) {
          this.mSm.log("invokeEnterMethods: " + this.mStateStack[paramInt].state.getName());
        }
        this.mStateStack[paramInt].state.enter();
        this.mStateStack[paramInt].active = true;
        paramInt += 1;
      }
    }
    
    private final void invokeExitMethods(StateInfo paramStateInfo)
    {
      while ((this.mStateStackTopIndex >= 0) && (this.mStateStack[this.mStateStackTopIndex] != paramStateInfo))
      {
        State localState = this.mStateStack[this.mStateStackTopIndex].state;
        if (this.mDbg) {
          this.mSm.log("invokeExitMethods: " + localState.getName());
        }
        localState.exit();
        this.mStateStack[this.mStateStackTopIndex].active = false;
        this.mStateStackTopIndex -= 1;
      }
    }
    
    private final boolean isDbg()
    {
      return this.mDbg;
    }
    
    private final boolean isQuit(Message paramMessage)
    {
      return (paramMessage.what == -1) && (paramMessage.obj == mSmHandlerObj);
    }
    
    private final void moveDeferredMessageAtFrontOfQueue()
    {
      int i = this.mDeferredMessages.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.mDeferredMessages.get(i);
        if (this.mDbg) {
          this.mSm.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i -= 1;
      }
      this.mDeferredMessages.clear();
    }
    
    private final int moveTempStateStackToStateStack()
    {
      int k = this.mStateStackTopIndex + 1;
      int i = this.mTempStateStackCount - 1;
      int j = k;
      while (i >= 0)
      {
        if (this.mDbg) {
          this.mSm.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
        }
        this.mStateStack[j] = this.mTempStateStack[i];
        j += 1;
        i -= 1;
      }
      this.mStateStackTopIndex = (j - 1);
      if (this.mDbg) {
        this.mSm.log("moveTempStackToStateStack: X mStateStackTop=" + this.mStateStackTopIndex + ",startingIndex=" + k + ",Top=" + this.mStateStack[this.mStateStackTopIndex].state.getName());
      }
      return k;
    }
    
    private void performTransitions(State paramState, Message paramMessage)
    {
      State localState = this.mStateStack[this.mStateStackTopIndex].state;
      int i;
      if ((this.mSm.recordLogRec(this.mMsg)) && (paramMessage.obj != mSmHandlerObj))
      {
        i = 1;
        if (!this.mLogRecords.logOnlyTransitions()) {
          break label160;
        }
        if (this.mDestState != null) {
          this.mLogRecords.add(this.mSm, this.mMsg, this.mSm.getLogRecString(this.mMsg), paramState, localState, this.mDestState);
        }
      }
      for (;;)
      {
        paramState = this.mDestState;
        paramMessage = paramState;
        if (paramState == null) {
          break label207;
        }
        for (;;)
        {
          if (this.mDbg) {
            this.mSm.log("handleMessage: new destination call exit/enter");
          }
          invokeExitMethods(setupTempStateStackWithStatesToEnter(paramState));
          invokeEnterMethods(moveTempStateStackToStateStack());
          moveDeferredMessageAtFrontOfQueue();
          if (paramState == this.mDestState) {
            break;
          }
          paramState = this.mDestState;
        }
        i = 0;
        break;
        label160:
        if (i != 0) {
          this.mLogRecords.add(this.mSm, this.mMsg, this.mSm.getLogRecString(this.mMsg), paramState, localState, this.mDestState);
        }
      }
      this.mDestState = null;
      paramMessage = paramState;
      label207:
      if (paramMessage != null)
      {
        if (paramMessage != this.mQuittingState) {
          break label231;
        }
        this.mSm.onQuitting();
        cleanupAfterQuitting();
      }
      label231:
      while (paramMessage != this.mHaltingState) {
        return;
      }
      this.mSm.onHalting();
    }
    
    private final State processMsg(Message paramMessage)
    {
      Object localObject2 = this.mStateStack[this.mStateStackTopIndex];
      if (this.mDbg) {
        this.mSm.log("processMsg: " + ((StateInfo)localObject2).state.getName());
      }
      Object localObject1 = localObject2;
      if (isQuit(paramMessage)) {
        transitionTo(this.mQuittingState);
      }
      while (localObject2 != null)
      {
        return ((StateInfo)localObject2).state;
        do
        {
          localObject1 = localObject2;
          if (this.mDbg)
          {
            this.mSm.log("processMsg: " + ((StateInfo)localObject2).state.getName());
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1.state.processMessage(paramMessage)) {
            break;
          }
          localObject2 = localObject1.parentStateInfo;
        } while (localObject2 != null);
        this.mSm.unhandledMessage(paramMessage);
      }
      return null;
    }
    
    private final void quit()
    {
      if (this.mDbg) {
        this.mSm.log("quit:");
      }
      sendMessage(obtainMessage(-1, mSmHandlerObj));
    }
    
    private final void quitNow()
    {
      if (this.mDbg) {
        this.mSm.log("quitNow:");
      }
      sendMessageAtFrontOfQueue(obtainMessage(-1, mSmHandlerObj));
    }
    
    private final void setDbg(boolean paramBoolean)
    {
      this.mDbg = paramBoolean;
    }
    
    private final void setInitialState(State paramState)
    {
      if (this.mDbg) {
        this.mSm.log("setInitialState: initialState=" + paramState.getName());
      }
      this.mInitialState = paramState;
    }
    
    private final void setupInitialStateStack()
    {
      if (this.mDbg) {
        this.mSm.log("setupInitialStateStack: E mInitialState=" + this.mInitialState.getName());
      }
      StateInfo localStateInfo = (StateInfo)this.mStateInfo.get(this.mInitialState);
      for (this.mTempStateStackCount = 0; localStateInfo != null; this.mTempStateStackCount += 1)
      {
        this.mTempStateStack[this.mTempStateStackCount] = localStateInfo;
        localStateInfo = localStateInfo.parentStateInfo;
      }
      this.mStateStackTopIndex = -1;
      moveTempStateStackToStateStack();
    }
    
    private final StateInfo setupTempStateStackWithStatesToEnter(State paramState)
    {
      this.mTempStateStackCount = 0;
      paramState = (StateInfo)this.mStateInfo.get(paramState);
      Object localObject;
      do
      {
        localObject = this.mTempStateStack;
        int i = this.mTempStateStackCount;
        this.mTempStateStackCount = (i + 1);
        localObject[i] = paramState;
        localObject = paramState.parentStateInfo;
        if (localObject == null) {
          break;
        }
        paramState = (State)localObject;
      } while (!((StateInfo)localObject).active);
      if (this.mDbg) {
        this.mSm.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.mTempStateStackCount + ",curStateInfo: " + localObject);
      }
      return localObject;
    }
    
    private final void transitionTo(IState paramIState)
    {
      this.mDestState = ((State)paramIState);
      if (this.mDbg) {
        this.mSm.log("transitionTo: destState=" + this.mDestState.getName());
      }
    }
    
    public final void handleMessage(Message paramMessage)
    {
      State localState;
      if (!this.mHasQuit)
      {
        if (this.mDbg) {
          this.mSm.log("handleMessage: E msg.what=" + paramMessage.what);
        }
        this.mMsg = paramMessage;
        localState = null;
        if (!this.mIsConstructionCompleted) {
          break label95;
        }
        localState = processMsg(paramMessage);
      }
      for (;;)
      {
        performTransitions(localState, paramMessage);
        if ((this.mDbg) && (this.mSm != null)) {
          this.mSm.log("handleMessage: X");
        }
        return;
        label95:
        if ((this.mIsConstructionCompleted) || (this.mMsg.what != -2) || (this.mMsg.obj != mSmHandlerObj)) {
          break;
        }
        this.mIsConstructionCompleted = true;
        invokeEnterMethods(0);
      }
      throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + paramMessage);
    }
    
    class HaltingState
      extends State
    {
      private HaltingState() {}
      
      public boolean processMessage(Message paramMessage)
      {
        StateMachine.this.haltedProcessMessage(paramMessage);
        return true;
      }
    }
    
    class QuittingState
      extends State
    {
      private QuittingState() {}
      
      public boolean processMessage(Message paramMessage)
      {
        return false;
      }
    }
    
    class StateInfo
    {
      boolean active;
      StateInfo parentStateInfo;
      State state;
      
      private StateInfo() {}
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder().append("state=").append(this.state.getName()).append(",active=").append(this.active).append(",parent=");
        if (this.parentStateInfo == null) {}
        for (String str = "null";; str = this.parentStateInfo.state.getName()) {
          return str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.StateMachine
 * JD-Core Version:    0.7.0.1
 */