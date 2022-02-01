import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.BaseVMPeakActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class axec
  extends ReportFragment
  implements axdr.a
{
  public static List<List<float[]>> allFaceAngles;
  public static List<List<List<PointF>>> allFacePoints;
  public static double faceDetectScale = 1.0D;
  private List<axdj> My = new ArrayList();
  private axfg jdField_a_of_type_Axfg;
  private axfq.a jdField_a_of_type_Axfq$a;
  private axfr jdField_a_of_type_Axfr;
  private BaseVMPeakActivity jdField_a_of_type_DovComQqImBaseVMPeakActivity;
  private long aBL = 9223372036854775807L;
  private TextView afP;
  private TextView aha;
  private axdr jdField_b_of_type_Axdr;
  private axfj jdField_b_of_type_Axfj;
  private axfk jdField_b_of_type_Axfk;
  private String cTY;
  private boolean duk;
  private ViewGroup fa;
  private RecyclerView mRecyclerView;
  private HashMap<String, String> qZ;
  
  public static axec a(String paramString, long paramLong)
  {
    axec localaxec = new axec();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PREVIEW_SOURCE_PATH", paramString);
    localBundle.putLong("KEY_AVAILABLE_EMO_COUNT", paramLong);
    localaxec.setArguments(localBundle);
    return localaxec;
  }
  
  private void b(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("qipc_param_camera_emo_png_dirs", paramArrayList1);
    localBundle.putStringArrayList("qipc_param_camera_emo_texts", paramArrayList2);
    localBundle.putStringArrayList("qipc_param_camera_emo_snapshots", paramArrayList3);
    localBundle.putStringArrayList("qipc_param_emo_widget_infos", paramArrayList4);
    QIPCClientHelper.getInstance().callServer("CameraEmoIpcServer", "qipc_action_camera_emo_create_gif_and_upload", localBundle, new axel(this));
    getActivity().setResult(201);
    getActivity().finish();
  }
  
  private void bgj()
  {
    this.mRecyclerView = ((RecyclerView)this.fa.findViewById(2131377617));
    this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 2));
    this.mRecyclerView.addItemDecoration(new axeg(this));
    initAdapter();
  }
  
  private void biN()
  {
    this.jdField_b_of_type_Axfk = ((axfk)awuh.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).b(axfk.class));
    this.jdField_b_of_type_Axdr.a(this.jdField_b_of_type_Axfk, this.jdField_a_of_type_DovComQqImBaseVMPeakActivity);
    this.jdField_b_of_type_Axfk.n().postValue("");
    this.jdField_b_of_type_Axfk.m().postValue(new axdl.a("#ccffffff", "#000000"));
    this.jdField_b_of_type_Axfk.o().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new axeh(this));
    this.jdField_b_of_type_Axfk.clearText();
    this.jdField_a_of_type_Axfg = ((axfg)awuh.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity).b(axfg.class));
    this.jdField_b_of_type_Axfj = ((axfj)awuh.a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, axyw.a()).b(axfj.class));
    this.jdField_b_of_type_Axfj.l().a(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, new axei(this));
  }
  
  private void eJa()
  {
    Object localObject = this.mRecyclerView.getChildAt(0);
    localObject = axeu.a(this.cTY, true, (View)localObject);
    getFragmentManager().beginTransaction().add(2131367564, (Fragment)localObject).addToBackStack(null).commit();
  }
  
  @Nullable
  private String gR(int paramInt)
  {
    if (this.My == null) {
      return null;
    }
    if ((paramInt < 0) || (paramInt >= this.My.size())) {
      return null;
    }
    if ((this.My.get(paramInt) == null) || (((axdj)this.My.get(paramInt)).c == null)) {
      return null;
    }
    return ((axdj)this.My.get(paramInt)).c.id;
  }
  
  private void initAdapter()
  {
    Object localObject = new axdj();
    ((axdj)localObject).c = null;
    ((axdj)localObject).text = null;
    ((axdj)localObject).downloadState = 2;
    this.My.add(0, new axdj());
    this.jdField_b_of_type_Axdr = new axdr(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, this.My);
    this.jdField_b_of_type_Axdr.a(this);
    this.jdField_b_of_type_Axdr.jn(this.afP);
    this.mRecyclerView.setAdapter(this.jdField_b_of_type_Axdr);
    localObject = new axfp();
    ((axfp)localObject).index = 0;
    this.jdField_a_of_type_Axfr.a((axfp)localObject);
  }
  
  private void initViews()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.fa.findViewById(2131377506);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = ((int)(DeviceUtils.getScreenHeight(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.08F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    this.fa.findViewById(2131368027).setOnClickListener(new axee(this));
    this.aha = ((TextView)this.fa.findViewById(2131380968));
    int i = (int)(DeviceUtils.getScreenWidth(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity) * 0.04F);
    this.aha.setPadding(i, aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F), 0, aqcx.dip2px(this.jdField_a_of_type_DovComQqImBaseVMPeakActivity, 9.0F));
    this.afP = ((TextView)this.fa.findViewById(2131377624));
    this.afP.setEnabled(false);
    this.afP.setOnClickListener(new axef(this));
    bgj();
  }
  
  public void Hi()
  {
    eJa();
  }
  
  protected int getLayoutId()
  {
    return 2131558623;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImBaseVMPeakActivity = ((BaseVMPeakActivity)getActivity());
    paramBundle = getArguments().getString("KEY_PREVIEW_SOURCE_PATH");
    this.aBL = getArguments().getLong("KEY_AVAILABLE_EMO_COUNT");
    QLog.d("AEGIFChunkPreviewFragment", 4, "availableEmoCount = " + this.aBL);
    this.jdField_a_of_type_Axfr = new axfr(paramBundle, allFacePoints, allFaceAngles, faceDetectScale, getActivity());
    this.jdField_a_of_type_Axfr.a(new axed(this));
    this.qZ = new HashMap();
    this.qZ.put("happy", acfp.m(2131702128));
    this.qZ.put("neutral", acfp.m(2131702129));
    this.qZ.put("sad", acfp.m(2131702134));
    this.qZ.put("anger", acfp.m(2131702132));
    this.qZ.put("disgust", acfp.m(2131702130));
    this.qZ.put("fear", acfp.m(2131702137));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.fa = ((ViewGroup)paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false));
    initViews();
    biN();
    paramLayoutInflater = this.fa;
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axfr localaxfr;
    if (this.jdField_a_of_type_Axfr != null)
    {
      localaxfr = this.jdField_a_of_type_Axfr;
      if (this.duk) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localaxfr.stop(bool);
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    axim.a().eLn();
  }
  
  public void onResume()
  {
    super.onResume();
    this.duk = false;
    axip.a().eLz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axec
 * JD-Core Version:    0.7.0.1
 */