import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
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
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.10;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.11;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.12;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.4;
import com.tencent.biz.qqcircle.comment.QCircleCommentPanelView.5;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleForwardEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCirclePolyParseFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class tuk
  extends xza<FeedCloudMeta.StFeed>
  implements View.OnClickListener, Animation.AnimationListener, IEventReceiver, yel
{
  private static final String jdField_a_of_type_JavaLangString = tuk.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new tuo(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolyParseFrameLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCirclePraiseTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private QCircleRockeyPopupView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private ArrayList<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilArrayList;
  private Map<Long, FeedCloudMeta.StUser> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ttr jdField_a_of_type_Ttr;
  protected ttv a;
  private tug jdField_a_of_type_Tug;
  private final tus jdField_a_of_type_Tus;
  private tut jdField_a_of_type_Tut;
  private tuu jdField_a_of_type_Tuu;
  private ydf jdField_a_of_type_Ydf;
  private boolean jdField_a_of_type_Boolean;
  private Context jdField_b_of_type_AndroidContentContext;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Map<Long, FeedCloudMeta.StComment> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private Map<Long, FeedCloudMeta.StReply> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private Map<Integer, FeedCloudMeta.StFeed> jdField_d_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public tuk(@NonNull Context paramContext)
  {
    super(paramContext, false);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Tus = new tus(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Tus);
    yej.a().a(this);
    k();
  }
  
  private FeedCloudMeta.StComment a(FeedCloudMeta.StComment paramStComment)
  {
    return new FeedCloudMeta.StComment();
  }
  
  private FeedCloudMeta.StFeed a()
  {
    int m = b();
    return (FeedCloudMeta.StFeed)this.jdField_d_of_type_JavaUtilMap.get(Integer.valueOf(m));
  }
  
  private FeedCloudMeta.StReply a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStComment == null) {
      return null;
    }
    return new FeedCloudMeta.StReply();
  }
  
  private FeedCloudMeta.StUser a()
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    localStUser.type.set(0);
    return localStUser;
  }
  
  private QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      if (!this.k)
      {
        QCircleInitBean localQCircleInitBean = (QCircleInitBean)((Activity)a()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
        QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
        localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
        this.k = true;
        return localStBusiInfoCommentListData;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getInfoError");
    }
    return null;
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 0L)
    {
      QQToast.a(a(), 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_b_of_type_AndroidContentContext))
    {
      QQToast.a(a(), 1, a().getResources().getString(2131694777), 0).a();
      return;
    }
    QQToast.a(a(), 1, paramString2, 0).a();
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_b_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Tug == null) {
      this.jdField_a_of_type_Tug = new tug((Activity)this.jdField_b_of_type_AndroidContentContext);
    }
    String str2;
    String str1;
    if (paramStReply != null) {
      if (paramStReply.postUser != null)
      {
        str2 = String.format(this.jdField_b_of_type_AndroidContentContext.getString(2131692455), new Object[] { paramStReply.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Tug.b(str1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Tug.a(new tup(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.jdField_a_of_type_Tug.a(paramBoolean2);
      return;
      if ((paramStComment != null) && (paramStComment.postUser != null))
      {
        str2 = String.format(this.jdField_b_of_type_AndroidContentContext.getString(2131692455), new Object[] { paramStComment.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Tug.b(str1);
      }
      else
      {
        this.jdField_a_of_type_Tug.b(this.jdField_b_of_type_AndroidContentContext.getString(2131692450));
      }
    }
  }
  
  private void a(Object[] paramArrayOfObject)
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
                              for (;;)
                              {
                                return;
                                localObject = (String)paramArrayOfObject[2];
                                break;
                                if (!a(4, paramArrayOfObject))
                                {
                                  this.jdField_c_of_type_Boolean = false;
                                  if (paramArrayOfObject[3] != null)
                                  {
                                    if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null) && (((Boolean)paramArrayOfObject[5]).booleanValue())) {
                                      f();
                                    }
                                    p();
                                    if (this.jdField_g_of_type_Boolean) {
                                      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new QCircleCommentPanelView.12(this));
                                    }
                                  }
                                  while (this.h)
                                  {
                                    this.h = false;
                                    return;
                                    QLog.w(jdField_a_of_type_JavaLangString, 1, "get commentList failed");
                                    if (!this.h) {
                                      QQToast.a(a(), (CharSequence)localObject, 0).a();
                                    }
                                  }
                                }
                              }
                            } while ((a(4, paramArrayOfObject)) || (!(paramArrayOfObject[3] instanceof FeedCloudRead.StGetCommentListRsp)));
                            if (this.jdField_a_of_type_Ttr != null)
                            {
                              paramArrayOfObject = ((FeedCloudRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get();
                              this.jdField_a_of_type_Ttr.a(paramArrayOfObject);
                            }
                            l();
                            return;
                            if (this.jdField_a_of_type_Tug != null) {
                              this.jdField_a_of_type_Tug.c(this.jdField_a_of_type_AndroidWidgetTextView);
                            }
                          } while (a(5, paramArrayOfObject));
                          if (localLong.longValue() != 0L) {
                            QLog.e(jdField_a_of_type_JavaLangString, 1, "comment fail ret=" + localLong + " msg=" + (String)localObject);
                          }
                          if ((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoCommentRsp))
                          {
                            localObject = ((FeedCloudWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
                            if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Ttr != null) && (this.jdField_a_of_type_Ttr.a(String.valueOf(paramArrayOfObject[4])))) {
                              l();
                            }
                            if (localLong.longValue() == 0L)
                            {
                              if ((this.jdField_a_of_type_Ttr != null) && (this.jdField_a_of_type_Ttr.a(String.valueOf(paramArrayOfObject[4]), (FeedCloudMeta.StComment)localObject))) {
                                l();
                              }
                              c(a().a(b()));
                            }
                          }
                        } while (this.jdField_a_of_type_Ttr == null);
                        this.jdField_a_of_type_Ttr.a(a());
                        return;
                      } while ((a(4, paramArrayOfObject)) || (localLong.longValue() != 0L) || (!(paramArrayOfObject[3] instanceof FeedCloudWrite.StDoCommentRsp)));
                      paramArrayOfObject = ((FeedCloudWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
                      if ((this.jdField_a_of_type_Ttr != null) && (this.jdField_a_of_type_Ttr.a(paramArrayOfObject))) {
                        l();
                      }
                      c(a().a(b()));
                    } while (this.jdField_a_of_type_Ttr == null);
                    if (this.jdField_a_of_type_Ttr.getCount() == 0) {}
                    for (boolean bool = true;; bool = false)
                    {
                      c(bool);
                      return;
                    }
                  } while (a(6, paramArrayOfObject));
                  if (this.jdField_a_of_type_Tug != null) {
                    this.jdField_a_of_type_Tug.c(this.jdField_a_of_type_AndroidWidgetTextView);
                  }
                  if (localLong.longValue() != 0L) {
                    QLog.e(jdField_a_of_type_JavaLangString, 1, "reply fail ret=" + localLong + " msg=" + (String)localObject);
                  }
                  if ((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoReplyRsp))
                  {
                    localObject = ((FeedCloudWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
                    FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)paramArrayOfObject[4];
                    paramArrayOfObject = (String)paramArrayOfObject[5];
                    if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Ttr != null) && (this.jdField_a_of_type_Ttr.a(localStComment.id.get(), paramArrayOfObject))) {
                      l();
                    }
                    if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Ttr != null) && (this.jdField_a_of_type_Ttr.a(localStComment.id.get(), paramArrayOfObject, (FeedCloudMeta.StReply)localObject))) {
                      l();
                    }
                  }
                  c(a().a(b()));
                  return;
                } while (a(5, paramArrayOfObject));
                if (((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoReplyRsp)) && ((paramArrayOfObject[4] instanceof FeedCloudMeta.StComment)))
                {
                  localObject = ((FeedCloudWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
                  paramArrayOfObject = ((FeedCloudMeta.StComment)paramArrayOfObject[4]).id.get();
                  if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Ttr != null) && (!TextUtils.isEmpty(paramArrayOfObject)) && (!TextUtils.isEmpty((CharSequence)localObject)))
                  {
                    this.jdField_a_of_type_Ttr.a(paramArrayOfObject, (String)localObject);
                    l();
                  }
                }
                c(a().a(b()));
                return;
              } while (a(4, paramArrayOfObject));
              a(localLong.longValue(), this.jdField_b_of_type_AndroidContentContext.getString(2131698376), this.jdField_b_of_type_AndroidContentContext.getString(2131698375));
            } while (localLong.longValue() != 0L);
            paramArrayOfObject = (String)paramArrayOfObject[3];
          } while ((this.jdField_a_of_type_Ttr == null) || (TextUtils.isEmpty(paramArrayOfObject)));
          this.jdField_a_of_type_Ttr.b(paramArrayOfObject);
          l();
          return;
        } while (a(4, paramArrayOfObject));
        a(localLong.longValue(), this.jdField_b_of_type_AndroidContentContext.getString(2131698277), this.jdField_b_of_type_AndroidContentContext.getString(2131698276));
      } while (localLong.longValue() != 0L);
      paramArrayOfObject = (String)paramArrayOfObject[3];
    } while ((this.jdField_a_of_type_Ttr == null) || (TextUtils.isEmpty(paramArrayOfObject)));
    this.jdField_a_of_type_Ttr.a(paramArrayOfObject);
    l();
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.jdField_d_of_type_Int != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private String b()
  {
    if (a() == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getCellId null");
      return "";
    }
    return a().id.get();
  }
  
  private void b(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "popupComment");
    a(paramStComment, paramStReply, true, false);
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null)
      {
        if (!tra.a(paramStFeed.poster.id.get())) {
          break label75;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 3);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setFeedId(paramStFeed.id.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView.setPageType(3);
      }
      return;
      label75:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(0);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int m = 1;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "loadFeedDisplay() isRefresh => " + paramBoolean);
    if (paramBoolean) {
      m();
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {}
    for (;;)
    {
      e(0);
      if (m != 0) {
        f();
      }
      if ((this.jdField_a_of_type_Tug != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Tug.a());
      }
      return;
      m = 0;
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new QCircleCommentPanelView.5(this, paramInt));
  }
  
  private void c(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_Tug == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Tug.setOnShowListener(new tuq(this, paramStComment, paramStReply));
    this.jdField_a_of_type_Tug.a(new tur(this, paramStComment, paramStReply));
  }
  
  private void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370758);
      if (localTextView != null)
      {
        if (!paramBoolean) {
          break label37;
        }
        localTextView.setText(2131693932);
      }
    }
    return;
    label37:
    localTextView.setText("");
  }
  
  private void d(int paramInt)
  {
    if (tym.a().d(57))
    {
      tyk.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    tyg.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Ttr.a(a());
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  private void k()
  {
    this.i = false;
    this.j = true;
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new QCircleCommentPanelView.4(this));
  }
  
  private void m()
  {
    a().a(a(), false);
  }
  
  /* Error */
  private void n()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 688	tuk:jdField_a_of_type_Ttv	Lttv;
    //   6: ifnonnull +16 -> 22
    //   9: getstatic 69	tuk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: iconst_1
    //   13: ldc_w 690
    //   16: invokestatic 302	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokevirtual 504	tuk:a	()Lttv;
    //   27: aload_0
    //   28: invokespecial 256	tuk:b	()Ljava/lang/String;
    //   31: invokevirtual 693	ttv:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   34: putfield 262	tuk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_0
    //   39: invokevirtual 504	tuk:a	()Lttv;
    //   42: aload_0
    //   43: invokespecial 256	tuk:b	()Ljava/lang/String;
    //   46: invokevirtual 695	ttv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   49: putfield 259	tuk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   52: aload_0
    //   53: getfield 262	tuk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   56: ifnull -37 -> 19
    //   59: aload_0
    //   60: getfield 305	tuk:jdField_a_of_type_Ttr	Lttr;
    //   63: ifnull +55 -> 118
    //   66: aload_0
    //   67: getfield 305	tuk:jdField_a_of_type_Ttr	Lttr;
    //   70: aload_0
    //   71: invokespecial 177	tuk:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   74: invokevirtual 514	ttr:a	(Lfeedcloud/FeedCloudMeta$StFeed;)V
    //   77: aload_0
    //   78: getfield 305	tuk:jdField_a_of_type_Ttr	Lttr;
    //   81: invokevirtual 697	ttr:a	()V
    //   84: aload_0
    //   85: getfield 305	tuk:jdField_a_of_type_Ttr	Lttr;
    //   88: aload_0
    //   89: getfield 262	tuk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   92: invokevirtual 468	ttr:a	(Ljava/util/Collection;)Z
    //   95: pop
    //   96: aload_0
    //   97: getfield 677	tuk:i	Z
    //   100: ifeq +11 -> 111
    //   103: aload_0
    //   104: getfield 305	tuk:jdField_a_of_type_Ttr	Lttr;
    //   107: iconst_0
    //   108: invokevirtual 699	ttr:a	(I)V
    //   111: aload_0
    //   112: getfield 305	tuk:jdField_a_of_type_Ttr	Lttr;
    //   115: invokevirtual 702	ttr:notifyDataSetChanged	()V
    //   118: aload_0
    //   119: getfield 704	tuk:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   122: ifnull -103 -> 19
    //   125: aload_0
    //   126: getfield 97	tuk:jdField_g_of_type_Int	I
    //   129: aload_0
    //   130: invokevirtual 160	tuk:b	()I
    //   133: if_icmpeq -114 -> 19
    //   136: aload_0
    //   137: getfield 677	tuk:i	Z
    //   140: ifeq -121 -> 19
    //   143: aload_0
    //   144: aload_0
    //   145: invokevirtual 160	tuk:b	()I
    //   148: putfield 97	tuk:jdField_g_of_type_Int	I
    //   151: getstatic 69	tuk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: iconst_1
    //   155: ldc_w 706
    //   158: invokestatic 601	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_0
    //   162: getfield 704	tuk:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   165: iconst_0
    //   166: invokevirtual 711	android/widget/ListView:setSelection	(I)V
    //   169: goto -150 -> 19
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	tuk
    //   172	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	172	finally
    //   22	111	172	finally
    //   111	118	172	finally
    //   118	169	172	finally
  }
  
  private void o()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(200L);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void p()
  {
    n();
    c(a().a(b()));
    if (this.jdField_a_of_type_Ttr != null) {
      if (this.jdField_a_of_type_Ttr.getCount() != 0) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      return;
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_b_of_type_AndroidContentContext, 2130772019);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
    this.jdField_g_of_type_Boolean = false;
  }
  
  protected int a()
  {
    return 2131560529;
  }
  
  protected View a()
  {
    return null;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleForwardEvent.class);
    return localArrayList;
  }
  
  public ttv a()
  {
    if (this.jdField_a_of_type_Ttv == null)
    {
      this.jdField_a_of_type_Ttv = new ttv(a());
      this.jdField_d_of_type_Int = this.jdField_a_of_type_Ttv.hashCode();
    }
    return this.jdField_a_of_type_Ttv;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)a(2131366083));
    this.jdField_a_of_type_AndroidViewView = a(2131364539);
    this.jdField_d_of_type_AndroidViewView = a(2131366084);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364570));
    this.jdField_c_of_type_AndroidViewView = a(2131364550);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377631));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout = ((QCirclePolyParseFrameLayout)a(2131368960));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368733));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)a(2131379038));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131378657));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)a(2131368856));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)a(2131364581));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131364573));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Tuu = new tuu(this);
    this.jdField_a_of_type_Ttr = new ttr(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_Tuu);
    this.jdField_a_of_type_Ttr.a(a());
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ttr);
    this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setFeedData(a());
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setOnClickHookListener(new tul(this));
    b(a());
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new tum(this));
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new tun(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void a(Activity paramActivity, ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(View paramView)
  {
    a(null, null, true, false);
  }
  
  public void a(QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null) && ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) && (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).feedId.equals(b()))) {
      switch (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).eventStatus)
      {
      }
    }
    while ((!(paramSimpleBaseEvent instanceof QCircleForwardEvent)) || (((QCircleForwardEvent)paramSimpleBaseEvent).feed == null) || (!((QCircleForwardEvent)paramSimpleBaseEvent).feed.id.get().equals(b())) || (!((QCircleForwardEvent)paramSimpleBaseEvent).isSynchronizeComment))
    {
      return;
      c(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
      return;
    }
    a().a(a(), false);
  }
  
  public void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((b() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new QCircleCommentPanelView.11(this, paramStComment, paramStReply), this.jdField_f_of_type_Int * 500);
      return;
    }
    String str = b();
    if ((!bdje.a(str)) && (a() != null) && (a().vecComment.size() == 0) && (a().commentCount.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_c_of_type_Boolean)) {
        break label168;
      }
      a().a(a(), false);
    }
    for (;;)
    {
      a(paramStComment, paramStReply, true, false);
      return;
      label168:
      n();
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    a(paramStFeed, a());
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    if (paramStFeed != null)
    {
      this.jdField_c_of_type_JavaLangString = paramStFeed.poster.id.get();
      this.jdField_d_of_type_JavaUtilMap.put(Integer.valueOf(b()), paramStFeed);
    }
    if (b() != null)
    {
      this.h = true;
      if (paramStBusiInfoCommentListData == null) {
        break label123;
      }
      a().a(a(), paramStBusiInfoCommentListData);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setFeedData(a());
        if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        }
      }
      b(paramStFeed);
      return;
      label123:
      a().a(a(), false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        if (!paramBoolean) {
          break;
        }
        q();
      }
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      q();
      return true;
    }
    return false;
  }
  
  public boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  public int b()
  {
    return 0;
  }
  
  protected void b() {}
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    e();
  }
  
  protected void e()
  {
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Tus);
    yej.a().b(this);
    a().a();
    this.jdField_a_of_type_Ttv = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_d_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Tug != null)
    {
      this.jdField_a_of_type_Tug.dismiss();
      this.jdField_a_of_type_Tug = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((b() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new QCircleCommentPanelView.10(this), this.jdField_f_of_type_Int * 500);
    }
    FeedCloudMeta.StFeed localStFeed;
    do
    {
      return;
      localStFeed = a();
    } while (b() == null);
    this.jdField_g_of_type_Boolean = true;
    a().a(localStFeed, false);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        if (this.jdField_a_of_type_Ttr != null) {
          this.jdField_a_of_type_Ttr.a(a());
        }
        f();
      }
      return;
    }
  }
  
  public void h()
  {
    a(true);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null))
      {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarMask(null);
        this.jdField_f_of_type_Boolean = false;
        if (this.jdField_a_of_type_Tut != null) {
          this.jdField_a_of_type_Tut.b();
        }
        tym.a().a(61);
      }
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation) {
      for (;;)
      {
        return;
        tra.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      this.jdField_f_of_type_Boolean = true;
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mHideCommentListAnimation onAnimationStarttrue");
    }
    do
    {
      do
      {
        return;
      } while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_Tut != null) {
        this.jdField_a_of_type_Tut.a();
      }
      tym.a().b(61);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mShowCommentListAnimation onAnimationStarttrue");
    } while (this.jdField_a_of_type_AndroidAppActivity == null);
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null))
    {
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(a().getColor(2131167076), PorterDuff.Mode.SRC_ATOP));
      return;
    }
    tra.a(this.jdField_a_of_type_AndroidAppActivity, a().getColor(2131166179));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377631: 
      a(paramView);
      if (tym.a().d(57)) {
        tyk.a(60, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = 60;
        return;
        tyg.a(60, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
    case 2131368733: 
      a(paramView);
      if (tym.a().d(57)) {
        tyk.a(61, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = 61;
        return;
        tyg.a(61, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
    }
    if (tym.a().d(57)) {
      tyk.a(53, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    for (;;)
    {
      q();
      return;
      tyg.a(53, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuk
 * JD-Core Version:    0.7.0.1
 */