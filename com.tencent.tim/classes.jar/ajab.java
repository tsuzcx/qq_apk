import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;

public class ajab
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private Switch G;
  private ajab.a a;
  private boolean cnb = true;
  private int dhl = 0;
  private Button gA;
  private Button gB;
  private Button gC;
  private Button gz;
  private RelativeLayout kR;
  private QQAppInterface mApp;
  private Button mCancelBtn;
  private Context mContext;
  private View rootView;
  private ArrayList<Button> xz = new ArrayList();
  
  public ajab(Context paramContext, QQAppInterface paramQQAppInterface, ajab.a parama)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.a = parama;
    initView();
  }
  
  private void Qw(int paramInt)
  {
    this.dhl = paramInt;
    if (this.xz != null)
    {
      int i = 0;
      if (i < this.xz.size())
      {
        Button localButton = (Button)this.xz.get(i);
        if (localButton != null)
        {
          if ((localButton.getTag() == null) || (!(localButton.getTag() instanceof Integer)) || (paramInt != ((Integer)localButton.getTag()).intValue())) {
            break label85;
          }
          a(true, localButton);
        }
        for (;;)
        {
          i += 1;
          break;
          label85:
          a(false, localButton);
        }
      }
    }
  }
  
  private void bCi()
  {
    if (this.mApp == null)
    {
      QLog.e("MatchChatFilterFragment", 2, "Save Seting but bull mApp");
      return;
    }
    afwh.z(this.mApp, this.dhl);
    boolean bool = afwh.a(this.mApp).booleanValue();
    if (this.cnb != bool) {
      if (this.cnb) {
        break label142;
      }
    }
    label142:
    for (int i = 1;; i = 0)
    {
      anot.a(this.mApp, "dc00898", "", "", "0X800A690", "0X800A690", i, 0, "", "", "", "");
      afsg localafsg = (afsg)this.mApp.getBusinessHandler(127);
      if (localafsg == null) {
        break;
      }
      localafsg.B(this.mApp.getCurrentUin(), this.cnb);
      return;
      QLog.i("MatchChatFilterFragment", 2, "saveSetting getMatchSwitchOpenFromSp unchanged " + bool);
      return;
    }
  }
  
  private void initView()
  {
    this.rootView = View.inflate(this.mContext, 2131561331, null);
    View localView;
    if (this.rootView != null)
    {
      this.kR = ((RelativeLayout)this.rootView.findViewById(2131367085));
      localView = this.rootView.findViewById(2131365991);
      if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        break label313;
      }
      this.kR.setBackgroundResource(2130846039);
      localView.setBackgroundColor(-14540254);
    }
    for (;;)
    {
      this.kR.setOnClickListener(this);
      this.gz = ((Button)this.rootView.findViewById(2131364339));
      this.gz.setTag(Integer.valueOf(0));
      this.gz.setOnClickListener(this);
      this.xz.add(this.gz);
      this.gB = ((Button)this.rootView.findViewById(2131363713));
      this.gB.setTag(Integer.valueOf(1));
      this.gB.setOnClickListener(this);
      this.xz.add(this.gB);
      this.gA = ((Button)this.rootView.findViewById(2131368064));
      this.gA.setTag(Integer.valueOf(2));
      this.gA.setOnClickListener(this);
      this.xz.add(this.gA);
      this.G = ((Switch)this.rootView.findViewById(2131379052));
      this.G.setOnCheckedChangeListener(this);
      this.mCancelBtn = ((Button)this.rootView.findViewById(2131364221));
      this.mCancelBtn.setOnClickListener(this);
      this.gC = ((Button)this.rootView.findViewById(2131379019));
      this.gC.setOnClickListener(this);
      this.rootView.findViewById(2131369521).setOnClickListener(this);
      dvJ();
      return;
      label313:
      this.kR.setBackgroundResource(2130846038);
      localView.setBackgroundColor(-1315339);
    }
  }
  
  public void LL(boolean paramBoolean)
  {
    this.cnb = paramBoolean;
    if (this.G != null) {
      this.G.setChecked(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Button paramButton)
  {
    if (paramBoolean)
    {
      paramButton.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130838048));
      paramButton.setTextColor(this.mContext.getResources().getColor(2131167654));
      return;
    }
    paramButton.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839559));
    paramButton.setTextColor(this.mContext.getResources().getColor(2131167337));
  }
  
  public void dvJ()
  {
    boolean bool = afwh.a(this.mApp).booleanValue();
    int i = afwh.K(this.mApp);
    LL(bool);
    km(i);
  }
  
  public void dvK()
  {
    if (this.a != null) {
      this.a.ddp();
    }
  }
  
  public View getView()
  {
    return this.rootView;
  }
  
  public boolean km(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 1))
    {
      Qw(paramInt);
      return true;
    }
    QLog.e("MatchChatFilterFragment", 2, "unknown sextype" + paramInt);
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.cnb = paramBoolean;
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
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
      if ((localObject != null) && ((localObject instanceof Integer)))
      {
        Qw(((Integer)localObject).intValue());
      }
      else
      {
        QLog.e("MatchChatFilterFragment", 2, "click unknown sex type tag button :" + paramView.getId());
        continue;
        bCi();
        dvK();
        continue;
        QLog.d("MatchChatFilterFragment", 2, "cancel filter");
        dvK();
        continue;
        QLog.d("MatchChatFilterFragment", 2, "filter_content click");
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.d("TAG", 2, "filterContentView onDestroy");
    this.xz.clear();
    this.mContext = null;
    this.mApp = null;
  }
  
  public static abstract interface a
  {
    public abstract void ddp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajab
 * JD-Core Version:    0.7.0.1
 */