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

public class urj
  extends blsv<usv, blsy<usv>>
{
  private int jdField_a_of_type_Int;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private ukz jdField_a_of_type_Ukz;
  private uuy jdField_a_of_type_Uuy;
  private uuy b;
  
  public urj(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(usv paramusv)
  {
    if ((paramusv != null) && ((paramusv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramusv.a();
    }
    return null;
  }
  
  private String a(ukz paramukz)
  {
    if ((paramukz != null) && (paramukz.jdField_a_of_type_Uld != null)) {
      return paramukz.jdField_a_of_type_Uld.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private ulc a(ukz paramukz)
  {
    if (paramukz != null) {
      return paramukz.jdField_a_of_type_Ulc;
    }
    return null;
  }
  
  private void a()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new urk(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, ukz paramukz)
  {
    if (c())
    {
      this.jdField_a_of_type_Ukz = ugl.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.jdField_a_of_type_Ukz)) && (this.jdField_a_of_type_Ukz.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc != null))
      {
        paramukz.jdField_a_of_type_Ulc = this.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc;
        paramukz.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Ukz.jdField_a_of_type_AndroidViewView;
        paramukz.jdField_a_of_type_Ulm = this.jdField_a_of_type_Ukz.jdField_a_of_type_Ulm;
        paramukz.jdField_a_of_type_Ulc.c(false);
      }
    }
  }
  
  private void a(uuy paramuuy)
  {
    uqf.b("WSVerticalPageAdapterLog", "switchPlayerVideoViewLayout() holder: " + paramuuy);
    this.jdField_a_of_type_Uuy = paramuuy;
    uns.a(this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz, false);
    unx.a(this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz, false);
    uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(false);
  }
  
  private void a(uuy paramuuy, usv paramusv, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramusv);
    paramusv = paramuuy.jdField_a_of_type_Ukz;
    if (paramusv == null) {
      paramusv = new ukz();
    }
    for (;;)
    {
      uld localuld = ulb.a(localstSimpleMetaFeed);
      paramusv.jdField_a_of_type_Uld = localuld;
      paramusv.jdField_a_of_type_AndroidViewViewGroup = paramuuy.a();
      ukp localukp = paramuuy.jdField_a_of_type_Ukp;
      Object localObject = localukp;
      if (localukp == null) {
        localObject = new usb();
      }
      ((usb)localObject).a(paramuuy);
      paramuuy.jdField_a_of_type_Ukp = ((ukp)localObject);
      paramusv.jdField_a_of_type_Ukp = paramuuy.jdField_a_of_type_Ukp;
      if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
      {
        paramusv.jdField_a_of_type_Int = localuld.b();
        paramusv.jdField_a_of_type_Long = 0L;
        paramusv.jdField_b_of_type_Boolean = true;
        paramusv.jdField_b_of_type_Int = paramInt;
        if (!TextUtils.equals(paramString, "aio_home_page")) {
          break label179;
        }
      }
      label179:
      for (paramString = "recommend_tab";; paramString = "vertical_page")
      {
        paramusv.jdField_a_of_type_JavaLangString = paramString;
        a(paramInt, localstSimpleMetaFeed, paramusv);
        paramuuy.jdField_a_of_type_Ukz = paramusv;
        return;
        paramusv.jdField_a_of_type_Int = localuld.a();
        break;
      }
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, ukz paramukz)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = a(paramukz);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!a(paramukz))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(ukz paramukz)
  {
    boolean bool2 = false;
    paramukz = a(paramukz);
    boolean bool1 = bool2;
    if (paramukz != null) {
      if (!paramukz.b())
      {
        bool1 = bool2;
        if (!paramukz.c()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(uuy paramuuy)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Uuy = paramuuy;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz, false);
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, this.jdField_a_of_type_Uuy.getLayoutPosition());
    uqf.a("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:" + this.jdField_a_of_type_Int + ", currentPosition():" + this.jdField_a_of_type_Uuy.getLayoutPosition());
  }
  
  private void c(uuy paramuuy)
  {
    if ((paramuuy == null) || (paramuuy == this.jdField_a_of_type_Uuy)) {}
    int i;
    do
    {
      do
      {
        return;
        this.b = paramuuy;
      } while ((this.jdField_a_of_type_Uuy == null) || (this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz == null) || (this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc == null));
      i = this.jdField_a_of_type_Uuy.jdField_a_of_type_Ukz.jdField_a_of_type_Ulc.e();
      uqf.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() state:" + i + ", prePlayVideoHolder:" + paramuuy);
    } while ((i == 0) || (i == 1) || (i == 2));
    uqf.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() prePlayVideoHolder:" + paramuuy);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramuuy.jdField_a_of_type_Ukz);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "follow_tab"));
  }
  
  private void d(uuy paramuuy)
  {
    paramuuy = paramuuy.jdField_a_of_type_Ukz;
    if ((paramuuy != null) && ((paramuuy.jdField_a_of_type_Boolean) || ((paramuuy.jdField_a_of_type_Ulc != null) && (paramuuy.jdField_a_of_type_Ulc.e() != 0)))) {
      paramuuy.jdField_a_of_type_Boolean = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    Object localObject = (usv)a(paramInt);
    if ((localObject != null) && ((((usv)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((stSimpleMetaFeed)((usv)localObject).a()).floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 0;
  }
  
  public blsy<usv> a(ViewGroup paramViewGroup, int paramInt)
  {
    return utu.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public usv a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = a();
    if ((localList != null) && (localList.size() > i)) {
      return (usv)localList.get(i);
    }
    return null;
  }
  
  public uuy a()
  {
    return this.jdField_a_of_type_Uuy;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    uqf.a("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onPageSelected() currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    if ((paramViewHolder instanceof uuy))
    {
      paramViewHolder = (uuy)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((usv)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((!c()) || (!a(paramInt, localstSimpleMetaFeed, this.jdField_a_of_type_Ukz))) {
        break label98;
      }
      a(paramViewHolder);
      ugl.a().a(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ukz = null;
      return;
      label98:
      b(paramViewHolder);
    }
  }
  
  public void a(blsy<usv> paramblsy)
  {
    super.onViewDetachedFromWindow(paramblsy);
    paramblsy.g();
  }
  
  public void a(blsy<usv> paramblsy, int paramInt)
  {
    uqf.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onBindCustomViewHolder() position: " + paramInt + ", holder:" + paramblsy);
    usv localusv = (usv)a(paramInt);
    if (localusv != null)
    {
      paramblsy.a(localusv);
      if (((paramblsy instanceof uts)) && (((uts)paramblsy).jdField_a_of_type_Uek != null)) {
        ((uts)paramblsy).jdField_a_of_type_Uek.a(paramInt);
      }
      if ((paramblsy instanceof uuy))
      {
        paramblsy = (uuy)paramblsy;
        d(paramblsy);
        a(paramblsy, localusv, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        if (paramInt > 0) {
          c(paramblsy);
        }
      }
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new urc(paramWSPlayerManager);
    paramWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    a();
  }
  
  public void a(List<usv> paramList)
  {
    List localList = a();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Uuy != null) && (this.jdField_a_of_type_Uuy.jdField_a_of_type_Uek != null) && ((this.jdField_a_of_type_Uuy.jdField_a_of_type_Uek instanceof utq)))
    {
      uej localuej = ((utq)this.jdField_a_of_type_Uuy.jdField_a_of_type_Uek).b();
      return ((localuej instanceof uuq)) && (((uuq)localuej).a());
    }
    return false;
  }
  
  public uuy b()
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
      uts localuts = (uts)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localuts != null) {
        localuts.jdField_a_of_type_Uek.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urj
 * JD-Core Version:    0.7.0.1
 */