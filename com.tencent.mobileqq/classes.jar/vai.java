import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class vai
  implements IEventReceiver, uys
{
  public QQAppInterface a;
  protected List<Subscriber> a;
  private final ulw jdField_a_of_type_Ulw = new vaj(this);
  protected uyl a;
  uzq jdField_a_of_type_Uzq;
  public vah a;
  public vaw a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b;
  
  public vai(vaw paramvaw, vah paramvah, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Vaw = paramvaw;
    this.jdField_a_of_type_Vah = paramvah;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private StoryVideoItem a(uyg paramuyg, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramuyg.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(paramuyg.jdField_a_of_type_JavaUtilList);
    int i = 0;
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((uyy)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((uyy)localArrayList.get(i + 1)).jdField_a_of_type_JavaLangString;
        localObject = ((uyy)localArrayList.get(i + 1)).b;
      }
    }
    for (;;)
    {
      uvx localuvx = (uvx)uwa.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localuvx.a(str);
        if (localStoryVideoItem != null)
        {
          wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramuyg.jdField_a_of_type_JavaLangString, str);
          localStoryVideoItem.mAttachedFeedId = ((String)localObject);
          return localStoryVideoItem;
          i += 1;
          break;
        }
      }
      for (localObject = localStoryVideoItem;; localObject = null)
      {
        if (i != -1)
        {
          while (i > 0)
          {
            localObject = localuvx.a(((uyy)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramuyg.jdField_a_of_type_JavaLangString, paramString);
              return localObject;
            }
            i -= 1;
          }
          return localObject;
        }
        return localObject;
      }
      label244:
      localObject = null;
      str = null;
      continue;
      i = -1;
      localObject = null;
      str = null;
    }
  }
  
  private void a(vpm paramvpm, String paramString)
  {
    wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramvpm, paramString);
    if (!(paramvpm instanceof vqa)) {}
    uyg localuyg;
    do
    {
      return;
      localuyg = ((uyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a(((vqa)paramvpm).a());
      if (localuyg == null)
      {
        wxe.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramvpm, paramString });
        return;
      }
    } while ((localuyg.jdField_a_of_type_Int != 12) || (!(paramvpm instanceof vqa)));
    Bosses.get().postJob(new val(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localuyg, paramString));
  }
  
  private void b(List<uyg> paramList)
  {
    if ((this.jdField_a_of_type_Vah != null) && (paramList != null))
    {
      this.jdField_a_of_type_Vah.a(paramList);
      a(paramList);
    }
  }
  
  private void b(uyg paramuyg, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_Vah != null) && (paramuyg != null))
    {
      wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramuyg, Integer.valueOf(paramInt), this.jdField_a_of_type_Vah.a(), Integer.valueOf(this.jdField_a_of_type_Vah.b()));
      localList = this.jdField_a_of_type_Vah.a();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      wxe.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_Vah.a(paramuyg, paramInt);
  }
  
  private void c(List<uyg> paramList)
  {
    if ((this.jdField_a_of_type_Vah != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_Vah.b(paramList);
      a(paramList);
    }
  }
  
  private void c(uyg paramuyg)
  {
    if ((this.jdField_a_of_type_Vah != null) && (paramuyg != null)) {
      this.jdField_a_of_type_Vah.a(paramuyg);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vaw.jdField_a_of_type_Vah.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Uyl != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Uyl.a()).iterator();
      while (localIterator.hasNext())
      {
        uyg localuyg = (uyg)localIterator.next();
        if ((localuyg != null) && (localuyg.jdField_a_of_type_Int == paramInt)) {
          a(localuyg);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.b;
    if (bool) {
      c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (bool) {
      b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    int i9 = 0;
    int i8 = 0;
    int i7 = 0;
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    int i3 = 1;
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int i10 = 0;
    int k = 0;
    int i = 0;
    long l1 = 0L;
    String str = "";
    StringBuilder localStringBuilder = new StringBuilder("{");
    int j = 2;
    int i25 = this.jdField_a_of_type_Vah.getItemCount();
    int i23 = 0;
    uyg localuyg;
    if (i23 < i25)
    {
      localuyg = (uyg)this.jdField_a_of_type_Vah.a(i23);
      if (localuyg != null) {}
    }
    for (;;)
    {
      i23 += 1;
      break;
      int i21;
      int i20;
      int i19;
      int i18;
      int i17;
      int i16;
      int i15;
      int i14;
      int i13;
      int i12;
      int i11;
      int i22;
      long l2;
      switch (localuyg.jdField_a_of_type_Int)
      {
      default: 
        i21 = i9;
        i20 = i8;
        i19 = i7;
        i18 = i6;
        i17 = i5;
        i16 = i4;
        i15 = i3;
        i14 = i2;
        i13 = i1;
        i12 = n;
        i11 = m;
        i22 = k;
        l2 = l1;
      }
      Object localObject;
      for (;;)
      {
        if (localuyg.b != 0) {
          j = 1;
        }
        if (!localuyg.c) {
          break label1519;
        }
        i += 1;
        l1 = l2;
        k = i22;
        m = i11;
        n = i12;
        i1 = i13;
        i2 = i14;
        i3 = i15;
        i4 = i16;
        i5 = i17;
        i6 = i18;
        i7 = i19;
        i8 = i20;
        i9 = i21;
        break;
        i21 = i9 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        continue;
        i20 = i8 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i21 = i9;
        continue;
        i19 = i7 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i20 = i8;
        i21 = i9;
        continue;
        i18 = i6 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i17 = i5 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i16 = i4 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i15 = i3 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i14 = i2 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i13 = i1;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i13 = i1 + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i12 = n;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i12 = n + 1;
        l2 = l1;
        i22 = k;
        i11 = m;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        continue;
        i11 = m + 1;
        if (localuyg.d > 0) {}
        for (localObject = "2";; localObject = "1")
        {
          localStringBuilder.append("\"mystory\":").append((String)localObject);
          l2 = l1;
          i22 = k;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
          break;
        }
        int i24 = i10 + 1;
        l2 = l1;
        i22 = k;
        i10 = i24;
        i11 = m;
        i12 = n;
        i13 = i1;
        i14 = i2;
        i15 = i3;
        i16 = i4;
        i17 = i5;
        i18 = i6;
        i19 = i7;
        i20 = i8;
        i21 = i9;
        if (l1 == 0L)
        {
          str = localuyg.jdField_e_of_type_JavaLangString;
          l2 = localuyg.a(str);
          i22 = k;
          i10 = i24;
          i11 = m;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
          continue;
          i22 = k + 1;
          l2 = l1;
          i11 = m;
          i12 = n;
          i13 = i1;
          i14 = i2;
          i15 = i3;
          i16 = i4;
          i17 = i5;
          i18 = i6;
          i19 = i7;
          i20 = i8;
          i21 = i9;
        }
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(String.valueOf(6), i9);
        ((JSONObject)localObject).put(String.valueOf(7), i8);
        ((JSONObject)localObject).put(String.valueOf(8), i7);
        ((JSONObject)localObject).put(String.valueOf(9), i6);
        ((JSONObject)localObject).put(String.valueOf(11), i5);
        ((JSONObject)localObject).put(String.valueOf(10), i4);
        ((JSONObject)localObject).put(String.valueOf(1), i3);
        ((JSONObject)localObject).put(String.valueOf(2), i2);
        ((JSONObject)localObject).put(String.valueOf(3), i1);
        ((JSONObject)localObject).put(String.valueOf(4), n);
        ((JSONObject)localObject).put(String.valueOf(5), m);
        ((JSONObject)localObject).put(String.valueOf(12), i10 + ":" + str + ":" + l1);
        ((JSONObject)localObject).put(String.valueOf(13), k);
        if (TextUtils.equals("exp_story", paramString))
        {
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_Vaw.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        wxj.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        wxe.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
        return;
      }
      label1519:
      l1 = l2;
      k = i22;
      m = i11;
      n = i12;
      i1 = i13;
      i2 = i14;
      i3 = i15;
      i4 = i16;
      i5 = i17;
      i6 = i18;
      i7 = i19;
      i8 = i20;
      i9 = i21;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = this.jdField_a_of_type_Vah.a(paramString1);
    this.jdField_a_of_type_Vaw.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
    if (!vae.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void a(ArrayList<uyg> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    wxe.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      b(paramArrayList);
      if (this.jdField_a_of_type_Vaw.jdField_a_of_type_Long != 0L)
      {
        wxj.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Vaw.jdField_a_of_type_Long), 0, new String[] { "" });
        this.jdField_a_of_type_Vaw.jdField_a_of_type_Long = 0L;
      }
    }
    while ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          uyg localuyg = (uyg)localIterator.next();
          if ((localuyg.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localuyg.jdField_a_of_type_JavaLangString)))
          {
            localArrayList.add(localuyg.jdField_a_of_type_JavaLangString);
            continue;
            c(paramArrayList);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        new vcu(localArrayList, String.valueOf(System.currentTimeMillis())).a();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List<uyg> paramList)
  {
    Context localContext = this.jdField_a_of_type_Vaw.jdField_a_of_type_AndroidContentContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_Uzq != null)) {
      this.jdField_a_of_type_Uzq.a(localContext, paramList);
    }
  }
  
  public void a(uyg paramuyg)
  {
    if ((this.jdField_a_of_type_Vah != null) && (paramuyg != null)) {
      this.jdField_a_of_type_Vah.a(paramuyg);
    }
  }
  
  public void a(uyg paramuyg, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((uwm)uwa.a(2)).b(paramuyg.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + paramuyg.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    paramuyg = (ult)vls.a().a(98);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramuyg.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(uyg paramuyg, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramuyg != null) && (paramuyg.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramuyg.jdField_a_of_type_JavaLangString))) {
        new vcu(paramuyg.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramuyg + ", type=" + paramInt1);
      }
      return;
      b(paramuyg, paramInt2);
      a(Collections.singletonList(paramuyg));
      if ((paramBoolean1) && (paramBoolean2))
      {
        wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_Vaw.h();
        continue;
        a(paramuyg);
        a(Collections.singletonList(paramuyg));
        if ((paramBoolean1) && (paramBoolean2))
        {
          wxe.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_Vaw.h();
          continue;
          c(paramuyg);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (uyz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    this.jdField_a_of_type_Uyl = ((uyz)localObject).a();
    this.jdField_a_of_type_Uzq = ((uyz)localObject).a();
    b(this.jdField_a_of_type_Uyl.b());
    this.jdField_a_of_type_Uyl.a(this);
    this.jdField_a_of_type_Uyl.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new var(this));
    this.jdField_a_of_type_JavaUtilList.add(new vam(this));
    this.jdField_a_of_type_JavaUtilList.add(new vap(this));
    this.jdField_a_of_type_JavaUtilList.add(new vav(this));
    this.jdField_a_of_type_JavaUtilList.add(new van(this));
    this.jdField_a_of_type_JavaUtilList.add(new vao(this));
    this.jdField_a_of_type_JavaUtilList.add(new vaq(this));
    this.jdField_a_of_type_JavaUtilList.add(new vat(this));
    this.jdField_a_of_type_JavaUtilList.add(new vau(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ulw);
    this.jdField_a_of_type_Uzq.a(new vak(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      umc.a().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(uyg paramuyg)
  {
    ult localult = (ult)vls.a().a(98);
    String str = paramuyg.jdField_a_of_type_JavaLangString;
    if ((paramuyg.jdField_a_of_type_Int == 10) || (paramuyg.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localult.a(str, paramuyg.jdField_a_of_type_Int, 1, paramuyg.jdField_e_of_type_Long);
    this.jdField_a_of_type_Uyl.b(paramuyg);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onDetached");
      }
      this.b = false;
      if (this.jdField_a_of_type_Uyl != null) {
        this.jdField_a_of_type_Uyl.b(this);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          umc.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ulw);
    if (this.jdField_a_of_type_Uzq != null) {
      this.jdField_a_of_type_Uzq.a();
    }
    this.jdField_a_of_type_Vah.a();
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vai
 * JD-Core Version:    0.7.0.1
 */