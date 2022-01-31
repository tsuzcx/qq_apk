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

public class thh
  implements IEventReceiver, tfr
{
  public QQAppInterface a;
  protected List<Subscriber> a;
  private final ssv jdField_a_of_type_Ssv = new thi(this);
  protected tfk a;
  tgp jdField_a_of_type_Tgp;
  public thg a;
  public thv a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b;
  
  public thh(thv paramthv, thg paramthg, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Thv = paramthv;
    this.jdField_a_of_type_Thg = paramthg;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private StoryVideoItem a(tff paramtff, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramtff.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(paramtff.jdField_a_of_type_JavaUtilList);
    int i = 0;
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((tfx)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((tfx)localArrayList.get(i + 1)).jdField_a_of_type_JavaLangString;
        localObject = ((tfx)localArrayList.get(i + 1)).b;
      }
    }
    for (;;)
    {
      tcw localtcw = (tcw)tcz.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localtcw.a(str);
        if (localStoryVideoItem != null)
        {
          ved.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramtff.jdField_a_of_type_JavaLangString, str);
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
            localObject = localtcw.a(((tfx)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              ved.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramtff.jdField_a_of_type_JavaLangString, paramString);
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
  
  private void a(twl paramtwl, String paramString)
  {
    ved.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramtwl, paramString);
    if (!(paramtwl instanceof twz)) {}
    tff localtff;
    do
    {
      return;
      localtff = ((tfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a(((twz)paramtwl).a());
      if (localtff == null)
      {
        ved.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramtwl, paramString });
        return;
      }
    } while ((localtff.jdField_a_of_type_Int != 12) || (!(paramtwl instanceof twz)));
    Bosses.get().postJob(new thk(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localtff, paramString));
  }
  
  private void b(List<tff> paramList)
  {
    if ((this.jdField_a_of_type_Thg != null) && (paramList != null))
    {
      this.jdField_a_of_type_Thg.a(paramList);
      a(paramList);
    }
  }
  
  private void b(tff paramtff, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_Thg != null) && (paramtff != null))
    {
      ved.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramtff, Integer.valueOf(paramInt), this.jdField_a_of_type_Thg.a(), Integer.valueOf(this.jdField_a_of_type_Thg.b()));
      localList = this.jdField_a_of_type_Thg.a();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      ved.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_Thg.a(paramtff, paramInt);
  }
  
  private void c(List<tff> paramList)
  {
    if ((this.jdField_a_of_type_Thg != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_Thg.b(paramList);
      a(paramList);
    }
  }
  
  private void c(tff paramtff)
  {
    if ((this.jdField_a_of_type_Thg != null) && (paramtff != null)) {
      this.jdField_a_of_type_Thg.a(paramtff);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Thv.jdField_a_of_type_Thg.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Tfk != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Tfk.a()).iterator();
      while (localIterator.hasNext())
      {
        tff localtff = (tff)localIterator.next();
        if ((localtff != null) && (localtff.jdField_a_of_type_Int == paramInt)) {
          a(localtff);
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
    int i25 = this.jdField_a_of_type_Thg.getItemCount();
    int i23 = 0;
    tff localtff;
    if (i23 < i25)
    {
      localtff = (tff)this.jdField_a_of_type_Thg.a(i23);
      if (localtff != null) {}
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
      switch (localtff.jdField_a_of_type_Int)
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
        if (localtff.b != 0) {
          j = 1;
        }
        if (!localtff.c) {
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
        if (localtff.d > 0) {}
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
          str = localtff.jdField_e_of_type_JavaLangString;
          l2 = localtff.a(str);
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
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_Thv.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        vei.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        ved.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
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
    int i = this.jdField_a_of_type_Thg.a(paramString1);
    this.jdField_a_of_type_Thv.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
    if (!thd.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void a(ArrayList<tff> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ved.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      b(paramArrayList);
      if (this.jdField_a_of_type_Thv.jdField_a_of_type_Long != 0L)
      {
        vei.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Thv.jdField_a_of_type_Long), 0, new String[] { "" });
        this.jdField_a_of_type_Thv.jdField_a_of_type_Long = 0L;
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
          tff localtff = (tff)localIterator.next();
          if ((localtff.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localtff.jdField_a_of_type_JavaLangString)))
          {
            localArrayList.add(localtff.jdField_a_of_type_JavaLangString);
            continue;
            c(paramArrayList);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        new tjt(localArrayList, String.valueOf(System.currentTimeMillis())).a();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List<tff> paramList)
  {
    Context localContext = this.jdField_a_of_type_Thv.jdField_a_of_type_AndroidContentContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_Tgp != null)) {
      this.jdField_a_of_type_Tgp.a(localContext, paramList);
    }
  }
  
  public void a(tff paramtff)
  {
    if ((this.jdField_a_of_type_Thg != null) && (paramtff != null)) {
      this.jdField_a_of_type_Thg.a(paramtff);
    }
  }
  
  public void a(tff paramtff, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((tdl)tcz.a(2)).b(paramtff.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + paramtff.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    paramtff = (sss)tsr.a().a(98);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramtff.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(tff paramtff, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramtff != null) && (paramtff.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramtff.jdField_a_of_type_JavaLangString))) {
        new tjt(paramtff.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramtff + ", type=" + paramInt1);
      }
      return;
      b(paramtff, paramInt2);
      a(Collections.singletonList(paramtff));
      if ((paramBoolean1) && (paramBoolean2))
      {
        ved.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_Thv.h();
        continue;
        a(paramtff);
        a(Collections.singletonList(paramtff));
        if ((paramBoolean1) && (paramBoolean2))
        {
          ved.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_Thv.h();
          continue;
          c(paramtff);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (tfy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    this.jdField_a_of_type_Tfk = ((tfy)localObject).a();
    this.jdField_a_of_type_Tgp = ((tfy)localObject).a();
    b(this.jdField_a_of_type_Tfk.b());
    this.jdField_a_of_type_Tfk.a(this);
    this.jdField_a_of_type_Tfk.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new thq(this));
    this.jdField_a_of_type_JavaUtilList.add(new thl(this));
    this.jdField_a_of_type_JavaUtilList.add(new tho(this));
    this.jdField_a_of_type_JavaUtilList.add(new thu(this));
    this.jdField_a_of_type_JavaUtilList.add(new thm(this));
    this.jdField_a_of_type_JavaUtilList.add(new thn(this));
    this.jdField_a_of_type_JavaUtilList.add(new thp(this));
    this.jdField_a_of_type_JavaUtilList.add(new ths(this));
    this.jdField_a_of_type_JavaUtilList.add(new tht(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ssv);
    this.jdField_a_of_type_Tgp.a(new thj(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      stb.a().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(tff paramtff)
  {
    sss localsss = (sss)tsr.a().a(98);
    String str = paramtff.jdField_a_of_type_JavaLangString;
    if ((paramtff.jdField_a_of_type_Int == 10) || (paramtff.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localsss.a(str, paramtff.jdField_a_of_type_Int, 1, paramtff.jdField_e_of_type_Long);
    this.jdField_a_of_type_Tfk.b(paramtff);
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
      if (this.jdField_a_of_type_Tfk != null) {
        this.jdField_a_of_type_Tfk.b(this);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          stb.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssv);
    if (this.jdField_a_of_type_Tgp != null) {
      this.jdField_a_of_type_Tgp.a();
    }
    this.jdField_a_of_type_Thg.a();
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thh
 * JD-Core Version:    0.7.0.1
 */