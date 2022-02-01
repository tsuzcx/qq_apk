package com.tencent.qplus.swingworker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ScheduleLinkedBlockingQueue<E>
  extends AbstractQueue<E>
  implements Serializable, BlockingQueue<E>
{
  private static final long serialVersionUID = -6903933977591709194L;
  private final int capacity;
  private final AtomicInteger count = new AtomicInteger(0);
  private ThreadPoolExecutor executor;
  private transient Node<E> head;
  private transient Node<E> last;
  private final Condition notEmpty = this.takeLock.newCondition();
  private final Condition notFull = this.putLock.newCondition();
  private final ReentrantLock putLock = new ReentrantLock();
  private final ReentrantLock takeLock = new ReentrantLock();
  
  public ScheduleLinkedBlockingQueue()
  {
    this(2147483647);
  }
  
  public ScheduleLinkedBlockingQueue(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException();
    }
    this.capacity = paramInt;
    Node localNode = new Node(null);
    this.head = localNode;
    this.last = localNode;
  }
  
  /* Error */
  private boolean deQueueAvaillableElement(ThreadPoolExecutor.Worker paramWorker)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 82	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:executor	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   4: getfield 87	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   7: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   10: aload_0
    //   11: invokevirtual 94	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:iterator	()Ljava/util/Iterator;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 100 1 0
    //   21: istore_2
    //   22: iload_2
    //   23: ifne +15 -> 38
    //   26: aload_0
    //   27: getfield 82	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:executor	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   30: getfield 87	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   33: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   36: iconst_0
    //   37: ireturn
    //   38: aload_3
    //   39: invokeinterface 107 1 0
    //   44: astore 4
    //   46: aload 4
    //   48: instanceof 109
    //   51: ifeq +45 -> 96
    //   54: aload_0
    //   55: getfield 82	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:executor	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   58: aload 4
    //   60: checkcast 109	com/tencent/qplus/swingworker/SchedulingRule
    //   63: invokevirtual 113	com/tencent/qplus/swingworker/ThreadPoolExecutor:isConflicting	(Lcom/tencent/qplus/swingworker/SchedulingRule;)Z
    //   66: ifne -51 -> 15
    //   69: aload_1
    //   70: aload 4
    //   72: checkcast 115	java/lang/Runnable
    //   75: putfield 121	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
    //   78: aload_3
    //   79: invokeinterface 124 1 0
    //   84: aload_0
    //   85: getfield 82	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:executor	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   88: getfield 87	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_1
    //   97: aload 4
    //   99: checkcast 115	java/lang/Runnable
    //   102: putfield 121	com/tencent/qplus/swingworker/ThreadPoolExecutor$Worker:currentTask	Ljava/lang/Runnable;
    //   105: aload_3
    //   106: invokeinterface 124 1 0
    //   111: goto -27 -> 84
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 82	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:executor	Lcom/tencent/qplus/swingworker/ThreadPoolExecutor;
    //   119: getfield 87	com/tencent/qplus/swingworker/ThreadPoolExecutor:mainLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   122: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ScheduleLinkedBlockingQueue
    //   0	127	1	paramWorker	ThreadPoolExecutor.Worker
    //   21	2	2	bool	boolean
    //   14	92	3	localIterator	Iterator
    //   44	54	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	15	114	finally
    //   15	22	114	finally
    //   38	84	114	finally
    //   96	111	114	finally
  }
  
  private E dequeue()
  {
    Object localObject = this.head;
    Node localNode = ((Node)localObject).next;
    ((Node)localObject).next = ((Node)localObject);
    this.head = localNode;
    localObject = localNode.item;
    localNode.item = null;
    return localObject;
  }
  
  private E dequeue(Node<E> paramNode)
  {
    Node localNode = paramNode.next;
    if (localNode != this.last)
    {
      paramNode.next = localNode.next;
      localNode.next = localNode;
    }
    for (;;)
    {
      return localNode.item;
      paramNode.next = null;
      this.last = paramNode;
    }
  }
  
  private void enqueue(E paramE)
  {
    Node localNode = this.last;
    paramE = new Node(paramE);
    localNode.next = paramE;
    this.last = paramE;
  }
  
  private Node<E> get(int paramInt)
  {
    Node localNode = this.head;
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return localNode;
      }
      localNode = localNode.next;
      i += 1;
    }
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.count.set(0);
    Object localObject = new Node(null);
    this.head = ((Node)localObject);
    this.last = ((Node)localObject);
    for (;;)
    {
      localObject = paramObjectInputStream.readObject();
      if (localObject == null) {
        return;
      }
      add(localObject);
    }
  }
  
  private void signalNotEmpty()
  {
    ReentrantLock localReentrantLock = this.takeLock;
    localReentrantLock.lock();
    try
    {
      this.notEmpty.signal();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  private void signalNotFull()
  {
    ReentrantLock localReentrantLock = this.putLock;
    localReentrantLock.lock();
    try
    {
      this.notFull.signal();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  private void writeObject(java.io.ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 173	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyLock	()V
    //   4: aload_1
    //   5: invokevirtual 178	java/io/ObjectOutputStream:defaultWriteObject	()V
    //   8: aload_0
    //   9: getfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   12: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +13 -> 30
    //   20: aload_1
    //   21: aconst_null
    //   22: invokevirtual 180	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   25: aload_0
    //   26: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   29: return
    //   30: aload_1
    //   31: aload_2
    //   32: getfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   35: invokevirtual 180	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_2
    //   39: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   42: astore_2
    //   43: goto -27 -> 16
    //   46: astore_1
    //   47: aload_0
    //   48: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	ScheduleLinkedBlockingQueue
    //   0	53	1	paramObjectOutputStream	java.io.ObjectOutputStream
    //   15	28	2	localNode	Node
    // Exception table:
    //   from	to	target	type
    //   4	16	46	finally
    //   20	25	46	finally
    //   30	43	46	finally
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 173	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyLock	()V
    //   4: aload_0
    //   5: getfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   8: astore_1
    //   9: aload_1
    //   10: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +40 -> 55
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 76	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:last	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   23: putfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   26: aload_0
    //   27: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_0
    //   31: invokevirtual 188	java/util/concurrent/atomic/AtomicInteger:getAndSet	(I)I
    //   34: aload_0
    //   35: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   38: if_icmpne +12 -> 50
    //   41: aload_0
    //   42: getfield 64	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notFull	Ljava/util/concurrent/locks/Condition;
    //   45: invokeinterface 167 1 0
    //   50: aload_0
    //   51: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   54: return
    //   55: aload_1
    //   56: aload_1
    //   57: putfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   60: aload_2
    //   61: aconst_null
    //   62: putfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   65: aload_2
    //   66: astore_1
    //   67: goto -58 -> 9
    //   70: astore_1
    //   71: aload_0
    //   72: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ScheduleLinkedBlockingQueue
    //   8	59	1	localObject1	Object
    //   70	6	1	localObject2	Object
    //   13	53	2	localNode	Node
    // Exception table:
    //   from	to	target	type
    //   4	9	70	finally
    //   9	14	70	finally
    //   18	50	70	finally
    //   55	65	70	finally
  }
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }
  
  /* Error */
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: ifnonnull +11 -> 20
    //   12: new 196	java/lang/NullPointerException
    //   15: dup
    //   16: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   19: athrow
    //   20: aload_1
    //   21: aload_0
    //   22: if_acmpne +11 -> 33
    //   25: new 66	java/lang/IllegalArgumentException
    //   28: dup
    //   29: invokespecial 67	java/lang/IllegalArgumentException:<init>	()V
    //   32: athrow
    //   33: aload_0
    //   34: getfield 54	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:takeLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   37: astore 9
    //   39: aload 9
    //   41: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   44: iload_2
    //   45: aload_0
    //   46: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   49: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   52: invokestatic 206	java/lang/Math:min	(II)I
    //   55: istore 6
    //   57: aload_0
    //   58: getfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   61: astore 7
    //   63: iconst_0
    //   64: istore_2
    //   65: iload_2
    //   66: iload 6
    //   68: if_icmplt +54 -> 122
    //   71: iload_2
    //   72: ifle +168 -> 240
    //   75: aload_0
    //   76: aload 7
    //   78: putfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   81: aload_0
    //   82: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   85: iload_2
    //   86: ineg
    //   87: invokevirtual 209	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   90: istore_2
    //   91: aload_0
    //   92: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   95: istore 5
    //   97: iload_2
    //   98: iload 5
    //   100: if_icmpne +65 -> 165
    //   103: iload 4
    //   105: istore_2
    //   106: aload 9
    //   108: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   111: iload_2
    //   112: ifeq +7 -> 119
    //   115: aload_0
    //   116: invokespecial 211	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotFull	()V
    //   119: iload 6
    //   121: ireturn
    //   122: aload 7
    //   124: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   127: astore 8
    //   129: aload_1
    //   130: aload 8
    //   132: getfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   135: invokeinterface 214 2 0
    //   140: pop
    //   141: aload 8
    //   143: aconst_null
    //   144: putfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   147: aload 7
    //   149: aload 7
    //   151: putfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   154: iload_2
    //   155: iconst_1
    //   156: iadd
    //   157: istore_2
    //   158: aload 8
    //   160: astore 7
    //   162: goto -97 -> 65
    //   165: iconst_0
    //   166: istore_2
    //   167: goto -61 -> 106
    //   170: astore_1
    //   171: iload_2
    //   172: ifle +63 -> 235
    //   175: aload_0
    //   176: aload 7
    //   178: putfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   181: aload_0
    //   182: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   185: iload_2
    //   186: ineg
    //   187: invokevirtual 209	java/util/concurrent/atomic/AtomicInteger:getAndAdd	(I)I
    //   190: istore_2
    //   191: aload_0
    //   192: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   195: istore 4
    //   197: iload_2
    //   198: iload 4
    //   200: if_icmpne +24 -> 224
    //   203: iload 5
    //   205: istore_2
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: aload 9
    //   211: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   214: iload_2
    //   215: ifeq +7 -> 222
    //   218: aload_0
    //   219: invokespecial 211	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotFull	()V
    //   222: aload_1
    //   223: athrow
    //   224: iconst_0
    //   225: istore_2
    //   226: goto -20 -> 206
    //   229: astore_1
    //   230: iload_3
    //   231: istore_2
    //   232: goto -23 -> 209
    //   235: iconst_0
    //   236: istore_2
    //   237: goto -31 -> 206
    //   240: iconst_0
    //   241: istore_2
    //   242: goto -136 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	ScheduleLinkedBlockingQueue
    //   0	245	1	paramCollection	Collection<? super E>
    //   0	245	2	paramInt	int
    //   7	224	3	i	int
    //   4	197	4	j	int
    //   1	203	5	k	int
    //   55	65	6	m	int
    //   61	116	7	localObject	Object
    //   127	32	8	localNode	Node
    //   37	173	9	localReentrantLock	ReentrantLock
    // Exception table:
    //   from	to	target	type
    //   122	154	170	finally
    //   206	208	208	finally
    //   44	63	229	finally
    //   75	97	229	finally
    //   175	197	229	finally
  }
  
  void fullyLock()
  {
    this.putLock.lock();
    this.takeLock.lock();
  }
  
  void fullyUnlock()
  {
    this.takeLock.unlock();
    this.putLock.unlock();
  }
  
  public ThreadPoolExecutor getExecutor()
  {
    return this.executor;
  }
  
  boolean isFullyLocked()
  {
    return (this.putLock.isHeldByCurrentThread()) && (this.takeLock.isHeldByCurrentThread());
  }
  
  public Iterator<E> iterator()
  {
    return new Itr();
  }
  
  public boolean offer(E paramE)
  {
    if (paramE == null) {
      throw new NullPointerException();
    }
    AtomicInteger localAtomicInteger = this.count;
    if (localAtomicInteger.get() == this.capacity) {
      return false;
    }
    int i = -1;
    ReentrantLock localReentrantLock = this.putLock;
    localReentrantLock.lock();
    try
    {
      if (localAtomicInteger.get() < this.capacity)
      {
        enqueue(paramE);
        int j = localAtomicInteger.getAndIncrement();
        i = j;
        if (j + 1 < this.capacity)
        {
          this.notFull.signal();
          i = j;
        }
      }
      localReentrantLock.unlock();
      if (i >= 0) {
        signalNotEmpty();
      }
      if (i >= 0) {
        return true;
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    return false;
  }
  
  /* Error */
  public boolean offer(E paramE, long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 196	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: aload 4
    //   14: lload_2
    //   15: invokevirtual 243	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   18: lstore_2
    //   19: aload_0
    //   20: getfield 62	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:putLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: astore 6
    //   31: aload 4
    //   33: invokevirtual 246	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   36: aload 6
    //   38: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   41: aload_0
    //   42: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   45: if_icmpeq +51 -> 96
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 228	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:enqueue	(Ljava/lang/Object;)V
    //   53: aload 6
    //   55: invokevirtual 231	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   58: istore 5
    //   60: iload 5
    //   62: iconst_1
    //   63: iadd
    //   64: aload_0
    //   65: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   68: if_icmpge +12 -> 80
    //   71: aload_0
    //   72: getfield 64	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notFull	Ljava/util/concurrent/locks/Condition;
    //   75: invokeinterface 167 1 0
    //   80: aload 4
    //   82: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   85: iload 5
    //   87: iflt +7 -> 94
    //   90: aload_0
    //   91: invokespecial 233	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotEmpty	()V
    //   94: iconst_1
    //   95: ireturn
    //   96: lload_2
    //   97: lconst_0
    //   98: lcmp
    //   99: ifgt +10 -> 109
    //   102: aload 4
    //   104: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: aload_0
    //   110: getfield 64	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notFull	Ljava/util/concurrent/locks/Condition;
    //   113: lload_2
    //   114: invokeinterface 249 3 0
    //   119: lstore_2
    //   120: goto -84 -> 36
    //   123: astore_1
    //   124: aload 4
    //   126: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	ScheduleLinkedBlockingQueue
    //   0	131	1	paramE	E
    //   0	131	2	paramLong	long
    //   0	131	4	paramTimeUnit	java.util.concurrent.TimeUnit
    //   58	28	5	i	int
    //   29	25	6	localAtomicInteger	AtomicInteger
    // Exception table:
    //   from	to	target	type
    //   36	80	123	finally
    //   109	120	123	finally
  }
  
  public E peek()
  {
    if (this.count.get() == 0) {
      return null;
    }
    ReentrantLock localReentrantLock = this.takeLock;
    localReentrantLock.lock();
    try
    {
      Object localObject1 = this.head.next;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((Node)localObject1).item;
      return localObject1;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
  
  public E poll()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    AtomicInteger localAtomicInteger = this.count;
    if (localAtomicInteger.get() == 0) {}
    for (;;)
    {
      return localObject3;
      int i = -1;
      ReentrantLock localReentrantLock = this.takeLock;
      localReentrantLock.lock();
      try
      {
        if (localAtomicInteger.get() > 0)
        {
          localObject3 = dequeue();
          int j = localAtomicInteger.getAndDecrement();
          i = j;
          localObject1 = localObject3;
          if (j > 1)
          {
            this.notEmpty.signal();
            localObject1 = localObject3;
            i = j;
          }
        }
        localReentrantLock.unlock();
        localObject3 = localObject1;
        if (i != this.capacity) {
          continue;
        }
        signalNotFull();
        return localObject1;
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
  
  /* Error */
  public E poll(long paramLong, java.util.concurrent.TimeUnit paramTimeUnit)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 243	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 54	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:takeLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 246	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   21: aload 5
    //   23: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   26: ifeq +51 -> 77
    //   29: aload_0
    //   30: invokespecial 254	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:dequeue	()Ljava/lang/Object;
    //   33: astore 6
    //   35: aload 5
    //   37: invokevirtual 257	java/util/concurrent/atomic/AtomicInteger:getAndDecrement	()I
    //   40: istore 4
    //   42: iload 4
    //   44: iconst_1
    //   45: if_icmple +12 -> 57
    //   48: aload_0
    //   49: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   52: invokeinterface 167 1 0
    //   57: aload_3
    //   58: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   61: iload 4
    //   63: aload_0
    //   64: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   67: if_icmpne +7 -> 74
    //   70: aload_0
    //   71: invokespecial 211	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotFull	()V
    //   74: aload 6
    //   76: areturn
    //   77: lload_1
    //   78: lconst_0
    //   79: lcmp
    //   80: ifgt +9 -> 89
    //   83: aload_3
    //   84: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   87: aconst_null
    //   88: areturn
    //   89: aload_0
    //   90: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   93: lload_1
    //   94: invokeinterface 249 3 0
    //   99: lstore_1
    //   100: goto -79 -> 21
    //   103: astore 5
    //   105: aload_3
    //   106: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   109: aload 5
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ScheduleLinkedBlockingQueue
    //   0	112	1	paramLong	long
    //   0	112	3	paramTimeUnit	java.util.concurrent.TimeUnit
    //   40	28	4	i	int
    //   10	26	5	localAtomicInteger	AtomicInteger
    //   103	7	5	localObject1	Object
    //   33	42	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	42	103	finally
    //   48	57	103	finally
    //   89	100	103	finally
  }
  
  /* Error */
  public void polllToWorker(long paramLong, java.util.concurrent.TimeUnit paramTimeUnit, ThreadPoolExecutor.Worker paramWorker)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_3
    //   1: lload_1
    //   2: invokevirtual 243	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 54	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:takeLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 246	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   21: aload 6
    //   23: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   26: ifeq +52 -> 78
    //   29: aload_0
    //   30: aload 4
    //   32: invokespecial 263	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:deQueueAvaillableElement	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)Z
    //   35: ifeq +43 -> 78
    //   38: aload 6
    //   40: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   43: istore 5
    //   45: iload 5
    //   47: iconst_1
    //   48: if_icmple +12 -> 60
    //   51: aload_0
    //   52: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   55: invokeinterface 167 1 0
    //   60: aload_3
    //   61: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   64: iload 5
    //   66: aload_0
    //   67: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   70: if_icmpne +7 -> 77
    //   73: aload_0
    //   74: invokespecial 211	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotFull	()V
    //   77: return
    //   78: lload_1
    //   79: lconst_0
    //   80: lcmp
    //   81: ifgt +8 -> 89
    //   84: aload_3
    //   85: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   88: return
    //   89: aload_0
    //   90: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   93: lload_1
    //   94: invokeinterface 249 3 0
    //   99: pop2
    //   100: goto -79 -> 21
    //   103: astore 4
    //   105: aload_3
    //   106: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   109: aload 4
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ScheduleLinkedBlockingQueue
    //   0	112	1	paramLong	long
    //   0	112	3	paramTimeUnit	java.util.concurrent.TimeUnit
    //   0	112	4	paramWorker	ThreadPoolExecutor.Worker
    //   43	28	5	i	int
    //   10	29	6	localAtomicInteger	AtomicInteger
    // Exception table:
    //   from	to	target	type
    //   21	45	103	finally
    //   51	60	103	finally
    //   89	100	103	finally
  }
  
  /* Error */
  public void put(E paramE)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 196	java/lang/NullPointerException
    //   7: dup
    //   8: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   11: athrow
    //   12: aload_0
    //   13: getfield 62	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:putLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   21: astore 4
    //   23: aload_3
    //   24: invokevirtual 246	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   27: aload 4
    //   29: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   32: aload_0
    //   33: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   36: if_icmpeq +46 -> 82
    //   39: aload_0
    //   40: aload_1
    //   41: invokespecial 228	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:enqueue	(Ljava/lang/Object;)V
    //   44: aload 4
    //   46: invokevirtual 231	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   49: istore_2
    //   50: iload_2
    //   51: iconst_1
    //   52: iadd
    //   53: aload_0
    //   54: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   57: if_icmpge +12 -> 69
    //   60: aload_0
    //   61: getfield 64	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notFull	Ljava/util/concurrent/locks/Condition;
    //   64: invokeinterface 167 1 0
    //   69: aload_3
    //   70: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   73: iload_2
    //   74: iflt +7 -> 81
    //   77: aload_0
    //   78: invokespecial 233	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotEmpty	()V
    //   81: return
    //   82: aload_0
    //   83: getfield 64	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notFull	Ljava/util/concurrent/locks/Condition;
    //   86: invokeinterface 267 1 0
    //   91: goto -64 -> 27
    //   94: astore_1
    //   95: aload_3
    //   96: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ScheduleLinkedBlockingQueue
    //   0	101	1	paramE	E
    //   49	25	2	i	int
    //   16	80	3	localReentrantLock	ReentrantLock
    //   21	24	4	localAtomicInteger	AtomicInteger
    // Exception table:
    //   from	to	target	type
    //   27	69	94	finally
    //   82	91	94	finally
  }
  
  public int remainingCapacity()
  {
    return this.capacity - this.count.get();
  }
  
  /* Error */
  public boolean remove(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 173	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyLock	()V
    //   10: aload_0
    //   11: getfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   14: astore_3
    //   15: aload_3
    //   16: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +9 -> 30
    //   24: aload_0
    //   25: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_1
    //   31: aload_2
    //   32: getfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   35: invokevirtual 273	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   38: ifeq +15 -> 53
    //   41: aload_0
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 277	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:unlink	(Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;)V
    //   47: aload_0
    //   48: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_2
    //   54: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   57: astore 4
    //   59: aload_2
    //   60: astore_3
    //   61: aload 4
    //   63: astore_2
    //   64: goto -44 -> 20
    //   67: astore_1
    //   68: aload_0
    //   69: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ScheduleLinkedBlockingQueue
    //   0	74	1	paramObject	Object
    //   19	45	2	localObject1	Object
    //   14	47	3	localObject2	Object
    //   57	5	4	localNode	Node
    // Exception table:
    //   from	to	target	type
    //   10	20	67	finally
    //   30	47	67	finally
    //   53	59	67	finally
  }
  
  public void setExecutor(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.executor = paramThreadPoolExecutor;
  }
  
  public int size()
  {
    return this.count.get();
  }
  
  /* Error */
  public E take()
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 54	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:takeLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 246	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   14: aload_3
    //   15: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   18: ifeq +47 -> 65
    //   21: aload_0
    //   22: invokespecial 254	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:dequeue	()Ljava/lang/Object;
    //   25: astore 4
    //   27: aload_3
    //   28: invokevirtual 257	java/util/concurrent/atomic/AtomicInteger:getAndDecrement	()I
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_1
    //   34: if_icmple +12 -> 46
    //   37: aload_0
    //   38: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   41: invokeinterface 167 1 0
    //   46: aload_2
    //   47: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   50: iload_1
    //   51: aload_0
    //   52: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   55: if_icmpne +7 -> 62
    //   58: aload_0
    //   59: invokespecial 211	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotFull	()V
    //   62: aload 4
    //   64: areturn
    //   65: aload_0
    //   66: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   69: invokeinterface 267 1 0
    //   74: goto -60 -> 14
    //   77: astore_3
    //   78: aload_2
    //   79: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   82: aload_3
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ScheduleLinkedBlockingQueue
    //   31	25	1	i	int
    //   9	70	2	localReentrantLock	ReentrantLock
    //   4	24	3	localAtomicInteger	AtomicInteger
    //   77	6	3	localObject1	Object
    //   25	38	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	32	77	finally
    //   37	46	77	finally
    //   65	74	77	finally
  }
  
  /* Error */
  public void takeToWorker(ThreadPoolExecutor.Worker paramWorker)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 54	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:takeLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 246	java/util/concurrent/locks/ReentrantLock:lockInterruptibly	()V
    //   15: aload 4
    //   17: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   20: ifeq +47 -> 67
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial 263	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:deQueueAvaillableElement	(Lcom/tencent/qplus/swingworker/ThreadPoolExecutor$Worker;)Z
    //   28: ifeq +39 -> 67
    //   31: aload 4
    //   33: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   36: istore_2
    //   37: iload_2
    //   38: ifle +12 -> 50
    //   41: aload_0
    //   42: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   45: invokeinterface 167 1 0
    //   50: aload_3
    //   51: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   54: iload_2
    //   55: aload_0
    //   56: getfield 69	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:capacity	I
    //   59: if_icmpne +7 -> 66
    //   62: aload_0
    //   63: invokespecial 211	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:signalNotFull	()V
    //   66: return
    //   67: aload_0
    //   68: getfield 60	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:notEmpty	Ljava/util/concurrent/locks/Condition;
    //   71: invokeinterface 267 1 0
    //   76: goto -61 -> 15
    //   79: astore_1
    //   80: aload_3
    //   81: invokevirtual 103	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ScheduleLinkedBlockingQueue
    //   0	86	1	paramWorker	ThreadPoolExecutor.Worker
    //   36	24	2	i	int
    //   10	71	3	localReentrantLock	ReentrantLock
    //   4	28	4	localAtomicInteger	AtomicInteger
    // Exception table:
    //   from	to	target	type
    //   15	37	79	finally
    //   41	50	79	finally
    //   67	76	79	finally
  }
  
  /* Error */
  public Object[] toArray()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 173	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyLock	()V
    //   4: aload_0
    //   5: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   8: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   11: anewarray 270	java/lang/Object
    //   14: astore_3
    //   15: iconst_0
    //   16: istore_1
    //   17: aload_0
    //   18: getfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   21: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnonnull +9 -> 35
    //   29: aload_0
    //   30: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   33: aload_3
    //   34: areturn
    //   35: aload_3
    //   36: iload_1
    //   37: aload_2
    //   38: getfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   41: aastore
    //   42: aload_2
    //   43: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   46: astore_2
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: istore_1
    //   51: goto -26 -> 25
    //   54: astore_2
    //   55: aload_0
    //   56: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   59: aload_2
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	ScheduleLinkedBlockingQueue
    //   16	35	1	i	int
    //   24	23	2	localNode	Node
    //   54	6	2	localObject	Object
    //   14	22	3	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   4	15	54	finally
    //   17	25	54	finally
    //   35	47	54	finally
  }
  
  /* Error */
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 173	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyLock	()V
    //   4: aload_0
    //   5: getfield 49	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:count	Ljava/util/concurrent/atomic/AtomicInteger;
    //   8: invokevirtual 200	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   11: istore_2
    //   12: aload_1
    //   13: astore_3
    //   14: aload_1
    //   15: arraylength
    //   16: iload_2
    //   17: if_icmpge +18 -> 35
    //   20: aload_1
    //   21: invokevirtual 290	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: invokevirtual 295	java/lang/Class:getComponentType	()Ljava/lang/Class;
    //   27: iload_2
    //   28: invokestatic 301	java/lang/reflect/Array:newInstance	(Ljava/lang/Class;I)Ljava/lang/Object;
    //   31: checkcast 303	[Ljava/lang/Object;
    //   34: astore_3
    //   35: iconst_0
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 74	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:head	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   41: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnonnull +19 -> 65
    //   49: aload_3
    //   50: arraylength
    //   51: iload_2
    //   52: if_icmple +7 -> 59
    //   55: aload_3
    //   56: iload_2
    //   57: aconst_null
    //   58: aastore
    //   59: aload_0
    //   60: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   63: aload_3
    //   64: areturn
    //   65: aload_3
    //   66: iload_2
    //   67: aload_1
    //   68: getfield 131	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:item	Ljava/lang/Object;
    //   71: aastore
    //   72: aload_1
    //   73: getfield 127	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node:next	Lcom/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue$Node;
    //   76: astore_1
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_2
    //   81: goto -36 -> 45
    //   84: astore_1
    //   85: aload_0
    //   86: invokevirtual 183	com/tencent/qplus/swingworker/ScheduleLinkedBlockingQueue:fullyUnlock	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	ScheduleLinkedBlockingQueue
    //   0	91	1	paramArrayOfT	T[]
    //   11	70	2	i	int
    //   13	53	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	12	84	finally
    //   14	35	84	finally
    //   37	45	84	finally
    //   49	55	84	finally
    //   65	77	84	finally
  }
  
  public String toString()
  {
    fullyLock();
    try
    {
      String str = super.toString();
      return str;
    }
    finally
    {
      fullyUnlock();
    }
  }
  
  void unlink(Node<E> paramNode1, Node<E> paramNode2)
  {
    paramNode1.item = null;
    paramNode2.next = paramNode1.next;
    if (this.last == paramNode1) {
      this.last = paramNode2;
    }
    if (this.count.getAndDecrement() == this.capacity) {
      this.notFull.signal();
    }
  }
  
  class Itr
    implements Iterator<E>
  {
    private ScheduleLinkedBlockingQueue.Node<E> current;
    private E currentElement;
    private ScheduleLinkedBlockingQueue.Node<E> lastRet;
    
    Itr()
    {
      ScheduleLinkedBlockingQueue.this.fullyLock();
      try
      {
        this.current = ScheduleLinkedBlockingQueue.this.head.next;
        if (this.current != null) {
          this.currentElement = this.current.item;
        }
        return;
      }
      finally
      {
        ScheduleLinkedBlockingQueue.this.fullyUnlock();
      }
    }
    
    private ScheduleLinkedBlockingQueue.Node<E> nextNode(ScheduleLinkedBlockingQueue.Node<E> paramNode)
    {
      for (Object localObject = paramNode;; localObject = paramNode)
      {
        paramNode = ((ScheduleLinkedBlockingQueue.Node)localObject).next;
        if (paramNode == localObject) {
          localObject = ScheduleLinkedBlockingQueue.this.head.next;
        }
        do
        {
          do
          {
            return localObject;
            localObject = paramNode;
          } while (paramNode == null);
          localObject = paramNode;
        } while (paramNode.item != null);
      }
    }
    
    public boolean hasNext()
    {
      return this.current != null;
    }
    
    public E next()
    {
      ScheduleLinkedBlockingQueue.this.fullyLock();
      try
      {
        if (this.current == null) {
          throw new NoSuchElementException();
        }
      }
      finally
      {
        ScheduleLinkedBlockingQueue.this.fullyUnlock();
      }
      Object localObject3 = this.currentElement;
      this.lastRet = this.current;
      this.current = nextNode(this.current);
      if (this.current == null) {}
      for (Object localObject2 = null;; localObject2 = this.current.item)
      {
        this.currentElement = localObject2;
        ScheduleLinkedBlockingQueue.this.fullyUnlock();
        return localObject3;
      }
    }
    
    public void remove()
    {
      if (this.lastRet == null) {
        throw new IllegalStateException();
      }
      ScheduleLinkedBlockingQueue.this.fullyLock();
      for (;;)
      {
        try
        {
          ScheduleLinkedBlockingQueue.Node localNode3 = this.lastRet;
          this.lastRet = null;
          localObject3 = ScheduleLinkedBlockingQueue.this.head;
          ScheduleLinkedBlockingQueue.Node localNode1 = ((ScheduleLinkedBlockingQueue.Node)localObject3).next;
          if (localNode1 == null) {
            return;
          }
          if (localNode1 == localNode3)
          {
            ScheduleLinkedBlockingQueue.this.unlink(localNode1, (ScheduleLinkedBlockingQueue.Node)localObject3);
            continue;
          }
          localNode2 = localObject1.next;
        }
        finally
        {
          ScheduleLinkedBlockingQueue.this.fullyUnlock();
        }
        ScheduleLinkedBlockingQueue.Node localNode2;
        Object localObject3 = localObject1;
        Object localObject2 = localNode2;
      }
    }
  }
  
  static class Node<E>
  {
    E item;
    Node<E> next;
    
    Node(E paramE)
    {
      this.item = paramE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qplus.swingworker.ScheduleLinkedBlockingQueue
 * JD-Core Version:    0.7.0.1
 */