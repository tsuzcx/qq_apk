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
import android.support.annotation.NonNull;
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
import com.tencent.biz.richframework.network.VSNetworkHelper;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class scw
  extends sak<CertifiedAccountMeta.StComment>
  implements View.OnClickListener, Animation.AnimationListener, CompoundButton.OnCheckedChangeListener, IEventReceiver
{
  private static final String TAG = scw.class.getSimpleName();
  private int AS = -1;
  private sbx jdField_a_of_type_Sbx;
  private final scw.a jdField_a_of_type_Scw$a;
  private scw.b jdField_a_of_type_Scw$b;
  private scw.c jdField_a_of_type_Scw$c;
  private scw.d jdField_a_of_type_Scw$d;
  private sdv jdField_a_of_type_Sdv;
  private sdx jdField_a_of_type_Sdx;
  private seb jdField_a_of_type_Seb;
  private String aDJ;
  private String aDK;
  private Animation ah;
  private Animation ai;
  private String aqa;
  private boolean axe;
  private boolean axf;
  private boolean axh;
  private boolean axi;
  private boolean axj;
  private boolean axk;
  private boolean axl;
  private boolean ayY;
  private boolean ayZ;
  private boolean aza;
  private AbsListView.OnScrollListener b;
  protected sci b;
  private int bgL;
  private CertifiedAccountMeta.StComment jdField_c_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment;
  private CertifiedAccountMeta.StReply jdField_c_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
  private int commentNum;
  private ArrayList<CertifiedAccountMeta.StComment> comments;
  private COMM.StCommonExt e;
  private Map<Long, CertifiedAccountMeta.StUser> fk = new HashMap();
  private Map<Long, CertifiedAccountMeta.StReply> fl = new HashMap();
  private Map<Long, CertifiedAccountMeta.StComment> ft = new HashMap();
  private Map<Integer, CertifiedAccountMeta.StFeed> fu = new HashMap();
  private View gD;
  public ListView l;
  private final Activity mActivity;
  View mCommentContainer;
  private TextView mCommentCount;
  private ExtraTypeInfo mExtraTypeInfo;
  private View.OnLayoutChangeListener mLayoutChangeListener = new scz(this);
  private View ns;
  private View nt;
  private int retryTimes;
  private ViewStub t;
  private TextView uj;
  private long yN;
  private long yO;
  
  public scw(Activity paramActivity, boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed, scw.c paramc, ExtraTypeInfo paramExtraTypeInfo)
  {
    super(paramActivity, paramBoolean);
    this.jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener = new scy(this);
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Scw$a = new scw.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Scw$a);
    this.jdField_a_of_type_Scw$c = paramc;
    this.mExtraTypeInfo = paramExtraTypeInfo;
    resetParams();
    m(paramStFeed);
    beL();
  }
  
  private void Je()
  {
    this.l = ((ListView)findViewById(2131366801));
    this.mCommentContainer = findViewById(2131364998);
    this.gD = findViewById(2131366802);
    this.mCommentCount = ((TextView)findViewById(2131365029));
    this.ns = findViewById(2131365009);
    this.uj = ((TextView)findViewById(2131379487));
    this.uj.setOnClickListener(this);
    this.nt = findViewById(2131363856);
    this.nt.setOnClickListener(this);
    this.l.setOnScrollListener(this.jdField_b_of_type_AndroidWidgetAbsListView$OnScrollListener);
    this.l.addOnLayoutChangeListener(this.mLayoutChangeListener);
    this.jdField_a_of_type_Scw$d = new scw.d();
    this.jdField_a_of_type_Sdv = new sdv(this.mContext, this.jdField_a_of_type_Scw$d);
    this.jdField_a_of_type_Sdv.px(this.aqa);
    this.l.setAdapter(this.jdField_a_of_type_Sdv);
    this.l.setEmptyView(this.ns);
    if (this.mCommentContainer != null) {
      this.mCommentContainer.setOnClickListener(new scx(this));
    }
  }
  
  private CertifiedAccountMeta.StComment a(CertifiedAccountMeta.StComment paramStComment)
  {
    return new CertifiedAccountMeta.StComment();
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
  
  private sci a()
  {
    if (this.jdField_b_of_type_Sci == null)
    {
      this.jdField_b_of_type_Sci = new sci();
      this.bgL = this.jdField_b_of_type_Sci.hashCode();
    }
    return this.jdField_b_of_type_Sci;
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    QLog.e(TAG, 1, "popupComment");
    a(paramStComment, paramStReply, true, false);
  }
  
  private void a(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mContext == null) || (BaseApplicationImpl.getContext() == null))
    {
      QLog.e(TAG, 1, "plugin environment exception ! ");
      return;
    }
    if (this.jdField_a_of_type_Seb == null) {
      this.jdField_a_of_type_Seb = new seb((Activity)this.mContext);
    }
    String str;
    if (paramStReply != null) {
      if (paramStReply.postUser != null)
      {
        str = "";
        if ("".length() > 10)
        {
          str = "".substring(0, 10);
          str = str + "...";
        }
        this.jdField_a_of_type_Seb.qG(str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Seb.a(new sda(this, paramStComment, paramStReply));
      b(paramStComment, paramStReply);
      this.jdField_a_of_type_Seb.show(paramBoolean2);
      return;
      if ((paramStComment != null) && (paramStComment.postUser != null))
      {
        str = "";
        if ("".length() > 10)
        {
          str = "".substring(0, 10);
          str = str + "...";
        }
        this.jdField_a_of_type_Seb.qG(str);
      }
    }
  }
  
  private boolean a(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (ryz.a() != null) && (paramStUser.id.get().equals(ryz.a().id.get()))) {}
    while ((paramStUser != null) && (paramStUser.id.get().equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()))) {
      return true;
    }
    return false;
  }
  
  private void aT(int paramInt, String paramString)
  {
    Object localObject = this.l.getChildAt(paramInt);
    if ((localObject instanceof CommentView))
    {
      localObject = (CommentView)localObject;
      paramString = ((CommentView)localObject).a(paramString);
      localObject = ((CommentView)localObject).f();
      if ((paramString != null) && (localObject != null))
      {
        int i = ((LinearLayout)localObject).getTop();
        int j = paramString.getTop();
        QLog.d(TAG, 2, "scrollToReplyView getTop containerTop:" + i + "replyViewTop:" + j);
        this.l.setSelectionFromTop(paramInt, -(i + j));
      }
    }
  }
  
  private void awT()
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(lX())) {}
        beN();
        rwv.a().a(new CommentListShowStateEvent(true));
        if ((this.comments != null) && (this.comments.size() > 0))
        {
          if (this.mCommentCount != null)
          {
            this.mCommentCount.setText(sds.aO(this.commentNum));
            this.mCommentCount.setVisibility(0);
          }
          if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() != 0))
          {
            this.mCommentContainer.setVisibility(0);
            this.ai = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            this.ai.setDuration(200L);
            this.ai.setAnimationListener(this);
            this.ai.setInterpolator(new AccelerateDecelerateInterpolator());
            this.gD.startAnimation(this.ai);
          }
          if (this.jdField_a_of_type_Sdv.getCount() == 0)
          {
            bool = true;
            qF(bool);
          }
        }
        else
        {
          if (this.mCommentCount == null) {
            continue;
          }
          this.mCommentCount.setText("");
          this.mCommentCount.setVisibility(8);
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  private CertifiedAccountMeta.StUser b()
  {
    if (ryz.a() != null) {
      return ryz.a();
    }
    CertifiedAccountMeta.StUser localStUser = new CertifiedAccountMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    localStUser.type.set(0);
    return localStUser;
  }
  
  private void b(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (this.jdField_a_of_type_Seb == null)
    {
      QLog.e(TAG, 1, "mCommentInputPopupWindow == null");
      return;
    }
    this.jdField_a_of_type_Seb.setOnShowListener(new sdb(this, paramStComment, paramStReply));
    this.jdField_a_of_type_Seb.a(new sdc(this, paramStComment, paramStReply));
  }
  
  private void b(CertifiedAccountMeta.StFeed paramStFeed, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
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
      paramStReply = new sgq.a();
      paramStReply.system = "android";
      paramStReply.version = AppSetting.getVersion();
      paramStReply.aDR = "1";
      paramStReply.aDS = paramStComment;
      paramStReply.appname = "KQQ";
      paramStReply.appid = "2400002";
      paramStReply.aDT = "qzone_authentication_comment";
      paramStReply.scene = "24000";
      paramStReply.aDU = "0";
      paramStReply.aDV = localStringBuilder.toString();
      paramStReply.aDW = paramStFeed;
      sgq.a(this.mContext, paramStReply);
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
  
  private boolean b(int paramInt, Object[] paramArrayOfObject)
  {
    return this.bgL != ((Integer)paramArrayOfObject[paramInt]).intValue();
  }
  
  private void beL()
  {
    if (lX() != null)
    {
      this.axl = true;
      if ((this.mExtraTypeInfo != null) && (!TextUtils.isEmpty(this.mExtraTypeInfo.getCommentId()))) {
        a().a(e(), false, this.mExtraTypeInfo.getCommentId());
      }
    }
    else
    {
      return;
    }
    a().a(e(), false, "");
  }
  
  /* Error */
  private void beN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 355	scw:jdField_b_of_type_Sci	Lsci;
    //   6: ifnonnull +16 -> 22
    //   9: getstatic 106	scw:TAG	Ljava/lang/String;
    //   12: iconst_1
    //   13: ldc_w 765
    //   16: invokestatic 384	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokespecial 368	scw:a	()Lsci;
    //   27: aload_0
    //   28: invokespecial 341	scw:lX	()Ljava/lang/String;
    //   31: invokevirtual 768	sci:t	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   34: putfield 347	scw:comments	Ljava/util/ArrayList;
    //   37: aload_0
    //   38: aload_0
    //   39: invokespecial 368	scw:a	()Lsci;
    //   42: aload_0
    //   43: invokespecial 341	scw:lX	()Ljava/lang/String;
    //   46: invokevirtual 771	sci:a	(Ljava/lang/String;)LNS_COMM/COMM$StCommonExt;
    //   49: putfield 328	scw:e	LNS_COMM/COMM$StCommonExt;
    //   52: aload_0
    //   53: getfield 347	scw:comments	Ljava/util/ArrayList;
    //   56: ifnull -37 -> 19
    //   59: aload_0
    //   60: getfield 227	scw:jdField_a_of_type_Sdv	Lsdv;
    //   63: ifnull +44 -> 107
    //   66: aload_0
    //   67: getfield 227	scw:jdField_a_of_type_Sdv	Lsdv;
    //   70: invokevirtual 774	sdv:beD	()V
    //   73: aload_0
    //   74: getfield 227	scw:jdField_a_of_type_Sdv	Lsdv;
    //   77: aload_0
    //   78: getfield 347	scw:comments	Ljava/util/ArrayList;
    //   81: invokevirtual 777	sdv:c	(Ljava/util/Collection;)Z
    //   84: pop
    //   85: aload_0
    //   86: getfield 779	scw:ayZ	Z
    //   89: ifeq +11 -> 100
    //   92: aload_0
    //   93: getfield 227	scw:jdField_a_of_type_Sdv	Lsdv;
    //   96: iconst_0
    //   97: invokevirtual 782	sdv:vh	(I)V
    //   100: aload_0
    //   101: getfield 227	scw:jdField_a_of_type_Sdv	Lsdv;
    //   104: invokevirtual 785	sdv:notifyDataSetChanged	()V
    //   107: aload_0
    //   108: getfield 178	scw:l	Landroid/widget/ListView;
    //   111: ifnull +47 -> 158
    //   114: aload_0
    //   115: getfield 138	scw:AS	I
    //   118: aload_0
    //   119: invokevirtual 788	scw:getPosition	()I
    //   122: if_icmpeq +36 -> 158
    //   125: aload_0
    //   126: getfield 779	scw:ayZ	Z
    //   129: ifeq +29 -> 158
    //   132: aload_0
    //   133: aload_0
    //   134: invokevirtual 788	scw:getPosition	()I
    //   137: putfield 138	scw:AS	I
    //   140: getstatic 106	scw:TAG	Ljava/lang/String;
    //   143: iconst_1
    //   144: ldc_w 790
    //   147: invokestatic 531	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: getfield 178	scw:l	Landroid/widget/ListView;
    //   154: iconst_0
    //   155: invokevirtual 793	android/widget/ListView:setSelection	(I)V
    //   158: aload_0
    //   159: getfield 347	scw:comments	Ljava/util/ArrayList;
    //   162: ifnull -143 -> 19
    //   165: aload_0
    //   166: getfield 347	scw:comments	Ljava/util/ArrayList;
    //   169: invokevirtual 561	java/util/ArrayList:size	()I
    //   172: ifle -153 -> 19
    //   175: aload_0
    //   176: aload_0
    //   177: invokespecial 368	scw:a	()Lsci;
    //   180: aload_0
    //   181: invokespecial 341	scw:lX	()Ljava/lang/String;
    //   184: invokevirtual 797	sci:aU	(Ljava/lang/String;)I
    //   187: putfield 247	scw:commentNum	I
    //   190: goto -171 -> 19
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	scw
    //   193	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	193	finally
    //   22	100	193	finally
    //   100	107	193	finally
    //   107	158	193	finally
    //   158	190	193	finally
  }
  
  private void beO()
  {
    if ((this.mCommentContainer != null) && (!this.ayY))
    {
      this.ah = AnimationUtils.loadAnimation(this.mContext, 2130772055);
      this.ah.setAnimationListener(this);
      this.gD.startAnimation(this.ah);
      rwv.a().a(new CommentListShowStateEvent(false));
    }
    this.axe = false;
  }
  
  private void beT()
  {
    runOnUiThread(new CommentPresenter.1(this));
  }
  
  private void biC()
  {
    a().a(e(), false);
  }
  
  private CertifiedAccountMeta.StFeed e()
  {
    int i = getPosition();
    return (CertifiedAccountMeta.StFeed)this.fu.get(Integer.valueOf(i));
  }
  
  private void el(int paramInt)
  {
    if (this.commentNum == 0) {
      this.commentNum = a().aU(lX());
    }
    this.commentNum += paramInt;
    runOnUiThread(new CommentPresenter.2(this));
    pmi.a().dispatch(new sct(5, new Object[] { lX(), Integer.valueOf(this.commentNum) }));
  }
  
  private void k(long paramLong, String paramString1, String paramString2)
  {
    if (paramLong == 0L)
    {
      QQToast.a(getContext(), 2, paramString1, 0).show();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(this.mContext))
    {
      QQToast.a(getContext(), 1, getContext().getResources().getString(2131696284), 0).show();
      return;
    }
    QQToast.a(getContext(), 1, paramString2, 0).show();
  }
  
  private String lX()
  {
    if (e() == null)
    {
      QLog.e(TAG, 2, "getCellId null");
      return "";
    }
    return e().id.get();
  }
  
  private void m(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.aqa = paramStFeed.poster.id.get();
    }
    this.fu.put(Integer.valueOf(getPosition()), paramStFeed);
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
  
  private void r(Object[] paramArrayOfObject)
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
                    beL();
                    return;
                    this.axf = false;
                    if (paramArrayOfObject[3] != null)
                    {
                      localObject2 = (CertifiedAccountRead.StGetFeedDetailRsp)paramArrayOfObject[3];
                      if (b(4, paramArrayOfObject)) {
                        continue;
                      }
                      m((CertifiedAccountMeta.StFeed)((CertifiedAccountRead.StGetFeedDetailRsp)localObject2).feed.get());
                      if (this.jdField_a_of_type_Scw$c != null) {
                        this.jdField_a_of_type_Scw$c.a((CertifiedAccountRead.StGetFeedDetailRsp)localObject2, VSNetworkHelper.fQ((String)localObject1), localLong.longValue(), (String)localObject1);
                      }
                      if ((paramArrayOfObject.length >= 6) && (paramArrayOfObject[5] != null))
                      {
                        localObject1 = (COMM.StCommonExt)paramArrayOfObject[5];
                        paramArrayOfObject = a().t(lX());
                        if (((COMM.StCommonExt)localObject1).mapInfo.size() > 0)
                        {
                          localObject1 = ((COMM.Entry)((COMM.StCommonExt)localObject1).mapInfo.get(0)).value.get();
                          if ((paramArrayOfObject == null) || (paramArrayOfObject.size() <= 0) || (!((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0)).id.get().equals(localObject1))) {
                            break label414;
                          }
                          if ((this.mExtraTypeInfo == null) || (TextUtils.isEmpty(this.mExtraTypeInfo.getReplyId()))) {
                            break label385;
                          }
                          localObject1 = a((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), this.mExtraTypeInfo.getReplyId());
                          if (localObject1 == null) {
                            break label370;
                          }
                          beM();
                          rwv.a().a(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), (CertifiedAccountMeta.StReply)localObject1));
                          this.ayZ = true;
                          this.aza = true;
                        }
                      }
                      if (this.axe) {
                        runOnUiThread(new CommentPresenter.13(this));
                      }
                    }
                    for (;;)
                    {
                      if (!this.axl) {
                        break label486;
                      }
                      this.axl = false;
                      return;
                      runOnUiThread(new CommentPresenter.11(this));
                      break;
                      beM();
                      rwv.a().a(new CommentReplyEvent((CertifiedAccountMeta.StComment)paramArrayOfObject.get(0), null));
                      break;
                      runOnUiThread(new CommentPresenter.12(this));
                      break;
                      QLog.w(TAG, 1, "get feed detail response failed");
                      if (this.jdField_a_of_type_Scw$c != null) {
                        this.jdField_a_of_type_Scw$c.a(null, VSNetworkHelper.fQ((String)localObject1), localLong.longValue(), (String)localObject1);
                      }
                      if (!this.axl) {
                        QQToast.a(getContext(), (CharSequence)localObject1, 0).show();
                      }
                    }
                  }
                  if (this.jdField_a_of_type_Seb != null) {
                    this.jdField_a_of_type_Seb.hideSoftInput(this.uj);
                  }
                } while (b(5, paramArrayOfObject));
                if (localLong.longValue() != 0L) {
                  QLog.e(TAG, 1, "comment fail ret=" + localLong + " msg=" + (String)localObject1);
                }
                if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp))
                {
                  localObject2 = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment;
                  if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Sdv != null) && (this.jdField_a_of_type_Sdv.eF(String.valueOf(paramArrayOfObject[4])))) {
                    beT();
                  }
                  if (localLong.longValue() == 0L)
                  {
                    if ((this.jdField_a_of_type_Sdv != null) && (this.jdField_a_of_type_Sdv.a(String.valueOf(paramArrayOfObject[4]), (CertifiedAccountMeta.StComment)localObject2))) {
                      beT();
                    }
                    el(1);
                  }
                }
                k(localLong.longValue(), acfp.m(2131704198), (String)localObject1);
                a().getHandler().postDelayed(new CommentPresenter.14(this), 1000L);
                return;
              } while (b(4, paramArrayOfObject));
              if ((localLong.longValue() == 0L) && ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoCommentRsp)))
              {
                paramArrayOfObject = ((CertifiedAccountWrite.StDoCommentRsp)paramArrayOfObject[3]).comment.id.get();
                if ((this.jdField_a_of_type_Sdv != null) && (this.jdField_a_of_type_Sdv.eF(paramArrayOfObject))) {
                  beT();
                }
                el(-1);
              }
              k(localLong.longValue(), acfp.m(2131704196), acfp.m(2131704199));
              return;
            } while (b(6, paramArrayOfObject));
            if (this.jdField_a_of_type_Seb != null) {
              this.jdField_a_of_type_Seb.hideSoftInput(this.uj);
            }
            if (localLong.longValue() != 0L) {
              QLog.e(TAG, 1, "reply fail ret=" + localLong + " msg=" + (String)localObject1);
            }
            if ((paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp))
            {
              localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply;
              localObject2 = (CertifiedAccountMeta.StComment)paramArrayOfObject[4];
              paramArrayOfObject = (String)paramArrayOfObject[5];
              if ((localLong.longValue() != 0L) && (this.jdField_a_of_type_Sdv != null) && (this.jdField_a_of_type_Sdv.L(((CertifiedAccountMeta.StComment)localObject2).id.get(), paramArrayOfObject))) {
                beT();
              }
              if ((localLong.longValue() == 0L) && (this.jdField_a_of_type_Sdv != null) && (this.jdField_a_of_type_Sdv.a(((CertifiedAccountMeta.StComment)localObject2).id.get(), paramArrayOfObject, (CertifiedAccountMeta.StReply)localObject1))) {
                beT();
              }
            }
            k(localLong.longValue(), acfp.m(2131704195), acfp.m(2131704200));
            return;
          } while (b(5, paramArrayOfObject));
          k(localLong.longValue(), acfp.m(2131704197), acfp.m(2131704201));
        } while ((!(paramArrayOfObject[3] instanceof CertifiedAccountWrite.StDoReplyRsp)) || (!(paramArrayOfObject[4] instanceof CertifiedAccountMeta.StComment)));
        localObject1 = ((CertifiedAccountWrite.StDoReplyRsp)paramArrayOfObject[3]).reply.id.get();
        paramArrayOfObject = ((CertifiedAccountMeta.StComment)paramArrayOfObject[4]).id.get();
      } while ((localLong.longValue() != 0L) || (this.jdField_a_of_type_Sdv == null) || (TextUtils.isEmpty(paramArrayOfObject)) || (TextUtils.isEmpty((CharSequence)localObject1)));
      this.jdField_a_of_type_Sdv.L(paramArrayOfObject, (String)localObject1);
      beT();
      return;
    } while ((b(4, paramArrayOfObject)) || (!(paramArrayOfObject[3] instanceof CertifiedAccountRead.StGetCommentListRsp)));
    label385:
    label414:
    label486:
    if (this.jdField_a_of_type_Sdv != null)
    {
      localObject1 = ((CertifiedAccountRead.StGetCommentListRsp)paramArrayOfObject[3]).vecComment.get();
      if ((paramArrayOfObject.length < 6) || (paramArrayOfObject[5] == null) || (!(paramArrayOfObject[5] instanceof String))) {
        break label1207;
      }
    }
    label1207:
    for (paramArrayOfObject = this.jdField_b_of_type_Sci.a((List)localObject1, (String)paramArrayOfObject[5]);; paramArrayOfObject = (Object[])localObject1)
    {
      this.jdField_a_of_type_Sdv.c(paramArrayOfObject);
      beT();
      return;
    }
  }
  
  private void resetParams()
  {
    this.ayZ = false;
    this.aza = true;
  }
  
  private void rk(boolean paramBoolean)
  {
    int i = 1;
    QLog.d(TAG, 1, "loadFeedDisplay() isRefresh => " + paramBoolean);
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
      if ((this.jdField_a_of_type_Seb != null) && (this.uj != null)) {
        this.uj.setText(this.jdField_a_of_type_Seb.getText());
      }
      return;
      i = 0;
    }
  }
  
  private void uF(int paramInt)
  {
    if (this.mCommentContainer == null)
    {
      QLog.d(TAG, 1, "setCommentContainerVisible() mCommentContainer == null.");
      return;
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Sdv.px(e().poster.id.get());
    }
    this.mCommentContainer.setVisibility(paramInt);
  }
  
  protected View G()
  {
    return null;
  }
  
  protected void Hp() {}
  
  public boolean MA()
  {
    return (this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() == 0);
  }
  
  public boolean MB()
  {
    return (this.jdField_a_of_type_Seb != null) && (this.jdField_a_of_type_Seb.isShowing());
  }
  
  public void a(scw.b paramb)
  {
    this.jdField_a_of_type_Scw$b = paramb;
  }
  
  public void a(sdx paramsdx)
  {
    this.jdField_a_of_type_Sdx = paramsdx;
  }
  
  public void b(ViewStub paramViewStub)
  {
    this.t = paramViewStub;
  }
  
  public void beM()
  {
    if (this.t != null)
    {
      initLayout(this.t);
      this.t = null;
    }
    if ((lX() == null) && (this.retryTimes <= 3))
    {
      this.retryTimes += 1;
      a().getHandler().postDelayed(new CommentPresenter.9(this), this.retryTimes * 500);
    }
    CertifiedAccountMeta.StFeed localStFeed;
    String str;
    do
    {
      return;
      localStFeed = e();
      str = lX();
    } while (str == null);
    this.comments = a().t(str);
    if (this.axf)
    {
      this.axe = true;
      a().a(localStFeed, false);
      return;
    }
    if (this.comments == null)
    {
      this.axe = true;
      a().a(localStFeed, false);
      return;
    }
    awT();
  }
  
  public void biD()
  {
    if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() != 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Sdv != null) {
          this.jdField_a_of_type_Sdv.px(e().poster.id.get());
        }
        beM();
      }
      return;
    }
  }
  
  public void biE()
  {
    if ((this.mCommentContainer != null) && (this.mCommentContainer.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        beO();
      }
      return;
    }
  }
  
  public void c(CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply)
  {
    if (this.t != null)
    {
      initLayout(this.t);
      this.t = null;
    }
    if ((lX() == null) && (this.retryTimes <= 3))
    {
      this.retryTimes += 1;
      a().getHandler().postDelayed(new CommentPresenter.10(this, paramStComment, paramStReply), this.retryTimes * 500);
      return;
    }
    String str = lX();
    if ((!aqmr.isEmpty(str)) && (e() != null) && (e().vecComment.size() == 0) && (e().commentCount.get() != 0))
    {
      this.comments = a().t(str);
      if ((this.comments != null) && (!this.axf)) {
        break label168;
      }
      a().a(e(), false);
    }
    for (;;)
    {
      a(paramStComment, paramStReply, true, false);
      return;
      label168:
      beN();
    }
  }
  
  public boolean c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    return (paramStFeed != null) && (!TextUtils.isEmpty(paramStFeed.id.get()));
  }
  
  public void dE(View paramView)
  {
    a(null, null, true, false);
  }
  
  public void ec(View paramView)
  {
    a(null, null, true, true);
  }
  
  public int getPosition()
  {
    return 0;
  }
  
  protected int gn()
  {
    return 2131558873;
  }
  
  protected void initChildView()
  {
    Je();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public void l(CertifiedAccountMeta.StFeed paramStFeed)
  {
    m(paramStFeed);
    beL();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.ah)
    {
      if (this.mCommentContainer != null) {
        this.mCommentContainer.setVisibility(8);
      }
      if ((this.mActivity != null) && ((this.mActivity instanceof BaseActivity)) && (((BaseActivity)this.mActivity).mSystemBarComp != null)) {
        ((BaseActivity)this.mActivity).mSystemBarComp.setStatusBarMask(null);
      }
      this.ayY = false;
      if (this.jdField_a_of_type_Scw$b != null) {
        this.jdField_a_of_type_Scw$b.onDismiss();
      }
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
      QLog.d(TAG, 2, "mHideCommentListAnimation onAnimationStarttrue");
    }
    do
    {
      do
      {
        return;
      } while (paramAnimation != this.ai);
      if (this.jdField_a_of_type_Scw$b != null) {
        this.jdField_a_of_type_Scw$b.onShow();
      }
      QLog.d(TAG, 2, "mShowCommentListAnimation onAnimationStarttrue");
    } while ((this.mActivity == null) || (!(this.mActivity instanceof BaseActivity)) || (((BaseActivity)this.mActivity).mSystemBarComp == null));
    ((BaseActivity)this.mActivity).mSystemBarComp.setStatusBarMask(new PorterDuffColorFilter(getResources().getColor(2131167481), PorterDuff.Mode.SRC_ATOP));
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
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.getId();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
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
      dE(paramView);
      continue;
      ec(paramView);
    }
  }
  
  protected void onRecycle()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Scw$a);
    a().release();
    this.jdField_b_of_type_Sci = null;
    if (this.comments != null) {
      this.comments.clear();
    }
    this.fu.clear();
  }
  
  protected void onUpdateUI() {}
  
  public static class a
    extends QQUIEventReceiver<scw, sct>
  {
    public a(@NonNull scw paramscw)
    {
      super();
    }
    
    public void a(@NonNull scw paramscw, @NonNull sct paramsct)
    {
      switch (paramsct.bgK)
      {
      case 4: 
      case 5: 
      default: 
      case 1: 
      case 2: 
      case 3: 
        CertifiedAccountMeta.StFeed localStFeed;
        int i;
        do
        {
          do
          {
            do
            {
              return;
              paramscw.biD();
              return;
              paramscw.biE();
              return;
              scw.a(paramscw, false);
              scw.a(paramscw, null);
              scw.a(paramscw, null);
            } while (!(paramsct.params instanceof Object[]));
            paramsct = (Object[])paramsct.params;
          } while ((paramsct.length < 2) || (!(paramsct[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramsct[1] instanceof Integer)));
          localStFeed = (CertifiedAccountMeta.StFeed)paramsct[0];
          i = ((Integer)paramsct[1]).intValue();
        } while (!paramscw.c(localStFeed));
        scw.c(paramscw).put(Integer.valueOf(i), localStFeed);
        QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
        return;
      }
      scw.a(paramscw, (Object[])paramsct.params);
    }
    
    public Class acceptEventClass()
    {
      return sct.class;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  public static abstract interface c
  {
    public abstract void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString);
    
    public abstract void yk(int paramInt);
  }
  
  class d
    implements sdw
  {
    d() {}
    
    public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
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
                            } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StUser)));
                            paramView = (CertifiedAccountMeta.StUser)paramObject;
                          } while (paramView.type.get() != 1);
                          rzd.a(scw.a(scw.this), paramView);
                          return;
                        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                        paramView = (CertifiedAccountMeta.StComment)paramObject;
                        QLog.d(scw.TAG, 1, "click comment, feedId: " + scw.a(scw.this).id + " commentId: " + paramView.id);
                        scw.a(scw.this, paramView, null);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                      paramObject = (Object[])paramObject;
                    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                    QLog.d(scw.TAG, 1, "click reply, feedId: " + scw.a(scw.this).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                    scw.a(scw.this, paramView, paramObject);
                    return;
                  } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject;
                  scw.a(scw.this).b(paramView);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                paramView = (Object[])paramObject;
              } while ((paramView.length <= 1) || (paramView[0] == null));
              paramObject = (CertifiedAccountMeta.StComment)paramView[0];
              paramInt1 = scw.a(scw.this).a(paramObject);
            } while ((paramInt1 < 0) || (paramView[1] == null));
            int i = ((Integer)paramView[1]).intValue();
            scw.this.l.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
            return;
          } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
          paramView = (CertifiedAccountMeta.StComment)paramObject;
          scw.a(scw.this, scw.a(scw.this).a(scw.a(scw.this), paramView));
          scw.c(scw.this, true);
          return;
        } while ((paramObject == null) || (!(paramObject instanceof Object[])));
        paramView = (Object[])paramObject;
      } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
      paramObject = (CertifiedAccountMeta.StComment)paramView[0];
      scw.a(scw.this).a(scw.a(scw.this), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
      scw.c(scw.this, true);
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
          } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
          paramView = (CertifiedAccountMeta.StComment)paramObject;
          scw.a(scw.this, new sbx(scw.a(scw.this), false, true));
          scw.a(scw.this).addButton(scw.b(scw.this).getString(2131721060), 0, new sdd(this, paramView));
          if (scw.a(scw.this, paramView.postUser)) {
            scw.a(scw.this).addButton(scw.d(scw.this).getString(2131692498), 1, new sde(this, paramView));
          }
          for (;;)
          {
            scw.a(scw.this).sZ(scw.f(scw.this).getString(2131721058));
            scw.a(scw.this).show();
            return;
            scw.a(scw.this).addButton(scw.e(scw.this).getString(2131718824), 6, new sdf(this, paramView));
          }
        } while ((paramObject == null) || (!(paramObject instanceof Object[])));
        paramObject = (Object[])paramObject;
      } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
      paramView = (CertifiedAccountMeta.StComment)paramObject[0];
      paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
      scw.a(scw.this, new sbx(scw.g(scw.this), false, true));
      scw.a(scw.this).addButton(scw.h(scw.this).getString(2131721060), 0, new sdg(this, paramObject));
      if (scw.a(scw.this, paramObject.postUser)) {
        scw.a(scw.this).addButton(scw.j(scw.this).getString(2131692498), 1, new sdh(this, paramView, paramObject));
      }
      for (;;)
      {
        scw.a(scw.this).sZ(scw.l(scw.this).getString(2131721058));
        scw.a(scw.this).show();
        return;
        scw.a(scw.this).addButton(scw.k(scw.this).getString(2131718824), 6, new sdi(this, paramView, paramObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scw
 * JD-Core Version:    0.7.0.1
 */