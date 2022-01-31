import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.DanceMachineUploadVideoFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class xdj
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString;
  WeakReference<AppInterface> jdField_a_of_type_MqqUtilWeakReference;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public xdj(Activity paramActivity, String paramString1, String paramString2, int paramInt1, WeakReference<AppInterface> paramWeakReference, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!azla.d((AppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get())) {
      return -1002;
    }
    azla.d(null);
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return 0;
    }
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return -1002;
    }
    paramString4 = paramString1 + File.separator + paramString4 + "_target.mp4";
    paramString1 = paramString1 + File.separator + "mc_audio.mp4";
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = AudioEncoder.a(null, null, 0);
    ((azjw)localObject).jdField_b_of_type_JavaLangString = paramString1;
    ((azjw)localObject).jdField_a_of_type_JavaLangString = paramString2;
    int i = AudioEncoder.a(paramString2);
    if (i != 0) {
      a("checkSourceAudioIsOK: errcode=" + i, null);
    }
    for (;;)
    {
      return 0;
      long l = System.currentTimeMillis();
      i = AudioEncoder.a((azjw)localObject);
      a("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
      if (i != 0)
      {
        a("AudioEncoder.encodeSafely: errcode=" + i, null);
        return i;
      }
      paramString2 = new File(paramString1);
      if (!paramString2.exists())
      {
        a("AudioEncoder.encodeSafely: exists = false", null);
      }
      else
      {
        i = azkd.a(paramString3, paramString1, paramString4, 0);
        paramString2.delete();
        if (i != 0)
        {
          a("HwVideoMerge.merge: errcode=" + i, null);
          return i;
        }
        this.jdField_a_of_type_JavaLangString = paramString4;
      }
    }
  }
  
  private void a()
  {
    a("cancleProgressDailog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Context paramContext, int paramInt)
  {
    a("showProgressDialog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131755801);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      a("showProgressDialog", paramContext);
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("DanceMachinePKVideoSharer", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("DanceMachinePKVideoSharer", 2, "[@] " + paramString);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    paramVarArgs = ((File)localObject).getParent();
    localObject = ((File)localObject).getName();
    return Integer.valueOf(a(paramVarArgs, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (String)localObject));
  }
  
  protected void a(Integer paramInteger)
  {
    a();
    if (paramInteger.intValue() == 0)
    {
      paramInteger = new Intent();
      paramInteger.putExtra("upload_video_path", this.jdField_a_of_type_JavaLangString);
      paramInteger.putExtra("share_method", this.jdField_a_of_type_Int);
      paramInteger.putExtra("pk_rank", this.jdField_b_of_type_Int);
      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramInteger, DanceMachineUploadVideoFragment.class, 90001);
      this.jdField_a_of_type_AndroidAppActivity = null;
      return;
    }
    a(alud.a(2131716754) + paramInteger, null);
  }
  
  protected void onPreExecute()
  {
    a(this.jdField_a_of_type_AndroidAppActivity, 2131695286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdj
 * JD-Core Version:    0.7.0.1
 */