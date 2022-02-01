import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class agyh
  extends agxu
{
  private View CZ;
  private View Da;
  private View Db;
  private View Dc;
  private View Dd;
  private View De;
  private XListView O;
  private TextView SR;
  private TextView SS;
  private TextView ST;
  private TextView SU;
  private TextView SV;
  private TextView SW;
  private TextView SX;
  private TriangleView a;
  private ProgressBar ad;
  private sms c;
  private int cYS;
  private RelativeLayout kt;
  private TextView mFileName;
  private TextView nO;
  
  public agyh(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void D(View.OnClickListener paramOnClickListener)
  {
    super.D(paramOnClickListener);
    this.kt = ((RelativeLayout)this.CS.findViewById(2131380163));
    this.ad = ((ProgressBar)this.CS.findViewById(2131380128));
    this.SX = ((TextView)this.CS.findViewById(2131380138));
    this.De = this.CS.findViewById(2131380126);
    this.De.setOnClickListener(paramOnClickListener);
  }
  
  public void JA(String paramString)
  {
    this.SR.setText(paramString);
  }
  
  public void JB(String paramString)
  {
    this.SV.setText(paramString);
    Kb(true);
  }
  
  public void JK(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.kt;
    if (this.cYS == 2) {
      localRelativeLayout = this.kp;
    }
    for (;;)
    {
      if (localRelativeLayout != null) {
        if (!paramBoolean) {
          break label43;
        }
      }
      label43:
      for (int i = 0;; i = 8)
      {
        localRelativeLayout.setVisibility(i);
        if (paramBoolean) {
          JQ(false);
        }
        return;
      }
    }
  }
  
  public void JQ(boolean paramBoolean)
  {
    int i = 0;
    if (this.SW != null)
    {
      if (this.kp == null) {
        break label49;
      }
      if ((paramBoolean) && (this.kp.getVisibility() != 0)) {
        this.SW.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.SW.setVisibility(8);
    return;
    label49:
    TextView localTextView = this.SW;
    if (paramBoolean) {}
    for (;;)
    {
      localTextView.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void JY(boolean paramBoolean)
  {
    View localView = this.Db;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void JZ(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.Dd.setVisibility(8);
      return;
    }
    this.Dd.setVisibility(0);
    this.ST.setVisibility(0);
    this.SU.setVisibility(0);
    this.cYS = 0;
  }
  
  public void Jn(String paramString)
  {
    if (this.kt != null) {
      this.SX.setText(paramString);
    }
    if (this.SD != null) {
      this.SD.setText(paramString);
    }
  }
  
  public void Jy(String paramString)
  {
    this.ST.setText(paramString);
  }
  
  public void Jz(String paramString)
  {
    this.SU.setText(paramString);
  }
  
  public void Ka(boolean paramBoolean)
  {
    View localView;
    if (this.Da != null)
    {
      localView = this.Da;
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (paramBoolean) {
        this.cYS = 1;
      }
      return;
    }
  }
  
  public void Kb(boolean paramBoolean)
  {
    TextView localTextView = this.SV;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void Kc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.CS.setBackgroundResource(2130838900);
      this.a.setColor(this.mContext.getResources().getColor(2131167595));
      this.nO.setTextColor(this.mContext.getResources().getColor(2131166632));
      this.ST.setTextColor(this.mContext.getResources().getColor(2131167385));
      return;
    }
    this.CS.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.a.setColor(Color.parseColor("#ffffffff"));
    this.Dc.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.nO.setTextColor(this.mContext.getResources().getColor(2131166631));
    this.ST.setTextColor(this.mContext.getResources().getColor(2131165381));
  }
  
  public void OJ(int paramInt)
  {
    if (this.ad != null) {
      this.ad.setProgress(paramInt);
    }
    if (this.ac != null) {
      this.ac.setProgress(paramInt);
    }
  }
  
  public void a(List<agxi.a> paramList, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, short paramShort)
  {
    this.c.ff(paramList);
    this.c.filePath = "/";
    this.c.nSessionId = paramLong1;
    this.c.troopUin = paramLong2;
    this.c.aEI = paramString2;
    this.c.aEJ = paramString3;
    this.c.aEK = paramString4;
    this.c.str_download_dns = paramString5;
    this.c.a(paramBoolean, paramString6, paramShort);
    this.O.setAdapter(this.c);
    this.CZ.setVisibility(0);
    this.Da.setVisibility(8);
    this.Dd.setVisibility(8);
    this.cYS = 2;
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    View localView = this.Db;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.nO.setText(paramString);
      this.nO.setOnClickListener(paramOnClickListener);
      if (this.cYS != 2) {
        this.Db.setVisibility(8);
      }
      return;
    }
  }
  
  public View ca()
  {
    return this.CS;
  }
  
  public void dkE()
  {
    this.CZ.setPadding(0, this.CZ.getPaddingTop(), 0, 0);
    this.Db.setVisibility(8);
  }
  
  public void dkq()
  {
    QLog.i("ZipFileViewer<QFile>", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131561069, this.mRootView, false);
      this.O = ((XListView)this.CS.findViewById(2131367072));
      this.SR = ((TextView)this.CS.findViewById(2131372574));
      this.mFileName = ((TextView)this.CS.findViewById(2131381328));
      this.SS = ((TextView)this.CS.findViewById(2131381343));
      this.Dc = this.CS.findViewById(2131382448);
      this.CZ = this.CS.findViewById(2131382453);
      this.Da = this.CS.findViewById(2131373576);
      this.Db = this.CS.findViewById(2131367172);
      this.nO = ((TextView)this.CS.findViewById(2131380667));
      this.SV = ((TextView)this.CS.findViewById(2131381037));
      this.SV.setVisibility(8);
      this.a = ((TriangleView)this.CS.findViewById(2131380179));
      this.c = new sms(null, this.mContext);
      this.Dd = this.CS.findViewById(2131373573);
      this.ST = ((TextView)this.Dd.findViewById(2131382451));
      this.SU = ((TextView)this.Dd.findViewById(2131382449));
      this.SF = ((TextView)this.CS.findViewById(2131372657));
      this.SW = ((TextView)this.CS.findViewById(2131361960));
    }
  }
  
  public void f(String paramString, View.OnClickListener paramOnClickListener)
  {
    super.f(paramString, paramOnClickListener);
    this.nO.setText(paramString);
  }
  
  public void fS(String paramString1, String paramString2)
  {
    this.mFileName.setText(paramString1);
    this.SS.setText(paramString2);
  }
  
  public void fT(String paramString1, String paramString2)
  {
    if (this.c != null) {
      this.c.notifyDataSetChanged();
    }
  }
  
  public void g(String paramString, View.OnClickListener paramOnClickListener)
  {
    if (this.SW != null)
    {
      this.SW.setText(paramString);
      this.SW.setOnClickListener(paramOnClickListener);
      JQ(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyh
 * JD-Core Version:    0.7.0.1
 */