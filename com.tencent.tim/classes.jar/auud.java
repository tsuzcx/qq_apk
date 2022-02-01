import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class auud
  extends PopupWindow
  implements View.OnClickListener
{
  protected ImageView Hn;
  private ImageView Ho;
  private ImageView Hp;
  private View Ls;
  protected auud.a a;
  protected auud.b a;
  private Activity activity;
  private Button[] b;
  protected Button bU;
  private int bbr;
  private int bbs;
  private View contentView;
  protected boolean dkC = true;
  private boolean dkD;
  protected int[] du = { 2131381267, 2131381268, 2131381269, 2131381270, 2131381271, 2131381272, 2131381273, 2131381274 };
  protected int[] dv = { 2131381262, 2131381263, 2131381264, 2131381265 };
  protected int etN;
  private RelativeLayout fm;
  private Button hN;
  private boolean hasInit;
  protected ArrayList<DislikeInfo> lE;
  protected ArrayList<DislikeInfo> lF;
  private View maskView;
  private RelativeLayout nG;
  private int screenHeight;
  private int screenWidth;
  private TextView tips;
  private View[] z;
  
  public auud(Activity paramActivity)
  {
    super(paramActivity);
    this.activity = paramActivity;
  }
  
  private void exd()
  {
    resetUI();
    int i = this.lE.size();
    if (i >= this.b.length)
    {
      i = this.b.length;
      j = 0;
      label29:
      if (j >= i) {
        break label121;
      }
      if (!TextUtils.isEmpty(((DislikeInfo)this.lE.get(j)).agQ)) {
        break label85;
      }
      this.b[j].setVisibility(8);
    }
    for (;;)
    {
      this.b[j].setSelected(false);
      j += 1;
      break label29;
      break;
      label85:
      this.b[j].setVisibility(0);
      this.b[j].setText(((DislikeInfo)this.lE.get(j)).agQ);
    }
    label121:
    int j = i;
    if (j < this.b.length)
    {
      if ((j == i) && (i % 2 == 1)) {
        this.b[j].setVisibility(4);
      }
      for (;;)
      {
        this.b[j].setSelected(false);
        j += 1;
        break;
        this.b[j].setVisibility(8);
      }
    }
    i = 1;
    if (i < this.b.length)
    {
      if (this.b[i].getVisibility() == 8) {
        this.z[(i / 2)].setVisibility(8);
      }
      for (;;)
      {
        i += 2;
        break;
        this.z[(i / 2)].setVisibility(0);
      }
    }
  }
  
  private void exe()
  {
    this.contentView.measure(0, 0);
    this.bbs = this.contentView.getMeasuredHeight();
  }
  
  private void resetUI()
  {
    this.tips.setText(this.activity.getString(2131701912));
    this.bU.setEnabled(false);
  }
  
  public void a(View paramView, auud.b paramb)
  {
    this.jdField_a_of_type_Auud$b = paramb;
    d(paramView.getWindowToken());
    paramb = new int[2];
    paramView.getLocationOnScreen(paramb);
    int j;
    int i;
    int n;
    if (!this.dkD)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "DeviceInfoUtil.getWidth() = " + this.screenWidth + ", DeviceInfoUtil.getHeight() = " + this.screenHeight);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "popupWidth = " + this.bbr + ", popupHeight = " + this.bbs);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "x = " + paramb[0] + ", y = " + paramb[1]);
      }
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "parent.getWidth() = " + paramView.getWidth() + ", parent.getHeight() = " + paramView.getHeight());
      }
      j = this.screenHeight;
      int k = paramb[1];
      int m = paramView.getHeight();
      i = paramb[1];
      i = (int)this.activity.getResources().getDimension(2131299225);
      n = this.bbr - paramb[0] - paramView.getWidth() / 2 + i;
      if (QLog.isColorLevel()) {
        QLog.d("KandianPopupWindow", 2, "marginRight = " + n);
      }
      if (j - (k + m) > this.bbs) {
        if (n > this.bbr * 0.1D)
        {
          setAnimationStyle(2131755042);
          this.Ho.setPadding(0, 0, n, 0);
          this.Ho.setVisibility(0);
          this.Hp.setVisibility(8);
          j = paramb[1] + paramView.getHeight() / 2 + wja.dp2px(9.5F, this.activity.getResources());
          showAtLocation(paramView, 0, i, j);
          if (QLog.isColorLevel()) {
            QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
          }
        }
      }
    }
    for (;;)
    {
      kxm.aih = true;
      return;
      setAnimationStyle(2131755041);
      break;
      if (n > this.bbr * 0.1D) {
        setAnimationStyle(2131755045);
      }
      for (;;)
      {
        this.Hp.setPadding(0, 0, n, 0);
        this.Ho.setVisibility(8);
        this.Hp.setVisibility(0);
        j = paramb[1] + paramView.getHeight() / 2 - wja.dp2px(9.5F, this.activity.getResources()) - this.bbs;
        showAtLocation(paramView, 0, i, j);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("KandianPopupWindow", 2, "show x = " + i + ", show y = " + j);
        break;
        setAnimationStyle(2131755044);
      }
      setAnimationStyle(2131755043);
      showAtLocation(paramView, 0, paramb[0] + paramView.getWidth() / 2 - wja.dp2px(10.5F, this.activity.getResources()) - (int)this.activity.getResources().getDimension(2131299226), paramb[1] + paramView.getHeight() / 2 - this.bbs / 2);
    }
  }
  
  public void a(auud.a parama)
  {
    this.jdField_a_of_type_Auud$a = parama;
  }
  
  public boolean a(int paramInt, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramInt == -1) {
      return false;
    }
    this.etN = paramInt;
    if (this.lF == null) {
      this.lF = new ArrayList();
    }
    while ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.dkD = true;
      this.nG.setVisibility(8);
      this.hN.setVisibility(0);
      this.bbr = ((int)this.activity.getResources().getDimension(2131299226));
      setWidth(this.bbr);
      exe();
      return true;
      this.lF.clear();
    }
    this.dkD = false;
    this.nG.setVisibility(0);
    this.hN.setVisibility(8);
    this.bbr = ((int)(this.screenWidth - this.activity.getResources().getDimension(2131299225) * 2.0F));
    setWidth(this.bbr);
    if (this.lE == null) {
      this.lE = new ArrayList();
    }
    for (;;)
    {
      this.lE.addAll(paramArrayList);
      exd();
      break;
      this.lE.clear();
    }
  }
  
  protected void d(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    localLayoutParams.format = -3;
    localLayoutParams.type = 1000;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.windowAnimations = 16973828;
    this.maskView = new View(this.activity.getApplicationContext());
    this.maskView.setBackgroundColor(-1895825408);
    this.maskView.setFitsSystemWindows(false);
    this.maskView.setOnKeyListener(new auuf(this));
    this.activity.getWindowManager().addView(this.maskView, localLayoutParams);
  }
  
  protected void dIv()
  {
    if (this.maskView != null)
    {
      this.activity.getWindowManager().removeView(this.maskView);
      this.maskView = null;
    }
  }
  
  public void exc()
  {
    if (this.fm != null) {
      this.fm.setVisibility(0);
    }
    if (this.Ls != null) {
      this.Ls.setBackgroundResource(2130843867);
    }
    if (this.Hp != null)
    {
      this.Hp.setImageResource(2130843876);
      if (RelativeLayout.LayoutParams.class.isInstance(this.Hp.getLayoutParams()))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Hp.getLayoutParams();
        localLayoutParams.addRule(3, 2131381259);
        this.Hp.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public boolean hasInit()
  {
    return this.hasInit;
  }
  
  public void initPopupWindow()
  {
    this.screenWidth = ((int)aqgz.hK());
    this.screenHeight = ((int)aqgz.hL());
    this.contentView = ((LayoutInflater)this.activity.getSystemService("layout_inflater")).inflate(2131560268, null);
    setContentView(this.contentView);
    this.nG = ((RelativeLayout)this.contentView.findViewById(2131381266));
    this.hN = ((Button)this.contentView.findViewById(2131381258));
    this.hN.setOnClickListener(this);
    this.Ls = this.contentView.findViewById(2131381260);
    this.tips = ((TextView)this.contentView.findViewById(2131381275));
    this.bU = ((Button)this.contentView.findViewById(2131381257));
    this.bU.setOnClickListener(this);
    this.bU.setEnabled(false);
    this.Hn = ((ImageView)this.contentView.findViewById(2131381261));
    this.fm = ((RelativeLayout)this.contentView.findViewById(2131381259));
    this.fm.setOnClickListener(this);
    this.Ho = ((ImageView)this.contentView.findViewById(2131381278));
    this.Hp = ((ImageView)this.contentView.findViewById(2131381277));
    this.z = new View[this.dv.length];
    int i = 0;
    while (i < this.dv.length)
    {
      this.z[i] = this.contentView.findViewById(this.dv[i]);
      i += 1;
    }
    this.b = new Button[this.du.length];
    i = 0;
    while (i < this.du.length)
    {
      this.b[i] = ((Button)this.contentView.findViewById(this.du[i]));
      this.b[i].setOnClickListener(this);
      i += 1;
    }
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOnDismissListener(new auue(this));
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    this.hasInit = true;
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
      if (i < this.du.length) {
        if (paramView.getId() != this.du[i]) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (i != -1)
      {
        if (!this.b[i].isSelected()) {
          break label204;
        }
        this.b[i].setSelected(false);
        this.lF.remove(this.lE.get(i));
        label99:
        if (this.lF.size() != 0) {
          break label281;
        }
        this.tips.setText(this.activity.getString(2131701912));
        this.bU.setEnabled(false);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Auud$b != null) {
          this.jdField_a_of_type_Auud$b.a(paramView, this.etN, this.lF, null);
        }
        dismiss();
        continue;
        if (this.jdField_a_of_type_Auud$a != null) {
          this.jdField_a_of_type_Auud$a.aNT();
        }
        dismiss();
        continue;
        i += 1;
        break;
        label204:
        if (!this.dkC)
        {
          Button[] arrayOfButton = this.b;
          int k = arrayOfButton.length;
          int j = 0;
          while (j < k)
          {
            arrayOfButton[j].setSelected(false);
            j += 1;
          }
          this.lF.clear();
        }
        this.b[i].setSelected(true);
        this.lF.add(this.lE.get(i));
        break label99;
        label281:
        if (this.dkC) {
          this.tips.setText(String.format(this.activity.getString(2131701913), new Object[] { Integer.valueOf(this.lF.size()) }));
        }
        this.bU.setEnabled(true);
      }
      i = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aNT();
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auud
 * JD-Core Version:    0.7.0.1
 */