import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v4.util.ArrayMap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;

public class uqx
  implements Runnable
{
  public uqx(PlusPanel paramPlusPanel, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.getVisibility() != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter == null) || (PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel) == null)) {
      break label30;
    }
    label30:
    while (PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).getCurrentItem() != this.jdField_a_of_type_Int) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(2130838006);
    Context localContext;
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt;
    int k;
    int m;
    int i1;
    TextView localTextView;
    int i;
    int j;
    int n;
    if (localObject3 != null)
    {
      localContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.getContext();
      localObject1 = localContext.getResources();
      localObject2 = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.getLocationInWindow((int[])localObject2);
      arrayOfInt = new int[2];
      ((View)localObject3).getLocationInWindow(arrayOfInt);
      k = ((View)localObject3).getWidth();
      m = ((View)localObject3).getHeight();
      i1 = ((Resources)localObject1).getDisplayMetrics().widthPixels;
      PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel, new LinearLayout(localContext));
      PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).setOrientation(1);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      localTextView = new TextView(localContext);
      localTextView.setBackgroundResource(2130838061);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setText(ApolloConstant.ai);
      localTextView.setSingleLine();
      localTextView.setGravity(17);
      i = (int)localTextView.getPaint().measureText(ApolloConstant.ai);
      j = AIOUtils.a(189.0F, (Resources)localObject1);
      n = AIOUtils.a(36.0F, (Resources)localObject1);
      if (i <= j) {
        break label809;
      }
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(i, n);
      ImageView localImageView = new ImageView(localContext);
      int i2 = AIOUtils.a(12.0F, (Resources)localObject1);
      j = AIOUtils.a(6.0F, (Resources)localObject1);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(i2, j);
      if (this.jdField_a_of_type_Boolean)
      {
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        i = AIOUtils.a(10.0F, (Resources)localObject1);
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
        localLayoutParams2.gravity = 3;
        i1 = arrayOfInt[0];
        localLayoutParams2.leftMargin = (k / 2 + i1 - i - i2 / 2);
        label370:
        if (!this.c) {
          break label726;
        }
        localImageView.setBackgroundResource(2130838060);
        ((RelativeLayout.LayoutParams)localObject3).topMargin = (arrayOfInt[1] - localObject2[1] + m - AIOUtils.a(10.0F, (Resources)localObject1));
        PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).addView(localImageView, localLayoutParams2);
        PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).addView(localTextView, localLayoutParams1);
        label437:
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.addView(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), (ViewGroup.LayoutParams)localObject3);
        localObject1 = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        localObject2 = "apollo_game_guide_shown" + this.jdField_a_of_type_JavaLangString;
        ((SharedPreferences)localObject1).edit().putBoolean((String)localObject2, true).apply();
        PlusPanel.a().put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!ApolloManager.a(localContext)) {
            break label793;
          }
        }
      }
      label793:
      for (i = 1;; i = 0)
      {
        VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "game_entrance_intro", "", i, ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PlusPanel", 2, "[checkApolloGameGuide] apollo game guide showing");
        return;
        if (this.b)
        {
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          i = AIOUtils.a(10.0F, (Resources)localObject1);
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
          localLayoutParams2.gravity = 5;
          localLayoutParams2.rightMargin = (i1 - arrayOfInt[0] - k / 2 - i - i2 / 2);
          break label370;
        }
        localLayoutParams2.gravity = 1;
        ((RelativeLayout.LayoutParams)localObject3).addRule(9);
        i1 = arrayOfInt[0];
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = (k / 2 + i1 - i / 2);
        break label370;
        label726:
        localImageView.setBackgroundResource(2130838059);
        ((RelativeLayout.LayoutParams)localObject3).topMargin = (arrayOfInt[1] - localObject2[1] - n - j + AIOUtils.a(21.0F, (Resources)localObject1));
        PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).addView(localTextView, localLayoutParams1);
        PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).addView(localImageView, localLayoutParams2);
        break label437;
      }
      QLog.e("PlusPanel", 1, "[checkApolloGameGuide] get apollo game view failed");
      return;
      label809:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uqx
 * JD-Core Version:    0.7.0.1
 */