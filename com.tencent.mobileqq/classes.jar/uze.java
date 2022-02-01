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

public class uze
  extends bjwv<vaq, bjwy<vaq>>
{
  private int jdField_a_of_type_Int;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private urt jdField_a_of_type_Urt;
  private vct jdField_a_of_type_Vct;
  private int jdField_b_of_type_Int;
  private vct jdField_b_of_type_Vct;
  
  public uze(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(vaq paramvaq)
  {
    if ((paramvaq != null) && ((paramvaq.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramvaq.a();
    }
    return null;
  }
  
  private String a(urt paramurt)
  {
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Urx != null)) {
      return paramurt.jdField_a_of_type_Urx.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private urw a(urt paramurt)
  {
    if (paramurt != null) {
      return paramurt.jdField_a_of_type_Urw;
    }
    return null;
  }
  
  private void a()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new uzf(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, urt paramurt)
  {
    if (d())
    {
      this.jdField_a_of_type_Urt = unc.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.jdField_a_of_type_Urt)) && (this.jdField_a_of_type_Urt.jdField_a_of_type_Usr != null) && (this.jdField_a_of_type_Urt.jdField_a_of_type_Urw != null))
      {
        paramurt.jdField_a_of_type_Urw = this.jdField_a_of_type_Urt.jdField_a_of_type_Urw;
        paramurt.jdField_a_of_type_Usr = this.jdField_a_of_type_Urt.jdField_a_of_type_Usr;
        paramurt.jdField_a_of_type_Usf = this.jdField_a_of_type_Urt.jdField_a_of_type_Usf;
        paramurt.jdField_a_of_type_Urw.c(false);
      }
    }
  }
  
  private void a(vct paramvct)
  {
    uya.b("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][switchPlayerVideoViewLayout] holder: " + paramvct);
    this.jdField_a_of_type_Vct = paramvct;
    uvr.a(this.jdField_a_of_type_Vct.jdField_a_of_type_Urt, false);
    vdq.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_Vct.jdField_a_of_type_Urt);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_Vct.jdField_a_of_type_Urt, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(false);
  }
  
  private void a(vct paramvct, vaq paramvaq, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramvaq);
    paramvaq = paramvct.jdField_a_of_type_Urt;
    if (paramvaq == null) {
      paramvaq = new urt();
    }
    for (;;)
    {
      urx localurx = urv.a(localstSimpleMetaFeed);
      paramvaq.jdField_a_of_type_Urx = localurx;
      paramvaq.jdField_a_of_type_AndroidViewViewGroup = paramvct.a();
      urk localurk = paramvct.jdField_a_of_type_Urk;
      Object localObject = localurk;
      if (localurk == null) {
        localObject = new uzw();
      }
      ((uzw)localObject).a(paramvct);
      paramvct.jdField_a_of_type_Urk = ((urk)localObject);
      paramvaq.jdField_a_of_type_Urk = paramvct.jdField_a_of_type_Urk;
      if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
      {
        paramvaq.jdField_a_of_type_Int = localurx.b();
        paramvaq.jdField_a_of_type_Long = 0L;
        paramvaq.jdField_b_of_type_Boolean = true;
        paramvaq.jdField_b_of_type_Int = paramInt;
        if (!TextUtils.equals(paramString, "aio_home_page")) {
          break label179;
        }
      }
      label179:
      for (paramString = "recommend_tab";; paramString = "vertical_page")
      {
        paramvaq.jdField_a_of_type_JavaLangString = paramString;
        a(paramInt, localstSimpleMetaFeed, paramvaq);
        paramvct.jdField_a_of_type_Urt = paramvaq;
        return;
        paramvaq.jdField_a_of_type_Int = localurx.a();
        break;
      }
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, urt paramurt)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = a(paramurt);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!a(paramurt))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(urt paramurt)
  {
    boolean bool2 = false;
    paramurt = a(paramurt);
    boolean bool1 = bool2;
    if (paramurt != null) {
      if (!paramurt.b())
      {
        bool1 = bool2;
        if (!paramurt.c()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(vct paramvct)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Vct = paramvct;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_Vct.jdField_a_of_type_Urt, false);
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, this.jdField_a_of_type_Vct.getLayoutPosition());
    uya.a("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:" + this.jdField_a_of_type_Int + ", currentPosition():" + this.jdField_a_of_type_Vct.getLayoutPosition());
  }
  
  private void c(vct paramvct)
  {
    if ((paramvct == null) || (paramvct == this.jdField_a_of_type_Vct)) {}
    int i;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Vct = paramvct;
      } while ((this.jdField_a_of_type_Vct == null) || (this.jdField_a_of_type_Vct.jdField_a_of_type_Urt == null) || (this.jdField_a_of_type_Vct.jdField_a_of_type_Urt.jdField_a_of_type_Urw == null));
      i = this.jdField_a_of_type_Vct.jdField_a_of_type_Urt.jdField_a_of_type_Urw.e();
      uya.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] state:" + i + ", prePlayVideoHolder:" + paramvct);
    } while ((i == 0) || (i == 1) || (i == 2));
    uya.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + paramvct);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramvct.jdField_a_of_type_Urt);
  }
  
  private void d(vct paramvct)
  {
    paramvct = paramvct.jdField_a_of_type_Urt;
    if ((paramvct != null) && ((paramvct.jdField_a_of_type_Boolean) || ((paramvct.jdField_a_of_type_Urw != null) && (paramvct.jdField_a_of_type_Urw.e() != 0)))) {
      paramvct.jdField_a_of_type_Boolean = false;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "follow_tab"));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    Object localObject = (vaq)a(paramInt);
    if ((localObject != null) && ((((vaq)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((stSimpleMetaFeed)((vaq)localObject).a()).floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 0;
  }
  
  public bjwy<vaq> a(ViewGroup paramViewGroup, int paramInt)
  {
    return vbp.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public vaq a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = a();
    if ((localList != null) && (localList.size() > i)) {
      return (vaq)localList.get(i);
    }
    return null;
  }
  
  public vct a()
  {
    return this.jdField_a_of_type_Vct;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    uya.a("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onPageSelected] currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    this.jdField_b_of_type_Int = paramInt;
    if ((paramViewHolder instanceof vct))
    {
      paramViewHolder = (vct)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((vaq)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((!d()) || (!a(paramInt, localstSimpleMetaFeed, this.jdField_a_of_type_Urt))) {
        break label103;
      }
      a(paramViewHolder);
      unc.a().a(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Urt = null;
      return;
      label103:
      b(paramViewHolder);
    }
  }
  
  public void a(bjwy<vaq> parambjwy)
  {
    super.onViewDetachedFromWindow(parambjwy);
    parambjwy.g();
  }
  
  public void a(bjwy<vaq> parambjwy, int paramInt)
  {
    uya.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onBindCustomViewHolder] position: " + paramInt + ", holder:" + parambjwy);
    vaq localvaq = (vaq)a(paramInt);
    if (localvaq != null)
    {
      parambjwy.a(localvaq);
      if (((parambjwy instanceof vbn)) && (((vbn)parambjwy).jdField_a_of_type_Ula != null)) {
        ((vbn)parambjwy).jdField_a_of_type_Ula.a(paramInt);
      }
      if ((parambjwy instanceof vct))
      {
        parambjwy = (vct)parambjwy;
        d(parambjwy);
        a(parambjwy, localvaq, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        if (paramInt > 0) {
          c(parambjwy);
        }
      }
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new uyx(paramWSPlayerManager);
    paramWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    a();
  }
  
  public void a(List<vaq> paramList)
  {
    List localList = a();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Vct != null) && (this.jdField_a_of_type_Vct.jdField_a_of_type_Ula != null) && ((this.jdField_a_of_type_Vct.jdField_a_of_type_Ula instanceof vbl)))
    {
      ukz localukz = ((vbl)this.jdField_a_of_type_Vct.jdField_a_of_type_Ula).b();
      return ((localukz instanceof vcl)) && (((vcl)localukz).a());
    }
    return false;
  }
  
  public vct b()
  {
    return this.jdField_b_of_type_Vct;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 0;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      vbn localvbn = (vbn)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localvbn != null) {
        localvbn.jdField_a_of_type_Ula.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uze
 * JD-Core Version:    0.7.0.1
 */