import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class yrw
  extends ysa
  implements View.OnClickListener
{
  private ysf a;
  private int caR;
  private PhoneContactManagerImp e;
  ArrayList<PhoneContact> ri = new ArrayList();
  ArrayList<PhoneContact> rj = new ArrayList();
  
  public yrw(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.e = ((PhoneContactManagerImp)paramQQAppInterface.getManager(11));
    this.jdField_a_of_type_Ysf = ((ysf)paramQQAppInterface.getManager(34));
    this.e.a(this.e.cU());
    if (this.mApp.getApplication().getResources().getDisplayMetrics().widthPixels >= 1080) {}
    for (int i = 5;; i = 4)
    {
      this.caR = i;
      this.rj = this.e.bT();
      this.ri = ((ArrayList)this.rj.clone());
      int j = this.caR - this.ri.size();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.e.z(this.ri, i);
      return;
    }
  }
  
  private void a(yrw.a parama)
  {
    int i = this.e.xv();
    if ((i != 0) && (!this.jdField_a_of_type_Ytv.isReaded()))
    {
      aute.updateCustomNoteTxt(parama.LJ, 3, i, 0);
      return;
    }
    parama.LJ.setVisibility(8);
  }
  
  public View a(int paramInt, View paramView)
  {
    yrw.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof yrw.a)))
    {
      locala = new yrw.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131561501, null);
      locala.LJ = ((TextView)paramView.findViewById(2131381284));
      locala.LI = ((TextView)paramView.findViewById(2131373065));
      locala.xY = paramView.findViewById(2131373071);
      locala.xZ = paramView.findViewById(2131373072);
      locala.ya = paramView.findViewById(2131373073);
      locala.yb = paramView.findViewById(2131373074);
      locala.yc = paramView.findViewById(2131373075);
      locala.uz = ((ImageView)paramView.findViewById(2131368399));
      locala.uA = ((ImageView)paramView.findViewById(2131368400));
      locala.uB = ((ImageView)paramView.findViewById(2131368401));
      locala.uC = ((ImageView)paramView.findViewById(2131368402));
      locala.uD = ((ImageView)paramView.findViewById(2131368403));
      locala.LK = ((TextView)paramView.findViewById(2131372370));
      locala.LL = ((TextView)paramView.findViewById(2131372371));
      locala.LM = ((TextView)paramView.findViewById(2131372372));
      locala.LN = ((TextView)paramView.findViewById(2131372373));
      locala.LO = ((TextView)paramView.findViewById(2131372374));
      fI(locala.uz);
      fI(locala.uA);
      fI(locala.uB);
      fI(locala.uC);
      fI(locala.uD);
      paramView.setTag(locala);
    }
    Object localObject1;
    int j;
    Object localObject2;
    for (;;)
    {
      localObject1 = (ArrayList)this.e.cU();
      j = ((ArrayList)localObject1).size();
      locala.LI.setText(String.format(acfp.m(2131704359), new Object[] { Integer.valueOf(j) }));
      localObject2 = this.ri.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (this.e.b(((PhoneContact)((Iterator)localObject2).next()).mobileNo) == null) {
          ((Iterator)localObject2).remove();
        }
      }
      locala = (yrw.a)paramView.getTag();
    }
    paramInt = this.ri.size();
    int i = paramInt;
    if (paramInt < this.caR)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      i = paramInt;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PhoneContact)((Iterator)localObject1).next();
        if ((this.ri.contains(localObject2)) || (!((PhoneContact)localObject2).uin.equals("0"))) {
          break label1822;
        }
        this.ri.add(localObject2);
        paramInt += 1;
      }
    }
    label1822:
    for (;;)
    {
      if (paramInt == this.caR)
      {
        i = paramInt;
        switch (i)
        {
        default: 
          label556:
          if (AppSetting.enableTalkBack) {
            paramView.setContentDescription(String.format(acfp.m(2131704367), new Object[] { Integer.valueOf(j) }));
          }
          if (this.jdField_a_of_type_Ytv.isReaded()) {
            break;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        C(paramView, bool);
        a(locala);
        paramView.setOnClickListener(this);
        return paramView;
        break;
        locala.xY.setVisibility(0);
        locala.xZ.setVisibility(4);
        locala.ya.setVisibility(4);
        locala.yb.setVisibility(4);
        if (this.caR == 4) {
          locala.yc.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.ri.get(0);
          locala.aZC = ((PhoneContact)localObject1).unifiedCode;
          locala.uz.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZC));
          locala.LK.setText(((PhoneContact)localObject1).name);
          break;
          locala.yc.setVisibility(4);
        }
        locala.xY.setVisibility(0);
        locala.xZ.setVisibility(0);
        locala.ya.setVisibility(4);
        locala.yb.setVisibility(4);
        if (this.caR == 4) {
          locala.yc.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.ri.get(0);
          locala.aZC = ((PhoneContact)localObject1).unifiedCode;
          locala.uz.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZC));
          locala.LK.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.ri.get(1);
          locala.aZD = ((PhoneContact)localObject1).unifiedCode;
          locala.uA.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZD));
          locala.LL.setText(((PhoneContact)localObject1).name);
          break;
          locala.yc.setVisibility(4);
        }
        locala.xY.setVisibility(0);
        locala.xZ.setVisibility(0);
        locala.ya.setVisibility(0);
        locala.yb.setVisibility(4);
        if (this.caR == 4) {
          locala.yc.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.ri.get(0);
          locala.aZC = ((PhoneContact)localObject1).unifiedCode;
          locala.uz.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZC));
          locala.LK.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.ri.get(1);
          locala.aZD = ((PhoneContact)localObject1).unifiedCode;
          locala.uA.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZD));
          locala.LL.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.ri.get(2);
          locala.aZE = ((PhoneContact)localObject1).unifiedCode;
          locala.uB.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZE));
          locala.LM.setText(((PhoneContact)localObject1).name);
          break;
          locala.yc.setVisibility(4);
        }
        locala.xY.setVisibility(0);
        locala.xZ.setVisibility(0);
        locala.ya.setVisibility(0);
        locala.yb.setVisibility(0);
        if (this.caR == 4) {
          locala.yc.setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (PhoneContact)this.ri.get(0);
          locala.aZC = ((PhoneContact)localObject1).unifiedCode;
          locala.uz.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZC));
          locala.LK.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.ri.get(1);
          locala.aZD = ((PhoneContact)localObject1).unifiedCode;
          locala.uA.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZD));
          locala.LL.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.ri.get(2);
          locala.aZE = ((PhoneContact)localObject1).unifiedCode;
          locala.uB.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZE));
          locala.LM.setText(((PhoneContact)localObject1).name);
          localObject1 = (PhoneContact)this.ri.get(3);
          locala.aZF = ((PhoneContact)localObject1).unifiedCode;
          locala.uC.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZF));
          locala.LN.setText(((PhoneContact)localObject1).name);
          break;
          locala.yc.setVisibility(4);
        }
        locala.xY.setVisibility(0);
        locala.xZ.setVisibility(0);
        locala.ya.setVisibility(0);
        locala.yb.setVisibility(0);
        locala.yc.setVisibility(0);
        localObject1 = (PhoneContact)this.ri.get(0);
        locala.aZC = ((PhoneContact)localObject1).unifiedCode;
        locala.uz.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZC));
        locala.LK.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.ri.get(1);
        locala.aZD = ((PhoneContact)localObject1).unifiedCode;
        locala.uA.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZD));
        locala.LL.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.ri.get(2);
        locala.aZE = ((PhoneContact)localObject1).unifiedCode;
        locala.uB.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZE));
        locala.LM.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.ri.get(3);
        locala.aZF = ((PhoneContact)localObject1).unifiedCode;
        locala.uC.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZF));
        locala.LN.setText(((PhoneContact)localObject1).name);
        localObject1 = (PhoneContact)this.ri.get(4);
        locala.aZG = ((PhoneContact)localObject1).unifiedCode;
        locala.uD.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, locala.aZG));
        locala.LO.setText(((PhoneContact)localObject1).name);
        break label556;
      }
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
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof yrw.a)))
      {
        ContactBindedActivity.a(this.mApp, 222, this.rj);
        this.jdField_a_of_type_Ysf.clu();
        anot.a(this.mApp, "CliOper", "", "", "0X8006A70", "0X8006A70", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static class a
    extends ysa.a
  {
    public TextView LI;
    public TextView LJ;
    public TextView LK;
    public TextView LL;
    public TextView LM;
    public TextView LN;
    public TextView LO;
    public String aZC;
    public String aZD;
    public String aZE;
    public String aZF;
    public String aZG;
    public ImageView uA;
    public ImageView uB;
    public ImageView uC;
    public ImageView uD;
    public ImageView uz;
    public View xY;
    public View xZ;
    public View ya;
    public View yb;
    public View yc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrw
 * JD-Core Version:    0.7.0.1
 */