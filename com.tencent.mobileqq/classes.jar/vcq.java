import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import qqcircle.QQCirclePrivateMsgShow.StFuelCostRange;
import qqcircle.QQCirclePrivateMsgShow.StGetPMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow.StPMSettingData;

public class vcq
  extends uzw
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqiw jdField_a_of_type_Aqiw = new vcv(this);
  private QQCirclePrivateMsgShow.StFuelCostRange jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StFuelCostRange;
  private QQCirclePrivateMsgShow.StGetPMSettingRsp jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StGetPMSettingRsp;
  private QQCirclePrivateMsgShow.StPMSettingData jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData;
  private vui jdField_a_of_type_Vui;
  private ImageView b;
  private ImageView c;
  private ImageView d;
  
  private void a()
  {
    this.jdField_a_of_type_Vui = ((vui)a(vui.class));
    this.jdField_a_of_type_Vui.a.observe(a(), new vcr(this));
    this.jdField_a_of_type_Vui.b.observe(a(), new vcs(this));
    this.jdField_a_of_type_Vui.a(BaseApplicationImpl.getApplication().getRuntime().getAccount());
  }
  
  private void a(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = anni.a(2131718323);
    }
    for (;;)
    {
      QLog.e("QCirclePrivateMessageSettingContentPart", 1, "handleError() return error！ retCode : " + paramLong + " , errMsg : " + paramString);
      vtt.a(paramLong, BaseApplicationImpl.getContext(), 1, paramString, 1);
      return;
    }
  }
  
  private void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.b.setImageDrawable(null);
    this.c.setImageDrawable(null);
    this.d.setImageDrawable(null);
    if (paramImageView != null) {
      paramImageView.setImageDrawable(a().getResources().getDrawable(2130844034));
    }
  }
  
  private void a(String paramString)
  {
    vrf.a(String.valueOf(uxx.a()), 11, 39, 1, paramString, "", "", "", "", b());
  }
  
  private void a(QQCirclePrivateMsgShow.StGetPMSettingRsp paramStGetPMSettingRsp)
  {
    this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StGetPMSettingRsp = paramStGetPMSettingRsp;
    try
    {
      this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData = ((QQCirclePrivateMsgShow.StPMSettingData)new QQCirclePrivateMsgShow.StPMSettingData().mergeFrom(((QQCirclePrivateMsgShow.StPMSettingData)paramStGetPMSettingRsp.setting.get()).toByteArray()));
      this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StFuelCostRange = ((QQCirclePrivateMsgShow.StFuelCostRange)paramStGetPMSettingRsp.fuelCostRange.get());
      if (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData == null) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      switch (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.privilgetype.get())
      {
      default: 
        a(null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.fuelCost.get()));
      return;
      a(this.c);
      continue;
      a(this.d);
      continue;
      a(this.b);
      continue;
      a(this.jdField_a_of_type_AndroidWidgetImageView);
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData != null) && (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StGetPMSettingRsp != null) && (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.privilgetype.get() == this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StGetPMSettingRsp.setting.privilgetype.get()) && (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.fuelCost.get() == this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StGetPMSettingRsp.setting.fuelCost.get())) {
      return;
    }
    this.jdField_a_of_type_Vui.a(this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369277));
    this.b = ((ImageView)paramView.findViewById(2131369280));
    this.c = ((ImageView)paramView.findViewById(2131369279));
    this.d = ((ImageView)paramView.findViewById(2131369278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379684));
    paramView.findViewById(2131369322).setOnClickListener(this);
    paramView.findViewById(2131376710).setOnClickListener(this);
    paramView.findViewById(2131376713).setOnClickListener(this);
    paramView.findViewById(2131376712).setOnClickListener(this);
    paramView.findViewById(2131376711).setOnClickListener(this);
    paramView.findViewById(2131376654).setOnClickListener(this);
  }
  
  private void c()
  {
    bkho localbkho = bkho.c(a());
    Object localObject = (DispatchActionMoveScrollView)localbkho.findViewById(2131361980);
    ((DispatchActionMoveScrollView)localObject).a = true;
    ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
    localObject = (IphonePickerView)LayoutInflater.from(a()).inflate(2131561215, null);
    ((IphonePickerView)localObject).a(this.jdField_a_of_type_Aqiw);
    if ((this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StFuelCostRange != null) && (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData != null))
    {
      ((IphonePickerView)localObject).setSelection(0, this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.fuelCost.get() - this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StFuelCostRange.min.get());
      QLog.i("QCirclePrivateMessageSettingContentPart", 1, "fuelUseNumSelect() setSelection  row : " + (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.fuelCost.get() - this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StFuelCostRange.min.get()) + " , fuelCost : " + this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.fuelCost.get());
    }
    ((IphonePickerView)localObject).setPickListener(new vct(this, (IphonePickerView)localObject, localbkho));
    localbkho.a(new vcu(this));
    localbkho.a((View)localObject, null);
    localbkho.show();
  }
  
  public String a()
  {
    return "QCirclePrivateMessageSettingContentPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    a();
  }
  
  public boolean a()
  {
    b();
    if (a() != null) {
      a().finish();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      if (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData != null) {
        this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.privilgetype.set(4);
      }
      a("1");
      continue;
      a(this.b);
      if (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData != null) {
        this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.privilgetype.set(3);
      }
      a("2");
      continue;
      a(this.c);
      if (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData != null) {
        this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.privilgetype.set(1);
      }
      a("3");
      continue;
      a(this.d);
      if (this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData != null) {
        this.jdField_a_of_type_QqcircleQQCirclePrivateMsgShow$StPMSettingData.privilgetype.set(2);
      }
      a("4");
      continue;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcq
 * JD-Core Version:    0.7.0.1
 */