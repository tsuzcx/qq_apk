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

public class oqb
  extends auwm<oqr, auwn<oqr>>
{
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private osf jdField_a_of_type_Osf;
  private osf b;
  private WSVerticalPageFragment c;
  private ole i;
  
  public oqb(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.c = paramWSVerticalPageFragment;
  }
  
  private boolean Hf()
  {
    return (this.c != null) && (TextUtils.equals(this.c.getFrom(), "follow_tab"));
  }
  
  private stSimpleMetaFeed a(oqr paramoqr)
  {
    if ((paramoqr != null) && ((paramoqr.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)paramoqr.B();
    }
    return null;
  }
  
  private void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, ole paramole)
  {
    if (Hf())
    {
      this.i = oie.a().a();
      if ((a(paramInt, paramstSimpleMetaFeed, this.i)) && (this.i.mVideoView != null) && (this.i.c != null))
      {
        paramole.c = this.i.c;
        paramole.mVideoView = this.i.mVideoView;
        paramole.jdField_a_of_type_Oll = this.i.jdField_a_of_type_Oll;
        paramole.c.setLoopback(false);
      }
    }
  }
  
  private void a(osf paramosf)
  {
    ooz.d("WSVerticalPageAdapterLog", "switchPlayerVideoViewLayout() holder: " + paramosf);
    this.jdField_a_of_type_Osf = paramosf;
    onf.h(this.jdField_a_of_type_Osf.b, false);
    osv.a(this.c.getFrom(), this.c.getPlayScene(), this.jdField_a_of_type_Osf.b);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_Osf.b, true);
  }
  
  private void a(osf paramosf, oqr paramoqr, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = a(paramoqr);
    paramoqr = paramosf.b;
    if (paramoqr == null) {
      paramoqr = new ole();
    }
    for (;;)
    {
      oli localoli = olg.a(localstSimpleMetaFeed);
      paramoqr.jdField_a_of_type_Oli = localoli;
      paramoqr.ci = paramosf.c();
      ola localola = paramosf.a;
      Object localObject = localola;
      if (localola == null) {
        localObject = new oqj();
      }
      ((oqj)localObject).e(paramosf);
      paramosf.a = ((ola)localObject);
      paramoqr.b = paramosf.a;
      if ((localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null)) {}
      for (paramoqr.bfl = localoli.rD();; paramoqr.bfl = localoli.rC())
      {
        paramoqr.mStartPosition = 0L;
        paramoqr.aqt = true;
        paramoqr.bfm = paramInt;
        paramoqr.aqb = "vertical_page";
        a(paramInt, localstSimpleMetaFeed, paramoqr);
        paramosf.b = paramoqr;
        return;
      }
    }
  }
  
  private boolean a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, ole paramole)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (paramstSimpleMetaFeed = paramstSimpleMetaFeed.id;; paramstSimpleMetaFeed = "")
    {
      String str = b(paramole);
      if ((this.c == null) || (this.c.rO() != paramInt + 1) || (TextUtils.isEmpty(str)) || (!TextUtils.equals(paramstSimpleMetaFeed, str)) || (!c(paramole))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private String b(ole paramole)
  {
    if ((paramole != null) && (paramole.jdField_a_of_type_Oli != null)) {
      return paramole.jdField_a_of_type_Oli.id;
    }
    return "";
  }
  
  private olh b(ole paramole)
  {
    if (paramole != null) {
      return paramole.c;
    }
    return null;
  }
  
  private void b(osf paramosf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.stop();
    this.jdField_a_of_type_Osf = paramosf;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(this.jdField_a_of_type_Osf.b, false);
  }
  
  private void bgd()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
    localWSVideoPreDownloadManager.a(new oqc(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(localWSVideoPreDownloadManager);
  }
  
  private void c(osf paramosf)
  {
    if ((paramosf == null) || (paramosf == this.jdField_a_of_type_Osf)) {}
    int j;
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Osf != null) && (paramosf.getLayoutPosition() < this.jdField_a_of_type_Osf.getLayoutPosition()))
        {
          ooz.e("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][tryPrePlayVideo] prePosition: " + paramosf.getLayoutPosition() + ", playingPosition:" + this.jdField_a_of_type_Osf.getLayoutPosition());
          return;
        }
        this.b = paramosf;
      } while ((this.jdField_a_of_type_Osf == null) || (this.jdField_a_of_type_Osf.b == null) || (this.jdField_a_of_type_Osf.b.c == null));
      j = this.jdField_a_of_type_Osf.b.c.qe();
      ooz.d("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() state:" + j + ", prePlayVideoHolder:" + paramosf);
    } while ((j == 0) || (j == 1) || (j == 2));
    ooz.d("WS_VIDEO_SCROLL", "WSVerticalPageAdapter tryPrePlayVideo() prePlayVideoHolder:" + paramosf);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.k(paramosf.b);
  }
  
  private boolean c(ole paramole)
  {
    boolean bool2 = false;
    paramole = b(paramole);
    boolean bool1 = bool2;
    if (paramole != null) {
      if (!paramole.isPlaying())
      {
        bool1 = bool2;
        if (!paramole.isPause()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void d(osf paramosf)
  {
    paramosf = paramosf.b;
    if ((paramosf != null) && ((paramosf.axG) || ((paramosf.c != null) && (paramosf.c.qe() != 0)))) {
      paramosf.axG = false;
    }
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public osf a()
  {
    return this.jdField_a_of_type_Osf;
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new opu(paramWSPlayerManager);
    paramWSPlayerManager.a(this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
    bgd();
  }
  
  public auwn<oqr> b(ViewGroup paramViewGroup, int paramInt)
  {
    return ore.a(paramViewGroup, paramInt, this.c);
  }
  
  public osf b()
  {
    return this.b;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ooz.i("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onPageSelected() currentPosition:" + paramInt + ", viewHolder:" + paramViewHolder);
    if ((paramViewHolder instanceof osf))
    {
      paramViewHolder = (osf)paramViewHolder;
      stSimpleMetaFeed localstSimpleMetaFeed = a((oqr)paramViewHolder.be);
      if ((!Hf()) || (!a(paramInt, localstSimpleMetaFeed, this.i))) {
        break label98;
      }
      a(paramViewHolder);
      oie.a().a(null);
    }
    for (;;)
    {
      this.i = null;
      return;
      label98:
      b(paramViewHolder);
    }
  }
  
  public void b(auwn<oqr> paramauwn)
  {
    super.onViewDetachedFromWindow(paramauwn);
    paramauwn.bey();
  }
  
  public void b(auwn<oqr> paramauwn, int paramInt)
  {
    ooz.d("WS_VIDEO_SCROLL", "WSVerticalPageAdapter onBindCustomViewHolder() position: " + paramInt + ", holder:" + paramauwn);
    oqr localoqr = (oqr)getItem(paramInt);
    if (localoqr != null)
    {
      paramauwn.P(localoqr);
      if (((paramauwn instanceof orc)) && (((orc)paramauwn).a != null)) {
        ((orc)paramauwn).a.setPosition(paramInt);
      }
      if ((paramauwn instanceof osf))
      {
        paramauwn = (osf)paramauwn;
        d(paramauwn);
        a(paramauwn, localoqr, paramInt);
        if (paramInt > 0) {
          c(paramauwn);
        }
      }
    }
  }
  
  public int dr(int paramInt)
  {
    Object localObject = (oqr)getItem(paramInt);
    if ((localObject != null) && ((((oqr)localObject).B() instanceof stSimpleMetaFeed)))
    {
      localObject = ((stSimpleMetaFeed)((oqr)localObject).B()).floatingLayerCardStyle;
      if (localObject != null) {
        return ((stFloatingLayerCardStyle)localObject).cardType;
      }
    }
    return 0;
  }
  
  public void dx(List<oqr> paramList)
  {
    List localList = be();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int k = paramRecyclerView.getChildCount();
    int j = 0;
    while (j < k)
    {
      orc localorc = (orc)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(j));
      if (localorc != null) {
        localorc.a.recycle();
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqb
 * JD-Core Version:    0.7.0.1
 */