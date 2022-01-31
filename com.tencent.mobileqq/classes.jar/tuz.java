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
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
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
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class tuz
  extends ydj<FeedCloudMeta.StFeed>
  implements View.OnClickListener, Animation.AnimationListener, IEventReceiver, yiy
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new tvd(this);
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
  private String jdField_a_of_type_JavaLangString;
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private Map<Long, FeedCloudMeta.StUser> jdField_a_of_type_JavaUtilMap = new HashMap();
  private tug jdField_a_of_type_Tug;
  protected tuk a;
  private tuv jdField_a_of_type_Tuv;
  private final tvh jdField_a_of_type_Tvh;
  private tvi jdField_a_of_type_Tvi;
  private tvj jdField_a_of_type_Tvj;
  private yho jdField_a_of_type_Yho;
  private boolean jdField_a_of_type_Boolean;
  private Context jdField_b_of_type_AndroidContentContext;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StComment jdField_b_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StReply jdField_b_of_type_FeedcloudFeedCloudMeta$StReply;
  private String jdField_b_of_type_JavaLangString;
  private Map<Long, FeedCloudMeta.StComment> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
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
  
  public tuz(@NonNull Context paramContext)
  {
    super(paramContext, false);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Tvh = new tvh(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Tvh);
    yiw.a().a(this);
    l();
  }
  
  private QCircleInitBean a()
  {
    return (QCircleInitBean)((Activity)a()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
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
  
  private String a()
  {
    if (a() == null)
    {
      QLog.e("QCircleCommentPanelView", 2, "getCellId null");
      return "";
    }
    return a().id.get();
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_b_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      QLog.e("QCircleCommentPanelView", 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Tuv == null) {
      this.jdField_a_of_type_Tuv = new tuv((Activity)this.jdField_b_of_type_AndroidContentContext);
    }
    String str2;
    String str1;
    if ((paramStReply != null) && (paramStReply.has())) {
      if (paramStReply.postUser != null)
      {
        str2 = String.format(this.jdField_b_of_type_AndroidContentContext.getString(2131692456), new Object[] { paramStReply.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Tuv.b(str1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Tuv.a(new tve(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.jdField_a_of_type_Tuv.a(paramBoolean2);
      return;
      if ((paramStComment != null) && (paramStComment.has()) && (paramStComment.postUser != null))
      {
        str2 = String.format(this.jdField_b_of_type_AndroidContentContext.getString(2131692456), new Object[] { paramStComment.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Tuv.b(str1);
      }
      else
      {
        this.jdField_a_of_type_Tuv.b(this.jdField_b_of_type_AndroidContentContext.getString(2131692451));
      }
    }
  }
  
  private void a(String paramString)
  {
    int m = 0;
    for (;;)
    {
      if (m < this.jdField_a_of_type_AndroidWidgetListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(m);
        if ((localObject instanceof QCircleCommentItemView))
        {
          localObject = (QCircleCommentItemView)localObject;
          if ((((QCircleCommentItemView)localObject).a() != null) && (((QCircleCommentItemView)localObject).a().id.get().equals(paramString)))
          {
            localObject = ((QCircleCommentItemView)localObject).a();
            if (localObject != null) {
              this.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(m + this.jdField_a_of_type_AndroidWidgetListView.getFirstVisiblePosition(), -((LinearLayout)localObject).getHeight());
            }
          }
        }
      }
      else
      {
        return;
      }
      m += 1;
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
                              return;
                              localObject = (String)paramArrayOfObject[2];
                              break;
                            } while (a(4, paramArrayOfObject));
                            this.jdField_c_of_type_Boolean = false;
                            if (paramArrayOfObject[3] != null)
                            {
                              if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null) && (((Boolean)paramArrayOfObject[5]).booleanValue())) {
                                b();
                              }
                              f(a().a(a()));
                              if (this.jdField_g_of_type_Boolean) {
                                this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new QCircleCommentPanelView.12(this));
                              }
                            }
                          } while (!this.h);
                          this.h = false;
                          return;
                        } while ((a(4, paramArrayOfObject)) || (!(paramArrayOfObject[3] instanceof FeedCloudRead.StGetCommentListRsp)));
                        if (this.jdField_a_of_type_Tug != null)
                        {
                          paramArrayOfObject = ((FeedCloudRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get();
                          this.jdField_a_of_type_Tug.a(paramArrayOfObject);
                        }
                        m();
                        return;
                        if (this.jdField_a_of_type_Tuv != null) {
                          this.jdField_a_of_type_Tuv.c(this.jdField_a_of_type_AndroidWidgetTextView);
                        }
                      } while (a(5, paramArrayOfObject));
                      if (localLong.longValue() != 0L) {
                        QLog.e("QCircleCommentPanelView", 1, "comment fail ret=" + localLong + " msg=" + (String)localObject);
                      }
                      if ((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoCommentRsp))
                      {
                        localObject = ((FeedCloudWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
                        if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Tug != null) && (this.jdField_a_of_type_Tug.a(String.valueOf(paramArrayOfObject[4])))) {
                          m();
                        }
                        if (localLong.longValue() == 0L)
                        {
                          if ((this.jdField_a_of_type_Tug != null) && (this.jdField_a_of_type_Tug.a(String.valueOf(paramArrayOfObject[4]), (FeedCloudMeta.StComment)localObject))) {
                            m();
                          }
                          c(a().a(a()));
                        }
                      }
                    } while (this.jdField_a_of_type_Tug == null);
                    this.jdField_a_of_type_Tug.a(a());
                    return;
                  } while ((a(4, paramArrayOfObject)) || (localLong.longValue() != 0L) || (!(paramArrayOfObject[3] instanceof FeedCloudWrite.StDoCommentRsp)));
                  paramArrayOfObject = ((FeedCloudWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
                  if ((this.jdField_a_of_type_Tug != null) && (this.jdField_a_of_type_Tug.a(paramArrayOfObject))) {
                    m();
                  }
                  c(a().a(a()));
                } while (this.jdField_a_of_type_Tug == null);
                if (this.jdField_a_of_type_Tug.getCount() == 0) {}
                for (boolean bool = true;; bool = false)
                {
                  c(bool);
                  return;
                }
              } while (a(6, paramArrayOfObject));
              if (this.jdField_a_of_type_Tuv != null) {
                this.jdField_a_of_type_Tuv.c(this.jdField_a_of_type_AndroidWidgetTextView);
              }
              if (localLong.longValue() != 0L) {
                QLog.e("QCircleCommentPanelView", 1, "reply fail ret=" + localLong + " msg=" + (String)localObject);
              }
              if ((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoReplyRsp))
              {
                localObject = ((FeedCloudWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
                FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)paramArrayOfObject[4];
                paramArrayOfObject = (String)paramArrayOfObject[5];
                if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Tug != null) && (this.jdField_a_of_type_Tug.a(localStComment.id.get(), paramArrayOfObject))) {
                  m();
                }
                if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Tug != null) && (this.jdField_a_of_type_Tug.a(localStComment.id.get(), paramArrayOfObject, (FeedCloudMeta.StReply)localObject))) {
                  m();
                }
              }
              c(a().a(a()));
              return;
            } while (a(5, paramArrayOfObject));
            if (((paramArrayOfObject[3] instanceof FeedCloudWrite.StDoReplyRsp)) && ((paramArrayOfObject[4] instanceof FeedCloudMeta.StComment)))
            {
              localObject = ((FeedCloudWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
              paramArrayOfObject = ((FeedCloudMeta.StComment)paramArrayOfObject[4]).id.get();
              if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Tug != null) && (!TextUtils.isEmpty(paramArrayOfObject)) && (!TextUtils.isEmpty((CharSequence)localObject)))
              {
                this.jdField_a_of_type_Tug.a(paramArrayOfObject, (String)localObject);
                m();
              }
            }
            c(a().a(a()));
            return;
          } while ((a(4, paramArrayOfObject)) || (localLong.longValue() != 0L));
          paramArrayOfObject = (String)paramArrayOfObject[3];
        } while ((this.jdField_a_of_type_Tug == null) || (TextUtils.isEmpty(paramArrayOfObject)));
        this.jdField_a_of_type_Tug.b(paramArrayOfObject);
        m();
        return;
      } while ((a(4, paramArrayOfObject)) || (localLong.longValue() != 0L));
      paramArrayOfObject = (String)paramArrayOfObject[3];
    } while ((this.jdField_a_of_type_Tug == null) || (TextUtils.isEmpty(paramArrayOfObject)));
    this.jdField_a_of_type_Tug.a(paramArrayOfObject);
    m();
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.jdField_d_of_type_Int != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private void b(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    QLog.e("QCircleCommentPanelView", 1, "popupComment");
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
    QLog.d("QCircleCommentPanelView", 1, "loadFeedDisplay() isRefresh => " + paramBoolean);
    if (paramBoolean) {
      n();
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {}
    for (;;)
    {
      e(0);
      if (m != 0) {
        g();
      }
      if ((this.jdField_a_of_type_Tuv != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Tuv.a());
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
    if (this.jdField_a_of_type_Tuv == null)
    {
      QLog.e("QCircleCommentPanelView", 1, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Tuv.setOnShowListener(new tvf(this, paramStComment, paramStReply));
    this.jdField_a_of_type_Tuv.a(new tvg(this, paramStComment, paramStReply));
  }
  
  private void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370777);
      if (localTextView != null)
      {
        if (!paramBoolean) {
          break label37;
        }
        localTextView.setText(2131693934);
      }
    }
    return;
    label37:
    localTextView.setText("");
  }
  
  private void d(int paramInt)
  {
    if (tzy.a().d(57))
    {
      tzw.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      return;
    }
    tzs.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
  }
  
  private void d(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {}
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.d("QCircleCommentPanelView", 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Tug.a(a());
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  private void f(int paramInt)
  {
    o();
    c(paramInt);
    if (this.jdField_a_of_type_Tug != null) {
      if (this.jdField_a_of_type_Tug.getCount() != 0) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      return;
    }
  }
  
  private void l()
  {
    this.i = false;
    this.j = true;
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new QCircleCommentPanelView.4(this));
  }
  
  private void n()
  {
    a().a(a(), false);
  }
  
  /* Error */
  private void o()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 265
    //   5: iconst_1
    //   6: ldc_w 678
    //   9: invokestatic 587	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aload_0
    //   13: getfield 680	tuz:jdField_a_of_type_Tuk	Ltuk;
    //   16: ifnonnull +16 -> 32
    //   19: ldc_w 265
    //   22: iconst_1
    //   23: ldc_w 682
    //   26: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: aload_0
    //   34: invokevirtual 433	tuz:a	()Ltuk;
    //   37: aload_0
    //   38: invokespecial 280	tuz:a	()Ljava/lang/String;
    //   41: invokevirtual 685	tuk:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   44: putfield 286	tuz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   47: aload_0
    //   48: aload_0
    //   49: invokevirtual 433	tuz:a	()Ltuk;
    //   52: aload_0
    //   53: invokespecial 280	tuz:a	()Ljava/lang/String;
    //   56: invokevirtual 687	tuk:a	(Ljava/lang/String;)Ljava/lang/String;
    //   59: putfield 283	tuz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: aload_0
    //   63: getfield 286	tuz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   66: ifnonnull +24 -> 90
    //   69: aload_0
    //   70: invokespecial 186	tuz:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   73: ifnull +17 -> 90
    //   76: aload_0
    //   77: aload_0
    //   78: invokespecial 186	tuz:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   81: getfield 688	feedcloud/FeedCloudMeta$StFeed:vecComment	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 464	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: putfield 286	tuz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   90: aload_0
    //   91: getfield 286	tuz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   94: ifnonnull +14 -> 108
    //   97: aload_0
    //   98: new 690	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 691	java/util/ArrayList:<init>	()V
    //   105: putfield 286	tuz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   108: aload_0
    //   109: getfield 290	tuz:jdField_a_of_type_Tug	Ltug;
    //   112: ifnull +65 -> 177
    //   115: ldc_w 265
    //   118: iconst_1
    //   119: ldc_w 693
    //   122: invokestatic 587	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_0
    //   126: getfield 290	tuz:jdField_a_of_type_Tug	Ltug;
    //   129: aload_0
    //   130: invokespecial 186	tuz:a	()Lfeedcloud/FeedCloudMeta$StFeed;
    //   133: invokevirtual 507	tug:a	(Lfeedcloud/FeedCloudMeta$StFeed;)V
    //   136: aload_0
    //   137: getfield 290	tuz:jdField_a_of_type_Tug	Ltug;
    //   140: invokevirtual 695	tug:a	()V
    //   143: aload_0
    //   144: getfield 290	tuz:jdField_a_of_type_Tug	Ltug;
    //   147: aload_0
    //   148: getfield 286	tuz:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   151: invokevirtual 469	tug:a	(Ljava/util/Collection;)Z
    //   154: pop
    //   155: aload_0
    //   156: getfield 668	tuz:i	Z
    //   159: ifeq +11 -> 170
    //   162: aload_0
    //   163: getfield 290	tuz:jdField_a_of_type_Tug	Ltug;
    //   166: iconst_0
    //   167: invokevirtual 697	tug:a	(I)V
    //   170: aload_0
    //   171: getfield 290	tuz:jdField_a_of_type_Tug	Ltug;
    //   174: invokevirtual 700	tug:notifyDataSetChanged	()V
    //   177: aload_0
    //   178: getfield 361	tuz:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   181: ifnull -152 -> 29
    //   184: aload_0
    //   185: getfield 87	tuz:jdField_g_of_type_Int	I
    //   188: aload_0
    //   189: invokevirtual 169	tuz:b	()I
    //   192: if_icmpeq -163 -> 29
    //   195: aload_0
    //   196: getfield 668	tuz:i	Z
    //   199: ifeq -170 -> 29
    //   202: aload_0
    //   203: aload_0
    //   204: invokevirtual 169	tuz:b	()I
    //   207: putfield 87	tuz:jdField_g_of_type_Int	I
    //   210: ldc_w 265
    //   213: iconst_1
    //   214: ldc_w 702
    //   217: invokestatic 587	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: getfield 361	tuz:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   224: iconst_0
    //   225: invokevirtual 705	android/widget/ListView:setSelection	(I)V
    //   228: goto -199 -> 29
    //   231: astore_1
    //   232: aload_0
    //   233: monitorexit
    //   234: aload_1
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	tuz
    //   231	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	231	finally
    //   32	90	231	finally
    //   90	108	231	finally
    //   108	170	231	finally
    //   170	177	231	finally
    //   177	228	231	finally
  }
  
  private void p()
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
  
  public QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = a();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment = ((FeedCloudMeta.StComment)localStBusiInfoCommentListData.comment.get());
      this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply = ((FeedCloudMeta.StReply)localStBusiInfoCommentListData.reply.get());
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPanelView", 1, "getInfoError");
    }
    return null;
  }
  
  public tuk a()
  {
    if (this.jdField_a_of_type_Tuk == null)
    {
      this.jdField_a_of_type_Tuk = new tuk(a());
      this.jdField_d_of_type_Int = this.jdField_a_of_type_Tuk.hashCode();
    }
    return this.jdField_a_of_type_Tuk;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)a(2131366085));
    this.jdField_a_of_type_AndroidViewView = a(2131364541);
    if (ybu.a()) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#00000000"));
    }
    this.jdField_d_of_type_AndroidViewView = a(2131366086);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364572));
    this.jdField_c_of_type_AndroidViewView = a(2131364552);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377685));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout = ((QCirclePolyParseFrameLayout)a(2131368978));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131368747));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)a(2131379096));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131378711));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)a(2131368871));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRockeyPopupView = ((QCircleRockeyPopupView)a(2131364583));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131364575));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Tvj = new tvj(this);
    this.jdField_a_of_type_Tug = new tug(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_Tvj);
    this.jdField_a_of_type_Tug.a(a());
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Tug);
    this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setFeedData(a());
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setOnClickHookListener(new tva(this));
    b(a());
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new tvb(this));
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new tvc(this));
    d(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
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
    a(this.jdField_b_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_b_of_type_FeedcloudFeedCloudMeta$StReply, true, false);
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
  
  public void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((a() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new QCircleCommentPanelView.11(this, paramStComment, paramStReply), this.jdField_f_of_type_Int * 500);
      return;
    }
    String str = a();
    if ((!bdnn.a(str)) && (a() != null) && (a().vecComment.size() == 0) && (a().commentCount.get() != 0))
    {
      this.jdField_a_of_type_JavaUtilList = a().a(str);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_c_of_type_Boolean)) {
        break label215;
      }
      a().a(a(), false);
    }
    for (;;)
    {
      QLog.d("QCircleCommentPanelView", 1, "showCommentPanelOutSide, pageId: " + tzy.a().a() + "  parentPageId: " + tzy.a().b());
      a(paramStComment, paramStReply, true, false);
      return;
      label215:
      o();
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.jdField_b_of_type_JavaLangString = paramStFeed.poster.id.get();
      this.jdField_d_of_type_JavaUtilMap.put(Integer.valueOf(b()), paramStFeed);
      a().a(paramStFeed.id.get(), paramStFeed.commentCount.get());
    }
    if (a() != null) {
      this.h = true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setFeedData(a());
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
    }
    b(paramStFeed);
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
  
  public void b()
  {
    Object localObject = a();
    if ((localObject != null) && (((QCircleInitBean)localObject).mActionBean != null) && (((QCircleInitBean)localObject).mActionBean.mShowInputKeyboard) && (!this.k))
    {
      localObject = a();
      if (localObject != null)
      {
        a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).comment, ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reply, true, false);
        this.k = true;
      }
    }
  }
  
  protected void c() {}
  
  protected void d() {}
  
  public void e()
  {
    super.e();
    f();
  }
  
  protected void f()
  {
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Tvh);
    yiw.a().b(this);
    a().a();
    this.jdField_a_of_type_Tuk = null;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_d_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_Tuv != null)
    {
      this.jdField_a_of_type_Tuv.dismiss();
      this.jdField_a_of_type_Tuv = null;
    }
  }
  
  public void g()
  {
    int m = 0;
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((a() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new QCircleCommentPanelView.10(this), this.jdField_f_of_type_Int * 500);
      return;
    }
    FeedCloudMeta.StFeed localStFeed = a();
    Object localObject = a();
    QLog.d("QCircleCommentPanelView", 1, "showCommentListWithAnim, pageId: " + tzy.a().a() + "  parentPageId: " + tzy.a().b());
    if (localObject != null)
    {
      this.jdField_g_of_type_Boolean = true;
      if (a() != null)
      {
        localObject = a();
        a().a(a(), (QQCircleFeedBase.StBusiInfoCommentListData)localObject);
      }
    }
    else
    {
      if (localStFeed != null) {
        break label195;
      }
    }
    for (;;)
    {
      f(m);
      p();
      return;
      a().a(a(), false);
      break;
      label195:
      m = localStFeed.commentCount.get();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleForwardEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        if (this.jdField_a_of_type_Tug != null) {
          this.jdField_a_of_type_Tug.a(a());
        }
        g();
      }
      return;
    }
  }
  
  public void i()
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
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Tvi != null) {
        this.jdField_a_of_type_Tvi.b();
      }
      tzy.a().a(61);
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      this.jdField_f_of_type_Boolean = true;
      QLog.d("QCircleCommentPanelView", 2, "mHideCommentListAnimation onAnimationStarttrue");
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation) {
      return;
    }
    if (this.jdField_a_of_type_Tvi != null) {
      this.jdField_a_of_type_Tvi.a();
    }
    tzy.a().b(61);
    QLog.d("QCircleCommentPanelView", 2, "mShowCommentListAnimation onAnimationStarttrue");
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    QLog.d("QCircleCommentPanelView", 1, "onClick, pageId: " + tzy.a().a() + "  parentPageId: " + tzy.a().b());
    switch (m)
    {
    default: 
      return;
    case 2131377685: 
      a(paramView);
      if (tzy.a().d(57)) {
        tzw.a(60, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = 60;
        QLog.d("QCircleCommentPanelView", 1, "onClick text_input, feedId: " + a().id);
        return;
        tzs.a(60, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
    case 2131368747: 
      a(paramView);
      if (tzy.a().d(57)) {
        tzw.a(61, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
      for (;;)
      {
        this.jdField_e_of_type_Int = 61;
        QLog.d("QCircleCommentPanelView", 1, "onClick iv_comment, feedId: " + a().id);
        return;
        tzs.a(61, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      }
    }
    if (tzy.a().d(57)) {
      tzw.a(53, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
    for (;;)
    {
      QLog.d("QCircleCommentPanelView", 1, "onClick comment_list_title_close, feedId: " + a().id);
      q();
      return;
      tzs.a(53, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) && (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).feedId.equals(a()))) {
      switch (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).eventStatus)
      {
      }
    }
    while ((!(paramSimpleBaseEvent instanceof QCircleForwardEvent)) || (((QCircleForwardEvent)paramSimpleBaseEvent).feed == null) || (!((QCircleForwardEvent)paramSimpleBaseEvent).feed.id.get().equals(a())) || (!((QCircleForwardEvent)paramSimpleBaseEvent).isSynchronizeComment))
    {
      return;
      c(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
      return;
    }
    a().a(a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuz
 * JD-Core Version:    0.7.0.1
 */