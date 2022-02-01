import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.PasterParcelData;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer.1;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class ayjl
  extends ayjn
{
  private boolean dzz;
  
  public ayjl(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public static String sP(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".apng"))) {}
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("DynamicFaceLayer", 2, "getDynamicStaticPicPath|path= " + paramString);
      }
      int i = paramString.length();
      paramString = paramString.substring(0, i - 5) + ".bpng";
      if (QLog.isColorLevel()) {
        QLog.d("DynamicFaceLayer", 2, "newPath= " + paramString);
      }
      if (new File(paramString).exists()) {
        return paramString;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DynamicFaceLayer", 2, "file not exist");
    return null;
  }
  
  /* Error */
  public static Drawable w(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokestatic 95	rop:u	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +74 -> 86
    //   15: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +43 -> 61
    //   21: ldc 45
    //   23: iconst_2
    //   24: new 47	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   31: ldc 97
    //   33: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 102	android/graphics/Bitmap:getWidth	()I
    //   40: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc 107
    //   45: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 110	android/graphics/Bitmap:getHeight	()I
    //   52: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: new 112	android/graphics/drawable/BitmapDrawable
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 115	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   69: astore_0
    //   70: aload_0
    //   71: iconst_0
    //   72: iconst_0
    //   73: aload_1
    //   74: invokevirtual 102	android/graphics/Bitmap:getWidth	()I
    //   77: aload_1
    //   78: invokevirtual 110	android/graphics/Bitmap:getHeight	()I
    //   81: invokevirtual 121	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   84: aload_0
    //   85: areturn
    //   86: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +28 -> 117
    //   92: ldc 45
    //   94: iconst_2
    //   95: new 47	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   102: ldc 123
    //   104: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aconst_null
    //   118: astore_0
    //   119: goto -35 -> 84
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_1
    //   126: invokevirtual 126	java/lang/OutOfMemoryError:printStackTrace	()V
    //   129: goto -45 -> 84
    //   132: astore_1
    //   133: goto -8 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramString	String
    //   10	68	1	localBitmap	android.graphics.Bitmap
    //   122	4	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   132	1	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   6	11	122	java/lang/OutOfMemoryError
    //   15	61	122	java/lang/OutOfMemoryError
    //   61	70	122	java/lang/OutOfMemoryError
    //   86	117	122	java/lang/OutOfMemoryError
    //   70	84	132	java/lang/OutOfMemoryError
  }
  
  public String Is()
  {
    return "DynamicFaceLayer";
  }
  
  protected boolean Ln()
  {
    return tp() >= 10;
  }
  
  public int RV()
  {
    return 2147483647;
  }
  
  public void Zs(boolean paramBoolean)
  {
    if ((!this.dzz) && (!paramBoolean)) {}
    for (;;)
    {
      return;
      if ((this.oJ != null) && (!this.oJ.isEmpty()))
      {
        Iterator localIterator = this.oJ.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ayjn.b)localIterator.next();
          if ((((ayjn.b)localObject).drawable != null) && ((((ayjn.b)localObject).drawable instanceof URLDrawable)))
          {
            localObject = (URLDrawable)((ayjn.b)localObject).drawable;
            if (localObject != null)
            {
              localObject = ((URLDrawable)localObject).getCurrDrawable();
              if ((localObject != null) && ((localObject instanceof ApngDrawable)) && (((ApngDrawable)localObject).getImage() != null)) {
                if (paramBoolean)
                {
                  this.dzz = true;
                  ApngImage.pauseByTag(13);
                }
                else
                {
                  this.dzz = false;
                  ApngImage.playByTag(13);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(ArrayList<PasterParcelData> paramArrayList, boolean paramBoolean, JSONArray paramJSONArray)
  {
    int i = 0;
    PasterParcelData localPasterParcelData;
    int j;
    label69:
    ayob localayob;
    if (i < paramArrayList.size())
    {
      localPasterParcelData = (PasterParcelData)paramArrayList.get(i);
      if ((localPasterParcelData.eGY == 3) && (!TextUtils.isEmpty(localPasterParcelData.data)))
      {
        if ((this.b.a == null) || (!this.b.a.Lb())) {
          break label436;
        }
        j = 1;
        localayob = aynb.a(BaseApplicationImpl.getContext(), localPasterParcelData.data);
        if (j == 0) {
          break label442;
        }
        paramJSONArray = localayob;
      }
    }
    for (;;)
    {
      label90:
      j = (int)localPasterParcelData.X.left;
      int k = (int)localPasterParcelData.X.right;
      int m = (int)localPasterParcelData.X.top;
      int n = (int)localPasterParcelData.X.bottom;
      ayjn.b localb;
      if (paramJSONArray != null)
      {
        paramJSONArray.setBounds(j, m, k, n);
        ram.d("DynamicFaceLayer", "Create Normal FaceItem.");
        localb = new ayjn.b(this, paramJSONArray, new ayjn.d(localPasterParcelData.centerP.x, localPasterParcelData.centerP.y, localPasterParcelData.scaleValue, localPasterParcelData.nI, localPasterParcelData.translateXValue, localPasterParcelData.translateYValue, (int)localPasterParcelData.width, (int)localPasterParcelData.height), localPasterParcelData.category, localPasterParcelData.name, localPasterParcelData.path, localPasterParcelData.eGY);
        localb.mSegmentKeeper.set(localPasterParcelData.mSegmentKeeper);
        localb.data = localPasterParcelData.data;
        localb.eGZ = localPasterParcelData.eGZ;
        localb.aVB = 0;
        localb.uj = 1;
        localb.dzB = aynb.oB(localayob.getType());
        localb.dzC = aynb.oC(localayob.getType());
        if (localb.dzB)
        {
          this.oK.add(localb);
          if (!TextUtils.isEmpty(localPasterParcelData.location))
          {
            localb.e = new TroopBarPOI("-1", "", localPasterParcelData.location, 0, "", 0, "");
            localb.poiUpdateTime = System.currentTimeMillis();
          }
        }
        if ((this.b.a == null) || (!this.b.a.Lb())) {
          break label470;
        }
        paramJSONArray.setCallback(this.b);
        this.oJ.add(localb);
      }
      for (;;)
      {
        i += 1;
        break;
        label436:
        j = 0;
        break label69;
        label442:
        if (localayob == null) {
          break label526;
        }
        paramJSONArray = new BitmapDrawable(this.context.getResources(), localayob.ba());
        break label90;
        label470:
        localb.eGY = 0;
        paramJSONArray = (ayjn)this.b.a(ayjn.TAG);
        if (paramJSONArray != null) {
          paramJSONArray.oJ.add(localb);
        }
      }
      ThreadManager.post(new DynamicFaceLayer.1(this, paramArrayList), 8, null, false);
      return;
      label526:
      paramJSONArray = null;
    }
  }
  
  public String b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = this.b.mWidth;
    int k = this.b.mHeight;
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 > paramInt2)
    {
      j = paramInt1;
      i = paramInt2;
      if (paramBoolean)
      {
        i = paramInt1;
        j = paramInt2;
      }
    }
    float f1 = this.b.mWidth * 1.0F / this.b.mHeight;
    float f2 = j * 1.0F / i;
    if (f2 != f1) {
      if (f1 > f2)
      {
        j = this.b.mWidth;
        i = Math.round(this.b.mWidth / f2);
        paramInt2 = (i - this.b.mHeight) / 2;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("layerParams=").append(j).append("*").append(i).append(",heightOffset=").append(paramInt2).append(",widthOffset=").append(paramInt1);
        QLog.d("DynamicFaceLayer", 2, ((StringBuilder)localObject).toString());
      }
      if (this.b.a.Lb())
      {
        localObject = new ArrayList();
        Iterator localIterator = this.oJ.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ayjn.b localb = (ayjn.b)localIterator.next();
            DynamicStickerData localDynamicStickerData = new DynamicStickerData();
            localDynamicStickerData.centerP = localb.centerP;
            localDynamicStickerData.scale = localb.scaleValue;
            localDynamicStickerData.rotate = localb.nI;
            localDynamicStickerData.translateX = (localb.translateXValue + paramInt1);
            localDynamicStickerData.translateY = (localb.translateYValue + paramInt2);
            localDynamicStickerData.height = localb.height;
            localDynamicStickerData.width = localb.width;
            localDynamicStickerData.path = localb.path;
            localDynamicStickerData.type = localb.eGY;
            localDynamicStickerData.data = localb.data;
            localDynamicStickerData.layerWidth = j;
            localDynamicStickerData.layerHeight = i;
            localDynamicStickerData.mapMotionTrack = localb.qU;
            localDynamicStickerData.setSegmentList(localb.mSegmentKeeper.getSegmentList());
            localDynamicStickerData.mSegmentKeeper.setAdjustTimeValid(false);
            ((ArrayList)localObject).add(localDynamicStickerData);
            continue;
            j = Math.round(this.b.mHeight * f2);
            i = this.b.mHeight;
            paramInt1 = (j - this.b.mWidth) / 2;
            paramInt2 = 0;
            break;
          }
        }
        if (((ArrayList)localObject).size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DynamicFaceLayer", 2, "generateDynamicStickers|size= " + ((ArrayList)localObject).size());
          }
          return ayon.B((ArrayList)localObject);
        }
      }
      return null;
      j = m;
      i = k;
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
  
  public void b(Canvas paramCanvas, float paramFloat) {}
  
  public void cg(Canvas paramCanvas)
  {
    if (!this.b.a.Lb()) {
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(this.scaleValue, this.scaleValue);
    Iterator localIterator = this.oJ.iterator();
    if (localIterator.hasNext())
    {
      ayjn.b localb = (ayjn.b)localIterator.next();
      Object localObject2 = w(sP(localb.path));
      if (localObject2 != null) {
        ((Drawable)localObject2).setBounds(0, 0, (int)localb.width, (int)localb.height);
      }
      Object localObject1 = localObject2;
      if (localb.eGY == 3)
      {
        localObject1 = localObject2;
        if (localb.drawable != null)
        {
          localObject1 = localObject2;
          if (!(localb.drawable instanceof ayob)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = (ayob)localb.drawable;
          localObject1 = new BitmapDrawable(this.context.getResources(), ((ayob)localObject1).ba());
        }
        catch (Exception localException2)
        {
          try
          {
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            if (localObject1 == null) {
              break;
            }
            paramCanvas.save();
            paramCanvas.concat(this.a.a(localb));
            paramCanvas.save();
            paramCanvas.translate(-localb.width / 2.0F, -localb.height / 2.0F);
            ((Drawable)localObject1).draw(paramCanvas);
            paramCanvas.restore();
            paramCanvas.restore();
          }
          catch (Exception localException1)
          {
            break label244;
          }
          localException2 = localException2;
          localObject1 = localObject2;
          localObject2 = localException2;
        }
        label244:
        QLog.e("DynamicFaceLayer", 1, "saveStaticFrame fail, ", (Throwable)localObject2);
      }
    }
    paramCanvas.restore();
  }
  
  public void clear()
  {
    super.clear();
    this.oK.clear();
  }
  
  public String getTag()
  {
    return "DynamicFaceLayer";
  }
  
  public void onDestroy()
  {
    if (this.oJ != null)
    {
      Iterator localIterator = this.oJ.iterator();
      while (localIterator.hasNext())
      {
        Drawable localDrawable = ((ayjn.b)localIterator.next()).drawable;
        if ((localDrawable instanceof ayol)) {
          ((ayol)localDrawable).pause();
        }
      }
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjl
 * JD-Core Version:    0.7.0.1
 */