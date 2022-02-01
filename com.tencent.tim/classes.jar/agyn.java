import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class agyn
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ausj.b
{
  private final List<String> BL;
  private final agyi.a jdField_a_of_type_Agyi$a;
  private final agyi jdField_a_of_type_Agyi;
  private final FormSimpleItem aD;
  private final FormSimpleItem aE;
  private ausj ag;
  private final FormSwitchItem bd;
  private final FormSwitchItem be;
  private final boolean cfT;
  
  public agyn(agyi paramagyi, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Agyi = paramagyi;
    this.cfT = paramBoolean;
    this.jdField_a_of_type_Agyi$a = new agyi.a();
    paramagyi = BaseApplicationImpl.sApplication;
    this.BL = new ArrayList();
    this.BL.add(paramagyi.getString(2131700334));
    this.BL.add(paramagyi.getString(2131700333));
    this.BL.add(paramagyi.getString(2131700335));
    this.aD = ((FormSimpleItem)paramView.findViewById(2131378127));
    Object localObject = this.aD;
    if (this.cfT)
    {
      i = 2131700336;
      ((FormSimpleItem)localObject).setLeftText(paramagyi.getString(i));
      this.aD.setRightText((CharSequence)this.BL.get(EK()));
      this.aD.setOnClickListener(this);
      this.bd = ((FormSwitchItem)paramView.findViewById(2131378126));
      this.aE = ((FormSimpleItem)paramView.findViewById(2131378140));
      this.bd.setChecked(this.jdField_a_of_type_Agyi$a.cfR);
      this.bd.setOnCheckedChangeListener(this);
      Kd(false);
      localObject = (TextView)paramView.findViewById(2131378142);
      if (!this.cfT) {
        break label333;
      }
    }
    label333:
    for (int i = 2131700339;; i = 2131700338)
    {
      ((TextView)localObject).setText(paramagyi.getString(i));
      this.be = ((FormSwitchItem)paramView.findViewById(2131378124));
      this.be.setChecked(this.jdField_a_of_type_Agyi$a.cfS);
      this.be.setOnCheckedChangeListener(this);
      this.be.setVisibility(8);
      paramView.findViewById(2131378125).setVisibility(8);
      if (this.cfT)
      {
        this.bd.setVisibility(8);
        this.aD.setBgType(0);
      }
      return;
      i = 2131700332;
      break;
    }
  }
  
  private int EK()
  {
    int i = 1;
    if (this.jdField_a_of_type_Agyi$a.cYT == 1) {
      i = 0;
    }
    while (this.jdField_a_of_type_Agyi$a.cYT == 2) {
      return i;
    }
    return 2;
  }
  
  private void Kd(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = this.aE;
    agyi.a locala = this.jdField_a_of_type_Agyi$a;
    Object localObject;
    if (this.jdField_a_of_type_Agyi$a.cfR)
    {
      localObject = agyj.eh(6);
      locala.aRN = ((String)localObject);
      localFormSimpleItem.setRightText((CharSequence)localObject);
      localObject = this.aE;
      if (!this.jdField_a_of_type_Agyi$a.cfR) {
        break label104;
      }
      i = 0;
      label57:
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.bd;
      if (!this.jdField_a_of_type_Agyi$a.cfR) {
        break label110;
      }
    }
    label104:
    label110:
    for (int i = 2;; i = 3)
    {
      ((FormSwitchItem)localObject).setBgType(i);
      if (paramBoolean) {
        this.jdField_a_of_type_Agyi.dkF();
      }
      return;
      localObject = "";
      break;
      i = 8;
      break label57;
    }
  }
  
  private void dkO()
  {
    if (this.ag == null)
    {
      this.ag = ((ausj)auss.b(this.jdField_a_of_type_Agyi.e(), null));
      Object localObject = this.ag;
      if (this.cfT) {}
      for (int i = 2131700336;; i = 2131700332)
      {
        ((ausj)localObject).setMainTitle(i);
        localObject = this.BL.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.ag.addRadioButton(str, false);
        }
      }
      this.ag.addCancelButton(2131721058);
      this.ag.a(this);
    }
    this.ag.clearAllRadioBtnCheckStatus();
    this.ag.setRadioButtonChecked(EK());
    if (!this.ag.isShowing()) {
      this.ag.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    int i = 1;
    if ((this.ag != null) && (this.ag.isShowing())) {
      this.ag.dismiss();
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt == this.jdField_a_of_type_Agyi$a.cYT) {
        break label90;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Agyi$a.cYT = paramInt;
      this.aD.setRightText(paramString);
      if (i != 0) {
        this.jdField_a_of_type_Agyi.dkF();
      }
      return;
      if (paramInt == 1)
      {
        paramInt = 2;
        break;
      }
      paramInt = 3;
      break;
      label90:
      i = 0;
    }
  }
  
  public agyi.a a()
  {
    return this.jdField_a_of_type_Agyi$a;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    boolean bool = true;
    if (paramCompoundButton.equals(this.bd.a())) {
      if (this.jdField_a_of_type_Agyi$a.cfR != paramBoolean)
      {
        this.jdField_a_of_type_Agyi$a.cfR = paramBoolean;
        Kd(bool);
      }
    }
    while (!paramCompoundButton.equals(this.be.a())) {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    if (this.jdField_a_of_type_Agyi$a.cfS != paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Agyi$a.cfS = paramBoolean;
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_Agyi.dkF();
      break;
      i = 0;
    }
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
      dkO();
    }
  }
  
  public void onDestroy()
  {
    if (this.ag != null)
    {
      this.ag.superDismiss();
      this.ag = null;
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.aD != null) {
      this.aD.setEnabled(paramBoolean);
    }
    if (this.bd != null) {
      this.bd.setEnabled(paramBoolean);
    }
    if (this.aE != null) {
      this.aE.setEnabled(paramBoolean);
    }
    if (this.be != null) {
      this.be.setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyn
 * JD-Core Version:    0.7.0.1
 */