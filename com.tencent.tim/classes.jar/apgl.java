import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.util.ArrayList;

public class apgl
  extends awrq
  implements View.OnClickListener
{
  private ImageView Et;
  private TextView aaB;
  private String mTroopUin;
  
  public apgl(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
  }
  
  public void Bx(boolean paramBoolean) {}
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.setFunctionFlag(2);
    locale.TN(1280);
    locale.TO(720);
    locale.Ov(false);
    locale.TS(2);
    return locale;
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    paramh = EditPicActivity.a(localActivity, paramh.filePath, false, false, false, true, false, 11);
    paramh.putExtra("arithmetic_ability", 1L);
    paramh.putExtra("troop_uin", this.mTroopUin);
    localActivity.startActivityForResult(paramh, 10001);
  }
  
  public void cox()
  {
    super.cox();
    this.hQ.setVisibility(8);
    this.hS.setVisibility(8);
  }
  
  public void coy()
  {
    super.coy();
  }
  
  protected int getLayoutId()
  {
    return 2131563234;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        getActivity().setResult(paramInt2, paramIntent);
        getActivity().finish();
        getActivity().overridePendingTransition(2130772077, 2130772307);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364221)
    {
      aqfr.b("Grp_edu", "Grp_oral", "Oral_Photo_Out", 0, 0, new String[] { this.mTroopUin, "" });
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
      case 2131362942: 
      case 2131362943: 
        aqfr.b("Grp_edu", "Grp_oral", "Oral_Photo_Tip_In", 0, 0, new String[] { this.mTroopUin, "" });
      case 2131381396: 
        BeginnerGuideFragment.f(getActivity(), null, 7);
        this.aaB.setVisibility(8);
        this.Et.setVisibility(8);
        break;
      case 2131364221: 
        auC();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.dKJ();
    this.mTroopUin = this.jdField_a_of_type_Aycb.getActivity().getIntent().getStringExtra("troop_uin");
    if (this.mTroopUin == null)
    {
      this.mTroopUin = "";
      QLog.e("ArithmeticCameraCaptureUnit", 1, "troopUin null!");
    }
    aqfr.b("Grp_edu", "Grp_oral", "Oral_Photo_In", 0, 0, new String[] { this.mTroopUin, "" });
  }
  
  public View onCreateView()
  {
    View localView1 = super.onCreateView();
    rnp.a(getActivity().getLayoutInflater(), new apgm(this, getActivity().getLayoutInflater()));
    Object localObject1 = localView1.findViewById(2131368618);
    Object localObject2 = localView1.findViewById(2131368619);
    View localView2 = localView1.findViewById(2131368620);
    View localView3 = localView1.findViewById(2131381534);
    View localView4 = localView1.findViewById(2131381535);
    int i = rpq.getWindowScreenHeight(getActivity()) / 4;
    int j = rpq.getWindowScreenWidth(getActivity()) / 3;
    ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).setMargins(0, i, 0, 0);
    ((RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams()).setMargins(0, i * 2, 0, 0);
    ((RelativeLayout.LayoutParams)localView2.getLayoutParams()).setMargins(0, i * 3, 0, 0);
    ((RelativeLayout.LayoutParams)localView3.getLayoutParams()).setMargins(j, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localView4.getLayoutParams()).setMargins(j * 2, 0, 0, 0);
    this.hQ.setVisibility(8);
    localObject1 = (Button)localView1.findViewById(2131381396);
    ((Button)localObject1).setVisibility(0);
    this.aaB = ((TextView)localView1.findViewById(2131362942));
    this.Et = ((ImageView)localView1.findViewById(2131362943));
    localObject2 = (psr)psx.a(10);
    if ((localObject2 != null) && (((Boolean)((psr)localObject2).c("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(true))).booleanValue()))
    {
      this.aaB.setVisibility(0);
      this.Et.setVisibility(0);
      this.aaB.setOnClickListener(this);
      this.Et.setOnClickListener(this);
      ((psr)localObject2).n("SP_ARITHMETIC_GUIDE_SHOW", Boolean.valueOf(false));
    }
    for (;;)
    {
      ((Button)localObject1).setOnClickListener(this);
      localView1.setFocusable(true);
      localView1.setFocusableInTouchMode(true);
      localView1.requestFocus();
      localView1.setOnKeyListener(new apgl.a(null));
      ((TextView)this.rootView.findViewById(2131364221)).setOnClickListener(this);
      return localView1;
      this.aaB.setVisibility(8);
      this.Et.setVisibility(8);
    }
  }
  
  class a
    implements View.OnKeyListener
  {
    private a() {}
    
    public void onBackPressed()
    {
      Activity localActivity = apgl.this.getActivity();
      if (localActivity != null)
      {
        apgl.this.getActivity().finish();
        localActivity.overridePendingTransition(2130772077, 2130772307);
      }
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      boolean bool2 = true;
      boolean bool1;
      switch (paramInt)
      {
      default: 
        bool1 = false;
      }
      do
      {
        return bool1;
        bool1 = bool2;
        switch (paramKeyEvent.getAction())
        {
        case 0: 
        default: 
          break;
        case 1: 
          bool1 = bool2;
        }
      } while (paramKeyEvent.isCanceled());
      onBackPressed();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgl
 * JD-Core Version:    0.7.0.1
 */