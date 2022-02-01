import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class aaky
  extends aakb
{
  private int mListItemLayout = 2131562963;
  private List<String> vo;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    if (paramView == null)
    {
      paramViewGroup = new aaky.a();
      paramView = a(paramContext, this.mListItemLayout, paramViewGroup);
      paramViewGroup.iN = ((RelativeLayout)paramView.findViewById(2131376937));
      paramViewGroup.hW = ((LinearLayout)paramView.findViewById(2131376925));
      paramViewGroup.Og = ((TextView)paramView.findViewById(2131376935));
      paramViewGroup.Oh = ((TextView)paramView.findViewById(2131376924));
      paramViewGroup.d = ((ThemeImageView)paramView.findViewById(2131369937));
      paramViewGroup.z = ((SingleLineTextView)paramView.findViewById(2131381005));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqWidgetFolderTextView = ((FolderTextView)paramView.findViewById(2131380646));
      paramViewGroup.eo = ((Button)paramView.findViewById(2131363896));
      paramViewGroup.a = ((TroopActiveLayout)paramView.findViewById(2131363297));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131363304));
      paramViewGroup.d.setSupportMaskView(true);
      paramViewGroup.eo.setOnClickListener(paramOnClickListener);
      paramViewGroup.hW.setOnClickListener(paramOnClickListener);
      paramViewGroup.Oh.setOnClickListener(paramOnClickListener);
      paramViewGroup.eo.setTag(paramViewGroup);
      paramViewGroup.hW.setTag(paramViewGroup);
      paramView.setTag(paramViewGroup);
      paramOnLongClickListener = (RecentItemRecommendTroopData)paramObject;
      paramViewGroup.a(paramOnLongClickListener, paramaajx);
      a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
      paramViewGroup.hW.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.eo.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.Oh.setTag(-1, Integer.valueOf(paramInt));
      paramaajx = null;
      paramObject = paramaajx;
      if (paramOnLongClickListener.mUser != null)
      {
        paramObject = paramaajx;
        if ((paramOnLongClickListener.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
          paramObject = (RecentRecommendTroopItem)paramOnLongClickListener.mUser.extraInfo;
        }
      }
      if (paramObject != null) {
        break label437;
      }
      paramaajx = "";
      label358:
      if (paramObject != null) {
        break label445;
      }
    }
    label437:
    label445:
    for (paramObject = "";; paramObject = paramObject.recomAlgol)
    {
      anot.a(null, "dc00899", "Grp_recom", "", "msg_tab", "exp_grp", 0, 0, paramaajx, paramObject, "", "");
      if (achg.bIg)
      {
        anot.a(null, "dc00899", "Grp_recom", "", "msg_tab", "exp", 0, 0, "", "", "", "");
        achg.bIg = false;
      }
      return paramView;
      paramViewGroup = (aaky.a)paramView.getTag();
      break;
      paramaajx = paramObject.uin;
      break label358;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.vo.add(paramRecentBaseData.getString(fy[0]));
      }
      return this.vo;
      this.vo.clear();
    }
  }
  
  public int xV()
  {
    return 1;
  }
  
  public static class a
    extends aakb.a
  {
    public TextView Og;
    public TextView Oh;
    public RecentItemRecommendTroopData a;
    TroopActiveLayout a;
    TroopLabelLayout b;
    public FolderTextView b;
    public ThemeImageView d;
    public Button eo;
    public LinearLayout hW;
    public RelativeLayout iN;
    public SingleLineTextView z;
    
    public void a(RecentItemRecommendTroopData paramRecentItemRecommendTroopData, aajx paramaajx)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemRecommendTroopData = paramRecentItemRecommendTroopData;
      if (paramRecentItemRecommendTroopData.mUser.uin.equals("sp_uin_for_title"))
      {
        this.hW.setVisibility(8);
        this.iN.setVisibility(0);
        if (AppSetting.enableTalkBack)
        {
          this.hW.setContentDescription(this.z.getText() + " " + this.jdField_b_of_type_ComTencentMobileqqWidgetFolderTextView.getText());
          this.z.setContentDescription(this.z.getText());
          this.jdField_b_of_type_ComTencentMobileqqWidgetFolderTextView.setContentDescription(this.jdField_b_of_type_ComTencentMobileqqWidgetFolderTextView.getText());
          this.iN.setContentDescription(acfp.m(2131713717));
        }
        return;
      }
      this.hW.setVisibility(0);
      this.iN.setVisibility(8);
      this.z.setText(paramRecentItemRecommendTroopData.mUser.displayName);
      QLog.d("RecentRecommendTroopItemBuilder", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
      QLog.i("RecentAdapter", 2, "faceDecoder getFaceDrawable uin: " + paramRecentItemRecommendTroopData.mUser.uin);
      if (paramaajx == null)
      {
        paramaajx = null;
        label225:
        this.d.setImageDrawable(paramaajx);
        if ((paramRecentItemRecommendTroopData.mUser == null) || (!(paramRecentItemRecommendTroopData.mUser.extraInfo instanceof RecentRecommendTroopItem))) {
          break label623;
        }
      }
      label312:
      label366:
      label623:
      for (paramaajx = (RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo;; paramaajx = null)
      {
        if (paramaajx == null)
        {
          QLog.d("RecentRecommendTroopIte", 1, "bindData, troopItem == null");
          return;
          paramaajx = paramaajx.a(paramRecentItemRecommendTroopData);
          break label225;
        }
        if (paramaajx.activity > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramaajx.activity);
          ArrayList localArrayList = joa.a((RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo);
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label523;
          }
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.O(localArrayList);
          if (!paramaajx.isJoined()) {
            break label535;
          }
          this.eo.setEnabled(false);
          this.eo.setText(2131701842);
          this.eo.setMinWidth(aqnm.dip2px(60.0F));
          this.eo.setMinWidth(aqnm.dip2px(29.0F));
          this.eo.setPadding(0, this.eo.getPaddingTop(), 0, this.eo.getPaddingBottom());
          this.eo.setBackgroundDrawable(null);
          if (TextUtils.isEmpty(paramaajx.intro)) {
            break label611;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new aofk(paramaajx.intro, 11, 16));
        }
        for (;;)
        {
          QLog.d("", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
          break;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
          break label312;
          this.jdField_b_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
          break label366;
          this.eo.setEnabled(true);
          this.eo.setText(2131701840);
          this.eo.setMinWidth(0);
          this.eo.setMinHeight(0);
          int i = aqnm.dip2px(16.0F);
          this.eo.setPadding(i, this.eo.getPaddingTop(), i, this.eo.getPaddingBottom());
          this.eo.setBackgroundResource(2130839559);
          break label445;
          this.jdField_b_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaky
 * JD-Core Version:    0.7.0.1
 */