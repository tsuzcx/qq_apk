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
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import qqcircle.TaskCenterReader.TaskRecord;

public class tyz
{
  public static final String a;
  private static volatile tyz jdField_a_of_type_Tyz;
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final String b = "https://sola.gtimg.cn/aoi/sola/20200423204457_HI03BGAOLF.png";
  
  static
  {
    jdField_a_of_type_JavaLangString = tyz.class.getSimpleName();
  }
  
  private ValueAnimator a(View paramView, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, long paramLong)
  {
    paramPointF1 = ValueAnimator.ofObject(new tzd(this, paramPointF3, paramPointF4), new Object[] { paramPointF1, paramPointF2 });
    paramPointF1.setDuration(paramLong);
    paramPointF1.addUpdateListener(new tzc(this, paramView));
    return paramPointF1;
  }
  
  public static URLDrawable a(String paramString, int[] paramArrayOfInt, Drawable paramDrawable)
  {
    tzb localtzb = new tzb(paramArrayOfInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", 1);
    return bduc.a(paramString, paramArrayOfInt, paramDrawable, localBundle, localtzb);
  }
  
  public static tyz a()
  {
    if (jdField_a_of_type_Tyz == null) {}
    try
    {
      if (jdField_a_of_type_Tyz == null) {
        jdField_a_of_type_Tyz = new tyz();
      }
      return jdField_a_of_type_Tyz;
    }
    finally {}
  }
  
  public void a(ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, ImageView paramImageView3, View paramView)
  {
    if (!a()) {
      return;
    }
    ApngImage.playByTag(33);
    Object localObject = new ColorDrawable(Color.parseColor("#00000000"));
    localObject = a("https://sola.gtimg.cn/aoi/sola/20200423204457_HI03BGAOLF.png", new int[] { 33 }, (Drawable)localObject);
    paramImageView1.setImageDrawable((Drawable)localObject);
    paramImageView1.setVisibility(0);
    if ((((URLDrawable)localObject).getCurrDrawable() instanceof ApngDrawable)) {
      ((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).getImage().reDraw();
    }
    paramImageView1.postDelayed(new QCircleFuelAnimationManager.1(this, paramTextView, paramImageView2), 600L);
    paramImageView1.postDelayed(new QCircleFuelAnimationManager.2(this, paramTextView, paramImageView2), 1700L);
    paramImageView1.postDelayed(new QCircleFuelAnimationManager.3(this, paramImageView1, paramImageView3, paramView), 2000L);
  }
  
  public void a(ArrayList<TaskCenterReader.TaskRecord> paramArrayList)
  {
    if (paramArrayList != null)
    {
      int i = 1;
      while (i < paramArrayList.size())
      {
        if (((TaskCenterReader.TaskRecord)paramArrayList.get(i)).haveDone.get() > 0)
        {
          Date localDate = new Date();
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount(), Boolean.valueOf(false));
        }
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount()) == null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount(), Boolean.valueOf(true));
        return true;
      }
      return ((Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount())).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyz
 * JD-Core Version:    0.7.0.1
 */