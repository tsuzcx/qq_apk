import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.QCircleActionBean;
import com.tencent.biz.qqcircle.QCircleInitBean.a;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.10;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.11;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.12;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.4;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.5;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleForwardEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class oyu
  extends sak<FeedCloudMeta.StFeed>
  implements View.OnClickListener, Animation.AnimationListener, IEventReceiver, rwx
{
  private int AS = -1;
  private QCircleRockeyPopupView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView;
  private oyd jdField_a_of_type_Oyd;
  private oyr jdField_a_of_type_Oyr;
  private final oyu.a jdField_a_of_type_Oyu$a;
  private oyu.b jdField_a_of_type_Oyu$b;
  private oyu.c jdField_a_of_type_Oyu$c;
  private sdx jdField_a_of_type_Sdx;
  private Animation ah;
  private Animation ai;
  private String aqa;
  private String aqc;
  private boolean axe;
  private boolean axf;
  private boolean axh;
  private boolean axi;
  private boolean axj;
  private boolean axk;
  private boolean axl;
  private boolean ayY;
  private boolean ayZ;
  private boolean ayo;
  private boolean aza;
  private AbsListView.OnScrollListener jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener = new oyy(this);
  private QCirclePolyLikeFrameLayout jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout;
  private QCirclePolymorphicAniView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCirclePraiseTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView;
  private QCircleRecommendImageView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private FeedCloudMeta.StComment jdField_b_of_type_FeedcloudFeedCloudMeta$StComment;
  protected oyh b;
  private int bgL;
  private int bgM;
  private FeedCloudMeta.StReply c;
  private FeedCloudMeta.StComment jdField_d_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StReply jdField_d_of_type_FeedcloudFeedCloudMeta$StReply;
  private Map<Long, FeedCloudMeta.StUser> fk = new HashMap();
  private Map<Long, FeedCloudMeta.StReply> fl = new HashMap();
  private Map<Long, FeedCloudMeta.StComment> ft = new HashMap();
  private Map<Integer, FeedCloudMeta.StFeed> fu = new HashMap();
  private View gD;
  private ImageView ij;
  public ListView l;
  private ImageView lX;
  private List<FeedCloudMeta.StComment> lo;
  private Activity mActivity;
  View mCommentContainer;
  private TextView mCommentCount;
  private Context mContext;
  private ExtraTypeInfo mExtraTypeInfo;
  private View ns;
  private int retryTimes;
  private ViewStub t;
  private TextView uj;
  private TextView wb;
  private long yN;
  
  public oyu(@NonNull Context paramContext)
  {
    super(paramContext, false);
    this.mContext = paramContext;
    this.jdField_a_of_type_Oyu$a = new oyu.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Oyu$a);
    rwv.a().a(this);
    resetParams();
  }
  
  private FeedCloudMeta.StFeed a()
  {
    int i = getPosition();
    return (FeedCloudMeta.StFeed)this.fu.get(Integer.valueOf(i));
  }
  
  private FeedCloudMeta.StReply a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStComment == null) {
      return null;
    }
    return new FeedCloudMeta.StReply();
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      QLog.e("QCircleCommentPanelView", 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Oyr == null) {
      this.jdField_a_of_type_Oyr = new oyr((Activity)this.mContext);
    }
    String str;
    if ((paramStReply != null) && (paramStReply.has())) {
      if (paramStReply.postUser != null)
      {
        str = "";
        if ("".length() > 10)
        {
          str = "".substring(0, 10);
          str = str + "...";
        }
        this.jdField_a_of_type_Oyr.qG(str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Oyr.a(new oyz(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.jdField_a_of_type_Oyr.show(paramBoolean2);
      return;
      if ((paramStComment != null) && (paramStComment.has()) && (paramStComment.postUser != null))
      {
        str = "";
        if ("".length() > 10)
        {
          str = "".substring(0, 10);
          str = str + "...";
        }
        this.jdField_a_of_type_Oyr.qG(str);
      }
    }
  }
  
  private void awT()
  {
    try
    {
      if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() != 0))
      {
        this.mCommentContainer.setVisibility(0);
        this.ai = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        this.ai.setDuration(200L);
        this.ai.setAnimationListener(this);
        this.ai.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gD.startAnimation(this.ai);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private QCircleInitBean b()
  {
    return (QCircleInitBean)((Activity)getContext()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private void b(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    QLog.e("QCircleCommentPanelView", 1, "popupComment");
    a(paramStComment, paramStReply, true, false);
  }
  
  private boolean b(int paramInt, Object[] paramArrayOfObject)
  {
    return this.bgL != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  /* Error */
  private void beN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 246
    //   4: iconst_1
    //   5: ldc_w 430
    //   8: invokestatic 432	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11: aload_0
    //   12: getfield 434	oyu:jdField_b_of_type_Oyh	Loyh;
    //   15: ifnonnull +15 -> 30
    //   18: ldc 246
    //   20: iconst_1
    //   21: ldc_w 436
    //   24: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 439	oyu:a	()Loyh;
    //   35: aload_0
    //   36: invokespecial 222	oyu:lX	()Ljava/lang/String;
    //   39: invokevirtual 444	oyh:t	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   42: putfield 228	oyu:lo	Ljava/util/List;
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 439	oyu:a	()Loyh;
    //   50: aload_0
    //   51: invokespecial 222	oyu:lX	()Ljava/lang/String;
    //   54: invokevirtual 448	oyh:getAttachInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   57: putfield 225	oyu:aqc	Ljava/lang/String;
    //   60: aload_0
    //   61: getfield 228	oyu:lo	Ljava/util/List;
    //   64: ifnonnull +24 -> 88
    //   67: aload_0
    //   68: invokespecial 203	oyu:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   71: ifnull +17 -> 88
    //   74: aload_0
    //   75: aload_0
    //   76: invokespecial 203	oyu:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   79: getfield 452	feedcloud/FeedCloudMeta$StFeed:vecComment	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   82: invokevirtual 457	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   85: putfield 228	oyu:lo	Ljava/util/List;
    //   88: aload_0
    //   89: getfield 228	oyu:lo	Ljava/util/List;
    //   92: ifnonnull +14 -> 106
    //   95: aload_0
    //   96: new 459	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 460	java/util/ArrayList:<init>	()V
    //   103: putfield 228	oyu:lo	Ljava/util/List;
    //   106: aload_0
    //   107: getfield 232	oyu:jdField_a_of_type_Oyd	Loyd;
    //   110: ifnull +64 -> 174
    //   113: ldc 246
    //   115: iconst_1
    //   116: ldc_w 462
    //   119: invokestatic 432	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: getfield 232	oyu:jdField_a_of_type_Oyd	Loyd;
    //   126: aload_0
    //   127: invokespecial 203	oyu:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   130: invokevirtual 467	oyd:b	(Lfeedcloud/FeedCloudMeta$StFeed;)V
    //   133: aload_0
    //   134: getfield 232	oyu:jdField_a_of_type_Oyd	Loyd;
    //   137: invokevirtual 470	oyd:beD	()V
    //   140: aload_0
    //   141: getfield 232	oyu:jdField_a_of_type_Oyd	Loyd;
    //   144: aload_0
    //   145: getfield 228	oyu:lo	Ljava/util/List;
    //   148: invokevirtual 473	oyd:c	(Ljava/util/Collection;)Z
    //   151: pop
    //   152: aload_0
    //   153: getfield 475	oyu:ayZ	Z
    //   156: ifeq +11 -> 167
    //   159: aload_0
    //   160: getfield 232	oyu:jdField_a_of_type_Oyd	Loyd;
    //   163: iconst_0
    //   164: invokevirtual 478	oyd:vh	(I)V
    //   167: aload_0
    //   168: getfield 232	oyu:jdField_a_of_type_Oyd	Loyd;
    //   171: invokevirtual 481	oyd:notifyDataSetChanged	()V
    //   174: aload_0
    //   175: getfield 483	oyu:l	Landroid/widget/ListView;
    //   178: ifnull -151 -> 27
    //   181: aload_0
    //   182: getfield 124	oyu:AS	I
    //   185: aload_0
    //   186: invokevirtual 186	oyu:getPosition	()I
    //   189: if_icmpeq -162 -> 27
    //   192: aload_0
    //   193: getfield 475	oyu:ayZ	Z
    //   196: ifeq -169 -> 27
    //   199: aload_0
    //   200: aload_0
    //   201: invokevirtual 186	oyu:getPosition	()I
    //   204: putfield 124	oyu:AS	I
    //   207: ldc 246
    //   209: iconst_1
    //   210: ldc_w 485
    //   213: invokestatic 432	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_0
    //   217: getfield 483	oyu:l	Landroid/widget/ListView;
    //   220: iconst_0
    //   221: invokevirtual 490	android/widget/ListView:setSelection	(I)V
    //   224: goto -197 -> 27
    //   227: astore_1
    //   228: aload_0
    //   229: monitorexit
    //   230: aload_1
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	oyu
    //   227	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	227	finally
    //   30	88	227	finally
    //   88	106	227	finally
    //   106	167	227	finally
    //   167	174	227	finally
    //   174	224	227	finally
  }
  
  private void beO()
  {
    if ((this.mCommentContainer != null) && (!this.ayY))
    {
      this.ah = AnimationUtils.loadAnimation(this.mContext, 2130772055);
      this.ah.setAnimationListener(this);
      this.gD.startAnimation(this.ah);
    }
    this.axe = false;
  }
  
  private void beT()
  {
    this.mActivity.runOnUiThread(new QCircleCommentPanelView.4(this));
  }
  
  private void biC()
  {
    a().a(a(), false);
  }
  
  private FeedCloudMeta.StComment c(FeedCloudMeta.StComment paramStComment)
  {
    return new FeedCloudMeta.StComment();
  }
  
  private void c(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_Oyr == null)
    {
      QLog.e("QCircleCommentPanelView", 1, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Oyr.setOnShowListener(new oza(this, paramStComment, paramStReply));
    this.jdField_a_of_type_Oyr.a(new ozb(this, paramStComment, paramStReply));
  }
  
  private FeedCloudMeta.StUser d()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    localStUser.type.set(0);
    return localStUser;
  }
  
  private void d(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.uj != null) {}
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null)
      {
        if (!ovd.eL(paramStFeed.poster.id.get())) {
          break label75;
        }
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 3);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setFeedId(paramStFeed.id.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(3);
      }
      return;
      label75:
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(0);
    }
  }
  
  private void el(int paramInt)
  {
    this.mActivity.runOnUiThread(new QCircleCommentPanelView.5(this, paramInt));
  }
  
  private String lX()
  {
    if (a() == null)
    {
      QLog.e("QCircleCommentPanelView", 2, "getCellId null");
      return "";
    }
    return a().id.get();
  }
  
  private void qF(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.ns != null)
    {
      localTextView = (TextView)this.ns.findViewById(2131371989);
      if ((localTextView != null) && (!paramBoolean)) {}
    }
    else
    {
      return;
    }
    localTextView.setText("");
  }
  
  private void qx(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.l.getChildCount())
      {
        Object localObject = this.l.getChildAt(i);
        if ((localObject instanceof QCircleCommentItemView))
        {
          localObject = (QCircleCommentItemView)localObject;
          if ((((QCircleCommentItemView)localObject).a() != null) && (((QCircleCommentItemView)localObject).a().id.get().equals(paramString)))
          {
            localObject = ((QCircleCommentItemView)localObject).f();
            if (localObject != null) {
              this.l.setSelectionFromTop(i + this.l.getFirstVisiblePosition(), -((LinearLayout)localObject).getHeight());
            }
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void r(Object[] paramArrayOfObject)
  {
    Long localLong = (Long)paramArrayOfObject[1];
    Object localObject;
    if ((String)paramArrayOfObject[2] == null)
    {
      localObject = "";
      switch (((Integer)paramArrayOfObject[0]).intValue())
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return;
                              localObject = (String)paramArrayOfObject[2];
                              break;
                            } while (b(4, paramArrayOfObject));
                            this.axf = false;
                            if (paramArrayOfObject[3] != null)
                            {
                              if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null) && (((Boolean)paramArrayOfObject[5]).booleanValue())) {
                                biB();
                              }
                              vl(a().aU(lX()));
                              if (this.axe) {
                                this.mActivity.runOnUiThread(new QCircleCommentPanelView.12(this));
                              }
                            }
                          } while (!this.axl);
                          this.axl = false;
                          return;
                        } while ((b(4, paramArrayOfObject)) || (!(paramArrayOfObject[3] instanceof FeedCloudRead.StGetCommentListRsp)));
                        if (this.jdField_a_of_type_Oyd != null)
                        {
                          paramArrayOfObject = ((FeedCloudRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get();
                          this.jdField_a_of_type_Oyd.c(paramArrayOfObject);
                        }
                        beT();
                        return;
                        if (this.jdField_a_of_type_Oyr != null) {
                          this.jdField_a_of_type_Oyr.hideSoftInput(this.uj);
                        }
                      } while (b(5, paramArrayOfObject));
                      if (localLong.longValue() != 0L) {
                        QLog.e("QCircleCommentPanelView", 1, "comment fail ret=" + localLong + " msg=" + (String)localObject);
                      }
                      if ((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoCommentRsp))
                      {
                        localObject = ((FeedCloudWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
                        if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Oyd != null) && (this.jdField_a_of_type_Oyd.eF(String.valueOf(paramArrayOfObject[4])))) {
                          beT();
                        }
                        if (localLong.longValue() == 0L)
                        {
                          if ((this.jdField_a_of_type_Oyd != null) && (this.jdField_a_of_type_Oyd.a(String.valueOf(paramArrayOfObject[4]), (FeedCloudMeta.StComment)localObject))) {
                            beT();
                          }
                          el(a().aU(lX()));
                        }
                      }
                    } while (this.jdField_a_of_type_Oyd == null);
                    this.jdField_a_of_type_Oyd.b(a());
                    return;
                  } while ((b(4, paramArrayOfObject)) || (localLong.longValue() != 0L) || (!(paramArrayOfObject[3] instanceof FeedCloudWrite.StDoCommentRsp)));
                  paramArrayOfObject = ((FeedCloudWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
                  if ((this.jdField_a_of_type_Oyd != null) && (this.jdField_a_of_type_Oyd.eF(paramArrayOfObject))) {
                    beT();
                  }
                  el(a().aU(lX()));
                } while (this.jdField_a_of_type_Oyd == null);
                if (this.jdField_a_of_type_Oyd.getCount() == 0) {}
                for (boolean bool = true;; bool = false)
                {
                  qF(bool);
                  return;
                }
              } while (b(6, paramArrayOfObject));
              if (this.jdField_a_of_type_Oyr != null) {
                this.jdField_a_of_type_Oyr.hideSoftInput(this.uj);
              }
              if (localLong.longValue() != 0L) {
                QLog.e("QCircleCommentPanelView", 1, "reply fail ret=" + localLong + " msg=" + (String)localObject);
              }
              if ((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoReplyRsp))
              {
                localObject = ((FeedCloudWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
                FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)paramArrayOfObject[4];
                paramArrayOfObject = (String)paramArrayOfObject[5];
                if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Oyd != null) && (this.jdField_a_of_type_Oyd.L(localStComment.id.get(), paramArrayOfObject))) {
                  beT();
                }
                if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Oyd != null) && (this.jdField_a_of_type_Oyd.a(localStComment.id.get(), paramArrayOfObject, (FeedCloudMeta.StReply)localObject))) {
                  beT();
                }
              }
              el(a().aU(lX()));
              return;
            } while (b(5, paramArrayOfObject));
            if (((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoReplyRsp)) && ((paramArrayOfObject[4] instanceof FeedCloudMeta.StComment)))
            {
              localObject = ((FeedCloudWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
              paramArrayOfObject = ((FeedCloudMeta.StComment)paramArrayOfObject[4]).id.get();
              if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Oyd != null) && (!TextUtils.isEmpty(paramArrayOfObject)) && (!TextUtils.isEmpty((CharSequence)localObject)))
              {
                this.jdField_a_of_type_Oyd.L(paramArrayOfObject, (String)localObject);
                beT();
              }
            }
            el(a().aU(lX()));
            return;
          } while ((b(4, paramArrayOfObject)) || (localLong.longValue() != 0L));
          paramArrayOfObject = (String)paramArrayOfObject[3];
        } while ((this.jdField_a_of_type_Oyd == null) || (TextUtils.isEmpty(paramArrayOfObject)));
        this.jdField_a_of_type_Oyd.qu(paramArrayOfObject);
        beT();
        return;
      } while ((b(4, paramArrayOfObject)) || (localLong.longValue() != 0L));
      paramArrayOfObject = (String)paramArrayOfObject[3];
    } while ((this.jdField_a_of_type_Oyd == null) || (TextUtils.isEmpty(paramArrayOfObject)));
    this.jdField_a_of_type_Oyd.qt(paramArrayOfObject);
    beT();
  }
  
  private void resetParams()
  {
    this.ayZ = false;
    this.aza = true;
  }
  
  private void rk(boolean paramBoolean)
  {
    int i = 1;
    QLog.d("QCircleCommentPanelView", 1, "loadFeedDisplay() isRefresh => " + paramBoolean);
    if (paramBoolean) {
      biC();
    }
    if (this.mCommentContainer.getVisibility() != 0) {}
    for (;;)
    {
      uF(0);
      if (i != 0) {
        beM();
      }
      if ((this.jdField_a_of_type_Oyr != null) && (this.uj != null)) {
        this.uj.setText(this.jdField_a_of_type_Oyr.getText());
      }
      return;
      i = 0;
    }
  }
  
  private void uF(int paramInt)
  {
    if (this.mCommentContainer == null)
    {
      QLog.d("QCircleCommentPanelView", 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Oyd.b(a());
    }
    this.mCommentContainer.setVisibility(paramInt);
  }
  
  private void vk(int paramInt)
  {
    if (pcr.a().eA(57))
    {
      pcp.b(paramInt, 2, this.mExtraTypeInfo);
      return;
    }
    pcl.a(paramInt, 2, this.mExtraTypeInfo);
  }
  
  private void vl(int paramInt)
  {
    beN();
    el(paramInt);
    if (this.jdField_a_of_type_Oyd != null) {
      if (this.jdField_a_of_type_Oyd.getCount() != 0) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      qF(bool);
      return;
    }
  }
  
  protected View G()
  {
    return null;
  }
  
  protected void Hp() {}
  
  public oyh a()
  {
    if (this.jdField_b_of_type_Oyh == null)
    {
      this.jdField_b_of_type_Oyh = new oyh(getContext());
      this.bgL = this.jdField_b_of_type_Oyh.hashCode();
    }
    return this.jdField_b_of_type_Oyh;
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = b();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment = ((FeedCloudMeta.StComment)localStBusiInfoCommentListData.comment.get());
      this.c = ((FeedCloudMeta.StReply)localStBusiInfoCommentListData.reply.get());
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPanelView", 1, "getInfoError");
    }
    return null;
  }
  
  public void a(Activity paramActivity, ViewStub paramViewStub)
  {
    this.t = paramViewStub;
    this.mActivity = paramActivity;
  }
  
  public void beM()
  {
    int i = 0;
    if (this.t != null)
    {
      initLayout(this.t);
      this.t = null;
    }
    if ((lX() == null) && (this.retryTimes <= 3))
    {
      this.retryTimes += 1;
      a().getHandler().postDelayed(new QCircleCommentPanelView.10(this), this.retryTimes * 500);
      return;
    }
    FeedCloudMeta.StFeed localStFeed = a();
    Object localObject = lX();
    QLog.d("QCircleCommentPanelView", 1, "showCommentListWithAnim, pageId: " + pcr.a().getPageId() + "  parentPageId: " + pcr.a().sb());
    if (localObject != null)
    {
      this.axe = true;
      if (a() != null)
      {
        localObject = a();
        a().a(a(), (QQCircleFeedBase.StBusiInfoCommentListData)localObject);
      }
    }
    else
    {
      if (localStFeed != null) {
        break label194;
      }
    }
    for (;;)
    {
      vl(i);
      awT();
      return;
      a().a(a(), false);
      break;
      label194:
      i = localStFeed.commentCount.get();
    }
  }
  
  public void biB()
  {
    Object localObject = b();
    if ((localObject != null) && (((QCircleInitBean)localObject).mActionBean != null) && (((QCircleInitBean)localObject).mActionBean.mShowInputKeyboard) && (!this.ayo))
    {
      localObject = a();
      if (localObject != null)
      {
        a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).comment, ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reply, true, false);
        this.ayo = true;
      }
    }
  }
  
  public void biD()
  {
    if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() != 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Oyd != null) {
          this.jdField_a_of_type_Oyd.b(a());
        }
        beM();
      }
      return;
    }
  }
  
  public void biE()
  {
    rl(true);
  }
  
  public boolean d(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  public void dE(View paramView)
  {
    a(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment, this.c, true, false);
  }
  
  public void e(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.t != null)
    {
      initLayout(this.t);
      this.t = null;
    }
    if ((lX() == null) && (this.retryTimes <= 3))
    {
      this.retryTimes += 1;
      a().getHandler().postDelayed(new QCircleCommentPanelView.11(this, paramStComment, paramStReply), this.retryTimes * 500);
      return;
    }
    String str = lX();
    if ((!aqmr.isEmpty(str)) && (a() != null) && (a().vecComment.size() == 0) && (a().commentCount.get() != 0))
    {
      this.lo = a().t(str);
      if ((this.lo != null) && (!this.axf)) {
        break label214;
      }
      a().a(a(), false);
    }
    for (;;)
    {
      QLog.d("QCircleCommentPanelView", 1, "showCommentPanelOutSide, pageId: " + pcr.a().getPageId() + "  parentPageId: " + pcr.a().sb());
      a(paramStComment, paramStReply, true, false);
      return;
      label214:
      beN();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleForwardEvent.class);
    return localArrayList;
  }
  
  public int getPosition()
  {
    return 0;
  }
  
  protected int gn()
  {
    return 2131560888;
  }
  
  protected void initChildView()
  {
    this.l = ((ListView)findViewById(2131366801));
    this.mCommentContainer = findViewById(2131364998);
    if (rze.Mp()) {
      this.mCommentContainer.setBackgroundColor(Color.parseColor("#00000000"));
    }
    this.gD = findViewById(2131366802);
    this.mCommentCount = ((TextView)findViewById(2131365029));
    this.ns = findViewById(2131365009);
    this.uj = ((TextView)findViewById(2131379487));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)findViewById(2131369966));
    this.lX = ((ImageView)findViewById(2131369711));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)findViewById(2131381036));
    this.wb = ((TextView)findViewById(2131380618));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)findViewById(2131369851));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)findViewById(2131365040));
    this.ij = ((ImageView)findViewById(2131365032));
    this.ij.setOnClickListener(this);
    this.lX.setOnClickListener(this);
    this.uj.setOnClickListener(this);
    this.l.setOnScrollListener(this.jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Oyu$c = new oyu.c();
    this.jdField_a_of_type_Oyd = new oyd(this.mContext, this.jdField_a_of_type_Oyu$c);
    this.jdField_a_of_type_Oyd.b(a());
    this.l.setAdapter(this.jdField_a_of_type_Oyd);
    this.l.setEmptyView(this.ns);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setAniView(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setFeedData(a());
    if ((this.mExtraTypeInfo instanceof ReportExtraTypeInfo)) {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.mExtraTypeInfo);
    }
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setOnClickHookListener(new oyv(this));
    d(a());
    if (this.mCommentContainer != null) {
      this.mCommentContainer.setOnClickListener(new oyw(this));
    }
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new oyx(this));
    d(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_d_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.ah)
    {
      if (this.mCommentContainer != null) {
        this.mCommentContainer.setVisibility(8);
      }
      this.ayY = false;
      if (this.jdField_a_of_type_Oyu$b != null) {
        this.jdField_a_of_type_Oyu$b.onDismiss();
      }
      pcr.a().vq(61);
    }
    while (paramAnimation != this.ai) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.ah)
    {
      this.ayY = true;
      QLog.d("QCircleCommentPanelView", 2, "mHideCommentListAnimation onAnimationStarttrue");
    }
    while (paramAnimation != this.ai) {
      return;
    }
    if (this.jdField_a_of_type_Oyu$b != null) {
      this.jdField_a_of_type_Oyu$b.onShow();
    }
    pcr.a().ey(61);
    QLog.d("QCircleCommentPanelView", 2, "mShowCommentListAnimation onAnimationStarttrue");
  }
  
  public boolean onBackPress()
  {
    if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() == 0))
    {
      beO();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QLog.d("QCircleCommentPanelView", 1, "onClick, pageId: " + pcr.a().getPageId() + "  parentPageId: " + pcr.a().sb());
    switch (i)
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131379487: 
      dE(paramView);
      if (pcr.a().eA(57)) {
        pcp.b(60, 2, this.mExtraTypeInfo);
      }
      for (;;)
      {
        this.bgM = 60;
        QLog.d("QCircleCommentPanelView", 1, "onClick text_input, feedId: " + a().id);
        break;
        pcl.a(60, 2, this.mExtraTypeInfo);
      }
    case 2131369711: 
      dE(paramView);
      if (pcr.a().eA(57)) {
        pcp.b(61, 2, this.mExtraTypeInfo);
      }
      for (;;)
      {
        this.bgM = 61;
        QLog.d("QCircleCommentPanelView", 1, "onClick iv_comment, feedId: " + a().id);
        break;
        pcl.a(61, 2, this.mExtraTypeInfo);
      }
    }
    if (pcr.a().eA(57)) {
      pcp.b(53, 2, this.mExtraTypeInfo);
    }
    for (;;)
    {
      QLog.d("QCircleCommentPanelView", 1, "onClick comment_list_title_close, feedId: " + a().id);
      beO();
      break;
      pcl.a(53, 2, this.mExtraTypeInfo);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) && (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).feedId.equals(lX()))) {
      switch (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).eventStatus)
      {
      }
    }
    while ((!(paramSimpleBaseEvent instanceof QCircleForwardEvent)) || (((QCircleForwardEvent)paramSimpleBaseEvent).feed == null) || (!((QCircleForwardEvent)paramSimpleBaseEvent).feed.id.get().equals(lX())) || (!((QCircleForwardEvent)paramSimpleBaseEvent).isSynchronizeComment))
    {
      return;
      el(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
      return;
    }
    a().a(a(), false);
  }
  
  protected void onRecycle()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Oyu$a);
    rwv.a().b(this);
    a().release();
    this.jdField_b_of_type_Oyh = null;
    if (this.lo != null) {
      this.lo.clear();
    }
    this.fu.clear();
    if (this.jdField_a_of_type_Oyr != null)
    {
      this.jdField_a_of_type_Oyr.dismiss();
      this.jdField_a_of_type_Oyr = null;
    }
  }
  
  protected void onUpdateUI() {}
  
  public void recycle()
  {
    super.recycle();
    onRecycle();
  }
  
  public void rl(boolean paramBoolean)
  {
    if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (!paramBoolean) {
          break;
        }
        beO();
      }
      return;
    }
    this.mCommentContainer.setVisibility(8);
  }
  
  public void setAniView(QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
    if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout != null) {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setAniView(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
    if ((this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout != null) && ((this.mExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.mExtraTypeInfo);
    }
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.aqa = paramStFeed.poster.id.get();
      this.fu.put(Integer.valueOf(getPosition()), paramStFeed);
      a().bb(paramStFeed.id.get(), paramStFeed.commentCount.get());
    }
    if (lX() != null) {
      this.axl = true;
    }
    if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout != null)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setAniView(this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setFeedData(a());
      if ((this.mExtraTypeInfo instanceof ReportExtraTypeInfo)) {
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.mExtraTypeInfo);
      }
    }
    d(paramStFeed);
  }
  
  public void vj(int paramInt)
  {
    this.bgM = paramInt;
  }
  
  public static class a
    extends QQUIEventReceiver<oyu, oyc>
  {
    public a(@NonNull oyu paramoyu)
    {
      super();
    }
    
    public void a(@NonNull oyu paramoyu, @NonNull oyc paramoyc)
    {
      switch (paramoyc.bgK)
      {
      case 4: 
      case 5: 
      default: 
      case 1: 
      case 2: 
      case 3: 
        FeedCloudMeta.StFeed localStFeed;
        int i;
        do
        {
          do
          {
            do
            {
              return;
              paramoyu.biD();
              return;
              paramoyu.biE();
              return;
              oyu.a(paramoyu, false);
              oyu.a(paramoyu, null);
              oyu.a(paramoyu, null);
            } while (!(paramoyc.params instanceof Object[]));
            paramoyc = (Object[])paramoyc.params;
          } while ((paramoyc.length < 2) || (!(paramoyc[0] instanceof FeedCloudMeta.StFeed)) || (!(paramoyc[1] instanceof Integer)));
          localStFeed = (FeedCloudMeta.StFeed)paramoyc[0];
          i = ((Integer)paramoyc[1]).intValue();
        } while (!paramoyu.d(localStFeed));
        oyu.c(paramoyu).put(Integer.valueOf(i), localStFeed);
        QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
        return;
      }
      oyu.a(paramoyu, (Object[])paramoyc.params);
    }
    
    public Class acceptEventClass()
    {
      return oyc.class;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  class c
    implements sdw
  {
    c() {}
    
    public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
    {
      QLog.d("QCircleCommentPanelView", 1, "onClick, pageId: " + pcr.a().getPageId() + "  parentPageId: " + pcr.a().sb());
      switch (paramInt1)
      {
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 12: 
      default: 
      case 2: 
      case 1: 
      case 4: 
      case 13: 
      case 7: 
      case 10: 
      case 11: 
        do
        {
          do
          {
            return;
            if ((paramObject instanceof FeedCloudMeta.StUser))
            {
              QLog.d("QCircleCommentPanelView", 1, "onClick nickName, feedId: " + oyu.a(oyu.this).id + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
              oux.b(new QCircleInitBean.a().a((FeedCloudMeta.StUser)paramObject).a(), null);
            }
            if (pcr.a().eA(57))
            {
              pcp.b(15, 2, oyu.a(oyu.this));
              return;
            }
            pcl.a(15, 2, oyu.a(oyu.this));
            return;
            if ((paramObject instanceof FeedCloudMeta.StUser))
            {
              QLog.d("QCircleCommentPanelView", 1, "onClick avatar, feedId: " + oyu.a(oyu.this).id + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
              oux.b(new QCircleInitBean.a().a((FeedCloudMeta.StUser)paramObject).a(), null);
            }
            if (pcr.a().eA(57))
            {
              pcp.b(14, 2, oyu.a(oyu.this));
              return;
            }
            pcl.a(14, 2, oyu.a(oyu.this));
            return;
            if ((paramObject instanceof FeedCloudMeta.StComment))
            {
              paramView = (FeedCloudMeta.StComment)paramObject;
              QLog.d("QCircleCommentPanelView", 1, "onClick comment, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramView.id);
              oyu.a(oyu.this, paramView, null);
            }
            if (pcr.a().eA(57)) {
              pcp.b(11, 2, oyu.a(oyu.this));
            }
            for (;;)
            {
              oyu.a(oyu.this, 11);
              return;
              pcl.a(11, 2, oyu.a(oyu.this));
            }
            if ((paramObject instanceof FeedCloudMeta.StComment))
            {
              paramView = (FeedCloudMeta.StComment)paramObject;
              QLog.d("QCircleCommentPanelView", 1, "onClick replyTextButton, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramView.id);
              oyu.a(oyu.this, paramView, null);
            }
            if (pcr.a().eA(57)) {
              pcp.b(13, 2, oyu.a(oyu.this));
            }
            for (;;)
            {
              oyu.a(oyu.this, 13);
              return;
              pcl.a(13, 2, oyu.a(oyu.this));
            }
            if ((paramObject instanceof Object[]))
            {
              paramObject = (Object[])paramObject;
              if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof FeedCloudMeta.StReply)))
              {
                paramView = (FeedCloudMeta.StComment)paramObject[0];
                paramObject = (FeedCloudMeta.StReply)paramObject[1];
                QLog.d("QCircleCommentPanelView", 1, "onClick reply, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                oyu.a(oyu.this, paramView, paramObject);
              }
            }
            if (pcr.a().eA(57)) {
              pcp.b(12, 2, oyu.a(oyu.this));
            }
            for (;;)
            {
              oyu.a(oyu.this, 12);
              return;
              pcl.a(12, 2, oyu.a(oyu.this));
            }
            if ((paramObject instanceof FeedCloudMeta.StComment))
            {
              paramView = (FeedCloudMeta.StComment)paramObject;
              oyu.a(oyu.this).c(paramView);
              QLog.d("QCircleCommentPanelView", 1, "onClick more reply, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramView.id);
            }
            if (pcr.a().eA(57))
            {
              pcp.b(52, 2, oyu.a(oyu.this));
              return;
            }
            pcl.a(52, 2, oyu.a(oyu.this));
            return;
          } while (!(paramObject instanceof Object[]));
          paramView = (Object[])paramObject;
        } while ((paramView.length <= 1) || (paramView[0] == null));
        paramObject = (FeedCloudMeta.StComment)paramView[0];
        paramInt1 = oyu.a(oyu.this).a(paramObject);
        if ((paramInt1 >= 0) && (paramView[1] != null))
        {
          int i = ((Integer)paramView[1]).intValue();
          oyu.this.l.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
        }
        QLog.d("QCircleCommentPanelView", 1, "onClick less reply, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramObject.id);
        return;
      case 14: 
        if (pcr.a().eA(57))
        {
          pcp.b(50, 2, oyu.a(oyu.this));
          return;
        }
        pcl.a(50, 2, oyu.a(oyu.this));
        return;
      }
      if (pcr.a().eA(57))
      {
        pcp.b(51, 2, oyu.a(oyu.this));
        return;
      }
      pcl.a(51, 2, oyu.a(oyu.this));
    }
    
    public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
    {
      QLog.d("QCircleCommentPanelView", 1, "onLongClick, pageId: " + pcr.a().getPageId() + "  parentPageId: " + pcr.a().sb());
      ozc localozc = new ozc(this);
      switch (paramInt1)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (!(paramObject instanceof FeedCloudMeta.StComment));
          oyu.a(oyu.this, 45);
          paramObject = (FeedCloudMeta.StComment)paramObject;
          QLog.d("QCircleCommentPanelView", 1, "onLongClick comment, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramObject.id);
          ouy.a().a(paramView, oyu.a(oyu.this), paramObject, new ozd(this, paramObject), localozc);
          return;
        } while (!(paramObject instanceof Object[]));
        localObject = (Object[])paramObject;
      } while ((localObject.length <= 1) || (localObject[0] == null) || (localObject[1] == null) || (!(localObject[0] instanceof FeedCloudMeta.StComment)) || (!(localObject[1] instanceof FeedCloudMeta.StReply)));
      paramObject = (FeedCloudMeta.StComment)localObject[0];
      Object localObject = (FeedCloudMeta.StReply)localObject[1];
      QLog.d("QCircleCommentPanelView", 1, "onLongClick reply, feedId: " + oyu.a(oyu.this).id + " commentId: " + paramObject.id + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
      ouy.a().a(paramView, oyu.a(oyu.this), (FeedCloudMeta.StReply)localObject, new ozk(this, (FeedCloudMeta.StReply)localObject, paramObject), localozc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyu
 * JD-Core Version:    0.7.0.1
 */