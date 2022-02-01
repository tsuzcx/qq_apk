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

public class vei
  extends uzu
  implements ven, zwr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TextureView jdField_a_of_type_AndroidViewTextureView;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private final String jdField_a_of_type_JavaLangString = "https://sola.gtimg.cn/aoi/sola/20200527150248_LGSXZNEfOh.png";
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private veo jdField_a_of_type_Veo;
  private ves jdField_a_of_type_Ves;
  private vet jdField_a_of_type_Vet;
  private vjm jdField_a_of_type_Vjm;
  public boolean a;
  private long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString = "    https://sola.gtimg.cn/aoi/sola/20200526154505_NHZGxe56vT.png";
  private ArrayList<vez> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private volatile boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public vei()
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
  
  private List<uzd> a(List<FeedCloudMeta.StComment> paramList)
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
      uzd localuzd = new uzd(localStComment);
      int i;
      if (paramList.size() == 1) {
        i = localStComment.vecReply.size();
      }
      for (;;)
      {
        int j = 0;
        while (j < i)
        {
          localuzd.a(1, (FeedCloudMeta.StReply)localStComment.vecReply.get(j));
          j += 1;
        }
        if (localStComment.vecReply.size() <= 3) {
          i = localStComment.vecReply.size();
        } else {
          i = 3;
        }
      }
      if (i < localStComment.vecReply.size()) {
        localuzd.a(2, localStComment.vecReply.size() - i);
      }
      localArrayList.add(localuzd);
    }
    return localArrayList;
  }
  
  private void a(ArrayList<vez> paramArrayList)
  {
    Iterator localIterator = new HashSet(paramArrayList).iterator();
    while (localIterator.hasNext())
    {
      vez localvez = (vez)localIterator.next();
      aoch.a(((BaseActivity)a()).app, 1, 4, String.valueOf(localvez.jdField_a_of_type_Long));
    }
    b(paramArrayList);
  }
  
  private void b()
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
        QLog.d("QCircleDanmakuPart", 2, "getRealCellId():" + veh.jdField_a_of_type_JavaLangString);
      } while (TextUtils.isEmpty(veh.jdField_a_of_type_JavaLangString));
      localArrayList = vhu.a().a(veh.jdField_a_of_type_JavaLangString);
    } while ((localArrayList == null) || (localArrayList.size() <= 0) || (this.jdField_a_of_type_Vet == null) || ((TextUtils.equals(this.jdField_c_of_type_JavaLangString, veh.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Vet.b())));
    this.jdField_c_of_type_JavaLangString = veh.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = veh.a();
    a(a(localArrayList));
  }
  
  private void b(View paramView)
  {
    if (this.d) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(a()).inflate(2131562553, null));
    this.jdField_a_of_type_AndroidViewTextureView = ((TextureView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378105));
    this.jdField_a_of_type_AndroidViewTextureView.setOpaque(false);
    this.jdField_a_of_type_Vet = new vet(a(), this.jdField_a_of_type_AndroidViewTextureView, 1);
    if (!a().isFinishing())
    {
      QLog.d("QCircleDanmakuPart", 2, "initDanmakuView ");
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_Veo = this.jdField_a_of_type_Vet.a();
    this.jdField_a_of_type_Ves = this.jdField_a_of_type_Vet.a();
    this.d = true;
  }
  
  private void b(ArrayList<vez> paramArrayList)
  {
    if (!(this.jdField_a_of_type_AndroidViewView instanceof QCircleTransitionLayout)) {
      return;
    }
    a();
    b(this.jdField_a_of_type_AndroidViewView);
    long l2 = 0L;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayList.size())
    {
      long l1 = l2;
      Object localObject;
      vex localvex;
      float f1;
      if (i > 0)
      {
        if (i < 2) {
          break label423;
        }
        localObject = (vex)localArrayList.get(i - 2);
        localvex = (vex)localArrayList.get(i - 1);
        f1 = ((vex)localObject).n();
        f1 = 8000.0F * f1 / (f1 + bgtn.a());
      }
      for (l1 = ((vex)localObject).d() + (int)(f1 + 800.0F);; l1 = l2 + 800L) {
        for (;;)
        {
          localObject = (vez)paramArrayList.get(i);
          localvex = this.jdField_a_of_type_Ves.a(1, l1, "", QCircleAsyncTextView.a(((vez)localObject).jdField_b_of_type_JavaLangString), a().getResources().getColor(2131166683), 10.0F, a().getResources().getColor(2131166682));
          localvex.t = ((vez)localObject).jdField_a_of_type_Int;
          localvex.h = ((vez)localObject).jdField_a_of_type_Boolean;
          localvex.u = i;
          ((vfb)localvex).a(new vej(this));
          if (((vez)localObject).jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuModelQzoneBarrageEffectData$BarrageEffectInfo != null)
          {
            String str1 = ((vez)localObject).jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuModelQzoneBarrageEffectData$BarrageEffectInfo.strAndBgUrl;
            String str2 = ((vez)localObject).jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuModelQzoneBarrageEffectData$BarrageEffectInfo.strTextColor;
            localvex.a(str1);
            localvex.a(Color.parseColor("#" + str2));
          }
          try
          {
            if ((((vez)localObject).jdField_c_of_type_JavaLangString != null) && (!TextUtils.isEmpty(((vez)localObject).jdField_c_of_type_JavaLangString)))
            {
              localvex.g(Integer.parseInt(((vez)localObject).jdField_c_of_type_JavaLangString));
              localvex.h(Integer.parseInt(((vez)localObject).d));
              localvex.f(((vez)localObject).e);
            }
            localvex.a("    https://sola.gtimg.cn/aoi/sola/20200526154505_NHZGxe56vT.png");
            localvex.a(TypedValue.applyDimension(2, 14.0F, a().getResources().getDisplayMetrics()));
            localvex.b(((vez)localObject).jdField_a_of_type_Long);
            localvex.b(1);
            localvex.g(60.0F);
            this.jdField_a_of_type_Ves.a(localvex);
            localArrayList.add(localvex);
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
    this.jdField_a_of_type_Veo.a(localArrayList);
    this.jdField_a_of_type_Vet.a(true);
    this.jdField_a_of_type_Vet.a(true);
    this.jdField_a_of_type_Vet.a(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_Vet);
    this.jdField_a_of_type_Vet.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    bmfo.a(3);
  }
  
  private boolean b()
  {
    return 57 == c();
  }
  
  private void c()
  {
    QCircleContentImmersiveEvent.resetImmersive();
    this.jdField_a_of_type_Vjm = new vjm();
    this.jdField_a_of_type_Vjm.a(this.jdField_a_of_type_AndroidViewViewGroup);
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
    if ((this.f) && (!this.g) && (this.jdField_a_of_type_Vet != null) && (!this.jdField_a_of_type_Vet.b()) && (!QCircleContentImmersiveEvent.isImmersive()) && (TextUtils.equals(this.jdField_c_of_type_JavaLangString, veh.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Vet.a();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
  }
  
  private void e()
  {
    if ((this.f) && (this.jdField_a_of_type_Vet != null) && (!this.jdField_a_of_type_Vet.b()) && (!QCircleContentImmersiveEvent.isImmersive()))
    {
      if (!TextUtils.equals(this.jdField_c_of_type_JavaLangString, veh.jdField_a_of_type_JavaLangString)) {
        break label66;
      }
      this.jdField_a_of_type_Vet.a();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      }
    }
    return;
    label66:
    b();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Vet != null) && (this.jdField_a_of_type_Vet.b())) {
      this.jdField_a_of_type_Vet.b();
    }
  }
  
  private void g()
  {
    f();
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
    if (this.jdField_a_of_type_Vet != null)
    {
      this.jdField_a_of_type_Vet.d();
      this.jdField_a_of_type_Vet.c();
      this.jdField_a_of_type_Vet.e();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
    }
    this.d = false;
  }
  
  protected void a(View paramView)
  {
    QLog.d("QCircleDanmakuPart", 2, paramView.toString());
    if ((paramView instanceof QCircleTransitionLayout))
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      b(paramView);
    }
    zwp.a().a(this);
    c();
  }
  
  protected void a(List<uzd> paramList)
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
      localObject = (uzd)paramList.get(i);
      localObject = new vez(((uzd)localObject).a.postUser.nick.get(), Long.parseLong(((uzd)localObject).a.postUser.id.get()), ((uzd)localObject).a.content.get(), null, null, null, null);
      ((vez)localObject).jdField_a_of_type_Int = ((uzd)paramList.get(i)).a.likeInfo.count.get();
      if (((uzd)paramList.get(i)).a.likeInfo.status.get() != 1) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      ((vez)localObject).jdField_a_of_type_Boolean = bool;
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
  
  public void a(vex paramvex, vev paramvev)
  {
    if ((paramvex != null) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Vet.b();
      QLog.d("QCircleDanmakuPart", 2, "AbsDanmaku: " + paramvex.toString());
      paramvev = new ImageView(a());
      ApngImage.playByTag(33);
      Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
      paramvev.setImageDrawable(vog.a("https://sola.gtimg.cn/aoi/sola/20200527150248_LGSXZNEfOh.png", new int[] { 33 }, (Drawable)localObject, 1));
      paramvev.setScaleType(ImageView.ScaleType.FIT_XY);
      int j = (int)paramvex.n() + vel.b * 2;
      int i = j;
      if (j > bgtn.a(205.0F)) {
        i = bgtn.a(205.0F);
      }
      j = i;
      if (i < bgtn.a(102.0F)) {
        j = bgtn.a(102.0F);
      }
      localObject = new RelativeLayout.LayoutParams(j, (int)paramvex.m() + vel.c * 2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)paramvex.b());
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)paramvex.c() + (int)(paramvex.e() - paramvex.c() - paramvex.m()) / 2 - vel.c);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramvev, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams((int)paramvex.n() + vel.b * 2, (int)paramvex.m() + vel.c * 2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ((int)paramvex.b());
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)paramvex.c() + (int)(paramvex.e() - paramvex.c() - paramvex.m()) / 2 - vel.c);
      ImageView localImageView = new ImageView(a());
      localImageView.setBackgroundResource(2130843909);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ObjectAnimator.ofFloat(localImageView, "alpha", new float[] { 0.0F, 1.0F, 0.0F }).setDuration(600L).start();
      this.jdField_a_of_type_AndroidViewViewGroup.postDelayed(new QCircleDanmakuPart.2(this, paramvev, paramvex), 900L);
      if ((this.jdField_a_of_type_JavaUtilList.size() > paramvex.u) && (!paramvex.h())) {
        VSNetworkHelper.a().a(a(), new QCircleDoLikeRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, 3, (FeedCloudMeta.StLike)((FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(paramvex.u)).likeInfo.get(), (FeedCloudMeta.StComment)this.jdField_a_of_type_JavaUtilList.get(paramvex.u), null, b()), new vek(this));
      }
      paramvev = new ArrayList();
      if (!c()) {
        break label567;
      }
    }
    label567:
    for (paramvex = "1";; paramvex = "2")
    {
      paramvev.add(vri.a("ext1", paramvex));
      vrg.a(84, 2, a(), paramvev, b());
      return;
    }
  }
  
  public boolean a()
  {
    a();
    return super.a();
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
    if (this.jdField_a_of_type_Vjm != null) {
      this.jdField_a_of_type_Vjm.a();
    }
    a();
    zwp.a().b(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    this.e = true;
    d();
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    this.e = false;
    f();
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
          b();
          return;
          a();
          return;
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          return;
          this.jdField_a_of_type_Vet.b();
          return;
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          return;
          this.jdField_a_of_type_Vet.a();
          return;
        } while (this.jdField_a_of_type_Boolean);
        d();
        return;
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Vet.b();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
      this.f = true;
      b();
      return;
      this.f = false;
      a();
      return;
    }
    QLog.d("QCircleDanmakuPart", 2, "onReceiveEvent:QCircleContentImmersiveEvent");
    if (this.jdField_a_of_type_Vjm != null) {
      this.jdField_a_of_type_Vjm.a((QCircleContentImmersiveEvent)paramSimpleBaseEvent);
    }
    if (QCircleContentImmersiveEvent.isImmersive())
    {
      g();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */