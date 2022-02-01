import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecTroopBusinessItem;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.widget.MotionViewSetter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.HashMap;
import java.util.List;

public class ege
  extends FacePreloadBaseAdapter
{
  public int a;
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap b = new HashMap();
  
  public ege(RecommendTroopView paramRecommendTroopView, Context paramContext, QQAppInterface paramQQAppInterface, SlideDetectListView paramSlideDetectListView)
  {
    super(paramContext, paramQQAppInterface, paramSlideDetectListView, 4, false);
    this.jdField_a_of_type_Int = -1;
  }
  
  private CharSequence a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    String str2 = paramInt + this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.a().getString(2131560607) + "  ";
    String str1;
    if (paramBoolean) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.a().getString(2131560608);
    }
    while (!TextUtils.isEmpty(str1))
    {
      paramString1 = "[icon]" + " " + str1 + " ";
      paramString1 = new SpannableString(str2 + paramString1);
      paramString1.setSpan(new ImageSpan(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.a(), 2130840357, 1), str2.length(), str2.length() + "[icon]".length(), 17);
      return paramString1;
      str1 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        str1 = "";
      }
    }
    if (!TextUtils.isEmpty(paramString2)) {
      return str2 + " " + paramString2;
    }
    return str2;
  }
  
  private void a(int paramInt, RecTroopBusinessItem paramRecTroopBusinessItem, egg paramegg)
  {
    Object localObject = null;
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramRecTroopBusinessItem.iconUrl, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.getResources().getDrawable(2130838413), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.getResources().getDrawable(2130838413));
      localObject = localURLDrawable;
    }
    catch (Exception localException)
    {
      label40:
      break label40;
    }
    if (localObject != null) {
      paramegg.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(localObject);
    }
    for (;;)
    {
      paramegg.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecTroopBusinessItem.title);
      paramegg.b.setText(paramRecTroopBusinessItem.des);
      paramegg.d.setText(paramRecTroopBusinessItem.btnText);
      paramegg.d.setVisibility(0);
      paramegg.d.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView);
      paramegg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramegg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      paramegg.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(2130838413);
    }
  }
  
  private void a(int paramInt, RecommendTroopInfo paramRecommendTroopInfo, egg paramegg)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramRecommendTroopInfo.uin))
    {
      paramegg.b.setTag(Integer.valueOf(paramRecommendTroopInfo.curMemberNum));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramRecommendTroopInfo.uin, paramegg.b);
    }
    paramegg.jdField_a_of_type_JavaLangString = paramRecommendTroopInfo.uin;
    Bitmap localBitmap = a(4, paramRecommendTroopInfo.uin);
    paramegg.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    paramegg.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecommendTroopInfo.name);
    if ((paramRecommendTroopInfo.flagExt & 0x800) != 0) {
      if (paramRecommendTroopInfo.authType == 2)
      {
        paramegg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramegg.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838181);
      }
    }
    for (;;)
    {
      b(paramInt, paramRecommendTroopInfo, paramegg);
      if (((FriendManager)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramRecommendTroopInfo.uin) == null) {
        break;
      }
      paramegg.d.setVisibility(8);
      paramegg.jdField_c_of_type_AndroidWidgetTextView.setText(2131561611);
      paramegg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      if (paramRecommendTroopInfo.authType == 1)
      {
        paramegg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramegg.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838357);
      }
      else
      {
        paramegg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        paramegg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    paramegg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramegg.d.setText(2131560762);
    paramegg.d.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView);
    paramegg.d.setVisibility(0);
  }
  
  private void b(int paramInt, RecommendTroopInfo paramRecommendTroopInfo, egg paramegg)
  {
    String str = "";
    if (this.b.containsKey(paramRecommendTroopInfo.uin)) {
      str = (String)this.b.get(paramRecommendTroopInfo.uin);
    }
    paramegg.b.setText(a(paramRecommendTroopInfo.curMemberNum, paramRecommendTroopInfo.isSameCity, paramRecommendTroopInfo.location, str));
  }
  
  public RecommendTroopMsg a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount()) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    return (RecommendTroopMsg)this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  protected Object a(int paramInt)
  {
    RecommendTroopMsg localRecommendTroopMsg = a(paramInt);
    if (localRecommendTroopMsg.isTroop())
    {
      FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
      localFaceInfo.jdField_a_of_type_Int = 4;
      localFaceInfo.jdField_a_of_type_JavaLangString = localRecommendTroopMsg.troop.uin;
      return localFaceInfo;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if (!this.b.containsKey(paramString1))
    {
      this.b.put(paramString1, paramString2);
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
      {
        paramString1 = (TextView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
        if (paramString1 != null)
        {
          localObject = paramString1.getTag();
          if (localObject == null) {
            break label82;
          }
        }
      }
    }
    label82:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      paramString1.setText(a(i, false, "", paramString2));
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView.a().getLayoutInflater().inflate(2130903398, paramViewGroup, false);
      paramViewGroup = new egg(null);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232315));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231398));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232317));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232319));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131232455));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232456));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131232313));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131232457));
      paramView.setTag(paramViewGroup);
    }
    RecommendTroopMsg localRecommendTroopMsg;
    for (;;)
    {
      localRecommendTroopMsg = a(paramInt);
      if (localRecommendTroopMsg != null) {
        break;
      }
      return paramView;
      paramViewGroup = (egg)paramView.getTag();
    }
    paramView.setOnClickListener(new egf(this, localRecommendTroopMsg));
    if (localRecommendTroopMsg.isRead)
    {
      paramView.setBackgroundResource(2130837850);
      paramViewGroup.d.setTag(localRecommendTroopMsg);
      if (!localRecommendTroopMsg.isTroop()) {
        break label316;
      }
      a(paramInt, localRecommendTroopMsg.troop, paramViewGroup);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != paramInt) {
        break label338;
      }
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.b();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter.setMotionView(paramView, paramInt);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopRecommendTroopView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramInt));
      return paramView;
      paramView.setBackgroundResource(2130837851);
      break;
      label316:
      if (localRecommendTroopMsg.isBusiness()) {
        a(paramInt, localRecommendTroopMsg.rtbItem, paramViewGroup);
      }
    }
    label338:
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.c();
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ege
 * JD-Core Version:    0.7.0.1
 */