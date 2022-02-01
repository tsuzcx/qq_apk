import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class woa
  implements IEventReceiver, wmk
{
  public QQAppInterface a;
  protected List<Subscriber> a;
  private final vzx jdField_a_of_type_Vzx = new wob(this);
  protected wmd a;
  wni jdField_a_of_type_Wni;
  public wnz a;
  public woo a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b;
  
  public woa(woo paramwoo, wnz paramwnz, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Woo = paramwoo;
    this.jdField_a_of_type_Wnz = paramwnz;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private StoryVideoItem a(wly paramwly, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramwly.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(paramwly.jdField_a_of_type_JavaUtilList);
    int i = 0;
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((wmq)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((wmq)localArrayList.get(i + 1)).jdField_a_of_type_JavaLangString;
        localObject = ((wmq)localArrayList.get(i + 1)).b;
      }
    }
    for (;;)
    {
      wjp localwjp = (wjp)wjs.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localwjp.a(str);
        if (localStoryVideoItem != null)
        {
          ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramwly.jdField_a_of_type_JavaLangString, str);
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
            localObject = localwjp.a(((wmq)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramwly.jdField_a_of_type_JavaLangString, paramString);
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
  
  private void a(xcy paramxcy, String paramString)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramxcy, paramString);
    if (!(paramxcy instanceof xdm)) {}
    wly localwly;
    do
    {
      return;
      localwly = ((wmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a(((xdm)paramxcy).a());
      if (localwly == null)
      {
        ykq.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramxcy, paramString });
        return;
      }
    } while ((localwly.jdField_a_of_type_Int != 12) || (!(paramxcy instanceof xdm)));
    Bosses.get().postJob(new wod(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localwly, paramString));
  }
  
  private void b(List<wly> paramList)
  {
    if ((this.jdField_a_of_type_Wnz != null) && (paramList != null))
    {
      this.jdField_a_of_type_Wnz.a(paramList);
      a(paramList);
    }
  }
  
  private void b(wly paramwly, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_Wnz != null) && (paramwly != null))
    {
      ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramwly, Integer.valueOf(paramInt), this.jdField_a_of_type_Wnz.a(), Integer.valueOf(this.jdField_a_of_type_Wnz.b()));
      localList = this.jdField_a_of_type_Wnz.a();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      ykq.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_Wnz.a(paramwly, paramInt);
  }
  
  private void c(List<wly> paramList)
  {
    if ((this.jdField_a_of_type_Wnz != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_Wnz.b(paramList);
      a(paramList);
    }
  }
  
  private void c(wly paramwly)
  {
    if ((this.jdField_a_of_type_Wnz != null) && (paramwly != null)) {
      this.jdField_a_of_type_Wnz.a(paramwly);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Woo.jdField_a_of_type_Wnz.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Wmd != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Wmd.a()).iterator();
      while (localIterator.hasNext())
      {
        wly localwly = (wly)localIterator.next();
        if ((localwly != null) && (localwly.jdField_a_of_type_Int == paramInt)) {
          a(localwly);
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
    int i25 = this.jdField_a_of_type_Wnz.getItemCount();
    int i23 = 0;
    wly localwly;
    if (i23 < i25)
    {
      localwly = (wly)this.jdField_a_of_type_Wnz.a(i23);
      if (localwly != null) {}
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
      switch (localwly.jdField_a_of_type_Int)
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
        if (localwly.b != 0) {
          j = 1;
        }
        if (!localwly.c) {
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
        if (localwly.d > 0) {}
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
          str = localwly.jdField_e_of_type_JavaLangString;
          l2 = localwly.a(str);
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
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_Woo.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        ykv.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        ykq.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
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
    int i = this.jdField_a_of_type_Wnz.a(paramString1);
    this.jdField_a_of_type_Woo.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
    if (!wnw.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void a(ArrayList<wly> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ykq.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      b(paramArrayList);
      if (this.jdField_a_of_type_Woo.jdField_a_of_type_Long != 0L)
      {
        ykv.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Woo.jdField_a_of_type_Long), 0, new String[] { "" });
        this.jdField_a_of_type_Woo.jdField_a_of_type_Long = 0L;
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
          wly localwly = (wly)localIterator.next();
          if ((localwly.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localwly.jdField_a_of_type_JavaLangString)))
          {
            localArrayList.add(localwly.jdField_a_of_type_JavaLangString);
            continue;
            c(paramArrayList);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        new wqm(localArrayList, String.valueOf(System.currentTimeMillis())).a();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List<wly> paramList)
  {
    Context localContext = this.jdField_a_of_type_Woo.jdField_a_of_type_AndroidContentContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_Wni != null)) {
      this.jdField_a_of_type_Wni.a(localContext, paramList);
    }
  }
  
  public void a(wly paramwly)
  {
    if ((this.jdField_a_of_type_Wnz != null) && (paramwly != null)) {
      this.jdField_a_of_type_Wnz.a(paramwly);
    }
  }
  
  public void a(wly paramwly, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((wke)wjs.a(2)).b(paramwly.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + paramwly.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    paramwly = (vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramwly.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(wly paramwly, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramwly != null) && (paramwly.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramwly.jdField_a_of_type_JavaLangString))) {
        new wqm(paramwly.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramwly + ", type=" + paramInt1);
      }
      return;
      b(paramwly, paramInt2);
      a(Collections.singletonList(paramwly));
      if ((paramBoolean1) && (paramBoolean2))
      {
        ykq.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_Woo.g();
        continue;
        a(paramwly);
        a(Collections.singletonList(paramwly));
        if ((paramBoolean1) && (paramBoolean2))
        {
          ykq.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_Woo.g();
          continue;
          c(paramwly);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (wmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
    this.jdField_a_of_type_Wmd = ((wmr)localObject).a();
    this.jdField_a_of_type_Wni = ((wmr)localObject).a();
    b(this.jdField_a_of_type_Wmd.b());
    this.jdField_a_of_type_Wmd.a(this);
    this.jdField_a_of_type_Wmd.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new woj(this));
    this.jdField_a_of_type_JavaUtilList.add(new woe(this));
    this.jdField_a_of_type_JavaUtilList.add(new woh(this));
    this.jdField_a_of_type_JavaUtilList.add(new won(this));
    this.jdField_a_of_type_JavaUtilList.add(new wof(this));
    this.jdField_a_of_type_JavaUtilList.add(new wog(this));
    this.jdField_a_of_type_JavaUtilList.add(new woi(this));
    this.jdField_a_of_type_JavaUtilList.add(new wol(this));
    this.jdField_a_of_type_JavaUtilList.add(new wom(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Vzx);
    this.jdField_a_of_type_Wni.a(new woc(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      wad.a().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(wly paramwly)
  {
    vzu localvzu = (vzu)wzk.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    String str = paramwly.jdField_a_of_type_JavaLangString;
    if ((paramwly.jdField_a_of_type_Int == 10) || (paramwly.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localvzu.a(str, paramwly.jdField_a_of_type_Int, 1, paramwly.jdField_e_of_type_Long);
    this.jdField_a_of_type_Wmd.b(paramwly);
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
      if (this.jdField_a_of_type_Wmd != null) {
        this.jdField_a_of_type_Wmd.b(this);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          wad.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vzx);
    if (this.jdField_a_of_type_Wni != null) {
      this.jdField_a_of_type_Wni.a();
    }
    this.jdField_a_of_type_Wnz.a();
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     woa
 * JD-Core Version:    0.7.0.1
 */