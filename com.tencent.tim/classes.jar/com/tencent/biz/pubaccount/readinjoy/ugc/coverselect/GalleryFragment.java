package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.GestureCropImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ucrop.UCropView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import mir.a;
import miw;
import mle;
import mlf;
import mlg;
import mlj;
import mlj.b;
import mll;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;

public class GalleryFragment
  extends PublicBaseFragment
  implements mlj.b, QQPermissionCallback
{
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private UCropView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView;
  private miw<mir.a> jdField_a_of_type_Miw = new miw();
  private mlj jdField_a_of_type_Mlj;
  public Activity activity;
  private String ajr;
  private List<mir.a> jl = new ArrayList();
  private View lg;
  private View lh;
  private RecyclerView recyclerView;
  private int videoHeight;
  private int videoWidth;
  
  public static GalleryFragment a(int paramInt1, int paramInt2, String paramString)
  {
    GalleryFragment localGalleryFragment = new GalleryFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("ARG_VIDEO_WIDTH", paramInt1);
    localBundle.putInt("ARG_VIDEO_HEIGHT", paramInt2);
    localBundle.putString("ARG_PLACEHOLDER_URL", paramString);
    localGalleryFragment.setArguments(localBundle);
    return localGalleryFragment;
  }
  
  private void aPL()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.Fk())
    {
      aPO();
      return;
    }
    this.lh.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(0);
  }
  
  private void aPM()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    this.ajr = localBundle.getString("ARG_PLACEHOLDER_URL");
    this.videoWidth = localBundle.getInt("ARG_VIDEO_WIDTH");
    this.videoHeight = localBundle.getInt("ARG_VIDEO_HEIGHT");
  }
  
  private void aPN()
  {
    nH(this.ajr);
  }
  
  private void aPO()
  {
    this.jdField_a_of_type_Miw.aPh();
  }
  
  private void aPP()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView.aPP();
    if ((this.videoWidth != 0) && (this.videoHeight != 0))
    {
      GestureCropImageView localGestureCropImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView.a();
      localGestureCropImageView.setMaxScale(2.0F);
      localGestureCropImageView.setIsDoubleTapEnabled(false);
      localGestureCropImageView.setMaxResultImageSizeX(this.videoWidth);
      localGestureCropImageView.setMaxResultImageSizeY(this.videoHeight);
      localGestureCropImageView.setTargetAspectRatio(this.videoWidth / this.videoHeight);
      return;
    }
    QLog.e("RIJUGC.GalleryFragment", 1, "setAspectRatio error mVideoWidth:" + this.videoWidth + "mVideoHeight" + this.videoHeight);
  }
  
  private void b(mir.a parama)
  {
    nH(parama.path);
  }
  
  private void n(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new GalleryFragment.5(this, paramBitmap));
  }
  
  private void nH(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      ThreadManager.post(new GalleryFragment.4(this, paramString), 8, null, true);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(mir.a parama)
  {
    aPP();
    b(parama);
  }
  
  public void a(mll parammll)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView.a().a(Bitmap.CompressFormat.JPEG, 90, this.videoWidth, this.videoHeight, new mlg(this, parammll));
  }
  
  public boolean a(int paramInt, mir.a parama)
  {
    if ((parama.getWidth() < this.videoWidth / 2.0F) || (parama.getHeight() < this.videoHeight / 2.0F))
    {
      Toast.makeText(this.activity, 2131718536, 0).show();
      return false;
    }
    return true;
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.lh.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      aPO();
    }
  }
  
  public void m(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Mlj.pz() >= 0) {}
    for (int i = 1;; i = 0)
    {
      if ((TextUtils.isEmpty(this.ajr)) && (i == 0)) {
        n(paramBitmap);
      }
      return;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.activity = paramActivity;
    aPM();
    this.jdField_a_of_type_Miw.a(new mle(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.activity, 2131560185, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.recyclerView = ((RecyclerView)paramView.findViewById(2131367842));
    this.lg = paramView.findViewById(2131366417);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewUcropUCropView = ((UCropView)paramView.findViewById(2131367839));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362631));
    this.lh = paramView.findViewById(2131370649);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_Mlj = new mlj(this.activity);
    this.jdField_a_of_type_Mlj.a(this);
    this.jl = this.jdField_a_of_type_Mlj.be();
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(this.activity, 4);
    this.recyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.recyclerView.addItemDecoration(new mlf(this));
    this.recyclerView.setAdapter(this.jdField_a_of_type_Mlj);
    aPP();
    aPN();
    aPL();
  }
  
  public void rP(int paramInt)
  {
    this.jdField_a_of_type_Miw.rP(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.GalleryFragment
 * JD-Core Version:    0.7.0.1
 */