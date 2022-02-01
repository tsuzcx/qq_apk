import android.animation.TypeEvaluator;
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
import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager.4;
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

public class pbv
{
  public static final String TAG = pbv.class.getSimpleName();
  private static volatile pbv a;
  private final String arX = "https://sola.gtimg.cn/aoi/sola/20200423204457_HI03BGAOLF.png";
  private ConcurrentHashMap<String, Boolean> bL = new ConcurrentHashMap();
  
  private ValueAnimator a(View paramView, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, long paramLong)
  {
    paramPointF1 = ValueAnimator.ofObject(new pbv.a(paramPointF3, paramPointF4), new Object[] { paramPointF1, paramPointF2 });
    paramPointF1.setDuration(paramLong);
    paramPointF1.addUpdateListener(new pby(this, paramView));
    return paramPointF1;
  }
  
  public static URLDrawable a(String paramString, int[] paramArrayOfInt, Drawable paramDrawable)
  {
    pbx localpbx = new pbx(paramArrayOfInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", 1);
    return aqqx.a(paramString, paramArrayOfInt, paramDrawable, localBundle, localpbx);
  }
  
  public static pbv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pbv();
      }
      return a;
    }
    finally {}
  }
  
  public boolean HL()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (this.bL != null)
    {
      if (this.bL.get(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount()) == null)
      {
        this.bL.put(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount(), Boolean.valueOf(true));
        return true;
      }
      return ((Boolean)this.bL.get(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount())).booleanValue();
    }
    return false;
  }
  
  public void a(ImageView paramImageView1, TextView paramTextView, ImageView paramImageView2, ImageView paramImageView3, View paramView)
  {
    if ((!HL()) || (paramImageView1 == null)) {
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
    paramImageView1.postDelayed(new QCircleFuelAnimationManager.3(this, paramImageView1, paramImageView3), 2000L);
    paramImageView1.postDelayed(new QCircleFuelAnimationManager.4(this, paramView), 2200L);
    pco.b("", 40, 1L, 0L);
  }
  
  public void setData(ArrayList<TaskCenterReader.TaskRecord> paramArrayList)
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
          this.bL.put(localSimpleDateFormat.format(localDate) + BaseApplicationImpl.getApplication().getRuntime().getAccount(), Boolean.valueOf(false));
        }
        i += 1;
      }
    }
  }
  
  public class a
    implements TypeEvaluator<PointF>
  {
    private PointF M;
    private PointF N;
    
    public a(PointF paramPointF1, PointF paramPointF2)
    {
      this.M = paramPointF1;
      this.N = paramPointF2;
    }
    
    public PointF evaluate(float paramFloat, PointF paramPointF1, PointF paramPointF2)
    {
      PointF localPointF = new PointF();
      localPointF.x = (paramPointF1.x * (1.0F - paramFloat) * (1.0F - paramFloat) * (1.0F - paramFloat) + this.M.x * 3.0F * paramFloat * (1.0F - paramFloat) * (1.0F - paramFloat) + this.N.x * 3.0F * paramFloat * paramFloat * (1.0F - paramFloat) + paramPointF2.x * paramFloat * paramFloat * paramFloat);
      localPointF.y = (paramPointF1.y * (1.0F - paramFloat) * (1.0F - paramFloat) * (1.0F - paramFloat) + this.M.y * 3.0F * paramFloat * (1.0F - paramFloat) * (1.0F - paramFloat) + this.N.y * 3.0F * paramFloat * paramFloat * (1.0F - paramFloat) + paramPointF2.y * paramFloat * paramFloat * paramFloat);
      return localPointF;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pbv
 * JD-Core Version:    0.7.0.1
 */