import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aozz
{
  public static final boolean aTl = AppSetting.enableTalkBack;
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt, 2131563118);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(paramInt2, paramViewGroup, false);
    paramViewGroup = new aozz.a();
    paramViewGroup.pQ = ((ImageView)paramContext.findViewById(2131380296));
    paramViewGroup.ON = ((TextView)paramContext.findViewById(2131380362));
    paramViewGroup.aao = ((TextView)paramContext.findViewById(2131380247));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramContext.findViewById(2131380324));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(paramInt1);
    paramViewGroup.d = ((TroopLabelLayout)paramContext.findViewById(2131380325));
    paramViewGroup.d.setLabelType(2);
    paramViewGroup.aar = ((TextView)paramContext.findViewById(2131365979));
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setDistanceTextView(paramViewGroup.aar);
    paramViewGroup.aap = ((TextView)paramContext.findViewById(2131380277));
    paramViewGroup.Em = ((ImageView)paramContext.findViewById(2131380238));
    paramViewGroup.DD = ((ImageView)paramContext.findViewById(2131380198));
    paramViewGroup.mm = ((RelativeLayout)paramContext.findViewById(2131377469));
    paramViewGroup.hm = ((Button)paramContext.findViewById(2131369980));
    paramViewGroup.pQ.setImageBitmap(null);
    paramViewGroup.kQ = ((LinearLayout)paramContext.findViewById(2131369468));
    paramViewGroup.aN = ((LinearLayout)paramContext.findViewById(2131379041));
    paramViewGroup.aaq = ((TextView)paramContext.findViewById(2131380245));
    paramViewGroup.gk = paramContext.findViewById(2131370458);
    paramViewGroup.dSp = paramInt1;
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean, false);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, paramGroupInfo, paramContext, paramBoolean1, true, paramBoolean2);
  }
  
  public static void a(View paramView, GroupInfo paramGroupInfo, Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    aozz.a locala = (aozz.a)paramView.getTag();
    locala.uin = String.valueOf(paramGroupInfo.lCode);
    locala.ON.setText(paramGroupInfo.strName);
    locala.ON.setTextColor(paramContext.getResources().getColor(2131167311));
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramBoolean2) && (paramGroupInfo.labels != null))
    {
      localObject1 = paramGroupInfo.labels.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GroupLabel)((Iterator)localObject1).next();
        if (((GroupLabel)localObject2).type == 2001L)
        {
          i = android.graphics.Color.rgb((int)((GroupLabel)localObject2).text_color.R, (int)((GroupLabel)localObject2).text_color.G, (int)((GroupLabel)localObject2).text_color.B);
          locala.ON.setTextColor(i);
        }
      }
    }
    if ((paramBoolean1) || (paramBoolean3)) {
      locala.mm.setVisibility(0);
    }
    if (paramBoolean3) {
      locala.hm.setVisibility(0);
    }
    locala.aap.setVisibility(0);
    if (TextUtils.isEmpty(paramGroupInfo.strIntro))
    {
      locala.aap.setText(2131698378);
      locala.jdField_a_of_type_NearbyGroupGroupInfo = paramGroupInfo;
      if ((paramGroupInfo.labels != null) && (paramGroupInfo.labels.size() != 0)) {
        break label718;
      }
      if ((locala.zz == null) || (locala.zz.size() == 0))
      {
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(new GroupLabel(paramGroupInfo.iMemberCnt + "", new NearbyGroup.Color(175L, 195L, 213L), 1L, new NearbyGroup.Color(190L, 206L, 220L)));
        locala.zz = ((ArrayList)localObject1);
      }
      ((GroupLabel)locala.zz.get(0)).strWording = (paramGroupInfo.iMemberCnt + "");
      paramGroupInfo.labels = locala.zz;
      a(paramContext, locala, paramGroupInfo);
      if ((paramGroupInfo.dwGroupFlagExt & 0x800) == 0L) {
        break label812;
      }
      if (paramGroupInfo.dwCertType != 2L) {
        break label767;
      }
      locala.Em.setVisibility(0);
      locala.Em.setBackgroundResource(2130844648);
      label435:
      if ((paramGroupInfo.dwExtFlag & 1L) == 0L) {
        break label825;
      }
      locala.DD.setBackgroundResource(2130843349);
      locala.DD.setVisibility(0);
    }
    label718:
    for (;;)
    {
      label466:
      if (aTl)
      {
        localObject1 = "" + paramGroupInfo.strName;
        paramContext = paramGroupInfo.iMemberCnt + acfp.m(2131708932);
        if (paramGroupInfo.labels == null) {
          break label907;
        }
        localObject2 = new StringBuffer();
        int j = paramGroupInfo.labels.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            GroupLabel localGroupLabel = (GroupLabel)paramGroupInfo.labels.get(i);
            if ((localGroupLabel != null) && (!TextUtils.isEmpty(localGroupLabel.strWording))) {
              ((StringBuffer)localObject2).append(localGroupLabel.strWording).append(" ");
            }
            i += 1;
            continue;
            i = paramContext.getResources().getDisplayMetrics().widthPixels;
            if (locala.dSo == 1) {
              i -= wja.dp2px(110.0F, paramContext.getResources());
            }
            for (;;)
            {
              localObject1 = jqc.dR(jqc.dS(paramGroupInfo.strIntro));
              TextUtils.ellipsize((CharSequence)localObject1, locala.aap.getPaint(), i, TextUtils.TruncateAt.END, false, new apaa(locala, (String)localObject1));
              break;
              i = (i - wja.dp2px(137.0F, paramContext.getResources())) * 2;
            }
            if ((a(paramContext, locala, paramGroupInfo)) || (!QLog.isColorLevel())) {
              break;
            }
            QLog.e("NearbyTroops", 2, "fillTroopLabels failed:" + paramGroupInfo.strName);
            break;
            label767:
            if (paramGroupInfo.dwCertType == 1L)
            {
              locala.Em.setVisibility(0);
              locala.Em.setBackgroundResource(2130844648);
              break label435;
            }
            locala.Em.setVisibility(8);
            break label435;
            locala.Em.setVisibility(8);
            break label435;
            locala.DD.setVisibility(8);
            break label466;
          }
        }
        if (((StringBuffer)localObject2).length() <= 0) {
          break label907;
        }
        paramContext = ((StringBuffer)localObject2).toString();
      }
    }
    label907:
    for (;;)
    {
      label812:
      label825:
      locala.aao.setContentDescription(paramContext);
      paramContext = (String)localObject1 + paramContext;
      paramView.setContentDescription(paramContext + paramGroupInfo.strIntro);
      return;
    }
  }
  
  protected static boolean a(Context paramContext, aozz.a parama, GroupInfo paramGroupInfo)
  {
    if ((paramContext == null) || (parama == null) || (paramGroupInfo == null) || (paramGroupInfo.labels == null) || (paramGroupInfo.labels.size() == 0)) {
      return false;
    }
    parama.aao.setVisibility(8);
    parama.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
    paramContext = paramGroupInfo.labels;
    parama.d.O(paramContext);
    return parama.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.O(paramContext);
  }
  
  public static void b(Context paramContext, AppInterface paramAppInterface)
  {
    HotChatManager.w(paramContext, false);
  }
  
  public static class a
    extends abeg.a
  {
    public ImageView DD;
    public ImageView Em;
    public TextView ON;
    public GroupInfo a;
    public TroopLabelLayout a;
    public LinearLayout aN;
    public TextView aao;
    public TextView aap;
    public TextView aaq;
    public TextView aar;
    public boolean bnU;
    public int cWL;
    public String cnD;
    public TroopLabelLayout d;
    public int dSo = 2;
    public int dSp;
    public View gk;
    public Button hm;
    public LinearLayout kQ;
    public RelativeLayout mm;
    public ArrayList<GroupLabel> zz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozz
 * JD-Core Version:    0.7.0.1
 */