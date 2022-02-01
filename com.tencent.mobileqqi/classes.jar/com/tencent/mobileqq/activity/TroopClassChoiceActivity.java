package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import dow;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  public GroupCatalogBean a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dow jdField_a_of_type_Dow;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  
  private void d()
  {
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(this).a();
    if ((localGroupCatalogBean != null) && (this.jdField_a_of_type_JavaLangString.equals(localGroupCatalogBean.b)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = localGroupCatalogBean;
      localObject = ((Intent)localObject).getStringExtra("id");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label94;
      }
      this.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this).a();
    }
    label94:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = GroupCatalogTool.a(this).a(this, this.jdField_a_of_type_JavaLangString);
        break;
        this.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this).a((String)localObject);
      } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0));
      localObject = (GroupCatalogBean)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    } while (((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean == null);
    setTitle(((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_JavaLangString);
  }
  
  private void e()
  {
    j(2130837729);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131234599));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Dow = new dow(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Dow);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (GroupCatalogBean)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((paramAdapterView.jdField_a_of_type_JavaUtilArrayList != null) && (paramAdapterView.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.b);
      paramView.putExtra("troopGroupClassExt", this.jdField_a_of_type_JavaLangString);
      startActivityForResult(paramView, 11);
      return;
    }
    GroupCatalogTool.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.b);
    setResult(-1, paramView);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904024);
    setTitle(2131561780);
    d();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */