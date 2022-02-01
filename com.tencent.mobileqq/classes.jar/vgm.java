import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuPart.2;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class vgm
  extends vbk
  implements aaam, vgr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final String jdField_a_of_type_JavaLangString = "https://sola.gtimg.cn/aoi/sola/20200527150248_LGSXZNEfOh.png";
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private vgs jdField_a_of_type_Vgs;
  private vgw jdField_a_of_type_Vgw;
  private vgx jdField_a_of_type_Vgx;
  private vlq jdField_a_of_type_Vlq;
  public boolean a;
  private long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString = "    https://sola.gtimg.cn/aoi/sola/20200526154505_NHZGxe56vT.png";
  private ArrayList<vhd> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public vgm()
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuDefaultSwitch", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Int = -1;
      this.f = true;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  private List<vat> a(List<FeedCloudMeta.StComment> paramList)
  {
    if (paramList == null)
    {
      QLog.e("QCircleDanmakuPart", 2, "commentList == null");
      return new ArrayList();
    }
    QLog.d("QCircleDanmakuPart", 2, "commentList.size():" + paramList.size());
    this.jdField_a_of_type_JavaUtilList = paramList;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      vat localvat = new vat(localStComment);
      int i;
      if (paramList.size() == 1) {
        i = localStComment.vecReply.size();
      }
      for (;;)
      {
        int j = 0;
        while (j < i)
        {
          localvat.a(1, (FeedCloudMeta.StReply)localStComment.vecReply.get(j));
          j += 1;
        }
        if (localStComment.vecReply.size() <= 3) {
          i = localStComment.vecReply.size();
        } else {
          i = 3;
        }
      }
      if (i < localStComment.vecReply.size()) {
        localvat.a(2, localStComment.vecReply.size() - i);
      }
      localArrayList.add(localvat);
    }
    return localArrayList;
  }
  
  private void a(ArrayList<vhd> paramArrayList)
  {
    Iterator localIterator = new HashSet(paramArrayList).iterator();
    while (localIterator.hasNext())
    {
      vhd localvhd = (vhd)localIterator.next();
      aoot.a(((BaseActivity)a()).app, 1, 4, String.valueOf(localvhd.jdField_a_of_type_Long));
    }
    b(paramArrayList);
  }
  
  private void b(View paramView)
  {
    if (this.d) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(a()).inflate(2131562594, null));
    this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378262));
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    this.jdField_a_of_type_Vgx = new vgx(a(), this.jdField_a_of_type_AndroidViewTextureView, 1);
    if (!a().isFinishing())
    {
      QLog.d("QCircleDanmakuPart", 2, "initDanmakuView ");
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_Vgs = this.jdField_a_of_type_Vgx.a();
    this.jdField_a_of_type_Vgw = this.jdField_a_of_type_Vgx.a();
    this.d = true;
  }
  
  private void b(ArrayList<vhd> paramArrayList)
  {
    if (!(this.jdField_a_of_type_AndroidViewView instanceof QCircleTransitionLayout)) {
      return;
    }
    b();
    b(this.jdField_a_of_type_AndroidViewView);
    long l2 = 0L;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayList.size())
    {
      long l1 = l2;
      Object localObject;
      vhb localvhb;
      float f1;
      if (i > 0)
      {
        if (i < 2) {
          break label423;
        }
        localObject = (vhb)localArrayList.get(i - 2);
        localvhb = (vhb)localArrayList.get(i - 1);
        f1 = ((vhb)localObject).n();
        f1 = 8160.0F * f1 / (f1 + bhtq.a());
      }
      for (l1 = ((vhb)localObject).d() + (int)(f1 + 1000.0F);; l1 = l2 + 1000L) {
        for (;;)
        {
          localObject = (vhd)paramArrayList.get(i);
          localvhb = this.jdField_a_of_type_Vgw.a(1, l1, "", QCircleAsyncTextView.a(((vhd)localObject).jdField_b_of_type_JavaLangString), a().getResources().getColor(2131166687), 10.0F, a().getResources().getColor(2131166686));
          localvhb.t = ((vhd)localObject).jdField_a_of_type_Int;
          localvhb.h = ((vhd)localObject).jdField_a_of_type_Boolean;
          localvhb.u = i;
          ((vhf)localvhb).a(new vgn(this));
          if (((vhd)localObject).jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuModelQzoneBarrageEffectData$BarrageEffectInfo != null)
          {
            String str1 = ((vhd)localObject).jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuModelQzoneBarrageEffectData$BarrageEffectInfo.strAndBgUrl;
            String str2 = ((vhd)localObject).jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuModelQzoneBarrageEffectData$BarrageEffectInfo.strTextColor;
            localvhb.a(str1);
            localvhb.a(Color.parseColor("#" + str2));
          }
          try
          {
            if ((((vhd)localObject).jdField_c_of_type_JavaLangString != null) && (!TextUtils.isEmpty(((vhd)localObject).jdField_c_of_type_JavaLangString)))
            {
              localvhb.g(Integer.parseInt(((vhd)localObject).jdField_c_of_type_JavaLangString));
              localvhb.h(Integer.parseInt(((vhd)localObject).d));
              localvhb.f(((vhd)localObject).e);
            }
            localvhb.a("    https://sola.gtimg.cn/aoi/sola/20200526154505_NHZGxe56vT.png");
            localvhb.a(TypedValue.applyDimension(2, 14.0F, a().getResources().getDisplayMetrics()));
            localvhb.b(((vhd)localObject).jdField_a_of_type_Long);
            localvhb.b(1);
            localvhb.g(60.0F);
            this.jdField_a_of_type_Vgw.a(localvhb);
            localArrayList.add(localvhb);
            i += 1;
            l2 = l1;
          }
          catch (NumberFormatException paramArrayList)
          {
            label423:
            QZLog.e("QCircleDanmakuPart", "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
            return;
          }
        }
      }
    }
    this.jdField_a_of_type_Vgs.a(localArrayList);
    this.jdField_a_of_type_Vgx.a(true);
    this.jdField_a_of_type_Vgx.a(true);
    this.jdField_a_of_type_Vgx.a(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_Vgx);
    this.jdField_a_of_type_Vgx.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    bngq.a(3);
  }
  
  private boolean b()
  {
    return 57 == c();
  }
  
  private void c()
  {
    if ((!this.f) || (QCircleContentImmersiveEvent.isImmersive())) {
      QLog.d("QCircleDanmakuPart", 2, "isBarrageOpen:" + this.f + ", QCircleContentImmersiveEvent.isImmersive():" + QCircleContentImmersiveEvent.isImmersive());
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        QLog.d("QCircleDanmakuPart", 2, "getRealCellId():" + vgl.jdField_a_of_type_JavaLangString);
      } while (TextUtils.isEmpty(vgl.jdField_a_of_type_JavaLangString));
      localArrayList = vjy.a().a(vgl.jdField_a_of_type_JavaLangString);
    } while ((localArrayList == null) || (localArrayList.size() <= 0) || (this.jdField_a_of_type_Vgx == null) || ((TextUtils.equals(this.jdField_c_of_type_JavaLangString, vgl.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Vgx.b())));
    this.jdField_c_of_type_JavaLangString = vgl.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = vgl.a();
    a(a(localArrayList));
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      bool1 = bool2;
      if (2 == this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.type.get()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d()
  {
    QCircleContentImmersiveEvent.resetImmersive();
    this.jdField_a_of_type_Vlq = new vlq();
    this.jdField_a_of_type_Vlq.a(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  private void e()
  {
    if ((this.f) && (!this.g) && (this.jdField_a_of_type_Vgx != null) && (!this.jdField_a_of_type_Vgx.b()) && (!QCircleContentImmersiveEvent.isImmersive()) && (TextUtils.equals(this.jdField_c_of_type_JavaLangString, vgl.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Vgx.a();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
  }
  
  private void f()
  {
    if ((this.f) && (this.jdField_a_of_type_Vgx != null) && (!this.jdField_a_of_type_Vgx.b()) && (!QCircleContentImmersiveEvent.isImmersive()))
    {
      if (!TextUtils.equals(this.jdField_c_of_type_JavaLangString, vgl.jdField_a_of_type_JavaLangString)) {
        break label66;
      }
      this.jdField_a_of_type_Vgx.a();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
    return;
    label66:
    c();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Vgx != null) && (this.jdField_a_of_type_Vgx.b())) {
      this.jdField_a_of_type_Vgx.b();
    }
  }
  
  private void h()
  {
    g();
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  public ReportExtraTypeInfo a()
  {
    return (ReportExtraTypeInfo)b("get_report_extra_type_info", "");
  }
  
  public String a()
  {
    return "QCircleDanmakuPart";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Vgx != null) && (this.jdField_a_of_type_Vgx.b())) {
      b();
    }
  }
  
  protected void a(View paramView)
  {
    QLog.d("QCircleDanmakuPart", 2, paramView.toString());
    if ((paramView instanceof QCircleTransitionLayout))
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      b(paramView);
    }
    aaak.a().a(this);
    d();
  }
  
  protected void a(List<vat> paramList)
  {
    int i;
    label20:
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      i = 0;
      if (i >= paramList.size()) {
        break label190;
      }
      localObject = (vat)paramList.get(i);
      localObject = new vhd(((vat)localObject).a.postUser.nick.get(), Long.parseLong(((vat)localObject).a.postUser.id.get()), ((vat)localObject).a.content.get(), null, null, null, null);
      ((vhd)localObject).jdField_a_of_type_Int = ((vat)paramList.get(i)).a.likeInfo.count.get();
      if (((vat)paramList.get(i)).a.likeInfo.status.get() != 1) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      ((vhd)localObject).jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
      i += 1;
      break label20;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
    }
    label190:
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)) {
      a(this.jdField_b_of_type_JavaUtilArrayList);
    }
  }
  
  public void a(vhb paramvhb, vgz paramvgz)
  {
    if ((paramvhb != null) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Vgx.b();
      QLog.d("QCircleDanmakuPart", 2, "AbsDanmaku: " + paramvhb.toString());
      paramvgz = new ImageView(a());
      ApngImage.playByTag(33);
      Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
      paramvgz.setImageDrawable(vqo.a("https://sola.gtimg.cn/aoi/sola/20200527150248_LGSXZNEfOh.png", new int[] { 33 }, (Drawable)localObject, 1));
      paramvgz.setScaleType(ImageView.ScaleType.FIT_XY);
      int j = (int)paramvhb.n() + vgp.b * 2;
      int i = j;
      if (j > bhtq.a(205.0F)) {
        i = bhtq.a(205.0F);
      }
      j = i;
      if (i < bhtq.a(102.0F)) {
        j = bhtq.a(102.0F);
      }
      localObject = new RelativeLayout.LayoutParams(j, (int)paramvhb.m() + vgp.c * 2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)paramvhb.b());
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)paramvhb.c() + (int)(paramvhb.e() - paramvhb.c() - paramvhb.m()) / 2 - vgp.c);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramvgz, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams((int)paramvhb.n() + vgp.b * 2, (int)paramvhb.m() + vgp.c * 2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)paramvhb.b());
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)paramvhb.c() + (int)(paramvhb.e() - paramvhb.c() - paramvhb.m()) / 2 - vgp.c);
      ImageView localImageView = new ImageView(a());
      localImageView.setBackgroundResource(2130843931);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ObjectAnimator.ofFloat(localImageView, "alpha", new float[] { 0.0F, 1.0F, 0.0F }).setDuration(600L).start();
      this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new QCircleDanmakuPart.2(this, paramvgz, paramvhb), 900L);
      if ((this.jdField_a_of_type_JavaUtilList.size() > paramvhb.u) && (!paramvhb.h())) {
        VSNetworkHelper.a().a(a(), new QCircleDoLikeRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, 3, (FeedCloudMeta.StLike)((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(paramvhb.u)).likeInfo.get(), (FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(paramvhb.u), null, b()), new vgo(this));
      }
      paramvgz = new ArrayList();
      if (!c()) {
        break label567;
      }
    }
    label567:
    for (paramvhb = "1";; paramvhb = "2")
    {
      paramvgz.add(vtt.a("ext1", paramvhb));
      vtr.a(84, 2, a(), paramvgz, b());
      return;
    }
  }
  
  public boolean a()
  {
    if (this.g) {
      a();
    }
    for (;;)
    {
      return super.a();
      b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vgx != null)
    {
      this.jdField_a_of_type_Vgx.d();
      this.jdField_a_of_type_Vgx.c();
      this.jdField_a_of_type_Vgx.e();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    this.d = false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleDanmakuEvent.class);
    localArrayList.add(QCircleContentImmersiveEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if (this.jdField_a_of_type_Vlq != null) {
      this.jdField_a_of_type_Vlq.a();
    }
    b();
    aaak.a().b(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.e = true;
    e();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.e = false;
    if (paramActivity.isFinishing())
    {
      b();
      return;
    }
    g();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleDanmakuEvent))
    {
      paramSimpleBaseEvent = (QCircleDanmakuEvent)paramSimpleBaseEvent;
      this.g = paramSimpleBaseEvent.isCommentPanelOpen;
      switch (paramSimpleBaseEvent.eventStatus)
      {
      }
    }
    while (!(paramSimpleBaseEvent instanceof QCircleContentImmersiveEvent))
    {
      do
      {
        do
        {
          return;
          c();
          return;
          b();
          return;
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          return;
          this.jdField_a_of_type_Vgx.b();
          return;
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          return;
          this.jdField_a_of_type_Vgx.a();
          return;
        } while (this.jdField_a_of_type_Boolean);
        e();
        return;
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Vgx.b();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      this.f = true;
      c();
      return;
      this.f = false;
      b();
      return;
    }
    QLog.d("QCircleDanmakuPart", 2, "onReceiveEvent:QCircleContentImmersiveEvent");
    if (this.jdField_a_of_type_Vlq != null) {
      this.jdField_a_of_type_Vlq.a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
    }
    if (QCircleContentImmersiveEvent.isImmersive())
    {
      h();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgm
 * JD-Core Version:    0.7.0.1
 */