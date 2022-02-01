import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.a;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.LinkedList;

public class aqdh
  extends aqdg
  implements FaceDecodeTask.a
{
  private aqdh.a jdField_a_of_type_Aqdh$a;
  private aqdh.b jdField_a_of_type_Aqdh$b;
  private aqdh.c jdField_a_of_type_Aqdh$c;
  private QQAppInterface e;
  
  public aqdh(QQAppInterface paramQQAppInterface)
  {
    this.dYv = 4;
    this.e = paramQQAppInterface;
  }
  
  public void F(AppInterface paramAppInterface)
  {
    if (this.e != paramAppInterface)
    {
      destory();
      if ((paramAppInterface instanceof QQAppInterface)) {
        this.e = ((QQAppInterface)paramAppInterface);
      }
    }
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "getBitmapFromCache, mApp is null");
      }
      return null;
    }
    if ((paramInt1 == 1001) && (paramString != null) && (!GroupIconHelper.kH(paramString))) {}
    for (Object localObject = GroupIconHelper.jy(paramString);; localObject = paramString)
    {
      if ((paramInt1 == 4) && (!apuh.ra(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte = 1;
        }
        paramByte = aqdm.c(paramByte);
        localObject = this.e.a(paramInt1, (String)localObject, paramByte, paramInt2, 100, true);
        localObject = this.e.getBitmapFromCache((String)localObject);
        if ((localObject != null) && (paramInt1 == 1001))
        {
          acdt localacdt = (acdt)this.e.getBusinessHandler(6);
          if ((localacdt != null) && (localacdt.a() != null)) {
            localacdt.a().FV(paramString);
          }
          if (this.jdField_a_of_type_Aqdh$a == null)
          {
            this.jdField_a_of_type_Aqdh$a = new aqdh.a(null);
            this.e.addObserver(this.jdField_a_of_type_Aqdh$a);
          }
        }
        return localObject;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.e == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + paramFaceInfo.toString());
      }
      this.dYw -= 1;
      paramAppInterface = (FaceInfo)this.x.get(paramFaceInfo.BM());
      if (paramAppInterface != null)
      {
        if (this.jdField_a_of_type_Aqdh$b == null)
        {
          this.jdField_a_of_type_Aqdh$b = new aqdh.b(null);
          this.e.addObserver(this.jdField_a_of_type_Aqdh$b);
        }
        aqdf.a(this.e, paramAppInterface);
      }
    } while ((this.mPause) || (this.am.isEmpty()) || (this.dYw >= this.dYv));
    cUQ();
  }
  
  public void a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.e == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompleted, faceInfo=" + paramFaceInfo.toString());
    }
    this.dYw -= 1;
    if ((!this.am.isEmpty()) && (!this.mPause)) {
      cUQ();
    }
    FaceInfo localFaceInfo = (FaceInfo)this.x.remove(paramFaceInfo.BM());
    int j;
    if (localFaceInfo != null)
    {
      j = FaceInfo.dYJ;
      if (paramBitmap == null) {
        break label161;
      }
    }
    label161:
    for (int i = FaceInfo.dYy;; i = FaceInfo.RESULT_FAIL)
    {
      localFaceInfo.kg(j, i);
      if ((this.jdField_a_of_type_Aqdg$a == null) || (paramBitmap == null)) {
        break;
      }
      this.jdField_a_of_type_Aqdg$a.onDecodeTaskCompleted(this.dYw + this.am.size(), paramFaceInfo.aRY, paramFaceInfo.uin, paramBitmap);
      return;
    }
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    byte b = 1;
    if (paramInt3 == 0) {
      if ((paramInt2 != 101) && (paramInt2 != 1001)) {}
    }
    String str;
    for (b = 1;; b = (byte)paramInt3)
    {
      paramInt3 = aqdm.c(b);
      str = FaceInfo.e(paramInt2, paramString, paramInt1);
      FaceInfo localFaceInfo = (FaceInfo)this.x.get(str);
      if ((localFaceInfo == null) || (localFaceInfo.s(FaceInfo.dYB, 300000L))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.cTI) && (!paramBoolean2)) {
        localFaceInfo.cTI = false;
      }
      localFaceInfo.shape = paramInt3;
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3, 100);
    paramString.Xq(FaceInfo.dYB);
    this.x.put(str, paramString);
    d(paramString);
    return true;
  }
  
  public void c(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L) || (this.e == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 202) && (paramInt2 != 204));
      if (paramInt1 == 32) {}
      for (byte b = 1;; b = 0)
      {
        FaceInfo localFaceInfo = new FaceInfo(paramInt1, paramString, false, b, 1, false, paramInt2);
        String str = FaceInfo.e(paramInt1, paramString, paramInt2);
        if (this.s.get(str) == null) {
          this.s.put(str, localFaceInfo);
        }
        if (this.jdField_a_of_type_Aqdh$b == null)
        {
          this.jdField_a_of_type_Aqdh$b = new aqdh.b(null);
          this.e.addObserver(this.jdField_a_of_type_Aqdh$b);
        }
        if (paramInt1 != 32) {
          break;
        }
        this.e.B(paramString, paramInt2, paramLong);
        return;
      }
    } while (paramInt1 != 16);
    this.e.C(paramString, paramInt2, paramLong);
  }
  
  protected void c(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    if (this.e == null) {}
    label177:
    do
    {
      Object localObject;
      do
      {
        Bitmap localBitmap;
        do
        {
          return;
          localObject = FaceInfo.e(paramInt1, paramString, paramInt2);
          if ((paramInt1 == 101) && ((!paramBoolean) || (this.mPause))) {
            break label177;
          }
          localBitmap = a(paramInt1, paramString, paramInt2, (byte)1);
          if (localBitmap == null) {
            break;
          }
          localObject = (FaceInfo)this.x.remove(localObject);
          if (localObject != null) {
            ((FaceInfo)localObject).kg(FaceInfo.dYJ, FaceInfo.dYy);
          }
        } while (this.jdField_a_of_type_Aqdg$a == null);
        this.jdField_a_of_type_Aqdg$a.onDecodeTaskCompleted(this.dYw + this.am.size(), paramInt1, paramString, localBitmap);
        return;
        paramString = (FaceInfo)this.x.get(localObject);
        if (paramString != null)
        {
          d(paramString);
          return;
        }
        paramString = (FaceInfo)this.s.remove(localObject);
      } while (paramString == null);
      paramString.Xq(FaceInfo.dYB);
      this.x.put(localObject, paramString);
      d(paramString);
      return;
      paramString = (FaceInfo)this.x.remove(localObject);
    } while (paramString == null);
    paramInt2 = FaceInfo.dYJ;
    if (!paramBoolean) {}
    for (paramInt1 = FaceInfo.RESULT_FAIL;; paramInt1 = FaceInfo.dYz)
    {
      paramString.kg(paramInt2, paramInt1);
      return;
    }
  }
  
  protected void cUQ()
  {
    Object localObject1 = null;
    if (this.am.isEmpty()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, mReadyRequests is empty");
    }
    label204:
    do
    {
      return;
      try
      {
        localObject2 = (FaceInfo)this.am.removeFirst();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, faceinfo=" + ((FaceInfo)localObject2).toString());
          }
          if (((((FaceInfo)localObject2).aRY == 101) || (((FaceInfo)localObject2).aRY == 1001)) && (this.jdField_a_of_type_Aqdh$a == null))
          {
            this.jdField_a_of_type_Aqdh$a = new aqdh.a(null);
            this.e.addObserver(this.jdField_a_of_type_Aqdh$a);
          }
          if (((((FaceInfo)localObject2).aRY == 4) || (((FaceInfo)localObject2).aRY == 113)) && (!apuh.ra(((FaceInfo)localObject2).uin)))
          {
            if (this.jdField_a_of_type_Aqdh$c == null) {
              this.jdField_a_of_type_Aqdh$c = new aqdh.c(null);
            }
            this.e.addObserver(this.jdField_a_of_type_Aqdh$c);
          }
          this.dYw += 1;
          FaceDecodeTask.a(FaceDecodeTask.a(this.e, (FaceInfo)localObject2, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        break label204;
      }
      if (localObject1 != null) {
        this.dYw -= 1;
      }
    } while (!QLog.isColorLevel());
    ajrk.m("Q.qqhead.FaceDecoderImpl", new Object[] { "runNextTask", localObject2, localObject1 });
  }
  
  public void destory()
  {
    QQAppInterface localQQAppInterface = this.e;
    aqdh.a locala = this.jdField_a_of_type_Aqdh$a;
    aqdh.b localb = this.jdField_a_of_type_Aqdh$b;
    aqdh.c localc = this.jdField_a_of_type_Aqdh$c;
    this.e = null;
    this.jdField_a_of_type_Aqdh$a = null;
    this.jdField_a_of_type_Aqdh$c = null;
    this.jdField_a_of_type_Aqdh$b = null;
    if (localQQAppInterface != null)
    {
      if (locala != null) {
        localQQAppInterface.removeObserver(locala);
      }
      if (localb != null) {
        localQQAppInterface.removeObserver(localb);
      }
      if (localc != null) {
        localQQAppInterface.removeObserver(localc);
      }
    }
    super.destory();
  }
  
  class a
    extends acdv
  {
    private a() {}
    
    protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      if (aqdh.a(aqdh.this) == null) {
        return;
      }
      String str;
      int i;
      if (aqdh.this.a != null)
      {
        if (!GroupIconHelper.kH(paramString)) {
          break label223;
        }
        str = GroupIconHelper.jz(paramString);
        i = 1001;
      }
      for (;;)
      {
        paramString = aqdh.this.a(i, paramString, 0, (byte)1);
        if ((paramBoolean1) && (paramString != null)) {
          if (i != 1001) {
            break label185;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + str + ",type: " + i + ",style: " + -1);
          }
          if ((aqdh.this.mPause) || (aqdh.this.am.isEmpty()) || (aqdh.this.dYw >= aqdh.this.dYv)) {
            break;
          }
          aqdh.this.cUQ();
          return;
          label185:
          aqdh.this.a.onDecodeTaskCompleted(aqdh.this.dYw + aqdh.this.am.size(), i, str, paramString);
        }
        label223:
        i = 101;
        str = paramString;
      }
    }
  }
  
  class b
    extends acfd
  {
    private b() {}
    
    protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      aqdh.this.c(paramBoolean, 1, paramString, 0);
    }
    
    protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
    {
      aqdh.this.c(paramBoolean, 11, paramString, 0);
    }
    
    protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
    {
      aqdh.this.c(paramBoolean1, 16, paramString, paramInt);
    }
    
    protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
    {
      aqdh.this.c(paramBoolean1, 32, paramString, paramInt);
    }
    
    protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      aqdh.this.c(paramBoolean, 4, paramString, 0);
    }
  }
  
  class c
    extends acnd
  {
    private c() {}
    
    protected void h(boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      if (aqdh.a(aqdh.this) == null) {}
      do
      {
        return;
        if (aqdh.this.a != null)
        {
          Bitmap localBitmap = aqdh.this.a(113, paramString, 0, (byte)1);
          if ((paramBoolean1) && (localBitmap != null))
          {
            aqdh.this.a.onDecodeTaskCompleted(aqdh.this.dYw + aqdh.this.am.size(), 113, paramString, localBitmap);
            if (QLog.isColorLevel()) {
              QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateNewTroopFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + 113 + ",style: " + -1);
            }
          }
        }
      } while ((aqdh.this.mPause) || (aqdh.this.am.isEmpty()) || (aqdh.this.dYw >= aqdh.this.dYv));
      aqdh.this.cUQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqdh
 * JD-Core Version:    0.7.0.1
 */