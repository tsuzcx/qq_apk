package com.tencent.mobileqq.vas.avatar;

import acbn;
import accg;
import acff;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import anlm;
import aqfo;
import aqrc;
import aqrg;
import aqrg.a;
import aure;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLState;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import wja;
import wki;

public class VasFaceManager
  extends aqrg<String>
{
  private static final ArrayList<Replayer> Db = new ArrayList();
  public static Boolean aM;
  private static Bundle bu;
  private static boolean cVN;
  public static Handler sHandler = new Handler(Looper.getMainLooper());
  private LinkedHashMap<String, Object> ak = new VasFaceManager.3(this, 20, 0.75F, true);
  public QQAppInterface app;
  private final aure<Object> n = new aure();
  
  public VasFaceManager(AppInterface paramAppInterface)
  {
    this.app = ((QQAppInterface)paramAppInterface);
  }
  
  public static String O(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = wja.b();
    if (isExistSDCard()) {
      localStringBuilder.append(acbn.bmG);
    }
    for (;;)
    {
      localStringBuilder.append(paramInt).append(File.separatorChar).append(paramString).append(".png");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.tim/files/head/_st/");
    }
  }
  
  public static Bundle a(boolean paramBoolean)
  {
    Bundle localBundle1 = t();
    if (paramBoolean)
    {
      Bundle localBundle2 = new Bundle();
      localBundle2.putAll(localBundle1);
      localBundle2.remove("key_loop");
      return localBundle2;
    }
    return localBundle1;
  }
  
  private VasAvatar a(ListView paramListView, int paramInt1, int paramInt2)
  {
    if (!(paramListView.getChildAt(paramInt1) instanceof BaseChatItemLayout)) {
      return null;
    }
    paramListView = (BaseChatItemLayout)paramListView.getChildAt(paramInt1);
    if (paramListView != null)
    {
      VasAvatar localVasAvatar = paramListView.a;
      if ((localVasAvatar != null) && (paramListView.getTop() + localVasAvatar.getBottom() > paramInt2)) {
        return localVasAvatar;
      }
    }
    return null;
  }
  
  public static VasFaceManager a(QQAppInterface paramQQAppInterface)
  {
    return ((aqrc)paramQQAppInterface.getManager(235)).a;
  }
  
  public static void a(String paramString, ApngDrawable paramApngDrawable)
  {
    for (;;)
    {
      int i;
      synchronized (Db)
      {
        i = Db.size() - 1;
        if (i >= 0)
        {
          ApngImage localApngImage = (ApngImage)((Replayer)Db.get(i)).iv.get();
          if (localApngImage == null) {
            Db.remove(i);
          } else if (localApngImage != paramApngDrawable.getImage()) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqhead.VasFaceManager", 2, "registerNewFace: " + paramApngDrawable.getImage());
          }
          Db.add(new Replayer(paramString, paramApngDrawable, sHandler));
          return;
        }
      }
      i -= 1;
    }
  }
  
  public static void b(ApngDrawable paramApngDrawable)
  {
    for (;;)
    {
      int i;
      synchronized (Db)
      {
        i = Db.size() - 1;
        if (i >= 0)
        {
          Replayer localReplayer = (Replayer)Db.get(i);
          ApngImage localApngImage = (ApngImage)localReplayer.iv.get();
          if (localApngImage == null) {
            Db.remove(i);
          } else if (localApngImage == paramApngDrawable.getImage()) {
            localReplayer.replay();
          }
        }
        else
        {
          return;
        }
      }
      i -= 1;
    }
  }
  
  private void e(ExtensionInfo paramExtensionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.VasFaceManager", 2, "onFaceIdChanged uin: " + paramExtensionInfo.uin + " newId: " + paramExtensionInfo.faceId + " faceUpdateTime: " + paramExtensionInfo.faceIdUpdateTime);
    }
    A(paramExtensionInfo.uin, null);
    if (paramExtensionInfo.uin.equals(this.app.getCurrentAccountUin()))
    {
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
      localEditor.putInt("my_store_face_id", paramExtensionInfo.faceId);
      localEditor.commit();
    }
  }
  
  public static int f(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    paramString = paramQQAppInterface.a(paramString, false);
    if (((paramString != null) && (paramString.faceId > 0)) || (anlm.ayn())) {
      i = 4;
    }
    return i;
  }
  
  private static boolean isExistSDCard()
  {
    if (aM == null) {
      aM = Boolean.valueOf(aqfo.isExistSDCard());
    }
    return aM.booleanValue();
  }
  
  public static String pS(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed scid is empty");
      return null;
    }
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length != 3)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed scid is " + paramString);
      return null;
    }
    int i;
    try
    {
      i = Integer.parseInt(arrayOfString[1]);
      if ((!"small".equals(arrayOfString[2])) && (!"medium".equals(arrayOfString[2])) && (!"large".equals(arrayOfString[2])))
      {
        QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed with unknown size type " + paramString);
        return null;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "getFacePath failed from " + paramString, localNumberFormatException);
      return null;
    }
    return O(i, localNumberFormatException[2]);
  }
  
  public static void pause()
  {
    if (!cVN) {}
    synchronized (Db)
    {
      int i = Db.size() - 1;
      while (i >= 0)
      {
        ((Replayer)Db.get(i)).pause();
        i -= 1;
      }
      cVN = true;
      return;
    }
  }
  
  public static void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.VasFaceManager", 2, "resume: " + Db.size());
    }
    for (;;)
    {
      int i;
      synchronized (Db)
      {
        i = Db.size() - 1;
        if (i >= 0)
        {
          Replayer localReplayer = (Replayer)Db.get(i);
          if ((ApngImage)localReplayer.iv.get() != null) {
            localReplayer.resume();
          } else {
            Db.remove(i);
          }
        }
      }
      cVN = false;
      return;
      i -= 1;
    }
  }
  
  public static Bundle t()
  {
    if (bu == null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 3);
      localBundle.putBoolean("key_double_bitmap", true);
      localBundle.putBoolean("key_draw_round", true);
      localBundle.putBoolean("key_get_reset_loop", false);
      localBundle.putBoolean("key_stop_on_first", true);
      localBundle.putIntArray("key_tagId_arr", new int[] { 9, 10, 2, 1, 0, 11 });
      localBundle.putString("key_name", "-face-");
      bu = localBundle;
    }
    return bu;
  }
  
  public void a(int paramInt, String paramString, aqrg.a<String> parama, Object paramObject)
  {
    String str = "face." + paramInt + "." + paramString;
    a(str, parama, paramObject);
    ThreadManagerV2.excute(new VasFaceManager.1(this, O(paramInt, paramString), str), 128, null, true);
  }
  
  public void a(ListView paramListView, wki paramwki, int paramInt)
  {
    int j = 0;
    int k = paramListView.getContext().getResources().getDimensionPixelSize(2131299627);
    int i1 = paramListView.getFirstVisiblePosition();
    int m = paramListView.getChildCount();
    int i2 = paramListView.getHeaderViewsCount();
    if (i1 < i2) {}
    Object localObject;
    for (int i = 0;; i = i1 - i2)
    {
      m = Math.min(paramwki.getCount(), m + i1 - i2);
      if (i1 < i2) {
        j = i2 - i1;
      }
      if (paramInt != 0) {
        break label213;
      }
      while (i < m)
      {
        localObject = a(paramListView, j, k);
        if (localObject != null)
        {
          ChatMessage localChatMessage = (ChatMessage)paramwki.getItem(i);
          if (localChatMessage != null)
          {
            long l = localChatMessage.uniseq;
            if (this.n.get(l) == null)
            {
              localObject = ((VasAvatar)localObject).getDrawable();
              if ((localObject instanceof URLDrawable))
              {
                localObject = ((URLDrawable)localObject).getCurrDrawable();
                if ((localObject instanceof ApngDrawable)) {
                  b((ApngDrawable)localObject);
                }
              }
            }
          }
        }
        j += 1;
        i += 1;
      }
    }
    this.n.clear();
    for (;;)
    {
      return;
      label213:
      if (this.n.size() == 0) {
        while (i < m)
        {
          if (a(paramListView, j, k) != null)
          {
            localObject = (ChatMessage)paramwki.getItem(i);
            if (localObject != null) {
              this.n.put(((ChatMessage)localObject).uniseq, this);
            }
          }
          j += 1;
          i += 1;
        }
      }
    }
  }
  
  public void a(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.ak.put(URLState.getMemoryCacheKey(paramURL.toString(), paramURLDrawableOptions), Boolean.TRUE);
  }
  
  public void b(String paramString, aqrg.a<String> parama, Object paramObject)
  {
    a(paramString, parama, paramObject);
    ThreadManagerV2.excute(new VasFaceManager.2(this, paramString), 32, null, true);
  }
  
  public void d(ExtensionInfo paramExtensionInfo)
  {
    HashSet localHashSet = new HashSet();
    if ((paramExtensionInfo != null) && (!TextUtils.isEmpty(paramExtensionInfo.uin)))
    {
      e(paramExtensionInfo);
      localHashSet.add(paramExtensionInfo.uin);
      this.app.getBusinessHandler(1).notifyUI(46, true, localHashSet);
    }
  }
  
  public void gu(String paramString, int paramInt)
  {
    try
    {
      ExtensionInfo localExtensionInfo = this.app.a(paramString, true);
      if (localExtensionInfo == null)
      {
        localExtensionInfo = new ExtensionInfo();
        localExtensionInfo.uin = paramString;
      }
      for (int i = 0;; i = localExtensionInfo.faceId)
      {
        QLog.d("Q.qqhead.VasFaceManager", 1, "handleFaceId uin: " + paramString + " oldId: " + i + " newId: " + paramInt);
        if (i != paramInt) {
          i(Arrays.asList(new String[] { paramString }));
        }
        paramString = (acff)this.app.getManager(51);
        localExtensionInfo.setStatus(1000);
        localExtensionInfo.faceId = paramInt;
        localExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        localExtensionInfo.timestamp = System.currentTimeMillis();
        paramString.a(localExtensionInfo);
        d(localExtensionInfo);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("Q.qqhead.VasFaceManager", 1, "", paramString);
    }
  }
  
  public void h(Collection<ExtensionInfo> paramCollection)
  {
    HashSet localHashSet = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      ExtensionInfo localExtensionInfo = (ExtensionInfo)paramCollection.next();
      if ((localExtensionInfo != null) && (!TextUtils.isEmpty(localExtensionInfo.uin)))
      {
        e(localExtensionInfo);
        localHashSet.add(localExtensionInfo.uin);
      }
    }
    if (!localHashSet.isEmpty()) {
      this.app.getBusinessHandler(1).notifyUI(46, true, localHashSet);
    }
  }
  
  /* Error */
  public void i(Collection<String> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/mobileqq/vas/avatar/VasFaceManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 587	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   7: invokevirtual 593	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload 4
    //   16: invokevirtual 599	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual 604	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   24: aload_1
    //   25: invokeinterface 573 1 0
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 578 1 0
    //   37: ifeq +99 -> 136
    //   40: aload_1
    //   41: invokeinterface 581 1 0
    //   46: checkcast 253	java/lang/String
    //   49: astore_3
    //   50: aload 4
    //   52: ldc_w 606
    //   55: aload_3
    //   56: invokevirtual 610	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   59: checkcast 606	com/tencent/mobileqq/data/Setting
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull -35 -> 31
    //   69: aload 5
    //   71: lconst_0
    //   72: putfield 613	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   75: aload_0
    //   76: getfield 69	com/tencent/mobileqq/vas/avatar/VasFaceManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   79: aload 5
    //   81: invokevirtual 616	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   84: aload_0
    //   85: getfield 69	com/tencent/mobileqq/vas/avatar/VasFaceManager:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: iconst_1
    //   89: aload_3
    //   90: sipush 200
    //   93: invokevirtual 620	com/tencent/mobileqq/app/QQAppInterface:y	(ILjava/lang/String;I)V
    //   96: aload 4
    //   98: aload 5
    //   100: invokevirtual 624	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   103: pop
    //   104: goto -73 -> 31
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: ldc 197
    //   114: iconst_1
    //   115: ldc_w 626
    //   118: aload_2
    //   119: invokestatic 346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 629	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   130: aload 4
    //   132: invokevirtual 632	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   135: return
    //   136: aload_2
    //   137: invokevirtual 634	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 629	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   148: aload 4
    //   150: invokevirtual 632	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   153: return
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 629	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   165: aload 4
    //   167: invokevirtual 632	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: goto -16 -> 157
    //   176: astore_3
    //   177: aload_1
    //   178: astore_2
    //   179: aload_3
    //   180: astore_1
    //   181: goto -24 -> 157
    //   184: astore_2
    //   185: aload_3
    //   186: astore_1
    //   187: goto -75 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	VasFaceManager
    //   0	190	1	paramCollection	Collection<String>
    //   19	160	2	localObject1	Object
    //   184	1	2	localException1	Exception
    //   13	77	3	str	String
    //   107	4	3	localException2	Exception
    //   176	10	3	localObject2	Object
    //   10	156	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   62	37	5	localSetting	com.tencent.mobileqq.data.Setting
    // Exception table:
    //   from	to	target	type
    //   20	31	107	java/lang/Exception
    //   31	64	107	java/lang/Exception
    //   69	104	107	java/lang/Exception
    //   136	140	107	java/lang/Exception
    //   14	20	154	finally
    //   20	31	172	finally
    //   31	64	172	finally
    //   69	104	172	finally
    //   136	140	172	finally
    //   112	122	176	finally
    //   14	20	184	java/lang/Exception
  }
  
  public boolean isFileExists(String paramString)
  {
    paramString = pS(paramString);
    if (paramString != null) {
      return new File(paramString).exists();
    }
    return false;
  }
  
  public void onComplete(String paramString, int paramInt)
  {
    QLog.d("Q.qqhead.VasFaceManager", 1, "download store face scid: " + paramString + " errorCode: " + paramInt);
    if ((paramInt <= 0) || (paramInt == 0)) {}
    for (String str = pS(paramString);; str = null)
    {
      A(paramString, str);
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public static class Replayer
    implements ApngDrawable.OnPlayRepeatListener, Runnable
  {
    private long atI;
    private long atJ;
    private boolean cVO;
    private Handler handler;
    public WeakReference<ApngImage> iv;
    private String uin;
    
    public Replayer(String paramString, ApngDrawable paramApngDrawable, Handler paramHandler)
    {
      this.iv = new WeakReference(paramApngDrawable.getImage());
      this.handler = paramHandler;
      paramApngDrawable.setOnPlayRepeatListener(this);
      this.uin = paramString;
    }
    
    public void onPlayRepeat(int paramInt)
    {
      if (paramInt == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqhead.VasFaceManager", 1, "onPlayRepeat: " + this.uin + " image: " + this.iv.get());
        }
        this.atI = SystemClock.uptimeMillis();
        this.atJ = 0L;
        this.cVO = true;
        this.handler.postDelayed(this, 5000L);
      }
    }
    
    public void pause()
    {
      if (this.cVO)
      {
        long l1 = SystemClock.uptimeMillis();
        long l2 = this.atJ;
        this.atJ = (l1 - this.atI + l2);
        this.handler.removeCallbacks(this);
      }
    }
    
    public void replay()
    {
      this.handler.post(this);
    }
    
    public void resume()
    {
      if (this.cVO)
      {
        this.atI = SystemClock.uptimeMillis();
        if (this.atJ >= 5000L) {
          this.handler.post(this);
        }
      }
      else
      {
        return;
      }
      this.handler.postDelayed(this, 5000L - this.atJ);
    }
    
    public void run()
    {
      this.cVO = false;
      this.handler.removeCallbacks(this);
      ApngImage localApngImage = (ApngImage)this.iv.get();
      if (localApngImage != null)
      {
        localApngImage.replay();
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.VasFaceManager", 2, "replay " + localApngImage + " in " + this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager
 * JD-Core Version:    0.7.0.1
 */