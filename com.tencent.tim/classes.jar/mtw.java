import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.a;
import com.tencent.qphone.base.util.QLog;

public class mtw
  implements VideoFeedsRecyclerView.a
{
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private mtw.a jdField_a_of_type_Mtw$a;
  private naf jdField_a_of_type_Naf;
  private int aUz;
  private boolean aou;
  private ViewGroup bB;
  private VideoInfo jdField_c_of_type_ComTencentBizPubaccountVideoInfo;
  private ReadInJoyCommentListFragment jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private ViewGroup.LayoutParams d;
  private AnimationSet e;
  private FragmentActivity mActivity;
  private FragmentManager mFragmentManager;
  private boolean mIsVisible;
  private TranslateAnimation t;
  
  public mtw(FragmentActivity paramFragmentActivity, FragmentManager paramFragmentManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, naf paramnaf, VideoFeedsPlayManager paramVideoFeedsPlayManager, ViewGroup paramViewGroup)
  {
    this.mActivity = paramFragmentActivity;
    this.mFragmentManager = paramFragmentManager;
    this.bB = paramViewGroup;
    if (paramVideoFeedsRecyclerView != null) {
      paramVideoFeedsRecyclerView.a(this);
    }
    this.jdField_a_of_type_Naf = paramnaf;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.e = ((AnimationSet)AnimationUtils.loadAnimation(this.mActivity, 2130772128));
    if (this.e != null)
    {
      this.e.setDuration(200L);
      this.e.setInterpolator(new LinearInterpolator());
    }
    this.t = ((TranslateAnimation)AnimationUtils.loadAnimation(this.mActivity, 2130772013));
    if (this.t != null)
    {
      this.t.setAnimationListener(new mtx(this));
      this.t.setDuration(300L);
      this.t.setInterpolator(new LinearInterpolator());
    }
  }
  
  private void aSl()
  {
    try
    {
      this.mActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new mtz(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("adjustSystemUiVisibility", 1, localException.toString());
      localException.printStackTrace();
    }
  }
  
  public boolean El()
  {
    return this.mIsVisible;
  }
  
  public boolean Em()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.k(this.mActivity);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bB.setVisibility(8);
      if (this.mIsVisible) {
        this.aou = true;
      }
    }
    while (!this.aou) {
      return;
    }
    this.aou = false;
    this.bB.setVisibility(0);
  }
  
  public void a(mtw.a parama)
  {
    this.jdField_a_of_type_Mtw$a = parama;
  }
  
  public void aKA()
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(mwl.a());
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.pB(2);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new mty(this), this.bB);
      localObject = this.mFragmentManager.beginTransaction();
      ((FragmentTransaction)localObject).add(2131365045, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void aSa() {}
  
  public void aSg()
  {
    if (this.d != null)
    {
      this.d.height = (muj.m(this.mActivity) - this.aUz);
      this.bB.setLayoutParams(this.d);
    }
  }
  
  public void aSh()
  {
    b(null);
  }
  
  public void aSi()
  {
    if (this.mIsVisible)
    {
      if ((this.bB.getVisibility() == 0) && (this.t != null)) {
        this.bB.startAnimation(this.t);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.setLoopback(false);
      }
      this.mIsVisible = false;
      if (this.jdField_a_of_type_Mtw$a != null) {
        this.jdField_a_of_type_Mtw$a.aJ(false);
      }
    }
  }
  
  public void aSj()
  {
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.articleInfo != null))
    {
      aSh();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.aGG();
    }
  }
  
  public void aSk()
  {
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (!this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onBackPress())) {
      aSi();
    }
  }
  
  public void b(AnchorData paramAnchorData)
  {
    ArticleInfo localArticleInfo;
    if ((!this.mIsVisible) && (this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.articleInfo != null))
    {
      aSg();
      if (this.e != null) {
        this.bB.startAnimation(this.e);
      }
      muj.a(this.bB, 0, 100);
      localArticleInfo = this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.articleInfo;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
      {
        Fragment localFragment = this.mFragmentManager.findFragmentById(2131365045);
        if ((localFragment instanceof ReadInJoyCommentListFragment)) {
          this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localFragment);
        }
      }
      if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (localArticleInfo != null)) {
        if (this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo.b == null) {
          break label182;
        }
      }
    }
    label182:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(localArticleInfo, paramAnchorData, bool, 2);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (aqiw.isWifiConnected(this.mActivity))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.setLoopback(true);
      }
      this.mIsVisible = true;
      if (this.jdField_a_of_type_Mtw$a != null) {
        this.jdField_a_of_type_Mtw$a.aJ(true);
      }
      return;
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void initUI()
  {
    this.d = this.bB.getLayoutParams();
    this.d.height = (muj.m(this.mActivity) - this.aUz);
    this.bB.setLayoutParams(this.d);
    this.bB.setOnClickListener(null);
    aKA();
    aSl();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void sz(int paramInt)
  {
    this.aUz = paramInt;
  }
  
  public void v(VideoInfo paramVideoInfo)
  {
    this.jdField_c_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public static abstract interface a
  {
    public abstract void aGM();
    
    public abstract void aJ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mtw
 * JD-Core Version:    0.7.0.1
 */