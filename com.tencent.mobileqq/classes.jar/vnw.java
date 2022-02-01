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

public class vnw
  extends blig<vpj, blij<vpj>>
{
  private int jdField_a_of_type_Int;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private vgb jdField_a_of_type_Vgb;
  private vrn jdField_a_of_type_Vrn;
  private int jdField_b_of_type_Int;
  private vrn jdField_b_of_type_Vrn;
  
  public vnw(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(vpj paramvpj)
  {
    if ((paramvpj != null) && ((paramvpj.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramvpj.a();
    }
    return null;
  }
  
  private String a(vgb paramvgb)
  {
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vgi != null)) {
      return paramvgb.jdField_a_of_type_Vgi.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private vgh a(vgb paramvgb)
  {
    if (paramvgb != null) {
      return paramvgb.jdField_a_of_type_Vgh;
    }
    return null;
  }
  
  private void a()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new vnx(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, vgb paramvgb)
  {
    if (d())
    {
      this.jdField_a_of_type_Vgb = vbc.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.jdField_a_of_type_Vgb)) && (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vhc != null) && (this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh != null))
      {
        paramvgb.jdField_a_of_type_Vgh = this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh;
        paramvgb.jdField_a_of_type_Vhc = this.jdField_a_of_type_Vgb.jdField_a_of_type_Vhc;
        paramvgb.jdField_a_of_type_Vgq = this.jdField_a_of_type_Vgb.jdField_a_of_type_Vgq;
        paramvgb.jdField_a_of_type_Vgh.c(false);
      }
    }
  }
  
  private void a(vrn paramvrn)
  {
    vmp.b("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][switchPlayerVideoViewLayout] holder: " + paramvrn);
    this.jdField_a_of_type_Vrn = paramvrn;
    vkf.a(this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb, false);
    vsj.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(false);
  }
  
  private void a(vrn paramvrn, vpj paramvpj, int paramInt, String paramString)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramvpj);
    paramvpj = paramvrn.jdField_a_of_type_Vgb;
    if (paramvpj == null) {
      paramvpj = new vgb();
    }
    for (;;)
    {
      paramvpj.jdField_a_of_type_Vgi = vgd.a(localstSimpleMetaFeed);
      paramvpj.jdField_a_of_type_AndroidViewViewGroup = paramvrn.a();
      vfs localvfs = paramvrn.jdField_a_of_type_Vfs;
      Object localObject = localvfs;
      if (localvfs == null) {
        localObject = new voo();
      }
      ((voo)localObject).a(paramvrn);
      paramvrn.jdField_a_of_type_Vfs = ((vfs)localObject);
      paramvpj.jdField_a_of_type_Vfs = paramvrn.jdField_a_of_type_Vfs;
      paramvpj.jdField_a_of_type_Int = paramvrn.b(localstSimpleMetaFeed);
      paramvpj.jdField_a_of_type_Long = 0L;
      paramvpj.jdField_b_of_type_Boolean = true;
      paramvpj.jdField_b_of_type_Int = paramInt;
      if (TextUtils.equals(paramString, "aio_home_page")) {}
      for (paramString = "recommend_tab";; paramString = "vertical_page")
      {
        paramvpj.jdField_a_of_type_JavaLangString = paramString;
        a(paramInt, localstSimpleMetaFeed, paramvpj);
        paramvrn.jdField_a_of_type_Vgb = paramvpj;
        return;
      }
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, vgb paramvgb)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = a(paramvgb);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!a(paramvgb))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(vgb paramvgb)
  {
    boolean bool2 = false;
    paramvgb = a(paramvgb);
    boolean bool1 = bool2;
    if (paramvgb != null) {
      if (!paramvgb.b())
      {
        bool1 = bool2;
        if (!paramvgb.c()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(vrn paramvrn)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Vrn = paramvrn;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb, false);
    this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, this.jdField_a_of_type_Vrn.getLayoutPosition());
    vmp.a("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:" + this.jdField_a_of_type_Int + ", currentPosition():" + this.jdField_a_of_type_Vrn.getLayoutPosition());
  }
  
  private void c(vrn paramvrn)
  {
    if ((paramvrn == null) || (paramvrn == this.jdField_a_of_type_Vrn)) {}
    int i;
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Vrn = paramvrn;
      } while ((this.jdField_a_of_type_Vrn == null) || (this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb == null) || (this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh == null));
      i = this.jdField_a_of_type_Vrn.jdField_a_of_type_Vgb.jdField_a_of_type_Vgh.e();
      vmp.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] state:" + i + ", prePlayVideoHolder:" + paramvrn);
    } while ((i == 0) || (i == 1) || (i == 2));
    vmp.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + paramvrn);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramvrn.jdField_a_of_type_Vgb);
  }
  
  private void d(vrn paramvrn)
  {
    paramvrn = paramvrn.jdField_a_of_type_Vgb;
    if ((paramvrn != null) && ((paramvrn.jdField_a_of_type_Boolean) || ((paramvrn.jdField_a_of_type_Vgh != null) && (paramvrn.jdField_a_of_type_Vgh.e() != 0)))) {
      paramvrn.jdField_a_of_type_Boolean = false;
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
    Object localObject = (vpj)a(paramInt);
    if ((localObject != null) && ((((vpj)localObject).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((stSimpleMetaFeed)((vpj)localObject).a()).floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 3;
  }
  
  public blij<vpj> a(ViewGroup paramViewGroup, int paramInt)
  {
    return vqi.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public List<vpj> a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = b();
    if ((localList != null) && (localList.size() > i)) {
      return localList.subList(i, localList.size());
    }
    return null;
  }
  
  public vpj a()
  {
    int i = this.jdField_a_of_type_Int;
    List localList = b();
    if ((localList != null) && (localList.size() > i)) {
      return (vpj)localList.get(i);
    }
    return null;
  }
  
  public vrn a()
  {
    return this.jdField_a_of_type_Vrn;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    vmp.a("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onPageSelected] currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    this.jdField_b_of_type_Int = paramInt;
    if ((paramViewHolder instanceof vrn))
    {
      paramViewHolder = (vrn)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((vpj)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((!d()) || (!a(paramInt, localstSimpleMetaFeed, this.jdField_a_of_type_Vgb))) {
        break label102;
      }
      a(paramViewHolder);
      vbc.a().a(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vgb = null;
      return;
      label102:
      b(paramViewHolder);
    }
  }
  
  public void a(blij<vpj> paramblij)
  {
    super.onViewDetachedFromWindow(paramblij);
    paramblij.h();
  }
  
  public void a(blij<vpj> paramblij, int paramInt)
  {
    vmp.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onBindCustomViewHolder] position: " + paramInt + ", holder:" + paramblij);
    Object localObject = (vpj)a(paramInt);
    if (localObject != null)
    {
      paramblij.a(localObject);
      if (((paramblij instanceof vqg)) && (((vqg)paramblij).jdField_a_of_type_Uyx != null)) {
        ((vqg)paramblij).jdField_a_of_type_Uyx.a(paramInt);
      }
      if ((paramblij instanceof vrn))
      {
        vrn localvrn = (vrn)paramblij;
        d(localvrn);
        a(localvrn, (vpj)localObject, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
        if (paramInt > 0) {
          c(localvrn);
        }
      }
      localObject = (voh)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      if (localObject != null) {
        ((voh)localObject).a(paramblij, paramInt);
      }
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new vnp(paramWSPlayerManager);
    paramWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    a();
  }
  
  public void a(List<vpj> paramList)
  {
    List localList = b();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Vrn != null) && (this.jdField_a_of_type_Vrn.jdField_a_of_type_Uyx != null) && ((this.jdField_a_of_type_Vrn.jdField_a_of_type_Uyx instanceof vqe)))
    {
      uyw localuyw = ((vqe)this.jdField_a_of_type_Vrn.jdField_a_of_type_Uyx).b();
      return ((localuyw instanceof vrf)) && (((vrf)localuyw).a());
    }
    return false;
  }
  
  public vrn b()
  {
    return this.jdField_b_of_type_Vrn;
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
      vqg localvqg = (vqg)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localvqg != null) {
        localvqg.jdField_a_of_type_Uyx.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */