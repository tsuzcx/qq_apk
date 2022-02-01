import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class wlh
  extends ReportDialog
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  MyVideoVisiblePersonPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView;
  MyVideoVisibleTroopPageView jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView;
  LeftTabBarView jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  String jdField_a_of_type_JavaLangString;
  vwo jdField_a_of_type_Vwo;
  boolean jdField_a_of_type_Boolean;
  
  public wlh(@NonNull Context paramContext, String paramString, int paramInt, vwo paramvwo, boolean paramBoolean)
  {
    super(paramContext, 16973841);
    super.requestWindowFeature(1);
    super.setContentView(LayoutInflater.from(paramContext).inflate(2131561796, null));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = wkp.a();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Vwo = paramvwo;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)wkp.a().getManager(52));
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void a()
  {
    ((ElasticImageView)findViewById(2131364630)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131380800));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView = ((LeftTabBarView)findViewById(2131378110));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setUnselectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setBackgroundDrawable(null);
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if ((this.jdField_a_of_type_Vwo != null) && (this.jdField_a_of_type_Boolean))
    {
      if ((this.jdField_a_of_type_Vwo.a != null) && (!this.jdField_a_of_type_Vwo.a.isEmpty()))
      {
        ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_Vwo.a.size());
        Iterator localIterator = this.jdField_a_of_type_Vwo.a.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b((String)localObject);
          if (localObject != null) {
            localArrayList2.add(localObject);
          }
        }
        Collections.sort(localArrayList2, ampx.a);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView = new MyVideoVisibleTroopPageView(this, this.jdField_a_of_type_AndroidContentContext, localArrayList2, this.jdField_a_of_type_ComTencentMobileqqAppTroopManager);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView.a());
        localArrayList1.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView.a());
        localArrayList1.add(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisibleTroopPageView);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectedTab(0, false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setOnTabChangeListener(new wli(this));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new wlk(this, localArrayList1));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new wlj(this));
      if (this.jdField_a_of_type_Int != 2) {
        break label438;
      }
      i = 1;
    }
    for (;;)
    {
      xwa.a("pub_control", "exp_list", 0, 0, new String[] { String.valueOf(i), "", "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView = new MyVideoVisiblePersonPageView(this, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      break;
      label438:
      if (this.jdField_a_of_type_Int == 3) {
        i = 2;
      } else if (this.jdField_a_of_type_Int == 1) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoMyVideoVisiblePersonPageView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getWindow();
    paramBundle.setGravity(80);
    paramBundle.setWindowAnimations(2131755168);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlh
 * JD-Core Version:    0.7.0.1
 */