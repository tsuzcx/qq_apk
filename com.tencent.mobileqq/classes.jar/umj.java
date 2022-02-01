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
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.10;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.2;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.ContactUtils;
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

public class umj
  implements View.OnClickListener, IEventReceiver
{
  public int a;
  private long jdField_a_of_type_Long;
  private stSimpleMetaComment jdField_a_of_type_UserGrowthStSimpleMetaComment;
  private stSimpleMetaReply jdField_a_of_type_UserGrowthStSimpleMetaReply;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  View jdField_a_of_type_AndroidViewView;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new uml(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<stSimpleMetaComment> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Long, stSimpleMetaPerson> jdField_a_of_type_JavaUtilMap = new HashMap();
  ull jdField_a_of_type_Ull;
  private ulq jdField_a_of_type_Ulq;
  private uls jdField_a_of_type_Uls;
  private umb jdField_a_of_type_Umb;
  private ump jdField_a_of_type_Ump;
  private umq jdField_a_of_type_Umq;
  private uyy jdField_a_of_type_Uyy;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<Long, stSimpleMetaReply> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f = 140;
  
  public umj(Fragment paramFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramFragment.getActivity();
    this.jdField_a_of_type_AndroidContentContext = paramFragment.getActivity().getApplicationContext();
    this.jdField_a_of_type_Uls = new uls(this);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Ump == null)
    {
      this.jdField_a_of_type_Ump = new ump(this, this.jdField_a_of_type_Int);
      vli.a().registerSubscriber(this.jdField_a_of_type_Ump);
      uya.d("comment", "注册一次评论监听器 , currentPage:" + paramInt);
      return;
    }
    uya.d("comment", "复用评论监听器 , currentPage:" + paramInt);
  }
  
  private int a()
  {
    if (uvl.a(a())) {
      return this.jdField_e_of_type_Int;
    }
    return unc.a().a.get(this.jdField_e_of_type_Int) + 1;
  }
  
  private stSimpleMetaFeed a()
  {
    int i = b();
    return (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
  }
  
  private stSimpleMetaPerson a()
  {
    if (zbc.a() != null)
    {
      localObject1 = zbc.a();
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
    for (((stSimpleMetaPerson)localObject1).nick = ContactUtils.getAccountNickName((QQAppInterface)localObject2, ((stSimpleMetaPerson)localObject1).id);; ((stSimpleMetaPerson)localObject1).nick = "")
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
    localWSDownloadParams.mLinkStrategyType = umu.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = uyo.a(1);
    localWSDownloadParams.mStReportItem = uvi.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    uvl.a(a(), b(), d(), paramInt1, paramInt2, a());
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694073), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramString2, 0).a();
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if ((paramstSimpleMetaReply != null) && (paramstSimpleMetaReply.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692094), new Object[] { paramstSimpleMetaReply.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaComment = paramstSimpleMetaComment + "...";
      }
      this.jdField_a_of_type_Umb.a(paramstSimpleMetaComment);
      return;
    }
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692094), new Object[] { paramstSimpleMetaComment.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaComment = paramstSimpleMetaComment + "...";
      }
      this.jdField_a_of_type_Umb.a(paramstSimpleMetaComment);
      return;
    }
    paramstSimpleMetaComment = umu.a().f();
    this.jdField_a_of_type_Umb.a(paramstSimpleMetaComment);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt)
  {
    a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramInt, false);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      uya.d("comment", 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Umb == null) {
      this.jdField_a_of_type_Umb = new umb(this.jdField_a_of_type_AndroidAppActivity);
    }
    a(paramstSimpleMetaComment, paramstSimpleMetaReply);
    this.jdField_a_of_type_Umb.a(new umn(this, paramstSimpleMetaComment, paramBoolean, paramstSimpleMetaReply));
    b(paramBoolean);
    this.jdField_a_of_type_Umb.a(paramInt);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool = true;
    uya.b("comment", 1, "onCommentSend()");
    if (this.jdField_a_of_type_Umb == null)
    {
      uya.b("comment", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = this.jdField_a_of_type_Umb.a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131692095), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131694073), 0).a();
      return;
    }
    if (a() == null)
    {
      uya.d("comment", 1, "feed is null");
      return;
    }
    if (paramstSimpleMetaComment == null)
    {
      uvl.a(a(), b(), a(), a(), paramBoolean, bool);
      if (!bool) {
        break label183;
      }
      a(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Umb.b("");
      this.jdField_a_of_type_Umb.dismiss();
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
    uya.c("comment", "2 mCommentListChanged:" + this.jdField_a_of_type_Boolean + ", hashCode" + hashCode());
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof WSFollowFragment)) {
      ((WSFollowFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a(b(), a());
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = null;
    if (this.jdField_a_of_type_Ulq != null)
    {
      this.jdField_a_of_type_Ulq.a(0, localstSimpleMetaComment);
      this.jdField_a_of_type_Ulq.notifyDataSetChanged();
    }
    uya.d("comment", "onCommentSend, lastPosition:" + this.jdField_d_of_type_Int + ",currentPosition:" + b());
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
      uya.d("comment", "回复请求前,发送者:" + localstSimpleMetaReply.poster.nick + ",接受者:" + localstSimpleMetaReply.receiver.nick);
      this.jdField_b_of_type_Long = a().a(a(), paramstSimpleMetaComment, localstSimpleMetaReply);
      this.jdField_a_of_type_Boolean = true;
      uya.d("comment", "1 mCommentListChanged:" + this.jdField_a_of_type_Boolean + ", hashCode" + hashCode());
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), this.jdField_a_of_type_UserGrowthStSimpleMetaReply);
      }
      this.jdField_a_of_type_UserGrowthStSimpleMetaReply = null;
      if (this.jdField_a_of_type_Ulq != null)
      {
        this.jdField_a_of_type_Ulq.a(paramstSimpleMetaComment.id, localstSimpleMetaReply);
        this.jdField_a_of_type_Ulq.notifyDataSetChanged();
      }
      return;
      localstSimpleMetaReply.receiver = paramstSimpleMetaComment.poster;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_Boolean))
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693350);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
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
    if (this.jdField_a_of_type_AndroidViewView == null) {
      uya.b("comment", 1, "setCommentContainerVisible() mCommentContainer == null.");
    }
    while (paramInt != 0) {
      return;
    }
    this.jdField_a_of_type_Ulq.a(a().poster.id);
    this.jdField_a_of_type_Ulq.a(a());
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Umb == null)
    {
      uya.d("comment", "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Umb.a(new umo(this, paramBoolean));
  }
  
  private String c()
  {
    if (a() == null)
    {
      uya.d("comment", 2, "getFeedId is null");
      return "";
    }
    return a().id;
  }
  
  private void c()
  {
    if (c() != null)
    {
      if (this.jdField_e_of_type_Boolean) {
        uya.d("comment", "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
      }
    }
    else {
      return;
    }
    if (!TextUtils.isEmpty(a().a(c())))
    {
      uya.d("comment", "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    uya.d("comment", "请求开始 preLoading = true");
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
    vli.a().dispatch(new unv(5, new Object[] { c(), Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private boolean c()
  {
    return true;
  }
  
  @NotNull
  private String d()
  {
    if (uvl.a(a())) {
      return uvl.b(a());
    }
    return uvl.b(a()) + a();
  }
  
  private void d()
  {
    boolean bool = true;
    label134:
    for (;;)
    {
      int i;
      try
      {
        e();
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          i = 1;
          if (i != 0)
          {
            if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
              break label134;
            }
            this.jdField_c_of_type_AndroidWidgetTextView.setText(zgv.a(this.jdField_a_of_type_Long));
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            break label134;
            a(bool);
            j();
            bool = a();
            if (!bool) {
              break label127;
            }
          }
        }
        else
        {
          label81:
          i = 0;
          continue;
        }
        if (this.jdField_c_of_type_AndroidWidgetTextView != null)
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText("");
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      finally {}
      label127:
      do
      {
        bool = false;
        break;
        l();
        break label81;
      } while (i != 0);
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	umj:jdField_a_of_type_Uls	Luls;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 122
    //   11: ldc_w 699
    //   14: invokestatic 143	uya:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual 490	umj:a	()Luls;
    //   25: aload_0
    //   26: invokespecial 311	umj:c	()Ljava/lang/String;
    //   29: invokevirtual 702	uls:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 315	umj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: aload_0
    //   36: aload_0
    //   37: invokevirtual 490	umj:a	()Luls;
    //   40: aload_0
    //   41: invokespecial 311	umj:c	()Ljava/lang/String;
    //   44: invokevirtual 638	uls:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: putfield 60	umj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 315	umj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: ifnull -37 -> 17
    //   57: aload_0
    //   58: getfield 318	umj:jdField_a_of_type_Ulq	Lulq;
    //   61: ifnull +29 -> 90
    //   64: aload_0
    //   65: getfield 318	umj:jdField_a_of_type_Ulq	Lulq;
    //   68: invokevirtual 704	ulq:a	()V
    //   71: aload_0
    //   72: getfield 318	umj:jdField_a_of_type_Ulq	Lulq;
    //   75: aload_0
    //   76: getfield 315	umj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   79: invokevirtual 707	ulq:a	(Ljava/util/Collection;)Z
    //   82: pop
    //   83: aload_0
    //   84: getfield 318	umj:jdField_a_of_type_Ulq	Lulq;
    //   87: invokevirtual 522	ulq:notifyDataSetChanged	()V
    //   90: ldc 122
    //   92: new 124	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 709
    //   102: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 66	umj:jdField_d_of_type_Int	I
    //   109: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 526
    //   115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokespecial 185	umj:b	()I
    //   122: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 143	uya:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 528	umj:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   135: ifnull +38 -> 173
    //   138: aload_0
    //   139: getfield 66	umj:jdField_d_of_type_Int	I
    //   142: aload_0
    //   143: invokespecial 185	umj:b	()I
    //   146: if_icmpeq +27 -> 173
    //   149: aload_0
    //   150: aload_0
    //   151: invokespecial 185	umj:b	()I
    //   154: putfield 66	umj:jdField_d_of_type_Int	I
    //   157: aload_0
    //   158: getfield 528	umj:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   161: new 711	com/tencent/biz/pubaccount/weishi_new/comment/WsCommentPresenter$3
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 712	com/tencent/biz/pubaccount/weishi_new/comment/WsCommentPresenter$3:<init>	(Lumj;)V
    //   169: invokevirtual 716	android/widget/ListView:post	(Ljava/lang/Runnable;)Z
    //   172: pop
    //   173: aload_0
    //   174: getfield 315	umj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   177: ifnull -160 -> 17
    //   180: aload_0
    //   181: getfield 315	umj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   184: invokevirtual 679	java/util/ArrayList:size	()I
    //   187: ifle -170 -> 17
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 490	umj:a	()Luls;
    //   195: aload_0
    //   196: invokespecial 311	umj:c	()Ljava/lang/String;
    //   199: invokevirtual 648	uls:a	(Ljava/lang/String;)I
    //   202: i2l
    //   203: putfield 179	umj:jdField_a_of_type_Long	J
    //   206: goto -189 -> 17
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	umj
    //   209	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	209	finally
    //   20	90	209	finally
    //   90	173	209	finally
    //   173	206	209	finally
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366415));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364864));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363858));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363840));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364845);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371413));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378449));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363827);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Umq = new umq(this);
    if (this.jdField_a_of_type_Ulq == null)
    {
      uya.a("comment", "create mCommentAdapter ...");
      this.jdField_a_of_type_Ulq = new ulq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Umq);
      this.jdField_a_of_type_Ulq.a(a());
      this.jdField_a_of_type_Ulq.a(a(), b());
    }
    for (;;)
    {
      this.jdField_a_of_type_Ulq.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ulq.a(a());
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ulq);
      umm localumm = new umm(this);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(localumm);
      }
      g();
      return;
      uya.a("comment", "复用 mCommentAdapter ...");
    }
  }
  
  private void g()
  {
    String str = umu.a().f();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setHint(str);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Ull != null) && (this.jdField_a_of_type_Ull.isShowing())) {
      this.jdField_a_of_type_Ull.dismiss();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Ulq.b();
      this.jdField_a_of_type_Ulq.a();
      this.jdField_a_of_type_Ulq.notifyDataSetChanged();
      a(false);
      i();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Uyy != null) {
      this.jdField_a_of_type_Uyy.c(1);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Uyy != null) {
      this.jdField_a_of_type_Uyy.b(1);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {}
    b(0);
    b();
    if ((this.jdField_a_of_type_Umb != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Umb.a());
    }
  }
  
  private void l()
  {
    String str2 = uvl.b(this.jdField_c_of_type_JavaLangString);
    String str1 = str2;
    if (!str2.equals("comment_page")) {
      str1 = str2 + a();
    }
    uvl.a(this.jdField_c_of_type_JavaLangString, b(), str1, a());
  }
  
  private void m()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      uya.d("comment", "请求结束 preLoading = false");
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
  
  public uls a()
  {
    if (this.jdField_a_of_type_Uls == null) {
      this.jdField_a_of_type_Uls = new uls(this);
    }
    return this.jdField_a_of_type_Uls;
  }
  
  public void a()
  {
    uya.c("comment", "comment onRecycle");
    if (this.jdField_a_of_type_Ump != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Ump);
    }
    a().a();
    this.jdField_a_of_type_Uls = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Ulq != null))
    {
      this.jdField_a_of_type_Ulq.b.clear();
      this.jdField_a_of_type_Ulq.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    this.jdField_e_of_type_Int = paramInt;
    ulq.jdField_a_of_type_Int = a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    uvl.a(a(), paramString, "comment_page_explicit", 1000001, paramInt2, a());
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
      localstSimpleMetaFeed.simpleComments.add(0, ulo.a(paramstSimpleMetaComment, a()));
    }
    for (;;)
    {
      paramstSimpleMetaComment = "";
      if (a() != null) {
        paramstSimpleMetaComment = a().id;
      }
      paramstSimpleMetaComment = new WSAddCommentEvent(paramstSimpleMetaComment, b(), i);
      unw.a().a(paramstSimpleMetaComment);
      return;
      i = 0;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.poster.id;
      if (this.jdField_a_of_type_Ulq != null) {
        this.jdField_a_of_type_Ulq.a(paramstSimpleMetaFeed);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(b()), paramstSimpleMetaFeed);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    f();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_Ulq != null) {
      this.jdField_a_of_type_Ulq.a(paramString1, paramString2);
    }
  }
  
  public void a(uyy paramuyy)
  {
    this.jdField_a_of_type_Uyy = paramuyy;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    Integer localInteger = (Integer)paramArrayOfObject[1];
    Object localObject;
    if (paramArrayOfObject[2] == null)
    {
      localObject = "";
      uya.c("comment", "handleResponseEvent, action: " + paramArrayOfObject[0] + ",resultCode:" + localInteger + ",msg:" + (String)localObject);
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
          if (this.jdField_a_of_type_Umb != null) {
            this.jdField_a_of_type_Umb.b(this.jdField_b_of_type_AndroidWidgetTextView);
          }
          if (a(5, paramArrayOfObject))
          {
            uya.d("comment", 1, "handleResponseEvent add comment isInterceptEvent");
            return;
          }
          if (localInteger.intValue() != 1000) {
            uya.d("comment", 1, "comment fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramArrayOfObject[3];
          if (localInteger.intValue() == 1000)
          {
            if ((this.jdField_a_of_type_Ulq != null) && (this.jdField_a_of_type_Ulq.a(String.valueOf(paramArrayOfObject[4]), localstPostFeedCommentV2Rsp.comment))) {
              n();
            }
            this.jdField_a_of_type_Boolean = true;
            c(1);
          }
          for (;;)
          {
            uya.d("comment", 1, "ACTION_ADD_FEED_COMMENT, result =" + localInteger + " msg=" + (String)localObject);
            a(localInteger.intValue(), amtj.a(2131701342), (String)localObject);
            return;
            if ((this.jdField_a_of_type_Ulq != null) && (this.jdField_a_of_type_Ulq.a(String.valueOf(paramArrayOfObject[4])))) {
              n();
            }
          }
          if (a(4, paramArrayOfObject))
          {
            uya.d("comment", 1, "handleResponseEvent delete isInterceptEvent");
            return;
          }
          if ((localInteger.intValue() == 1000) && ((paramArrayOfObject[3] instanceof stDeleteFeedCommentRsp)))
          {
            paramArrayOfObject = (String)paramArrayOfObject[4];
            if ((this.jdField_a_of_type_Ulq != null) && (this.jdField_a_of_type_Ulq.a(paramArrayOfObject))) {
              n();
            }
            c(-1);
          }
          a(localInteger.intValue(), amtj.a(2131701336), amtj.a(2131701345));
          return;
          if (a(6, paramArrayOfObject))
          {
            uya.d("comment", 1, "handleResponseEvent add reply isInterceptEvent");
            return;
          }
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_Umb != null) {
            this.jdField_a_of_type_Umb.b(this.jdField_b_of_type_AndroidWidgetTextView);
          }
          if (localInteger.intValue() != 1000) {
            uya.d("comment", 1, "reply fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          localObject = ((stPostCommentReplyV2Rsp)paramArrayOfObject[3]).reply;
          paramArrayOfObject = (String)paramArrayOfObject[5];
          uya.d("comment", "fakeReplyId:" + paramArrayOfObject + ",reply toString :" + ((stSimpleMetaReply)localObject).toString());
          if (localInteger.intValue() == 1000) {
            if ((this.jdField_a_of_type_Ulq != null) && (this.jdField_a_of_type_Ulq.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject, (stSimpleMetaReply)localObject))) {
              n();
            }
          }
          for (;;)
          {
            a(localInteger.intValue(), amtj.a(2131701335), amtj.a(2131701346));
            return;
            if ((this.jdField_a_of_type_Ulq != null) && (this.jdField_a_of_type_Ulq.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject))) {
              n();
            }
          }
          if (a(5, paramArrayOfObject))
          {
            uya.d("comment", 1, "handleResponseEvent delete reply isInterceptEvent");
            return;
          }
          a(localInteger.intValue(), amtj.a(2131701341), amtj.a(2131701348));
        } while ((!(paramArrayOfObject[3] instanceof String)) || (!(paramArrayOfObject[4] instanceof stSimpleMetaReply)));
        localObject = (String)paramArrayOfObject[3];
        paramArrayOfObject = ((stSimpleMetaReply)paramArrayOfObject[4]).id;
      } while ((localInteger.intValue() != 1000) || (this.jdField_a_of_type_Ulq == null) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramArrayOfObject)));
      this.jdField_a_of_type_Ulq.a((String)localObject, paramArrayOfObject);
      n();
      return;
    }
    uya.d("comment", "onEvent: ACTION_GET_MORE_COMMENT！");
    m();
    if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(c())))
    {
      uya.d("comment", "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
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
        uya.c("comment", "---------------------------------------- if(!loadMore) mCommentListChanged = false, hashCode" + hashCode());
      }
    }
    for (;;)
    {
      if ((paramArrayOfObject[3] instanceof stGetFeedCommentListV2Rsp))
      {
        if (this.jdField_a_of_type_Ulq != null)
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
            this.jdField_a_of_type_Ulq.a();
          }
          this.jdField_a_of_type_Ulq.a(paramArrayOfObject);
          n();
          c(0);
        }
        label1065:
        break;
      }
      uya.d("comment", "获取评论response失败");
      return;
      bool = true;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Ull != null) && (this.jdField_a_of_type_Ull.isShowing());
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ull == null) {
      this.jdField_a_of_type_Ull = ull.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      this.jdField_a_of_type_Ull.b();
      this.jdField_a_of_type_Ull.showAtLocation(((Window)localObject).getDecorView(), 80, 0, 0);
    }
    this.jdField_a_of_type_Ull.setOnDismissListener(new umk(this));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      a(this.jdField_a_of_type_Ull.a());
    }
    if ((c() == null) && (this.jdField_c_of_type_Int <= 3))
    {
      this.jdField_c_of_type_Int += 1;
      a().a().postDelayed(new WsCommentPresenter.2(this), this.jdField_c_of_type_Int * 500);
    }
    String str;
    do
    {
      return;
      localObject = a();
      if (localObject == null)
      {
        uya.d("comment", "showCommentListWithAnim, but feed is null");
        return;
      }
      str = c();
    } while (str == null);
    this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      i = 0;
      uya.c("comment", "position:" + b() + ",feedId:" + ((stSimpleMetaFeed)localObject).id + ",cellId:" + str + ",loadedComments size:" + i + ",mCommentListChanged:" + this.jdField_a_of_type_Boolean + ",hashCode:" + hashCode());
      if (!this.jdField_a_of_type_Boolean) {
        break label328;
      }
      uya.c("comment", "11111111111111111111111111 mCommentListChanged");
      a().a((stSimpleMetaFeed)localObject, false);
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      d();
      return;
      i = this.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label328:
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        if (this.jdField_e_of_type_Boolean) {
          uya.c("comment", "444444444444444444444444 loadedComments == null and preloading is true");
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          break;
          uya.c("comment", "2222222222222222222222222 loadedComments == null and preloading is false");
          a().a((stSimpleMetaFeed)localObject, false);
        }
      }
      uya.c("comment", "333333333333333333333 读取评论" + this.jdField_a_of_type_JavaUtilArrayList.size() + "条");
      this.jdField_b_of_type_Boolean = false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umj
 * JD-Core Version:    0.7.0.1
 */