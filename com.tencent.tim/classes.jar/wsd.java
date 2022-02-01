import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic.1;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class wsd
{
  private static String TAG = "PlayLastLogic";
  private static wsd a;
  private long Iw = -1L;
  private long Ix = -1L;
  private long Iy = -1L;
  private int JO;
  private int aKI;
  private int bRx = -1;
  private int bRy = 0;
  private boolean bfM;
  private WeakReference<DoodleMsgLayout> dS;
  private Runnable ek;
  private Map<Integer, wsd.a> hE = new ConcurrentHashMap();
  private int mEndPos;
  private Handler mHandler;
  public int mScrollState = 0;
  private int mStartPos;
  private int mViewHeight;
  
  private void CL(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "restartPlayTimer:" + paramInt);
    }
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    if (this.ek != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.ek == null) {
      this.ek = new PlayLastLogic.1(this);
    }
    this.mHandler.postDelayed(this.ek, paramInt);
  }
  
  public static long a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000)) {
      return paramChatMessage.shmsgseq;
    }
    return paramChatMessage.time;
  }
  
  public static wsd a()
  {
    try
    {
      if (a == null) {
        a = new wsd();
      }
      return a;
    }
    finally {}
  }
  
  private void aB(boolean paramBoolean, int paramInt)
  {
    Object localObject;
    if (paramBoolean)
    {
      if ((this.bfM) || (this.Ix < 0L)) {
        return;
      }
      do
      {
        do
        {
          do
          {
            this.bfM = true;
            localObject = this.hE.values().iterator();
          } while (!((Iterator)localObject).hasNext());
          wsd.a locala = (wsd.a)((Iterator)localObject).next();
          if (locala.IA != this.Iy) {
            break;
          }
          localObject = locala.dL;
        } while (localObject == null);
        localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
      } while (localObject == null);
      ((DoodleMsgLayout)localObject).stop();
      return;
    }
    int i = this.mEndPos;
    label115:
    if (i >= this.mStartPos) {
      if (i != paramInt) {
        break label135;
      }
    }
    for (;;)
    {
      i -= 1;
      break label115;
      break;
      label135:
      localObject = (wsd.a)this.hE.get(Integer.valueOf(i));
      if ((localObject != null) && ((((wsd.a)localObject).Iz > this.Ix) || (((wsd.a)localObject).IA == this.Iy)))
      {
        localObject = ((wsd.a)localObject).dL;
        if (localObject != null)
        {
          localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
          if (localObject != null) {
            ((DoodleMsgLayout)localObject).stop();
          }
        }
      }
    }
  }
  
  public static long b(ChatMessage paramChatMessage)
  {
    return paramChatMessage.uniseq;
  }
  
  public static void destroy()
  {
    try
    {
      if (a != null)
      {
        a.reset();
        a = null;
      }
      return;
    }
    finally {}
  }
  
  private void fy(int paramInt1, int paramInt2)
  {
    if (this.hE.size() == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.hE.entrySet().iterator();
      while (localIterator.hasNext())
      {
        wsd.a locala = (wsd.a)((Map.Entry)localIterator.next()).getValue();
        if ((locala == null) || (locala.mPos < paramInt1) || (locala.mPos > paramInt2)) {
          localIterator.remove();
        }
      }
    }
  }
  
  private int o(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "checkPlayable: bRealPlay:" + paramBoolean);
    }
    wsd.a locala = (wsd.a)this.hE.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      Object localObject = locala.dL;
      if (localObject != null)
      {
        localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
        if (localObject != null)
        {
          Rect localRect = new Rect();
          if ((((DoodleMsgLayout)localObject).getGlobalVisibleRect(localRect)) && (localRect.height() > ((DoodleMsgLayout)localObject).getHeight() * 0.9D))
          {
            if ((!((DoodleMsgLayout)localObject).isPlaying()) && (this.Iw != locala.IA) && (((DoodleMsgLayout)localObject).isDataValid()))
            {
              if (paramBoolean)
              {
                a((DoodleMsgLayout)localObject, false);
                if (locala.IA == this.Iy) {
                  this.bfM = true;
                }
              }
              if (!QLog.isColorLevel()) {
                break label376;
              }
              QLog.d(TAG, 2, "checkPlayable: lastID:" + this.Ix + "lasUniID" + this.Iy + " lastMsgPlayed:" + this.bfM + " playedID:" + this.Iw);
              return 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "checkPlayable: can not play:" + locala.Iz + "uniID:" + locala.IA + " mPlayedID:" + this.Iw);
            }
            if (!((DoodleMsgLayout)localObject).isPlaying()) {
              break label374;
            }
            return 3;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkPlayable: invisible MsgID:" + locala.Iz + "uniID:" + locala.IA);
          }
        }
      }
    }
    return 0;
    label374:
    return 2;
    label376:
    return 1;
  }
  
  private void yT(boolean paramBoolean)
  {
    if (this.hE.size() == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.hE.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (wsd.a)localIterator.next();
        if ((localObject != null) && (((wsd.a)localObject).mPos >= this.mStartPos) && (((wsd.a)localObject).mPos <= this.mEndPos))
        {
          localObject = ((wsd.a)localObject).dL;
          if (localObject != null)
          {
            localObject = (DoodleMsgLayout)((WeakReference)localObject).get();
            if (localObject != null) {
              ((DoodleMsgLayout)localObject).pause(paramBoolean);
            }
          }
        }
      }
    }
  }
  
  private void yU(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "strategy2 :" + paramBoolean + " StartPos:" + this.mStartPos + "EndPos:" + this.mEndPos);
    }
    int k;
    int i;
    if (this.bRy == 0)
    {
      j = this.mEndPos;
      while (j >= this.mStartPos)
      {
        k = o(j, paramBoolean);
        if (k > 0)
        {
          i = j;
          if (k != 1)
          {
            if (k != 3) {
              break;
            }
            i = j;
          }
          aB(false, i);
          return;
        }
        j -= 1;
      }
    }
    int j = this.mStartPos;
    for (;;)
    {
      if (j <= this.mEndPos)
      {
        k = o(j, paramBoolean);
        if (k <= 0) {
          break label169;
        }
        i = j;
        if (k == 1) {
          break;
        }
        i = j;
        if (k == 3) {
          break;
        }
      }
      i = -1;
      break;
      label169:
      j += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int k = 0;
    int j = 0;
    if ((paramInt1 == 0) && (paramInt3 > 0)) {
      paramInt2 -= 1;
    }
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 + paramInt2 == paramInt5)
      {
        i = paramInt2;
        if (paramInt4 > 0) {
          i = paramInt2 - 1;
        }
      }
      paramInt1 -= paramInt3;
      if ((this.mViewHeight != paramInt8) || (this.JO != paramInt7))
      {
        this.mViewHeight = paramInt8;
        this.JO = paramInt7;
        this.bRy = 0;
        this.aKI = paramInt6;
        this.bRx = paramInt1;
        if (paramInt1 < 0) {
          paramInt1 = j;
        }
        for (;;)
        {
          this.mStartPos = paramInt1;
          this.mEndPos = (i + this.mStartPos - 1);
          if (this.mEndPos < this.mStartPos) {
            this.mEndPos = this.mStartPos;
          }
          return;
        }
      }
      if (paramInt1 > this.bRx)
      {
        this.bRy = 0;
        label153:
        this.aKI = paramInt6;
        this.bRx = paramInt1;
        if (paramInt1 >= 0) {
          break label259;
        }
        paramInt1 = k;
      }
      label259:
      for (;;)
      {
        this.mStartPos = paramInt1;
        this.mEndPos = (i + this.mStartPos - 1);
        if (this.mEndPos >= this.mStartPos) {
          break;
        }
        this.mEndPos = this.mStartPos;
        return;
        if (paramInt1 < this.bRx)
        {
          this.bRy = 1;
          break label153;
        }
        if (paramInt6 < this.aKI)
        {
          this.bRy = 0;
          break label153;
        }
        if (paramInt6 <= this.aKI) {
          break label153;
        }
        this.bRy = 1;
        break label153;
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, DoodleMsgLayout paramDoodleMsgLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "registLayout:" + paramLong2 + " pos:" + paramInt + " uniid:" + paramLong1);
    }
    this.hE.put(Integer.valueOf(paramInt), new wsd.a(paramLong1, paramLong2, paramInt, paramDoodleMsgLayout));
    boolean bool;
    if (this.mScrollState != 0)
    {
      bool = true;
      paramDoodleMsgLayout.pause(bool);
      if (!t(paramLong1, paramLong2)) {
        break label182;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "registLayout: is new msg, lastID:" + this.Ix + " uniID:" + paramLong1);
      }
      if (this.mScrollState != 0) {
        break label176;
      }
      CL(1000);
    }
    label176:
    label182:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
      this.bfM = true;
      return;
    }
    QLog.d(TAG, 2, "registLayout: is old msg, lastID:" + this.Ix + " uniID:" + paramLong1 + " lastMsgPlayed:" + this.bfM + " playedID:" + this.Iw);
  }
  
  public void a(DoodleMsgLayout paramDoodleMsgLayout, boolean paramBoolean)
  {
    if (paramDoodleMsgLayout == null) {}
    do
    {
      do
      {
        return;
        if (this.dS != null)
        {
          localObject = (DoodleMsgLayout)this.dS.get();
          if ((localObject != null) && (((DoodleMsgLayout)localObject).isPlaying()))
          {
            if ((paramBoolean) && (localObject == paramDoodleMsgLayout))
            {
              ((DoodleMsgLayout)localObject).stop();
              return;
            }
            if ((!paramBoolean) && (localObject == paramDoodleMsgLayout)) {
              break;
            }
            ((DoodleMsgLayout)localObject).stop();
          }
        }
        this.dS = new WeakReference(paramDoodleMsgLayout);
        paramDoodleMsgLayout.play();
        Object localObject = this.hE.values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          wsd.a locala = (wsd.a)((Iterator)localObject).next();
          if ((locala.dL != null) && (locala.dL.get() == paramDoodleMsgLayout))
          {
            this.Iw = locala.IA;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "playLayout: lastPlayedID:" + this.Iw);
            }
          }
        }
      } while (!paramBoolean);
      CL(-1);
      return;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "playLayout: same layout, ans is playing, return:");
  }
  
  public void gi(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    long l1 = a((ChatMessage)paramList.get(paramList.size() - 1));
    long l2 = b((ChatMessage)paramList.get(paramList.size() - 1));
    if ((l1 > this.Ix) && (this.Iy != l2))
    {
      aB(true, -1);
      if (this.Ix >= 0L) {
        break label192;
      }
    }
    label192:
    for (this.bfM = ((ChatMessage)paramList.get(paramList.size() - 1)).isread;; this.bfM = false)
    {
      this.Ix = l1;
      this.Iy = l2;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "setLastMsgID: a new msg");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG, 2, "setLastMsgID:" + this.Ix + " :" + this.Iy);
      return;
    }
  }
  
  public void reset()
  {
    this.Iy = -1L;
    this.Ix = -1L;
    this.Iw = -1L;
    this.hE.clear();
    this.bfM = false;
    this.bRx = 0;
    this.mScrollState = 0;
    if (this.ek != null) {
      new Handler(Looper.getMainLooper()).removeCallbacksAndMessages(null);
    }
    this.ek = null;
    this.mHandler = null;
  }
  
  public void setScrollState(int paramInt)
  {
    this.mScrollState = paramInt;
    if (this.mScrollState == 0)
    {
      CL(1000);
      fy(this.mStartPos, this.mEndPos);
      yT(false);
      yU(false);
      return;
    }
    CL(-1);
    yT(true);
  }
  
  public boolean t(long paramLong1, long paramLong2)
  {
    if ((paramLong2 > this.Ix) && (paramLong1 != this.Iy)) {}
    while ((this.Iy == paramLong1) && (!this.bfM)) {
      return true;
    }
    return false;
  }
  
  class a
  {
    long IA;
    long Iz;
    WeakReference<DoodleMsgLayout> dL;
    int mPos;
    
    public a(long paramLong1, long paramLong2, int paramInt, DoodleMsgLayout paramDoodleMsgLayout)
    {
      this.Iz = paramLong2;
      this.mPos = paramInt;
      this.IA = paramLong1;
      this.dL = new WeakReference(paramDoodleMsgLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsd
 * JD-Core Version:    0.7.0.1
 */