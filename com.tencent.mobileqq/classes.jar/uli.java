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
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class uli
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<ulk> jdField_a_of_type_JavaUtilArrayList;
  private swi jdField_a_of_type_Swi;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public uli(Context paramContext)
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
      if (shl.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bhfn.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(skq paramskq)
  {
    return (paramskq != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramskq.jdField_a_of_type_Rpz != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Swi != null) && (this.jdField_a_of_type_Swi.f != null))
    {
      localResources = this.jdField_a_of_type_Swi.f.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Swi.jdField_a_of_type_Skq == null) || (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130843150;
        if (localResources.getText(2131717750).toString().equals(localObject1)) {
          i = 2130843149;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Swi.f.setText((CharSequence)localObject1);
      int j = AIOUtils.dp2px(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Swi.f.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131717753).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717750).toString();
      break;
      localObject1 = localResources.getText(2131717751).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717801).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131717801).toString();
      break;
      if (localResources.getText(2131717751).toString().equals(localObject1)) {
        i = 2130843152;
      }
    }
  }
  
  public swi a()
  {
    return this.jdField_a_of_type_Swi;
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
    if (this.jdField_a_of_type_Swi != null) {
      this.jdField_a_of_type_Swi = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(swu paramswu)
  {
    if (this.jdField_a_of_type_Swi != null)
    {
      this.jdField_a_of_type_Swi.d.setVisibility(8);
      this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramswu instanceof swi))
    {
      this.jdField_a_of_type_Swi = ((swi)paramswu);
      return;
    }
    this.jdField_a_of_type_Swi = null;
  }
  
  public void a(ulk paramulk)
  {
    if ((paramulk != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramulk))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramulk);
    }
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Swi != null) && (this.jdField_a_of_type_Swi.d != null) && (this.jdField_a_of_type_Swi.d.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Swi.d.setVisibility(8);
        this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(skq paramskq)
  {
    if ((paramskq == null) || (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Swi != null) && (!this.jdField_a_of_type_Boolean) && (ukr.b(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Swi == null) || (this.jdField_a_of_type_Boolean) || (!ukr.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    rpz localrpz;
    boolean bool;
    label163:
    AdvertisementInfo localAdvertisementInfo;
    int m;
    int n;
    int i;
    label243:
    int j;
    label253:
    int i1;
    if ((b(paramskq)) && (paramskq.jdField_a_of_type_Spn != null) && (!paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Boolean))
    {
      if (paramskq.jdField_a_of_type_Spn.e() != 0L) {
        break label514;
      }
      paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Int = paramskq.jdField_a_of_type_Rpz.e;
      paramskq.jdField_a_of_type_Rpz.e = ((int)paramskq.jdField_a_of_type_Spn.b(true));
      localrpz = paramskq.jdField_a_of_type_Rpz;
      if (paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Int != 0) {
        break label532;
      }
      bool = true;
      localrpz.b = bool;
      paramskq.jdField_a_of_type_Rpz.h = ((int)paramskq.jdField_a_of_type_Spn.b());
      paramskq.jdField_a_of_type_Rpz.c = true;
      paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Boolean = true;
      localrpz = paramskq.jdField_a_of_type_Rpz;
      localAdvertisementInfo = ois.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localrpz.jdField_d_of_type_Int;
      n = localrpz.e;
      if (!localrpz.b) {
        break label538;
      }
      i = 1;
      if (!localrpz.c) {
        break label543;
      }
      j = 1;
      i1 = localrpz.f;
      if (!localrpz.jdField_a_of_type_Boolean) {
        break label548;
      }
    }
    label514:
    label532:
    label538:
    label543:
    label548:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = ois.a(m, n, i, j, i1, k, localrpz.h, 2, 0, localrpz.i, ReportConstants.VideoEndType.NORMAL_COMPLETE, true);
      ois.a(new ufy().a(this.jdField_a_of_type_AndroidContentContext).a(6).b(localrpz.g).a(localAdvertisementInfo).a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Swi.d != null)
      {
        this.jdField_a_of_type_Swi.d.setVisibility(0);
        this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a("continue_pause", true);
        if (this.jdField_a_of_type_Swi.e != null) {
          this.jdField_a_of_type_Swi.e.setVisibility(8);
        }
        paramskq = ObjectAnimator.ofFloat(this.jdField_a_of_type_Swi.d, "alpha", new float[] { 0.0F, 1.0F });
        paramskq.setDuration(200L);
        paramskq.setInterpolator(new DecelerateInterpolator());
        paramskq.addListener(new ulj(this));
        paramskq.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      paramskq.jdField_a_of_type_Rpz.jdField_d_of_type_Int = ((int)paramskq.jdField_a_of_type_Spn.e());
      break;
      bool = false;
      break label163;
      i = 0;
      break label243;
      j = 0;
      break label253;
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
    if ((this.jdField_a_of_type_Swi != null) && (this.jdField_a_of_type_Swi.d != null))
    {
      this.jdField_a_of_type_Swi.d.setVisibility(8);
      this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Swi != null) && (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
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
    if ((this.jdField_a_of_type_Swi != null) && (this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Swi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Swi.d != null)
      {
        this.jdField_a_of_type_Swi.d.setVisibility(8);
        this.jdField_a_of_type_Swi.jdField_a_of_type_Skq.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((ulk)paramMessage.next()).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uli
 * JD-Core Version:    0.7.0.1
 */