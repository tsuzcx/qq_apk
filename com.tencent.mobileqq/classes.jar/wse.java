import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.videostory.capture.AEVideoStoryCaptureModePart.AECaptureModeAdapter.2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import java.io.File;

public class wse
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<wsg> jdField_a_of_type_AndroidUtilSparseArray;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  
  wse(wsa paramwsa, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable = new QQAnimationDrawable();
  }
  
  private void a(int paramInt)
  {
    if (bgxb.a().a("GIF_MODE_GUIDE", false, 0)) {}
    wsg localwsg;
    String str2;
    String str1;
    do
    {
      return;
      localwsg = (wsg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      str2 = wqf.c;
      str1 = null;
      localObject = str1;
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      localObject = new File(str2);
    } while (!((File)localObject).exists());
    File[] arrayOfFile = ((File)localObject).listFiles();
    Object localObject = str1;
    if (arrayOfFile != null)
    {
      localObject = str1;
      if (arrayOfFile.length > 0)
      {
        localObject = new String[arrayOfFile.length];
        paramInt = 0;
        while (paramInt < arrayOfFile.length)
        {
          str1 = str2 + "star" + String.format("%03d", new Object[] { Integer.valueOf(paramInt) }) + ".png";
          if (new File(str1).exists()) {
            localObject[paramInt] = str1;
          }
          paramInt += 1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(6000L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false);
    localwsg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    localwsg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a((String[])localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    localObject = PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.03F, -21.0F), Keyframe.ofFloat(0.06F, 0.0F), Keyframe.ofFloat(0.09F, -11.0F), Keyframe.ofFloat(0.12F, 0.0F), Keyframe.ofFloat(0.14F, -6.0F), Keyframe.ofFloat(0.16F, 0.0F) });
    wsa.a(this.jdField_a_of_type_Wsa, ObjectAnimator.ofPropertyValuesHolder(localwsg.jdField_a_of_type_AndroidWidgetTextView, new PropertyValuesHolder[] { localObject }));
    wsa.a(this.jdField_a_of_type_Wsa).setDuration(6000L);
    wsa.a(this.jdField_a_of_type_Wsa).setRepeatCount(-1);
    wsa.a(this.jdField_a_of_type_Wsa).start();
    wsa.b(this.jdField_a_of_type_Wsa, true);
  }
  
  private void b(int paramInt)
  {
    wsg localwsg = (wsg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    }
    if (wsa.a(this.jdField_a_of_type_Wsa) != null) {
      wsa.a(this.jdField_a_of_type_Wsa).end();
    }
    localwsg.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(0.0F);
    localwsg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (wsa.c(this.jdField_a_of_type_Wsa)) {
      bgxb.a().a("GIF_MODE_GUIDE", true, 0);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return wsh.a().length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (wsg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131492936, null);
      localObject1 = new wsg(this);
      ((wsg)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((wsg)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131304695));
      ((wsg)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131296997));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = ((wsg)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    ((TextView)localObject2).setText(wsh.a()[paramInt].b);
    if (wsa.a(this.jdField_a_of_type_Wsa))
    {
      ((TextView)localObject2).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099738));
      if (wsa.a(this.jdField_a_of_type_Wsa) != paramInt) {
        break label259;
      }
      ((TextView)localObject2).setAlpha(1.0F);
    }
    for (;;)
    {
      ((TextView)localObject2).setOnClickListener(new wsf(this, paramInt));
      paramViewGroup.addView(((wsg)localObject1).jdField_a_of_type_AndroidViewView);
      if (paramInt != wsh.c.a) {
        break label287;
      }
      if (!bjeg.a(this.jdField_a_of_type_Wsa.a)) {
        break label270;
      }
      ((wsg)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
      return ((wsg)localObject1).jdField_a_of_type_AndroidViewView;
      ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, ((TextView)localObject2).getResources().getColor(2131099747));
      ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
      break;
      label259:
      ((TextView)localObject2).setAlpha(0.6F);
    }
    label270:
    ((wsg)localObject1).jdField_a_of_type_AndroidViewView.post(new AEVideoStoryCaptureModePart.AECaptureModeAdapter.2(this, paramInt));
    label287:
    return ((wsg)localObject1).jdField_a_of_type_AndroidViewView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wse
 * JD-Core Version:    0.7.0.1
 */