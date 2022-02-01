import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;

public class fot
  extends EmoticonLinearLayout.EmoticonAdapter
{
  private static final int e = 63;
  private static final int f = 30;
  private static final int g = 48;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public fot(EmoticonPanelViewBinder paramEmoticonPanelViewBinder, int paramInt)
  {
    float f1 = paramEmoticonPanelViewBinder.a.getResources().getDisplayMetrics().density;
    this.i = ((int)(30.0F * f1));
    this.h = ((int)(63.0F * f1));
    this.j = ((int)(f1 * 48.0F));
    this.k = paramInt;
  }
  
  public void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup)
  {
    Object localObject1 = (ImageView)paramRelativeLayout.findViewById(2131230814);
    ((ImageView)localObject1).setVisibility(0);
    paramViewGroup = a(paramInt);
    paramRelativeLayout.setTag(paramViewGroup);
    Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    float f1 = this.a.a.getResources().getDisplayMetrics().density;
    label138:
    String str;
    if (paramViewGroup != null) {
      if ((paramViewGroup.b == 1) || (paramViewGroup.b == 2) || (paramViewGroup.b == 7))
      {
        ((RelativeLayout.LayoutParams)localObject2).width = this.i;
        ((RelativeLayout.LayoutParams)localObject2).height = this.i;
        if (paramViewGroup.b == -1) {
          break label615;
        }
        localObject2 = paramViewGroup.b(this.a.a, f1);
        if (localObject2 == null) {
          break label606;
        }
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if ((this.k == 2006) || (this.k == 2008))
        {
          localObject1 = (TextView)paramRelativeLayout.findViewById(2131230816);
          if ((paramViewGroup == null) || (!(paramViewGroup instanceof PicEmoticonInfo)) || ((paramViewGroup.b != 6) && (paramViewGroup.b != 9))) {
            break label794;
          }
          localObject2 = (PicEmoticonInfo)paramViewGroup;
          str = ((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
          if ((str == null) || (str.length() <= 0)) {
            break label784;
          }
          ((TextView)localObject1).setVisibility(0);
          paramInt = str.length();
          if (paramInt <= 5) {
            break label774;
          }
          int m = str.indexOf("Q脸表情-");
          if ((((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) || (m < 0)) {
            break label741;
          }
          m += 5;
          if (m > paramInt - 1) {
            break label731;
          }
          ((TextView)localObject1).setText(str.substring(m));
        }
        label296:
        if ((this.k == 2006) || (this.k == 2009))
        {
          localObject1 = (ImageView)paramRelativeLayout.findViewById(2131230815);
          if ((paramViewGroup == null) || (!(paramViewGroup instanceof PicEmoticonInfo))) {
            break label813;
          }
          if (!((PicEmoticonInfo)paramViewGroup).a()) {
            break label804;
          }
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageResource(2130840219);
        }
        label361:
        if ((this.k == 2008) && (paramViewGroup != null) && ((paramViewGroup instanceof PicEmoticonInfo)))
        {
          localObject1 = (PicEmoticonInfo)paramViewGroup;
          if (paramViewGroup.b == 9)
          {
            paramViewGroup = (ImageView)paramRelativeLayout.findViewById(2131230818);
            localObject2 = (ImageView)paramRelativeLayout.findViewById(2131230817);
            paramViewGroup.setVisibility(8);
            ((ImageView)localObject2).setVisibility(8);
            paramRelativeLayout = (ProgressBar)paramRelativeLayout.findViewById(2131230819);
            if (!((PicEmoticonInfo)localObject1).jdField_a_of_type_Boolean) {
              break label822;
            }
            paramViewGroup.setBackgroundResource(2130839129);
            paramViewGroup.getBackground().setAlpha(187);
            paramViewGroup.setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (!((PicEmoticonInfo)localObject1).b) {
        break label913;
      }
      paramRelativeLayout.setVisibility(0);
      return;
      if ((this.k != 2009) && ((paramViewGroup.b == 6) || (paramViewGroup.b == 9)))
      {
        ((RelativeLayout.LayoutParams)localObject2).width = this.j;
        ((RelativeLayout.LayoutParams)localObject2).height = this.j;
        break;
      }
      if ((!"setting".equals(paramViewGroup.a)) && (!"add".equals(paramViewGroup.a)) && ((this.k != 2009) || ((paramViewGroup.b != 6) && (paramViewGroup.b != 9)))) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject2).width = this.h;
      ((RelativeLayout.LayoutParams)localObject2).height = this.h;
      break;
      label606:
      ((ImageView)localObject1).setVisibility(4);
      break label138;
      label615:
      if ("delete".equals(paramViewGroup.a))
      {
        ((ImageView)localObject1).setImageResource(2130837941);
        break label138;
      }
      if ("setting".equals(paramViewGroup.a))
      {
        ((ImageView)localObject1).setImageDrawable(this.a.a.getResources().getDrawable(2130839131));
        break label138;
      }
      if ("add".equals(paramViewGroup.a))
      {
        ((ImageView)localObject1).setImageDrawable(this.a.a.getResources().getDrawable(2130839130));
        break label138;
      }
      ((ImageView)localObject1).setImageDrawable(null);
      break label138;
      ((ImageView)localObject1).setImageDrawable(null);
      ((ImageView)localObject1).setVisibility(4);
      break label138;
      label731:
      ((TextView)localObject1).setText("");
      break label296;
      label741:
      ((TextView)localObject1).setText(str.substring(0, 4) + "...");
      break label296;
      label774:
      ((TextView)localObject1).setText(str);
      break label296;
      label784:
      ((TextView)localObject1).setVisibility(8);
      break label296;
      label794:
      ((TextView)localObject1).setVisibility(8);
      break label296;
      label804:
      ((ImageView)localObject1).setVisibility(4);
      break label361;
      label813:
      ((ImageView)localObject1).setVisibility(4);
      break label361;
      label822:
      localObject2 = ((EmoticonManager)((BaseActivity)this.a.a).b.getManager(12)).a(((PicEmoticonInfo)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if ((localObject2 != null) && (3 == ((EmoticonPackage)localObject2).jobType) && ((!((EmoticonPackage)localObject2).valid) || (2 != ((EmoticonPackage)localObject2).status)))
      {
        paramViewGroup.setBackgroundResource(2130839129);
        paramViewGroup.getBackground().setAlpha(187);
        paramViewGroup.setVisibility(0);
      }
    }
    label913:
    paramRelativeLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fot
 * JD-Core Version:    0.7.0.1
 */