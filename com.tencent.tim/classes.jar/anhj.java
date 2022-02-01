import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lanij.b;>;

@TargetApi(21)
public class anhj
{
  public static int a(CameraCharacteristics paramCameraCharacteristics, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 0;
    }
    paramInt = (i + 45) / 90 * 90;
    i = ((Integer)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    paramCameraCharacteristics = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
    if ((paramCameraCharacteristics != null) && (paramCameraCharacteristics.intValue() == 0)) {
      return (i - paramInt + 360) % 360;
    }
    return (i + paramInt) % 360;
  }
  
  @TargetApi(21)
  private static anij.b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Camera2Control.a parama)
  {
    if (parama != null) {}
    Object localObject2;
    for (;;)
    {
      ArrayList localArrayList;
      float f2;
      try
      {
        if (!parama.isValid())
        {
          dH(2, "[Camera2]getPictureSize camera2Info null!");
          return null;
        }
        Object localObject1 = (StreamConfigurationMap)parama.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 == null)
        {
          dH(2, "[Camera2]getPictureSize map null!");
          return null;
        }
        parama = new anij.b();
        localObject2 = ((StreamConfigurationMap)localObject1).getOutputSizes(256);
        if ((localObject2 == null) || (localObject2.length <= 0))
        {
          dH(2, "[Camera2]getPictureSize outPutSizes null!");
          return null;
        }
        localObject1 = new ArrayList();
        int j = localObject2.length;
        int i = 0;
        if (i < j)
        {
          localArrayList = localObject2[i];
          ((List)localObject1).add(new anij.b(localArrayList.getWidth(), localArrayList.getHeight()));
          i += 1;
          continue;
        }
        localObject2 = new anij.b();
        f1 = 10000.0F;
        i = Math.min(paramInt1, paramInt2);
        paramInt1 = Math.max(paramInt1, paramInt2);
        float f3 = paramInt1 / i;
        localArrayList = new ArrayList();
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          anij.b localb = (anij.b)localIterator.next();
          dH(1, "[Camera2] setPictureSize[list]: width=" + localb.width + " height=" + localb.height + " w/h=" + localb.width / localb.height);
          float f4 = localb.width / localb.height;
          if (Math.abs(f4 - f3) <= anij.cW) {
            localArrayList.add(localb);
          }
          f2 = f1;
          if (localb.width < paramInt1) {
            break label685;
          }
          f2 = f1;
          if (f1 <= Math.abs(f4 - f3)) {
            break label685;
          }
          f2 = Math.abs(f4 - f3);
          ((anij.b)localObject2).width = localb.width;
          ((anij.b)localObject2).height = localb.height;
          break label685;
        }
        if ((localArrayList.isEmpty()) && (((anij.b)localObject2).width >= paramInt1))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + ((anij.b)localObject2).width + " height=" + ((anij.b)localObject2).height + " w/h=" + ((anij.b)localObject2).width / ((anij.b)localObject2).height);
          break;
        }
        if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
        {
          parama.width = ((anij.b)((List)localObject1).get(0)).width;
          parama.height = ((anij.b)((List)localObject1).get(0)).height;
          return parama;
        }
        if (localArrayList.isEmpty()) {
          return null;
        }
        if (paramInt5 == -1)
        {
          localObject1 = localArrayList.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (anij.b)((Iterator)localObject1).next();
            if (parama.width >= ((anij.b)localObject2).width) {
              continue;
            }
            parama.width = ((anij.b)localObject2).width;
            parama.height = ((anij.b)localObject2).height;
            continue;
          }
          if (parama.width != 0) {
            break label682;
          }
        }
      }
      catch (Exception parama)
      {
        dH(2, "[Camera2]getPictureSize" + parama);
        return null;
      }
      for (;;)
      {
        return null;
        parama = a(paramInt3, paramInt4, paramInt5, localArrayList);
      }
      label682:
      return parama;
      label685:
      float f1 = f2;
    }
    return localObject2;
  }
  
  public static anij.b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Camera2Control.a parama)
  {
    int j = 0;
    if (parama != null) {}
    try
    {
      if (!parama.isValid())
      {
        dH(2, "[Camera2]getPreviewSizeV2 camera2Info: " + parama);
        return null;
      }
      localObject1 = (StreamConfigurationMap)parama.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parama = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        parama.add(new anij.b(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (parama.size() > 0)
      {
        i = 0;
        while (i < parama.size())
        {
          dH(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((anij.b)parama.get(i)).width + " height=" + ((anij.b)parama.get(i)).height + " w/h=" + ((anij.b)parama.get(i)).width / ((anij.b)parama.get(i)).height);
          i += 1;
        }
      }
      localObject1 = a(parama, paramInt1, paramInt2);
      if (localObject1 != null)
      {
        parama = (Camera2Control.a)localObject1;
        if (!QLog.isColorLevel()) {
          break label417;
        }
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + ((anij.b)localObject1).toString());
        return localObject1;
      }
    }
    catch (Exception parama)
    {
      dH(2, "[Camera2] getPreviewSizeV2 exception!");
      return null;
    }
    Object localObject1 = a(parama, 960, 720);
    if (localObject1 != null)
    {
      parama = (Camera2Control.a)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
        return localObject1;
      }
    }
    else
    {
      localObject1 = a(parama, paramInt1, paramInt2, paramInt3, paramInt4);
      parama = (Camera2Control.a)localObject1;
      if (paramBoolean) {
        if (localObject1 == null)
        {
          paramInt3 = 0;
          break label420;
        }
      }
    }
    for (;;)
    {
      aarz.d(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject1;
      paramInt3 = ((anij.b)localObject1).width;
      label417:
      label420:
      while (localObject1 != null)
      {
        paramInt4 = ((anij.b)localObject1).height;
        break;
        return parama;
      }
      paramInt4 = j;
    }
  }
  
  private static anij.b a(int paramInt1, int paramInt2, int paramInt3, List<anij.b> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    anij.b localb1 = new anij.b(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      anij.b localb2 = (anij.b)paramList.next();
      paramInt2 = Math.abs(localb2.width - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label126;
      }
      localb1.width = localb2.width;
      localb1.height = localb2.height;
      paramInt1 = paramInt2;
    }
    label126:
    for (;;)
    {
      break;
      return localb1;
    }
  }
  
  private static anij.b a(List<anij.b> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    anij.b localb1 = new anij.b();
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (!paramList.isEmpty())
      {
        paramList = paramList.iterator();
        i = -1;
        if (paramList.hasNext())
        {
          anij.b localb2 = (anij.b)paramList.next();
          if ((localb2 == null) || (localb2.height != paramInt2) || (localb2.width < paramInt1) || ((i >= 0) && (localb2.width > i))) {
            break label235;
          }
          i = localb2.width;
        }
      }
    }
    label235:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localb1.height = paramInt2;
        localb1.width = i;
        if (localb1.width / 4 == localb1.height / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
          }
          return localb1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + localb1.toString());
        }
        return localb1;
      }
      return null;
    }
  }
  
  private static anij.b a(List<anij.b> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d);
    }
    anij.b localb1 = new anij.b();
    Iterator localIterator;
    long l1;
    anij.b localb2;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localb2 = (anij.b)localIterator.next();
        if ((localb2 != null) && (localb2.width >= paramInt1) && (localb2.height >= paramInt2) && (localb2.width / localb2.height >= d))
        {
          l2 = localb2.width * localb2.height;
          if (l2 < l1)
          {
            localb1.width = localb2.width;
            localb1.height = localb2.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localb2.width < localb1.width))
          {
            localb1.width = localb2.width;
            localb1.height = localb2.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localb1.width <= 0) || (localb1.height <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localb2 = (anij.b)localIterator.next();
        if ((localb2 != null) && (localb2.width / localb2.height >= d))
        {
          l2 = localb2.width * localb2.height;
          if (l2 > l1)
          {
            localb1.width = localb2.width;
            localb1.height = localb2.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localb2.width < localb1.width))
          {
            localb1.width = localb2.width;
            localb1.height = localb2.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + localb1.width + "  cSize.height=" + localb1.height);
    }
    if ((localb1.width > 0) && (localb1.height > 0)) {
      return localb1;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localb1.width = ((anij.b)paramList.get(0)).width;
      localb1.height = ((anij.b)paramList.get(0)).height;
      return localb1;
    }
    return null;
  }
  
  private static anij.b a(List<anij.b> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    label234:
    label874:
    label877:
    label880:
    label881:
    for (;;)
    {
      anij.b localb;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localb = (anij.b)paramList.next();
        if (localb == null) {
          continue;
        }
        i = Math.max(localb.width, localb.height);
        j = Math.min(localb.width, localb.height);
        if ((localb.height != paramInt2) || (i != paramInt1)) {
          break label347;
        }
        ((List)localObject1).add(new anij.b(paramInt1, paramInt2));
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 first: width=" + paramInt1 + "  height=" + paramInt2);
        }
      }
      float f1;
      float f2;
      if (((List)localObject1).size() == 0)
      {
        paramList = ((List)localObject2).iterator();
        f1 = 10000.0F;
        if (paramList.hasNext())
        {
          localb = (anij.b)paramList.next();
          if (localb == null) {
            break label880;
          }
          paramInt1 = Math.max(localb.width, localb.height);
          paramInt2 = Math.min(localb.width, localb.height);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < anij.cW) {
            ((List)localObject1).add(localb);
          }
          if (Math.abs(f3 - f2) >= f1) {
            break label880;
          }
          f1 = Math.abs(f3 - f2);
        }
      }
      for (;;)
      {
        break label234;
        if ((i <= paramInt5) || (i >= paramInt3) || (j <= paramInt6) || (j >= paramInt4)) {
          break label881;
        }
        ((List)localObject2).add(new anij.b(i, j));
        break;
        f2 = f1;
        if (QLog.isColorLevel())
        {
          f2 = f1;
          if (localObject1 != null)
          {
            paramInt1 = 0;
            for (;;)
            {
              f2 = f1;
              if (paramInt1 >= ((List)localObject1).size()) {
                break;
              }
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((anij.b)((List)localObject1).get(paramInt1)).width + " height=" + ((anij.b)((List)localObject1).get(paramInt1)).height + " w/h=" + ((anij.b)((List)localObject1).get(paramInt1)).width / ((anij.b)((List)localObject1).get(paramInt1)).height);
              paramInt1 += 1;
            }
            f2 = 10000.0F;
          }
        }
        if (((List)localObject1).size() == 0)
        {
          paramList = ((List)localObject2).iterator();
          while (paramList.hasNext())
          {
            localObject2 = (anij.b)paramList.next();
            if (localObject2 != null)
            {
              paramInt1 = Math.max(((anij.b)localObject2).width, ((anij.b)localObject2).height);
              paramInt2 = Math.min(((anij.b)localObject2).width, ((anij.b)localObject2).height);
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < anij.cW) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((anij.b)((List)localObject1).get(paramInt1)).width + " height=" + ((anij.b)((List)localObject1).get(paramInt1)).height + " w/h=" + ((anij.b)((List)localObject1).get(paramInt1)).width / ((anij.b)((List)localObject1).get(paramInt1)).height);
              paramInt1 += 1;
            }
          }
        }
        if (((List)localObject1).size() > 0)
        {
          paramList = (anij.b)((List)localObject1).get(0);
          localObject2 = ((List)localObject1).iterator();
          localObject1 = paramList;
          if (!((Iterator)localObject2).hasNext()) {
            break label874;
          }
          localObject1 = (anij.b)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((anij.b)localObject1).width * ((anij.b)localObject1).height <= paramList.width * paramList.height)) {
            break label877;
          }
          paramList = (List<anij.b>)localObject1;
        }
        for (;;)
        {
          break;
          localObject1 = null;
          return localObject1;
        }
      }
    }
  }
  
  public static anij.b[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Camera2Control.a parama)
  {
    dH(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    anij.b[] arrayOfb = new anij.b[2];
    anij.b localb = a(paramInt1, paramInt2, paramInt3, paramInt4, true, parama);
    if (localb != null)
    {
      arrayOfb[0] = localb;
      dH(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + localb.width + " " + localb.height);
      parama = a(localb.width, localb.height, paramInt3, paramInt4, 1, parama);
      arrayOfb[1] = parama;
      if (parama != null) {
        dH(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + parama.width + " " + parama.height);
      }
    }
    return arrayOfb;
  }
  
  @TargetApi(21)
  private static anij.b b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Camera2Control.a parama)
  {
    if (parama != null) {}
    try
    {
      if (!parama.isValid())
      {
        dH(2, "[Camera2]getPreviewSizeV3 camera2Info: " + parama);
        return null;
      }
      Object localObject1 = (StreamConfigurationMap)parama.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      parama = new ArrayList();
      localObject1 = ((StreamConfigurationMap)localObject1).getOutputSizes(SurfaceTexture.class);
      if (localObject1 == null) {
        return null;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        parama.add(new anij.b(localObject2.getWidth(), localObject2.getHeight()));
        i += 1;
      }
      if (parama.size() > 0)
      {
        i = 0;
        while (i < parama.size())
        {
          dH(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((anij.b)parama.get(i)).width + " height=" + ((anij.b)parama.get(i)).height + " w/h=" + ((anij.b)parama.get(i)).width / ((anij.b)parama.get(i)).height);
          i += 1;
        }
      }
      localObject1 = a(parama, paramInt1, paramInt2, 2600, 1500, 1700, 1000);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + localObject1);
        }
        if (paramBoolean) {
          aarz.d(2, paramInt1, paramInt2, ((anij.b)localObject1).width, ((anij.b)localObject1).height);
        }
      }
      else
      {
        localObject1 = a(parama, paramInt1, paramInt2, 2600, 1500, 1000, 700);
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + localObject1);
          }
          if (!paramBoolean) {
            break label519;
          }
          aarz.d(3, paramInt1, paramInt2, ((anij.b)localObject1).width, ((anij.b)localObject1).height);
          break label519;
        }
        parama = a(parama, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean)
        {
          if (parama != null) {
            break label495;
          }
          paramInt3 = 0;
          break label522;
        }
      }
      for (;;)
      {
        aarz.d(4, paramInt1, paramInt2, paramInt3, paramInt4);
        if (QLog.isColorLevel())
        {
          QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + parama);
          return parama;
          label495:
          paramInt3 = parama.width;
        }
        label519:
        label522:
        while (parama != null)
        {
          paramInt4 = parama.height;
          break;
          return parama;
          return localObject1;
          return localObject1;
        }
        paramInt4 = 0;
      }
      return null;
    }
    catch (Exception parama) {}
  }
  
  public static anij.b[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Camera2Control.a parama)
  {
    dH(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    if (parama == null)
    {
      dH(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + parama);
      return null;
    }
    anij.b[] arrayOfb = new anij.b[2];
    anij.b localb = b(paramInt1, paramInt2, paramInt3, paramInt4, true, parama);
    if (localb != null)
    {
      arrayOfb[0] = localb;
      dH(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + localb.width + " " + localb.height);
      parama = a(localb.width, localb.height, paramInt3, paramInt4, 1, parama);
      arrayOfb[1] = parama;
      if (parama != null) {
        dH(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + parama.width + " " + parama.height);
      }
    }
    return arrayOfb;
  }
  
  public static void dH(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      QLog.w("Camera2Control", 1, paramString);
    }
    while (paramInt != 2) {
      return;
    }
    QLog.e("Camera2Control", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhj
 * JD-Core Version:    0.7.0.1
 */