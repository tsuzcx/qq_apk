import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class axpr
  extends axpm
  implements Handler.Callback, IEventReceiver
{
  public static int eGC = 4;
  public ArrayList<QIMTemplateItem> FR = new ArrayList();
  public ArrayList<QIMTemplateItem> FS = new ArrayList();
  public ArrayList<QIMFilterCategoryItem> FT = new ArrayList();
  public ArrayList<QIMFilterCategoryItem> FU = new ArrayList();
  private axpz a;
  public axqc a;
  public axqf a;
  public ayva.a a;
  public prt a;
  public axpr.b[] a;
  private boolean dvV;
  int eGD;
  public Handler ei;
  ArrayList<axpr.a> list = new ArrayList();
  public Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  public HashMap<String, axqc> rn = new HashMap();
  public HashMap<String, axqf> ro = new HashMap();
  public HashMap<String, axpp> rp = new HashMap();
  public HashMap<String, axqm> rq = new HashMap();
  public HashMap<String, ArrayList<axpr.c>> rr = new HashMap();
  public Handler uiHandler = new Handler(Looper.getMainLooper(), new axpt(this));
  
  public axpr()
  {
    this.jdField_a_of_type_ArrayOfAxpr$b = new axpr.b[5];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAxpr$b.length)
    {
      this.jdField_a_of_type_ArrayOfAxpr$b[i] = new axpr.b(i);
      i += 1;
    }
    this.eGD = 0;
    this.ei = new Handler(ThreadManager.getSubThreadLooper(), new axps(this));
    this.jdField_a_of_type_Axpz = new axpz();
  }
  
  private void C(Activity paramActivity, int paramInt)
  {
    axqc localaxqc = ayva.a().a[paramInt];
    if (localaxqc != null) {
      localaxqc.A(paramActivity, paramInt);
    }
    ayva.a().a(null, paramActivity, paramInt);
  }
  
  private void D(Activity paramActivity, int paramInt)
  {
    axpx localaxpx = (axpx)axov.a(15);
    axqm localaxqm = localaxpx.a();
    if (localaxqm != null)
    {
      localaxqm.A(paramActivity, paramInt);
      if (paramInt == 0) {
        localaxpx.d(null);
      }
    }
  }
  
  private static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if ((paramQIMFilterCategoryItem != null) && (paramQIMFilterCategoryItem.za != null))
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.za.iterator();
      while (paramQIMFilterCategoryItem.hasNext()) {
        if ("EMPTY".equals((String)paramQIMFilterCategoryItem.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void YP(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "yes to do setBeRecording" + paramBoolean);
    }
    this.dvV = paramBoolean;
  }
  
  public axpp a(FilterDesc paramFilterDesc)
  {
    axpp localaxpp2 = (axpp)this.rp.get(paramFilterDesc.name);
    axpp localaxpp1 = localaxpp2;
    if (localaxpp2 == null)
    {
      localaxpp1 = new axpp(paramFilterDesc);
      this.rp.put(paramFilterDesc.name, localaxpp1);
    }
    return localaxpp1;
  }
  
  public axpr.b a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfAxpr$b[paramInt];
  }
  
  public axpz a()
  {
    return this.jdField_a_of_type_Axpz;
  }
  
  public axqc a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    axqc localaxqc2 = (axqc)this.rn.get(paramQIMFilterCategoryItem.id);
    Object localObject1 = localaxqc2;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    int n;
    int k;
    int m;
    if (localaxqc2 == null)
    {
      localaxqc2 = new axqc(paramQIMFilterCategoryItem);
      localObject1 = paramQIMFilterCategoryItem.za.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = ayva.a().a((String)localObject2);
        if (localObject3 != null) {
          localaxqc2.c(a((FilterDesc)localObject3));
        } else if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo filter Null " + (String)localObject2);
        }
      }
      j = 0;
      i = 0;
      if (paramQIMFilterCategoryItem.V != null)
      {
        n = paramQIMFilterCategoryItem.V.length();
        k = 0;
        j = i;
        if (k < n)
        {
          localObject3 = paramQIMFilterCategoryItem.V.optJSONObject(k);
          if (localObject3 == null) {
            break label1292;
          }
          for (;;)
          {
            try
            {
              localObject4 = ((JSONObject)localObject3).optString("packet_id");
              localObject1 = ((JSONObject)localObject3).optString("item_id");
              f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
              f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
              f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
              localObject2 = new SegmentKeeper();
              ((SegmentKeeper)localObject2).fromJSONObject((JSONObject)localObject3);
              localObject3 = axsq.a(paramQIMFilterCategoryItem.id, (String)localObject4, (String)localObject1, f1, f2, f3);
              if (localObject3 != null)
              {
                ((axpn)localObject3).a((SegmentKeeper)localObject2);
                localaxqc2.c((axpn)localObject3);
                k += 1;
                break;
              }
              m = 1;
              j = 1;
              i = j;
              try
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("QCombo", 2, "createCombo pasters Null item_id= " + (String)localObject1);
                i = j;
              }
              catch (Exception localException1)
              {
                i = m;
              }
            }
            catch (Exception localException5)
            {
              Object localObject4;
              float f1;
              float f2;
              float f3;
              int i1;
              String str1;
              String str2;
              continue;
            }
            localException1.printStackTrace();
          }
        }
      }
      if (paramQIMFilterCategoryItem.W != null)
      {
        i1 = paramQIMFilterCategoryItem.W.length();
        m = 0;
        i = j;
        label399:
        j = i;
        if (m < i1)
        {
          localObject2 = paramQIMFilterCategoryItem.W.optJSONObject(m);
          j = i;
          if (localObject2 == null) {
            break label1295;
          }
          k = i;
          try
          {
            str1 = ((JSONObject)localObject2).optString("tagId");
            k = i;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            k = i;
            localObject3 = axsq.a((String)localObject2);
            if (localObject3 != null)
            {
              k = i;
              localaxqc2.c((axpn)localObject3);
              j = i;
            }
            else
            {
              n = 1;
              i = 1;
              k = i;
              j = n;
              if (QLog.isColorLevel())
              {
                k = i;
                QLog.d("QCombo", 2, "createCombo musicNull " + str1 + ":" + (String)localObject2);
                j = n;
              }
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            j = k;
          }
        }
      }
      i = j;
      if (paramQIMFilterCategoryItem.X != null)
      {
        i1 = paramQIMFilterCategoryItem.X.length();
        m = 0;
        label599:
        i = j;
        if (m < i1)
        {
          localObject2 = paramQIMFilterCategoryItem.X.optJSONObject(m);
          i = j;
          if (localObject2 == null) {
            break label1308;
          }
          k = j;
          try
          {
            str2 = ((JSONObject)localObject2).optString("tagId");
            k = j;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            k = j;
            i = j;
            if (aqmr.isEmpty(str2)) {
              break label1308;
            }
            k = j;
            localObject3 = axsq.b((String)localObject2);
            if (localObject3 != null)
            {
              k = j;
              localaxqc2.c((axpn)localObject3);
              i = j;
            }
            else
            {
              n = 1;
              j = 1;
              k = j;
              i = n;
              if (QLog.isColorLevel())
              {
                k = j;
                QLog.d("QCombo", 2, "createCombo ptvNull " + str2 + ":" + (String)localObject2);
                i = n;
              }
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            i = k;
          }
        }
      }
      j = i;
      if (paramQIMFilterCategoryItem.Y != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMFilterCategoryItem.Y + " size: " + paramQIMFilterCategoryItem.Y.length());
        }
        i1 = paramQIMFilterCategoryItem.Y.length();
        m = 0;
      }
    }
    for (;;)
    {
      j = i;
      if (m < i1)
      {
        localObject2 = paramQIMFilterCategoryItem.Y.optJSONObject(m);
        k = i;
        if (localObject2 != null) {
          j = i;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            String str3 = ((JSONObject)localObject2).optString("text_id");
            j = i;
            localObject4 = ((JSONObject)localObject2).optJSONArray("texts");
            k = i;
            if (localObject4 == null) {
              break label1330;
            }
            j = i;
            localObject3 = new ArrayList();
            k = 0;
            j = i;
            if (k < ((JSONArray)localObject4).length())
            {
              j = i;
              String str4 = ((JSONArray)localObject4).getString(k);
              j = i;
              if (TextUtils.isEmpty(str4)) {
                break label1321;
              }
              j = i;
              ((List)localObject3).add(str4);
              break label1321;
            }
            j = i;
            f1 = Float.valueOf(((JSONObject)localObject2).optString("position_x")).floatValue();
            j = i;
            f2 = Float.valueOf(((JSONObject)localObject2).optString("position_y")).floatValue();
            j = i;
            f3 = Float.valueOf(((JSONObject)localObject2).optString("scale")).floatValue();
            j = i;
            if (QLog.isColorLevel())
            {
              j = i;
              QLog.d("QCombo", 2, "create  TextCombo ID: " + str3);
            }
            j = i;
            localObject4 = new SegmentKeeper();
            j = i;
            ((SegmentKeeper)localObject4).fromJSONObject((JSONObject)localObject2);
            j = i;
            localObject2 = axsq.a(str3, (List)localObject3, f1, f2, f3);
            if (localObject2 != null)
            {
              j = i;
              ((axpn)localObject2).a((SegmentKeeper)localObject4);
              j = i;
              localaxqc2.c((axpn)localObject2);
              k = i;
            }
            else
            {
              n = 1;
              i = 1;
              j = i;
              k = n;
              if (QLog.isColorLevel())
              {
                j = i;
                QLog.d("QCombo", 2, "createCombo texts Null id=" + str3);
                k = n;
              }
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
            k = j;
          }
          if (j == 0) {
            this.rn.put(paramQIMFilterCategoryItem.id, localaxqc2);
          }
          axqc localaxqc1 = localaxqc2;
          localaxqc1.target = paramQIMFilterCategoryItem;
          return localaxqc1;
          label1292:
          break;
          label1295:
          m += 1;
          i = j;
          break label399;
          label1308:
          m += 1;
          j = i;
          break label599;
          label1321:
          k += 1;
        }
      }
      label1330:
      m += 1;
      i = k;
    }
  }
  
  public axqc a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    axpr localaxpr = (axpr)axov.a(5);
    axqc localaxqc = localaxpr.a(paramQIMFilterCategoryItem);
    localaxqc.B(paramActivity, paramBundle.getInt("capture_scene", -1));
    localaxqc.jl = new WeakReference(paramActivity);
    localaxpr.a(paramQIMFilterCategoryItem);
    switch (localaxqc.outState)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyCombo state = " + localaxqc.outState);
      }
      return localaxqc;
      a(new axpr.c(localaxqc, paramBundle, paramActivity));
      paramQIMFilterCategoryItem = Message.obtain(this.mUiHandler, 7, 0, 0, localaxqc);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        s(paramQIMFilterCategoryItem);
      }
      else
      {
        paramQIMFilterCategoryItem.sendToTarget();
        continue;
        a(new axpr.c(localaxqc, paramBundle, paramActivity));
        continue;
        a(new axpr.c(localaxqc, paramBundle, paramActivity));
        localaxqc.Rq();
      }
    }
  }
  
  public axqc a(String paramString)
  {
    Object localObject1 = null;
    axqc localaxqc = null;
    Object localObject2 = this.jdField_a_of_type_Ayva$a;
    if (localObject2 != null)
    {
      localObject2 = ((ayva.a)localObject2).b.GE.iterator();
      localObject1 = localaxqc;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((FilterCategory)((Iterator)localObject2).next()).Fv.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          if (TextUtils.equals(localQIMFilterCategoryItem.id, paramString)) {
            localaxqc = a(localQIMFilterCategoryItem);
          }
        }
      }
    }
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public axqf a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramQIMFilterCategoryItem.za.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = ayva.a().a((String)localObject2);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    Object localObject2 = (axqf)this.ro.get(paramQIMFilterCategoryItem.id);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new axqf(paramQIMFilterCategoryItem);
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((axqf)localObject1).c(a((FilterDesc)((Iterator)localObject2).next()));
      }
      this.ro.put(paramQIMFilterCategoryItem.id, localObject1);
    }
    return localObject1;
  }
  
  public axqf a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_Ayva$a;
    if (localObject != null)
    {
      localObject = ((ayva.a)localObject).b.filterList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
        if (TextUtils.equals(localQIMFilterCategoryItem.id, paramString)) {
          return a(localQIMFilterCategoryItem);
        }
      }
    }
    return null;
  }
  
  public axqm a(QIMTemplateItem paramQIMTemplateItem)
  {
    Object localObject2 = (axqm)this.rq.get(paramQIMTemplateItem.id);
    Object localObject1 = localObject2;
    Object localObject3;
    Object localObject4;
    int j;
    int i;
    Object localObject5;
    float f1;
    float f2;
    float f3;
    label439:
    label587:
    int k;
    if (localObject2 == null)
    {
      localObject1 = new axqm(paramQIMTemplateItem);
      if (QLog.isColorLevel()) {
        QLog.d("QTemplate", 2, "createTemplate filter " + paramQIMTemplateItem.za);
      }
      localObject2 = paramQIMTemplateItem.za.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = ayva.a().a((String)localObject3);
        if (localObject4 != null) {
          ((axqm)localObject1).d(a((FilterDesc)localObject4));
        } else if (QLog.isColorLevel()) {
          QLog.d("QTemplate", 2, "createTemplate filterNull " + (String)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QTemplate", 2, "createTemplate pasters " + paramQIMTemplateItem.V);
      }
      if (paramQIMTemplateItem.V != null)
      {
        j = paramQIMTemplateItem.V.length();
        i = 0;
        if (i < j)
        {
          localObject4 = paramQIMTemplateItem.V.optJSONObject(i);
          if (localObject4 == null) {
            break label1090;
          }
          try
          {
            localObject5 = ((JSONObject)localObject4).optString("packet_id");
            localObject2 = ((JSONObject)localObject4).optString("item_id");
            f1 = Float.valueOf(((JSONObject)localObject4).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject4).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject4).optString("scale")).floatValue();
            localObject3 = new SegmentKeeper();
            ((SegmentKeeper)localObject3).fromJSONObject((JSONObject)localObject4);
            localObject4 = axsq.a(paramQIMTemplateItem.id, (String)localObject5, (String)localObject2, f1, f2, f3);
            if (localObject4 != null)
            {
              ((axpn)localObject4).a((SegmentKeeper)localObject3);
              ((axqm)localObject1).d((axpn)localObject4);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("QTemplate", 2, "createTemplate pasters Null item_id= " + (String)localObject2);
            }
          }
          catch (Exception localException1)
          {
            QLog.d("CaptureComboManager", 1, "createTemplate exception", localException1);
          }
        }
      }
      if (paramQIMTemplateItem.W != null)
      {
        j = paramQIMTemplateItem.W.length();
        i = 0;
        if (i < j)
        {
          localObject3 = paramQIMTemplateItem.W.optJSONObject(i);
          if (localObject3 == null) {
            break label1099;
          }
          try
          {
            String str1 = ((JSONObject)localObject3).optString("tagId");
            localObject3 = ((JSONObject)localObject3).optString("itemId");
            localObject4 = axsq.a((String)localObject3);
            if (localObject4 != null) {
              ((axqm)localObject1).d((axpn)localObject4);
            } else if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "createTemplate musicNull " + str1 + ":" + (String)localObject3);
            }
          }
          catch (Exception localException2)
          {
            QLog.d("CaptureComboManager", 1, "createTemplateSet exception", localException2);
          }
        }
      }
      if (paramQIMTemplateItem.X != null)
      {
        j = paramQIMTemplateItem.X.length();
        i = 0;
        if (i < j)
        {
          localObject3 = paramQIMTemplateItem.X.optJSONObject(i);
          if (localObject3 == null) {
            break label1108;
          }
          try
          {
            String str2 = ((JSONObject)localObject3).optString("tagId");
            localObject3 = ((JSONObject)localObject3).optString("itemId");
            if (aqmr.isEmpty(str2)) {
              break label1108;
            }
            localObject4 = axsq.b((String)localObject3);
            if (localObject4 != null) {
              ((axqm)localObject1).d((axpn)localObject4);
            } else if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "createTemplateSet ptvNull " + str2 + ":" + (String)localObject3);
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
        }
      }
      if (paramQIMTemplateItem.Y != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMTemplateItem.Y + " size: " + paramQIMTemplateItem.Y.length());
        }
        k = paramQIMTemplateItem.Y.length();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < k)
      {
        localObject3 = paramQIMTemplateItem.Y.optJSONObject(i);
        if (localObject3 == null) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            String str3 = ((JSONObject)localObject3).optString("text_id");
            localObject5 = ((JSONObject)localObject3).optJSONArray("texts");
            if (localObject5 == null) {
              break label1126;
            }
            localObject4 = new ArrayList();
            j = 0;
            if (j < ((JSONArray)localObject5).length())
            {
              String str4 = ((JSONArray)localObject5).getString(j);
              if (TextUtils.isEmpty(str4)) {
                break label1117;
              }
              ((List)localObject4).add(str4);
              break label1117;
            }
            f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "create  TextCombo ID: " + str3);
            }
            localObject5 = new SegmentKeeper();
            ((SegmentKeeper)localObject5).fromJSONObject((JSONObject)localObject3);
            localObject3 = axsq.a(str3, (List)localObject4, f1, f2, f3);
            if (localObject3 != null)
            {
              ((axpn)localObject3).a((SegmentKeeper)localObject5);
              ((axqm)localObject1).d((axpn)localObject3);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("QTemplate", 2, "createCombo texts Null id=" + str3);
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
          }
          this.rq.put(paramQIMTemplateItem.id, localObject1);
          ((axqm)localObject1).target = paramQIMTemplateItem;
          return localObject1;
          label1090:
          i += 1;
          break;
          label1099:
          i += 1;
          break label439;
          label1108:
          i += 1;
          break label587;
          label1117:
          j += 1;
        }
      }
      label1126:
      i += 1;
    }
  }
  
  public axqm a(QIMTemplateItem paramQIMTemplateItem, Activity paramActivity, Bundle paramBundle)
  {
    paramQIMTemplateItem = ((axpr)axov.a(5)).a(paramQIMTemplateItem);
    paramQIMTemplateItem.B(paramActivity, paramBundle.getInt("capture_scene", -1));
    paramQIMTemplateItem.jl = new WeakReference(paramActivity);
    switch (paramQIMTemplateItem.outState)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyTemplate state = " + paramQIMTemplateItem.outState);
      }
      return paramQIMTemplateItem;
      a(new axpr.c(paramQIMTemplateItem, paramBundle, paramActivity));
      paramActivity = Message.obtain(this.mUiHandler, 7, 0, 0, paramQIMTemplateItem);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        s(paramActivity);
      }
      else
      {
        paramActivity.sendToTarget();
        continue;
        a(new axpr.c(paramQIMTemplateItem, paramBundle, paramActivity));
        continue;
        a(new axpr.c(paramQIMTemplateItem, paramBundle, paramActivity));
        paramQIMTemplateItem.Rq();
      }
    }
  }
  
  public ayva.b a()
  {
    if (this.jdField_a_of_type_Ayva$a != null) {
      return this.jdField_a_of_type_Ayva$a.b;
    }
    return null;
  }
  
  public QIMFilterCategoryItem a(int paramInt)
  {
    String str = "combo-" + paramInt;
    Object localObject1 = this.jdField_a_of_type_Ayva$a;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((ayva.a)localObject1).b;
    if (localObject1 == null) {
      return null;
    }
    localObject1 = ((ayva.b)localObject1).GE;
    if (localObject1 != null)
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem;
      do
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (FilterCategory)((Iterator)localObject1).next();
          } while ((localObject2 == null) || (((FilterCategory)localObject2).Fv == null));
          localObject2 = ((FilterCategory)localObject2).Fv.iterator();
        }
        localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject2).next();
      } while ((localQIMFilterCategoryItem == null) || (!str.equals(localQIMFilterCategoryItem.id)));
      return localQIMFilterCategoryItem;
    }
    return null;
  }
  
  public QIMFilterCategoryItem a(Activity paramActivity, awrq paramawrq, int paramInt)
  {
    paramawrq = (ComboProviderView)paramActivity.findViewById(2131364257);
    if (paramawrq != null)
    {
      paramawrq.apk();
      paramawrq = axvy.a().a(paramawrq.eCJ);
      if ((paramawrq != null) && (paramawrq.a() != null))
      {
        paramawrq.a().clear();
        paramawrq.a().clear();
        paramawrq.a().clear();
      }
    }
    paramawrq = (StaticStickerProviderView)paramActivity.findViewById(2131364268);
    if (paramawrq != null) {
      paramawrq.apk();
    }
    paramawrq = (QIMFilterProviderView)paramActivity.findViewById(2131364259);
    if (paramawrq != null) {
      paramawrq.apk();
    }
    paramActivity = (MusicProviderView)paramActivity.findViewById(2131364267);
    if (paramActivity != null) {
      paramActivity.apk();
    }
    return ayva.a().b(paramInt);
  }
  
  public QIMFilterCategoryItem a(axqc paramaxqc, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramaxqc != null)
    {
      localObject1 = localObject3;
      if ((paramaxqc.target instanceof QIMFilterCategoryItem))
      {
        localObject3 = (QIMFilterCategoryItem)paramaxqc.target;
        if (!((QIMFilterCategoryItem)localObject3).za.isEmpty()) {
          break label176;
        }
      }
    }
    label278:
    label280:
    label283:
    for (localObject1 = null;; localObject1 = paramaxqc)
    {
      if (localObject1 == null)
      {
        localObject3 = ((QIMFilterCategoryItem)localObject3).za.iterator();
        paramaxqc = (axqc)localObject2;
        do
        {
          localObject2 = paramaxqc;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = ayva.a().a((String)localObject2);
        } while (localObject2 == null);
        if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramaxqc = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramaxqc.za.size() == 1) && (paramaxqc.za.contains(((FilterDesc)localObject2).name)))
            {
              localObject1 = paramaxqc;
              return localObject1;
              label176:
              Iterator localIterator1 = paramArrayList.iterator();
              paramaxqc = null;
              label184:
              if (!localIterator1.hasNext()) {
                break label283;
              }
              localObject1 = (QIMFilterCategoryItem)localIterator1.next();
              if (((QIMFilterCategoryItem)localObject1).za.size() != ((QIMFilterCategoryItem)localObject3).za.size()) {
                break label280;
              }
              Iterator localIterator2 = ((QIMFilterCategoryItem)localObject3).za.iterator();
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (((QIMFilterCategoryItem)localObject1).za.contains(str)) {
                  paramaxqc = (axqc)localObject1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label184;
        paramaxqc = (axqc)localObject2;
        break;
        return localObject1;
      }
    }
  }
  
  public QIMFilterCategoryItem a(axqm paramaxqm, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramaxqm != null)
    {
      localObject1 = localObject3;
      if ((paramaxqm.target instanceof QIMTemplateItem))
      {
        localObject3 = (QIMTemplateItem)paramaxqm.target;
        if (!((QIMTemplateItem)localObject3).za.isEmpty()) {
          break label176;
        }
      }
    }
    label278:
    label280:
    label283:
    for (localObject1 = null;; localObject1 = paramaxqm)
    {
      if (localObject1 == null)
      {
        localObject3 = ((QIMTemplateItem)localObject3).za.iterator();
        paramaxqm = (axqm)localObject2;
        do
        {
          localObject2 = paramaxqm;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = ayva.a().a((String)localObject2);
        } while (localObject2 == null);
        if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramaxqm = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramaxqm.za.size() == 1) && (paramaxqm.za.contains(((FilterDesc)localObject2).name)))
            {
              localObject1 = paramaxqm;
              return localObject1;
              label176:
              Iterator localIterator1 = paramArrayList.iterator();
              paramaxqm = null;
              label184:
              if (!localIterator1.hasNext()) {
                break label283;
              }
              localObject1 = (QIMFilterCategoryItem)localIterator1.next();
              if (((QIMFilterCategoryItem)localObject1).za.size() != ((QIMTemplateItem)localObject3).za.size()) {
                break label280;
              }
              Iterator localIterator2 = ((QIMTemplateItem)localObject3).za.iterator();
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (((QIMFilterCategoryItem)localObject1).za.contains(str)) {
                  paramaxqm = (axqm)localObject1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label184;
        paramaxqm = (axqm)localObject2;
        break;
        return localObject1;
      }
    }
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Object localObject = ayva.a().b(paramInt);
    if (localObject != null)
    {
      localObject = a((QIMFilterCategoryItem)localObject);
      if ((localObject != null) && (((axqc)localObject).outState == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("capture_scene", paramInt);
        axqc localaxqc = ayva.a().a[paramInt];
        if (localaxqc != null) {
          a((QIMFilterCategoryItem)localaxqc.target, paramActivity, (Bundle)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "stopApplyDownload scene " + paramInt);
        }
      }
    }
  }
  
  public void a(Activity paramActivity, int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("capture_scene", paramInt);
    a(paramQIMFilterCategoryItem, paramActivity, localBundle);
  }
  
  public void a(axpr.a parama)
  {
    synchronized (this.list)
    {
      if (!this.list.contains(parama)) {
        this.list.add(parama);
      }
      return;
    }
  }
  
  public void a(axpr.c paramc)
  {
    synchronized (this.rr)
    {
      String str = paramc.a.getUniqueId();
      ArrayList localArrayList2 = (ArrayList)this.rr.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.rr.put(str, localArrayList1);
      }
      localArrayList1.add(paramc);
      return;
    }
  }
  
  public void a(axpw paramaxpw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboSuccess captureSet " + paramaxpw);
    }
    if ((paramaxpw.target instanceof QIMFilterCategoryItem)) {}
    synchronized (this.FU)
    {
      this.FU.add((QIMFilterCategoryItem)paramaxpw.target);
      this.ei.sendEmptyMessage(1);
      Message.obtain(this.mUiHandler, 7, 0, 0, paramaxpw).sendToTarget();
      return;
    }
  }
  
  public void a(axpw paramaxpw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboFailed captureset " + paramaxpw);
    }
    if ((paramaxpw.target instanceof QIMFilterCategoryItem)) {}
    synchronized (this.FU)
    {
      this.FU.add((QIMFilterCategoryItem)paramaxpw.target);
      this.ei.sendEmptyMessage(1);
      Message.obtain(this.mUiHandler, 7, paramInt, 0, paramaxpw).sendToTarget();
      return;
    }
  }
  
  public void a(axqm paramaxqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadTemplateSuccess templateSet " + paramaxqm);
    }
    if ((paramaxqm.target instanceof QIMTemplateItem)) {}
    synchronized (this.FS)
    {
      this.FS.add((QIMTemplateItem)paramaxqm.target);
      this.ei.sendEmptyMessage(3);
      Message.obtain(this.mUiHandler, 7, 0, 0, paramaxqm).sendToTarget();
      return;
    }
  }
  
  public void a(axqm paramaxqm, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadTemplateFailed templateSet " + paramaxqm + ", error " + paramInt);
    }
    if ((paramaxqm.target instanceof QIMTemplateItem)) {}
    synchronized (this.FS)
    {
      this.FS.add((QIMTemplateItem)paramaxqm.target);
      this.ei.sendEmptyMessage(3);
      Message.obtain(this.mUiHandler, 7, paramInt, 0, paramaxqm).sendToTarget();
      return;
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
    String str = "";
    if ((paramQIMFilterCategoryItem.aPz()) || (paramQIMFilterCategoryItem.auG())) {
      str = paramQIMFilterCategoryItem.id;
    }
    paramQIMFilterCategoryItem = str;
    if (str == null) {
      paramQIMFilterCategoryItem = "";
    }
    localSharedPreferences.edit().putString("select", paramQIMFilterCategoryItem).apply();
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    int i = paramBundle.getInt("capture_scene", -1);
    QIMFilterCategoryItem localQIMFilterCategoryItem = ayva.a().c(i);
    boolean bool1;
    boolean bool2;
    if ((localQIMFilterCategoryItem != null) && (TextUtils.equals(localQIMFilterCategoryItem.id, paramQIMFilterCategoryItem.id)))
    {
      bool1 = true;
      if ((localQIMFilterCategoryItem != null) || (!a(paramQIMFilterCategoryItem))) {
        break label164;
      }
      bool2 = true;
      label58:
      boolean bool3 = paramBundle.getBoolean("capture_force_enable", false);
      if (((!bool1) && (!bool2)) || (bool3)) {
        break label170;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboManager", 2, new Object[] { "applyFilters repeat, sameItem: ", Boolean.valueOf(bool1), " emptyItem:", Boolean.valueOf(bool2), " filterItem:", paramQIMFilterCategoryItem.name, " isForceEnable:", Boolean.valueOf(bool3) });
      }
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label164:
      bool2 = false;
      break label58;
      label170:
      paramQIMFilterCategoryItem = ((axpr)axov.a(5)).a(paramQIMFilterCategoryItem);
      paramQIMFilterCategoryItem.B(paramActivity, i);
      paramQIMFilterCategoryItem.jl = new WeakReference(paramActivity);
      switch (paramQIMFilterCategoryItem.outState)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.i("QCombo", 2, "applyFilters state = " + paramQIMFilterCategoryItem.outState);
        return;
        a(new axpr.c(paramQIMFilterCategoryItem, paramBundle, paramActivity));
        paramActivity = Message.obtain(this.mUiHandler, 7, 0, 0, paramQIMFilterCategoryItem);
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          s(paramActivity);
        }
        else
        {
          paramActivity.sendToTarget();
          continue;
          a(new axpr.c(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          continue;
          a(new axpr.c(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          axxj.a(paramQIMFilterCategoryItem).start();
          paramQIMFilterCategoryItem.Rq();
        }
      }
    }
  }
  
  public boolean aC(List<FilterCategory> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "preInitCombo: " + paramList.size());
    }
    Iterator localIterator1 = paramList.iterator();
    boolean bool = false;
    FilterCategory localFilterCategory;
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      localFilterCategory = (FilterCategory)localIterator1.next();
      localIterator2 = localFilterCategory.Fv.iterator();
    }
    for (;;)
    {
      if (localIterator2.hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator2.next();
        if (localFilterCategory.dvZ) {}
        for (paramList = a(localQIMFilterCategoryItem);; paramList = a(localQIMFilterCategoryItem))
        {
          paramList.outState = paramList.getState();
          if (paramList.outState != 1) {
            break label210;
          }
          paramList.eGB = ((int)(10000.0F * paramList.getProgress()));
          if (!QLog.isColorLevel()) {
            break label241;
          }
          QLog.d("QCombo", 2, "preInitCombo progress: " + localQIMFilterCategoryItem.name + ", progress: " + paramList.eGB);
          bool = true;
          break;
        }
        label210:
        if ((paramList.outState != 2) && (paramList.outState == 3)) {
          paramList.eGB = 10000;
        }
      }
      else
      {
        break;
        return bool;
        label241:
        bool = true;
      }
    }
  }
  
  public boolean aPq()
  {
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.FU)
      {
        this.FT.addAll(this.FU);
        this.FU.clear();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "syncStateAndProgress " + this.FT.size());
        }
        bool = false;
        i = this.FT.size() - 1;
        if (i < 0) {
          break label475;
        }
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)this.FT.get(i);
        ??? = a(localQIMFilterCategoryItem1);
        if (((axpw)???).outState == 1)
        {
          int j = ((axpw)???).getState();
          if (j != ((axpw)???).outState)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMFilterCategoryItem1.name + ", progress: " + ((axpw)???).eGB);
            }
            ((axpw)???).outState = j;
          }
          j = (int)(10000.0F * ((axpw)???).getProgress());
          if (j != ((axpw)???).eGB)
          {
            ((axpw)???).eGB = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((axpw)???).eGB);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMFilterCategoryItem localQIMFilterCategoryItem2;
      if (((axpw)???).outState == 2)
      {
        ((axpw)???).getState();
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.FT.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.name + ",  STATE_NEED_DOWNLOAD progress: " + ((axpw)???).eGB);
        }
        bool = true;
      }
      else if (((axpw)???).outState == 3)
      {
        ((axpw)???).getState();
        ((axpw)???).eGB = 10000;
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.FT.remove(i);
        axxj.a(???).ePh();
        Message.obtain(this.uiHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.name + ", STATE_DOWNLOADED progress: " + ((axpw)???).eGB);
        }
        bool = true;
        continue;
        label475:
        return bool;
      }
    }
  }
  
  public boolean aPr()
  {
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.FS)
      {
        this.FR.addAll(this.FS);
        this.FS.clear();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "syncStateAndProgress " + this.FR.size());
        }
        bool = false;
        i = this.FR.size() - 1;
        if (i < 0) {
          break label463;
        }
        QIMTemplateItem localQIMTemplateItem1 = (QIMTemplateItem)this.FR.get(i);
        ??? = a(localQIMTemplateItem1);
        if (((axpw)???).outState == 1)
        {
          int j = ((axpw)???).getState();
          if (j != ((axpw)???).outState)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMTemplateItem1.name + ", progress: " + ((axpw)???).eGB);
            }
            ((axpw)???).outState = j;
          }
          j = (int)(10000.0F * ((axpw)???).getProgress());
          if (j != ((axpw)???).eGB)
          {
            ((axpw)???).eGB = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((axpw)???).eGB);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMTemplateItem localQIMTemplateItem2;
      if (((axpw)???).outState == 2)
      {
        localQIMTemplateItem2 = (QIMTemplateItem)this.FR.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMTemplateItem2.name + ",  STATE_NEED_DOWNLOAD progress: " + ((axpw)???).eGB);
        }
        bool = true;
      }
      else if (((axpw)???).outState == 3)
      {
        ((axpw)???).eGB = 10000;
        localQIMTemplateItem2 = (QIMTemplateItem)this.FR.remove(i);
        axxj.a(???).ePh();
        Message.obtain(this.uiHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMTemplateItem2.name + ", STATE_DOWNLOADED progress: " + ((axpw)???).eGB);
        }
        bool = true;
        continue;
        label463:
        return bool;
      }
    }
  }
  
  public boolean aPs()
  {
    return (this.jdField_a_of_type_Prt.mIsEnable) && (this.jdField_a_of_type_Prt.aBn);
  }
  
  public boolean aPt()
  {
    return this.dvV;
  }
  
  public void aeF(int paramInt)
  {
    if ((this.eGD & 0x3) == 3) {}
    do
    {
      return;
      this.eGD |= paramInt;
    } while ((this.eGD & 0x3) != 3);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "first random");
    }
    eNL();
  }
  
  public void b(axpr.a parama)
  {
    synchronized (this.list)
    {
      this.list.remove(parama);
      return;
    }
  }
  
  public void b(axpw paramaxpw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadBegin combo " + paramaxpw);
    }
    synchronized (this.FU)
    {
      this.FU.add((QIMFilterCategoryItem)paramaxpw.target);
      this.ei.sendEmptyMessage(1);
      return;
    }
  }
  
  public void b(axqc paramaxqc)
  {
    Iterator localIterator = this.list.iterator();
    while (localIterator.hasNext()) {
      ((axpr.a)localIterator.next()).a(paramaxqc);
    }
  }
  
  public void b(axqm paramaxqm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadTemplateBegin templateSet " + paramaxqm);
    }
    synchronized (this.FS)
    {
      this.FS.add((QIMTemplateItem)paramaxqm.target);
      this.ei.sendEmptyMessage(3);
      return;
    }
  }
  
  public void b(ayva.a parama)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateData data is null?");
      if (parama != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCombo", 2, bool);
      if (parama != null)
      {
        this.jdField_a_of_type_Ayva$a = parama;
        this.jdField_a_of_type_Axpz.c(parama);
        Message.obtain(this.mUiHandler, 9, parama).sendToTarget();
      }
      aeF(1);
      return;
    }
  }
  
  public void cT(Activity paramActivity)
  {
    axpr.b[] arrayOfb = this.jdField_a_of_type_ArrayOfAxpr$b;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      arrayOfb[i].cW(paramActivity);
      i += 1;
    }
  }
  
  public void eIC()
  {
    ayva.a().a(BaseApplicationImpl.getContext(), null, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureComboManager", 4, "initComboConfig");
    }
  }
  
  public void eNK()
  {
    if ((this.rq != null) && (this.rq.size() > 0)) {
      this.rq.clear();
    }
  }
  
  public void eNL()
  {
    ayva.a locala = this.jdField_a_of_type_Ayva$a;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "randomliseData " + locala);
    }
    if (locala != null)
    {
      locala.eTP();
      b(locala);
    }
  }
  
  public void eNM()
  {
    a().notifyObservers(axpu.class, 971, true, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return s(paramMessage);
  }
  
  public boolean isValidate()
  {
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Axpz.eNS();
  }
  
  public boolean s(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "MSG_APPLY error " + i + " " + paramMessage.obj);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      label407:
      label413:
      int j;
      if ((paramMessage.obj instanceof axqf))
      {
        paramMessage = (axqf)paramMessage.obj;
        if (i == 0)
        {
          axxj.a(paramMessage).ePh();
          localObject1 = paramMessage.getUniqueId();
          localObject1 = (ArrayList)this.rr.get(localObject1);
          if (localObject1 == null) {
            continue;
          }
          localObject2 = (ArrayList)((ArrayList)localObject1).clone();
          ((ArrayList)localObject1).clear();
          localObject1 = (QIMFilterCategoryItem)paramMessage.target;
          if (i == 0) {
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label413;
            }
            localObject3 = (axpr.c)((Iterator)localObject2).next();
            i = ((axpr.c)localObject3).extra.getInt("capture_scene", -1);
            ??? = ayva.a().c(i);
            if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).id, ((QIMFilterCategoryItem)???).id)) && (!this.dvV))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QCombo", 2, "MSG_APPLY filter " + i + " " + ???);
              }
              ((awrz)axov.a(13)).aca(((QIMFilterCategoryItem)???).id);
              ??? = (Activity)((axpr.c)localObject3).weakActivity.get();
              if (??? != null)
              {
                paramMessage.b((Activity)???, i);
                synchronized (this.list)
                {
                  ??? = this.list.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label407;
                  }
                  ((axpr.a)((Iterator)???).next()).a(paramMessage, true, 0, ((axpr.c)localObject3).extra);
                }
                axxj.a(paramMessage).ePi();
                break;
              }
            }
          }
          this.jdField_a_of_type_Axqf = paramMessage;
          continue;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axpr.c)((Iterator)localObject2).next();
          j = ((axpr.c)localObject3).extra.getInt("capture_scene", -1);
          ??? = ayva.a().c(j);
          if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).id, ((QIMFilterCategoryItem)???).id)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "MSG_APPLY filter " + j + " " + ???);
            }
            ((awrz)axov.a(13)).aca(((QIMFilterCategoryItem)???).id);
            if ((Activity)((axpr.c)localObject3).weakActivity.get() != null) {
              synchronized (this.list)
              {
                ??? = this.list.iterator();
                if (((Iterator)???).hasNext()) {
                  ((axpr.a)((Iterator)???).next()).a(paramMessage, false, i, ((axpr.c)localObject3).extra);
                }
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131703405), 0).show();
          }
        }
      }
      else if ((paramMessage.obj instanceof axqc))
      {
        paramMessage = (axqc)paramMessage.obj;
        if (i == 0)
        {
          axxj.a(paramMessage).ePh();
          localObject1 = (QIMFilterCategoryItem)paramMessage.target;
          localObject2 = paramMessage.getUniqueId();
          localObject2 = (ArrayList)this.rr.get(localObject2);
          if (localObject2 == null) {
            continue;
          }
          localObject3 = (ArrayList)((ArrayList)localObject2).clone();
          ((ArrayList)localObject2).clear();
          if (i == 0) {
            localObject2 = ((ArrayList)localObject3).iterator();
          }
        }
        else
        {
          label980:
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label986;
            }
            localObject3 = (axpr.c)((Iterator)localObject2).next();
            ??? = (Activity)((axpr.c)localObject3).weakActivity.get();
            if (??? != null)
            {
              i = ((axpr.c)localObject3).extra.getInt("capture_scene", -1);
              ??? = ayva.a().b(i);
              if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).id, ((QIMFilterCategoryItem)localObject1).id)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QCombo", 2, "MSG_APPLY success " + i + " " + localObject1);
                }
                ((awrz)axov.a(13)).acb(((QIMFilterCategoryItem)localObject1).id);
                D((Activity)???, i);
                if (!axpp.a(paramMessage, i)) {
                  paramMessage.b((Activity)???, i);
                }
                synchronized (this.list)
                {
                  ??? = this.list.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label980;
                  }
                  ((axpr.a)((Iterator)???).next()).a(paramMessage, true, 0, ((axpr.c)localObject3).extra);
                }
                axxj.a(paramMessage).ePi();
                break;
              }
            }
          }
          label986:
          this.jdField_a_of_type_Axqc = paramMessage;
          continue;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axpr.c)((Iterator)localObject2).next();
          j = ((axpr.c)localObject3).extra.getInt("capture_scene", -1);
          ??? = ayva.a().b(j);
          if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).id, ((QIMFilterCategoryItem)localObject1).id)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "MSG_APPLY fail " + j + " " + localObject1);
            }
            ((awrz)axov.a(13)).acb(((QIMFilterCategoryItem)localObject1).id);
            ??? = (Activity)((axpr.c)localObject3).weakActivity.get();
            if (??? != null)
            {
              synchronized (this.list)
              {
                ??? = this.list.iterator();
                if (((Iterator)???).hasNext()) {
                  ((axpr.a)((Iterator)???).next()).a(paramMessage, false, i, ((axpr.c)localObject3).extra);
                }
              }
              ??? = (axpr)axov.a(5);
              ??? = ((axpr)???).jdField_a_of_type_Axqc;
              if (??? != null) {
                ((axpr)???).a((QIMFilterCategoryItem)((axqc)???).target, (Activity)???, ((axpr.c)localObject3).extra);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131703407), 0).show();
          }
        }
      }
      else if ((paramMessage.obj instanceof axqm))
      {
        localObject1 = (axpx)axov.a(15);
        paramMessage = (axqm)paramMessage.obj;
        if (i == 0)
        {
          axxj.a(paramMessage).ePh();
          localObject2 = (QIMTemplateItem)paramMessage.target;
          localObject3 = paramMessage.getUniqueId();
          localObject3 = (ArrayList)this.rr.get(localObject3);
          if (localObject3 == null) {
            continue;
          }
          ??? = (ArrayList)((ArrayList)localObject3).clone();
          ((ArrayList)localObject3).clear();
          if (i == 0) {
            localObject3 = ((ArrayList)???).iterator();
          }
        }
        else
        {
          label1589:
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1595;
            }
            ??? = (axpr.c)((Iterator)localObject3).next();
            ??? = (Activity)((axpr.c)???).weakActivity.get();
            if (??? != null)
            {
              i = ((axpr.c)???).extra.getInt("capture_scene", -1);
              ??? = ((axpx)localObject1).a(i);
              if ((??? != null) && (TextUtils.equals(((QIMTemplateItem)???).id, ((QIMTemplateItem)localObject2).id)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QTemplate", 2, "MSG_APPLY template success:" + i + ", item:" + localObject2);
                }
                C((Activity)???, i);
                if (!((axpx)localObject1).a(paramMessage, i)) {
                  paramMessage.b((Activity)???, i);
                }
                synchronized (this.list)
                {
                  ??? = this.list.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label1589;
                  }
                  ((axpr.a)((Iterator)???).next()).a(paramMessage, true, 0, ((axpr.c)???).extra);
                }
                axxj.a(paramMessage).ePi();
                break;
              }
            }
          }
          label1595:
          ((axpx)localObject1).d(paramMessage);
          continue;
        }
        localObject3 = ((ArrayList)???).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ??? = (axpr.c)((Iterator)localObject3).next();
          j = ((axpr.c)???).extra.getInt("capture_scene", -1);
          ??? = ((axpx)localObject1).a(j);
          if ((??? != null) && (TextUtils.equals(((QIMTemplateItem)???).id, ((QIMTemplateItem)localObject2).id)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "MSG_APPLY template fail " + j + " " + localObject2);
            }
            ??? = (Activity)((axpr.c)???).weakActivity.get();
            if (??? != null)
            {
              synchronized (this.list)
              {
                localObject7 = this.list.iterator();
                if (((Iterator)localObject7).hasNext()) {
                  ((axpr.a)((Iterator)localObject7).next()).a(paramMessage, false, i, ((axpr.c)???).extra);
                }
              }
              ??? = ((axpx)localObject1).a();
              Object localObject7 = (axpr)axov.a(5);
              if (??? != null) {
                ((axpr)localObject7).a((QIMTemplateItem)((axqm)???).target, (Activity)???, ((axpr.c)???).extra);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, acfp.m(2131703406), 0).show();
          }
        }
        paramMessage = (ayva.a)paramMessage.obj;
        try
        {
          localObject1 = this.list.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((axpr.a)((Iterator)localObject1).next()).a(paramMessage);
          }
        }
        finally {}
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(axqc paramaxqc);
    
    public abstract void a(axqc paramaxqc, boolean paramBoolean, int paramInt, Bundle paramBundle);
    
    public abstract void a(axqf paramaxqf, boolean paramBoolean, int paramInt, Bundle paramBundle);
    
    public abstract void a(axqm paramaxqm, boolean paramBoolean, int paramInt, Bundle paramBundle);
    
    public abstract void a(ayva.a parama);
  }
  
  public static class b
  {
    public axqm a;
    axrd a;
    public long aCs;
    public long aCt;
    public axqc b;
    public axqf b;
    int eGE;
    ArrayList<axpn> others;
    
    public b(int paramInt)
    {
      this.eGE = paramInt;
    }
    
    public void a(axqf paramaxqf)
    {
      this.jdField_b_of_type_Axqf = paramaxqf;
      this.aCt = System.currentTimeMillis();
    }
    
    public boolean aPu()
    {
      return (this.jdField_b_of_type_Axqf == null) || (this.aCt <= this.aCs);
    }
    
    public void c(axqc paramaxqc)
    {
      this.jdField_b_of_type_Axqc = paramaxqc;
      this.aCs = System.currentTimeMillis();
    }
    
    public void c(axqm paramaxqm)
    {
      this.jdField_a_of_type_Axqm = paramaxqm;
      this.aCs = System.currentTimeMillis();
    }
    
    public void cU(Activity paramActivity)
    {
      if ((this.jdField_b_of_type_Axqc != null) && (this.jdField_b_of_type_Axqc.outState == 3))
      {
        this.jdField_b_of_type_Axqc.B(paramActivity, this.eGE);
        this.jdField_b_of_type_Axqc.b(paramActivity, this.eGE);
      }
      if (this.jdField_b_of_type_Axqf != null)
      {
        this.jdField_b_of_type_Axqf.B(paramActivity, this.eGE);
        this.jdField_b_of_type_Axqf.b(paramActivity, this.eGE);
      }
    }
    
    public void cV(Activity paramActivity)
    {
      ayva.a().afK(this.eGE);
      ayva.a().a(null, paramActivity, this.eGE);
      axqc localaxqc = ayva.a().a[this.eGE];
      if (localaxqc != null) {
        localaxqc.A(paramActivity, this.eGE);
      }
      ayva.a().a(null, paramActivity, this.eGE);
      ayva.a().b(null, paramActivity, this.eGE);
    }
    
    public void cW(Activity paramActivity)
    {
      cV(paramActivity);
      this.jdField_b_of_type_Axqc = null;
      this.jdField_b_of_type_Axqf = null;
      this.jdField_a_of_type_Axrd = null;
      this.others = null;
    }
    
    public void eNN()
    {
      ayva.a().b(null, null, this.eGE);
      ayva.a().a(null, this.eGE);
      this.jdField_b_of_type_Axqf = null;
    }
  }
  
  public static class c
  {
    public axpw a;
    public Bundle extra;
    public WeakReference<Activity> weakActivity;
    
    public c(axpw paramaxpw, Bundle paramBundle, Activity paramActivity)
    {
      this.a = paramaxpw;
      this.extra = paramBundle;
      this.weakActivity = new WeakReference(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axpr
 * JD-Core Version:    0.7.0.1
 */