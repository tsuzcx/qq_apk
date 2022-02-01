import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.hardware.Camera.Size;>;

@TargetApi(11)
public class anij
  extends anhn
{
  private static ArrayList<Float> AF;
  private static ArrayList<Float> AG;
  public static String TAG;
  static anij jdField_a_of_type_Anij;
  private static boolean cGP;
  private static boolean cGQ;
  public static double cW;
  anij.a jdField_a_of_type_Anij$a = new anij.a();
  anij.b jdField_a_of_type_Anij$b;
  boolean aNE;
  boolean aqw;
  aeab b = aeab.a();
  int cFs;
  int cjo;
  anij.b d;
  public int dGP = -1;
  int dGQ;
  private byte[] fy;
  private byte[] fz;
  public Camera mCamera;
  int[] nB;
  
  static
  {
    if (!anij.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = "CameraControl";
      cW = 0.009999999776482582D;
      AF = new ArrayList();
      AG = new ArrayList();
      return;
    }
  }
  
  private int JD()
  {
    int i = ImageFormat.getBitsPerPixel(this.cFs);
    float f = i * 1.0F / 8.0F;
    int j = (int)(this.jdField_a_of_type_Anij$b.height * this.jdField_a_of_type_Anij$b.width * f);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "startPreview getPreviewBufferSize:bitpixel=" + i + " byteNum=" + f + " bufSize=" + j);
    }
    return j;
  }
  
  private anij.b a(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getHighVersionPreviewSize[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    anij.b localb = new anij.b();
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
          Camera.Size localSize = (Camera.Size)paramList.next();
          if ((localSize == null) || (localSize.height != paramInt2) || (localSize.width < paramInt1) || ((i >= 0) && (localSize.width > i))) {
            break label225;
          }
          i = localSize.width;
        }
      }
    }
    label225:
    for (;;)
    {
      break;
      if (i > 0)
      {
        localb.height = paramInt2;
        localb.width = i;
        if (localb.width / 4 == localb.height / 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[@] getHighVersionPreviewSize[4:3]...");
          }
          return localb;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getHighVersionPreviewSize: RATIO_MUST_EQUAL=false");
        }
        return localb;
      }
      return null;
    }
  }
  
  private anij.b a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramInt4 / paramInt3;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewSize[self-adaption] physicRatio=" + d1);
    }
    anij.b localb = new anij.b();
    Iterator localIterator;
    long l1;
    Camera.Size localSize;
    long l2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 9223372036854775807L;
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize != null) && (localSize.width >= paramInt1) && (localSize.height >= paramInt2) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 < l1)
          {
            localb.width = localSize.width;
            localb.height = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localb.width))
          {
            localb.width = localSize.width;
            localb.height = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewSize[self-adaption] have no resolution >= (w*h)");
    }
    if (((localb.width <= 0) || (localb.height <= 0)) && (paramList != null) && (!paramList.isEmpty()))
    {
      localIterator = paramList.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localSize = (Camera.Size)localIterator.next();
        if ((localSize != null) && (localSize.width / localSize.height >= d1))
        {
          l2 = localSize.width * localSize.height;
          if (l2 > l1)
          {
            localb.width = localSize.width;
            localb.height = localSize.height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (localSize.width < localb.width))
          {
            localb.width = localSize.width;
            localb.height = localSize.height;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewSize[self-adaption] cSize.width=" + localb.width + "  cSize.height=" + localb.height);
    }
    if ((localb.width > 0) && (localb.height > 0)) {
      return localb;
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList.get(0) != null))
    {
      localb.width = ((Camera.Size)paramList.get(0)).width;
      localb.height = ((Camera.Size)paramList.get(0)).height;
      return localb;
    }
    return null;
  }
  
  private anij.b a(List<Camera.Size> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + paramInt1 + "  height=" + paramInt2);
    }
    float f3 = paramInt1 / paramInt2;
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      paramList = paramList.iterator();
    }
    label236:
    label879:
    label882:
    label885:
    label886:
    for (;;)
    {
      Object localObject3;
      int i;
      int j;
      if (paramList.hasNext())
      {
        localObject3 = (Camera.Size)paramList.next();
        if (localObject3 == null) {
          continue;
        }
        i = Math.max(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        j = Math.min(((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        if ((((Camera.Size)localObject3).height != paramInt2) || (i != paramInt1)) {
          break label349;
        }
        ((List)localObject1).add(new anij.b(paramInt1, paramInt2));
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getHighVersionPreviewSizeV3 first: width=" + paramInt1 + "  height=" + paramInt2);
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
          localObject3 = (anij.b)paramList.next();
          if (localObject3 == null) {
            break label885;
          }
          paramInt1 = Math.max(((anij.b)localObject3).width, ((anij.b)localObject3).height);
          paramInt2 = Math.min(((anij.b)localObject3).width, ((anij.b)localObject3).height);
          f2 = paramInt1 / paramInt2;
          if (Math.abs(f3 - f2) < cW) {
            ((List)localObject1).add(localObject3);
          }
          if (Math.abs(f3 - f2) >= f1) {
            break label885;
          }
          f1 = Math.abs(f3 - f2);
        }
      }
      for (;;)
      {
        break label236;
        if ((i <= paramInt5) || (i >= paramInt3) || (j <= paramInt6) || (j >= paramInt4)) {
          break label886;
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
              QLog.i(TAG, 2, "[@] getHighVersionPreviewSizeV2 secend: width=" + ((anij.b)((List)localObject1).get(paramInt1)).width + " height=" + ((anij.b)((List)localObject1).get(paramInt1)).height + " w/h=" + ((anij.b)((List)localObject1).get(paramInt1)).width / ((anij.b)((List)localObject1).get(paramInt1)).height);
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
              if (Math.abs(Math.abs(f3 - paramInt1 / paramInt2) - f2) < cW) {
                ((List)localObject1).add(localObject2);
              }
            }
          }
          if ((QLog.isColorLevel()) && (localObject1 != null))
          {
            paramInt1 = 0;
            while (paramInt1 < ((List)localObject1).size())
            {
              QLog.i(TAG, 2, "[@] getHighVersionPreviewSizeV2 third: width=" + ((anij.b)((List)localObject1).get(paramInt1)).width + " height=" + ((anij.b)((List)localObject1).get(paramInt1)).height + " w/h=" + ((anij.b)((List)localObject1).get(paramInt1)).width / ((anij.b)((List)localObject1).get(paramInt1)).height);
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
            break label879;
          }
          localObject1 = (anij.b)((Iterator)localObject2).next();
          if ((localObject1 == null) || (((anij.b)localObject1).width * ((anij.b)localObject1).height <= paramList.width * paramList.height)) {
            break label882;
          }
          paramList = (List<Camera.Size>)localObject1;
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
  
  public static anij a()
  {
    if (jdField_a_of_type_Anij == null) {}
    try
    {
      if (jdField_a_of_type_Anij == null) {
        jdField_a_of_type_Anij = new anij();
      }
      return jdField_a_of_type_Anij;
    }
    finally {}
  }
  
  private boolean a(ArrayList<Camera.Size> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramArrayList.size())
      {
        Camera.Size localSize = (Camera.Size)paramArrayList.get(i);
        if ((localSize.width == paramInt1) && (localSize.height == paramInt2)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private int[] b(List<int[]> paramList)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    int i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject2).next();
      if ((arrayOfInt2 == null) || (arrayOfInt2.length < 2) || (arrayOfInt2[1] < i)) {
        break label314;
      }
      i = arrayOfInt2[1];
    }
    label301:
    label314:
    for (;;)
    {
      break;
      if (i <= 0) {
        return null;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (int[])paramList.next();
        if ((localObject2 != null) && (localObject2.length >= 2) && (localObject2[1] == i)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if (((ArrayList)localObject1).size() <= 0) {
        return null;
      }
      paramList = ((ArrayList)localObject1).iterator();
      int k = 0;
      int j = 2147483647;
      int m;
      if (paramList.hasNext())
      {
        localObject1 = (int[])paramList.next();
        if (localObject1[0] >= 15000)
        {
          m = localObject1[0] - 15000;
          label211:
          if (m >= j) {
            break label301;
          }
          j = localObject1[0];
        }
      }
      for (k = m;; k = m)
      {
        m = k;
        k = j;
        j = m;
        break;
        m = 15000 - localObject1[0];
        break label211;
        if (j != 2147483647)
        {
          arrayOfInt1[0] = k;
          arrayOfInt1[1] = i;
        }
        while ((arrayOfInt1[0] <= 0) || (arrayOfInt1[1] <= 0))
        {
          return null;
          arrayOfInt1[0] = i;
          arrayOfInt1[1] = i;
        }
        return arrayOfInt1;
        m = j;
        j = k;
      }
    }
  }
  
  private int[] b(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt2 = b(paramList);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null) {
      arrayOfInt1 = c(paramList, paramInt);
    }
    return arrayOfInt1;
  }
  
  private boolean c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 / paramInt5 <= 1.0D) {}
    while (paramInt2 * paramInt5 / (paramInt5 * paramInt3 / paramInt4) < paramInt1) {
      return false;
    }
    return true;
  }
  
  private int[] c(List<int[]> paramList, int paramInt)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 2147483647;
    int[] tmp10_5 = tmp5_4;
    tmp10_5[1] = 2147483647;
    tmp10_5;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      int[] arrayOfInt2 = (int[])((Iterator)localObject).next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (arrayOfInt2[0] >= paramInt) && (arrayOfInt2[1] < arrayOfInt1[1]))
      {
        arrayOfInt1[0] = arrayOfInt2[0];
        arrayOfInt1[1] = arrayOfInt2[1];
      }
    }
    if ((arrayOfInt1[0] == 2147483647) || (arrayOfInt1[1] == 2147483647))
    {
      arrayOfInt1[1] = 0;
      arrayOfInt1[0] = 0;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (int[])paramList.next();
        if ((localObject != null) && (localObject.length >= 2) && (localObject[0] <= paramInt) && (localObject[1] > arrayOfInt1[1]))
        {
          arrayOfInt1[0] = localObject[0];
          arrayOfInt1[1] = localObject[1];
        }
      }
    }
    if ((arrayOfInt1[0] != 2147483647) && (arrayOfInt1[1] != 2147483647)) {
      return arrayOfInt1;
    }
    return null;
  }
  
  private boolean canFocus()
  {
    return !anii.isFoundProduct(anii.KEY_NOT_FOCUS_MODEL);
  }
  
  private boolean cm(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      if ((this.fy == null) || (this.fy.length != paramInt)) {
        this.fy = new byte[paramInt];
      }
      if ((this.fz == null) || (this.fz.length != paramInt)) {
        this.fz = new byte[paramInt];
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        URLDrawable.clearMemoryCache();
        try
        {
          if ((this.fy != null) && (this.fy.length == paramInt)) {
            break label81;
          }
          this.fy = new byte[paramInt];
          label81:
          if ((this.fz != null) && (this.fz.length == paramInt)) {
            continue;
          }
          this.fz = new byte[paramInt];
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          QLog.e(TAG, 2, "allocateFrame failed , size:" + paramInt + ", " + localOutOfMemoryError2.getMessage());
        }
      }
    }
    return true;
    return false;
  }
  
  private static void eV(ArrayList<Float> paramArrayList)
  {
    Object localObject = anih.a().gl();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
        float f = localSize.width / localSize.height;
        if (!paramArrayList.contains(Float.valueOf(f))) {
          paramArrayList.add(Float.valueOf(f));
        }
      }
    }
  }
  
  private boolean f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.max(paramInt1, paramInt2);
    paramInt1 = Math.min(paramInt1, paramInt2);
    float f1 = i / paramInt1;
    paramInt1 = Math.max(paramInt3, paramInt4);
    paramInt2 = Math.min(paramInt3, paramInt4);
    float f2 = paramInt1 / paramInt2;
    boolean bool = false;
    if (Math.abs(f2 - f1) > cW) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "needClip " + bool + " screenRatio" + f2 + " previewRatio" + f1);
    }
    return bool;
  }
  
  public static String fj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "RM_CAMERA_OPEN_SUCCESS";
    case 1: 
      return "RM_CAMERA_USED_AV";
    case 2: 
      return "RM_CAMERA_COUNT_ZERO";
    case 3: 
      return "RM_CAMERA_OPEN_FAILED";
    }
    return "RM_CAMERA_GET_PARAM";
  }
  
  private int jq(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = anih.JC();
    }
    do
    {
      do
      {
        return paramInt;
        paramInt = i;
      } while (!anih.agb());
      return anih.JB();
      paramInt = i;
    } while (!anih.axm());
    return anih.JC();
  }
  
  private void mt(List<int[]> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "printFpsRange[listFpsRange=null]");
      }
      return;
    }
    int i = 0;
    label32:
    if (i < paramList.size())
    {
      int[] arrayOfInt = (int[])paramList.get(i);
      if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "printFpsRange[i=" + i + " fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
      }
    }
    for (;;)
    {
      i += 1;
      break label32;
      break;
      label133:
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "printFpsRange[i=" + i + " ele=null]");
      }
    }
  }
  
  public int JE()
  {
    int j = this.cjo;
    if (aaqh.cix == 1) {
      if (this.cjo != 270) {
        break label70;
      }
    }
    label70:
    for (int i = this.cjo - 180;; i = this.cjo + 180)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "getPreviewOrientation:blackPhone= orientation=" + i);
        j = i;
      }
      return j;
    }
  }
  
  public void PP(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mCamera != null) && (cm(JD())))
    {
      this.mCamera.addCallbackBuffer(this.fy);
      this.mCamera.addCallbackBuffer(this.fz);
    }
  }
  
  public int[] Z()
  {
    return this.nB;
  }
  
  public anij.b a(int paramInt)
  {
    Object localObject2 = anih.a().gk();
    int i;
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      i = 0;
      while (i < ((List)localObject2).size())
      {
        QLog.i(TAG, 2, "[@] getStarPhotoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(i)).width + " height=" + ((Camera.Size)((List)localObject2).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(i)).width / ((Camera.Size)((List)localObject2).get(i)).height);
        i += 1;
      }
    }
    Object localObject1 = new ArrayList();
    anij.b localb = new anij.b();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        if ((localSize != null) && (localSize.height >= paramInt)) {
          ((List)localObject1).add(localSize);
        }
      }
    }
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      for (paramInt = 2147483647; ((Iterator)localObject1).hasNext(); paramInt = i)
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        i = paramInt;
        if (((Camera.Size)localObject2).width < paramInt)
        {
          i = ((Camera.Size)localObject2).width;
          localb.height = ((Camera.Size)localObject2).height;
          localb.width = ((Camera.Size)localObject2).width;
        }
      }
    }
    if (localb.width > 0) {
      return localb;
    }
    return null;
  }
  
  public anij.b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject2 = anih.a().gk();
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      paramInt2 = 0;
      while (paramInt2 < ((List)localObject2).size())
      {
        QLog.i(TAG, 2, "[@] getFullVideoPreviewSize[list]: width=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width + " height=" + ((Camera.Size)((List)localObject2).get(paramInt2)).height + " w/h=" + ((Camera.Size)((List)localObject2).get(paramInt2)).width / ((Camera.Size)((List)localObject2).get(paramInt2)).height);
        paramInt2 += 1;
      }
    }
    double d1;
    Object localObject4;
    Object localObject3;
    anij.b localb;
    Object localObject5;
    label259:
    if (aaqh.cix == 1)
    {
      if (!cGQ)
      {
        eV(AG);
        cGQ = true;
      }
      localObject1 = AG;
      d1 = paramInt4 / paramInt3;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getFullVideoPreviewSize[self-adaption] physicRatio=" + d1);
      }
      localObject4 = new ArrayList(3);
      localObject3 = new ArrayList(3);
      localb = new anij.b();
      localObject5 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject5).hasNext()) {
        break label400;
      }
      Camera.Size localSize = (Camera.Size)((Iterator)localObject5).next();
      if (localSize != null)
      {
        double d2 = localSize.width / localSize.height;
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          if (Math.abs(((Float)localIterator.next()).floatValue() - d2) > 0.009999999776482582D) {
            break label259;
          }
          if (d2 >= d1)
          {
            ((ArrayList)localObject4).add(localSize);
            continue;
            if (!cGP)
            {
              eV(AF);
              cGP = true;
            }
            localObject1 = AF;
            break;
          }
          ((ArrayList)localObject3).add(localSize);
        }
      }
    }
    label400:
    int i = anhm.dGc;
    int j = anhm.dGd;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getFullVideoPreviewSize[self-adaption] previewWidth=" + i + "previewHeight=" + j);
    }
    Object localObject1 = ((ArrayList)localObject4).iterator();
    paramInt2 = -1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject5 = (Camera.Size)((Iterator)localObject1).next();
      if ((localObject5 == null) || (((Camera.Size)localObject5).height != j) || (((Camera.Size)localObject5).width < i) || ((paramInt2 >= 0) && (((Camera.Size)localObject5).width > paramInt2))) {
        break label1402;
      }
      paramInt2 = ((Camera.Size)localObject5).width;
    }
    label1399:
    label1402:
    for (;;)
    {
      break;
      if (paramInt2 > 0)
      {
        localb.height = j;
        localb.width = paramInt2;
        if ((anii.isFoundCoolPad()) && (a((ArrayList)localObject3, i, j))) {
          localb.width = i;
        }
        return localb;
      }
      localObject1 = ((ArrayList)localObject3).iterator();
      long l1 = 9223372036854775807L;
      long l2;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 != null) && (c(paramInt1, paramInt3, paramInt4, ((Camera.Size)localObject5).width, ((Camera.Size)localObject5).height)))
        {
          l2 = ((Camera.Size)localObject5).width * ((Camera.Size)localObject5).height;
          if (l2 < l1)
          {
            localb.width = ((Camera.Size)localObject5).width;
            localb.height = ((Camera.Size)localObject5).height;
            l1 = l2;
          }
        }
        for (;;)
        {
          break;
          if ((l2 == l1) && (((Camera.Size)localObject5).width < localb.width))
          {
            localb.width = ((Camera.Size)localObject5).width;
            localb.height = ((Camera.Size)localObject5).height;
          }
        }
      }
      if ((localb.width > 0) || (localb.height > 0)) {
        return localb;
      }
      paramInt2 = anhm.ny[1];
      i = anhm.nz[1];
      localObject1 = ((ArrayList)localObject4).iterator();
      paramInt1 = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject5 = (Camera.Size)((Iterator)localObject1).next();
        if ((localObject5 == null) || (((Camera.Size)localObject5).height != i) || (((Camera.Size)localObject5).width < paramInt2) || ((paramInt1 >= 0) && (((Camera.Size)localObject5).width > paramInt1))) {
          break label1399;
        }
        paramInt1 = ((Camera.Size)localObject5).width;
      }
      for (;;)
      {
        break;
        if (paramInt1 > 0)
        {
          localb.height = i;
          localb.width = paramInt1;
          return localb;
        }
        if ((localb.width <= 0) || (localb.height <= 0))
        {
          localObject1 = ((ArrayList)localObject4).iterator();
          l1 = 9223372036854775807L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject4 != null)
            {
              l2 = ((Camera.Size)localObject4).width * ((Camera.Size)localObject4).height;
              if (l2 < l1)
              {
                localb.width = ((Camera.Size)localObject4).width;
                localb.height = ((Camera.Size)localObject4).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject4).width < localb.width))
              {
                localb.width = ((Camera.Size)localObject4).width;
                localb.height = ((Camera.Size)localObject4).height;
              }
            }
          }
        }
        if ((localb.width <= 0) || (localb.height <= 0))
        {
          localObject1 = ((ArrayList)localObject3).iterator();
          l1 = 9223372036854775807L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Camera.Size)((Iterator)localObject1).next();
            if ((localObject3 != null) && (c(320, paramInt3, paramInt4, ((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height)))
            {
              l2 = ((Camera.Size)localObject3).width * ((Camera.Size)localObject3).height;
              if (l2 < l1)
              {
                localb.width = ((Camera.Size)localObject3).width;
                localb.height = ((Camera.Size)localObject3).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject3).width < localb.width))
              {
                localb.width = ((Camera.Size)localObject3).width;
                localb.height = ((Camera.Size)localObject3).height;
              }
            }
          }
        }
        if ((localb.width <= 0) || (localb.height <= 0))
        {
          localObject1 = ((List)localObject2).iterator();
          l1 = 0L;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Camera.Size)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              l2 = ((Camera.Size)localObject2).width * ((Camera.Size)localObject2).height;
              if (l2 > l1)
              {
                localb.width = ((Camera.Size)localObject2).width;
                localb.height = ((Camera.Size)localObject2).height;
                l1 = l2;
              }
            }
            for (;;)
            {
              break;
              if ((l2 == l1) && (((Camera.Size)localObject2).width < localb.width))
              {
                localb.width = ((Camera.Size)localObject2).width;
                localb.height = ((Camera.Size)localObject2).height;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getFullVideoPreviewSize[self-adaption] cSize.width=" + localb.width + "  cSize.height=" + localb.height);
        }
        if ((localb.width > 0) && (localb.height > 0)) {
          return localb;
        }
        return null;
      }
    }
  }
  
  public anij.b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    assert (this.mCamera != null);
    assert (this.jdField_a_of_type_Anij$b != null);
    if (b() == null) {
      return null;
    }
    int i = Math.min(paramInt1, paramInt2);
    paramInt1 = Math.max(paramInt1, paramInt2);
    float f3 = paramInt1 / i;
    anij.b localb = new anij.b();
    Object localObject1 = anih.a().gl();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      return null;
    }
    Object localObject2 = new anij.b();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    float f1 = 10000.0F;
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if (localSize != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] setPictureSize[list]: width=" + localSize.width + " height=" + localSize.height + " w/h=" + localSize.width / localSize.height);
        }
        float f4 = localSize.width / localSize.height;
        if (Math.abs(f4 - f3) <= cW) {
          localArrayList.add(localSize);
        }
        float f2 = f1;
        if (localSize.width >= paramInt1)
        {
          f2 = f1;
          if (f1 > Math.abs(f4 - f3))
          {
            f2 = Math.abs(f4 - f3);
            ((anij.b)localObject2).width = localSize.width;
            ((anij.b)localObject2).height = localSize.height;
          }
        }
        f1 = f2;
      }
    }
    if ((localArrayList.isEmpty()) && (((anij.b)localObject2).width >= paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getPictureSize: width=" + ((anij.b)localObject2).width + " height=" + ((anij.b)localObject2).height + " w/h=" + ((anij.b)localObject2).width / ((anij.b)localObject2).height);
      }
      return localObject2;
    }
    if ((localArrayList.isEmpty()) && (((List)localObject1).size() > 0))
    {
      localb.width = ((Camera.Size)((List)localObject1).get(0)).width;
      localb.height = ((Camera.Size)((List)localObject1).get(0)).height;
      return localb;
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    if (paramInt5 == -1)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Camera.Size)((Iterator)localObject1).next();
        if (localb.width < ((Camera.Size)localObject2).width)
        {
          localb.width = ((Camera.Size)localObject2).width;
          localb.height = ((Camera.Size)localObject2).height;
        }
      }
    }
    while (localb.width == 0)
    {
      return null;
      localb = a(paramInt3, paramInt4, paramInt5, localArrayList);
    }
    return localb;
  }
  
  public anij.b a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewSizeV2: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = anih.a().gk();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    anij.b localb = a((List)localObject, paramInt1, paramInt2);
    if (localb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localb;
      if (paramBoolean)
      {
        aarz.d(2, paramInt1, paramInt2, localb.width, localb.height);
        localObject = localb;
      }
    }
    do
    {
      do
      {
        return localObject;
        localb = a((List)localObject, 960, 720);
        if (localb == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
        }
        localObject = localb;
      } while (!paramBoolean);
      aarz.d(3, paramInt1, paramInt2, localb.width, localb.height);
      return localb;
      localb = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = localb;
    } while (!paramBoolean);
    if (localb == null)
    {
      paramInt3 = 0;
      if (localb != null) {
        break label379;
      }
    }
    label379:
    for (paramInt4 = j;; paramInt4 = localb.height)
    {
      aarz.d(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localb;
      paramInt3 = localb.width;
      break;
    }
  }
  
  public anij.b a(int paramInt1, int paramInt2, int paramInt3, List<Camera.Size> paramList)
  {
    paramInt3 = Math.max(paramInt1 * paramInt3, paramInt2 * paramInt3);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setParamsPictureSize targetWidth " + paramInt3);
    }
    anij.b localb = new anij.b(0, 0);
    paramList = paramList.iterator();
    paramInt1 = 2147483647;
    if (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      paramInt2 = Math.abs(localSize.width - paramInt3);
      if (paramInt1 <= paramInt2) {
        break label132;
      }
      localb.width = localSize.width;
      localb.height = localSize.height;
      paramInt1 = paramInt2;
    }
    label132:
    for (;;)
    {
      break;
      return localb;
    }
  }
  
  @TargetApi(17)
  public void a(File paramFile, Rect paramRect, CameraCover.a parama, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.mCamera == null) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[takePicture]mCamera " + null);
      }
    }
    for (;;)
    {
      return;
      aarz.AK("begin pic taken");
      try
      {
        this.mCamera.enableShutterSound(false);
        try
        {
          long l = System.currentTimeMillis();
          this.aNE = false;
          this.mCamera.takePicture(null, null, null, new anik(this, paramInt1, l, paramFile, paramRect, parama, paramBoolean, paramInt2));
          return;
        }
        catch (RuntimeException paramFile) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, "", paramFile);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.i(TAG, 1, "[takePicture]enableShutterSound error, ", localException);
        }
      }
    }
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    if ((this.mCamera == null) || (paramSurfaceTexture == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.aNE) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "@$[setPreviewTexture] mIsPreviewing=" + this.aNE);
    return true;
    try
    {
      this.mCamera.setPreviewTexture(paramSurfaceTexture);
      return true;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramSurfaceTexture.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "@$[setPreviewTexture] exp=", paramSurfaceTexture);
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.mCamera == null) || (!this.aNE) || (!canFocus())) {
      return false;
    }
    try
    {
      this.mCamera.cancelAutoFocus();
      this.mCamera.autoFocus(paramAutoFocusCallback);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, SurfaceHolder paramSurfaceHolder)
  {
    if ((this.mCamera == null) || (paramPreviewCallback == null) || (paramSurfaceHolder == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] startPreview[failed] mCamera=" + this.mCamera + " holder=" + paramSurfaceHolder + " callback=" + paramPreviewCallback);
      }
      return false;
    }
    try
    {
      this.mCamera.setPreviewDisplay(paramSurfaceHolder);
      this.mCamera.setPreviewCallback(paramPreviewCallback);
      this.mCamera.startPreview();
      this.aNE = true;
      return true;
    }
    catch (Exception paramPreviewCallback)
    {
      paramPreviewCallback.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback.getMessage());
        QLog.i(TAG, 2, "[@] startPreview[failed] Exception Occured... ep=" + paramPreviewCallback);
      }
    }
    return false;
  }
  
  public boolean a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if ((this.mCamera == null) || (paramPreviewCallback == null)) {
      return false;
    }
    if (paramBoolean) {
      try
      {
        if (cm(JD()))
        {
          this.mCamera.addCallbackBuffer(this.fy);
          this.mCamera.addCallbackBuffer(this.fz);
          this.mCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
        }
        else
        {
          this.mCamera.setPreviewCallback(paramPreviewCallback);
        }
      }
      catch (Exception paramPreviewCallback)
      {
        paramPreviewCallback.printStackTrace();
        return false;
      }
    } else {
      this.mCamera.setPreviewCallback(paramPreviewCallback);
    }
    return true;
  }
  
  public boolean a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool = true;
    if ((this.mCamera == null) || (paramSurfaceHolder == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (!this.aNE) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "@$[setSurfaceHolder] mIsPreviewing=" + this.aNE);
    return true;
    try
    {
      this.mCamera.setPreviewDisplay(paramSurfaceHolder);
      return true;
    }
    catch (Exception paramSurfaceHolder)
    {
      paramSurfaceHolder.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "@$[setSurfaceHolder] exp=", paramSurfaceHolder);
      }
    }
    return false;
  }
  
  public boolean a(anim.f paramf)
  {
    Camera.Parameters localParameters = b();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      return false;
    }
    localParameters.setPreviewFormat(paramf.cFs);
    localParameters.setPreviewSize(paramf.e.width, paramf.e.height);
    localParameters.setPreviewFpsRange(paramf.dGV, paramf.dGW);
    if (paramf.cGV) {
      localParameters.setPictureSize(paramf.f.width, paramf.f.height);
    }
    boolean bool = setCameraParameters(localParameters);
    if (bool)
    {
      this.cFs = paramf.cFs;
      this.jdField_a_of_type_Anij$b = paramf.e;
      this.nB = new int[] { paramf.dGV, paramf.dGW };
      this.d = paramf.f;
    }
    return bool;
  }
  
  public anij.b[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeV2 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    }
    anij.b[] arrayOfb = new anij.b[2];
    anij.b localb1 = a(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localb1 != null)
    {
      arrayOfb[0] = localb1;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localb1.width + " " + localb1.height);
      }
      anij.b localb2 = a(localb1.width, localb1.height, paramInt3, paramInt4, 1);
      arrayOfb[1] = localb2;
      if (localb2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localb2.width + " " + localb2.height);
        }
        aarz.c(true, localb1.width, localb1.height, localb2.width, localb2.height);
      }
    }
    else
    {
      return arrayOfb;
    }
    aarz.c(true, localb1.width, localb1.height, -1, -1);
    return arrayOfb;
  }
  
  public void anR()
  {
    this.fy = null;
    this.fz = null;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "releasePreviewFrameBuffer");
    }
  }
  
  public boolean axp()
  {
    if (this.mCamera == null) {
      return false;
    }
    if (this.aNE) {
      return true;
    }
    try
    {
      this.mCamera.startPreview();
      this.aNE = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public boolean axq()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 379	anij:mCamera	Landroid/hardware/Camera;
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield 514	anij:aNE	Z
    //   13: ifne +5 -> 18
    //   16: iconst_1
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 514	anij:aNE	Z
    //   23: aload_0
    //   24: invokespecial 546	anij:canFocus	()Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +10 -> 39
    //   32: aload_0
    //   33: getfield 379	anij:mCamera	Landroid/hardware/Camera;
    //   36: invokevirtual 549	android/hardware/Camera:cancelAutoFocus	()V
    //   39: aload_0
    //   40: getfield 379	anij:mCamera	Landroid/hardware/Camera;
    //   43: invokevirtual 648	android/hardware/Camera:stopPreview	()V
    //   46: aload_0
    //   47: getfield 379	anij:mCamera	Landroid/hardware/Camera;
    //   50: aconst_null
    //   51: invokevirtual 568	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   54: aload_0
    //   55: getfield 379	anij:mCamera	Landroid/hardware/Camera;
    //   58: aconst_null
    //   59: invokevirtual 564	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   62: iconst_1
    //   63: ireturn
    //   64: astore_2
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_2
    //   68: goto -29 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	anij
    //   27	2	1	bool	boolean
    //   64	1	2	localException	Exception
    //   67	1	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   18	28	64	java/lang/Exception
    //   32	39	64	java/lang/Exception
    //   39	62	64	java/lang/Exception
    //   32	39	67	java/lang/RuntimeException
  }
  
  public boolean axr()
  {
    int j = 90;
    assert (this.mCamera != null);
    Object localObject = Build.MODEL.toUpperCase();
    int i;
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && ((((String)localObject).contains("RLI-AN00")) || (((String)localObject).contains("RLI-N29")) || (((String)localObject).contains("TAH-AN00")) || (((String)localObject).contains("TAH-N29"))))
    {
      i = 1;
      if (i == 0)
      {
        i = j;
        if (Build.VERSION.SDK_INT < 28) {}
      }
      else
      {
        localObject = new Camera.CameraInfo();
        Camera.getCameraInfo(this.dGP, (Camera.CameraInfo)localObject);
        switch (((WindowManager)BaseApplicationImpl.getApplication().getSystemService("window")).getDefaultDisplay().getRotation())
        {
        default: 
          i = 90;
          label175:
          if (((Camera.CameraInfo)localObject).facing == 1) {
            i = (360 - (i + ((Camera.CameraInfo)localObject).orientation) % 360) % 360;
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.dGP == 1)
        {
          bool1 = anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL);
          bool2 = anii.isFoundProductFeatureRom(anii.KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2);
          if (bool1) {
            break label405;
          }
          if (!bool2) {
            break label402;
          }
          break label405;
          this.mCamera.setDisplayOrientation(i);
          this.cjo = i;
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "setDisplayOrientation degrees=" + i + " blackPhone=" + bool1 + " camera=" + aaqh.cix + " rom_black=" + bool2);
          }
          return true;
          i = 0;
          break;
          i = 0;
          break label175;
          i = 90;
          break label175;
          i = 180;
          break label175;
          i = 270;
          break label175;
          i = (((Camera.CameraInfo)localObject).orientation - i + 360) % 360;
          continue;
        }
        boolean bool1 = anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL);
        if (bool1)
        {
          i += 180;
          bool2 = false;
          continue;
        }
        boolean bool2 = false;
      }
      catch (Exception localException)
      {
        return false;
      }
      continue;
      label402:
      continue;
      label405:
      i += 180;
    }
  }
  
  @TargetApi(14)
  public boolean axs()
  {
    boolean bool = false;
    assert (this.mCamera != null);
    try
    {
      i = this.mCamera.getParameters().getMaxNumDetectedFaces();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "supportFaceDetect" + i);
      }
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int i = 0;
      }
    }
  }
  
  public boolean axt()
  {
    assert (this.mCamera != null);
    Camera.Parameters localParameters = b();
    boolean bool1;
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] setParamsPreviewFormat[failed]getCameraParameters=null");
      }
      bool1 = false;
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (!anih.a().lz(17)) {
                  break;
                }
                localParameters.setPreviewFormat(17);
                this.cFs = 17;
                bool2 = setCameraParameters(localParameters);
                bool1 = bool2;
              } while (!QLog.isColorLevel());
              QLog.i(TAG, 2, "[@] setParamsPreviewFormat:success=" + bool2 + ", isSupportPreviewFormat=NV21 ok");
              return bool2;
              if (!anih.a().lz(842094169)) {
                break;
              }
              localParameters.setPreviewFormat(842094169);
              this.cFs = 842094169;
              bool2 = setCameraParameters(localParameters);
              bool1 = bool2;
            } while (!QLog.isColorLevel());
            QLog.i(TAG, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YV12 OK");
            return bool2;
            if (!anih.a().lz(20)) {
              break;
            }
            localParameters.setPreviewFormat(20);
            this.cFs = 20;
            bool2 = setCameraParameters(localParameters);
            bool1 = bool2;
          } while (!QLog.isColorLevel());
          QLog.i(TAG, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=YUY2 OK");
          return bool2;
          if (!anih.a().lz(4)) {
            break;
          }
          localParameters.setPreviewFormat(4);
          this.cFs = 4;
          bool2 = setCameraParameters(localParameters);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.i(TAG, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=RGB_565 OK");
        return bool2;
        if (!anih.a().lz(256)) {
          break;
        }
        localParameters.setPreviewFormat(256);
        this.cFs = 256;
        bool2 = setCameraParameters(localParameters);
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.i(TAG, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=JPEG OK");
      return bool2;
      if (!anih.a().lz(16)) {
        break;
      }
      localParameters.setPreviewFormat(16);
      this.cFs = 16;
      bool2 = setCameraParameters(localParameters);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "[@] setParamsPreviewFormat:success=" + bool2 + "isSupportPreviewFormat=NV16 OK");
    return bool2;
    return false;
  }
  
  public boolean axu()
  {
    assert (this.mCamera != null);
    if (anih.a().axo())
    {
      Camera.Parameters localParameters = b();
      if (TextUtils.equals(localParameters.getFlashMode(), "torch")) {
        localParameters.setFlashMode("off");
      }
      for (;;)
      {
        return setCameraParameters(localParameters);
        localParameters.setFlashMode("torch");
      }
    }
    return false;
  }
  
  public boolean axv()
  {
    return this.aNE;
  }
  
  public Camera.Parameters b()
  {
    try
    {
      Camera.Parameters localParameters = this.mCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 2, localException, new Object[0]);
    }
    return null;
  }
  
  public anij.b b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewSizeV3: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = anih.a().gk();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    float f2 = 1.0F * paramInt1 / paramInt2 * 1000.0F;
    float f1 = f2;
    if (f2 > 1700.0F) {
      f1 = 1700.0F;
    }
    anij.b localb = a((List)localObject, paramInt1, paramInt2, 2600, 1500, (int)f1, 1000);
    if (localb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localb;
      if (paramBoolean)
      {
        aarz.d(2, paramInt1, paramInt2, localb.width, localb.height);
        localObject = localb;
      }
    }
    do
    {
      return localObject;
      f2 = 1.0F * paramInt1 / paramInt2 * 700.0F;
      f1 = f2;
      if (f2 > 1000.0F) {
        f1 = 1000.0F;
      }
      localb = a((List)localObject, paramInt1, paramInt2, 2600, 1500, (int)f1, 700);
      if (localb == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
      }
      localObject = localb;
    } while (!paramBoolean);
    aarz.d(3, paramInt1, paramInt2, localb.width, localb.height);
    return localb;
    localObject = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      if (localObject != null) {
        break label444;
      }
      paramInt3 = 0;
      if (localObject != null) {
        break label453;
      }
    }
    label444:
    label453:
    for (paramInt4 = 0;; paramInt4 = ((anij.b)localObject).height)
    {
      aarz.d(4, paramInt1, paramInt2, paramInt3, paramInt4);
      return localObject;
      paramInt3 = ((anij.b)localObject).width;
      break;
    }
  }
  
  public boolean b(anij.b paramb)
  {
    Camera.Parameters localParameters = b();
    if (localParameters == null) {}
    do
    {
      return false;
      try
      {
        localParameters.setPictureSize(paramb.width, paramb.height);
        this.d = paramb;
        boolean bool = setCameraParameters(localParameters);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "setRawPictureSize w " + paramb.width + ", h " + paramb.height + ", success=" + bool);
        }
        return bool;
      }
      catch (Exception paramb)
      {
        paramb.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "setParamsPictureSize", paramb);
    return false;
  }
  
  public int[] b(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = 2147483647;
    int[] tmp12_7 = tmp7_5;
    tmp12_7[1] = 2147483647;
    tmp12_7;
    int i = paramInt * 1000;
    List localList = anih.a().gm();
    if (localList == null)
    {
      arrayOfInt1[0] = i;
      arrayOfInt1[1] = i;
      return arrayOfInt1;
    }
    mt(localList);
    if (!paramBoolean) {
      return b(localList, paramInt);
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt2 = (int[])localIterator.next();
      if ((arrayOfInt2 != null) && (arrayOfInt2.length >= 2) && (i >= arrayOfInt2[0]) && (i <= arrayOfInt2[1]))
      {
        arrayOfInt1[0] = i;
        arrayOfInt1[1] = arrayOfInt2[1];
        return arrayOfInt1;
      }
    }
    return b(localList, paramInt);
  }
  
  public anij.b[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeV3 wanted size=" + paramInt1 + " " + paramInt2 + " cliped=" + paramInt3 + " " + paramInt4);
    }
    anij.b[] arrayOfb = new anij.b[2];
    anij.b localb1 = b(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localb1 != null)
    {
      arrayOfb[0] = localb1;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localb1.width + " " + localb1.height);
      }
      anij.b localb2 = a(localb1.width, localb1.height, paramInt3, paramInt4, 1);
      arrayOfb[1] = localb2;
      if (localb2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localb2.width + " " + localb2.height);
        }
        aarz.c(true, localb1.width, localb1.height, localb2.width, localb2.height);
      }
    }
    else
    {
      return arrayOfb;
    }
    aarz.c(true, localb1.width, localb1.height, -1, -1);
    return arrayOfb;
  }
  
  public boolean bn(boolean paramBoolean)
  {
    assert (this.mCamera != null);
    if (anih.a().axo())
    {
      Camera.Parameters localParameters = b();
      String str = localParameters.getFlashMode();
      if ((paramBoolean) && (!TextUtils.equals(str, "on"))) {
        localParameters.setFlashMode("on");
      }
      for (;;)
      {
        return setCameraParameters(localParameters);
        if ((!paramBoolean) && (!TextUtils.equals(str, "off"))) {
          localParameters.setFlashMode("off");
        }
      }
    }
    return false;
  }
  
  public boolean bo(boolean paramBoolean)
  {
    assert (this.mCamera != null);
    if (anih.a().axo())
    {
      Camera.Parameters localParameters = b();
      if (paramBoolean) {}
      for (String str = "torch";; str = "off")
      {
        localParameters.setFlashMode(str);
        return setCameraParameters(localParameters);
      }
    }
    return false;
  }
  
  public anij.b c()
  {
    return this.jdField_a_of_type_Anij$b;
  }
  
  public anij.b c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: dstwidth=" + paramInt1 + "  dstheight=" + paramInt2);
    }
    Object localObject = anih.a().gk();
    if ((QLog.isColorLevel()) && (localObject != null))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK[list]: width=" + ((Camera.Size)((List)localObject).get(i)).width + " height=" + ((Camera.Size)((List)localObject).get(i)).height + " w/h=" + ((Camera.Size)((List)localObject).get(i)).width / ((Camera.Size)((List)localObject).get(i)).height);
        i += 1;
      }
    }
    anij.b localb = a((List)localObject, anhm.dGc, anhm.dGd);
    if (localb != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: DEFAULT resolution os OK.");
      }
      localObject = localb;
      if (paramBoolean)
      {
        aarz.d(2, anhm.dGc, anhm.dGd, localb.width, localb.height);
        localObject = localb;
      }
    }
    do
    {
      do
      {
        return localObject;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: Degeneration to 640*480...");
        }
        localb = a((List)localObject, anhm.ns[1], anhm.nt[1]);
        if (localb == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getPreviewSizeGuaranteeOK: 640*480 resolution os OK.");
        }
        localObject = localb;
      } while (!paramBoolean);
      aarz.d(3, anhm.dGc, anhm.dGd, localb.width, localb.height);
      return localb;
      localb = a((List)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = localb;
    } while (!paramBoolean);
    if (localb == null)
    {
      paramInt1 = 0;
      if (localb != null) {
        break label413;
      }
    }
    label413:
    for (paramInt2 = j;; paramInt2 = localb.height)
    {
      aarz.d(4, anhm.dGc, anhm.dGd, paramInt1, paramInt2);
      return localb;
      paramInt1 = localb.width;
      break;
    }
  }
  
  public void c(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if ((paramBoolean) && (this.mCamera != null) && (paramArrayOfByte != null)) {
      this.mCamera.addCallbackBuffer(paramArrayOfByte);
    }
  }
  
  public boolean c(anij.b paramb)
  {
    assert (this.mCamera != null);
    Camera.Parameters localParameters = b();
    if (localParameters == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] setParamsPreviewSize[failed]getCameraParameters=null");
      }
      return false;
    }
    try
    {
      localParameters.setPreviewSize(paramb.width, paramb.height);
      this.jdField_a_of_type_Anij$b = paramb;
      boolean bool = setCameraParameters(localParameters);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] setParamsPreviewSize, result = " + bool + ",size.width = " + paramb.width + ",size.height = " + paramb.height);
      }
      return bool;
    }
    catch (Exception paramb)
    {
      paramb.printStackTrace();
    }
    return false;
  }
  
  public anij.b[] c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee wanted size=" + anhm.dGc + " " + anhm.dGd + " cliped=" + paramInt1 + " " + paramInt2);
    }
    if (0 != 0)
    {
      paramInt1 = anhm.dGc;
      paramInt1 = anhm.dGd;
      throw new NullPointerException();
    }
    anij.b[] arrayOfb = new anij.b[2];
    anij.b localb1 = c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    if (localb1 != null)
    {
      arrayOfb[0] = localb1;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee way2 preview=" + localb1.width + " " + localb1.height);
      }
      anij.b localb2 = a(localb1.width, localb1.height, paramInt3, paramInt4, 1);
      arrayOfb[1] = localb2;
      if (localb2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] getPreviewAndPictureSizeGuarantee way2 picture=" + localb2.width + " " + localb2.height);
        }
        aarz.c(true, localb1.width, localb1.height, localb2.width, localb2.height);
        return arrayOfb;
      }
      aarz.c(true, localb1.width, localb1.height, -1, -1);
    }
    return arrayOfb;
  }
  
  public anij.b d()
  {
    return this.d;
  }
  
  public int getPreviewFormat()
  {
    return this.cFs;
  }
  
  public int jr(int paramInt)
  {
    if (aaqi.WS()) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if (!anih.axl())
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] openCamera[failed]hasCameras=false");
        }
        return 2;
      }
      if (this.aqw)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[openCamera]Camera is opened, Camera object " + this.mCamera);
        }
        return 5;
      }
      int j = 0;
      i = 0;
      label83:
      if (j < 10) {}
      try
      {
        for (;;)
        {
          this.dGP = jq(paramInt);
          if (VersionUtils.isGingerBread())
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "openCamera:currentCount= " + j);
            }
            axiy.i(TAG, "【Real Old openCamera】:" + this.dGP);
            axiy.i(TAG, "【Real Old openCamera】:currentCount= " + j);
          }
          for (this.mCamera = Camera.open(this.dGP);; this.mCamera = Camera.open())
          {
            i = 0;
            if (this.mCamera == null) {
              break;
            }
            if (anih.a().a(this.mCamera)) {
              break label321;
            }
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "[@] openCamera[failed]bindCamera=false");
            }
            return 4;
          }
          try
          {
            Thread.sleep(300L);
            i = 3;
            break label83;
            this.jdField_a_of_type_Anij$a = new anij.a();
            this.aqw = true;
            return 0;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label316;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.mCamera = null;
        j += 1;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "[@] openCamera[failed][RM_CAMERA_OPEN_FAILED]currentCount=" + j, localException);
        }
        if (j >= 10) {}
      }
    }
  }
  
  public boolean lA(int paramInt)
  {
    assert (this.mCamera != null);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + "]");
    }
    boolean bool2 = p(paramInt, false);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=false success=" + bool2 + "]");
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool2 = p(paramInt, true);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(TAG, 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=true success=" + bool2 + "]");
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public boolean lB(int paramInt)
  {
    int j = 0;
    assert (this.mCamera != null);
    Camera.Parameters localParameters;
    int i;
    if (anih.a().axn())
    {
      localParameters = b();
      if (localParameters == null) {
        return false;
      }
      i = localParameters.getMaxZoom();
      paramInt = localParameters.getZoom() + paramInt;
      if (paramInt >= 0) {
        break label90;
      }
      paramInt = j;
    }
    label90:
    for (;;)
    {
      if (paramInt > i) {
        paramInt = i;
      }
      for (;;)
      {
        localParameters.setZoom(paramInt);
        return setCameraParameters(localParameters);
        return false;
      }
    }
  }
  
  public boolean p(int paramInt, boolean paramBoolean)
  {
    assert (this.mCamera != null);
    Camera.Parameters localParameters = b();
    if (localParameters == null) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "[@] setPreviewFps[failed]getCameraParameters=null");
      }
    }
    int[] arrayOfInt;
    do
    {
      return false;
      arrayOfInt = b(paramInt, paramBoolean);
      if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "setPreviewFps[getFpsRange=null]");
    return false;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "setPreviewFps[ fps[low]=" + arrayOfInt[0] + " fps[high]=" + arrayOfInt[1] + "]");
    }
    try
    {
      localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
      this.nB = arrayOfInt;
      paramBoolean = setCameraParameters(localParameters);
      return paramBoolean;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean pk(String paramString)
  {
    assert (this.mCamera != null);
    if (anih.a().pj(paramString))
    {
      Camera.Parameters localParameters = b();
      String str = localParameters.getSceneMode();
      if ((str != null) && (!str.equals(paramString)))
      {
        localParameters.setSceneMode(paramString);
        boolean bool = setCameraParameters(localParameters);
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 2, new Object[] { "setSceneMode success: ", Boolean.valueOf(bool) });
        }
        return bool;
      }
    }
    else
    {
      return false;
    }
    return true;
  }
  
  @TargetApi(14)
  public void releaseCamera()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "release camera");
    }
    if (!this.aqw) {}
    do
    {
      return;
      anih.a().reset();
    } while (this.mCamera == null);
    stopFaceDetection();
    try
    {
      this.mCamera.release();
      this.mCamera = null;
      this.cFs = -1;
      this.nB = null;
      this.jdField_a_of_type_Anij$b = null;
      this.aqw = false;
      anR();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean setCameraParameters(Camera.Parameters paramParameters)
  {
    assert (this.mCamera != null);
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.mCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters)
    {
      QLog.e(TAG, 2, paramParameters, new Object[0]);
    }
    return false;
  }
  
  @TargetApi(14)
  public void setFaceDetectionListener(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    assert (this.mCamera != null);
    try
    {
      this.mCamera.setFaceDetectionListener(paramFaceDetectionListener);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "setFaceDetectionListener");
      }
      return;
    }
    catch (Exception paramFaceDetectionListener)
    {
      for (;;)
      {
        paramFaceDetectionListener.printStackTrace();
      }
    }
  }
  
  public boolean setParamsFocusMode(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    assert (this.mCamera != null);
    if (!canFocus()) {}
    boolean bool3;
    do
    {
      for (;;)
      {
        return bool2;
        try
        {
          this.mCamera.cancelAutoFocus();
          Camera.Parameters localParameters = b();
          if (localParameters != null)
          {
            String str = localParameters.getFocusMode();
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "[@] setParamsFocusMode getFocusMode=" + str);
            }
            if ((str != null) && (str.equals(paramString))) {
              return true;
            }
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "", localRuntimeException);
            }
          }
          bool3 = anih.a().isSupportFocus(paramString);
          if (bool3)
          {
            localRuntimeException.setFocusMode(paramString);
            bool1 = setCameraParameters(localRuntimeException);
          }
          bool2 = bool1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "[@] setParamsFocusMode support=" + bool3 + " success=" + bool1 + " setTo=" + paramString);
    return bool1;
  }
  
  @TargetApi(14)
  public void startFaceDetection()
  {
    assert (this.mCamera != null);
    try
    {
      this.mCamera.startFaceDetection();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "startFaceDetection");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  @TargetApi(14)
  public void stopFaceDetection()
  {
    assert (this.mCamera != null);
    try
    {
      this.mCamera.setFaceDetectionListener(null);
      this.mCamera.stopFaceDetection();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "stopFaceDetection");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public class a
  {
    int facing = -1;
    int orientation = -1;
    int rotation = -1;
    
    public a() {}
  }
  
  public static class b
  {
    private double cX;
    public int height;
    public int width;
    
    public b() {}
    
    public b(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.cX = (paramInt1 / paramInt2);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
      } while ((this.width == paramObject.width) && (this.height == paramObject.height));
      return false;
    }
    
    public String toString()
    {
      return "CustomSize[width=" + this.width + ", height=" + this.height + ", scaleWH='" + this.cX + ']';
    }
  }
  
  public class c
  {
    public CameraCover.a a;
    public File aM;
    public Camera.Size c;
    public Rect cD;
    public int dGS;
    public byte[] fA;
    public int mCameraId;
    public boolean mMirror;
    public int mOrientation;
    public int mQuality;
    
    private c() {}
  }
  
  public class d
    extends AsyncTask<Void, Void, String>
  {
    anij.c a;
    
    public d(anij.c paramc)
    {
      this.a = paramc;
      aqip.beginPile();
    }
    
    private void b(File paramFile, byte[] paramArrayOfByte)
    {
      do
      {
        try
        {
          localFileOutputStream = new FileOutputStream(paramFile);
          paramFile.printStackTrace();
        }
        catch (Exception paramFile)
        {
          try
          {
            localFileOutputStream.write(paramArrayOfByte);
            localFileOutputStream.flush();
            localFileOutputStream.close();
            return;
          }
          catch (Exception paramFile)
          {
            FileOutputStream localFileOutputStream;
            paramArrayOfByte = localFileOutputStream;
            continue;
          }
          paramFile = paramFile;
          paramArrayOfByte = null;
        }
      } while (paramArrayOfByte == null);
      try
      {
        paramArrayOfByte.close();
        return;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
        return;
      }
    }
    
    private String zU()
    {
      boolean bool2 = false;
      Object localObject3 = this.a.fA;
      Object localObject1 = this.a.aM;
      aqip.beginPile();
      if (localObject1 == null) {
        return null;
      }
      int i;
      if (localObject3 != null)
      {
        i = aeah.a(anij.this.b, anij.this.dGP, this.a.mOrientation);
        if (QLog.isColorLevel()) {
          QLog.i(anij.TAG, 2, "[onPictureTaken] mirror=" + this.a.mMirror + " frontFlip=" + anij.this.b.a().afW() + " jpegRotation=" + i);
        }
      }
      for (;;)
      {
        try
        {
          boolean bool3 = anij.a(anij.this, this.a.c.width, this.a.c.height, this.a.cD.width(), this.a.cD.height());
          boolean bool1 = bool2;
          if (this.a.mMirror)
          {
            bool1 = bool2;
            if (!anij.this.b.a().afW()) {
              bool1 = true;
            }
          }
          localObject3 = aeah.b((byte[])localObject3, this.a.cD, bool1, i);
          aarz.AK("clip_rotate;");
          aqhu.b((Bitmap)localObject3, this.a.mQuality, (File)localObject1);
          aarz.a(false, this.a.c.width, this.a.c.height, this.a.cD.width(), this.a.cD.height(), bool3, i, bool1);
          aarz.AK("save jpg;");
          if (0 == 0) {}
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e(anij.TAG, 2, "[onPictureTaken] createBitmap failed orientation:" + this.a.mOrientation + ", " + localOutOfMemoryError.getMessage(), localOutOfMemoryError);
          aeah.b(null);
          if (0 == 0) {
            continue;
          }
          try
          {
            throw new NullPointerException();
          }
          catch (IOException localIOException3)
          {
            localIOException3.printStackTrace();
          }
          continue;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          aeah.b(null);
          if (0 == 0) {
            continue;
          }
          try
          {
            throw new NullPointerException();
          }
          catch (IOException localIOException5)
          {
            localIOException5.printStackTrace();
          }
          continue;
        }
        finally
        {
          if (0 == 0) {
            continue;
          }
          try
          {
            throw new NullPointerException();
            throw localObject4;
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
            continue;
          }
          aeah.b(null);
          continue;
        }
        try
        {
          throw new NullPointerException();
          if ((localObject1 != null) && (0 != 0)) {}
          try
          {
            aqhu.cn(BaseApplicationImpl.getContext(), ((File)localObject1).getAbsolutePath());
            if (QLog.isColorLevel()) {
              QLog.i(anij.TAG, 2, "[onPictureTaken] saveBitmapFileAsJPEG to " + ((File)localObject1).getPath());
            }
            if (!((File)localObject1).exists()) {
              continue;
            }
            BaseApplicationImpl.sImageCache.put(((File)localObject1).getAbsolutePath() + "#short_video_camera_preview_cache", null);
          }
          catch (Exception localException)
          {
            QLog.e(anij.TAG, 2, "[onPictureTaken] saveBitmapFileAsJPEG failed: " + localException.getMessage());
            if (!localIOException1.exists()) {
              break label660;
            }
            BaseApplicationImpl.sImageCache.put(localIOException1.getAbsolutePath() + "#short_video_camera_preview_cache", null);
            continue;
            aeah.b(null);
            continue;
          }
          finally
          {
            if (!localIOException1.exists()) {
              break label712;
            }
            BaseApplicationImpl.sImageCache.put(localIOException1.getAbsolutePath() + "#short_video_camera_preview_cache", null);
            for (;;)
            {
              throw localObject5;
              aeah.b(null);
            }
            Object localObject2 = null;
            continue;
          }
          aqip.endPile(anij.TAG, "TakePictureTask_writeTmpFile_needClip");
          if (((File)localObject1).exists())
          {
            localObject1 = ((File)localObject1).getAbsolutePath();
            return localObject1;
          }
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    
    private String zV()
    {
      int j = 0;
      byte[] arrayOfByte = this.a.fA;
      Object localObject = this.a.cD;
      localObject = this.a.aM;
      if (QLog.isColorLevel()) {
        QLog.i(anij.TAG, 2, "Do not clip photo");
      }
      aqip.beginPile();
      b((File)localObject, arrayOfByte);
      if (anii.isFoundProduct(anii.KEY_NEED_ROTATION_INFO_90_MODEL)) {
        aqhu.A(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(6));
      }
      while (!anii.isFoundProduct(anii.KEY_NEED_ROTATION_INFO_MODEL))
      {
        aqip.endPile(anij.TAG, "TakePictureTask_writePhotoFile");
        if (!((File)localObject).exists()) {
          break;
        }
        return ((File)localObject).getAbsolutePath();
      }
      int i = j;
      switch (this.a.mOrientation % 360)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        aqhu.A(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(i));
        break;
        i = 6;
        continue;
        i = 3;
        continue;
        i = 8;
      }
      return null;
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      if (this.a.dGS == 0) {
        return zV();
      }
      if (this.a.dGS == 1) {
        return zU();
      }
      return null;
    }
    
    protected void onPostExecute(String paramString)
    {
      
      if (this.a.a != null)
      {
        this.a.a.AE(paramString);
        if ((paramString == null) && (QLog.isColorLevel())) {
          QLog.i(anij.TAG, 2, "Picture bitmap data error or output file not exist");
        }
      }
      aqip.endPile(anij.TAG, "TakePictureTask_onPictureTokenCb");
      if (anij.this.mCamera != null) {}
      for (;;)
      {
        try
        {
          anij.this.mCamera.startPreview();
          anij.this.aNE = true;
          aqip.endPile(anij.TAG, "TakePictureTask");
          return;
        }
        catch (RuntimeException paramString)
        {
          paramString.printStackTrace();
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i(anij.TAG, 2, "[onPostExecute]mCamera is " + null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anij
 * JD-Core Version:    0.7.0.1
 */