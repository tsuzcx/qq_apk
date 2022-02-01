import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.1;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.12;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.13;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.2;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.6;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.7;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.8;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.9;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.c;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituRequest;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.zhitu.gate.ZhituSafeGate.ReqBody;

public class ykm
  implements Handler.Callback, Manager, yla.c
{
  private static int bZz;
  private static volatile boolean bhW;
  private static volatile boolean mUsed;
  private long Kg;
  public ZhituPanelView.c a;
  public ZhituPanelView a;
  public DoutuEmotionHorizonListView a;
  private BlockingDeque<ykw> jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque();
  private ykm.a jdField_a_of_type_Ykm$a;
  private ykm.c jdField_a_of_type_Ykm$c;
  private yks jdField_a_of_type_Yks;
  public yku a;
  private String aYp = "";
  private int bZA;
  private int bZB;
  private int bZC = 0;
  private final int bZD = 180;
  private int bZE = 180;
  private Handler bm;
  private boolean bmT;
  private boolean bmU;
  private boolean bmV = true;
  private boolean bmW;
  private boolean bmX;
  private boolean bmY;
  private boolean bmZ;
  private Typeface g;
  private Map<String, String> hZ = new HashMap();
  public LinearLayout hs;
  private Map<String, String> ia = new HashMap();
  private Map<String, ZhituResponse> ib = new HashMap();
  private Map<File, Boolean> ic;
  private Executor m;
  private AppInterface mApp;
  private volatile int mCurType;
  private volatile String mCurrentText = "";
  private Handler mMainHandler = new ykr(this, Looper.getMainLooper());
  private HandlerThread mThread;
  private List<aoll> sJ = new LinkedList();
  private List<String> sK = new LinkedList();
  
  public ykm(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    ciY();
  }
  
  private void Aa(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.size() == 0) {}
    long l;
    LinkedList localLinkedList;
    do
    {
      return;
      l = System.currentTimeMillis();
      localLinkedList = new LinkedList();
      while ((!this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.isEmpty()) && ((localLinkedList.size() <= 100) || (!paramBoolean))) {
        localLinkedList.add(this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.poll());
      }
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        ZhituReportMsg.ReqBody localReqBody = ((ykw)localIterator.next()).a();
        if (localReqBody != null)
        {
          NewIntent localNewIntent = new NewIntent(this.mApp.getApp(), ykz.class);
          localNewIntent.putExtra("ZhituCMD", "MQInference.ZhituReport");
          localNewIntent.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
          this.mApp.startServlet(localNewIntent);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "send " + localLinkedList.size() + " reports, take " + Long.toString(System.currentTimeMillis() - l));
  }
  
  public static void Ae(boolean paramBoolean)
  {
    if (bhW == paramBoolean) {
      return;
    }
    try
    {
      bhW = paramBoolean;
      return;
    }
    finally {}
  }
  
  private boolean TR()
  {
    return this.bmX;
  }
  
  public static boolean TS()
  {
    try
    {
      boolean bool = bhW;
      return bool;
    }
    finally {}
  }
  
  @Nullable
  private Rect a(String paramString, ZhituImgResponse paramZhituImgResponse)
  {
    Rect localRect = new Rect();
    String[] arrayOfString = paramZhituImgResponse.coord.split("\\|");
    try
    {
      localRect.left = Integer.parseInt(arrayOfString[0]);
      localRect.top = Integer.parseInt(arrayOfString[1]);
      localRect.right = (localRect.left + Integer.parseInt(arrayOfString[2]));
      int i = localRect.top;
      localRect.bottom = (Integer.parseInt(arrayOfString[3]) + i);
      return localRect;
    }
    catch (Exception localException)
    {
      QLog.d("ZhituManager", 1, u(paramString, "startImgGenerate", "unknown rect format: " + paramZhituImgResponse.coord));
    }
    return null;
  }
  
  public static AbstractGifImage a(String paramString)
  {
    paramString = BaseApplicationImpl.sImageCache.get(paramString);
    if ((paramString instanceof Pair)) {
      return (AbstractGifImage)((Pair)paramString).first;
    }
    return null;
  }
  
  private File a(ZhituImgResponse paramZhituImgResponse)
  {
    return a(w(), paramZhituImgResponse);
  }
  
  private File a(File paramFile, ZhituImgResponse paramZhituImgResponse)
  {
    return new File(paramFile, a(paramZhituImgResponse));
  }
  
  @NonNull
  private String a(ZhituImgResponse paramZhituImgResponse)
  {
    return atad.toMD5(paramZhituImgResponse.url) + "_" + paramZhituImgResponse.md5;
  }
  
  static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return u(paramString1, paramString2, "[" + paramInt + "]" + paramString3);
  }
  
  public static ykm a(AppInterface paramAppInterface)
  {
    return (ykm)paramAppInterface.getManager(258);
  }
  
  private void a(int paramInt1, ZhituResponse paramZhituResponse, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, u(paramString1, "onResponse", "error code: " + paramInt1 + " / " + paramZhituResponse + " startIdx: " + paramInt2));
    }
    if (paramInt1 != 0) {
      return;
    }
    a(paramString1, paramZhituResponse);
    a(paramZhituResponse, paramString1, paramInt2, paramString2);
  }
  
  private void a(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    if (!paramString1.equals(pE()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, u(paramString1, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ykv localykv = new ykv();
    localykv.drawable = new BitmapDrawable(this.mApp.getApp().getResources(), paramBitmap2);
    if (paramBitmap1 != null)
    {
      paramBitmap1 = new BitmapDrawable(this.mApp.getApp().getResources(), paramBitmap1);
      localykv.ea = paramBitmap1;
      localykv.isGif = false;
      if (paramInt != 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      localykv.isChecked = bool;
      localykv.bne = paramBoolean;
      a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, localykv);
      g(localykv);
      return;
      paramBitmap1 = null;
      break;
    }
  }
  
  private void a(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new ykp(this));
    b(paramMessageQueue);
  }
  
  private void a(AbstractGifImage paramAbstractGifImage, yla.a parama, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!paramString3.equals(pE()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, u(paramString3, "notifyImgProcessFinished", "notifyImgProcessFinished but the reqKey is outdated"));
      }
      return;
    }
    ykv localykv = new ykv();
    localykv.b = parama;
    localykv.isGif = true;
    localykv.gJ = paramString1;
    localykv.path = paramString2;
    localykv.bnc = true;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localykv.isChecked = bool;
      a(paramString3, paramInt, paramString4, paramString5, paramString6, paramString7, localykv);
      parama = b(localykv);
      a(parama, paramAbstractGifImage);
      if (this.bm != null) {
        this.bm.post(new ZhituManager.8(this, parama));
      }
      g(localykv);
      return;
    }
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = paramZhituResponse.list;
    if (localObject == null)
    {
      QLog.d("ZhituManager", 1, u(paramString1, "handleZhituResponse", "the list is null"));
      if (paramInt == 0) {
        yM(this.mApp.getApp().getResources().getString(2131721958));
      }
    }
    int i;
    do
    {
      return;
      this.ib.put(paramString1, paramZhituResponse);
      if ((paramInt == 0) && (((List)localObject).isEmpty()))
      {
        yM(this.mApp.getApp().getResources().getString(2131721958));
        return;
      }
      i = Math.min(((List)localObject).size(), wS() + paramInt);
      if (!a(paramZhituResponse, (List)localObject, paramInt, i, paramString1, paramString2))
      {
        QLog.d("ZhituManager", 1, u(paramString1, "handleZhituResponse", "fail to start download"));
        return;
      }
      localObject = this.mMainHandler.obtainMessage(6);
      ((Message)localObject).arg1 = (i - paramInt);
      if (paramInt == 0) {
        ((Message)localObject).arg1 += 1;
      }
      ((Message)localObject).arg2 = paramZhituResponse.hasMore;
      ((Message)localObject).obj = paramString1;
      this.mMainHandler.sendMessage((Message)localObject);
    } while (paramInt != 0);
    this.m.execute(new ZhituManager.9(this, paramZhituResponse, paramString1, i, paramString2));
  }
  
  private void a(ZhituResponse paramZhituResponse, String paramString1, AppInterface paramAppInterface, int paramInt, ZhituImgResponse paramZhituImgResponse, String paramString2, Bundle paramBundle)
  {
    int i = 1;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putParcelable("ZhituRespose", paramZhituResponse);
    localBundle.putParcelable("ImgResponse", paramZhituImgResponse);
    localBundle.putString("ReqUniqueKey", paramString1);
    localBundle.putInt("IdxInRes", paramInt);
    localBundle.putString("QueryText", paramString2);
    localBundle.putLong("StartTs", System.currentTimeMillis());
    paramZhituResponse = a(paramZhituImgResponse);
    if (paramZhituResponse.exists())
    {
      calcMD5(paramZhituResponse.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "md5 matched, the origin img is downloaded and just skip download."));
      }
      if (this.bZC != 2)
      {
        boolean bool = paramZhituResponse.setLastModified(System.currentTimeMillis());
        if ((this.bZC == 0) && (QLog.isColorLevel())) {
          QLog.d("ZhituManager", 2, "set last modified time is supported? " + bool);
        }
        if (!bool) {
          break label223;
        }
      }
      label223:
      for (paramInt = i;; paramInt = 2)
      {
        this.bZC = paramInt;
        paramZhituResponse = this.bm.obtainMessage(3);
        paramZhituResponse.obj = localBundle;
        this.bm.sendMessage(paramZhituResponse);
        return;
      }
    }
    if (this.jdField_a_of_type_Ykm$a == null) {
      this.jdField_a_of_type_Ykm$a = new ykm.a(this.bm);
    }
    paramZhituImgResponse = paramZhituImgResponse.url;
    paramAppInterface = paramAppInterface.getNetEngine(0);
    paramString2 = new aoll();
    paramString2.cMG = true;
    paramString2.cMK = true;
    paramString2.f = this.jdField_a_of_type_Ykm$a;
    paramString2.mHttpMethod = 0;
    paramString2.bZ = paramZhituImgResponse;
    paramString2.atY = paramZhituResponse.getAbsolutePath();
    paramString2.dPo = 0;
    paramString2.bw(localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startEachImgDownloadRequest", paramInt, "start send img download request, " + paramZhituImgResponse));
    }
    this.sJ.add(paramString2);
    paramAppInterface.a(paramString2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, ZhituRequest paramZhituRequest, int paramInt, Handler paramHandler)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), ykz.class);
    String str = aqec.convert2JSON(paramZhituRequest).toString();
    localNewIntent.putExtra("ZhituCMD", "AIMessage.Text2Image");
    localNewIntent.putExtra("ZhituRequestBytes", str.getBytes());
    a(localNewIntent, paramHandler);
    localNewIntent.putExtra("ZhituReqKey", paramString);
    localNewIntent.putExtra("StartIdx", paramInt);
    localNewIntent.putExtra("QueryText", paramZhituRequest.text);
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, u(paramString, "realSendZhituRequest", "send request: " + paramZhituRequest));
    }
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X800ADCB", "0X800ADCB", 0, 0, "", "", paramZhituRequest.text, "");
  }
  
  public static void a(OutOfMemoryError paramOutOfMemoryError)
  {
    annt.e(paramOutOfMemoryError, "ZhituCreateBitmapCatchedExceptionOOM when create bitmap with count: " + bZz);
    QLog.d("ZhituManager", 1, "create bitmap but oom, " + bZz);
  }
  
  private void a(String paramString, int paramInt, ZhituImgResponse paramZhituImgResponse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "passThroughOriginImg", paramInt, "start"));
    }
    String str = paramZhituImgResponse.url;
    if (".gif".equalsIgnoreCase(str.substring(str.lastIndexOf(".")))) {
      try
      {
        str = a(paramZhituImgResponse).getAbsolutePath();
        a(new NativeGifImage(new File(str), false), null, str, str, paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
        return;
      }
      catch (IOException paramZhituImgResponse)
      {
        QLog.e("ZhituManager", 1, u(paramString, "passThroughOriginImg", "convert to gif drawable fail"));
        return;
      }
    }
    a(null, BitmapFactory.decodeFile(a(paramZhituImgResponse).getAbsolutePath()), paramString, paramInt, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass, false);
  }
  
  private void a(String paramString1, int paramInt1, ZhituResponse paramZhituResponse, ZhituImgResponse paramZhituImgResponse, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "startImgGenerate", paramInt1, "start"));
    }
    bZz += 1;
    String str = paramZhituImgResponse.url;
    Object localObject = str.substring(str.lastIndexOf("."));
    Rect localRect = a(paramString1, paramZhituImgResponse);
    if (localRect == null) {
      return;
    }
    str = a(paramZhituImgResponse).getAbsolutePath();
    long l = System.currentTimeMillis();
    if (".gif".equalsIgnoreCase((String)localObject)) {}
    for (;;)
    {
      int i;
      try
      {
        if (wQ() != 1) {
          continue;
        }
        i = 1;
      }
      catch (IOException paramZhituResponse)
      {
        QLog.e("ZhituManager", 1, a(paramString1, "startImgGenerate", paramInt1, "open gif file fail, " + paramZhituResponse));
        return;
        i = 0;
        break label604;
        localObject = new NativeGifImage(new File(str), false);
        a((AbstractGifImage)localObject, yla.a().a(((NativeGifImage)localObject).getWidth(), ((NativeGifImage)localObject).getHeight(), paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.g), str, null, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
        return;
      }
      catch (OutOfMemoryError paramString1)
      {
        a(paramString1);
        return;
      }
      localObject = new ykk(new File(str), false, 0.0F);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "get width: " + paramInt1 + " / " + ((ykk)localObject).getWidth() + " / " + ((ykk)localObject).getRealWidth());
      }
      paramZhituResponse = yla.a().a(((ykk)localObject).getWidth(), ((ykk)localObject).getHeight(), paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.g);
      ((ykk)localObject).a(paramZhituResponse);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "generateGifImage", paramInt1, "take time " + Long.toString(System.currentTimeMillis() - l)));
      }
      a((AbstractGifImage)localObject, paramZhituResponse, str, null, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass);
      return;
      try
      {
        localObject = BitmapFactory.decodeFile(str);
        if (localObject == null)
        {
          QLog.e("ZhituManager", 1, a(paramString1, "generateZhitu", paramInt1, "decode bitmap fail"));
          return;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        QLog.e("ZhituManager", 1, "decode origin file but oom");
        return;
      }
      paramZhituResponse = yla.a().a(str, paramString2, paramZhituResponse.tokens, paramZhituImgResponse.textColor, localRect, paramInt2, paramString1, paramInt1, this.g);
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, a(paramString1, "generateBitmap", paramInt1, "take time " + Long.toString(System.currentTimeMillis() - l)));
      }
      if (paramZhituResponse == null) {
        break;
      }
      a((Bitmap)localObject, paramZhituResponse, paramString1, paramInt1, paramZhituImgResponse.url, paramZhituImgResponse.md5, paramZhituImgResponse.style, paramZhituImgResponse.pass, false);
      return;
      label604:
      if (paramInt1 != 0) {
        if (i == 0) {}
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, ykv paramykv)
  {
    paramykv.aYv = paramString1;
    paramykv.bZJ = paramInt;
    paramykv.url = paramString2;
    paramykv.pic_md5 = paramString3;
    paramString1 = new ykw();
    paramString1.aYx = paramString3;
    paramString1.auy = paramString4;
    paramString1.pass = paramString5;
    paramString1.aYy = cN(this.mCurType);
    paramString1.aYz = getCurrentText();
    paramykv.a = paramString1;
  }
  
  private void a(String paramString, AbstractGifImage paramAbstractGifImage)
  {
    paramAbstractGifImage = new Pair(paramAbstractGifImage, Integer.valueOf(paramAbstractGifImage.getByteSize()));
    BaseApplicationImpl.sImageCache.put(paramString, paramAbstractGifImage);
  }
  
  private void a(String paramString, ZhituResponse paramZhituResponse)
  {
    List localList = paramZhituResponse.list;
    if (localList == null)
    {
      QLog.d("ZhituManager", 1, u(paramString, "removeDuplicateImg", "the list is null"));
      return;
    }
    HashSet localHashSet = new HashSet(localList.size());
    ArrayList localArrayList = new ArrayList(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      if (!localHashSet.add(localList.get(i))) {
        if (QLog.isColorLevel()) {
          QLog.e("ZhituManager", 2, u(paramString, "removeDuplicateImg", "find duplication res: " + localList.get(i)));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localList.get(i));
      }
    }
    paramZhituResponse.list = localArrayList;
  }
  
  private void a(NewIntent paramNewIntent, Handler paramHandler)
  {
    if (this.jdField_a_of_type_Yks == null) {
      this.jdField_a_of_type_Yks = new yks(paramHandler);
    }
    paramNewIntent.setObserver(this.jdField_a_of_type_Yks);
  }
  
  private boolean a(ZhituResponse paramZhituResponse, List<ZhituImgResponse> paramList, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, u(paramString1, "startImgDownload", "start / end idx: " + paramInt1 + " / " + paramInt2));
    }
    Object localObject = w();
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      QLog.d("ZhituManager", 1, u(paramString1, "startImgDownload", "can not create dir."));
      return false;
    }
    try
    {
      n((File)localObject);
      label98:
      int i;
      if (paramInt1 == 0) {
        i = 0;
      }
      while (paramInt1 < paramInt2)
      {
        localObject = (ZhituImgResponse)paramList.get(paramInt1 + i);
        a(paramZhituResponse, paramString1, this.mApp, paramInt1, (ZhituImgResponse)localObject, paramString2, null);
        paramInt1 += 1;
        continue;
        i = -1;
      }
      return true;
    }
    catch (IOException localIOException)
    {
      break label98;
    }
  }
  
  private void av(Message paramMessage)
  {
    Object localObject = (Bundle)paramMessage.obj;
    paramMessage = ((Bundle)localObject).getString("ReqUniqueKey");
    if (!pE().equals(paramMessage)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, u(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "reqKey is outdated, skip."));
      }
    }
    ZhituResponse localZhituResponse;
    ZhituImgResponse localZhituImgResponse;
    int j;
    do
    {
      return;
      localZhituResponse = (ZhituResponse)((Bundle)localObject).getParcelable("ZhituRespose");
      localZhituImgResponse = (ZhituImgResponse)((Bundle)localObject).getParcelable("ImgResponse");
      j = ((Bundle)localObject).getInt("IdxInRes");
      localObject = ((Bundle)localObject).getString("QueryText");
      if ((localZhituResponse != null) && (localZhituImgResponse != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, u(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", "originResponse or originImgResponse is null, skip."));
    return;
    int k = bP(localZhituImgResponse.style);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramMessage, "MSG_WHAT_IMG_DOWNLOAD_SUCC", j, "style is " + k));
    }
    if (wQ() == 1) {}
    for (int i = 1; k != 2; i = 0)
    {
      this.m.execute(new ZhituManager.6(this, paramMessage, j, localZhituResponse, localZhituImgResponse, k, (String)localObject));
      return;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "zhitutest handleImgDownloadSucc key = " + paramMessage + " |idxinRes = " + j + " | originQueryText = " + (String)localObject);
      }
      if (a(paramMessage, localZhituImgResponse) != null)
      {
        this.m.execute(new ZhituManager.7(this, paramMessage, j, localZhituResponse, localZhituImgResponse, k, (String)localObject));
        return;
      }
      a(paramMessage, j, localZhituImgResponse);
      return;
    }
    a(paramMessage, j, localZhituImgResponse);
  }
  
  private void aw(Message paramMessage)
  {
    int i = paramMessage.arg1;
    paramMessage = (String)paramMessage.obj;
    if (TextUtils.isEmpty(paramMessage)) {}
    ZhituResponse localZhituResponse;
    do
    {
      do
      {
        return;
        if (paramMessage.equals(pE())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ZhituManager", 2, u(paramMessage, "MSG_WHAT_REQUEST_MORE_IMG", "more img key is not the last req key, stop."));
      return;
      localZhituResponse = (ZhituResponse)this.ib.get(paramMessage);
    } while (localZhituResponse == null);
    a(localZhituResponse, paramMessage, i, getCurrentText());
  }
  
  @Nullable
  static Bitmap b(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a(localOutOfMemoryError);
    }
    return null;
  }
  
  private void b(MessageQueue paramMessageQueue)
  {
    paramMessageQueue.addIdleHandler(new ykq(this));
  }
  
  private void b(ZhituResponse paramZhituResponse, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString1, "generateFullTextZhitu", paramInt, ""));
    }
    Bitmap localBitmap = b(200, 200);
    if (localBitmap == null) {}
    do
    {
      return;
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setColor(-1);
      Rect localRect = new Rect(0, 0, 200, 200);
      localCanvas.drawRect(localRect, localPaint);
      paramZhituResponse = yla.a().a(localBitmap, paramString2, paramZhituResponse.tokens, "#000000", localRect, 3, paramString1, paramInt, this.g);
      if (paramZhituResponse != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "generate full text zhitu fail");
    return;
    a(null, paramZhituResponse, paramString1, paramInt, "http://img.qq.com/zhitu/fulltext.jpg", "mario" + System.currentTimeMillis(), "WhiteBack", null, true);
  }
  
  private void bB(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("ReqUniqueKey");
    if (!pE().equals(str1)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, u(str1, "retryFailDownload", "reqKey is outdated, skip."));
      }
    }
    int i;
    int j;
    do
    {
      return;
      i = paramBundle.getInt("RetryCount", 0);
      j = paramBundle.getInt("IdxInRes");
      str1 = paramBundle.getString("ReqUniqueKey");
      if (i < 3) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, u(str1, "retryFailDownload", "max retry limitation is reached."));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, u(str1, "retryFailDownload", "current retry count is " + i));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, u(str1, "retryFailDownload", "retry img download"));
    }
    paramBundle.putInt("RetryCount", i + 1);
    ZhituResponse localZhituResponse = (ZhituResponse)paramBundle.getParcelable("ZhituRespose");
    ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)paramBundle.getParcelable("ImgResponse");
    String str2 = paramBundle.getString("QueryText");
    paramBundle.remove("ErrorCode");
    a(localZhituResponse, str1, this.mApp, j, localZhituImgResponse, str2, paramBundle);
  }
  
  private int bP(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      switch (i)
      {
      }
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ZhituManager", 2, "img response has invalid style");
    }
    return 2;
    return 0;
    return 1;
    return 2;
  }
  
  private void bg(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "realSendZhituSafeGateRequest start");
    }
    ZhituSafeGate.ReqBody localReqBody = new ZhituSafeGate.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(paramQQAppInterface.getCurrentUin()));
    localReqBody.uint32_src_term.set(3);
    paramQQAppInterface = new NewIntent(this.mApp.getApp(), ykz.class);
    paramQQAppInterface.putExtra("ZhituCMD", "ZhituGate.Check");
    paramQQAppInterface.putExtra("ZhituRequestBytes", localReqBody.toByteArray());
    this.mApp.startServlet(paramQQAppInterface);
  }
  
  private String cM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 0: 
      return "c2c";
    case 3000: 
      return "discussion";
    case 1: 
      return "troop";
    }
    return "kandian";
  }
  
  private String cN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "tempchat";
    case 0: 
      return "c2c";
    case 3000: 
      return "discuss";
    case 1: 
      return "group";
    }
    return "kandian";
  }
  
  private static String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = aszr.getFileMD5String(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, new Object[] { "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l) });
    }
    return paramString;
  }
  
  private void ciV()
  {
    if (this.bm != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "cancelAllRequestMessage");
      }
      int i = 1;
      while (i < 10)
      {
        this.bm.removeMessages(i);
        i += 1;
      }
    }
  }
  
  private void ciW()
  {
    Iterator localIterator = this.sK.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      BaseApplicationImpl.sImageCache.remove(str);
    }
    this.sK.clear();
  }
  
  private void ciY()
  {
    this.bmV = aqmj.aK(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bmU = aqmj.aG(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bZA = aqmj.bk(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bmY = aqmj.aL(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bmZ = aqmj.aM(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.Kg = aqmj.s(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bZE = aqmj.bl(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.bmW = true;
  }
  
  private void d(ykv paramykv)
  {
    int i = 1;
    if (paramykv == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "handleRequestDecodeGif font fail, picData is null.");
      }
    }
    for (;;)
    {
      return;
      if (wQ() == 1) {}
      String str;
      for (;;)
      {
        str = b(paramykv);
        if (a(str) == null) {
          break;
        }
        g(paramykv);
        return;
        i = 0;
      }
      try
      {
        if ((paramykv.b != null) && ((paramykv.isChecked) || (i != 0)))
        {
          localObject = new ykk(new File(paramykv.gJ), false, 0.0F);
          ((ykk)localObject).a(paramykv.b);
          a(str, (AbstractGifImage)localObject);
          this.sK.add(str);
          g(paramykv);
          return;
        }
        if (paramykv.gJ == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ZhituManager", 2, "decode gif picData.originPath is null: " + paramykv.toString());
        }
      }
      catch (IOException paramykv)
      {
        Object localObject;
        while (QLog.isColorLevel())
        {
          QLog.d("ZhituManager", 2, "decode gif fail: " + paramykv);
          return;
          localObject = new NativeGifImage(new File(paramykv.gJ), false);
        }
      }
      catch (OutOfMemoryError paramykv)
      {
        a(paramykv);
      }
    }
  }
  
  public static boolean d(MessageForPic paramMessageForPic)
  {
    boolean bool3 = false;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {}
    for (boolean bool1 = a((QQAppInterface)localAppRuntime).TN();; bool1 = false)
    {
      boolean bool2 = bool3;
      if (e(paramMessageForPic))
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      return bool2;
    }
  }
  
  public static boolean e(MessageForPic paramMessageForPic)
  {
    return (paramMessageForPic != null) && (paramMessageForPic.picExtraData != null) && (paramMessageForPic.picExtraData.isZhitu());
  }
  
  public static int fq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 4;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    }
    return 5;
  }
  
  private int fr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      return 1;
    case 3000: 
      return 2;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  private void g(ykv paramykv)
  {
    paramykv = this.mMainHandler.obtainMessage(5, paramykv);
    this.mMainHandler.sendMessage(paramykv);
  }
  
  private void gE(List<aoll> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "cancel all pending net req: " + paramList.size());
    }
    aolm localaolm = this.mApp.getNetEngine(0);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localaolm.b((aoll)paramList.next());
    }
  }
  
  public static boolean isUsed()
  {
    try
    {
      boolean bool = mUsed;
      return bool;
    }
    finally {}
  }
  
  private void n(File paramFile)
    throws IOException
  {
    try
    {
      if (this.ic == null) {
        this.ic = new HashMap();
      }
      if (!this.ic.containsKey(paramFile))
      {
        File localFile = new File(paramFile, ".nomedia");
        if ((!localFile.exists()) && (localFile.createNewFile())) {
          this.ic.put(paramFile, Boolean.valueOf(true));
        }
      }
      return;
    }
    finally {}
  }
  
  public static void setUsed(boolean paramBoolean)
  {
    if (mUsed == paramBoolean) {
      return;
    }
    try
    {
      mUsed = paramBoolean;
      return;
    }
    finally {}
  }
  
  private File u()
  {
    return new File(v(), "font");
  }
  
  static String u(String paramString1, String paramString2, String paramString3)
  {
    return String.format("[%s][%s]: %s", new Object[] { paramString1, paramString2, paramString3 });
  }
  
  private File v()
  {
    return x();
  }
  
  private File w()
  {
    return new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "zhitu" + File.separator + "origin/"));
  }
  
  private int wS()
  {
    return this.bZA;
  }
  
  private File x()
  {
    return new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "zhitu"));
  }
  
  private File y()
  {
    return new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + "zhitu" + File.separator + "sent/"));
  }
  
  private void yM(String paramString)
  {
    paramString = this.mMainHandler.obtainMessage(11, paramString);
    this.mMainHandler.sendMessage(paramString);
  }
  
  public void Ab(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituConfigOpen: " + paramBoolean);
    }
    this.bmU = paramBoolean;
    aqmj.v(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramBoolean);
  }
  
  public void Ac(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSaveAndShareSwitch: " + paramBoolean);
    }
    this.bmY = paramBoolean;
    aqmj.w(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramBoolean);
  }
  
  public void Ad(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSafeGateSwitch: " + paramBoolean);
    }
    this.bmZ = paramBoolean;
    aqmj.x(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramBoolean);
  }
  
  public void Ee(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSafeGateRequestInterval: " + paramInt);
    }
    this.bZE = paramInt;
    aqmj.aB(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramInt);
  }
  
  public void Ef(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setPageLen: " + paramInt);
    }
    this.bZA = paramInt;
    aqmj.aA(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramInt);
  }
  
  public boolean TM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "isZhituConfigOpen.zhituSwitch = " + this.bmU);
    }
    return this.bmU;
  }
  
  public boolean TN()
  {
    return this.bmY;
  }
  
  public boolean TO()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "isZhituSafeGateSwitch = " + this.bmZ);
    }
    return this.bmZ;
  }
  
  public boolean TP()
  {
    return this.bmV;
  }
  
  public boolean TQ()
  {
    if (TS()) {}
    while ((!TM()) || (!TP())) {
      return false;
    }
    return true;
  }
  
  @Nullable
  public String a(ykv paramykv)
  {
    if ((!paramykv.bnc) || (paramykv.b == null)) {
      return null;
    }
    return yla.a().a(paramykv.gJ, paramykv.b, paramykv.aYv, paramykv.bZJ, this);
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, boolean paramBoolean, MqqHandler paramMqqHandler)
  {
    if (paramViewGroup == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : parentView is null.");
      }
      return;
    }
    this.bmX = paramBoolean;
    Object localObject = (LinearLayout)paramViewGroup.findViewById(2131382436);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout != null.");
      }
      this.hs = ((LinearLayout)localObject);
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = ((DoutuEmotionHorizonListView)this.hs.findViewById(2131382440));
    }
    for (;;)
    {
      this.jdField_a_of_type_Yku = ((yku)this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.getAdapter());
      if ((this.jdField_a_of_type_Yku == null) && ((this.mApp instanceof QQAppInterface)))
      {
        this.jdField_a_of_type_Yku = new yku(paramContext, (QQAppInterface)this.mApp, paramBaseActivity, paramSessionInfo, paramMqqHandler);
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setAdapter(this.jdField_a_of_type_Yku);
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setRecycleListener(this.jdField_a_of_type_Yku);
      }
      this.hs.setVisibility(0);
      if (paramMqqHandler == null) {
        break;
      }
      paramMqqHandler.removeMessages(84);
      paramMqqHandler.sendEmptyMessageDelayed(84, 10000L);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "showZhituEmotionLayout : zhituLayout == null.");
      }
      this.hs = ((LinearLayout)View.inflate(paramContext, 2131558712, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = ((DoutuEmotionHorizonListView)this.hs.findViewById(2131382440));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setOnScrollStateChangedListener(new ykn(this));
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.setTouchListener(new yko(this, paramMqqHandler));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369277);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      paramViewGroup.addView(this.hs, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Editable paramEditable, List<ChatMessage> paramList, int paramInt, boolean paramBoolean)
  {
    setUsed(true);
    paramList = paramEditable.toString();
    if (TextUtils.isEmpty(paramList)) {
      break label16;
    }
    label16:
    while ((paramList.length() > 24) || (!b(paramEditable))) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.b() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.b().setEnabled(false);
    }
    ciT();
    ciV();
    if (this.mThread == null)
    {
      this.mThread = ThreadManager.newFreeHandlerThread("ZhituThread", 8);
      this.mThread.start();
      this.bm = new Handler(this.mThread.getLooper(), this);
      if (Build.VERSION.SDK_INT >= 23)
      {
        a(this.bm.getLooper().getQueue());
        label137:
        paramEditable = new ThreadPoolParams();
        paramEditable.corePoolsize = 1;
        paramEditable.maxPooolSize = 1;
        paramEditable.priority = 8;
        paramEditable.poolThreadName = "ZhituImgGenerateThreadPool";
        this.m = ThreadManager.newFreeThreadPool(paramEditable);
      }
    }
    else
    {
      paramEditable = atad.toMD5(paramList) + "_" + System.currentTimeMillis();
      dH(paramEditable, paramList);
      paramQQAppInterface = new ZhituManager.2(this, paramInt, paramQQAppInterface, paramEditable, paramList);
      paramQQAppInterface = this.bm.obtainMessage(1, paramQQAppInterface);
      paramList = this.bm;
      if (!paramBoolean) {
        break label300;
      }
    }
    label300:
    for (long l = 500L;; l = 0L)
    {
      paramList.sendMessageDelayed(paramQQAppInterface, l);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ZhituManager", 2, u(paramEditable, "pending request", ""));
      return;
      this.bm.postAtFrontOfQueue(new ZhituManager.1(this));
      break label137;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, List<String> paramList, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, u(paramString1, "sendZhituRequest", "start sending request"));
    }
    ZhituRequest localZhituRequest = new ZhituRequest();
    localZhituRequest.uin = paramQQAppInterface.getCurrentUin();
    localZhituRequest.os = "android";
    localZhituRequest.text = paramString2;
    localZhituRequest.styles = 3;
    localZhituRequest.chat = cM(paramInt1);
    localZhituRequest.version = "3.4.4";
    if (this.hZ.containsKey(paramQQAppInterface.getCurrentUin()))
    {
      paramString2 = new ykx();
      paramString2.sM = paramList;
      paramString2.text = ((String)this.ia.get(paramQQAppInterface.getCurrentUin()));
      paramString2.md5 = ((String)this.hZ.get(paramQQAppInterface.getCurrentUin()));
      paramString2.type = fr(paramInt1);
      localZhituRequest.report = paramString2;
    }
    a(paramQQAppInterface, paramString1, localZhituRequest, 0, this.bm);
  }
  
  public void a(ykm.c paramc)
  {
    this.jdField_a_of_type_Ykm$c = paramc;
  }
  
  @NonNull
  public String b(ykv paramykv)
  {
    int i = 1;
    if (wQ() == 1)
    {
      if (i == 0) {
        break label80;
      }
      localStringBuilder = new StringBuilder().append("Zhitu_").append(paramykv.gJ).append("_");
      if (paramykv.b != null) {
        break label66;
      }
    }
    label66:
    for (paramykv = "origin";; paramykv = Integer.valueOf(paramykv.b.hashCode()))
    {
      return paramykv;
      i = 0;
      break;
    }
    label80:
    StringBuilder localStringBuilder = new StringBuilder().append("Zhitu_").append(paramykv.gJ).append("_");
    if (paramykv.b == null) {
      paramykv = "origin";
    }
    for (;;)
    {
      return paramykv;
      if (paramykv.isChecked) {
        paramykv = Integer.valueOf(paramykv.b.hashCode());
      } else {
        paramykv = "origin";
      }
    }
  }
  
  public void b(ykv paramykv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "onSend:" + paramykv);
    }
    this.ia.put(this.mApp.getCurrentAccountUin(), getCurrentText());
    this.hZ.put(this.mApp.getCurrentAccountUin(), paramykv.pic_md5);
    Object localObject = paramykv.a;
    ((ykw)localObject).action = 1;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(localObject);
    localObject = null;
    if ((this.mApp instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.mApp;
    }
    anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800ADCD", "0X800ADCD", 0, 0, "", "", paramykv.pic_md5, "");
  }
  
  public boolean b(Editable paramEditable)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (aofy.eC(paramEditable.toString()) <= -1)
    {
      if (!aofy.Z(paramEditable.toString())) {
        break label77;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "isLegal: " + bool1 + " / " + atad.toMD5(paramEditable.toString()));
      }
      return bool1;
      label77:
      ArrayList localArrayList = new ArrayList();
      appb.a(paramEditable, localArrayList);
      bool1 = bool2;
      if (localArrayList.size() <= 0) {
        bool1 = true;
      }
    }
  }
  
  public void bf(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest start");
    }
    if (!aheq.a(paramQQAppInterface).j(paramQQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest isZhituLegalOpen is fales return");
      }
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis() - et();
      if (l >= wR() * 60000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ZhituManager", 2, "sendZhituSafeGateRequest time is short return time = " + l);
    return;
    bg(paramQQAppInterface);
  }
  
  public void bs(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, a(paramString, "requestDownloadMoreImg", paramInt, ""));
    }
    Message localMessage = this.bm.obtainMessage(7);
    localMessage.obj = paramString;
    localMessage.arg1 = paramInt;
    this.bm.sendMessage(localMessage);
    if ((this.mApp instanceof QQAppInterface)) {}
    for (paramString = (QQAppInterface)this.mApp;; paramString = null)
    {
      anot.a(paramString, "dc00898", "", "", "0X8008C73", "0X8008C73", fq(this.mCurType), 0, "", "", "", "");
      return;
    }
  }
  
  public void c(ykv paramykv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "onShow:" + paramykv);
    }
    Object localObject = paramykv.a;
    ((ykw)localObject).action = 0;
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.add(localObject);
    localObject = null;
    if ((this.mApp instanceof QQAppInterface)) {
      localObject = (QQAppInterface)this.mApp;
    }
    anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800ADCC", "0X800ADCC", 0, 0, "", "", paramykv.pic_md5, "");
  }
  
  public void ciT()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c.resetData();
    }
    if ((this.hs != null) && (this.hs.getVisibility() == 0))
    {
      this.jdField_a_of_type_Yku = ((yku)this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.getAdapter());
      if (this.jdField_a_of_type_Yku != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Yku.resetData();
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView.resetCurrentX(0);
    this.jdField_a_of_type_Yku.notifyDataSetChanged();
  }
  
  public void ciU()
  {
    if (this.bmT) {}
    do
    {
      return;
      localFile = v();
    } while ((!localFile.exists()) && (!localFile.mkdirs()));
    File localFile = new File(localFile, "font");
    if ((localFile.exists()) && ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(calcMD5(localFile.getAbsolutePath()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "startDownload Font but file is exist and correct");
      }
      this.g = Typeface.createFromFile(localFile);
      this.bmT = true;
      return;
    }
    aolm localaolm = this.mApp.getNetEngine(0);
    aoll localaoll = new aoll();
    localaoll.cMG = true;
    localaoll.cMK = true;
    localaoll.f = new ykm.b(this.bm);
    localaoll.mHttpMethod = 0;
    localaoll.bZ = "https://dl.url.cn/myapp/qq_desk/qqrm/smartgif/lantingyuan.ttf";
    localaoll.atY = localFile.getAbsolutePath();
    localaoll.dPo = 0;
    localaolm.a(localaoll);
  }
  
  public void ciX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "hideZhituEmotionLayout.");
    }
    if ((TR()) && ((this.mApp instanceof QQAppInterface))) {
      abrb.b((QQAppInterface)this.mApp, "zhitu", false);
    }
    if (this.hs != null)
    {
      ciT();
      ((ViewGroup)this.hs.getParent()).removeView(this.hs);
      this.hs = null;
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = null;
      this.jdField_a_of_type_Yku = null;
    }
    ciV();
    if (this.bm != null)
    {
      this.bm.post(new ZhituManager.12(this));
      this.bm.sendEmptyMessageDelayed(9, 10000L);
    }
  }
  
  public void dH(String paramString1, String paramString2)
  {
    try
    {
      this.aYp = paramString1;
      this.mCurrentText = paramString2;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void e(ykv paramykv)
  {
    paramykv = this.bm.obtainMessage(10, paramykv);
    this.bm.sendMessage(paramykv);
  }
  
  public long et()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "getZhituSafeGateRequestTime = " + this.Kg);
    }
    return this.Kg;
  }
  
  public void f(ykv paramykv)
  {
    e(paramykv);
  }
  
  public File g(@NonNull String paramString)
  {
    paramString = new File(paramString).getName() + "_" + System.currentTimeMillis();
    return new File(y(), paramString);
  }
  
  public File g(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      return g(paramString2);
    }
    int i = paramString1.lastIndexOf("/") + 1;
    int j = paramString1.lastIndexOf(".");
    if (i < j) {}
    for (paramString1 = paramString1.substring(i, j);; paramString1 = "fakeFileName")
    {
      paramString1 = paramString1 + "_" + System.currentTimeMillis();
      return new File(y(), paramString1);
    }
  }
  
  public int getCurType()
  {
    return this.mCurType;
  }
  
  public String getCurrentText()
  {
    try
    {
      String str = this.mCurrentText;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void gl(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "setZhituSafeGateRequestTime: " + paramLong);
    }
    this.Kg = paramLong;
    aqmj.w(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramLong);
  }
  
  public void h(ykv paramykv)
  {
    if ((this.hs != null) && (this.hs.getVisibility() == 0)) {
      this.jdField_a_of_type_Yku.j(paramykv);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c.j(paramykv);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 9: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    case 100: 
    case 8: 
    case 101: 
      do
      {
        do
        {
          return true;
          ((Runnable)paramMessage.obj).run();
          return true;
          paramMessage = (Bundle)paramMessage.obj;
          ZhituResponse localZhituResponse = (ZhituResponse)paramMessage.getParcelable("Response");
          a(paramMessage.getInt("ErrorCode"), localZhituResponse, paramMessage.getString("UniqueKey"), paramMessage.getInt("StartIdx", 0), paramMessage.getString("QueryText"));
          return true;
          av(paramMessage);
          return true;
          bB((Bundle)paramMessage.obj);
          return true;
          aw(paramMessage);
          return true;
          paramMessage = u();
          if (paramMessage.exists()) {}
          for (paramMessage = Typeface.createFromFile(paramMessage);; paramMessage = null)
          {
            this.g = paramMessage;
            this.bmT = true;
            return true;
          }
        } while (!(paramMessage.obj instanceof aoll));
        this.sJ.remove(paramMessage.obj);
        return true;
        this.bZB += 1;
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "download font fail, retry count: " + this.bZB);
        }
      } while (this.bZB > 3);
      b(Looper.myQueue());
      return true;
    }
    d((ykv)paramMessage.obj);
    return true;
  }
  
  public void i(ykv paramykv)
  {
    if (this.jdField_a_of_type_Ykm$c != null) {
      this.jdField_a_of_type_Ykm$c.a(paramykv);
    }
  }
  
  public void onDestroy()
  {
    if (this.hs != null)
    {
      this.hs = null;
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionHorizonListView = null;
      this.jdField_a_of_type_Yku = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView$c = null;
    }
    if ((this.mThread != null) && (this.bm != null))
    {
      ciV();
      this.bm.post(new ZhituManager.13(this));
    }
    if ((this.m instanceof ExecutorService)) {
      ((ExecutorService)this.m).shutdown();
    }
  }
  
  public String pE()
  {
    try
    {
      String str = this.aYp;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String pF()
  {
    File localFile = y();
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      return null;
    }
    try
    {
      n(localFile);
      label26:
      return localFile.getAbsolutePath();
    }
    catch (IOException localIOException)
    {
      break label26;
    }
  }
  
  public int wQ()
  {
    int j = 0;
    int i = j;
    if (this.mApp != null)
    {
      i = j;
      if ((this.mApp instanceof QQAppInterface)) {
        i = aheq.a((QQAppInterface)this.mApp).wQ();
      }
    }
    return i;
  }
  
  public int wR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituManager", 2, "getZhituSafeGateRequestInterval = " + this.bZE);
    }
    return this.bZE;
  }
  
  static class a
    implements aolm.b
  {
    private Handler mHandler;
    
    a(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public void onResp(aomh paramaomh)
    {
      Object localObject = this.mHandler.obtainMessage(8);
      ((Message)localObject).obj = paramaomh.b;
      this.mHandler.sendMessage((Message)localObject);
      Bundle localBundle = (Bundle)paramaomh.b.U();
      localObject = localBundle.getString("ReqUniqueKey");
      int i = localBundle.getInt("IdxInRes");
      if (QLog.isColorLevel())
      {
        long l = localBundle.getLong("StartTs");
        QLog.d("ZhituManager", 2, ykm.a((String)localObject, "onResp", i, " zhitu img download onResp result fileSize = " + paramaomh.apU + " file.path = " + paramaomh.b.atY + " resp.result = " + paramaomh.mResult + " take time: " + Long.toString(System.currentTimeMillis() - l)));
      }
      if (paramaomh.mResult == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, ykm.a((String)localObject, "OnResp", i, "result downloading, "));
        }
        return;
      }
      if (paramaomh.mResult == 0)
      {
        ZhituImgResponse localZhituImgResponse = (ZhituImgResponse)localBundle.getParcelable("ImgResponse");
        ykm.hK(paramaomh.b.atY);
        if (localZhituImgResponse != null)
        {
          paramaomh = this.mHandler.obtainMessage(3);
          paramaomh.obj = localBundle;
          this.mHandler.sendMessage(paramaomh);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, ykm.u((String)localObject, "onResp", "download succ but md5 is mismatched"));
        }
        paramaomh = this.mHandler.obtainMessage(4);
        localBundle.putInt("ErrorCode", 99999);
        paramaomh.obj = localBundle;
      }
      for (;;)
      {
        break;
        localObject = this.mHandler.obtainMessage(4);
        localBundle.putInt("ErrorCode", paramaomh.mErrCode);
        ((Message)localObject).obj = localBundle;
        paramaomh = (aomh)localObject;
      }
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  static class b
    implements aolm.b
  {
    private Handler mHandler;
    
    b(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public void onResp(aomh paramaomh)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "FontDownloadListener onResp: " + paramaomh);
      }
      if (paramaomh.mResult == 3) {
        return;
      }
      if (paramaomh.mResult == 0)
      {
        if ("f832939458e5e54f73b1702bc4edb7e8".equalsIgnoreCase(ykm.hK(paramaomh.b.atY)))
        {
          this.mHandler.sendEmptyMessage(100);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ZhituManager", 2, "font download but md5 is not matched");
        }
        this.mHandler.sendEmptyMessage(101);
        return;
      }
      this.mHandler.sendEmptyMessage(101);
    }
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static abstract interface c
  {
    public abstract void a(ykv paramykv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykm
 * JD-Core Version:    0.7.0.1
 */