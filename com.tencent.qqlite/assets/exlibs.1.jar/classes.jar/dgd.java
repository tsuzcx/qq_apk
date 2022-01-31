import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.ImageUtil;

public class dgd
  extends EmoticonLinearLayout.EmoticonAdapter
{
  private static final int e = 63;
  private static final int f = 30;
  private static final int g = 48;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public dgd(EmoticonPanelViewBinder paramEmoticonPanelViewBinder, int paramInt)
  {
    float f1 = paramEmoticonPanelViewBinder.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.i = ((int)(30.0F * f1));
    this.h = ((int)(63.0F * f1));
    this.j = ((int)(f1 * 48.0F));
    this.k = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    paramViewGroup = (ImageView)paramRelativeLayout.findViewById(2131296344);
    paramViewGroup.setVisibility(0);
    paramViewGroup.setTag(Boolean.valueOf(false));
    Object localObject1 = a(paramInt);
    paramRelativeLayout.setTag(localObject1);
    Object localObject2 = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    float f1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    label164:
    PicEmoticonInfo localPicEmoticonInfo;
    Object localObject3;
    if (localObject1 != null) {
      if ((((EmoticonInfo)localObject1).c == 1) || (((EmoticonInfo)localObject1).c == 2) || (((EmoticonInfo)localObject1).c == 7))
      {
        ((RelativeLayout.LayoutParams)localObject2).width = this.i;
        ((RelativeLayout.LayoutParams)localObject2).height = this.i;
        if (((EmoticonInfo)localObject1).c == -1) {
          break label652;
        }
        localObject2 = ((EmoticonInfo)localObject1).a(this.a.jdField_a_of_type_AndroidContentContext, f1);
        ((URLImageView)paramViewGroup).setURLDrawableDownListener(this.a.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
        if (localObject2 == null) {
          break label644;
        }
        paramViewGroup.setImageDrawable((Drawable)localObject2);
        if ((this.k == 2006) || (this.k == 2008))
        {
          localObject2 = (TextView)paramRelativeLayout.findViewById(2131296346);
          if ((localObject1 == null) || (!(localObject1 instanceof PicEmoticonInfo)) || ((((EmoticonInfo)localObject1).c != 6) && (((EmoticonInfo)localObject1).c != 9))) {
            break label828;
          }
          localPicEmoticonInfo = (PicEmoticonInfo)localObject1;
          localObject3 = localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
          if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {
            break label818;
          }
          ((TextView)localObject2).setVisibility(0);
          paramInt = ((String)localObject3).length();
          if (paramInt <= 5) {
            break label808;
          }
          int m = ((String)localObject3).indexOf("Q脸表情-");
          if ((localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) || (m < 0)) {
            break label775;
          }
          m += 5;
          if (m > paramInt - 1) {
            break label765;
          }
          ((TextView)localObject2).setText(((String)localObject3).substring(m));
        }
        label327:
        if ((this.k == 2006) || (this.k == 2009))
        {
          localObject2 = (ImageView)paramRelativeLayout.findViewById(2131296345);
          if ((localObject1 == null) || (!(localObject1 instanceof PicEmoticonInfo))) {
            break label847;
          }
          if (!((PicEmoticonInfo)localObject1).a()) {
            break label838;
          }
          ((ImageView)localObject2).setVisibility(0);
          ((ImageView)localObject2).setImageResource(2130839409);
        }
        label395:
        if (this.k == 2008)
        {
          localObject3 = (ImageView)paramRelativeLayout.findViewById(2131296347);
          localObject2 = (ImageView)paramRelativeLayout.findViewById(2131296345);
          paramRelativeLayout = (ProgressBar)paramRelativeLayout.findViewById(2131296349);
          if ((localObject1 == null) || (!(localObject1 instanceof PicEmoticonInfo))) {
            break label1027;
          }
          localPicEmoticonInfo = (PicEmoticonInfo)localObject1;
          if (((EmoticonInfo)localObject1).c == 9)
          {
            ((ImageView)localObject3).setVisibility(8);
            ((ImageView)localObject2).setVisibility(8);
            if (!localPicEmoticonInfo.jdField_a_of_type_Boolean) {
              break label856;
            }
            ((ImageView)localObject3).setImageResource(2130838987);
            ((ImageView)localObject3).setVisibility(0);
            if (!localPicEmoticonInfo.b) {
              break label1020;
            }
            paramRelativeLayout.setVisibility(0);
          }
        }
      }
    }
    label644:
    label652:
    label765:
    while ((localObject3 == null) || (localObject2 == null) || (paramRelativeLayout == null))
    {
      do
      {
        return;
        if ((this.k != 2009) && ((((EmoticonInfo)localObject1).c == 6) || (((EmoticonInfo)localObject1).c == 9)))
        {
          ((RelativeLayout.LayoutParams)localObject2).width = this.j;
          ((RelativeLayout.LayoutParams)localObject2).height = this.j;
          break;
        }
        if ((!"setting".equals(((EmoticonInfo)localObject1).a)) && (!"add".equals(((EmoticonInfo)localObject1).a)) && ((this.k != 2009) || ((((EmoticonInfo)localObject1).c != 6) && (((EmoticonInfo)localObject1).c != 9)))) {
          break;
        }
        ((RelativeLayout.LayoutParams)localObject2).width = this.h;
        ((RelativeLayout.LayoutParams)localObject2).height = this.h;
        break;
        paramViewGroup.setVisibility(4);
        break label164;
        if ("delete".equals(((EmoticonInfo)localObject1).a))
        {
          paramViewGroup.setImageResource(2130837989);
          break label164;
        }
        if ("setting".equals(((EmoticonInfo)localObject1).a))
        {
          paramViewGroup.setImageDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839004));
          break label164;
        }
        if ("add".equals(((EmoticonInfo)localObject1).a))
        {
          paramViewGroup.setImageDrawable(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839003));
          break label164;
        }
        paramViewGroup.setImageDrawable(null);
        break label164;
        paramViewGroup.setImageDrawable(null);
        paramViewGroup.setVisibility(4);
        break label164;
        ((TextView)localObject2).setText("");
        break label327;
        ((TextView)localObject2).setText(((String)localObject3).substring(0, 4) + "...");
        break label327;
        ((TextView)localObject2).setText((CharSequence)localObject3);
        break label327;
        ((TextView)localObject2).setVisibility(8);
        break label327;
        ((TextView)localObject2).setVisibility(8);
        break label327;
        ((ImageView)localObject2).setVisibility(4);
        break label395;
        ((ImageView)localObject2).setVisibility(4);
        break label395;
        localObject3 = ((EmoticonManager)((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).app.getManager(13)).a(localPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      } while ((localObject3 == null) || (3 != ((EmoticonPackage)localObject3).jobType) || ((((EmoticonPackage)localObject3).valid) && (2 == ((EmoticonPackage)localObject3).status)) || (localPicEmoticonInfo.b));
      localObject1 = ((EmoticonInfo)localObject1).a(this.a.jdField_a_of_type_AndroidContentContext, f1);
      if (((Drawable)localObject1).getIntrinsicWidth() > 0)
      {
        localObject1 = ImageUtil.a((Drawable)localObject1);
        if ((localObject1 != null) && (((Bitmap)localObject1).getWidth() > 0)) {
          paramViewGroup.setImageBitmap(ImageUtil.a((Bitmap)localObject1));
        }
      }
      for (;;)
      {
        if (!((EmoticonPackage)localObject3).valid) {
          ((ImageView)localObject2).setImageResource(2130839005);
        }
        ((ImageView)localObject2).setVisibility(0);
        break;
        paramViewGroup.setTag(Boolean.valueOf(true));
      }
      paramRelativeLayout.setVisibility(8);
      return;
    }
    label775:
    label808:
    label818:
    label828:
    label838:
    label847:
    label856:
    label1020:
    ((ImageView)localObject3).setVisibility(8);
    label1027:
    ((ImageView)localObject2).setVisibility(8);
    paramRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dgd
 * JD-Core Version:    0.7.0.1
 */