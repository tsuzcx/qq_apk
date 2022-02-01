package com.tencent.mobileqq.profile.view;

import algr;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import anot;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.widget.CirclePageIndicator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileLabelPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  protected TextView Xo;
  protected TextView Xp;
  protected a a;
  protected ProfileLabelPanelAdapter a;
  protected CirclePageIndicator c;
  protected View root;
  protected List<ProfileLabelTypeInfo> typeList;
  protected ViewPager viewPager;
  
  public ProfileLabelPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileLabelPanel(Context paramContext, a parama, List<ProfileLabelTypeInfo> paramList, algr paramalgr)
  {
    this(paramContext);
    this.root = LayoutInflater.from(paramContext).inflate(2131562222, this);
    this.typeList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a = parama;
    a(paramContext, paramalgr);
  }
  
  protected void a(Context paramContext, algr paramalgr)
  {
    this.Xp = ((TextView)this.root.findViewById(2131379182));
    this.Xo = ((TextView)this.root.findViewById(2131379186));
    this.Xp.setText(((ProfileLabelTypeInfo)this.typeList.get(0)).typeInfo);
    this.Xo.setText(((ProfileLabelTypeInfo)this.typeList.get(0)).typeName);
    this.c = ((CirclePageIndicator)this.root.findViewById(2131372816));
    this.viewPager = ((ViewPager)this.root.findViewById(2131381896));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter = new ProfileLabelPanelAdapter(paramContext, this.typeList);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.a(paramalgr);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$a);
    this.viewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanelAdapter);
    this.viewPager.setCurrentItem(0);
    this.c.setViewPager(this.viewPager);
    this.c.setOnPageChangeListener(this);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    anot.a(null, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "3", "", "", "");
    ProfileLabelTypeInfo localProfileLabelTypeInfo = (ProfileLabelTypeInfo)this.typeList.get(paramInt);
    this.Xp.setText(localProfileLabelTypeInfo.typeInfo);
    this.Xo.setText(localProfileLabelTypeInfo.typeName);
  }
  
  public static class a
  {
    private Map<ProfileLabelInfo, ToggleButton> mv = new HashMap();
    
    public ToggleButton a(ProfileLabelInfo paramProfileLabelInfo)
    {
      return (ToggleButton)this.mv.get(paramProfileLabelInfo);
    }
    
    public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
    {
      if (!a(paramProfileLabelInfo)) {
        this.mv.put(paramProfileLabelInfo, paramToggleButton);
      }
    }
    
    public boolean a(ProfileLabelInfo paramProfileLabelInfo)
    {
      return this.mv.get(paramProfileLabelInfo) != null;
    }
    
    public Map<ProfileLabelInfo, ToggleButton> ar()
    {
      return this.mv;
    }
    
    public void b(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
    {
      if (a(paramProfileLabelInfo)) {
        this.mv.remove(paramProfileLabelInfo);
      }
    }
    
    public void c(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton)
    {
      if (paramProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_NORMAL) {
        a(paramProfileLabelInfo, paramToggleButton);
      }
      for (;;)
      {
        paramProfileLabelInfo.toggleStatus();
        paramToggleButton.toggle();
        return;
        if (paramProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
          b(paramProfileLabelInfo, paramToggleButton);
        }
      }
    }
    
    public void destroy()
    {
      this.mv.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanel
 * JD-Core Version:    0.7.0.1
 */