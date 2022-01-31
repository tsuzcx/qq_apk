import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetCommentListRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView.OnScrollListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.subscribe.comment.CommentPresenter.1;
import com.tencent.biz.subscribe.comment.CommentPresenter.10;
import com.tencent.biz.subscribe.comment.CommentPresenter.11;
import com.tencent.biz.subscribe.comment.CommentPresenter.2;
import com.tencent.biz.subscribe.comment.CommentPresenter.8;
import com.tencent.biz.subscribe.comment.CommentPresenter.9;
import com.tencent.biz.subscribe.event.CommentListShowStateEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class vzz
  extends vxj<CertifiedAccountMeta.StComment>
  implements View.OnClickListener, Animation.AnimationListener, CompoundButton.OnCheckedChangeListener, IEventReceiver
{
  private static final String jdField_a_of_type_JavaLangString = vzz.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private CertifiedAccountMeta.StComment jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private COMM.StCommonExt jdField_a_of_type_NS_COMMCOMM$StCommonExt;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new wab(this);
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<CertifiedAccountMeta.StComment> jdField_a_of_type_JavaUtilArrayList;
  private Map<Long, CertifiedAccountMeta.StUser> jdField_a_of_type_JavaUtilMap = new HashMap();
  private vyw jdField_a_of_type_Vyw;
  protected vzf a;
  private vzs jdField_a_of_type_Vzs;
  private final waf jdField_a_of_type_Waf;
  private wag jdField_a_of_type_Wag;
  private wah jdField_a_of_type_Wah;
  private wai jdField_a_of_type_Wai;
  private wbe jdField_a_of_type_Wbe;
  private wbg jdField_a_of_type_Wbg;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
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
  
  public vzz(Activity paramActivity, boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed, wah paramwah)
  {
    super(paramActivity, paramBoolean);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Waf = new waf(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Waf);
    this.jdField_a_of_type_Wah = paramwah;
    b(paramStFeed);
    k();
  }
  
  private CertifiedAccountMeta.StComment a(CertifiedAccountMeta.StComment paramStComment)
  {
    return new CertifiedAccountMeta.StComment();
  }
  
  private CertifiedAccountMeta.StFeed a()
  {
    int i = a();
    return (CertifiedAccountMeta.StFeed)this.jdField_d_of_type_JavaUtilMap.get(Integer.valueOf(i));
  }
  
  private CertifiedAccountMeta.StReply a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (paramStComment == null) {
      return null;
    }
    return new CertifiedAccountMeta.StReply();
  }
  
  private CertifiedAccountMeta.StUser a()
  {
    if (vvt.a() != null) {
      return vvt.a();
    }
    CertifiedAccountMeta.StUser localStUser = new CertifiedAccountMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    localStUser.type.set(0);
    return localStUser;
  }
  
  private vzf a()
  {
    if (this.jdField_a_of_type_Vzf == null)
    {
      this.jdField_a_of_type_Vzf = new vzf();
      this.jdField_e_of_type_Int = this.jdField_a_of_type_Vzf.hashCode();
    }
    return this.jdField_a_of_type_Vzf;
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 0L)
    {
      bbmy.a(a(), 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(a(), 1, a().getResources().getString(2131628956), 0).a();
      return;
    }
    bbmy.a(a(), 1, paramString2, 0).a();
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Vzs == null) {
      this.jdField_a_of_type_Vzs = new vzs((Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    String str2;
    String str1;
    if (paramStReply != null) {
      if (paramStReply.postUser != null)
      {
        str2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131626777), new Object[] { paramStReply.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Vzs.b(str1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Vzs.a(new wac(this, paramStComment, paramStReply));
      c(paramStComment, paramStReply);
      this.jdField_a_of_type_Vzs.a(paramBoolean2);
      return;
      if ((paramStComment != null) && (paramStComment.postUser != null))
      {
        str2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131626777), new Object[] { paramStComment.postUser.nick.get() });
        str1 = str2;
        if (str2.length() > 10)
        {
          str1 = str2.substring(0, 10);
          str1 = str1 + "...";
        }
        this.jdField_a_of_type_Vzs.b(str1);
      }
      else
      {
        this.jdField_a_of_type_Vzs.b(this.jdField_a_of_type_AndroidContentContext.getString(2131626772));
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
      paramStReply = new wdt();
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
      wdr.a(this.jdField_a_of_type_AndroidContentContext, paramStReply);
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
    int i = 1;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "loadFeedDisplay() isRefresh => " + paramBoolean);
    if (paramBoolean) {
      n();
    }
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {}
    for (;;)
    {
      c(0);
      if (i != 0) {
        h();
      }
      if ((this.jdField_a_of_type_Vzs != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vzs.a());
      }
      return;
      i = 0;
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
                    k();
                    return;
                    this.jdField_c_of_type_Boolean = false;
                    if (paramArrayOfObject[3] != null)
                    {
                      localObject2 = (CertifiedAccountRead.StGetFeedDetailRsp)paramArrayOfObject[3];
                      if (a(4, paramArrayOfObject)) {
                        continue;
                      }
                      b((CertifiedAccountMeta.StFeed)((CertifiedAccountRead.StGetFeedDetailRsp)localObject2).feed.get());
                      if (this.jdField_a_of_type_Wah != null) {
                        this.jdField_a_of_type_Wah.a((CertifiedAccountRead.StGetFeedDetailRsp)localObject2, VSNetworkHelper.a((String)localObject1), localLong.longValue(), (String)localObject1);
                      }
                      if (this.jdField_g_of_type_Boolean) {
                        a(new CommentPresenter.10(this));
                      }
                    }
                    while (this.h)
                    {
                      this.h = false;
                      return;
                      QLog.w(jdField_a_of_type_JavaLangString, 1, "get feed detail response failed");
                      if (this.jdField_a_of_type_Wah != null) {
                        this.jdField_a_of_type_Wah.a(null, VSNetworkHelper.a((String)localObject1), localLong.longValue(), (String)localObject1);
                      }
                      if (!this.h) {
                        bbmy.a(a(), (CharSequence)localObject1, 0).a();
                      }
                    }
                  }
                  if (this.jdField_a_of_type_Vzs != null) {
                    this.jdField_a_of_type_Vzs.b(this.jdField_a_of_type_AndroidWidgetTextView);
                  }
                } while (a(5, paramArrayOfObject));
                if (localLong.longValue() != 0L) {
                  QLog.e(jdField_a_of_type_JavaLangString, 1, "comment fail ret=" + localLong + " msg=" + (String)localObject1);
                }
                if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp))
                {
                  localObject2 = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
                  if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Wbe != null) && (this.jdField_a_of_type_Wbe.a(String.valueOf(paramArrayOfObject[4])))) {
                    l();
                  }
                  if (localLong.longValue() == 0L)
                  {
                    if ((this.jdField_a_of_type_Wbe != null) && (this.jdField_a_of_type_Wbe.a(String.valueOf(paramArrayOfObject[4]), (CertifiedAccountMeta.StComment)localObject2))) {
                      l();
                    }
                    b(1);
                  }
                }
                a(localLong.longValue(), ajjy.a(2131636401), (String)localObject1);
                a().a().postDelayed(new CommentPresenter.11(this), 1000L);
                return;
              } while (a(4, paramArrayOfObject));
              if ((localLong.longValue() == 0L) && ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp)))
              {
                paramArrayOfObject = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
                if ((this.jdField_a_of_type_Wbe != null) && (this.jdField_a_of_type_Wbe.a(paramArrayOfObject))) {
                  l();
                }
                b(-1);
              }
              a(localLong.longValue(), ajjy.a(2131636395), ajjy.a(2131636404));
              return;
            } while (a(6, paramArrayOfObject));
            if (this.jdField_a_of_type_Vzs != null) {
              this.jdField_a_of_type_Vzs.b(this.jdField_a_of_type_AndroidWidgetTextView);
            }
            if (localLong.longValue() != 0L) {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "reply fail ret=" + localLong + " msg=" + (String)localObject1);
            }
            if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp))
            {
              localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
              localObject2 = (CertifiedAccountMeta.StComment)paramArrayOfObject[4];
              paramArrayOfObject = (String)paramArrayOfObject[5];
              if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Wbe != null) && (this.jdField_a_of_type_Wbe.a(((CertifiedAccountMeta.StComment)localObject2).id.get(), paramArrayOfObject))) {
                l();
              }
              if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Wbe != null) && (this.jdField_a_of_type_Wbe.a(((CertifiedAccountMeta.StComment)localObject2).id.get(), paramArrayOfObject, (CertifiedAccountMeta.StReply)localObject1))) {
                l();
              }
            }
            a(localLong.longValue(), ajjy.a(2131636394), ajjy.a(2131636405));
            return;
          } while (a(5, paramArrayOfObject));
          a(localLong.longValue(), ajjy.a(2131636400), ajjy.a(2131636407));
        } while ((!(paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp)) || (!(paramArrayOfObject[4] instanceof CertifiedAccountMeta.StComment)));
        localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
        paramArrayOfObject = ((CertifiedAccountMeta.StComment)paramArrayOfObject[4]).id.get();
      } while ((localLong.longValue() != 0L) || (this.jdField_a_of_type_Wbe == null) || (TextUtils.isEmpty(paramArrayOfObject)) || (TextUtils.isEmpty((CharSequence)localObject1)));
      this.jdField_a_of_type_Wbe.a(paramArrayOfObject, (String)localObject1);
      l();
      return;
    } while ((a(4, paramArrayOfObject)) || (!(paramArrayOfObject[3] instanceof CertifiedAccountRead.StGetCommentListRsp)));
    if (this.jdField_a_of_type_Wbe != null) {
      this.jdField_a_of_type_Wbe.a(((CertifiedAccountRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get());
    }
    l();
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return this.jdField_e_of_type_Int != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private boolean a(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (vvt.a() != null) && (paramStUser.id.get().equals(vvt.a().id.get()))) {}
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
  
  private void b(int paramInt)
  {
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = a().a(b());
    }
    this.jdField_d_of_type_Int += paramInt;
    a(new CommentPresenter.2(this));
    sgi.a().dispatch(new vzr(5, new Object[] { b(), Integer.valueOf(this.jdField_d_of_type_Int) }));
  }
  
  private void b(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    a(paramStComment, paramStReply, true, false);
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.jdField_d_of_type_JavaLangString = paramStFeed.poster.id.get();
    }
    this.jdField_d_of_type_JavaUtilMap.put(Integer.valueOf(a()), paramStFeed);
  }
  
  private void b(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131304792);
      if (localTextView != null)
      {
        if (!paramBoolean) {
          break label37;
        }
        localTextView.setText(2131628174);
      }
    }
    return;
    label37:
    localTextView.setText("");
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Wbe.a(a().poster.id.get());
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  private void c(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_Vzs == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Vzs.setOnShowListener(new wad(this, paramStComment, paramStReply));
    this.jdField_a_of_type_Vzs.a(new wae(this, paramStComment, paramStReply));
  }
  
  private void k()
  {
    if (b() != null)
    {
      this.h = true;
      a().a(a(), false);
    }
  }
  
  private void l()
  {
    a(new CommentPresenter.1(this));
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)a(2131300394));
    this.jdField_b_of_type_AndroidViewView = a(2131298908);
    this.jdField_e_of_type_AndroidViewView = a(2131300395);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131298939));
    this.jdField_c_of_type_AndroidViewView = a(2131298919);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131311296));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = a(2131297984);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Wai = new wai(this);
    this.jdField_a_of_type_Wbe = new wbe(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Wai);
    this.jdField_a_of_type_Wbe.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Wbe);
    this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new waa(this));
    }
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
    //   2: aload_0
    //   3: getfield 260	vzz:jdField_a_of_type_Vzf	Lvzf;
    //   6: ifnonnull +16 -> 22
    //   9: getstatic 61	vzz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: iconst_1
    //   13: ldc_w 764
    //   16: invokestatic 326	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokespecial 273	vzz:a	()Lvzf;
    //   27: aload_0
    //   28: invokespecial 246	vzz:b	()Ljava/lang/String;
    //   31: invokevirtual 767	vzf:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   34: putfield 252	vzz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_0
    //   39: invokespecial 273	vzz:a	()Lvzf;
    //   42: aload_0
    //   43: invokespecial 246	vzz:b	()Ljava/lang/String;
    //   46: invokevirtual 770	vzf:a	(Ljava/lang/String;)LNS_COMM/COMM$StCommonExt;
    //   49: putfield 234	vzz:jdField_a_of_type_NS_COMMCOMM$StCommonExt	LNS_COMM/COMM$StCommonExt;
    //   52: aload_0
    //   53: getfield 252	vzz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   56: ifnull -37 -> 19
    //   59: aload_0
    //   60: getfield 280	vzz:jdField_a_of_type_Wbe	Lwbe;
    //   63: ifnull +29 -> 92
    //   66: aload_0
    //   67: getfield 280	vzz:jdField_a_of_type_Wbe	Lwbe;
    //   70: invokevirtual 772	wbe:a	()V
    //   73: aload_0
    //   74: getfield 280	vzz:jdField_a_of_type_Wbe	Lwbe;
    //   77: aload_0
    //   78: getfield 252	vzz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   81: invokevirtual 629	wbe:a	(Ljava/util/Collection;)Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 280	vzz:jdField_a_of_type_Wbe	Lwbe;
    //   89: invokevirtual 775	wbe:notifyDataSetChanged	()V
    //   92: aload_0
    //   93: getfield 724	vzz:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   96: ifnull +30 -> 126
    //   99: aload_0
    //   100: getfield 88	vzz:jdField_g_of_type_Int	I
    //   103: aload_0
    //   104: invokevirtual 135	vzz:a	()I
    //   107: if_icmpeq +19 -> 126
    //   110: aload_0
    //   111: aload_0
    //   112: invokevirtual 135	vzz:a	()I
    //   115: putfield 88	vzz:jdField_g_of_type_Int	I
    //   118: aload_0
    //   119: getfield 724	vzz:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   122: iconst_0
    //   123: invokevirtual 778	android/widget/ListView:setSelection	(I)V
    //   126: aload_0
    //   127: getfield 252	vzz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: ifnull -111 -> 19
    //   133: aload_0
    //   134: getfield 252	vzz:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   137: invokevirtual 783	java/util/ArrayList:size	()I
    //   140: ifle -121 -> 19
    //   143: aload_0
    //   144: aload_0
    //   145: invokespecial 273	vzz:a	()Lvzf;
    //   148: aload_0
    //   149: invokespecial 246	vzz:b	()Ljava/lang/String;
    //   152: invokevirtual 649	vzf:a	(Ljava/lang/String;)I
    //   155: putfield 117	vzz:jdField_d_of_type_Int	I
    //   158: goto -139 -> 19
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	vzz
    //   161	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	161	finally
    //   22	92	161	finally
    //   92	126	161	finally
    //   126	158	161	finally
  }
  
  private void p()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(b())) {}
        o();
        if (this.jdField_a_of_type_Wag != null) {
          this.jdField_a_of_type_Wag.a();
        }
        wcj.a().a(new CommentListShowStateEvent(true));
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(wbb.a(this.jdField_d_of_type_Int));
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          if (this.jdField_b_of_type_AndroidViewView != null) {
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_a_of_type_Wbe.getCount() == 0) {
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
        bool = false;
      }
      finally {}
    }
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772019);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_f_of_type_Boolean = true;
      wcj.a().a(new CommentListShowStateEvent(false));
    }
    this.jdField_g_of_type_Boolean = false;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected View a()
  {
    return null;
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
      a().a().postDelayed(new CommentPresenter.9(this, paramStComment, paramStReply), this.jdField_f_of_type_Int * 500);
      return;
    }
    String str = b();
    if ((!baip.a(str)) && (a() != null) && (a().vecComment.size() == 0) && (a().commentCount.get() != 0))
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
      o();
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    b(paramStFeed);
    k();
  }
  
  public boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  protected int b()
  {
    return 2131493148;
  }
  
  protected void b() {}
  
  public void b(View paramView)
  {
    a(null, null, true, false);
  }
  
  public void b(ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
  }
  
  public boolean b()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
    {
      q();
      return true;
    }
    return false;
  }
  
  public void c(View paramView)
  {
    a(null, null, true, true);
  }
  
  protected void d() {}
  
  protected void e()
  {
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Waf);
    a().a();
    this.jdField_a_of_type_Vzf = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_d_of_type_JavaUtilMap.clear();
  }
  
  protected void g()
  {
    m();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      a(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((b() == null) && (this.jdField_f_of_type_Int <= 3))
    {
      this.jdField_f_of_type_Int += 1;
      a().a().postDelayed(new CommentPresenter.8(this), this.jdField_f_of_type_Int * 500);
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
    p();
  }
  
  public void i()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        c(0);
        h();
      }
      return;
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void j()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        q();
      }
      return;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_f_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Wag != null) {
      this.jdField_a_of_type_Wag.b();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
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
    case 2131311296: 
      b(paramView);
      return;
    }
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vzz
 * JD-Core Version:    0.7.0.1
 */