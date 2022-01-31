import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.videostory.capture.AEPlayShowGridViewHolder.1;
import com.tencent.biz.videostory.capture.AEPlayShowGridViewHolder.3;
import com.tencent.biz.videostory.capture.AEPlayShowGridViewHolder.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class wrr
  extends RecyclerView.ViewHolder
  implements URLDrawable.URLDrawableListener2, wts
{
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = b().getResources().getDrawable(2130837594);
  private static final Map<String, WeakReference<URLDrawable>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final String jdField_b_of_type_JavaLangString;
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bgya jdField_a_of_type_Bgya;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private final String jdField_a_of_type_JavaLangString = "AEPlayShowGridViewHolder";
  private wrt jdField_a_of_type_Wrt;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private String c = "";
  private String d = "";
  private String e = "";
  
  static
  {
    try
    {
      bool = "mounted".equals(Environment.getExternalStorageState());
      if (bool)
      {
        File localFile1 = new File(ajed.aU);
        localFile1 = new File(localFile1, "play_show_apng");
        jdField_b_of_type_JavaLangString = localFile1.getPath();
        if (!localFile1.exists()) {
          localFile1.mkdirs();
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(wrr.class.getSimpleName(), 1, localException.toString());
        boolean bool = false;
        continue;
        File localFile2 = BaseApplicationImpl.getApplication().getCacheDir();
      }
    }
  }
  
  public wrr(View paramView, wrq paramwrq, wrt paramwrt, int paramInt)
  {
    super(paramView);
    this.jdField_b_of_type_Int = paramInt;
    if (paramInt == 1) {
      paramView.post(new AEPlayShowGridViewHolder.1(this, paramView));
    }
    this.jdField_a_of_type_Wrt = paramwrt;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296640));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131296641);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296644));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131296643));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131296642);
    paramwrt = paramView.getLayoutParams();
    paramwrt.width = paramwrq.jdField_a_of_type_Int;
    paramwrt.height = paramwrq.jdField_b_of_type_Int;
    paramView.setLayoutParams(paramwrt);
    paramView.setOnClickListener(new wrs(this));
  }
  
  private URLDrawable a(@NonNull String paramString1, @NonNull String paramString2)
  {
    return baop.a(paramString1, paramString2, jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, "-GY-PLAY-SHOW-", null);
  }
  
  private void a(@NonNull bgya parambgya)
  {
    this.c = parambgya.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(parambgya.j)) {}
    for (String str = "";; str = parambgya.j)
    {
      this.d = str;
      this.e = parambgya.i;
      parambgya = jdField_b_of_type_JavaLangString + File.separator + this.e.hashCode() + "_" + this.c.hashCode() + ".png";
      c();
      this.jdField_a_of_type_ComTencentImageURLDrawable = a(parambgya, this.e);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
      return;
    }
  }
  
  private static Context b()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_b_of_type_Int != 1) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a(@NonNull bgya parambgya, int paramInt)
  {
    this.jdField_a_of_type_Bgya = parambgya;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    a(parambgya);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.3(this, paramInt));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_a_of_type_Bgya.jdField_a_of_type_JavaLangString))) {
      return;
    }
    bhcs.a("AEPlayShowGridViewHolder", 1, "【Play Item】onDownloadFinish id:" + paramString);
    bhcs.a("AEPlayShowGridViewHolder", 1, "【Play Item】onDownloadFinish isSuccess:" + paramBoolean);
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.4(this, paramBoolean));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrr
 * JD-Core Version:    0.7.0.1
 */