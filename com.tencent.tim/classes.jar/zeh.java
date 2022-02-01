import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.1;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.2;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.3;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.4;
import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit.5;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class zeh
  extends awrq
  implements View.OnClickListener
{
  private TextView MG;
  private TextView MH;
  private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
  private arfo jdField_a_of_type_Arfo;
  private String bac;
  private String bae;
  private int cdf;
  private int cdg = 155;
  private int cdh = 211;
  private Button eC;
  private LinearLayout hH;
  private RelativeLayout ha;
  private RelativeLayout iw;
  private Runnable mCountDownRunnable = new QFaceUnlockCameraCaptureUnit.1(this);
  private Handler mHandler;
  private int mSecond;
  
  public zeh(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
  }
  
  private void By(boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.4(this, paramBoolean));
  }
  
  private void Bz(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setPreviewDisplay(null);
      this.jdField_a_of_type_AndroidMediaMediaRecorder.setOnErrorListener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord begin");
      }
      this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
      if (paramBoolean) {
        this.mHandler.post(new QFaceUnlockCameraCaptureUnit.5(this));
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFaceUnlockCameraCaptureUnit", 0, "releaseRecord end");
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, IllegalStateException: " + localIllegalStateException.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QFaceUnlockCameraCaptureUnit", 1, "releaseRecord failed, Exception: " + localException.getMessage());
      }
    }
    this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
  }
  
  private void cow()
  {
    this.cdf = 0;
    this.eC.setText(2131701222);
    this.eC.setVisibility(0);
    this.eC.setEnabled(false);
    this.mSecond = 0;
    this.MH.setVisibility(8);
    this.hH.setVisibility(8);
    this.MG.setVisibility(0);
  }
  
  private Camera.Size getSameSize(List<Camera.Size> paramList1, List<Camera.Size> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null))
    {
      paramList2 = null;
      return paramList2;
    }
    HashSet localHashSet = new HashSet(paramList1);
    Iterator localIterator = paramList2.iterator();
    paramList1 = null;
    int i = -1;
    for (;;)
    {
      paramList2 = paramList1;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList2 = (Camera.Size)localIterator.next();
      if (localHashSet.contains(paramList2))
      {
        int j = paramList2.width * paramList2.height;
        if (j > i)
        {
          i = j;
          paramList1 = paramList2;
        }
      }
    }
  }
  
  private void startRecord()
  {
    ThreadManager.getSubThreadHandler().post(new QFaceUnlockCameraCaptureUnit.3(this));
  }
  
  public void Bx(boolean paramBoolean)
  {
    super.Bx(paramBoolean);
    ThreadManager.getUIHandler().post(new QFaceUnlockCameraCaptureUnit.2(this));
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.setFunctionFlag(3);
    locale.TS(1);
    locale.Ov(false);
    return locale;
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    super.a(paramVideoCaptureResult);
  }
  
  public void ac(boolean paramBoolean, String paramString)
  {
    super.ac(paramBoolean, paramString);
    if (paramBoolean)
    {
      this.eC.setEnabled(true);
      return;
    }
    QLog.e("QFaceUnlockCameraCaptureUnit", 1, "Camera start fail!");
  }
  
  public void bSV()
  {
    super.bSV();
  }
  
  public void coA() {}
  
  public void coB() {}
  
  public void cox()
  {
    int i = 0;
    cow();
    if (aeah.agb()) {
      this.hQ.setVisibility(0);
    }
    for (;;)
    {
      this.hR.setVisibility(8);
      this.hQ.setVisibility(8);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
      if (this.eZ != null)
      {
        ViewGroup localViewGroup = this.eZ;
        if (this.drn) {
          i = 8;
        }
        localViewGroup.setVisibility(i);
      }
      this.hS.setVisibility(8);
      this.HK.setVisibility(8);
      if (this.cz != null) {
        this.cz.setVisibility(8);
      }
      if (this.eZ != null) {
        this.eZ.setVisibility(8);
      }
      this.iw.setVisibility(8);
      return;
      this.hQ.setVisibility(4);
    }
  }
  
  public void coy()
  {
    super.coy();
  }
  
  protected void coz()
  {
    super.coz();
  }
  
  protected int getLayoutId()
  {
    return 2131559328;
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityPause");
    }
    By(false);
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResult");
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onActivityResume");
    }
  }
  
  public boolean onBackPressed()
  {
    return super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364221)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(2130772077, 2130772307);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374606: 
        if (this.cdf == 0)
        {
          this.cdf = 1;
          this.eC.setText(2131701225);
          this.MH.setVisibility(0);
          this.hH.setVisibility(0);
          this.MG.setVisibility(8);
          startRecord();
        }
        else if (this.cdf == 1)
        {
          this.eC.setEnabled(false);
          this.cdf = 2;
          By(true);
        }
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getActivity().getWindow().setFlags(1024, 1024);
    getActivity().requestWindowFeature(1);
    super.onCreate(paramBundle);
    this.bac = this.jdField_a_of_type_Aycb.getActivity().getIntent().getStringExtra("key_face_unlock_code");
    this.mHandler = new Handler();
    if (TextUtils.isEmpty(this.bac))
    {
      this.bac = "6978";
      QLog.e("QFaceUnlockCameraCaptureUnit", 1, "verification code is null, use default code");
    }
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    ((TextView)localView.findViewById(2131364221)).setOnClickListener(this);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.dKJ();
    this.eC = ((Button)localView.findViewById(2131374606));
    this.cdf = 0;
    this.eC.setEnabled(false);
    this.eC.setText(2131701222);
    this.eC.setOnClickListener(this);
    this.mSecond = 0;
    this.iw = ((RelativeLayout)localView.findViewById(2131367263));
    this.ha = ((RelativeLayout)localView.findViewById(2131366684));
    int i = wja.dp2px(this.cdg, getActivity().getResources());
    this.jdField_a_of_type_Arfo = new arfo();
    this.jdField_a_of_type_Arfo.setCenterY(wja.dp2px(this.cdg + this.cdh, getActivity().getResources()));
    this.jdField_a_of_type_Arfo.Yr(i);
    this.jdField_a_of_type_Arfo.Yy(1);
    if (Build.VERSION.SDK_INT > 15) {
      this.ha.setBackground(this.jdField_a_of_type_Arfo);
    }
    for (;;)
    {
      this.MG = ((TextView)localView.findViewById(2131378705));
      this.hH = ((LinearLayout)localView.findViewById(2131377017));
      this.MH = ((TextView)localView.findViewById(2131366687));
      this.MH.setText(this.bac);
      return localView;
      this.ha.setBackgroundDrawable(this.jdField_a_of_type_Arfo);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("QFaceUnlockCameraCaptureUnit", 0, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zeh
 * JD-Core Version:    0.7.0.1
 */