import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.1;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class ufp
  implements View.OnClickListener, IEventReceiver
{
  public int a;
  private long jdField_a_of_type_Long;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private stSimpleMetaReply jdField_a_of_type_UserGrowthStSimpleMetaReply;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  protected View a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new ufr(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<stSimpleMetaComment> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Long, stSimpleMetaPerson> jdField_a_of_type_JavaUtilMap = new HashMap();
  private uex jdField_a_of_type_Uex;
  private uez jdField_a_of_type_Uez;
  private ufh jdField_a_of_type_Ufh;
  private ufw jdField_a_of_type_Ufw;
  private ufx jdField_a_of_type_Ufx;
  private uqc jdField_a_of_type_Uqc;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<Long, stSimpleMetaReply> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 140;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  public ufp(Fragment paramFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramFragment.getActivity();
    this.jdField_a_of_type_AndroidContentContext = paramFragment.getActivity().getApplicationContext();
    this.jdField_a_of_type_Uez = new uez(this);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Ufw == null)
    {
      this.jdField_a_of_type_Ufw = new ufw(this, this.jdField_a_of_type_Int);
      wfo.a().registerSubscriber(this.jdField_a_of_type_Ufw);
      upe.d("comment", "注册一次评论监听器 , currentPage:" + paramInt);
      return;
    }
    upe.d("comment", "复用评论监听器 , currentPage:" + paramInt);
  }
  
  private int a()
  {
    if (umt.a(a())) {
      return this.jdField_e_of_type_Int;
    }
    return ugj.a().a.get(this.jdField_e_of_type_Int) + 1;
  }
  
  private stSimpleMetaFeed a()
  {
    int i = b();
    return (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
  }
  
  private stSimpleMetaPerson a()
  {
    if (zzz.a() != null)
    {
      localObject1 = zzz.a();
      localObject2 = new stSimpleMetaPerson();
      ((stSimpleMetaPerson)localObject2).id = ((CertifiedAccountMeta.StUser)localObject1).id.get();
      ((stSimpleMetaPerson)localObject2).nick = ((CertifiedAccountMeta.StUser)localObject1).nick.get();
      ((stSimpleMetaPerson)localObject2).type = ((CertifiedAccountMeta.StUser)localObject1).type.get();
      return localObject2;
    }
    Object localObject1 = new stSimpleMetaPerson();
    ((stSimpleMetaPerson)localObject1).id = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {}
    for (((stSimpleMetaPerson)localObject1).nick = bglf.h((QQAppInterface)localObject2, ((stSimpleMetaPerson)localObject1).id);; ((stSimpleMetaPerson)localObject1).nick = "")
    {
      ((stSimpleMetaPerson)localObject1).type = 0;
      return localObject1;
    }
  }
  
  @NotNull
  private WSDownloadParams a(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = ugb.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = ups.a(1);
    localWSDownloadParams.mStReportItem = umq.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    umt.a(a(), b(), d(), paramInt1, paramInt2, a());
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 1000L)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, paramString1, 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693957), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramString2, 0).a();
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if ((paramstSimpleMetaReply != null) && (paramstSimpleMetaReply.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692041), new Object[] { paramstSimpleMetaReply.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaComment = paramstSimpleMetaComment + "...";
      }
      this.jdField_a_of_type_Ufh.a(paramstSimpleMetaComment);
      return;
    }
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692041), new Object[] { paramstSimpleMetaComment.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaComment = paramstSimpleMetaComment + "...";
      }
      this.jdField_a_of_type_Ufh.a(paramstSimpleMetaComment);
      return;
    }
    paramstSimpleMetaComment = ugb.a().f();
    this.jdField_a_of_type_Ufh.a(paramstSimpleMetaComment);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt)
  {
    a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramInt, false);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      upe.d("comment", 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Ufh == null) {
      this.jdField_a_of_type_Ufh = new ufh(this.jdField_a_of_type_AndroidAppActivity);
    }
    a(paramstSimpleMetaComment, paramstSimpleMetaReply);
    this.jdField_a_of_type_Ufh.a(new ufu(this, paramstSimpleMetaComment, paramBoolean, paramstSimpleMetaReply));
    b(paramBoolean);
    this.jdField_a_of_type_Ufh.a(paramInt);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool = true;
    upe.b("comment", 1, "onCommentSend()");
    if (this.jdField_a_of_type_Ufh == null)
    {
      upe.b("comment", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = this.jdField_a_of_type_Ufh.a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131692042), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131693957), 0).a();
      return;
    }
    if (a() == null)
    {
      upe.d("comment", 1, "feed is null");
      return;
    }
    if (paramstSimpleMetaComment == null)
    {
      umt.a(a(), b(), a(), a(), paramBoolean, bool);
      if (!bool) {
        break label183;
      }
      a(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ufh.b("");
      this.jdField_a_of_type_Ufh.dismiss();
      return;
      bool = false;
      break;
      label183:
      a(str, paramstSimpleMetaReply, paramstSimpleMetaComment);
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaComment == null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaComment = new stSimpleMetaComment();
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment.wording = paramString;
    stSimpleMetaComment localstSimpleMetaComment = new stSimpleMetaComment();
    localstSimpleMetaComment.id = ("fakeId_" + System.currentTimeMillis());
    localstSimpleMetaComment.wording = paramString;
    localstSimpleMetaComment.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaComment.poster = a();
    localstSimpleMetaComment.replyList = new ArrayList();
    a().a(a(), localstSimpleMetaComment);
    this.jdField_a_of_type_Boolean = true;
    upe.c("comment", "2 mCommentListChanged:" + this.jdField_a_of_type_Boolean + ", hashCode" + hashCode());
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof WSFollowFragment)) {
      ((WSFollowFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a(b(), a());
    }
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = null;
    if (this.jdField_a_of_type_Uex != null)
    {
      this.jdField_a_of_type_Uex.a(0, localstSimpleMetaComment);
      this.jdField_a_of_type_Uex.notifyDataSetChanged();
    }
    upe.d("comment", "onCommentSend, lastPosition:" + this.jdField_d_of_type_Int + ",currentPosition:" + b());
    if (this.jdField_a_of_type_AndroidWidgetListView != null) {
      this.jdField_a_of_type_AndroidWidgetListView.setSelection(0);
    }
  }
  
  private void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply, stSimpleMetaComment paramstSimpleMetaComment)
  {
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaReply == null) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaReply = new stSimpleMetaReply();
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaReply.wording = paramString;
    stSimpleMetaReply localstSimpleMetaReply = new stSimpleMetaReply();
    localstSimpleMetaReply.id = ("fakeId_" + System.currentTimeMillis());
    localstSimpleMetaReply.wording = paramString;
    localstSimpleMetaReply.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaReply.poster = a();
    if (paramstSimpleMetaReply != null)
    {
      localstSimpleMetaReply.receiver = paramstSimpleMetaReply.poster;
      localstSimpleMetaReply.beReplyReplyId = paramstSimpleMetaReply.id;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_UserGrowthStSimpleMetaReply.receiver != null) {
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), this.jdField_a_of_type_UserGrowthStSimpleMetaReply.receiver);
      }
      upe.d("comment", "回复请求前,发送者:" + localstSimpleMetaReply.poster.nick + ",接受者:" + localstSimpleMetaReply.receiver.nick);
      this.jdField_b_of_type_Long = a().a(a(), paramstSimpleMetaComment, localstSimpleMetaReply);
      this.jdField_a_of_type_Boolean = true;
      upe.d("comment", "1 mCommentListChanged:" + this.jdField_a_of_type_Boolean + ", hashCode" + hashCode());
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), this.jdField_a_of_type_UserGrowthStSimpleMetaReply);
      }
      this.jdField_a_of_type_UserGrowthStSimpleMetaReply = null;
      if (this.jdField_a_of_type_Uex != null)
      {
        this.jdField_a_of_type_Uex.a(paramstSimpleMetaComment.id, localstSimpleMetaReply);
        this.jdField_a_of_type_Uex.notifyDataSetChanged();
      }
      return;
      localstSimpleMetaReply.receiver = paramstSimpleMetaComment.poster;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    TextView localTextView;
    if ((this.jdField_c_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_Boolean))
    {
      localTextView = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131371338);
      if (paramBoolean) {
        localTextView.setText(2131693249);
      }
    }
    else
    {
      return;
    }
    localTextView.setText("");
  }
  
  private boolean a(int paramInt, Object[] paramArrayOfObject)
  {
    return false;
  }
  
  private int b()
  {
    return this.jdField_e_of_type_Int;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      upe.b("comment", 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Uex.a(a().poster.id);
      this.jdField_a_of_type_Uex.a(a());
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ufh == null)
    {
      upe.d("comment", "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Ufh.a(new ufv(this, paramBoolean));
  }
  
  private String c()
  {
    if (a() == null)
    {
      upe.d("comment", 2, "getFeedId is null");
      return "";
    }
    return a().id;
  }
  
  private void c()
  {
    if (c() != null)
    {
      if (this.h) {
        upe.d("comment", "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
      }
    }
    else {
      return;
    }
    if (!TextUtils.isEmpty(a().a(c())))
    {
      upe.d("comment", "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
      return;
    }
    this.h = true;
    upe.d("comment", "请求开始 preLoading = true");
    a().a(a(), false);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = a().a(c());
    }
    this.jdField_a_of_type_Long += paramInt;
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new WsCommentPresenter.9(this));
    }
    wfo.a().dispatch(new uhc(5, new Object[] { c(), Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private boolean c()
  {
    return true;
  }
  
  @NotNull
  private String d()
  {
    if (umt.a(a())) {
      return umt.b(a());
    }
    return umt.b(a()) + a();
  }
  
  private void d()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        e();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          if (this.jdField_b_of_type_AndroidWidgetTextView != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(aafw.a(this.jdField_a_of_type_Long));
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          if (this.jdField_a_of_type_Uex.getCount() == 0) {
            bool = true;
          }
          a(bool);
          j();
          bool = a();
          if (!bool) {}
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
        if (this.jdField_b_of_type_AndroidViewView == null) {
          break label142;
        }
      }
      finally {}
      uep.a(this.jdField_b_of_type_AndroidViewView, new ufq(this));
      label142:
      l();
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	ufp:jdField_a_of_type_Uez	Luez;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 124
    //   11: ldc_w 722
    //   14: invokestatic 145	upe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual 494	ufp:a	()Luez;
    //   25: aload_0
    //   26: invokespecial 315	ufp:c	()Ljava/lang/String;
    //   29: invokevirtual 725	uez:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 319	ufp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: aload_0
    //   36: aload_0
    //   37: invokevirtual 494	ufp:a	()Luez;
    //   40: aload_0
    //   41: invokespecial 315	ufp:c	()Ljava/lang/String;
    //   44: invokevirtual 650	uez:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: putfield 62	ufp:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 319	ufp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: ifnull -37 -> 17
    //   57: aload_0
    //   58: getfield 322	ufp:jdField_a_of_type_Uex	Luex;
    //   61: ifnull +29 -> 90
    //   64: aload_0
    //   65: getfield 322	ufp:jdField_a_of_type_Uex	Luex;
    //   68: invokevirtual 727	uex:a	()V
    //   71: aload_0
    //   72: getfield 322	ufp:jdField_a_of_type_Uex	Luex;
    //   75: aload_0
    //   76: getfield 319	ufp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   79: invokevirtual 730	uex:a	(Ljava/util/Collection;)Z
    //   82: pop
    //   83: aload_0
    //   84: getfield 322	ufp:jdField_a_of_type_Uex	Luex;
    //   87: invokevirtual 526	uex:notifyDataSetChanged	()V
    //   90: ldc 124
    //   92: new 126	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 732
    //   102: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 68	ufp:jdField_d_of_type_Int	I
    //   109: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 530
    //   115: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokespecial 187	ufp:b	()I
    //   122: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 145	upe:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 532	ufp:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   135: ifnull +30 -> 165
    //   138: aload_0
    //   139: getfield 68	ufp:jdField_d_of_type_Int	I
    //   142: aload_0
    //   143: invokespecial 187	ufp:b	()I
    //   146: if_icmpeq +19 -> 165
    //   149: aload_0
    //   150: aload_0
    //   151: invokespecial 187	ufp:b	()I
    //   154: putfield 68	ufp:jdField_d_of_type_Int	I
    //   157: aload_0
    //   158: getfield 532	ufp:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   161: iconst_0
    //   162: invokevirtual 537	android/widget/ListView:setSelection	(I)V
    //   165: aload_0
    //   166: getfield 319	ufp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   169: ifnull -152 -> 17
    //   172: aload_0
    //   173: getfield 319	ufp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   176: invokevirtual 691	java/util/ArrayList:size	()I
    //   179: ifle -162 -> 17
    //   182: aload_0
    //   183: aload_0
    //   184: invokevirtual 494	ufp:a	()Luez;
    //   187: aload_0
    //   188: invokespecial 315	ufp:c	()Ljava/lang/String;
    //   191: invokevirtual 660	uez:a	(Ljava/lang/String;)I
    //   194: i2l
    //   195: putfield 609	ufp:jdField_a_of_type_Long	J
    //   198: goto -181 -> 17
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ufp
    //   201	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	201	finally
    //   20	90	201	finally
    //   90	165	201	finally
    //   165	198	201	finally
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366339));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364794);
    Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366340);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364787));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363807));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363787));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364768);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378525));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363774);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Ufx = new ufx(this);
    if (this.jdField_a_of_type_Uex == null)
    {
      upe.a("comment", "create mCommentAdapter ...");
      this.jdField_a_of_type_Uex = new uex(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ufx);
      this.jdField_a_of_type_Uex.a(a());
      this.jdField_a_of_type_Uex.a(a(), b());
    }
    for (;;)
    {
      this.jdField_a_of_type_Uex.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Uex.a(a());
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Uex);
      this.jdField_a_of_type_AndroidWidgetListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
      localObject = new ufs(this);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
      }
      g();
      return;
      upe.a("comment", "复用 mCommentAdapter ...");
    }
  }
  
  private void g()
  {
    String str = ugb.a().f();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setHint(str);
    }
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      uep.b(this.jdField_b_of_type_AndroidViewView, new uft(this));
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Uex.b();
      this.jdField_a_of_type_Uex.a();
      this.jdField_a_of_type_Uex.notifyDataSetChanged();
      a(false);
      i();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Uqc != null) {
      this.jdField_a_of_type_Uqc.c(1);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Uqc != null) {
      this.jdField_a_of_type_Uqc.b(1);
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {}
    for (int i = 1;; i = 0)
    {
      b(0);
      if (i != 0) {
        b();
      }
      if ((this.jdField_a_of_type_Ufh != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ufh.a());
      }
      return;
    }
  }
  
  private void l()
  {
    String str2 = umt.b(this.jdField_c_of_type_JavaLangString);
    String str1 = str2;
    if (!str2.equals("comment_page")) {
      str1 = str2 + a();
    }
    umt.a(this.jdField_c_of_type_JavaLangString, b(), str1, a());
  }
  
  private void m()
  {
    if (this.h)
    {
      this.h = false;
      upe.d("comment", "请求结束 preLoading = false");
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new WsCommentPresenter.10(this));
    }
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public uez a()
  {
    if (this.jdField_a_of_type_Uez == null) {
      this.jdField_a_of_type_Uez = new uez(this);
    }
    return this.jdField_a_of_type_Uez;
  }
  
  public void a()
  {
    upe.c("comment", "comment onRecycle");
    if (this.jdField_a_of_type_Ufw != null) {
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Ufw);
    }
    a().a();
    this.jdField_a_of_type_Uez = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Uex != null))
    {
      this.jdField_a_of_type_Uex.b.clear();
      this.jdField_a_of_type_Uex.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    this.jdField_e_of_type_Int = paramInt;
    uex.jdField_a_of_type_Int = a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    umt.a(a(), paramString, "comment_page_explicit", 1000001, paramInt2, a());
    a(null, null, paramInt1, true);
    j();
  }
  
  public void a(stSimpleMetaComment paramstSimpleMetaComment)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    int i;
    if (localstSimpleMetaFeed != null)
    {
      localstSimpleMetaFeed.total_comment_num += 1;
      i = localstSimpleMetaFeed.total_comment_num;
      localstSimpleMetaFeed.simpleComments.add(0, ueu.a(paramstSimpleMetaComment, a()));
    }
    for (;;)
    {
      paramstSimpleMetaComment = "";
      if (a() != null) {
        paramstSimpleMetaComment = a().id;
      }
      paramstSimpleMetaComment = new WSAddCommentEvent(paramstSimpleMetaComment, b(), i);
      uhd.a().a(paramstSimpleMetaComment);
      return;
      i = 0;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.poster.id;
      if (this.jdField_a_of_type_Uex != null) {
        this.jdField_a_of_type_Uex.a(paramstSimpleMetaFeed);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b()), paramstSimpleMetaFeed);
  }
  
  public void a(ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
  }
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      f();
      return;
    }
    upe.d("comment", 2, "viewStub is null");
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Uex != null) {
      this.jdField_a_of_type_Uex.a(paramString1, paramString2);
    }
  }
  
  public void a(uqc paramuqc)
  {
    this.jdField_a_of_type_Uqc = paramuqc;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    Integer localInteger = (Integer)paramArrayOfObject[1];
    Object localObject;
    if (paramArrayOfObject[2] == null)
    {
      localObject = "";
      upe.c("comment", "handleResponseEvent, action: " + paramArrayOfObject[0] + ",resultCode:" + localInteger + ",msg:" + (String)localObject);
    }
    switch (i)
    {
    case 2: 
    case 7: 
    case 8: 
    default: 
    case 1: 
    case 3: 
    case 5: 
    case 4: 
    case 6: 
      do
      {
        do
        {
          return;
          localObject = (String)paramArrayOfObject[2];
          break;
          c();
          return;
          if (this.jdField_a_of_type_Ufh != null) {
            this.jdField_a_of_type_Ufh.b(this.jdField_a_of_type_AndroidWidgetTextView);
          }
          if (a(5, paramArrayOfObject))
          {
            upe.d("comment", 1, "handleResponseEvent add comment isInterceptEvent");
            return;
          }
          if (localInteger.intValue() != 1000) {
            upe.d("comment", 1, "comment fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramArrayOfObject[3];
          if (localInteger.intValue() == 1000)
          {
            if ((this.jdField_a_of_type_Uex != null) && (this.jdField_a_of_type_Uex.a(String.valueOf(paramArrayOfObject[4]), localstPostFeedCommentV2Rsp.comment))) {
              n();
            }
            this.jdField_a_of_type_Boolean = true;
            c(1);
          }
          for (;;)
          {
            upe.d("comment", 1, "ACTION_ADD_FEED_COMMENT, result =" + localInteger + " msg=" + (String)localObject);
            a(localInteger.intValue(), anni.a(2131701000), (String)localObject);
            return;
            if ((this.jdField_a_of_type_Uex != null) && (this.jdField_a_of_type_Uex.a(String.valueOf(paramArrayOfObject[4])))) {
              n();
            }
          }
          if (a(4, paramArrayOfObject))
          {
            upe.d("comment", 1, "handleResponseEvent delete isInterceptEvent");
            return;
          }
          if ((localInteger.intValue() == 1000) && ((paramArrayOfObject[3] instanceof stDeleteFeedCommentRsp)))
          {
            paramArrayOfObject = (String)paramArrayOfObject[4];
            if ((this.jdField_a_of_type_Uex != null) && (this.jdField_a_of_type_Uex.a(paramArrayOfObject))) {
              n();
            }
            c(-1);
          }
          a(localInteger.intValue(), anni.a(2131700994), anni.a(2131701003));
          return;
          if (a(6, paramArrayOfObject))
          {
            upe.d("comment", 1, "handleResponseEvent add reply isInterceptEvent");
            return;
          }
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_Ufh != null) {
            this.jdField_a_of_type_Ufh.b(this.jdField_a_of_type_AndroidWidgetTextView);
          }
          if (localInteger.intValue() != 1000) {
            upe.d("comment", 1, "reply fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          localObject = ((stPostCommentReplyV2Rsp)paramArrayOfObject[3]).reply;
          paramArrayOfObject = (String)paramArrayOfObject[5];
          upe.d("comment", "fakeReplyId:" + paramArrayOfObject + ",reply toString :" + ((stSimpleMetaReply)localObject).toString());
          if (localInteger.intValue() == 1000) {
            if ((this.jdField_a_of_type_Uex != null) && (this.jdField_a_of_type_Uex.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject, (stSimpleMetaReply)localObject))) {
              n();
            }
          }
          for (;;)
          {
            a(localInteger.intValue(), anni.a(2131700993), anni.a(2131701004));
            return;
            if ((this.jdField_a_of_type_Uex != null) && (this.jdField_a_of_type_Uex.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject))) {
              n();
            }
          }
          if (a(5, paramArrayOfObject))
          {
            upe.d("comment", 1, "handleResponseEvent delete reply isInterceptEvent");
            return;
          }
          a(localInteger.intValue(), anni.a(2131700999), anni.a(2131701006));
        } while ((!(paramArrayOfObject[3] instanceof String)) || (!(paramArrayOfObject[4] instanceof stSimpleMetaReply)));
        localObject = (String)paramArrayOfObject[3];
        paramArrayOfObject = ((stSimpleMetaReply)paramArrayOfObject[4]).id;
      } while ((localInteger.intValue() != 1000) || (this.jdField_a_of_type_Uex == null) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramArrayOfObject)));
      this.jdField_a_of_type_Uex.a((String)localObject, paramArrayOfObject);
      n();
      return;
    }
    upe.d("comment", "onEvent: ACTION_GET_MORE_COMMENT！");
    m();
    if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(c())))
    {
      upe.d("comment", "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
      return;
    }
    if (a(4, paramArrayOfObject))
    {
      m();
      return;
    }
    boolean bool;
    if ((paramArrayOfObject[5] instanceof Boolean))
    {
      bool = ((Boolean)paramArrayOfObject[5]).booleanValue();
      if (!bool)
      {
        this.jdField_a_of_type_Boolean = false;
        upe.c("comment", "---------------------------------------- if(!loadMore) mCommentListChanged = false, hashCode" + hashCode());
      }
    }
    for (;;)
    {
      if ((paramArrayOfObject[3] instanceof stGetFeedCommentListV2Rsp))
      {
        if (this.jdField_a_of_type_Uex != null)
        {
          paramArrayOfObject = ((stGetFeedCommentListV2Rsp)paramArrayOfObject[3]).comments;
          if (paramArrayOfObject.size() != 0) {
            break label1035;
          }
          a(true);
        }
        for (;;)
        {
          if ((!this.jdField_b_of_type_Boolean) || (bool)) {
            break label1065;
          }
          paramArrayOfObject = this.jdField_a_of_type_AndroidSupportV4AppFragment.getActivity();
          if (paramArrayOfObject == null) {
            break;
          }
          paramArrayOfObject.runOnUiThread(new WsCommentPresenter.8(this));
          return;
          label1035:
          if (!bool) {
            this.jdField_a_of_type_Uex.a();
          }
          this.jdField_a_of_type_Uex.a(paramArrayOfObject);
          n();
          c(0);
        }
        label1065:
        break;
      }
      upe.d("comment", "获取评论response失败");
      return;
      bool = true;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewViewStub != null)
    {
      b(this.jdField_a_of_type_AndroidViewViewStub);
      this.jdField_a_of_type_AndroidViewViewStub = null;
    }
    if ((c() == null) && (this.jdField_c_of_type_Int <= 3))
    {
      this.jdField_c_of_type_Int += 1;
      a().a().postDelayed(new WsCommentPresenter.1(this), this.jdField_c_of_type_Int * 500);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    String str;
    do
    {
      return;
      localstSimpleMetaFeed = a();
      if (localstSimpleMetaFeed == null)
      {
        upe.d("comment", "showCommentListWithAnim, but feed is null");
        return;
      }
      str = c();
    } while (str == null);
    this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      upe.c("comment", "position:" + b() + ",feedId:" + localstSimpleMetaFeed.id + ",cellId:" + str + ",loadedComments size:" + i + ",mCommentListChanged:" + this.jdField_a_of_type_Boolean + ",hashCode:" + hashCode());
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      upe.c("comment", "11111111111111111111111111 mCommentListChanged");
      a().a(localstSimpleMetaFeed, false);
      this.jdField_b_of_type_Boolean = true;
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (this.h)
      {
        upe.c("comment", "444444444444444444444444 loadedComments == null and preloading is true");
        d();
        return;
      }
      upe.c("comment", "2222222222222222222222222 loadedComments == null and preloading is false");
      a().a(localstSimpleMetaFeed, false);
      this.jdField_b_of_type_Boolean = true;
      d();
      return;
    }
    upe.c("comment", "333333333333333333333 读取评论" + this.jdField_a_of_type_JavaUtilArrayList.size() + "条");
    d();
  }
  
  public void b(ViewStub paramViewStub)
  {
    if (paramViewStub == null) {
      return;
    }
    if (this.jdField_b_of_type_Int != -1)
    {
      a(paramViewStub, this.jdField_b_of_type_Int);
      return;
    }
    paramViewStub.setLayoutResource(2131559987);
    this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
    f();
  }
  
  public boolean b()
  {
    boolean bool = a();
    if (bool) {
      h();
    }
    return bool;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(1000001, 7);
      a(null, null, 2);
      continue;
      a(1000001, 7);
      a(null, null, 3);
      continue;
      a(1000001, 4);
      a(null, null, 0, false);
      continue;
      a(1000001, 7);
      a(null, null, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ufp
 * JD-Core Version:    0.7.0.1
 */