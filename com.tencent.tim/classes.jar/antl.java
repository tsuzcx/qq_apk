import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class antl
  extends anqv
{
  private RelativeLayout d(Context paramContext)
  {
    BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(paramContext);
    localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localBubbleViewLayout.setId(2131364052);
    localBubbleViewLayout.setRadius(10.0F);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setPadding(0, 0, 0, wja.dp2px(10.0F, paramContext.getResources()));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setId(2131362458);
    localLinearLayout.setBackgroundColor(-1);
    localBubbleViewLayout.addView(localLinearLayout);
    return localBubbleViewLayout;
  }
  
  public static final int ew(String paramString)
  {
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = new JSONObject(paramString).optInt("msgType", 0);
      return i;
    }
    catch (Exception paramString)
    {
      do
      {
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("StructMsg", 2, "generate 26: " + QLog.getStackTraceString(paramString));
    }
    return 0;
  }
  
  protected int IX()
  {
    return 26;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    Object localObject1 = null;
    LinearLayout localLinearLayout1 = null;
    paramView = null;
    int j = ew(paramBundle.getString("extraData"));
    RelativeLayout localRelativeLayout = d(paramContext);
    LinearLayout localLinearLayout2 = (LinearLayout)localRelativeLayout.findViewById(2131362458);
    Iterator localIterator = this.rz.iterator();
    Object localObject2;
    Object localObject3;
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (anqu)localIterator.next();
      ((anqu)localObject2).hU = this.hU;
      localObject3 = ((anqu)localObject2).mTypeName;
      if ((("picture".equals(localObject3)) || ("vote".equals(localObject3)) || ("video".equals(localObject3))) && (localObject1 == null))
      {
        localObject1 = ((anqu)localObject2).a(paramContext, null, paramBundle);
        i = wja.dp2px(200.0F, localResources);
        if (!(localObject2 instanceof ansr)) {
          break label756;
        }
        localObject2 = (ansr)localObject2;
        if (((ansr)localObject2).height > 0)
        {
          i = ((ansr)localObject2).height;
          label175:
          if ((j & 0x2) == 0) {
            break label753;
          }
          localObject2 = new RelativeLayout(paramContext);
          localObject3 = new RelativeLayout.LayoutParams(-1, i);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          localObject1 = new ImageView(paramContext);
          ((ImageView)localObject1).setImageResource(2130842527);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(13);
          ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          localObject1 = localObject2;
        }
      }
    }
    label616:
    label626:
    label756:
    for (;;)
    {
      localLinearLayout2.addView((View)localObject1, new LinearLayout.LayoutParams(-1, i));
      for (;;)
      {
        break;
        break label175;
        if ("summary".equals(localObject3))
        {
          paramView = (TextView)((anqu)localObject2).a(paramContext, null, paramBundle);
          localLinearLayout2.addView(paramView);
        }
        else if ("taglist".equals(localObject3))
        {
          localLinearLayout1 = (LinearLayout)((anqu)localObject2).a(paramContext, null, paramBundle);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).setMargins(0, wja.dp2px(10.0F, localResources), 0, wja.dp2px(6.0F, localResources));
          localLinearLayout2.addView(localLinearLayout1, (ViewGroup.LayoutParams)localObject2);
          continue;
          if (localObject1 == null) {
            QLog.e("StructMsg", 1, "generate 26 item failure coverView == null，mElements.size=" + this.rz.size());
          }
          if (localLinearLayout2 == null) {
            QLog.e("StructMsg", 1, "generate 26 item failure containerView == null, mElements.size=" + this.rz.size());
          }
          boolean bool = paramBundle.getBoolean("isSend", true);
          ((BubbleViewLayout)localRelativeLayout.findViewById(2131364052)).mIsSend = bool;
          if (bool)
          {
            if (localLinearLayout1 != null) {
              localLinearLayout1.setPadding(wja.dp2px(12.0F, localResources), 0, wja.dp2px(22.0F, localResources), 0);
            }
            if (paramView != null) {
              paramView.setPadding(wja.dp2px(12.0F, localResources), 0, wja.dp2px(22.0F, localResources), 0);
            }
            if ((AppSetting.enableTalkBack) && (paramView != null))
            {
              paramContext = new StringBuilder();
              paramContext.append(paramView.getText());
              localLinearLayout2.setContentDescription(paramContext.toString());
            }
            if ((this.e != null) && (this.e.message != null))
            {
              if (!ajpc.a(this.e.message, "isFaceScoreSecondMember")) {
                break label730;
              }
              paramContext = "2";
              if ((j & 0x2) == 0) {
                break label737;
              }
              i = 1;
              paramBundle = this.e.uin;
              if (i == 0) {
                break label743;
              }
            }
          }
          for (paramView = "2";; paramView = "1")
          {
            ajpc.b("exp_obj", paramBundle, new String[] { paramContext, "", "", paramView });
            return localRelativeLayout;
            if (localLinearLayout1 != null) {
              localLinearLayout1.setPadding(wja.dp2px(22.0F, localResources), 0, wja.dp2px(12.0F, localResources), 0);
            }
            if (paramView == null) {
              break;
            }
            paramView.setPadding(wja.dp2px(22.0F, localResources), 0, wja.dp2px(12.0F, localResources), 0);
            break;
            paramContext = "1";
            break label616;
            i = 0;
            break label626;
          }
        }
      }
    }
  }
  
  public String getName()
  {
    return "Layout26";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     antl
 * JD-Core Version:    0.7.0.1
 */