import UserGrowth.stFeed;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import java.util.List;

public class oey
  extends auwm<stFeed, auwn<stFeed>>
{
  public WSFollowFragment a;
  private WSPlayerManager a;
  public ojm a;
  private ojm b;
  
  public oey(WSFollowFragment paramWSFollowFragment)
  {
    super(paramWSFollowFragment.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment = paramWSFollowFragment;
  }
  
  private String a(ojm paramojm)
  {
    if (paramojm == null) {
      return "WSPlayableHolder is null.";
    }
    if (paramojm.b == null) {
      return "WSPlayableHolder.mPlayerParam is null.";
    }
    if (paramojm.b.jdField_a_of_type_Oli == null) {
      return "WSPlayableHolder.mPlayerParam.mVideoInfo is null.";
    }
    return paramojm.b.jdField_a_of_type_Oli.mTitle;
  }
  
  public WSFollowFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public void a(auwn<stFeed> paramauwn)
  {
    ooz.d("WSFollowAdapter", "[WSFollowAdapter.java][onViewAttachedToWindow] holder: " + paramauwn);
    if (((paramauwn instanceof oiy)) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getUserVisibleHint())) {
      ((oiy)paramauwn).aCG();
    }
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    paramWSPlayerManager = new olt(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramWSPlayerManager);
  }
  
  public void a(ojm paramojm)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.stop();
    this.jdField_a_of_type_Ojm = paramojm;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.c(paramojm.b, false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.qQ(true);
    oie.a().a(paramojm.b);
  }
  
  public auwn<stFeed> b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = ojf.a(paramInt, paramViewGroup, this);
    ooz.i("WSFollowContinuePlayLog", "===> WSFollowAdapter onCreateCustomViewHolder viewHolder:" + paramViewGroup);
    return paramViewGroup;
  }
  
  public void b(auwn<stFeed> paramauwn)
  {
    super.onViewDetachedFromWindow(paramauwn);
    if ((paramauwn instanceof oiy)) {
      ((oiy)paramauwn).bey();
    }
  }
  
  public void b(auwn<stFeed> paramauwn, int paramInt)
  {
    stFeed localstFeed = (stFeed)getItem(paramInt);
    if (localstFeed == null) {}
    do
    {
      return;
      if ((paramauwn instanceof oiy))
      {
        paramauwn.P(localstFeed);
        oiy localoiy = (oiy)paramauwn;
        localoiy.jdField_a_of_type_Oli = olg.a(localstFeed.feed);
        oie.a().d(localoiy);
        localoiy.jdField_a_of_type_Ola = oie.a().a(localoiy);
        localoiy.b = oie.a().a(localoiy, 0L, paramInt);
        ooz.i("WSFollowContinuePlayLog", "===> WSFollowAdapter onBindCustomViewHolder1 holder:" + paramauwn);
        ooz.i("WSFollowContinuePlayLog", "===> WSFollowAdapter onBindCustomViewHolder2 position:" + paramInt + ", title: " + localoiy.jdField_a_of_type_Oli.mTitle);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.c(localoiy);
        return;
      }
    } while (!(paramauwn instanceof ojg));
    ((ojg)paramauwn).a(localstFeed);
  }
  
  public void b(ojm paramojm)
  {
    this.b = paramojm;
    ooz.bY("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][setPrePlayingHolder]\nplayingTitle:" + a(this.jdField_a_of_type_Ojm) + "\nprePlayTitle:" + a(this.b) + "\nPlayingHolder:" + this.jdField_a_of_type_Ojm + "\nPrePlayHolder:" + this.b);
  }
  
  public void bdY()
  {
    ojm localojm = this.b;
    if ((localojm == null) || (localojm == this.jdField_a_of_type_Ojm)) {
      ooz.e("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + localojm);
    }
    int i;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Ojm == null) || (this.jdField_a_of_type_Ojm.b == null) || (this.jdField_a_of_type_Ojm.b.c == null));
      i = this.jdField_a_of_type_Ojm.b.c.qe();
      ooz.bY("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] playingPlayerState:" + i + ", prePlayVideoHolder:" + localojm);
    } while ((i == 0) || (i == 1) || (i == 2));
    ooz.i("WS_VIDEO_PRE_PLAY", "[WSFollowAdapter.java][tryPrePlayVideo] goto prePlayVideo prePlayVideoHolder:" + localojm);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.k(localojm.b);
  }
  
  public int dr(int paramInt)
  {
    Object localObject = be();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (stFeed)((List)localObject).get(paramInt);
      if (localObject != null) {
        return ((stFeed)localObject).feed_type;
      }
    }
    return 2;
  }
  
  public Activity getActivity()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSFollowFragment.getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oey
 * JD-Core Version:    0.7.0.1
 */