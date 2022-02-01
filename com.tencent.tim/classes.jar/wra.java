import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.1;
import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import com.tencent.qphone.base.util.QLog;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class wra
  implements LoadDataJob.a, ScribbleResMgr.b
{
  private long Ip = -1L;
  private long Iq = -1L;
  private LoadDataJob jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob;
  private wra.b jdField_a_of_type_Wra$b = new wra.b();
  private wro jdField_a_of_type_Wro = new wro();
  private String aTY;
  private int bQY = 0;
  private int bQZ;
  private int bRa;
  private Bitmap jdField_bd_of_type_AndroidGraphicsBitmap;
  private Paint jdField_bd_of_type_AndroidGraphicsPaint;
  private boolean bfF;
  private Map<Integer, Integer> hw = new HashMap();
  private Canvas i;
  private Object mCacheLock = new Object();
  private WeakReference<wra.a> mListenerRef;
  private boolean mLoadFailed;
  boolean mPause = false;
  private int mState = -1;
  private List<wsa> rJ = new ArrayList();
  private View wt;
  
  private void CE(int paramInt)
  {
    synchronized (this.rJ)
    {
      Iterator localIterator = this.rJ.iterator();
      while (localIterator.hasNext())
      {
        wsa localwsa = (wsa)localIterator.next();
        if (localwsa.getTexture() == paramInt) {
          localwsa.setTexture(paramInt);
        }
      }
    }
  }
  
  private void R(String paramString, long paramLong)
  {
    int j = 0;
    if ((this.aTY == null) || (!this.aTY.equalsIgnoreCase(paramString))) {}
    wra.a locala;
    do
    {
      do
      {
        return;
      } while (this.mListenerRef == null);
      locala = (wra.a)this.mListenerRef.get();
    } while (locala == null);
    synchronized (this.mCacheLock)
    {
      locala.a(paramString, paramLong, this.jdField_bd_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private boolean RJ()
  {
    bool = true;
    if ((this.bRa <= 0) || (this.bQZ <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "checkcache error:" + this.bQZ + "-" + this.bRa);
      }
      return false;
    }
    synchronized (this.mCacheLock)
    {
      if ((this.jdField_bd_of_type_AndroidGraphicsBitmap != null) && (this.i != null)) {
        return true;
      }
    }
    try
    {
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
      {
        wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
        this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
      }
      this.jdField_bd_of_type_AndroidGraphicsBitmap = wrq.a().e(this.bQZ, this.bRa);
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
      {
        this.i = new Canvas(this.jdField_bd_of_type_AndroidGraphicsBitmap);
        this.i.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        this.bQZ = this.jdField_bd_of_type_AndroidGraphicsBitmap.getWidth();
        this.bRa = this.jdField_bd_of_type_AndroidGraphicsBitmap.getHeight();
      }
      clearCache();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DoodleDrawer", 2, "create bitmapcache execption!" + localException);
        }
        if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
        {
          wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
          this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
        }
        this.i = null;
        this.Ip = -1L;
        bool = false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DoodleDrawer", 2, "create bitmapcache OOM!");
        }
        if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
        {
          wrq.a().E(this.jdField_bd_of_type_AndroidGraphicsBitmap);
          this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
        }
        this.i = null;
        this.Ip = -1L;
        bool = false;
      }
    }
    return bool;
  }
  
  private boolean a(Canvas paramCanvas, long paramLong1, long paramLong2, long paramLong3, List<wsa> paramList)
  {
    if ((paramLong1 > paramLong2) || (paramCanvas == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "drawSegmentsInner:param error: " + paramLong1 + " " + paramLong2);
      }
      return false;
    }
    if ((this.mState != 3) && (this.mState != 0)) {
      return false;
    }
    paramList = paramList.iterator();
    long l1 = 0L;
    long l2 = 0L;
    wsa localwsa;
    long l3;
    if (paramList.hasNext())
    {
      localwsa = (wsa)paramList.next();
      if (vW() == 1) {}
      for (l3 = localwsa.ep();; l3 = localwsa.getSegmentCount())
      {
        if (l2 + l3 + l1 > paramLong1) {
          break label165;
        }
        l1 = 100L + l1;
        l2 = l3 + l2;
        break;
      }
      label165:
      if (l2 + l3 + l1 <= paramLong2)
      {
        if (this.Ip < paramLong2) {
          localwsa.draw(paramCanvas);
        }
        l2 = l3 + l2;
        label202:
        l1 = 100L + l1;
        if (l2 + l1 <= paramLong2) {
          break label287;
        }
      }
    }
    for (;;)
    {
      if (l1 + l2 - 100L >= paramLong3)
      {
        return false;
        l3 = 0L;
        if (paramLong1 > l2 + l1) {
          l3 = paramLong1 - l2 - l1;
        }
        localwsa.a(paramCanvas, l3, paramLong2 - l2 - l1);
        l2 = paramLong2 - l1;
        break label202;
        label287:
        break;
      }
      return true;
    }
  }
  
  private void c(String paramString, long paramLong, List<wsa> paramList)
  {
    if ((this.mState != 3) && (this.mState != 0)) {
      break label15;
    }
    label15:
    while (paramList == null) {
      return;
    }
    if (!RJ())
    {
      R(paramString, this.Ip);
      return;
    }
    if (paramLong < this.Ip) {
      clearCache();
    }
    if (paramLong < 0L)
    {
      R(paramString, this.Ip);
      return;
    }
    long l1 = c(paramList);
    if (this.Ip >= l1)
    {
      R(paramString, this.Ip);
      return;
    }
    if (paramLong >= l1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "draw last frame try use cache");
      }
      if (k(paramString, l1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleDrawer", 2, "cache ok, drawfilecache finish");
        }
        R(paramString, this.Ip);
        return;
      }
    }
    long l2 = this.Ip;
    if (paramLong > l1) {
      paramLong = l1;
    }
    while (this.Ip < paramLong)
    {
      long l3 = System.currentTimeMillis();
      synchronized (this.mCacheLock)
      {
        if (a(this.i, l2, paramLong, l1, paramList)) {
          if (this.Ip < paramLong) {
            this.Ip = paramLong;
          }
        }
        do
        {
          do
          {
            R(paramString, this.Ip);
            return;
            break;
            this.Ip = l1;
            l2 = System.currentTimeMillis();
          } while ((l2 - l3 <= 1000L) || (paramLong < l1));
          if (QLog.isColorLevel()) {
            QLog.d("DoodleDrawer", 2, "creage file cache:" + (l2 - l3) + "-" + paramString);
          }
          o(paramString, this.jdField_bd_of_type_AndroidGraphicsBitmap);
        } while (!QLog.isColorLevel());
        QLog.d("DoodleDrawer", 2, "creage file cache end");
      }
    }
  }
  
  private void cbg()
  {
    if (this.jdField_a_of_type_Wra$b != null) {
      this.jdField_a_of_type_Wra$b.reset();
    }
    k(-1L, false);
    try
    {
      this.mState = -1;
      this.mLoadFailed = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob != null)
      {
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, 16);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = new LoadDataJob(this.aTY, this.bQZ, this.bRa, this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob, 16, null, true);
      QLog.d("DoodleDrawer", 2, "run task now:" + this.aTY);
      this.mState = 1;
      return;
    }
    finally {}
  }
  
  private void cbh()
  {
    if (this.mState != 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "onTextureReady: state error:" + this.mState);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "onTextureReady: prepare:" + this.bfF);
    }
    if (this.bfF)
    {
      k(2147483647L, false);
      return;
    }
    k(-1L, false);
  }
  
  private void clearCache()
  {
    synchronized (this.mCacheLock)
    {
      if (this.jdField_bd_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_bd_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_bd_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      if ((this.i != null) && (this.jdField_bd_of_type_AndroidGraphicsPaint != null)) {
        this.i.drawPaint(this.jdField_bd_of_type_AndroidGraphicsPaint);
      }
      this.Ip = -1L;
      return;
    }
  }
  
  private void clearData()
  {
    synchronized (this.rJ)
    {
      this.rJ.clear();
      this.Iq = -1L;
      return;
    }
  }
  
  private boolean hH(String paramString)
  {
    try
    {
      if ((this.aTY != null) && (this.aTY.equalsIgnoreCase(paramString))) {
        return true;
      }
      this.aTY = paramString;
      return false;
    }
    finally {}
  }
  
  private String hq(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = paramString.substring(0, paramString.lastIndexOf('_')) + "_cache";
        boolean bool = aqhq.fileExists(paramString);
        if (bool) {
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  private boolean k(String arg1, long paramLong)
  {
    try
    {
      ??? = hq(???);
      if (TextUtils.isEmpty(???)) {
        return false;
      }
      Bitmap localBitmap = BitmapFactory.decodeFile(???);
      if (localBitmap != null)
      {
        Paint localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        localPaint.setAntiAlias(true);
        synchronized (this.mCacheLock)
        {
          if (this.i != null)
          {
            Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
            Rect localRect2 = new Rect(0, 0, this.jdField_bd_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_bd_of_type_AndroidGraphicsBitmap.getHeight());
            this.i.drawBitmap(localBitmap, localRect1, localRect2, localPaint);
          }
          this.Ip = paramLong;
          localBitmap.recycle();
          return true;
        }
      }
      return false;
    }
    catch (Exception ???)
    {
      return false;
    }
    catch (OutOfMemoryError ???) {}
  }
  
  private void o(String paramString, Bitmap paramBitmap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {}
    do
    {
      return;
      paramString = paramString.substring(0, paramString.lastIndexOf('_')) + "_cache";
    } while (aqhq.fileExists(paramString));
    String str = paramString + "tmp";
    if (aqhq.fileExists(str)) {
      aqhq.deleteFile(str);
    }
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(str);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      aqhq.rename(str, paramString);
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "saveFileCache exception:" + paramBitmap);
      }
      aqhq.delete(paramString, true);
    }
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if ((paramResInfo == null) || (paramView == null)) {}
    for (;;)
    {
      return;
      if (this.mListenerRef != null) {}
      for (wra.a locala = (wra.a)this.mListenerRef.get(); (locala != null) && (this.wt == paramView) && (paramInt1 == 1) && (this.mState == 2); locala = null)
      {
        int j = 0;
        paramInt1 = 0;
        if (1 == paramInt2) {}
        for (;;)
        {
          try
          {
            this.hw.remove(Integer.valueOf(paramResInfo.sourceId));
            CE(paramResInfo.sourceId);
            if (paramInt1 == 0) {
              break label215;
            }
            try
            {
              this.mState = 4;
              if (locala != null) {
                locala.cz(this.aTY, 4);
              }
              return;
            }
            finally {}
            if (4 == paramInt2) {
              continue;
            }
          }
          finally {}
          paramInt1 = j;
          try
          {
            if (this.hw.get(Integer.valueOf(paramResInfo.sourceId)) != null)
            {
              this.hw.remove(Integer.valueOf(paramResInfo.sourceId));
              this.hw.put(Integer.valueOf(paramResInfo.sourceId), Integer.valueOf(4));
              paramInt1 = 1;
            }
            continue;
          }
          finally {}
          label215:
          if (this.hw.size() == 0)
          {
            this.mState = 3;
            cbh();
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, wro arg3, List<wsa> paramList, Map<Integer, Integer> paramMap)
  {
    if ((??? == null) || (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoodleDrawer", 2, "onResult param error");
      }
      this.mLoadFailed = true;
      this.mState = 4;
      return;
    }
    try
    {
      if (this.jdField_a_of_type_Wra$b != null) {
        this.jdField_a_of_type_Wra$b.start();
      }
      if ((this.aTY == null) || (!this.aTY.equalsIgnoreCase(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleDrawer", 2, "onResult is not current data");
        }
        return;
      }
    }
    finally {}
    if (paramInt == 4)
    {
      this.mState = 4;
      this.mLoadFailed = true;
      if (this.mListenerRef != null)
      {
        ??? = (wra.a)this.mListenerRef.get();
        if (??? != null) {
          ???.cz(paramString, 4);
        }
      }
      return;
    }
    this.mState = 2;
    clearData();
    clearCache();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob = null;
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "onResult:" + paramString + " result:" + paramInt + " State:" + this.mState);
    }
    this.mLoadFailed = false;
    if (this.mState == 1)
    {
      QLog.d("DoodleDrawer", 2, "onResult: reset data, state is loading now");
      return;
    }
    this.jdField_a_of_type_Wro.a(???);
    synchronized (this.rJ)
    {
      this.rJ.clear();
      this.rJ.addAll(paramList);
      try
      {
        this.hw.clear();
        if ((paramMap != null) && (paramMap.size() > 0))
        {
          ??? = paramMap.entrySet().iterator();
          while (???.hasNext())
          {
            paramList = (Map.Entry)???.next();
            if (((Integer)paramList.getValue()).intValue() == 4)
            {
              this.hw.put(paramList.getKey(), Integer.valueOf(1));
              wrq.a().b(0, ((Integer)paramList.getKey()).intValue(), this.wt, this);
              continue;
              paramString = finally;
            }
          }
        }
      }
      finally {}
    }
    if (this.hw.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "onResult:" + paramString + " waitting res");
      }
      return;
    }
    this.mState = 3;
    cbh();
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "onResult end:" + paramString);
    }
  }
  
  public void a(wra.a parama, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mListenerRef = new WeakReference(parama);
    this.bQY = paramInt1;
    this.bQZ = paramInt2;
    this.bRa = paramInt3;
    RJ();
    this.mState = -1;
    this.mLoadFailed = false;
  }
  
  public boolean a(String paramString, boolean paramBoolean, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleDrawer", 2, "setData ：" + paramString + " state:" + this.mState);
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("DoodleDrawer", 2, "setContent filename is null");
      this.aTY = "";
      this.mState = -1;
      k(-1L, false);
      return false;
    }
    if (hH(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleDrawer", 2, "checkdigest, no change:" + this.mState + " old prepare:" + this.bfF);
      }
      try
      {
        if (this.bfF != paramBoolean) {
          break label186;
        }
        if (this.mState == 0) {
          return false;
        }
      }
      finally {}
      if (this.mState == 4)
      {
        aGs();
        return false;
      }
      return true;
      label186:
      this.bfF = paramBoolean;
      if ((this.mState == -1) || (this.mState == 1) || (this.mState == 2))
      {
        QLog.d("DoodleDrawer", 2, "checkdigest, waitting event");
        return true;
      }
      if ((this.mState == 0) || (this.mState == 3))
      {
        this.mState = 3;
        long l = 9223372036854775807L;
        if (!paramBoolean) {
          l = -1L;
        }
        k(l, false);
        QLog.d("DoodleDrawer", 2, "checkdigest, preapre:" + l);
        return true;
      }
      aGs();
      QLog.d("DoodleDrawer", 2, "checkdigest, state error:" + this.mState);
      return false;
    }
    try
    {
      this.wt = new View(paramContext);
      this.wt.setVisibility(4);
      this.bfF = paramBoolean;
      cbg();
      return true;
    }
    finally {}
  }
  
  public void aGs()
  {
    Object localObject1;
    if (this.mState == 0) {
      if (this.mListenerRef != null)
      {
        localObject1 = (wra.a)this.mListenerRef.get();
        if (localObject1 != null) {
          ((wra.a)localObject1).cz(this.aTY, 0);
        }
      }
    }
    while ((this.mState == 1) || (this.mState == -1)) {
      return;
    }
    if (this.mLoadFailed == true)
    {
      cbg();
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        this.mState = 2;
        if (this.hw.size() <= 0) {
          break;
        }
        localObject1 = this.hw.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        j = ((Integer)localEntry.getKey()).intValue();
        if (wrq.a().ax(0, j))
        {
          ((Iterator)localObject1).remove();
          CE(j);
          continue;
        }
        localEntry.setValue(Integer.valueOf(1));
      }
      finally {}
      wrq.a().b(0, j, this.wt, this);
    }
    if (this.hw.size() > 0) {
      if (this.mListenerRef != null)
      {
        wra.a locala = (wra.a)this.mListenerRef.get();
        if (locala != null) {
          locala.cz(this.aTY, 2);
        }
      }
    }
    for (;;)
    {
      return;
      this.mState = 3;
      cbh();
    }
  }
  
  public long c(List<wsa> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 0L;
    }
    Iterator localIterator = paramList.iterator();
    long l = 0L;
    wsa localwsa;
    if (localIterator.hasNext())
    {
      localwsa = (wsa)localIterator.next();
      if (vW() == 1) {
        l = localwsa.ep() + l;
      }
    }
    for (;;)
    {
      break;
      if (vW() == 0)
      {
        l = localwsa.getSegmentCount() + l;
        continue;
        return (paramList.size() - 1) * 100 + l;
      }
    }
  }
  
  public long eo()
  {
    long l = 0L;
    if (this.Iq > 0L) {}
    for (;;)
    {
      return this.Iq;
      synchronized (this.rJ)
      {
        if (this.rJ.size() == 0) {
          this.Iq = 0L;
        }
      }
    }
    Iterator localIterator = this.rJ.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        wsa localwsa = (wsa)localIterator.next();
        if (vW() == 1) {
          l = localwsa.ep() + l;
        } else if (vW() == 0) {
          l = localwsa.getSegmentCount() + l;
        }
      }
      else
      {
        this.Iq = ((this.rJ.size() - 1) * 100 + l);
        break;
      }
    }
  }
  
  public int getDataState()
  {
    try
    {
      int j = this.mState;
      return j;
    }
    finally {}
  }
  
  public boolean hG(String paramString)
  {
    try
    {
      if (this.aTY == null) {
        return false;
      }
      if (!this.aTY.equalsIgnoreCase(paramString)) {
        return false;
      }
    }
    finally {}
    if (this.mPause)
    {
      this.mState = -1;
      this.aTY = "";
      return false;
    }
    return true;
  }
  
  public boolean k(long paramLong, boolean paramBoolean)
  {
    if ((paramLong > 0L) && (this.mState != 3) && (this.mState != 0)) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      synchronized (this.rJ)
      {
        localArrayList.addAll(this.rJ);
        if (!paramBoolean)
        {
          ??? = this.aTY;
          this.jdField_a_of_type_Wra$b.post(new DoodleDrawer.1(this, (String)???, paramLong, localArrayList));
          if (paramLong >= eo()) {
            break;
          }
          return true;
        }
      }
      c(this.aTY, paramLong, localList);
    }
  }
  
  public void pause(boolean paramBoolean)
  {
    this.mPause = paramBoolean;
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 55	wra:mState	I
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 303	wra:mLoadFailed	Z
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 127	wra:mListenerRef	Ljava/lang/ref/WeakReference;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 455	wra:wt	Landroid/view/View;
    //   24: aload_0
    //   25: ldc_w 550
    //   28: putfield 119	wra:aTY	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 305	wra:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   35: ifnull +18 -> 53
    //   38: aload_0
    //   39: getfield 305	wra:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   42: bipush 16
    //   44: invokestatic 311	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   47: pop
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 305	wra:jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob	Lcom/tencent/mobileqq/activity/aio/doodle/LoadDataJob;
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 80	wra:jdField_a_of_type_Wra$b	Lwra$b;
    //   59: invokevirtual 606	wra$b:stop	()V
    //   62: aload_0
    //   63: getfield 69	wra:mCacheLock	Ljava/lang/Object;
    //   66: astore_2
    //   67: aload_2
    //   68: monitorenter
    //   69: aload_0
    //   70: ldc2_w 70
    //   73: putfield 73	wra:Ip	J
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 181	wra:i	Landroid/graphics/Canvas;
    //   81: aload_0
    //   82: getfield 134	wra:jdField_bd_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   85: ifnull +13 -> 98
    //   88: aload_0
    //   89: getfield 134	wra:jdField_bd_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 134	wra:jdField_bd_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 148	wra:bRa	I
    //   103: aload_0
    //   104: iconst_0
    //   105: putfield 150	wra:bQZ	I
    //   108: aload_2
    //   109: monitorexit
    //   110: aload_1
    //   111: ifnull +10 -> 121
    //   114: invokestatic 186	wrq:a	()Lwrq;
    //   117: aload_1
    //   118: invokevirtual 190	wrq:E	(Landroid/graphics/Bitmap;)V
    //   121: aload_0
    //   122: invokespecial 495	wra:clearData	()V
    //   125: ldc 157
    //   127: iconst_2
    //   128: ldc_w 608
    //   131: invokestatic 270	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: return
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_2
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	wra
    //   1	117	1	localBitmap	Bitmap
    //   135	4	1	localObject1	Object
    //   140	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	53	135	finally
    //   53	55	135	finally
    //   136	138	135	finally
    //   69	81	140	finally
    //   81	98	140	finally
    //   98	110	140	finally
    //   141	143	140	finally
  }
  
  public final int vW()
  {
    return this.bQY;
  }
  
  public int vX()
  {
    synchronized (this.rJ)
    {
      int j = this.rJ.size();
      return j;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, long paramLong, Bitmap paramBitmap);
    
    public abstract void cz(String paramString, int paramInt);
  }
  
  class b
  {
    private Handler mSubHandler;
    
    b() {}
    
    public void post(Runnable paramRunnable)
    {
      if ((paramRunnable == null) || (this.mSubHandler == null)) {
        return;
      }
      this.mSubHandler.post(paramRunnable);
    }
    
    public void reset()
    {
      if (this.mSubHandler != null) {
        this.mSubHandler.removeCallbacksAndMessages(null);
      }
    }
    
    public void start()
    {
      if (this.mSubHandler == null)
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("DoodleDrawerThread", 0);
        localHandlerThread.start();
        this.mSubHandler = new Handler(localHandlerThread.getLooper());
      }
    }
    
    public void stop()
    {
      if (this.mSubHandler != null)
      {
        this.mSubHandler.removeCallbacksAndMessages(null);
        this.mSubHandler.getLooper().quit();
        this.mSubHandler = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wra
 * JD-Core Version:    0.7.0.1
 */