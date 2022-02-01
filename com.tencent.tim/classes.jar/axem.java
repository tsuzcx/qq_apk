import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.BaseVMPeakActivity;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.8;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFSinglePreviewFragment.9;
import dov.com.qq.im.ae.gif.preview.VideoPlayView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class axem
  extends ReportFragment
{
  private final float DW = 147.0F;
  private final float DX = 58.799999F;
  private View Mu;
  private axfx jdField_a_of_type_Axfx;
  private VideoPlayView jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView;
  private Dialog aH;
  private SessionWrap b;
  private axdn jdField_c_of_type_Axdn;
  private AEGIFOutlineTextView jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView;
  private String cTM = "";
  private boolean duf;
  private boolean dul;
  private boolean dum;
  private final int eDZ = 700;
  private final int eEa = 600;
  private ViewGroup fa;
  private boolean isPaused;
  private Activity mActivity;
  private String materialId;
  private MediaPlayer mediaPlayer;
  private String sourcePath;
  
  private void Yd(boolean paramBoolean)
  {
    axiy.i("AEGIFSinglePreviewFragment", "saveAndSend---onlySave=" + paramBoolean);
    eJd();
    this.jdField_a_of_type_Axfx = new axfx(this.sourcePath);
    if (!this.duf) {
      eJf();
    }
    this.jdField_a_of_type_Axfx.a(new axeq(this, paramBoolean));
  }
  
  public static Fragment a(String paramString1, Boolean paramBoolean, String paramString2, String paramString3, SessionWrap paramSessionWrap, boolean paramBoolean1)
  {
    axem localaxem = new axem();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString1);
    localBundle.putString("KEY_AVAILABLE_SAVENAME", paramString3);
    localBundle.putBoolean("KEY_MATERIAL_APPLIED", paramBoolean.booleanValue());
    localBundle.putString("ARG_GIF_MATERIAL_ID", paramString2);
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putBoolean("ARG_GIF_SEND_TO_AIO", paramBoolean1);
    localaxem.setArguments(localBundle);
    return localaxem;
  }
  
  private void a(String paramString1, SessionWrap paramSessionWrap, String paramString2, String paramString3)
  {
    if (!new File(paramString1).exists()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_GIF_PATH", paramString1);
    localBundle.putString("curFriendUin", paramSessionWrap.aTl);
    localBundle.putString("curFriendNick", paramSessionWrap.aTn);
    localBundle.putString("troopUin", paramSessionWrap.troopUin);
    localBundle.putInt("curType", paramSessionWrap.cZ);
    localBundle.putString("forward_summary_extra", paramString2);
    paramSessionWrap = new StringBuilder().append("gif^");
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localBundle.putString("widgetinfo", paramString1);
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_SEND_GIF", localBundle, null);
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void acs(String paramString)
  {
    this.mediaPlayer = new MediaPlayer();
    this.mediaPlayer.setLooping(true);
    try
    {
      this.mediaPlayer.setDataSource(paramString);
      this.mediaPlayer.setOnPreparedListener(new axes(this));
      return;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        QLog.e("AEGIFSinglePreviewFragment", 1, "mediaPlayer 初始化失败");
      }
    }
  }
  
  private void c(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList3);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new axer(this));
  }
  
  private void eJa()
  {
    axeu localaxeu = axeu.a(null, false);
    localaxeu.a(this.jdField_c_of_type_Axdn);
    getFragmentManager().beginTransaction().add(2131367564, localaxeu).addToBackStack(null).commit();
  }
  
  private void eJb()
  {
    acs(this.sourcePath);
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView = ((VideoPlayView)this.fa.findViewById(2131381585));
    if (this.mediaPlayer != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView.a(this.mediaPlayer);
    }
  }
  
  private void eJc()
  {
    this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView = ((AEGIFOutlineTextView)this.fa.findViewById(2131372763));
    this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setVisibility(0);
    this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.setOnClickListener(new axet(this));
    RelativeLayout localRelativeLayout = (RelativeLayout)this.fa.findViewById(2131374695);
    localRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_Axdn = new axdn((BaseVMPeakActivity)this.mActivity, localRelativeLayout, this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView);
    this.jdField_c_of_type_Axdn.init();
  }
  
  private void eJd()
  {
    if (!this.mActivity.isFinishing()) {
      aurs.runOnUiThread(new AEGIFSinglePreviewFragment.8(this));
    }
  }
  
  private void eJe()
  {
    aurs.runOnUiThread(new AEGIFSinglePreviewFragment.9(this));
  }
  
  private void eJf()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.fa.findViewById(2131374672);
    float f2 = this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getLeft() / localRelativeLayout.getWidth();
    float f3 = this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getTop() / localRelativeLayout.getHeight();
    float f1 = this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.getTextSize() + this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.ca() * 2.0F;
    if (this.jdField_c_of_type_Axdn.HK().indexOf('\n') > 0) {}
    for (f1 = f1 * 2.5F / aqcx.dip2px(this.mActivity, 250.0F);; f1 = f1 * 1.2F / aqcx.dip2px(this.mActivity, 250.0F))
    {
      if (this.jdField_c_of_type_Axdn.HK().length() > 0) {
        this.jdField_a_of_type_Axfx.a(this.jdField_c_of_type_DovComQqImAeGifGiftextAEGIFOutlineTextView.aT(), f2, f3, 1.0F, f1);
      }
      return;
    }
  }
  
  private void initViews()
  {
    this.fa.findViewById(2131368027).setOnClickListener(new axen(this));
    this.Mu = this.fa.findViewById(2131362689);
    this.fa.findViewById(2131368028).setOnClickListener(new axeo(this));
    this.fa.findViewById(2131380834).setOnClickListener(new axep(this));
  }
  
  protected int getLayoutId()
  {
    return 2131558625;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.fa = ((ViewGroup)paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false));
    int i = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int j = aqcx.dip2px(this.mActivity, 700.0F);
    if (i < j)
    {
      this.dum = true;
      if (this.dum)
      {
        paramLayoutInflater = this.fa.findViewById(2131374672);
        paramViewGroup = (RelativeLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        if (i >= aqcx.dip2px(this.mActivity, 600.0F)) {
          break label269;
        }
        paramViewGroup.topMargin = aqcx.dip2px(this.mActivity, 58.799999F);
        label109:
        paramLayoutInflater.setLayoutParams(paramViewGroup);
      }
      paramLayoutInflater = getArguments();
      this.sourcePath = paramLayoutInflater.getString("KEY_PREVIEW_SOURCE_PATH");
      this.duf = paramLayoutInflater.getBoolean("KEY_MATERIAL_APPLIED");
      this.materialId = paramLayoutInflater.getString("ARG_GIF_MATERIAL_ID");
      axiy.i("AEGIFSinglePreviewFragment", "receive materialId=" + this.materialId);
      this.cTM = paramLayoutInflater.getString("KEY_AVAILABLE_SAVENAME");
      this.b = ((SessionWrap)paramLayoutInflater.getParcelable("ARG_SESSION_INFO"));
      this.dul = paramLayoutInflater.getBoolean("ARG_GIF_SEND_TO_AIO");
      if ((this.duf) || (!axip.a().HQ().equals("none"))) {
        break label312;
      }
      this.duf = false;
      eJc();
    }
    for (;;)
    {
      initViews();
      eJb();
      paramLayoutInflater = this.fa;
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.dum = false;
      break;
      label269:
      float f = (j - i) / aqcx.dip2px(this.mActivity, 100.0F);
      paramViewGroup.topMargin = aqcx.dip2px(this.mActivity, 147.0F - f * 88.199997F);
      break label109;
      label312:
      this.duf = true;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mediaPlayer != null) {
      this.mediaPlayer.release();
    }
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoPlayView.clear();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    axim.a().eLn();
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.pause();
      this.isPaused = true;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    axip.a().eLz();
    if ((this.mediaPlayer != null) && (this.isPaused))
    {
      this.mediaPlayer.start();
      this.isPaused = false;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.mediaPlayer != null) && (this.isPaused)) {
      this.mediaPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axem
 * JD-Core Version:    0.7.0.1
 */