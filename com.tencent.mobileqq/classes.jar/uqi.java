import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class uqi
  extends bkrs<uru, bkrv<uru>>
{
  private int jdField_a_of_type_Int;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private ukb jdField_a_of_type_Ukb;
  private utw jdField_a_of_type_Utw;
  private utw b;
  
  public uqi(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(uru paramuru)
  {
    if ((paramuru != null) && ((paramuru.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramuru.a();
    }
    return null;
  }
  
  private String a(ukb paramukb)
  {
    if ((paramukb != null) && (paramukb.jdField_a_of_type_Ukf != null)) {
      return paramukb.jdField_a_of_type_Ukf.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private uke a(ukb paramukb)
  {
    if (paramukb != null) {
      return paramukb.jdField_a_of_type_Uke;
    }
    return null;
  }
  
  private void a()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new uqj(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, ukb paramukb)
  {
    if (c())
    {
      this.jdField_a_of_type_Ukb = ugj.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.jdField_a_of_type_Ukb)) && (this.jdField_a_of_type_Ukb.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke != null))
      {
        paramukb.jdField_a_of_type_Uke = this.jdField_a_of_type_Ukb.jdField_a_of_type_Uke;
        paramukb.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Ukb.jdField_a_of_type_AndroidViewView;
        paramukb.jdField_a_of_type_Uko = this.jdField_a_of_type_Ukb.jdField_a_of_type_Uko;
        paramukb.jdField_a_of_type_Uke.c(false);
      }
    }
  }
  
  private void a(utw paramutw)
  {
    upe.b("WSVerticalPageAdapterLog", "switchPlayerVideoViewLayout() holder: " + paramutw);
    this.jdField_a_of_type_Utw = paramutw;
    umu.a(this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb, false);
    umw.a(this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb, false);
    uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb, true);
  }
  
  private void a(utw paramutw, uru paramuru, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramuru);
    paramuru = paramutw.jdField_a_of_type_Ukb;
    if (paramuru == null) {
      paramuru = new ukb();
    }
    for (;;)
    {
      ukf localukf = ukd.a(localstSimpleMetaFeed);
      paramuru.jdField_a_of_type_Ukf = localukf;
      paramuru.jdField_a_of_type_AndroidViewViewGroup = paramutw.a();
      ujv localujv = paramutw.jdField_a_of_type_Ujv;
      Object localObject = localujv;
      if (localujv == null) {
        localObject = new ura();
      }
      ((ura)localObject).a(paramutw);
      paramutw.jdField_a_of_type_Ujv = ((ujv)localObject);
      paramuru.jdField_a_of_type_Ujv = paramutw.jdField_a_of_type_Ujv;
      if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
      {
        paramuru.jdField_a_of_type_Int = localukf.b();
        paramuru.jdField_a_of_type_Long = 0L;
        paramuru.jdField_b_of_type_Boolean = true;
        paramuru.jdField_b_of_type_Int = paramInt;
        if (!TextUtils.equals(paramString, "aio_home_page")) {
          break label179;
        }
      }
      label179:
      for (paramString = "recommend_tab";; paramString = "vertical_page")
      {
        paramuru.jdField_a_of_type_JavaLangString = paramString;
        a(paramInt, localstSimpleMetaFeed, paramuru);
        paramutw.jdField_a_of_type_Ukb = paramuru;
        return;
        paramuru.jdField_a_of_type_Int = localukf.a();
        break;
      }
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, ukb paramukb)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = a(paramukb);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!a(paramukb))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(ukb paramukb)
  {
    boolean bool2 = false;
    paramukb = a(paramukb);
    boolean bool1 = bool2;
    if (paramukb != null) {
      if (!paramukb.b())
      {
        bool1 = bool2;
        if (!paramukb.c()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(utw paramutw)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Utw = paramutw;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb, false);
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, this.jdField_a_of_type_Utw.getLayoutPosition());
    upe.a("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:" + this.jdField_a_of_type_Int + ", currentPosition():" + this.jdField_a_of_type_Utw.getLayoutPosition());
  }
  
  private void c(utw paramutw)
  {
    if ((paramutw == null) || (paramutw == this.jdField_a_of_type_Utw)) {}
    int i;
    do
    {
      do
      {
        return;
        this.b = paramutw;
      } while ((this.jdField_a_of_type_Utw == null) || (this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb == null) || (this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb.jdField_a_of_type_Uke == null));
      i = this.jdField_a_of_type_Utw.jdField_a_of_type_Ukb.jdField_a_of_type_Uke.e();
      upe.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() state:" + i + ", prePlayVideoHolder:" + paramutw);
    } while ((i == 0) || (i == 1) || (i == 2));
    upe.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() prePlayVideoHolder:" + paramutw);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramutw.jdField_a_of_type_Ukb);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "follow_tab"));
  }
  
  private void d(utw paramutw)
  {
    paramutw = paramutw.jdField_a_of_type_Ukb;
    if ((paramutw != null) && ((paramutw.jdField_a_of_type_Boolean) || ((paramutw.jdField_a_of_type_Uke != null) && (paramutw.jdField_a_of_type_Uke.e() != 0)))) {
      paramutw.jdField_a_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    Object localObject = (uru)a(paramInt);
    if ((localObject != null) && ((((uru)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((stSimpleMetaFeed)((uru)localObject).a()).floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 0;
  }
  
  public bkrv<uru> a(ViewGroup paramViewGroup, int paramInt)
  {
    return ust.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public uru a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = a();
    if ((localList != null) && (localList.size() > i)) {
      return (uru)localList.get(i);
    }
    return null;
  }
  
  public utw a()
  {
    return this.jdField_a_of_type_Utw;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    upe.a("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onPageSelected() currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    if ((paramViewHolder instanceof utw))
    {
      paramViewHolder = (utw)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((uru)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((!c()) || (!a(paramInt, localstSimpleMetaFeed, this.jdField_a_of_type_Ukb))) {
        break label98;
      }
      a(paramViewHolder);
      ugj.a().a(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ukb = null;
      return;
      label98:
      b(paramViewHolder);
    }
  }
  
  public void a(bkrv<uru> parambkrv)
  {
    super.onViewDetachedFromWindow(parambkrv);
    parambkrv.c();
  }
  
  public void a(bkrv<uru> parambkrv, int paramInt)
  {
    upe.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onBindCustomViewHolder() position: " + paramInt + ", holder:" + parambkrv);
    uru localuru = (uru)a(paramInt);
    if (localuru != null)
    {
      parambkrv.a(localuru);
      if (((parambkrv instanceof usr)) && (((usr)parambkrv).jdField_a_of_type_Uei != null)) {
        ((usr)parambkrv).jdField_a_of_type_Uei.a(paramInt);
      }
      if ((parambkrv instanceof utw))
      {
        parambkrv = (utw)parambkrv;
        d(parambkrv);
        a(parambkrv, localuru, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        if (paramInt > 0) {
          c(parambkrv);
        }
      }
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new uqb(paramWSPlayerManager);
    paramWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    a();
  }
  
  public void a(List<uru> paramList)
  {
    List localList = a();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Utw != null) && (this.jdField_a_of_type_Utw.jdField_a_of_type_Uei != null) && ((this.jdField_a_of_type_Utw.jdField_a_of_type_Uei instanceof usp)))
    {
      ueh localueh = ((usp)this.jdField_a_of_type_Utw.jdField_a_of_type_Uei).b();
      return ((localueh instanceof uto)) && (((uto)localueh).a());
    }
    return false;
  }
  
  public utw b()
  {
    return this.b;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      usr localusr = (usr)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localusr != null) {
        localusr.jdField_a_of_type_Uei.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqi
 * JD-Core Version:    0.7.0.1
 */