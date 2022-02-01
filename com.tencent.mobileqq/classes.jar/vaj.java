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

public class vaj
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
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = new val(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  public ListView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<stSimpleMetaComment> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, stSimpleMetaFeed> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<Long, stSimpleMetaPerson> jdField_a_of_type_JavaUtilMap = new HashMap();
  uzl jdField_a_of_type_Uzl;
  private uzq jdField_a_of_type_Uzq;
  private uzs jdField_a_of_type_Uzs;
  private vab jdField_a_of_type_Vab;
  private vap jdField_a_of_type_Vap;
  private vaq jdField_a_of_type_Vaq;
  private vnq jdField_a_of_type_Vnq;
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
  
  public vaj(Fragment paramFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
    this.jdField_a_of_type_AndroidAppActivity = paramFragment.getActivity();
    this.jdField_a_of_type_AndroidContentContext = paramFragment.getActivity().getApplicationContext();
    this.jdField_a_of_type_Uzs = new uzs(this);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Vap == null)
    {
      this.jdField_a_of_type_Vap = new vap(this, this.jdField_a_of_type_Int);
      wad.a().registerSubscriber(this.jdField_a_of_type_Vap);
      vmp.d("comment", "注册一次评论监听器 , currentPage:" + paramInt);
      return;
    }
    vmp.d("comment", "复用评论监听器 , currentPage:" + paramInt);
  }
  
  private int a()
  {
    if (vjz.a(a())) {
      return this.jdField_e_of_type_Int;
    }
    return vbc.a().a.get(this.jdField_e_of_type_Int) + 1;
  }
  
  private stSimpleMetaFeed a()
  {
    int i = b();
    return (stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
  }
  
  private stSimpleMetaPerson a()
  {
    if (zqh.a() != null)
    {
      localObject1 = zqh.a();
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
    localWSDownloadParams.mLinkStrategyType = vau.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = vnd.a(1);
    localWSDownloadParams.mStReportItem = vjx.a();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    vjz.a(a(), b(), d(), paramInt1, paramInt2, a());
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694264), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramString2, 0).a();
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply)
  {
    if ((paramstSimpleMetaReply != null) && (paramstSimpleMetaReply.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692184), new Object[] { paramstSimpleMetaReply.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaComment = paramstSimpleMetaComment + "...";
      }
      this.jdField_a_of_type_Vab.a(paramstSimpleMetaComment);
      return;
    }
    if ((paramstSimpleMetaComment != null) && (paramstSimpleMetaComment.poster != null))
    {
      paramstSimpleMetaReply = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131692184), new Object[] { paramstSimpleMetaComment.poster.nick });
      paramstSimpleMetaComment = paramstSimpleMetaReply;
      if (paramstSimpleMetaReply.length() > 10)
      {
        paramstSimpleMetaComment = paramstSimpleMetaReply.substring(0, 10);
        paramstSimpleMetaComment = paramstSimpleMetaComment + "...";
      }
      this.jdField_a_of_type_Vab.a(paramstSimpleMetaComment);
      return;
    }
    paramstSimpleMetaComment = vau.a().f();
    this.jdField_a_of_type_Vab.a(paramstSimpleMetaComment);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt)
  {
    a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramInt, false);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      vmp.d("comment", 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Vab == null) {
      this.jdField_a_of_type_Vab = new vab(this.jdField_a_of_type_AndroidAppActivity);
    }
    a(paramstSimpleMetaComment, paramstSimpleMetaReply);
    this.jdField_a_of_type_Vab.a(new van(this, paramstSimpleMetaComment, paramBoolean, paramstSimpleMetaReply));
    b(paramBoolean);
    this.jdField_a_of_type_Vab.a(paramInt);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool = true;
    vmp.b("comment", 1, "onCommentSend()");
    if (this.jdField_a_of_type_Vab == null)
    {
      vmp.b("comment", 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    String str = this.jdField_a_of_type_Vab.a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131692185), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131694264), 0).a();
      return;
    }
    if (a() == null)
    {
      vmp.d("comment", 1, "feed is null");
      return;
    }
    if (paramstSimpleMetaComment == null)
    {
      vjz.a(a(), b(), a(), a(), paramBoolean, bool);
      if (!bool) {
        break label183;
      }
      a(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vab.b("");
      this.jdField_a_of_type_Vab.dismiss();
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
    vmp.c("comment", "2 mCommentListChanged:" + this.jdField_a_of_type_Boolean + ", hashCode" + hashCode());
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof WSFollowFragment)) {
      ((WSFollowFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a(b(), a());
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_UserGrowthStSimpleMetaComment = null;
    if (this.jdField_a_of_type_Uzq != null)
    {
      this.jdField_a_of_type_Uzq.a(0, localstSimpleMetaComment);
      this.jdField_a_of_type_Uzq.notifyDataSetChanged();
    }
    vmp.d("comment", "onCommentSend, lastPosition:" + this.jdField_d_of_type_Int + ",currentPosition:" + b());
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
      vmp.d("comment", "回复请求前,发送者:" + localstSimpleMetaReply.poster.nick + ",接受者:" + localstSimpleMetaReply.receiver.nick);
      this.jdField_b_of_type_Long = a().a(a(), paramstSimpleMetaComment, localstSimpleMetaReply);
      this.jdField_a_of_type_Boolean = true;
      vmp.d("comment", "1 mCommentListChanged:" + this.jdField_a_of_type_Boolean + ", hashCode" + hashCode());
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(this.jdField_b_of_type_Long), this.jdField_a_of_type_UserGrowthStSimpleMetaReply);
      }
      this.jdField_a_of_type_UserGrowthStSimpleMetaReply = null;
      if (this.jdField_a_of_type_Uzq != null)
      {
        this.jdField_a_of_type_Uzq.a(paramstSimpleMetaComment.id, localstSimpleMetaReply);
        this.jdField_a_of_type_Uzq.notifyDataSetChanged();
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131693531);
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
      vmp.b("comment", 1, "setCommentContainerVisible() mCommentContainer == null.");
    }
    while (paramInt != 0) {
      return;
    }
    this.jdField_a_of_type_Uzq.a(a().poster.id);
    this.jdField_a_of_type_Uzq.a(a());
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vab == null)
    {
      vmp.d("comment", "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Vab.a(new vao(this, paramBoolean));
  }
  
  private String c()
  {
    if (a() == null)
    {
      vmp.d("comment", 2, "getFeedId is null");
      return "";
    }
    return a().id;
  }
  
  private void c()
  {
    if (c() != null)
    {
      if (this.jdField_e_of_type_Boolean) {
        vmp.d("comment", "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
      }
    }
    else {
      return;
    }
    if (!TextUtils.isEmpty(a().a(c())))
    {
      vmp.d("comment", "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    vmp.d("comment", "请求开始 preLoading = true");
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
    wad.a().dispatch(new vbv(5, new Object[] { c(), Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  private boolean c()
  {
    return true;
  }
  
  @NotNull
  private String d()
  {
    if (vjz.a(a())) {
      return vjz.b(a());
    }
    return vjz.b(a()) + a();
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
            this.jdField_c_of_type_AndroidWidgetTextView.setText(zwa.a(this.jdField_a_of_type_Long));
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
    //   3: getfield 100	vaj:jdField_a_of_type_Uzs	Luzs;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 122
    //   11: ldc_w 699
    //   14: invokestatic 143	vmp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual 490	vaj:a	()Luzs;
    //   25: aload_0
    //   26: invokespecial 311	vaj:c	()Ljava/lang/String;
    //   29: invokevirtual 702	uzs:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 315	vaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   35: aload_0
    //   36: aload_0
    //   37: invokevirtual 490	vaj:a	()Luzs;
    //   40: aload_0
    //   41: invokespecial 311	vaj:c	()Ljava/lang/String;
    //   44: invokevirtual 638	uzs:a	(Ljava/lang/String;)Ljava/lang/String;
    //   47: putfield 60	vaj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 315	vaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   54: ifnull -37 -> 17
    //   57: aload_0
    //   58: getfield 318	vaj:jdField_a_of_type_Uzq	Luzq;
    //   61: ifnull +29 -> 90
    //   64: aload_0
    //   65: getfield 318	vaj:jdField_a_of_type_Uzq	Luzq;
    //   68: invokevirtual 704	uzq:a	()V
    //   71: aload_0
    //   72: getfield 318	vaj:jdField_a_of_type_Uzq	Luzq;
    //   75: aload_0
    //   76: getfield 315	vaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   79: invokevirtual 707	uzq:a	(Ljava/util/Collection;)Z
    //   82: pop
    //   83: aload_0
    //   84: getfield 318	vaj:jdField_a_of_type_Uzq	Luzq;
    //   87: invokevirtual 522	uzq:notifyDataSetChanged	()V
    //   90: ldc 122
    //   92: new 124	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 709
    //   102: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 66	vaj:jdField_d_of_type_Int	I
    //   109: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 526
    //   115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokespecial 185	vaj:b	()I
    //   122: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 143	vmp:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: getfield 528	vaj:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   135: ifnull +38 -> 173
    //   138: aload_0
    //   139: getfield 66	vaj:jdField_d_of_type_Int	I
    //   142: aload_0
    //   143: invokespecial 185	vaj:b	()I
    //   146: if_icmpeq +27 -> 173
    //   149: aload_0
    //   150: aload_0
    //   151: invokespecial 185	vaj:b	()I
    //   154: putfield 66	vaj:jdField_d_of_type_Int	I
    //   157: aload_0
    //   158: getfield 528	vaj:jdField_a_of_type_AndroidWidgetListView	Landroid/widget/ListView;
    //   161: new 711	com/tencent/biz/pubaccount/weishi_new/comment/WsCommentPresenter$3
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 712	com/tencent/biz/pubaccount/weishi_new/comment/WsCommentPresenter$3:<init>	(Lvaj;)V
    //   169: invokevirtual 716	android/widget/ListView:post	(Ljava/lang/Runnable;)Z
    //   172: pop
    //   173: aload_0
    //   174: getfield 315	vaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   177: ifnull -160 -> 17
    //   180: aload_0
    //   181: getfield 315	vaj:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   184: invokevirtual 679	java/util/ArrayList:size	()I
    //   187: ifle -170 -> 17
    //   190: aload_0
    //   191: aload_0
    //   192: invokevirtual 490	vaj:a	()Luzs;
    //   195: aload_0
    //   196: invokespecial 311	vaj:c	()Ljava/lang/String;
    //   199: invokevirtual 648	uzs:a	(Ljava/lang/String;)I
    //   202: i2l
    //   203: putfield 179	vaj:jdField_a_of_type_Long	J
    //   206: goto -189 -> 17
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	vaj
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
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366524));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364952));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363930));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363912));
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131364932);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371598));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378740));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363899);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Vaq = new vaq(this);
    if (this.jdField_a_of_type_Uzq == null)
    {
      vmp.a("comment", "create mCommentAdapter ...");
      this.jdField_a_of_type_Uzq = new uzq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vaq);
      this.jdField_a_of_type_Uzq.a(a());
      this.jdField_a_of_type_Uzq.a(a(), b());
    }
    for (;;)
    {
      this.jdField_a_of_type_Uzq.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Uzq.a(a());
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Uzq);
      vam localvam = new vam(this);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(localvam);
      }
      g();
      return;
      vmp.a("comment", "复用 mCommentAdapter ...");
    }
  }
  
  private void g()
  {
    String str = vau.a().f();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setHint(str);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Uzl != null) && (this.jdField_a_of_type_Uzl.isShowing())) {
      this.jdField_a_of_type_Uzl.dismiss();
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_Uzq.b();
      this.jdField_a_of_type_Uzq.a();
      this.jdField_a_of_type_Uzq.notifyDataSetChanged();
      a(false);
      i();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Vnq != null) {
      this.jdField_a_of_type_Vnq.c(1);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Vnq != null) {
      this.jdField_a_of_type_Vnq.b(1);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {}
    b(0);
    b();
    if ((this.jdField_a_of_type_Vab != null) && (this.jdField_b_of_type_AndroidWidgetTextView != null)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vab.a());
    }
  }
  
  private void l()
  {
    String str2 = vjz.b(this.jdField_c_of_type_JavaLangString);
    String str1 = str2;
    if (!str2.equals("comment_page")) {
      str1 = str2 + a();
    }
    vjz.a(this.jdField_c_of_type_JavaLangString, b(), str1, a());
  }
  
  private void m()
  {
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      vmp.d("comment", "请求结束 preLoading = false");
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
  
  public uzs a()
  {
    if (this.jdField_a_of_type_Uzs == null) {
      this.jdField_a_of_type_Uzs = new uzs(this);
    }
    return this.jdField_a_of_type_Uzs;
  }
  
  public void a()
  {
    vmp.c("comment", "comment onRecycle");
    if (this.jdField_a_of_type_Vap != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Vap);
    }
    a().a();
    this.jdField_a_of_type_Uzs = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != this.jdField_e_of_type_Int) && (this.jdField_a_of_type_Uzq != null))
    {
      this.jdField_a_of_type_Uzq.b.clear();
      this.jdField_a_of_type_Uzq.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    this.jdField_e_of_type_Int = paramInt;
    uzq.jdField_a_of_type_Int = a();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    vjz.a(a(), paramString, "comment_page_explicit", 1000001, paramInt2, a());
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
      localstSimpleMetaFeed.simpleComments.add(0, uzo.a(paramstSimpleMetaComment, a()));
    }
    for (;;)
    {
      paramstSimpleMetaComment = "";
      if (a() != null) {
        paramstSimpleMetaComment = a().id;
      }
      paramstSimpleMetaComment = new WSAddCommentEvent(paramstSimpleMetaComment, b(), i);
      vbw.a().a(paramstSimpleMetaComment);
      return;
      i = 0;
    }
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.poster.id;
      if (this.jdField_a_of_type_Uzq != null) {
        this.jdField_a_of_type_Uzq.a(paramstSimpleMetaFeed);
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
    if (this.jdField_a_of_type_Uzq != null) {
      this.jdField_a_of_type_Uzq.a(paramString1, paramString2);
    }
  }
  
  public void a(vnq paramvnq)
  {
    this.jdField_a_of_type_Vnq = paramvnq;
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    Integer localInteger = (Integer)paramArrayOfObject[1];
    Object localObject;
    if (paramArrayOfObject[2] == null)
    {
      localObject = "";
      vmp.c("comment", "handleResponseEvent, action: " + paramArrayOfObject[0] + ",resultCode:" + localInteger + ",msg:" + (String)localObject);
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
          if (this.jdField_a_of_type_Vab != null) {
            this.jdField_a_of_type_Vab.b(this.jdField_b_of_type_AndroidWidgetTextView);
          }
          if (a(5, paramArrayOfObject))
          {
            vmp.d("comment", 1, "handleResponseEvent add comment isInterceptEvent");
            return;
          }
          if (localInteger.intValue() != 1000) {
            vmp.d("comment", 1, "comment fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramArrayOfObject[3];
          if (localInteger.intValue() == 1000)
          {
            if ((this.jdField_a_of_type_Uzq != null) && (this.jdField_a_of_type_Uzq.a(String.valueOf(paramArrayOfObject[4]), localstPostFeedCommentV2Rsp.comment))) {
              n();
            }
            this.jdField_a_of_type_Boolean = true;
            c(1);
          }
          for (;;)
          {
            vmp.d("comment", 1, "ACTION_ADD_FEED_COMMENT, result =" + localInteger + " msg=" + (String)localObject);
            a(localInteger.intValue(), anvx.a(2131701693), (String)localObject);
            return;
            if ((this.jdField_a_of_type_Uzq != null) && (this.jdField_a_of_type_Uzq.a(String.valueOf(paramArrayOfObject[4])))) {
              n();
            }
          }
          if (a(4, paramArrayOfObject))
          {
            vmp.d("comment", 1, "handleResponseEvent delete isInterceptEvent");
            return;
          }
          if ((localInteger.intValue() == 1000) && ((paramArrayOfObject[3] instanceof stDeleteFeedCommentRsp)))
          {
            paramArrayOfObject = (String)paramArrayOfObject[4];
            if ((this.jdField_a_of_type_Uzq != null) && (this.jdField_a_of_type_Uzq.a(paramArrayOfObject))) {
              n();
            }
            c(-1);
          }
          a(localInteger.intValue(), anvx.a(2131701687), anvx.a(2131701696));
          return;
          if (a(6, paramArrayOfObject))
          {
            vmp.d("comment", 1, "handleResponseEvent add reply isInterceptEvent");
            return;
          }
          this.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_Vab != null) {
            this.jdField_a_of_type_Vab.b(this.jdField_b_of_type_AndroidWidgetTextView);
          }
          if (localInteger.intValue() != 1000) {
            vmp.d("comment", 1, "reply fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          localObject = ((stPostCommentReplyV2Rsp)paramArrayOfObject[3]).reply;
          paramArrayOfObject = (String)paramArrayOfObject[5];
          vmp.d("comment", "fakeReplyId:" + paramArrayOfObject + ",reply toString :" + ((stSimpleMetaReply)localObject).toString());
          if (localInteger.intValue() == 1000) {
            if ((this.jdField_a_of_type_Uzq != null) && (this.jdField_a_of_type_Uzq.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject, (stSimpleMetaReply)localObject))) {
              n();
            }
          }
          for (;;)
          {
            a(localInteger.intValue(), anvx.a(2131701686), anvx.a(2131701697));
            return;
            if ((this.jdField_a_of_type_Uzq != null) && (this.jdField_a_of_type_Uzq.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject))) {
              n();
            }
          }
          if (a(5, paramArrayOfObject))
          {
            vmp.d("comment", 1, "handleResponseEvent delete reply isInterceptEvent");
            return;
          }
          a(localInteger.intValue(), anvx.a(2131701692), anvx.a(2131701699));
        } while ((!(paramArrayOfObject[3] instanceof String)) || (!(paramArrayOfObject[4] instanceof stSimpleMetaReply)));
        localObject = (String)paramArrayOfObject[3];
        paramArrayOfObject = ((stSimpleMetaReply)paramArrayOfObject[4]).id;
      } while ((localInteger.intValue() != 1000) || (this.jdField_a_of_type_Uzq == null) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramArrayOfObject)));
      this.jdField_a_of_type_Uzq.a((String)localObject, paramArrayOfObject);
      n();
      return;
    }
    vmp.d("comment", "onEvent: ACTION_GET_MORE_COMMENT！");
    m();
    if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(c())))
    {
      vmp.d("comment", "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
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
        vmp.c("comment", "---------------------------------------- if(!loadMore) mCommentListChanged = false, hashCode" + hashCode());
      }
    }
    for (;;)
    {
      if ((paramArrayOfObject[3] instanceof stGetFeedCommentListV2Rsp))
      {
        if (this.jdField_a_of_type_Uzq != null)
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
            this.jdField_a_of_type_Uzq.a();
          }
          this.jdField_a_of_type_Uzq.a(paramArrayOfObject);
          n();
          c(0);
        }
        label1065:
        break;
      }
      vmp.d("comment", "获取评论response失败");
      return;
      bool = true;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Uzl != null) && (this.jdField_a_of_type_Uzl.isShowing());
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Uzl == null) {
      this.jdField_a_of_type_Uzl = uzl.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      this.jdField_a_of_type_Uzl.b();
      this.jdField_a_of_type_Uzl.showAtLocation(((Window)localObject).getDecorView(), 80, 0, 0);
    }
    this.jdField_a_of_type_Uzl.setOnDismissListener(new vak(this));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      a(this.jdField_a_of_type_Uzl.a());
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
        vmp.d("comment", "showCommentListWithAnim, but feed is null");
        return;
      }
      str = c();
    } while (str == null);
    this.jdField_a_of_type_JavaUtilArrayList = a().a(str);
    int i;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      i = 0;
      vmp.c("comment", "position:" + b() + ",feedId:" + ((stSimpleMetaFeed)localObject).id + ",cellId:" + str + ",loadedComments size:" + i + ",mCommentListChanged:" + this.jdField_a_of_type_Boolean + ",hashCode:" + hashCode());
      if (!this.jdField_a_of_type_Boolean) {
        break label328;
      }
      vmp.c("comment", "11111111111111111111111111 mCommentListChanged");
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
          vmp.c("comment", "444444444444444444444444 loadedComments == null and preloading is true");
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = true;
          break;
          vmp.c("comment", "2222222222222222222222222 loadedComments == null and preloading is false");
          a().a((stSimpleMetaFeed)localObject, false);
        }
      }
      vmp.c("comment", "333333333333333333333 读取评论" + this.jdField_a_of_type_JavaUtilArrayList.size() + "条");
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
 * Qualified Name:     vaj
 * JD-Core Version:    0.7.0.1
 */