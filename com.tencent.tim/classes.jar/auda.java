import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.widgets.TriangleView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class auda
  extends aucp
{
  private View CZ;
  private View Da;
  private View Db;
  private View Dc;
  private View KL;
  private XListView O;
  private TextView SR;
  private TextView SS;
  private TriangleView a;
  private TextView afm;
  private TextView afn;
  private sms c;
  private TextView mFileName;
  private TextView nO;
  
  public auda(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void JA(String paramString)
  {
    this.SR.setText(paramString);
  }
  
  public void JY(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.nO != null)
    {
      localTextView = this.nO;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void Jy(String paramString)
  {
    this.afn.setText(paramString);
  }
  
  public void Kc(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.CS.setBackgroundResource(2130838900);
      this.a.setColor(this.mContext.getResources().getColor(2131167595));
      this.nO.setTextColor(this.mContext.getResources().getColor(2131166632));
      return;
    }
    this.CS.setBackgroundColor(Color.parseColor("#ffffffff"));
    this.a.setColor(Color.parseColor("#ffffffff"));
    this.Dc.setBackgroundColor(Color.parseColor("#fff7f7f8"));
    this.nO.setTextColor(this.mContext.getResources().getColor(2131166631));
  }
  
  public void a(CharSequence paramCharSequence, MovementMethod paramMovementMethod)
  {
    this.Da.setVisibility(8);
    this.CZ.setVisibility(8);
    this.Db.setVisibility(8);
    JK(false);
    this.afm.setVisibility(0);
    this.KL.setVisibility(0);
    this.afm.setMovementMethod(paramMovementMethod);
    this.afm.setText(paramCharSequence);
  }
  
  public void a(List<agxi.a> paramList, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.c.ff(paramList);
    this.c.filePath = "/";
    this.c.nSessionId = paramLong1;
    this.c.troopUin = paramLong2;
    this.c.aEI = paramString2;
    this.c.aEJ = paramString3;
    this.c.aEK = paramString4;
    this.c.str_download_dns = paramString5;
    this.O.setAdapter(this.c);
    this.Da.setVisibility(8);
    this.CZ.setVisibility(0);
    this.KL.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.nO;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      this.nO.setText(paramString);
      this.nO.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public void b(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    View localView = this.CS.findViewById(2131372657);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      localView.setOnClickListener(paramOnClickListener);
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
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: ZipFileViewer initFileView");
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
      this.Da.setVisibility(0);
      this.Db = this.CS.findViewById(2131367172);
      this.afm = ((TextView)this.CS.findViewById(2131381037));
      this.afm.setVisibility(8);
      this.KL = this.CS.findViewById(2131373573);
      this.afn = ((TextView)this.KL.findViewById(2131382451));
      this.a = ((TriangleView)this.CS.findViewById(2131380179));
      this.nO = ((TextView)this.CS.findViewById(2131380667));
      this.SF = ((TextView)this.CS.findViewById(2131372657));
      this.c = new sms(null, this.mContext);
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auda
 * JD-Core Version:    0.7.0.1
 */