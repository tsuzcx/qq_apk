import android.content.Context;
import android.util.SparseArray;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ije
  extends accg
{
  ije.b jdField_a_of_type_Ije$b = null;
  ije.d jdField_a_of_type_Ije$d = null;
  private ije.a[] jdField_a_of_type_ArrayOfIje$a;
  private ije.c[] jdField_a_of_type_ArrayOfIje$c;
  
  public ije(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static ije a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface == null) {
      return null;
    }
    return (ije)paramVideoAppInterface.getBusinessHandler(3);
  }
  
  private ije.a[] a()
  {
    if (this.jdField_a_of_type_ArrayOfIje$a == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfIje$a == null)
      {
        this.jdField_a_of_type_Ije$b = new ije.b();
        this.jdField_a_of_type_ArrayOfIje$a = new ije.a[this.jdField_a_of_type_Ije$b.cu.length];
      }
      return this.jdField_a_of_type_ArrayOfIje$a;
    }
    finally {}
  }
  
  private ije.c[] a()
  {
    if (this.jdField_a_of_type_ArrayOfIje$c == null) {}
    try
    {
      if (this.jdField_a_of_type_ArrayOfIje$c == null)
      {
        this.jdField_a_of_type_Ije$d = new ije.d();
        this.jdField_a_of_type_ArrayOfIje$c = new ije.c[this.jdField_a_of_type_Ije$d.cu.length];
      }
      return this.jdField_a_of_type_ArrayOfIje$c;
    }
    finally {}
  }
  
  private int e(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Ije$d != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Ije$d.cu.length)
      {
        if (this.jdField_a_of_type_Ije$d.cu[i] == paramInt) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (j == -1)
        {
          String str = acfp.m(2131703006) + paramInt + "]，需要在FrameDataHandlerArray中添加";
          QLog.d("AVDataSender", 1, str);
          throw new IllegalArgumentException(str);
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  private int f(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Ije$b != null)
    {
      i = 0;
      int j = -1;
      while (i < this.jdField_a_of_type_Ije$b.cu.length)
      {
        if (this.jdField_a_of_type_Ije$b.cu[i] == paramInt) {
          j = i;
        }
        i += 1;
      }
      i = j;
      if (paramBoolean)
      {
        i = j;
        if (j == -1)
        {
          String str = acfp.m(2131703008) + paramInt + "]，需要在C2CDataHandlerArray中添加";
          QLog.d("AVDataSender", 1, str);
          throw new IllegalArgumentException(str);
        }
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (int i = 0;; i = paramArrayOfByte.length)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(paramInt2);
      if (i > 0) {
        localByteBuffer.put(paramArrayOfByte);
      }
      VideoController.a().a(paramInt1, localByteBuffer.array());
      return;
    }
  }
  
  public boolean a(int paramInt, ije.a parama)
  {
    ije.a[] arrayOfa = a();
    paramInt = f(paramInt, true);
    if (arrayOfa[paramInt] == null)
    {
      arrayOfa[paramInt] = parama;
      return true;
    }
    ivv.jL("registerC2CDataHandler重复注册");
    return false;
  }
  
  public boolean a(int paramInt, ije.c paramc)
  {
    Object localObject = BaseApplicationImpl.getContext();
    localObject = VideoController.a().a((Context)localObject);
    if (localObject == null)
    {
      ivv.jL("registerFrameDataHandler, EffectController为空");
      return false;
    }
    ((iov)localObject).lm(4);
    localObject = a();
    paramInt = e(paramInt, true);
    if (localObject[paramInt] == null)
    {
      localObject[paramInt] = paramc;
      return true;
    }
    ivv.jL("registerFrameDataHandler重复注册");
    return false;
  }
  
  public boolean b(int paramInt, ije.c paramc)
  {
    paramInt = e(paramInt, true);
    ije.c[] arrayOfc = this.jdField_a_of_type_ArrayOfIje$c;
    if ((arrayOfc != null) && (arrayOfc[paramInt] != null) && (paramc.equals(arrayOfc[paramInt])))
    {
      arrayOfc[paramInt] = null;
      return true;
    }
    ivv.jL("unregisterFrameDataHandler取消注册失败");
    return false;
  }
  
  public boolean b(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfIje$a;
    if (localObject == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = f(paramInt, false);
      } while (i < 0);
      localObject = localObject[i];
    } while (localObject == null);
    return ((ije.a)localObject).c(paramInt, ByteBuffer.wrap(paramArrayOfByte).getInt(), ioh.c(paramArrayOfByte, 4, paramArrayOfByte.length - 4));
  }
  
  public void c(String paramString, byte[] paramArrayOfByte)
  {
    ije.c[] arrayOfc;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      arrayOfc = this.jdField_a_of_type_ArrayOfIje$c;
      if (arrayOfc != null) {}
    }
    else
    {
      return;
    }
    paramArrayOfByte = ioh.a(paramArrayOfByte);
    int i = 0;
    label28:
    int j;
    if (i < paramArrayOfByte.size())
    {
      j = paramArrayOfByte.keyAt(i);
      int k = e(j, false);
      if (k < 0) {
        break label92;
      }
      ije.c localc = arrayOfc[k];
      if (localc != null) {
        localc.a(paramString, (iog)paramArrayOfByte.valueAt(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label92:
      if (AudioHelper.isDev()) {
        QLog.d("AVDataSender", 1, "notifyFrameDataCome, msgType[" + j + "], i[" + i + "]");
      }
    }
  }
  
  public int l(ArrayList<iog> paramArrayList)
  {
    int i = 0;
    ije.c[] arrayOfc = this.jdField_a_of_type_ArrayOfIje$c;
    if (arrayOfc == null) {
      return 0;
    }
    int k;
    for (int j = 0; i < arrayOfc.length; j = k)
    {
      Object localObject = arrayOfc[i];
      k = j;
      if (localObject != null)
      {
        localObject = ((ije.c)localObject).a();
        k = j;
        if (localObject != null)
        {
          paramArrayList.add(localObject);
          k = j + ((iog)localObject).ln();
        }
      }
      i += 1;
    }
    return j;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    if (paramToServiceMsg != null) {
      l = jlc.a(paramToServiceMsg);
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("AVDataSender", 1, "onReceive, serviceCmd[" + "null" + "], seq[" + l + "]");
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean c(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  }
  
  public static class b
  {
    public int[] cu = { 9, 11 };
  }
  
  public static abstract interface c
  {
    public abstract iog a();
    
    public abstract void a(String paramString, iog paramiog);
  }
  
  public static class d
  {
    public int[] cu = { 5 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ije
 * JD-Core Version:    0.7.0.1
 */