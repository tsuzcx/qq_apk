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

public class wtu
  implements IEventReceiver, wse
{
  public QQAppInterface a;
  protected List<Subscriber> a;
  private final wfi jdField_a_of_type_Wfi = new wtv(this);
  protected wrx a;
  wtc jdField_a_of_type_Wtc;
  public wtt a;
  public wui a;
  boolean jdField_a_of_type_Boolean = false;
  protected boolean b;
  
  public wtu(wui paramwui, wtt paramwtt, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Wui = paramwui;
    this.jdField_a_of_type_Wtt = paramwtt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private StoryVideoItem a(wrs paramwrs, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramwrs.jdField_a_of_type_JavaUtilList.size());
    localArrayList.addAll(paramwrs.jdField_a_of_type_JavaUtilList);
    int i = 0;
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((wsk)localArrayList.get(i)).jdField_a_of_type_JavaLangString, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((wsk)localArrayList.get(i + 1)).jdField_a_of_type_JavaLangString;
        localObject = ((wsk)localArrayList.get(i + 1)).b;
      }
    }
    for (;;)
    {
      wpj localwpj = (wpj)wpm.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localwpj.a(str);
        if (localStoryVideoItem != null)
        {
          yqp.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramwrs.jdField_a_of_type_JavaLangString, str);
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
            localObject = localwpj.a(((wsk)localArrayList.get(i)).jdField_a_of_type_JavaLangString);
            if (localObject != null)
            {
              yqp.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", paramwrs.jdField_a_of_type_JavaLangString, paramString);
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
  
  private void a(xix paramxix, String paramString)
  {
    yqp.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramxix, paramString);
    if (!(paramxix instanceof xjl)) {}
    wrs localwrs;
    do
    {
      return;
      localwrs = ((wsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251)).a(((xjl)paramxix).a());
      if (localwrs == null)
      {
        yqp.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramxix, paramString });
        return;
      }
    } while ((localwrs.jdField_a_of_type_Int != 12) || (!(paramxix instanceof xjl)));
    Bosses.get().postJob(new wtx(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localwrs, paramString));
  }
  
  private void b(List<wrs> paramList)
  {
    if ((this.jdField_a_of_type_Wtt != null) && (paramList != null))
    {
      this.jdField_a_of_type_Wtt.a(paramList);
      a(paramList);
    }
  }
  
  private void b(wrs paramwrs, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_Wtt != null) && (paramwrs != null))
    {
      yqp.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", paramwrs, Integer.valueOf(paramInt), this.jdField_a_of_type_Wtt.a(), Integer.valueOf(this.jdField_a_of_type_Wtt.b()));
      localList = this.jdField_a_of_type_Wtt.a();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      yqp.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_Wtt.a(paramwrs, paramInt);
  }
  
  private void c(List<wrs> paramList)
  {
    if ((this.jdField_a_of_type_Wtt != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_Wtt.b(paramList);
      a(paramList);
    }
  }
  
  private void c(wrs paramwrs)
  {
    if ((this.jdField_a_of_type_Wtt != null) && (paramwrs != null)) {
      this.jdField_a_of_type_Wtt.a(paramwrs);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wui.jdField_a_of_type_Wtt.notifyDataSetChanged();
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Wrx != null)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_Wrx.a()).iterator();
      while (localIterator.hasNext())
      {
        wrs localwrs = (wrs)localIterator.next();
        if ((localwrs != null) && (localwrs.jdField_a_of_type_Int == paramInt)) {
          a(localwrs);
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
    int i25 = this.jdField_a_of_type_Wtt.getItemCount();
    int i23 = 0;
    wrs localwrs;
    if (i23 < i25)
    {
      localwrs = (wrs)this.jdField_a_of_type_Wtt.a(i23);
      if (localwrs != null) {}
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
      switch (localwrs.jdField_a_of_type_Int)
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
        if (localwrs.b != 0) {
          j = 1;
        }
        if (!localwrs.c) {
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
        if (localwrs.d > 0) {}
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
          str = localwrs.jdField_e_of_type_JavaLangString;
          l2 = localwrs.a(str);
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
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_Wui.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.a()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        yqu.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        yqp.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
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
    int i = this.jdField_a_of_type_Wtt.a(paramString1);
    this.jdField_a_of_type_Wui.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.scrollToPosition(i);
    if (!wtq.a()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void a(ArrayList<wrs> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    yqp.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      b(paramArrayList);
      if (this.jdField_a_of_type_Wui.jdField_a_of_type_Long != 0L)
      {
        yqu.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Wui.jdField_a_of_type_Long), 0, new String[] { "" });
        this.jdField_a_of_type_Wui.jdField_a_of_type_Long = 0L;
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
          wrs localwrs = (wrs)localIterator.next();
          if ((localwrs.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(localwrs.jdField_a_of_type_JavaLangString)))
          {
            localArrayList.add(localwrs.jdField_a_of_type_JavaLangString);
            continue;
            c(paramArrayList);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        new wwg(localArrayList, String.valueOf(System.currentTimeMillis())).a();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void a(List<wrs> paramList)
  {
    Context localContext = this.jdField_a_of_type_Wui.jdField_a_of_type_AndroidContentContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_Wtc != null)) {
      this.jdField_a_of_type_Wtc.a(localContext, paramList);
    }
  }
  
  public void a(wrs paramwrs)
  {
    if ((this.jdField_a_of_type_Wtt != null) && (paramwrs != null)) {
      this.jdField_a_of_type_Wtt.a(paramwrs);
    }
  }
  
  public void a(wrs paramwrs, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((wpy)wpm.a(2)).b(paramwrs.jdField_a_of_type_JavaLangString);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + paramwrs.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    paramwrs = (wff)xfe.a().a(98);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      paramwrs.a(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void a(wrs paramwrs, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (paramwrs != null) && (paramwrs.jdField_a_of_type_Int == 8) && (!TextUtils.isEmpty(paramwrs.jdField_a_of_type_JavaLangString))) {
        new wwg(paramwrs.jdField_a_of_type_JavaLangString, String.valueOf(System.currentTimeMillis())).a();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + paramwrs + ", type=" + paramInt1);
      }
      return;
      b(paramwrs, paramInt2);
      a(Collections.singletonList(paramwrs));
      if ((paramBoolean1) && (paramBoolean2))
      {
        yqp.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_Wui.g();
        continue;
        a(paramwrs);
        a(Collections.singletonList(paramwrs));
        if ((paramBoolean1) && (paramBoolean2))
        {
          yqp.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_Wui.g();
          continue;
          c(paramwrs);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = (wsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(251);
    this.jdField_a_of_type_Wrx = ((wsl)localObject).a();
    this.jdField_a_of_type_Wtc = ((wsl)localObject).a();
    b(this.jdField_a_of_type_Wrx.b());
    this.jdField_a_of_type_Wrx.a(this);
    this.jdField_a_of_type_Wrx.a(1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new wud(this));
    this.jdField_a_of_type_JavaUtilList.add(new wty(this));
    this.jdField_a_of_type_JavaUtilList.add(new wub(this));
    this.jdField_a_of_type_JavaUtilList.add(new wuh(this));
    this.jdField_a_of_type_JavaUtilList.add(new wtz(this));
    this.jdField_a_of_type_JavaUtilList.add(new wua(this));
    this.jdField_a_of_type_JavaUtilList.add(new wuc(this));
    this.jdField_a_of_type_JavaUtilList.add(new wuf(this));
    this.jdField_a_of_type_JavaUtilList.add(new wug(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wfi);
    this.jdField_a_of_type_Wtc.a(new wtw(this));
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      wfo.a().registerSubscriber("", localSubscriber);
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(wrs paramwrs)
  {
    wff localwff = (wff)xfe.a().a(98);
    String str = paramwrs.jdField_a_of_type_JavaLangString;
    if ((paramwrs.jdField_a_of_type_Int == 10) || (paramwrs.jdField_a_of_type_Int == 11)) {
      str = null;
    }
    localwff.a(str, paramwrs.jdField_a_of_type_Int, 1, paramwrs.jdField_e_of_type_Long);
    this.jdField_a_of_type_Wrx.b(paramwrs);
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
      if (this.jdField_a_of_type_Wrx != null) {
        this.jdField_a_of_type_Wrx.b(this);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          wfo.a().unRegisterSubscriber(localSubscriber);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wfi);
    if (this.jdField_a_of_type_Wtc != null) {
      this.jdField_a_of_type_Wtc.a();
    }
    this.jdField_a_of_type_Wtt.a();
  }
  
  public void d() {}
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wtu
 * JD-Core Version:    0.7.0.1
 */