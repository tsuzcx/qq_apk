package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import axbm;
import axbo;
import axcg;
import axhb;
import axhc;
import axhd;
import axic;
import axim;
import ayom;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import javax.annotation.Nullable;
import shb;
import vnk;

public class AETakeFacePhotoPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, vnk
{
  private static String cUp = "";
  private ImageView If;
  private axbm jdField_a_of_type_Axbm = (axbm)this.mAppInterface.getBusinessHandler(3);
  private axbo jdField_a_of_type_Axbo;
  private long aBP;
  private String aEu;
  private TextView ahc;
  private Dialog g;
  private Bitmap hl;
  private AppInterface mAppInterface = QQStoryContext.c();
  private int screenHeight;
  private int screenWidth;
  private TextView tg;
  
  public static String HM()
  {
    return cUp;
  }
  
  private void ce(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      if (paramInt == 0) {
        eJK();
      }
    }
    for (;;)
    {
      hideLoading();
      return;
      if (paramInt == -1)
      {
        QQToast.a(getActivity(), 2131690002, 0).show();
      }
      else if (paramInt == -2)
      {
        QQToast.a(getActivity(), 2131699971, 0).show();
        continue;
        QQToast.a(getActivity(), 2131699971, 0).show();
      }
    }
  }
  
  private void eJJ()
  {
    cUp = "";
    if (!axic.i(this.hl)) {
      return;
    }
    axic.a(this.hl, new axhb(this));
  }
  
  private void eJK()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("take_photo_path", this.aEu);
    getActivity().setResult(-1, localIntent);
    onBackPressed();
  }
  
  private void eJL()
  {
    if (this.jdField_a_of_type_Axbo != null)
    {
      this.mAppInterface.removeObserver(this.jdField_a_of_type_Axbo);
      this.jdField_a_of_type_Axbo = null;
    }
  }
  
  private void f(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
      return;
    }
    AEVideoShelfEditFragment.ad(getActivity(), true);
    showLoading();
    Intent localIntent = getActivity().getIntent();
    if (((!localIntent.getBooleanExtra("key_disable_face_detect", false)) || (axcg.aw(localIntent))) && (!axic.i(paramBitmap)))
    {
      QQToast.a(getActivity(), 2131690004, 0).show();
      hideLoading();
      onBackPressed();
      return;
    }
    if ((localIntent.getBooleanExtra("key_need_check_sensitive", false)) || (axcg.aw(localIntent)))
    {
      eJL();
      this.jdField_a_of_type_Axbo = new axhc(this);
      this.aBP = System.currentTimeMillis();
      this.mAppInterface.addObserver(this.jdField_a_of_type_Axbo);
      this.jdField_a_of_type_Axbm.acm(paramString);
      return;
    }
    ce(true, 0);
  }
  
  private void hideLoading()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()) && (this.g != null) && (this.g.isShowing())) {
      this.g.dismiss();
    }
  }
  
  private void initData()
  {
    this.screenWidth = ayom.getWindowScreenWidth(getActivity());
    this.screenHeight = ayom.getWindowScreenHeight(getActivity());
    this.aEu = getArguments().getString("photo_path");
    if (!TextUtils.isEmpty(this.aEu))
    {
      this.hl = BitmapUtils.decodeSampleBitmap(getActivity(), this.aEu, this.screenWidth, this.screenHeight);
      if (this.hl != null)
      {
        this.If.setImageBitmap(this.hl);
        eJJ();
        this.ahc.setOnClickListener(this);
        this.tg.setOnClickListener(this);
      }
    }
  }
  
  public static void j(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.b.startForResult(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AETakeFacePhotoPreviewFragment.class, paramInt);
  }
  
  private void showLoading()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      if (this.g == null)
      {
        this.g = new ReportDialog(localFragmentActivity, 2131756467);
        this.g.setContentView(2131559761);
        ((TextView)this.g.findViewById(2131373180)).setText(2131690001);
        this.g.setCancelable(true);
        this.g.setCanceledOnTouchOutside(false);
        this.g.setOnDismissListener(new axhd(this));
      }
      this.g.show();
    }
  }
  
  private void u(View paramView)
  {
    this.If = ((ImageView)paramView.findViewById(2131362313));
    this.ahc = ((TextView)paramView.findViewById(2131362327));
    this.tg = ((TextView)paramView.findViewById(2131362328));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      shb.e(paramActivity.getWindow());
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    getActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362328) {
      if ((!TextUtils.isEmpty(this.aEu)) || (this.hl != null))
      {
        axim.a().eLe();
        f(this.hl, this.aEu);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131362327)
      {
        axim.a().eLf();
        onBackPressed();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558556, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.hl != null) {
      BitmapUtils.recycle(this.hl);
    }
    if ((cUp != null) && (cUp.length() > 0)) {
      FileUtils.delete(cUp);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    hideLoading();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    u(paramView);
    initData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */