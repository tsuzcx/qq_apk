package com.tencent.mobileqq.activity.aio.doodle;

import acbn;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import aqhq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import wqz;
import wro;
import wrt;
import wrx;
import wrz;
import wsh;

public class LineLayer
  extends wqz
  implements wrt, wsh
{
  public static final int brD = Color.parseColor("#ff000000");
  private LoadTempFileJob jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a;
  private wro jdField_a_of_type_Wro = new wro();
  private wrz jdField_a_of_type_Wrz;
  private int bRk;
  private int bRl;
  private int bRm;
  private int bRn;
  private Bitmap jdField_bd_of_type_AndroidGraphicsBitmap;
  private Paint jdField_bd_of_type_AndroidGraphicsPaint;
  private Map<Integer, Integer> hA = new ConcurrentHashMap();
  private Map<Integer, Integer> hB = new ConcurrentHashMap();
  private Map<Integer, String> hz = new ConcurrentHashMap();
  private Canvas i;
  private int mCurrentColor = brD;
  private int mSeq;
  private long mStartTime;
  private int mTextureID = -1;
  private int mTotalCount;
  private List<wrz> rN = new ArrayList();
  
  public LineLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  private int[] A()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    if (this.rN == null) {
      return arrayOfInt;
    }
    Iterator localIterator = this.rN.iterator();
    while (localIterator.hasNext())
    {
      wrz localwrz = (wrz)localIterator.next();
      arrayOfInt[0] += 1;
    }
    return arrayOfInt;
  }
  
  private void a(Canvas paramCanvas, wrz paramwrz, boolean paramBoolean)
  {
    paramwrz.a(paramCanvas, paramBoolean);
  }
  
  private void cbp()
  {
    this.mSeq += 1;
    this.hB.put(Integer.valueOf(this.rN.size()), Integer.valueOf(this.mSeq));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob != null)
    {
      ThreadManager.remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob = new LoadTempFileJob(this.rN.size(), this.hz, this.mSeq, this);
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob, 5, null, false);
  }
  
  private void cbq()
  {
    if ((this.rN == null) || (this.rN.size() == 0))
    {
      clearCache();
      return;
    }
    if (!RM()) {
      RJ();
    }
    int j;
    if (this.rN.size() - 1 > this.bRm)
    {
      j = this.bRm;
      while (j < this.rN.size() - 1)
      {
        a(this.i, (wrz)this.rN.get(j), false);
        j += 1;
      }
      this.bRn = 0;
      this.bRm = (this.rN.size() - 1);
    }
    for (;;)
    {
      wrz localwrz = (wrz)this.rN.get(this.bRm);
      j = localwrz.getSegmentCount();
      if (j <= this.bRn) {
        break;
      }
      localwrz.a(this.i, this.bRn, j);
      this.bRn = j;
      if (this.bRn != 1) {
        break;
      }
      this.bRn = 0;
      return;
      if (this.bRm > this.rN.size() - 1) {
        this.bRm = (this.rN.size() - 1);
      }
    }
  }
  
  private void clearCache()
  {
    if ((this.i != null) && (this.jdField_bd_of_type_AndroidGraphicsPaint != null)) {
      this.i.drawPaint(this.jdField_bd_of_type_AndroidGraphicsPaint);
    }
    this.bRm = 0;
    this.bRn = 0;
  }
  
  public boolean H(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.mTotalCount > 10000)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a.fw(2, 10000);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a.cbi();
      }
      this.jdField_a_of_type_Wrz = null;
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Wrz = new wrz(this.jdField_a_of_type_Wro, vZ(), null, this.mTextureID);
        this.jdField_a_of_type_Wrz.init();
        this.mStartTime = System.currentTimeMillis();
        this.jdField_a_of_type_Wrz.H(f1, f2);
        this.rN.add(this.jdField_a_of_type_Wrz);
        this.mTotalCount = wa();
        continue;
        long l1 = System.currentTimeMillis();
        long l2 = this.mStartTime;
        if (this.jdField_a_of_type_Wrz != null)
        {
          this.jdField_a_of_type_Wrz.b(f1, f2, l1 - l2);
          this.mTotalCount += 1;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a.cbi();
    }
    if (this.jdField_a_of_type_Wrz != null)
    {
      this.jdField_a_of_type_Wrz.aD(false);
      cbq();
      this.jdField_a_of_type_Wrz.aD(true);
      this.bRn = this.jdField_a_of_type_Wrz.getSegmentCount();
      if (this.bRn == 1) {
        this.bRn = 0;
      }
    }
    this.jdField_a_of_type_Wrz = null;
    this.mTotalCount = wa();
    paramMotionEvent = this.hz.keySet().iterator();
    int j = 0;
    label306:
    int k;
    if (paramMotionEvent.hasNext())
    {
      k = ((Integer)paramMotionEvent.next()).intValue();
      if (j >= k) {
        break label530;
      }
      j = k;
    }
    label530:
    for (;;)
    {
      break label306;
      paramMotionEvent = this.hA.keySet().iterator();
      while (paramMotionEvent.hasNext())
      {
        k = ((Integer)paramMotionEvent.next()).intValue();
        if (j < k) {
          j = k;
        }
      }
      int n;
      for (k = 0; m < j; k = n + k)
      {
        n = ((wrz)this.rN.get(m)).wc();
        m += 1;
      }
      if (k + 100 >= this.mTotalCount) {
        break;
      }
      cbq();
      this.mSeq += 1;
      this.hA.put(Integer.valueOf(this.rN.size()), Integer.valueOf(this.mSeq));
      ThreadManager.post(new SaveTempFileJob(this.rN.size(), this.mSeq, this.jdField_bd_of_type_AndroidGraphicsBitmap, this), 5, null, true);
      break;
    }
  }
  
  public boolean RI()
  {
    this.jdField_bd_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_bd_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    return true;
  }
  
  public boolean RJ()
  {
    boolean bool = false;
    int j = this.bg.width();
    int k = this.bg.height();
    if ((j <= 0) || (k <= 0)) {
      return false;
    }
    try
    {
      if ((this.bRk != j) || (this.bRl != k) || (this.jdField_bd_of_type_AndroidGraphicsBitmap == null) || (this.i == null))
      {
        if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
        {
          this.i = null;
          this.jdField_bd_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
        }
        this.jdField_bd_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
        if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
        {
          this.i = new Canvas(this.jdField_bd_of_type_AndroidGraphicsBitmap);
          this.bRk = j;
          this.bRl = k;
        }
        this.bRm = 0;
        this.bRn = 0;
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_bd_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
      }
      this.bRk = 0;
      this.bRl = 0;
      this.i = null;
      this.bRm = 0;
      this.bRn = 0;
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LineLayer", 2, "checkcache oom:" + localOutOfMemoryError.toString());
      }
      this.bRk = 0;
      this.bRl = 0;
      this.i = null;
      this.bRm = 0;
      this.bRn = 0;
      this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
    }
    return true;
  }
  
  public boolean RM()
  {
    return (this.jdField_bd_of_type_AndroidGraphicsBitmap != null) && (this.i != null);
  }
  
  public final wro a()
  {
    return this.jdField_a_of_type_Wro;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob = null;
    Object localObject = (Integer)this.hB.remove(Integer.valueOf(paramInt1));
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo result, seq not exist:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt3 == ((Integer)localObject).intValue()) {
            break;
          }
          this.hB.put(Integer.valueOf(paramInt1), localObject);
        } while (!QLog.isColorLevel());
        QLog.d("LineLayer", 2, "undo result, seq not match:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3 + "-" + ((Integer)localObject).intValue());
        return;
        if (paramInt1 == this.rN.size()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LineLayer", 2, "undo result, pathsize not match:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3 + "-" + this.rN.size());
      return;
      if ((paramInt2 != 0) && (paramBitmap != null)) {
        break;
      }
      clearCache();
      super.notifyChange();
    } while (!QLog.isColorLevel());
    QLog.d("LineLayer", 2, "undo result, no cache:" + paramInt1 + "-" + paramInt2 + "-" + paramInt3);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo result, use cache:" + paramInt1 + "-" + paramInt2);
    }
    localObject = new Paint();
    ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    this.i.drawBitmap(paramBitmap, 0.0F, 0.0F, (Paint)localObject);
    this.bRm = (paramInt2 - 1);
    paramBitmap = (wrz)this.rN.get(this.bRm);
    if (paramBitmap != null)
    {
      this.bRn = paramBitmap.getSegmentCount();
      if (this.bRn == 1) {
        this.bRn = 0;
      }
    }
    if (paramInt2 < this.rN.size()) {
      cbq();
    }
    super.notifyChange();
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a = parama;
  }
  
  public void an(Canvas paramCanvas)
  {
    cbq();
    ay(paramCanvas);
  }
  
  public void ay(Canvas paramCanvas)
  {
    if ((this.jdField_bd_of_type_AndroidGraphicsBitmap != null) && (paramCanvas != null)) {
      paramCanvas.drawBitmap(this.jdField_bd_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    Integer localInteger = (Integer)this.hA.remove(Integer.valueOf(paramInt1));
    if (localInteger == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "save result, seq not exist:" + paramInt1 + "-" + paramInt2);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == localInteger.intValue()) {
          break;
        }
        this.hA.put(Integer.valueOf(paramInt1), localInteger);
      } while (!QLog.isColorLevel());
      QLog.d("LineLayer", 2, "save result, seq not match:" + paramInt1 + "-" + paramInt2 + "-" + localInteger.intValue());
      return;
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
        this.hz.put(Integer.valueOf(paramInt1), paramString);
      }
    } while (!QLog.isColorLevel());
    QLog.d("LineLayer", 2, "save result, add cache:" + paramInt1 + "-" + paramString + " : " + this.hz.size());
  }
  
  public boolean c(Canvas paramCanvas)
  {
    boolean bool = false;
    Iterator localIterator = this.rN.iterator();
    while (localIterator.hasNext())
    {
      a(paramCanvas, new wrz((wrz)localIterator.next()), true);
      bool = true;
    }
    return bool;
  }
  
  public void cbf()
  {
    super.cbf();
    if ((this.rN != null) && (this.rN.size() > 0))
    {
      Iterator localIterator = this.rN.iterator();
      while (localIterator.hasNext()) {
        ((wrz)localIterator.next()).unInit();
      }
      this.rN.clear();
    }
    this.hz.clear();
    this.hA.clear();
    this.hB.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$LoadTempFileJob = null;
    this.jdField_a_of_type_Wrz = null;
    this.i = null;
    if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_bd_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
    }
    this.bRl = 0;
    this.bRk = 0;
    this.mTextureID = -1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer$a = null;
    ThreadManager.post(new ClearTempFileJob(), 5, null, true);
  }
  
  public void clear(boolean paramBoolean)
  {
    this.rN.clear();
    this.hA.clear();
    this.hz.clear();
    this.jdField_a_of_type_Wrz = null;
    this.mTotalCount = 0;
    ThreadManager.post(new ClearTempFileJob(), 5, null, true);
    if (paramBoolean)
    {
      this.i = null;
      if (this.jdField_bd_of_type_AndroidGraphicsBitmap != null)
      {
        this.jdField_bd_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_bd_of_type_AndroidGraphicsBitmap = null;
      }
    }
  }
  
  public List<wrx> getPathList()
  {
    if (this.rN.size() == 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rN.iterator();
    while (localIterator.hasNext())
    {
      wrz localwrz = (wrz)localIterator.next();
      wrx localwrx = new wrx();
      localwrx.b(localwrz.a());
      localArrayList.add(localwrx);
    }
    return localArrayList;
  }
  
  public void setLineColor(int paramInt)
  {
    this.mCurrentColor = paramInt;
    this.mTextureID = -1;
  }
  
  public void setLineTexture(int paramInt)
  {
    if (this.mTextureID == paramInt) {
      return;
    }
    this.mCurrentColor = -1;
    this.mTextureID = paramInt;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    super.setSize(paramInt1, paramInt2);
    this.jdField_a_of_type_Wro.fv(paramInt1, paramInt2);
    RJ();
  }
  
  public int tp()
  {
    int[] arrayOfInt = A();
    int j = arrayOfInt[0];
    return arrayOfInt[1] + j;
  }
  
  public void undo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LineLayer", 2, "undo begin");
    }
    if ((this.rN != null) && (!this.rN.isEmpty()))
    {
      this.hA.remove(Integer.valueOf(this.rN.size()));
      this.hB.remove(Integer.valueOf(this.rN.size()));
      this.hz.remove(Integer.valueOf(this.rN.size()));
      this.rN.remove(this.rN.size() - 1);
      if (this.rN.size() == 0)
      {
        this.mTotalCount = 0;
        ThreadManager.post(new ClearTempFileJob(), 5, null, true);
        this.hA.clear();
        this.hB.clear();
        this.hz.clear();
        clearCache();
      }
    }
    else
    {
      if (this.mTotalCount >= 100) {
        break label245;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo draw directly");
      }
      clearCache();
      super.notifyChange();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo end");
      }
      return;
      this.mTotalCount = wa();
      break;
      label245:
      cbp();
      if (QLog.isColorLevel()) {
        QLog.d("LineLayer", 2, "undo try use cache");
      }
    }
  }
  
  public int vZ()
  {
    return this.mCurrentColor;
  }
  
  public int wa()
  {
    if (this.rN == null) {
      return 0;
    }
    Iterator localIterator = this.rN.iterator();
    for (int j = 0; localIterator.hasNext(); j = ((wrz)localIterator.next()).wc() + j) {}
    return j;
  }
  
  class ClearTempFileJob
    implements Runnable
  {
    public final String aTZ = acbn.bng + "temp" + File.separator;
    
    public ClearTempFileJob() {}
    
    public void run()
    {
      try
      {
        aqhq.delete(this.aTZ, true);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("ClearTempFileJobdownloading", 2, "makedir execption: " + localException);
      }
    }
  }
  
  class LoadTempFileJob
    implements Runnable
  {
    private int bRo;
    private int bRp = -1;
    private Map<Integer, String> hC = new HashMap();
    private WeakReference<wrt> mListenerRef;
    
    public LoadTempFileJob(Map<Integer, String> paramMap, int paramInt, wrt paramwrt)
    {
      Object localObject;
      this.mListenerRef = new WeakReference(localObject);
      this.bRo = paramMap;
      this.hC.putAll(paramInt);
      this.bRp = paramwrt;
    }
    
    public void run()
    {
      localObject3 = null;
      j = 0;
      try
      {
        localObject1 = (String)this.hC.get(Integer.valueOf(this.bRo));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label157;
        }
        localObject1 = this.hC.keySet().iterator();
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int k;
          Object localObject1 = localObject3;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("UndoJob", 2, "exception :" + localException);
            localObject1 = localObject3;
            i = j;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          label157:
          Object localObject2 = localObject3;
          int i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("UndoJob", 2, "OOM!!");
            localObject2 = localObject3;
            i = j;
          }
        }
      }
      if (((Iterator)localObject1).hasNext())
      {
        k = ((Integer)((Iterator)localObject1).next()).intValue();
        if ((k > i) && (k <= this.bRo)) {
          i = k;
        }
      }
      else
      {
        localObject1 = (String)this.hC.get(Integer.valueOf(i));
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i != 0)) {
          localObject1 = BitmapFactory.decodeFile((String)localObject1);
        }
        for (;;)
        {
          new Handler(Looper.getMainLooper()).post(new LineLayer.LoadTempFileJob.1(this, i, (Bitmap)localObject1));
          return;
          i = this.bRo;
          break;
          localObject1 = null;
          i = 0;
        }
      }
    }
  }
  
  class SaveTempFileJob
    implements Runnable
  {
    public final String aTZ = acbn.bng + "temp" + File.separator;
    private int bRp = -1;
    private int bRr = -1;
    private Bitmap mBitmap;
    private WeakReference<wsh> mListenerRef;
    
    public SaveTempFileJob(int paramInt1, int paramInt2, Bitmap paramBitmap, wsh paramwsh)
    {
      QLog.d("SaveTempFileJob", 2, "SaveTempFileJob begin:");
      this.mListenerRef = new WeakReference(paramwsh);
      if (paramBitmap == null) {
        return;
      }
      this.bRr = paramInt1;
      this.bRp = paramInt2;
      for (;;)
      {
        try
        {
          if (this.mBitmap != null) {
            continue;
          }
          this.mBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
          this$1 = new Paint();
          LineLayer.this.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
          new Canvas(this.mBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, LineLayer.this);
        }
        catch (Exception this$1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SaveTempFileJob", 2, "SaveTempFileJob exception:" + LineLayer.this);
          continue;
        }
        catch (OutOfMemoryError this$1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SaveTempFileJob", 2, "SaveTempFileJob OOM:" + LineLayer.this.toString());
          continue;
        }
        QLog.d("SaveTempFileJob", 2, "SaveTempFileJob end:");
        return;
        if ((this.mBitmap.getHeight() != paramBitmap.getHeight()) || (this.mBitmap.getWidth() != paramBitmap.getWidth()))
        {
          this.mBitmap.recycle();
          this.mBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
      }
    }
    
    private String a(int paramInt, Bitmap paramBitmap)
    {
      if (paramBitmap == null) {}
      do
      {
        return null;
        try
        {
          String str = this.aTZ + paramInt + ".tmp";
          if (aqhq.fileExists(str)) {
            aqhq.deleteFile(str);
          }
          FileOutputStream localFileOutputStream = new FileOutputStream(str);
          paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return str;
        }
        catch (Exception paramBitmap)
        {
          paramBitmap.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.e("SaveTempFileJob", 2, "saveFileCache exception:" + paramBitmap);
      return null;
    }
    
    private void cbr()
    {
      try
      {
        File localFile = new File(this.aTZ);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("SaveTempFileJobdownloading", 2, "makedir execption: " + localException);
      }
    }
    
    private void fireEvent(String paramString)
    {
      new Handler(Looper.getMainLooper()).post(new LineLayer.SaveTempFileJob.1(this, paramString));
    }
    
    public void run()
    {
      if (LineLayer.a(LineLayer.this) == null) {}
      do
      {
        return;
        if (this.mBitmap == null)
        {
          fireEvent(null);
          return;
        }
        cbr();
        fireEvent(a(this.bRr, this.mBitmap));
      } while (this.mBitmap == null);
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cbi();
    
    public abstract void fw(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LineLayer
 * JD-Core Version:    0.7.0.1
 */