import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class acsz
  extends ReportDialog
  implements aqdf.a
{
  private static String TAG = "MsgNotifyPushForSpecialCareDialog";
  private static String bqP = acfp.m(2131708527);
  private static String bqQ = acfp.m(2131708524);
  private aduk.a jdField_a_of_type_Aduk$a;
  private aqdf jdField_a_of_type_Aqdf;
  private String bfa;
  private RoundImageView e;
  private aduk f;
  private QQAppInterface mAppInterface;
  private Context mContext;
  
  @TargetApi(14)
  public acsz(Context paramContext, @Nullable QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramContext, 2131756467);
    super.getWindow().setWindowAnimations(2131755320);
    getWindow().setDimAmount(0.5F);
    this.mContext = paramContext;
    this.mAppInterface = paramQQAppInterface;
    this.bfa = paramString;
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_Aqdf != null) {
      this.jdField_a_of_type_Aqdf.destory();
    }
    if (this.f != null)
    {
      this.f.b(this.jdField_a_of_type_Aduk$a);
      this.f.destroy();
    }
  }
  
  public void onBackPressed() {}
  
  @TargetApi(16)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131559160);
    this.e = ((RoundImageView)findViewById(2131365856));
    paramBundle = (TextView)findViewById(2131365867);
    TextView localTextView = (TextView)findViewById(2131365835);
    Button localButton = (Button)findViewById(2131365832);
    ImageView localImageView = (ImageView)findViewById(2131364687);
    Bitmap localBitmap;
    if (this.mAppInterface != null)
    {
      this.jdField_a_of_type_Aqdf = new aqdf(this.mAppInterface);
      this.jdField_a_of_type_Aqdf.a(this);
      localBitmap = this.jdField_a_of_type_Aqdf.a(1, this.bfa, 0);
      if (localBitmap == null)
      {
        if (!this.jdField_a_of_type_Aqdf.isPausing()) {
          this.jdField_a_of_type_Aqdf.i(this.bfa, 1, true);
        }
        this.e.setBackgroundDrawable(aqhu.aU());
      }
    }
    for (;;)
    {
      paramBundle.setText(bqP);
      localTextView.setText(bqQ);
      localButton.setText(acfp.m(2131708526));
      localButton.setOnClickListener(new actb(this));
      localImageView.setOnClickListener(new actc(this));
      localImageView.setOnTouchListener(new actd(this, localImageView));
      return;
      this.e.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      continue;
      this.f = new aduk(this.mContext, 1);
      this.f.init();
      this.jdField_a_of_type_Aduk$a = new acta(this);
      this.f.a(this.jdField_a_of_type_Aduk$a);
      this.e.setImageBitmap(this.f.getFaceBitmap(this.bfa, true));
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aqdf.isPausing())) {
      return;
    }
    this.e.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsz
 * JD-Core Version:    0.7.0.1
 */