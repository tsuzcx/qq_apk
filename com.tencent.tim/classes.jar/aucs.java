import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.tim.filemanager.fileviewer.viewer.SimpleFileViewer.1;
import com.tencent.tim.teamwork.TeamWorkFileImportInfo;

public class aucs
  extends aucp
{
  private View CX;
  private View KG;
  private View KH;
  private View KK;
  private arhz P;
  private TextView SI;
  private TextView SJ;
  private TextView SK;
  private TextView SL;
  private TextView afj;
  private TextView afk;
  private TextView afl;
  AsyncImageView jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private TbsReaderView jdField_c_of_type_ComTencentTbsReaderTbsReaderView;
  private RelativeLayout nB;
  
  public aucs(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void JR(boolean paramBoolean)
  {
    TextView localTextView = this.SJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void Jr(String paramString)
  {
    if (this.SI.getMeasuredWidth() <= 0)
    {
      this.SI.post(new SimpleFileViewer.1(this, paramString));
      return;
    }
    this.SI.setText(audx.a(paramString, false, this.SI.getMeasuredWidth(), this.SI.getPaint(), 2));
  }
  
  public void Js(String paramString)
  {
    this.SJ.setText(paramString);
  }
  
  public void Jt(String paramString)
  {
    this.SK.setText(paramString);
  }
  
  public void Ju(String paramString)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void OO(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void OP(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void VG(boolean paramBoolean)
  {
    if (this.afl == null) {}
    float f;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      this.afl.setVisibility(0);
      f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if (this.SF.getVisibility() == 4)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.afl.getLayoutParams();
        localLayoutParams.topMargin = ((int)(f * -56.0F));
        this.afl.setLayoutParams(localLayoutParams);
        this.afl.invalidate();
        return;
      }
    } while (this.SF.getVisibility() != 8);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.afl.getLayoutParams();
    localLayoutParams.topMargin = ((int)(f * 14.0F));
    this.afl.setLayoutParams(localLayoutParams);
    this.afl.invalidate();
    return;
    this.afl.setVisibility(8);
  }
  
  public void VH(boolean paramBoolean)
  {
    TextView localTextView = this.afj;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void VI(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.afk != null)
    {
      localTextView = this.afk;
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
  
  public void Zm(String paramString)
  {
    this.afj.setText(paramString);
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.SK.setMovementMethod(LinkMovementMethod.getInstance());
    this.SK.setText(paramSpannableString);
    this.SK.setHighlightColor(0);
  }
  
  public void a(String paramString, atxy.a parama)
  {
    this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView = atxy.a().a(this.mContext, paramString, parama, true);
    if (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView != null)
    {
      if (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView.getParent() != null) {
        ((ViewGroup)this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView.getParent()).removeAllViews();
      }
      if (this.nB != null) {
        break label97;
      }
      this.nB = new RelativeLayout(this.mContext);
    }
    for (;;)
    {
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      this.nB.addView(this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView, 0, paramString);
      euG();
      return;
      label97:
      this.nB.removeAllViews();
    }
  }
  
  public void a(String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (this.afk == null)
    {
      this.afk = ((TextView)this.CS.findViewById(2131372654));
      this.afk.setHighlightColor(17170445);
    }
    paramString = this.afk;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      this.afk.setOnClickListener(paramOnClickListener);
      return;
    }
  }
  
  public boolean amE()
  {
    return (this.nB != null) && (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView != null) && (this.CX != null) && (this.CX.getVisibility() == 0) && (this.nB.getVisibility() == 0) && (this.CX.getVisibility() == 0);
  }
  
  public void b(SpannableString paramSpannableString)
  {
    if (this.afl == null) {
      return;
    }
    this.afl.setMovementMethod(LinkMovementMethod.getInstance());
    this.afl.setText(paramSpannableString);
    this.afl.setHighlightColor(0);
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      break label4;
    }
    label4:
    while ((this.nB == null) || (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView == null) || (!(BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 70;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 140;
    this.CX = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131559117, this.mRootView, false);
    this.CX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.nB.addView(this.CX);
    this.CX.setVisibility(0);
    this.KG = this.CX.findViewById(2131380969);
    this.KH = this.CX.findViewById(2131380970);
    localObject = localQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + localQQAppInterface.getCurrentUin(), 0);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("tim_convert_teamwork_open_with_share_doc", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("tim_convert_teamwork_open_file_in_tim", false);
    if (!bool1)
    {
      if (this.KG != null) {
        this.KG.setVisibility(8);
      }
      label248:
      if (bool2) {
        break label364;
      }
      if (this.KH != null) {
        this.KH.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.KG != null) && (bool1)) {
        this.KG.setOnClickListener(new auct(this, localQQAppInterface, paramTeamWorkFileImportInfo));
      }
      if ((this.KH == null) || (!bool2)) {
        break;
      }
      this.KH.setOnClickListener(new aucu(this, localQQAppInterface, paramTeamWorkFileImportInfo));
      return;
      anot.a(localQQAppInterface, "CliOper", "", "", "0X8008D2C", "0X8008A2F", 0, 0, "", "", "", "");
      break label248;
      label364:
      anot.a(localQQAppInterface, "CliOper", "", "", "0X8008A30", "0X8008A30", 0, 0, "", "", "", "");
    }
  }
  
  public View ca()
  {
    if ((this.nB != null) && (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView != null))
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      this.CS = this.nB;
    }
    return this.CS;
  }
  
  public View cb()
  {
    return this.CX;
  }
  
  public void cj(String paramString, boolean paramBoolean)
  {
    if (this.SL == null) {
      this.SL = ((TextView)this.CS.findViewById(2131364706));
    }
    TextView localTextView = this.SL;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      this.SL.setText(paramString);
      return;
    }
  }
  
  public void dkq()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.CS == null)
    {
      this.CS = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131563202, this.mRootView, false);
      this.SK = ((TextView)this.CS.findViewById(2131367040));
      this.afl = ((TextView)this.CS.findViewById(2131367068));
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.CS.findViewById(2131364246));
      this.SI = ((TextView)this.CS.findViewById(2131367034));
      this.SJ = ((TextView)this.CS.findViewById(2131367029));
      this.afj = ((TextView)this.CS.findViewById(2131367030));
      this.SF = ((TextView)this.CS.findViewById(2131372657));
      this.KK = this.CS.findViewById(2131381970);
    }
  }
  
  public void dkv()
  {
    if ((this.CX != null) && (this.CX.getVisibility() == 0)) {
      this.CX.setVisibility(8);
    }
  }
  
  public void dkx()
  {
    if ((this.P != null) && (this.P.isShowing())) {
      this.P.dismiss();
    }
  }
  
  public void euG()
  {
    ViewGroup localViewGroup = (ViewGroup)this.CS.getParent();
    if ((localViewGroup != null) && (this.nB != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.nB, 0, localLayoutParams);
    }
  }
  
  public void ig(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView != null) {
      this.jdField_c_of_type_ComTencentTbsReaderTbsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void showTip(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.SK.setVisibility(0);
      return;
    }
    this.SK.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucs
 * JD-Core Version:    0.7.0.1
 */