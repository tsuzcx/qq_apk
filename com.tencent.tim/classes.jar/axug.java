import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextBuilder.1;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean.a;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class axug
{
  private static final String TAG = axug.class.getSimpleName();
  private static final Map<Integer, List<String>> qO = new HashMap();
  private DynamicTextConfigManager b;
  private ConcurrentHashMap<String, Typeface> kl = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, Bitmap> km = new ConcurrentHashMap();
  
  static
  {
    qO.put(Integer.valueOf(0), Collections.singletonList(acfp.m(2131705361)));
    qO.put(Integer.valueOf(1), Collections.singletonList("Hi (•ω•)"));
    qO.put(Integer.valueOf(3), Collections.singletonList(acfp.m(2131705371)));
    qO.put(Integer.valueOf(4), Collections.singletonList(acfp.m(2131705384)));
    qO.put(Integer.valueOf(5), Arrays.asList(new String[] { acfp.m(2131705359), "MY JOURNEY" }));
    qO.put(Integer.valueOf(7), Collections.singletonList(acfp.m(2131705358)));
    qO.put(Integer.valueOf(8), Collections.singletonList(acfp.m(2131705381)));
    qO.put(Integer.valueOf(11), Collections.singletonList(acfp.m(2131705376)));
    qO.put(Integer.valueOf(15), Collections.singletonList(acfp.m(2131705377)));
    qO.put(Integer.valueOf(16), Collections.singletonList(acfp.m(2131705363)));
    qO.put(Integer.valueOf(17), Collections.singletonList(acfp.m(2131705387)));
    qO.put(Integer.valueOf(19), Collections.singletonList(acfp.m(2131705382)));
    qO.put(Integer.valueOf(20), Collections.singletonList("superich"));
    qO.put(Integer.valueOf(21), Collections.singletonList(acfp.m(2131705372)));
    qO.put(Integer.valueOf(24), Collections.singletonList("街头，\n艺术家。"));
    qO.put(Integer.valueOf(26), Collections.singletonList(acfp.m(2131705364)));
    qO.put(Integer.valueOf(27), Arrays.asList(new String[] { "悠闲的\n下午。", "jenny" }));
    qO.put(Integer.valueOf(28), Collections.singletonList(acfp.m(2131705385)));
    ThreadManager.post(new DynamicTextBuilder.1(), 5, null, false);
  }
  
  public static List<String> a(List<String> paramList, @NonNull DynamicTextItem paramDynamicTextItem)
  {
    int j = 0;
    ArrayList localArrayList = paramDynamicTextItem.eN();
    if ((localArrayList.isEmpty()) || (TextUtils.isEmpty((CharSequence)localArrayList.get(0)))) {
      return paramList;
    }
    Iterator localIterator = localArrayList.iterator();
    if (localIterator.hasNext())
    {
      localIterator.next();
      i = 1;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.equals(aa(paramDynamicTextItem.getType(), i)))) {
          localIterator.remove();
        }
        i += 1;
      }
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    int i = localArrayList.size();
    int m = paramList.size();
    int k = Math.min(i, paramDynamicTextItem.Rv());
    i = j;
    for (;;)
    {
      if ((i >= k) || (i >= m))
      {
        i = k;
        while (i < m)
        {
          localArrayList.add(paramList.get(i));
          i += 1;
        }
      }
      if (((String)localArrayList.get(i)).equals(aa(paramDynamicTextItem.getType(), i))) {
        localArrayList.set(i, paramList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static String aa(int paramInt1, int paramInt2)
  {
    List localList = at(paramInt1);
    if ((localList != null) && (paramInt2 >= 0) && (paramInt2 < localList.size())) {
      return (String)localList.get(paramInt2);
    }
    return "";
  }
  
  public static void ab(int paramInt, List<String> paramList)
  {
    qO.put(Integer.valueOf(paramInt), paramList);
  }
  
  public static List<String> at(int paramInt)
  {
    List localList = null;
    if (qO.containsKey(Integer.valueOf(paramInt))) {
      localList = (List)qO.get(Integer.valueOf(paramInt));
    }
    return localList;
  }
  
  public static String gU(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 18: 
    case 22: 
    case 23: 
    case 25: 
    default: 
      return null;
    case 0: 
      return acfp.m(2131705374);
    case 1: 
      return "Hi";
    case 3: 
      return acfp.m(2131705373);
    case 4: 
      return acfp.m(2131705380);
    case 5: 
      return acfp.m(2131705375);
    case 7: 
      return acfp.m(2131705379);
    case 8: 
      return acfp.m(2131705378);
    case 11: 
      return acfp.m(2131705365);
    case 15: 
      return acfp.m(2131705362);
    case 16: 
      return acfp.m(2131705386);
    case 17: 
      return acfp.m(2131705360);
    case 19: 
      return acfp.m(2131705368);
    case 20: 
      return "superich";
    case 21: 
      return acfp.m(2131705367);
    case 24: 
      return acfp.m(2131705369);
    case 26: 
      return acfp.m(2131705383);
    }
    return acfp.m(2131705366);
  }
  
  public static int lO(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "getIconDrawable type is: " + paramInt);
    }
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 6: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    case 14: 
    case 18: 
    case 22: 
    case 23: 
    case 25: 
    default: 
      return 2130845381;
    case 28: 
      return 2130845360;
    case 1: 
      return 2130845369;
    case 3: 
      return 2130845371;
    case 4: 
      return 2130845373;
    case 5: 
      return 2130845372;
    case 7: 
      return 2130845386;
    case 8: 
      return 2130845370;
    case 11: 
      return 2130845361;
    case 15: 
      return 2130845375;
    case 16: 
      return 2130845379;
    case 17: 
      return 2130845376;
    case 19: 
      return 2130845367;
    case 20: 
      return 2130845388;
    case 26: 
      return 2130845377;
    case 24: 
      return 2130845383;
    case 27: 
      return 2130845384;
    }
    return 2130845382;
  }
  
  public int a(DynamicTextItem paramDynamicTextItem)
  {
    int i = 0;
    if (axvb.class.isInstance(paramDynamicTextItem)) {
      if ((paramDynamicTextItem instanceof axva)) {
        i = 28;
      }
    }
    do
    {
      return i;
      if (axuc.class.isInstance(paramDynamicTextItem)) {
        return 1;
      }
      if (axup.class.isInstance(paramDynamicTextItem)) {
        return 3;
      }
      if (axvh.class.isInstance(paramDynamicTextItem)) {
        return 4;
      }
      if (axus.class.isInstance(paramDynamicTextItem)) {
        return 5;
      }
      if (axvm.class.isInstance(paramDynamicTextItem)) {
        return 7;
      }
      if (axuj.class.isInstance(paramDynamicTextItem)) {
        return 8;
      }
      if (axts.class.isInstance(paramDynamicTextItem)) {
        return 11;
      }
      if (axuq.class.isInstance(paramDynamicTextItem)) {
        return 17;
      }
      if (axum.class.isInstance(paramDynamicTextItem)) {
        return 15;
      }
      if (axuw.class.isInstance(paramDynamicTextItem)) {
        return 16;
      }
      if (axub.class.isInstance(paramDynamicTextItem)) {
        return 19;
      }
      if (axur.class.isInstance(paramDynamicTextItem)) {
        return 26;
      }
      if (axvq.class.isInstance(paramDynamicTextItem)) {
        return 20;
      }
      if (axvg.class.isInstance(paramDynamicTextItem)) {
        return 24;
      }
      if (axvk.class.isInstance(paramDynamicTextItem)) {
        return 27;
      }
    } while (!axtz.class.isInstance(paramDynamicTextItem));
    return ((axtz)paramDynamicTextItem).getType();
  }
  
  public <T extends DynamicTextItem> T a(int paramInt, @NonNull List<String> paramList)
  {
    Object localObject11 = null;
    if (this.b == null) {
      this.b = ((DynamicTextConfigManager)axov.a(7));
    }
    Object localObject10 = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject10).add((String)paramList.next());
      }
    }
    if (((List)localObject10).isEmpty())
    {
      paramList = at(paramInt);
      if (paramList != null) {
        localObject10 = paramList;
      }
    }
    for (;;)
    {
      Object localObject14 = this.b.a(String.valueOf(paramInt));
      Object localObject1;
      List<String> localList;
      if (localObject14 != null) {
        if (((DynamicTextConfigManager.DynamicTextConfigBean)localObject14).fontInfos.isEmpty())
        {
          paramList = null;
          if (paramList == null) {
            break label3241;
          }
          localObject1 = (Typeface)this.kl.get(paramList.name);
          localList = paramList;
          paramList = (List<String>)localObject1;
        }
      }
      for (;;)
      {
        Object localObject8;
        label526:
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 9: 
        case 10: 
        case 12: 
        case 13: 
        case 14: 
        case 18: 
        case 22: 
        case 23: 
        case 25: 
        default: 
          localObject1 = "invalid text type" + paramInt;
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "DynamicTextBuilder : " + (String)localObject1);
          }
          localObject1 = new axvb(paramInt, (List)localObject10);
        case 0: 
        case 28: 
        case 1: 
          for (;;)
          {
            if ((paramList != null) && (this.kl.get(Integer.valueOf(paramInt)) == null) && (localList != null)) {
              this.kl.put(localList.name, paramList);
            }
            return localObject1;
            paramList = (DynamicTextConfigManager.DynamicTextConfigBean.a)((DynamicTextConfigManager.DynamicTextConfigBean)localObject14).fontInfos.get(0);
            break;
            localObject1 = new axvb(paramInt, (List)localObject10);
            continue;
            localObject1 = new axva(paramInt, (List)localObject10);
            continue;
            localObject11 = (Bitmap)this.km.get(Integer.valueOf(2130845521));
            if (paramList != null)
            {
              localObject1 = localObject11;
              localObject8 = paramList;
              if (localObject11 != null) {
                break label526;
              }
            }
            try
            {
              localObject1 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
              paramList = (List<String>)localObject1;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                QLog.i(TAG, 2, Log.getStackTraceString(localException1));
              }
            }
            localObject1 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845521);
            this.km.put(Integer.valueOf(2130845521), localObject1);
            localObject8 = paramList;
            localObject1 = new axuc(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject1);
            paramList = (List<String>)localObject8;
          }
        case 3: 
          localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845389));
          localObject2 = (Bitmap)this.km.get(Integer.valueOf(2130845390));
          if (paramList == null)
          {
            try
            {
              localObject2 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
              paramList = (List<String>)localObject2;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                QLog.i(TAG, 2, Log.getStackTraceString(localException2));
              }
            }
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845389);
            localObject2 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845390);
            this.km.put(Integer.valueOf(2130845389), localObject8);
            this.km.put(Integer.valueOf(2130845390), localObject2);
          }
          break;
        }
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                localObject2 = new axup(paramInt, (List)localObject10, paramList, (Bitmap)localObject8, (Bitmap)localObject2);
                break;
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                  axvh localaxvh = new axvh(BaseApplicationImpl.getContext(), paramInt, (List)localObject10, (Typeface)localObject8);
                  paramList = (List<String>)localObject8;
                }
                catch (Exception localException3)
                {
                  for (;;)
                  {
                    QLog.i(TAG, 2, Log.getStackTraceString(localException3));
                    localObject8 = paramList;
                  }
                }
              }
              localObject11 = (Bitmap)this.km.get(Integer.valueOf(2130845428));
              localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845427));
              Object localObject3 = localObject11;
              if (localObject11 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845428);
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845427);
              }
              localObject3 = new axus(paramInt, (List)localObject10, (Bitmap)localObject3, (Bitmap)localObject8);
              break;
              localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845527));
              localObject3 = localObject8;
              if (localObject8 == null)
              {
                localObject3 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845527);
                this.km.put(Integer.valueOf(2130845527), localObject3);
              }
              localObject11 = (Bitmap)this.km.get(Integer.valueOf(2130845528));
              localObject8 = localObject11;
              if (localObject11 == null)
              {
                localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845528);
                this.km.put(Integer.valueOf(2130845528), localObject8);
              }
              localObject14 = (Bitmap)this.km.get(Integer.valueOf(2130845529));
              localObject11 = localObject14;
              if (localObject14 == null)
              {
                localObject11 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845529);
                this.km.put(Integer.valueOf(2130845529), localObject11);
              }
              localObject14 = new ArrayList(3);
              ((List)localObject14).add(localObject3);
              ((List)localObject14).add(localObject8);
              ((List)localObject14).add(localObject11);
              localObject8 = paramList;
              if (paramList == null) {}
              try
              {
                localObject8 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                localObject3 = new axvm(paramInt, (Typeface)localObject8, (List)localObject10, (List)localObject14);
                paramList = (List<String>)localObject8;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  localObject8 = paramList;
                  if (QLog.isColorLevel())
                  {
                    QLog.i(TAG, 2, localException4.getMessage(), localException4);
                    localObject8 = paramList;
                  }
                }
              }
            }
            localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845421));
            localObject4 = localObject8;
            if (localObject8 == null)
            {
              localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845421);
              this.km.put(Integer.valueOf(2130845421), localObject4);
            }
            localObject8 = paramList;
            if (paramList == null) {}
            try
            {
              localObject8 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
              localObject4 = new axuj(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject4);
              paramList = (List<String>)localObject8;
            }
            catch (RuntimeException localRuntimeException)
            {
              for (;;)
              {
                localObject8 = paramList;
                if (QLog.isColorLevel())
                {
                  QLog.e(TAG, 2, Log.getStackTraceString(localRuntimeException));
                  localObject8 = paramList;
                }
              }
            }
          }
          Object localObject4 = (Bitmap)this.km.get(Integer.valueOf(2130845362));
          localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845364));
          Object localObject12 = (Bitmap)this.km.get(Integer.valueOf(2130845363));
          if (localObject4 == null)
          {
            localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845362);
            localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845364);
            localObject12 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845363);
          }
          for (;;)
          {
            Object localObject5;
            for (;;)
            {
              for (;;)
              {
                if (paramList == null) {}
                for (;;)
                {
                  try
                  {
                    localObject14 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                    paramList = (List<String>)localObject14;
                    localObject4 = new axts(paramInt, (List)localObject10, paramList, (Bitmap)localObject4, (Bitmap)localObject8, (Bitmap)localObject12);
                  }
                  catch (Exception localException14)
                  {
                    QLog.i(TAG, 2, Log.getStackTraceString(localException14));
                  }
                }
                localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845522));
                localObject4 = localObject8;
                if (localObject8 == null)
                {
                  localObject4 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845522);
                  this.km.put(Integer.valueOf(2130845522), localObject4);
                }
                localObject12 = (Bitmap)this.km.get(Integer.valueOf(2130845523));
                localObject8 = localObject12;
                if (localObject12 == null)
                {
                  localObject8 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845523);
                  this.km.put(Integer.valueOf(2130845523), localObject8);
                }
                localObject12 = new ArrayList(3);
                ((List)localObject12).add(localObject4);
                ((List)localObject12).add(localObject8);
                localObject8 = paramList;
                if (paramList == null) {}
                try
                {
                  localObject8 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                  localObject4 = new axuq(paramInt, (List)localObject10, (Typeface)localObject8, (List)localObject12);
                  paramList = (List<String>)localObject8;
                }
                catch (Exception localException5)
                {
                  for (;;)
                  {
                    QLog.i(TAG, 2, Log.getStackTraceString(localException5));
                    localObject8 = paramList;
                  }
                }
              }
              localObject8 = (Bitmap)this.km.get(Integer.valueOf(2130845374));
              localObject5 = localObject8;
              if (localObject8 == null)
              {
                localObject5 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845374);
                this.km.put(Integer.valueOf(2130845374), localObject5);
              }
              localObject8 = paramList;
              if (paramList == null) {}
              try
              {
                localObject8 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                localObject5 = new axum(paramInt, (List)localObject10, (Typeface)localObject8, (Bitmap)localObject5);
                paramList = (List<String>)localObject8;
              }
              catch (Exception localException11)
              {
                for (;;)
                {
                  QLog.i(TAG, 2, Log.getStackTraceString(localException11));
                  localObject9 = paramList;
                }
              }
            }
            Object localObject9 = (Bitmap)this.km.get(Integer.valueOf(2130845378));
            if (localObject9 == null)
            {
              localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845378);
              this.km.put(Integer.valueOf(2130845378), localObject9);
            }
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  if (paramList == null) {}
                  label2136:
                  for (;;)
                  {
                    try
                    {
                      localObject5 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                      paramList = (List<String>)localObject5;
                      localObject5 = localObject12;
                      if (localException14 != null)
                      {
                        localObject5 = localObject12;
                        if (localException14.fontInfos.size() > 1)
                        {
                          localObject5 = localObject12;
                          if (localException14.fontInfos.get(1) != null)
                          {
                            localObject5 = localObject12;
                            if (!TextUtils.isEmpty(((DynamicTextConfigManager.DynamicTextConfigBean.a)localException14.fontInfos.get(1)).name))
                            {
                              localObject5 = (Typeface)this.kl.get(((DynamicTextConfigManager.DynamicTextConfigBean.a)localException14.fontInfos.get(1)).name);
                              if (localObject5 != null) {
                                break label2136;
                              }
                            }
                          }
                        }
                      }
                    }
                    catch (Exception localException6)
                    {
                      try
                      {
                        localObject12 = Typeface.createFromFile(this.b.b((DynamicTextConfigManager.DynamicTextConfigBean.a)localException14.fontInfos.get(1)) + "dynamic_text.ttf");
                        localObject5 = localObject12;
                        localObject5 = new axuw(paramInt, (List)localObject10, paramList, (Typeface)localObject5, (Bitmap)localObject9);
                      }
                      catch (Exception localException12)
                      {
                        QLog.i(TAG, 2, Log.getStackTraceString(localException12));
                      }
                      localException6 = localException6;
                      QLog.i(TAG, 2, Log.getStackTraceString(localException6));
                    }
                  }
                  localObject9 = paramList;
                  if (paramList == null)
                  {
                    localObject9 = paramList;
                    if (!ahbj.isFileExists(this.b.b(localList) + "dynamic_text.ttf")) {}
                  }
                  try
                  {
                    localObject9 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                    axub localaxub = new axub(paramInt, (List)localObject10, (Typeface)localObject9);
                    paramList = (List<String>)localObject9;
                  }
                  catch (Exception localException7)
                  {
                    for (;;)
                    {
                      QLog.i(TAG, 2, Log.getStackTraceString(localException7));
                      localObject9 = paramList;
                    }
                  }
                }
                localObject9 = paramList;
                if (paramList == null)
                {
                  localObject9 = paramList;
                  if (!ahbj.isFileExists(this.b.b(localList) + "dynamic_text.ttf")) {}
                }
                try
                {
                  localObject9 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                  if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "added new rich super : ");
                  }
                  axvq localaxvq = new axvq(paramInt, (List)localObject10, (Typeface)localObject9);
                  paramList = (List<String>)localObject9;
                }
                catch (Exception localException8)
                {
                  for (;;)
                  {
                    localObject9 = paramList;
                    if (QLog.isColorLevel())
                    {
                      QLog.i(TAG, 2, localException8.toString());
                      localObject9 = paramList;
                    }
                  }
                }
              }
              Object localObject6 = (Bitmap)this.km.get(Integer.valueOf(2130845366));
              if (localObject6 == null)
              {
                localObject6 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845366);
                this.km.put(Integer.valueOf(2130845366), localObject6);
              }
              for (;;)
              {
                localObject9 = (Bitmap)this.km.get(Integer.valueOf(2130845365));
                if (localObject9 == null)
                {
                  localObject9 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845365);
                  this.km.put(Integer.valueOf(2130845365), localObject9);
                }
                for (;;)
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      for (;;)
                      {
                        if (paramList == null) {}
                        for (;;)
                        {
                          try
                          {
                            Typeface localTypeface = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                            paramList = localTypeface;
                            localObject6 = new axur(paramInt, (List)localObject10, (Bitmap)localObject9, (Bitmap)localObject6, paramList);
                          }
                          catch (Exception localException13)
                          {
                            if (QLog.isColorLevel()) {
                              QLog.i(TAG, 2, localException13.getMessage(), localException13);
                            }
                          }
                        }
                        localObject9 = paramList;
                        if (paramList == null) {}
                        try
                        {
                          localObject9 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                          localObject6 = new axvg(paramInt, (List)localObject10, (Typeface)localObject9);
                          paramList = (List<String>)localObject9;
                        }
                        catch (Exception localException9)
                        {
                          for (;;)
                          {
                            localObject9 = paramList;
                            if (QLog.isColorLevel())
                            {
                              QLog.i(TAG, 2, localException9.getMessage(), localException9);
                              localObject9 = paramList;
                            }
                          }
                        }
                      }
                      localObject9 = paramList;
                      if (paramList == null)
                      {
                        localObject9 = paramList;
                        if (!ahbj.isFileExists(this.b.b(localList) + "dynamic_text.ttf")) {}
                      }
                      try
                      {
                        localObject9 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                        if (QLog.isColorLevel()) {
                          QLog.i(TAG, 2, "added new rich super : ");
                        }
                        axvk localaxvk = new axvk(paramInt, (List)localObject10, (Typeface)localObject9);
                        paramList = (List<String>)localObject9;
                      }
                      catch (Exception localException10)
                      {
                        for (;;)
                        {
                          localObject9 = paramList;
                          if (QLog.isColorLevel())
                          {
                            QLog.i(TAG, 2, localException10.toString());
                            localObject9 = paramList;
                          }
                        }
                      }
                    }
                    localObject9 = (Bitmap)this.km.get(Integer.valueOf(2130845524));
                    Object localObject7 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject7 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845524);
                      this.km.put(Integer.valueOf(2130845524), localObject7);
                    }
                    localObject9 = (Bitmap)this.km.get(Integer.valueOf(2130845525));
                    Object localObject13 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject13 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845525);
                      this.km.put(Integer.valueOf(2130845525), localObject13);
                    }
                    localObject9 = (Bitmap)this.km.get(Integer.valueOf(2130845526));
                    Object localObject15 = localObject9;
                    if (localObject9 == null)
                    {
                      localObject15 = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130845526);
                      this.km.put(Integer.valueOf(2130845526), localObject15);
                    }
                    localObject9 = paramList;
                    if (paramList == null) {}
                    try
                    {
                      localObject9 = Typeface.createFromFile(this.b.b(localList) + "dynamic_text.ttf");
                      paramList = new axty.a().a(10.0F, 12.0F).a((Bitmap)localObject7).a(41.0F, 36.0F, 1, 1).a((Typeface)localObject9).a();
                      localObject7 = new axty.a().a(12.0F, 21.0F).a((Bitmap)localObject13).a(123.0F, 33.0F, 7, 2).a((Typeface)localObject9).a();
                      localObject13 = new axty.a().a(10.0F, 27.0F).a((Bitmap)localObject15).a(192.0F, 43.0F, 10, 8).a((Typeface)localObject9).a();
                      localObject15 = new axtz.a();
                      ((axtz.a)localObject15).b(paramList);
                      ((axtz.a)localObject15).b((axty)localObject7);
                      ((axtz.a)localObject15).b((axty)localObject13);
                      ((axtz.a)localObject15).setTypeface((Typeface)localObject9);
                      ((axtz.a)localObject15).aer(-16777216);
                      localObject7 = ((axtz.a)localObject15).a(paramInt, (List)localObject10);
                      paramList = (List<String>)localObject9;
                    }
                    catch (Exception localException15)
                    {
                      for (;;)
                      {
                        localObject9 = paramList;
                        if (QLog.isColorLevel())
                        {
                          QLog.i(TAG, 2, localException15.getMessage(), localException15);
                          localObject9 = paramList;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label3241:
        localList = paramList;
        paramList = null;
        continue;
        localList = null;
        paramList = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axug
 * JD-Core Version:    0.7.0.1
 */