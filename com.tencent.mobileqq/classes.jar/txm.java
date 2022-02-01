import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class txm
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<txo> jdField_a_of_type_JavaUtilArrayList;
  private rvi jdField_a_of_type_Rvi;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public txm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    int i = 2;
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (ruw.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bfwv.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(ryo paramryo)
  {
    return (paramryo != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramryo.jdField_a_of_type_Rds != null) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Rvi != null) && (this.jdField_a_of_type_Rvi.h != null))
    {
      localResources = this.jdField_a_of_type_Rvi.h.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo == null) || (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130843114;
        if (localResources.getText(2131717384).toString().equals(localObject1)) {
          i = 2130843113;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rvi.h.setText((CharSequence)localObject1);
      int j = AIOUtils.dp2px(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Rvi.h.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131717387).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717384).toString();
      break;
      localObject1 = localResources.getText(2131717385).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717435).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131717435).toString();
      break;
      if (localResources.getText(2131717385).toString().equals(localObject1)) {
        i = 2130843116;
      }
    }
  }
  
  public rvi a()
  {
    return this.jdField_a_of_type_Rvi;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_Rvi != null) {
      this.jdField_a_of_type_Rvi = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(rvv paramrvv)
  {
    if (this.jdField_a_of_type_Rvi != null)
    {
      this.jdField_a_of_type_Rvi.e.setVisibility(8);
      this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramrvv instanceof rvi))
    {
      this.jdField_a_of_type_Rvi = ((rvi)paramrvv);
      return;
    }
    this.jdField_a_of_type_Rvi = null;
  }
  
  public void a(txo paramtxo)
  {
    if ((paramtxo != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramtxo))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramtxo);
    }
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Rvi != null) && (this.jdField_a_of_type_Rvi.e != null) && (this.jdField_a_of_type_Rvi.e.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Rvi.e.setVisibility(8);
        this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(ryo paramryo)
  {
    if ((paramryo == null) || (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Rvi != null) && (!this.jdField_a_of_type_Boolean) && (twq.b(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Rvi == null) || (this.jdField_a_of_type_Boolean) || (!twq.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    rds localrds;
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
    if ((b(paramryo)) && (paramryo.jdField_a_of_type_Sdj != null) && (!paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Boolean))
    {
      if (paramryo.jdField_a_of_type_Sdj.e() != 0L) {
        break label496;
      }
      paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Int = paramryo.jdField_a_of_type_Rds.e;
      paramryo.jdField_a_of_type_Rds.e = ((int)paramryo.jdField_a_of_type_Sdj.b(true));
      localrds = paramryo.jdField_a_of_type_Rds;
      if (paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localrds.b = bool;
      paramryo.jdField_a_of_type_Rds.c = true;
      paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Boolean = true;
      localrds = paramryo.jdField_a_of_type_Rds;
      localAdvertisementInfo = obb.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localrds.jdField_d_of_type_Int;
      n = localrds.e;
      if (!localrds.b) {
        break label520;
      }
      i = 1;
      if (!localrds.c) {
        break label525;
      }
      j = 1;
      i1 = localrds.f;
      if (!localrds.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = obb.a(m, n, i, j, i1, k, (int)paramryo.jdField_a_of_type_Sdj.b(), obb.aP, 0);
      obb.a(new trn().a(this.jdField_a_of_type_AndroidContentContext).a(obb.f).b(localrds.g).a(localAdvertisementInfo).a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Rvi.e != null)
      {
        this.jdField_a_of_type_Rvi.e.setVisibility(0);
        this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a("continue_pause", true);
        if (this.jdField_a_of_type_Rvi.f != null) {
          this.jdField_a_of_type_Rvi.f.setVisibility(8);
        }
        paramryo = ObjectAnimator.ofFloat(this.jdField_a_of_type_Rvi.e, "alpha", new float[] { 0.0F, 1.0F });
        paramryo.setDuration(200L);
        paramryo.setInterpolator(new DecelerateInterpolator());
        paramryo.addListener(new txn(this));
        paramryo.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramryo.jdField_a_of_type_Rds.jdField_d_of_type_Int = ((int)paramryo.jdField_a_of_type_Sdj.e());
      break;
      bool = false;
      break label163;
      i = 0;
      break label228;
      j = 0;
      break label238;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.b = true;
    b();
  }
  
  public void d()
  {
    this.b = false;
    a();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Rvi != null) && (this.jdField_a_of_type_Rvi.e != null))
    {
      this.jdField_a_of_type_Rvi.e.setVisibility(8);
      this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rvi != null) && (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
      this.c = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Rvi != null) && (this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Rvi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Rvi.e != null)
      {
        this.jdField_a_of_type_Rvi.e.setVisibility(8);
        this.jdField_a_of_type_Rvi.jdField_a_of_type_Ryo.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((txo)paramMessage.next()).a();
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return true;
      label154:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txm
 * JD-Core Version:    0.7.0.1
 */