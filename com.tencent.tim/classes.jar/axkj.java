import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Log;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.FaceRects;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SmartFilterReqItem;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.filter.aifilter.AIImageFilterResult;
import com.tencent.ttpic.filter.aifilter.NewEnhanceCategories;
import com.tencent.ttpic.filter.aifilter.PhotoAIFilter;
import com.tencent.ttpic.openapi.PTFaceAttr;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterProxyBase.3;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

public abstract class axkj
{
  private static final String TAG = axkj.class.getSimpleName();
  public List<Bitmap> MN = new ArrayList();
  private WeakReference<axjp.a> bw;
  public int eFO = 1;
  private PhotoAIFilter mPhotoAIFilter = new PhotoAIFilter();
  public List<Bitmap> mPickUpBitmapList = new ArrayList();
  
  private SmartFilterReqItem a(Context paramContext, Bitmap paramBitmap, ArrayList<FaceRects> paramArrayList)
  {
    int i = 0;
    if (paramBitmap == null) {
      paramBitmap = null;
    }
    for (;;)
    {
      return paramBitmap;
      double d = Math.sqrt(25600.0F / this.eFO);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      if (paramBitmap.getWidth() <= d)
      {
        paramContext = paramBitmap;
        if (paramBitmap.getHeight() <= d) {}
      }
      else
      {
        paramContext = new Matrix();
        d = Math.max(d / paramBitmap.getWidth(), d / paramBitmap.getHeight());
        paramContext.postScale((float)d, (float)d);
        paramContext = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramContext, true);
        i = 1;
      }
      paramContext.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
      paramArrayList = new SmartFilterReqItem(localByteArrayOutputStream.toByteArray(), paramArrayList);
      try
      {
        localByteArrayOutputStream.close();
        paramBitmap = paramArrayList;
        if (i == 0) {
          continue;
        }
        paramBitmap = paramArrayList;
        if (paramContext == null) {
          continue;
        }
        BitmapUtils.recycle(paramContext);
        return paramArrayList;
      }
      catch (IOException paramBitmap)
      {
        for (;;)
        {
          paramBitmap.printStackTrace();
        }
      }
    }
  }
  
  private ArrayList<SmartFilterReqItem> a(Context paramContext, List<Bitmap> paramList, List<PTFaceAttr> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      Bitmap localBitmap = (Bitmap)paramList.get(i);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramList1 != null)
      {
        localObject1 = localObject2;
        if (paramList1.size() > i) {
          localObject1 = a((PTFaceAttr)paramList1.get(i));
        }
      }
      localArrayList.add(a(paramContext, localBitmap, (ArrayList)localObject1));
      i += 1;
    }
    return localArrayList;
  }
  
  public static ArrayList<FaceRects> a(PTFaceAttr paramPTFaceAttr)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        float f4 = 0.0F;
        float f1 = 1.4E-45F;
        float f6 = 1.4E-45F;
        float f8 = 3.4028235E+38F;
        float f5 = 0.0F;
        float f3 = 0.0F;
        float f2 = 3.4028235E+38F;
        float f7 = 0.0F;
        while (((Iterator)localObject).hasNext())
        {
          PointF localPointF = (PointF)((Iterator)localObject).next();
          f8 = Math.min(f8, localPointF.x);
          f6 = Math.max(f6, localPointF.x);
          f2 = Math.min(f2, localPointF.y);
          f1 = Math.max(f1, localPointF.y);
          f5 = f8 / paramPTFaceAttr.getFaceDetWidth();
          f3 = f2 / paramPTFaceAttr.getFaceDetHeight();
          f7 = (f6 - f8) / paramPTFaceAttr.getFaceDetWidth();
          f4 = (f1 - f2) / paramPTFaceAttr.getFaceDetHeight();
        }
        localArrayList.add(new FaceRects(f5, f3, f7, f4));
      }
    }
    return localArrayList;
  }
  
  private void b(Context paramContext, List<Bitmap> paramList, axkj.a parama)
  {
    axiy.i(TAG, "doFaceDetect");
    if ((paramList == null) && (parama != null)) {
      parama.aee(-2);
    }
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Bitmap localBitmap = (Bitmap)localIterator.next();
        axiy.d(TAG, "doFaceDetect start");
        int i = Math.max(localBitmap.getHeight(), localBitmap.getWidth());
        float f = 1.0F;
        if (i > 240.0F) {
          f = 240.0F / i;
        }
        localArrayList.add(this.mPhotoAIFilter.doFaceDetect(localBitmap, f));
        axiy.d(TAG, "doFaceDetect end");
      }
      paramContext = a(paramContext, paramList, localArrayList);
      if ((paramContext != null) && (paramContext.size() != 0)) {
        break;
      }
    } while (parama == null);
    parama.aee(-3);
    return;
    parama.fB(paramContext);
  }
  
  public static List<Bitmap> n(List<String> paramList, List<axjm> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int j = 0;
      while ((j < paramList.size()) && (j < paramList1.size()))
      {
        Object localObject = (String)paramList.get(j);
        CropConfig localCropConfig = ((axjm)paramList1.get(j)).cropConfig;
        int m = Math.max(((axjm)paramList1.get(j)).width, ((axjm)paramList1.get(j)).height);
        if (m > 400)
        {
          int i = 1;
          for (;;)
          {
            k = i;
            if (m / i <= 400) {
              break;
            }
            i *= 2;
          }
        }
        int k = 1;
        axiy.d(TAG, "decodeBitmap: start ");
        localObject = BitmapUtil.cropBitmap((String)localObject, localCropConfig, k);
        axiy.d(TAG, "decodeBitmap: end ");
        localArrayList.add(localObject);
        j += 1;
      }
    }
    return localArrayList;
  }
  
  protected static String sG(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString.split("\\.")[0];
    paramString = axmr.a().sJ(str);
    axiy.i(TAG, "parseLutBySceneLabel--select lut=" + str + ", path=" + paramString);
    if ((paramString != null) && (new File(paramString).exists())) {}
    for (;;)
    {
      return paramString;
      axiy.i(TAG, "parseLutBySceneLabel--used lut not exists, id=" + str);
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      boolean[] arrayOfBoolean = new boolean[1];
      axmr.a().a(str, new axkk(arrayOfBoolean, localCountDownLatch));
      try
      {
        localCountDownLatch.await();
        if (arrayOfBoolean[0] != 0) {
          axiy.i(TAG, "parseLutBySceneLabel--download SUCCESS");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        axiy.i(TAG, "parseLutBySceneLabel--download FAIL");
        paramString = null;
      }
    }
  }
  
  protected static String sH(String paramString)
  {
    Object localObject1 = NewEnhanceCategories.COMMON;
    Object localObject3 = NewEnhanceCategories.newEnhanceTypes.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (!((NewEnhanceCategories)localObject2).serverLabel.equals(paramString)) {
        break label220;
      }
      localObject1 = localObject2;
    }
    label220:
    for (;;)
    {
      break;
      localObject2 = localObject1.fileName.split("\\.")[0];
      paramString = axmr.a().sJ((String)localObject2);
      axiy.i(TAG, "parseLutBySceneLabel--select lut=" + (String)localObject2 + ", path=" + paramString);
      if ((paramString != null) && (new File(paramString).exists())) {
        return paramString;
      }
      axiy.i(TAG, "parseLutBySceneLabel--used lut not exists, id=" + (String)localObject2);
      localObject3 = new CountDownLatch(1);
      localObject1 = new boolean[1];
      axmr.a().a((String)localObject2, new axkl((boolean[])localObject1, (CountDownLatch)localObject3));
      try
      {
        ((CountDownLatch)localObject3).await();
        if (localObject1[0] != 0)
        {
          axiy.i(TAG, "parseLutBySceneLabel--download SUCCESS");
          return paramString;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        axiy.i(TAG, "parseLutBySceneLabel--download FAIL");
        return null;
      }
    }
  }
  
  protected static String voteLable(List<axkm> paramList)
  {
    axiy.i(TAG, "voteLable");
    Object localObject1 = new HashMap();
    int i = 0;
    if (i < paramList.size())
    {
      if (((Map)localObject1).containsKey(paramList.get(i))) {
        ((Map)localObject1).put(((axkm)paramList.get(i)).cVl, Integer.valueOf(((Integer)((Map)localObject1).get(paramList.get(i))).intValue() + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((Map)localObject1).put(((axkm)paramList.get(i)).cVl, Integer.valueOf(0));
      }
    }
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    localObject1 = (Map.Entry)localIterator.next();
    paramList = (String)((Map.Entry)localObject1).getKey();
    localObject1 = (Integer)((Map.Entry)localObject1).getValue();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Integer)((Map.Entry)localObject2).getValue();
      if (((Integer)localObject1).intValue() >= ((Integer)localObject2).intValue()) {
        break label234;
      }
      paramList = str;
      localObject1 = localObject2;
    }
    label234:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  public axjp.a a()
  {
    if (this.bw == null) {
      return null;
    }
    return (axjp.a)this.bw.get();
  }
  
  protected axkn a()
  {
    return a(null);
  }
  
  protected abstract axkn a(List<axkm> paramList);
  
  protected axks a(axkm paramaxkm)
  {
    axks localaxks = new axks();
    if (aB(this.mPickUpBitmapList)) {}
    try
    {
      localaxks.a = PhotoAIFilter.preprocessImages(this.mPickUpBitmapList);
      localaxks.dZ = axjp.a(localaxks.a);
      Object localObject = new ArrayList();
      if (paramaxkm == null)
      {
        String str1 = NewEnhanceCategories.COMMON.serverLabel;
        localaxks.bGa = true;
        axiy.i(TAG, "result is exception");
        paramaxkm = (axkm)localObject;
        axiy.i(TAG, "sceneLabel: " + str1);
        localObject = paramaxkm.iterator();
        while (((Iterator)localObject).hasNext())
        {
          YoutuResultItem localYoutuResultItem = (YoutuResultItem)((Iterator)localObject).next();
          axiy.i(TAG, "label: " + localYoutuResultItem.Label + ", confidence: " + localYoutuResultItem.Confidence);
        }
      }
    }
    catch (Exception localException)
    {
      String str2;
      for (;;)
      {
        axiy.e(TAG, Log.getStackTraceString(localException));
        continue;
        str2 = paramaxkm.cVl;
        paramaxkm = paramaxkm.MP;
      }
      localaxks.sceneLabel = str2;
      localaxks.MT = paramaxkm;
      PhotoAIFilter.setAIImageJsonPath(axmr.a().HX());
      PhotoAIFilter.setLutImagePath("");
      paramaxkm = PhotoAIFilter.parseAIImageParamsBySceneLabel(localaxks.sceneLabel);
      localaxks.lutPath = sG(paramaxkm.lutPath);
      localaxks.lutStrengt = paramaxkm.lutStrengt;
      localaxks.adjustParam = paramaxkm.adjustParam;
      localaxks.smoothLevel = paramaxkm.smoothLevel;
      localaxks.glowStrength = paramaxkm.glowStrength;
    }
    return localaxks;
  }
  
  protected abstract void a(Context paramContext, axkj.a parama);
  
  public void a(Context paramContext, List<Bitmap> paramList, axkj.a parama)
  {
    axiy.i(TAG, "faceDetect");
    if ((paramList == null) || (!aB(paramList)))
    {
      if (parama != null) {
        parama.aee(-2);
      }
      return;
    }
    axic.a(new AIFilterProxyBase.3(this, paramContext, paramList, parama), false, "");
  }
  
  public void a(axjp.a parama)
  {
    this.bw = new WeakReference(parama);
  }
  
  protected boolean aB(List<Bitmap> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!BitmapUtils.isLegal((Bitmap)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  public abstract boolean aOO();
  
  public void clear()
  {
    axiy.i(TAG, "clear");
    Iterator localIterator;
    if ((this.mPickUpBitmapList != null) && (this.mPickUpBitmapList.size() > 0))
    {
      localIterator = this.mPickUpBitmapList.iterator();
      while (localIterator.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator.next());
      }
      this.mPickUpBitmapList.clear();
    }
    if ((this.MN != null) && (this.MN.size() > 0))
    {
      localIterator = this.MN.iterator();
      while (localIterator.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator.next());
      }
      this.MN.clear();
    }
  }
  
  public void removeObserver()
  {
    axiy.i(TAG, "removeObserver");
    this.bw = null;
  }
  
  public static abstract interface a
  {
    public abstract void aee(int paramInt);
    
    public abstract void fB(ArrayList<SmartFilterReqItem> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axkj
 * JD-Core Version:    0.7.0.1
 */