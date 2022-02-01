import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.1;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.2;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class vgh
  implements vgx
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private volatile ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private vfy jdField_a_of_type_Vfy;
  private vgv jdField_a_of_type_Vgv;
  private vgw jdField_a_of_type_Vgw;
  private vhc jdField_a_of_type_Vhc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  private long f;
  private long g;
  private long h = -1L;
  private long i;
  private long j;
  private long k;
  
  public vgh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private int a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      try
      {
        paramInt = ((Integer)paramArrayList.get(paramInt)).intValue();
        return paramInt;
      }
      catch (Exception paramArrayList)
      {
        vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][getSpeedFromListCache] e:" + paramArrayList.getMessage());
      }
      paramInt = 0;
    }
    return 0;
  }
  
  private vgu a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    vgu localvgu = this.jdField_a_of_type_Vgw.a();
    localvgu.a(paramString1, paramString2, paramInt1, paramLong, paramInt2, paramBoolean1, paramBoolean2, this.jdField_c_of_type_Boolean, this.jdField_b_of_type_Boolean);
    return localvgu;
  }
  
  private boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + ", mState:" + vgd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    if (h())
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] checkPlayerStartState return true.");
      return false;
    }
    paramString1 = a(paramString1, paramString2, paramInt1, paramLong2, paramInt2, paramBoolean1, paramBoolean2);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_Vgv != null)) {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + ", mState:" + vgd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    try
    {
      this.jdField_a_of_type_Vgv.a(this.jdField_a_of_type_AndroidContentContext, paramLong1, 0, paramString1);
      this.jdField_b_of_type_Long = paramInt2;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      this.e = paramLong1;
      return true;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        vmp.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][innerPlayerStartByUrl] openMediaPlayerByUrl error:" + paramString1.getMessage());
      }
    }
  }
  
  private vhc b()
  {
    if (this.jdField_a_of_type_Vgw == null)
    {
      a();
      if (this.jdField_a_of_type_Vgw == null) {
        return null;
      }
    }
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      vmp.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][createVideoViewScroll]: error, mContext null");
      return null;
    }
    return this.jdField_a_of_type_Vgw.a(this.jdField_a_of_type_AndroidContentContext, VersionUtils.isIceScreamSandwich());
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 20) {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
      }
      return;
    }
  }
  
  private boolean h()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)))
    {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][checkPlayerStartState] not idle or complete state, should't reopen media player mState:" + vgd.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
      return true;
    }
    return false;
  }
  
  private void l()
  {
    this.jdField_a_of_type_Vgw = vhe.a().a();
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if ((localView instanceof IVideoViewBase)) {
        ((IVideoViewBase)localView).doCacheSurfaceTexture();
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if ((localView instanceof IVideoViewBase)) {
        ((IVideoViewBase)localView).doRecoverSurfaceTexture();
      }
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Vgv != null) {
      return this.jdField_a_of_type_Vgv.a();
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Vgv == null) {
      return 0L;
    }
    return this.jdField_a_of_type_Vgv.b();
  }
  
  public long a(boolean paramBoolean)
  {
    long l2 = this.jdField_c_of_type_Long;
    if (paramBoolean)
    {
      l1 = b();
      if (l1 - this.e <= 0L) {
        break label70;
      }
    }
    label70:
    for (long l1 = l1 - this.e + l2;; l1 = l2)
    {
      vmp.g("WS_VIDEO_PLAY_TIME", "[WSPlayerWrapper.java][getTotalPlayTime] result:" + l1);
      return l1;
      l1 = a();
      break;
    }
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public vgv a()
  {
    return this.jdField_a_of_type_Vgv;
  }
  
  public vhc a()
  {
    if (this.jdField_a_of_type_Vhc == null) {}
    try
    {
      if (this.jdField_a_of_type_Vhc == null) {
        this.jdField_a_of_type_Vhc = b();
      }
      if (this.jdField_a_of_type_Vhc != null)
      {
        View localView = this.jdField_a_of_type_Vhc.a();
        if (localView != null) {
          a(localView);
        }
      }
      return this.jdField_a_of_type_Vhc;
    }
    finally {}
  }
  
  public void a()
  {
    l();
    if ((this.jdField_a_of_type_Vgw != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][initMediaPlayer] success!");
      this.jdField_a_of_type_Vgv = this.jdField_a_of_type_Vgw.a(this.jdField_a_of_type_AndroidContentContext, null);
      this.jdField_a_of_type_Vgv.b(false);
      this.jdField_a_of_type_Vgv.a(this);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Vgv != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      if (l1 - this.e > 0L)
      {
        long l2 = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = (l1 - this.e + l2);
      }
      this.e = paramInt;
      this.jdField_a_of_type_Vgv.b(paramInt);
      this.jdField_a_of_type_Boolean = true;
      vmp.g("WS_VIDEO_PLAY_TIME", "[WSPlayerWrapper.java][seekTo] mTotalPlayTime:" + this.jdField_c_of_type_Long + ", mLastPlayPosition:" + this.e);
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    boolean bool = true;
    this.k = paramLong;
    c(paramInt);
    try
    {
      if (new JSONObject(paramString).optInt("hitDownloaded") == 1) {}
      for (;;)
      {
        this.jdField_d_of_type_Boolean = bool;
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      m();
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][removeVideoViewFromParent] remove scroll view parents!");
      n();
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_b_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.a(this, paramString);
    }
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new JSONObject(paramString);
        long l = ((JSONObject)localObject).getLong("fileSize");
        int m = ((JSONObject)localObject).getInt("speedKBS");
        int n = ((JSONObject)localObject).getInt("offset");
        i1 = ((JSONObject)localObject).getInt("callBackType");
        if (l > 0L) {
          this.k = l;
        }
        if (i1 == 2)
        {
          c(m);
          if (n <= 0) {
            break;
          }
          this.j = n;
          return;
        }
        if (i1 == 1)
        {
          this.jdField_a_of_type_JavaLangString = paramString;
          localObject = ((JSONObject)localObject).optString("contentType");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.jdField_b_of_type_JavaLangString = ((String)localObject);
          }
          if (this.jdField_a_of_type_Vfy == null) {
            continue;
          }
          this.jdField_a_of_type_Vfy.b(this, paramString);
          continue;
        }
        if (i1 == 7) {}
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      if ((i1 == 50) && (this.jdField_a_of_type_Vfy != null)) {
        this.jdField_a_of_type_Vfy.c(this);
      }
    }
  }
  
  public void a(vfy paramvfy)
  {
    this.jdField_a_of_type_Vfy = paramvfy;
  }
  
  public void a(vgv paramvgv)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onVideoPrepared] streamDumpInfo:" + paramvgv.a());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.a(this, this.jdField_b_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_Vgv != null) {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_Vgv.a();
    }
    ThreadManager.post(new WSPlayerWrapper.1(this, paramvgv), 5, null, false);
  }
  
  public void a(vgv paramvgv, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(vgv paramvgv, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(vhc paramvhc)
  {
    if (this.jdField_a_of_type_Vgv == null) {
      return;
    }
    this.jdField_a_of_type_Vhc = paramvhc;
    this.jdField_a_of_type_Vgv.a(paramvhc);
    this.jdField_a_of_type_Vgv.a(this.jdField_a_of_type_Int);
  }
  
  public void a(vhc paramvhc, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Vgv == null) || (paramViewGroup == null)) {
      return;
    }
    this.jdField_a_of_type_Vgv.a(paramvhc, paramViewGroup);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, null);
  }
  
  public boolean a(vgv paramvgv, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    vmp.d("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onError]!!");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(vgv paramvgv, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Vfy != null) {
        this.jdField_a_of_type_Vfy.a(this, paramInt, paramObject);
      }
      return false;
      vmp.g("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onInfo] start buffering ===> isSeeking:" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      }
      this.f = System.currentTimeMillis();
      continue;
      vmp.g("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onInfo] end buffering <=== isSeeking:" + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      }
      if (this.jdField_a_of_type_Boolean) {
        continue;
      }
      this.jdField_c_of_type_Int += 1;
      this.g += System.currentTimeMillis() - this.f;
      continue;
      if (!(paramObject instanceof String)) {
        continue;
      }
      try
      {
        m = new JSONObject((String)paramObject).optInt("skipFrameCount", 1);
        if (m <= 0) {
          continue;
        }
        this.jdField_b_of_type_Int = (m + this.jdField_b_of_type_Int);
      }
      catch (JSONException paramvgv)
      {
        for (;;)
        {
          paramvgv.printStackTrace();
          int m = 0;
        }
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Vgv != null) {
      return this.jdField_a_of_type_Vgv.b();
    }
    return -1;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      return this.jdField_a_of_type_Long;
    }
    if (this.jdField_a_of_type_Vgv != null)
    {
      if (this.jdField_a_of_type_Vgv.a() > 0L) {
        return this.jdField_a_of_type_Vgv.a();
      }
      return this.jdField_b_of_type_Long;
    }
    return -1L;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vgv != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_Vgv.a();
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][start]");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Vgv != null) {
      this.jdField_a_of_type_Vgv.a(paramInt);
    }
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][setXYAxis] value:" + paramInt);
  }
  
  public void b(vgv paramvgv)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.a(this);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    if (this.jdField_a_of_type_Vgv != null) {
      ThreadManager.executeOnSubThread(new WSPlayerWrapper.2(this, this.jdField_a_of_type_Vgv));
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Vhc != null))
    {
      ??? = this.jdField_a_of_type_Vhc.a();
      if ((??? != null) && (((View)???).getParent() != null))
      {
        ViewParent localViewParent = ((View)???).getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView((View)???);
        }
      }
    }
    this.jdField_a_of_type_Vfy = null;
    this.jdField_a_of_type_Vhc = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      this.h = 0L;
      this.j = 0L;
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][destroy]");
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Vgv != null) {
      return this.jdField_a_of_type_Vgv.a();
    }
    return false;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long c()
  {
    return this.k;
  }
  
  public String c()
  {
    for (;;)
    {
      int m;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          Object localObject2 = new StringBuilder();
          int n = Math.min(20, this.jdField_a_of_type_JavaUtilArrayList.size());
          m = 0;
          if (m < n)
          {
            ((StringBuilder)localObject2).append(a(this.jdField_a_of_type_JavaUtilArrayList, m));
            if (m != n - 1) {
              ((StringBuilder)localObject2).append(",");
            }
          }
          else
          {
            localObject2 = ((StringBuilder)localObject2).toString();
            return localObject2;
          }
        }
        else
        {
          return "";
        }
      }
      m += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Vgv != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      this.jdField_a_of_type_Vgv.b();
    }
  }
  
  public void c(vgv paramvgv)
  {
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][onSeekComplete] isPause:" + c());
    if (this.jdField_a_of_type_Vfy != null) {
      this.jdField_a_of_type_Vfy.b(this);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      ThreadManager.excute(new WSPlayerWrapper.3(this, paramBoolean), 16, null, false);
    }
    while ((this.jdField_a_of_type_Vgv == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 6) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)) {
      return;
    }
    this.jdField_a_of_type_Vgv.a(paramBoolean);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Vgv != null) {
      return this.jdField_a_of_type_Vgv.b();
    }
    return false;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long d()
  {
    return this.i;
  }
  
  @WorkerThread
  public void d()
  {
    if (this.jdField_a_of_type_Vgv == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
    {
      vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop] player had destroyed! return!");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.jdField_a_of_type_Vgv.c();
    vmp.e("WS_VIDEO_PLAYER", "[WSPlayerWrapper.java][stop]");
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long e()
  {
    return this.g;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Vgv != null) {
      this.jdField_a_of_type_Vgv.e();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public long f()
  {
    return this.jdField_d_of_type_Long + a(d());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Vgv != null) {
      this.jdField_a_of_type_Vgv.f();
    }
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long g()
  {
    if (this.h == -1L) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int i1 = Math.min(10, this.jdField_a_of_type_JavaUtilArrayList.size());
        int m = 0;
        int n = 0;
        while (m < i1)
        {
          n += ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(m)).intValue();
          m += 1;
        }
        if (i1 != 0) {
          this.h = (n / i1);
        }
      }
      return this.h;
    }
  }
  
  public void g()
  {
    b(true);
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public long h()
  {
    long l1 = -1L;
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    long l2 = l1;
    for (;;)
    {
      int m;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          l2 = l1;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            int n = this.jdField_a_of_type_JavaUtilArrayList.size();
            m = 0;
            l2 = l1;
            if (m < n)
            {
              int i1 = a(this.jdField_a_of_type_JavaUtilArrayList, m);
              if (m == 0)
              {
                l1 = i1;
                break label105;
              }
              l1 = Math.min(i1, l1);
              break label105;
            }
          }
        }
        return l2;
      }
      finally {}
      label105:
      m += 1;
    }
  }
  
  public void h()
  {
    this.jdField_d_of_type_Long += a(d());
    this.e = a();
    this.jdField_c_of_type_Long = 0L;
  }
  
  public long i()
  {
    long l1 = -1L;
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    long l2 = l1;
    for (;;)
    {
      int m;
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          l2 = l1;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
          {
            int n = this.jdField_a_of_type_JavaUtilArrayList.size();
            m = 0;
            l2 = l1;
            if (m < n)
            {
              int i1 = a(this.jdField_a_of_type_JavaUtilArrayList, m);
              if (m == 0)
              {
                l1 = i1;
                break label105;
              }
              l1 = Math.max(i1, l1);
              break label105;
            }
          }
        }
        return l2;
      }
      finally {}
      label105:
      m += 1;
    }
  }
  
  public void i()
  {
    long l1 = 0L;
    long l2 = b();
    if (l2 - this.e > 0L) {
      l1 = l2 - this.e;
    }
    this.jdField_c_of_type_Long = (l1 + this.jdField_c_of_type_Long);
    vmp.g("WS_VIDEO_PLAY_TIME", "[WSPlayerWrapper.java][addTotalPlayTimeForLoop] mTotalPlayTime:" + this.jdField_c_of_type_Long);
  }
  
  public long j()
  {
    long l2 = 0L;
    long l3 = this.i;
    long l1 = l2;
    if (l3 > 0L)
    {
      l1 = l2;
      if (this.j > 0L) {
        l1 = this.j / l3;
      }
    }
    return l1;
  }
  
  public void j()
  {
    this.e = 0L;
  }
  
  public void k()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.e = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.f = 0L;
    this.g = 0L;
    this.jdField_c_of_type_Int = 0;
    this.i = 0L;
    this.k = 0L;
    this.h = -1L;
    this.j = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgh
 * JD-Core Version:    0.7.0.1
 */