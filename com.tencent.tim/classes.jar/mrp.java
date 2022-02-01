import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.b;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class mrp
  implements Handler.Callback
{
  private mtg.b a;
  private boolean anD;
  private boolean anE;
  private boolean fV;
  private ArrayList<mrp.a> ll;
  private Context mContext;
  private Handler mHandler;
  
  public mrp(Context paramContext)
  {
    this.mContext = paramContext;
    this.mHandler = new Handler(this);
    this.ll = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    int i = 2;
    if ((paramVideoInfo == null) || (paramVideoInfo.b == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (mtg.h(paramVideoInfo.b)) {
        return 4;
      }
      if (paramVideoInfo.b.aGV != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.b.Wo);
        boolean bool = aqiz.isAppInstalled(this.mContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private void aRB()
  {
    Resources localResources;
    Object localObject;
    String str1;
    if ((this.a != null) && (this.a.rs != null))
    {
      localResources = this.a.rs.getResources();
      String str2 = "";
      localObject = str2;
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)
      {
        localObject = str2;
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null)
        {
          str1 = str2;
          if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b != null)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b.Wi)) {
              str1 = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b.Wi;
            }
          }
          localObject = str1;
          switch (a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d))
          {
          default: 
            localObject = str1;
          }
        }
      }
    }
    for (;;)
    {
      this.a.rs.setText((CharSequence)localObject);
      wja.dp2px(12.0F, localResources);
      return;
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        continue;
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = str1;
        }
      }
    }
  }
  
  private boolean c(VideoFeedsPlayManager.b paramb)
  {
    return (paramb != null) && (paramb.d != null) && (paramb.a != null) && (paramb.d.isAD) && (paramb.d.b != null);
  }
  
  public boolean DY()
  {
    if ((!this.anD) && (this.a != null) && (this.a.lB != null) && (this.a.lB.getVisibility() == 0))
    {
      if (this.anE)
      {
        this.a.lB.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.aj("continue_pause", false);
        this.anE = false;
        return true;
      }
      aRB();
      this.mHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.anE = false;
    return false;
  }
  
  public mtg.b a()
  {
    return this.a;
  }
  
  public void a(mrp.a parama)
  {
    if ((parama != null) && (!this.ll.contains(parama))) {
      this.ll.add(parama);
    }
  }
  
  public void aRC()
  {
    this.anD = true;
    doOnPause();
  }
  
  public void aRD()
  {
    this.anD = false;
    DY();
  }
  
  public void aRE()
  {
    if ((this.a != null) && (this.a.lB != null))
    {
      this.a.lB.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.aj("continue_pause", false);
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.fV = false;
  }
  
  public void aRF()
  {
    if ((this.a != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) && (a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d) != 3)) {
      this.anE = true;
    }
  }
  
  public boolean b(VideoFeedsPlayManager.b paramb)
  {
    if ((paramb == null) || (paramb.d == null) || (!paramb.d.isAD) || ((this.a != null) && (!this.fV) && (knc.b(paramb.d.b)))) {}
    while ((this.a == null) || (this.fV) || (!knc.a(paramb.d.b))) {
      return false;
    }
    mht localmht;
    boolean bool;
    label163:
    AdvertisementInfo localAdvertisementInfo;
    int m;
    int n;
    int i;
    label228:
    int j;
    label238:
    int i1;
    if ((c(paramb)) && (paramb.e != null) && (!paramb.a.amB))
    {
      if (paramb.e.de() != 0L) {
        break label496;
      }
      paramb.a.aSl = paramb.a.endPosition;
      paramb.a.endPosition = ((int)paramb.e.d(true));
      localmht = paramb.a;
      if (paramb.a.aSl != 0) {
        break label514;
      }
      bool = true;
      localmht.amz = bool;
      paramb.a.amA = true;
      paramb.a.amB = true;
      localmht = paramb.a;
      localAdvertisementInfo = jzk.a(paramb.d.b);
      m = localmht.aSl;
      n = localmht.endPosition;
      if (!localmht.amz) {
        break label520;
      }
      i = 1;
      if (!localmht.amA) {
        break label525;
      }
      j = 1;
      i1 = localmht.aSm;
      if (!localmht.autoPlay) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = jzk.a(m, n, i, j, i1, k, (int)paramb.e.getDuration(), jzk.aGr, 0);
      jzk.a(new kku.a().a(this.mContext).a(jzk.aEO).b(localmht.aSn).a(localAdvertisementInfo).a(paramb.d.b).a(localJSONObject).a());
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.resetTime();
      }
      aRB();
      if (this.a.lB != null)
      {
        this.a.lB.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.aj("continue_pause", true);
        if (this.a.lC != null) {
          this.a.lC.setVisibility(8);
        }
        paramb = ObjectAnimator.ofFloat(this.a.lB, "alpha", new float[] { 0.0F, 1.0F });
        paramb.setDuration(200L);
        paramb.setInterpolator(new DecelerateInterpolator());
        paramb.addListener(new mrq(this));
        paramb.start();
      }
      this.fV = false;
      this.mHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramb.a.aSl = ((int)paramb.e.de());
      break;
      bool = false;
      break label163;
      i = 0;
      break label228;
      j = 0;
      break label238;
    }
  }
  
  public void d(mtg.l paraml)
  {
    if (this.a != null)
    {
      this.a.lB.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.aj("continue_pause", false);
      this.mHandler.removeCallbacksAndMessages(null);
      this.fV = false;
    }
    if ((paraml instanceof mtg.b))
    {
      this.a = ((mtg.b)paraml);
      return;
    }
    this.a = null;
  }
  
  public void doOnDestory()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mContext != null) {
      this.mContext = null;
    }
    if (this.a != null) {
      this.a = null;
    }
    if (this.ll != null)
    {
      this.ll.clear();
      this.ll = null;
    }
  }
  
  public void doOnPause()
  {
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.a != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.ea(20)) {
        break label154;
      }
      if (this.a.lB != null)
      {
        this.a.lB.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.aj("continue_pause", false);
      }
      this.mHandler.removeCallbacksAndMessages(null);
      this.fV = true;
      if (this.ll != null)
      {
        paramMessage = this.ll.iterator();
        while (paramMessage.hasNext()) {
          ((mrp.a)paramMessage.next()).aRG();
        }
      }
      this.fV = false;
    }
    for (;;)
    {
      return true;
      label154:
      this.mHandler.sendEmptyMessageDelayed(1, 20L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aRG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrp
 * JD-Core Version:    0.7.0.1
 */