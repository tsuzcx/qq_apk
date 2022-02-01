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
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class tqy
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ArrayList<tra> jdField_a_of_type_JavaUtilArrayList;
  private rog jdField_a_of_type_Rog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public tqy(Context paramContext)
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
      if (rnu.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = bhny.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(rrm paramrrm)
  {
    return (paramrrm != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramrrm.jdField_a_of_type_Qwu != null) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.h != null))
    {
      localResources = this.jdField_a_of_type_Rog.h.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm == null) || (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130843060;
        if (localResources.getText(2131717147).toString().equals(localObject1)) {
          i = 2130843059;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Rog.h.setText((CharSequence)localObject1);
      int j = agej.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_Rog.h.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131717150).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717147).toString();
      break;
      localObject1 = localResources.getText(2131717148).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131717202).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131717202).toString();
      break;
      if (localResources.getText(2131717148).toString().equals(localObject1)) {
        i = 2130843062;
      }
    }
  }
  
  public rog a()
  {
    return this.jdField_a_of_type_Rog;
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
    if (this.jdField_a_of_type_Rog != null) {
      this.jdField_a_of_type_Rog = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(rot paramrot)
  {
    if (this.jdField_a_of_type_Rog != null)
    {
      this.jdField_a_of_type_Rog.e.setVisibility(8);
      this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramrot instanceof rog))
    {
      this.jdField_a_of_type_Rog = ((rog)paramrot);
      return;
    }
    this.jdField_a_of_type_Rog = null;
  }
  
  public void a(tra paramtra)
  {
    if ((paramtra != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramtra))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramtra);
    }
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.e != null) && (this.jdField_a_of_type_Rog.e.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_Rog.e.setVisibility(8);
        this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(rrm paramrrm)
  {
    if ((paramrrm == null) || (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_Rog != null) && (!this.jdField_a_of_type_Boolean) && (tpz.b(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_Rog == null) || (this.jdField_a_of_type_Boolean) || (!tpz.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    qwu localqwu;
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
    if ((b(paramrrm)) && (paramrrm.jdField_a_of_type_Rwf != null) && (!paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Boolean))
    {
      if (paramrrm.jdField_a_of_type_Rwf.e() != 0L) {
        break label496;
      }
      paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int = paramrrm.jdField_a_of_type_Qwu.e;
      paramrrm.jdField_a_of_type_Qwu.e = ((int)paramrrm.jdField_a_of_type_Rwf.b(true));
      localqwu = paramrrm.jdField_a_of_type_Qwu;
      if (paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int != 0) {
        break label514;
      }
      bool = true;
      localqwu.b = bool;
      paramrrm.jdField_a_of_type_Qwu.c = true;
      paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Boolean = true;
      localqwu = paramrrm.jdField_a_of_type_Qwu;
      localAdvertisementInfo = nzq.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localqwu.jdField_d_of_type_Int;
      n = localqwu.e;
      if (!localqwu.b) {
        break label520;
      }
      i = 1;
      if (!localqwu.c) {
        break label525;
      }
      j = 1;
      i1 = localqwu.f;
      if (!localqwu.jdField_a_of_type_Boolean) {
        break label530;
      }
    }
    label514:
    label520:
    label525:
    label530:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = nzq.a(m, n, i, j, i1, k, (int)paramrrm.jdField_a_of_type_Rwf.b(), nzq.aO, 0);
      nzq.a(new tlx().a(this.jdField_a_of_type_AndroidContentContext).a(nzq.f).b(localqwu.g).a(localAdvertisementInfo).a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      if (this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_Rog.e != null)
      {
        this.jdField_a_of_type_Rog.e.setVisibility(0);
        this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a("continue_pause", true);
        if (this.jdField_a_of_type_Rog.f != null) {
          this.jdField_a_of_type_Rog.f.setVisibility(8);
        }
        paramrrm = ObjectAnimator.ofFloat(this.jdField_a_of_type_Rog.e, "alpha", new float[] { 0.0F, 1.0F });
        paramrrm.setDuration(200L);
        paramrrm.setInterpolator(new DecelerateInterpolator());
        paramrrm.addListener(new tqz(this));
        paramrrm.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label496:
      paramrrm.jdField_a_of_type_Qwu.jdField_d_of_type_Int = ((int)paramrrm.jdField_a_of_type_Rwf.e());
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
    if ((this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.e != null))
    {
      this.jdField_a_of_type_Rog.e.setVisibility(8);
      this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
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
    if ((this.jdField_a_of_type_Rog != null) && (this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_Rog.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_Rog.e != null)
      {
        this.jdField_a_of_type_Rog.e.setVisibility(8);
        this.jdField_a_of_type_Rog.jdField_a_of_type_Rrm.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((tra)paramMessage.next()).a();
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
 * Qualified Name:     tqy
 * JD-Core Version:    0.7.0.1
 */