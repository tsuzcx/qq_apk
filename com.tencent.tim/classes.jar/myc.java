import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class myc
  implements Handler.Callback, View.OnClickListener
{
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private kcr jdField_a_of_type_Kcr;
  private mrr jdField_a_of_type_Mrr;
  private mrz jdField_a_of_type_Mrz;
  private myc.b jdField_a_of_type_Myc$b;
  private myc.c jdField_a_of_type_Myc$c;
  private int aVQ;
  private int aVR;
  private int aVS;
  private FrameLayout am;
  private boolean aqg;
  private boolean aqh;
  private boolean aqi;
  private boolean aqj = true;
  private boolean aqk;
  private kcs jdField_b_of_type_Kcs;
  private mrr jdField_b_of_type_Mrr;
  private mrr c;
  private List<myc.a> jH;
  private Context mContext;
  private Handler mHandler;
  private int mPlayCount;
  private String mUin;
  private Queue<mrr> n = new ArrayDeque();
  
  public myc(Activity paramActivity, FrameLayout paramFrameLayout, myc.c paramc)
  {
    this.mContext = paramActivity;
    this.am = paramFrameLayout;
    this.jdField_a_of_type_Myc$c = paramc;
    this.mHandler = new auru(this);
    this.jH = new ArrayList();
    paramActivity = kxm.getAppRuntime();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Kcr = ((kcr)paramActivity.getBusinessHandler(90));
      this.jdField_b_of_type_Kcs = new myc.d(null);
      this.mUin = paramActivity.getCurrentUin();
    }
  }
  
  private void a(mrr parammrr1, mrr parammrr2)
  {
    if (((parammrr1 instanceof mye.b)) && ((parammrr2 instanceof mye.b)))
    {
      parammrr1 = (mye.b)parammrr1;
      parammrr2 = (mye.b)parammrr2;
    }
    try
    {
      parammrr2 = parammrr2.d;
      if (parammrr2 != null)
      {
        parammrr2.mChannelID = parammrr1.d.mChannelID;
        parammrr2.mRecommendTime = parammrr1.d.mRecommendTime;
      }
      return;
    }
    catch (Throwable parammrr1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + parammrr1.getMessage());
    }
  }
  
  private void aTI()
  {
    if ((this.jdField_a_of_type_Kcr != null) && (this.jdField_b_of_type_Mrr != null)) {
      this.jdField_a_of_type_Kcr.a(this.jdField_b_of_type_Kcs, Long.parseLong(this.mUin), this.jdField_b_of_type_Mrr.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void aTK()
  {
    if (((this.mContext instanceof BaseActivity)) && (this.jdField_b_of_type_Kcs != null)) {
      ((BaseActivity)this.mContext).removeObserver(this.jdField_b_of_type_Kcs);
    }
  }
  
  private void aTL()
  {
    this.c.position = (this.jdField_b_of_type_Mrr.position + 1);
    a(this.jdField_b_of_type_Mrr, this.c);
  }
  
  private void playNextVideo()
  {
    if ((this.c != null) && (this.jdField_a_of_type_Mrz != null))
    {
      this.n.remove(this.c);
      if (this.jdField_a_of_type_Myc$b != null) {
        this.jdField_a_of_type_Myc$b.a(this.jdField_b_of_type_Mrr, this.c, this.aVR, this.aqk);
      }
      this.jdField_a_of_type_Mrz.a(this.c);
      this.mPlayCount += 1;
    }
    this.c = null;
    this.aqk = false;
  }
  
  public boolean EN()
  {
    return this.aqg;
  }
  
  public boolean EO()
  {
    return this.aqh;
  }
  
  public void O(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.mHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  public mrr a()
  {
    return this.jdField_b_of_type_Mrr;
  }
  
  public void a(mrr parammrr, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + parammrr);
    }
    this.aqg = true;
    this.jdField_b_of_type_Mrr = parammrr;
    this.mPlayCount = 1;
    this.aVR = paramInt;
    this.aqk = true;
    this.n.clear();
    if (this.jdField_b_of_type_Mrr != null)
    {
      if (parammrr.channelId == 409409L) {
        this.aVS = 0;
      }
    }
    else {
      return;
    }
    if (parammrr.channelId == 56L)
    {
      this.aVS = 1;
      return;
    }
    this.aVS = 2;
  }
  
  public void a(mrz parammrz)
  {
    this.jdField_a_of_type_Mrz = parammrz;
  }
  
  public void a(myc.b paramb)
  {
    this.jdField_a_of_type_Myc$b = paramb;
  }
  
  public void aTE()
  {
    this.aqg = false;
    if (this.jdField_b_of_type_Mrr != null) {
      this.jH.add(new myc.a(this.jdField_b_of_type_Mrr, this.mPlayCount));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public void aTF()
  {
    this.aqh = false;
    this.am.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
    aTK();
  }
  
  public void aTG()
  {
    if (!this.aqi) {
      sM(this.aVQ);
    }
  }
  
  public void aTH()
  {
    this.mHandler.removeMessages(1);
  }
  
  public void aTJ()
  {
    mrr localmrr = (mrr)this.n.peek();
    if (localmrr == null)
    {
      aTI();
      return;
    }
    c(localmrr);
  }
  
  public void b(mrr parammrr)
  {
    boolean bool = true;
    this.aqh = true;
    if (!aqiw.isWifiConnected(this.mContext))
    {
      this.aqi = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + parammrr + " mVideoRootFrameLayout:" + this.am);
      }
      if (((this.mContext instanceof BaseActivity)) && (this.jdField_b_of_type_Kcs != null)) {
        ((BaseActivity)this.mContext).addObserver(this.jdField_b_of_type_Kcs);
      }
      if ((parammrr != null) && (this.am != null))
      {
        this.jdField_a_of_type_Mrr = parammrr;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.mContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.resetUI();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(parammrr.title);
        if (!this.aqj) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(obs.a(parammrr.videoCoverUrl, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.am.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      aTJ();
      parammrr = new nce.a(null, null, parammrr.videoVid, parammrr.getInnerUniqueID()).a((int)parammrr.channelId).a().toJsonString();
      kbp.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.aVS), "", parammrr, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.aYs();
    }
  }
  
  public void c(mrr parammrr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + parammrr);
    }
    this.c = parammrr;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.aqi);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(parammrr);
    if (!this.aqi) {
      sM(3);
    }
    aTL();
  }
  
  public void doOnDestroy()
  {
    aTK();
    this.jdField_a_of_type_Kcr = null;
  }
  
  public String eV(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jH.iterator();
      while (localIterator.hasNext())
      {
        myc.a locala = (myc.a)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", locala.d.getInnerUniqueID());
        localJSONObject2.put("playCount", locala.playCount);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    localJSONObject1.put("first_rowKey", paramString);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l / 1000L));
        sM(paramMessage.arg1);
      }
    }
    else
    {
      return true;
    }
    O(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    return true;
  }
  
  public String kw()
  {
    return String.valueOf(this.aVS);
  }
  
  public void oK(boolean paramBoolean)
  {
    this.aqj = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aTF();
      if (this.jdField_a_of_type_Mrz != null) {
        this.jdField_a_of_type_Mrz.a(this.jdField_a_of_type_Mrr);
      }
      if (this.jdField_a_of_type_Mrr != null)
      {
        String str = new nce.a(null, null, this.jdField_a_of_type_Mrr.videoVid, this.jdField_a_of_type_Mrr.getInnerUniqueID()).a((int)this.jdField_a_of_type_Mrr.channelId).a().toJsonString();
        kbp.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.aVS), "", str, false);
        continue;
        if (this.jdField_a_of_type_Myc$b != null)
        {
          this.jdField_a_of_type_Myc$b.aCj();
          continue;
          if (this.c != null)
          {
            str = new nce.a(null, null, this.c.videoVid, this.c.getInnerUniqueID()).a((int)this.c.channelId).h(this.c.getInnerUniqueID()).a().toJsonString();
            kbp.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.aVS), "", str, false);
            aTF();
            playNextVideo();
          }
        }
      }
    }
  }
  
  public void sM(int paramInt)
  {
    this.aVQ = paramInt;
    if (!EO()) {
      return;
    }
    if (this.aVQ > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.sM(paramInt);
      O(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.c != null)
    {
      aTF();
      playNextVideo();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.aYr();
  }
  
  public static class a
  {
    mrr d;
    int playCount;
    
    public a(mrr parammrr, int paramInt)
    {
      this.d = parammrr;
      this.playCount = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(mrr parammrr1, mrr parammrr2, int paramInt, boolean paramBoolean);
    
    public abstract void aCj();
  }
  
  public static abstract interface c
  {
    public abstract List<mrr> Z(List<VideoInfo> paramList);
  }
  
  class d
    extends kcs
  {
    private d() {}
    
    protected void o(boolean paramBoolean, Bundle paramBundle)
    {
      super.o(paramBoolean, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "onGetRecommend:" + paramBoolean);
      }
      if (paramBoolean)
      {
        paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
        myc.a(myc.this).addAll(myc.a(myc.this).Z(paramBundle));
        myc.this.aTJ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myc
 * JD-Core Version:    0.7.0.1
 */