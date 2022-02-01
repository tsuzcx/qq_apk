import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.2;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ytd
  extends auvp
  implements amfh, Handler.Callback, aqdf.a, SwipListView.c, ysf.a
{
  private amhj jdField_a_of_type_Amhj;
  private aqdf jdField_a_of_type_Aqdf;
  private yrr jdField_a_of_type_Yrr = new yrr();
  private yrw jdField_a_of_type_Yrw;
  private ysf jdField_a_of_type_Ysf;
  public SystemMsgListView b;
  public int bKH = -1;
  private boolean boE = true;
  private int caS;
  protected Runnable eK = new SystemMsgListAdapter.2(this);
  private Hashtable<String, Bitmap> h = new Hashtable();
  private QQAppInterface mApp;
  private Context mContext;
  private FlingHandler mFlingHandler;
  public XListView mListView;
  public Handler mUiHandler = null;
  private ConcurrentLinkedQueue<Long> r = new ConcurrentLinkedQueue();
  private List<ysa> te = new ArrayList();
  
  public ytd(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    this.caS = paramInt;
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.b = paramSystemMsgListView;
    this.mListView = paramXListView;
    this.jdField_a_of_type_Aqdf = new aqdf(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.jdField_a_of_type_Ysf = ((ysf)this.mApp.getManager(34));
    this.jdField_a_of_type_Amhj = ((amhj)this.mApp.getManager(15));
    this.mUiHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Amhj.addListener(this);
    this.jdField_a_of_type_Ysf.a(this);
    this.mFlingHandler = paramFlingHandler;
    this.jdField_a_of_type_Ysf.Ez(0);
  }
  
  private void EB(int paramInt)
  {
    ThreadManager.postImmediately(new SystemMsgListAdapter.1(this, paramInt), null, true);
  }
  
  private void a(ytx paramytx)
  {
    if ((paramytx == null) || (paramytx.data == null) || (paramytx.data.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
      }
    }
    do
    {
      return;
      paramytx = paramytx.data;
    } while (this.b == null);
    this.b.y(paramytx, xt());
  }
  
  private void fS(int paramInt1, int paramInt2)
  {
    if (!Um())
    {
      this.jdField_a_of_type_Yrr.clc();
      refreshData();
    }
    achg localachg;
    Bundle localBundle;
    if ((aqiw.isNetSupport(this.mContext)) && (gL(paramInt2)))
    {
      localachg = (achg)this.mApp.getManager(159);
      localBundle = new Bundle();
      localBundle.putString("from", "3");
      if (paramInt1 > 0) {
        break label95;
      }
      localBundle.putInt("load_biz_type", 1);
      localachg.a(4, this.jdField_a_of_type_Yrr.aCj, localBundle);
    }
    label95:
    while (paramInt1 >= 5) {
      return;
    }
    localBundle.putInt("load_biz_type", 3);
    localachg.b(4, this.jdField_a_of_type_Yrr.aCj, localBundle);
  }
  
  private boolean gK(int paramInt)
  {
    if (this.b != null) {
      return this.b.gM(paramInt);
    }
    return false;
  }
  
  public void Az(int paramInt)
  {
    refreshData();
  }
  
  public boolean Um()
  {
    int i = xt();
    Iterator localIterator = ((achg)this.mApp.getManager(159)).cu().iterator();
    while (localIterator.hasNext()) {
      if (((yrh)localIterator.next()).tab_id == i) {
        return true;
      }
    }
    return false;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, paramInt, true, (byte)0);
    }
    return aqhu.G();
  }
  
  public yrr a()
  {
    return this.jdField_a_of_type_Yrr;
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(ysa paramysa)
  {
    if ((this.te != null) && (this.te.size() > 0)) {
      this.te.remove(paramysa);
    }
  }
  
  public void al(boolean paramBoolean)
  {
    Object localObject;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.mFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void bLU()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    Handler localHandler = this.mUiHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 200L);
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public void bLV()
  {
    refreshData();
  }
  
  public void ckT()
  {
    this.jdField_a_of_type_Aqdf.edu();
    this.jdField_a_of_type_Aqdf.pause();
  }
  
  public void ckU()
  {
    if (this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.resume();
    }
  }
  
  public void ckV()
  {
    int j = this.mListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.mListView.getChildAt(i).getTag();
      if ((localObject instanceof ytc.a)) {
        h((ytc.a)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof yrx.a))
        {
          localObject = (yrx.a)localObject;
          ((yrx.a)localObject).uw.setImageBitmap(a(11, ((yrx.a)localObject).aZH));
        }
        else if ((localObject instanceof yry.a))
        {
          localObject = (yry.a)localObject;
          ((yry.a)localObject).uw.setImageBitmap(a(1, ((yry.a)localObject).aZH));
        }
        else if ((localObject instanceof ysy.a))
        {
          localObject = (ysy.a)localObject;
          ((ysy.a)localObject).uw.setImageBitmap(a(11, ((ysy.a)localObject).aZH));
        }
        else if ((localObject instanceof yrw.a))
        {
          localObject = (yrw.a)localObject;
          if ((((yrw.a)localObject).aZC != null) && (((yrw.a)localObject).aZC.length() > 0)) {
            ((yrw.a)localObject).uz.setImageBitmap(a(11, ((yrw.a)localObject).aZC));
          }
          if ((((yrw.a)localObject).aZD != null) && (((yrw.a)localObject).aZD.length() > 0)) {
            ((yrw.a)localObject).uA.setImageBitmap(a(11, ((yrw.a)localObject).aZD));
          }
          if ((((yrw.a)localObject).aZE != null) && (((yrw.a)localObject).aZE.length() > 0)) {
            ((yrw.a)localObject).uB.setImageBitmap(a(11, ((yrw.a)localObject).aZE));
          }
          if ((((yrw.a)localObject).aZF != null) && (((yrw.a)localObject).aZF.length() > 0)) {
            ((yrw.a)localObject).uC.setImageBitmap(a(11, ((yrw.a)localObject).aZF));
          }
          if ((((yrw.a)localObject).aZG != null) && (((yrw.a)localObject).aZG.length() > 0)) {
            ((yrw.a)localObject).uD.setImageBitmap(a(11, ((yrw.a)localObject).aZG));
          }
        }
        else if ((localObject instanceof ysx.a))
        {
          localObject = (ysx.a)localObject;
          ((ysx.a)localObject).uw.setImageBitmap(a(1, ((ysx.a)localObject).aZH));
        }
      }
    }
  }
  
  public void ckZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()))
    {
      this.mListView.removeCallbacks(this.eK);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      int i = this.mListView.getFirstVisiblePosition();
      if ((i <= this.mListView.getLastVisiblePosition()) && (i < getCount()))
      {
        Object localObject = (ysa)getItem(i);
        if ((localObject instanceof yry))
        {
          localArrayList1.add(((yry)localObject).pQ());
          localArrayList2.add(((yry)localObject).getRecommendReason());
          localArrayList3.add(Integer.valueOf(((yry)localObject).xm()));
          localArrayList4.add(((yry)localObject).M());
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof ysr))
          {
            localObject = ((ysr)localObject).bR();
            if (localObject != null) {
              localArrayList5.addAll((Collection)localObject);
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgListAdapter", 2, "reportRecommendFrdExpose exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      ContactReportUtils.a(this.mApp, xt(), localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "3");
    }
  }
  
  public void clh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()))
    {
      int i = this.mListView.getFirstVisiblePosition();
      while ((i <= this.mListView.getLastVisiblePosition()) && (i < getCount()))
      {
        ysa localysa = (ysa)getItem(i);
        if ((localysa instanceof yry)) {
          ((yry)localysa).clh();
        }
        i += 1;
      }
    }
    if (this.mListView != null)
    {
      this.mListView.removeCallbacks(this.eK);
      this.mListView.postDelayed(this.eK, 1000L);
    }
  }
  
  public void cli()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "stopVisibleExpose firstVisible: " + this.mListView.getFirstVisiblePosition() + " lastvisible: " + this.mListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.mListView.isShown()))
    {
      int i = this.mListView.getFirstVisiblePosition();
      while ((i <= this.mListView.getLastVisiblePosition()) && (i < getCount()))
      {
        ysa localysa = (ysa)getItem(i);
        if ((localysa instanceof yry)) {
          ((yry)localysa).cli();
        }
        i += 1;
      }
    }
    if (this.mListView != null) {
      this.mListView.removeCallbacks(this.eK);
    }
  }
  
  public void d(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.bKH = i;
      return;
    }
  }
  
  public void destroy()
  {
    this.mListView.setOnScrollListener(null);
    this.jdField_a_of_type_Ysf.Ez(0);
    this.jdField_a_of_type_Ysf.b(this);
    this.jdField_a_of_type_Amhj.removeListener(this);
    if (this.mUiHandler != null) {
      this.mUiHandler.removeCallbacksAndMessages(null);
    }
    this.te.clear();
    this.jdField_a_of_type_Aqdf.a(null);
    this.jdField_a_of_type_Aqdf.destory();
  }
  
  public void fT(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Yrr != null)
    {
      this.jdField_a_of_type_Yrr.caN = paramInt2;
      this.jdField_a_of_type_Yrr.aCj = paramInt1;
    }
  }
  
  public void fU(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SystemMsgListAdapter", 2, "onConnectionTabSelected tabId : " + paramInt1 + ", position =" + paramInt2);
    }
    fT(paramInt1, paramInt2);
    if (this.b != null) {
      this.b.setStickHeadSelection(paramInt2);
    }
    gs(0L);
  }
  
  public boolean gL(int paramInt)
  {
    boolean bool = ((zbq)this.mApp.getManager(295)).Vf();
    if (paramInt == 23) {}
    for (paramInt = 1; (paramInt != 0) || (!bool); paramInt = 0) {
      return true;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.te.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.te.size())) {
      return new Object();
    }
    return this.te.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = ((ysa)getItem(paramInt)).a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void gs(long paramLong)
  {
    Handler localHandler = this.mUiHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public void gt(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.r.size() > 0)
    {
      Iterator localIterator = this.r.iterator();
      Long localLong;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localLong = (Long)localIterator.next();
      } while ((localLong == null) || (localLong.longValue() != paramLong));
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        refreshData();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate discussUin: %d needRefresh: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public void h(ytc.a parama)
  {
    if ((parama == null) || (parama.uw == null)) {
      return;
    }
    int i = parama.a.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (acff)this.mApp.getManager(51);
      if ((localObject1 != null) && (((acff)localObject1).isFriend(String.valueOf(parama.a.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Aqdf.a(32, String.valueOf(parama.a.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Aqdf.isPausing())
          {
            this.jdField_a_of_type_Aqdf.a(String.valueOf(parama.a.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = aqhu.G();
        }
        parama.uw.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Aqdf.b(1, String.valueOf(parama.a.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Aqdf.isPausing())
          {
            this.jdField_a_of_type_Aqdf.i(String.valueOf(parama.a.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      EB(xt());
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 2) {
        notifyDataSetChanged();
      } else if (paramMessage.what == 3) {
        a((ytx)paramMessage.obj);
      }
    }
  }
  
  public void hi() {}
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.h.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.mListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.mListView.getChildAt(paramInt1).getTag();
        if (paramString != null)
        {
          if (!(paramString instanceof yrw.a)) {
            break label305;
          }
          paramString = (yrw.a)paramString;
          if ((paramString.aZC != null) && (paramString.aZC.length() > 0))
          {
            paramBitmap = (Bitmap)this.h.get(paramString.aZC);
            if (paramBitmap != null) {
              paramString.uz.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.aZD != null) && (paramString.aZD.length() > 0))
          {
            paramBitmap = (Bitmap)this.h.get(paramString.aZD);
            if (paramBitmap != null) {
              paramString.uA.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.aZE != null) && (paramString.aZE.length() > 0))
          {
            paramBitmap = (Bitmap)this.h.get(paramString.aZE);
            if (paramBitmap != null) {
              paramString.uB.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.aZF != null) && (paramString.aZF.length() > 0))
          {
            paramBitmap = (Bitmap)this.h.get(paramString.aZF);
            if (paramBitmap != null) {
              paramString.uC.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.aZG != null) && (paramString.aZG.length() > 0))
          {
            paramBitmap = (Bitmap)this.h.get(paramString.aZG);
            if (paramBitmap != null) {
              paramString.uD.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label305:
          if ((!(paramString instanceof yss.a)) && (!(paramString instanceof ysl.a)) && (!(paramString instanceof ysc.a)) && (!(paramString instanceof ysr.a)) && (!(paramString instanceof ysw.a)) && (!(paramString instanceof ysu.a)) && (!(paramString instanceof yse.a)) && (!(paramString instanceof ysv.a)) && (!(paramString instanceof yst.a)))
          {
            paramString = (ysa.a)paramString;
            if ((paramString.aZH != null) && (paramString.aZH.length() > 0))
            {
              paramBitmap = (Bitmap)this.h.get(paramString.aZH);
              if (paramBitmap != null) {
                paramString.uw.setImageBitmap(paramBitmap);
              }
            }
          }
        }
      }
      this.h.clear();
    }
  }
  
  public void refreshData()
  {
    gs(400L);
  }
  
  public int xs()
  {
    int i = this.mListView.getFirstVisiblePosition();
    if (i == 0) {
      return 0;
    }
    return i - 1;
  }
  
  public int xt()
  {
    if (this.jdField_a_of_type_Yrr != null) {
      return this.jdField_a_of_type_Yrr.aCj;
    }
    return -1;
  }
  
  public int xu()
  {
    if (this.jdField_a_of_type_Yrr != null) {
      return this.jdField_a_of_type_Yrr.caN;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ytd
 * JD-Core Version:    0.7.0.1
 */