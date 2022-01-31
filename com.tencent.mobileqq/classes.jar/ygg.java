import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView.OnScrollListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.comment.CommentPresenter.1;
import com.tencent.biz.subscribe.comment.CommentPresenter.10;
import com.tencent.biz.subscribe.comment.CommentPresenter.11;
import com.tencent.biz.subscribe.comment.CommentPresenter.12;
import com.tencent.biz.subscribe.comment.CommentPresenter.13;
import com.tencent.biz.subscribe.comment.CommentPresenter.14;
import com.tencent.biz.subscribe.comment.CommentPresenter.2;
import com.tencent.biz.subscribe.comment.CommentPresenter.9;
import com.tencent.biz.subscribe.comment.CommentView;
import com.tencent.biz.subscribe.comment.ReplyView;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.subscribe.event.CommentReplyEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class ygg
  extends ydj<CertifiedAccountMeta.StComment>
  implements View.OnClickListener, Animation.AnimationListener, CompoundButton.OnCheckedChangeListener, IEventReceiver
{
  private static final String jdField_a_of_type_JavaLangString = ygg.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new ygj(this);
  View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new ygi(this);
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private ArrayList<CertifiedAccountMeta.StComment> jdField_a_of_type_JavaUtilArrayList;
  private Map<Long, CertifiedAccountMeta.StUser> jdField_a_of_type_JavaUtilMap = new HashMap();
  private yfe jdField_a_of_type_Yfe;
  protected yfp a;
  private final ygn jdField_a_of_type_Ygn;
  private ygo jdField_a_of_type_Ygo;
  private ygp jdField_a_of_type_Ygp;
  private ygq jdField_a_of_type_Ygq;
  private yhm jdField_a_of_type_Yhm;
  private yho jdField_a_of_type_Yho;
  private yht jdField_a_of_type_Yht;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private Map<Long, CertifiedAccountMeta.StComment> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private Map<Long, CertifiedAccountMeta.StReply> jdField_c_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  private Map<Integer, CertifiedAccountMeta.StFeed> jdField_d_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  private boolean j;
  
  public ygg(Activity paramActivity, boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed, ygp paramygp, ExtraTypeInfo paramExtraTypeInfo)
  {
    super(paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Ygn = new ygn(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Ygn);
    this.jdField_a_of_type_Ygp = paramygp;
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    i();
    b(paramStFeed);
    l();
  }
  
  private CertifiedAccountMeta.StComment a(CertifiedAccountMeta.StComment paramStComment)
  {
    return new CertifiedAccountMeta.StComment();
  }
  
  private CertifiedAccountMeta.StFeed a()
  {
    int k = b();
    return (CertifiedAccountMeta.StFeed)this.jdField_d_of_type_JavaUtilMap.get(Integer.valueOf(k));
  }
  
  private CertifiedAccountMeta.StReply a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStComment == null) {
      return null;
    }
    return new CertifiedAccountMeta.StReply();
  }
  
  private CertifiedAccountMeta.StReply a(CertifiedAccountMeta.StComment paramStComment, String paramString)
  {
    if ((paramStComment != null) && (paramStComment.vecReply.get() != null) && (paramStComment.vecReply.get().size() > 0))
    {
      paramStComment = paramStComment.vecReply.get().iterator();
      while (paramStComment.hasNext())
      {
        CertifiedAccountMeta.StReply localStReply = (CertifiedAccountMeta.StReply)paramStComment.next();
        if (localStReply.id.get().equals(paramString)) {
          return localStReply;
        }
      }
    }
    return null;
  }
  
  private CertifiedAccountMeta.StUser a()
  {
    if (ybo.a() != null) {
      return ybo.a();
    }
    CertifiedAccountMeta.StUser localStUser = new CertifiedAccountMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    localStUser.type.set(0);
    return localStUser;
  }
  
  private yfp a()
  {
    if (this.jdField_a_of_type_Yfp == null)
    {
      this.jdField_a_of_type_Yfp = new yfp();
      this.jdField_e_of_type_Int = this.jdField_a_of_type_Yfp.hashCode();
    }
    return this.jdField_a_of_type_Yfp;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = a().a(b());
    }
    this.jdField_d_of_type_Int += paramInt;
    a(new CommentPresenter.2(this));
    umc.a().dispatch(new ygc(5, new Object[] { b(), Integer.valueOf(this.jdField_d_of_type_Int) }));
  }
  
  private void a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(paramInt);
    if ((localObject instanceof CommentView))
    {
      localObject = (CommentView)localObject;
      paramString = ((CommentView)localObject).a(paramString);
      localObject = ((CommentView)localObject).a();
      if ((paramString != null) && (localObject != null))
      {
        int k = ((LinearLayout)localObject).getTop();
        int m = paramString.getTop();
        QLog.d(jdField_a_of_type_JavaLangString, 2, "scrollToReplyView getTop containerTop:" + k + "replyViewTop:" + m);
        this.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(paramInt, -(k + m));
      }
    }
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 0L)
    {
      QQToast.a(a(), 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(a(), 1, a().getResources().getString(2131694779), 0).a();
      return;
    }
    QQToast.a(a(), 1, paramString2, 0).a();
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Yht == null) {
      this.jdField_a_of_type_Yht = new yht((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    String str2;
    String str1;
    if (paramStReply != null) {
      if (paramStReply.postUser != null)
      {
        str2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692456), new Object[] { paramStReply.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Yht.b(str1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Yht.a(new ygk(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.jdField_a_of_type_Yht.a(paramBoolean2);
      return;
      if ((paramStComment != null) && (paramStComment.postUser != null))
      {
        str2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692456), new Object[] { paramStComment.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Yht.b(str1);
      }
      else
      {
        this.jdField_a_of_type_Yht.b(this.jdField_a_of_type_AndroidContentContext.getString(2131692451));
      }
    }
  }
  
  private void a(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if ((paramStFeed == null) || (paramStComment == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramStReply == null)
    {
      paramStReply = paramStComment.postUser.id.get();
      localStringBuilder.append("uin:").append(paramStFeed.poster.id.get());
      localStringBuilder.append("|evil_uin:").append(paramStReply);
      localStringBuilder.append("|feed_id:").append(paramStFeed.id.get());
      localStringBuilder.append("|comment_id:").append(paramStComment.id.get());
      paramStFeed = paramStComment.content.get();
    }
    String str;
    for (paramStComment = paramStReply;; paramStComment = str)
    {
      paramStReply = new ylk();
      paramStReply.jdField_a_of_type_JavaLangString = "android";
      paramStReply.jdField_b_of_type_JavaLangString = AppSetting.f();
      paramStReply.jdField_c_of_type_JavaLangString = "1";
      paramStReply.jdField_d_of_type_JavaLangString = paramStComment;
      paramStReply.e = "KQQ";
      paramStReply.f = "2400002";
      paramStReply.g = "qzone_authentication_comment";
      paramStReply.h = "24000";
      paramStReply.i = "0";
      paramStReply.k = localStringBuilder.toString();
      paramStReply.l = paramStFeed;
      yli.a(this.jdField_a_of_type_AndroidContentContext, paramStReply);
      return;
      str = paramStReply.postUser.id.get();
      localStringBuilder.append("uin:").append(paramStFeed.poster.id.get());
      localStringBuilder.append("|evil_uin:").append(str);
      localStringBuilder.append("|feed_id:").append(paramStFeed.id.get());
      localStringBuilder.append("|comment_id:").append(paramStComment.id.get());
      localStringBuilder.append("|reply_id:").append(paramStReply.id.get());
      paramStFeed = paramStReply.content.get();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 1;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "loadFeedDisplay() isRefresh => " + paramBoolean);
    if (paramBoolean) {
      o();
    }
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {}
    for (;;)
    {
      c(0);
      if (k != 0) {
        b();
      }
      if ((this.jdField_a_of_type_Yht != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Yht.a());
      }
      return;
      k = 0;
    }
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    Long localLong = (Long)paramArrayOfObject[1];
    Object localObject1;
    if ((String)paramArrayOfObject[2] == null)
    {
      localObject1 = "";
      switch (((Integer)paramArrayOfObject[0]).intValue())
      {
      }
    }
    label370:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject2;
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    return;
                    localObject1 = (String)paramArrayOfObject[2];
                    break;
                    l();
                    return;
                    this.jdField_c_of_type_Boolean = false;
                    if (paramArrayOfObject[3] != null)
                    {
                      localObject2 = (CertifiedAccountRead.StGetFeedDetailRsp)paramArrayOfObject[3];
                      if (a(4, paramArrayOfObject)) {
                        continue;
                      }
                      b((CertifiedAccountMeta.StFeed)((CertifiedAccountRead.StGetFeedDetailRsp)localObject2).feed.get());
                      if (this.jdField_a_of_type_Ygp != null) {
                        this.jdField_a_of_type_Ygp.a((CertifiedAccountRead.StGetFeedDetailRsp)localObject2, VSNetworkHelper.a((String)localObject1), localLong.longValue(), (String)localObject1);
                      }
                      if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null))
                      {
                        localObject1 = (COMM.StCommonExt)paramArrayOfObject[5];
                        paramArrayOfObject = a().a(b());
                        if (((COMM.StCommonExt)localObject1).mapInfo.size() > 0)
                        {
                          localObject1 = ((COMM.Entry)((COMM.StCommonExt)localObject1).mapInfo.get(0)).value.get();
                          if ((paramArrayOfObject == null) || (paramArrayOfObject.size() <= 0) || (!((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0)).id.get().equals(localObject1))) {
                            break label414;
                          }
                          if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.getReplyId()))) {
                            break label385;
                          }
                          localObject1 = a((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.getReplyId());
                          if (localObject1 == null) {
                            break label370;
                          }
                          b();
                          yiw.a().a(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), (CertifiedAccountMeta.StReply)localObject1));
                          this.i = true;
                          this.j = true;
                        }
                      }
                      if (this.jdField_g_of_type_Boolean) {
                        a(new CommentPresenter.13(this));
                      }
                    }
                    for (;;)
                    {
                      if (!this.h) {
                        break label486;
                      }
                      this.h = false;
                      return;
                      a(new CommentPresenter.11(this));
                      break;
                      b();
                      yiw.a().a(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), null));
                      break;
                      a(new CommentPresenter.12(this));
                      break;
                      QLog.w(jdField_a_of_type_JavaLangString, 1, "get feed detail response failed");
                      if (this.jdField_a_of_type_Ygp != null) {
                        this.jdField_a_of_type_Ygp.a(null, VSNetworkHelper.a((String)localObject1), localLong.longValue(), (String)localObject1);
                      }
                      if (!this.h) {
                        QQToast.a(a(), (CharSequence)localObject1, 0).a();
                      }
                    }
                  }
                  if (this.jdField_a_of_type_Yht != null) {
                    this.jdField_a_of_type_Yht.c(this.jdField_a_of_type_AndroidWidgetTextView);
                  }
                } while (a(5, paramArrayOfObject));
                if (localLong.longValue() != 0L) {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "comment fail ret=" + localLong + " msg=" + (String)localObject1);
                }
                if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp))
                {
                  localObject2 = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
                  if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Yhm != null) && (this.jdField_a_of_type_Yhm.a(String.valueOf(paramArrayOfObject[4])))) {
                    m();
                  }
                  if (localLong.longValue() == 0L)
                  {
                    if ((this.jdField_a_of_type_Yhm != null) && (this.jdField_a_of_type_Yhm.a(String.valueOf(paramArrayOfObject[4]), (CertifiedAccountMeta.StComment)localObject2))) {
                      m();
                    }
                    a(1);
                  }
                }
                a(localLong.longValue(), alud.a(2131702580), (String)localObject1);
                a().a().postDelayed(new CommentPresenter.14(this), 1000L);
                return;
              } while (a(4, paramArrayOfObject));
              if ((localLong.longValue() == 0L) && ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp)))
              {
                paramArrayOfObject = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
                if ((this.jdField_a_of_type_Yhm != null) && (this.jdField_a_of_type_Yhm.a(paramArrayOfObject))) {
                  m();
                }
                a(-1);
              }
              a(localLong.longValue(), alud.a(2131702574), alud.a(2131702583));
              return;
            } while (a(6, paramArrayOfObject));
            if (this.jdField_a_of_type_Yht != null) {
              this.jdField_a_of_type_Yht.c(this.jdField_a_of_type_AndroidWidgetTextView);
            }
            if (localLong.longValue() != 0L) {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "reply fail ret=" + localLong + " msg=" + (String)localObject1);
            }
            if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp))
            {
              localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
              localObject2 = (CertifiedAccountMeta.StComment)paramArrayOfObject[4];
              paramArrayOfObject = (String)paramArrayOfObject[5];
              if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Yhm != null) && (this.jdField_a_of_type_Yhm.a(((CertifiedAccountMeta.StComment)localObject2).id.get(), paramArrayOfObject))) {
                m();
              }
              if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Yhm != null) && (this.jdField_a_of_type_Yhm.a(((CertifiedAccountMeta.StComment)localObject2).id.get(), paramArrayOfObject, (CertifiedAccountMeta.StReply)localObject1))) {
                m();
              }
            }
            a(localLong.longValue(), alud.a(2131702573), alud.a(2131702584));
            return;
          } while (a(5, paramArrayOfObject));
          a(localLong.longValue(), alud.a(2131702579), alud.a(2131702586));
        } while ((!(paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp)) || (!(paramArrayOfObject[4] instanceof CertifiedAccountMeta.StComment)));
        localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
        paramArrayOfObject = ((CertifiedAccountMeta.StComment)paramArrayOfObject[4]).id.get();
      } while ((localLong.longValue() != 0L) || (this.jdField_a_of_type_Yhm == null) || (TextUtils.isEmpty(paramArrayOfObject)) || (TextUtils.isEmpty((CharSequence)localObject1)));
      this.jdField_a_of_type_Yhm.a(paramArrayOfObject, (String)localObject1);
      m();
      return;
    } while ((a(4, paramArrayOfObject)) || (!(paramArrayOfObject[3] instanceof CertifiedAccountRead.StGetCommentListRsp)));
    label385:
    label414:
    label486:
    if (this.jdField_a_of_type_Yhm != null)
    {
      localObject1 = ((CertifiedAccountRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get();
      if ((paramArrayOfObject.length < 6) || (paramArrayOfObject[5] == null) || (!(paramArrayOfObject[5] instanceof String))) {
        break label1207;
      }
    }
    label1207:
    for (paramArrayOfObject = this.jdField_a_of_type_Yfp.a((List)localObject1, (String)paramArrayOfObject[5]);; paramArrayOfObject = (Object[])localObject1)
    {
      this.jdField_a_of_type_Yhm.a(paramArrayOfObject);
      m();
      return;
    }
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.jdField_e_of_type_Int != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private boolean a(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (ybo.a() != null) && (paramStUser.id.get().equals(ybo.a().id.get()))) {}
    while ((paramStUser != null) && (paramStUser.id.get().equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))) {
      return true;
    }
    return false;
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
  
  private void b(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "popupComment");
    a(paramStComment, paramStReply, true, false);
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.jdField_d_of_type_JavaLangString = paramStFeed.poster.id.get();
    }
    this.jdField_d_of_type_JavaUtilMap.put(Integer.valueOf(b()), paramStFeed);
  }
  
  private void b(boolean paramBoolean)
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
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Yhm.a(a().poster.id.get());
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  private void c(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_Yht == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Yht.setOnShowListener(new ygl(this, paramStComment, paramStReply));
    this.jdField_a_of_type_Yht.a(new ygm(this, paramStComment, paramStReply));
  }
  
  private void i()
  {
    this.i = false;
    this.j = true;
  }
  
  private void l()
  {
    if (b() != null)
    {
      this.h = true;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.getCommentId()))) {
        a().a(a(), false, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.getCommentId());
      }
    }
    else
    {
      return;
    }
    a().a(a(), false, "");
  }
  
  private void m()
  {
    a(new CommentPresenter.1(this));
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)a(2131366085));
    this.jdField_a_of_type_AndroidViewView = a(2131364541);
    this.jdField_e_of_type_AndroidViewView = a(2131366086);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364572));
    this.jdField_c_of_type_AndroidViewView = a(2131364552);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377685));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = a(2131363576);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_AndroidWidgetListView.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    this.jdField_a_of_type_Ygq = new ygq(this);
    this.jdField_a_of_type_Yhm = new yhm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ygq);
    this.jdField_a_of_type_Yhm.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Yhm);
    this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ygh(this));
    }
  }
  
  private void o()
  {
    a().a(a(), false);
  }
  
  /* Error */
  private void p()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 312	ygg:jdField_a_of_type_Yfp	Lyfp;
    //   6: ifnonnull +16 -> 22
    //   9: getstatic 65	ygg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: iconst_1
    //   13: ldc_w 902
    //   16: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokespecial 325	ygg:a	()Lyfp;
    //   27: aload_0
    //   28: invokespecial 298	ygg:b	()Ljava/lang/String;
    //   31: invokevirtual 632	yfp:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   34: putfield 304	ygg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_0
    //   39: invokespecial 325	ygg:a	()Lyfp;
    //   42: aload_0
    //   43: invokespecial 298	ygg:b	()Ljava/lang/String;
    //   46: invokevirtual 905	yfp:a	(Ljava/lang/String;)LNS_COMM/COMM$StCommonExt;
    //   49: putfield 285	ygg:jdField_a_of_type_NS_COMMCOMM$StCommonExt	LNS_COMM/COMM$StCommonExt;
    //   52: aload_0
    //   53: getfield 304	ygg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   56: ifnull -37 -> 19
    //   59: aload_0
    //   60: getfield 329	ygg:jdField_a_of_type_Yhm	Lyhm;
    //   63: ifnull +44 -> 107
    //   66: aload_0
    //   67: getfield 329	ygg:jdField_a_of_type_Yhm	Lyhm;
    //   70: invokevirtual 907	yhm:a	()V
    //   73: aload_0
    //   74: getfield 329	ygg:jdField_a_of_type_Yhm	Lyhm;
    //   77: aload_0
    //   78: getfield 304	ygg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   81: invokevirtual 780	yhm:a	(Ljava/util/Collection;)Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 677	ygg:i	Z
    //   89: ifeq +11 -> 100
    //   92: aload_0
    //   93: getfield 329	ygg:jdField_a_of_type_Yhm	Lyhm;
    //   96: iconst_0
    //   97: invokevirtual 908	yhm:a	(I)V
    //   100: aload_0
    //   101: getfield 329	ygg:jdField_a_of_type_Yhm	Lyhm;
    //   104: invokevirtual 911	yhm:notifyDataSetChanged	()V
    //   107: aload_0
    //   108: getfield 356	ygg:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   111: ifnull +47 -> 158
    //   114: aload_0
    //   115: getfield 97	ygg:jdField_g_of_type_Int	I
    //   118: aload_0
    //   119: invokevirtual 148	ygg:b	()I
    //   122: if_icmpeq +36 -> 158
    //   125: aload_0
    //   126: getfield 677	ygg:i	Z
    //   129: ifeq +29 -> 158
    //   132: aload_0
    //   133: aload_0
    //   134: invokevirtual 148	ygg:b	()I
    //   137: putfield 97	ygg:jdField_g_of_type_Int	I
    //   140: getstatic 65	ygg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: iconst_1
    //   144: ldc_w 913
    //   147: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 356	ygg:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   154: iconst_0
    //   155: invokevirtual 916	android/widget/ListView:setSelection	(I)V
    //   158: aload_0
    //   159: getfield 304	ygg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   162: ifnull -143 -> 19
    //   165: aload_0
    //   166: getfield 304	ygg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   169: invokevirtual 647	java/util/ArrayList:size	()I
    //   172: ifle -153 -> 19
    //   175: aload_0
    //   176: aload_0
    //   177: invokespecial 325	ygg:a	()Lyfp;
    //   180: aload_0
    //   181: invokespecial 298	ygg:b	()Ljava/lang/String;
    //   184: invokevirtual 338	yfp:a	(Ljava/lang/String;)I
    //   187: putfield 130	ygg:jdField_d_of_type_Int	I
    //   190: goto -171 -> 19
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	ygg
    //   193	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	193	finally
    //   22	100	193	finally
    //   100	107	193	finally
    //   107	158	193	finally
    //   158	190	193	finally
  }
  
  private void q()
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(b())) {}
        p();
        yiw.a().a(new CommentListShowStateEvent(true));
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(yhj.a(this.jdField_d_of_type_Int));
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0))
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(200L);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
            this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            this.jdField_e_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
          }
          if (this.jdField_a_of_type_Yhm.getCount() == 0)
          {
            bool = true;
            b(bool);
          }
        }
        else
        {
          if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
            continue;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772019);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_e_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      yiw.a().a(new CommentListShowStateEvent(false));
    }
    this.jdField_g_of_type_Boolean = false;
  }
  
  protected int a()
  {
    return 2131558739;
  }
  
  protected View a()
  {
    return null;
  }
  
  protected void a()
  {
    n();
  }
  
  public void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((b() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new CommentPresenter.10(this, paramStComment, paramStReply), this.jdField_f_of_type_Int * 500);
      return;
    }
    String str = b();
    if ((!bdnn.a(str)) && (a() != null) && (a().vecComment.size() == 0) && (a().commentCount.get() != 0))
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
      p();
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    b(paramStFeed);
    l();
  }
  
  public void a(View paramView)
  {
    a(null, null, true, false);
  }
  
  public void a(ygo paramygo)
  {
    this.jdField_a_of_type_Ygo = paramygo;
  }
  
  public void a(yho paramyho)
  {
    this.jdField_a_of_type_Yho = paramyho;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      r();
      return true;
    }
    return false;
  }
  
  public boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((b() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new CommentPresenter.9(this), this.jdField_f_of_type_Int * 500);
    }
    CertifiedAccountMeta.StFeed localStFeed;
    String str;
    do
    {
      return;
      localStFeed = a();
      str = b();
    } while (str == null);
    this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = true;
      a().a(localStFeed, false);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_g_of_type_Boolean = true;
      a().a(localStFeed, false);
      return;
    }
    q();
  }
  
  public void b(ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
  }
  
  protected void c() {}
  
  public void c(View paramView)
  {
    a(null, null, true, true);
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  protected void d() {}
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Yht != null) && (this.jdField_a_of_type_Yht.isShowing());
  }
  
  protected void f()
  {
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Ygn);
    a().a();
    this.jdField_a_of_type_Yfp = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_d_of_type_JavaUtilMap.clear();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) {}
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        if (this.jdField_a_of_type_Yhm != null) {
          this.jdField_a_of_type_Yhm.a(a().poster.id.get());
        }
        b();
      }
      return;
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {}
    for (int k = 1;; k = 0)
    {
      if (k != 0) {
        r();
      }
      return;
    }
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
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarMask(null);
      }
      this.jdField_f_of_type_Boolean = false;
      if (this.jdField_a_of_type_Ygo != null) {
        this.jdField_a_of_type_Ygo.l();
      }
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mHideCommentListAnimation onAnimationStarttrue");
    }
    do
    {
      do
      {
        return;
      } while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_Ygo != null) {
        this.jdField_a_of_type_Ygo.k();
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "mShowCommentListAnimation onAnimationStarttrue");
    } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp == null));
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(a().getColor(2131167078), PorterDuff.Mode.SRC_ATOP));
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.getId();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377685: 
      a(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygg
 * JD-Core Version:    0.7.0.1
 */