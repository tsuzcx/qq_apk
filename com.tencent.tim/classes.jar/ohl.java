import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_KING_INTERFACE.stDeleteFeedCommentRsp;
import NS_KING_INTERFACE.stGetFeedCommentListV2Rsp;
import UserGrowth.stPostCommentReplyV2Rsp;
import UserGrowth.stPostFeedCommentV2Rsp;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stSimpleMetaReply;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.1;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.6;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.7;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.8;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class ohl
  implements View.OnClickListener, Animation.AnimationListener, IEventReceiver
{
  private int AS = -1;
  public int Ib;
  private String TAG = "comment";
  private ImageButton U;
  private String Ur = "";
  private ImageButton V;
  private ohe jdField_a_of_type_Ohe;
  private ohl.a jdField_a_of_type_Ohl$a;
  private ohl.b jdField_a_of_type_Ohl$b;
  private opv jdField_a_of_type_Opv;
  private sbx jdField_a_of_type_Sbx;
  private Animation ab;
  private String aqa = "";
  private String aqb;
  private String aqc = "";
  private boolean axe;
  public boolean axf;
  private boolean axg;
  private boolean axh;
  private boolean axi;
  private boolean axj;
  private boolean axk;
  private boolean axl;
  private stSimpleMetaComment jdField_b_of_type_UserGrowthStSimpleMetaComment;
  private stSimpleMetaReply jdField_b_of_type_UserGrowthStSimpleMetaReply;
  private Fragment jdField_b_of_type_AndroidSupportV4AppFragment;
  private AbsListView.OnScrollListener jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener = new ohm(this);
  private ogt jdField_b_of_type_Ogt;
  private ogv jdField_b_of_type_Ogv;
  private int beX = 140;
  private long commentNum;
  private int currentPosition;
  private HashMap<Integer, stSimpleMetaFeed> eK = new HashMap();
  private Map<Long, stSimpleMetaPerson> fk = new HashMap();
  private Map<Long, stSimpleMetaReply> fl = new HashMap();
  public ListView l;
  private Activity mActivity;
  View mCommentContainer;
  private TextView mCommentCount;
  private Context mContext;
  private int mLayoutId = -1;
  protected View mParentView;
  private ArrayList<stSimpleMetaComment> md;
  private View ns;
  private View nt;
  private View nu;
  private int retryTimes;
  private ViewStub t;
  private TextView uj;
  private long yN;
  private long yO;
  
  public ohl(Fragment paramFragment, int paramInt)
  {
    this.jdField_b_of_type_AndroidSupportV4AppFragment = paramFragment;
    this.mActivity = paramFragment.getActivity();
    this.mContext = paramFragment.getActivity().getApplicationContext();
    this.jdField_b_of_type_Ogv = new ogv(this);
    this.Ib = paramInt;
    if (this.jdField_a_of_type_Ohl$a == null)
    {
      this.jdField_a_of_type_Ohl$a = new ohl.a(this, this.Ib);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Ohl$a);
      ooz.e(this.TAG, "注册一次评论监听器 , currentPage:" + paramInt);
      return;
    }
    ooz.e(this.TAG, "复用评论监听器 , currentPage:" + paramInt);
  }
  
  private boolean GL()
  {
    return true;
  }
  
  private void Je()
  {
    this.l = ((ListView)this.mParentView.findViewById(2131366801));
    this.mCommentContainer = this.mParentView;
    this.nu = this.mParentView.findViewById(2131365036);
    Object localObject = (RelativeLayout)this.mParentView.findViewById(2131366802);
    this.mCommentCount = ((TextView)this.mParentView.findViewById(2131365029));
    this.U = ((ImageButton)this.mParentView.findViewById(2131363888));
    this.U.setOnClickListener(this);
    this.V = ((ImageButton)this.mParentView.findViewById(2131363869));
    this.V.setOnClickListener(this);
    this.ns = this.mParentView.findViewById(2131365009);
    this.uj = ((TextView)this.mParentView.findViewById(2131379487));
    this.uj.setOnClickListener(this);
    this.nt = this.mParentView.findViewById(2131363856);
    this.nt.setOnClickListener(this);
    this.l.setOnScrollListener(this.jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_Ohl$b = new ohl.b();
    if (this.jdField_b_of_type_Ogt == null)
    {
      ooz.i("comment", "create mCommentAdapter ...");
      this.jdField_b_of_type_Ogt = new ogt(this.mContext, this.jdField_a_of_type_Ohl$b);
      this.jdField_b_of_type_Ogt.bW(getSopName(), getPlayScene());
    }
    for (;;)
    {
      this.jdField_b_of_type_Ogt.px(this.aqa);
      this.jdField_b_of_type_Ogt.b(a());
      this.l.setAdapter(this.jdField_b_of_type_Ogt);
      this.l.setEmptyView(this.ns);
      localObject = new ohn(this);
      if (this.mCommentContainer != null) {
        this.mCommentContainer.setOnClickListener((View.OnClickListener)localObject);
      }
      beH();
      return;
      ooz.i("comment", "复用 mCommentAdapter ...");
    }
  }
  
  private stSimpleMetaFeed a()
  {
    int i = getPosition();
    return (stSimpleMetaFeed)this.eK.get(Integer.valueOf(i));
  }
  
  private stSimpleMetaPerson a()
  {
    if (ryz.a() != null)
    {
      localObject1 = ryz.a();
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
    for (((stSimpleMetaPerson)localObject1).nick = aqgv.n((QQAppInterface)localObject2, ((stSimpleMetaPerson)localObject1).id);; ((stSimpleMetaPerson)localObject1).nick = "")
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
    localWSDownloadParams.mLinkStrategyType = ohy.a().rp();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = opn.getSceneTypeTestId(1);
    localWSDownloadParams.mStReportItem = ond.getInitialReportItem();
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt)
  {
    a(paramstSimpleMetaComment, paramstSimpleMetaReply, paramInt, false);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, int paramInt, boolean paramBoolean)
  {
    if ((this.mContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      ooz.e(this.TAG, 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Ohe == null) {
      this.jdField_a_of_type_Ohe = new ohe(this.mActivity);
    }
    this.jdField_a_of_type_Ohe.a(new oho(this, paramstSimpleMetaComment, paramBoolean, paramstSimpleMetaReply));
    qG(paramBoolean);
    this.jdField_a_of_type_Ohe.show(paramInt);
  }
  
  private void a(stSimpleMetaComment paramstSimpleMetaComment, boolean paramBoolean, stSimpleMetaReply paramstSimpleMetaReply)
  {
    boolean bool = true;
    ooz.d(this.TAG, 1, "onCommentSend()");
    if (this.jdField_a_of_type_Ohe == null) {
      ooz.d(this.TAG, 1, "onCommentSend(): mCommentInputPopupWindow null");
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Ohe.getText();
    } while (TextUtils.isEmpty(str.trim()));
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, 1, this.mContext.getString(2131696284), 0).show();
      return;
    }
    if (a() == null)
    {
      ooz.e(this.TAG, 1, "feed is null");
      return;
    }
    if (paramstSimpleMetaComment == null)
    {
      WSPublicAccReport.getInstance().reportCommentSendClick(getSopName(), getPlayScene(), this.currentPosition, a(), paramBoolean, bool);
      if (!bool) {
        break label169;
      }
      py(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ohe.setText("");
      this.jdField_a_of_type_Ohe.dismiss();
      return;
      bool = false;
      break;
      label169:
      a(str, paramstSimpleMetaReply, paramstSimpleMetaComment);
    }
  }
  
  private void a(String paramString, stSimpleMetaReply paramstSimpleMetaReply, stSimpleMetaComment paramstSimpleMetaComment)
  {
    if (this.jdField_b_of_type_UserGrowthStSimpleMetaReply == null) {
      this.jdField_b_of_type_UserGrowthStSimpleMetaReply = new stSimpleMetaReply();
    }
    this.jdField_b_of_type_UserGrowthStSimpleMetaReply.wording = paramString;
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
      if (this.jdField_b_of_type_UserGrowthStSimpleMetaReply.receiver != null) {
        this.fk.put(Long.valueOf(this.yN), this.jdField_b_of_type_UserGrowthStSimpleMetaReply.receiver);
      }
      ooz.e("comment", "回复请求前,发送者:" + localstSimpleMetaReply.poster.nick + ",接受者:" + localstSimpleMetaReply.receiver.nick);
      this.yN = a().a(a(), paramstSimpleMetaComment, localstSimpleMetaReply);
      this.axf = true;
      ooz.e("comment", "1 mCommentListChanged:" + this.axf + ", hashCode" + hashCode());
      this.axj = true;
      if (this.fl != null) {
        this.fl.put(Long.valueOf(this.yN), this.jdField_b_of_type_UserGrowthStSimpleMetaReply);
      }
      this.jdField_b_of_type_UserGrowthStSimpleMetaReply = null;
      if (this.jdField_b_of_type_Ogt != null)
      {
        this.jdField_b_of_type_Ogt.a(paramstSimpleMetaComment.id, localstSimpleMetaReply);
        this.jdField_b_of_type_Ogt.notifyDataSetChanged();
      }
      return;
      localstSimpleMetaReply.receiver = paramstSimpleMetaComment.poster;
    }
  }
  
  private boolean a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if ((paramstSimpleMetaPerson != null) && (ryz.a() != null) && (paramstSimpleMetaPerson.id.equals(ryz.a().id.get()))) {}
    while ((paramstSimpleMetaPerson != null) && (paramstSimpleMetaPerson.id.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))) {
      return true;
    }
    return false;
  }
  
  /* Error */
  private void awT()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokespecial 664	ohl:beN	()V
    //   8: aload_0
    //   9: getfield 442	ohl:md	Ljava/util/ArrayList;
    //   12: ifnull +93 -> 105
    //   15: aload_0
    //   16: getfield 442	ohl:md	Ljava/util/ArrayList;
    //   19: invokevirtual 669	java/util/ArrayList:size	()I
    //   22: ifle +83 -> 105
    //   25: aload_0
    //   26: getfield 220	ohl:mCommentCount	Landroid/widget/TextView;
    //   29: ifnull +25 -> 54
    //   32: aload_0
    //   33: getfield 220	ohl:mCommentCount	Landroid/widget/TextView;
    //   36: aload_0
    //   37: getfield 671	ohl:commentNum	J
    //   40: invokestatic 677	sds:aO	(J)Ljava/lang/String;
    //   43: invokevirtual 680	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   46: aload_0
    //   47: getfield 220	ohl:mCommentCount	Landroid/widget/TextView;
    //   50: iconst_0
    //   51: invokevirtual 683	android/widget/TextView:setVisibility	(I)V
    //   54: aload_0
    //   55: getfield 209	ohl:mCommentContainer	Landroid/view/View;
    //   58: ifnull +19 -> 77
    //   61: aload_0
    //   62: getfield 209	ohl:mCommentContainer	Landroid/view/View;
    //   65: iconst_0
    //   66: invokevirtual 684	android/view/View:setVisibility	(I)V
    //   69: aload_0
    //   70: getfield 212	ohl:nu	Landroid/view/View;
    //   73: iconst_0
    //   74: invokevirtual 684	android/view/View:setVisibility	(I)V
    //   77: aload_0
    //   78: getfield 252	ohl:jdField_b_of_type_Ogt	Logt;
    //   81: invokevirtual 687	ogt:getCount	()I
    //   84: ifne +5 -> 89
    //   87: iconst_1
    //   88: istore_1
    //   89: aload_0
    //   90: iload_1
    //   91: invokespecial 690	ohl:qF	(Z)V
    //   94: aload_0
    //   95: invokespecial 693	ohl:bbm	()V
    //   98: aload_0
    //   99: invokespecial 696	ohl:beR	()V
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: aload_0
    //   106: getfield 220	ohl:mCommentCount	Landroid/widget/TextView;
    //   109: ifnull -55 -> 54
    //   112: aload_0
    //   113: getfield 220	ohl:mCommentCount	Landroid/widget/TextView;
    //   116: ldc 102
    //   118: invokevirtual 680	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   121: aload_0
    //   122: getfield 220	ohl:mCommentCount	Landroid/widget/TextView;
    //   125: bipush 8
    //   127: invokevirtual 683	android/widget/TextView:setVisibility	(I)V
    //   130: goto -76 -> 54
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	ohl
    //   1	90	1	bool	boolean
    //   133	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	54	133	finally
    //   54	77	133	finally
    //   77	87	133	finally
    //   89	102	133	finally
    //   105	130	133	finally
  }
  
  private boolean b(int paramInt, Object[] paramArrayOfObject)
  {
    return false;
  }
  
  private void bbm()
  {
    if (this.jdField_a_of_type_Opv != null) {
      this.jdField_a_of_type_Opv.uR(1);
    }
  }
  
  private void beH()
  {
    String str = ohy.a().lt();
    if (!TextUtils.isEmpty(str)) {
      this.uj.setHint(str);
    }
  }
  
  private void beL()
  {
    if (getFeedId() != null)
    {
      if (this.axl) {
        ooz.e(this.TAG, "已经有预加载进行中，拦截---------------------------------------------------------------------》》》》》》》》");
      }
    }
    else {
      return;
    }
    if (!TextUtils.isEmpty(a().getAttachInfo(getFeedId())))
    {
      ooz.e(this.TAG, "已经看过的视频，attachInfo不为空，选择拦截---------------------------------------------------------------------");
      return;
    }
    this.axl = true;
    ooz.e(this.TAG, "请求开始 preLoading = true");
    a().a(a(), false);
  }
  
  /* Error */
  private void beN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	ohl:jdField_b_of_type_Ogv	Logv;
    //   6: ifnonnull +16 -> 22
    //   9: aload_0
    //   10: getfield 95	ohl:TAG	Ljava/lang/String;
    //   13: ldc_w 736
    //   16: invokestatic 188	ooz:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokevirtual 606	ohl:a	()Logv;
    //   27: aload_0
    //   28: invokespecial 699	ohl:getFeedId	()Ljava/lang/String;
    //   31: invokevirtual 739	ogv:t	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   34: putfield 442	ohl:md	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_0
    //   39: invokevirtual 606	ohl:a	()Logv;
    //   42: aload_0
    //   43: invokespecial 699	ohl:getFeedId	()Ljava/lang/String;
    //   46: invokevirtual 727	ogv:getAttachInfo	(Ljava/lang/String;)Ljava/lang/String;
    //   49: putfield 108	ohl:aqc	Ljava/lang/String;
    //   52: aload_0
    //   53: getfield 442	ohl:md	Ljava/util/ArrayList;
    //   56: ifnull -37 -> 19
    //   59: aload_0
    //   60: getfield 252	ohl:jdField_b_of_type_Ogt	Logt;
    //   63: ifnull +29 -> 92
    //   66: aload_0
    //   67: getfield 252	ohl:jdField_b_of_type_Ogt	Logt;
    //   70: invokevirtual 742	ogt:beD	()V
    //   73: aload_0
    //   74: getfield 252	ohl:jdField_b_of_type_Ogt	Logt;
    //   77: aload_0
    //   78: getfield 442	ohl:md	Ljava/util/ArrayList;
    //   81: invokevirtual 746	ogt:c	(Ljava/util/Collection;)Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 252	ohl:jdField_b_of_type_Ogt	Logt;
    //   89: invokevirtual 632	ogt:notifyDataSetChanged	()V
    //   92: aload_0
    //   93: getfield 95	ohl:TAG	Ljava/lang/String;
    //   96: new 168	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 748
    //   106: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_0
    //   110: getfield 114	ohl:AS	I
    //   113: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 750
    //   119: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: invokespecial 313	ohl:getPosition	()I
    //   126: invokevirtual 178	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 188	ooz:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 207	ohl:l	Landroid/widget/ListView;
    //   139: ifnull +30 -> 169
    //   142: aload_0
    //   143: getfield 114	ohl:AS	I
    //   146: aload_0
    //   147: invokespecial 313	ohl:getPosition	()I
    //   150: if_icmpeq +19 -> 169
    //   153: aload_0
    //   154: aload_0
    //   155: invokespecial 313	ohl:getPosition	()I
    //   158: putfield 114	ohl:AS	I
    //   161: aload_0
    //   162: getfield 207	ohl:l	Landroid/widget/ListView;
    //   165: iconst_0
    //   166: invokevirtual 753	android/widget/ListView:setSelection	(I)V
    //   169: aload_0
    //   170: getfield 442	ohl:md	Ljava/util/ArrayList;
    //   173: ifnull -154 -> 19
    //   176: aload_0
    //   177: getfield 442	ohl:md	Ljava/util/ArrayList;
    //   180: invokevirtual 669	java/util/ArrayList:size	()I
    //   183: ifle -164 -> 19
    //   186: aload_0
    //   187: aload_0
    //   188: invokevirtual 606	ohl:a	()Logv;
    //   191: aload_0
    //   192: invokespecial 699	ohl:getFeedId	()Ljava/lang/String;
    //   195: invokevirtual 757	ogv:aU	(Ljava/lang/String;)I
    //   198: i2l
    //   199: putfield 671	ohl:commentNum	J
    //   202: goto -183 -> 19
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	ohl
    //   205	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	205	finally
    //   22	92	205	finally
    //   92	169	205	finally
    //   169	202	205	finally
  }
  
  private void beO()
  {
    if ((this.mCommentContainer != null) && (!this.axg))
    {
      this.nu.setVisibility(8);
      this.ab = AnimationUtils.loadAnimation(this.mContext, 2130772055);
      this.ab.setAnimationListener(this);
      this.mCommentContainer.startAnimation(this.ab);
      this.axg = true;
      this.jdField_b_of_type_Ogt.beE();
      beP();
    }
    this.axe = false;
  }
  
  private void beP()
  {
    if (this.jdField_a_of_type_Opv != null) {
      this.jdField_a_of_type_Opv.uS(1);
    }
  }
  
  private void beQ()
  {
    if (this.mCommentContainer.getVisibility() != 0) {}
    for (int i = 1;; i = 0)
    {
      uF(0);
      if (i != 0) {
        beM();
      }
      if ((this.jdField_a_of_type_Ohe != null) && (this.uj != null)) {
        this.uj.setText(this.jdField_a_of_type_Ohe.getText());
      }
      return;
    }
  }
  
  private void beR()
  {
    String str2 = WSPublicAccReport.getPagePositionId(this.Ur);
    String str1 = str2;
    if (!str2.equals("comment_page")) {
      str1 = str2 + getPosition();
    }
    WSPublicAccReport.getInstance().reportCommentPageExposure(this.Ur, getPlayScene(), str1, a());
  }
  
  private void beS()
  {
    if (this.axl)
    {
      this.axl = false;
      ooz.e(this.TAG, "请求结束 preLoading = false");
    }
  }
  
  private void beT()
  {
    if (this.mActivity != null) {
      this.mActivity.runOnUiThread(new WsCommentPresenter.8(this));
    }
  }
  
  private void dA(int paramInt1, int paramInt2)
  {
    WSPublicAccReport.getInstance().reportCommentPageClick(getSopName(), getPlayScene(), ln(), paramInt1, paramInt2, a());
  }
  
  private void el(int paramInt)
  {
    if (this.commentNum == 0L) {
      this.commentNum = a().aU(getFeedId());
    }
    this.commentNum += paramInt;
    if (this.mActivity != null) {
      this.mActivity.runOnUiThread(new WsCommentPresenter.7(this));
    }
    pmi.a().dispatch(new sct(5, new Object[] { getFeedId(), Long.valueOf(this.commentNum) }));
  }
  
  private String getFeedId()
  {
    if (a() == null)
    {
      ooz.e(this.TAG, 2, "getFeedId is null");
      return "";
    }
    return a().id;
  }
  
  private int getPosition()
  {
    return this.currentPosition;
  }
  
  private void k(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 1000L)
    {
      QQToast.a(this.mContext, 2, paramString1, 0).show();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, 1, this.mContext.getResources().getString(2131696284), 0).show();
      return;
    }
    QQToast.a(this.mContext, 1, paramString2, 0).show();
  }
  
  @NotNull
  private String ln()
  {
    if (WSPublicAccReport.isVideoPage(getSopName())) {
      return WSPublicAccReport.getPagePositionId(getSopName());
    }
    return WSPublicAccReport.getPagePositionId(getSopName()) + this.currentPosition;
  }
  
  private void py(String paramString)
  {
    if (this.jdField_b_of_type_UserGrowthStSimpleMetaComment == null) {
      this.jdField_b_of_type_UserGrowthStSimpleMetaComment = new stSimpleMetaComment();
    }
    this.jdField_b_of_type_UserGrowthStSimpleMetaComment.wording = paramString;
    stSimpleMetaComment localstSimpleMetaComment = new stSimpleMetaComment();
    localstSimpleMetaComment.id = ("fakeId_" + System.currentTimeMillis());
    localstSimpleMetaComment.wording = paramString;
    localstSimpleMetaComment.createtime = ((int)(System.currentTimeMillis() / 1000L));
    localstSimpleMetaComment.poster = a();
    localstSimpleMetaComment.replyList = new ArrayList();
    a().a(a(), localstSimpleMetaComment);
    this.axf = true;
    ooz.w("comment", "2 mCommentListChanged:" + this.axf + ", hashCode" + hashCode());
    if ((this.jdField_b_of_type_AndroidSupportV4AppFragment instanceof WSFollowFragment)) {
      ((WSFollowFragment)this.jdField_b_of_type_AndroidSupportV4AppFragment).a(getPosition(), a());
    }
    this.axj = true;
    this.jdField_b_of_type_UserGrowthStSimpleMetaComment = null;
    if (this.jdField_b_of_type_Ogt != null)
    {
      this.jdField_b_of_type_Ogt.a(0, localstSimpleMetaComment);
      this.jdField_b_of_type_Ogt.notifyDataSetChanged();
    }
    ooz.e(this.TAG, "onCommentSend, lastPosition:" + this.AS + ",currentPosition:" + getPosition());
    if (this.l != null) {
      this.l.setSelection(0);
    }
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
  
  private void qG(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ohe == null)
    {
      ooz.e(this.TAG, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Ohe.a(new ohp(this, paramBoolean));
  }
  
  private void uF(int paramInt)
  {
    if (this.mCommentContainer == null)
    {
      ooz.d(this.TAG, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Ogt.px(a().poster.id);
      this.jdField_b_of_type_Ogt.b(a());
    }
    this.mCommentContainer.setVisibility(paramInt);
  }
  
  public ogv a()
  {
    if (this.jdField_b_of_type_Ogv == null) {
      this.jdField_b_of_type_Ogv = new ogv(this);
    }
    return this.jdField_b_of_type_Ogv;
  }
  
  public void a(ViewStub paramViewStub, int paramInt)
  {
    if (paramViewStub != null)
    {
      paramViewStub.setLayoutResource(paramInt);
      this.mParentView = paramViewStub.inflate();
      Je();
      return;
    }
    ooz.e(this.TAG, 2, "viewStub is null");
  }
  
  public void a(opv paramopv)
  {
    this.jdField_a_of_type_Opv = paramopv;
  }
  
  public void b(stSimpleMetaComment paramstSimpleMetaComment)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a();
    int i;
    if (localstSimpleMetaFeed != null)
    {
      localstSimpleMetaFeed.total_comment_num += 1;
      i = localstSimpleMetaFeed.total_comment_num;
      localstSimpleMetaFeed.simpleComments.add(0, ogs.a(paramstSimpleMetaComment, a()));
    }
    for (;;)
    {
      paramstSimpleMetaComment = "";
      if (a() != null) {
        paramstSimpleMetaComment = a().id;
      }
      paramstSimpleMetaComment = new WSAddCommentEvent(paramstSimpleMetaComment, getPosition(), i);
      oiv.a().b(paramstSimpleMetaComment);
      return;
      i = 0;
    }
  }
  
  public void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.poster != null))
    {
      this.aqa = paramstSimpleMetaFeed.poster.id;
      if (this.jdField_b_of_type_Ogt != null) {
        this.jdField_b_of_type_Ogt.b(paramstSimpleMetaFeed);
      }
    }
    this.eK.put(Integer.valueOf(getPosition()), paramstSimpleMetaFeed);
  }
  
  public void b(ViewStub paramViewStub)
  {
    this.t = paramViewStub;
  }
  
  public void bX(String paramString1, String paramString2)
  {
    this.Ur = paramString1;
    this.aqb = paramString2;
    if (this.jdField_b_of_type_Ogt != null) {
      this.jdField_b_of_type_Ogt.bW(paramString1, paramString2);
    }
  }
  
  public void beM()
  {
    if (this.t != null)
    {
      initLayout(this.t);
      this.t = null;
    }
    if ((getFeedId() == null) && (this.retryTimes <= 3))
    {
      this.retryTimes += 1;
      a().getHandler().postDelayed(new WsCommentPresenter.1(this), this.retryTimes * 500);
    }
    stSimpleMetaFeed localstSimpleMetaFeed;
    String str;
    do
    {
      return;
      localstSimpleMetaFeed = a();
      if (localstSimpleMetaFeed == null)
      {
        ooz.e(this.TAG, "showCommentListWithAnim, but feed is null");
        return;
      }
      str = getFeedId();
    } while (str == null);
    this.md = a().t(str);
    if (this.md == null) {}
    for (int i = 0;; i = this.md.size())
    {
      ooz.w(this.TAG, "position:" + getPosition() + ",feedId:" + localstSimpleMetaFeed.id + ",cellId:" + str + ",loadedComments size:" + i + ",mCommentListChanged:" + this.axf + ",hashCode:" + hashCode());
      if (!this.axf) {
        break;
      }
      ooz.w(this.TAG, "11111111111111111111111111 mCommentListChanged");
      a().a(localstSimpleMetaFeed, false);
      this.axe = true;
      return;
    }
    if (this.md == null)
    {
      if (this.axl)
      {
        ooz.w(this.TAG, "444444444444444444444444 loadedComments == null and preloading is true");
        awT();
        return;
      }
      ooz.w(this.TAG, "2222222222222222222222222 loadedComments == null and preloading is false");
      a().a(localstSimpleMetaFeed, false);
      this.axe = true;
      return;
    }
    ooz.w(this.TAG, "333333333333333333333 读取评论" + this.md.size() + "条");
    awT();
  }
  
  public String getPlayScene()
  {
    return this.aqb;
  }
  
  public String getSopName()
  {
    return this.Ur;
  }
  
  public void initLayout(ViewStub paramViewStub)
  {
    if (paramViewStub == null) {
      return;
    }
    if (this.mLayoutId != -1)
    {
      a(paramViewStub, this.mLayoutId);
      return;
    }
    paramViewStub.setLayoutResource(2131560192);
    this.mParentView = paramViewStub.inflate();
    Je();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void l(int paramInt1, int paramInt2, String paramString)
  {
    WSPublicAccReport.getInstance().reportCommentPageClick(getSopName(), paramString, "comment_page_explicit", 1000001, paramInt2, a());
    a(null, null, paramInt1, true);
    bbm();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.ab)
    {
      if (this.mCommentContainer != null) {
        this.mCommentContainer.setVisibility(8);
      }
      this.axg = false;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dA(1000001, 7);
      a(null, null, 2);
      continue;
      dA(1000001, 7);
      a(null, null, 3);
      continue;
      dA(1000001, 4);
      a(null, null, 0, false);
      continue;
      dA(1000001, 7);
      a(null, null, 1);
    }
  }
  
  public void onRecycle()
  {
    ooz.w(this.TAG, this.TAG + " onRecycle");
    if (this.jdField_a_of_type_Ohl$a != null) {
      pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Ohl$a);
    }
    a().release();
    this.jdField_b_of_type_Ogv = null;
    if (this.md != null) {
      this.md.clear();
    }
    this.eK.clear();
  }
  
  public void r(Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    Integer localInteger = (Integer)paramArrayOfObject[1];
    Object localObject;
    if (paramArrayOfObject[2] == null)
    {
      localObject = "";
      ooz.w(this.TAG, "handleResponseEvent, action: " + paramArrayOfObject[0] + ",resultCode:" + localInteger + ",msg:" + (String)localObject);
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
          beL();
          return;
          if (this.jdField_a_of_type_Ohe != null) {
            this.jdField_a_of_type_Ohe.hideSoftInput(this.uj);
          }
          if (b(5, paramArrayOfObject))
          {
            ooz.e(this.TAG, 1, "handleResponseEvent add comment isInterceptEvent");
            return;
          }
          if (localInteger.intValue() != 1000) {
            ooz.e(this.TAG, 1, "comment fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          stPostFeedCommentV2Rsp localstPostFeedCommentV2Rsp = (stPostFeedCommentV2Rsp)paramArrayOfObject[3];
          if (localInteger.intValue() == 1000)
          {
            if ((this.jdField_b_of_type_Ogt != null) && (this.jdField_b_of_type_Ogt.a(String.valueOf(paramArrayOfObject[4]), localstPostFeedCommentV2Rsp.comment))) {
              beT();
            }
            this.axf = true;
            el(1);
          }
          for (;;)
          {
            ooz.e(this.TAG, 1, "ACTION_ADD_FEED_COMMENT, result =" + localInteger + " msg=" + (String)localObject);
            k(localInteger.intValue(), acfp.m(2131704198), (String)localObject);
            return;
            if ((this.jdField_b_of_type_Ogt != null) && (this.jdField_b_of_type_Ogt.eF(String.valueOf(paramArrayOfObject[4])))) {
              beT();
            }
          }
          if (b(4, paramArrayOfObject))
          {
            ooz.e(this.TAG, 1, "handleResponseEvent delete isInterceptEvent");
            return;
          }
          if ((localInteger.intValue() == 1000) && ((paramArrayOfObject[3] instanceof stDeleteFeedCommentRsp)))
          {
            paramArrayOfObject = (String)paramArrayOfObject[4];
            if ((this.jdField_b_of_type_Ogt != null) && (this.jdField_b_of_type_Ogt.eF(paramArrayOfObject))) {
              beT();
            }
            el(-1);
          }
          k(localInteger.intValue(), acfp.m(2131704196), acfp.m(2131704199));
          return;
          if (b(6, paramArrayOfObject))
          {
            ooz.e(this.TAG, 1, "handleResponseEvent add reply isInterceptEvent");
            return;
          }
          if (this.jdField_a_of_type_Ohe != null) {
            this.jdField_a_of_type_Ohe.hideSoftInput(this.uj);
          }
          if (localInteger.intValue() != 1000) {
            ooz.e(this.TAG, 1, "reply fail ret=" + localInteger + " msg=" + (String)localObject);
          }
          localObject = ((stPostCommentReplyV2Rsp)paramArrayOfObject[3]).reply;
          paramArrayOfObject = (String)paramArrayOfObject[5];
          ooz.e(this.TAG, "fakeReplyId:" + paramArrayOfObject + ",reply toString :" + ((stSimpleMetaReply)localObject).toString());
          if (localInteger.intValue() == 1000) {
            if ((this.jdField_b_of_type_Ogt != null) && (this.jdField_b_of_type_Ogt.a(((stSimpleMetaReply)localObject).id, paramArrayOfObject, (stSimpleMetaReply)localObject))) {
              beT();
            }
          }
          for (;;)
          {
            k(localInteger.intValue(), acfp.m(2131704195), acfp.m(2131704200));
            return;
            if ((this.jdField_b_of_type_Ogt != null) && (this.jdField_b_of_type_Ogt.L(((stSimpleMetaReply)localObject).id, paramArrayOfObject))) {
              beT();
            }
          }
          if (b(5, paramArrayOfObject))
          {
            ooz.e(this.TAG, 1, "handleResponseEvent delete reply isInterceptEvent");
            return;
          }
          k(localInteger.intValue(), acfp.m(2131704197), acfp.m(2131704201));
        } while ((!(paramArrayOfObject[3] instanceof String)) || (!(paramArrayOfObject[4] instanceof stSimpleMetaReply)));
        localObject = (String)paramArrayOfObject[3];
        paramArrayOfObject = ((stSimpleMetaReply)paramArrayOfObject[4]).id;
      } while ((localInteger.intValue() != 1000) || (this.jdField_b_of_type_Ogt == null) || (TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramArrayOfObject)));
      this.jdField_b_of_type_Ogt.L((String)localObject, paramArrayOfObject);
      beT();
      return;
    }
    ooz.e(this.TAG, "onEvent: ACTION_GET_MORE_COMMENT！");
    beS();
    if (((paramArrayOfObject[6] instanceof String)) && (!((String)paramArrayOfObject[6]).equals(getFeedId())))
    {
      ooz.e(this.TAG, "不是当前feedId的数据，不响应！！！！！！！！！！！！！！！！");
      return;
    }
    if (b(4, paramArrayOfObject))
    {
      beS();
      return;
    }
    boolean bool;
    if ((paramArrayOfObject[5] instanceof Boolean))
    {
      bool = ((Boolean)paramArrayOfObject[5]).booleanValue();
      if (!bool)
      {
        this.axf = false;
        ooz.w(this.TAG, "---------------------------------------- if(!loadMore) mCommentListChanged = false, hashCode" + hashCode());
      }
    }
    for (;;)
    {
      if ((paramArrayOfObject[3] instanceof stGetFeedCommentListV2Rsp))
      {
        if (this.jdField_b_of_type_Ogt != null)
        {
          paramArrayOfObject = ((stGetFeedCommentListV2Rsp)paramArrayOfObject[3]).comments;
          if (paramArrayOfObject.size() != 0) {
            break label1056;
          }
          qF(true);
        }
        for (;;)
        {
          if ((!this.axe) || (bool)) {
            break label1086;
          }
          paramArrayOfObject = this.jdField_b_of_type_AndroidSupportV4AppFragment.getActivity();
          if (paramArrayOfObject == null) {
            break;
          }
          paramArrayOfObject.runOnUiThread(new WsCommentPresenter.6(this));
          return;
          label1056:
          if (!bool) {
            this.jdField_b_of_type_Ogt.beD();
          }
          this.jdField_b_of_type_Ogt.c(paramArrayOfObject);
          beT();
          el(0);
        }
        label1086:
        break;
      }
      ooz.e(this.TAG, "获取评论response失败");
      return;
      bool = true;
    }
  }
  
  public void setPosition(int paramInt)
  {
    if ((paramInt != this.currentPosition) && (this.jdField_b_of_type_Ogt != null))
    {
      this.jdField_b_of_type_Ogt.ad.clear();
      this.jdField_b_of_type_Ogt.ac.clear();
    }
    this.currentPosition = paramInt;
    ogt.beU = paramInt;
  }
  
  public static class a
    extends QQUIEventReceiver<ohl, sct>
  {
    private int currentIndex;
    
    a(@NonNull ohl paramohl, int paramInt)
    {
      super();
      this.currentIndex = paramInt;
    }
    
    public void a(@NonNull ohl paramohl, @NonNull sct paramsct)
    {
      ooz.w("comment", "onEvent,commentEvent.mEventAction:" + paramsct.bgK + ",WSHomeFragment.mCurrentPageIndex:" + WSHomeFragment.mCurrentPageIndex + ",mCurrentPageIndex:" + this.currentIndex);
      if (WSHomeFragment.mCurrentPageIndex != this.currentIndex) {
        ooz.e("comment", "commentPresenter 's hashCode:" + paramohl.hashCode() + ", 页面不对,不响应!");
      }
      do
      {
        return;
        ooz.w("comment", "commentPresenter 's hashCode:" + paramohl.hashCode() + ", 页面正确,开始响应~");
        switch (paramsct.bgK)
        {
        case 3: 
        case 5: 
        default: 
          ooz.d("comment", "default process,commentEvent.mEventAction:" + paramsct.bgK);
          return;
        case 1: 
          paramohl.beM();
          return;
        case 2: 
          ohl.a(paramohl);
          return;
        case 4: 
          if ((paramsct.params instanceof Object[]))
          {
            paramsct = (Object[])paramsct.params;
            int i = ((Integer)paramsct[0]).intValue();
            paramohl.setPosition(i);
            paramsct = (stSimpleMetaFeed)((oqr)paramsct[1]).B();
            ooz.w("comment", "setCurrentFeed , feedId:" + paramsct.id + ", position:" + i + ",feed desc:" + paramsct.feed_desc);
            paramohl.b(paramsct);
          }
          QZLog.w(this.TAG, "event page change, position:" + ohl.b(paramohl) + " feedId:" + ohl.b(paramohl));
          ohl.a(paramohl, null);
          ohl.a(paramohl, "");
          ohl.b(paramohl, 0L);
          ohl.a(paramohl, false);
        }
      } while (!ohl.e(paramohl));
      ohl.a(paramohl).getHandler().removeMessages(11);
      paramsct = ohl.a(paramohl).getHandler().obtainMessage(11);
      ohl.a(paramohl).getHandler().sendMessageDelayed(paramsct, 20L);
      return;
      paramohl.r((Object[])paramsct.params);
    }
    
    public Class acceptEventClass()
    {
      return sct.class;
    }
  }
  
  class b
    implements sdw
  {
    b() {}
    
    private void a(stSimpleMetaPerson paramstSimpleMetaPerson, stSchema paramstSchema)
    {
      if (paramstSchema != null)
      {
        switch (paramstSchema.type)
        {
        default: 
          return;
        case 1: 
          paramstSimpleMetaPerson = paramstSchema.miniAppSchema;
          okj.a().aW(ohl.a(ohl.this), paramstSimpleMetaPerson);
          ooz.w("weishi", "miniShema is :" + paramstSimpleMetaPerson);
          ohl.a(ohl.this, 1000007, 2);
          return;
        case 2: 
          a(paramstSimpleMetaPerson, paramstSchema.schema);
          return;
        }
        paramstSchema = paramstSchema.H5Url;
        ooz.w("weishi", "h5Url is :" + paramstSchema);
        if ((ohl.a(ohl.this) instanceof Activity))
        {
          paramstSimpleMetaPerson = new Bundle();
          paramstSimpleMetaPerson.putBoolean("injectrecommend", false);
          paramstSchema = URLDecoder.decode(paramstSchema);
          QzoneLiveVideoInterface.forwardToBrowser((Activity)ohl.a(ohl.this), paramstSchema, 0, paramstSimpleMetaPerson, null);
          ooz.d(ohl.a(ohl.this), "评论头像点击:" + paramstSchema);
        }
        for (;;)
        {
          ohl.a(ohl.this, 1000001, 2);
          return;
          ooz.w(ohl.a(ohl.this), "context 不是Activity");
        }
      }
      a(paramstSimpleMetaPerson, paramstSimpleMetaPerson.schema_url);
    }
    
    private void a(stSimpleMetaPerson paramstSimpleMetaPerson, String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (paramstSimpleMetaPerson = "weishi://profile?person_id=" + opn.getPersonId();; paramstSimpleMetaPerson = paramString)
      {
        paramString = ohl.a(ohl.this, paramstSimpleMetaPerson, 13);
        if (rpw.isWeishiInstalled(ohl.a(ohl.this)))
        {
          opb.a(ohl.a(ohl.this), "biz_src_jc_gzh_weishi", paramstSimpleMetaPerson, paramString.mScene, paramString.mLinkStrategyType, paramString.mEventId);
          ohl.a(ohl.this, 1000003, 2);
          return;
        }
        oir.a(ohl.a(ohl.this), paramString, true);
        ohl.a(ohl.this, 1000002, 2);
        return;
      }
    }
    
    public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
    {
      WSDownloadParams localWSDownloadParams;
      switch (paramInt1)
      {
      default: 
        return;
      case 12: 
        paramView = (String)paramObject;
        paramObject = "weishi://profile?person_id=" + paramView;
        localWSDownloadParams = ohl.a(ohl.this, paramObject, 14);
        paramView = WSPublicAccReport.getTagPositionId(ohl.this.getSopName());
        if (TextUtils.equals(ohl.this.getSopName(), "focus")) {
          paramView = paramView + ohl.a(ohl.this);
        }
        break;
      }
      for (;;)
      {
        if (rpw.isWeishiInstalled(ohl.a(ohl.this)))
        {
          opb.a(ohl.a(ohl.this), "biz_src_jc_gzh_weishi", paramObject, localWSDownloadParams.mScene, localWSDownloadParams.mLinkStrategyType, localWSDownloadParams.mEventId);
          WSPublicAccReport.getInstance().reportCommentTagClick(ohl.this.getSopName(), ohl.this.getPlayScene(), paramView, 1000003, ohl.a(ohl.this));
          return;
        }
        oir.c(ohl.a(ohl.this), localWSDownloadParams);
        WSPublicAccReport.getInstance().reportCommentTagClick(ohl.this.getSopName(), ohl.this.getPlayScene(), paramView, 1000002, ohl.a(ohl.this));
        return;
        ohl.a(ohl.this, 1000001, 6);
        return;
        paramView = ((stSimpleMetaPerson)paramObject).avatarSchema;
        a((stSimpleMetaPerson)paramObject, paramView);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        if ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply))) {
          break;
        }
        paramView = (stSimpleMetaReply)paramObject[1];
        paramObject = (stSimpleMetaComment)paramObject[0];
        if (paramView.poster != null)
        {
          paramObject = paramView.poster.avatarSchema;
          a(paramView.poster, paramObject);
          return;
        }
        a(paramView.poster, null);
        return;
        if (!(paramObject instanceof stSimpleMetaComment)) {
          break;
        }
        paramView = (stSimpleMetaComment)paramObject;
        ohl.a(ohl.this, paramView, null, 0);
        ohl.a(ohl.this, 1000001, 1);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramObject = (Object[])paramObject;
        if ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply))) {
          break;
        }
        paramView = (stSimpleMetaComment)paramObject[0];
        paramObject = (stSimpleMetaReply)paramObject[1];
        ohl.a(ohl.this, paramView, paramObject, 0);
        ohl.a(ohl.this, 1000001, 1);
        return;
        if (!(paramObject instanceof stSimpleMetaComment)) {
          break;
        }
        paramView = (stSimpleMetaComment)paramObject;
        ohl.a(ohl.this).a(paramView);
        ohl.a(ohl.this, 1000001, 5);
        return;
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramView = (Object[])paramObject;
        if ((paramView.length <= 1) || (paramView[0] == null)) {
          break;
        }
        paramObject = (stSimpleMetaComment)paramView[0];
        paramInt1 = ohl.a(ohl.this).a(paramObject);
        if ((paramInt1 < 0) || (paramView[1] == null)) {
          break;
        }
        int i = ((Integer)paramView[1]).intValue();
        ohl.this.l.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
        return;
        if (!(paramObject instanceof stSimpleMetaComment)) {
          break;
        }
        paramView = (stSimpleMetaComment)paramObject;
        ohl.a(ohl.this, ohl.this.a().a(ohl.a(ohl.this), paramView));
        ohl.this.axf = true;
        ooz.w("comment", "3 mCommentListChanged:" + ohl.this.axf + ",clickPosition:" + paramInt2 + ", hashCode" + ohl.this.hashCode());
        paramObject = ohl.this;
        if (paramView.isDing == 0) {}
        for (paramInt1 = 1001002;; paramInt1 = 1001001)
        {
          ohl.a(paramObject, paramInt1, 3);
          if (!(ohl.a(ohl.this) instanceof WSFollowFragment)) {
            break;
          }
          paramInt1 = paramInt2 - 1;
          paramView = ((WSFollowFragment)ohl.a(ohl.this)).a().a().findViewHolderForAdapterPosition(ohl.b(ohl.this));
          if (!(paramView instanceof oiy)) {
            break;
          }
          paramView = (oiy)paramView;
          ooz.w("comment", "***getPosition():" + ohl.b(ohl.this) + ",realPosition:" + paramInt1);
          paramView.uJ(paramInt1);
          return;
        }
        if (!(paramObject instanceof Object[])) {
          break;
        }
        paramView = (Object[])paramObject;
        if ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null)) {
          break;
        }
        paramObject = (stSimpleMetaComment)paramView[0];
        ohl.this.a().a(ohl.a(ohl.this), paramObject, (stSimpleMetaReply)paramView[1]);
        ohl.this.axf = true;
        ooz.w("comment", "4 mCommentListChanged:" + ohl.this.axf + ", hashCode" + ohl.this.hashCode());
        ohl.a(ohl.this, 1000001, 3);
        return;
      }
    }
    
    public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
    {
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
          } while (!(paramObject instanceof stSimpleMetaComment));
          paramView = (stSimpleMetaComment)paramObject;
          ohl.a(ohl.this, new sbx(ohl.a(ohl.this), false, true));
          ohl.a(ohl.this).addButton(ohl.a(ohl.this).getString(2131721060), 0, new ohq(this, paramView));
          if (ohl.a(ohl.this, paramView.poster)) {
            ohl.a(ohl.this).addButton(ohl.a(ohl.this).getString(2131692498), 1, new ohr(this, paramView));
          }
          for (;;)
          {
            ohl.a(ohl.this).sZ(ohl.a(ohl.this).getString(2131721058));
            ohl.a(ohl.this).show();
            return;
            ohl.a(ohl.this).addButton(ohl.a(ohl.this).getString(2131718824), 6, new ohs(this));
          }
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof stSimpleMetaComment)) || (!(paramObject[1] instanceof stSimpleMetaReply)));
      paramView = (stSimpleMetaComment)paramObject[0];
      paramObject = (stSimpleMetaReply)paramObject[1];
      ohl.a(ohl.this, new sbx(ohl.a(ohl.this), false, true));
      ohl.a(ohl.this).addButton(ohl.a(ohl.this).getString(2131721060), 0, new oht(this, paramObject));
      if (ohl.a(ohl.this, paramObject.poster)) {
        ohl.a(ohl.this).addButton(ohl.a(ohl.this).getString(2131692498), 1, new ohu(this, paramView, paramObject));
      }
      for (;;)
      {
        ohl.a(ohl.this).sZ(ohl.a(ohl.this).getString(2131721058));
        ohl.a(ohl.this).show();
        return;
        ohl.a(ohl.this).addButton(ohl.a(ohl.this).getString(2131718824), 6, new ohv(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohl
 * JD-Core Version:    0.7.0.1
 */