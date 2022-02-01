package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonPanel
  extends SystemEmoticonPanel
{
  public SystemAndEmojiEmoticonPanel(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    super(paramContext, paramEmoticonCallback);
  }
  
  protected void a(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131231633));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager = ((EmoticonViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131231632));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new ClassicEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 9));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.getCount(), true);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonViewPager.setCurrentItem(9);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131231650));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */