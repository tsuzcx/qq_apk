import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.3;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class pvv
  implements IEventReceiver, pum.b
{
  pvi a;
  public pvu a;
  public pvz a;
  boolean aCl = false;
  protected pum b;
  private final pmd c = new pvw(this);
  public QQAppInterface mApp;
  protected boolean mAttached;
  protected List<Subscriber> mG;
  
  public pvv(pvz parampvz, pvu parampvu, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Pvz = parampvz;
    this.jdField_a_of_type_Pvu = parampvu;
    this.mApp = paramQQAppInterface;
  }
  
  private StoryVideoItem a(puh parampuh, @NonNull String paramString)
  {
    ArrayList localArrayList = new ArrayList(parampuh.iO.size());
    localArrayList.addAll(parampuh.iO);
    int i = 0;
    String str;
    Object localObject;
    if (i < localArrayList.size()) {
      if (TextUtils.equals(((pux)localArrayList.get(i)).vid, paramString))
      {
        if (i + 1 >= localArrayList.size()) {
          break label244;
        }
        str = ((pux)localArrayList.get(i + 1)).vid;
        localObject = ((pux)localArrayList.get(i + 1)).feedId;
      }
    }
    for (;;)
    {
      psu localpsu = (psu)psx.a(5);
      StoryVideoItem localStoryVideoItem;
      if (str != null)
      {
        localStoryVideoItem = localpsu.a(str);
        if (localStoryVideoItem != null)
        {
          ram.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", parampuh.unionId, str);
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
            localObject = localpsu.a(((pux)localArrayList.get(i)).vid);
            if (localObject != null)
            {
              ram.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "findLoadedVideo, unionId=%s curVid=%s", parampuh.unionId, paramString);
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
  
  private void a(puh parampuh, int paramInt)
  {
    List localList;
    if ((this.jdField_a_of_type_Pvu != null) && (parampuh != null))
    {
      ram.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, changedData:%s, insertPosition:%s, AdapterList:%s, headerView:%s", parampuh, Integer.valueOf(paramInt), this.jdField_a_of_type_Pvu.be(), Integer.valueOf(this.jdField_a_of_type_Pvu.st()));
      localList = this.jdField_a_of_type_Pvu.be();
      if (localList == null) {
        break label90;
      }
    }
    label90:
    for (int i = localList.size(); (paramInt < 0) || (paramInt >= i); i = 0)
    {
      ram.w("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "insertOrReplaceStoryNodeItem, insertPosition illegal, list size = %s", new Object[] { Integer.valueOf(i) });
      return;
    }
    this.jdField_a_of_type_Pvu.i(parampuh, paramInt);
  }
  
  private void a(qgy.c paramc, String paramString)
  {
    ram.b("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s", paramc, paramString);
    if (!(paramc instanceof qhc.a)) {}
    puh localpuh;
    do
    {
      return;
      localpuh = ((puy)this.mApp.getManager(251)).d(((qhc.a)paramc).getUnionId());
      if (localpuh == null)
      {
        ram.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onMsgTabStoryDataUpdate. groupId=%s, vid=%s, nodeInfo is null! return!", new Object[] { paramc, paramString });
        return;
      }
    } while ((localpuh.nodeType != 12) || (!(paramc instanceof qhc.a)));
    Bosses.get().postJob(new pvy(this, "Q.qqstory.msgTab.MsgTabStoryNodeDelegate", localpuh, paramString));
  }
  
  private void ef(List<puh> paramList)
  {
    if ((this.jdField_a_of_type_Pvu != null) && (paramList != null))
    {
      this.jdField_a_of_type_Pvu.D(paramList);
      eh(paramList);
    }
  }
  
  private void eg(List<puh> paramList)
  {
    if ((this.jdField_a_of_type_Pvu != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_Pvu.E(paramList);
      eh(paramList);
    }
  }
  
  private void p(puh parampuh)
  {
    if ((this.jdField_a_of_type_Pvu != null) && (parampuh != null)) {
      this.jdField_a_of_type_Pvu.aj(parampuh);
    }
  }
  
  public void a(puh parampuh, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((paramBoolean1) && (parampuh != null) && (parampuh.nodeType == 8) && (!TextUtils.isEmpty(parampuh.unionId))) {
        new pxm(parampuh.unionId, String.valueOf(System.currentTimeMillis())).sendRequest();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "singleDataChange, data=" + parampuh + ", type=" + paramInt1);
      }
      return;
      a(parampuh, paramInt2);
      eh(Collections.singletonList(parampuh));
      if ((paramBoolean1) && (paramBoolean2))
      {
        ram.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_INSERT_OR_REPLACE");
        this.jdField_a_of_type_Pvz.bno();
        continue;
        o(parampuh);
        eh(Collections.singletonList(parampuh));
        if ((paramBoolean1) && (paramBoolean2))
        {
          ram.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onSingleDataChange, startBreath TYPE_UPDATE");
          this.jdField_a_of_type_Pvz.bno();
          continue;
          p(parampuh);
        }
      }
    }
  }
  
  public void aNg()
  {
    Object localObject = (puy)this.mApp.getManager(251);
    this.b = ((puy)localObject).a();
    this.jdField_a_of_type_Pvi = ((puy)localObject).a();
    ef(this.b.br());
    this.b.a(this);
    this.b.vY(1);
    this.mG = new ArrayList();
    this.mG.add(new pvv.f(this));
    this.mG.add(new pvv.a(this));
    this.mG.add(new pvv.d(this));
    this.mG.add(new pvv.j(this));
    this.mG.add(new pvv.b(this));
    this.mG.add(new pvv.c(this));
    this.mG.add(new pvv.e(this));
    this.mG.add(new pvv.h(this));
    this.mG.add(new pvv.i(this));
    this.mApp.addObserver(this.c);
    this.jdField_a_of_type_Pvi.a(new pvx(this));
    localObject = this.mG.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Iterator)localObject).next();
      pmi.a().registerSubscriber("", localSubscriber);
    }
    this.mAttached = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onAttached");
    }
  }
  
  public void b(ArrayList<puh> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ram.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "onDataSetChange() %s, %b, %b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3));
    if (paramBoolean1)
    {
      ef(paramArrayList);
      if (this.jdField_a_of_type_Pvz.Ay != 0L)
      {
        rar.b("msgtab", "data_time", (int)(System.currentTimeMillis() - this.jdField_a_of_type_Pvz.Ay), 0, new String[] { "" });
        this.jdField_a_of_type_Pvz.Ay = 0L;
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
          puh localpuh = (puh)localIterator.next();
          if ((localpuh.nodeType == 8) && (!TextUtils.isEmpty(localpuh.unionId)))
          {
            localArrayList.add(localpuh.unionId);
            continue;
            eg(paramArrayList);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        new pxm(localArrayList, String.valueOf(System.currentTimeMillis())).sendRequest();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, new Object[] { "dataSetChange dataList = ", paramArrayList });
    }
  }
  
  public void b(puh parampuh, int paramInt)
  {
    QQUserUIItem localQQUserUIItem = ((ptf)psx.a(2)).b(parampuh.unionId);
    if (localQQUserUIItem == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "SUBSCRIBE failed: user is null, unionId = " + parampuh.unionId);
      }
      return;
    }
    parampuh = (pma)qem.getQQAppInterface().getBusinessHandler(98);
    if (localQQUserUIItem.isVip()) {}
    for (int i = 1;; i = 0)
    {
      parampuh.b(i, localQQUserUIItem.uid, paramInt, 14);
      return;
    }
  }
  
  public void bmQ()
  {
    this.jdField_a_of_type_Pvz.jdField_a_of_type_Pvu.notifyDataSetChanged();
  }
  
  public void bng() {}
  
  public void bq(String paramString, int paramInt)
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
    int i25 = this.jdField_a_of_type_Pvu.getItemCount();
    int i23 = 0;
    puh localpuh;
    if (i23 < i25)
    {
      localpuh = (puh)this.jdField_a_of_type_Pvu.getItem(i23);
      if (localpuh != null) {}
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
      switch (localpuh.nodeType)
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
        if (localpuh.unreadCount != 0) {
          j = 1;
        }
        if (!localpuh.redPoint) {
          break label1523;
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
        if (localpuh.bkt > 0) {}
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
          str = localpuh.nodeVid;
          l2 = localpuh.N(str);
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
          localStringBuilder.append(",\"text\":").append("\"").append(this.jdField_a_of_type_Pvz.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.mE()).append("\"");
          localStringBuilder.append(",\"msg\":").append(i);
        }
        localStringBuilder.append("}");
        rar.a("msg_tab", paramString, 0, j, new String[] { ((JSONObject)localObject).toString(), String.valueOf(i25), localStringBuilder.toString(), String.valueOf(paramInt) });
        return;
      }
      catch (JSONException paramString)
      {
        ram.e("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "ReportError:" + paramString.getMessage());
        return;
      }
      label1523:
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
  
  public void cs(String paramString1, String paramString2)
  {
    int i = this.jdField_a_of_type_Pvu.bf(paramString1);
    this.jdField_a_of_type_Pvz.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.mRecyclerView.scrollToPosition(i);
    if (!pvs.Jh()) {
      return;
    }
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeDelegate.3(this, paramString1));
  }
  
  public void eh(List<puh> paramList)
  {
    Context localContext = this.jdField_a_of_type_Pvz.mContext;
    if ((!paramList.isEmpty()) && (this.jdField_a_of_type_Pvi != null)) {
      this.jdField_a_of_type_Pvi.b(localContext, paramList);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void o(puh parampuh)
  {
    if ((this.jdField_a_of_type_Pvu != null) && (parampuh != null)) {
      this.jdField_a_of_type_Pvu.d(parampuh);
    }
  }
  
  public void onAccountChange(QQAppInterface paramQQAppInterface)
  {
    boolean bool = this.mAttached;
    if (bool) {
      onDetached();
    }
    this.mApp = paramQQAppInterface;
    if (bool) {
      aNg();
    }
  }
  
  public void onDetached()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", 2, "onDetached");
      }
      this.mAttached = false;
      if (this.b != null) {
        this.b.b(this);
      }
      if (this.mG != null)
      {
        Iterator localIterator = this.mG.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          pmi.a().unRegisterSubscriber(localSubscriber);
        }
        this.mG.clear();
      }
    }
    finally {}
    this.mApp.removeObserver(this.c);
    if (this.jdField_a_of_type_Pvi != null) {
      this.jdField_a_of_type_Pvi.stopDownload();
    }
    this.jdField_a_of_type_Pvu.YW();
  }
  
  public void q(puh parampuh)
  {
    pma localpma = (pma)qem.getQQAppInterface().getBusinessHandler(98);
    String str = parampuh.unionId;
    if ((parampuh.nodeType == 10) || (parampuh.nodeType == 11)) {
      str = null;
    }
    localpma.c(str, parampuh.nodeType, 1, parampuh.recommendId);
    this.b.h(parampuh);
  }
  
  public void sn(boolean paramBoolean) {}
  
  public void so(boolean paramBoolean) {}
  
  protected void wb(int paramInt)
  {
    if (this.b != null)
    {
      Iterator localIterator = new ArrayList(this.b.bq()).iterator();
      while (localIterator.hasNext())
      {
        puh localpuh = (puh)localIterator.next();
        if ((localpuh != null) && (localpuh.nodeType == paramInt)) {
          o(localpuh);
        }
      }
    }
  }
  
  public static class a
    extends QQUIEventReceiver<pvv, psg>
  {
    public a(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull psg parampsg)
    {
      parampvv.b.b(parampsg);
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
  }
  
  public static class b
    extends QQUIEventReceiver<pvv, pxm.a>
  {
    public b(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull pxm.a parama)
    {
      if (parama.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
      {
        if (QLog.isColorLevel()) {
          QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: " + parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
        }
        if (parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null) {
          parampvv.o(parampvv.b.a(8, parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId));
        }
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("zivonchen", 2, "MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: " + parama.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage + ", sharegroupInfo = " + parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
    }
    
    public Class acceptEventClass()
    {
      return pxm.a.class;
    }
  }
  
  public static class c
    extends QQUIEventReceiver<pvv, qiy>
  {
    public c(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull qiy paramqiy)
    {
      if ((parampvv.a.mF().equals(paramqiy.axu)) && ((paramqiy.a instanceof qhc.a))) {
        parampvv.cs(((qhc.a)paramqiy.a).getUnionId(), paramqiy.vid);
      }
    }
    
    public Class acceptEventClass()
    {
      return qiy.class;
    }
  }
  
  public static final class d
    extends QQUIEventReceiver<pvv, ptk>
  {
    public d(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull ptk paramptk)
    {
      ram.b(this.TAG, "onEvent, %s", String.valueOf(paramptk));
      puh localpuh = parampvv.b.a(3, "");
      if ((localpuh != null) && (paramptk.vid.equals(localpuh.nodeVid)))
      {
        ram.d(this.TAG, "onEvent, guideInfoNode read");
        parampvv = new pvh();
        parampvv.unionId = localpuh.unionId;
        parampvv.nodeType = localpuh.nodeType;
        parampvv.operation = 5;
        parampvv.recommendId = localpuh.recommendId;
        ppv.a().a(parampvv, null);
        return;
      }
      parampvv.b.K(paramptk.unionId, paramptk.Ak);
    }
    
    public Class acceptEventClass()
    {
      return ptk.class;
    }
  }
  
  public static final class e
    extends QQUIEventReceiver<pvv, pug>
  {
    public e(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull pug parampug)
    {
      parampvv.b.rr(parampug.unionId);
    }
    
    public Class acceptEventClass()
    {
      return pug.class;
    }
  }
  
  public static class f
    extends QQUIEventReceiver<pvv, pnx.d>
  {
    public f(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull pnx.d paramd)
    {
      parampvv.b.b(paramd);
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
  
  public static class g
    extends plt
  {
    public qgy.c a;
    public String vid;
    
    public g(qgy.c paramc, String paramString)
    {
      this.a = paramc;
      this.vid = paramString;
    }
    
    public String toString()
    {
      return "UpdateMsgTabCoverEvent{, groupId=" + this.a + ", vid='" + this.vid + '\'' + '}';
    }
  }
  
  public static class h
    extends QQUIEventReceiver<pvv, pvv.g>
  {
    public h(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull pvv.g paramg)
    {
      pvv.a(parampvv, paramg.a, paramg.vid);
    }
    
    public Class acceptEventClass()
    {
      return pvv.g.class;
    }
  }
  
  public static class i
    extends QQUIEventReceiver<pvv, puz.b>
  {
    public i(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull puz.b paramb)
    {
      parampvv.a.a.bindData();
    }
    
    public Class acceptEventClass()
    {
      return puz.b.class;
    }
  }
  
  public static class j
    extends QQUIEventReceiver<pvv, pxs.b>
  {
    public j(@NonNull pvv parampvv)
    {
      super();
    }
    
    public void a(@NonNull pvv parampvv, @NonNull pxs.b paramb)
    {
      if ((paramb.b.isSuccess()) && (paramb.mX != null) && (!paramb.mX.isEmpty())) {
        parampvv.b.b(paramb);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramb.b + ", userUIItems = " + paramb.mX);
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvv
 * JD-Core Version:    0.7.0.1
 */