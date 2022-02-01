import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.1;
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class vog
{
  public static final String a;
  private static volatile vog jdField_a_of_type_Vog;
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "https://sola.gtimg.cn/aoi/sola/20200518192950_cZOH0rfA0k.png";
  private ConcurrentHashMap<String, Boolean> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private final String c = "https://sola.gtimg.cn/aoi/sola/20200518192951_ckvyj8QZ2N.png";
  
  static
  {
    jdField_a_of_type_JavaLangString = vog.class.getSimpleName();
  }
  
  private ValueAnimator a(View paramView, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, long paramLong)
  {
    paramPointF1 = ValueAnimator.ofObject(new vok(this, paramPointF3, paramPointF4), new Object[] { paramPointF1, paramPointF2 });
    paramPointF1.setDuration(paramLong);
    paramPointF1.addUpdateListener(new voj(this, paramView));
    return paramPointF1;
  }
  
  public static URLDrawable a(String paramString, int[] paramArrayOfInt, Drawable paramDrawable, int paramInt)
  {
    voi localvoi = new voi(paramArrayOfInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", paramInt);
    return VasApngUtil.getApngURLDrawable(paramString, paramArrayOfInt, paramDrawable, localBundle, localvoi);
  }
  
  public static vog a()
  {
    if (jdField_a_of_type_Vog == null) {}
    try
    {
      if (jdField_a_of_type_Vog == null) {
        jdField_a_of_type_Vog = new vog();
      }
      return jdField_a_of_type_Vog;
    }
    finally {}
  }
  
  public String a()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  }
  
  public void a(ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, ImageView paramImageView3, View paramView, boolean paramBoolean)
  {
    if ((!a()) || (paramImageView1 == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(), Boolean.valueOf(true));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(), Boolean.valueOf(false));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramTextView = "https://sola.gtimg.cn/aoi/sola/20200518192951_ckvyj8QZ2N.png";; paramTextView = "https://sola.gtimg.cn/aoi/sola/20200518192950_cZOH0rfA0k.png")
    {
      ApngImage.playByTag(33);
      paramImageView2 = new ColorDrawable(Color.parseColor("#00000000"));
      paramTextView = a(paramTextView, new int[] { 33 }, paramImageView2, 1);
      paramImageView1.setImageDrawable(paramTextView);
      paramImageView1.setVisibility(0);
      if ((paramTextView.getCurrDrawable() instanceof ApngDrawable)) {
        ((ApngDrawable)paramTextView.getCurrDrawable()).getImage().reDraw();
      }
      paramImageView1.postDelayed(new QCircleFuelAnimationManager.1(this, paramImageView1, paramImageView3, paramBoolean), 1800L);
      paramImageView1.postDelayed(new QCircleFuelAnimationManager.2(this, paramView), 1800L);
      vrf.a("", 40, 1, 0);
      return;
    }
  }
  
  public void a(ArrayList<TaskCenterReader.TaskRecord> paramArrayList)
  {
    int i;
    if (paramArrayList != null) {
      i = 1;
    }
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        if (((TaskCenterReader.TaskRecord)paramArrayList.get(i)).haveDone.get() > 0)
        {
          paramArrayList = new Date();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSimpleDateFormat.format(paramArrayList) + BaseApplicationImpl.getApplication().getRuntime().getAccount(), Boolean.valueOf(false));
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        paramArrayList = new ColorDrawable(Color.parseColor("#00000000"));
        a("https://sola.gtimg.cn/aoi/sola/20200518192950_cZOH0rfA0k.png", new int[] { 33 }, paramArrayList, 1);
        paramArrayList = new ColorDrawable(Color.parseColor("#00000000"));
        a("https://sola.gtimg.cn/aoi/sola/20200518192951_ckvyj8QZ2N.png", new int[] { 33 }, paramArrayList, 1);
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a()) == null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(), Boolean.valueOf(true));
        return true;
      }
      return ((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(a())).booleanValue() == true;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(a(), Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(a()) != null) {
      return ((Boolean)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(a())).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vog
 * JD-Core Version:    0.7.0.1
 */