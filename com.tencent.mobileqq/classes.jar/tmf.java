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

public class tmf
  extends bhzz<tmv, biac<tmv>>
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private thl jdField_a_of_type_Thl;
  private tnj jdField_a_of_type_Tnj;
  private tnj b;
  
  public tmf(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  private stSimpleMetaFeed a(tmv paramtmv)
  {
    if ((paramtmv != null) && ((paramtmv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramtmv.a();
    }
    return null;
  }
  
  private String a(thl paramthl)
  {
    if ((paramthl != null) && (paramthl.jdField_a_of_type_Thp != null)) {
      return paramthl.jdField_a_of_type_Thp.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private tho a(thl paramthl)
  {
    if (paramthl != null) {
      return paramthl.jdField_a_of_type_Tho;
    }
    return null;
  }
  
  private void a()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new tmg(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, thl paramthl)
  {
    if (b())
    {
      this.jdField_a_of_type_Thl = tel.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.jdField_a_of_type_Thl)) && (this.jdField_a_of_type_Thl.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Thl.jdField_a_of_type_Tho != null))
      {
        paramthl.jdField_a_of_type_Tho = this.jdField_a_of_type_Thl.jdField_a_of_type_Tho;
        paramthl.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Thl.jdField_a_of_type_AndroidViewView;
        paramthl.jdField_a_of_type_Thy = this.jdField_a_of_type_Thl.jdField_a_of_type_Thy;
        paramthl.jdField_a_of_type_Tho.c(false);
      }
    }
  }
  
  private void a(tnj paramtnj)
  {
    tlo.b("WSVerticalPageAdapterLog", "switchPlayerVideoViewLayout() holder: " + paramtnj);
    this.jdField_a_of_type_Tnj = paramtnj;
    tjt.a(this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl, false);
    tnt.a(this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl, true);
  }
  
  private void a(tnj paramtnj, tmv paramtmv, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramtmv);
    paramtmv = paramtnj.jdField_a_of_type_Thl;
    if (paramtmv == null) {
      paramtmv = new thl();
    }
    for (;;)
    {
      thp localthp = thn.a(localstSimpleMetaFeed);
      paramtmv.jdField_a_of_type_Thp = localthp;
      tnk localtnk = (tnk)paramtnj.jdField_a_of_type_Tcl;
      paramtmv.jdField_a_of_type_AndroidViewViewGroup = localtnk.a().a();
      thf localthf = paramtnj.jdField_a_of_type_Thf;
      Object localObject = localthf;
      if (localthf == null) {
        localObject = new tmm();
      }
      ((tmm)localObject).a(localtnk);
      paramtnj.jdField_a_of_type_Thf = ((thf)localObject);
      paramtmv.jdField_a_of_type_Thf = paramtnj.jdField_a_of_type_Thf;
      paramtmv.jdField_a_of_type_Int = localthp.a();
      paramtmv.jdField_a_of_type_Long = 0L;
      paramtmv.jdField_b_of_type_Boolean = true;
      paramtmv.jdField_b_of_type_Int = paramInt;
      paramtmv.jdField_a_of_type_JavaLangString = "vertical_page";
      a(paramInt, localstSimpleMetaFeed, paramtmv);
      paramtnj.jdField_a_of_type_Thl = paramtmv;
      return;
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, thl paramthl)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = a(paramthl);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!a(paramthl))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(thl paramthl)
  {
    boolean bool2 = false;
    paramthl = a(paramthl);
    boolean bool1 = bool2;
    if (paramthl != null) {
      if (!paramthl.b())
      {
        bool1 = bool2;
        if (!paramthl.c()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(tnj paramtnj)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
    this.jdField_a_of_type_Tnj = paramtnj;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl, false);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), "follow_tab"));
  }
  
  private void c(tnj paramtnj)
  {
    if ((paramtnj == null) || (paramtnj == this.jdField_a_of_type_Tnj)) {}
    int i;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Tnj != null) && (paramtnj.getLayoutPosition() < this.jdField_a_of_type_Tnj.getLayoutPosition()))
        {
          tlo.d("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][tryPrePlayVideo] prePosition: " + paramtnj.getLayoutPosition() + ", playingPosition:" + this.jdField_a_of_type_Tnj.getLayoutPosition());
          return;
        }
        this.b = paramtnj;
      } while ((this.jdField_a_of_type_Tnj == null) || (this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl == null) || (this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl.jdField_a_of_type_Tho == null));
      i = this.jdField_a_of_type_Tnj.jdField_a_of_type_Thl.jdField_a_of_type_Tho.e();
      tlo.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() state:" + i + ", prePlayVideoHolder:" + paramtnj);
    } while ((i == 0) || (i == 1) || (i == 2));
    tlo.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() prePlayVideoHolder:" + paramtnj);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramtnj.jdField_a_of_type_Thl);
  }
  
  private void d(tnj paramtnj)
  {
    paramtnj = paramtnj.jdField_a_of_type_Thl;
    if ((paramtnj != null) && ((paramtnj.jdField_a_of_type_Boolean) || ((paramtnj.jdField_a_of_type_Tho != null) && (paramtnj.jdField_a_of_type_Tho.e() != 0)))) {
      paramtnj.jdField_a_of_type_Boolean = false;
    }
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public biac<tmv> a(ViewGroup paramViewGroup, int paramInt)
  {
    return new tnj(paramViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public tnj a()
  {
    return this.jdField_a_of_type_Tnj;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    tlo.a("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onPageSelected() currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    if ((paramViewHolder instanceof tnj))
    {
      paramViewHolder = (tnj)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((tmv)paramViewHolder.jdField_a_of_type_JavaLangObject);
      if ((!b()) || (!a(paramInt, localstSimpleMetaFeed, this.jdField_a_of_type_Thl))) {
        break label97;
      }
      a(paramViewHolder);
      tel.a().a(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Thl = null;
      return;
      label97:
      b(paramViewHolder);
    }
  }
  
  public void a(biac<tmv> parambiac)
  {
    super.onViewDetachedFromWindow(parambiac);
    parambiac.c();
  }
  
  public void a(biac<tmv> parambiac, int paramInt)
  {
    tlo.b("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onBindCustomViewHolder() position: " + paramInt + ", holder:" + parambiac);
    tmv localtmv = (tmv)a(paramInt);
    if (localtmv != null)
    {
      parambiac.a(localtmv);
      if ((parambiac instanceof tmw)) {
        ((tmw)parambiac).jdField_a_of_type_Tcl.a(paramInt);
      }
      if ((parambiac instanceof tnj))
      {
        parambiac = (tnj)parambiac;
        d(parambiac);
        a(parambiac, localtmv, paramInt);
        if (paramInt > 0) {
          c(parambiac);
        }
      }
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new tmd(paramWSPlayerManager);
    paramWSPlayerManager.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    a();
  }
  
  public void a(List<tmv> paramList)
  {
    List localList = a();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public tnj b()
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
      tmw localtmw = (tmw)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localtmw != null) {
        localtmw.jdField_a_of_type_Tcl.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmf
 * JD-Core Version:    0.7.0.1
 */